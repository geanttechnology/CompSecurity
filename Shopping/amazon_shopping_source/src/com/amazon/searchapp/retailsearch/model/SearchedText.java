// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;


public interface SearchedText
{

    public abstract String getAlias();

    public abstract String getDeleteUrl();

    public abstract String getDisplayAlias();

    public abstract long getEventTimestamp();

    public abstract String getId();

    public abstract String getKeywords();

    public abstract void setAlias(String s);

    public abstract void setKeywords(String s);
}
