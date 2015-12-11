// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;


public interface CustomRefinementFilter
{

    public abstract String getDetail();

    public abstract String getId();

    public abstract String getLabel();

    public abstract int getPriority();

    public abstract void setDetail(String s);

    public abstract void setId(String s);

    public abstract void setLabel(String s);

    public abstract void setPriority(int i);
}
