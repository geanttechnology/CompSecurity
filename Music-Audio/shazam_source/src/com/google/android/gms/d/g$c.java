// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;


// Referenced classes of package com.google.android.gms.d:
//            kw, g, la, kv, 
//            ku, lc

public static final class s extends kw
{

    private static volatile c f[];
    public String a;
    public long b;
    public long c;
    public boolean d;
    public long e;

    public static s[] b()
    {
        if (f == null)
        {
            synchronized (la.a)
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

    protected final int a()
    {
        int j = super.a();
        int i = j;
        if (!a.equals(""))
        {
            i = j + kv.b(1, a);
        }
        j = i;
        if (b != 0L)
        {
            j = i + kv.b(2, b);
        }
        i = j;
        if (c != 0x7fffffffL)
        {
            i = j + kv.b(3, c);
        }
        j = i;
        if (d)
        {
            j = i + (kv.c(4) + 1);
        }
        i = j;
        if (e != 0L)
        {
            i = j + kv.b(5, e);
        }
        return i;
    }

    public final lc a(ku ku1)
    {
        do
        {
            int i = ku1.a();
            switch (i)
            {
            default:
                if (a(ku1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                a = ku1.d();
                break;

            case 16: // '\020'
                b = ku1.b();
                break;

            case 24: // '\030'
                c = ku1.b();
                break;

            case 32: // ' '
                d = ku1.c();
                break;

            case 40: // '('
                e = ku1.b();
                break;
            }
        } while (true);
    }

    public final void a(kv kv1)
    {
        if (!a.equals(""))
        {
            kv1.a(1, a);
        }
        if (b != 0L)
        {
            kv1.a(2, b);
        }
        if (c != 0x7fffffffL)
        {
            kv1.a(3, c);
        }
        if (d)
        {
            kv1.a(4, d);
        }
        if (e != 0L)
        {
            kv1.a(5, e);
        }
        super.a(kv1);
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        if (obj != this) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (!(obj instanceof ))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = ()obj;
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
                        return a(((kw) (obj)));
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

    public final int hashCode()
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
        return ((c1 + (((i + 527) * 31 + j) * 31 + k) * 31) * 31 + (int)(e ^ e >>> 32)) * 31 + c();
    }

    public ()
    {
        a = "";
        b = 0L;
        c = 0x7fffffffL;
        d = false;
        e = 0L;
        r = null;
        s = -1;
    }
}
