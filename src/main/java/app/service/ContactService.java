package app.service;

import app.entity.Contact;
import app.repository.ContactRepository;
import app.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;
@Service
public class ContactService {

    @Autowired
    ContactRepository repository;

    public List<Contact> getTours() {
        Iterable<Contact> iterable = repository.findAll();
        List<Contact> list =
                StreamSupport.stream(iterable.spliterator(), false)
                        .map(contact -> new Contact(contact.getId(),
                                Constants.URL_NAMES + contact.getFirst_name(),
                                contact.getLast_name(),
                                contact.getPhone()))
                        .toList();
        return new ArrayList<>(list);
    }
}
