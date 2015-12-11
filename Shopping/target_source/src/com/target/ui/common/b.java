// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.common;

import com.google.a.a.e;

public class b
{

    private String mCartWheelText;
    private String mCurrentPriceText;
    private String mEyeBrowText;
    private boolean mIsStorePrice;
    private boolean mShowCartwheel;
    private boolean mShowCurrentPrice;
    private boolean mShowEyeBrow;
    private boolean mShowStrikeThroughPrice;
    private String mStoreName;
    private String mStrikeThroughPriceText;

    public b()
    {
        mShowCurrentPrice = false;
        mShowStrikeThroughPrice = false;
        mShowEyeBrow = false;
        mShowCartwheel = false;
    }

    public void a(String s)
    {
        mCurrentPriceText = s;
    }

    public void a(boolean flag)
    {
        mShowCurrentPrice = flag;
    }

    public boolean a()
    {
        return mShowCurrentPrice;
    }

    public void b(String s)
    {
        mStrikeThroughPriceText = s;
    }

    public void b(boolean flag)
    {
        mShowStrikeThroughPrice = flag;
    }

    public boolean b()
    {
        return mShowStrikeThroughPrice;
    }

    public void c(String s)
    {
        mEyeBrowText = s;
    }

    public void c(boolean flag)
    {
        mShowEyeBrow = flag;
    }

    public boolean c()
    {
        return mShowEyeBrow;
    }

    public void d(String s)
    {
        mCartWheelText = s;
    }

    public void d(boolean flag)
    {
        mShowCartwheel = flag;
    }

    public boolean d()
    {
        return mShowCartwheel;
    }

    public String e()
    {
        return mCurrentPriceText;
    }

    public void e(String s)
    {
        mStoreName = s;
    }

    public void e(boolean flag)
    {
        mIsStorePrice = flag;
    }

    public String f()
    {
        return mStrikeThroughPriceText;
    }

    public String g()
    {
        return mCartWheelText;
    }

    public String h()
    {
        return mEyeBrowText;
    }

    public e i()
    {
        return com.google.a.a.e.c(mStoreName);
    }

    public boolean j()
    {
        return mIsStorePrice;
    }
}
