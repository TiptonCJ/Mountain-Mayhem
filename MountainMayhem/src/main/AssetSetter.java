package main;

import object.OBJ_BITCOIN;
import object.OBJ_PORTAL;
import object.OBJ_ENERGY;
import object.OBJ_LOCKBOX;

public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	
	public void setObject() {
		// Clear previous objects
		for (int i = 0; i < gp.obj.length; i++) {
			gp.obj[i] = null;
		}

		int objIndex = 0;
		// Only objects represent collectable bitcoins. Do not use tile[17] for bitcoin tiles.
		switch (gp.getCurrentMapIndex()) {
			case 0: // World 1: Place bitcoin on every tile with value 5
				for (int row = 0; row < gp.maxWorldRow; row++) {
					for (int col = 0; col < gp.maxWorldCol; col++) {
						if (gp.tileM.mapTileNum[col][row] == 5) {
							if (objIndex < gp.obj.length) {
								gp.obj[objIndex] = new OBJ_BITCOIN();
								gp.obj[objIndex].worldX = col * gp.tileSize;
								gp.obj[objIndex].worldY = row * gp.tileSize;
								objIndex++;
							}
						}
					}
				}
				//place lockbox
				if (objIndex < gp.obj.length) {
					gp.obj[objIndex] = new OBJ_PORTAL();
					gp.obj[objIndex].worldX = 23 * gp.tileSize;
					gp.obj[objIndex].worldY = 13 * gp.tileSize;
					objIndex++;
				}
				break;
			case 1: // World 2: Place bitcoin on every tile with value 0
				for (int row = 0; row < gp.maxWorldRow; row++) {
					for (int col = 0; col < gp.maxWorldCol; col++) {
						if (gp.tileM.mapTileNum[col][row] == 0) {
							if (objIndex < gp.obj.length) {
								gp.obj[objIndex] = new OBJ_BITCOIN();
								gp.obj[objIndex].worldX = col * gp.tileSize;
								gp.obj[objIndex].worldY = row * gp.tileSize;
								objIndex++;
							}
						}
					}
				}
				// Place lockbox as example
				if (objIndex < gp.obj.length) {
					gp.obj[objIndex] = new OBJ_LOCKBOX();
					gp.obj[objIndex].worldX = 20 * gp.tileSize;
					gp.obj[objIndex].worldY = 10 * gp.tileSize;
					objIndex++;
				}
				break;
			default:
				// No objects for unknown maps
				break;
		}
	}
	
	
	
}
