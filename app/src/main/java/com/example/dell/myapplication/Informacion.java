package com.example.dell.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.myapplication.api.ApiService;
import com.example.dell.myapplication.model.Pokemon;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Informacion extends AppCompatActivity {

    private TextView type;
    private TextView type2;
    private TextView peso;
    private TextView nombre;
    private TextView alto;
    private ListaPokemonAdapter listaPokemonAdapter;
    private Retrofit retrofit;
    private static final String TAG="POKEDEX";
    private ArrayList<Pokemon> dataset;
    private Context context;
    private ImageView foto1ImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
        type = (TextView)findViewById(R.id.type);
        type2 = (TextView)findViewById(R.id.type2);
        nombre = (TextView) findViewById(R.id.nombre);
        peso = (TextView) findViewById(R.id.peso);
        alto = (TextView) findViewById(R.id.alto);
        retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle!=null){
            int codigo= (int) bundle.get("id");
            obtenerDatosPokemon(codigo);
        }
    }

    public void obtenerDatosPokemon(int id) {
        final ApiService service = retrofit.create(ApiService.class);
        Call<Pokemon> dato = service.pokemons(id);

        dato.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                if(response.isSuccessful()){
                    Pokemon dato = response.body();



                    nombre.setText(dato.getName());
                    type.setText(dato.getTypes().get(0).getType().getName());
                    peso.setText(dato.getWeight());
                    alto.setText(dato.getHeight());





                    //type2.setText(dato.getTypes().get(1).getType().getName());
                   // move.setText(dato.getMoves().get(2).getMove());


                }else
                {
                    Log.e(TAG, "onResponse: "+response.errorBody());
                }
            }






            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Log.e(TAG," onFailure: "+t.getMessage());
            }
        });
    }
}