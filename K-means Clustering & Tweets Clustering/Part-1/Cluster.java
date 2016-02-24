
import java.util.ArrayList;
import java.util.List;
 
public class Cluster {
	
	public ArrayList<DataPoints> points;
	public DataPoints centroid;
	public int id;
	
	//Creates a new Cluster
	public Cluster(int id) {
		this.id = id;
		this.points = new ArrayList<DataPoints>();
		this.centroid = null;
	}
 
	public ArrayList<DataPoints> getPoints() {
		return points;
	}
	
	public void addPoint(DataPoints point) {
		points.add(point);
	}
 
	public void setPoints(ArrayList<DataPoints> points) {
		this.points = points;
	}
 
	public DataPoints getCentroid() {
		return centroid;
	}
 
	public void setCentroid(DataPoints centroid) {
		this.centroid = centroid;
	}
	
	public int getClusterId() {
		return id;
	}
	
	public void clear() {
		points.clear();
	}
 
}