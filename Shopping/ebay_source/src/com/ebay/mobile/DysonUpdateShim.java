// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;

import com.ebay.mobile.util.LocationUtil;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.dm.DysonDataManager;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.shell.app.ActivityShim;
import com.ebay.nautilus.shell.app.FwActivity;

public class DysonUpdateShim extends ActivityShim
{

    private static final long UPDATE_INTERVAL = 0xdbba0L;
    private static long lastUpdate;

    public DysonUpdateShim()
    {
    }

    protected void onResume()
    {
        super.onResume();
        long l;
        if (DeviceConfiguration.getNoSync().get(DcsNautilusBoolean.PayPalDyson))
        {
            if ((l = System.currentTimeMillis()) - lastUpdate >= 0xdbba0L)
            {
                lastUpdate = l;
                android.app.Activity activity = getActivity();
                ((DysonDataManager)DataManager.get(getFwActivity().getEbayContext(), DysonDataManager.KEY)).load(LocationUtil.getLastKnownLocation(activity));
                return;
            }
        }
    }
}
