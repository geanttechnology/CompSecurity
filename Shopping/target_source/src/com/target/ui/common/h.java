// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.common;

import com.google.a.a.e;

public class h
{

    private static final int INVALID_RES = -1;
    private String mProductSubTitle;
    private String mProductTitle;
    private int mSubTitleTextColor;

    public h(String s)
    {
        mSubTitleTextColor = -1;
        mProductTitle = s;
    }

    public void a(int i)
    {
        mSubTitleTextColor = i;
    }

    public void a(String s)
    {
        mProductSubTitle = s;
    }

    public boolean a()
    {
        return mProductSubTitle != null && mSubTitleTextColor != -1;
    }

    public String b()
    {
        return mProductTitle;
    }

    public e c()
    {
        return e.c(mProductSubTitle);
    }

    public int d()
    {
        return mSubTitleTextColor;
    }
}
