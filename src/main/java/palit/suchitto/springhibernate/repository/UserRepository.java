/**
 * 
 */
package palit.suchitto.springhibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import palit.suchitto.springhibernate.model.User;

/**
 * 	This class support the repository tier database operations. @Repository classes are DAO class.
 * 
 *  There are two interface methods needed for the application’s purpose.
 *  To Verify the User Login details from the Database which is done by findByUserName method.
 *	To Insert the User Signup details into the Database. For that the save() method is supported by the 
 *  Hibernate implementation and hence no separate SQL statements are required for the data insert.
 *  
 * @author Suchitto
 *
 */

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select u from User u where u.uName = :uName")
	 User findByUserName(@Param("uName") String uName);

}
