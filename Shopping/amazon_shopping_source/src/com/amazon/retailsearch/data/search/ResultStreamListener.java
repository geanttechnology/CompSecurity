// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.search;

import com.amazon.searchapp.retailsearch.client.SearchListener;

public interface ResultStreamListener
    extends SearchListener
{

    public abstract void clearError();

    public abstract void close();

    public abstract void endPage();

    public abstract void endResult();

    public abstract void ready();

    public abstract void startPage();

    public abstract void startResult();
}
