package test.com.cuongnt.utils;

import com.cuongnt.utils.Utils;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * Utils Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Feb 1, 2018</pre>
 */
public class UtilsTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: validatePhoneNumber(String phoneNumber)
     */
    @Test
    public void testValidatePhoneNumber() throws Exception {
        assertEquals(true, Utils.validatePhoneNumber("0987654321"));
    }
} 
