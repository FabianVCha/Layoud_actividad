package Sapo.layoud_actividad;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_main extends AppCompatActivity implements View.OnClickListener{

  //VARIABLES QUE SE VAN A USAR
  private TextView TITULO_C;
  private TextView SALIDA_T;
  private EditText NOMBRE_C;
  private EditText BUSQUEDA_C;
  private Button BUSCAR_C;
  private RadioGroup SELECCION_C;
  private Spinner DISPONIBLE_C;



// codigo de funciones asignadas
  @Override
  protected void onCreate(Bundle savedInstanceStare) {


    super.onCreate(savedInstanceStare);
    setContentView(R.layout.linear);//se relaciona con el layoud ya creado

    //TEXTVIEW
    SALIDA_T = (TextView) findViewById(R.id.MENSAJE);
    TITULO_C = (TextView) findViewById(R.id.TITULO); //relaciona TITULO_C con el textview del layoud
    TITULO_C.setTextSize(40);
    TITULO_C.setTextColor(Color.BLUE);
    TITULO_C.setText("HOTELES FACUNDO"); //este es el texto que se vera en pantalla

    //EDITTEXT
    NOMBRE_C = (EditText) findViewById(R.id.NOMBRE);
    NOMBRE_C.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

      }

      @Override
      public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
      }

      @Override
      public void afterTextChanged(Editable editable) {
        NOMBRE_C.setTextColor(Color.GREEN);

      }
    });

    BUSQUEDA_C = (EditText) findViewById(R.id.BUSQUEDA);
    BUSQUEDA_C.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

      }

      @Override
      public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

      }

      @Override
      public void afterTextChanged(Editable editable) {
        BUSQUEDA_C.setTextColor(Color.GREEN);
      }
    });//LISTENER PARA EL CAMBIO DE CONTENIDO DE VARIABLE

    //BUTTON
    BUSCAR_C = (Button) findViewById(R.id.BUSCAR);
    BUSCAR_C.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        SALIDA_T.setText("ANFRITION " + NOMBRE_C.getText() + "SI HAY DISPONIVILIDAD PARA " + BUSQUEDA_C.getText());
      }
    });

    //RADIOGROUP

    SELECCION_C = (RadioGroup) findViewById(R.id.SELECCION);
    SELECCION_C.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.PISCINA) {

        } else if (i == R.id.SAUNA) {

        }
      }
    });


    //Spinner

    ArrayAdapter<CharSequence> adapter  = ArrayAdapter.createFromResource(
      this,
      R.array.fechas,
      android.R.layout.simple_spinner_item
    );

    DISPONIBLE_C = (Spinner) findViewById(R.id.DIPONIBLE);
    DISPONIBLE_C.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String fecha = parent.getItemAtPosition(position).toString();
        Toast.makeText(getBaseContext(), "seleccionado"+fecha, Toast.LENGTH_LONG).show();

      }

      @Override
      public void onNothingSelected(AdapterView<?> adapterView) {

      }
    });



  }


  @Override
  public void onClick(View view) {

  }
}
