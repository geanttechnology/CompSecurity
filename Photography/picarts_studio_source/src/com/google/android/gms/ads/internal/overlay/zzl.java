// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import com.google.android.gms.internal.zzce;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzmx;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            zzj, zzc, zzp, zzi

public class zzl
    implements zzj
{

    public zzl()
    {
    }

    public zzi zza(Context context, zziz zziz1, int i, zzcg zzcg, zzce zzce)
    {
        if (!zzmx.zzqx())
        {
            return null;
        } else
        {
            return new zzc(context, new zzp(context, zziz1.zzhh(), zziz1.getRequestId(), zzcg, zzce));
        }
    }
}
