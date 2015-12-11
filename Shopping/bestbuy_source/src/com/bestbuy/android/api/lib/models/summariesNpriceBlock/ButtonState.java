// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.summariesNpriceBlock;

import gu;
import java.io.Serializable;

public class ButtonState
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String availabilityType;
    private String buttonStateID;
    private boolean commerceUnavailable;
    private String displayName;
    private boolean purchasable;

    public ButtonState()
    {
    }

    public String getAvailabilityType()
    {
        return availabilityType;
    }

    public String getButtonStateID()
    {
        return buttonStateID;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public boolean isCommerceUnavailable()
    {
        return commerceUnavailable;
    }

    public boolean isPurchasable()
    {
        return purchasable;
    }

    public void setAvailabilityType(String s)
    {
        availabilityType = s;
    }

    public void setButtonStateID(String s)
    {
        buttonStateID = s;
    }

    public void setCommerceUnavailable(boolean flag)
    {
        commerceUnavailable = flag;
    }

    public void setDisplayName(String s)
    {
        displayName = s;
    }

    public void setPurchasable(boolean flag)
    {
        purchasable = flag;
    }
}
