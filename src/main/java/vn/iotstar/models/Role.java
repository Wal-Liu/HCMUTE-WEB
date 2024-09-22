package vn.iotstar.models;

import java.io.Serializable;

public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int roleid;
	private String rolename;
	
	public Role(int roleId, String rolename) {
		super();
		this.roleid = roleId;
		this.rolename = rolename;
	}

	public Role() {
		super();
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	
	
}
