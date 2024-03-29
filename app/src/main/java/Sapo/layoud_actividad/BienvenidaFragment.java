package Sapo.layoud_actividad;

import android.graphics.Color;
import android.media.metrics.BundleSession;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BienvenidaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BienvenidaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button BUSCAR_C;
    private EditText Nombre_c;
    private TextView Titulo_c;
    private String Comprobante = "";

    public BienvenidaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BienvenidaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BienvenidaFragment newInstance(String param1, String param2) {
        BienvenidaFragment fragment = new BienvenidaFragment();
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
        return inflater.inflate(R.layout.fragment_bienvenida, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
      super.onViewCreated(view, savedInstanceState);

      Titulo_c = (TextView) view.findViewById(R.id.TITULO);
      BUSCAR_C = (Button) view.findViewById(R.id.buscar);


      BUSCAR_C.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

          Nombre_c = (EditText) view.findViewById(R.id.NOMBRE);
          Comprobante = Nombre_c.getText().toString();
          if(Comprobante.equals("NOMBRE") || Comprobante.equals("")){
            Nombre_c.setTextColor(Color.RED);
          }else{
            Bundle bundle = new Bundle();
            bundle.putString("amount", Comprobante);
            Navigation.findNavController(v).navigate(R.id.linearFragment, bundle);
          }
        }
      });



    }
}
