package com.example.quizzed;

import static android.content.ContentValues.TAG;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity6 extends AppCompatActivity {

   private DrawerLayout drawerLayout;
   private NavigationView navigationView;
   private Toolbar tool;
   RecyclerView recyclerView;
   LinearLayoutManager layoutManager;
   List<quiz_names> list;
   Adapter adapter;
   int position ;
   TextView textView;
    String quesno,quizname1234,questiondate123,email;
    FirebaseAuth auth;
    TextView textusername;
    TextView textemail;
    FirebaseUser user;
    FirebaseFirestore db;
    Button btn;



    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        tool=findViewById(R.id.tool_bar);
        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        if(user!=null){
            email=user.getEmail();
        }


            db=FirebaseFirestore.getInstance();
        Query query=db.collection("quiz_names");



        setupfirestore();
        initdata();
        initRecylarView();







        setSupportActionBar(tool);
       ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,tool,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
       drawerLayout.addDrawerListener(toggle);
       toggle.syncState();

       navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if(id==R.id.nav_logout)
                {  FirebaseAuth.getInstance().signOut();
                    Intent intent=new Intent(MainActivity6.this, MainActivity3.class);
                    startActivity(intent);
                    finish();
                }else if (id==R.id.nav_share){
                    Toast.makeText(MainActivity6.this, "Working on it :D", Toast.LENGTH_LONG).show();
                }else if (id==R.id.nav_rate){
                    Toast.makeText(MainActivity6.this, "Working on this too :D", Toast.LENGTH_LONG).show();
                } else if (id == R.id.nav_profile) {
                    loadfragment(new Fragment1());

                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
           }
       });
    }

    private void setupfirestore(){
        db.collection("quiz_names")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());

                                String one =document.getString("quiz_name_name");
                                String two= document.getString("quiz_date");
                                String three=document.getString("questions");
                                Map<String,Object> ques= document.getData();

                              //   Log.d(TAG,ques.get("1").toString());


                                Log.d(TAG,ques.toString());
                                list.add(new quiz_names(one,two,three,ques));
                                adapter.notifyDataSetChanged();
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());

                        }
                    }
                });
    }







   private void initdata() {
    list =new ArrayList<>();
    }

    private void initRecylarView() {
        recyclerView=findViewById(R.id.recycler_view);
        layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(recyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);




        adapter =new Adapter(list, new Adapter.ItemClickListner() {
            @Override
            public void oniteamclick(quiz_names details) {
                Map pos=details.getMap();
                Log.d(TAG,pos.toString());




                 quizname1234=details.getQuiz_name();
                 quesno=details.getQuestions();
                 questiondate123=details.getQuiz_date();

                loadfragment(new Fragment2());
            }
        });
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void loadfragment(Fragment fragment) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        Bundle data=new Bundle();
        data.putString("questionno",quesno);
        data.putString("questioname",quizname1234);
        data.putString("questiondate",questiondate123);
        data.putString("email",email);
        fragment.setArguments(data);
        fragmentTransaction.add(R.id.container,fragment);
        fragmentTransaction.commit();
        fragmentTransaction.addToBackStack(null);
    }


}