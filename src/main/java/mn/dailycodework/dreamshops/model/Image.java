package mn.dailycodework.dreamshops.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mn.dailycodework.dreamshops.core.BaseEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Image extends BaseEntity {
    private String fileName;
    private String fileType;

    @Lob
    private byte[] image;
    private String downloadUrl;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
