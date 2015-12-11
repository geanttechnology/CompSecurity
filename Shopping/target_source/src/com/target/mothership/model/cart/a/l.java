// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.a;

import com.google.b.f;
import com.target.mothership.b;
import com.target.mothership.model.common.a.a;
import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.d;
import com.target.mothership.services.x;
import com.target.mothership.services.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.a:
//            k, j

public class l
    implements d
{

    public l()
    {
    }

    private List a()
    {
        ArrayList arraylist = new ArrayList(1);
        arraylist.add(c._ERR_UNKNOWN);
        return arraylist;
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }

    public List a(x x1)
    {
        if (x1 == null || x1.a() == null)
        {
            return a();
        }
        if (x1.b().equals(z.REQUEST_TIMEOUT))
        {
            x1 = new ArrayList();
            x1.add(c.ERR_TIMEOUT);
            return x1;
        }
        Object obj = (new a()).a(x1);
        if (obj != c._ERR_UNKNOWN)
        {
            x1 = new ArrayList();
            x1.add(obj);
            return x1;
        }
        obj = b.a().k();
        try
        {
            obj = (k)((f) (obj)).a(x1.a(), com/target/mothership/model/cart/a/k);
        }
        // Misplaced declaration of an exception variable
        catch (x x1)
        {
            return a();
        }
        if (obj == null || ((k) (obj)).a() == null)
        {
            return a();
        }
        x1 = new ArrayList(((k) (obj)).a().size());
        for (obj = ((k) (obj)).a().iterator(); ((Iterator) (obj)).hasNext(); x1.add(((j)((Iterator) (obj)).next()).a())) { }
        return x1;
    }
}
