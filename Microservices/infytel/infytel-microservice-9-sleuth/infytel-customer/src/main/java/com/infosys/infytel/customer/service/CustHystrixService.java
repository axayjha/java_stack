package com.infosys.infytel.customer.service;

import java.util.List;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infosys.infytel.customer.controller.CustPlanFeign;
import com.infosys.infytel.customer.dto.PlanDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;

@Service
public class CustHystrixService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	RestTemplate template;
	
	@Autowired
	CustPlanFeign planFeign;
	
	@HystrixCommand(fallbackMethod="getPlanFallBack")
	public Future<PlanDTO> getSpecificPlans(final int planId) {
		return new AsyncResult<PlanDTO>() {
			@Override
			
			public PlanDTO invoke() {
				return planFeign.getSpecificPlan(planId);
			}
		};
		
	}
	
	public PlanDTO getPlanFallBack(int planId) {
		logger.info("***++++==== Inside Fall back ====++++****");
		return null;
	}
	@HystrixCommand
	public Future<List<Long>> getFriends(final long phoneNo)
	{
		return new AsyncResult<List<Long>>() {
		@SuppressWarnings("unchecked")
		@Override
		public List<Long> invoke(){
			return template.getForObject("http://FRIENDFAMILYMS"+"/customers/"+phoneNo+"/friends", List.class);
		}
		};
		
	}
}
