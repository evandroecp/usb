package com.ubs.teste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ubs.teste.entity.Data;

@Repository
public interface DataRepository extends JpaRepository<Data, Long> { 

	@Query(value = "SELECT product, " + 
	   		"	   quantity,  " +            
	   		"	   price,  " +  
	   		"	   type,  " +   
	   		"	   industry,  " +
	   		"	   origin from Data d " +
	   		"      where product =:product " +
	   		"      and quantity =:quantity " +
	   		"      and price =:price " +
	   		"      and type =:type " +
	   		"      and industry =:industry " +
  	        "      and origin =:origin ")
	Data getPesquisaData(@Param("product") String product, 
		                 @Param("quantity") int quantity, 
		                 @Param("price") String price, 
		                 @Param("type") String type,
		                 @Param("industry") String industry, 
		                 @Param("origin") String origin);
	
	List<Data> findAll();
		
	@Query(value = "SELECT id, product, " + 
	   		"	   quantity,  " +            
	   		"	   REPLACE(price, '$', '') as price, industry, origin, type  " +  
	   		"	   from data d " +
	   		"      where product =:product ", nativeQuery = true)
	List<Data> getPesquisaCalculo(@Param("product") String product);
	
}
