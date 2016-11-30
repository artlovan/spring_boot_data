package spring_boot_data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring_boot_data.model.Stock;
import spring_boot_data.repository.StockRepository;


@RestController
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    @RequestMapping("/stocks/{symbol}")
    public Stock getStock(@PathVariable("symbol") String symbol) {
        return stockRepository.findBySymbol(symbol);
    }
}
