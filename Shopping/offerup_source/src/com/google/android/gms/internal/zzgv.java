// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.concurrent.Future;

// Referenced classes of package com.google.android.gms.internal:
//            zzin, zziz, zzdk

public final class zzgv
{

    private String zzBY;
    private String zzFO;
    private zzin zzFP;
    zzdz.zzd zzFQ;
    public final zzdk zzFR = new _cls1();
    public final zzdk zzFS = new _cls2();
    zziz zzoM;
    private final Object zzpd = new Object();

    public zzgv(String s, String s1)
    {
        zzFP = new zzin();
        zzFO = s1;
        zzBY = s;
    }

    static Object zza(zzgv zzgv1)
    {
        return zzgv1.zzpd;
    }

    static zzin zzb(zzgv zzgv1)
    {
        return zzgv1.zzFP;
    }

    static String zzc(zzgv zzgv1)
    {
        return zzgv1.zzBY;
    }

    static String zzd(zzgv zzgv1)
    {
        return zzgv1.zzFO;
    }

    public final void zzb(zzdz.zzd zzd1)
    {
        zzFQ = zzd1;
    }

    public final void zze(zziz zziz1)
    {
        zzoM = zziz1;
    }

    public final zzdz.zzd zzfR()
    {
        return zzFQ;
    }

    public final Future zzfS()
    {
        return zzFP;
    }

    public final void zzfT()
    {
        if (zzoM != null)
        {
            zzoM.destroy();
            zzoM = null;
        }
    }

    private class _cls1
        implements zzdk
    {

        final zzgv zzFT;

        public void zza(zziz zziz1, Map map)
        {
label0:
            {
                synchronized (zzgv.zza(zzFT))
                {
                    if (!com.google.android.gms.internal.zzgv.zzb(zzFT).isDone())
                    {
                        break label0;
                    }
                }
                return;
            }
            if (zzgv.zzc(zzFT).equals(map.get("request_id")))
            {
                break MISSING_BLOCK_LABEL_55;
            }
            zziz1;
            JVM INSTR monitorexit ;
            return;
            map;
            zziz1;
            JVM INSTR monitorexit ;
            throw map;
            map = new zzgx(1, map);
            com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder("Invalid ")).append(map.getType()).append(" request error: ").append(map.zzfU()).toString());
            com.google.android.gms.internal.zzgv.zzb(zzFT).zzf(map);
            zziz1;
            JVM INSTR monitorexit ;
        }

        _cls1()
        {
            zzFT = zzgv.this;
            super();
        }
    }


    private class _cls2
        implements zzdk
    {

        final zzgv zzFT;

        public void zza(zziz zziz1, Map map)
        {
label0:
            {
                synchronized (zzgv.zza(zzFT))
                {
                    if (!com.google.android.gms.internal.zzgv.zzb(zzFT).isDone())
                    {
                        break label0;
                    }
                }
                return;
            }
            zzgx zzgx1;
            zzgx1 = new zzgx(-2, map);
            if (zzgv.zzc(zzFT).equals(zzgx1.getRequestId()))
            {
                break MISSING_BLOCK_LABEL_100;
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder()).append(zzgx1.getRequestId()).append(" ==== ").append(zzgv.zzc(zzFT)).toString());
            obj;
            JVM INSTR monitorexit ;
            return;
            zziz1;
            obj;
            JVM INSTR monitorexit ;
            throw zziz1;
            String s = zzgx1.getUrl();
            if (s != null)
            {
                break MISSING_BLOCK_LABEL_120;
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("URL missing in loadAdUrl GMSG.");
            obj;
            JVM INSTR monitorexit ;
            return;
            if (s.contains("%40mediation_adapters%40"))
            {
                zziz1 = s.replaceAll("%40mediation_adapters%40", zzhy.zza(zziz1.getContext(), (String)map.get("check_adapters"), zzgv.zzd(zzFT)));
                zzgx1.setUrl(zziz1);
                com.google.android.gms.ads.internal.util.client.zzb.v((new StringBuilder("Ad request URL modified to ")).append(zziz1).toString());
            }
            com.google.android.gms.internal.zzgv.zzb(zzFT).zzf(zzgx1);
            obj;
            JVM INSTR monitorexit ;
        }

        _cls2()
        {
            zzFT = zzgv.this;
            super();
        }
    }

}
