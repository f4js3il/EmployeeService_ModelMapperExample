package com.example.EmployeeService.Payload;

import java.util.Date;

public abstract class EmploymentStatus {

    private Boolean isEmployed;
    private Date employmentStartDate;
    private Date lastPromotionDate;

    public Boolean getEmployed() {
        return isEmployed;
    }

    public void setEmployed(Boolean employed) {
        isEmployed = employed;
    }

    public Date getEmploymentStartDate() {
        return employmentStartDate;
    }

    public void setEmploymentStartDate(Date employmentStartDate) {
        this.employmentStartDate = employmentStartDate;
    }

    public Date getLastPromotionDate() {
        return lastPromotionDate;
    }

    public void setLastPromotionDate(Date lastPromotionDate) {
        this.lastPromotionDate = lastPromotionDate;
    }

    public abstract void changeEmployment();

    public void promoted(Date promotionDate){
        this.lastPromotionDate = promotionDate;
    }
}
