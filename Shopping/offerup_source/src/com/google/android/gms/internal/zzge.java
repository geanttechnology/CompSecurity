// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package com.google.android.gms.internal:
//            zzgc, zziz, zzgd, zzja

public class zzge extends zzgc
{

    private zzgd zzDt;

    zzge(Context context, zzhs.zza zza, zziz zziz1, zzgg.zza zza1)
    {
        super(context, zza, zziz1, zza1);
    }

    protected void zzfs()
    {
        Object obj = zzoM.zzaN();
        int i;
        int j;
        if (((AdSizeParcel) (obj)).zztf)
        {
            obj = mContext.getResources().getDisplayMetrics();
            j = ((DisplayMetrics) (obj)).widthPixels;
            i = ((DisplayMetrics) (obj)).heightPixels;
        } else
        {
            j = ((AdSizeParcel) (obj)).widthPixels;
            i = ((AdSizeParcel) (obj)).heightPixels;
        }
        zzDt = new zzgd(this, zzoM, j, i);
        zzoM.zzhe().zza(this);
        zzDt.zza(zzDf);
    }

    protected int zzft()
    {
        if (zzDt.zzfx())
        {
            zzb.zzaF("Ad-Network indicated no fill with passback URL.");
            return 3;
        }
        return zzDt.zzfy() ? -2 : 2;
    }
}
