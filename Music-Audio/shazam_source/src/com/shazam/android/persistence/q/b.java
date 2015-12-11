// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.q;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.shazam.android.persistence.q:
//            a

public final class b
{

    public b()
    {
    }

    public static List a(a a1, List list)
    {
        if (list.size() <= 999)
        {
            return a1.a(list);
        }
        ArrayList arraylist = new ArrayList();
        Object obj = list;
        do
        {
            List list1;
            if (((List) (obj)).size() > 999)
            {
                list1 = ((List) (obj)).subList(0, 999);
                List list2 = ((List) (obj)).subList(999, ((List) (obj)).size());
                obj = list1;
                list1 = list2;
            } else
            {
                list1 = Collections.emptyList();
            }
            arraylist.add(obj);
            obj = list1;
        } while (!list1.isEmpty());
        list = new ArrayList(list.size());
        for (obj = arraylist.iterator(); ((Iterator) (obj)).hasNext(); list.addAll(a1.a((List)((Iterator) (obj)).next()))) { }
        return list;
    }
}
