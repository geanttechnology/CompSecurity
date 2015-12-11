// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Base64;
import java.security.GeneralSecurityException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.ebay.nautilus.kernel:
//            EbayIdentity

private static final class looper extends BroadcastReceiver
{

    private final CountDownLatch done = new CountDownLatch(1);
    private final Looper looper;
    private final Handler scheduler;

    final boolean getId(Context context)
    {
        context.sendOrderedBroadcast((new Intent("com.ebay.nautilus.domain.ACTION_GET_DEVICE_ID")).putExtra("version", (byte)1), null, this, scheduler, 0, null, null);
        boolean flag;
        try
        {
            flag = done.await(30L, TimeUnit.SECONDS);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return flag;
    }

    public void onReceive(Context context, Intent intent)
    {
        String s = getResultData();
        if (EbayIdentity.access$100().sultData)
        {
            EbayIdentity.log(context, (new StringBuilder()).append("DeviceIdGenerateReceiver:onReceive(").append(s).append(')').toString());
        }
        Object obj = null;
        intent = obj;
        if (s != null)
        {
            try
            {
                intent = getResultData(Base64.decode(s, 0));
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                EbayIdentity.access$100().sultData((new StringBuilder()).append("Received an invalid response: ").append(s).toString());
                intent = obj;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                EbayIdentity.access$100().sultData((new StringBuilder()).append("Received an invalid response: ").append(s).toString(), intent);
                intent = obj;
            }
        }
        if (intent != null)
        {
            getResultData(context, intent);
        } else
        {
            getResultData(context);
        }
        done.countDown();
        looper.quit();
    }

    public ()
    {
        HandlerThread handlerthread = new HandlerThread(com/ebay/nautilus/kernel/EbayIdentity$DeviceIdGenerateReceiver.getSimpleName());
        handlerthread.start();
        looper = handlerthread.getLooper();
        scheduler = new Handler(looper);
    }
}
