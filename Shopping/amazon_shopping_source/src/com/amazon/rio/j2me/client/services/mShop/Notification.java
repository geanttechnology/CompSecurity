// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class Notification
{

    private String message;
    private String title;
    private int type;

    public Notification()
    {
    }

    public String getMessage()
    {
        return message;
    }

    public String getTitle()
    {
        return title;
    }

    public int getType()
    {
        return type;
    }

    public void setMessage(String s)
    {
        message = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }

    public void setType(int i)
    {
        type = i;
    }
}
