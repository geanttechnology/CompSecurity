// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.f.c;

import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.services.b;
import com.target.mothership.services.e.i.d;
import com.target.mothership.services.e.i.e;
import com.target.mothership.services.w;
import java.util.List;

public class a extends b
{

    private com.target.mothership.services.e.f.a.a mRequestFactory;

    public a()
    {
        mRequestFactory = new com.target.mothership.services.e.f.a.a(com.target.mothership.b.a().b());
    }

    public void a(StoreIdentifier storeidentifier, Tcin tcin, w w)
    {
        a(mRequestFactory.a(storeidentifier, tcin), ((com.target.mothership.services.aa) (new d())), w);
    }

    public void a(StoreIdentifier storeidentifier, String s, w w)
    {
        a(mRequestFactory.a(storeidentifier, s), ((com.target.mothership.services.aa) (new d())), w);
    }

    public void a(StoreIdentifier storeidentifier, List list, List list1, w w)
    {
        a(mRequestFactory.a(storeidentifier, list, list1), ((com.target.mothership.services.aa) (new e())), w);
    }
}
