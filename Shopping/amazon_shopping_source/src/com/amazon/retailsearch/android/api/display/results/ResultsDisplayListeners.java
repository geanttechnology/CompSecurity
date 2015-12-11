// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.display.results;

import com.amazon.retailsearch.android.api.display.results.listeners.ResultItemBuildListener;
import com.amazon.retailsearch.android.api.display.results.listeners.ResultItemFocusListener;
import com.amazon.retailsearch.android.api.display.results.listeners.ResultItemSelectionListener;
import com.amazon.retailsearch.android.api.display.results.listeners.SearchChangedListener;
import com.amazon.retailsearch.android.api.display.results.listeners.SearchPageLoadListener;

public interface ResultsDisplayListeners
{

    public abstract void addListener(ResultItemBuildListener resultitembuildlistener);

    public abstract void addListener(ResultItemFocusListener resultitemfocuslistener);

    public abstract void addListener(ResultItemSelectionListener resultitemselectionlistener);

    public abstract void addListener(SearchChangedListener searchchangedlistener);

    public abstract void addListener(SearchPageLoadListener searchpageloadlistener);

    public abstract void removeAllListeners();

    public abstract void removeListener(ResultItemBuildListener resultitembuildlistener);

    public abstract void removeListener(ResultItemFocusListener resultitemfocuslistener);

    public abstract void removeListener(ResultItemSelectionListener resultitemselectionlistener);

    public abstract void removeListener(SearchChangedListener searchchangedlistener);

    public abstract void removeListener(SearchPageLoadListener searchpageloadlistener);
}
