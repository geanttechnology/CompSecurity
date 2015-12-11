// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.google.android.gms.internal:
//            zziq, zzin

final class zzJD
    implements Runnable
{

    final zzin zzJB;
    final a zzJC;
    final zziq zzJD;

    public final void run()
    {
        try
        {
            zzJB.zzf(zzJC.zze(zzJD.get()));
            return;
        }
        catch (CancellationException cancellationexception) { }
        catch (InterruptedException interruptedexception) { }
        catch (ExecutionException executionexception) { }
        zzJB.cancel(true);
    }

    a(zzin zzin1, a a, zziq zziq1)
    {
        zzJB = zzin1;
        zzJC = a;
        zzJD = zziq1;
        super();
    }
}
