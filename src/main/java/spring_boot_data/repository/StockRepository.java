package spring_boot_data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import spring_boot_data.model.Stock;


@Repository
public interface StockRepository extends MongoRepository<Stock, Integer> {
    Stock findBySymbol(String symbol);
}
