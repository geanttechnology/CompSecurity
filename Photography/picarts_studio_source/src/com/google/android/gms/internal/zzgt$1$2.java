// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package com.google.android.gms.internal:
//            zzgt, zzdz, zzgv, zzcg, 
//            zzce, zzbe

class zzFI
    implements zzFI
{

    final zzFI zzFI;

    public void run()
    {
    }

    FG(FG fg)
    {
        zzFI = fg;
        super();
    }

    // Unreferenced inner class com/google/android/gms/internal/zzgt$1

/* anonymous class */
    final class zzgt._cls1
        implements Runnable
    {

        final zzdz zzFD;
        final zzgv zzFE;
        final zzce zzFF;
        final String zzFG;
        final zzcg zzoD;

        public final void run()
        {
            zzdz.zzd zzd = zzFD.zzdO();
            zzFE.zzb(zzd);
            zzoD.zza(zzFF, new String[] {
                "rwc"
            });
            zzd.zza(new zzgt._cls1._cls1(zzoD.zzdn()), new zzgt._cls1._cls2(this));
        }

            
            {
                zzFD = zzdz1;
                zzFE = zzgv1;
                zzoD = zzcg1;
                zzFF = zzce;
                zzFG = s;
                super();
            }

        // Unreferenced inner class com/google/android/gms/internal/zzgt$1$1

/* anonymous class */
        class zzgt._cls1._cls1
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

                    
                    {
                        zzFI = zzgt._cls1.this;
                        zzFH = zzce;
                        super();
                    }
        }

    }

}
