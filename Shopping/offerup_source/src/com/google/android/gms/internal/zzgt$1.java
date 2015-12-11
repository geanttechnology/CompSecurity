// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzdz, zzgv, zzcg, zzce

final class zzFG
    implements Runnable
{

    final zzdz zzFD;
    final zzgv zzFE;
    final zzce zzFF;
    final String zzFG;
    final zzcg zzoD;

    public final void run()
    {
        d d = zzFD.zzdO();
        zzFE.zzb(d);
        zzoD.zza(zzFF, new String[] {
            "rwc"
        });
        class _cls1
            implements zzis.zzc
        {

            final zzce zzFH;
            final zzgt._cls1 zzFI;

            public void zzb(zzbe zzbe1)
            {
                zzFI.zzoD.zza(zzFH, new String[] {
                    "jsf"
                });
                zzFI.zzoD.zzdo();
                zzbe1.zza("/invalidRequest", zzFI.zzFE.zzFR);
                zzbe1.zza("/loadAdURL", zzFI.zzFE.zzFS);
                try
                {
                    zzbe1.zza("AFMA_buildAdURL", zzFI.zzFG);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (zzbe zzbe1)
                {
                    com.google.android.gms.ads.internal.util.client.zzb.zzb("Error requesting an ad url", zzbe1);
                }
            }

            public void zzc(Object obj)
            {
                zzb((zzbe)obj);
            }

            _cls1(zzce zzce)
            {
                zzFI = zzgt._cls1.this;
                zzFH = zzce;
                super();
            }
        }

        class _cls2
            implements zzis.zza
        {

            final zzgt._cls1 zzFI;

            public void run()
            {
            }

            _cls2()
            {
                zzFI = zzgt._cls1.this;
                super();
            }
        }

        d.zza(new _cls1(zzoD.zzdn()), new _cls2());
    }

    d(zzdz zzdz1, zzgv zzgv1, zzcg zzcg1, zzce zzce, String s)
    {
        zzFD = zzdz1;
        zzFE = zzgv1;
        zzoD = zzcg1;
        zzFF = zzce;
        zzFG = s;
        super();
    }
}
