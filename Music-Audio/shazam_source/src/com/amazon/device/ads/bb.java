// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

// Referenced classes of package com.amazon.device.ads:
//            co, cm, cn

class bb
{

    private static final String b = com/amazon/device/ads/bb.getSimpleName();
    String a;
    private ConnectivityManager c;
    private final cn d;

    public bb(cm cm1)
    {
        new co();
        d = co.a(b);
        c = (ConnectivityManager)cm1.b().getSystemService("connectivity");
        Object obj = null;
        cm1 = obj;
        try
        {
            if (c != null)
            {
                cm1 = c.getActiveNetworkInfo();
            }
        }
        // Misplaced declaration of an exception variable
        catch (cm cm1)
        {
            d.b("Unable to get active network information: %s", new Object[] {
                cm1
            });
            cm1 = obj;
        }
        if (cm1 != null)
        {
            if (cm1.getType() == 1)
            {
                a = "Wifi";
                return;
            } else
            {
                a = Integer.toString(cm1.getSubtype());
                return;
            }
        } else
        {
            a = Integer.toString(0);
            return;
        }
    }

}
