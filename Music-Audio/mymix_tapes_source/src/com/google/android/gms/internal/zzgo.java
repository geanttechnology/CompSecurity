// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.concurrent.Future;

// Referenced classes of package com.google.android.gms.internal:
//            zzie, zzip, zzdg

public final class zzgo
{

    private String zzBm;
    private String zzEZ;
    private zzie zzFa;
    zzdv.zzd zzFb;
    public final zzdg zzFc = new _cls1();
    public final zzdg zzFd = new _cls2();
    zzip zzoL;
    private final Object zzpc = new Object();

    public zzgo(String s, String s1)
    {
        zzFa = new zzie();
        zzEZ = s1;
        zzBm = s;
    }

    static Object zza(zzgo zzgo1)
    {
        return zzgo1.zzpc;
    }

    static zzie zzb(zzgo zzgo1)
    {
        return zzgo1.zzFa;
    }

    static String zzc(zzgo zzgo1)
    {
        return zzgo1.zzBm;
    }

    static String zzd(zzgo zzgo1)
    {
        return zzgo1.zzEZ;
    }

    public void zzb(zzdv.zzd zzd1)
    {
        zzFb = zzd1;
    }

    public void zze(zzip zzip1)
    {
        zzoL = zzip1;
    }

    public zzdv.zzd zzfH()
    {
        return zzFb;
    }

    public Future zzfI()
    {
        return zzFa;
    }

    public void zzfJ()
    {
        if (zzoL != null)
        {
            zzoL.destroy();
            zzoL = null;
        }
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
