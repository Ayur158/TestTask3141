package test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class MainController {

    private final LordRepo lordRepo;
    private final PlanetRepo planetRepo;

    public MainController(LordRepo lordRepo, PlanetRepo planetRepo) {
        this.lordRepo = lordRepo;
        this.planetRepo = planetRepo;
    }

    @GetMapping("/everything")
    public String showAll (Model model) {
        Iterable<Planet> planets = planetRepo.findAll();
        Iterable<Lord> lords = lordRepo.findAll();
        model.addAttribute("planets",planets);
        model.addAttribute("lords",lords);
        return "/everything";
    }

    @PostMapping("/everythingL")
    public String addLord (Lord lord) {
        lordRepo.save(lord);
        return "redirect:/everything";
    }
    @PostMapping("/everythingP")
    public String addPlanet (Planet planet) {
        planetRepo.save(planet);
        lordRepo.save(planet.getLord());
        return "redirect:/everything";
    }
    @GetMapping("/{id}")
    public String setThings (@PathVariable long id, Model model) {
        model.addAttribute("planet", planetRepo.findById(id).get());
        return "/indexPlanet";
    }
    @PatchMapping("/{id}")
    public String editThings (@ModelAttribute("planet") Planet planet) {
        planetRepo.save(planet);
        return "redirect:/everything";
    }
    @DeleteMapping("/{id}")
    public String deleteThings (@PathVariable("id") long id) {
        planetRepo.deleteById(id);
        return "redirect:/everything";
    }
   @GetMapping("/everythingY")
    public String findYoung (Model model) {
        ArrayList<Lord> lords = (ArrayList<Lord>) lordRepo.findAllByOrderByAgeAsc();
        ArrayList<Lord> youngLords = new ArrayList<>();
        if (lords.size() < 10) return "redirect:/everything";
       for (int i = 0; i < 10; i++) {
           youngLords.add(lords.get(i));
       }
        model.addAttribute("lords", youngLords);
        return "/someLords";
    }

    @GetMapping("/everythingF")
    public String findFree (Model model) {
        Iterable<Lord> lords = lordRepo.findAllByPlanetSetNull();
        model.addAttribute("lords",lords);
        return "/someLords";
    }

}
