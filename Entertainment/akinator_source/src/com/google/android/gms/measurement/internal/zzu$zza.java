// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.FutureTask;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzu, zzp

private final class zzaNH extends FutureTask
{

    private final String zzaNH;
    final zzu zzaNI;

    protected void setException(Throwable throwable)
    {
        zzaNI.zzyd().zzzK().zzj(zzaNH, throwable);
        super.setException(throwable);
    }

    _cls9(zzu zzu1, Runnable runnable, String s)
    {
        zzaNI = zzu1;
        super(runnable, null);
        zzx.zzw(s);
        zzaNH = s;
    }
}
