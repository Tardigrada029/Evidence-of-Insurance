package org.example.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String showProductList(Model model) {
        List<Product> listProducts = productService.listAllProducts();
        model.addAttribute("listProducts", listProducts);

        return "products";
    }

    @GetMapping("/products/new")
    public String showNewProductForm(Model model) {
        model.addAttribute("product", new Product());

        return "product_form";
    }

    @PostMapping("/products/save")
    public String saveNewProduct(Product product) {
        productService.save(product);

        return "redirect:/products";
    }

    @GetMapping("/products/edit/{productId}")
    public String editProductForm(@PathVariable("productId") Long productId, Model model) {
            Product product = productService.get(productId);
            model.addAttribute("product", product);

            return "product_edit_form";
    }

    @GetMapping("/products/delete/{productId}")
    public String deleteProductForm(@PathVariable("productId") Long productId) {
        productService.deleteProduct(productId);

        return "redirect:/products";
    }
}
