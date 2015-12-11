// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import com.pointinside.json.JSONResponse;
import java.util.List;
import java.util.Map;

public final class AggregatedDealDataResult extends JSONResponse
{

    public final Map dealBrands = null;
    public final Map dealCategories = null;
    public final Map dealTypes = null;
    public final List deals = null;
    public final int totalResults = 0;

    AggregatedDealDataResult()
    {
    }

    public AggregatedDealDataResult getData()
    {
        return this;
    }

    public volatile Object getData()
    {
        return getData();
    }
}
