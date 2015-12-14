// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.photos.device.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.metrics.customer.ReferrerParser;

public class GooglePlayAdsInstallReceiver extends BroadcastReceiver
{

    private static final String TAG = com/amazon/photos/device/receivers/GooglePlayAdsInstallReceiver.getName();

    public GooglePlayAdsInstallReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if (intent != null)
        {
            if ((intent = intent.getStringExtra("referrer")) != null)
            {
                context = PreferenceManager.getDefaultSharedPreferences(context);
                context.edit().putString("referrer", intent).apply();
                intent = ReferrerParser.parseRefString(intent);
                GLogger.i(TAG, "Install referrer detected: %s", new Object[] {
                    intent
                });
                if (intent != null)
                {
                    context.edit().putString("AMZN_REF_KEY", intent).apply();
                    return;
                } else
                {
                    GLogger.e(TAG, "No ref key found", new Object[0]);
                    return;
                }
            }
        }
    }

}
