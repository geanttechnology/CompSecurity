// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.b;

import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.a.k;
import com.target.mothership.services.apigee.c.a.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.b:
//            b, h

public class c
    implements aa
{

    public c()
    {
    }

    public v a(b b1)
    {
        ArrayList arraylist = new ArrayList();
        k k1;
        for (Iterator iterator = b1.b().iterator(); iterator.hasNext(); arraylist.add(k1))
        {
            h h1 = (h)iterator.next();
            k1 = new k(h1.a());
            k1.b(b1.a());
            k1.h(h1.h());
            k1.f(h1.f());
            k1.c(h1.c());
            k1.e(h1.e());
            k1.a(h1.b());
            k1.d(h1.d());
            k1.i(h1.g());
            k1.g(h1.i());
        }

        return new v(b1.a(), arraylist);
    }

    public volatile Object a(Object obj)
    {
        return a((b)obj);
    }
}
