// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;


public interface ResultsMetadata
{

    public abstract long getFirstItem();

    public abstract long getItemCount();

    public abstract String getResultsLabel();

    public abstract long getTotalResults();
}
