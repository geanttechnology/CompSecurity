// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

// Referenced classes of package com.a.a.a:
//            u, t

public final class s
    implements Closeable
{

    final Charset a;
    private final InputStream b;
    private byte c[];
    private int d;
    private int e;

    public s(InputStream inputstream, Charset charset)
    {
        this(inputstream, charset, (byte)0);
    }

    private s(InputStream inputstream, Charset charset, byte byte0)
    {
        if (inputstream == null || charset == null)
        {
            throw new NullPointerException();
        }
        if (!charset.equals(u.d))
        {
            throw new IllegalArgumentException("Unsupported encoding");
        } else
        {
            b = inputstream;
            a = charset;
            c = new byte[8192];
            return;
        }
    }

    private void c()
    {
        int i = b.read(c, 0, c.length);
        if (i == -1)
        {
            throw new EOFException();
        } else
        {
            d = 0;
            e = i;
            return;
        }
    }

    public final String a()
    {
        InputStream inputstream = b;
        inputstream;
        JVM INSTR monitorenter ;
        if (c == null)
        {
            throw new IOException("LineReader is closed");
        }
        break MISSING_BLOCK_LABEL_29;
        Exception exception;
        exception;
        inputstream;
        JVM INSTR monitorexit ;
        throw exception;
        int i;
        if (d >= e)
        {
            c();
        }
        i = d;
_L9:
        if (i == e) goto _L2; else goto _L1
_L1:
        if (c[i] != 10)
        {
            break MISSING_BLOCK_LABEL_265;
        }
        Object obj;
        int j;
        if (i != d && c[i - 1] == 13)
        {
            j = i - 1;
        } else
        {
            j = i;
        }
        obj = new String(c, d, j - d, a.name());
        d = i + 1;
        inputstream;
        JVM INSTR monitorexit ;
        return ((String) (obj));
_L2:
        obj = new t(this, (e - d) + 80);
_L8:
        ((ByteArrayOutputStream) (obj)).write(c, d, e - d);
        e = -1;
        c();
        i = d;
_L6:
        if (i == e)
        {
            break; /* Loop/switch isn't completed */
        }
        if (c[i] != 10) goto _L4; else goto _L3
_L3:
        if (i != d)
        {
            ((ByteArrayOutputStream) (obj)).write(c, d, i - d);
        }
        d = i + 1;
        obj = ((ByteArrayOutputStream) (obj)).toString();
        inputstream;
        JVM INSTR monitorexit ;
        return ((String) (obj));
_L4:
        i++;
        if (true) goto _L6; else goto _L5
_L5:
        if (true) goto _L8; else goto _L7
_L7:
        i++;
          goto _L9
    }

    public final int b()
    {
        String s1 = a();
        int i;
        try
        {
            i = Integer.parseInt(s1);
        }
        catch (NumberFormatException numberformatexception)
        {
            throw new IOException((new StringBuilder("expected an int but was \"")).append(s1).append("\"").toString());
        }
        return i;
    }

    public final void close()
    {
        synchronized (b)
        {
            if (c != null)
            {
                c = null;
                b.close();
            }
        }
        return;
        exception;
        inputstream;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
