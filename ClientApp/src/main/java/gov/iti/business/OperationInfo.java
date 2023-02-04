package gov.iti.business;

import java.math.BigDecimal;

public class OperationInfo {

    BigDecimal firstNum,secondNum;
    String opertion;
    boolean isTrue=false;
    
    private static final OperationInfo instance = new OperationInfo();

    public static OperationInfo getInstance() {
        return instance;
    }

    public BigDecimal getFirstNum() {
        return firstNum;
    }
    public void setFirstNum(BigDecimal firstNum) {
        this.firstNum = firstNum;
    }
    public BigDecimal getSecondNum() {
        return secondNum;
    }
    public void setSecondNum(BigDecimal secondNum) {
        this.secondNum = secondNum;
    }
    public String getOpertion() {
        return opertion;
    }
    public void setOpertion(String opertion) {
        this.opertion = opertion;
    }
    public boolean isTrue() {
        return isTrue;
    }
    public void setTrue(boolean isTrue) {
        this.isTrue = isTrue;
    }

}
