package com.shankes.account.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 前台form表单
 * <p>
 * <form action="mvc/upload" method="post" enctype="multipart/form-data">
 * <input type="file" name="file"><br>
 * <input type="submit" value="submit">
 * </form>
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest req) throws Exception {
        MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) req;
        MultipartFile file = mreq.getFile("file");
        String fileName = file.getOriginalFilename();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        FileOutputStream fos = new FileOutputStream(req.getSession().getServletContext().getRealPath("/") +
                "upload/" + sdf.format(new Date()) + fileName.substring(fileName.lastIndexOf('.')));
        fos.write(file.getBytes());
        fos.flush();
        fos.close();
        return "hello";
    }
}
