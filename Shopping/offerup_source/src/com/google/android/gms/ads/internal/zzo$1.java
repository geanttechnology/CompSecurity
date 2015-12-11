// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import java.lang.ref.WeakReference;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zzo, zza

class zzpL
    implements Runnable
{

    final WeakReference zzpL;
    final zzo zzpM;

    public void run()
    {
        zzo.zza(zzpM, false);
        zza zza1 = (zza)zzpL.get();
        if (zza1 != null)
        {
            zza1.zzd(zzo.zza(zzpM));
        }
    }

    (zzo zzo1, WeakReference weakreference)
    {
        zzpM = zzo1;
        zzpL = weakreference;
        super();
    }
}
