package deint.jroldan.logintable.controllers;

/**
 * Created by usuario on 6/10/16.
 */

/**
 * Interface that has the structure for the Controller classes
 * @author Jesús Roldán López
 * @version 1.0
 */

public interface ILoginMvc {

    public int validateCredentials(String user, String password);
}
