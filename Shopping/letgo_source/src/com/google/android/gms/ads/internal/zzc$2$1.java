// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.support.v7.nt;
import android.support.v7.nu;
import android.support.v7.nx;
import android.support.v7.ru;
import android.support.v7.tp;
import android.support.v7.ul;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zze, zzc, zzq, zzp

class zzoD
    implements android.view.ouchListener
{

    final zze zzoD;
    final rdClick zzoE;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        zzoD.recordClick();
        return false;
    }

    oC(oC oc, zze zze1)
    {
        zzoE = oc;
        zzoD = zze1;
        super();
    }

    // Unreferenced inner class com/google/android/gms/ads/internal/zzc$2

/* anonymous class */
    class zzc._cls2
        implements Runnable
    {

        final android.support.v7.te.a zzoA;
        final zzc zzoB;
        final nt zzoC;

        public void run()
        {
            if (zzoA.b.zzEg && zzoB.zzos.zzqu != null)
            {
                Object obj = null;
                if (zzoA.b.zzAT != null)
                {
                    obj = zzp.zzbx().a(zzoA.b.zzAT);
                }
                obj = new nu(zzoB, ((String) (obj)), zzoA.b.body);
                zzoB.zzos.zzqz = 1;
                try
                {
                    zzoB.zzos.zzqu.a(((android.support.v7.nw) (obj)));
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    zzb.zzd("Could not call the onCustomRenderedAdLoadedListener.", remoteexception);
                }
            }
            zze zze1 = new zze();
            ul ul1 = zzoB.zza(zzoA, zze1);
            zze1.zza(new zze.zzb(zzoA, ul1));
            ul1.setOnTouchListener(new zzc._cls2._cls1(this, zze1));
            ul1.setOnClickListener(new zzc._cls2._cls2(zze1));
            zzoB.zzos.zzqz = 0;
            zzoB.zzos.zzqe = zzp.zzbw().a(zzoB.zzos.context, zzoB, zzoA, zzoB.zzos.zzqa, ul1, zzoB.zzow, zzoB, zzoC);
        }

            
            {
                zzoB = zzc1;
                zzoA = a;
                zzoC = nt;
                super();
            }

        // Unreferenced inner class com/google/android/gms/ads/internal/zzc$2$2

/* anonymous class */
        class zzc._cls2._cls2
            implements android.view.View.OnClickListener
        {

            final zze zzoD;
            final zzc._cls2 zzoE;

            public void onClick(View view)
            {
                zzoD.recordClick();
            }

                    
                    {
                        zzoE = zzc._cls2.this;
                        zzoD = zze1;
                        super();
                    }
        }

    }

}
