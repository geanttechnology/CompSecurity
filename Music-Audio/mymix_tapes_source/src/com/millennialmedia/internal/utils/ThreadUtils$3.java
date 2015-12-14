// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.utils;

import android.os.Handler;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.millennialmedia.internal.utils:
//            ThreadUtils

static final class val.runnable
    implements heduledRunnable
{

    final Runnable val$runnable;

    public void cancel()
    {
        ThreadUtils.access$000().removeCallbacks(this);
    }

    public void run()
    {
        ThreadUtils.access$200().execute(val$runnable);
    }

    heduledRunnable(Runnable runnable1)
    {
        val$runnable = runnable1;
        super();
    }
}
