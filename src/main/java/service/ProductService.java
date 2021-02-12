package service;

import mapper.ProductMapper;
import model.CreateProduct;
import model.Product;
import model.UpdateProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import repositories.ProductRepository;
import javax.persistence.EntityNotFoundException;
//
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Page<Product> getAll(Pageable page) {
        return productRepository.findAll(page);
    }

    public Product get(int id) {
        return productRepository.findById((long) id).orElseThrow(EntityNotFoundException::new);
    }

    public Product create(CreateProduct request) {
        return productRepository.save(productMapper.toProduct(request));
    }

    public Product update(int id, UpdateProduct request) {
        Product product = productRepository.findById((long) id).orElseThrow(EntityNotFoundException::new);
        productMapper.updateProduct(request, product);
        return productRepository.save(product);
    }

    public void delete(int id) {
        productRepository.delete(productRepository.findById((long) id).orElseThrow(EntityNotFoundException::new));
    }
}

