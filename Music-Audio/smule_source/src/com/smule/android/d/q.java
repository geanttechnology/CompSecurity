// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.smule.android.d:
//            r, u

public class q
{

    Map a;
    Map b;

    q()
    {
        a = new HashMap();
        b = new HashMap();
    }

    public r a(String s)
    {
        return (r)b.get(s);
    }

    void a(r r1)
    {
        b.put(r1.c(), r1);
    }

    void a(u u1)
    {
        a.put(u1.a(), u1);
    }

    List b(String s)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = b.values().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            r r1 = (r)iterator.next();
            if (r1.a().equals(s))
            {
                arraylist.add(r1.c());
            }
        } while (true);
        return arraylist;
    }
}
