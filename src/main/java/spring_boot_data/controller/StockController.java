package spring_boot_data.controller;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring_boot_data.model.Stock;
//import spring_boot_data.repository.StockRepository;

import java.util.List;


@RestController
public class StockController {

    @Autowired
    private MongoDbFactory mongo;

//    @Autowired
//    private StockRepository stockRepository;
//
//    @RequestMapping("/stocks/{symbol}")
//    public Stock getStock(@PathVariable("symbol") String symbol) {
//        return stockRepository.findBySymbol(symbol);
//    }
//
//    @RequestMapping("/stocks/create")
//    public ResponseEntity getStock() {
//        Stock stock = new Stock();
//        stock.setCeo("Dan Spring");
//        stock.setCompanyName("Pivotal");
//        stock.setSymbol("SBP");
//        stock.setStockId(5);
//        stock.setPrice("14.99");
//
//        stockRepository.save(stock);
//
//        return new ResponseEntity(HttpStatus.CREATED);
//    }

    @RequestMapping("/stocks")
    public DBObject getAllStock() {
        DB db = mongo.getDb("sandbox");
        DBCollection collection = db.getCollection("stocks");

        collection.insert(
                new BasicDBObject()
                        .append("companyName", "Ford")
                        .append("symbol", "F")
        );

        return collection.findOne(new BasicDBObject().append("symbol", "F"));
    }
}
