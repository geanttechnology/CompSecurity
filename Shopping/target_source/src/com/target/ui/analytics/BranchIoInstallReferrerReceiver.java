// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.target.a.a.b;
import io.branch.referral.k;

public class BranchIoInstallReferrerReceiver extends BroadcastReceiver
{

    private static final String LOG_TAG = "BranchIoReferralRcvr";

    public BranchIoInstallReferrerReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        b.d("BranchIoReferralRcvr", (new StringBuilder()).append("Received install referrer broadcast ").append(intent).toString());
        (new k()).onReceive(context, intent);
    }
}
