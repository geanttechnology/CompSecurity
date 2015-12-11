// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

// Referenced classes of package com.paypal.android.sdk:
//            br, bx, ck, cj

public abstract class bw extends br
{

    private static final String a = com/paypal/android/sdk/bw.getSimpleName();
    private final ck b;
    private final ThreadPoolExecutor c = (ThreadPoolExecutor)Executors.newCachedThreadPool();
    private final int d;

    public bw(int i, ck ck)
    {
        d = i;
        b = ck;
    }

    static int a(bw bw1)
    {
        return bw1.d;
    }

    static ck b(bw bw1)
    {
        return bw1.b;
    }

    static String d()
    {
        return a;
    }

    public final void a()
    {
    }

    protected abstract String b();

    public final boolean b(cj cj)
    {
        c.submit(new bx(this, cj));
        return true;
    }

    protected abstract int c();

    protected abstract boolean c(cj cj);

}
