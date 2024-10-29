import org.testng.annotations.*;

public class Selenium8 {
        // before class izvrsava se SAMO jednom i SAMO na pocetku (pre svih metoda)
    @BeforeClass
    public void method1(){
        System.out.println("---------------");
        System.out.println("OVO JE ISPIS IZ BEFORE CLASS");
        System.out.println("----------------");

    }
        // before method se izvrsava pre svake @Test anotacije
    @BeforeMethod
    public void method2() {
        System.out.println("++++++++++++++++");
        System.out.println("OVO JE ISPIS IZ BEFORE METHOD");
        System.out.println("+++++++++++++++");

    }
        // Prioriteti odredjuju kojim redosledom se izvsavaju @Test metode
    // Ako metoda nema naznacen priritet uzima se default vrednost 0
    // Prioriteti se izvrsavaju od manjeg ka vecem
    // Metode mogu imati isti prioritet
    @Test
    public void method3(){
        System.out.println("=================");
        System.out.println("TEST");
        System.out.println("==================");
    }
        //After Method se izvrsava nakon svake @Test anotacije
    @AfterMethod
    public void method4(){
        System.out.println("///////////////////");
        System.out.println("OVO JE ISPIS IZ AFTER METHOD");
        System.out.println("////////////////////");
    }
        //After Class izvrsava se SAMO jednom i SAMO na kraju klase (nakon svih metoda)
    @AfterClass
    public void method5(){
        System.out.println("....................");
        System.out.println("OVO JE ISPIS IZ AFTER CLASS");
        System.out.println(".....................");
    }
}
