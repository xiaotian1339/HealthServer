package me.tcgg.status;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.tcgg.enums.StatusCodeEnum;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStatus {
    private Integer code;
    private String message;

    public ResponseStatus(StatusCodeEnum statusCodeEnum){
        this.code = statusCodeEnum.getCode();
        this.message = statusCodeEnum.getMsg();
    }
}
