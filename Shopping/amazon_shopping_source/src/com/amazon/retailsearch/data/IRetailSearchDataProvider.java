// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data;

import android.graphics.Bitmap;
import com.amazon.retailsearch.data.assets.AssetFetchType;
import com.amazon.searchapp.retailsearch.model.PersonalizedSuggestions;
import com.amazon.searchapp.retailsearch.model.SearchSuggestions;

public interface IRetailSearchDataProvider
{

    public abstract void clearAssets();

    public abstract void clearSuggestions();

    public abstract PersonalizedSuggestions deletePersonalizedSuggestions(String s, String s1);

    public abstract void fetchAssets(AssetFetchType assetfetchtype);

    public abstract Bitmap getBadge(String s);

    public abstract PersonalizedSuggestions getPersonalizedSuggestions(String s);

    public abstract PersonalizedSuggestions getPersonalizedSuggestions(String s, boolean flag);

    public abstract SearchSuggestions getSearchSuggestions(String s, String s1, String s2);
}
