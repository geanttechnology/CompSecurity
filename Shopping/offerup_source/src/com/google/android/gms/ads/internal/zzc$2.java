// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzck;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zziz;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zzc, zzq, zzp, zze

class zzoD
    implements Runnable
{

    final com.google.android.gms.internal.za zzoB;
    final zzc zzoC;
    final zzcg zzoD;

    public void run()
    {
        if (zzoB.zzHD.zzET && zzoC.zzot.zzqC != null)
        {
            Object obj = null;
            if (zzoB.zzHD.zzBF != null)
            {
                obj = zzp.zzbv().zzaz(zzoB.zzHD.zzBF);
            }
            obj = new zzch(zzoC, ((String) (obj)), zzoB.zzHD.body);
            zzoC.zzot.zzqH = 1;
            try
            {
                zzoC.zzot.zzqC.zza(((com.google.android.gms.internal.zzcj) (obj)));
                return;
            }
            catch (RemoteException remoteexception)
            {
                zzb.zzd("Could not call the onCustomRenderedAdLoadedListener.", remoteexception);
            }
        }
        zze zze1 = new zze();
        zziz zziz1 = zzoC.zza(zzoB, zze1);
        zze1.zza(new b(zzoB, zziz1));
        class _cls1
            implements android.view.View.OnTouchListener
        {

            final zze zzoE;
            final zzc._cls2 zzoF;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                zzoE.recordClick();
                return false;
            }

            _cls1(zze zze1)
            {
                zzoF = zzc._cls2.this;
                zzoE = zze1;
                super();
            }
        }

        zziz1.setOnTouchListener(new _cls1(zze1));
        class _cls2
            implements android.view.View.OnClickListener
        {

            final zze zzoE;
            final zzc._cls2 zzoF;

            public void onClick(View view)
            {
                zzoE.recordClick();
            }

            _cls2(zze zze1)
            {
                zzoF = zzc._cls2.this;
                zzoE = zze1;
                super();
            }
        }

        zziz1.setOnClickListener(new _cls2(zze1));
        zzoC.zzot.zzqH = 0;
        zzoC.zzot.zzqm = zzp.zzbu().zza(zzoC.zzot.context, zzoC, zzoB, zzoC.zzot.zzqi, zziz1, zzoC.zzox, zzoC, zzoD);
    }

    _cls2(zzc zzc1, com.google.android.gms.internal.za za, zzcg zzcg)
    {
        zzoC = zzc1;
        zzoB = za;
        zzoD = zzcg;
        super();
    }
}
