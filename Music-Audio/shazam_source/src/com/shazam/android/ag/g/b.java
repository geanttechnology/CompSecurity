// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ag.g;

import com.shazam.b.e.a;
import com.shazam.model.configuration.StoresConfiguration;
import com.shazam.model.store.StoreChoice;
import com.shazam.model.store.StoreOrderingDecider;
import com.shazam.model.store.Stores;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
    implements StoreOrderingDecider
{

    private final StoresConfiguration a;
    private final com.shazam.android.persistence.n.b b;
    private final String c;

    public b(StoresConfiguration storesconfiguration, com.shazam.android.persistence.n.b b1, String s)
    {
        a = storesconfiguration;
        b = b1;
        c = s;
    }

    private List a()
    {
        Object obj1 = a.c();
        Object obj = b();
        if (com.shazam.b.e.a.a(((String) (obj))) || !a.b(((String) (obj))))
        {
            return ((List) (obj1));
        }
        ArrayList arraylist = new ArrayList();
        obj = a.a(((String) (obj)));
        arraylist.add(obj);
        obj1 = ((List) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            StoreChoice storechoice = (StoreChoice)((Iterator) (obj1)).next();
            boolean flag;
            if (obj != null && !storechoice.key.equals(((StoreChoice) (obj)).key))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                arraylist.add(storechoice);
            }
        } while (true);
        return arraylist;
    }

    private String b()
    {
        return b.h(c);
    }

    public final Stores a(Stores stores)
    {
        ArrayList arraylist = new ArrayList();
        if (stores != null)
        {
            stores = stores.c();
            Iterator iterator = a().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = ((StoreChoice)iterator.next()).key;
                if (stores.containsKey(s))
                {
                    arraylist.add(stores.get(s));
                } else
                if (a.b(b()))
                {
                    arraylist.add(null);
                }
            } while (true);
        }
        stores = com.shazam.model.store.Stores.Builder.a();
        stores.stores = arraylist;
        return stores.b();
    }
}
