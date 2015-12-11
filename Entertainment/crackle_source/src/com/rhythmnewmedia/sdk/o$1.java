// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;


// Referenced classes of package com.rhythmnewmedia.sdk:
//            o, y

public final class b
    implements Runnable
{

    final String a;
    final String b;
    final o c;

    public final void run()
    {
        Object obj;
        obj = String.format("%s/adServed?requestId=%s&id=%s&%s=%d", new Object[] {
            o.a(c), a, b, "v", Integer.valueOf(3)
        });
        obj = o.a(c, a(((String) (obj))));
        o.b(((org.apache.http.HttpResponse) (obj)));
        return;
        Object obj1;
        obj1;
        y.a(((Throwable) (obj1)), "Error during ack", new Object[0]);
        o.b(null);
        return;
        obj1;
        o.b(null);
        throw obj1;
    }

    public (o o1, String s, String s1)
    {
        c = o1;
        a = s;
        b = s1;
        super();
    }
}
