import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Annual Salary: ");
        float annualSalary = input.nextFloat();
        double annualDeduct = 0;

        double[] taxExcess = {0.2, 0.25, 0.30, 0.32, 0.35};
        double[] taxDeduction = {30000.00, 130000.00, 490000.00, 2410000.00};

        while(annualDeduct < annualSalary || annualSalary != 0){

            if (annualSalary > 250000 && annualSalary <= 400000){
                annualDeduct = annualSalary * taxExcess[0];

            } else if (annualSalary > 400000 && annualSalary <= 800000){
                if ((annualSalary - taxDeduction[0]) > 400000){
                    annualDeduct = ((annualSalary - taxDeduction[0]) * taxExcess[1]) + taxExcess[0];
                } else {
                    annualDeduct = taxDeduction[0];
                }

            } else if (annualSalary > 800000 && annualSalary <= 2000000){
                if ((annualSalary - taxDeduction[1]) > 800000){
                    annualDeduct = ((annualSalary - taxDeduction[1]) * taxExcess[2]) + taxExcess[1];
                } else {
                    annualDeduct = taxDeduction[1];
                }

            } else if (annualSalary > 2000000 && annualSalary <= 8000000){
                if ((annualSalary - taxDeduction[1]) > 800000){
                    annualDeduct = ((annualSalary - taxDeduction[1]) * taxExcess[3]) + taxExcess[2];
                } else {
                    annualDeduct = taxDeduction[2];
                }

            } else if (annualSalary > 8000000){
                if ((annualSalary - taxDeduction[1]) > 2000000){
                    annualDeduct = ((annualSalary - taxDeduction[1]) * taxExcess[4]) + taxExcess[3];
                } else {
                    annualDeduct = taxDeduction[3];        
                }   
            }break;
        }
        double monthlyRate = annualSalary/12;
        System.out.printf("Monthly Rate: %.2f \n", monthlyRate);
        double dailyRate = monthlyRate/22;
        System.out.printf("Daily Rate: %.2f \n", dailyRate);
        double hourlyRate = dailyRate/8;
        System.out.printf("Hourly Rate: %.2f \n", hourlyRate);
        System.out.printf("Annual Tax Deduction: %.2f \n", annualDeduct); 
        double monthlyDeduct = annualDeduct/12;
        System.out.printf("Monthly Tax Deduction: %.2f \n", monthlyDeduct);
        double netPay = monthlyRate - monthlyDeduct;
        System.out.printf("Net Pay: %.2f \n", netPay);

    }
}
