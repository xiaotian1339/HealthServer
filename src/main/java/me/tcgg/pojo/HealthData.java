package me.tcgg.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HealthData {

    private Integer id;

    private String  uid;

    private Double oxygenSaturation;

    private Integer heartRate;

    private boolean available;

    private String date;

    private String time;

}
