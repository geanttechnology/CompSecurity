// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

public interface ResultsMetadata
{

    public abstract long getFirstItem();

    public abstract long getItemCount();

    public abstract List getResultsInfoStyledLabel();

    public abstract String getResultsLabel();

    public abstract long getTotalResults();

    public abstract void setFirstItem(long l);

    public abstract void setItemCount(long l);

    public abstract void setResultsInfoStyledLabel(List list);

    public abstract void setResultsLabel(String s);

    public abstract void setTotalResults(long l);
}
