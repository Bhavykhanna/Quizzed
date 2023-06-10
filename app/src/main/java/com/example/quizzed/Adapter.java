package com.example.quizzed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

private List<quiz_names> list;
private ItemClickListner mitemClickListner;

 Adapter(List<quiz_names> list,ItemClickListner itemClickListner){
    this.list=list;
    this.mitemClickListner=itemClickListner;
 }

 public int positon;



    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.iteams_list,parent,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
      String name1=list.get(position).getQuiz_name();
      String date=list.get(position).getQuiz_date();

      holder.setdata(name1,date);

      holder.itemView.setOnClickListener(view ->{
          mitemClickListner.oniteamclick(list.get(position));



      });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface ItemClickListner{
        void oniteamclick(quiz_names details);
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
    private TextView name_quiz;
    private TextView date1;

       public ViewHolder(@NonNull View itemView) {
          super(itemView);

          date1=itemView.findViewById(R.id.card2);
          name_quiz=itemView.findViewById(R.id.card1);
          itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
               positon=getAdapterPosition();

             }
          });



       }

       public void setdata(String name,String date) {
          name_quiz.setText(name);
          date1.setText(date);


       }
    }



    }



