// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;


public interface AppIntent
{

    public abstract String getType();

    public abstract String getValue();

    public abstract void setType(String s);

    public abstract void setValue(String s);
}
