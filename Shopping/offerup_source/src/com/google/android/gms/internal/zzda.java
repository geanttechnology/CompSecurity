// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.formats.zzj;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;

// Referenced classes of package com.google.android.gms.internal:
//            zzcp, zzco

public class zzda extends zzg
{

    public zzda()
    {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    private zzco zzb(Context context, FrameLayout framelayout, FrameLayout framelayout1)
    {
        com.google.android.gms.dynamic.zzd zzd1 = zze.zzy(context);
        framelayout = zze.zzy(framelayout);
        framelayout1 = zze.zzy(framelayout1);
        context = zzco.zza.zzu(((zzcp)zzas(context)).zza(zzd1, framelayout, framelayout1, 0x7bd338));
        return context;
        context;
_L2:
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not create remote NativeAdViewDelegate.", context);
        return null;
        context;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected zzcp zzD(IBinder ibinder)
    {
        return zzcp.zza.zzv(ibinder);
    }

    public zzco zza(Context context, FrameLayout framelayout, FrameLayout framelayout1)
    {
label0:
        {
            if (zzl.zzcF().zzR(context))
            {
                zzco zzco = zzb(context, framelayout, framelayout1);
                context = zzco;
                if (zzco != null)
                {
                    break label0;
                }
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Using NativeAdViewDelegate from the client jar.");
            context = new zzj(framelayout, framelayout1);
        }
        return context;
    }

    protected Object zzd(IBinder ibinder)
    {
        return zzD(ibinder);
    }
}
