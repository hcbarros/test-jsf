package br.com.usuarios_jsf;

import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class BaseEJBTest {

    protected static EJBContainer container;
    protected final Logger logger = Logger.getGlobal();

    @BeforeClass
    public static void setUpClass() {
        //container = EJBContainer.createEJBContainer();
        //DbUnitUtil.inserirDados();

    }

    @Test
    public void test() {
    	
    }
    
    
    @AfterClass
    public static void tearDownClass() {
        //container.close();
    }
}
