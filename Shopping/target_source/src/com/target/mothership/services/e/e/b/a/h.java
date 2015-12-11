// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.e.b.a;

import java.math.BigDecimal;

public class h
{

    private int mGuestReviewCount;
    private String mOverAllGuestRating;

    public BigDecimal a()
    {
        if (mOverAllGuestRating != null)
        {
            return new BigDecimal(mOverAllGuestRating);
        } else
        {
            return null;
        }
    }

    public int b()
    {
        return mGuestReviewCount;
    }
}
