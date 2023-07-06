public class Toy {
    private int id;
    private String name;
    private int quantity;
    private int chance;

    @Override
    public String toString() {
        return "id: "+ this.id + "; игрушка: " + this.name + "; шанс выпадения: " + this.chance + "%";
    }

    public Toy(int id, String name, int quantity, int chance) {
        this.id = id;
        this.name = name;
        this.chance = chance;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }
}
