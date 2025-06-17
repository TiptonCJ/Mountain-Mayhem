package entity;

public class MapInfo {
    private String mapName;
    private int enemyCount;
    private int pickupCount;
    private String layoutFile;

    public MapInfo(String mapName, int enemyCount, int pickupCount, String layoutFile) {
        this.mapName = mapName;
        this.enemyCount = enemyCount;
        this.pickupCount = pickupCount;
        this.layoutFile = layoutFile;
    }

    public String getMapName() {
        return mapName;
    }

    public int getEnemyCount() {
        return enemyCount;
    }

    public int getPickupCount() {
        return pickupCount;
    }

    public String getLayoutFile() {
        return layoutFile;
    }

    @Override
    public String toString() {
        return "MapInfo{" +
                "mapName='" + mapName + '\'' +
                ", enemyCount=" + enemyCount +
                ", pickupCount=" + pickupCount +
                ", layoutFile='" + layoutFile + '\'' +
                '}';
    }
}
