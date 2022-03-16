package paylocity.pages;



public class TestBase {


    public static benfits Calcultaion (int a){
        /*Assumptions:
        All employees are paid $2000 per paycheck before deductions
        There are 26 paychecks in a year
        The cost of benefits is $1000/year for each employee
        Each dependent incurs a cost of $500/year*/
        double paycheckYearly = 2000;
        double benefitWeeklyn =38.46; //38.46
        double dependent = 19.23;
        if(a>1){
            dependent*=a;
        }
        double netPay = (paycheckYearly-(benefitWeeklyn+dependent));
        double BenifitCost = benefitWeeklyn+dependent;

        benfits benfits = new benfits(netPay,BenifitCost);


        return benfits;
    }


}


