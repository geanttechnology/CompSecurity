// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zzp;

// Referenced classes of package com.google.android.gms.internal:
//            zzip, zzix, zzhu

public class zzfx
    implements Runnable
{

    private final Handler zzCs;
    private final long zzCt;
    private long zzCu;
    private zziq.zza zzCv;
    protected boolean zzCw;
    protected boolean zzCx;
    private final int zznP;
    private final int zznQ;
    protected final zzip zzoL;

    public zzfx(zziq.zza zza1, zzip zzip1, int i, int j)
    {
        this(zza1, zzip1, i, j, 200L, 50L);
    }

    public zzfx(zziq.zza zza1, zzip zzip1, int i, int j, long l, long l1)
    {
        zzCt = l;
        zzCu = l1;
        zzCs = new Handler(Looper.getMainLooper());
        zzoL = zzip1;
        zzCv = zza1;
        zzCw = false;
        zzCx = false;
        zznQ = j;
        zznP = i;
    }

    static int zza(zzfx zzfx1)
    {
        return zzfx1.zznP;
    }

    static int zzb(zzfx zzfx1)
    {
        return zzfx1.zznQ;
    }

    static long zzc(zzfx zzfx1)
    {
        long l = zzfx1.zzCu - 1L;
        zzfx1.zzCu = l;
        return l;
    }

    static long zzd(zzfx zzfx1)
    {
        return zzfx1.zzCu;
    }

    static zziq.zza zze(zzfx zzfx1)
    {
        return zzfx1.zzCv;
    }

    static long zzf(zzfx zzfx1)
    {
        return zzfx1.zzCt;
    }

    static Handler zzg(zzfx zzfx1)
    {
        return zzfx1.zzCs;
    }

    public void run()
    {
        if (zzoL == null || zzfn())
        {
            zzCv.zza(zzoL, true);
            return;
        } else
        {
    /* block-local class not found */
    class zza {}

            (new zza(zzoL.getWebView())).execute(new Void[0]);
            return;
        }
    }

    public void zza(AdResponseParcel adresponseparcel)
    {
        zza(adresponseparcel, new zzix(this, zzoL, adresponseparcel.zzEe));
    }

    public void zza(AdResponseParcel adresponseparcel, zzix zzix1)
    {
        zzoL.setWebViewClient(zzix1);
        zzip zzip1 = zzoL;
        if (TextUtils.isEmpty(adresponseparcel.zzAT))
        {
            zzix1 = null;
        } else
        {
            zzix1 = zzp.zzbx().zzaw(adresponseparcel.zzAT);
        }
        zzip1.loadDataWithBaseURL(zzix1, adresponseparcel.body, "text/html", "UTF-8", null);
    }

    public void zzfl()
    {
        zzCs.postDelayed(this, zzCt);
    }

    public void zzfm()
    {
        this;
        JVM INSTR monitorenter ;
        zzCw = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean zzfn()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = zzCw;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean zzfo()
    {
        return zzCx;
    }
}
