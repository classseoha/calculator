package task03;

public enum OperatorEnum {

    ADD("+", "+"), MINUS("-", "-"), MULTIPLE("×", "*"), DIVIDE("÷", "/");

    private String symbol01;
    private String symbol02;

    OperatorEnum(String symbol01, String symbol02) {
        this.symbol01 = symbol01;
        this.symbol02 = symbol02;
    }

    public String getSymbol() {
        return symbol01;
    }

    public String getSymbol2() {
        return symbol02;
    }

    public static boolean containSymbol(String test) {
        for (OperatorEnum operator : OperatorEnum.values()) {
            if (operator.getSymbol().equals(test) || operator.getSymbol2().equals(test)) {
                return true;
            }
        }
        return false;
    }
}
