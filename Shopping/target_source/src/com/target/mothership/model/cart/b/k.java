// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.b;

import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.cart.interfaces.UsableShipMode;

// Referenced classes of package com.target.mothership.model.cart.b:
//            h

public class k
    implements h
{

    private final String mOrderItemId;
    private final String mShipModeId;

    public k(CartProduct cartproduct)
    {
        mOrderItemId = cartproduct.a();
        mShipModeId = cartproduct.z();
    }

    public k(CartProduct cartproduct, UsableShipMode usableshipmode)
    {
        mOrderItemId = cartproduct.a();
        mShipModeId = String.valueOf(usableshipmode.b());
    }

    public String a()
    {
        return mOrderItemId;
    }

    public String b()
    {
        return mShipModeId;
    }

    public String c()
    {
        return null;
    }

    public String d()
    {
        return null;
    }

    public String e()
    {
        return null;
    }

    public String f()
    {
        return null;
    }

    public String g()
    {
        return null;
    }

    public String h()
    {
        return null;
    }

    public String i()
    {
        return null;
    }
}
