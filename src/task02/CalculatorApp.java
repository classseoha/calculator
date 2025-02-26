package task02;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {

        Calculation calculation = new Calculation();
        Scanner scan = new Scanner(System.in);
        int select = 0;

        while (true) {
            System.out.println();
            System.out.println("######## 양의 정수 계산기 ########");
            System.out.println("1. 계산기 사용 \n2. 결과값 조회 \n3. 결과값 삭제 \n4. 프로그램 종료");
            System.out.print("번호 선택: ");
            select = scan.nextInt();


            switch (select) {
                case 1:
                    int num01 = 0;

                    while (true) {
                        System.out.print("첫번째 정수 입력: ");
                        String userNum01 = scan.next();

                        try {
                            if (userNum01.equalsIgnoreCase("exit")) {
                                System.out.println("프로그램을 종료합니다.");
                                scan.close();
                                System.exit(0);
                            }

                            num01 = Integer.parseInt(userNum01);

                            if (num01 >= 0) {
                                scan.nextLine();
                                break;
                            } else {
                                System.out.println("정수를 입력해 주세요.");
                                scan.nextLine();
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
                        } catch (Exception e) {
                            System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
                        }
                    }

                    String userStr;

                    while (true) {
                        System.out.print("사칙연산 기호 입력: ");
                        userStr = scan.next();

                        if (userStr.equals("+") || userStr.equals("-") || userStr.equals("×") || userStr.equals("÷")) {
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

                    int num02 = 0;

                    while (true) {
                        System.out.print("두번째 정수 입력: ");
                        String userNum02 = scan.next();

                        try {
                            if (userNum02.equalsIgnoreCase("exit")) {
                                System.out.println("프로그램을 종료합니다.");
                                scan.close();
                                System.exit(0);
                            }

                            num02 = Integer.parseInt(userNum02);

                            if (userStr.equals("÷") && num02 == 0) {
                                System.out.println("0으로는 나눌 수 없습니다. 다시 입력해 주세요.");
                            } else if (num02 >= 0) {
                                scan.nextLine();
                                break;
                            } else {
                                System.out.println("정수를 입력해 주세요.");
                                scan.nextLine();
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
                        } catch (Exception e) {
                            System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
                        }
                    }

                    if (userStr.equals("+")) {
                        System.out.println("결과: " + calculation.add(num01, num02));
                    } else if (userStr.equals("-")) {
                        System.out.println("결과: " + calculation.minus(num01, num02));
                    } else if (userStr.equals("×")) {
                        System.out.println("결과: " + calculation.multiple(num01, num02));
                    } else if (userStr.equals("÷")) {
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
                    System.exit(0);
            }
        }
    }
}
