import java.io.*;
import java.util.Scanner;

class CustomFileNotFoundException extends Exception{
    public CustomFileNotFoundException(String message, String fileName) {
        super(message);
    }
}

public class Main {
    static final String excFile = "exc.txt";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        try {
            validateRead(fileName);
        } catch (CustomFileNotFoundException e) {
            System.err.println("Ошибка: " + e.getMessage());
            logExc(e);
        } finally {
            scanner.close();
        }
    }

    public static void validateRead (String fileName) throws CustomFileNotFoundException {
        File fileCheck = new File(fileName);

        if (fileCheck.exists() == false ) {
            throw new CustomFileNotFoundException("Файл не найден", fileName);
        }
        if (fileCheck.canRead() == false ) {
            throw new CustomFileNotFoundException("Отсутсвуют права на чтение файла", fileName);
        }

        try (BufferedReader file = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = file.readLine()) != null ) {
                System.out.println(line);
            }

            System.out.println("Чтение завершено");
        } catch (IOException e ) {
            System.err.println("Ошибка чтения файла" + e.getMessage());
            logExc(e);
        }
    }

    public static void logExc (Exception e) {
        try (BufferedWriter exception = new BufferedWriter(new FileWriter(excFile, true)) ) {
            exception.write("Исключение: " + e.getClass().getSimpleName() + "(" + e.getMessage() + ")\n");
        } catch (IOException ioException) {
            System.err.println("Ошибка записи в лог-файл: " + ioException.getMessage());
        }
    }
}