package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
	
	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];
	
	public TileManager(GamePanel gp)
	{
		this.gp = gp;
		
		tile = new Tile[20]; 
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		// Do not load a map here; let GamePanel control which map is loaded
	}
	
	public void getTileImage()
	{
		try {
			
			//loading each texture into an array
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
			tile[1].collision = true;
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));

			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
			tile[4].collision = true;
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
			
			tile[6] = new Tile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/cactus.png"));
			tile[6].collision = true;
			
			tile[7] = new Tile();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/snow.png"));
			
			tile[8] = new Tile();
			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/ice.png"));
			
			tile[9] = new Tile();
			tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/snowyTree.png"));
			tile[9].collision = true;

			tile[10] = new Tile();
			tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/lava.png"));
			tile[10].collision = true;	
			
			tile[11] = new Tile();
			tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/magma.png"));

			tile[12] = new Tile();
			tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wood.png"));

			tile[13] = new Tile();
			tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/metal.png"));
			tile[13].collision = true;

			tile[14] = new Tile();
			tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/brick.png"));
			tile[14].collision = true;

			tile[15] = new Tile();
			tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/floor.png"));

			tile[16] = new Tile();
			tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/glass.png"));
			tile[16].collision = true;

			
		}catch(IOException e) {
			
			e.printStackTrace();
		}
	}
	public void loadMap(String filePath)
	{
		try {
			
			//importing txt file
			InputStream is = getClass().getResourceAsStream(filePath);
			//reading the text file
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			//iterates through text file and stores values into an array
			while(col < gp.maxWorldCol && row < gp.maxWorldRow)
			{
				String line = br.readLine();
				
				while(col < gp.maxWorldCol)
				{
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}
				
				if(col == gp.maxWorldCol)
				{
					col = 0;
					row++;
				}
				
			}
			
			br.close();
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	public void draw(Graphics2D g2)
	{
		for (int row = 0; row < gp.maxWorldRow; row++) {
			for (int col = 0; col < gp.maxWorldCol; col++) {
				int tileNum = mapTileNum[col][row];
				int x = col * gp.tileSize;
				int y = row * gp.tileSize;
				g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
			}
		}
	}
}


