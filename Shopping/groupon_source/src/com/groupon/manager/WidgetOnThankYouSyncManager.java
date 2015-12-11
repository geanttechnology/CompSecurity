// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import com.groupon.abtest.WidgetOnThankYouIntlAbTestHelper;
import com.groupon.models.country.Country;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.PausableThreadPoolExecutor;

// Referenced classes of package com.groupon.manager:
//            WidgetSyncManager, WidgetOnThankYouSyncHelper, WidgetsSyncHelper

public class WidgetOnThankYouSyncManager extends WidgetSyncManager
{

    public static final String WIDGET_SCENARIO_RVD_CAB_CAV_SINGLE_DEAL_ID = "v2";
    public static final String WIDGET_SCENARIO_RVD_ONLY_ID = "v1";
    public static final String WIDGET_SCENARIO_RVD_RVD_CAB_CAV_THREE_DEALS_ID = "v3";
    private AbTestService abTestService;
    private CurrentCountryManager currentCountryManager;
    private WidgetOnThankYouIntlAbTestHelper widgetOnThankYouIntlAbTestHelper;
    private WidgetOnThankYouSyncHelper widgetOnThankYouSyncHelper;

    public WidgetOnThankYouSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor)
    {
        super(context, pausablethreadpoolexecutor);
    }

    public void init()
    {
        if (!currentCountryManager.getCurrentCountry().isUSACompatible()) goto _L2; else goto _L1
_L1:
        String s = "v2";
_L11:
        widgetOnThankYouSyncHelper.setScenarioIdVariantPostfix(s).setFragmentName("INVALID_KEYSTRING").setRequiresRedirectLogging(false);
        setWidgetsSyncHelper(widgetOnThankYouSyncHelper);
_L4:
        return;
_L2:
        if (!widgetOnThankYouIntlAbTestHelper.isMegamindOnThankYouScreenEnabledINTL()) goto _L4; else goto _L3
_L3:
        byte byte0;
        s = abTestService.getVariant("megamindOnThankYouScreen1511INTL");
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 104
    //                   -453759960: 153
    //                   -263923944: 139
    //                   1828547037: 167;
           goto _L5 _L6 _L7 _L8
_L5:
        break; /* Loop/switch isn't completed */
_L8:
        break MISSING_BLOCK_LABEL_167;
_L9:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            s = "v1";
            break;

        case 1: // '\001'
            s = "v2";
            break;

        case 2: // '\002'
            s = "v3";
            break;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (s.equals("recentlyViewedOnly"))
        {
            byte0 = 0;
        }
          goto _L9
_L6:
        if (s.equals("rvdCabCavSingleDeal"))
        {
            byte0 = 1;
        }
          goto _L9
        if (s.equals("rvdCabCavThreeDeals"))
        {
            byte0 = 2;
        }
          goto _L9
        if (true) goto _L11; else goto _L10
_L10:
    }

    public void setDealUuid(String s)
    {
        widgetOnThankYouSyncHelper.setDealUuid(s);
    }
}
