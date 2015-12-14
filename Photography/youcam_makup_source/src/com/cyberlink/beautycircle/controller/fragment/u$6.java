// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import com.cyberlink.beautycircle.model.UserInfo;
import com.perfectcorp.utility.m;
import java.util.TreeMap;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            u, v, w

class b extends m
{

    final int a;
    final v b;
    final u c;

    public void a()
    {
        super.a();
        u.f(c).remove(Long.valueOf(b.a.id));
    }

    public void a(int i)
    {
        super.a(i);
        u.f(c).remove(Long.valueOf(b.a.id));
    }

    public void a(Boolean boolean1)
    {
        if (boolean1 != null && boolean1.booleanValue())
        {
            boolean1 = (w)u.e(c).get(Integer.valueOf(a));
            if (boolean1 != null && ((w) (boolean1)).a != null && ((w) (boolean1)).a.equals(b))
            {
                boolean1.a();
            }
        }
        u.f(c).remove(Long.valueOf(b.a.id));
    }

    public void b(Object obj)
    {
        a((Boolean)obj);
    }

    (u u1, int i, v v1)
    {
        c = u1;
        a = i;
        b = v1;
        super();
    }
}
