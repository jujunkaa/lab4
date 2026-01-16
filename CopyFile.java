import java.io.*;
import java.util.Scanner;

public class CopyFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            String name1 = scanner.nextLine();
            String name2 = scanner.nextLine();
        try (FileInputStream file1 = new FileInputStream(name1); FileOutputStream file2 = new FileOutputStream(name2)) {
            
            int n;
            while ((n = file1.read()) != -1) {
                file2.write(n);
            }
            System.out.println("File copied successfully");
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка во время открытия файла: " + e.getMessage());
        } catch (SecurityException e) {
            System.out.println("Ошибка безопасности: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода при копировании");
        } finally {
            scanner.close();
            System.out.println("Programm is done");
        }
    }
}