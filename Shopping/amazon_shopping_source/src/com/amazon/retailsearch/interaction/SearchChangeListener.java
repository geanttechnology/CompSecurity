// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.interaction;

import com.amazon.retailsearch.data.SearchTask;

public interface SearchChangeListener
{

    public abstract void onNewSearch(SearchTask searchtask);
}
