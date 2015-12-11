// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;

// Referenced classes of package com.paypal.android.sdk:
//            ks, hl, gm

public abstract class gw
    implements Closeable
{

    public gw()
    {
    }

    private byte[] e()
    {
        ks ks1;
        long l;
        l = b();
        if (l > 0x7fffffffL)
        {
            throw new IOException((new StringBuilder("Cannot buffer entire body for content length: ")).append(l).toString());
        }
        ks1 = c();
        Object obj = ks1.m();
        hl.a(ks1);
        if (l != -1L && l != (long)obj.length)
        {
            throw new IOException("Content-Length and stream length disagree");
        } else
        {
            return ((byte []) (obj));
        }
        obj;
        hl.a(ks1);
        throw obj;
    }

    public abstract gm a();

    public abstract long b();

    public abstract ks c();

    public void close()
    {
        c().close();
    }

    public final String d()
    {
        byte abyte0[] = e();
        Object obj = a();
        if (obj != null)
        {
            obj = ((gm) (obj)).a(hl.c);
        } else
        {
            obj = hl.c;
        }
        return new String(abyte0, ((Charset) (obj)).name());
    }
}
