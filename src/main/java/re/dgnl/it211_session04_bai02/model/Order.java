package re.dgnl.it211_session04_bai02.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String orderId;
    private String customerName;
    private String address;
    private String productId;
    private int quantity;
}