package com.wangyuelin.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述:
 *
 * @outhor wangyuelin
 * @create 2018-06-21 下午5:22
 */
public class HtmlController {

    public String index(HttpServletRequest request) {
        return "index.html";

    }

}