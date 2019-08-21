package com.example.stockspring.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.example.stockspring.model.Company;

public interface CompanyController {
    public String insertCompany( Company company) throws Exception;
    public Company updateCompany(Company company)throws Exception;
	public ModelAndView getCompanyList() throws Exception;
}

