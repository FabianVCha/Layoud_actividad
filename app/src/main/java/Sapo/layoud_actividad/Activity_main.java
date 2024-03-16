package Sapo.layoud_actividad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_main extends AppCompatActivity implements View.OnClickListener{

  @SuppressLint("MissingInflatedId")
  @Override
  protected void onCreate(Bundle savedInstanceStare) {

    super.onCreate(savedInstanceStare);
    setContentView(R.layout.primer);//se relaciona con el layoud ya creado
  }
  @Override
  public void onClick(View view) {

  }
}
