// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.io.Serializable;

// Referenced classes of package com.jirbo.adcolony:
//            z, ak, be, bq, 
//            bo

public abstract class s
    implements Serializable
{

    int a;
    String b;
    bq c;
    bo d;
    String e;
    String f;
    String g;
    String h;
    double i;
    double j;
    int k;
    boolean l;
    boolean m;
    boolean n;
    boolean o;
    z p;

    public s()
    {
        a = 0;
        e = "";
        f = "";
        g = "";
        h = "";
        i = 0.0D;
        j = 0.0D;
        p = z.a;
    }

    public boolean a()
    {
        return a == 4;
    }

    abstract boolean a(boolean flag);

    public boolean b()
    {
        return a != 4;
    }

    boolean b(boolean flag)
    {
        boolean flag2 = false;
        if (a != 4) goto _L2; else goto _L1
_L1:
        boolean flag1 = true;
_L4:
        return flag1;
_L2:
        if (f())
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = flag2;
        if (!flag) goto _L4; else goto _L3
_L3:
        if (a(true))
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = flag2;
        if (flag) goto _L4; else goto _L5
_L5:
        c = ak.c.g(b);
        bo bo;
        if (flag)
        {
            bo = c.i();
        } else
        {
            bo = c.h();
        }
        d = bo;
        if (d != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    public boolean c()
    {
        return a == 1;
    }

    public boolean d()
    {
        return a == 2;
    }

    public boolean e()
    {
        return a == 3;
    }

    abstract boolean f();

    abstract void g();

    abstract boolean h();

    boolean i()
    {
        return b(false);
    }
}
