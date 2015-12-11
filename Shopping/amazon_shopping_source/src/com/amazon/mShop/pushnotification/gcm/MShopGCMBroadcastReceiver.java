// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification.gcm;

import android.content.Context;
import com.google.android.gcm.GCMBroadcastReceiver;

// Referenced classes of package com.amazon.mShop.pushnotification.gcm:
//            MShopGCMIntentService

public class MShopGCMBroadcastReceiver extends GCMBroadcastReceiver
{

    public MShopGCMBroadcastReceiver()
    {
    }

    protected String getGCMIntentServiceClassName(Context context)
    {
        return com/amazon/mShop/pushnotification/gcm/MShopGCMIntentService.getName();
    }
}
