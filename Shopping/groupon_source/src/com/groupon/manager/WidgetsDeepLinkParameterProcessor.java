// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.groupon.manager:
//            ParameterProcessor

public class WidgetsDeepLinkParameterProcessor extends ParameterProcessor
{

    protected static final Set EXCLUDED_WIDGET_REQUEST_CLIENT_PARAMETERS = new HashSet(Arrays.asList(new String[] {
        "deal_ids"
    }));
    protected static final Set EXCLUDED_WIDGET_REQUEST_SERVER_PARAMETERS = new HashSet(Arrays.asList(new String[] {
        "client_id", "consumer_id", "datetime", "deal_recommendations", "geo_source", "lang", "show", "visitor_id"
    }));

    public WidgetsDeepLinkParameterProcessor(String s, List list)
    {
        super(s, list);
    }

    protected Set getExcludedClientParameters()
    {
        return EXCLUDED_WIDGET_REQUEST_CLIENT_PARAMETERS;
    }

    protected Set getExcludedServerParameters()
    {
        return EXCLUDED_WIDGET_REQUEST_SERVER_PARAMETERS;
    }

}
