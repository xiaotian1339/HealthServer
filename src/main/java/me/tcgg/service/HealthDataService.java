package me.tcgg.service;

import com.github.pagehelper.PageInfo;
import me.tcgg.pojo.HealthData;

import java.util.HashMap;
import java.util.List;

public interface HealthDataService {
    PageInfo<HealthData> selectByUidAndDate(String uid, String date, int pageNum);

    PageInfo<HealthData> selectByUid(String uid,int pageNum);

    List<HashMap<String ,Object>> getUserDate(String uid);
}
