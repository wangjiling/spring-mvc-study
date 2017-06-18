package com.springapp.mvc.controller;

import com.springapp.mvc.common.FieldConfig;
import com.springapp.mvc.entity.User;
import com.springapp.mvc.exception.CustomException;
import com.springapp.mvc.service.UserService;
import com.springapp.mvc.util.PageConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * UserService: vincent
 * Date: 14-1-26
 * Time: 下午4:02
 * To change this template use File | Settings | File Templates.
 */
@RequestMapping("user")
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(){
        return "register";

    }

    @Transactional
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute User user, Model model) throws CustomException, IOException {

        userService.save(user);

        return "redirect:/login";

    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public String loginProcess(@ModelAttribute User user, Model model) throws CustomException, IOException {
        if(userService.auth(user)){
            return "redirect:list";
        }

        return "redirect:/login";
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable(value = "id") String id, Model model) throws CustomException{
        if(id == null || StringUtils.isEmpty(id)){
            throw new CustomException("error");
        }
        User user = userService.findById(id);
        if(user == null){
            throw new CustomException("error");
        }

        model.addAttribute("user", user);
        return "user/detail";
    }

    @RequestMapping(value = "/list")
    public String getList(
            User user, Model model,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) throws CustomException {
        PageConfig pager = new PageConfig();
        if(user != null){
            String name = user.getName();

            if(name != null && !StringUtils.isEmpty(name)){
                pager.addFieldConfig(new FieldConfig("name", PageConfig.FieldType.LIKE, name));
            }
        }

        pager.addOrder(new Sort.Order(Sort.Direction.ASC, "name"));
        pager.setCurPage(pageNum);
        pager.setPageCount(pageSize);

        Page<User> page = userService.getListByPage(pager);

        model.addAttribute("page", page);
        return "user/list";
    }

    @Transactional
    @RequestMapping(value = "/delete",  method = RequestMethod.GET)
    public String del(@RequestParam(value="id") String id) throws Exception{
        userService.delete(id);
        return "user/detail";
    }

    @RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
    public String modify(@PathVariable(value = "id") String id, Model model) throws CustomException{
        if(id == null || StringUtils.isEmpty(id)){
            throw new CustomException("error");
        }
        User user = userService.findById(id);
        if(user == null){
            throw new CustomException("error");
        }

        model.addAttribute("user", user);
        return "user/modify";
    }

    @Transactional
    @RequestMapping(value = "/modify",  method = RequestMethod.POST)
    public String update(@ModelAttribute("user") User user, Model model) throws CustomException {
        userService.update(user);
        model.addAttribute("user", user);
        return "user/detail";
    }

}
