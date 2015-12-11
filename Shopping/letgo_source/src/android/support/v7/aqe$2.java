// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package android.support.v7:
//            aqk, aqe, aql, apv, 
//            aqh

static final class b
    implements aqk
{

    final aql a;
    final InputStream b;

    public void close()
        throws IOException
    {
        b.close();
    }

    public long read(apv apv1, long l)
        throws IOException
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("byteCount < 0: ").append(l).toString());
        }
        if (l == 0L)
        {
            return 0L;
        }
        a.throwIfReached();
        aqh aqh1 = apv1.d(1);
        int i = (int)Math.min(l, 2048 - aqh1.c);
        i = b.read(aqh1.a, aqh1.c, i);
        if (i == -1)
        {
            return -1L;
        } else
        {
            aqh1.c = aqh1.c + i;
            apv1.b = apv1.b + (long)i;
            return (long)i;
        }
    }

    public aql timeout()
    {
        return a;
    }

    public String toString()
    {
        return (new StringBuilder()).append("source(").append(b).append(")").toString();
    }

    Exception(aql aql1, InputStream inputstream)
    {
        a = aql1;
        b = inputstream;
        super();
    }
}
