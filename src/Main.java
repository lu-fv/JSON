import Models.Editorial;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        Editorial editorial = new Editorial();
        //editorial.CreateAndSave();
        System.out.println("------MUESTRA LISTA------------");
        editorial.ShowList();
        System.out.println("-------JSON-----------");
        editorial.JsonToList();
        System.out.println("------------------");
        editorial.DeleteInJson(" Billiken ");
    }

}