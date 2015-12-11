// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.analytics.tracking.android.j;
import com.localytics.android.ReferralReceiver;
import com.wishabi.flipp.b.a;

public class InstallBroadcastReceiver extends BroadcastReceiver
{

    public InstallBroadcastReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        SharedPreferences sharedpreferences = a.a.b.getSharedPreferences("com.wishabi.flipp.preferences", 0);
        Object obj = intent.getExtras();
        if (obj != null)
        {
            obj = ((Bundle) (obj)).getString("referrer", "none");
        } else
        {
            obj = "none";
        }
        sharedpreferences.edit().putString("referrer", ((String) (obj))).commit();
        (new ReferralReceiver()).onReceive(context, intent);
        (new j()).onReceive(context, intent);
    }
}
