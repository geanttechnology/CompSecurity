// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home.availability;

import gu;
import java.io.Serializable;

public class Download
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private boolean available;
    private String displayMessage;

    public Download()
    {
    }

    public String getDisplayMessage()
    {
        return displayMessage;
    }

    public boolean isAvailable()
    {
        return available;
    }

    public void setAvailable(boolean flag)
    {
        available = flag;
    }

    public void setDisplayMessage(String s)
    {
        displayMessage = s;
    }
}
