package me.tcgg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.tcgg.mapper.HealthDataMapper;
import me.tcgg.pojo.HealthData;
import me.tcgg.service.HealthDataService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class HealthDataServiceImpl implements HealthDataService {

    @Resource
    private HealthDataMapper healthDataMapper;

    public PageInfo<HealthData> selectByUidAndDate(String uid, String date, int pageNum) {
        PageHelper.startPage(pageNum, 30);
        List<HealthData> dataList = healthDataMapper.selectByUidAndDate(uid, date, new RowBounds());
        return new PageInfo<>(dataList);
    }

    public PageInfo<HealthData> selectByUid(String uid, int pageNum) {
        PageHelper.startPage(pageNum, 30);
        List<HealthData> dataList = healthDataMapper.selectByUid(uid, new RowBounds());
        return new PageInfo<>(dataList);
    }

    public List<HashMap<String ,Object>> getUserDate(String uid){
        return healthDataMapper.selectDistinctDatesByUidWithSequence(uid);
    }


}
