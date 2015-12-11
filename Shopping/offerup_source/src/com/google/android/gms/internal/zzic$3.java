// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Callable;

// Referenced classes of package com.google.android.gms.internal:
//            zzin, zzhu

final class zzIu
    implements Runnable
{

    final Callable zzIu;
    final zzin zzrA;

    public final void run()
    {
        try
        {
            Process.setThreadPriority(10);
            zzrA.zzf(zzIu.call());
            return;
        }
        catch (Exception exception)
        {
            zzp.zzby().zzc(exception, true);
        }
        zzrA.cancel(true);
    }

    (zzin zzin1, Callable callable)
    {
        zzrA = zzin1;
        zzIu = callable;
        super();
    }
}
