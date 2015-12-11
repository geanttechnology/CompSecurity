// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.store.availability;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.store.availability:
//            CheckLink

public class Ship
    implements gu, Serializable
{

    private String available;
    private CheckLink checkLink;
    private String displayMessage;

    public Ship()
    {
    }

    public String getAvailable()
    {
        return available;
    }

    public CheckLink getCheckLink()
    {
        return checkLink;
    }

    public String getDisplayMessage()
    {
        return displayMessage;
    }

    public void setAvailable(String s)
    {
        available = s;
    }

    public void setCheckLink(CheckLink checklink)
    {
        checkLink = checklink;
    }

    public void setDisplayMessage(String s)
    {
        displayMessage = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ClassPojo [displayMessage = ").append(displayMessage).append(", checkLink = ").append(checkLink).append(", available = ").append(available).append("]").toString();
    }
}
