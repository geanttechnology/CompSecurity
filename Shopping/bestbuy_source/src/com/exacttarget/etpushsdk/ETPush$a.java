// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import com.exacttarget.etpushsdk.util.m;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.exacttarget.etpushsdk:
//            ETPush, ETException

class 
{

    private boolean a;
    private CountDownLatch b;

    public void a()
    {
        a = true;
        b.countDown();
    }

    public boolean a(long l, TimeUnit timeunit)
    {
        boolean flag;
        try
        {
            flag = b.await(l, timeunit);
        }
        // Misplaced declaration of an exception variable
        catch (TimeUnit timeunit)
        {
            m.c("~!ETPush", timeunit.getMessage(), timeunit);
            throw new ETException(String.format("Exception in latch.await: %1$s", new Object[] {
                timeunit.getMessage()
            }));
        }
        if (a)
        {
            if (ETPush.w() != null)
            {
                ETPush.w().interrupt();
            }
            throw new ETException("Aborting readyAimFire() due to Exception in initialization.  See logcat for more information.");
        } else
        {
            return flag;
        }
    }

    public boolean b()
    {
        return a;
    }

    public void c()
    {
        b.countDown();
    }

    public long d()
    {
        return b.getCount();
    }

    public (int i)
    {
        b = new CountDownLatch(i);
    }
}
