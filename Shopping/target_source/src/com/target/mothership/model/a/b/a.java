// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.a.b;

import com.target.mothership.model.b;
import com.target.mothership.model.d;
import com.target.mothership.services.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.a.b:
//            c

public class a extends b
{

    public a(d d)
    {
        super(d);
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((List)obj);
    }

    protected List a(List list)
    {
        ArrayList arraylist = new ArrayList();
        c c1 = new c();
        for (list = list.iterator(); list.hasNext(); arraylist.add(c1.a((com.target.mothership.services.e.b.b.a)list.next()))) { }
        return arraylist;
    }

    protected com.target.mothership.model.a.c.a.a b(x x)
    {
        return (new com.target.mothership.model.a.a.a()).a(x);
    }
}
