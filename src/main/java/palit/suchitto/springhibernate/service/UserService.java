package palit.suchitto.springhibernate.service;

import palit.suchitto.springhibernate.model.User;

/**
 * This interface support the service tier operations.
 * @author Suchitto
 *
 */

public interface UserService {
	
	User save(User usr);
	  boolean findByLoginDetails(String userName, String password);
	  boolean findByUserName(String userName);

}
