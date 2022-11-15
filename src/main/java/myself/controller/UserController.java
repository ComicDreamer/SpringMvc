package myself.controller;

import myself.pojo.User;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.PublicKey;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
//所有类中的请求路径都加上 /user
public class UserController {

    @RequestMapping("/save")
//    设置请求路径
    @ResponseBody
//    标记这是响应体
    public String save(){
        System.out.println("user save...");
        return "{'info':'springmvc'}";
    }

    @RequestMapping("/see")
    @ResponseBody
    public String see(String name, int age){
        System.out.println(name);
        System.out.println(age);
        return "name是" + name + "\n" + "age是" + age;
    }

//    普通参数:请求参数名与形参名不同 使用注解@RequestParam
    @RequestMapping("/commonParamDifferentName")
    @ResponseBody
    public String commonParamDifferentName(@RequestParam("name") String userName, int age) {
        System.out.println(userName);
        System.out.println(age);
        return "{'module' : 'common param different name'}";
    }

//    将传入的参数封装进数组 参数名要都相同才行
    @RequestMapping("/arrayParam")
    @ResponseBody
    public String arrayParam(String[] likes) {
        System.out.println(likes.length);
        System.out.println(Arrays.toString(likes));
        return "{'module' : 'array param'}";
    }

//    将传入的参数自动封装进入实体类，实体类可以嵌套，只要传入的参数注意嵌套，本质是调用init方法然后设置参数，所以接口类不适应
    @RequestMapping("/pojoParam")
    @ResponseBody
    public String pojoParam(User user){
        System.out.println(user);
        return "{'module' : 'pojo param'}";
    }

//    将传入的参数封装进入list集合，注意！！不可以自动封装进，因为list是接口，所以需要用@RequestParam注解
    @RequestMapping("/listParam")
    @ResponseBody
    public String listParam(@RequestParam List<String> likes) {
        System.out.println(likes);
        return "{'module' : ' list param'}";
    }

//    使用@请求体来将外部传递的json数组数据映射到集合对象中
    @RequestMapping("/listParamForJson")
    @ResponseBody
    public String listParamForJson(@RequestBody List<String> likes) {
        System.out.println(likes);
        return "{'module' : 'list common for json param'}";
    }

    @RequestMapping("/dataParam")
    @ResponseBody
//    设置日期数据格式
    public String dataParam(Date date1,
                            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date2){
        System.out.println(date1);
        System.out.println(date2);
        return "{'module' : 'data param'}";
    }

//    返回页面的时候不需要加响应体
    @RequestMapping("/toJumpPage")
    public String toJumpPage(){
        System.out.println("跳转页面");
//        返回jsp文件的时候不能在类前面加@RequestMapping
        return "index.jsp";
    }

//    返回json数据 函数返回值要是pojo实体类 自动转换成json 这件事是json依赖导入的接口类做的
    @RequestMapping("/toJsonPojo")
    @ResponseBody
    public User toJspnPojo(){
        System.out.println("返回json对象数据");
        User user = new User();
        user.setName("zhangsan");
        user.setAge(18);
        return user;
    }
}
