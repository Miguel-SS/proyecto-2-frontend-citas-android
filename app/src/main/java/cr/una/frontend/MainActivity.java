package cr.una.frontend;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends Activity {

    private EditText idTxt;
    private EditText passTxt;
    private Button logInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        idTxt = (EditText) findViewById(R.id.idTxt);
        passTxt = (EditText) findViewById(R.id.passwordTxt);
        logInBtn = (Button) findViewById(R.id.logInBtn);
    }
}
