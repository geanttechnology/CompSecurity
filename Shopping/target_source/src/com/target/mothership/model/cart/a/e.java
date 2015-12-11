// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.a;

import com.google.b.f;
import com.target.mothership.b;
import com.target.mothership.model.cart.interfaces.a.d;
import com.target.mothership.model.common.a.a;
import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;
import com.target.mothership.services.aa;
import com.target.mothership.services.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.a:
//            l, k, j

public class e
    implements aa
{

    l mJsonTransformer;

    public e()
    {
        mJsonTransformer = new l();
    }

    private d a(x x1, List list)
    {
        d d1 = new d();
        d1.a(x1);
        d1.a(list);
        d1.a((j)list.get(0));
        return d1;
    }

    private d b(x x1)
    {
        d d1 = new d();
        d1.a(x1);
        x1 = new ArrayList();
        x1.add(com.target.mothership.model.cart.interfaces.a.d.a.ERR_CART_UNKNOWN);
        d1.a(x1);
        d1.a((j)x1.get(0));
        return d1;
    }

    public d a(x x1)
    {
        Object obj = (new a()).a(x1);
        if (obj != c._ERR_UNKNOWN)
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(com.target.mothership.model.cart.interfaces.a.d.a.a(((c) (obj))));
            return a(x1, ((List) (arraylist)));
        }
        obj = com.target.mothership.b.a().k();
        Object obj1;
        try
        {
            obj1 = (k)((f) (obj)).a(x1.a(), com/target/mothership/model/cart/a/k);
        }
        catch (Exception exception)
        {
            return b(x1);
        }
        if (obj1 == null || ((k) (obj1)).a() == null)
        {
            return b(x1);
        }
        exception = ((k) (obj1)).a();
        if (exception == null || exception.isEmpty())
        {
            return b(x1);
        }
        obj1 = new ArrayList(((k) (obj1)).a().size());
        for (exception = exception.iterator(); exception.hasNext(); ((List) (obj1)).add(com.target.mothership.model.cart.interfaces.a.d.a.a((com.target.mothership.model.cart.a.j)exception.next()))) { }
        return a(x1, ((List) (obj1)));
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }
}
