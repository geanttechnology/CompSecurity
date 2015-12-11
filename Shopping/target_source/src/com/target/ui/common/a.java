// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.common;

import com.google.a.a.e;

public class a
{

    private String mPlanPriceDataUri;
    private boolean mShouldShowPhonePlansCard;

    public a()
    {
        mShouldShowPhonePlansCard = false;
    }

    public void a(String s)
    {
        mPlanPriceDataUri = s;
    }

    public void a(boolean flag)
    {
        mShouldShowPhonePlansCard = flag;
    }

    public boolean a()
    {
        return mShouldShowPhonePlansCard;
    }

    public e b()
    {
        return e.c(mPlanPriceDataUri);
    }
}
