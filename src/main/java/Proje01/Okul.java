package Proje01;

import java.util.ArrayList;
import java.util.List;

public class Okul {
    private String schoolName;
    private int maxNumberofStudents;
    private List<Ogrenci> ogrenciler = new ArrayList<>();

    public Okul(String schoolName, int maxNumberofStudents) {
        setSchoolName(schoolName);
        setMaxStudentNumber(maxNumberofStudents);
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getMaxStudentNumber() {
        return maxNumberofStudents;
    }

    public void setMaxStudentNumber(int maxStudentNumber) {
        this.maxNumberofStudents = maxStudentNumber;
    }

    public int getMaxNumberofStudents() {
        return maxNumberofStudents;
    }

    public void setMaxNumberofStudents(int maxNumberofStudents) {
        this.maxNumberofStudents = maxNumberofStudents;
    }

    public List<Ogrenci> getOgrenciler() {
        return ogrenciler;
    }

    public void setOgrenciler(List<Ogrenci> ogrenciler) {
        this.ogrenciler = ogrenciler;
    }
}
