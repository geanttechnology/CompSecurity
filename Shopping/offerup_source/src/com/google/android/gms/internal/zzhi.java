// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;

// Referenced classes of package com.google.android.gms.internal:
//            zzhz, zzhj, zzhm, zzhh, 
//            zzhl, zzen, zzmn

public class zzhi extends zzhz
    implements zzhj, zzhm
{

    private final Context mContext;
    private final zzhs.zza zzDe;
    private int zzDv;
    private final String zzGY;
    private final zzhh zzHg;
    private final zzhm zzHh;
    private final String zzHi;
    private int zzHj;
    private final Object zzpd = new Object();
    private final String zzzj;

    public zzhi(Context context, String s, String s1, String s2, zzhs.zza zza1, zzhh zzhh1, zzhm zzhm1)
    {
        zzHj = 0;
        zzDv = 3;
        mContext = context;
        zzzj = s;
        zzGY = s1;
        zzHi = s2;
        zzDe = zza1;
        zzHg = zzhh1;
        zzHh = zzhm1;
    }

    static String zza(zzhi zzhi1)
    {
        return zzhi1.zzHi;
    }

    static String zzb(zzhi zzhi1)
    {
        return zzhi1.zzzj;
    }

    static Context zzc(zzhi zzhi1)
    {
        return zzhi1.mContext;
    }

    static String zzd(zzhi zzhi1)
    {
        return zzhi1.zzGY;
    }

    private void zzk(long l)
    {
_L1:
label0:
        {
            synchronized (zzpd)
            {
                if (zzHj == 0)
                {
                    break label0;
                }
            }
            return;
        }
        if (zzf(l))
        {
            break MISSING_BLOCK_LABEL_35;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
          goto _L1
    }

    public void onStop()
    {
    }

    public void zzK(int i)
    {
        zzb(zzzj, 0);
    }

    public void zzav(String s)
    {
        synchronized (zzpd)
        {
            zzHj = 1;
            zzpd.notify();
        }
        return;
        exception;
        s;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzb(String s, int i)
    {
        synchronized (zzpd)
        {
            zzHj = 2;
            zzDv = i;
            zzpd.notify();
        }
        return;
        exception;
        s;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzbn()
    {
        zzhl zzhl1;
        AdRequestParcel adrequestparcel;
        zzen zzen1;
        if (zzHg == null || zzHg.zzgd() == null || zzHg.zzgc() == null)
        {
            return;
        }
        zzhl1 = zzHg.zzgd();
        zzhl1.zza(this);
        zzhl1.zza(this);
        adrequestparcel = zzDe.zzHC.zzEn;
        zzen1 = zzHg.zzgc();
        if (!zzen1.isInitialized())
        {
            break MISSING_BLOCK_LABEL_135;
        }
        zza.zzJt.post(new _cls1(zzen1, adrequestparcel));
_L1:
        zzk(zzp.zzbz().elapsedRealtime());
        zzhl1.zza(null);
        zzhl1.zza(null);
        RemoteException remoteexception;
        if (zzHj == 1)
        {
            zzHh.zzav(zzzj);
            return;
        } else
        {
            zzHh.zzb(zzzj, zzDv);
            return;
        }
        try
        {
            zza.zzJt.post(new _cls2(zzen1, adrequestparcel, zzhl1));
        }
        // Misplaced declaration of an exception variable
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Fail to check if adapter is initialized.", remoteexception);
            zzb(zzzj, 0);
        }
          goto _L1
    }

    protected boolean zzf(long l)
    {
        l = 20000L - (zzp.zzbz().elapsedRealtime() - l);
        if (l <= 0L)
        {
            return false;
        }
        try
        {
            zzpd.wait(l);
        }
        catch (InterruptedException interruptedexception)
        {
            return false;
        }
        return true;
    }

    public void zzge()
    {
        zzHg.zzgd();
        AdRequestParcel adrequestparcel = zzDe.zzHC.zzEn;
        zzen zzen1 = zzHg.zzgc();
        try
        {
            zzen1.zza(adrequestparcel, zzHi);
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Fail to load ad from adapter.", remoteexception);
        }
        zzb(zzzj, 0);
    }

    private class _cls1
        implements Runnable
    {

        final zzen zzHk;
        final zzhi zzHl;
        final AdRequestParcel zzpe;

        public void run()
        {
            try
            {
                zzHk.zza(zzpe, com.google.android.gms.internal.zzhi.zza(zzHl));
                return;
            }
            catch (RemoteException remoteexception)
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Fail to load ad from adapter.", remoteexception);
            }
            zzHl.zzb(com.google.android.gms.internal.zzhi.zzb(zzHl), 0);
        }

        _cls1(zzen zzen1, AdRequestParcel adrequestparcel)
        {
            zzHl = zzhi.this;
            zzHk = zzen1;
            zzpe = adrequestparcel;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final zzen zzHk;
        final zzhi zzHl;
        final zzhl zzHm;
        final AdRequestParcel zzpe;

        public void run()
        {
            try
            {
                zzHk.zza(zze.zzy(zzhi.zzc(zzHl)), zzpe, zzhi.zzd(zzHl), zzHm, com.google.android.gms.internal.zzhi.zza(zzHl));
                return;
            }
            catch (RemoteException remoteexception)
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzd((new StringBuilder("Fail to initialize adapter ")).append(com.google.android.gms.internal.zzhi.zzb(zzHl)).toString(), remoteexception);
            }
            zzHl.zzb(com.google.android.gms.internal.zzhi.zzb(zzHl), 0);
        }

        _cls2(zzen zzen1, AdRequestParcel adrequestparcel, zzhl zzhl1)
        {
            zzHl = zzhi.this;
            zzHk = zzen1;
            zzpe = adrequestparcel;
            zzHm = zzhl1;
            super();
        }
    }

}
