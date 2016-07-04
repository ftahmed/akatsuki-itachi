package org.akatsuki.itachi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author long.yl.
 * @Date 2016/7/1
 */
@Controller
@RequestMapping("/test")
public class SampleController{

    @RequestMapping("/getInfo")
    public @ResponseBody String getInfo(){
        return "love is touch and yet not a touch.";
    }

}
