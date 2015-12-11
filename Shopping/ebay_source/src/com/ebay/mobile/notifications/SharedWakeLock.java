// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import android.content.Context;
import android.os.PowerManager;

public class SharedWakeLock
{

    private static final String LOCK_TAG = "com.ebay.mobile";
    private static android.os.PowerManager.WakeLock wakeLock = null;

    public SharedWakeLock()
    {
    }

    public static void acquireLock(Context context)
    {
        com/ebay/mobile/notifications/SharedWakeLock;
        JVM INSTR monitorenter ;
        if (wakeLock == null)
        {
            wakeLock = ((PowerManager)context.getSystemService("power")).newWakeLock(1, "com.ebay.mobile");
            wakeLock.setReferenceCounted(true);
        }
        wakeLock.acquire();
        com/ebay/mobile/notifications/SharedWakeLock;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public static void releaseLock()
    {
        com/ebay/mobile/notifications/SharedWakeLock;
        JVM INSTR monitorenter ;
        boolean flag;
        if (wakeLock == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        flag = wakeLock.isHeld();
        Exception exception;
        if (flag)
        {
            try
            {
                wakeLock.release();
            }
            catch (Throwable throwable) { }
            finally
            {
                com/ebay/mobile/notifications/SharedWakeLock;
            }
        }
        com/ebay/mobile/notifications/SharedWakeLock;
        JVM INSTR monitorexit ;
        return;
        throw exception;
    }

}
