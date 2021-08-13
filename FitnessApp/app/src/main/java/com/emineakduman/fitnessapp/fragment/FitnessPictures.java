package com.emineakduman.fitnessapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.emineakduman.fitnessapp.FitnessMove;
import com.emineakduman.fitnessapp.PopupActivity;
import com.emineakduman.fitnessapp.R;
import com.emineakduman.fitnessapp.recyclerview.FitnessPictureAdapter;

import java.util.ArrayList;

public class FitnessPictures extends Fragment implements FitnessPictureAdapter.MyListener{
    private FitnessPictureAdapter fitnessPictureAdapter;
    private RecyclerView recyclerView;
    private ArrayList<FitnessMove> fitnessMoves;

    public static FitnessPictures newInstance(){
        return new FitnessPictures();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fitness_pictures,container,false);
        fitnessPictureAdapter = new FitnessPictureAdapter((AppCompatActivity) getActivity(),this);
        fitnessMoves = fitnessPictureAdapter.getFitnessMoves();
        recyclerView = rootView.findViewById(R.id.fragment_fitness_pictures_recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
      if(isAdded()) {
          recyclerView.setAdapter(fitnessPictureAdapter);
      }
      getFitnessMoves(fitnessMoves);
        return rootView;
    }


    private ArrayList<FitnessMove> getFitnessMoves (ArrayList<FitnessMove> fitnessMoves){
        for (int i=0; i<16; i++){
        fitnessMoves.add(new FitnessMove("Fitnes Move Name 1" + i,
                "https://www.atilsamancioglu.com/wp-content/uploads/2018/06/fitness" +i+".jpg",
                "Fitnes Move Description",100));}
        return fitnessMoves;
    }

    @Override
    public void MyListener(FitnessMove fitnessMove) {
        System.out.println("Fitness Move : "+fitnessMove.getFitnessName());

        Intent intent = PopupActivity.newIntent(getActivity(),fitnessMove);
        startActivity(intent);

    }
}
