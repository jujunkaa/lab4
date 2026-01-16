public class ArrayAverage {
    public static void main(String[] args) {
        int[] arr3 = {};
        int sum = 0;
        try {
            for ( int i = 0; i < arr3.length; i++) {
                sum += arr3[i];
            }
            int result = sum/arr3.length;
            System.out.print(result);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Индекс выходит за границы массива");
        } catch (NullPointerException e) {
            System.out.println("Массив не инициализирован");
        } catch (ArithmeticException e) {
            System.out.println("Введен пустой массив - деление на ноль невозможно");
        }
    }
}