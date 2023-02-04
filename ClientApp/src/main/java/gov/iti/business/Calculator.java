package gov.iti.business;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {

    public BigDecimal add(BigDecimal num1,BigDecimal num2) throws RemoteException;

    public BigDecimal subtract(BigDecimal num1,BigDecimal num2) throws RemoteException;

    public BigDecimal multiply(BigDecimal num1,BigDecimal num2) throws RemoteException;

    public BigDecimal division(BigDecimal num1,BigDecimal num2) throws RemoteException;
    
}
