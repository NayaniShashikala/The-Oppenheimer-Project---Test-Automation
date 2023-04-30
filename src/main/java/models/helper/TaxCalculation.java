package models.helper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TaxCalculation {
    DecimalFormat decimalFormat = new DecimalFormat("#.##");

    // get decimal values
    public double getTaxReliefAmount(double salary, double taxPaid, String birthdate, boolean isMale){
        double variable = getVariableValue(birthdate);
        double genderBonus = isMale ? 0 : 500;
        double taxRelief = ((salary - taxPaid) * variable) + genderBonus;

        //for rounding-> df- decides decimal places
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedAmount = df.format(taxRelief);
        double roundedAmount = Double.parseDouble(formattedAmount);
        return roundedAmount;
    }

    private int calculateAge(String birthdate){
        LocalDate bod = LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("ddMMyyyy"));
        // Calculate age as of today's date
        LocalDate today = LocalDate.now();
        Period age = Period.between(bod, today);
        return age.getYears();

    }

    private double getVariableValue(String birthdate){

        int age = calculateAge(birthdate);
        double variable;
        if (age <= 18) {
            variable = 1;
        } else if (age <= 35) {
            variable = 0.8;
        } else if (age <= 50) {
            variable = 0.5;
        } else if (age <= 75) {
            variable = 0.367;
        } else {
            variable = 0.05;
        }
        return variable;
    }

    public Double applyNormalRoundRule (Double reliefAmount) {
        BigDecimal bd = new BigDecimal(Double.toString(reliefAmount));
        bd = bd.setScale(0, RoundingMode.HALF_UP);
        Double roundedTaxRelief = Double.valueOf(bd.longValueExact());
      return  roundedTaxRelief;
    }

    }
