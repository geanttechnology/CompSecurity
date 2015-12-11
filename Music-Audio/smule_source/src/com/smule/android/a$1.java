// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.smule.android.c.aa;
import com.smule.android.f.p;

// Referenced classes of package com.smule.android:
//            a

final class >
    implements Runnable
{

    final Context a;

    public void run()
    {
        try
        {
            com.google.android.gms.ads.identifier.rtisingIdClient.Info info = AdvertisingIdClient.getAdvertisingIdInfo(a);
            a.c = Boolean.valueOf(info.isLimitAdTrackingEnabled());
            a.b = info.getId();
            p.a(a.getSharedPreferences("network", 0).edit().putString("AdvertisingID", a.b));
            return;
        }
        catch (Exception exception)
        {
            aa.c(a.a, exception.toString());
        }
    }

    t(Context context)
    {
        a = context;
        super();
    }
}
