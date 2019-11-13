/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calorietracker;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Harsh
 */

@XmlRootElement
public class ReportDate {

    private double calorieConsumed;
    private double calorieBurned;
    private String reportDate;

    public ReportDate() {
    }

    public ReportDate(double calorieConsumed, double calorieBurned, String reportDate) {
        this.calorieConsumed = calorieConsumed;
        this.calorieBurned = calorieBurned;
        this.reportDate = reportDate;
    }

    public double getCalorieConsumed() {
        return calorieConsumed;
    }

    public void setCalorieConsumed(double calorieConsumed) {
        this.calorieConsumed = calorieConsumed;
    }

    public double getCalorieBurned() {
        return calorieBurned;
    }

    public void setCalorieBurned(double calorieBurned) {
        this.calorieBurned = calorieBurned;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }
}
