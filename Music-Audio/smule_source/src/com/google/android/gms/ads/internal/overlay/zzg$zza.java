// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.os.Handler;
import com.google.android.gms.internal.zzfl;
import java.lang.ref.WeakReference;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            zzg

final class zzdR
{

    private final Runnable zznB;
    private volatile boolean zzwZ;

    static boolean zza(zzdR zzdr)
    {
        return zzdr.zzwZ;
    }

    public void cancel()
    {
        zzwZ = true;
        zzfl.zzCr.removeCallbacks(zznB);
    }

    public void zzdR()
    {
        zzfl.zzCr.postDelayed(zznB, 250L);
    }

    public _cls1.zzxb(zzg zzg)
    {
        zzwZ = false;
        zznB = new Runnable(zzg) {

            private final WeakReference zzxa;
            final zzg zzxb;
            final zzg.zza zzxc;

            public void run()
            {
                zzg zzg1 = (zzg)zzxa.get();
                if (!zzg.zza.zza(zzxc) && zzg1 != null)
                {
                    zzg1.zzdI();
                    zzxc.zzdR();
                }
            }

            
            {
                zzxc = zzg.zza.this;
                zzxb = zzg1;
                super();
                zzxa = new WeakReference(zzxb);
            }
        };
    }
}
