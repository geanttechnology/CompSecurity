// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;

import android.os.Handler;
import android.os.Looper;
import com.google.a.d.c;
import com.google.a.d.h;
import com.google.a.d.i;
import com.rdio.android.core.util.Logging;
import java.util.concurrent.Executor;

public class SharedAsyncEventBus extends c
{

    private static final String TAG = "SharedAsyncEventBus";

    public SharedAsyncEventBus(final Logging logging)
    {
        super(new Executor() {

            private Handler handler;

            public void execute(Runnable runnable)
            {
                if (handler == null)
                {
                    handler = new Handler(Looper.getMainLooper());
                }
                handler.post(runnable);
            }

        }, new i() {

            final Logging val$logging;

            public void handleException(Throwable throwable, h h)
            {
                logging.log(6, "SharedAsyncEventBus", "Exception thrown when handling event.");
                logging.logException(throwable, true);
            }

            
            {
                logging = logging1;
                super();
            }
        });
    }
}
