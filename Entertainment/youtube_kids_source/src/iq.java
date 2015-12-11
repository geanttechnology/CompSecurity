// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class iq
{

    private ArrayList a;

    public iq()
    {
    }

    public iq(ip ip1)
    {
        if (ip1 == null)
        {
            throw new IllegalArgumentException("selector must not be null");
        }
        ip.a(ip1);
        if (!ip.b(ip1).isEmpty())
        {
            a = new ArrayList(ip.b(ip1));
        }
    }

    private iq a(Collection collection)
    {
        if (collection == null)
        {
            throw new IllegalArgumentException("categories must not be null");
        }
        if (!collection.isEmpty())
        {
            for (collection = collection.iterator(); collection.hasNext(); a((String)collection.next())) { }
        }
        return this;
    }

    public final ip a()
    {
        if (a == null)
        {
            return ip.c;
        } else
        {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("controlCategories", a);
            return new ip(bundle, a);
        }
    }

    public final iq a(ip ip1)
    {
        if (ip1 == null)
        {
            throw new IllegalArgumentException("selector must not be null");
        } else
        {
            a(((Collection) (ip1.a())));
            return this;
        }
    }

    public final iq a(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("category must not be null");
        }
        if (a == null)
        {
            a = new ArrayList();
        }
        if (!a.contains(s))
        {
            a.add(s);
        }
        return this;
    }
}
