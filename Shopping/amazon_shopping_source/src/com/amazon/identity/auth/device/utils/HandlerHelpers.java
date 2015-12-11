// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.os.Handler;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            MAPLog

public final class HandlerHelpers
{

    private static final String TAG = com/amazon/identity/auth/device/utils/HandlerHelpers.getName();

    private HandlerHelpers()
    {
    }

    public static void postAndWait(Handler handler, Runnable runnable)
    {
        CountDownLatch countdownlatch = new CountDownLatch(1);
        handler.post(new Runnable(runnable, countdownlatch) {

            final CountDownLatch val$latch;
            final Runnable val$runnable;

            public void run()
            {
                runnable.run();
                latch.countDown();
                return;
                Exception exception;
                exception;
                latch.countDown();
                throw exception;
            }

            
            {
                runnable = runnable1;
                latch = countdownlatch;
                super();
            }
        });
        try
        {
            countdownlatch.await();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Handler handler)
        {
            MAPLog.e(TAG, "Latch was interrupted.", handler);
        }
    }

}
