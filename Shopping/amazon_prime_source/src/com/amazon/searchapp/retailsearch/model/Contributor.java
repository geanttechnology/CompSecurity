// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;


public interface Contributor
{

    public abstract String getDisplayableRole();

    public abstract String getName();

    public abstract String getRole();

    public abstract String getUrl();

    public abstract void setDisplayableRole(String s);

    public abstract void setName(String s);

    public abstract void setRole(String s);

    public abstract void setUrl(String s);
}
