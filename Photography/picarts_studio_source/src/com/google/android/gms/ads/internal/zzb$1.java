// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.content.Intent;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.purchase.zzi;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zziz;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zzb, zzp, zzq

class zzoz
    implements Runnable
{

    final zzb zzoA;
    final Intent zzoz;

    public void run()
    {
        int i = zzp.zzbF().zzd(zzoz);
        zzp.zzbF();
        if (i == 0 && zzoA.zzot.zzqo != null && zzoA.zzot.zzqo.zzBD != null && zzoA.zzot.zzqo.zzBD.zzhc() != null)
        {
            zzoA.zzot.zzqo.zzBD.zzhc().close();
        }
        zzoA.zzot.zzqI = false;
    }

    y.zzd(zzb zzb1, Intent intent)
    {
        zzoA = zzb1;
        zzoz = intent;
        super();
    }
}
