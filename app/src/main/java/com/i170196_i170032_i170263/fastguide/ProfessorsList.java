package com.i170196_i170032_i170263.fastguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ProfessorsList extends AppCompatActivity {

    ImageView BackBtn;
    RecyclerView ProfessorRV;
    List<ProfessorModel> ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professors_list);

        BackBtn = findViewById(R.id.ProfessorsListScreenBackBtn);
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ls = new ArrayList<>();
        ls.add(new ProfessorModel("Professor 1","Course#1,Course#2"));
        ls.add(new ProfessorModel("Professor 1","Course#1,Course#2"));
        ls.add(new ProfessorModel("Professor 1","Course#1,Course#2"));
        ls.add(new ProfessorModel("Professor 1","Course#1,Course#2"));
        ls.add(new ProfessorModel("Professor 1","Course#1,Course#2"));
        ls.add(new ProfessorModel("Professor 1","Course#1,Course#2"));
        ls.add(new ProfessorModel("Professor 1","Course#1,Course#2"));
        ls.add(new ProfessorModel("Professor 1","Course#1,Course#2"));
        ls.add(new ProfessorModel("Professor 1","Course#1,Course#2"));
        ls.add(new ProfessorModel("Professor 1","Course#1,Course#2"));

        ProfessorRV = findViewById(R.id.ProfessorRV);
        ProfessorAdapter adapter = new ProfessorAdapter(ls,this);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        ProfessorRV.setLayoutManager(lm);
        ProfessorRV.setAdapter(adapter);
    }
}