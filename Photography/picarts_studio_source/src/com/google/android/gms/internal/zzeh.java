// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzee, zzed, zzen, zzem, 
//            zzby, zzbu, zzet, zzeg, 
//            zzid, zzei, zzep

public final class zzeh
    implements zzei.zza
{

    private final Context mContext;
    private final NativeAdOptionsParcel zzoY;
    private final List zzoZ;
    private final zzem zzox;
    private final AdRequestParcel zzpH;
    private final VersionInfoParcel zzpb;
    private final Object zzpd = new Object();
    private final String zzzj;
    private final long zzzk;
    private final zzed zzzl;
    private final AdSizeParcel zzzm;
    private final boolean zzzn;
    private zzen zzzo;
    private int zzzp;
    private zzep zzzq;

    public zzeh(Context context, String s, zzem zzem1, zzee zzee1, zzed zzed1, AdRequestParcel adrequestparcel, AdSizeParcel adsizeparcel, 
            VersionInfoParcel versioninfoparcel, boolean flag, NativeAdOptionsParcel nativeadoptionsparcel, List list)
    {
        zzzp = -2;
        mContext = context;
        zzox = zzem1;
        zzzl = zzed1;
        long l;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(s))
        {
            zzzj = zzdT();
        } else
        {
            zzzj = s;
        }
        if (zzee1.zzyX != -1L)
        {
            l = zzee1.zzyX;
        } else
        {
            l = 10000L;
        }
        zzzk = l;
        zzpH = adrequestparcel;
        zzzm = adsizeparcel;
        zzpb = versioninfoparcel;
        zzzn = flag;
        zzoY = nativeadoptionsparcel;
        zzoZ = list;
    }

    static zzen zza(zzeh zzeh1, zzen zzen1)
    {
        zzeh1.zzzo = zzen1;
        return zzen1;
    }

    static Object zza(zzeh zzeh1)
    {
        return zzeh1.zzpd;
    }

    private void zza(long l, long l1, long l2, long l3)
    {
        do
        {
            if (zzzp != -2)
            {
                return;
            }
            zzb(l, l1, l2, l3);
        } while (true);
    }

    private void zza(zzeg zzeg1)
    {
        if ("com.google.ads.mediation.AdUrlAdapter".equals(zzzj))
        {
            Bundle bundle1 = zzpH.zzsL.getBundle(zzzj);
            Bundle bundle = bundle1;
            if (bundle1 == null)
            {
                bundle = new Bundle();
            }
            bundle.putString("sdk_less_network_id", zzzl.zzyN);
            zzpH.zzsL.putBundle(zzzj, bundle);
        }
        if (zzpb.zzJw >= 0x3e8fa0)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        if (zzzm.zztf)
        {
            zzzo.zza(zze.zzy(mContext), zzpH, zzzl.zzyT, zzeg1);
            return;
        }
        try
        {
            zzzo.zza(zze.zzy(mContext), zzzm, zzpH, zzzl.zzyT, zzeg1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzeg zzeg1)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request ad from mediation adapter.", zzeg1);
        }
        zzq(5);
        return;
        if (zzzn)
        {
            zzzo.zza(zze.zzy(mContext), zzpH, zzzl.zzyT, zzzl.zzyM, zzeg1, zzoY, zzoZ);
            return;
        }
        if (zzzm.zztf)
        {
            zzzo.zza(zze.zzy(mContext), zzpH, zzzl.zzyT, zzzl.zzyM, zzeg1);
            return;
        }
        zzzo.zza(zze.zzy(mContext), zzzm, zzpH, zzzl.zzyT, zzzl.zzyM, zzeg1);
        return;
    }

    static void zza(zzeh zzeh1, zzeg zzeg1)
    {
        zzeh1.zza(zzeg1);
    }

    static int zzb(zzeh zzeh1)
    {
        return zzeh1.zzzp;
    }

    private void zzb(long l, long l1, long l2, long l3)
    {
        long l4 = SystemClock.elapsedRealtime();
        l = l1 - (l4 - l);
        l1 = l3 - (l4 - l2);
        if (l <= 0L || l1 <= 0L)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaG("Timed out waiting for adapter.");
            zzzp = 3;
            return;
        }
        try
        {
            zzpd.wait(Math.min(l, l1));
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            zzzp = -1;
        }
    }

    static zzen zzc(zzeh zzeh1)
    {
        return zzeh1.zzdU();
    }

    static zzen zzd(zzeh zzeh1)
    {
        return zzeh1.zzzo;
    }

    private String zzdT()
    {
        if (!TextUtils.isEmpty(zzzl.zzyQ))
        {
            if (zzox.zzaf(zzzl.zzyQ))
            {
                return "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
            } else
            {
                return "com.google.ads.mediation.customevent.CustomEventAdapter";
            }
        }
        break MISSING_BLOCK_LABEL_44;
        RemoteException remoteexception;
        remoteexception;
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to determine the custom event's version, assuming the old one.");
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    private zzen zzdU()
    {
        com.google.android.gms.ads.internal.util.client.zzb.zzaG((new StringBuilder("Instantiating mediation adapter: ")).append(zzzj).toString());
        if (((Boolean)zzby.zzvu.get()).booleanValue())
        {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(zzzj))
            {
                return new zzet(new AdMobAdapter());
            }
            if ("com.google.ads.mediation.AdUrlAdapter".equals(zzzj))
            {
                return new zzet(new AdUrlAdapter());
            }
        }
        zzen zzen1;
        try
        {
            zzen1 = zzox.zzae(zzzj);
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zza((new StringBuilder("Could not instantiate mediation adapter: ")).append(zzzj).toString(), remoteexception);
            return null;
        }
        return zzen1;
    }

    public final void cancel()
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (zzzo != null)
        {
            zzzo.destroy();
        }
