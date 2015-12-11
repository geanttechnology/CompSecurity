// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.tapjoy.internal:
//            fk

class en
    implements Runnable
{

    private fk a;
    private CountDownLatch b;

    public en(fk fk1)
    {
        a = null;
        b = null;
        a = fk1;
        b = null;
    }

    public void run()
    {
        a.e();
        if (b != null)
        {
            b.countDown();
        }
    }
}
