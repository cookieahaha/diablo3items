package me.kukkii.diablo3items;

public class Item{

	private String name ;	
	private String type ;	
	private String stat;	
	private String level;	

	public Item(String name, String type, String stat, String level){
		name=name;
		type=type;
		stat=stat;
		level=level;
	}

	public void setName(String name){
		name=name;
	}

	public void setType(String type){
		type=type;
	}
	
	public void setStat(String stat){
		stat=stat;
	}

	public void setLevel(String level){
		level=level;
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

}


