// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;

// Referenced classes of package android.support.v7:
//            xv, lu, xz, xu

public static final class c extends xv
{

    private static volatile d c[];
    public int a;
    public int b;

    public static c[] a()
    {
        if (c == null)
        {
            synchronized (xz.a)
            {
                if (c == null)
                {
                    c = new c[0];
                }
            }
        }
        return c;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(xu xu1)
        throws IOException
    {
        xu1.a(1, a);
        xu1.a(2, b);
        super.a(xu1);
    }

    protected int b()
    {
        return super.b() + xu.b(1, a) + xu.b(2, b);
    }

    public b c()
    {
        a = 0;
        b = 0;
        r = null;
        s = -1;
        return this;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag;
        if (obj == this)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (obj instanceof s)
            {
                obj = (s)obj;
                flag = flag1;
                if (a == ((a) (obj)).a)
                {
                    flag = flag1;
                    if (b == ((b) (obj)).b)
                    {
                        return a(((xv) (obj)));
                    }
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return ((a + 527) * 31 + b) * 31 + d();
    }

    public ()
    {
        c();
    }
}
