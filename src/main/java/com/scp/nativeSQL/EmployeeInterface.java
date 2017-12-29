package com.scp.nativeSQL;

public interface EmployeeInterface
{
	void insertEmployee(Employee e) throws MyException;
	void getAllEmployeeWithHQL_Native()throws MyException;
	void allEmployeeWith_SQL_Native()throws MyException;	
}