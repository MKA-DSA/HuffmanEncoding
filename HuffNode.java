/* HuffNode
 * Huffman Encoding
 */

// Does not need to be altered.

import java.util.*;

public class HuffNode implements Comparable{
    // instance variables
    private int count;
    private char ch;
    private HuffNode left;
    private HuffNode right;

    // constructors
    public HuffNode(char ch){
		// used when creating node with char in message
		this.count = 1; this.ch = ch;
		left = null; right = null;
    }
    public HuffNode(HuffNode l, HuffNode r){
		// used when creating node out of two nodes
		left = l; right = r;
		count = l.getCount() + r.getCount();
		ch = '*';
    }

    // accessors
    public HuffNode getLeft() { return left; }
    public HuffNode getRight() { return right; }
    public int getCount(){ return count; }
    public char getChar() { return ch; }

    public boolean isLeaf() {
    	return this.getLeft() == null && this.getRight() == null;
    }
    public int compareTo(Object other){
    	HuffNode o = (HuffNode) other;
    	return count - o.getCount();
    }
    public String toString(){
    	return ch + ": " + Integer.toString(count);
    }

    // modifiers - used when counting
    public void increment() { count+= 1;}
}
