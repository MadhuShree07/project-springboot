package com.xworkz.springboot.controller;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.springboot.dto.SpringbootDTO;
import com.xworkz.springboot.entity.SpringbootEntity;
import com.xworkz.springboot.service.SpringbootService;

@Controller
public class SpringBootController {

	private static final Logger logger = Logger.getLogger(SpringBootController.class);

	@Autowired
	private SpringbootService springbootService;

	public SpringBootController() {
		logger.info("Created " + this.getClass().getSimpleName());
	}
	

	@RequestMapping("onDO")
	public String onDO() {
		logger.info("Invoked onDo");
		return "springboot";

	}

	@RequestMapping("springboot")
	public String save(SpringbootDTO springbootDTO, Model model) {
		try {
			logger.info("Started save from springboot controller" + springbootDTO);
			logger.info("Invoked springboot page");

			if (Objects.nonNull(springbootDTO)) {

				SpringbootEntity fetchedMessage = springbootService.validateAndSave(springbootDTO);
				logger.info(fetchedMessage);

				model.addAttribute("from", springbootDTO.getFromName());
				model.addAttribute("message", springbootDTO.getMessage());
				logger.info("Directing to message.jsp");
				return "message";
			} else {
				logger.error("Message not valid");
				model.addAttribute("Error", "check the details you entered");
				return "springboot";
			}
		} catch (Exception e) {
			logger.error("Exception in save method of SpringbootController " + e);
		}
		logger.info("Ended save method of SpringbootController " + springbootDTO);
		return "message";
	}
}
