// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            is, in, if, iy, 
//            jw, iq, ia, ir

class <init>
    implements is
{

    private final jw a;
    private final boolean b;
    private final Class c;
    private final in d;
    private final if e;

    public ir a(ia ia, jw jw1)
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
            return new iq(d, e, ia, jw1, this, null);
        } else
        {
            return null;
        }
    }

    private (Object obj, jw jw1, boolean flag, Class class1)
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

    c(Object obj, jw jw1, boolean flag, Class class1, c c1)
    {
        this(obj, jw1, flag, class1);
    }
}
