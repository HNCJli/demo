package suep.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import suep.example.demo.common.CommonResult;
import suep.example.demo.vo.CompanyinfoVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Li Ming
 * @e-mail liming.school@qq.com
 * @create 2022-10-13 22:25
 */
@RestController
@RequestMapping("/companyinfo/basicinfo/import")
public class CompanyInfoController {

    /**
     * @param path 想要下载的文件的路径
     * @param response
     * @功能描述 下载文件:
     */
    @GetMapping("/download")
    public void download(String path, HttpServletResponse response) {
        try {
            path="C:\\Users\\Mr.Chestnut\\Desktop\\demo\\src\\main\\java\\suep\\example\\demo\\file\\template.xlsx";
            // path是指想要下载的文件的路径
            File file = new File(path);
            // 获取文件名
            String filename = file.getName();
            // 获取文件后缀名
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();

            // 将文件写入输入流
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStream fis = new BufferedInputStream(fileInputStream);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();

            // 清空response
            response.reset();
            // 设置response的Header
            response.setCharacterEncoding("UTF-8");
            //Content-Disposition的作用：告知浏览器以何种方式显示响应返回的文件，用浏览器打开还是以附件的形式下载到本地保存
            //attachment表示以附件方式下载 inline表示在线打开 "Content-Disposition: inline; filename=文件名.mp3"
            // filename表示文件的默认名称，因为网络传输只支持URL编码的相关支付，因此需要将文件名URL编码后进行传输,前端收到后需要反编码才能获取到真正的名称
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
            // 告知浏览器文件的大小
            response.addHeader("Content-Length", "" + file.length());
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            outputStream.write(buffer);
            outputStream.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    /**
     *
     *
     */
    @PostMapping("/upload")
    public @ResponseBody CommonResult upload(@RequestParam MultipartFile file, HttpServletRequest request){
        CommonResult<String> commonResult = new CommonResult<>();
        CommonResult result = commonResult.success(null);
        return result;
    }


    /**
     *
     */
    @GetMapping("/list")
    public CommonResult list(String code,String name,int pageNum,int pageSize){
        ArrayList<CompanyinfoVO> companyinfoVOS = new ArrayList<>();
        CompanyinfoVO companyinfoVO = new CompanyinfoVO("企业id","企业代码","企业名称","企业类型A/B/高耗能/C/D",100,"continuity");
        companyinfoVOS.add(companyinfoVO);

        CommonResult<List<CompanyinfoVO>> commonResult = new CommonResult<>();
        CommonResult result = commonResult.success(companyinfoVOS);
        return result;
    }


    /**
     *
     */
    @PostMapping("/one")
    public CommonResult one(String name,String type,int baseline,String feature){
        CommonResult<String> commonResult = new CommonResult<>();
        CommonResult result = commonResult.success(null);
        System.out.println("post-one");
        return result;
    }


    /**
     *
     */
    @PutMapping("/one")
    public CommonResult one(String CompanyId, Map<String,Object> map){
        CommonResult<String> commonResult = new CommonResult<>();
        CommonResult result = commonResult.success(null);
        System.out.println("put-one");
        return result;
    }


    /**
     *
     */
    @DeleteMapping("/one")
    public CommonResult one(String CompanyId){
        CommonResult<String> commonResult = new CommonResult<>();
        CommonResult result = commonResult.success(null);
        System.out.println("delete-one");
        return result;
    }
}
