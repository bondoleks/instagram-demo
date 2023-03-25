package com.instagramdemo.instagramDemo.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

  public void addViewControllers(ViewControllerRegistry registry) {
    String[][] mappings = {
    //  mapping     file name in `resources/templates` folder `.html`
        {"/"      , "home" }, // open for ALL
        {"/registration" , "registration"}, // open for ALL
        {"/message"  , "message" }, // open for ANY authenticated
        {"/admin" , "admin"}, // only for ROLE: ADMIN
        {"/likes"    , "likes"   }, // open for ROLE: USER
        {"/profile"  , "profile/**" }, // open for ROLE: ADMIN | USER
    };

    for (String[] item: mappings) {
      registry.addViewController(item[0]).setViewName(item[1]);
    }
  }

}
