// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.p;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

// Referenced classes of package com.shazam.android.p:
//            e

public final class a
    implements e
{

    private final Context a;

    public a(Context context)
    {
        a = context;
    }

    public final String a()
    {
        NetworkInfo anetworkinfo[] = ((ConnectivityManager)a.getSystemService("connectivity")).getAllNetworkInfo();
        if (anetworkinfo != null)
        {
            int j = anetworkinfo.length;
            for (int i = 0; i < j; i++)
            {
                NetworkInfo networkinfo = anetworkinfo[i];
                if (networkinfo.isConnected())
                {
                    return networkinfo.getTypeName();
                }
            }

        }
        return null;
    }
}
