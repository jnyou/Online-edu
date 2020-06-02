package org.jnyou.eduservice.controller;

import org.jnyou.commonutils.R;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("edu/test")
@CrossOrigin // 解决跨域问题
public class EduLoginController {

    /**
     * 测试用的登录接口，方便能够登录
     */

    @PostMapping("login")
    public R TestLogin(){
        return R.ok().put("token","admin");
    }

    /**
     * 测试获取用户身份信息
     */
    @GetMapping("info")
    public R TestUserInfo(){
        return R.ok().put("roles","[admin]").put("name","admin").put("avatar","");
    }

}
