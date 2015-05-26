/**
 * 
 */
package palit.suchitto.springhibernate.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import palit.suchitto.springhibernate.model.User;
import palit.suchitto.springhibernate.repository.UserRepository;



/**
 * This is where the application logic goes – either to save the user details into the database or to verify the user (already saved) 
 * details from the database.
 * @author Suchitto
 *
 */
@Configuration
@ComponentScan("palit.suchitto.springhibernate.repository")
public class UserServiceImpl implements UserService {

	/*
	 * Here @Autowired annotation is used on the property. So we neither need a
	 * setter method nor the property has to be public. The userRepository will
	 * be injected when you pass values of autowired properties using
	 * <property>. Spring will automatically assign those properties with the
	 * passed values or references.
	 * 
	 * The @Autowired annotation tells spring where an injection needs to occur.
	 * If you put it on a setter method it understands (by the prefix set + the
	 * 
	 * @Autowired annotation) that a bean needs to be injected.
	 * 
	 * Read it here.
	 * http://stackoverflow.com/questions/19414734/understanding-spring
	 * -autowired-usage
	 */
	@Autowired
	private UserRepository userRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * palit.suchitto.springhibernate.service.UserService#save(palit.suchitto
	 * .springhibernate.model.User)
	 */
	@Transactional
	public User save(User usr) {
		return userRepository.save(usr);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * palit.suchitto.springhibernate.service.UserService#findByLoginDetails
	 * (java.lang.String, java.lang.String)
	 */
	@Override
	public boolean findByLoginDetails(String userName, String password) {
		User usr = userRepository.findByUserName(userName);

		if (usr != null && usr.getPassword().equals(password)) {
			return true;
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * palit.suchitto.springhibernate.service.UserService#findByUserName(java
	 * .lang.String)
	 */
	@Override
	public boolean findByUserName(String userName) {
		User usr = userRepository.findByUserName(userName);

		if (usr != null) {
			return true;
		}

		return false;
	}

}
