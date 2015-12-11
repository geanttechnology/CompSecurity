// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import java.util.Iterator;

// Referenced classes of package com.rhythmnewmedia.sdk:
//            a, y

final class a
    implements Runnable
{

    final Iterable a;
    final a b;

    public final void run()
    {
        Object obj;
        Iterator iterator = a.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_50;
            }
            obj = ()iterator.next();
        } while (!(() (obj)).c);
        Object obj1 = b.a(((b) (obj)), null);
        com.rhythmnewmedia.sdk.a.a(((org.apache.http.HttpResponse) (obj1)));
_L3:
        obj = a.iterator();
_L1:
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_161;
            }
            obj1 = ()((Iterator) (obj)).next();
        } while ((() (obj1)).c);
        org.apache.http.HttpResponse httpresponse = b.a(((b) (obj1)), null);
        com.rhythmnewmedia.sdk.a.a(httpresponse);
          goto _L1
        obj1;
        y.a(((Throwable) (obj1)), "Error pinging %s", new Object[] {
            obj
        });
        com.rhythmnewmedia.sdk.a.a(null);
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        com.rhythmnewmedia.sdk.a.a(null);
        throw exception;
        Throwable throwable;
        throwable;
        y.a(throwable, "Error pinging %s", new Object[] {
            obj1
        });
        com.rhythmnewmedia.sdk.a.a(null);
          goto _L1
        exception;
        com.rhythmnewmedia.sdk.a.a(null);
        throw exception;
        return;
        if (true) goto _L3; else goto _L2
_L2:
    }

    (a a1, Iterable iterable)
    {
        b = a1;
        a = iterable;
        super();
    }
}
