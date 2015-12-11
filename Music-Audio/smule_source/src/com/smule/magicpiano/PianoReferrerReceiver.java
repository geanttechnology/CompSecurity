// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.magicpiano;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sponsorpay.advertiser.InstallReferrerReceiver;

public class PianoReferrerReceiver extends BroadcastReceiver
{

    public static final String a = com/smule/magicpiano/PianoReferrerReceiver.getName();

    public PianoReferrerReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        (new InstallReferrerReceiver()).onReceive(context, intent);
    }

}
