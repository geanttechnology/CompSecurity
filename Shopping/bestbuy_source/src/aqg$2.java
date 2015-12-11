// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

class ang.Object
    implements aqk
{

    final aqg a;

    public void a(List list)
    {
        aqh aqh1;
        for (list = list.iterator(); list.hasNext(); aqg.a(a, a.a(aqh1.a, aqh1.b)))
        {
            aqh1 = (aqh)list.next();
        }

        aqg.a(a).countDown();
    }

    (aqg aqg1)
    {
        a = aqg1;
        super();
    }
}
