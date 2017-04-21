package com.handstandsam.maintainableespresso.features.itemdetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.handstandsam.maintainableespresso.di.NetworkModule;
import com.handstandsam.maintainableespresso.models.Item;
import com.handstandsam.maintainableespresso.repository.SessionManager;

import javax.inject.Inject;

public class ItemDetailPresenter {

    public static final String BUNDLE_PARAM_ITEM = "item";
    private final ItemDetailActivity.ItemDetailView view;

    @Inject
    SessionManager sessionManager;

    Item item;

    public ItemDetailPresenter(@NonNull ItemDetailActivity.ItemDetailView view) {
        this.view = view;
        view.getAppComponent().inject(this);
    }

    public void onResume(Intent intent) {

        Bundle extras = intent.getExtras();
        Item item = (Item) extras.get(BUNDLE_PARAM_ITEM);
        this.item = item;

        view.setLabel(item.getLabel());
        view.setImageUrl(NetworkModule.IMAGE_BASE_URL + item.getImage());
        view.setActionBarTitle(item.getLabel());
    }
}