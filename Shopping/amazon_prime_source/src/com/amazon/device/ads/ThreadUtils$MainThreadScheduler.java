// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.os.Handler;
import android.os.Looper;

// Referenced classes of package com.amazon.device.ads:
//            ThreadUtils

public static class _THREAD extends _THREAD
{

    public void execute(Runnable runnable)
    {
        (new Handler(Looper.getMainLooper())).post(runnable);
    }

    public ()
    {
        super(ULE, _THREAD);
    }
}
