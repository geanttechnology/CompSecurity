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
import com.google.android.gms.ads.internal.zzj;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            zzk, zzq, zzp

public final class zzd extends ln
{

    private static final zzd zzsp = new zzd();

    private zzd()
    {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public static zzp zza(Context context, String s, py py)
    {
        Object obj;
label0:
        {
            if (zzk.zzcE().zzR(context))
            {
                zzp zzp = zzsp.zzb(context, s, py);
                obj = zzp;
                if (zzp != null)
                {
                    break label0;
                }
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Using AdLoader from the client jar.");
            obj = new zzj(context, s, py, new VersionInfoParcel(0x7877d8, 0x7877d8, true));
        }
        return ((zzp) (obj));
    }

    private zzp zzb(Context context, String s, py py)
    {
        android.support.v7.lk lk = ll.a(context);
        context = zzp.zza.zzi(((zzq)zzar(context)).zza(lk, s, py, 0x7877d8));
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

    protected zzq zzc(IBinder ibinder)
    {
        return com.google.android.gms.ads.internal.client.zzq.zza.zzj(ibinder);
    }

    protected Object zzd(IBinder ibinder)
    {
        return zzc(ibinder);
    }

}
