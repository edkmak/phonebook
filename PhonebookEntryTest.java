/*Edwin Mak
 * This contains the a test case to test the
 * PhonebookEntry class.
 */

package phonebook;
import junit.framework.TestCase;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Assert;
import org.junit.Test;


public class PhonebookEntryTest extends TestCase{
	
	//test the constructor
	@Test
	public void testConstructor() throws Exception{
		new PhonebookEntry("Sam Smith", "192-398-3928");
		new PhonebookEntry("Jerry Jones", "192-328-3928");
		new PhonebookEntry("Raymond green", "192-328-3928");
		new PhonebookEntry("Dan", "192-928-3928");
		new PhonebookEntry("Stan L", "1929283928");
	}
	
	//test IllegalArgumentException for valid phone number
	@Test
	public void testIllegalArgumentException() throws Exception {
		try {
			new PhonebookEntry("Sam Smith", "192-9328-3928");
		    fail( "Missing exception" );
		} catch( IllegalArgumentException e ) {
		     assertEquals( "Phone number must be 10 digits long", e.getMessage() ); 
		}
	}
	
	//test IllegalArgumentException for valid name
	@Test
	public void testIllegalArgumentException2() throws Exception {
		try {
			new PhonebookEntry("S@m Smith&*", "192-328-3928");
		    fail( "Missing exception" );
		} catch( IllegalArgumentException e ) {
		     assertEquals( "Name must contain only alphabetic characters", e.getMessage() ); 
		}
	}
	
	//test equals method
	@Test
	public void testEquals() throws Exception{
		PhonebookEntry s1 = new PhonebookEntry("Steven Gale", "715-983-2938");
		PhonebookEntry sameNameSameNumNoDashes = new PhonebookEntry("Steven Gale", "7159832938"); 
		Assert.assertTrue(!s1.equals(null));
	    Assert.assertEquals(s1, s1);//test against itself
	    Assert.assertEquals(s1, sameNameSameNumNoDashes);
	    
	    PhonebookEntry diffNamediffNum = new PhonebookEntry("Stan Lee", "715-983-2938");
	    Assert.assertThat(s1, not(diffNamediffNum));
	    
	    PhonebookEntry sameNamediffNum = new PhonebookEntry("Steven Gale", "415-000-2938");
	    Assert.assertThat(s1, not(sameNamediffNum));
	    
	    PhonebookEntry sameNameSpacediffNum = new PhonebookEntry("StevenGale", "715-983-2938");
	    Assert.assertThat(s1, not(sameNameSpacediffNum));
	}
	
	 //test the toString method
	 @Test
	  public void testToStringSimple() throws Exception {
		 PhonebookEntry p = new PhonebookEntry("Sam Smith", "192-398-3928");
		 PhonebookEntry sameNameSameNumNoDashes = new PhonebookEntry("Sam Smith", "1923983928");
		 Assert.assertEquals(p.toString(), "Sam Smith : 192-398-3928");
		 Assert.assertEquals(sameNameSameNumNoDashes.toString(), "Sam Smith : 192-398-3928");

	  }
	
}
