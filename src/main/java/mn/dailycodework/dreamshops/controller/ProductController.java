package mn.dailycodework.dreamshops.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mn.dailycodework.dreamshops.exceptions.ResourceNotFoundException;
import mn.dailycodework.dreamshops.model.Product;
import mn.dailycodework.dreamshops.request.AddProductRequest;
import mn.dailycodework.dreamshops.request.ProductUpdateRequest;
import mn.dailycodework.dreamshops.response.ApiResponse;
import mn.dailycodework.dreamshops.service.product.IProductService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RequiredArgsConstructor
@RestController
@RequestMapping("product")
public class ProductController {

    private final IProductService productService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(new ApiResponse("Success", products));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable Long productId) {
        try {
            Product product = productService.getProductById(productId);
            return ResponseEntity.ok(new ApiResponse("Success", product));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createProduct(@RequestBody AddProductRequest product) {
        try {
            Product theProduct = productService.addProduct(product);
            return ResponseEntity.ok(new ApiResponse("Success", theProduct));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PutMapping("/{productId}/update")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable Long productId,
            @RequestBody ProductUpdateRequest request) {
        try {
            Product updatedProduct = productService.updateProduct(request, productId);
            return ResponseEntity.ok(new ApiResponse("Success", updatedProduct));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/{productId}/delete")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long productId) {
        try {
            productService.deleteProduct(productId);
            return ResponseEntity.ok(new ApiResponse("Success", productId));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), productId));
        }
    }

    @PostMapping("/getBy/brandAndName")
    public ResponseEntity<ApiResponse> getProductByBrandAndName(@RequestBody String bnand, String productName) {
        try {
            List<Product> products = productService.getProductsByBrandAndName(bnand,
                    productName);
            if (products.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No products found", null));
            }
            return ResponseEntity.ok(new ApiResponse("Success", products));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PostMapping("/getBy/brandAndCategory")
    public ResponseEntity<ApiResponse> getProductByBrandAndCategory(@RequestBody String bnand,
            String categoryName) {
        try {
            List<Product> products = productService.getProductsByCategoryAndBrand(categoryName, bnand);
            if (products.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No products found", null));
            }
            return ResponseEntity.ok(new ApiResponse("Success", products));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/{productName}/name")
    public ResponseEntity<ApiResponse> getProductsByName(@PathVariable String productName) {
        try {
            List<Product> products = productService.getProductsByName(productName);
            if (products.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No products found", null));
            }
            return ResponseEntity.ok(new ApiResponse("Success", products));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/by-category")
    public ResponseEntity<ApiResponse> getProductsByCategory(@RequestParam String category) {
        try {
            List<Product> products = productService.getProductsByCategory(category);
            if (products.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No products found", null));
            }
            return ResponseEntity.ok(new ApiResponse("Success", products));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/brand")
    public ResponseEntity<ApiResponse> getProductsByBrand(@RequestParam String brand) {
        try {
            List<Product> products = productService.getProductsByBrand(brand);
            if (products.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No products found", null));
            }
            return ResponseEntity.ok(new ApiResponse("Success", products));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PostMapping("/count/byBrandAndName")
    public ResponseEntity<ApiResponse> getProductCountByBrandAndName(@RequestBody String brand,
            String productName) {
        try {
            Long count = productService.countProductsByBrandAndName(brand,
                    productName);
            return ResponseEntity.ok(new ApiResponse("Success", count));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }
}
