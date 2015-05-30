package demo.domain;

/**
 * Created by jwillard on 5/30/2015.
 */
public class User {

     public String name;
     public String phone;
     public String donationAmount;
     public String isRecurring;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(String donationAmount) {
        this.donationAmount = donationAmount;
    }

    public String getIsRecurring() {
        return isRecurring;
    }

    public void setIsRecurring(String isRecurring) {
        this.isRecurring = isRecurring;
    }
}
