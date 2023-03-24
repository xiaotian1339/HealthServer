package me.tcgg.controller;

import com.github.pagehelper.PageInfo;
import me.tcgg.pojo.HealthData;
import me.tcgg.service.HealthDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RootController {

    @Autowired
    private HealthDataService healthDataService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/info/{userId}/{page}")
    public String getHealthData(@PathVariable String userId, @PathVariable String page, Model model) {
        PageInfo<HealthData> healthDataPageInfo;
        try {
            healthDataPageInfo = healthDataService.selectByUid(userId, Integer.parseInt(page));
        } catch (Exception e) {
            e.printStackTrace();
            return "error/404";
        }
        model.addAttribute("dataList",healthDataPageInfo);
        return "showDataById";
    }


}
