// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.b;

import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.util.o;

// Referenced classes of package com.target.mothership.model.cart.b:
//            h

public class e
    implements h
{

    private static final String PHONE_NUMBER_COUNTRY_CODE = "1";
    private static final int PHONE_WITH_COUNTRY_CODE_START_INDEX = 1;
    private final String mEmailId;
    private final String mFromName;
    private final String mOrderItemId;
    private final String mPhone;
    private final String mToName;

    public e(CartProduct cartproduct, String s, String s1, String s2, String s3)
    {
        mOrderItemId = cartproduct.a();
        mFromName = s;
        mToName = s1;
        mEmailId = s3;
        if (o.g(s2))
        {
            cartproduct = s2;
            if (s2.startsWith("1"))
            {
                cartproduct = s2.substring(1);
            }
        } else
        {
            cartproduct = null;
        }
        mPhone = cartproduct;
    }

    public String a()
    {
        return mOrderItemId;
    }

    public String b()
    {
        return null;
    }

    public String c()
    {
        return mFromName;
    }

    public String d()
    {
        return mToName;
    }

    public String e()
    {
        return mPhone;
    }

    public String f()
    {
        return mEmailId;
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
