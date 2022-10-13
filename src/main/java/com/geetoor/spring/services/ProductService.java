package com.geetoor.spring.services;

import com.geetoor.spring.model.entity.Product;
import com.geetoor.spring.model.entity.Supplier;
import com.geetoor.spring.model.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private SupplierService supplierService;

    public Product save(Product product){
        return productRepo.save(product);
    }

    public Product findOne(Long id){
        Optional<Product> product = productRepo.findById(id);
        if (!product.isPresent()){
            return null;
        }else {
            return productRepo.findById(id).get();
        }
    }

    public Iterable<Product> findAll(){
        return productRepo.findAll();
    }

    public void removeOne(Long id){
        productRepo.deleteById(id);
    }

    public void addSupplier(Supplier supplier, Long productId){
        Product product = findOne(productId);
        if (product == null){
            throw new RuntimeException("Product with id : " + productId + "not found");
        }
        product.getSuppliers().add(supplier);
        save(product);
    }

    public Product findByProductName(String name){
        return productRepo.findProductByName(name);
    }

    public List<Product> findByProductNameLike(String name){
        return productRepo.findProductByNameLike("%" + name + "%");
    }

    public List<Product> findByProductCategory(Long categoryId){
        return productRepo.findProductByCategory(categoryId);
    }

    public List<Product> findSupplier(Long supplierId){
        Supplier supplier = supplierService.findOne(supplierId);
        if (supplier == null){
            return new ArrayList<>();
        }
        return productRepo.findProductBySupplier(supplier);
    }
}
