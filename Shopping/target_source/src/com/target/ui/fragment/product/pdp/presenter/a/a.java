// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.pdp.presenter.a;

import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.ui.fragment.product.pdp.a.b;

public abstract class a
{

    protected b mPdpPresentation;

    public a()
    {
    }

    public abstract void a(ProductDetails productdetails, boolean flag, boolean flag1);

    public void a(b b)
    {
        mPdpPresentation = b;
    }
}
