// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.weeklyad.a;

import com.target.mothership.common.weeklyad.StoreSlug;
import com.target.mothership.model.common.a.g;
import com.target.mothership.services.x;
import java.util.ArrayList;
import java.util.List;

public class b
    implements g
{

    public b()
    {
    }

    private com.target.mothership.model.weeklyad.interfaces.a.b a(com.target.mothership.model.weeklyad.interfaces.a.a a1, x x1)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(a1);
        com.target.mothership.model.weeklyad.interfaces.a.b b1 = new com.target.mothership.model.weeklyad.interfaces.a.b();
        b1.a(x1);
        b1.a(arraylist);
        b1.a(a1);
        return b1;
    }

    public com.target.mothership.model.weeklyad.interfaces.a.b a(StoreSlug storeslug)
    {
        return a(com.target.mothership.model.weeklyad.interfaces.a.a.ERR_STORE_NOT_FOUND, null);
    }

    public com.target.mothership.model.weeklyad.interfaces.a.b a(x x1)
    {
        return a(com.target.mothership.model.weeklyad.interfaces.a.a.ERR_NETWORK, x1);
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }
}
