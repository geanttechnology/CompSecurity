// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.k.b.a;

import java.util.List;

public class a
{

    private String mCurrentPage;
    private String mPageSize;
    private List mRegistryList;
    private String mSortField;
    private String mSortType;
    private int mTotalRecords;

    public int a()
    {
        return mTotalRecords;
    }

    public String b()
    {
        return mPageSize;
    }

    public String c()
    {
        return mCurrentPage;
    }

    public String d()
    {
        return mSortField;
    }

    public String e()
    {
        return mSortType;
    }

    public List f()
    {
        return mRegistryList;
    }
}
