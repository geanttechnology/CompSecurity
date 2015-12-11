// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.b.f;
import com.google.b.b.g;
import com.google.b.d.a;
import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.i;
import com.google.b.l;
import com.google.b.n;
import com.google.b.o;
import com.google.b.r;
import com.google.b.x;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.b.b.a:
//            m

static final class r extends x
{

    private void a(c c1, l l1)
    {
        if (l1 == null || (l1 instanceof n))
        {
            c1.f();
            return;
        }
        if (l1 instanceof r)
        {
            l1 = l1.h();
            if (((r) (l1)).a instanceof Number)
            {
                c1.a(l1.a());
                return;
            }
            if (((r) (l1)).a instanceof Boolean)
            {
                c1.a(l1.f());
                return;
            } else
            {
                c1.b(l1.b());
                return;
            }
        }
        if (l1 instanceof i)
        {
            c1.b();
            if (l1 instanceof i)
            {
                for (l1 = ((i)l1).iterator(); l1.hasNext(); a(c1, (l)l1.next())) { }
            } else
            {
                throw new IllegalStateException("This is not a JSON Array.");
            }
            c1.c();
            return;
        }
        if (l1 instanceof o)
        {
            c1.d();
            java.util.ntry ntry;
            for (l1 = l1.g().a.entrySet().iterator(); l1.hasNext(); a(c1, (l)ntry.getValue()))
            {
                ntry = (java.util.ntry)l1.next();
                c1.a((String)ntry.getKey());
            }

            c1.e();
            return;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Couldn't write ")).append(l1.getClass()).toString());
        }
    }

    private l b(a a1)
    {
        o o1;
        switch (com.google.b.b.a.a[a1.f().ordinal()])
        {
        default:
            throw new IllegalArgumentException();

        case 3: // '\003'
            return new r(a1.i());

        case 1: // '\001'
            return new r(new f(a1.i()));

        case 2: // '\002'
            return new r(Boolean.valueOf(a1.j()));

        case 4: // '\004'
            a1.k();
            return n.a;

        case 5: // '\005'
            i j = new i();
            a1.a();
            for (; a1.e(); j.a(b(a1))) { }
            a1.b();
            return j;

        case 6: // '\006'
            o1 = new o();
            a1.c();
            break;
        }
        for (; a1.e(); o1.a(a1.h(), b(a1))) { }
        a1.d();
        return o1;
    }

    public final Object a(a a1)
    {
        return b(a1);
    }

    public final volatile void a(c c1, Object obj)
    {
        a(c1, (l)obj);
    }

    r()
    {
    }
}
