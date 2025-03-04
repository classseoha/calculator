package task03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {

        Calculation calculation = new Calculation<>(); //연산 클래스 인스턴스화
        Scanner scan = new Scanner(System.in);

        int select = 0; // 사용자 Switch 번호 입력 변수 선언
        while (true) {
            System.out.println();
            System.out.println("######## 양의 정수 계산기 ########");
            System.out.println("1. 계산기 사용 \n2. 결과값 조회 \n3. 결과값 삭제 \n4. 입력값 보다 큰 결과값 조회 \n5. 프로그램 종료");
            System.out.print("번호 선택: ");

            try { // 입력 시 Switch에 해당되는 값 이외의 값 입력 시 발생하는 예외 처리
                select = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("잘못 입력하셨습니다. 다시 골라주세요.");
                scan.nextLine();
                continue;
            } catch (Exception e) {
                System.out.println("잘못 입력하셨습니다. 다시 골라주세요.");
                scan.nextLine();
                continue;
            }

            switch (select) {
                case 1: // 계산기 사용 실행

                    Number num01; // 첫번째 숫자 입력 받기 위한 변수 선언 (Number 타입으로 선언하여 숫자면 정수든 실수든 내포 가능)
                    while (true) {
                        System.out.print("첫번째 정수 입력: ");
                        String userNum01 = scan.next();

                        try { // exit, 숫자 이외의 문자 입력 시 발생하는 예외 처리
                            if (userNum01.equalsIgnoreCase("exit")) {
                                System.out.println("프로그램을 종료합니다.");
                                scan.close();
                                System.exit(0);
                            }

                            if (userNum01.contains(".")) { // 사용자 입력 값에 .이 포함되어 있으면 실수 타입으로 변환
                                num01 = Double.parseDouble(userNum01);
                                scan.nextLine();
                                break;
                            } else { // . 미포함 시 정수 타입 변환
                                num01 = Integer.parseInt(userNum01);
                                scan.nextLine();
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
                        } catch (Exception e) {
                            System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
                        }
                    }

                    String userStr; // 사칙연산 기호 입력 받기 위한 String 타입 변수 선언
                    OperatorEnum operatorEnum = null;
                    while (true) {
                        System.out.print("사칙연산 기호 입력: ");
                        userStr = scan.next();

                        if (OperatorEnum.containSymbol(userStr)) { // 사용자 입력값이 OperatorEnum 상수값에 포함되어 있는지 여부 확인
                            scan.nextLine();
                            break;
                        } else if (userStr.equalsIgnoreCase("exit")) { // 사용자 입력값이 exit 인지 여부 확인
                            System.out.println("프로그램을 종료합니다.");
                            scan.close();
                            System.exit(0);
                        } else { // 둘다 아닐 시 재입력 메세지 송출
                            System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
                            scan.nextLine();
                        }
                    }

                    Number num02; // 두번째 숫자 입력 받기 위한 변수 선언 (Number 타입으로 선언하여 숫자면 정수든 실수든 내포 가능)
                    while (true) {
                        System.out.print("두번째 정수 입력: ");
                        String userNum02 = scan.next();

                        try { // exit, 숫자 이외의 문자 입력 시 발생하는 예외 처리
                            if (userNum02.equalsIgnoreCase("exit")) {
                                System.out.println("프로그램을 종료합니다.");
                                scan.close();
                                System.exit(0);
                            }

                            if (userNum02.contains(".")) {
                                num02 = Double.parseDouble(userNum02);
                                scan.nextLine();
                            } else { // userStr에 입력된 사칙연산 기호가 나누기 기호 + userNum02 입력값이 0일 경우 반려
                                if (userNum02.equals("0") && (userStr.equals(operatorEnum.DIVIDE.getSymbol()) || userStr.equals(operatorEnum.DIVIDE.getSymbol2()))) {
                                    System.out.println("0으로는 나눌 수 없습니다. 다시 입력해 주세요.");
                                    scan.nextLine();
                                    continue;
                                }
                                num02 = Integer.parseInt(userNum02); // 입력된 값이 0일 경우 0.0으로 입력될 가능성 제로라고 보고 정수 타입으로 변환
                                scan.nextLine();
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
                        } catch (Exception e) {
                            System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
                        }
                    }

                    // userStr에 입력된 사칙연산 기호와 Enum 상수에 등록된 기호 비교하여 결과 호출
                    if (userStr.equals(operatorEnum.ADD.getSymbol()) || userStr.equals(operatorEnum.ADD.getSymbol2())) {
                        System.out.println("결과: " + calculation.add(num01, num02));
                    } else if (userStr.equals(operatorEnum.MINUS.getSymbol()) || userStr.equals(operatorEnum.MINUS.getSymbol2())) {
                        System.out.println("결과: " + calculation.minus(num01, num02));
                    } else if (userStr.equals(operatorEnum.MULTIPLE.getSymbol()) || userStr.equals(operatorEnum.MULTIPLE.getSymbol2())) {
                        System.out.println("결과: " + calculation.multiple(num01, num02));
                    } else if (userStr.equals(operatorEnum.DIVIDE.getSymbol()) || userStr.equals(operatorEnum.DIVIDE.getSymbol2())) {
                        System.out.println("결과: " + calculation.divide(num01, num02));
                    }
                    break;

                case 2: // 결과값 리스트 프린트 호출하는 메서드
                    calculation.printResult();
                    break;

                case 3: // 결과값 리스트 내 가장 처음 입력된 결과값 삭제 메서드
                    calculation.deleteResult();
                    break;

                case 4:
                    try { // 비교값 입력할 때, 숫자 이외의 값 입력 시 발생하는 예외 처리
                        System.out.print("값 입력: ");
                        Double compareNum = scan.nextDouble();
                        System.out.print("입력값 보다 큰 결과값: ");
                        calculation.bigNum(compareNum);
                    } catch (InputMismatchException e) {
                        System.out.println("잘못 입력하셨습니다. 번호를 입력해 주세요.");
                        scan.nextLine();
                    }
                    break;

                case 5: // 나가기 버튼
                    System.exit(0);
            }
        }
    }
}
