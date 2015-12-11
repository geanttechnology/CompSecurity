// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.clickstream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.client.metrics.clickstream:
//            ClickStreamInfo, ClickStreamData, ClickStreamHelper

public class ECommerceInfo
    implements ClickStreamInfo
{

    boolean mIsGlanceView;
    boolean mIsPrimeEligibleItem;
    Map mOrderData;
    String mPageAction;

    public ECommerceInfo(String s, Map map)
    {
        validateString(s);
        validateMap(map);
        mPageAction = s;
        mOrderData = map;
    }

    private void addInitialDataPoints(List list)
    {
        ClickStreamHelper.addDatapoint(list, ClickStreamData.ECOMMERCE_PAGE_ACTION.getName(), mPageAction);
        ClickStreamHelper.addDatapoint(list, ClickStreamData.ORDER_DATA.getName(), ClickStreamHelper.mapToString(mOrderData));
    }

    private void validateMap(Map map)
    {
        if (map == null || map.isEmpty())
        {
            throw new IllegalArgumentException("Invalid Map. Cannot be null or empty");
        } else
        {
            return;
        }
    }

    private void validateString(String s)
    {
        if (s == null || s.isEmpty())
        {
            throw new IllegalArgumentException("Invalid string. Cannot be null or empty");
        } else
        {
            return;
        }
    }

    public List getDataPoints()
    {
        ArrayList arraylist = new ArrayList();
        addInitialDataPoints(arraylist);
        ClickStreamHelper.addDatapoint(arraylist, ClickStreamData.IS_PRIME_ELIGIBLE_ITEM.getName(), Boolean.toString(mIsPrimeEligibleItem));
        ClickStreamHelper.addDatapoint(arraylist, ClickStreamData.IS_GLANCE_VIEW.getName(), Boolean.toString(mIsGlanceView));
        return arraylist;
    }

    public ECommerceInfo isGlanceView(Boolean boolean1)
    {
        mIsGlanceView = boolean1.booleanValue();
        return this;
    }

    public ECommerceInfo isPrimeEligibleItem(Boolean boolean1)
    {
        mIsPrimeEligibleItem = boolean1.booleanValue();
        return this;
    }
}
