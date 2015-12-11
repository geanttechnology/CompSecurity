// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.tapjoy.internal:
//            dl, dv

public static abstract class ption
    implements ption
{

    private static void a(Iterable iterable)
    {
        for (iterable = iterable.iterator(); iterable.hasNext();)
        {
            if (iterable.next() == null)
            {
                throw new NullPointerException();
            }
        }

    }

    public static void a(Iterable iterable, Collection collection)
    {
        if (iterable instanceof dv)
        {
            a(((Iterable) (((dv)iterable).a())));
            collection.addAll((Collection)iterable);
        } else
        {
            if (iterable instanceof Collection)
            {
                a(iterable);
                collection.addAll((Collection)iterable);
                return;
            }
            iterable = iterable.iterator();
            while (iterable.hasNext()) 
            {
                Object obj = iterable.next();
                if (obj == null)
                {
                    throw new NullPointerException();
                }
                collection.add(obj);
            }
        }
    }

    public abstract ption a();

    public Object clone()
    {
        return a();
    }

    public ption()
    {
    }
}
