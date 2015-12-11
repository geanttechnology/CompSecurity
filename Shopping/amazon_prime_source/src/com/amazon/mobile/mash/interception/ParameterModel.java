// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.interception;


class ParameterModel
{

    private String mName;
    private int mPathSegmentIndex;

    ParameterModel(String s, int i)
    {
        mName = s;
        mPathSegmentIndex = i;
    }

    public String getName()
    {
        return mName;
    }

    public int getPathSegmentIndex()
    {
        return mPathSegmentIndex;
    }
}
