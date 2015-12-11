// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import com.pointinside.PIException;

// Referenced classes of package com.pointinside.products:
//            SearchAnalyticsData, SearchResult

public static final class tType extends com.pointinside.analytics.Type
{

    private boolean isBoosted;
    private String itemId;
    private tType itemType;
    private int resultNumber;
    private SearchResult selectedItem;

    public SearchAnalyticsData build()
        throws PIException
    {
        if (itemId == null)
        {
            throw new PIException("itemId must be set before calling build()");
        }
        if (itemType == null)
        {
            throw new PIException("itemType must be set before calling build()");
        } else
        {
            selectedItem = new SearchResult(itemType, itemId, isBoosted);
            return new SearchAnalyticsData(this, null);
        }
    }

    protected volatile com.pointinside.analytics.sBoosted getThis()
    {
        return getThis();
    }

    protected getThis getThis()
    {
        return this;
    }

    public getThis setIsBoosted(boolean flag)
    {
        isBoosted = flag;
        return getThis();
    }

    public getThis setItemId(String s)
    {
        itemId = s;
        return getThis();
    }

    public tType setItemType(tType ttype)
    {
        itemType = ttype;
        return getThis();
    }

    public getThis setResultNumber(int i)
    {
        resultNumber = i;
        return getThis();
    }



    public tType()
    {
    }
}
