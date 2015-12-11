// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import com.groupon.util.CarouselExecutorManager;
import com.groupon.util.CountryNotSupportedException;
import com.groupon.util.PausableThreadPoolExecutor;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.groupon.manager:
//            GoodsSyncManager

public class ShoppingSyncManager extends GoodsSyncManager
{

    public ShoppingSyncManager(Context context)
    {
        super(context, "SHOPPING");
    }

    public ShoppingSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor, CarouselExecutorManager carouselexecutormanager)
    {
        super(context, pausablethreadpoolexecutor, "SHOPPING", carouselexecutormanager);
    }

    protected List getRelevanceContextNameValueParams()
    {
        if (isRtrGoods1408INTL)
        {
            return Arrays.asList(new String[] {
                "relevance_context", "mobile_goods_intl"
            });
        } else
        {
            return super.getRelevanceContextNameValueParams();
        }
    }

    protected String getUrl(int i, int j)
        throws CountryNotSupportedException
    {
        if (isRtrGoods1408INTL)
        {
            return String.format("%s?offset=%s&limit=%s", new Object[] {
                "https:/deals/search", Integer.valueOf(i), Integer.valueOf(j)
            });
        } else
        {
            return super.getSuperUrl(i, j);
        }
    }
}
