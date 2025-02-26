package task01;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("######## 양의 정수 계산기 ########");
        System.out.println("'exit' 입력 시 시스템이 종료됩니다.");

        while (true) {
            String userNum01;
            int num01 = 0;

            while (true) {
                try {
                    System.out.println("첫번째 정수 입력: ");
                    userNum01 = scan.next();

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
                        System.out.println("0보다 작은 값은 입력할 수 없습니다. 다시 입력해 주세요.");
                        scan.nextLine();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("정수를 입력해 주세요.");
                    scan.nextLine();
                } catch (Exception e) {
                    System.out.println("정수를 입력해 주세요.");
                    scan.nextLine();
                }
            }

            String userStr = "";

            while (true) {
                System.out.println("사칙연산 기호 입력: ");
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

            String userNum02;
            int num02 = 0;

            while (true) {
                try {
                    System.out.println("두번째 정수 입력: ");
                    userNum02 = scan.next();

                    if (userNum02.equalsIgnoreCase("exit")) {
                        System.out.println("프로그램을 종료합니다.");
                        scan.close();
                        System.exit(0);
                    }

                    num02 = Integer.parseInt(userNum02);

                    if (!userStr.equals("÷") && num02 >= 0) {
                        scan.nextLine();
                        break;
                    } else if (userStr.equals("÷") && num02 == 0) {
                        System.out.println("0으로 나눌 수 없습니다. 다시 입력해 주세요.");
                        scan.nextLine();
                    } else if (num02 > 0) {
                        scan.nextLine();
                        break;
                    } else {
                        System.out.println("0보다 작은 값은 입력할 수 없습니다. 다시 입력해 주세요.");
                        scan.nextLine();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("정수를 입력해 주세요.");
                    scan.nextLine();
                } catch (Exception e) {
                    System.out.println("정수를 입력해 주세요.");
                    scan.nextLine();
                }
            }

            if (userStr.equals("+")) {
                System.out.println("결과: " + (num01 + num02));
            } else if (userStr.equals("-")) {
                System.out.println("결과: " + (num01 - num02));
            } else if (userStr.equals("×")) {
                System.out.println("결과: " + (num01 * num02));
            } else if (userStr.equals("÷")) {
                System.out.println("결과: " + (double) num01 / num02);
            }
        }

    }
}
