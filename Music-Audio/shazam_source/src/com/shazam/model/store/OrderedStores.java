// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.store;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.shazam.model.store:
//            Stores, Store

public class OrderedStores
{
    public static class Builder
    {

        private final List stores = new ArrayList();

        public static Builder a(Stores stores1)
        {
            Builder builder = new Builder();
            if (stores1 != null)
            {
                Store store;
                for (stores1 = stores1.stores.iterator(); stores1.hasNext(); builder.stores.add(store))
                {
                    store = (Store)stores1.next();
                }

            }
            return builder;
        }

        static List a(Builder builder)
        {
            return builder.stores;
        }

        public final OrderedStores a()
        {
            return new OrderedStores(this, null);
        }

        public Builder()
        {
        }
    }


    public final List stores;

    private OrderedStores(Builder builder)
    {
        stores = Builder.a(builder);
    }

    OrderedStores(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
