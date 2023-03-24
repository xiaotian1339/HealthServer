package me.tcgg.mapper;

import me.tcgg.pojo.HealthData;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.HashMap;
import java.util.List;

public interface HealthDataMapper {
    @Select("SELECT * FROM healthData WHERE uid = #{uid} AND date = #{date} ORDER BY time ASC")
    List<HealthData> selectByUidAndDate(@Param("uid") String uid, @Param("date") String date, RowBounds rowBounds);

    @Select("SELECT * FROM healthData WHERE uid = #{uid} ORDER BY time ASC")
    List<HealthData> selectByUid(@Param("uid") String uid, RowBounds rowBounds);


    @Insert("insert into healthData values (null,#{uid},#{oxygenSaturation},#{heartRate},#{available},#{date},#{time})")
    Integer insertHealthDate(HealthData healthData);

    @Select("SELECT @seq := @seq + 1 AS sequence, tmp.date FROM" +
            " (SELECT DISTINCT date FROM healthData WHERE uid = #{uid} ORDER BY date ASC) tmp, (SELECT @seq := -1) seq")
    @Results(id = "dateResultMap", value = {
            @Result(property = "id", column = "sequence"),
            @Result(property = "date", column = "date")
    })
    List<HashMap<String, Object>> selectDistinctDatesByUidWithSequence(@Param("uid") String uid);











}
