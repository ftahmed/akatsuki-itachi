package org.akatsuki.itachi.controller;

import com.alibaba.fastjson.JSON;
import org.akatsuki.itachi.mapper.CloudSongMapper;
import org.akatsuki.itachi.meta.CloudSong;
import org.akatsuki.itachi.service.CloudSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by long.yl on 2016/7/1.
 */
@Controller
public class DataController {

    @Autowired
    CloudSongService cloudSongService;

    @RequestMapping("/song")
    public String index(){
        return "song";
    }

    @RequestMapping("/song/add")
    public ModelAndView addSong(@RequestParam("title")String title, @RequestParam("tag")String tag){
        CloudSong song = new CloudSong();
        song.setTitle(title);
        song.setTag(tag);
        if (cloudSongService.addCloudSong(song)) {
            return new ModelAndView("success");
        }else {
            Map<String, Object> model = new HashMap<>(2);
            model.put("title", title);
            return new ModelAndView("song", model);
        }
    }

    @RequestMapping("/song/get/{id}")
    public @ResponseBody String getSougDetail(@PathVariable("id") long id){
        return JSON.toJSONString(cloudSongService.getCloudSongById(id));
    }

    @RequestMapping("/login")
    public ModelAndView login(String username, String password){
        System.out.println("username: " + username + " and password: " + password);
        if ("yl".equals(username) && "1234".equals(password)){
            System.out.println("login success!");
            Map<String, Object> model = new HashMap<>();
            model.put("username", username);
            return new ModelAndView("success", model);
        }else {
            System.out.println("login falied!");
            return new ModelAndView("index");
        }
    }

}
