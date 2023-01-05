import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        String data = inputData();
        String[] array = data.split(" ");
        System.out.println(Arrays.toString(array));
        if (array.length != 6) {
            throw new Exception("заполни форму нормально!!!");
        }
        String surname = array[0];
        String name = array[1];
        String name2 = array[2];
        String bd = array[3];
        Long phone;
        Date date1;

        try {
            phone = Long.valueOf(array[4]);
        } catch (Exception e) {
            throw new Exception("введите телефон цифрами");
        }
        String gender = array[5];
        if (!gender.equals("f") && !gender.equals("m")) {
            throw new Exception("определитесь между \"f\" и \"m\"");
        }
        try {
            date1 = new SimpleDateFormat("dd.MM.yyyy").parse(bd);
        } catch (Exception e) {
            throw new Exception("дата не правильно");
        }
        try {
        createFile(surname, name, name2, bd, phone, gender);
        } catch (Exception e) {
            throw new Exception("ошибка работы с файлом");
        }
    }

    public static void createFile(String surname, String name, String name2, String bd, long phone, String gender) throws Exception {

        File itog = new File("C:\\Users\\Alena\\Desktop\\гикбрейнс\\исключения\\itogovaja\\"+ surname+".txt");
        if (!itog.exists()) {
            itog.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(itog,true));
        writer.append("<" + surname + "><" + name + "><" + name2 + "><" + bd + "><" + phone + "><" + gender + ">\n");
        writer.close();
    }
    public static String inputData() {
        String data;
        Scanner sk = new Scanner(System.in);
        System.out.print("Введите данные: ");
        data = sk.nextLine();
        return data;
    }
}
