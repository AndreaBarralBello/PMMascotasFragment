package com.example.mascotasfragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class Categorias extends Fragment {

   public interface OnDataSelectedListener {
       void OnDataSelectedCategorias(String data);
   }

   private OnDataSelectedListener listener;

   Spinner spcategorias;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            listener = (OnDataSelectedListener) context;
        }catch (ClassCastException e){
            listener.OnDataSelectedCategorias(context.toString()+ "implementar");
        }
    }

    @Override
    //se infla el layout
    public @Nullable View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_categorias, container, false );

        return view;
    }

    @Override
    //se trabaja sobre el layout cargado
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //conexion
        super.onViewCreated(view, savedInstanceState);
        spcategorias = view.findViewById(R.id.spcategorias);

        //Conexion a intertet se repite en Categorias, ProductoDetalle, Productos, por eso
        //es mejor crear una interfaz

        RequestQueue queue = Volley.newRequestQueue(view.getContext());

        JsonArrayRequest peticion = new JsonArrayRequest(
                "https://abarral.colexio-karbo.com/2025-27/tiendamascotas/tienda_mascotas.php",
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                }
        );
        queue.add(peticion);






    }
}