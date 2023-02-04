package gov.iti.business;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Connection {

    Registry reg;
    Calculator calculatorRef;

    private static final Connection instance = new Connection();

    public static Connection getInstance() {
        return instance;
    }

    public Connection () {
        try{
            //Registry reg =  LocateRegistry.
            //Registry("127.0.0.1");
            reg = LocateRegistry.getRegistry();
            calculatorRef =(Calculator) reg.lookup("CalculateService"); 
            //String str = helloRef.sayHello("JETS");
            //System.out.println(str);
            } catch(Exception ex) { 
                ex.printStackTrace();
            }
    }

    public BigDecimal calculate() {

        BigDecimal result=null;

        if(OperationInfo.getInstance().isTrue()) {
            BigDecimal fBigDecimal = OperationInfo.getInstance().getFirstNum();
            BigDecimal sBigDecimal = OperationInfo.getInstance().getSecondNum();
            String ope = OperationInfo.getInstance().getOpertion();
            System.out.print(ope);

            if(ope.equals("+")) {
                try {
                    result=calculatorRef.add(fBigDecimal, sBigDecimal);
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else if (ope.equals("-")) {
                System.out.println("elseon");
                try {
                    
                    result=calculatorRef.subtract(fBigDecimal, sBigDecimal);
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else if (ope.equals("*")) {
                try {
                    result=calculatorRef.multiply(fBigDecimal, sBigDecimal);
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else if (ope.equals("/")) {
                try {
                    result=calculatorRef.division(fBigDecimal, sBigDecimal);
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                System.out.println("invalid operation");
            }
        }
        return result;
    }
    
}
