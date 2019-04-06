package pl.wszib.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wszib.domain.Person;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SimpleController {

    private List<Person> listPerson;

    public SimpleController() {
        listPerson = generateList();
    }

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
        ;
        model.addAttribute("list", listPerson);
        return "iterationTemplate";
    }

    @GetMapping("links")

    public String links(Model model){


        return "linksTemplate";
    }

    @GetMapping("inter")
    public String inter(Model model){
        return "interTemplate";
    }

    @GetMapping ("forms")
    public String forms(Model model){
        model.addAttribute("person", new Person());
        return "formsTemplate";
    }

    @PostMapping("formsSave")
    public String formsSave(Person person, Model model){
        listPerson.add(person);
        return "successTemplate";
    }

    private List<Person> generateList(){
        List<Person> list = new ArrayList<>();

        Person person1 = new Person();
        person1.setFirstName("Marek");
        person1.setLastName("Dar");
        person1.setPhoneNumber("52369043");
        person1.setSalary(6567.78598);
        person1.setVisible(false);
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
        person3.setLastName("Żak");
        person3.setPhoneNumber("97956789");
        person3.setSalary(9320.15498);
        person3.setVisible(true);
        list.add(person3);

        return list;
    }

    @GetMapping ("fragments")
    public String fragments (Model model){
        return "fragments/fragmentsTemplates";
    }

    @GetMapping ("fragmentsT")
    public String fragments2 (Model model) {
        return "fragments/fragmentsTemplatesT";
    }

}
