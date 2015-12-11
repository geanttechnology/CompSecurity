// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package android.support.v7:
//            aqj, aqe, apv, aqm, 
//            aql, aqh, aqi

static final class b
    implements aqj
{

    final aql a;
    final OutputStream b;

    public void close()
        throws IOException
    {
        b.close();
    }

    public void flush()
        throws IOException
    {
        b.flush();
    }

    public aql timeout()
    {
        return a;
    }

    public String toString()
    {
        return (new StringBuilder()).append("sink(").append(b).append(")").toString();
    }

    public void write(apv apv1, long l)
        throws IOException
    {
        aqm.a(apv1.b, 0L, l);
        do
        {
            if (l <= 0L)
            {
                break;
            }
            a.throwIfReached();
            aqh aqh1 = apv1.a;
            int i = (int)Math.min(l, aqh1.c - aqh1.b);
            b.write(aqh1.a, aqh1.b, i);
            aqh1.b = aqh1.b + i;
            long l1 = l - (long)i;
            apv1.b = apv1.b - (long)i;
            l = l1;
            if (aqh1.b == aqh1.c)
            {
                apv1.a = aqh1.a();
                aqi.a(aqh1);
                l = l1;
            }
        } while (true);
    }

    (aql aql1, OutputStream outputstream)
    {
        a = aql1;
        b = outputstream;
        super();
    }
}
