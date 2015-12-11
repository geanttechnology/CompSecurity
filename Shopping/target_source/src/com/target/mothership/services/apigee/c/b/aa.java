// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.b;

import com.target.mothership.util.o;

public class aa
{

    private String mCode;
    private String mDescription;
    private String mPromoCode;

    public aa()
    {
    }

    public String a()
    {
        return mDescription;
    }

    public String b()
    {
        if (o.g(mPromoCode))
        {
            return mPromoCode;
        } else
        {
            return mCode;
        }
    }
}
