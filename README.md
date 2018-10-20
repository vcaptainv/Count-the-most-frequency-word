# Count-the-most-frequency-word

Introduction :

This project is a continuation of the previous project. The primary objective of this project is to develop two major classes: the FindCommonWord and the FindTrends. The FindCommonWord class implements the priority queue data structure and can read in a text file and return the top ten most frequently used words in that text file. The FindTrends class implements the BST map data structure that I created in previous project and can determine the frequency of a particular words appears over multiple text files.

Solutions:

FindCommonWord: This class stores three fields, a priority queue heap, a wordcounter object, and a comparator object. I first use WordCounter class from previous project to read the word count text file and turn every lines in the text file into key-value pairs. The key is the a String of word, and value is an int that represents the apperance of that word in the text file. All the key-value pairs are then stored into an arraylist. Afterwards, I use "for each" method to loop through the arraylist and add every element of the arraylist to the priority queue. Then I call remove function of the PQ heap (priority queue heap) class for ten times. Since the remove function will return the root of the heap (which has the largest value (word apperance)), I will get the top ten most frequently used words in the text file.

FindTrends: In this class, there is only one wordcounter object. I first use the WordCounter object to read the word count text file. Then I use the getfrequency method in word counter class to get the frequency of current word. I also use args[] list to read the command line. As you can see, the first element contains the text part of the name of each wordcount file you want to analyze. The second element and third element is the begin and end year of word counter file. Then the rest of the elements are the list of words that you want to analyze to get the word frequency. I store the second and thrid elements to two integers "beginyear" and "endyear". I use args.length to get the full length of the args list, so I can know the number of word that I need to get frequency (equals to total number in the list - 3). Then I use double loop to read all the files and add the word frequency of a specific word in a specific year to a 2 dimentional array (which has (endyear - beginyear + 1) as the number of columns and (the number of words) as the rows). In the end, I print every elements in the 2-D array out, and here is the result.

Some events that can explain the trend of word frequency:

Apple and Microsoft have always been the top-tier technology companies in the world, which is the reason why they are mentioned a lot in the "reddit comments." 

In 2010, Apple released the first iPad in April 3rd, 2010 and iPhone 4 in June 7, 2010, which are two revolutionary electronic products made by Steven Jobs. These two events can explain the apex of word "apple" in 2010. 

Snapchat was launched in 2011 but became a popular social application in 2013. That is the reason why the word "snapchat" has never been mentioned before 2013 but suddenly became popular after 2013.

In 2015 Uber announced a collaboration with Carnegie Mellon to establish the Uber Advanced Technologies Center, a new facility in Pittsburgh meant to support research in the development of self-driving vehicles. 

Extensions:

Extension 1: I made two additional lists of interesting words and make the trend into a graph. Here is the result:

The Trend of different political names

The word "Obama" and "Clinton" are the two domintant words in the graph. This is because Obama has become the 44th president of United States and he is also the first african American to be elected to office and the first president born outside the contiguous United States. The popularity of word "clinton" can be explained by the previous president Bill Clinton and the Secretary of State Hillary Clinton. The fact that Hillary Clinton was also running for president in 2008 can explain the apex of word "Clinton" in 2008. The trend line of the word "Romney" has an apex in 2012, which is probably caused by the fact that he is running for the office against Obama in 2012. Palin is the vice president nominee in 2008, which explains the apex. "Sanders" has become very popular in 2015 maybe because he is preparing to run for the president in 2016.

The trend of different countries.

The word america and china are the two dominant words in the graph since they are two countries with highest GDP and economic growth. Canada also has a very high word frequency since it is contiguous to the United States and also a developed country. 

Extension 4: I marked the lines where memory is lost. 
