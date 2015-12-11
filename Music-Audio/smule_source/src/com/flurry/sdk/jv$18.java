// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.flurry.sdk:
//            ir, jv, jx, jy, 
//            il, jd, ii, id, 
//            ij, ig, jz

final class er extends ir
{

    public ig a(jx jx1)
    {
        ij ij1;
        switch (a[jx1.f().ordinal()])
        {
        default:
            throw new IllegalArgumentException();

        case 3: // '\003'
            return new il(jx1.h());

        case 1: // '\001'
            return new il(new jd(jx1.h()));

        case 2: // '\002'
            return new il(Boolean.valueOf(jx1.i()));

        case 4: // '\004'
            jx1.j();
            return ii.a;

        case 5: // '\005'
            id id1 = new id();
            jx1.a();
            for (; jx1.e(); id1.a(a(jx1))) { }
            jx1.b();
            return id1;

        case 6: // '\006'
            ij1 = new ij();
            jx1.c();
            break;
        }
        for (; jx1.e(); ij1.a(jx1.g(), a(jx1))) { }
        jx1.d();
        return ij1;
    }

    public void a(jz jz1, ig ig1)
    {
        if (ig1 == null || ig1.j())
        {
            jz1.f();
            return;
        }
        if (ig1.i())
        {
            ig1 = ig1.m();
            if (ig1.p())
            {
                jz1.a(ig1.a());
                return;
            }
            if (ig1.o())
            {
                jz1.a(ig1.f());
                return;
            } else
            {
                jz1.b(ig1.b());
                return;
            }
        }
        if (ig1.g())
        {
            jz1.b();
            for (ig1 = ig1.l().iterator(); ig1.hasNext(); a(jz1, (ig)ig1.next())) { }
            jz1.c();
            return;
        }
        if (ig1.h())
        {
            jz1.d();
            java.util.try try1;
            for (ig1 = ig1.k().o().iterator(); ig1.hasNext(); a(jz1, (ig)try1.getValue()))
            {
                try1 = (java.util.try)ig1.next();
                jz1.a((String)try1.getKey());
            }

            jz1.e();
            return;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Couldn't write ").append(ig1.getClass()).toString());
        }
    }

    public volatile void a(jz jz1, Object obj)
    {
        a(jz1, (ig)obj);
    }

    public Object b(jx jx1)
    {
        return a(jx1);
    }

    er()
    {
    }
}
