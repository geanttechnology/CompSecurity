// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

class a
{

    private final ConnectivityManager a;

    final a a()
    {
        NetworkInfo networkinfo = a.getActiveNetworkInfo();
        if (networkinfo == null || !networkinfo.isConnected())
        {
            return new a(false, -1, -1);
        } else
        {
            return new a(true, networkinfo.getType(), networkinfo.getSubtype());
        }
    }

    ()
    {
        a = null;
    }

    a(Context context)
    {
        a = (ConnectivityManager)context.getSystemService("connectivity");
    }
}
