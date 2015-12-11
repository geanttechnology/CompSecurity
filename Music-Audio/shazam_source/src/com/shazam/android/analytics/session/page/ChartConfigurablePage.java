// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session.page;

import com.shazam.model.analytics.event.DefinedEventParameterKey;
import java.util.Map;

// Referenced classes of package com.shazam.android.analytics.session.page:
//            ConfigurablePage

public class ChartConfigurablePage extends ConfigurablePage
{

    private String chartTitle;

    public ChartConfigurablePage()
    {
    }

    public Map getAdditionalEventParameters()
    {
        Map map = super.getAdditionalEventParameters();
        addEventParameterIfNotNull(map, DefinedEventParameterKey.CHART_TITLE, getChartTitle());
        return map;
    }

    public String getChartTitle()
    {
        return chartTitle;
    }

    public void setChartTitle(String s)
    {
        chartTitle = s;
    }
}
