// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.concurrent.Future;

// Referenced classes of package com.google.android.gms.internal:
//            zzic, zzin

final class zzIv
    implements Runnable
{

    final Future zzIv;
    final zzin zzrA;

    public final void run()
    {
        if (zzrA.isCancelled())
        {
            zzIv.cancel(true);
        }
    }

    (zzin zzin1, Future future)
    {
        zzrA = zzin1;
        zzIv = future;
        super();
    }
}
