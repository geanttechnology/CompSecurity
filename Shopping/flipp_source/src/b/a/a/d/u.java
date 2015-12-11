// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.d;

import b.a.a.a;
import b.a.a.c;
import b.a.a.d;
import b.a.a.f;
import b.a.a.i;
import b.a.a.l;
import b.a.a.m;
import b.a.a.o;
import b.a.a.p;
import java.util.Arrays;
import java.util.Locale;

// Referenced classes of package b.a.a.d:
//            v, w

public final class u
{

    final a a;
    i b;
    Integer c;
    Locale d;
    Integer e;
    v f[];
    int g;
    boolean h;
    private final long i = 0L;
    private int j;
    private Object k;

    public u(a a1, Locale locale, Integer integer, int i1)
    {
        f = new v[8];
        a1 = b.a.a.f.a(a1);
        b = a1.a();
        a = a1.b();
        a1 = locale;
        if (locale == null)
        {
            a1 = Locale.getDefault();
        }
        d = a1;
        e = integer;
        j = i1;
    }

    static int a(l l1, l l2)
    {
        if (l1 == null || !l1.b())
        {
            return l2 != null && l2.b() ? -1 : 0;
        }
        if (l2 == null || !l2.b())
        {
            return 1;
        } else
        {
            return -l1.compareTo(l2);
        }
    }

    public final long a(String s)
    {
        Object obj;
        int i2;
        do
        {
label0:
            {
                obj = f;
                i2 = g;
                if (h)
                {
                    obj = (v[])(v[])f.clone();
                    f = ((v []) (obj));
                    h = false;
                }
                l l1;
                l l2;
                l l3;
                if (i2 > 10)
                {
                    Arrays.sort(((Object []) (obj)), 0, i2);
                } else
                {
                    int i1 = 0;
                    while (i1 < i2) 
                    {
                        for (int k1 = i1; k1 > 0 && obj[k1 - 1].a(obj[k1]) > 0; k1--)
                        {
                            v v1 = obj[k1];
                            obj[k1] = obj[k1 - 1];
                            obj[k1 - 1] = v1;
                        }

                        i1++;
                    }
                }
                if (i2 <= 0)
                {
                    break label0;
                }
                l1 = m.i().a(a);
                l2 = m.f().a(a);
                l3 = obj[0].a.d();
                if (a(l3, l1) < 0 || a(l3, l2) > 0)
                {
                    break label0;
                }
                a(b.a.a.d.s(), j);
            }
        } while (true);
        int j1;
        long l5;
        l5 = i;
        j1 = 0;
_L2:
        if (j1 >= i2)
        {
            break; /* Loop/switch isn't completed */
        }
        l5 = obj[j1].a(l5, true);
        j1++;
        if (true) goto _L2; else goto _L1
_L18:
        Object obj1;
        boolean flag;
        l5 = ((v) (obj1)).a(l5, flag);
        j1++;
          goto _L3
_L16:
        flag = false;
        continue; /* Loop/switch isn't completed */
        obj;
        if (s == null) goto _L5; else goto _L4
_L4:
        s = (new StringBuilder("Cannot parse \"")).append(s).append('"').toString();
        if (((o) (obj)).a != null) goto _L7; else goto _L6
_L6:
        obj.a = s;
_L5:
        throw obj;
_L7:
        if (s != null)
        {
            obj.a = (new StringBuilder()).append(s).append(": ").append(((o) (obj)).a).toString();
        }
        if (true) goto _L5; else goto _L8
_L8:
        if (c == null) goto _L10; else goto _L9
_L9:
        long l4 = l5 - (long)c.intValue();
_L12:
        return l4;
_L10:
        l4 = l5;
        if (b == null) goto _L12; else goto _L11
_L11:
        j1 = b.c(l5);
        l5 -= j1;
        l4 = l5;
        if (j1 == b.b(l5)) goto _L12; else goto _L13
_L13:
        obj1 = (new StringBuilder("Illegal instant due to time zone offset transition (")).append(b).append(')').toString();
        obj = obj1;
        if (s != null)
        {
            obj = (new StringBuilder("Cannot parse \"")).append(s).append("\": ").append(((String) (obj1))).toString();
        }
        throw new p(((String) (obj)));
_L1:
        j1 = 0;
_L3:
        if (j1 >= i2) goto _L8; else goto _L14
_L14:
        obj1 = obj[j1];
        if (j1 != i2 - 1) goto _L16; else goto _L15
_L15:
        flag = true;
        if (true) goto _L18; else goto _L17
_L17:
    }

    public final Object a()
    {
        if (k == null)
        {
            k = new w(this);
        }
        return k;
    }

    final void a(v v1)
    {
        v av[] = f;
        int j1 = g;
        if (j1 == av.length || h)
        {
            v av1[];
            int i1;
            if (j1 == av.length)
            {
                i1 = j1 * 2;
            } else
            {
                i1 = av.length;
            }
            av1 = new v[i1];
            System.arraycopy(av, 0, av1, 0, j1);
            f = av1;
            h = false;
            av = av1;
        }
        k = null;
        av[j1] = v1;
        g = j1 + 1;
    }

    public final void a(d d1, int i1)
    {
        a(new v(d1.a(a), i1));
    }

    public final void a(i i1)
    {
        k = null;
        b = i1;
    }

    public final void a(Integer integer)
    {
        k = null;
        c = integer;
    }

    public final boolean a(Object obj)
    {
        if (obj instanceof w)
        {
            w w1 = (w)obj;
            boolean flag;
            if (this != w1.e)
            {
                flag = false;
            } else
            {
                b = w1.a;
                c = w1.b;
                f = w1.c;
                if (w1.d < g)
                {
                    h = true;
                }
                g = w1.d;
                flag = true;
            }
            if (flag)
            {
                k = obj;
                return true;
            }
        }
        return false;
    }
}
