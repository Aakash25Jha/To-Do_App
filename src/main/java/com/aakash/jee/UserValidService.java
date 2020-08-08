package com.aakash.jee;

public class UserValidService {
	
	public boolean isUserValid(String user,String password)
	{
		if(user.equalsIgnoreCase("aakash")&&password.equalsIgnoreCase("dummy"))
		return true;
		else
		return false;	
	}
}
