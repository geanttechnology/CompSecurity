// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzmi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zzn

public class zzi extends com.google.android.gms.ads.internal.client.zzp.zza
{

    private final Context mContext;
    private final zzo zzoT;
    private final zzcw zzoU;
    private final zzcx zzoV;
    private final zzmi zzoW;
    private final zzmi zzoX;
    private final NativeAdOptionsParcel zzoY;
    private final List zzoZ = zzbi();
    private final zzem zzox;
    private final String zzpa;
    private final VersionInfoParcel zzpb;
    private WeakReference zzpc;
    private Object zzpd;

    zzi(Context context, String s, zzem zzem, VersionInfoParcel versioninfoparcel, zzo zzo, zzcw zzcw, zzcx zzcx, 
            zzmi zzmi1, zzmi zzmi2, NativeAdOptionsParcel nativeadoptionsparcel)
    {
        zzpd = new Object();
        mContext = context;
        zzpa = s;
        zzox = zzem;
        zzpb = versioninfoparcel;
        zzoT = zzo;
        zzoV = zzcx;
        zzoU = zzcw;
        zzoW = zzmi1;
        zzoX = zzmi2;
        zzoY = nativeadoptionsparcel;
    }

    static Object zza(zzi zzi1)
    {
        return zzi1.zzpd;
    }

    static WeakReference zza(zzi zzi1, WeakReference weakreference)
    {
        zzi1.zzpc = weakreference;
        return weakreference;
    }

    static zzcw zzb(zzi zzi1)
    {
        return zzi1.zzoU;
    }

    private List zzbi()
    {
        ArrayList arraylist = new ArrayList();
        if (zzoV != null)
        {
            arraylist.add("1");
        }
        if (zzoU != null)
        {
            arraylist.add("2");
        }
        if (zzoW.size() > 0)
        {
            arraylist.add("3");
        }
        return arraylist;
    }

    static zzcx zzc(zzi zzi1)
    {
        return zzi1.zzoV;
    }

    static zzmi zzd(zzi zzi1)
    {
        return zzi1.zzoW;
    }

    static zzo zze(zzi zzi1)
    {
        return zzi1.zzoT;
    }

    static zzmi zzf(zzi zzi1)
    {
        return zzi1.zzoX;
    }

    static List zzg(zzi zzi1)
    {
        return zzi1.zzbi();
    }

    static NativeAdOptionsParcel zzh(zzi zzi1)
    {
        return zzi1.zzoY;
    }

    public String getMediationAdapterClassName()
    {
        Object obj1 = zzpd;
        obj1;
        JVM INSTR monitorenter ;
        if (zzpc == null) goto _L2; else goto _L1
_L1:
        Object obj = (zzn)zzpc.get();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        obj = ((zzn) (obj)).getMediationAdapterClassName();
_L3:
        obj1;
        JVM INSTR monitorexit ;
        return ((String) (obj));
_L2:
        obj1;
        JVM INSTR monitorexit ;
        return null;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        obj = null;
          goto _L3
    }

    public boolean isLoading()
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (zzpc == null) goto _L2; else goto _L1
_L1:
        zzn zzn1 = (zzn)zzpc.get();
        if (zzn1 == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        boolean flag = zzn1.isLoading();
_L3:
        obj;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        obj;
        JVM INSTR monitorexit ;
        return false;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        flag = false;
          goto _L3
    }

    protected void runOnUiThread(Runnable runnable)
    {
        zzid.zzIE.post(runnable);
    }

    protected zzn zzbj()
    {
        return new zzn(mContext, AdSizeParcel.zzs(mContext), zzpa, zzox, zzpb);
    }

    public void zzf(AdRequestParcel adrequestparcel)
    {
        runOnUiThread(new Runnable(adrequestparcel) {

            final AdRequestParcel zzpe;
            final zzi zzpf;

            public void run()
            {
                synchronized (zzi.zza(zzpf))
                {
                    zzn zzn1 = zzpf.zzbj();
                    zzi.zza(zzpf, new WeakReference(zzn1));
                    zzn1.zzb(zzi.zzb(zzpf));
                    zzn1.zzb(zzi.zzc(zzpf));
                    zzn1.zza(zzi.zzd(zzpf));
                    zzn1.zza(zzi.zze(zzpf));
                    zzn1.zzb(zzi.zzf(zzpf));
                    zzn1.zza(zzi.zzg(zzpf));
                    zzn1.zzb(zzi.zzh(zzpf));
                    zzn1.zzb(zzpe);
                }
                return;
                exception;
                obj;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                zzpf = zzi.this;
                zzpe = adrequestparcel;
                super();
            }
        });
    }
}
