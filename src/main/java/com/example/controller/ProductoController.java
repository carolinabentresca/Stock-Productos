package com.example.controller;

import com.example.model.Producto;
import com.example.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductoController {

    @Autowired
    ProductoService service;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("list", service.list());
        return "index";
    }

    @RequestMapping("/showProducto")
    public String show(Model model) {
        Producto producto = new Producto();
        model.addAttribute("producto", producto);
        return "save";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("producto") Producto producto) {
        service.save(producto);
        return "redirect:/";
    }

    @RequestMapping(value = "/showProducto/{id}")
    public String edit(@PathVariable(value = "id") int id, Model model) {
        Producto producto = service.get(id);
        model.addAttribute("producto", producto);
        return "edit";
    }

    @RequestMapping(value = "/destacado/{id}")
    public String destacado(@PathVariable(value = "id") int id, Model model) {
        Producto producto = service.get(id);
        model.addAttribute("producto", producto);
        return "destacado";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value = "id") int id) {
        this.service.delete(id);
        return "redirect:/";
    }

}
