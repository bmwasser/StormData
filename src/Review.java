import java.util.ArrayList;
import java.util.List;

public class Review{

    public static void main(String[] args) {
        String[][] arr = {{"A", "B", "C", "D", "E", "F"}, {"G","H","I","J","K","L"}, {"M","N","O","P","Q","R"}, {"S","T","U","V","W","X"}};
        List<String> str = new ArrayList<String>();
        for (int r = 0; r < arr.length; r++){
            for (int c = 0; c < arr[0].length; c++){
                str.add(arr[r][c]);
            }
        }
        System.out.println(str);
        List<String> str2 = new ArrayList<String>();
        for (int c = 0; c < arr[0].length; c++){
            for (int r = 0; r < arr.length; r++){
                str2.add(arr[r][c]);
            }
        }
        System.out.println(str2);
        List<String> str3 = new ArrayList<String>();
        for (int r = 0; r < arr.length; r++){
            for (int c = 0; c < arr[0].length; c++){
                if (r % 2 == 0){
                    str3.add(arr[r][c]);
                } else {
                    str3.add(arr[r][arr[0].length - 1 - c]);
                } 
            }
        }
        System.out.println(str3);
        String[][] arr2 = {{"A", "B", "C", "D"}, {"E", "F", "G","H"}, {"I","J","K","L"}, {"M","N","O","P"}, {"Q","R", "S","T"}, {"U","V","W","X"}};
        for (int c = 0; c < arr2[0].length; c++){
            for (int r = 0; r < arr2.length; r++){
                str2.add(arr[r][c]);
            }
        }
        for (String s: ArrayList<String> str2){
            
        }
    }

}