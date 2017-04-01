package androidfeaturesdemo.com.osfg.androiddemofeatures;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by athakur on 4/1/17.
 */

public class LoginActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText inputUserName, inputEmail, inputPassword;
    private TextInputLayout inputLayoutUsername, inputLayoutEmail, inputLayoutPassword;
    private Button loginButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlayout);

        //set the toolbar
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //lets hide the tabs for now. Well add later if required
        TabLayout tabs = (TabLayout)findViewById(R.id.tabs);
        tabs.setVisibility(View.GONE);

        inputLayoutUsername = (TextInputLayout) findViewById(R.id.input_layout_username);
        inputLayoutEmail = (TextInputLayout) findViewById(R.id.input_layout_email);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_password);

        inputUserName = (EditText) findViewById(R.id.input_username);
        inputEmail = (EditText) findViewById(R.id.input_email);
        inputPassword = (EditText) findViewById(R.id.input_password);

        loginButton = (Button) findViewById(R.id.btn_login);

        inputUserName.addTextChangedListener(new CustomTextWatcher(inputUserName));
        inputEmail.addTextChangedListener(new CustomTextWatcher(inputEmail));
        inputPassword.addTextChangedListener(new CustomTextWatcher(inputPassword));

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateUsername(inputUserName.getText().toString()) && validateEmail(inputEmail.getText().toString()) && validatePassword(inputPassword.getText().toString())) {
                    Toast.makeText(getApplicationContext(),getString(R.string.welcome_message),Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),getString(R.string.error_message),Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private boolean validateUsername(String text) {
        if(TextUtils.isEmpty(text)) {
            inputLayoutUsername.setError(getString(R.string.error_username));
            inputUserName.requestFocus();
            return false;
        }
        else {
            inputLayoutUsername.setErrorEnabled(false);
        }
        return true;

    }

    private boolean validateEmail(String text) {
        if(!isValidEmail(text)) {
            inputLayoutEmail.setError(getString(R.string.error_email));
            inputEmail.requestFocus();
            return false;
        }
        else {
            inputLayoutEmail.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validatePassword(String text) {
        if(TextUtils.isEmpty(text)) {
            inputLayoutPassword.setError(getString(R.string.error_password));
            inputPassword.requestFocus();
            return false;
        }
        else {
            inputLayoutPassword.setErrorEnabled(false);
        }
        return true;
    }

    private boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private class CustomTextWatcher implements TextWatcher {

        private EditText editText;

        public CustomTextWatcher(EditText editText) {
            this.editText = editText;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            switch(editText.getId()) {
                case R.id.input_username:
                    validateUsername(editable.toString());
                    break;
                case R.id.input_email :
                    validateEmail(editable.toString());
                    break;
                case R.id.input_password:
                validatePassword(editable.toString());
                    break;

            }

        }
    }
}


