package spring_boot_data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring_boot_data.model.Stock;
import spring_boot_data.repository.StockRepository;

import java.util.List;


@RestController
public class StockController {

    @Autowired
    private StockRepository repository;

    @RequestMapping("/stocks/create")
    public Stock getStock() {
        Stock stock = new Stock();
        stock.setStockId(repository.findAll().size());
        stock.setCompanyName("Tesla");
        stock.setSymbol("TLSA");
        stock.setCeo("Danny");
        stock.setPrice("250.000");

        repository.save(stock);

        return repository.findBySymbol("TLSA");
    }

    @RequestMapping("/stocks")
    public List<?> getAllStocks() {
        return repository.findAll();
    }
}
