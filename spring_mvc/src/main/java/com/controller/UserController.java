package com.controller;

import com.domain.User;
import com.domain.VO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cglib.core.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class UserController{

    @RequestMapping(value = "/quick", method = RequestMethod.GET, params = {"username"})
    public String save() {
        System.out.println("Controller save running....");
        return "success.jsp";
    }

    @RequestMapping(value = "/quick2")
    public ModelAndView save2() {
        /*
            Model:模型 作用封装数据
            View: 视图 作用展示数据
         */
        ModelAndView modelAndView = new ModelAndView();
        // 设置模型数据,相当于将数据存到request域中
        modelAndView.addObject("username", "张三");

        // 设置视图名称
        modelAndView.setViewName("success");            // 同样适用于内部资源视图解析器
        return modelAndView;
    }

    @RequestMapping(value = "/quick3")
    public void save3(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello");

    }

    @RequestMapping(value = "/quick4")
    @ResponseBody               // 告知SpringMVC框架,不进行视图跳转,直接进行数据响应
    public String save4() {
        return "页面跳转";

    }

    @RequestMapping(value = "/quick5")
    @ResponseBody
    public String save5() {
        // 引号需要转义
        return "{\"username\":\"zhangsan\",\"age\":18}";

    }

    @RequestMapping(value = "/quick6")
    @ResponseBody
    public String save6() throws JsonProcessingException {
        User user = new User("zhangsan", 18);

        // 使用json的转换工具将对象转换成json格式字符串再返回
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(user);

        // 引号需要转义
        return s;

    }

    @RequestMapping(value = "/quick7")
    @ResponseBody
    public User save7() {
        User user = new User("lisi", 24);


        return user;

    }

    @RequestMapping(value = "/quick8")
    @ResponseBody
    // http://localhost:8080/quick8?username=zhangsan&age=18
    public User save8(String username, int age) {
        User user = new User(username, age);
        System.out.println(username);
        System.out.println(age);
        return user;

    }

    @RequestMapping(value = "/quick9")
    @ResponseBody
    // http://localhost:8080/quick9?name=zhangsan&age=18
    public User save9(User user) {
        System.out.println(user.getName());
        System.out.println(user.getAge());
        return user;

    }

    @RequestMapping(value = "/quick10")
    @ResponseBody
    // http://localhost:8080/quick10?aihao=sanshang&aihao=boduo&aihao=cang
    public void save10(String[] aihao) {
        System.out.println(Arrays.asList(aihao));
        System.out.println(Arrays.toString(aihao));


    }

    @RequestMapping(value = "/quick11")
    @ResponseBody
    public void save11(VO vo) {
        List<User> userList = vo.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

    }

    @RequestMapping(value = "/quick12")
    @ResponseBody
    public void save12(@RequestBody List<User> userList) {

        for (User user : userList) {
            System.out.println(user);
        }

    }

    @RequestMapping(value = "/quick13")
    @ResponseBody
    public void save13(@RequestParam(value = "username",required = false,defaultValue = "zhangsan") String name) {

        System.out.println(name);

    }

    @RequestMapping(value = "/quick14/{username}")
    @ResponseBody
    // http://localhost:8080/quick14/zhangsan
    public void save14(@PathVariable(value = "username") String name) {

        System.out.println(name);       // zhangsan

    }

    @RequestMapping(value = "/quick15")
    @ResponseBody
    public void save15(Date date) {

        System.out.println(date);

    }

    @RequestMapping(value = "/quick16")
    @ResponseBody
    public void save16(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);

    }

    @RequestMapping(value = "/quick17")
    @ResponseBody
    public void save17(@RequestHeader(value = "User-Agent",required = false)String user_agent) {
        System.out.println(user_agent);
    }

    @RequestMapping(value = "/quick18")
    @ResponseBody
    public void save18(String name, MultipartFile upload) throws IOException {
        System.out.println(name);
        // 获得上传文件的名称
        String originalFilename = upload.getOriginalFilename();
        upload.transferTo(new File("D:\\"+originalFilename));

    }

    @RequestMapping(value = "/quick19")
    @ResponseBody
    public void save19(String name, MultipartFile[] upload) throws IOException {
        System.out.println(name);
        for (MultipartFile multipartFile : upload) {

            // 获得上传文件的名称
            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("D:\\"+originalFilename));
        }

    }




}
