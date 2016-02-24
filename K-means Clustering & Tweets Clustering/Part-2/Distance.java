
public class Distance {

	double diff=0;
	long id1=0;
	public Distance() {
		// TODO Auto-generated constructor stub
	}
	
	public Distance(	double diff,long id1) 
	{
		
		// TODO Auto-generated constructor stub
		this.setDiff(diff);
		this.setID1(id1);

	}
	public double getDiff()  
	{
        return this.diff;
    }
    public void setDiff(double diff)  
    {
         this.diff=diff;
    }
    
	public long getID1()  
	{
        return this.id1;
    }
    public void setID1(long id1)  
    {
         this.id1=id1;
    }

}
