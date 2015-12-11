// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.b;

import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.a.ad;
import com.target.mothership.services.apigee.c.a.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.b:
//            l, h

public class m
    implements aa
{

    public m()
    {
    }

    public ad a(l l1)
    {
        ArrayList arraylist = new ArrayList();
        k k1;
        for (l1 = l1.a().iterator(); l1.hasNext(); arraylist.add(k1))
        {
            h h1 = (h)l1.next();
            k1 = new k(h1.a());
            k1.b(null);
            k1.h(h1.h());
            k1.f(h1.f());
            k1.c(h1.c());
            k1.e(h1.e());
            k1.a(h1.b());
            k1.d(h1.d());
            k1.i(h1.g());
            k1.g(h1.i());
        }

        return new ad(arraylist);
    }

    public volatile Object a(Object obj)
    {
        return a((l)obj);
    }
}