_L1:
        zzzp = -1;
        zzpd.notify();
        return;
        Object obj1;
        obj1;
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not destroy mediation adapter.", ((Throwable) (obj1)));
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public final zzei zza(long l, long l1)
    {
        Object obj1;
        synchronized (zzpd)
        {
            long l2 = SystemClock.elapsedRealtime();
            obj1 = new zzeg();
            zzid.zzIE.post(new Runnable(((zzeg) (obj1))) {

                final zzeg zzzr;
                final zzeh zzzs;

                public void run()
                {
label0:
                    {
                        synchronized (zzeh.zza(zzzs))
                        {
                            if (com.google.android.gms.internal.zzeh.zzb(zzzs) == -2)
                            {
                                break label0;
                            }
                        }
                        return;
                    }
                    zzeh.zza(zzzs, zzeh.zzc(zzzs));
                    if (zzeh.zzd(zzzs) != null)
                    {
                        break MISSING_BLOCK_LABEL_66;
                    }
                    zzzs.zzq(4);
                    obj2;
                    JVM INSTR monitorexit ;
                    return;
                    exception1;
                    obj2;
                    JVM INSTR monitorexit ;
                    throw exception1;
                    zzzr.zza(zzzs);
                    zzeh.zza(zzzs, zzzr);
                    obj2;
                    JVM INSTR monitorexit ;
                }

            
            {
                zzzs = zzeh.this;
                zzzr = zzeg1;
                super();
            }
            });
            zza(l2, zzzk, l, l1);
            obj1 = new zzei(zzzl, zzzo, zzzj, ((zzeg) (obj1)), zzzp, zzzq);
        }
        return ((zzei) (obj1));
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void zza(int i, zzep zzep)
    {
        synchronized (zzpd)
        {
            zzzp = i;
            zzzq = zzep;
            zzpd.notify();
        }
        return;
        zzep;
        obj;
        JVM INSTR monitorexit ;
        throw zzep;
    }

    public final void zzq(int i)
    {
        synchronized (zzpd)
        {
            zzzp = i;
            zzpd.notify();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
