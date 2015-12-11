// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package com.google.android.gms.internal:
//            zzgd

public final class zzDq extends AsyncTask
{

    private final WebView zzDq;
    private Bitmap zzDr;
    final zzgd zzDs;

    protected final Object doInBackground(Object aobj[])
    {
        return zza((Void[])aobj);
    }

    protected final void onPostExecute(Object obj)
    {
        zza((Boolean)obj);
    }

    protected final void onPreExecute()
    {
        this;
        JVM INSTR monitorenter ;
        zzDr = Bitmap.createBitmap(zzgd.zza(zzDs), com.google.android.gms.internal.zzgd.zzb(zzDs), android.graphics.nfig.ARGB_8888);
        zzDq.setVisibility(0);
        zzDq.measure(android.view.ureSpec.makeMeasureSpec(zzgd.zza(zzDs), 0), android.view.ureSpec.makeMeasureSpec(com.google.android.gms.internal.zzgd.zzb(zzDs), 0));
        zzDq.layout(0, 0, zzgd.zza(zzDs), com.google.android.gms.internal.zzgd.zzb(zzDs));
        Canvas canvas = new Canvas(zzDr);
        zzDq.draw(canvas);
        zzDq.invalidate();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected final transient Boolean zza(Void avoid[])
    {
        this;
        JVM INSTR monitorenter ;
        int i1;
        int j1;
        i1 = zzDr.getWidth();
        j1 = zzDr.getHeight();
        if (i1 != 0 && j1 != 0) goto _L2; else goto _L1
_L1:
        avoid = Boolean.valueOf(false);
_L3:
        this;
        JVM INSTR monitorexit ;
        return avoid;
_L2:
        int i;
        int j;
        i = 0;
        j = 0;
_L4:
        int k;
        if (i < i1)
        {
            k = 0;
            break MISSING_BLOCK_LABEL_52;
        }
        boolean flag;
        if ((double)j / ((double)(i1 * j1) / 100D) > 0.10000000000000001D)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        avoid = Boolean.valueOf(flag);
          goto _L3
        avoid;
        throw avoid;
        if (zzDr.getPixel(i, k) != 0)
        {
            l = j + 1;
        }
        k += 10;
        j = l;
        int l;
        if (k < j1)
        {
            l = j;
            break MISSING_BLOCK_LABEL_62;
        }
        i += 10;
          goto _L4
    }

    protected final void zza(Boolean boolean1)
    {
        zzgd.zzc(zzDs);
        if (boolean1.booleanValue() || zzDs.zzfx() || zzgd.zzd(zzDs) <= 0L)
        {
            zzDs.zzDp = boolean1.booleanValue();
            zzgd.zze(zzDs).zza(zzDs.zzoM, true);
        } else
        if (zzgd.zzd(zzDs) > 0L)
        {
            if (zzb.zzN(2))
            {
                zzb.zzaF("Ad not detected, scheduling another run.");
            }
            zzgd.zzg(zzDs).postDelayed(zzDs, zzgd.zzf(zzDs));
            return;
        }
    }

    public client.zzb(zzgd zzgd1, WebView webview)
    {
        zzDs = zzgd1;
        super();
        zzDq = webview;
    }
}
