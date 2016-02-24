#Assignment - 2 (Decision Tree) 


#install.packages("rpart",dependencies = TRUE)
library(rpart)
args <- commandArgs(TRUE)

#Reading Data


training <- read.table(file=args[1],header = TRUE, sep = ",")
validation <- read.table(file=args[2],header = TRUE, sep = ",")
trainVal <- rbind(training,validation)


#Building the model

decisionTree <- rpart(Class ~ ., data = trainVal, method = "class", parms = list(split ='information'), minsplit=2)
print(decisionTree)

#Plot 1

jpeg("DecisionTree.jpg")
par(mar = rep(0.1, 4))
plot(decisionTree)
text(decisionTree)
dev.off()

sink(file="DecisionTreeTextFiles.txt")
summary(decisionTree)
sink()

#Plot 2

sink(file="DecisionTreeTextFiles.txt")
printcp(decisionTree)
sink()

jpeg("CP.jpg")
plotcp(decisionTree)
text(decisionTree)
dev.off()

#Prunning

pruneDTree <- prune(decisionTree , cp=0.01000000)
print(pruneDTree)

#Plot 3

jpeg("Prune.jpg")
plot(pruneDTree)
text(pruneDTree)
dev.off()

sink(file="PrunnedTreeTextFiles.txt")
printcp(pruneDTree)
sink()

#Plot 4

jpeg("PruneCP.jpg")
plotcp(pruneDTree)
text(pruneDTree)
dev.off()

sink(file="PrunnedTreeTextFiles.txt")
summary(pruneDTree)

sink()
#Read Test Data

test <- read.csv(file=args[3],header = TRUE, sep = ",")

#Prediction

pred <- predict(pruneDTree, newdata = test, type = "class")

#Accuracy

accuracy<- table(pred,test$Class)
sum(diag(accuracy))/sum(accuracy) *100 

