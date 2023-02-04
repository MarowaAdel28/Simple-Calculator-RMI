package gov.iti.business;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImp extends UnicastRemoteObject implements Calculator {

    public CalculatorImp() throws RemoteException {
        //super();
        //TODO Auto-generated constructor stub
    }

    public BigDecimal add(BigDecimal num1, BigDecimal num2) throws RemoteException {
        // TODO Auto-generated method stub
        return num1.add(num2);
    }

    public BigDecimal subtract(BigDecimal num1, BigDecimal num2) throws RemoteException {
        // TODO Auto-generated method stub
        //System.out.println("subtract");
        return num1.subtract(num2);
    }

    public BigDecimal multiply(BigDecimal num1, BigDecimal num2) throws RemoteException {
        // TODO Auto-generated method stub
        return num1.multiply(num2);
    }

    public BigDecimal division(BigDecimal num1, BigDecimal num2) throws RemoteException {
        // TODO Auto-generated method stub
        return num1.divide(num2);
    }


    
}
