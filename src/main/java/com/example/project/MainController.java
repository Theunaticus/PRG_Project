package com.example.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/command") // This means URL's start with /command (after Application path)
public class MainController {

  public  static MainController current;
  public  MainController  ()  {
    current = this;
  }

  @Autowired
  private RegisterRepository registerRepository;
  @Autowired
  private StudentRepository studentRepository;
  @Autowired
  private AdministratorRepository adminRepository;

  @PostMapping(path = "/addregister") // Map ONLY POST Requests
  public @ResponseBody String addNewRegister(@RequestParam String name, @RequestParam String address,
      @RequestParam String email, @RequestParam String password, @RequestParam String course_name) {

    Register n = new Register();
    n.SetName(name);
    n.SetAddress(address);
    n.SetEmail(email);
    n.SetPassword(password);
    n.SetCourse(course_name);
    registerRepository.save(n);
    return "Saved";
  }

  @PostMapping(path = "/addstudent") // Map ONLY POST Requests
  public @ResponseBody String addNewStudent(@RequestParam String name, @RequestParam String address,
      @RequestParam String email, @RequestParam String password) {

    Student n = new Student();
    n.SetName(name);
    n.SetAddress(address);
    n.SetEmail(email);
    n.SetPassword(password);
    studentRepository.save(n);
    return "Saved";
  }

  @PostMapping(path = "/addadmin") // Map ONLY POST Requests
  public @ResponseBody
   String addNewAdmin(@RequestParam String name, @RequestParam String password,
      @RequestParam String contact) {

    Administrator n = new Administrator();
    n.SetName(name);
    n.SetContact(contact);
    n.SetPassword(password);
    adminRepository.save(n);
    return "Saved";
  }

  @GetMapping(path = "/allstudent")
  public @ResponseBody Iterable<Student> getAllStudents() {
    // This returns a JSON or XML with the students
    return studentRepository.findAll();
  }

  @GetMapping(path = "/allregister")
  public @ResponseBody Iterable<Register> getAllRegisters() {
    // This returns a JSON or XML with the registers
    return registerRepository.findAll();
  }

  @GetMapping(path = "/alladmins")
  public @ResponseBody
   Iterable<Administrator> getAllAdmins() {
    // This returns a JSON or XML with the admins
    try {
      return adminRepository.findAll();
    } catch (Exception e) {
      addNewAdmin("admin", "admin", "admin");
      return adminRepository.findAll();
    } 
  }

  public void DeleteAdmin ()  {
    adminRepository.deleteAll();
  }
}