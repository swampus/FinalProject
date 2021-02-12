package controller;

import mapper.ProductMapper;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import service.ProductService;
import javax.validation.Valid;

    @RestController
    @RequestMapping("rest/api/Products.svc")
    public class ProductController {

        @Autowired
        private ProductService productService;

        @Autowired
        private ProductMapper productMapper;

        @GetMapping
        public CustomPage<ProductBase> getAll(@RequestParam(name = "page", defaultValue = "0") int page,
                                              @RequestParam(name = "size", defaultValue = "10") int size) {
            Page<Product> productPage = productService.getAll(PageRequest.of(page, size));
            return new CustomPage<>(productPage, productMapper.toProductBase(productPage.getContent()));
        }

        @GetMapping("/{id}")
        public ProductDetail get(@PathVariable("id") int id) {
            return productMapper.toProductDetail(productService.get(id));
        }

        @PostMapping("/products")
        public ProductDetail create(@RequestBody @Valid CreateProduct request) {
            return productMapper.toProductDetail(productService.create(request));
        }

        @PutMapping("/{id}")
        public ProductDetail update(@PathVariable("id") int id, @RequestBody @Valid UpdateProduct request) {
            return productMapper.toProductDetail(productService.update(id, request));
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable("id") int id) {
            productService.delete(id);
        }
    }


