package task03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculation<T extends Number> {

    private ArrayList<String> resultList = new ArrayList<>();

    public double add(T num01, T num02) {
        double result = num01.doubleValue() + num02.doubleValue();
        String inArr = Double.toString(result);
        resultList.add(inArr);
        return result;
    }

    public double minus(T num01, T num02) {
        double result = num01.doubleValue() - num02.doubleValue();
        String inArr = Double.toString(result);
        resultList.add(inArr);
        return result;
    }

    public double multiple(T num01, T num02) {
        double result = num01.doubleValue() * num02.doubleValue();
        String inArr = Double.toString(result);
        resultList.add(inArr);
        return result;
    }

    public double divide(T num01, T num02) {
        double result = num01.doubleValue() / num02.doubleValue();
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

    public void bigNum(Double user) {
        List<String> list = this.resultList.stream().filter(num -> ((Double.parseDouble(num)) > user)).collect(Collectors.toList());
        System.out.println(list);
    }
}
