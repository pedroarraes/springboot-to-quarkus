package com.englishcentral.crud.repository;

import com.englishcentral.crud.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by christophergumera on 16/08/2018.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
