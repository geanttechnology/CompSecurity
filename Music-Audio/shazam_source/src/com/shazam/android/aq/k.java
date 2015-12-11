// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aq;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.shazam.android.advert.c;
import com.shazam.android.persistence.n.b;

public final class k
    implements c
{

    private final Context b;
    private final b c;

    public k(Context context, b b1)
    {
        b = context;
        c = b1;
    }

    private com.google.android.gms.ads.identifier.AdvertisingIdClient.Info e()
    {
        com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info;
        try
        {
            info = AdvertisingIdClient.getAdvertisingIdInfo(b);
        }
        catch (Exception exception)
        {
            return null;
        }
        return info;
    }

    public final String a()
    {
        String s = null;
        com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info = e();
        if (info != null)
        {
            s = info.getId();
            c.b("pk_google_play_ad_id", s);
        }
        return s;
    }

    public final Boolean b()
    {
        Boolean boolean1 = null;
        com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info = e();
        if (info != null)
        {
            boolean1 = Boolean.valueOf(info.isLimitAdTrackingEnabled());
            c.b("pk_google_play_ad_tracking_limited", boolean1.booleanValue());
        }
        return boolean1;
    }

    public final String c()
    {
        return c.a("pk_google_play_ad_id", "");
    }

    public final boolean d()
    {
        return c.b("pk_google_play_ad_tracking_limited");
    }
}
