package org.example;

import jakarta.persistence.*;



@Table(name = "clients")
@NamedStoredProcedureQuery(
        name="Customer.getMonthlyIncome",
        procedureName = "client_income",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN,name="income",type=Double.class),
        },
        resultClasses = Customer.class

)
@Entity
public class Customer {

    @Column(name = "client_name")
    private String FullName;
    @Id
    @Column(name = "client_username")
    private String UserName;
    @Column(name = "client_aadhar")
    private long Aadhar;
    @Column(name = "client_email")
    private String Email;
    @Column(name = "client_income")
    private double MonthlyIncome;

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public long getAadhar() {
        return Aadhar;
    }

    public void setAadhar(long aadhar) {
        Aadhar = aadhar;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public double getMonthlyIncome() {
        return MonthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        MonthlyIncome = monthlyIncome;
    }

    public Customer(String fullName, String userName, long aadhar, String email, double monthlyIncome) {
        FullName = fullName;
        UserName = userName;
        Aadhar = aadhar;
        Email = email;
        MonthlyIncome = monthlyIncome;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "FullName='" + FullName + '\'' +
                ", UserName='" + UserName + '\'' +
                ", Aadhar=" + Aadhar +
                ", Email='" + Email + '\'' +
                ", MonthlyIncome=" + MonthlyIncome +
                '}'+"\n";
    }
}
