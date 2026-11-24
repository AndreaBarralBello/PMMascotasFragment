package com.example.mascotasfragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

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
    public @Nullable View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_categorias, container, false );
       spcategorias = view.findViewById(R.id.spcategorias);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}