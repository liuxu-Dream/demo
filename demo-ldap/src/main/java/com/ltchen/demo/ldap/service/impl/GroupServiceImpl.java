package com.ltchen.demo.ldap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltchen.demo.ldap.bean.Group;
import com.ltchen.demo.ldap.dao.GroupDao;
import com.ltchen.demo.ldap.service.GroupService;

@Service("groupServiceImpl")
public class GroupServiceImpl implements GroupService {

	@Override
	public List<Group> getAll() {
		return groupDao.getAll();
	}
	
	@Override
	public boolean isExist(String groupRdn){
		for (Group group : this.getAll()) {
			if(String.format("cn=%s,ou=group", group.getGroupName()).equals(groupRdn)){
				return true;
			}
		}
		return false;
	}
	
	@Autowired
	private GroupDao groupDao;
	
	@Override
	public void add(String groupRdn, Group group) {
		groupDao.add(groupRdn, group);
	}

	@Override
	public void remove(String groupRdn) {
		groupDao.delete(groupRdn);
	}

	@Override
	public void update(String groupRdn, Group group) {
		groupDao.update(groupRdn, group);
	}

	@Override
	public Group find(String groupRdn) {
		return groupDao.find(groupRdn);
	}

	@Override
	public void rename(String oldGroupRdn, String newGroupRdn) {
		groupDao.rename(oldGroupRdn, newGroupRdn);
	}

	@Override
	public List<Group> search(String groupRdn, String filter) {
		return groupDao.search(groupRdn, filter);
	}

	@Override
	public void addUser(String userRdn, String groupRdn) {
		groupDao.addMember(userRdn, groupRdn);
		
	}

	@Override
	public void removeUser(String userRdn, String groupRdn) {
		groupDao.removeMember(userRdn, groupRdn);
	}

}
