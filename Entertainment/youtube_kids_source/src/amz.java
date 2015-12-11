// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

public final class amz extends HttpEntityWrapper
{

    private final String a;
    private final int b;
    private final long c;
    private final long d;
    private final long e;
    private final long f;

    public amz(HttpEntity httpentity, String s, int i, long l, long l1, 
            long l2, long l3)
    {
        super(httpentity);
        a = s;
        b = i;
        c = l;
        d = l1;
        e = l2;
        f = l3;
    }

    static long a(amz amz1)
    {
        return amz1.f;
    }

    static int b(amz amz1)
    {
        return amz1.b;
    }

    static String c(amz amz1)
    {
        return amz1.a;
    }

    static long d(amz amz1)
    {
        return amz1.e;
    }

    static long e(amz amz1)
    {
        return amz1.c;
    }

    static long f(amz amz1)
    {
        return amz1.d;
    }

    public final InputStream getContent()
    {
        return new ana(this, super.getContent());
    }
}
