// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.database.DataSetObserver;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.lang.ref.WeakReference;

// Referenced classes of package com.ebay.mobile.activities:
//            eBay

static class activityReference extends DataSetObserver
{

    private final WeakReference activityReference;

    public void onChanged()
    {
        super.onChanged();
        eBay ebay = (eBay)activityReference.get();
        if (ebay == null)
        {
            return;
        } else
        {
            DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
            eBay.access$100(ebay);
            eBay.access$500(ebay, deviceconfiguration);
            return;
        }
    }

    A(eBay ebay)
    {
        activityReference = new WeakReference(ebay);
    }
}
