package com.broovin.dao;

import java.util.List;

import com.broovin.beans.Reimbursement;
import com.broovin.beans.User;

public interface SystemDAO {
	public int userLogin(String username, String password, String isManager) throws ClassNotFoundException;
	public boolean submitRequest(Reimbursement reimbursement);
	public Reimbursement[] viewReimbursement(User user, int reimbursementType);
	public boolean updateInfo(User user);
	public List<User> viewAllEmployees();
	public Reimbursement[] viewAllReimbursements(int reimbursementType);
	public boolean handleReimbursementRequests(Reimbursement reimbursement);
	public User viewSingleEmployee( int user_ID);
	public boolean register(String username, String password, String email);
	public String returnUserAsSession(String username, String password);
	public List<String> returnRList( int userID, boolean isManager);
	public boolean submitFields(int userID, double amount, String desc);
	public boolean approveall();
}