package com.learning.web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.web.Entity.Contact;
import com.learning.web.Repository.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepo;
	
	public List<Contact> getAllContacts(){
		return contactRepo.findAll();
	}
	
	public Contact saveContact(Contact contact) {
		return contactRepo.save(contact);
	}
	
	public Contact getContactById(Long id) {
		return contactRepo.findById(id).get();
	}
	
	public Contact updateContact(Contact contact) {
		return contactRepo.save(contact);
	}
	
	public void deleteContactById(Long id) {
		contactRepo.deleteById(id);
	}

}
