// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.device.ads:
//            di, ba, ao, cm, 
//            dn, cz, bc, df, 
//            dj, dk

final class a
    implements Runnable
{

    final di a;

    public final void run()
    {
        di di1 = a;
        CountDownLatch countdownlatch = new CountDownLatch(1);
        Object obj = new AtomicBoolean(false);
        di1.f.a(new <init>(di1, ((AtomicBoolean) (obj)), countdownlatch));
        boolean flag;
        long l;
        try
        {
            countdownlatch.await();
        }
        catch (InterruptedException interruptedexception) { }
        if (!((AtomicBoolean) (obj)).get()) goto _L2; else goto _L1
_L1:
        l = System.currentTimeMillis();
        if (!di1.c.a().a) goto _L2; else goto _L3
_L3:
        obj = di1.e.c;
        if (l - di1.g.a("amzn-ad-sis-last-checkin", 0L) > 0x5265c00L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag || dn.a().a("newSISDIDRequested", false)) goto _L5; else goto _L4
_L4:
        if (!cz.b())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag && !di1.i.a("debug.shouldRegisterSIS", Boolean.valueOf(false)).booleanValue()) goto _L6; else goto _L5
_L5:
        flag = true;
_L8:
        if (flag)
        {
            obj = di1.g;
            ((dn) (obj)).a("amzn-ad-sis-last-checkin", new <init>(((dn) (obj)), java/lang/Long, Long.valueOf(l)));
            obj = di1.e.c;
            if (!cz.b())
            {
                break; /* Loop/switch isn't completed */
            }
            obj = di1.c;
            obj = a(b).a(((ao) (obj)));
            a(new <init>(di1), new dj[] {
                obj
            }).a();
        }
_L2:
        return;
_L6:
        flag = false;
        if (true) goto _L8; else goto _L7
_L7:
        obj = di1.c;
        obj = a(a).a(((ao) (obj)));
        a(new <init>(di1), new dj[] {
            obj
        }).a();
        return;
    }

    ion(di di1)
    {
        a = di1;
        super();
    }
}
