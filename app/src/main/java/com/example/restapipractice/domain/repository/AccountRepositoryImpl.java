package com.example.restapipractice.domain.repository;

import com.example.restapipractice.data.model.Account;
import com.example.restapipractice.data.network.interceptor.response.CategoryResponse;
import com.example.restapipractice.data.source.AccountDataSource;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AccountRepositoryImpl implements AccountRepository {
    private AccountDataSource mAccountCloudDataSource;
    private AccountDataSource mAccountLocalDataSource;

    public AccountRepositoryImpl(AccountDataSource accountCloudDataSource,
                                 AccountDataSource accountLocalDataSource){
        mAccountCloudDataSource = accountCloudDataSource;
        mAccountLocalDataSource = accountLocalDataSource;
    }

    @Override
    public Observable<CategoryResponse> retrieveCategory() {
        return mAccountCloudDataSource.retrieveCategory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<Account>> retrieveAllAccount() {

        //dari source account data source
        return mAccountLocalDataSource.retrieveAllAccount();
    }
}
