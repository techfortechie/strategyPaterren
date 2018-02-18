package com.sapient.demo.inputTransactions;

public abstract class Lookup implements ILookup {
	 protected long id;
	 private boolean readOnly=false;
	 
	 public Lookup(long id) {
		// TODO Auto-generated constructor stub
		 
		 this.id = id;
	}
	  abstract public long getId();
	public void setId(long id) {
	
		      System.out.println("Set id '"+this.getClass().getName()+"' currVal: "+this.id+", newVal: "+id);
		 
		      if(readOnly){
		          throw new RuntimeException("Cannot change the ID of a lookup object");
		      }
		      this.id = id;
		  }
}
