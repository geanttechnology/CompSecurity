// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.shazam.android.aspects.b:
//            c, b

public final class d
    implements c
{

    private final Class a;
    private final Collection b;

    public d(Class class1, Collection collection)
    {
        a = class1;
        b = a(collection);
    }

    private Collection a(Collection collection)
    {
        ArrayList arraylist = new ArrayList();
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            b b1 = (b)collection.next();
            if (a.isAssignableFrom(b1.getClass()))
            {
                arraylist.add(b1);
            }
        } while (true);
        return arraylist;
    }

    public final Collection a()
    {
        return b;
    }
}
