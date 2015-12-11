// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import com.groupon.models.country.Country;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.PausableThreadPoolExecutor;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.manager:
//            WidgetSyncManager, WidgetOnDealDetailsSyncHelper, WidgetsSyncHelper

public class WidgetOnDealDetailsSyncManager extends WidgetSyncManager
{

    private AbTestService abTestService;
    private CurrentCountryManager currentCountryManager;
    private WidgetOnDealDetailsSyncHelper widgetOnDealDetailsSyncHelper;
    private boolean widgetsSupported;

    public WidgetOnDealDetailsSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor)
    {
        super(context, pausablethreadpoolexecutor);
    }

    public void init()
    {
        boolean flag;
        if (currentCountryManager.getCurrentCountry().isUSACompatible() && Strings.notEmpty(abTestService.getVariant("cabCavOnDealDetails1504USCA")) && !abTestService.isVariantEnabled("cabCavOnDealDetails1504USCA", "Original"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        widgetsSupported = flag;
        if (widgetsSupported)
        {
            widgetOnDealDetailsSyncHelper.setScenarioIdVariantPostfix(abTestService.getVariant("cabCavOnDealDetails1504USCA")).setFragmentName("INVALID_KEYSTRING").setRequiresRedirectLogging(false);
            setWidgetsSyncHelper(widgetOnDealDetailsSyncHelper);
        }
    }

    public void setDealUuid(String s)
    {
        widgetOnDealDetailsSyncHelper.setDealUuid(s);
    }
}
