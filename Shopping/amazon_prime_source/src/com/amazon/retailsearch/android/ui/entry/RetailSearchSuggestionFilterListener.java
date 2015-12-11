// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import java.util.List;

public interface RetailSearchSuggestionFilterListener
{

    public abstract void afterConstructRows(List list);

    public abstract void afterPublishResults(String s, List list);

    public abstract void beforePerformFiltering();

    public abstract void beforePublishResults(List list, boolean flag);
}
