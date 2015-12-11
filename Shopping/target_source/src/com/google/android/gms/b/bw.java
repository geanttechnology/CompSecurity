// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import java.util.concurrent.Future;

// Referenced classes of package com.google.android.gms.b:
//            by

public abstract class bw
{

    private final Runnable a = new _cls1();
    private volatile Thread b;

    public bw()
    {
    }

    static Thread a(bw bw1, Thread thread)
    {
        bw1.b = thread;
        return thread;
    }

    public abstract void a();

    public final Future b()
    {
        return by.a(a);
    }

    /* member class not found */
    class _cls1 {}

}
