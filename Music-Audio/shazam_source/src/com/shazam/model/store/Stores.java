// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.store;

import com.shazam.b.e.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.shazam.model.store:
//            Store

public class Stores
{
    public static class Builder
    {

        public List stores;

        public static Builder a()
        {
            return new Builder();
        }

        static List a(Builder builder)
        {
            return builder.stores;
        }

        public final Builder a(Store store)
        {
            stores.add(store);
            return this;
        }

        public final Stores b()
        {
            return new Stores(this, null);
        }

        public Builder()
        {
            stores = new ArrayList();
        }
    }


    public List stores;

    public Stores()
    {
        stores = new ArrayList();
    }

    private Stores(Builder builder)
    {
        stores = new ArrayList();
        stores = com.shazam.model.store.Builder.a(builder);
    }

    Stores(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public final Store a()
    {
        if (stores.isEmpty())
        {
            return null;
        } else
        {
            return (Store)stores.get(0);
        }
    }

    public final String a(String s)
    {
        Object obj = a();
        String s1 = s;
        if (obj != null)
        {
            obj = ((Store) (obj)).coverArt;
            s1 = s;
            if (com.shazam.b.e.a.c(((String) (obj))))
            {
                s1 = ((String) (obj));
            }
        }
        return s1;
    }

    public final Store b()
    {
        if (stores.size() > 1)
        {
            return (Store)stores.get(1);
        } else
        {
            return null;
        }
    }

    public final Map c()
    {
        HashMap hashmap = new HashMap();
        Iterator iterator = stores.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Store store = (Store)iterator.next();
            if (store != null)
            {
                hashmap.put(store.key, store);
            }
        } while (true);
        return hashmap;
    }

    public final String d()
    {
        if (a() != null)
        {
            return a().previewUrl;
        } else
        {
            return null;
        }
    }

    public String toString()
    {
        return (new StringBuilder("Stores{stores=")).append(stores).append('}').toString();
    }
}
