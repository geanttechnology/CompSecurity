// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.io.Serializable;
import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            k, q, ac, x

public abstract class g
    implements Serializable
{

    int a;
    String b;
    al.c c;
    al.a d;
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
    k p;

    public g()
    {
        a = 0;
        e = "";
        f = "";
        g = "";
        h = "";
        i = 0.0D;
        j = 0.0D;
        p = k.a;
    }

    abstract boolean a();

    final boolean a(boolean flag)
    {
        boolean flag2 = false;
        if (a != 4) goto _L2; else goto _L1
_L1:
        boolean flag1 = true;
_L4:
        return flag1;
_L2:
        if (a())
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = flag2;
        if (!flag) goto _L4; else goto _L3
_L3:
        if (b())
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = flag2;
        if (flag) goto _L4; else goto _L5
_L5:
        Object obj;
        c = q.c.g(b);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_228;
        }
        obj = c;
        if (((al.c) (obj)).g.size() <= 0) goto _L7; else goto _L6
_L6:
        al.i i1;
        int j1;
        i1 = ((al.c) (obj)).i;
        j1 = ((al.c) (obj)).k.c % ((al.c) (obj)).g.size();
_L12:
        if (j1 >= i1.a.size()) goto _L9; else goto _L8
_L8:
        obj = (al.a)i1.a.get(j1);
        if (!((al.a) (obj)).v.a) goto _L11; else goto _L10
_L10:
        d = ((al.a) (obj));
        flag1 = flag2;
        if (d != null)
        {
            return true;
        }
          goto _L4
_L11:
        j1++;
          goto _L12
_L9:
        j1 = 0;
_L14:
        al.a a1;
        if (j1 >= i1.a.size())
        {
            break MISSING_BLOCK_LABEL_218;
        }
        a1 = (al.a)i1.a.get(j1);
        obj = a1;
        if (a1.v.a) goto _L10; else goto _L13
_L13:
        j1++;
          goto _L14
        obj = null;
          goto _L10
_L7:
        obj = null;
          goto _L10
        obj = c.a();
          goto _L10
    }

    abstract boolean b();

    abstract void c();

    abstract boolean d();
}
