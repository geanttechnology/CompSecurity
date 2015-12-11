// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

// Referenced classes of package com.tapjoy.internal:
//            ho, hn, hl, ht

public final class hr
    implements HttpEntity
{

    private static final char a[] = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final hn b;
    private final Header c;
    private long d;
    private volatile boolean e;

    public hr()
    {
        this(ho.a);
    }

    private hr(ho ho1)
    {
        String s = a();
        ho ho2 = ho1;
        if (ho1 == null)
        {
            ho2 = ho.a;
        }
        b = new hn("form-data", s, ho2);
        ho1 = new StringBuilder();
        ho1.append("multipart/form-data; boundary=");
        ho1.append(s);
        c = new BasicHeader("Content-Type", ho1.toString());
        e = true;
    }

    public hr(ho ho1, byte byte0)
    {
        this(ho1);
    }

    private static String a()
    {
        StringBuilder stringbuilder = new StringBuilder();
        Random random = new Random();
        int j = random.nextInt(11);
        for (int i = 0; i < j + 30; i++)
        {
            stringbuilder.append(a[random.nextInt(a.length)]);
        }

        return stringbuilder.toString();
    }

    public final void a(hl hl1)
    {
        b.a(hl1);
        e = true;
    }

    public final void a(String s, ht ht1)
    {
        a(new hl(s, ht1));
    }

    public final void consumeContent()
    {
        if (isStreaming())
        {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        } else
        {
            return;
        }
    }

    public final InputStream getContent()
    {
        throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
    }

    public final Header getContentEncoding()
    {
        return null;
    }

    public final long getContentLength()
    {
        if (e)
        {
            d = b.b();
            e = false;
        }
        return d;
    }

    public final Header getContentType()
    {
        return c;
    }

    public final boolean isChunked()
    {
        return !isRepeatable();
    }

    public final boolean isRepeatable()
    {
        for (Iterator iterator = b.a().iterator(); iterator.hasNext();)
        {
            if (((hl)iterator.next()).b.d() < 0L)
            {
                return false;
            }
        }

        return true;
    }

    public final boolean isStreaming()
    {
        return !isRepeatable();
    }

    public final void writeTo(OutputStream outputstream)
    {
        b.a(outputstream);
    }

}
