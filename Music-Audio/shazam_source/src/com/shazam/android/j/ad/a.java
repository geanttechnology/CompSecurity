// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.ad;

import com.shazam.android.aq.c;
import com.shazam.model.configuration.StoresConfiguration;
import com.shazam.model.store.StoreChoice;
import com.shazam.server.response.config.AmpConfig;
import com.shazam.server.response.config.Stores;
import java.util.Iterator;
import java.util.List;

public final class a
    implements StoresConfiguration
{

    private final c a;
    private final com.shazam.b.a.a b;

    public a(c c1, com.shazam.b.a.a a1)
    {
        a = c1;
        b = a1;
    }

    public final StoreChoice a(String s)
    {
        for (Iterator iterator = c().iterator(); iterator.hasNext();)
        {
            StoreChoice storechoice = (StoreChoice)iterator.next();
            if (storechoice.key.equals(s))
            {
                return storechoice;
            }
        }

        return null;
    }

    public final String a()
    {
        StoreChoice storechoice = b();
        if (storechoice != null)
        {
            return storechoice.key;
        } else
        {
            return null;
        }
    }

    public final StoreChoice b()
    {
        List list = c();
        if (!list.isEmpty())
        {
            return (StoreChoice)list.get(0);
        } else
        {
            return null;
        }
    }

    public final boolean b(String s)
    {
        return a(s) != null;
    }

    public final List c()
    {
        return (List)b.a(a.a().getStores().getChoices());
    }
}
