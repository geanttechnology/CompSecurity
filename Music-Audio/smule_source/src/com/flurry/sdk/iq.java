// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            ir, ia, jz, jw, 
//            in, jh, ig, if, 
//            is, jx

final class iq extends ir
{

    private final in a;
    private final if b;
    private final ia c;
    private final jw d;
    private final is e;
    private ir f;

    private iq(in in1, if if1, ia ia1, jw jw1, is is)
    {
        a = in1;
        b = if1;
        c = ia1;
        d = jw1;
        e = is;
    }


    private ir a()
    {
        ir ir1 = f;
        if (ir1 != null)
        {
            return ir1;
        } else
        {
            ir ir2 = c.a(e, d);
            f = ir2;
            return ir2;
        }
    }

    public static is a(jw jw1, Object obj)
    {
        return new a(obj, jw1, false, null);
    }

    public void a(jz jz1, Object obj)
    {
        if (a == null)
        {
            a().a(jz1, obj);
            return;
        }
        if (obj == null)
        {
            jz1.f();
            return;
        } else
        {
            jh.a(a.a(obj, d.b(), c.b), jz1);
            return;
        }
    }

    public Object b(jx jx)
    {
        if (b == null)
        {
            return a().b(jx);
        }
        jx = jh.a(jx);
        if (jx.j())
        {
            return null;
        } else
        {
            return b.b(jx, d.b(), c.a);
        }
    }

    private class a
        implements is
    {

        private final jw a;
        private final boolean b;
        private final Class c;
        private final in d;
        private final if e;

        public ir a(ia ia1, jw jw1)
        {
            boolean flag;
            if (a != null)
            {
                if (a.equals(jw1) || b && a.b() == jw1.a())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            {
                flag = c.isAssignableFrom(jw1.a());
            }
            if (flag)
            {
                return new iq(d, e, ia1, jw1, this);
            } else
            {
                return null;
            }
        }

        private a(Object obj, jw jw1, boolean flag, Class class1)
        {
            in in1;
            boolean flag1;
            if (obj instanceof in)
            {
                in1 = (in)obj;
            } else
            {
                in1 = null;
            }
            d = in1;
            if (obj instanceof if)
            {
                obj = (if)obj;
            } else
            {
                obj = null;
            }
            e = ((if) (obj));
            if (d != null || e != null)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            iy.a(flag1);
            a = jw1;
            b = flag;
            c = class1;
        }

    }

}
