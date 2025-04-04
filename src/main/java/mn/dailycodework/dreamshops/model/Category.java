package mn.dailycodework.dreamshops.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mn.dailycodework.dreamshops.core.BaseEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category extends BaseEntity {
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
