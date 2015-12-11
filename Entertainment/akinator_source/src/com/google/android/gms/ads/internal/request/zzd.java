// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzbr;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzgs;
import com.google.android.gms.internal.zzgt;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzii;
import com.google.android.gms.internal.zzmn;

// Referenced classes of package com.google.android.gms.ads.internal.request:
//            zzg, zzj, AdResponseParcel, AdRequestInfoParcel, 
//            zze

public abstract class zzd extends zzhz
    implements zzc.zza
{
    public static final class zza extends zzd
    {

        private final Context mContext;

        public void zzfH()
        {
        }

        public zzj zzfI()
        {
            zzbr zzbr1 = new zzbr((String)zzby.zzul.get());
            return zzgt.zza(mContext, zzbr1, zzgs.zzfQ());
        }

        public zza(Context context, AdRequestInfoParcel adrequestinfoparcel, zzc.zza zza1)
        {
            super(adrequestinfoparcel, zza1);
            mContext = context;
        }
    }

    public static class zzb extends zzd
        implements com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    {

        private Context mContext;
        private final zzc.zza zzEi;
        protected zze zzEj;
        private boolean zzEk;
        private final Object zzpd = new Object();
        private AdRequestInfoParcel zzzz;

        protected void connect()
        {
            zzEj.zzoZ();
        }

        public void onConnected(Bundle bundle)
        {
            zzgz();
        }

        public void onConnectionFailed(ConnectionResult connectionresult)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Cannot connect to remote service, fallback to local instance.");
            zzfJ().zzgz();
            connectionresult = new Bundle();
            connectionresult.putString("action", "gms_connection_failed_fallback_to_local");
            zzp.zzbv().zzb(mContext, zzzz.zzqj.zzJu, "gmob-apps", connectionresult, true);
        }

        public void onConnectionSuspended(int i)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Disconnected from remote ad request service.");
        }

        public void zzfH()
        {
            synchronized (zzpd)
            {
                if (zzEj.isConnected() || zzEj.isConnecting())
                {
                    zzEj.disconnect();
                }
                Binder.flushPendingCommands();
                if (zzEk)
                {
                    zzp.zzbG().zzgN();
                    zzEk = false;
                }
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public zzj zzfI()
        {
            obj;
            JVM INSTR monitorenter ;
            zzj zzj1;
            synchronized (zzpd)
            {
                zzj1 = zzEj.zzfM();
            }
            return zzj1;
_L2:
            obj;
            JVM INSTR monitorexit ;
            return null;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
            Object obj1;
            obj1;
            continue; /* Loop/switch isn't completed */
            obj1;
            if (true) goto _L2; else goto _L1
_L1:
        }

        zzhz zzfJ()
        {
            return new zza(mContext, zzzz, zzEi);
        }

        public zzb(Context context, AdRequestInfoParcel adrequestinfoparcel, zzc.zza zza1)
        {
            super(adrequestinfoparcel, zza1);
            mContext = context;
            zzzz = adrequestinfoparcel;
            zzEi = zza1;
            if (((Boolean)zzby.zzuK.get()).booleanValue())
            {
                zzEk = true;
                zza1 = zzp.zzbG().zzgM();
            } else
            {
                zza1 = context.getMainLooper();
            }
            zzEj = new zze(context, zza1, this, this, adrequestinfoparcel.zzqj.zzJw);
            connect();
        }
    }


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
