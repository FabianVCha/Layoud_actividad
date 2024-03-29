package Sapo.layoud_actividad;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link linearFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class linearFragment extends Fragment {

    private Spinner DISPONIBLE_C;
    private RadioGroup Grupo;
    private TextView Saludo;
    private Button siguiente;
    private Button atras;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public linearFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment linearFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static linearFragment newInstance(String param1, String param2) {
        linearFragment fragment = new linearFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_linear, container, false);
    }





  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
    super.onViewCreated(view, savedInstanceState);
    //recibir el bundle
    String Nombre = getArguments().getString("amount");


    //set texto de bienvenida
    Saludo = (TextView) view.findViewById(R.id.SALUDO);
    Saludo.setText("BIENVENIDO "+Nombre+", ¿A DONDE VAMOS?");


    //Spinner
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
      getActivity(),
      R.array.fechas,
      android.R.layout.simple_spinner_item
    );
    DISPONIBLE_C= (Spinner) view.findViewById(R.id.lugar);
    DISPONIBLE_C.setAdapter(adapter);
    DISPONIBLE_C.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      }
      @Override
      public void onNothingSelected(AdapterView<?> adapterView) {
      }
    });

    //BOTONES
    atras = (Button) view.findViewById(R.id.atras_linear);
    siguiente = (Button) view.findViewById(R.id.siguiente_linear);

    atras.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Navigation.findNavController(v).navigate(R.id.bienvenidaFragment);
      }
    });

    siguiente.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        Grupo = (RadioGroup) view.findViewById(R.id.grupo_act);
        int check = Grupo.getCheckedRadioButtonId();
        if(check == -1){
         re_escritura();
        }else{
          Navigation.findNavController(v).navigate(R.id.frameFragment);
        }

      }

      private void re_escritura() {
        Saludo.setText("PORFAVOR LLENE TODOS LOS ESPACIOS");
      }
    });




  }




  }
