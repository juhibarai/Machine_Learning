Name : Juhi Kaushik Barai
Net Id: jkb140130


*****Contents of the Zip folder :*****
1. R Code ( MLassignment.R )
2. 4 Plots ( .jpg images )
3. 2 Textfiles ( DecisionTreeTextFiles and PrunnedTreeTextFiles )
4. Report.txt (Accuracy report with different complexity parameters values for both dataset)
5. ReadMe.txt


*****How To Run the R-Code :*****


Generic Set Path Command : set path=%PATH%;<bin location of where R is installed in your PC>

(EXAMPLE) -  set path=%PATH%;C:\Program Files\R\R-3.1.2\bin


Generic Dataset Execution Command : Rscript <R file name> <training data> <validation data> <test data>

(EXAMPLE DataSet 1)  : Rscript MLassignment.R training_set.csv validation_set.csv test_set.csv

(EXAMPLE DataSet 2)  :  Rscript MLassignment.R training_set1.csv validation_set1.csv test_set1.csv


*****Package and Parameters used :*****

1. Built the model using rpart.

2. Created the plots using plot() command.
(Made 4 plots, namely, DecisionTree, CP, Prune, PruneCP)

3. Exported 2 text files, namely, DecisionTreeTextFiles and PrunnedTreeTextFiles, using sink() command, containing the summary & complexity parameter(CP) information.

4. Parameter Used : cp
   Printed the cp table using printcp() command and chose the cp value with least xerror in prunning the set.






