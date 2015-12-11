// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import android.location.Location;
import android.text.TextUtils;
import com.pointinside.analytics.CommonAnalyticsData;
import com.pointinside.internal.ParameterCheck;
import com.pointinside.internal.utils.LogUtils;
import com.pointinside.net.EndpointType;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.pointinside.products:
//            SearchURLBuilder

class AutocompleteURLBuilder extends SearchURLBuilder
{

    private static final String LOG_TAG = LogUtils.makeLogTag(com/pointinside/products/AutocompleteURLBuilder);
    private static final String PARAM_CLASSES = "classes";
    private static final String PARAM_LIMIT = "limit";
    private static final String PARAM_QUERY = "q";
    private static final String PARAM_SOURCE = "source";
    private static final String VERSION = "v1.4";
    List classes;
    String keywordToSearch;
    int maxSuggestionsLimit;
    String rankUsing;
    String source;

    AutocompleteURLBuilder(String s)
    {
        super(EndpointType.AUTOCOMPLETE);
        keywordToSearch = s;
    }

    AutocompleteURLBuilder(String s, Location location)
    {
        super(EndpointType.AUTOCOMPLETE, location);
        keywordToSearch = s;
    }

    static AutocompleteURLBuilder copy(AutocompleteURLBuilder autocompleteurlbuilder)
    {
        AutocompleteURLBuilder autocompleteurlbuilder1 = new AutocompleteURLBuilder(autocompleteurlbuilder.keywordToSearch);
        if (autocompleteurlbuilder.commonAnalyticData != null)
        {
            autocompleteurlbuilder1.commonAnalyticData = CommonAnalyticsData.copy(autocompleteurlbuilder.commonAnalyticData);
        }
        autocompleteurlbuilder1.classes = autocompleteurlbuilder.classes;
        autocompleteurlbuilder1.maxSuggestionsLimit = autocompleteurlbuilder.maxSuggestionsLimit;
        autocompleteurlbuilder1.source = autocompleteurlbuilder.source;
        autocompleteurlbuilder1.storeID = autocompleteurlbuilder.storeID;
        autocompleteurlbuilder1.venueUUID = autocompleteurlbuilder.venueUUID;
        return autocompleteurlbuilder1;
    }

    protected String getHost()
    {
        if ((host.contains("api.target.pointinside") || host.contains("api-tbird-prod")) && !"analytics".equals(getQualifiers()))
        {
            return "http://target-prod.cache.pointinside.com";
        } else
        {
            return super.getHost();
        }
    }

    protected String getVersion()
    {
        return "v1.4";
    }

    public void onPrepareURL()
    {
        super.onPrepareURL();
        parameters.put("q", keywordToSearch);
        if (maxSuggestionsLimit > 0)
        {
            parameters.put("limit", String.valueOf(maxSuggestionsLimit));
        }
        if (!ParameterCheck.isNullOrEmpty(classes))
        {
            parameters.put("classes", TextUtils.join(",", classes));
        }
        if (!ParameterCheck.isNullOrEmpty(source))
        {
            parameters.put("source", source);
        }
    }

}
