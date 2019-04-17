package gr.gcc.hellIsland.Invetory;
public class Key implements Item{

	private int keyId;
	private boolean pickable;

	public Key(int keyId,boolean pickable) {
		this.keyId = keyId;
		this.pickable=pickable;
	}

	public boolean isPickable(){
		return this.pickable;
	}

	@Override
	public int getId(Item item) {
		return keyId;
	}

	@Override
	public String getDescription(Item item) {
		return null;
	}


	@Override
	public boolean pickable(Item pick) {
		return isPickable();
	}

	@Override
	public int attack() {
		return 0;
	}
}
