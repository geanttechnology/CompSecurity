// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.zzp;
import java.lang.ref.WeakReference;

// Referenced classes of package com.google.android.gms.internal:
//            zzix, zzie

class zziv extends zzix
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    private final WeakReference zzJR;

    public zziv(View view, android.view.ViewTreeObserver.OnGlobalLayoutListener ongloballayoutlistener)
    {
        super(view);
        zzJR = new WeakReference(ongloballayoutlistener);
    }

    public void onGlobalLayout()
    {
        android.view.ViewTreeObserver.OnGlobalLayoutListener ongloballayoutlistener = (android.view.ViewTreeObserver.OnGlobalLayoutListener)zzJR.get();
        if (ongloballayoutlistener != null)
        {
            ongloballayoutlistener.onGlobalLayout();
            return;
        } else
        {
            detach();
            return;
        }
    }

    protected void zza(ViewTreeObserver viewtreeobserver)
    {
        viewtreeobserver.addOnGlobalLayoutListener(this);
    }

    protected void zzb(ViewTreeObserver viewtreeobserver)
    {
        zzp.zzbx().zza(viewtreeobserver, this);
    }
}
