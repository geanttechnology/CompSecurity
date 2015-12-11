// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.summariesNpriceBlock;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.summariesNpriceBlock:
//            CheckShipLink

public class Ship
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private boolean available;
    private CheckShipLink checkLink;
    private String displayMessage;
    private boolean signatureRequired;

    public Ship()
    {
    }

    public CheckShipLink getCheckLink()
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

    public boolean isSignatureRequired()
    {
        return signatureRequired;
    }

    public void setAvailable(boolean flag)
    {
        available = flag;
    }

    public void setCheckLink(CheckShipLink checkshiplink)
    {
        checkLink = checkshiplink;
    }

    public void setDisplayMessage(String s)
    {
        displayMessage = s;
    }

    public void setSignatureRequired(boolean flag)
    {
        signatureRequired = flag;
    }
}
