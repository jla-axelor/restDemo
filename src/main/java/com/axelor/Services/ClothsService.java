package com.axelor.Services;

import java.util.List;

import com.axelor.db.Cloths;

public interface ClothsService {
	
	public void addCloths(Cloths c,int pid);
	public String updateCloths(int cid, String cname);
	public void deleteCloths (int cid);	

}
