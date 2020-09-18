package com.cms.portal.controller.admin;

import com.google.code.kaptcha.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@Slf4j
public class LoginController {

    @Resource
    private Producer captchaProducer;

    @RequestMapping("login.do")
    public String toLogin(){
        return "admin/login";
    }

    @GetMapping("captcha.do")
    public void doCaptcha(HttpServletResponse httpServletResponse){
        String text = captchaProducer.createText();
        BufferedImage image = captchaProducer.createImage(text);

        try(ServletOutputStream outputStream = httpServletResponse.getOutputStream()) {
            ImageIO.write(image, "jpg", outputStream);
        }catch (IOException e){
            log.error("验证码生成失败");
        }
    }



}
