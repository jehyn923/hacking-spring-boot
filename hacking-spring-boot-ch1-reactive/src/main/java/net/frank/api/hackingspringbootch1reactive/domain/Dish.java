package net.frank.api.hackingspringbootch1reactive.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    private String description;
    private boolean delivered = false;

    public static Dish deliver (Dish dish){
        Dish deliveredDish = new Dish(dish.description);
        deliveredDish.delivered = true;
        return deliveredDish;
    }
    // 원 예제에선 default 사용하지만, domain, controller, service package 구분때문에 public 선언 추후 수정
    public Dish(String description){
        this.description = description;
    }
    public boolean isDelivered(){
        return delivered;
    }

}
