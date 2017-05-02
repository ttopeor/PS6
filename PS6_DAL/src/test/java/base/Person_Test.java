package base;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {
	
	
	
	static PersonDomainModel YueFeng;
	static PersonDomainModel WeichengHuang;
	static UUID YueFengUUID = UUID.randomUUID();
	static UUID WeichengHuangUUID = UUID.randomUUID();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		YueFeng = new PersonDomainModel();
		YueFeng.setFirstName("Yue");
		YueFeng.setLastName("Feng");
		YueFeng.setBirthday(LocalDate.of(1994, 04, 10));
		YueFeng.setCity("Elkton");
		YueFeng.setPostalCode(21092);
		YueFeng.setStreet("508 Stonegate blvd");
		YueFeng.setPersonID(YueFengUUID);

		
		WeichengHuang = new PersonDomainModel();
		WeichengHuang.setFirstName("Weicheng");
		WeichengHuang.setLastName("Huang");
		WeichengHuang.setBirthday(LocalDate.of(1993, 12, 21));
		WeichengHuang.setCity("Newark");
		WeichengHuang.setPostalCode(19711);
		WeichengHuang.setStreet("613s twin lakes blvd");
		WeichengHuang.setPersonID(YueFengUUID);

		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		PersonDAL.deletePerson(YueFengUUID);
		PersonDAL.deletePerson(WeichengHuangUUID);
		
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	

	@Test
	public void addgetPersonTest() {
		
		PersonDAL.addPerson(WeichengHuang);
		String LastName1 = WeichengHuang.getLastName();
		assertEquals("Huang", LastName1);
		
		
		PersonDAL.addPerson(YueFeng);
		String LastName2 = YueFeng.getLastName();
		assertEquals("Feng", LastName2);
		}
	
	@Test
	public void UpdatePersonTest() {
		WeichengHuang.setLastName("Feng");
		PersonDAL.updatePerson(WeichengHuang);
		String LastName = WeichengHuang.getLastName();
		assertEquals("Feng", LastName);
		
	}
	@Test
	
	public void deletePersontest() {
		PersonDAL.addPerson(YueFeng);
		PersonDAL.addPerson(WeichengHuang);
		
		PersonDAL.deletePerson(YueFengUUID);
		PersonDAL.deletePerson(WeichengHuangUUID);
		
		YueFeng = PersonDAL.getPerson(YueFeng.getPersonID());		
		assertNull(PersonDAL.getPerson(YueFengUUID));	
		
		WeichengHuang = PersonDAL.getPerson(WeichengHuang.getPersonID());		
		assertNull(PersonDAL.getPerson(WeichengHuangUUID));	
		
	}
		
}
