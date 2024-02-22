/* Huffman Encoding
 * Code Template
 */

import java.util.*;
import java.io.*;

public class HuffmanEncoding{
    // instance variables
    private String message;
    private HuffNode trie;

    //constructor
    public HuffmanEncoding(String message){
		this.message = message;
		makeTrie();
    }

    //private helper methods that you can implement if you'd like
    private int contains(ArrayList<HuffNode> lst, char c){ 
    	for (int i = 0; i < lst.size(); i++) {
    		if (lst.get(i).getChar() == c) {
    			return i;
    		}
    	}
    	return -1;
    }
    //private boolean trieContains(HuffNode currTrie, char c){    }	
    //private String find(char c){    }

    // necessary private methods
    private MinHeap<HuffNode> countChars(){  
    	// count all the characters and make HuffNodes for each
    	// adding them to the minheap and returning 
    	ArrayList<HuffNode> Patrick = new ArrayList<HuffNode>();
    	for(int i = 0; i < message.length(); i++) {
    		int pos = contains(Patrick, message.charAt(i));
    		if(pos >= 0) {
    			Patrick.get(pos).increment();
    		}
    		else {
    			Patrick.add(new HuffNode(message.charAt(i)));
    		}
    	}
    	MinHeap Neo = new MinHeap();
    	for (HuffNode i: Patrick) {
    		Neo.insert(i);
    	}
    	return Neo;
    }
    
    private void makeTrie(){ 
    	MinHeap<HuffNode> Murray = countChars();
    	while(Murray.size() > 1) {
    		HuffNode val1 = Murray.remove();
    		HuffNode val2 = Murray.remove();
    		Murray.insert(new HuffNode(val1, val2));
    	}
    	trie = Murray.remove();
    }
    
    public String encode() {    }

   // public String decode(File fileName){    }
	    
    public String decode(String encoded){    }

    //Does not need to be altered.	
    private static String readInFile(File fileName){ 
		String str = "";
		try{
		    Scanner in = new Scanner(fileName);
		    while(in.hasNextLine())
	
			str += in.nextLine();
		}
		catch(Exception E) { System.out.println(E); }
		return str;
    }
    
    public static void main(String[] args){
		String message = "mississippi";
		HuffmanEncoding e = new HuffmanEncoding(message);
		System.out.println(e.encode());
		System.out.println(e.decode(e.encode()));

		//for further testing 
		String[] files = {"StarWarsIpsum.txt",
				  "LoremIpsum.txt",
				  "LegalIpsum.txt",
				  "PirateIpsum.txt"};
		String[] encoded = {"EncodedStarWars.txt", "EncodedLoremIpsum.txt",
				    "EncodedLegal.txt", "EncodedPirate.txt"};

    }


    
}
