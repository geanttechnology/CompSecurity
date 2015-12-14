// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.viewengine;

import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.database.q;
import com.cyberlink.youcammakeup.database.r;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import java.util.HashMap;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.viewengine:
//            d, ViewEngine, o

class p
{

    private ViewEngine a;
    private com.cyberlink.youcammakeup.database.p b;
    private HashMap c;
    private HashMap d;

    public p(ViewEngine viewengine)
    {
        c = new HashMap();
        d = new HashMap();
        a = viewengine;
        b = com.cyberlink.youcammakeup.c.f();
    }

    private void a(long l, d d1)
    {
        if (!c.containsKey(Long.valueOf(l)))
        {
            c.put(Long.valueOf(l), d1);
        }
    }

    public d a(long l, boolean flag)
    {
label0:
        {
            if (c.containsKey(Long.valueOf(l)))
            {
                return (d)c.get(Long.valueOf(l));
            }
            Object obj = new q();
            r r1 = b.a(l, ((q) (obj)));
            if (r1 == null && a.a == null)
            {
                throw new NullPointerException(((q) (obj)).a);
            }
            long l1;
            long l2;
            long l3;
            long l4;
            long l5;
            long l6;
            long l7;
            long l8;
            if (a.a != null)
            {
                l1 = a.a.b.a;
            } else
            {
                l1 = r1.y();
            }
            if (a.a != null)
            {
                l2 = a.a.b.b;
            } else
            {
                l2 = r1.x();
            }
            if (a.a != null)
            {
                l3 = a.a.a.a;
            } else
            {
                l3 = r1.j();
            }
            if (a.a != null)
            {
                l4 = a.a.a.b;
            } else
            {
                l4 = r1.i();
            }
            l5 = l1;
            l8 = l2;
            l6 = l3;
            l7 = l4;
            if (a.a != null)
            {
                break label0;
            }
            l5 = l1;
            l8 = l2;
            l6 = l3;
            l7 = l4;
            if (!flag)
            {
                break label0;
            }
            obj = r1.d();
            if (obj != UIImageOrientation.g && obj != UIImageOrientation.f && obj != UIImageOrientation.i)
            {
                l5 = l1;
                l8 = l2;
                l6 = l3;
                l7 = l4;
                if (obj != UIImageOrientation.h)
                {
                    break label0;
                }
            }
            l7 = l3;
            l6 = l4;
            l8 = l1;
            l5 = l2;
        }
        l1 = l6;
        if (l6 % 2L == 1L)
        {
            l1 = l6 + 1L;
        }
        l2 = l5;
        if (l5 % 2L == 1L)
        {
            l2 = l5 + 1L;
        }
        obj = new d(new o(l2, l8), new o(l1, l7));
        a(l, ((d) (obj)));
        return ((d) (obj));
    }

    public void a()
    {
        c.clear();
    }

    public void a(long l)
    {
        c.remove(Long.valueOf(l));
    }

    public void a(long l, long l1, long l2)
    {
        if (!d.containsKey(Long.valueOf(l)))
        {
            d.put(Long.valueOf(l), new o(l1, l2));
        }
    }

    public void a(long l, long l1, long l2, long l3, long l4)
    {
        a(l, new d(new o(l1, l2), new o(l3, l4)));
    }
}
