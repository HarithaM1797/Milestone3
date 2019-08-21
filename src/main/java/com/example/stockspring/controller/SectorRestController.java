      package com.example.stockspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.stockspring.service.CompanyService;
import com.example.stockspring.service.StockPriceService;
import com.example.stockspring.model.StockPrice;
import com.example.stockspring.model.Company;
import com.example.stockspring.model.IpoPlaned;
import com.example.stockspring.service.IpoPlanedService;


@RestController
public class SectorRestController {
      @Autowired
      CompanyService companyService;
      
      @Autowired
      StockPriceService stockPriceService;
      
      @Autowired
      IpoPlanedService ipoPlanedService;
	
	  @GetMapping("/companyList/{name}")
      public List<Company> getCompanyList(@PathVariable("name") String stockName) throws Exception
      {
		  return companyService.getCompanyListSector(stockName);
      }
	  
	  @GetMapping("/stockPriceList/{companyName}")
	  public List<StockPrice> getStockPriceList(@PathVariable("companyName") String companyName) throws Exception
	  {
		  return stockPriceService.getStockPriceCompany(companyName);
	  }
	  
	  @GetMapping("/IpoPlanedList/{companyName}")
	  public List<IpoPlaned> getIpoPlanedList(@PathVariable("companyName") String companyName) throws Exception
	  {
		  return ipoPlanedService.getIpoPlanedList(companyName);
	  }
}
