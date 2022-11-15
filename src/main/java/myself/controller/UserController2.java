package myself.controller;

import myself.pojo.User;
import org.springframework.web.bind.annotation.*;

@RestController
//@Controller + ResponseBody
@RequestMapping("/users")
public class UserController2 {
    @PostMapping
    public String save(@RequestBody User user){
        System.out.println("user save");
        return "save";
    }
//@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) 原本状态
    @DeleteMapping("/{id}")
//    告诉url中id位置
    public String delete(@PathVariable Integer id){
//        从url中获取参数 适应于参数很少且简单的情况
        System.out.println("user delete");
        return "delete";
    }

    @PutMapping
    public String update(@RequestBody User user){
        System.out.println("update");
        return "update";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id){
        System.out.println("user getById");
        return "user getById";
    }

    @GetMapping
    public String getAll(){
        System.out.println("user getAll");
        return "user getAll";
    }
}
