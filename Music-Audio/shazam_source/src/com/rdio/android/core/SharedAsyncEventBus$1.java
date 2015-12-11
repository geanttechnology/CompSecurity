// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

// Referenced classes of package com.rdio.android.core:
//            SharedAsyncEventBus

class 
    implements Executor
{

    private Handler handler;

    public void execute(Runnable runnable)
    {
        if (handler == null)
        {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.post(runnable);
    }

    ()
    {
    }
}
