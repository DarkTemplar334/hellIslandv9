package gr.gcc.hellIsland.Invetory;
public class Food implements Item{

    private String description;
    private int lifePoints;
    private boolean pickable;
    private boolean edible;

    public Food(String description, int lifePoints, boolean pickable, boolean edible) {
        this.description = description;
        this.lifePoints = lifePoints;
        this.pickable = pickable;
        this.edible = edible;
    }

    public String getDescription() {
        return description;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    @Override
    public boolean pickable(Item pick) {
        return true;
    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int getId(Item item) {
        return 0;
    }

    @Override
    public String getDescription(Item item) {
        return null;
    }
}
