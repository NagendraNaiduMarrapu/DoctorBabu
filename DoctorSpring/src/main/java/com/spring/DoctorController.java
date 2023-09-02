package com.spring;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class DoctorController {
	@Autowired
	DoctorDAO docdao;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String displayDoctors(Model model) {
		ArrayList<Doctor> doctors = docdao.getAllDoctors();
        model.addAttribute("doctors", doctors);
        return "DoctorPreview";
	}
}
