// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ag.g;

import com.shazam.c.i;
import com.shazam.model.ActionsToIntentsConverterFactory;
import com.shazam.model.configuration.StoresConfiguration;
import com.shazam.model.store.ParameterizedStores;
import com.shazam.model.store.Store;
import com.shazam.model.store.StoreActionsMerger;
import com.shazam.model.store.StoreChoice;
import com.shazam.model.store.StoreChoiceAction;
import com.shazam.model.store.Stores;
import com.shazam.o.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
    implements StoreActionsMerger
{

    private final StoresConfiguration a;
    private final ActionsToIntentsConverterFactory b;

    public a(StoresConfiguration storesconfiguration, ActionsToIntentsConverterFactory actionstointentsconverterfactory)
    {
        a = storesconfiguration;
        b = actionstointentsconverterfactory;
    }

    private Store a(StoreChoice storechoice, Store store, Map map)
    {
        map = (i)b.create(map);
        Object obj = storechoice.storeChoiceAction;
        storechoice = (List)map.a(((StoreChoiceAction) (obj)).staticActions);
        obj = (List)map.a(((StoreChoiceAction) (obj)).defaultActions);
        map = new ArrayList(store.intents);
        a(((ArrayList) (map)), ((List) (storechoice)));
        a(((ArrayList) (map)), ((List) (obj)));
        storechoice = com.shazam.model.store.Store.Builder.a(store);
        storechoice.intents = map;
        return storechoice.b();
    }

    private static void a(ArrayList arraylist, List list)
    {
        if (list != null)
        {
            arraylist.addAll(list);
        }
    }

    public final Stores a(ParameterizedStores parameterizedstores)
    {
        if (parameterizedstores == null)
        {
            return com.shazam.model.store.Stores.Builder.a().b();
        }
        Stores stores = parameterizedstores.stores;
        if (stores == null)
        {
            return com.shazam.model.store.Stores.Builder.a().b();
        }
        Map map = parameterizedstores.urlParameters;
        Map map1 = stores.c();
        com.shazam.model.store.Stores.Builder builder = com.shazam.model.store.Stores.Builder.a();
        Iterator iterator = a.c().iterator();
        while (iterator.hasNext()) 
        {
            StoreChoice storechoice = (StoreChoice)iterator.next();
            parameterizedstores = storechoice.key;
            Object obj = (Store)map1.get(parameterizedstores);
            StoreChoiceAction storechoiceaction = storechoice.storeChoiceAction;
            boolean flag;
            if (!storechoiceaction.staticActions.isEmpty() && k.a(map) && obj == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                obj = com.shazam.model.store.Store.Builder.a();
                obj.key = parameterizedstores;
                parameterizedstores = a(storechoice, ((com.shazam.model.store.Store.Builder) (obj)).b(), map);
            } else
            {
                boolean flag1;
                if (obj != null && (!storechoiceaction.staticActions.isEmpty() && k.a(map) || !storechoiceaction.defaultActions.isEmpty()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                parameterizedstores = ((ParameterizedStores) (obj));
                if (flag1)
                {
                    parameterizedstores = a(storechoice, ((Store) (obj)), map);
                }
            }
            builder.a(parameterizedstores);
        }
        return builder.b();
    }
}
