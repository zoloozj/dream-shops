package mn.dailycodework.dreamshops.service.product;

import java.util.List;

import mn.dailycodework.dreamshops.model.Product;
import mn.dailycodework.dreamshops.request.AddProductRequest;
import mn.dailycodework.dreamshops.request.ProductUpdateRequest;

public interface IProductService {
    Product addProduct(AddProductRequest product);

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByBrand(String brand);

    List<Product> getProductsByCategoryAndBrand(String category, String brand);

    List<Product> getProductsByName(String name);

    List<Product> getProductsByBrandAndName(String brand, String name);

    Long countProductsByBrandAndName(String brand, String name);

    Product getProductById(Long id);

    void deleteProduct(Long id);

    Product updateProduct(ProductUpdateRequest product, Long productId);
}
