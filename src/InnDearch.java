import java.util.Scanner;

public class InnDearch {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter INN: ");
        String inn = scanner.nextLine();

        if (validateInn(inn)) {
            // код для добавления поиска по ИНН
            System.out.println("Добавлен поиск по ИНН: " + inn);
        } else {
            System.out.println("Неверный ИНН");
        }

    }

    public static boolean validateInn(String inn) {

        if (inn.length() != 10 && inn.length() != 12) {
            return false;
        }

        int[] coefficients = {2, 4, 10, 3, 5, 9, 4, 6, 8};
        int sum = 0;

        for(int i = 0; i < inn.length() - 1; i++) {
            int digit = Character.getNumericValue(inn.charAt(i));
            sum += digit * coefficients[i];
        }

        int lastDigit = Character.getNumericValue(inn.charAt(inn.length()-1));
        int controlSum = sum % 11 % 10;

        return controlSum == lastDigit;
    }

}