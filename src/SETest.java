public class SETest{
    
    public static void main(String[] args){
        StringEditor phrase = new StringEditor("i ate a pepperoni pizza");
        phrase.removeLetters("ap");
        System.out.println(phrase);

    }
}