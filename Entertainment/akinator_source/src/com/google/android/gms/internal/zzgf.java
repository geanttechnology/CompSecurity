// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package com.google.android.gms.internal:
//            zzhz, zzid, zzhs

public abstract class zzgf extends zzhz
{

    protected final Context mContext;
    protected final zzgg.zza zzDd;
    protected final zzhs.zza zzDe;
    protected AdResponseParcel zzDf;
    protected final Object zzDh = new Object();
    protected final Object zzpd = new Object();

    protected zzgf(Context context, zzhs.zza zza1, zzgg.zza zza2)
    {
        super(true);
        mContext = context;
        zzDe = zza1;
        zzDf = zza1.zzHD;
        zzDd = zza2;
    }

    public void onStop()
    {
    }

    protected abstract zzhs zzA(int i);

    public void zzbn()
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        int i;
        zzb.zzaF("AdRendererBackgroundTask started.");
        i = zzDe.errorCode;
        zzh(SystemClock.elapsedRealtime());
_L3:
        zzhs zzhs = zzA(i);
        zzid.zzIE.post(new _cls2(zzhs));
        return;
        Object obj1;
        obj1;
    /* block-local class not found */
    class zza {}

        i = ((zza) (obj1)).getErrorCode();
        if (i != 3 && i != -1) goto _L2; else goto _L1
_L1:
        zzb.zzaG(((zza) (obj1)).getMessage());
_L4:
        if (zzDf != null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        zzDf = new AdResponseParcel(i);
_L5:
        zzid.zzIE.post(new _cls1());
          goto _L3
_L2:
        zzb.zzaH(((zza) (obj1)).getMessage());
          goto _L4
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        zzDf = new AdResponseParcel(i, zzDf.zzzc);
          goto _L5
    }

    protected abstract void zzh(long l)
        throws zza;

    protected void zzi(zzhs zzhs)
    {
        zzDd.zzb(zzhs);
    }

    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls1 {}

}
