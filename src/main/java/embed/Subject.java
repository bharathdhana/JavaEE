package embed;

import jakarta.persistence.Embeddable;

@Embeddable
public class Subject {
    private int subjId;
    private String subjname;
    private int year;

    public int getSubjId() {
        return subjId;
    }

    public void setSubjId(int subjId) {
        this.subjId = subjId;
    }

    public String getSubjname() {
        return subjname;
    }

    public void setSubjname(String subjname) {
        this.subjname = subjname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
