// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package com.google.android.gms.internal:
//            zzhq, zzhu, zzhj, zzip

public abstract class zzfz extends zzhq
{

    protected final Context mContext;
    protected final zzga.zza zzCD;
    protected final Object zzCE = new Object();
    protected final zzhj.zza zzCF;
    protected AdResponseParcel zzCG;
    protected final zzip zzoL;
    protected final Object zzpc = new Object();

    protected zzfz(Context context, zzhj.zza zza1, zzip zzip, zzga.zza zza2)
    {
        mContext = context;
        zzCF = zza1;
        zzCG = zza1.zzGM;
        zzoL = zzip;
        zzCD = zza2;
    }

    public void onStop()
    {
    }

    public void zzdG()
    {
        Object obj = zzpc;
        obj;
        JVM INSTR monitorenter ;
        int i;
        zzb.zzaC("AdRendererBackgroundTask started.");
        i = zzCF.errorCode;
        zzh(SystemClock.elapsedRealtime());
_L3:
        zzhj zzhj1 = zzz(i);
        zzhu.zzHK.post(new _cls2(zzhj1));
        return;
        Object obj1;
        obj1;
    /* block-local class not found */
    class zza {}

        i = ((zza) (obj1)).getErrorCode();
        if (i != 3 && i != -1) goto _L2; else goto _L1
_L1:
        zzb.zzaD(((zza) (obj1)).getMessage());
_L4:
        if (zzCG != null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        zzCG = new AdResponseParcel(i);
_L5:
        zzhu.zzHK.post(new _cls1());
          goto _L3
_L2:
        zzb.zzaE(((zza) (obj1)).getMessage());
          goto _L4
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        zzCG = new AdResponseParcel(i, zzCG.zzyA);
          goto _L5
    }

    protected abstract void zzh(long l)
        throws zza;

    protected void zzi(zzhj zzhj1)
    {
        zzCD.zzb(zzhj1);
    }

    protected zzhj zzz(int i)
    {
        AdRequestInfoParcel adrequestinfoparcel = zzCF.zzGL;
        return new zzhj(adrequestinfoparcel.zzDy, zzoL, zzCG.zzyw, i, zzCG.zzyx, zzCG.zzDZ, zzCG.orientation, zzCG.zzyA, adrequestinfoparcel.zzDB, zzCG.zzDX, null, null, null, null, null, zzCG.zzDY, zzCF.zzqf, zzCG.zzDW, zzCF.zzGI, zzCG.zzEb, zzCG.zzEc, zzCF.zzGF, null, adrequestinfoparcel.zzDO);
    }

    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls1 {}

}
