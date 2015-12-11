// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;

// Referenced classes of package android.support.v7:
//            xv, lu, xz, xu

public static final class c extends xv
{

    private static volatile d f[];
    public String a;
    public long b;
    public long c;
    public boolean d;
    public long e;

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
        if (!a.equals(""))
        {
            xu1.a(1, a);
        }
        if (b != 0L)
        {
            xu1.a(2, b);
        }
        if (c != 0x7fffffffL)
        {
            xu1.a(3, c);
        }
        if (d)
        {
            xu1.a(4, d);
        }
        if (e != 0L)
        {
            xu1.a(5, e);
        }
        super.a(xu1);
    }

    protected int b()
    {
        int j = super.b();
        int i = j;
        if (!a.equals(""))
        {
            i = j + xu.b(1, a);
        }
        j = i;
        if (b != 0L)
        {
            j = i + xu.b(2, b);
        }
        i = j;
        if (c != 0x7fffffffL)
        {
            i = j + xu.b(3, c);
        }
        j = i;
        if (d)
        {
            j = i + xu.b(4, d);
        }
        i = j;
        if (e != 0L)
        {
            i = j + xu.b(5, e);
        }
        return i;
    }

    public e c()
    {
        a = "";
        b = 0L;
        c = 0x7fffffffL;
        d = false;
        e = 0L;
        r = null;
        s = -1;
        return this;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        if (obj != this) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (!(obj instanceof s))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = (s)obj;
        if (a != null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (((a) (obj)).a != null)
        {
            continue; /* Loop/switch isn't completed */
        }
_L5:
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
        if (true) goto _L4; else goto _L3
_L3:
        if (!a.equals(((a) (obj)).a))
        {
            return false;
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    public int hashCode()
    {
        int i;
        char c1;
        int j;
        int k;
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        j = (int)(b ^ b >>> 32);
        k = (int)(c ^ c >>> 32);
        if (d)
        {
            c1 = '\u04CF';
        } else
        {
            c1 = '\u04D5';
        }
        return ((c1 + (((i + 527) * 31 + j) * 31 + k) * 31) * 31 + (int)(e ^ e >>> 32)) * 31 + d();
    }

    public ()
    {
        c();
    }
}
