// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.Application;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.groupon.service.core.AbTestService;

// Referenced classes of package com.groupon.util:
//            DeviceInfoUtil

public class DealCardListUtils
{

    public static final int DEFAULT_DEALS_PER_PAGE = 15;
    AbTestService abTestService;
    Application application;
    DeviceInfoUtil deviceInfoUtil;

    public DealCardListUtils()
    {
    }

    private int getPageSize(boolean flag)
    {
        int j = application.getResources().getInteger(0x7f0d0001);
        byte byte0 = 15;
        int k = getSizeOfDealToFitScreen();
        int i = byte0;
        if (flag)
        {
            int l = abTestService.getVariantAsInt("firstPageLimit");
            i = byte0;
            if (l > 0)
            {
                i = Math.max(l, k * j);
            }
        }
        return (((i + j) - 1) / j) * j;
    }

    private int getSizeOfDealToFitScreen()
    {
        DisplayMetrics displaymetrics = deviceInfoUtil.getDisplayMetrics();
        float f = application.getResources().getDimensionPixelSize(0x7f0b00e8);
        return (int)((float)displaymetrics.heightPixels / f) + 1;
    }

    public int getFirstPageSize()
    {
        return getPageSize(true);
    }

    public int getNumberOfColumns()
    {
        return application.getResources().getInteger(0x7f0d0001);
    }

    public int getSubsequencePageSize()
    {
        return getPageSize(false);
    }
}
