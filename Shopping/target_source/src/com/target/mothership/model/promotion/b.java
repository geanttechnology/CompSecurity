// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.promotion;

import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.e;
import com.target.mothership.model.h;
import com.target.mothership.services.e.f.c.a;
import java.util.List;

// Referenced classes of package com.target.mothership.model.promotion:
//            a

public class b extends com.target.mothership.model.promotion.a
{

    private a mServices;

    public b()
    {
        mServices = new a();
    }

    public void a(StoreIdentifier storeidentifier, Tcin tcin, h h)
    {
        h = new e(new com.target.mothership.model.promotion.handler.a(h));
        mServices.a(storeidentifier, tcin, h);
    }

    public void a(StoreIdentifier storeidentifier, String s, h h)
    {
        h = new e(new com.target.mothership.model.promotion.handler.a(h));
        mServices.a(storeidentifier, s, h);
    }

    public void a(StoreIdentifier storeidentifier, List list, List list1, h h)
    {
        h = new e(new com.target.mothership.model.promotion.handler.b(h));
        mServices.a(storeidentifier, list, list1, h);
    }
}
