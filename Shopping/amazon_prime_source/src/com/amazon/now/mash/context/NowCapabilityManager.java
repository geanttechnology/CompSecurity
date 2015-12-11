// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash.context;

import android.content.Context;
import com.amazon.mobile.mash.appcontext.CapabilityManager;

public class NowCapabilityManager extends CapabilityManager
{

    public NowCapabilityManager(Context context)
    {
        super(context);
    }

    public boolean isAvailableAivPlayback()
    {
        return false;
    }

    public boolean isAvailableAppNavMenu()
    {
        return true;
    }

    public boolean isAvailableAppstore()
    {
        return false;
    }

    public boolean isAvailableEnforceParentalControls()
    {
        return false;
    }

    public boolean isAvailableShowAdsBrowser()
    {
        return false;
    }

    public boolean isAvailableShowAmazonPoints()
    {
        return false;
    }

    public boolean isAvailableShowContactPicker()
    {
        return false;
    }

    public boolean isAvailableShowDeliveryDestinationPicker()
    {
        return false;
    }

    public boolean isAvailableShowNotificationSettings()
    {
        return false;
    }
}
