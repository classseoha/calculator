package task02;

import java.util.ArrayList;

public class Calculation implements BasicFunc {

    private ArrayList<String> resultList = new ArrayList<>();

    @Override
    public int add(int num01, int num02) {
        int result = num01 + num02;
        String inArr = Integer.toString(result);
        resultList.add(inArr);
        return result;
    }

    @Override
    public int minus(int num01, int num02) {
        int result = num01 - num02;
        String inArr = Integer.toString(result);
        resultList.add(inArr);
        return result;
    }

    @Override
    public int multiple(int num01, int num02) {
        int result = num01 * num02;
        String inArr = Integer.toString(result);
        resultList.add(inArr);
        return result;
    }

    @Override
    public double divide(int num01, int num02) {
        double result = (double) num01 / num02;
        String inArr = Double.toString(result);
        resultList.add(inArr);
        return result;
    }

    public void printResult() {
        if (resultList.isEmpty()) {
            System.out.println("저장된 결과값이 없습니다.");
        } else {
            System.out.print("결과값: ");
            for (String result : resultList) {
                System.out.print(result + " / ");
            }
        }
    }

    public void deleteResult() {
        try {
            resultList.remove(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("삭제할 결과값이 없습니다.");
        } catch (Exception e) {
            System.out.println("삭제할 결과값이 없습니다.");
        }
    }
}
