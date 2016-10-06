package deint.jroldan.logintable.controllers;

/**
 * Created by usuario on 5/10/16.
 */

/**
 * Class that implements the Login rules
 * - At least one upper case and one lower case character
 * - At least on digit
 * - At least 8 characters long
 * @author Jesús Roldán López
 * @version 1.0
 */

public class LoginTable_Controller implements ILoginMvc {

    public static final int OK = 0;
    public static final int PASSWORD_DIGIT = 1;
    public static final int PASSWORD_CASE = 2;
    public static final int PASSWORD_LENGTH = 3;

    public int validateCredentials(String user, String password) {
        if(password.length() >= 8) {
            if(!password.matches("(.*)[0-9]+?(.*)")) {
                return PASSWORD_DIGIT;
            }
            if(!password.matches("(.*)[a-z]+?(.*)[A-Z]+?(.*)")) {
                return PASSWORD_CASE;
            }
            return OK;
        } else {
            return PASSWORD_LENGTH;
        }
    }

}
