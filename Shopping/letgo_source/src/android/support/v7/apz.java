// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;
import java.util.zip.Deflater;

// Referenced classes of package android.support.v7:
//            aqj, aqe, apw, apv, 
//            aqh, aqi, aqm, aql

public final class apz
    implements aqj
{

    private final apw a;
    private final Deflater b;
    private boolean c;

    apz(apw apw1, Deflater deflater)
    {
        if (apw1 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        if (deflater == null)
        {
            throw new IllegalArgumentException("inflater == null");
        } else
        {
            a = apw1;
            b = deflater;
            return;
        }
    }

    public apz(aqj aqj1, Deflater deflater)
    {
        this(aqe.a(aqj1), deflater);
    }

    private void a(boolean flag)
        throws IOException
    {
        apv apv1 = a.b();
        aqh aqh1;
label0:
        do
        {
            do
            {
                aqh1 = apv1.d(1);
                int i;
                if (flag)
                {
                    i = b.deflate(aqh1.a, aqh1.c, 2048 - aqh1.c, 2);
                } else
                {
                    i = b.deflate(aqh1.a, aqh1.c, 2048 - aqh1.c);
                }
                if (i <= 0)
                {
                    continue label0;
                }
                aqh1.c = aqh1.c + i;
                apv1.b = apv1.b + (long)i;
                a.v();
            } while (true);
        } while (!b.needsInput());
        if (aqh1.b == aqh1.c)
        {
            apv1.a = aqh1.a();
            aqi.a(aqh1);
        }
    }

    void a()
        throws IOException
    {
        b.finish();
        a(false);
    }

    public void close()
        throws IOException
    {
        if (!c) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Throwable throwable1 = null;
        Throwable throwable;
        Throwable throwable2;
        try
        {
            a();
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable1) { }
        b.end();
        throwable = throwable1;
_L3:
        a.close();
        throwable1 = throwable;
_L4:
        c = true;
        if (throwable1 != null)
        {
            aqm.a(throwable1);
            return;
        }
          goto _L1
        throwable;
        if (throwable1 != null)
        {
            throwable = throwable1;
        }
          goto _L3
        throwable2;
        throwable1 = throwable;
        if (throwable == null)
        {
            throwable1 = throwable2;
        }
          goto _L4
    }

    public void flush()
        throws IOException
    {
        a(true);
        a.flush();
    }

    public aql timeout()
    {
        return a.timeout();
    }

    public String toString()
    {
        return (new StringBuilder()).append("DeflaterSink(").append(a).append(")").toString();
    }

    public void write(apv apv1, long l)
        throws IOException
    {
        aqm.a(apv1.b, 0L, l);
        int i;
        for (; l > 0L; l -= i)
        {
            aqh aqh1 = apv1.a;
            i = (int)Math.min(l, aqh1.c - aqh1.b);
            b.setInput(aqh1.a, aqh1.b, i);
            a(false);
            apv1.b = apv1.b - (long)i;
            aqh1.b = aqh1.b + i;
            if (aqh1.b == aqh1.c)
            {
                apv1.a = aqh1.a();
                aqi.a(aqh1);
            }
        }

    }
}
