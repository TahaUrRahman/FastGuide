package com.i170196_i170032_i170263.fastguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ReviewSummary extends AppCompatActivity {
    ImageView BackBtn;
    RecyclerView ReviewSummaryRV;
    List<ReviewSummaryModel> ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_summary);

        ReviewSummaryRV=findViewById(R.id.ReviewSummaryRV);
        ls= new ArrayList<>();

        BackBtn = findViewById(R.id.ReviewSummaryScreenBackBtn);
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ls.add(new ReviewSummaryModel("Student 1","Great Teacher"));
        ls.add(new ReviewSummaryModel("Student 1","Great Teacher"));
        ls.add(new ReviewSummaryModel("Student 1","Great Teacher"));
        ls.add(new ReviewSummaryModel("Student 1","Great Teacher"));
        ls.add(new ReviewSummaryModel("Student 1","Great Teacher"));
        ls.add(new ReviewSummaryModel("Student 1","Great Teacher"));
        ls.add(new ReviewSummaryModel("Student 1","Great Teacher"));
        ls.add(new ReviewSummaryModel("Student 1","Great Teacher"));
        ls.add(new ReviewSummaryModel("Student 1","Great Teacher"));
        ls.add(new ReviewSummaryModel("Student 1","Great Teacher"));


        ReviewSummaryAdapter adapter = new ReviewSummaryAdapter(ls,this);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        ReviewSummaryRV.setLayoutManager(lm);
        ReviewSummaryRV.setAdapter(adapter);
    }
}