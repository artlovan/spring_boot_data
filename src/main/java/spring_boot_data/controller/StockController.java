package spring_boot_data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
public class StockController {

    @Autowired
    private EntityManager entityManager;

    @RequestMapping(name = "/stocks")
    public List<?> getAllStucks() {
        return entityManager.createQuery("select s from Stock s").getResultList();
    }
}
