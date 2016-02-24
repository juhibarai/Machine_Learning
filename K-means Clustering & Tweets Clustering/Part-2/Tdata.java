

public class Tdata {
	
	long  tid =0;
	String tData="";
	int clusterNumber=-1;

	public Tdata() {
		// TODO Auto-generated constructor stub
	}
	
	public Tdata(long tid,String tData ) 
	{
		this.setTweid(tid);
		this.setTData(tData);
	}
	
	public Tdata(long tid,String tData, int cid ) 
	{
		this.setTweid(tid);
		this.setTData(tData);
		this.setCluster(cid);
	}
	
	
	
	  
    public void setTData(String tData) 
    {
        this.tData = tData;
    }
    public long getTweid()  
	{
        return this.tid;
    }
    public void setTweid(long tid)  
    {
         this.tid=tid;
    }
    
    public String getTData()  
    {
        return this.tData;
    }
    
    
   public void setCluster(int n) {
       this.clusterNumber = n;
    }
    
    public int getCluster() {
        return this.clusterNumber;
    }
    
    
    public static int similarity(String td1, String td2)
	{

		String[] data1 = td1.split(" ");
		String[] data2 = td2.split(" ");
		int count = 0;
		for(int i=0;i<data1.length;i++)
		{
			String d = data1[i];
			for(int j=0;j<data2.length;j++)
			{
				if(d.equalsIgnoreCase(data2[j]))
				{
					count++;
					break;
				}
			}
		}
		return count;
	}
    
    
    
    protected static double jaccardDistance(Tdata p1, Tdata p2)
    {
    double distnc =0;
    String w1=p1.getTData();
    String w2=p2.getTData();
    double intersection=similarity(w1,w2)* 1.0;
    String[] l1=w1.split(" ");
    String[] l2=w2.split(" ");
    double union =((l1.length + l2.length )*1.0 )-intersection;
    double jaccardCoefficient= intersection/union;
    distnc=1-jaccardCoefficient;
    distnc = Math.round(distnc * 10000) / 10000.0;
    return distnc;
    
    }
    

    
	
	
	
	
}
