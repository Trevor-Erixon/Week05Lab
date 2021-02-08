package models;

/**
 *
 * @author Trevor Erixon
 */
public class AccountService {
    
    private String username_1 = "Abe";
    private String username_2 = "Barb";
    
    public AccountService() {
        
    }
    
    public User login(String username, String password) {
        User user = null;
        
        if (username.equalsIgnoreCase(username_1) || username.equalsIgnoreCase(username_2))
        {
            if (password.equals("password"))
            {
                user = new User(username, null);
            }
        }
        
        return user;
    }
    
}
