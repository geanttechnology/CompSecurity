// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.snds.api;

import android.os.Looper;
import java.util.concurrent.Executor;

// Referenced classes of package com.amazon.identity.snds.api:
//            NamedCachedThreadPool

public final class ThreadUtils
{

    private static final Executor MAP_COMMON_THREAD_POOL = new NamedCachedThreadPool("SNDSCommonThreadPool");

    public static boolean isRunningOnMainThread()
    {
        return Looper.getMainLooper() != null && Looper.getMainLooper() == Looper.myLooper();
    }

}
