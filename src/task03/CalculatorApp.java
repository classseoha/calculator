package task03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {

        Calculation calculation = new Calculation<>();
        Scanner scan = new Scanner(System.in);

        int select = 0;
        while (true) {
            System.out.println();
            System.out.println("######## 양의 정수 계산기 ########");
            System.out.println("1. 계산기 사용 \n2. 결과값 조회 \n3. 결과값 삭제 \n4. 입력값 보다 큰 결과값 조회 \n5. 프로그램 종료");
            System.out.print("번호 선택: ");

            try {
                select = scan.nextInt();
            } catch (Exception e) {
                System.out.println("잘못 입력하셨습니다. 다시 골라주세요.");
                scan.nextLine();
                continue;
            }

            switch (select) {
                case 1:

                    Number num01;
                    while (true) {
                        System.out.print("첫번째 정수 입력: ");
                        String userNum01 = scan.next();

                        try {
                            if (userNum01.equalsIgnoreCase("exit")) {
                                System.out.println("프로그램을 종료합니다.");
                                scan.close();
                                System.exit(0);
                            }

                            if (userNum01.contains(".")) {
                                num01 = Double.parseDouble(userNum01);
                                scan.nextLine();
                                break;
                            } else {
                                num01 = Integer.parseInt(userNum01);
                                scan.nextLine();
                                break;
                            }

//                            if (num01 >= 0) {
//                                scan.nextLine();
//                                break;
//                            } else {
//                                System.out.println("정수를 입력해 주세요.");
//                                scan.nextLine();
//                            }
//                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
                        } catch (Exception e) {
                            System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
                        }
                    }

                    String userStr;
                    OperatorEnum operatorEnum = null;
                    while (true) {
                        System.out.print("사칙연산 기호 입력: ");
                        userStr = scan.next();

                        if (OperatorEnum.containSymbol(userStr)) {
                            scan.nextLine();
                            break;
                        } else if (userStr.equalsIgnoreCase("exit")) {
                            System.out.println("프로그램을 종료합니다.");
                            scan.close();
                            System.exit(0);
                        } else {
                            System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
                            scan.nextLine();
                        }
                    }

                    Number num02;
                    while (true) {
                        System.out.print("두번째 정수 입력: ");
                        String userNum02 = scan.next();

                        try {
                            if (userNum02.equalsIgnoreCase("exit")) {
                                System.out.println("프로그램을 종료합니다.");
                                scan.close();
                                System.exit(0);
                            }

                            if (userNum02.contains(".")) {
                                num02 = Double.parseDouble(userNum02);
                                scan.nextLine();
                            } else {
                                if (userNum02.equals("0") && (userStr.equals(operatorEnum.DIVIDE.getSymbol()) || userStr.equals(operatorEnum.DIVIDE.getSymbol2()))) {
                                    System.out.println("0으로는 나눌 수 없습니다. 다시 입력해 주세요.");
                                    scan.nextLine();
                                    continue;
                                }
                                num02 = Integer.parseInt(userNum02);
                                scan.nextLine();
                            }

//                            if (userStr.equals(operatorEnum.DIVIDE.getSymbol()) || userStr.equals(operatorEnum.DIVIDE.getSymbol2()) && num02.equals("0")) {
//                                System.out.println("0으로는 나눌 수 없습니다. 다시 입력해 주세요.");
//                            }
//                            else if (calculation.getNum02() >= 0) {
//                                scan.nextLine();
//                                break;
//                            } else {
//                                System.out.println("정수를 입력해 주세요.");
//                                scan.nextLine();
//                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
                        } catch (Exception e) {
                            System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
                        }
                    }

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

                case 2:
                    calculation.printResult();
                    break;

                case 3:
                    calculation.deleteResult();
                    break;

                case 4:
                    try {
                        System.out.print("값 입력: ");
                        Double compareNum = scan.nextDouble();
                        System.out.print("입력값 보다 큰 결과값: ");
                        calculation.bigNum(compareNum);
                    } catch (InputMismatchException e) {
                        System.out.println("잘못 입력하셨습니다. 번호를 입력해 주세요.");
                        scan.nextLine();
                    }
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}
