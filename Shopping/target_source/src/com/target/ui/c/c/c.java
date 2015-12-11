// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.c.c;

import android.view.Menu;
import android.view.MenuInflater;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.g.a;
import com.target.ui.helper.j.b;
import com.target.ui.service.provider.o;

// Referenced classes of package com.target.ui.c.c:
//            b

public class c
    implements a
{

    private b mListDetailDataHelper;
    private com.target.ui.c.c.b mPresentation;
    private o mProductLocationReportProvider;

    public c(o o1, b b1)
    {
        mProductLocationReportProvider = o1;
        mListDetailDataHelper = b1;
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
    }

    public void a(ProductDetails productdetails, Store store)
    {
        com.target.ui.util.f.a.a a1 = mProductLocationReportProvider.a(productdetails);
        if (com.target.ui.util.f.a.a.a.FOUND_UNKNOWN_DEPARTMENT.equals(a1.mLocationLookupStatus))
        {
            mPresentation.a();
            return;
        } else
        {
            mPresentation.a(productdetails, store);
            return;
        }
    }

    public void a(com.target.ui.c.c.b b1)
    {
        mPresentation = b1;
    }

    public volatile void a(Object obj)
    {
        a((com.target.ui.c.c.b)obj);
    }

    public void a(String s, Store store)
    {
        mPresentation.a(s, store);
    }

    public void v_()
    {
    }

    public void z_()
    {
        mPresentation = null;
    }
}
