// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.store.availability;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.store.availability:
//            CheckLink

public class Delivery
    implements gu, Serializable
{

    private boolean available;
    private CheckLink checkLink;
    private String displayMessage;

    public Delivery()
    {
    }

    public CheckLink getCheckLink()
    {
        return checkLink;
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

    public void setCheckLink(CheckLink checklink)
    {
        checkLink = checklink;
    }

    public void setDisplayMessage(String s)
    {
        displayMessage = s;
    }
}
