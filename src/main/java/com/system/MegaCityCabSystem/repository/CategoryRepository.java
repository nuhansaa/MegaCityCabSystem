package com.system.MegaCityCabSystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.system.MegaCityCabSystem.model.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String>{
   

}
