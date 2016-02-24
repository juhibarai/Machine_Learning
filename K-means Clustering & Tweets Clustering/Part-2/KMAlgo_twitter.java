import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

public class KMAlgo_twitter {
	

	static String initialSeedsFile ="";
	static String TweetsDataFile ="";
	static String outputFile ="";
	static int clusterNum=0;
	static ArrayList<Long> cpInitial= new ArrayList<Long>();
	static ArrayList<Tdata> dataInput= new ArrayList<Tdata>();
	ArrayList<tCluster> tCluster;
	
	public KMAlgo_twitter() {
		// TODO Auto-generated constructor stub
		this.tCluster = new ArrayList<>();    	
	}

	public void errorSSE()
	{
	 double errorFinal = 0;
	  double clusterError=0;
	  
	  double diff=0;
	  
	 for (tCluster cse:tCluster)
	 {
		 Tdata coc=cse.getCentroid();
		 ArrayList<Tdata> pSSE=cse.getPoints();
		 for(Tdata pse:pSSE)
		 {
			 diff= Tdata.jaccardDistance(pse, cse.getCentroid());
			 clusterError+=Math.pow(diff,2);
		 }
		 
	 }
	 
	  

	 System.out.println("SSE value:"+ clusterError );
	 
	}
	
	
	public void inputRead()throws JSONException, FileNotFoundException
	{
		//JSON to String List
		BufferedReader br = new BufferedReader(new FileReader(TweetsDataFile));
		try
		{
			
			String inputRec = "";
			while((inputRec=br.readLine())!=null)
			{
				JSONObject ObjValue = new JSONObject(inputRec);
				String tweet = ObjValue.getString("text");
				long dataId = ObjValue.getLong("id");
				Tdata t1=new Tdata(dataId,tweet);
				
				dataInput.add(t1);

			}
			
		}	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
	}//inputRead

	
	public void initialCentRead() throws FileNotFoundException
	{
		BufferedReader br = new BufferedReader(new FileReader(initialSeedsFile));
		try
		{
			
			String inputRec = "";
			while((inputRec=br.readLine())!=null)
			{
				

				String[] splitline = inputRec.split(",");
				cpInitial.add(Long.parseLong(splitline[0]));
			}
			
			
		}//try	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
		for(int i=0;i<clusterNum;i++)
		{
			Tdata im = new Tdata();
			
			tCluster tc=new tCluster(i);
			long cid=cpInitial.get(i);
		
			for (Tdata tp: dataInput)
			{
				if(tp.getTweid()==cid)
				{
					im.setTweid(tp.getTweid());
					im.setTData(tp.getTData());
					break;
				}
			}
			Tdata intialcentroid = new Tdata(im.getTweid(),im.getTData());
			
			tc.setCentroid(intialcentroid);
			tCluster.add(tc);
		}
		
		
		
	}	
	
	public void allocateCluster()
	  { 	
	        double max = Double.MAX_VALUE;
	        double min = max; 
	        int id_cust = -1;                 
	        double dist = 0.0; 
	        
	        for(Tdata pa: dataInput)
	        {
	        	min = max;
	            for(int i = 0; i < clusterNum; i++)
	            {
	            	tCluster c = tCluster.get(i);
	                dist = Tdata.jaccardDistance(pa, c.getCentroid());
	                if(dist < min){
	                    min = dist;
	                    id_cust = i;
	                }
	            }
	            pa.setCluster(id_cust);
	            tCluster.get(id_cust).addPoint(pa);
	        }
	    }
	
	
	
	public void kMeansTweetsAlgo()
	{
		boolean convergeFlag=false;
		int itrCount=0;
		
			
		ArrayList<Tdata>finalCent=centroidSeek();
			
			for(tCluster cc1 : tCluster) 
					cc1.clear();	

			allocateCluster();
	
			centroidEvaluate();
	}
	
	
	public void clusterDetails()
	{	
	 
	try
	{
		File opfile = new File(outputFile);

		
		if (!opfile.exists())
			opfile.createNewFile();
		
		FileWriter fw = new FileWriter(opfile.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		String heading="Cluster Id	"+"\t"+"List of point ids in cluster";
		bw.write(heading);
		 bw.newLine();
		for(tCluster cpi: tCluster)
		 	{
				 StringBuffer datapts =new StringBuffer();
				 int cid=cpi.getClusterId()+1;
				 ArrayList<Tdata> pCluster=cpi.getPoints();
				 for(Tdata p2:pCluster)
					  {
						  long pid=p2.getTweid();
						  datapts.append(Long.toString(pid));
						  datapts.append(",");
						 
					  }
						  
					System.out.print("Cluster id :"+cid +"\t" +datapts);
					 System.out.println();
					 bw.write(cid +"\t\t" +datapts);
					 bw.newLine();
				 }
		bw.close();
		
	}
	
	catch (IOException e) {
		e.printStackTrace();
	}
	
	}//clusterDetails

	
	
	public void centroidEvaluate()
{
    for(tCluster rc : tCluster)
    {
      	ArrayList<Distance> md=new ArrayList<Distance>();
    	double max = Double.MAX_VALUE;
        double min = max;
        double min1=max;
    	double diff = 0;
            long newCentroidId=0;
            String newCentroidData=" ";
            ArrayList<Tdata> pointsInCluster = rc.getPoints();
            int noOfpoints = pointsInCluster.size();
            
            for(int i=0;i<noOfpoints;i++)
            {
            	Tdata dataptsList=pointsInCluster.get(i);
            	
            	
            	for(int j=i+1;j<noOfpoints;j++)
            	{
            		
                 	Tdata p2=pointsInCluster.get(j);
                	diff=Tdata.jaccardDistance(dataptsList,p2);
                	
                	
                	if(diff<min1)
                	{
                		min1=diff;
                		
                	}
                	
                	
            	}
              	Distance md1=new Distance(diff,dataptsList.getTweid());
            	md.add(md1);  	
            	
            }//i
         
     	  	for(Distance d3:md)
          	{
          	}
     	   
     	  
     	  	
     	   for(Distance d1: md)
            {
           	
           	 if(d1.getDiff()<min)
           	 {
           		 min=d1.getDiff();
           		 newCentroidId=d1.getID1();
           	 }
            }
    
    
    
    }//cluster
    
}//centroidEvaluate

	 
	public ArrayList<Tdata> centroidSeek()
	{	ArrayList<Tdata> dataptsList= new ArrayList<Tdata>(clusterNum);
		for(tCluster  cst1 :tCluster)
		{  Tdata temp=cst1.getCentroid();
			long pcid=temp.getTweid();
			Tdata lastp=new Tdata(pcid,temp.getTData());
			dataptsList.add(lastp);
			
		}
		return dataptsList;	
	}
	
	public static void main (String[] args)
	{
		
		if(args.length!=4)
		{System.out.println("ERROR ! - Invalid/Incorrect Input Parameter Format !! ");
		System.exit(0);

		}
		else
		{
			clusterNum=Integer.parseInt(args[0]);
			initialSeedsFile=args[1];
			TweetsDataFile=args[2];
			outputFile=args[3];
		}//else	
		KMAlgo_twitter km_twitter=new KMAlgo_twitter();
		try
		{		km_twitter.inputRead();
				km_twitter.initialCentRead();
				km_twitter.kMeansTweetsAlgo();
				km_twitter.clusterDetails();
				km_twitter.errorSSE();
		}
			
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
}
}//main class

