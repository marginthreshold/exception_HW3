import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        User parsedUser = parseUserInput();
        createFile(parsedUser);
    }

    public static void createFile(User user) {

        File file = new File(user.getSecondName() + ".txt");

        try (PrintStream printStream = new PrintStream(new FileOutputStream(file, true))) {
            if (!file.exists()) {
                file.createNewFile();
            }
            printStream.println(user.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static boolean checkUserInput(int count) {
        if (count != 6) {
            String msg = "Вы ввели " + count + " параметров вместо требуемых ";
            if (count < 6)
                msg += ", это меньше 6";
            else
                msg += ", это больше 6";
            System.out.print(msg);
            return false;
        } else {
            return true;
        }
    }

    public static char parseGender(char gender) throws ParseException {
        switch (gender) {
            case 'm':
                return 'm';
            case 'f':
                return 'f';
            default:
                throw new ParseException("Неверный пол", 0);
        }
    }

    public static Date parseDate(String dateStr) throws ParseException {
        SimpleDateFormat sdf;
        Date date;
        try {
            sdf = new SimpleDateFormat("dd/MM/yyyy");
            date = sdf.parse(dateStr);
            return date;
        } catch (ParseException e) {
            System.out.println("Неверный формат даты");
        }
        return null;
    }

    public static User parseUserInput() throws ParseException, NumberFormatException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО, дату рождения (dd/MM/yyyy), номер телефона и пол(м/ж) через пробел: ");
        String[] input = scanner.nextLine().split(" ");
        char gender;
        Long phoneNumber;
        Date dateOfBirth;
        User user;

        if (input.length != 6) {
            checkUserInput(input.length);
            user = parseUserInput();
            return user;
        } else {
            try {
                gender = parseGender(input[5].charAt(0));
                phoneNumber = Long.parseLong(input[4]);
                dateOfBirth = parseDate(input[3]);
                user = new User(input[0], input[1], input[2], dateOfBirth, phoneNumber, gender);
                return user;
            } catch (ParseException e) {
                e.printStackTrace();
                user = parseUserInput();
                return user;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                user = parseUserInput();
                return user;
            }
        }
    }
} 