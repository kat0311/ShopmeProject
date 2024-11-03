package com.shopme.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {  // 这里需要加上 'class'

    @GetMapping("/")  // 确保导入了正确的包
    public String viewHomePage() {
        return "index";  // 返回视图名称
    }

}

