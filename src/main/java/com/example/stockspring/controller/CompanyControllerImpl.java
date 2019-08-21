package com.example.stockspring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.stockspring.model.Company;
import com.example.stockspring.service.CompanyService;




@Controller
public class CompanyControllerImpl implements CompanyController {
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping(path="/NewCompany" )
	public String insertCompanyPage(Model model)
	{
		Company company = new Company();
		model.addAttribute("company", company);
		return "NewCompany";	
	}
		
	@RequestMapping(path="/insert", method = RequestMethod.POST)
	public String insertCompany(Company company)
	{
		try 
		{
			companyService.insertCompany(company);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}   
		return "redirect:companyList";
		
	}
	
	public Company updateCompany(Company company) throws Exception {
		return companyService.updateCompany(company);
	}

	@RequestMapping(path="/companyList")
	public ModelAndView getCompanyList() throws Exception {
		List<Company> list=companyService.getCompanyList();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("companyList");
		mv.addObject("list", list);
		return mv;
	}

}
