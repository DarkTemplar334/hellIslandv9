package gr.gcc.hellIsland.Domain;

public class Door1 {
    private int doorId;
    private boolean locked;


    public Door1(int doorId) {
        this.doorId = doorId;
    }

    public int getDoorId() {
        return doorId;
    }

    public void setDoorId(int doorId) {
        this.doorId = doorId;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked1) {
        this.locked = locked1;
    }

}
