// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.net.api.search.SearchResult;
import com.ebay.nautilus.domain.data.ItemCurrency;
import java.util.ArrayList;
import java.util.Date;

// Referenced classes of package com.ebay.mobile.search:
//            SearchResultFragment

public static interface 
{

    public abstract void onIafTokenFailure();

    public abstract void onRelatedSearchItemClicked(ArrayList arraylist);

    public abstract void onRequestTermination();

    public abstract void onSearchComplete(SearchResult searchresult);

    public abstract void onSearchError(boolean flag);

    public abstract void onSearchItemClicked(long l, Date date, ItemCurrency itemcurrency, boolean flag, com.ebay.common.stener stener, int i);

    public abstract void onSearchStarted(SearchParameters searchparameters);
}
