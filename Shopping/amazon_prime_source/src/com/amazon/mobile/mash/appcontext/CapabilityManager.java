// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.appcontext;

import android.content.Context;
import com.amazon.mobile.mash.util.MASHUtil;

// Referenced classes of package com.amazon.mobile.mash.appcontext:
//            Capability

public class CapabilityManager
{

    private Context mApplicationContext;

    public CapabilityManager(Context context)
    {
        mApplicationContext = context.getApplicationContext();
        Capability.init(this);
    }

    public long formatCapabilities()
    {
        long l = 0L;
        Capability acapability[] = Capability.values();
        int j = acapability.length;
        for (int i = 0; i < j;)
        {
            Capability capability = acapability[i];
            long l1 = l;
            if (capability.isAvailable())
            {
                l1 = l | (long)Math.pow(2D, capability.getCapabilityId());
            }
            i++;
            l = l1;
        }

        return l;
    }

    public Context getApplicationContext()
    {
        return mApplicationContext;
    }

    public boolean isAvailableAivPlayback()
    {
        return false;
    }

    public boolean isAvailableAppNavMenu()
    {
        return false;
    }

    public boolean isAvailableAppstore()
    {
        return false;
    }

    public boolean isAvailableEnforceParentalControls()
    {
        return false;
    }

    public boolean isAvailablePdfViewer()
    {
        return true;
    }

    public boolean isAvailableShowAdsBrowser()
    {
        return false;
    }

    public boolean isAvailableShowAmazonPoints()
    {
        return false;
    }

    public boolean isAvailableShowCardScannerCredit()
    {
        return false;
    }

    public boolean isAvailableShowContactPicker()
    {
        return MASHUtil.isAndroidPermissionGranted(mApplicationContext, "android.permission.GET_ACCOUNTS") && MASHUtil.isAndroidPermissionGranted(mApplicationContext, "android.permission.READ_CONTACTS");
    }

    public boolean isAvailableShowDeliveryDestinationPicker()
    {
        return false;
    }

    public boolean isAvailableShowNotificationSettings()
    {
        return false;
    }

    public boolean isAvailableSmile()
    {
        return false;
    }
}
