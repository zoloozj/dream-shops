package mn.dailycodework.dreamshops.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mn.dailycodework.dreamshops.core.BaseEntity;
import mn.dailycodework.dreamshops.enums.OrderStatus;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    private LocalDate orderDate;
    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
