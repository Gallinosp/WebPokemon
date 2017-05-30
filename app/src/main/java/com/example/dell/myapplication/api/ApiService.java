package com.example.dell.myapplication.api;

import com.example.dell.myapplication.model.Pokemon;
import com.example.dell.myapplication.model.PokemonRespuesta;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Gallo on 29/05/2017.
 */

public interface ApiService
{

    @GET("pokemon")
    retrofit2.Call<PokemonRespuesta> obtenerListaPokemon(@Query("limit") int limit, @Query("offset") int offset);

    @GET("pokemon/{id}/")
    retrofit2.Call<Pokemon> pokemons (@Path("id")int id);
}
