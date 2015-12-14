// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.millennialmedia.internal.utils:
//            ThreadUtils

static final class val.initializeLatch extends Thread
{

    final CountDownLatch val$initializeLatch;

    public void run()
    {
        Looper.prepare();
        Handler _tmp = ThreadUtils.access$002(new Handler());
        val$initializeLatch.countDown();
        Looper.loop();
    }

    (CountDownLatch countdownlatch)
    {
        val$initializeLatch = countdownlatch;
        super();
    }
}
