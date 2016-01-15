import java.lang.*;
import java.util.HashMap;
import java.time.LocalDate;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("contacts", Contact.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("index/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/contacts-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String firstName = request.queryParams("firstName");
      String lastName = request.queryParams("lastName");
      Contact contact = new Contact(firstName, lastName);
      // model.put("contact", contact);
      model.put("contacts", Contact.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/index/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Contact contact = Contact.find(Integer.parseInt(request.params(":id")));
      model.put("contact", contact);
      model.put("template", "templates/contact.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/index/:id/addbirth", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Contact contact = Contact.find(Integer.parseInt(request.params(":id")));
      model.put("contact", contact);
      model.put("template", "templates/addbirth.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/index/:id/addphone", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Contact contact = Contact.find(Integer.parseInt(request.params(":id")));
      model.put("contact", contact);
      model.put("template", "templates/addphone.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/index/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
        Contact contact = Contact.find(Integer.parseInt(request.params(":id")));
        //birthday
        if (request.queryParams("phoneType") == null) {
          Integer birthMonth = Integer.parseInt(request.queryParams("birthMonth"));
          Integer birthDay = Integer.parseInt(request.queryParams("birthDay"));
          Integer birthYear = Integer.parseInt(request.queryParams("birthYear"));
          LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
          contact.addBirthDate(birthDate);
        }
        //phone
        if (request.queryParams("birthMonth") == null) {
          String phoneType = request.queryParams("phoneType");
          Integer phoneAc = Integer.parseInt(request.queryParams("phoneAc"));
          Integer phoneNumber = Integer.parseInt(request.queryParams("phoneNumber"));
          Phone phone = new Phone(phoneType, phoneAc, phoneNumber);
          contact.addPhone(phone);
        }

        model.put("contacts", Contact.all());
        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
  }


}
