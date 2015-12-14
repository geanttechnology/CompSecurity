// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.Window;
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
        Object obj = zzp.zzbv().zzg(com.google.android.gms.ads.internal.overlay.zzd.zza(zzBv), zzBv.zzBi.zzBM.zzpv);
        if (obj != null)
        {
            obj = zzp.zzbx().zza(com.google.android.gms.ads.internal.overlay.zzd.zza(zzBv), ((android.graphics.Bitmap) (obj)), zzBv.zzBi.zzBM.zzpw, zzBv.zzBi.zzBM.zzpx);
            zzid.zzIE.post(new Runnable(((Drawable) (obj))) {

                final Drawable zzBy;
                final zzd.zzd zzBz;

                public void run()
                {
                    com.google.android.gms.ads.internal.overlay.zzd.zza(zzBz.zzBv).getWindow().setBackgroundDrawable(zzBy);
                }

            
            {
                zzBz = zzd.zzd.this;
                zzBy = drawable;
                super();
            }
            });
        }
    }

    private _cls1.zzBy(zzd zzd1)
    {
        zzBv = zzd1;
        super();
    }

    zzBv(zzd zzd1, zzBv zzbv)
    {
        this(zzd1);
    }
}
