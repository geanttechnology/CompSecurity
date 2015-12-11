// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session.page;

import com.shazam.b.e.a;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import java.util.Map;

// Referenced classes of package com.shazam.android.analytics.session.page:
//            ConfigurablePage

public class SearchPage extends ConfigurablePage
{

    public static final String SEARCH = "search";
    private String campaignId;

    public SearchPage()
    {
    }

    public Map getAdditionalEventParameters()
    {
        Map map = super.getAdditionalEventParameters();
        if (a.c(campaignId))
        {
            map.put(DefinedEventParameterKey.CAMPAIGN.getParameterKey(), campaignId);
        }
        return map;
    }

    public String getPageName()
    {
        return "search";
    }

    public void setCampaignId(String s)
    {
        campaignId = s;
    }
}
