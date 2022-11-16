package Okul_Projesi;

public class Ogrenci {
    private String name;
    private String surname;
    private int age;

    public Ogrenci(String name, String surname, int age) {
        setName(name);
        setSurname(surname);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }


    public void setAge(int age){
        if (age>15){
            throw new RuntimeException("Kayit icin yas siniri 15 dir!");
        }this.age=age;
    }

    @Override
    public String toString() {
        return "Ogrenci{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
