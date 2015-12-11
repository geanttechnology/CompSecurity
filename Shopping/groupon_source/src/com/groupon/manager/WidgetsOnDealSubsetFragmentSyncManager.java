// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import com.groupon.util.PausableThreadPoolExecutor;

// Referenced classes of package com.groupon.manager:
//            WidgetSyncManager, WidgetsOnDealSubsetFragmentSyncHelper, WidgetsSyncHelper

public class WidgetsOnDealSubsetFragmentSyncManager extends WidgetSyncManager
{

    private WidgetsOnDealSubsetFragmentSyncHelper widgetOnDealSubsetFragmentSyncHelper;

    public WidgetsOnDealSubsetFragmentSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor)
    {
        super(context, pausablethreadpoolexecutor);
    }

    public void configure(String s, String s1, String s2, String s3)
    {
        widgetOnDealSubsetFragmentSyncHelper.configure(s, s1, s2, s3);
    }

    public String getWidgetsChannel()
    {
        return widgetOnDealSubsetFragmentSyncHelper.getWidgetsChannel();
    }

    public void init()
    {
        widgetOnDealSubsetFragmentSyncHelper.setFragmentName("INVALID_KEYSTRING").setRequiresRedirectLogging(false);
        setWidgetsSyncHelper(widgetOnDealSubsetFragmentSyncHelper);
    }
}
