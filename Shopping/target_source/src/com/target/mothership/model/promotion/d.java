// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.promotion;

import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.util.h;
import java.util.List;

// Referenced classes of package com.target.mothership.model.promotion:
//            a, b

public class d extends a
{

    private b mLiveDataSource;

    public d()
    {
        mLiveDataSource = new b();
    }

    public void a(StoreIdentifier storeidentifier, Tcin tcin, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            a("get_promotion_detail_tcin.json");
            mLiveDataSource.a(storeidentifier, tcin, h1);
            return;
        }
    }

    public void a(StoreIdentifier storeidentifier, String s, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            a("get_promotion_detail_generic.json");
            mLiveDataSource.a(storeidentifier, s, h1);
            return;
        }
    }

    public void a(StoreIdentifier storeidentifier, List list, List list1, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            a("get_promotion_status.json");
            mLiveDataSource.a(storeidentifier, list, list1, h1);
            return;
        }
    }
}
