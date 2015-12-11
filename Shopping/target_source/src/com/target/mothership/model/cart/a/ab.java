// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.a;

import com.target.mothership.model.cart.interfaces.a.y;
import com.target.mothership.model.common.a.b;
import com.target.mothership.model.common.a.j;

class ab extends b
    implements y
{

    private final int MAX_PURCHASE_LIMIT = 99;
    private int mMaxPurchaseLimit;

    ab()
    {
        mMaxPurchaseLimit = 99;
    }

    public void a(int i)
    {
        mMaxPurchaseLimit = i;
    }

    public com.target.mothership.model.cart.interfaces.a.y.a[] a()
    {
        return com.target.mothership.model.cart.interfaces.a.y.a.values();
    }

    public int b()
    {
        return mMaxPurchaseLimit;
    }

    public j[] c()
    {
        return a();
    }
}
