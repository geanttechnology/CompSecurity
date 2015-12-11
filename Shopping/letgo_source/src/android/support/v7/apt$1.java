// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;

// Referenced classes of package android.support.v7:
//            aqj, apt, aql, apv

class a
    implements aqj
{

    final aqj a;
    final apt b;

    public void close()
        throws IOException
    {
        b.enter();
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

    public void flush()
        throws IOException
    {
        b.enter();
        a.flush();
        b.exit(true);
        return;
        Object obj;
        obj;
        throw b.exit(((IOException) (obj)));
        obj;
        b.exit(false);
        throw obj;
    }

    public aql timeout()
    {
        return b;
    }

    public String toString()
    {
        return (new StringBuilder()).append("AsyncTimeout.sink(").append(a).append(")").toString();
    }

    public void write(apv apv, long l)
        throws IOException
    {
        b.enter();
        a.write(apv, l);
        b.exit(true);
        return;
        apv;
        throw b.exit(apv);
        apv;
        b.exit(false);
        throw apv;
    }

    (apt apt1, aqj aqj1)
    {
        b = apt1;
        a = aqj1;
        super();
    }
}
