package com.example.brainboggle3;



import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

public class MyAdapter_sol  extends RecyclerView.Adapter<MyAdapter_sol.ViewHolder >

{
    private List<ListItem_sol> listItems;
    private Context  context;



    public MyAdapter_sol(List<ListItem_sol> listItems, Context context)
    {
        this.listItems = listItems;
        this.context=context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v= LayoutInflater.from(parent.getContext())
                .inflate((R.layout.show_sol), parent,false);

        return new ViewHolder(v);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        final ListItem_sol listItem =listItems.get(position);

        holder.ques.setText(listItem.getQuestion());
        holder.sol_a.setText(listItem.getSola());
        holder.sol_b.setText(listItem.getSolb());
        holder.sol_c.setText(listItem.getSolc());
        holder.sol_d.setText(listItem.getSold());
        holder.sol_corr.setText(listItem.getSolcorr());




    }

    @Override
    public int getItemCount() {
        return listItems.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView ques;
        public  TextView sol_a;
        public  TextView sol_b;
        public  TextView sol_c;
        public  TextView sol_d;
        public  TextView sol_corr;

        public LinearLayout linearLayout66;


        public ViewHolder(@NonNull View itemView)
        {  super(itemView);
            ques=(TextView)itemView.findViewById(R.id.ques) ;
            sol_a=(TextView)itemView.findViewById(R.id.sol_a) ;
            sol_b=(TextView)itemView.findViewById(R.id.sol_b) ;
            sol_c=(TextView)itemView.findViewById(R.id.sol_c) ;
            sol_d=(TextView)itemView.findViewById(R.id.sol_d) ;
            sol_corr=(TextView)itemView.findViewById(R.id.sol_corr) ;
            linearLayout66=(LinearLayout)itemView.findViewById(R.id.linearLayout66);


        }
    }
}

