// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package android.support.v7:
//            aah

class a
    implements a
{

    final aah a;

    public void a(List list)
    {
        a a1;
        for (list = list.iterator(); list.hasNext(); aah.a(a, a.b(a1.a, a1.b)))
        {
            a1 = (b)list.next();
        }

        aah.a(a).countDown();
    }

    tDownLatch(aah aah1)
    {
        a = aah1;
        super();
    }
}
