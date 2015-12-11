// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.interaction;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.amazon.retailsearch.android.api.display.results.ResultsDisplayListeners;
import com.amazon.retailsearch.android.api.display.results.item.RetailSearchResultItem;
import com.amazon.retailsearch.metrics.DetailPageType;

public interface UserInteractionListener
    extends ResultsDisplayListeners
{

    public abstract void endPage(View view);

    public abstract String getSelectedAsin();

    public abstract void resultItemBuilt(ViewGroup viewgroup, ImageView imageview, String s);

    public abstract void resultItemSelected(RetailSearchResultItem retailsearchresultitem, DetailPageType detailpagetype);

    public abstract void retrySearch();

    public abstract void search(String s);

    public abstract void startPage(View view, int i);
}
