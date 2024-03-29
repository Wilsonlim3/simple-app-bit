package com.example.restapipractice.presentation.ListMenu;

import android.os.Bundle;
import android.util.Log;

import com.example.restapipractice.R;
import com.example.restapipractice.base.BaseActivity;
import com.example.restapipractice.data.model.Account;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListMenuActivity extends BaseActivity {
    private ListMenuAdapter mAdapter;
    List<Account> mAccounts;
    Account mAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_menu);

        FloatingActionButton btn_add = findViewById(R.id.button_add_note);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
//        mAccounts = new ArrayList<>();
        mAccounts = new ArrayList<>();
        mAccounts.add(new Account("1","Tet",35000));
        mAccounts.add(new Account("2","Test",32000));
        mAccounts.add(new Account("3","Tetz",35200));
        Log.d("TEST maccount",mAccounts.get(0)+"");
        mAdapter = new ListMenuAdapter(mAccounts);

//        mAdapter.setMenuList(mAccounts);

        recyclerView.setAdapter(mAdapter);


    }

    @Override
    public int getContentView() {
        return R.layout.activity_list_menu;
    }

    @Override
    public String getScreenTitle() {
        return null;
    }
}
