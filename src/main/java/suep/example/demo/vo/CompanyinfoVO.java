package suep.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Li Ming
 * @e-mail liming.school@qq.com
 * @create 2022-10-13 23:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompanyinfoVO {
    private String id;
    private String code;
    private String name;
    private String type;
    private int baseline;
    private String feature;
}
