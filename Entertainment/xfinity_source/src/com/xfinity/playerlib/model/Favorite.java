// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model;

import java.util.Date;

public class Favorite
{

    private boolean adultContent;
    private Date created;
    private String title;

    public Favorite(String s)
    {
        title = s;
        adultContent = false;
    }

    public Favorite(String s, boolean flag)
    {
        title = s;
        adultContent = flag;
    }

    public Favorite(String s, boolean flag, Date date)
    {
        title = s;
        adultContent = flag;
        created = date;
    }

    public Date getCreated()
    {
        return created;
    }

    public String getTitle()
    {
        return title;
    }

    public boolean isAdultContent()
    {
        return adultContent;
    }

    public void setAdultContent(boolean flag)
    {
        adultContent = flag;
    }

    public void setCreated(Date date)
    {
        created = date;
    }

    public void setTitle(String s)
    {
        title = s;
    }
}
