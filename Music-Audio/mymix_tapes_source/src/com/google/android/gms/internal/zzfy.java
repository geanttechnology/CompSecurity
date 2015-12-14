// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package com.google.android.gms.internal:
//            zzfw, zzip, zzfx, zzhu

public class zzfy extends zzfw
{

    zzfy(Context context, zzhj.zza zza, zzip zzip1, zzga.zza zza1)
    {
        super(context, zza, zzip1, zza1);
    }

    protected void zzh(long l)
        throws zzfz.zza
    {
        Object obj = zzoL.zzaN();
        int i;
        int j;
        if (((AdSizeParcel) (obj)).zzsH)
        {
            j = mContext.getResources().getDisplayMetrics().widthPixels;
            i = mContext.getResources().getDisplayMetrics().heightPixels;
        } else
        {
            j = ((AdSizeParcel) (obj)).widthPixels;
            i = ((AdSizeParcel) (obj)).heightPixels;
        }
        obj = new zzfx(this, zzoL, j, i);
        zzhu.zzHK.post(new _cls1(((zzfx) (obj))));
        zzg(l);
        if (((zzfx) (obj)).zzfn())
        {
            zzb.zzaC("Ad-Network indicated no fill with passback URL.");
            throw new zzfz.zza("AdNetwork sent passback url", 3);
        }
        if (!((zzfx) (obj)).zzfo())
        {
            throw new zzfz.zza("AdNetwork timed out", 2);
        } else
        {
            return;
        }
    }

    /* member class not found */
    class _cls1 {}

}
