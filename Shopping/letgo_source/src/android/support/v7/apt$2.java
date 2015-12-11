// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;

// Referenced classes of package android.support.v7:
//            aqk, apt, apv, aql

class a
    implements aqk
{

    final aqk a;
    final apt b;

    public void close()
        throws IOException
    {
        a.close();
        b.exit(true);
        return;
        Object obj;
        obj;
        throw b.exit(((IOException) (obj)));
        obj;
        b.exit(false);
        throw obj;
    }

    public long read(apv apv, long l)
        throws IOException
    {
        b.enter();
        l = a.read(apv, l);
        b.exit(true);
        return l;
        apv;
        throw b.exit(apv);
        apv;
        b.exit(false);
        throw apv;
    }

    public aql timeout()
    {
        return b;
    }

    public String toString()
    {
        return (new StringBuilder()).append("AsyncTimeout.source(").append(a).append(")").toString();
    }

    (apt apt1, aqk aqk1)
    {
        b = apt1;
        a = aqk1;
        super();
    }
}
