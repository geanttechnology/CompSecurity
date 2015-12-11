// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.a.b;
import com.google.a.c;
import com.google.a.d;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.zza;
import java.util.Date;
import java.util.HashSet;

public final class zzcz
{

    public static int zza(b b1)
    {
        class _cls1
        {

            static final int zzvg[];
            static final int zzvh[];

            static 
            {
                zzvh = new int[b.values().length];
                try
                {
                    zzvh[b.d.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    zzvh[b.a.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    zzvh[b.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    zzvh[b.b.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                zzvg = new int[c.values().length];
                try
                {
                    zzvg[c.c.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    zzvg[c.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    zzvg[c.a.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.zzvh[b1.ordinal()])
        {
        default:
            return 0;

        case 2: // '\002'
            return 1;

        case 3: // '\003'
            return 2;

        case 4: // '\004'
            return 3;
        }
    }

    public static d zzb(AdSizeParcel adsizeparcel)
    {
        int i = 0;
        d ad[] = new d[6];
        ad[0] = d.a;
        ad[1] = d.b;
        ad[2] = d.c;
        ad[3] = d.d;
        ad[4] = d.e;
        ad[5] = d.f;
        for (; i < ad.length; i++)
        {
            if (ad[i].a() == adsizeparcel.width && ad[i].b() == adsizeparcel.height)
            {
                return ad[i];
            }
        }

        return new d(com.google.android.gms.ads.zza.zza(adsizeparcel.width, adsizeparcel.height, adsizeparcel.zzpX));
    }

    public static com.google.a.a.d zzd(AdRequestParcel adrequestparcel)
    {
        HashSet hashset;
        if (adrequestparcel.zzpK != null)
        {
            hashset = new HashSet(adrequestparcel.zzpK);
        } else
        {
            hashset = null;
        }
        return new com.google.a.a.d(new Date(adrequestparcel.zzpI), zzn(adrequestparcel.zzpJ), hashset, adrequestparcel.zzpL, adrequestparcel.zzpQ);
    }

    public static c zzn(int i)
    {
        switch (i)
        {
        default:
            return c.a;

        case 2: // '\002'
            return c.c;

        case 1: // '\001'
            return c.b;
        }
    }
}
