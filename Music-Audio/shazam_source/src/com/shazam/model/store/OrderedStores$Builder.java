// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.store;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.shazam.model.store:
//            OrderedStores, Stores, Store

public static class 
{

    private final List stores = new ArrayList();

    public static  a(Stores stores1)
    {
          = new <init>();
        if (stores1 != null)
        {
            Store store;
            for (stores1 = stores1.stores.iterator(); stores1.hasNext(); .stores.add(store))
            {
                store = (Store)stores1.next();
            }

        }
        return ;
    }

    static List a(stores stores1)
    {
        return stores1.stores;
    }

    public final OrderedStores a()
    {
        return new OrderedStores(this, null);
    }

    public ()
    {
    }
}
