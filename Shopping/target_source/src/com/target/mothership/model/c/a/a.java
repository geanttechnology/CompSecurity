// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.c.a;

import com.google.a.a.e;
import com.target.mothership.model.common.a.g;
import com.target.mothership.services.x;
import java.util.ArrayList;
import java.util.List;

public class a
    implements g
{

    public a()
    {
    }

    private com.target.mothership.model.c.c.a.a a(com.target.mothership.model.c.c.a.a a1, x x1)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(a1);
        com.target.mothership.model.c.c.a.a a2 = new com.target.mothership.model.c.c.a.a();
        a2.a(x1);
        a2.a(arraylist);
        a2.a(a1);
        return a2;
    }

    public com.target.mothership.model.c.c.a.a a(com.target.mothership.model.c.c.a a1)
    {
        if (a1 == null)
        {
            return a(com.target.mothership.model.c.c.a.a.ERR_GEOCODE_FAILED, null);
        }
        if (!a1.c().b() || !((String)a1.c().c()).equals("United States"))
        {
            return a(com.target.mothership.model.c.c.a.a.ERR_GEOCODE_RESULT_OUTSIDE_USA, null);
        } else
        {
            return null;
        }
    }

    public com.target.mothership.model.c.c.a.a a(x x1)
    {
        return a(com.target.mothership.model.c.c.a.a.ERR_NETWORK, x1);
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }
}
