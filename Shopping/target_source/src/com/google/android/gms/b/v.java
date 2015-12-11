// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.b:
//            u, t

public class v
{

    private final Collection a = new ArrayList();
    private final Collection b = new ArrayList();
    private final Collection c = new ArrayList();

    public v()
    {
    }

    public List a()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = b.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)((u)iterator.next()).c();
            if (s != null)
            {
                arraylist.add(s);
            }
        } while (true);
        return arraylist;
    }

    public void a(t t)
    {
        a.add(t);
    }

    public void a(u u1)
    {
        b.add(u1);
    }

    public void b(u u1)
    {
        c.add(u1);
    }
}
