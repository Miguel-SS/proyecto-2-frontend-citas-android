package cr.una.frontend;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import cr.una.frontend.model.Patient;
import cr.una.frontend.service.ServiceFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class MainActivity extends Activity {

    private static final Logger logger = LogManager.getLogger(MainActivity.class);

    private ServiceFacade service;

    private EditText idTxt;
    private EditText passTxt;
    private Button logInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            init();
        } catch (IOException e) {
            logger.error("Error en main controller", e);
        }
    }

    private void init() throws IOException {
        service = new ServiceFacade();

        idTxt = (EditText) findViewById(R.id.idTxt);
        passTxt = (EditText) findViewById(R.id.passwordTxt);
        logInBtn = (Button) findViewById(R.id.logInBtn);

        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginAction();
            }
        });
    }

    private void loginAction() {
        int id = Integer.parseInt(idTxt.getText().toString());
        String password = passTxt.getText().toString();

        Object auxUser = service.searchUser(id);
        if (auxUser != null) {
            if (auxUser.getClass() == Patient.class) {
                if (verifyPass(id, password, (Patient) auxUser)) {
                    /*
                    view.dispose();
                    new AdminView((Admin) auxUser, service);
                     */
                } else { /*view.showError("Contrasena o usuario incorrecto");*/ }
            }
        } else { /*view.showError("Usuario no encontrado");*/ }
    }

    private boolean verifyPass(int id, String password, Patient patient) {
        if (password != null && -1 != id && !"".equals(password)) {
            if (patient != null) {
                return id == patient.getId() && password.equals(patient.getPassword());
            }
        }
        return false;
    }

}
