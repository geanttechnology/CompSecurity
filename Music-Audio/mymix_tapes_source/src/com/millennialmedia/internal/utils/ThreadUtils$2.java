// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.utils;

import android.os.Handler;

// Referenced classes of package com.millennialmedia.internal.utils:
//            ThreadUtils

static final class val.runnable
    implements heduledRunnable
{

    final Runnable val$runnable;

    public void cancel()
    {
        ThreadUtils.access$100().removeCallbacks(this);
    }

    public void run()
    {
        val$runnable.run();
    }

    heduledRunnable(Runnable runnable1)
    {
        val$runnable = runnable1;
        super();
    }
}
