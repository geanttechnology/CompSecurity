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
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzel;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            zzl, zzr, zzq

public final class zzd extends zzg
{

    private static final zzd zzsA = new zzd();

    private zzd()
    {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public static zzq zza(Context context, String s, zzel zzel)
    {
        Object obj;
label0:
        {
            if (zzl.zzcF().zzR(context))
            {
                zzq zzq = zzsA.zzb(context, s, zzel);
                obj = zzq;
                if (zzq != null)
                {
                    break label0;
                }
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Using AdLoader from the client jar.");
            obj = new zzj(context, s, zzel, new VersionInfoParcel(0x7bd338, 0x7bd338, true));
        }
        return ((zzq) (obj));
    }

    private zzq zzb(Context context, String s, zzel zzel)
    {
        com.google.android.gms.dynamic.zzd zzd1 = zze.zzy(context);
        context = zzq.zza.zzi(((zzr)zzas(context)).zza(zzd1, s, zzel, 0x7bd338));
        return context;
        context;
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not create remote builder for AdLoader.", context);
_L2:
        return null;
        context;
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not create remote builder for AdLoader.", context);
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected final zzr zzc(IBinder ibinder)
    {
        return com.google.android.gms.ads.internal.client.zzr.zza.zzj(ibinder);
    }

    protected final Object zzd(IBinder ibinder)
    {
        return zzc(ibinder);
    }

}
