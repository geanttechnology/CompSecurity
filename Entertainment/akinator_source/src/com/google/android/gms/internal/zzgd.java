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
//            zziz, zzji, zzid

public class zzgd
    implements Runnable
{

    private final Handler zzDk;
    private final long zzDl;
    private long zzDm;
    private zzja.zza zzDn;
    protected boolean zzDo;
    protected boolean zzDp;
    private final int zznQ;
    private final int zznR;
    protected final zziz zzoM;

    public zzgd(zzja.zza zza1, zziz zziz1, int i, int j)
    {
        this(zza1, zziz1, i, j, 200L, 50L);
    }

    public zzgd(zzja.zza zza1, zziz zziz1, int i, int j, long l, long l1)
    {
        zzDl = l;
        zzDm = l1;
        zzDk = new Handler(Looper.getMainLooper());
        zzoM = zziz1;
        zzDn = zza1;
        zzDo = false;
        zzDp = false;
        zznR = j;
        zznQ = i;
    }

    static int zza(zzgd zzgd1)
    {
        return zzgd1.zznQ;
    }

    static int zzb(zzgd zzgd1)
    {
        return zzgd1.zznR;
    }

    static long zzc(zzgd zzgd1)
    {
        long l = zzgd1.zzDm - 1L;
        zzgd1.zzDm = l;
        return l;
    }

    static long zzd(zzgd zzgd1)
    {
        return zzgd1.zzDm;
    }

    static zzja.zza zze(zzgd zzgd1)
    {
        return zzgd1.zzDn;
    }

    static long zzf(zzgd zzgd1)
    {
        return zzgd1.zzDl;
    }

    static Handler zzg(zzgd zzgd1)
    {
        return zzgd1.zzDk;
    }

    public void run()
    {
        if (zzoM == null || zzfx())
        {
            zzDn.zza(zzoM, true);
            return;
        } else
        {
    /* block-local class not found */
    class zza {}

            (new zza(zzoM.getWebView())).execute(new Void[0]);
            return;
        }
    }

    public void zza(AdResponseParcel adresponseparcel)
    {
        zza(adresponseparcel, new zzji(this, zzoM, adresponseparcel.zzER));
    }

    public void zza(AdResponseParcel adresponseparcel, zzji zzji1)
    {
        zzoM.setWebViewClient(zzji1);
        zziz zziz1 = zzoM;
        if (TextUtils.isEmpty(adresponseparcel.zzBF))
        {
            zzji1 = null;
        } else
        {
            zzji1 = zzp.zzbv().zzaz(adresponseparcel.zzBF);
        }
        zziz1.loadDataWithBaseURL(zzji1, adresponseparcel.body, "text/html", "UTF-8", null);
    }

    public void zzfv()
    {
        zzDk.postDelayed(this, zzDl);
    }

    public void zzfw()
    {
        this;
        JVM INSTR monitorenter ;
        zzDo = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean zzfx()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = zzDo;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean zzfy()
    {
        return zzDp;
    }
}
