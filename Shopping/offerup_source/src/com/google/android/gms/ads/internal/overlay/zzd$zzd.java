// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.os.Handler;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzie;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            zzd, AdOverlayInfoParcel

class <init> extends zzhz
{

    final zzd zzBv;

    public void onStop()
    {
    }

    public void zzbn()
    {
        Object obj = zzp.zzbv().zzg(zzd.zza(zzBv), zzBv.zzBi.zzBM.zzpv);
        if (obj != null)
        {
            obj = zzp.zzbx().zza(zzd.zza(zzBv), ((android.graphics.Bitmap) (obj)), zzBv.zzBi.zzBM.zzpw, zzBv.zzBi.zzBM.zzpx);
            class _cls1
                implements Runnable
            {

                final Drawable zzBy;
                final zzd.zzd zzBz;

                public void run()
                {
                    zzd.zza(zzBz.zzBv).getWindow().setBackgroundDrawable(zzBy);
                }

            _cls1(Drawable drawable)
            {
                zzBz = zzd.zzd.this;
                zzBy = drawable;
                super();
            }
            }

            zzid.zzIE.post(new _cls1(((Drawable) (obj))));
        }
    }

    private _cls1(zzd zzd1)
    {
        zzBv = zzd1;
        super();
    }

    zzBv(zzd zzd1, zzBv zzbv)
    {
        this(zzd1);
    }
}
