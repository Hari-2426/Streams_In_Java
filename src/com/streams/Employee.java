package com.streams;

public class Employee {
	
	
	private int empid;
	private String empname;
	private int empSal;
	public Employee(int empid, String empname, int empSal) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.empSal = empSal;
	}
	
	public Employee()
	{
		
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", empSal=" + empSal + "]";
	}

	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public int getEmpSal() {
		return empSal;
	}
	public void setEmpSal(int empSal) {
		this.empSal = empSal;
	}

}
