// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.d;

import b.a.a.d;
import java.util.ArrayList;

// Referenced classes of package b.a.a.d:
//            t, g, i, x, 
//            d, f, n, h, 
//            s, l, m, q, 
//            j

public final class e
{

    private ArrayList a;
    private Object b;

    public e()
    {
        a = new ArrayList();
    }

    static void a(StringBuffer stringbuffer, int k)
    {
        do
        {
            k--;
            if (k >= 0)
            {
                stringbuffer.append('\uFFFD');
            } else
            {
                return;
            }
        } while (true);
    }

    private static boolean b(Object obj)
    {
        if (obj instanceof t)
        {
            return !(obj instanceof g) || ((g)obj).b != null;
        } else
        {
            return false;
        }
    }

    private e c(d d1, int k, int i1)
    {
        if (d1 == null)
        {
            throw new IllegalArgumentException("Field type must not be null");
        }
        int j1 = i1;
        if (i1 < k)
        {
            j1 = k;
        }
        if (k < 0 || j1 <= 0)
        {
            throw new IllegalArgumentException();
        } else
        {
            return a(new i(d1, k, j1));
        }
    }

    private static void c(t t1)
    {
        if (t1 == null)
        {
            throw new IllegalArgumentException("No parser supplied");
        } else
        {
            return;
        }
    }

    private Object e()
    {
        Object obj;
        Object obj1;
        obj1 = b;
        obj = obj1;
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        obj = obj1;
        if (a.size() != 2) goto _L4; else goto _L3
_L3:
        Object obj3;
        Object obj4;
        obj3 = a.get(0);
        obj4 = a.get(1);
        if (obj3 == null) goto _L6; else goto _L5
_L5:
        if (obj3 == obj4) goto _L8; else goto _L7
_L7:
        obj = obj1;
        if (obj4 != null) goto _L4; else goto _L8
_L8:
        obj = obj3;
_L4:
        Object obj2 = obj;
        if (obj == null)
        {
            obj2 = new g(a);
        }
        b = obj2;
        obj = obj2;
_L2:
        return obj;
_L6:
        obj = obj4;
        if (true) goto _L4; else goto _L9
_L9:
    }

