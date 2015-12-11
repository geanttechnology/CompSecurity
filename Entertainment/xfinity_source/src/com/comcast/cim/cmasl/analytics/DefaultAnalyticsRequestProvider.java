// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.analytics;

import com.comcast.cim.cmasl.http.request.RequestProvider;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.cmasl.analytics:
//            AnalyticsRequestProvider

public class DefaultAnalyticsRequestProvider extends AnalyticsRequestProvider
{

    Logger LOG;

    public DefaultAnalyticsRequestProvider(RequestProvider requestprovider)
    {
        super(requestprovider);
        LOG = LoggerFactory.getLogger(com/comcast/cim/cmasl/analytics/DefaultAnalyticsRequestProvider);
    }

    public void addDataPairs(Map map)
    {
        Iterator iterator = map.entrySet().iterator();
_L7:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        map = (java.util.Map.Entry)iterator.next();
        String s = URLEncoder.encode((String)map.getKey(), "UTF-8");
        if (map.getValue() == null) goto _L4; else goto _L3
_L3:
        map = URLEncoder.encode((String)map.getValue(), "UTF-8");
_L5:
        addQueryParameter(s, map);
        continue; /* Loop/switch isn't completed */
        map;
        LOG.warn("Failed to encode analytics data-pair", map);
        continue; /* Loop/switch isn't completed */
_L4:
        map = "null";
        if (true) goto _L5; else goto _L2
_L2:
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }
}
