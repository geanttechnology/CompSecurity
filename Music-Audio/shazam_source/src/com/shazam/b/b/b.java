// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.b.b;

import com.shazam.b.a.c;
import com.shazam.b.a.d;
import com.shazam.b.a.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class b
{

    public static Collection a(Collection collection, c c1)
    {
        d.a(collection);
        d.a(c1);
        ArrayList arraylist = new ArrayList(collection.size());
        for (collection = collection.iterator(); collection.hasNext(); arraylist.add(c1.a(collection.next()))) { }
        return arraylist;
    }

    public static Collection a(Collection collection, e e1)
    {
        d.a(collection);
        d.a(e1);
        ArrayList arraylist = new ArrayList();
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            Object obj = collection.next();
            if (e1.apply(obj))
            {
                arraylist.add(obj);
            }
        } while (true);
        return arraylist;
    }
}
