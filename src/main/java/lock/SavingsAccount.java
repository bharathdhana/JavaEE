package lock;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SavingsAccount {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accNumber;
    private String accHolder;
    private double balance;

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "accNumber=" + accNumber +
                ", accHolder='" + accHolder + '\'' +
                ", balance=" + balance +
                '}';
    }

    public  SavingsAccount(){}

    public SavingsAccount( String accHolder, double balance) {
        this.accHolder = accHolder;
        this.balance = balance;
    }

    public long getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(long accNumber) {
        this.accNumber = accNumber;
    }

    public String getAccHolder() {
        return accHolder;
    }

    public void setAccHolder(String accHolder) {
        this.accHolder = accHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
