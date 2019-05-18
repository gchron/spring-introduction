package pl.dominisz.springintroduction.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<OrderItem> orderItemList;
    private BigDecimal amount;

    public Order() {
        orderItemList = new ArrayList<>();
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void addItem(OrderItem orderItem) {
        orderItemList.add(orderItem);
    }

    public BigDecimal getAmount() {
        BigDecimal sum = BigDecimal.ZERO;
        for (OrderItem item : orderItemList) {
            sum = sum.add(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
        }
        return sum;
    }
}
