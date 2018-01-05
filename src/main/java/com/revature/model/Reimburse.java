package com.revature.model;

import java.sql.Timestamp;

public class Reimburse {
	public int reimburseid;
	public int employeeid;
	public Timestamp date;
	public String location;
	public String decription;
	public int cost;
	public int type;
	public int stage;
	public Reimburse(int id, int ids, Timestamp dates, String location, String description, int costs, int type, int stage) {
		reimburseid= id;
		employeeid= ids;
		this.date = dates;
		this.location = location;
		this.decription = description;
		this.cost = costs;
		this.type = type;
		this.stage = stage;
		
		
	}
	@Override
	public String toString() {
		return date.toString();
	}

}
