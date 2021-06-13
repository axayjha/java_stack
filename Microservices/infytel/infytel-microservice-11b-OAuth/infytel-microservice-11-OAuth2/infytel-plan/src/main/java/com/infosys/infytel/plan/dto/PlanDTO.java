package com.infosys.infytel.plan.dto;

import java.util.Optional;

import com.infosys.infytel.plan.entity.Plan;

public class PlanDTO {

	
	Integer planId;
	
	String planName;

	Integer nationalRate;

	Integer localRate;
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Integer getNationalRate() {
		return nationalRate;
	}
	public void setNationalRate(Integer nationalRate) {
		this.nationalRate = nationalRate;
	}
	public Integer getLocalRate() {
		return localRate;
	}
	public void setLocalRate(Integer localRate) {
		this.localRate = localRate;
	}
	public PlanDTO() {
		super();
	}

	// Converts Entity into DTO
	public static PlanDTO valueOf(Plan plan) {
		PlanDTO planDTO= new PlanDTO();
		planDTO.setLocalRate(plan.getLocalRate());
		planDTO.setNationalRate(plan.getNationalRate());
		planDTO.setPlanId(plan.getPlanId());
		planDTO.setPlanName(plan.getPlanName());
		return planDTO;
	}
	@Override
	public String toString() {
		return "PlanDTO [planId=" + planId + ", planName=" + planName + ", nationalRate=" + nationalRate
				+ ", localRate=" + localRate + "]";
	}
	public static PlanDTO valueOf(Optional<Plan> findById) {
		// TODO Auto-generated method stub
		PlanDTO planDTO= new PlanDTO();
		planDTO.setLocalRate(findById.get().getLocalRate());
		planDTO.setNationalRate(findById.get().getNationalRate());
		planDTO.setPlanId(findById.get().getPlanId());
		planDTO.setPlanName(findById.get().getPlanName());
		return planDTO;
	}


}
