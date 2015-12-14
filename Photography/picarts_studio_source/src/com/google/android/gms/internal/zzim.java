// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import com.google.android.gms.ads.internal.zzp;

// Referenced classes of package com.google.android.gms.internal:
//            zzid, zzie

public final class zzim
{

    private Activity zzJn;
    private boolean zzJo;
    private boolean zzJp;
    private boolean zzJq;
    private android.view.ViewTreeObserver.OnGlobalLayoutListener zzJr;
    private android.view.ViewTreeObserver.OnScrollChangedListener zzJs;

    public zzim(Activity activity, android.view.ViewTreeObserver.OnGlobalLayoutListener ongloballayoutlistener, android.view.ViewTreeObserver.OnScrollChangedListener onscrollchangedlistener)
    {
        zzJn = activity;
        zzJr = ongloballayoutlistener;
        zzJs = onscrollchangedlistener;
    }

    private void zzgQ()
    {
        while (zzJn == null || zzJo) 
        {
            return;
        }
        if (zzJr != null)
        {
            zzp.zzbv().zza(zzJn, zzJr);
        }
        if (zzJs != null)
        {
            zzp.zzbv().zza(zzJn, zzJs);
        }
        zzJo = true;
    }

    private void zzgR()
    {
        while (zzJn == null || !zzJo) 
        {
            return;
        }
        if (zzJr != null)
        {
            zzp.zzbx().zzb(zzJn, zzJr);
        }
        if (zzJs != null)
        {
            zzp.zzbv().zzb(zzJn, zzJs);
        }
        zzJo = false;
    }

    public final void onAttachedToWindow()
    {
        zzJp = true;
        if (zzJq)
        {
            zzgQ();
        }
    }

    public final void onDetachedFromWindow()
    {
        zzJp = false;
        zzgR();
    }

    public final void zzgO()
    {
        zzJq = true;
        if (zzJp)
        {
            zzgQ();
        }
    }

    public final void zzgP()
    {
        zzJq = false;
        zzgR();
    }

    public final void zzk(Activity activity)
    {
        zzJn = activity;
    }
}
