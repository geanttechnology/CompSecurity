// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.apls;

import android.content.Context;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.analytics.DeviceInfoUtil;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.net.LogTrackError;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.nautilus.domain.net.api.apls:
//            AplsFormatHelper

public final class AplsErrorReport
{

    private static final String HEADER_POOL_NAME = "x-ebay-api-pool-name";
    private static final String HEADER_SERVER_NAME = "x-ebay-api-server-name";
    private static final HashSet filteredHeaders = new HashSet(Arrays.asList(new String[] {
        "x-ebay-soa-security-iaftoken", "x-ebay-soa-security-token", "x-ebay-api-iaf-token", "authorization", "x-paypal-rm-token"
    }));
    private final Context context;
    private final EbayCountry country;
    private final LogTrackError track;

    public AplsErrorReport(Context context1, LogTrackError logtrackerror, EbayCountry ebaycountry)
    {
        track = logtrackerror;
        context = context1;
        country = ebaycountry;
    }

    public static ArrayList buildErrorReports(Context context1, ArrayList arraylist, EbayCountry ebaycountry)
    {
        if (arraylist != null) goto _L2; else goto _L1
_L1:
        arraylist = null;
_L4:
        return arraylist;
_L2:
        ArrayList arraylist1 = new ArrayList(arraylist.size());
        Iterator iterator = arraylist.iterator();
        do
        {
            arraylist = arraylist1;
            if (!iterator.hasNext())
            {
                continue;
            }
            arraylist1.add(new AplsErrorReport(context1, (LogTrackError)iterator.next(), ebaycountry));
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private String flattenAndFilter(Map map)
    {
        if (map == null)
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) 
        {
            map = (java.util.Map.Entry)iterator.next();
            String s = (String)map.getKey();
            if (filteredHeaders.contains(s))
            {
                map = "*** HIDDEN ***";
            } else
            {
                map = (String)map.getValue();
            }
            stringbuilder.append(s).append(" : ").append(map).append("\n");
        }
        return stringbuilder.toString();
    }

    public String getBackTrace()
    {
        return track.getBackTrace();
    }

    public String getClientData()
    {
        HashMap hashmap = new HashMap(track.getUserData());
        hashmap.put("requestHeaders", flattenAndFilter(track.getRequestHeaders()));
        hashmap.put("responseHeaders", flattenAndFilter(track.getResponseHeaders()));
        String s = DeviceInfoUtil.getMobileNetworkType(context);
        if (s != null)
        {
            hashmap.put("networkSubType", s);
        }
        return (new GsonBuilder()).create().toJson(hashmap);
    }

    public String getCountryCode()
    {
        String s1 = track.getCountryCode();
        String s = s1;
        if (s1 == null)
        {
            s = s1;
            if (country != null)
            {
                s = country.getCountryCode();
            }
        }
        return s;
    }

    public String getElapsedTime()
    {
        return AplsFormatHelper.perfIntervalFormat(track.getTotalDuration());
    }

    public String getErrorCode()
    {
        return track.getErrorCode();
    }

    public String getErrorDomain()
    {
        return track.getErrorDomain();
    }

    public String getGlobalId()
    {
        return track.getGlobalId();
    }

    public String getLastViewedItemId()
    {
        return track.getLastViewedItemId();
    }

    public String getLevel()
    {
        return track.getLevel();
    }

    public String getLongErrorMessage()
    {
        return track.getLongErrorMessage();
    }

    public String getName()
    {
        return track.getErrorName();
    }

    public String getPoolName()
    {
        return track.getResponseHeader(new String[] {
            "x-ebay-api-pool-name"
        });
    }

    public String getRecentImpressions()
    {
        return track.getRecentImpressions();
    }

    public String getRecentSearches()
    {
        return track.getRecentSearches();
    }

    public String getRequestStartTime()
    {
        return EbayDateUtils.format(new Date(EbayResponse.getHostTime(track.getOperationStartTime())));
    }

    public String getRlogId()
    {
        return track.getRlogId();
    }

    public String getServerAddress()
    {
        return track.getServerAddress();
    }

    public String getServerName()
    {
        return track.getResponseHeader(new String[] {
            "x-ebay-api-server-name"
        });
    }

    public String getServiceName()
    {
        return track.getServiceName();
    }

    public String getServiceOperationName()
    {
        return track.getOperationName();
    }

    public String getUrl()
    {
        return track.getUrl();
    }

}
