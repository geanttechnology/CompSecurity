// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.promotion;

import com.target.mothership.b;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.a;
import com.target.mothership.model.h;
import java.util.List;

// Referenced classes of package com.target.mothership.model.promotion:
//            d, b, a

public class c extends a
{

    private com.target.mothership.model.promotion.a mDataSource;

    public c()
    {
        if (b.a().m())
        {
            mDataSource = new d();
            return;
        } else
        {
            mDataSource = new com.target.mothership.model.promotion.b();
            return;
        }
    }

    public void a(StoreIdentifier storeidentifier, Tcin tcin, h h)
    {
        mDataSource.a(storeidentifier, tcin, h);
    }

    public void a(StoreIdentifier storeidentifier, String s, h h)
    {
        mDataSource.a(storeidentifier, s, h);
    }

    public void a(StoreIdentifier storeidentifier, List list, List list1, h h)
    {
        mDataSource.a(storeidentifier, list, list1, h);
    }
}
