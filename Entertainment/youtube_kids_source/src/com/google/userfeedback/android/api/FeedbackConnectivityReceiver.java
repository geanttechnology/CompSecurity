// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

// Referenced classes of package com.google.userfeedback.android.api:
//            UserFeedback, UserFeedbackReport, SendUserFeedbackService

public class FeedbackConnectivityReceiver extends BroadcastReceiver
{

    public FeedbackConnectivityReceiver()
    {
    }

    static void setEnabled(Context context, boolean flag)
    {
        PackageManager packagemanager = context.getPackageManager();
        context = new ComponentName(context.getPackageName(), com/google/userfeedback/android/api/FeedbackConnectivityReceiver.getCanonicalName());
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        if (i != packagemanager.getComponentEnabledSetting(context))
        {
            packagemanager.setComponentEnabledSetting(context, i, 1);
        }
    }

    public void onReceive(Context context, Intent intent)
    {
        ConnectivityManager connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
        NetworkInfo networkinfo = (NetworkInfo)intent.getParcelableExtra("networkInfo");
        intent = networkinfo;
        if (networkinfo == null)
        {
            intent = connectivitymanager.getActiveNetworkInfo();
        }
        while (intent == null || !intent.isConnected() || !connectivitymanager.getBackgroundDataSetting() || UserFeedback.userFeedback() == null || UserFeedback.userFeedback().getReport() == null || !UserFeedback.userFeedback().getReport().shouldSubmitReport()) 
        {
            return;
        }
        context.startService(new Intent(context, com/google/userfeedback/android/api/SendUserFeedbackService));
    }
}
