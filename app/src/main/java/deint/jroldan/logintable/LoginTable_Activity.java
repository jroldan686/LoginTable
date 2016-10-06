package deint.jroldan.logintable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import deint.jroldan.logintable.controllers.ILoginMvc;
import deint.jroldan.logintable.controllers.LoginTable_Controller;

/**
 * This application uses the Model-View-Controller philosophy
 * Class which shows a Login Activity in a TableLayout
 * @author Jesús Roldán López
 * @version 1.0
 */

public class LoginTable_Activity extends AppCompatActivity {

    //private LoginTable_Controller loginTableController;
    private ILoginMvc loginMvc;
    private EditText edtUser;
    private EditText edtPassword;
    private Button btnOk;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_table);
        //loginTableController = new LoginTable_Controller();
        loginMvc = new LoginTable_Controller();
        edtUser = (EditText)findViewById(R.id.edtUser);
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        btnOk = (Button)findViewById(R.id.btnOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString();
                String password = edtPassword.getText().toString();
                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(password))
                    Toast.makeText(LoginTable_Activity.this, getResources().getString(R.string.data_empty), Toast.LENGTH_SHORT).show();
                else {
                    int result=loginMvc.validateCredentials(user,password);
                    switch (result) {
                        case LoginTable_Controller.PASSWORD_DIGIT:
                            Toast.makeText(LoginTable_Activity.this, getResources().getString(R.string.password_digit), Toast.LENGTH_SHORT).show();
                            break;
                        case LoginTable_Controller.PASSWORD_CASE:
                            Toast.makeText(LoginTable_Activity.this, getResources().getString(R.string.password_case), Toast.LENGTH_SHORT).show();
                            break;
                        case LoginTable_Controller.PASSWORD_LENGTH:
                            Toast.makeText(LoginTable_Activity.this, getResources().getString(R.string.password_length), Toast.LENGTH_SHORT).show();
                            break;
                        case LoginTable_Controller.OK:
                            // The next Activity would launch after logging in
                            break;
                    }
                }
            }
        });

        btnCancel = (Button)findViewById(R.id.btnCancel);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetValues();
            }
        });
    }

    private void resetValues() {
        edtPassword.setText("");
        edtUser.setText("");
    }
}
