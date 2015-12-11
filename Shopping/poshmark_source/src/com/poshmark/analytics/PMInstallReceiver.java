// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.analytics.tracking.android.CampaignTrackingReceiver;
import com.mobileapptracker.Tracker;
import net.singular.sdk.InstallReceiver;

public class PMInstallReceiver extends BroadcastReceiver
{

    public PMInstallReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        (new Tracker()).onReceive(context, intent);
        (new InstallReceiver()).onReceive(context, intent);
        (new CampaignTrackingReceiver()).onReceive(context, intent);
    }
}
