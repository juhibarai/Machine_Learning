
public class DataPoints {


	int  id =0;
	double x=0.0;
	double y =0.0;
	int cNo=-1;
	
	DataPoints(int id,double x,double y)
	{
		this.setPId(id);
		this.setX(x);
		this.setY(y);
	
	}
	
	DataPoints()
	{}
	

	 public static DataPoints parseRecord(String infoRecord[])
	 { DataPoints ps=new DataPoints();
	 	ps.id=Integer.parseInt(infoRecord[0].trim());
	 	ps.x=Double.parseDouble(infoRecord[1].trim());
	 	ps.y=Double.parseDouble(infoRecord[2].trim());
	 	ps.cNo=-1;
	 	return  ps;
	 	}
	   
	    public int getPId()  {
	        return this.id;
	    }
	    public void setPId(int id)  {
	         this.id=id;
	    }
	  
	 
	 
	    public void setX(double x) {
	        this.x = x;
	    }
	    
	    public double getX()  {
	        return this.x;
	    }
	    
	    public void setY(double y) {
	        this.y = y;
	    }
	    
	    public double getY() {
	        return this.y;
	    }
	    
	   public void setCluster(int n) {
	       this.cNo = n;
	    }
	    
	    protected static double distance(DataPoints p, DataPoints centroid) {
	        return Math.sqrt(Math.pow((centroid.getY() - p.getY()), 2) + Math.pow((centroid.getX() - p.getX()), 2));
	    }
	    public String toString() {
	    	return "("+x+","+y+")";
	    }
	
	
	
	
	
	
}
