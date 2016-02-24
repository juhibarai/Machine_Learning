

  ************PART - 1**************

## KMEANS Algorithm Implementation ##


Steps to Execute Part-1


1. Set path in your command prompt : SET PATH=%PATH%;C:\Program Files\Java\jdk1.8.0_60\bin

2. Change the directory to your working directory/where your code is saved
	Example- cd C:\Users\Juhi\workspace\Assignment5

3. Compile the code
	javac KMalgo.java

4. Run the code
	java KMalgo 12 test_data.txt output5.txt   

 (OR)	java KMalgo.java C:\Users\Juhi\workspace\Assignment5\test_data.txt  C:\Users\Juhi\workspace\Assignment5\output5.txt 

5. Output will be generated to a file called output.txt


REFERENCE
Data On Focus - Everything about data and manipulation
http://www.dataonfocus.com/k-means-clustering-java-code/


#####--- 5 times execution with the SSE Values ---#####


1. For k=3

Cluster id :1           Data Points :   3,4,11,14,16,18,21,22,25,26,28,32,33,36,37,40,42,48,50,52,56,59,60,64,68,69,70,71,72,74,80,82,83,84,91,92,95,96,100,
Cluster id :2           Data Points :   1,2,6,8,10,12,13,17,19,20,24,27,34,38,39,41,51,53,54,55,57,58,61,63,65,73,75,77,78,85,88,89,93,94,97,98,99,
Cluster id :3           Data Points :   5,7,9,15,23,30,31,35,43,44,45,46,47,49,62,66,76,79,81,87,90,

SSE value:1.9035754198594212



2. For k=7

Cluster id :1           Data Points :   9,23,31,35,44,45,46,47,49,66,76,79,81,86,90,
Cluster id :2           Data Points :   10,19,20,27,41,54,55,73,77,78,85,89,
Cluster id :3           Data Points :   1,2,8,17,61,94,99,
Cluster id :4           Data Points :   3,4,16,32,38,52,59,60,64,
Cluster id :5           Data Points :   11,14,18,21,22,25,26,28,33,36,37,40,48,50,68,69,70,71,72,74,80,82,83,84,91,92,95,96,100,
Cluster id :6           Data Points :   5,7,15,43,67,87,
Cluster id :7           Data Points :   6,12,13,24,29,34,39,51,53,57,58,65,75,93,97,

SSE value:1.0211995539682541



3. For k=12

Cluster id :1           Data Points :   73,85,89,
Cluster id :2           Data Points :   14,22,25,26,33,40,42,50,84,91,100,
Cluster id :3           Data Points :
Cluster id :4           Data Points :   6,12,38,75,93,
Cluster id :5           Data Points :   37,48,82,95,
Cluster id :6           Data Points :   1,2,8,17,24,29,34,39,51,53,58,61,63,65,94,98,99,
Cluster id :7           Data Points :   5,7,9,15,30,31,35,43,44,45,46,47,49,62,66,67,76,79,81,86,87,90,
Cluster id :8           Data Points :
Cluster id :9           Data Points :   18,69,74,80,
Cluster id :10          Data Points :   19,20,27,41,54,55,77,78,88,
Cluster id :11          Data Points :   11,28,32,52,68,71,72,92,
Cluster id :12          Data Points :   3,4,16,56,59,64,

SSE value:0.7842842483214496



4. For k=18

Cluster id :1           Data Points :   31,79,
Cluster id :2           Data Points :   3,14,25,26,33,40,42,50,84,91,100,
Cluster id :3           Data Points :   4,11,22,60,64,68,70,71,92,
Cluster id :4           Data Points :   30,35,45,46,47,49,86,
Cluster id :5           Data Points :   20,41,77,
Cluster id :6           Data Points :   5,7,43,62,67,87,
Cluster id :7           Data Points :   28,36,37,48,72,82,95,
Cluster id :8           Data Points :   9,15,66,76,81,
Cluster id :9           Data Points :   19,27,54,78,
Cluster id :10          Data Points :   10,
Cluster id :11          Data Points :   38,56,59,
Cluster id :12          Data Points :   73,
Cluster id :13          Data Points :   16,18,69,74,80,
Cluster id :14          Data Points :   8,17,94,98,
Cluster id :15          Data Points :   1,53,57,65,
Cluster id :16          Data Points :   6,12,13,75,97,
Cluster id :17          Data Points :   29,34,39,51,58,63,
Cluster id :18          Data Points :

SSE value:0.31084266572871594



5. For k=25

Cluster id :1           Data Points :   7,62,
Cluster id :2           Data Points :   66,76,90,
Cluster id :3           Data Points :   45,
Cluster id :4           Data Points :
Cluster id :5           Data Points :   56,64,
Cluster id :6           Data Points :
Cluster id :7           Data Points :   38,59,
Cluster id :8           Data Points :   23,30,46,
Cluster id :9           Data Points :   1,2,8,17,61,94,98,99,
Cluster id :10          Data Points :   35,67,
Cluster id :11          Data Points :   3,16,42,69,80,100,
Cluster id :12          Data Points :   5,
Cluster id :13          Data Points :   44,49,
Cluster id :14          Data Points :   18,74,
Cluster id :15          Data Points :   11,22,70,
Cluster id :16          Data Points :
Cluster id :17          Data Points :   37,48,83,95,96,
Cluster id :18          Data Points :   82,
Cluster id :19          Data Points :
Cluster id :20          Data Points :   6,13,24,29,34,51,53,65,93,97,
Cluster id :21          Data Points :   14,40,50,84,91,
Cluster id :22          Data Points :   10,27,39,58,73,78,85,88,89,
Cluster id :23          Data Points :
Cluster id :24          Data Points :   12,20,41,54,75,77,
Cluster id :25          Data Points :   28,32,68,72,92,

SSE value:0.263770175





