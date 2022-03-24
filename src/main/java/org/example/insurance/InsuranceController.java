package org.example.insurance;

import java.util.List;
import org.example.product.Product;
import org.example.product.ProductService;
import org.example.user.User;
import org.example.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InsuranceController {
    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @GetMapping("/insurance/new")
    public String showNewInsuranceForm(Model model) {
        List<User> listUsers = userService.listAllUsers();
        List<Product> listProducts = productService.listAllProducts();
        model.addAttribute("insurance", new Insurance());
        model.addAttribute("listUsers", listUsers);
        model.addAttribute("listProducts", listProducts);

        return "insurance_form";
    }

    @PostMapping("insurance/save")
    public String saveNewInsurance(Insurance insurance) {
        insuranceService.save(insurance);

        return "redirect:/insurance";
    }

    @GetMapping("insurance")
    public String showInsuranceList(Model model) {
        List<Insurance> listInsurances = insuranceService.listAllInsurances();
        model.addAttribute("listInsurances", listInsurances);

        return "insurance";
    }

    @GetMapping("insurance/edit/{insuranceId}")
    public String editInsuranceForm(@PathVariable("insuranceId") Long insuranceId, Model model) {
        Insurance insurance = insuranceService.get(insuranceId);
        List<User> listUsers = userService.listAllUsers();
        List<Product> listProducts = productService.listAllProducts();
        model.addAttribute("listUsers", listUsers);
        model.addAttribute("listProducts", listProducts);
        model.addAttribute("insurance", insurance);

        return "insurance_edit_form";
    }

    @GetMapping("insurance/delete/{insuranceId}")
    public String deleteInsuranceForm(@PathVariable("insuranceId") Long insuranceId) {
        insuranceService.deleteInsurance(insuranceId);

        return "redirect:/users";
    }
}