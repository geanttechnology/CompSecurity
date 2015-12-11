// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.b;

import com.target.mothership.common.params.AddressParams;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.a.k;
import com.target.mothership.services.apigee.c.a.u;
import com.target.mothership.services.apigee.c.a.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.b:
//            i, h

public class j
    implements aa
{

    private final String NEW_ADDRESS_IDENTIFIER = "new";

    public j()
    {
    }

    public w a(i l)
    {
        Object obj = l.a();
        ArrayList arraylist = new ArrayList();
        k k1;
        for (Iterator iterator = l.b().iterator(); iterator.hasNext(); arraylist.add(k1))
        {
            h h1 = (h)iterator.next();
            k1 = new k(h1.a());
            k1.b("new");
            k1.h(h1.h());
            k1.f(h1.f());
            k1.c(h1.c());
            k1.e(h1.e());
            k1.a(h1.b());
            k1.d(h1.d());
            k1.i(h1.g());
            k1.g(h1.i());
        }

        ArrayList arraylist1 = new ArrayList();
        obj = new u(((AddressParams) (obj)).f(), ((AddressParams) (obj)).h(), ((AddressParams) (obj)).a(), ((AddressParams) (obj)).b(), ((AddressParams) (obj)).c(), ((AddressParams) (obj)).d(), ((AddressParams) (obj)).i(), ((AddressParams) (obj)).j());
        ((u) (obj)).a(l.c().booleanValue());
        ((u) (obj)).a("new");
        arraylist1.add(obj);
        return new w(arraylist1, arraylist);
    }

    public volatile Object a(Object obj)
    {
        return a((i)obj);
    }
}
