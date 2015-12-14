// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzel;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            zzt, zzl, AdSizeParcel, zzs

public class zze extends zzg
{

    public zze()
    {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    private zzs zza(Context context, AdSizeParcel adsizeparcel, String s, zzel zzel, int i)
    {
        com.google.android.gms.dynamic.zzd zzd1 = com.google.android.gms.dynamic.zze.zzy(context);
        context = com.google.android.gms.ads.internal.client.zzs.zza.zzk(((zzt)zzas(context)).zza(zzd1, adsizeparcel, s, zzel, 0x7bd338, i));
        return context;
        context;
_L2:
        com.google.android.gms.ads.internal.util.client.zzb.zza("Could not create remote AdManager.", context);
        return null;
        context;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public zzs zza(Context context, AdSizeParcel adsizeparcel, String s, zzel zzel)
    {
        Object obj;
label0:
        {
            if (zzl.zzcF().zzR(context))
            {
                zzs zzs = zza(context, adsizeparcel, s, zzel, 1);
                obj = zzs;
                if (zzs != null)
                {
                    break label0;
                }
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Using BannerAdManager from the client jar.");
            obj = new zzf(context, adsizeparcel, s, zzel, new VersionInfoParcel(0x7bd338, 0x7bd338, true), com.google.android.gms.ads.internal.zzd.zzbd());
        }
        return ((zzs) (obj));
    }

    public zzs zzb(Context context, AdSizeParcel adsizeparcel, String s, zzel zzel)
    {
        Object obj;
label0:
        {
            if (zzl.zzcF().zzR(context))
            {
                zzs zzs = zza(context, adsizeparcel, s, zzel, 2);
                obj = zzs;
                if (zzs != null)
                {
                    break label0;
                }
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Using InterstitialAdManager from the client jar.");
            obj = new zzk(context, adsizeparcel, s, zzel, new VersionInfoParcel(0x7bd338, 0x7bd338, true), com.google.android.gms.ads.internal.zzd.zzbd());
        }
        return ((zzs) (obj));
    }

    protected Object zzd(IBinder ibinder)
    {
        return zze(ibinder);
    }

    protected zzt zze(IBinder ibinder)
    {
        return zzt.zza.zzl(ibinder);
    }
}
