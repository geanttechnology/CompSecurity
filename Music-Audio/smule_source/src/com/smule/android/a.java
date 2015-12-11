// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.smule.android.c.aa;
import com.smule.android.f.p;
import com.smule.android.network.core.b;

public class a
{

    public static final String a = com/smule/android/a.getName();
    public static String b = null;
    public static Boolean c = Boolean.valueOf(false);

    public a()
    {
    }

    public static void a(Context context)
    {
        if (b == null)
        {
            b = context.getSharedPreferences("network", 0).getString("AdvertisingID", null);
        }
        com.smule.android.network.core.b.a(new Runnable(context) {

            final Context a;

            public void run()
            {
                try
                {
                    com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info = AdvertisingIdClient.getAdvertisingIdInfo(a);
                    a.c = Boolean.valueOf(info.isLimitAdTrackingEnabled());
                    com.smule.android.a.b = info.getId();
                    p.a(a.getSharedPreferences("network", 0).edit().putString("AdvertisingID", com.smule.android.a.b));
                    return;
                }
                catch (Exception exception)
                {
                    aa.c(a.a, exception.toString());
                }
            }

            
            {
                a = context;
                super();
            }
        });
    }

}
