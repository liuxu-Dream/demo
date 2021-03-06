package com.ltchen.demo.dubbox.provider.service;

import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.ltchen.demo.dubbox.api.bean.User;
import com.ltchen.demo.dubbox.api.service.UserService;

@Service("userServiceImpl")
@Path("users")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class UserServiceImpl implements UserService {

	@Override
	@GET
	@Path("")
	@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
	public List<User> getAll() {
		List<User> users = new ArrayList<User>();
		users.add(new User("1","ltchen"));
		users.add(new User("2","loupipalien"));
		System.out.println("get all users.");
		return users;
	}

	@Override
	@GET
	@Path("{id : \\d+}")
	@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
	public User get(@PathParam("id") String id) {
		System.out.println("get user that id is " + id);
		return new User(id, "ltchen");
	}

	@Override
	@POST
	@Path("")
	@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
	public User add(User user) {
		System.out.println("add user that is " + user);
		return user;
	}

	@Override
	@PUT
	@Path("")
	@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
	public User update(User user) {
		System.out.println("update user that is " + user);
		return user;
	}

	@Override
	@DELETE
	@Path("{id : \\d+}")
	@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
	public void delete(@PathParam("id") String id) {
		System.out.println("delete user that id is " + id);
	}

}
