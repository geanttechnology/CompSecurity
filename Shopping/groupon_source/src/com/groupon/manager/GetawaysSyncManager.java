// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import com.groupon.models.country.Country;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.CarouselExecutorManager;
import com.groupon.util.CountryNotSupportedException;
import com.groupon.util.PausableThreadPoolExecutor;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.groupon.manager:
//            AnyChannelSyncManager

public class GetawaysSyncManager extends AnyChannelSyncManager
{

    private boolean isRtrGetaways1408INTL;

    public GetawaysSyncManager(Context context)
    {
        super(context, "GETAWAYS");
    }

    public GetawaysSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor, CarouselExecutorManager carouselexecutormanager)
    {
        super(context, pausablethreadpoolexecutor, "GETAWAYS", carouselexecutormanager);
    }

    protected List getNameValueParams(int i, int j)
    {
        List list = super.getNameValueParams(i, j);
        if (isRtrGetaways1408INTL)
        {
            list.addAll(Arrays.asList(new String[] {
                "relevance_context", "mobile_getaways_intl"
            }));
        }
        return list;
    }

    protected String getUrl(int i, int j)
        throws CountryNotSupportedException
    {
        if (isRtrGetaways1408INTL)
        {
            return String.format("%s?offset=%s&limit=%s", new Object[] {
                "https:/deals/search", Integer.valueOf(i), Integer.valueOf(j)
            });
        } else
        {
            return super.getUrl(i, j);
        }
    }

    protected boolean includesDealsWithSpecificAttributes()
    {
        return !currentCountryManager.getCurrentCountry().isJapan();
    }

    protected boolean includesGiftWrappableDeals()
    {
        return currentCountryManager.getCurrentCountry().isJapan();
    }

    public void init()
    {
        boolean flag;
        if (!currentCountryManager.getCurrentCountry().isUSACompatible() && abTestService.isINTLVariantEnabled("rtrGetaways1408%s", "on"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isRtrGetaways1408INTL = flag;
    }
}
