package pl.wszib.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.wszib.domain.Person;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SimpleController {

    @GetMapping("basic")
    public String basic(Model model){
        String firstName = "Jan";
        String lastName = "Kowąlski";
        model.addAttribute("fName", firstName);
        model.addAttribute("lName", lastName);

        Person person = new Person();
        person.setFirstName("Jacek");
        person.setLastName("Nowak");
        person.setPhoneNumber("123456789");
        person.setSalary(1000.15498);
        person.setVisible(true);

        model.addAttribute("person", person);


        return "basicTemplate";
    }

    @GetMapping("iteration")
    public String iteration(Model model){
        List<Person> list = generateList();
        model.addAttribute("list", list);
        return "iterationTemplate";
    }

    private List<Person> generateList(){
        List<Person> list = new ArrayList<>();

        Person person1 = new Person();
        person1.setFirstName("Marek");
        person1.setLastName("Dar");
        person1.setPhoneNumber("523690543");
        person1.setSalary(65657.78598);
        person1.setVisible(true);
        list.add(person1);

        Person person2 = new Person();
        person2.setFirstName("Mustafa");
        person2.setLastName("Akka");
        person2.setPhoneNumber("96798679");
        person2.setSalary(3252.754498);
        person2.setVisible(true);
        list.add(person2);

        Person person3 = new Person();
        person3.setFirstName("Darek");
        person3.setLastName("Zak");
        person3.setPhoneNumber("97956789");
        person3.setSalary(1320.15498);
        person3.setVisible(true);
        list.add(person3);

        return list;
    }

}
