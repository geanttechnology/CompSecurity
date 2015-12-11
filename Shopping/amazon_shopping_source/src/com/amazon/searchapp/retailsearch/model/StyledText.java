// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;


public interface StyledText
{

    public abstract String getStyle();

    public abstract String getText();

    public abstract String getUrl();

    public abstract void setStyle(String s);

    public abstract void setText(String s);

    public abstract void setUrl(String s);
}
