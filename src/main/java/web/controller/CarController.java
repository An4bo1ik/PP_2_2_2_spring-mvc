package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImpl;

import java.util.Objects;

@Controller
public class CarController {
    private CarServiceImpl carServiceImpl;

    @Autowired
    public void setCarServiceImpl(CarServiceImpl carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        model.addAttribute("cars", carServiceImpl
                .getCars(Objects.requireNonNullElse(count, 5)));
        return "cars";
    }
}
