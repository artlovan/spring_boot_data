package spring_boot_data.controller;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StockController {

    @Autowired
    private MongoDbFactory mongo;

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
