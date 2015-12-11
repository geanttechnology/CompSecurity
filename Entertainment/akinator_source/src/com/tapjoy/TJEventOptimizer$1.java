// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.content.Context;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.tapjoy:
//            TJEventOptimizer

static final class a
    implements Runnable
{

    final Context a;

    public final void run()
    {
        TJEventOptimizer.a(new TJEventOptimizer(a, (byte)0));
        TJEventOptimizer.a().countDown();
    }

    Latch(Context context)
    {
        a = context;
        super();
    }
}
