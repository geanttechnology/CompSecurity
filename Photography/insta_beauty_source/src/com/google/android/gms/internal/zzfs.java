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
//            zzhh, zzhl, zzha, zzid

public abstract class zzfs extends zzhh
{

    protected final Context mContext;
    protected final zzft.zza zzBq;
    protected final Object zzBr = new Object();
    protected final zzha.zza zzBs;
    protected AdResponseParcel zzBt;
    protected final zzid zzoA;
    protected final Object zzqt = new Object();

    protected zzfs(Context context, zzha.zza zza, zzid zzid, zzft.zza zza1)
    {
        mContext = context;
        zzBs = zza;
        zzBt = zza.zzFs;
        zzoA = zzid;
        zzBq = zza1;
    }

    public void onStop()
    {
    }

    public void zzdP()
    {
        Object obj = zzqt;
        obj;
        JVM INSTR monitorenter ;
        int i;
        zzb.zzay("AdRendererBackgroundTask started.");
        i = zzBs.errorCode;
        zzh(SystemClock.elapsedRealtime());
_L3:
        zzha zzha1 = zzz(i);
        zzhl.zzGk.post(new _cls2(zzha1));
        return;
        Object obj1;
        obj1;
        i = ((zza) (obj1)).getErrorCode();
        if (i != 3 && i != -1) goto _L2; else goto _L1
_L1:
        zzb.zzaA(((zza) (obj1)).getMessage());
_L4:
        if (zzBt != null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        zzBt = new AdResponseParcel(i);
_L5:
        zzhl.zzGk.post(new _cls1());
          goto _L3
_L2:
        zzb.zzaC(((zza) (obj1)).getMessage());
          goto _L4
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        zzBt = new AdResponseParcel(i, zzBt.zzxJ);
          goto _L5
    }

    protected abstract void zzh(long l);

    protected void zzk(zzha zzha1)
    {
        zzBq.zzb(zzha1);
    }

    protected zzha zzz(int i)
    {
        AdRequestInfoParcel adrequestinfoparcel = zzBs.zzFr;
        return new zzha(adrequestinfoparcel.zzCm, zzoA, zzBt.zzxF, i, zzBt.zzxG, zzBt.zzCM, zzBt.orientation, zzBt.zzxJ, adrequestinfoparcel.zzCp, zzBt.zzCK, null, null, null, null, null, zzBt.zzCL, zzBs.zzpN, zzBt.zzCJ, zzBs.zzFo, zzBt.zzCO, zzBt.zzCP, zzBs.zzFl, null, adrequestinfoparcel.zzCC);
    }

    private class _cls2
        implements Runnable
    {

        final zzfs zzBu;
        final zzha zzpd;

        public void run()
        {
            synchronized (zzBu.zzqt)
            {
                zzBu.zzk(zzpd);
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        _cls2(zzha zzha1)
        {
            zzBu = zzfs.this;
            zzpd = zzha1;
            super();
        }
    }


    private class zza extends Exception
    {

        private final int zzBv;

        public int getErrorCode()
        {
            return zzBv;
        }

        public zza(String s, int i)
        {
            super(s);
            zzBv = i;
        }
    }


    private class _cls1
        implements Runnable
    {

        final zzfs zzBu;

        public void run()
        {
            zzBu.onStop();
        }

        _cls1()
        {
            zzBu = zzfs.this;
            super();
        }
    }

}
