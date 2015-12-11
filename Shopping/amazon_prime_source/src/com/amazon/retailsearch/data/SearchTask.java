// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data;

import com.amazon.retailsearch.data.search.AbstractResultStreamListener;

public interface SearchTask
{
    public static class SearchTaskListener extends AbstractResultStreamListener
    {

        public SearchTaskListener()
        {
        }
    }


    public abstract void addListener(SearchTaskListener searchtasklistener);

    public abstract void close();

    public abstract com.amazon.retailsearch.data.search.ResultStream.Status getStatus();

    public abstract boolean isLoading();

    public abstract void loadNext();

    public abstract void loadNext(int i);

    public abstract boolean removeAllListeners();

    public abstract boolean removeListener(SearchTaskListener searchtasklistener);

    public abstract void retry();
}
