// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.pdp.presenter.a;

import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.ui.fragment.product.pdp.a.b;

// Referenced classes of package com.target.ui.fragment.product.pdp.presenter.a:
//            a

public class c extends a
{

    public c()
    {
    }

    public void a(ProductDetails productdetails, boolean flag, boolean flag1)
    {
        if (mPdpPresentation == null)
        {
            return;
        }
        if (productdetails == null || flag)
        {
            mPdpPresentation.z();
            return;
        } else
        {
            mPdpPresentation.a(productdetails, flag1);
            return;
        }
    }
}