    public final b.a.a.d.d a()
    {
        Object obj = e();
        x x1;
        boolean flag;
        if (obj instanceof x)
        {
            if (obj instanceof g)
            {
                if (((g)obj).a != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            {
                flag = true;
            }
        } else
        {
            flag = false;
        }
        if (flag)
        {
            x1 = (x)obj;
        } else
        {
            x1 = null;
        }
        if (b(obj))
        {
            obj = (t)obj;
        } else
        {
            obj = null;
        }
        if (x1 != null || obj != null)
        {
            return new b.a.a.d.d(x1, ((t) (obj)));
        } else
        {
            throw new UnsupportedOperationException("Both printing and parsing not supported");
        }
    }

    public final e a(char c1)
    {
        return a(new f(c1));
    }

    public final e a(int k)
    {
        return a(b.a.a.d.c(), k, 2);
    }

    public final e a(int k, int i1)
    {
        return c(b.a.a.d.d(), k, i1);
    }

    public final e a(b.a.a.d.d d1)
    {
        if (d1 == null)
        {
            throw new IllegalArgumentException("No formatter supplied");
        } else
        {
            return a(d1.a, d1.b);
        }
    }

    public final e a(t t1)
    {
        c(t1);
        return a(((x) (null)), t1);
    }

    final e a(x x1, t t1)
    {
        b = null;
        a.add(x1);
        a.add(t1);
        return this;
    }

    public final e a(d d1)
    {
        if (d1 == null)
        {
            throw new IllegalArgumentException("Field type must not be null");
        } else
        {
            return a(new n(d1, false));
        }
    }

    public final e a(d d1, int k)
    {
        if (d1 == null)
        {
            throw new IllegalArgumentException("Field type must not be null");
        }
        if (k <= 0)
        {
            throw new IllegalArgumentException((new StringBuilder("Illegal number of digits: ")).append(k).toString());
        } else
        {
            return a(new h(d1, k));
        }
    }

    public final e a(d d1, int k, int i1)
    {
        if (d1 == null)
        {
            throw new IllegalArgumentException("Field type must not be null");
        }
        int j1 = i1;
        if (i1 < k)
        {
            j1 = k;
        }
        if (k < 0 || j1 <= 0)
        {
            throw new IllegalArgumentException();
        }
        if (k <= 1)
        {
            return a(new s(d1, j1, false));
        } else
        {
            return a(new l(d1, j1, false, k));
        }
    }

    final e a(Object obj)
    {
        b = null;
        a.add(obj);
        a.add(obj);
        return this;
    }

    public final e a(String s1)
    {
        e e1 = this;
        switch (s1.length())
        {
        default:
            e1 = a(new m(s1));
            // fall through

        case 0: // '\0'
            return e1;

        case 1: // '\001'
            return a(new f(s1.charAt(0)));
        }
    }

    public final e a(String s1, boolean flag)
    {
        return a(new q(null, s1, flag, 2));
    }

    public final e a(String s1, boolean flag, int k)
    {
        return a(new q(s1, s1, flag, k));
    }

    public final e a(t at[])
    {
        int k = 0;
        int i1 = at.length;
        if (i1 == 1)
        {
            if (at[0] == null)
            {
                throw new IllegalArgumentException("No parser supplied");
            } else
            {
                return a(((x) (null)), at[0]);
            }
        }
        t at1[] = new t[i1];
        for (; k < i1 - 1; k++)
        {
            t t1 = at[k];
            at1[k] = t1;
            if (t1 == null)
            {
                throw new IllegalArgumentException("Incomplete parser array");
            }
        }

        at1[k] = at[k];
        return a(((x) (null)), ((t) (new j(at1))));
    }

    public final e b(int k)
    {
        return a(b.a.a.d.e(), k, 2);
    }

    public final e b(int k, int i1)
    {
        return b(b.a.a.d.p(), k, i1);
    }

    public final e b(t t1)
    {
        c(t1);
        return a(((x) (null)), new j(new t[] {
            t1, null
        }));
    }

    public final e b(d d1)
    {
        if (d1 == null)
        {
            throw new IllegalArgumentException("Field type must not be null");
        } else
        {
            return a(new n(d1, true));
        }
    }

    public final e b(d d1, int k, int i1)
    {
        if (d1 == null)
        {
            throw new IllegalArgumentException("Field type must not be null");
        }
        int j1 = i1;
        if (i1 < k)
        {
            j1 = k;
        }
        if (k < 0 || j1 <= 0)
        {
            throw new IllegalArgumentException();
        }
        if (k <= 1)
        {
            return a(new s(d1, j1, true));
        } else
        {
            return a(new l(d1, j1, true, k));
        }
    }

    public final t b()
    {
        Object obj = e();
        if (b(obj))
        {
            return (t)obj;
        } else
        {
            throw new UnsupportedOperationException("Parsing is not supported");
        }
    }

    public final e c()
    {
        return c(b.a.a.d.f(), 1, 9);
    }

    public final e c(int k)
    {
        return a(b.a.a.d.g(), k, 2);
    }

    public final e c(int k, int i1)
    {
        return b(b.a.a.d.s(), k, i1);
    }

    public final e d()
    {
        return c(b.a.a.d.g(), 1, 9);
    }

    public final e d(int k)
    {
        return a(b.a.a.d.l(), k, 1);
    }

    public final e e(int k)
    {
        return a(b.a.a.d.m(), k, 2);
    }

    public final e f(int k)
    {
        return a(b.a.a.d.n(), k, 3);
    }

    public final e g(int k)
    {
        return a(b.a.a.d.o(), k, 2);
    }

    public final e h(int k)
    {
        return a(b.a.a.d.r(), k, 2);
    }
}
