package com.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.model.User;
import com.rest.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userrepository;
	
	@Override
	public User saveUser(User uobj) 
	{
		Optional<User> optional = this.userrepository.findById(uobj.getUserId());
		User adduobj = null;
		
		if(optional.isPresent())
		{
			System.out.println("User Details already exists ...");
		}
		else
		{		
			adduobj = this.userrepository.save(uobj);
		}
		return adduobj;
	}

	@Override
	public User updateUser(User uobj, int uid) {
    	
//		get the user details which to be updated by passing the user id
		Optional<User> userOptional = this.userrepository.findById(uid);

    	User uObj = null;
    	User updatedData = null;
    	
//    	Checking whether user id exists or not
        if(userOptional.isPresent())
        {
        	System.out.println("Record Exists and ready for Update !!!");
        	
//        	Extracting the user details as user object from optional
        	uObj = userOptional.get();
 
//        	setting the updated value to setter method by taking from user through getter
           	uObj.setUserName(uobj.getUserName());
        	uObj.setPassword(uobj.getPassword());
 
//        	saving the final updated value to db
        	updatedData = this.userrepository.save(uObj);
        	
        }

//        returning the updated value to user
        return updatedData;
	}

	@Override
	public User getUserById(int uid) {

		
//		get the user details which to be updated by passing the user id
		Optional<User> userOptional = this.userrepository.findById(uid);

    	User uObj = null;
    	
//    	Checking whether user id exists or not
        if(userOptional.isPresent())
        {
        	System.out.println("Record Exists and ready for Update !!!");
        	
//        	Extracting the user details as user object from optional
        	uObj = userOptional.get();
        }
        else
        {
        	System.out.println("User does not exists");
        }

        return uObj;
		
	}

	@Override
	public List<User> getAllUsers() {
		
		return this.userrepository.findAll();
		
	}

	@Override
	public boolean delUser(int uid) {
	
//		get the user details which to be updated by passing the user id
		Optional<User> userOptional = this.userrepository.findById(uid);

    	boolean status=false;
    	
//    	Checking whether user id exists or not
        if(userOptional.isPresent())
        {
        	System.out.println("Record Exists and ready for Delete !!!");
        	
//        	Extracting the user details as user object from optional
        	this.userrepository.delete(userOptional.get());
        	status=true;
        }
        else
        {
        	System.out.println("User details does not exits for delete ..");
        }
        return status;
	}
}