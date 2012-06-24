package me.kukkii.diablo3items;

public class Item{

	private String name ;	
	private String type ;	
	private String stat;	
	private String level;	

	public Item(String name, String type, String stat, String level){
		this.name=name;
		this.type=type;
		this.stat=stat;
		this.level=level;
	}

	public void setName(String name){
		this.name=name;
	}

	public void setType(String type){
		this.type=type;
	}
	
	public void setStat(String stat){
		this.stat=stat;
	}

	public void setLevel(String level){
		this.level=level;
	}

	public String getName(){
		return name;
	}

	public String getType(){
		return type;
	}

	public String getStat(){
		return stat;
	}

	public String getLevel(){
		return level;
	}

	public String toString(){
		return "Item[" + name + ", " + type + ", " + stat + ", " + level + "]";
	}

}
