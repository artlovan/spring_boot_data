package spring_boot_data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_boot_data.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    Stock findBySymbol(String symbol);
}
