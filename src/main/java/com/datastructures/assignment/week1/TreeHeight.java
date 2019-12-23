package com.datastructures.assignment.week1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class FastScanner {
	StringTokenizer tok = new StringTokenizer("");
	BufferedReader in;

	FastScanner() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	String next() throws IOException {
		while (!tok.hasMoreElements())
			tok = new StringTokenizer(in.readLine());
		return tok.nextToken();
	}
	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}	
}

class Node{
	int key;
	List<Node> children;
	Node parent;
	
	Node(int k){
		this.key = k;
	}
	
	boolean hasChildern() {
		return !(this.children==null||this.children.size()==0);
	}
	
	void addChild(Node child){
		if(children==null||children.size()==0) {
			children = new ArrayList<Node>();
		}
		children.add(child);
	}
	
}

public class TreeHeight {	
	
	public static void main(String args[]) throws IOException {
		FastScanner fs = new FastScanner();
		int n = fs.nextInt();
		Map<Integer,Node> nodes = new HashMap<Integer,Node>();
		Node rootNode = null;
		for(int i=0;i<n;i++) {
			nodes.put(i,new Node(i));
		}
		for(int i=0;i<n;i++) {			
			int input = fs.nextInt();
			Node node = nodes.get(i);
			if(input==-1) {
				rootNode = node;			
			}else {
				Node parentNode = nodes.get(input);
				parentNode.addChild(node);	
				node.parent = parentNode;
			}			
		}
		
		System.out.println(getHeight(rootNode,n));
		
	}
	private static int getHeight(Node tree, int n) {		
		if(tree==null) {
			return 0;
		}	
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(tree);	
		
		int i = 0;
		while(!q.isEmpty()) {	
			i++;
			if(i==n) {
				break;
			}
			Node node = q.poll();
			if(node.hasChildern()) {				
				node.children.stream().forEach(child->q.add(child));
			}
		}
		Node lastNode = q.poll();
		Node parent = lastNode.parent;
		i=1;
		while(parent !=null) {
			i++;
			parent = parent.parent;
		}
		return i;
		
	}
	
}
