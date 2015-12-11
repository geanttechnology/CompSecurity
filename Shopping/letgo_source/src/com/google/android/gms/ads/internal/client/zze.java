// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.ll;
import android.support.v7.ln;
import android.support.v7.py;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.ads.internal.zzk;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            zzs, zzk, AdSizeParcel, zzr

public class zze extends ln
{

    public zze()
    {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    private zzr zza(Context context, AdSizeParcel adsizeparcel, String s, py py, int i)
    {
        android.support.v7.lk lk = ll.a(context);
        context = com.google.android.gms.ads.internal.client.zzr.zza.zzk(((zzs)zzar(context)).zza(lk, adsizeparcel, s, py, 0x7877d8, i));
        return context;
        context;
_L2:
        com.google.android.gms.ads.internal.util.client.zzb.zza("Could not create remote AdManager.", context);
        return null;
        context;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public zzr zza(Context context, AdSizeParcel adsizeparcel, String s, py py)
    {
        Object obj;
label0:
        {
            if (zzk.zzcE().zzR(context))
            {
                zzr zzr = zza(context, adsizeparcel, s, py, 1);
                obj = zzr;
                if (zzr != null)
                {
                    break label0;
                }
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Using BannerAdManager from the client jar.");
            obj = new zzf(context, adsizeparcel, s, py, new VersionInfoParcel(0x7877d8, 0x7877d8, true));
        }
        return ((zzr) (obj));
    }

    public zzr zzb(Context context, AdSizeParcel adsizeparcel, String s, py py)
    {
        Object obj;
label0:
        {
            if (zzk.zzcE().zzR(context))
            {
                zzr zzr = zza(context, adsizeparcel, s, py, 2);
                obj = zzr;
                if (zzr != null)
                {
                    break label0;
                }
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzaE("Using InterstitialAdManager from the client jar.");
            obj = new zzk(context, adsizeparcel, s, py, new VersionInfoParcel(0x7877d8, 0x7877d8, true), com.google.android.gms.ads.internal.zzd.zzbd());
        }
        return ((zzr) (obj));
    }

    protected Object zzd(IBinder ibinder)
    {
        return zze(ibinder);
    }

    protected zzs zze(IBinder ibinder)
    {
        return zzs.zza.zzl(ibinder);
    }
}
