// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.services;

import android.os.Bundle;

// Referenced classes of package com.aviary.android.feather.library.services:
//            HiResBackgroundService

private static class total
{

    private long id;
    int index;
    int total;

    public long getId()
    {
        this;
        JVM INSTR monitorenter ;
        long l = id;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void reset()
    {
        this;
        JVM INSTR monitorenter ;
        id = id + 1L;
        index = 0;
        total = 0;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void toBundle(Bundle bundle)
    {
        bundle.putLong("counter_id", id);
        bundle.putInt("counter_index", index);
        bundle.putInt("counter_total", total);
    }

    public ()
    {
        id = 0L;
        index = 0;
        total = 0;
    }
}
