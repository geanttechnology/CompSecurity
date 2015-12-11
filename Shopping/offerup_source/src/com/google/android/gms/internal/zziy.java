// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.overlay.zzk;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.internal:
//            zziz, zzcf, zzcc, zzja

public class zziy
{

    private final Context mContext;
    private zzk zzCo;
    private final ViewGroup zzJT;
    private final zziz zzoM;

    public zziy(Context context, ViewGroup viewgroup, zziz zziz1)
    {
        this(context, viewgroup, zziz1, null);
    }

    zziy(Context context, ViewGroup viewgroup, zziz zziz1, zzk zzk1)
    {
        mContext = context;
        zzJT = viewgroup;
        zzoM = zziz1;
        zzCo = zzk1;
    }

    public void onDestroy()
    {
        zzx.zzci("onDestroy must be called from the UI thread.");
        if (zzCo != null)
        {
            zzCo.destroy();
        }
    }

    public void zza(int i, int j, int k, int l, int i1)
    {
        if (zzCo != null)
        {
            return;
        } else
        {
            zzcc.zza(zzoM.zzhn().zzdm(), zzoM.zzhm(), new String[] {
                "vpr"
            });
            zzce zzce = zzcc.zzb(zzoM.zzhn().zzdm());
            zzCo = new zzk(mContext, zzoM, i1, zzoM.zzhn().zzdm(), zzce);
            zzJT.addView(zzCo, 0, new android.view.ViewGroup.LayoutParams(-1, -1));
            zzCo.zzd(i, j, k, l);
            zzoM.zzhe().zzF(false);
            return;
        }
    }

    public void zze(int i, int j, int k, int l)
    {
        zzx.zzci("The underlay may only be modified from the UI thread.");
        if (zzCo != null)
        {
            zzCo.zzd(i, j, k, l);
        }
    }

    public zzk zzgX()
    {
        zzx.zzci("getAdVideoUnderlay must be called from the UI thread.");
        return zzCo;
    }
}
