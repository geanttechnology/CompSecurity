// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            ck, dy, cn

final class a
    implements Runnable
{

    final dy a;
    final ck b;

    public final void run()
    {
        a.e();
        try
        {
            a.c();
            return;
        }
        catch (a a1)
        {
            switch (a[a1.a.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                ck.a(b).d("Unable to submit metrics for ad due to an Invalid Client Protocol, msg: %s", new Object[] {
                    a1.getMessage()
                });
                return;

            case 2: // '\002'
                ck.a(b).d("Unable to submit metrics for ad due to Network Failure, msg: %s", new Object[] {
                    a1.getMessage()
                });
                return;

            case 3: // '\003'
                ck.a(b).d("Unable to submit metrics for ad due to a Malformed Pixel URL, msg: %s", new Object[] {
                    a1.getMessage()
                });
                // fall through

            case 4: // '\004'
                ck.a(b).d("Unable to submit metrics for ad because of unsupported character encoding, msg: %s", new Object[] {
                    a1.getMessage()
                });
                break;
            }
        }
    }

    (ck ck1, dy dy1)
    {
        b = ck1;
        a = dy1;
        super();
    }
}
