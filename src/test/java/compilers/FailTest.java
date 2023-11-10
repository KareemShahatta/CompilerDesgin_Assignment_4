package compilers;

import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


/**
 *
 * @author richardburns
 */
@RunWith(value = Parameterized.class)
public class FailTest {

    @Parameter
    public String filePath;

    @Parameters(name = "{index}: testFile - {0}")
    public static Object[] data() {
        return new Object[] {
            "src/test/java/compilers/test_programs/fail/Array.ram23",
            "src/test/java/compilers/test_programs/fail/ParsePass2.ram23",
            "src/test/java/compilers/test_programs/fail/pass1.ram23",
            "src/test/java/compilers/test_programs/fail/Sigma.ram23"
        };
    }


    @Test
    public void runFailTests() {
        try {
            String args[] = {filePath};
            // RamParser.main(args);
            // fail("expected parser to throw an exception and it didn't");
            Ram23Compiler.main(args);
            fail("expected front end to throw an exception and it didn't");
        } catch (ParseException e) {
            ;  // do nothing
            System.out.println(e);
        } catch (TokenMgrError e) {
            ;  // do nothing
            System.out.println(e);
        } catch (Exception e) {   // fail on an exception that we didn't except
            fail(e.toString());
        }
    }


}
