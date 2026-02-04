🔎 Mini Search Engine using Index & Inverted Index (Java)
- README Generated with the help of ChatGPT

📋 Overview
This project implements a **mini search engine** in Java that supports document indexing, inverted indexing, Boolean retrieval, and ranked retrieval.
It demonstrates core **Information Retrieval (IR)** concepts using **custom data structures** without relying on Java built-in collections.

The system supports multiple retrieval models:
- Index-based retrieval using linked lists
- Inverted Index using linked lists
- Inverted Index using Binary Search Trees (BST)
- Boolean queries (AND, OR, NOT)
- Ranked retrieval based on term frequency

📚 Features
- Custom implementation of Linked List and BST
- Stop-word removal
- Tokenization and normalization
- Boolean query processing
- Ranked retrieval with document scoring
- Menu-driven console interface

🧵 Core Components
- Index: Stores full documents and allows term-based retrieval
- Inverted Index (List): Maps words to document IDs using linked lists
- Inverted Index (BST): Optimized word lookup using a binary search tree
- Query Processors:
  - Index-based Boolean queries
  - Inverted Index Boolean queries
  - BST-based Boolean queries
- Ranking Engine: Scores documents using term frequency

📁 File Structure

- Main.java                // Program entry point and menu
- m_invIndex.java          // Manages indexing, loading files, and statistics
- Index.java               // Document index using linked lists
- InvertedIndex.java       // Inverted index using linked lists
- InvertedIndexBST.java    // Inverted index using BST
- Document.java            // Represents a document
- Word.java                // Represents a term and its document list
- LinkedList.java          // Custom generic linked list
- Node.java                // Linked list node
- List.java                // List interface
- BST.java                 // Binary Search Tree implementation
- BSTNode.java             // BST node
- Queryindex.java          // Boolean queries using index
- Query.java               // Boolean queries using inverted index (list)
- QueryBST.java            // Boolean queries using inverted index (BST)
- Ranking.java             // Ranked retrieval logic
- Doc_Rank.java            // Document ranking object

📄 Input Files

stop.txt  
Contains stop words (one word per line).

dataset.csv  
Contains documents in the following format:
ID,DocumentContent

Example:
1,Information retrieval is the process of obtaining information
2,Search engines use inverted indexes
3,Data structures improve search efficiency

⚙️ How It Works
1. Stop words are loaded from `stop.txt`
2. Documents are read from `dataset.csv`
3. Text is normalized (lowercase, punctuation removal)
4. Tokens are indexed into:
   - Document Index
   - Inverted Index (List)
   - Inverted Index (BST)
5. Users interact through a menu to perform searches

🛠 How to Run

1. Compile all Java files:
   javac *.java

2. Run the program:
   java Main

3. Follow the menu options:
   1 → Retrieve a term (Index / Inverted Index / BST)
   2 → Boolean Retrieval (AND, OR, NOT)
   3 → Ranked Retrieval
   4 → Display all indexed documents
   5 → Number of documents
   6 → Number of unique words (excluding stop words)
   7 → Vocabulary size and token count
   8 → Exit

📊 Output
- Lists of document IDs matching queries
- Full document contents for retrieved results
- Ranked results with document scores
- Statistics about tokens and vocabulary

📌 Notes
- All data structures are implemented manually (no Java Collections)
- Ranking is based on **term frequency**
- Stop words are excluded during indexing
- BST improves word lookup efficiency compared to linked lists

🎯 Learning Objectives
- Understand indexing and inverted indexing
- Implement Boolean and ranked retrieval models
- Practice custom data structure implementation
- Apply Information Retrieval concepts
- Compare list-based and tree-based indexing approaches
