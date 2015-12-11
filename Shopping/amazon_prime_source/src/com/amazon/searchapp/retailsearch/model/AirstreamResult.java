// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;


public interface AirstreamResult
{

    public abstract String getCursor();

    public abstract String getFavoritesRequestToken();

    public abstract boolean getNewCursor();

    public abstract String getQueryId();

    public abstract String getRequestId();

    public abstract void setCursor(String s);

    public abstract void setFavoritesRequestToken(String s);

    public abstract void setNewCursor(boolean flag);

    public abstract void setQueryId(String s);

    public abstract void setRequestId(String s);
}
