// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cart.b.a;

import com.target.mothership.model.cart.interfaces.CartDetails;

public abstract class a
{

    protected com.target.ui.helper.b.a mCartDataHelper;
    protected com.target.ui.fragment.cart.a.a mCartPresentation;

    public a(com.target.ui.helper.b.a a1)
    {
        mCartDataHelper = a1;
    }

    public void a()
    {
        mCartPresentation = null;
    }

    public abstract void a(CartDetails cartdetails);

    public void a(com.target.ui.fragment.cart.a.a a1)
    {
        mCartPresentation = a1;
        mCartPresentation.b();
    }

    public abstract void b();
}
