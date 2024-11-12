package ra.bt1md5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.bt1md5.model.Product;
import ra.bt1md5.repository.IRepository;
import ra.bt1md5.service.IService;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IService iService;
    @Autowired
    private IRepository iRepository;

    @GetMapping
    public String productList(Model model, @RequestParam(value = "keyword", defaultValue = "") String name) {
        model.addAttribute("products", iRepository.getAllAndSearch(name));
        model.addAttribute("keyword", name);
        return "index";
    }

    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "addAndEditProduct";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) {
        iService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable Integer id, Model model) {
        model.addAttribute("product", iService.findById(id));
        return "addAndEditProduct";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        iService.deleteById(id);
        return "redirect:/products";
    }

}
