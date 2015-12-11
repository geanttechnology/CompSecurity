// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.conversiontracking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

// Referenced classes of package com.google.ads.conversiontracking:
//            a

public class InstallReceiver extends BroadcastReceiver
{

    public InstallReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        String s = intent.getStringExtra("referrer");
        if (!"com.android.vending.INSTALL_REFERRER".equals(intent.getAction()) || s == null)
        {
            return;
        }
        intent = String.valueOf(s);
        if (intent.length() != 0)
        {
            intent = "Received install referrer: ".concat(intent);
        } else
        {
            intent = new String("Received install referrer: ");
        }
        Log.i("GoogleConversionReporter", intent);
        a.a(context, Uri.parse("http://hostname/").buildUpon().appendQueryParameter("referrer", s).build());
    }
}
