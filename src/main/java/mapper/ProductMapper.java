package mapper;

import model.*;
import org.springframework.stereotype.Component;

import java.util.List;
//
@Component
public interface ProductMapper {

    ProductBase toProductBase(Product product);
    ProductDetail toProductDetail(Product product);

    List<ProductBase> toProductBase(List<Product> product);

    Product toProduct(CreateProduct request);

    void updateProduct(UpdateProduct request, Product product);
}
