// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.deep_link;

import com.google.a.a.e;

public class m
{

    private String mAdGroup;
    private String mAfid;
    private String mCpng;
    private String mLnm;
    private String mRef;

    public m()
    {
    }

    public e a()
    {
        return com.google.a.a.e.c(mRef);
    }

    public void a(String s)
    {
        mRef = s;
    }

    public e b()
    {
        return com.google.a.a.e.c(mAfid);
    }

    public void b(String s)
    {
        mAfid = s;
    }

    public e c()
    {
        return com.google.a.a.e.c(mCpng);
    }

    public void c(String s)
    {
        mCpng = s;
    }

    public e d()
    {
        return com.google.a.a.e.c(mLnm);
    }

    public void d(String s)
    {
        mLnm = s;
    }

    public e e()
    {
        return com.google.a.a.e.c(mAdGroup);
    }

    public void e(String s)
    {
        mAdGroup = s;
    }
}
