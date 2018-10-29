package in.nfnlabs.mymockito;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    private boolean validEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }



    private boolean validPassword(String passcode) {
        if( !TextUtils.isEmpty(passcode) ){
            return true;
        }
        return false;
    }

    public void userInputValidator(){
        if (!validEmail(etEmail.getText().toString()) && !validPassword(etPassword.getText().toString()) ) {
            Toast.makeText(MainActivity.this,"Enter valid inputs",Toast.LENGTH_LONG).show();
            }
        else {
            Intent i = new Intent(this, LandingPageActivity.class);
            startActivity(i);
        }

    }


    @OnClick({R.id.et_email, R.id.et_password, R.id.button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.et_email:
                break;
            case R.id.et_password:
                break;
            case R.id.button:
                userInputValidator();
                break;

        }
    }
}
