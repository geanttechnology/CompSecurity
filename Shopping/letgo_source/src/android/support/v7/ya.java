// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;

// Referenced classes of package android.support.v7:
//            yb, xu

public abstract class ya
{

    protected volatile int s;

    public ya()
    {
        s = -1;
    }

    public void a(xu xu)
        throws IOException
    {
    }

    protected int b()
    {
        return 0;
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return f();
    }

    public ya f()
        throws CloneNotSupportedException
    {
        return (ya)super.clone();
    }

    public int g()
    {
        if (s < 0)
        {
            h();
        }
        return s;
    }

    public int h()
    {
        int i = b();
        s = i;
        return i;
    }

    public String toString()
    {
        return yb.a(this);
    }
}
