package mn.dailycodework.dreamshops.request;

import java.math.BigDecimal;

import lombok.Data;
import mn.dailycodework.dreamshops.model.Category;

@Data
public class AddProductRequest {
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private String description;
    private Category category;
}
