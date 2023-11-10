package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final static List<Car> cars = new ArrayList<>();

    static {
        cars.add(new Car("Porsche", "911", "black"));
        cars.add(new Car("Ford", "Mustang", "Red"));
        cars.add(new Car("Dodge", "Ram", "white"));
        cars.add(new Car("Nissan", "GT-R", "silver"));
        cars.add(new Car("BMW", "I8", "blue"));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count > 4) {
            return cars;
        }
        return cars.subList(0, count);
    }
}
