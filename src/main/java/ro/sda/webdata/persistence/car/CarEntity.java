package ro.sda.webdata.persistence.car;

import javax.persistence.*;

@Entity
@Table(name ="car")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "horse_power")
    private int hp;

    @Column(name = "color")
    private String color;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
