package suep.example.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

/**
 * @author Li Ming
 * @e-mail liming.school@qq.com
 * @create 2022-10-13 23:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommonResult<T> {
    private static final int SUCCESS_CODE = 0;
    private static final int ERROR_CODE = 1;

    private Integer code;
    private String message;
    private T data;

    public CommonResult success(T data) {
        CommonResult result = new CommonResult();
        result.setCode(SUCCESS_CODE);
        result.setMessage("success");
        if(data!=null)
            result.setData(data);
        return result;
    }

    public CommonResult error(String message) {
        CommonResult result = new CommonResult();
        result.setCode(ERROR_CODE);
        message="error";
        result.setMessage(message);
        return result;
    }
}
