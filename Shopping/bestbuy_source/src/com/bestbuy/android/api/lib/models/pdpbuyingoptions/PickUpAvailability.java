// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpbuyingoptions;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdpbuyingoptions:
//            CheckStoresLink

public class PickUpAvailability
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private boolean available;
    private CheckStoresLink checkStoresLink;
    private String displayMessage;

    public PickUpAvailability()
    {
    }

    public CheckStoresLink getCheckStoresLink()
    {
        return checkStoresLink;
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

    public void setCheckStoresLink(CheckStoresLink checkstoreslink)
    {
        checkStoresLink = checkstoreslink;
    }

    public void setDisplayMessage(String s)
    {
        displayMessage = s;
    }
}
