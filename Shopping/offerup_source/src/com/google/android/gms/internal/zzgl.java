// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzn;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.google.android.gms.internal:
//            zzhz, zzgm, zzih, zzhs, 
//            zzic, zzid, zzbc, zzan

public class zzgl extends zzhz
{

    private final zzgm zzDB;
    private Future zzDC;
    private final zzgg.zza zzDd;
    private final zzhs.zza zzDe;
    private final AdResponseParcel zzDf;
    private final Object zzpd;

    public zzgl(Context context, zzn zzn, zzbc zzbc, zzhs.zza zza1, zzan zzan, zzgg.zza zza2)
    {
        this(zza1, zza2, new zzgm(context, zzn, zzbc, new zzih(context), zzan, zza1));
    }

    zzgl(zzhs.zza zza1, zzgg.zza zza2, zzgm zzgm1)
    {
        zzpd = new Object();
        zzDe = zza1;
        zzDf = zza1.zzHD;
        zzDd = zza2;
        zzDB = zzgm1;
    }

    private zzhs zzB(int i)
    {
        return new zzhs(zzDe.zzHC.zzEn, null, null, i, null, null, zzDf.orientation, zzDf.zzzc, zzDe.zzHC.zzEq, false, null, null, null, null, null, zzDf.zzEL, zzDe.zzqn, zzDf.zzEJ, zzDe.zzHz, zzDf.zzEO, zzDf.zzEP, zzDe.zzHw, null);
    }

    static zzgg.zza zza(zzgl zzgl1)
    {
        return zzgl1.zzDd;
    }

    public void onStop()
    {
        synchronized (zzpd)
        {
            if (zzDC != null)
            {
                zzDC.cancel(true);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzbn()
    {
        synchronized (zzpd)
        {
            zzDC = zzic.zza(zzDB);
        }
        obj = (zzhs)zzDC.get(60000L, TimeUnit.MILLISECONDS);
        byte byte0 = -2;
_L1:
        if (obj == null)
        {
            obj = zzB(byte0);
        }
        zzid.zzIE.post(new _cls1(((zzhs) (obj))));
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            zzb.zzaH("Timed out waiting for native ad.");
            zzDC.cancel(true);
            byte0 = 2;
            obj = null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            byte0 = 0;
            obj = null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = null;
            byte0 = -1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = null;
            byte0 = -1;
        }
          goto _L1
    }

    private class _cls1
        implements Runnable
    {

        final zzgl zzDD;
        final zzhs zzpF;

        public void run()
        {
            zzgl.zza(zzDD).zzb(zzpF);
        }

        _cls1(zzhs zzhs1)
        {
            zzDD = zzgl.this;
            zzpF = zzhs1;
            super();
        }
    }

}
