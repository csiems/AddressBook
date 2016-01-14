import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDate;

public class ContactTest {

  @Test
  public void Contact_instantiatesCorrectly_true() {
    Contact myContact = new Contact("Joe", "Smith");
    assertEquals(true, myContact instanceof Contact);
  }

  @Test
  public void Contact_instantiatesWithFirstName_true() {
    Contact myContact = new Contact("Joe", "Smith");
    assertEquals("Joe", myContact.getFirstName());
  }

  @Test
  public void Contact_instantiatesWithLastName_true() {
    Contact myContact = new Contact("Joe", "Smith");
    assertEquals("Smith", myContact.getLastName());
  }

  @Test
  public void Contact_instantiatesWithNullMiddleInitial_true() {
    Contact myContact = new Contact("Joe", "Smith");
    assertEquals(null, myContact.getMiddleInitial());
  }

  @Test
  public void addMiddleInitial_addsMiddleInitialToContact_V() {
    Contact myContact = new Contact("Joe", "Smith");
    myContact.addMiddleInitial("V");
    assertEquals("V", myContact.getMiddleInitial());
  }

  @Test
  public void Contact_instantiatesWithNullBirthDate_true() {
    Contact myContact = new Contact("Joe", "Smith");
    assertEquals(null, myContact.getBirthDate());
  }

  @Test
  public void addBirthDate_addsBirthDateToContact_date() {
    Contact myContact = new Contact("Joe", "Smith");
    LocalDate birthday = LocalDate.of(2000,12,12);
    myContact.addBirthDate(birthday);
    assertEquals(birthday, myContact.getBirthDate());
  }

  @Test
  public void all_returnsAllInstancesOfContact_true() {
    Contact firstContact = new Contact("Joe", "Smith");
    Contact secondContact = new Contact("Jane", "Jones");
    assertTrue(Contact.all().contains(firstContact));
    assertTrue(Contact.all().contains(secondContact));
  }

  @Test
  public void newId_tasksInstantiateWithAnID_true() {
    Contact myContact = new Contact("Joe", "Smith");
    assertEquals(Contact.all().size(), myContact.getId());
  }

  @Test
  public void find_returnsContactWithSameId_secondContact() {
    Contact firstContact = new Contact("Joe", "Smith");
    Contact secondContact = new Contact("Jane", "Jones");
    assertEquals(Contact.find(secondContact.getId()), secondContact);
  }

  @Test
  public void find_returnsNullWhenNoContactFound_null() {
    assertTrue(Contact.find(999) == null);
  }

  @Test
  public void clear_emptiesAllContactsFromArrayList() {
    Contact myContact = new Contact("Joe", "Smith");
    Contact.clear();
    assertEquals(Contact.all().size(), 0);
  }

  @Test
  public void addPhone_addsPhoneToContact_true() {
    Contact myContact = new Contact("Joe", "Smith");
    Phone phone = new Phone("Work", 503, 7374894);
    myContact.addPhone(phone);
    assert(myContact.getAllPhones().contains(phone));
  }

}
