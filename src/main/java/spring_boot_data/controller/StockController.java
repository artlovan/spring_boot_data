package spring_boot_data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring_boot_data.model.Stock;


@RestController
public class StockController {

    @Autowired
    private MongoTemplate template;

    @RequestMapping("/stocks")
    public Stock getAllStock() {
        Stock stock = new Stock();
        stock.setCompanyName("Tesla");
        stock.setSymbol("TLSA");
        stock.setCeo("Danny");
        stock.setPrice("250.000");

        template.insert(stock, "stock");

        return template.findOne(new BasicQuery("{symbol: 'TLSA'}"), Stock.class);
    }
}
