package task03;

public enum OperatorEnum {

    ADD("+", "+"), MINUS("-", "-"), MULTIPLE("×", "*"), DIVIDE("÷", "/");

    private String symbol01; // 사칙연산 기호1
    private String symbol02; // 사칙연산 기호2

    OperatorEnum(String symbol01, String symbol02) { // 사칙연산 기호 등록 생성자
        this.symbol01 = symbol01;
        this.symbol02 = symbol02;
    }

    public String getSymbol() { // 캡슐화 해놓은 사칙연산 기호 호출용 메소드
        return symbol01;
    }

    public String getSymbol2() {
        return symbol02;
    }

    public static boolean containSymbol(String test) { // 사용자가 입력한 사칙연산 기호와 상수로 등록해놓은 기호가 일치하는지 테스트하는 메소드
        for (OperatorEnum operator : OperatorEnum.values()) {
            if (operator.getSymbol().equals(test) || operator.getSymbol2().equals(test)) {
                return true;
            }
        }
        return false;
    }
}
