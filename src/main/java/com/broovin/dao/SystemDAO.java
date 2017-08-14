package com.broovin.dao;

import java.util.List;

import com.broovin.beans.Reimbursement;
import com.broovin.beans.User;

public interface SystemDAO {
	public boolean userLogin(String username, String password, String isManager) throws ClassNotFoundException;
	public boolean submitRequest(Reimbursement reimbursement);
	public Reimbursement[] viewReimbursement(User user, int reimbursementType);
	public boolean updateInfo(User user);
	public List<User> viewAllEmployees();
	public Reimbursement[] viewAllReimbursements(int reimbursementType);
	public boolean handleReimbursementRequests(Reimbursement reimbursement);
	public User viewSingleEmployee( int user_ID);
	public boolean register(String username, String password, String email);
}