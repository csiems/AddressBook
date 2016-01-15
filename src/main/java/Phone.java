import java.util.ArrayList;

public class Phone {
  private String mType;
  private int mAreaCode;
  private int mMainNumber;

  public Phone(String type, int areaCode, int mainNumber) {
    mType = type;
    mAreaCode = areaCode;
    mMainNumber = mainNumber;
  }

    public String getPhoneType() {
      return mType;
    }

    public Integer getAreaCode() {
      return mAreaCode;
    }

    public Integer getMainNumber() {
      return mMainNumber;
    }
}
