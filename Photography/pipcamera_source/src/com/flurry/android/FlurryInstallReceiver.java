// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.flurry.sdk.hm;
import com.flurry.sdk.kg;
import com.flurry.sdk.lt;

public final class FlurryInstallReceiver extends BroadcastReceiver
{

    static final String a = com/flurry/android/FlurryInstallReceiver.getSimpleName();

    public FlurryInstallReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        kg.a(4, a, (new StringBuilder()).append("Received an Install nofication of ").append(intent.getAction()).toString());
        String s = intent.getExtras().getString("referrer");
        kg.a(4, a, (new StringBuilder()).append("Received an Install referrer of ").append(s).toString());
        if (s == null || !"com.android.vending.INSTALL_REFERRER".equals(intent.getAction()))
        {
            kg.a(5, a, "referrer is null");
            return;
        }
        intent = s;
        if (!s.contains("="))
        {
            kg.a(4, a, (new StringBuilder()).append("referrer is before decoding: ").append(s).toString());
            intent = lt.d(s);
            kg.a(4, a, (new StringBuilder()).append("referrer is: ").append(intent).toString());
        }
        (new hm(context)).a(intent);
    }

}
