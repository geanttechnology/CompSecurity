// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

// Referenced classes of package android.support.v7:
//            aqk, aqe, apx, apv, 
//            aqh, aqi, aql

public final class aqd
    implements aqk
{

    private final apx a;
    private final Inflater b;
    private int c;
    private boolean d;

    aqd(apx apx1, Inflater inflater)
    {
        if (apx1 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null)
        {
            throw new IllegalArgumentException("inflater == null");
        } else
        {
            a = apx1;
            b = inflater;
            return;
        }
    }

    public aqd(aqk aqk1, Inflater inflater)
    {
        this(aqe.a(aqk1), inflater);
    }

    private void b()
        throws IOException
    {
        if (c == 0)
        {
            return;
        } else
        {
            int i = c - b.getRemaining();
            c = c - i;
            a.g(i);
            return;
        }
    }

    public boolean a()
        throws IOException
    {
        if (!b.needsInput())
        {
            return false;
        }
        b();
        if (b.getRemaining() != 0)
        {
            throw new IllegalStateException("?");
        }
        if (a.f())
        {
            return true;
        } else
        {
            aqh aqh1 = a.b().a;
            c = aqh1.c - aqh1.b;
            b.setInput(aqh1.a, aqh1.b, c);
            return false;
        }
    }

    public void close()
        throws IOException
    {
        if (d)
        {
            return;
        } else
        {
            b.end();
            d = true;
            a.close();
            return;
        }
    }

    public long read(apv apv1, long l)
        throws IOException
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("byteCount < 0: ").append(l).toString());
        }
        if (d)
        {
            throw new IllegalStateException("closed");
        }
        if (l == 0L)
        {
            return 0L;
        }
_L2:
        boolean flag = a();
        aqh aqh1;
        int i;
        try
        {
            aqh1 = apv1.d(1);
            i = b.inflate(aqh1.a, aqh1.c, 2048 - aqh1.c);
        }
        // Misplaced declaration of an exception variable
        catch (apv apv1)
        {
            throw new IOException(apv1);
        }
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        aqh1.c = aqh1.c + i;
        apv1.b = apv1.b + (long)i;
        return (long)i;
        if (b.finished() || b.needsDictionary())
        {
            b();
            if (aqh1.b == aqh1.c)
            {
                apv1.a = aqh1.a();
                aqi.a(aqh1);
            }
            break MISSING_BLOCK_LABEL_212;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        throw new EOFException("source exhausted prematurely");
        return -1L;
    }

    public aql timeout()
    {
        return a.timeout();
    }
}
