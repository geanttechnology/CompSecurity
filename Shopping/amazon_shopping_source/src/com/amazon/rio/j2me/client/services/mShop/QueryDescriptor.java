// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

public class QueryDescriptor
{

    private List queryData;
    private String queryType;

    public QueryDescriptor()
    {
    }

    public List getQueryData()
    {
        return queryData;
    }

    public String getQueryType()
    {
        return queryType;
    }

    public void setQueryData(List list)
    {
        queryData = list;
    }

    public void setQueryType(String s)
    {
        queryType = s;
    }
}
