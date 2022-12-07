package macera_oyunu;

public class Player {
    int damage;
    int health;
    int money;
    String name;
    private String charName;

    public Player(String name) {
        this.name=name;
    }

    public Player(int damage, int healtly, int money, String name) {
        this.damage = damage;
        this.health = healtly;
        this.money = money;
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealtly() {
        return health;
    }

    public void setHealtly(int healtly) {
        this.health = healtly;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public void selectChar(){
    Samurai sam = new Samurai();

 }
}
