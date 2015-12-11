// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;

// Referenced classes of package android.support.v7:
//            xv, lu, xz, xu, 
//            ye

public static final class c extends xv
{

    private static volatile d f[];
    public int a[];
    public int b;
    public int c;
    public boolean d;
    public boolean e;

    public static c[] a()
    {
        if (f == null)
        {
            synchronized (xz.a)
            {
                if (f == null)
                {
                    f = new f[0];
                }
            }
        }
        return f;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(xu xu1)
        throws IOException
    {
        if (e)
        {
            xu1.a(1, e);
        }
        xu1.a(2, b);
        if (a != null && a.length > 0)
        {
            for (int i = 0; i < a.length; i++)
            {
                xu1.a(3, a[i]);
            }

        }
        if (c != 0)
        {
            xu1.a(4, c);
        }
        if (d)
        {
            xu1.a(6, d);
        }
        super.a(xu1);
    }

    protected int b()
    {
        int j = 0;
        int k = super.b();
        int i = k;
        if (e)
        {
            i = k + xu.b(1, e);
        }
        k = xu.b(2, b) + i;
        if (a != null && a.length > 0)
        {
            for (i = 0; i < a.length; i++)
            {
                j += xu.b(a[i]);
            }

            j = k + j + a.length * 1;
        } else
        {
            j = k;
        }
        i = j;
        if (c != 0)
        {
            i = j + xu.b(4, c);
        }
        j = i;
        if (d)
        {
            j = i + xu.b(6, d);
        }
        return j;
    }

    public d c()
    {
        a = ye.a;
        b = 0;
        c = 0;
        d = false;
        e = false;
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
                if (xz.a(a, ((a) (obj)).a))
                {
                    flag = flag1;
                    if (b == ((b) (obj)).b)
                    {
                        flag = flag1;
                        if (c == ((c) (obj)).c)
                        {
                            flag = flag1;
                            if (d == ((d) (obj)).d)
                            {
                                flag = flag1;
                                if (e == ((e) (obj)).e)
                                {
                                    return a(((xv) (obj)));
                                }
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        char c2 = '\u04CF';
        int i = xz.a(a);
        int j = b;
        int k = c;
        char c1;
        if (d)
        {
            c1 = '\u04CF';
        } else
        {
            c1 = '\u04D5';
        }
        if (!e)
        {
            c2 = '\u04D5';
        }
        return ((c1 + (((i + 527) * 31 + j) * 31 + k) * 31) * 31 + c2) * 31 + d();
    }

    public ()
    {
        c();
    }
}
