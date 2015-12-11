// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzmn;

// Referenced classes of package com.google.android.gms.ads.internal.request:
//            zzg, zzj, AdResponseParcel, AdRequestInfoParcel

public abstract class zzd extends zzhz
    implements zzc.zza
{

    private AdResponseParcel zzDf;
    private final zzc.zza zzEi;
    private final Object zzpd = new Object();
    private final AdRequestInfoParcel zzzz;

    public zzd(AdRequestInfoParcel adrequestinfoparcel, zzc.zza zza1)
    {
        zzzz = adrequestinfoparcel;
        zzEi = zza1;
    }

    public final void onStop()
    {
        zzfH();
    }

    boolean zza(zzj zzj1, AdRequestInfoParcel adrequestinfoparcel)
    {
        zzj1.zza(adrequestinfoparcel, new zzg(this));
        return true;
        zzj1;
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not fetch ad response from ad request service.", zzj1);
        zzp.zzby().zzc(zzj1, true);
_L2:
        zzEi.zzb(new AdResponseParcel(0));
        return false;
        zzj1;
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not fetch ad response from ad request service due to an Exception.", zzj1);
        zzp.zzby().zzc(zzj1, true);
        continue; /* Loop/switch isn't completed */
        zzj1;
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not fetch ad response from ad request service due to an Exception.", zzj1);
        zzp.zzby().zzc(zzj1, true);
        continue; /* Loop/switch isn't completed */
        zzj1;
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not fetch ad response from ad request service due to an Exception.", zzj1);
        zzp.zzby().zzc(zzj1, true);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void zzb(AdResponseParcel adresponseparcel)
    {
        synchronized (zzpd)
        {
            zzDf = adresponseparcel;
            zzpd.notify();
        }
        return;
        adresponseparcel;
        obj;
        JVM INSTR monitorexit ;
        throw adresponseparcel;
    }

    public void zzbn()
    {
        Object obj = zzfI();
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = new AdResponseParcel(0);
        zzEi.zzb(((AdResponseParcel) (obj)));
_L4:
        zzfH();
        return;
_L2:
        if (!zza(((zzj) (obj)), zzzz)) goto _L4; else goto _L3
_L3:
        zzi(zzp.zzbz().elapsedRealtime());
          goto _L4
        Exception exception;
        exception;
        zzfH();
        throw exception;
    }

    protected boolean zzf(long l)
    {
        l = 60000L - (zzp.zzbz().elapsedRealtime() - l);
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

    public abstract void zzfH();

    public abstract zzj zzfI();

    protected void zzi(long l)
    {
        obj;
        JVM INSTR monitorenter ;
_L2:
        synchronized (zzpd)
        {
            if (zzDf == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            zzEi.zzb(zzDf);
        }
        return;
        if (zzf(l)) goto _L2; else goto _L1
_L1:
        if (zzDf == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        zzEi.zzb(zzDf);
_L3:
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        zzEi.zzb(new AdResponseParcel(0));
          goto _L3
    }
}
