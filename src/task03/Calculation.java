package task03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculation<T extends Number> {

    // 계산 결과값을 저장하는 String 타입 리스트 선언
    private ArrayList<String> resultList = new ArrayList<>();

    // Number 속성 매개변수 2개를 입력받아 더하기 연산하는 메소드
    public double add(T num01, T num02) {
        double result = num01.doubleValue() + num02.doubleValue();
        String inArr = Double.toString(result); // String 타입 리스트에 저장하기 위해 String으로 변환
        resultList.add(inArr); // 리스트에 결과값 저장
        return result; // 결과값 반환
    }

    // Number 속성 매개변수 2개를 입력받아 빼기 연산하는 메소드
    public double minus(T num01, T num02) {
        double result = num01.doubleValue() - num02.doubleValue();
        String inArr = Double.toString(result);
        resultList.add(inArr);
        return result;
    }

    // Number 속성 매개변수 2개를 입력받아 곱하기 연산하는 메소드
    public double multiple(T num01, T num02) {
        double result = num01.doubleValue() * num02.doubleValue();
        String inArr = Double.toString(result);
        resultList.add(inArr);
        return result;
    }

    // Number 속성 매개변수 2개를 입력받아 나누기 연산하는 메소드
    public double divide(T num01, T num02) {
        double result = num01.doubleValue() / num02.doubleValue();
        String inArr = Double.toString(result);
        resultList.add(inArr);
        return result;
    }

    // 리스트에 저장된 결과값을 조회할 수 있게 하는 메소드
    public void printResult() {
        if (resultList.isEmpty()) { // 리스트 내 저장된 값이 없으면 저장된 값이 없다는 내용 반환
            System.out.println("저장된 결과값이 없습니다.");
        } else {
            System.out.print("결과값: ");
            for (String result : resultList) { // 리스트 내 저장된 값 향상된 for문으로 나열
                System.out.print(result + " / ");
            }
        }
    }

    // 리스트에 저장된 결과값 중, 제일 처음 입력된 것을 삭제하는 메소드
    public void deleteResult() {
        try {
            resultList.remove(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("삭제할 결과값이 없습니다.");
        } catch (Exception e) {
            System.out.println("삭제할 결과값이 없습니다.");
        }
    }

    // Lambda & Stream을 활용하여 유저가 입력한 값과 리스트에 저장된 결과값을 비교 후, 더 큰값을 리스트에 저장하여 보여주는 메소드
    public void bigNum(Double user) {
        List<String> list = this.resultList.stream().filter(num -> ((Double.parseDouble(num)) > user)).collect(Collectors.toList());
        System.out.println(list);
    }
}
