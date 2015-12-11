// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b;

import com.google.b.b.j;
import com.google.b.c.a;
import com.google.b.d.c;

// Referenced classes of package com.google.b:
//            x, f, n, k, 
//            t, y

final class w extends x
{
    private static final class a
        implements y
    {

        private final com.google.b.c.a a;
        private final boolean b;
        private final Class c;
        private final t d;
        private final k e;

        public final x a(f f1, com.google.b.c.a a1)
        {
            boolean flag;
            if (a != null)
            {
                if (a.equals(a1) || b && a.b == a1.a)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            {
                flag = c.isAssignableFrom(a1.a);
            }
            if (flag)
            {
                return new w(d, e, f1, a1, this, (byte)0);
            } else
            {
                return null;
            }
        }

        private a(Object obj, com.google.b.c.a a1, boolean flag)
        {
            t t1;
            boolean flag1;
            if (obj instanceof t)
            {
                t1 = (t)obj;
            } else
            {
                t1 = null;
            }
            d = t1;
            if (obj instanceof k)
            {
                obj = (k)obj;
            } else
            {
                obj = null;
            }
            e = ((k) (obj));
            if (d != null || e != null)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            com.google.b.b.a.a(flag1);
            a = a1;
            b = flag;
            c = null;
        }

        a(Object obj, com.google.b.c.a a1, boolean flag, byte byte0)
        {
            this(obj, a1, flag);
        }
    }


    private final t a;
    private final k b;
    private final f c;
    private final com.google.b.c.a d;
    private final y e;
    private x f;

    private w(t t1, k k1, f f1, com.google.b.c.a a1, y y)
    {
        a = t1;
        b = k1;
        c = f1;
        d = a1;
        e = y;
    }

    w(t t1, k k1, f f1, com.google.b.c.a a1, y y, byte byte0)
    {
        this(t1, k1, f1, a1, y);
    }

    private x a()
    {
        x x1 = f;
        if (x1 != null)
        {
            return x1;
        } else
        {
            x x2 = c.a(e, d);
            f = x2;
            return x2;
        }
    }

    public static y a(com.google.b.c.a a1, Object obj)
    {
        return new a(obj, a1, false, (byte)0);
    }

    public static y b(com.google.b.c.a a1, Object obj)
    {
        boolean flag;
        if (a1.b == a1.a)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return new a(obj, a1, flag, (byte)0);
    }

    public final Object a(com.google.b.d.a a1)
    {
        if (b == null)
        {
            return a().a(a1);
        }
        a1 = j.a(a1);
        if (a1 instanceof n)
        {
            return null;
        } else
        {
            return b.deserialize(a1, d.b, c.a);
        }
    }

    public final void a(c c1, Object obj)
    {
        if (a == null)
        {
            a().a(c1, obj);
            return;
        }
        if (obj == null)
        {
            c1.f();
            return;
        } else
        {
            j.a(a.serialize(obj, d.b, c.b), c1);
            return;
        }
    }
}
