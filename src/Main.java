import java.util.Scanner;

class Main {
    public static void main(String[] args) throws AnyOperationExeption{
        Scanner scanner = new Scanner(System.in);
        String virazhenie = scanner.nextLine().trim();

        String operation = "";

        String s = "+";
        String v = "/";
        String u = "*";
        String d = "-";

        String virazhenie2 = new String();

        int[] numbersofoperations = {s.codePointAt(0), v.codePointAt(0), u.codePointAt(0), d.codePointAt(0)};

        int opers = 0;
        for (int element: numbersofoperations) {
            if (virazhenie.indexOf(element) != -1){
                String razdel = "" + element;
                switch (element) {
                    case 42:
                        operation = "[*]";
                        break;
                    case 43:
                        operation = "[+]";
                        break;
                    case 47:
                        operation = "/";
                        break;
                    case 45:
                        operation = "-";
                        break;
                }
                opers = opers + 1;
                virazhenie2= virazhenie.replaceAll("[+]]", "+");
                virazhenie2= virazhenie.replaceAll("[*]]", "*");

            }
        }

        if (opers == 0){
            throw new AnyOperationExeption(" т.к. строка не является математической операцией");
        } else if (opers > 1) {
            throw new AnyOperationExeption(
                    "т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        String [] operNumbersString = virazhenie2.split(operation);

        int [] operNumbersInt = new int[2];

        for (int i = 0; i < 2; i++){

            int number;

                number = Integer.parseInt(operNumbersString[i].trim());


            if (number < 1 || number > 10){
                throw new AnyOperationExeption("Ввведено некорректное число, допустимы числа от '1' до '10'");
            } else {
                operNumbersInt[i] = number;
            }
        }
        //все исключения отработали, считаем

        int rez = 0;
        switch (operation){
            case "[+]":
                rez = operNumbersInt[0] + operNumbersInt[1];
                new Sout(rez);
                break;
            case "-":
                rez = operNumbersInt[0] - operNumbersInt[1];
                new Sout(rez);
                break;
            case "[*]":
                rez = operNumbersInt[0] * operNumbersInt[1];
                new Sout(rez);
                break;
            case "/":
                rez = operNumbersInt[0] / operNumbersInt[1];
                new Sout(rez);
                break;
        }
    }
}
class AnyOperationExeption extends Exception{
    AnyOperationExeption(String textMassage) {
        super(textMassage);
    }
}

class Sout{
    Sout(int out){
        System.out.println(out);
    }
}
