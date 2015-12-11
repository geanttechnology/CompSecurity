// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class NotificationTarget
{

    private String applicationId;
    private String destination;
    private int type;

    public NotificationTarget()
    {
    }

    public String getApplicationId()
    {
        return applicationId;
    }

    public String getDestination()
    {
        return destination;
    }

    public int getType()
    {
        return type;
    }

    public void setApplicationId(String s)
    {
        applicationId = s;
    }

    public void setDestination(String s)
    {
        destination = s;
    }

    public void setType(int i)
    {
        type = i;
    }
}
