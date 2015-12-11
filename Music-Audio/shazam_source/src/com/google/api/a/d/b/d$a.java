// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d.b;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

// Referenced classes of package com.google.api.a.d.b:
//            d

private final class b extends FilterInputStream
{

    final d a;
    private long b;

    private void a()
    {
        String s = a.a.getHeaderField("Content-Length");
        long l;
        if (s == null)
        {
            l = -1L;
        } else
        {
            l = Long.parseLong(s);
        }
        while (l == -1L || b == 0L || b >= l) 
        {
            return;
        }
        long l1 = b;
        throw new IOException((new StringBuilder(102)).append("Connection closed prematurely: bytesRead = ").append(l1).append(", Content-Length = ").append(l).toString());
    }

    public final int read()
    {
        int i = in.read();
        if (i == -1)
        {
            a();
            return i;
        } else
        {
            b = b + 1L;
            return i;
        }
    }

    public final int read(byte abyte0[], int i, int j)
    {
        i = in.read(abyte0, i, j);
        if (i == -1)
        {
            a();
            return i;
        } else
        {
            b = b + (long)i;
            return i;
        }
    }

    public n(d d1, InputStream inputstream)
    {
        a = d1;
        super(inputstream);
        b = 0L;
    }
}
