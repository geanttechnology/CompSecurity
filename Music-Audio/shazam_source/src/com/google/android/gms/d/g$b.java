// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;


// Referenced classes of package com.google.android.gms.d:
//            kw, g, lg, la, 
//            kv, ku, lc

public static final class s extends kw
{

    private static volatile c f[];
    public int a[];
    public int b;
    public int c;
    public boolean d;
    public boolean e;

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
        int j = 0;
        int k = super.a();
        int i = k;
        if (e)
        {
            i = k + (kv.c(1) + 1);
        }
        k = kv.b(2, b) + i;
        if (a != null && a.length > 0)
        {
            for (i = 0; i < a.length; i++)
            {
                j += kv.a(a[i]);
            }

            j = k + j + a.length * 1;
        } else
        {
            j = k;
        }
        i = j;
        if (c != 0)
        {
            i = j + kv.b(4, c);
        }
        j = i;
        if (d)
        {
            j = i + (kv.c(6) + 1);
        }
        return j;
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

            case 8: // '\b'
                e = ku1.c();
                break;

            case 16: // '\020'
                b = ku1.e();
                break;

            case 24: // '\030'
                int l = lg.a(ku1, 24);
                int ai[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                ai = new int[l + j];
                l = j;
                if (j != 0)
                {
                    System.arraycopy(a, 0, ai, 0, j);
                    l = j;
                }
                for (; l < ai.length - 1; l++)
                {
                    ai[l] = ku1.e();
                    ku1.a();
                }

                ai[l] = ku1.e();
                a = ai;
                break;

            case 26: // '\032'
                int j1 = ku1.c(ku1.e());
                int k = ku1.i();
                int i1;
                for (i1 = 0; ku1.h() > 0; i1++)
                {
                    ku1.e();
                }

                ku1.e(k);
                int ai1[];
                if (a == null)
                {
                    k = 0;
                } else
                {
                    k = a.length;
                }
                ai1 = new int[i1 + k];
                i1 = k;
                if (k != 0)
                {
                    System.arraycopy(a, 0, ai1, 0, k);
                    i1 = k;
                }
                for (; i1 < ai1.length; i1++)
                {
                    ai1[i1] = ku1.e();
                }

                a = ai1;
                ku1.d(j1);
                break;

            case 32: // ' '
                c = ku1.e();
                break;

            case 48: // '0'
                d = ku1.c();
                break;
            }
        } while (true);
    }

    public final void a(kv kv1)
    {
        if (e)
        {
            kv1.a(1, e);
        }
        kv1.a(2, b);
        if (a != null && a.length > 0)
        {
            for (int i = 0; i < a.length; i++)
            {
                kv1.a(3, a[i]);
            }

        }
        if (c != 0)
        {
            kv1.a(4, c);
        }
        if (d)
        {
            kv1.a(6, d);
        }
        super.a(kv1);
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag;
        if (obj == this)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (obj instanceof )
            {
                obj = ()obj;
                flag = flag1;
                if (la.a(a, ((a) (obj)).a))
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
                                    return a(((kw) (obj)));
                                }
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }

    public final int hashCode()
    {
        char c2 = '\u04CF';
        int i = la.a(a);
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
        return ((c1 + (((i + 527) * 31 + j) * 31 + k) * 31) * 31 + c2) * 31 + c();
    }

    public ()
    {
        a = lg.a;
        b = 0;
        c = 0;
        d = false;
        e = false;
        r = null;
        s = -1;
    }
}
