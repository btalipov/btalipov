package kz.bitlab.btalipov.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Long id;
    private String name;
    private double price;
    private int amount;
}
