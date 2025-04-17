package mn.dailycodework.dreamshops.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mn.dailycodework.dreamshops.core.BaseEntity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Category extends BaseEntity {
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category(String name) {
        this.name = name;
    }

}
