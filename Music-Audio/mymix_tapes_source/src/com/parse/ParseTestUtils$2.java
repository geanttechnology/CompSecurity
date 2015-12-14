// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.concurrent.Semaphore;

// Referenced classes of package com.parse:
//            ParseTestUtils

static final class val.done
    implements Runnable
{

    final Semaphore val$done;
    final boolean val$enabled;

    public void run()
    {
        ParseTestUtils.setStrictModeEnabledForThisThread(val$enabled);
        val$done.release();
    }

    ore(boolean flag, Semaphore semaphore)
    {
        val$enabled = flag;
        val$done = semaphore;
        super();
    }
}
