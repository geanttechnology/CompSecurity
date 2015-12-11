// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.internal:
//            zziq, zzir

public class zzio
    implements zziq
{

    private final zzir zzJA = new zzir();
    private final Object zzJy;

    public zzio(Object obj)
    {
        zzJy = obj;
        zzJA.zzgV();
    }

    public boolean cancel(boolean flag)
    {
        return false;
    }

    public Object get()
    {
        return zzJy;
    }

    public Object get(long l, TimeUnit timeunit)
    {
        return zzJy;
    }

    public boolean isCancelled()
    {
        return false;
    }

    public boolean isDone()
    {
        return true;
    }

    public void zzc(Runnable runnable)
    {
        zzJA.zzc(runnable);
    }
}
