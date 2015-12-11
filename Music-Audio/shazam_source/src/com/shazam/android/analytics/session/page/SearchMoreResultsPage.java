// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session.page;

import com.shazam.b.e.a;
import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import java.util.Map;

// Referenced classes of package com.shazam.android.analytics.session.page:
//            ConfigurablePage

public class SearchMoreResultsPage extends ConfigurablePage
{

    public static final String MORE_RESULTS = "moreresults";
    private static final String SEARCH_ORIGIN = "search";
    private String searchResultType;

    public SearchMoreResultsPage()
    {
    }

    public Map getAdditionalEventParameters()
    {
        Map map = super.getAdditionalEventParameters();
        if (a.c(searchResultType))
        {
            map.put(DefinedEventParameterKey.SEARCH_RESULT_TYPE.getParameterKey(), searchResultType);
        }
        return map;
    }

    public String getPageName()
    {
        return "moreresults";
    }

    public String getScreenOrigin()
    {
        return ScreenOrigin.SEARCH.value;
    }

    public void setSearchResultType(String s)
    {
        searchResultType = s;
    }
}
