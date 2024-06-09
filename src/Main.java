import Models.Editorial;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        Editorial editorial = new Editorial();
        //editorial.CreateAndSave();
        System.out.println("------------------");
        editorial.ShowList();
        System.out.println("------------------");
        editorial.JsonToList();
        System.out.println("------------------");
        editorial.DeleteInJson(" Anteojito ");
    }

}