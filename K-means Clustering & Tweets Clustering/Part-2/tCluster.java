import java.util.ArrayList;

public class tCluster {

	public ArrayList<Tdata> points;
	public Tdata centroid;
	public int id;
	
	//Creates a new Cluster
	public tCluster(int id) {
		this.id = id;
		this.points = new ArrayList<Tdata>();
		this.centroid = null;
	}
 
	
	public void setPoints(ArrayList<Tdata> points) {
		this.points = points;
	}
 
	public Tdata getCentroid() {
		return centroid;
	}
 
	public void setCentroid(Tdata centroid) {
		this.centroid = centroid;
	}
	public ArrayList<Tdata> getPoints() {
		return points;
	}
	
	public void addPoint(Tdata point) {
		points.add(point);
	}
 
 
	
	public int getClusterId() {
		return id;
	}
	
	public void clear() {
		points.clear();
	}



}
