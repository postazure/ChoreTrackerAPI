//package com.postazure.controllers;
//
//import org.apache.log4j.Logger;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;

//
//
//
///**
// * Created by postazure on 1/26/16.
// */
//
//@Controller
//@RequestMapping("/auth")
//public class AuthController {
//    protected static Logger logger = Logger.getLogger("controller");
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
//    public String loggin(
//            @RequestParam(value = "error", required = false)
//            boolean error, ModelMap model) {
//        logger.debug("Request to login");
//        if (error == true) {
//            // Assign an error message
//            model.put("error", "You have entered an invalid username or password!");
//        } else {
//            model.put("error", "");
//        }
//
//        // This will resolve to /WEB-INF/jsp/loginpage.jsp
//        return "loginpage";
//
//
//    }
//
//    @RequestMapping(value = "/denied", method = RequestMethod.GET)
//    public String getDeniedPage() {
//        logger.debug("Received request to show denied page");
//        return "Denied Page";
////        // This will resolve to /WEB-INF/jsp/deniedpage.jsp
////        return "deniedpage";
//    }
//
//}
//
