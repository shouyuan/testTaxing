package com.crunchify.controller;
 
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.DocumentException;
 
/*
 * author: Crunchify.com
 * 
 */
 
@Controller
public class CrunchifyHelloWorld {
 
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
 try {
	AddContentToPDF.writePDF();
} catch (IOException | DocumentException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3></div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
}