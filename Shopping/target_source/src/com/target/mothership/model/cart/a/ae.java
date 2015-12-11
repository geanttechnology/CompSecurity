// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.a;

import com.google.b.f;
import com.target.mothership.b;
import com.target.mothership.model.cart.interfaces.a.y;
import com.target.mothership.model.common.a.a;
import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.g;
import com.target.mothership.services.x;
import com.target.mothership.util.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.a:
//            ab, k, j

public class ae
    implements g
{

    public ae()
    {
    }

    private ab a(x x1, List list, int i)
    {
        ab ab1 = new ab();
        ab1.a(x1);
        ab1.a(list);
        if (i != 0)
        {
            ab1.a(i);
        }
        return ab1;
    }

    private y b(x x1)
    {
        ab ab1 = new ab();
        ab1.a(x1);
        x1 = new ArrayList();
        x1.add(com.target.mothership.model.cart.interfaces.a.y.a.ERR_CART_UNKNOWN);
        ab1.a(x1);
        return ab1;
    }

    public y a(x x1)
    {
        int i = 0;
        if (x1.a() == null)
        {
            return b(x1);
        }
        Object obj = (new a()).a(x1);
        if (obj != c._ERR_UNKNOWN)
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(com.target.mothership.model.cart.interfaces.a.y.a.a(((c) (obj))));
            return a(x1, ((List) (arraylist)), 0);
        }
        obj = com.target.mothership.b.a().k();
        try
        {
            obj = (k)((f) (obj)).a(x1.a(), com/target/mothership/model/cart/a/k);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return b(x1);
        }
        if (obj == null || ((k) (obj)).a() == null)
        {
            return b(x1);
        }
        Object obj1 = ((k) (obj)).a();
        if (obj1 == null || ((List) (obj1)).isEmpty())
        {
            return b(x1);
        }
        obj = new ArrayList(((List) (obj1)).size());
        com.target.mothership.model.cart.interfaces.a.y.a a1;
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((List) (obj)).add(a1))
        {
            j j1 = (j)((Iterator) (obj1)).next();
            a1 = com.target.mothership.model.cart.interfaces.a.y.a.a(j1.a());
            if (a1.compareTo(com.target.mothership.model.cart.interfaces.a.y.a.ERR_CART_MAX_PURCHASE_LIMIT) == 0 && o.g(j1.b()))
            {
                i = Integer.parseInt(j1.b());
            }
        }

        return a(x1, ((List) (obj)), i);
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }
}
