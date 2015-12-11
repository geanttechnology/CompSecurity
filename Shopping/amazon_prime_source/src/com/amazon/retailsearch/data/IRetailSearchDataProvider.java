// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data;

import android.graphics.Bitmap;
import com.amazon.retailsearch.data.assets.AssetFetchType;
import com.amazon.retailsearch.data.stores.StoreManager;
import com.amazon.searchapp.retailsearch.model.PersonalizedSuggestions;
import com.amazon.searchapp.retailsearch.model.SearchSuggestions;

public interface IRetailSearchDataProvider
{

    public abstract void clearAssets();

    public abstract void clearMetrics();

    public abstract void clearSuggestions();

    public abstract PersonalizedSuggestions deletePersonalizedSuggestions(String s, String s1);

    public abstract void fetchAssets(AssetFetchType assetfetchtype);

    public abstract void fetchMetrics();

    public abstract Bitmap getBadge(String s);

    public abstract String getLatency(String s);

    public abstract void getLocation(com.amazon.retailsearch.data.location.LocationLoader.LocationResultListener locationresultlistener);

    public abstract PersonalizedSuggestions getPersonalizedSuggestions(String s);

    public abstract PersonalizedSuggestions getPersonalizedSuggestions(String s, boolean flag);

    public abstract SearchSuggestions getSearchSuggestions(String s, String s1, String s2);

    public abstract StoreManager getStoreManager();
}
