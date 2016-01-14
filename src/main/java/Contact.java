import java.util.ArrayList;
import java.time.LocalDate;

public class Contact{
  private String mFirstName;
  private String mMiddleInitial;
  private String mLastName;
  private LocalDate mBirthDate;
  private ArrayList<Phone> mPhones = new ArrayList<Phone>();
  private static ArrayList<Contact> contacts = new ArrayList<Contact>();
  private int mId;


  public Contact(String firstName, String lastName) {
    mFirstName = firstName;
    mLastName = lastName;
    contacts.add(this);
    mId = contacts.size();
  }

  public String getFirstName() {
    return mFirstName;
  }

  public String getMiddleInitial() {
    return mMiddleInitial;
  }

  public void addMiddleInitial(String mi) {
    mMiddleInitial = mi;
  }

  public String getLastName() {
    return mLastName;
  }

  public LocalDate getBirthDate() {
    return mBirthDate;
  }

  public void addBirthDate(LocalDate birthDate) {
    mBirthDate = birthDate;
  }

  public ArrayList<Phone> getAllPhones() {
    return mPhones;
  }

  public void addPhone(Phone phone) {
    mPhones.add(phone);
  }

  public static ArrayList<Contact> all(){
    return contacts;
  }

  public int getId(){
    return mId;
  }

  public static Contact find(int id) {
    try {
      return contacts.get(id - 1);
    } catch (IndexOutOfBoundsException oob) {
      return null;
    }
  }

  public static void clear() {
    contacts.clear();
  }

}
