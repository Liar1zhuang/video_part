package com.example.demo.web;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @author denakira
 * @date 2019/12/23 7:34 下午
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @ResponseBody
    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String login(@RequestParam("name") String name,
                      @RequestParam("password") String password,
                      HttpServletResponse response,
                      HttpServletRequest request) throws IOException{
        logger.info(request.getRequestURL().toString());
        logger.info(request.getParameter("name"));
        logger.info(request.getParameter("password"));
        UserEntity userBean = userService.loginIn(name,password);
        if(userBean!=null){
            return "success";
        }else {
            return "fail";
        }
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void getVideo(HttpServletResponse response) throws IOException {
        File file = new File("/springboot/video");

        FileInputStream inputStream = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        int length = inputStream.read(data);
        inputStream.close();

        String fileName = URLEncoder.encode("test.mp4", "UTF-8");

        response.setContentType("application/octet-stream;charset=UTF-8");
        response.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");
        response.addHeader("Content-Length", "" + data.length);

        OutputStream stream = response.getOutputStream();
        stream.write(data);
        stream.flush();
        stream.close();
    }
}
