package suep.example.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Li Ming
 * @e-mail liming.school@qq.com
 * @create 2022-10-13 23:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PageInfo {
    private int total;
    private int pageCount;
    private int currentPage;
}
