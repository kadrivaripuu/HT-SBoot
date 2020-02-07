package com.ht.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.core.beans.UserDto;
import com.ht.core.service.UserServiceImpl;
import com.ht.web.beans.ResponseBean;

@Controller
@CrossOrigin
@RequestMapping("/rest/user")
public class UserRestController {

	@Autowired
	private UserServiceImpl userService;
	
	 @RequestMapping(value = "/save", method = RequestMethod.POST,
	            produces = MediaType.APPLICATION_JSON_VALUE,
	            consumes= MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody
	    ResponseBean<String> moduleProcess(@RequestBody UserDto userDto) {
	        userService.register(userDto);
	        return new ResponseBean<>("User Saved");
	    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseBean<UserDto> find(@PathVariable Long id) {
       UserDto userDto = userService.findById(id);
        return new ResponseBean<UserDto>(userDto);
    }
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseBean<UserDto> userDelete(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseBean<>("User Deleted");
    }
}
