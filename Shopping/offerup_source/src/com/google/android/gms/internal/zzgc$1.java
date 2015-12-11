// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.google.android.gms.internal:
//            zzgc

class zzDj
    implements Runnable
{

    final zzgc zzDj;

    public void run()
    {
        if (!zzgc.zza(zzDj).get())
        {
            return;
        } else
        {
            zzb.e("Timed out waiting for WebView to finish loading.");
            zzDj.cancel();
            return;
        }
    }

    l.client.zzb(zzgc zzgc1)
    {
        zzDj = zzgc1;
        super();
    }
}
