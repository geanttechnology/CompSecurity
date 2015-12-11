// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;

// Referenced classes of package android.support.v7:
//            xv, lu, xz, xu

public static final class c extends xv
{

    private static volatile d d[];
    public String a;
    public d b;
    public d c;

    public static c[] a()
    {
        if (d == null)
        {
            synchronized (xz.a)
            {
                if (d == null)
                {
                    d = new d[0];
                }
            }
        }
        return d;
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
        if (b != null)
        {
            xu1.a(2, b);
        }
        if (c != null)
        {
            xu1.a(3, c);
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
        if (b != null)
        {
            j = i + xu.c(2, b);
        }
        i = j;
        if (c != null)
        {
            i = j + xu.c(3, c);
        }
        return i;
    }

    public c c()
    {
        a = "";
        b = null;
        c = null;
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
        if (!(obj instanceof s)) goto _L4; else goto _L3
_L3:
        obj = (s)obj;
        if (a != null) goto _L6; else goto _L5
_L5:
        flag = flag1;
        if (((a) (obj)).a != null) goto _L4; else goto _L7
_L7:
        if (b != null) goto _L9; else goto _L8
_L8:
        flag = flag1;
        if (((b) (obj)).b != null) goto _L4; else goto _L10
_L10:
        if (c != null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        flag = flag1;
        if (((c) (obj)).c != null) goto _L4; else goto _L11
_L11:
        return a(((xv) (obj)));
_L6:
        if (!a.equals(((a) (obj)).a))
        {
            return false;
        }
          goto _L7
_L9:
        if (!b.equals(((equals) (obj)).b))
        {
            return false;
        }
          goto _L10
        if (!c.equals(((equals) (obj)).c))
        {
            return false;
        }
          goto _L11
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        if (b == null)
        {
            j = 0;
        } else
        {
            j = b.hashCode();
        }
        if (c != null)
        {
            k = c.hashCode();
        }
        return ((j + (i + 527) * 31) * 31 + k) * 31 + d();
    }

    public ()
    {
        c();
    }
}
