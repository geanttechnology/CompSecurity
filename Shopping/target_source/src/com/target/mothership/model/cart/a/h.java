// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.a;

import com.google.a.a.e;
import com.target.mothership.model.cart.interfaces.GiftProduct;
import com.target.mothership.model.cart.interfaces.a.f;
import com.target.mothership.model.common.a.j;
import java.util.ArrayList;
import java.util.List;

public class h
{

    private f mError;

    public h(GiftProduct giftproduct)
    {
        mError = null;
        ArrayList arraylist = new ArrayList();
        if (!giftproduct.f().b())
        {
            arraylist.add(com.target.mothership.model.cart.interfaces.a.f.a.ERR_PRODUCT_ID_REQUIRED);
        }
        if (!arraylist.isEmpty())
        {
            giftproduct = new f();
            giftproduct.a(arraylist);
            giftproduct.a((j)arraylist.get(0));
            giftproduct.a(null);
            mError = giftproduct;
        }
    }

    public boolean a()
    {
        return mError != null;
    }

    public f b()
    {
        return mError;
    }
}
