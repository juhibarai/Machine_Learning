import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KMalgo {

	
	static String fileInput ="";
	static String fileOutput ="";
	static int numCluster=0;
	static ArrayList<DataPoints> datapts= new ArrayList<DataPoints>();
	 
	ArrayList<Cluster> clusterDetailsList;

	  public KMalgo() {
	    
	    	this.clusterDetailsList = new ArrayList<>();    	
}
	  
	  
		public void evaluateSSE()
		{
			
			double errorCust=0;
			double diff=0;
	  
			for (Cluster cse:clusterDetailsList)
			{
		 DataPoints centerPt=cse.getCentroid();
		 ArrayList<DataPoints> errorpts=cse.getPoints();
		 for(DataPoints pse:errorpts)
		 {
			 diff= DataPoints.distance(pse, cse.getCentroid());
			 errorCust+=Math.pow(diff,2);
		 }
		
	     }
	 
	  System.out.println("SSE value:"+ errorCust );
	 
	}

	  
	 //Initial centroids   
	  public void initialize(ArrayList<DataPoints> dpts)
	{
	    Random randomgen = new Random();
	    int rnum=0;
		for(int i=0;i<numCluster;i++)
			{
				Cluster cl= new Cluster(i);
				rnum=randomgen.nextInt(100)+1;
				DataPoints intialcentroid=dpts.get(rnum);
				cl.setCentroid(intialcentroid);
				System.out.println("");
				clusterDetailsList.add(cl);
			}
}
	
	
	public void clusterDetails()
	{	
	 
	try
	{
		File outputfile = new File(fileOutput);

		if (!outputfile.exists())
			outputfile.createNewFile();
		
		FileWriter opw = new FileWriter(outputfile.getAbsoluteFile());
		BufferedWriter linewriter = new BufferedWriter(opw);
		
		for(Cluster temp: clusterDetailsList)
		 	{
				 StringBuffer listofPoints =new StringBuffer();
				 int cid=temp.getClusterId()+1;
				 ArrayList<DataPoints> clusterDP=temp.getPoints();
				 for(DataPoints dp:clusterDP)
					  {
						  int pid=dp.getPId();
						  if(pid!=0)
						  {
						  listofPoints.append(Integer.toString(pid));
						  listofPoints.append(",");
						  }
						  else{
							  
						  }
						  }
						  
					 System.out.print("Cluster id :"+cid +"\t" +"\t"+"Data Points : "+"\t"+listofPoints);
					 System.out.println();
					 linewriter.write(cid +"\t\t" +listofPoints);
					 linewriter.newLine();
				 }
		linewriter.close();
		
	}
	
	catch (IOException e) {
		e.printStackTrace();
	}
	
}
	
	public void KMclusteringAlgo()
	{
		boolean convergeFlag=false;
		int iterartionCount=0;
		while((iterartionCount<25) && (!convergeFlag))
		{
		ArrayList<DataPoints>lastCentroids=centroidSeek();
	
			for(Cluster clearC : clusterDetailsList) 
					clearC.clear();	

			allocateCluster();
			evaluateCentroid();
			ArrayList<DataPoints>currentCentroids=centroidSeek();	
			iterartionCount++;
			
			double changeInCentroids = 0;
			
        for(int i = 0; i <lastCentroids.size(); i++) 
        	changeInCentroids += DataPoints.distance(lastCentroids.get(i),currentCentroids.get(i));
        	
              	System.out.println("");

        	if(changeInCentroids == 0) {
        		convergeFlag = true;
        	}
			
		}
		
}// KMclusteringAlgo
	
	
	public void evaluateCentroid()
	{
        for(Cluster rc : clusterDetailsList)
        {
	            double xSum = 0;
	            double ySum= 0;
	            ArrayList<DataPoints> pointsInCluster = rc.getPoints();
	            int noOfpoints = pointsInCluster.size();
	            
	            for(DataPoints point : pointsInCluster)
		            {
		            	xSum = xSum+point.getX();
		                ySum = ySum+point.getY();
		            }
	            DataPoints newCentroid = rc.getCentroid();
	            if(noOfpoints > 0) 
	            {
	            	double newX = xSum / noOfpoints;
	            	double newY = ySum / noOfpoints;
	            	newCentroid.setX(newX);
	            	newCentroid.setY(newY);
	            	newCentroid.setPId(0);    	
	            	rc.setCentroid(newCentroid);
	            	
	            }
        }
        
}//evaluateCentroid
	
	
	  public void allocateCluster() {

	        double max = Double.MAX_VALUE;
	        double min = max; 
	        int custid = -1;                 
	        double distance = 0.0; 
	        
	        for(DataPoints ptd: datapts) {
	        	min = max;
	            for(int i = 0; i < numCluster; i++) {
	            	Cluster c = clusterDetailsList.get(i);
	                distance = DataPoints.distance(ptd, c.getCentroid());
	                if(distance < min){
	                    min = distance;
	                    custid = i;
	                }
	            }
	            ptd.setCluster(custid);
	            clusterDetailsList.get(custid).addPoint(ptd);
	        }
}
	
	public ArrayList<DataPoints> centroidSeek()
	{	ArrayList<DataPoints> dp= new ArrayList<DataPoints>(numCluster);
		for(Cluster  cust :clusterDetailsList)
		{  DataPoints pt=cust.getCentroid();
			int id=pt.getPId();
			DataPoints recent=new DataPoints(id,pt.getX(),pt.getY());
			dp.add(recent);			
		}//for
		return dp;	
}
	
	public static void main (String[] args)
	{
	
	if(args.length!=3)
		
		{System.out.println("ERROR ! - Invalid/Incorrect Input Parameter Format !! ");
		}

	else
	{
	
		numCluster=Integer.parseInt(args[0]);
		fileInput=args[1];
		fileOutput=args[2];
	}

	String ipath=fileInput;
	BufferedReader inReader = null;

	try
	{
		inReader= new BufferedReader(new FileReader(ipath));
		inReader.readLine();
		String inLine=null;
		while((inLine=inReader.readLine())!=null)
		{
			String[] inputline=inLine.split("\t");
			DataPoints p1_rec=DataPoints.parseRecord(inputline);
			datapts.add(p1_rec);
		}
			
	}
	catch(Exception e)
		{
		System.out.println("ERROR"+e);
		}
	
	KMalgo  km = new KMalgo();
	
	km.initialize(datapts);
	km.KMclusteringAlgo();
	km.clusterDetails();
	km.evaluateSSE();
   }//main

}//KMalgo
