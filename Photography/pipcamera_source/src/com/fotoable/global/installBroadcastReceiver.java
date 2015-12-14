// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.global;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class installBroadcastReceiver extends BroadcastReceiver
{

    public installBroadcastReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Log.d("installBroadcastReceiver", (new StringBuilder()).append("ReferralReceiver").append(intent.getAction()).toString());
        Log.d("installBroadcastReceiver", (new StringBuilder()).append("ReferralReceiver").append(intent.getDataString()).toString());
        Log.d("installBroadcastReceiver", (new StringBuilder()).append("ReferralReceiver").append(intent.toString()).toString());
        Log.d("installBroadcastReceiver", (new StringBuilder()).append("ReferralReceiver").append(intent.getStringExtra("referrer")).toString());
    }
}
