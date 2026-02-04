import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class m_invIndex {
    LinkedList<String> stopWord;
    Index index1;
    InvertedIndex inverted;
    InvertedIndexBST inv_BST;
    int numOftokens=0;
    LinkedList<String> unique_word = new LinkedList<>();

    public m_invIndex () {
        stopWord = new LinkedList<>();
        index1 = new Index();
        inverted = new InvertedIndex();
        inv_BST = new InvertedIndexBST();
    }

    public void Load_stopWords(String fileName) {
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                stopWord.insert(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Load_all_doc(String fileName) {
    	String line = null;
    	try {
    	    File f = new File(fileName);
    	    Scanner s = new Scanner(f);
    	    s.nextLine();
    	    while (s.hasNextLine()) {
    	        line = s.nextLine();
    	        if (line.trim().length() < 3) {
    	          System.out.println("Empty line found skip =" + line);
    	            break;
    	        }

    	        String x = line.substring(0, line.indexOf(','));
    	        int id = Integer.parseInt(x.trim());
    	        String content = line.substring(line.indexOf(',') + 1).trim();
    	        count_Token_and_unique_word( content);
    	        LinkedList<String> words_in_doc =Linked_List_of_words_in_doc_index_inv_index(content, id);
    	        index1.add_Document(new Document(id, words_in_doc, content));
    	    }}catch (Exception e) {
            System.out.println("end of file");
        }
    }

    public LinkedList<String> Linked_List_of_words_in_doc_index_inv_index(String content, int id) {
        LinkedList<String> word_in_doc = new LinkedList<String>();
        index_and_inv_index(content, word_in_doc, id);
        return word_in_doc;
    }

    public void index_and_inv_index(String content, LinkedList<String> word_in_doc, int id) {
    	
    	while(content.contains("-")) {
    	    if(content.charAt(content.indexOf("-") - 2) == ' ') {
    	        content = content.replaceFirst("-", "");
    	    } else {
    	        content = content.replaceFirst("-", " "); //****
    	    }
    	}

    	content = content.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "");
    	String[] tokens = content.split("\\s+"); //****

    	for (String w : tokens) {
    	    if (!search_stop_word(w)) {
    	        word_in_doc.insert(w);
    	        inverted.add(w, id);
    	        inv_BST.add(w, id);
    	    }
    	}

    	}
    public void count_Token_and_unique_word(String content) {
        content = content.replaceAll("\'", " "); // ***
        content = content.replaceAll("-", " "); // ***
        content = content.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", ""); // ***
        String[] tokens = content.split("\\s+"); // ***
        numOftokens += tokens.length;
        
        for (String w : tokens) {
            if (!unique_word.search(w)) { // ******
                unique_word.insert(w);
            }
        }
    }



    public boolean search_stop_word(String word) {
        if (stopWord == null || stopWord.empty()) 
            return false;
        
        stopWord.findFirst();
        while (!stopWord.last()) {
            if (stopWord.retrieve().equals(word)) {
                return true;
            }
            stopWord.findNext();
        }

        if (stopWord.retrieve().equals(word)) {
            return true;
        }

        return false;
    }
    public void display_doc(LinkedList<Integer> IDs) {
        if (IDs.empty()) {
            System.out.println("no docs exist");
            return;
        }

        IDs.findFirst();
        while (!IDs.last()) {
            Document d = index1.get_doc(IDs.retrieve());
            if (d != null) {
                System.out.println("Document " + d.id + ": " + d.content);
            }
            IDs.findNext();
        }

        Document d = index1.get_doc(IDs.retrieve());
        if (d != null) {
            System.out.println("Document " + d.id + ": " + d.content);
        }
        

        System.out.println("");
    }


    public void Load_all_file(String stop_file, String documents_file) {
        Load_stopWords(stop_file);
        Load_all_doc(documents_file);
    }
   
}
