// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import android.location.Location;
import android.text.TextUtils;
import com.pointinside.internal.ParameterCheck;
import com.pointinside.internal.utils.LogUtils;
import com.pointinside.nav.RouteWaypoint;
import com.pointinside.net.EndpointType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.pointinside.products:
//            SearchURLBuilder

class NearbySearchURLBuilder extends SearchURLBuilder
{

    private static final String LOG_TAG = "NearbySearchURLBuilder";
    private static final String PARAM_BACKGROUND = "background";
    private static final String PARAM_CLASSES = "classes";
    private static final String PARAM_FACETS = "facets";
    private static final String PARAM_INCLUDE_DEALS_IN_PRODUCTS = "showDeals";
    private static final String PARAM_LATITUDE = "lat";
    private static final String PARAM_LIMIT = "limit";
    private static final String PARAM_LIMIT_TO_PRODUCTS_WITH_DEALS = "hasDeals";
    private static final String PARAM_LONGITUDE = "lng";
    private static final String PARAM_OFFSET = "offset";
    private static final String PARAM_PROXIMITY = "proximity";
    private static final String PARAM_QUERY = "q";
    private static final String PARAM_RADIUS = "radius";
    private static final String PARAM_SOURCE = "source";
    private static final String WARNING_INVALID = "KeywordToSearch or facet - both are not set. HTTP error may occur because of invalid URL";
    public String accuracy;
    public boolean background;
    public List classes;
    public HashMap facets;
    public boolean includeDealsInProducts;
    public String keywordToSearch;
    public String lat;
    public boolean limitToProductsWithDeals;
    public String lng;
    public long maxDistanceFromWaypoint;
    public int maxProductsLimit;
    public RouteWaypoint nearWayPoint;
    public int productOffset;
    public String proximity;
    public String source;
    public String userLocationTime;

    public NearbySearchURLBuilder(String s, Location location)
    {
        super(EndpointType.NEARBY, location);
        facets = new HashMap();
        keywordToSearch = s;
    }

    public NearbySearchURLBuilder(HashMap hashmap, Location location)
    {
        this("", location);
        facets = hashmap;
    }

    String formatFacetsParam(HashMap hashmap)
    {
        StringBuilder stringbuilder = new StringBuilder();
        java.util.Map.Entry entry;
        for (hashmap = hashmap.entrySet().iterator(); hashmap.hasNext(); stringbuilder.append(entry.getValue()))
        {
            entry = (java.util.Map.Entry)hashmap.next();
            if (!stringbuilder.toString().isEmpty())
            {
                stringbuilder.append(",");
            }
            stringbuilder.append(entry.getKey());
            stringbuilder.append(':');
        }

        return stringbuilder.toString();
    }

    public void onPrepareURL()
    {
        boolean flag1 = false;
        super.onPrepareURL();
        boolean flag = true;
        if (!ParameterCheck.isNullOrEmpty(keywordToSearch))
        {
            parameters.put("q", keywordToSearch);
            flag = false;
        }
        if (maxProductsLimit > 0)
        {
            parameters.put("limit", String.valueOf(maxProductsLimit));
        }
        if (productOffset >= 0)
        {
            parameters.put("offset", String.valueOf(productOffset));
        }
        if (!ParameterCheck.isNullOrEmpty(facets))
        {
            parameters.put("facets", formatFacetsParam(facets));
            flag = flag1;
        }
        if (!ParameterCheck.isNullOrEmpty(classes))
        {
            parameters.put("classes", TextUtils.join(",", classes));
        }
        if (!ParameterCheck.isNullOrEmpty(source))
        {
            parameters.put("source", source);
        }
        if (background)
        {
            parameters.put("background", String.valueOf(background));
        }
        if (flag)
        {
            LogUtils.logW("NearbySearchURLBuilder", "KeywordToSearch or facet - both are not set. HTTP error may occur because of invalid URL");
        }
        if (!ParameterCheck.isNullOrEmpty(Boolean.valueOf(includeDealsInProducts)))
        {
            parameters.put("showDeals", String.valueOf(includeDealsInProducts));
        }
        if (!ParameterCheck.isNullOrEmpty(Boolean.valueOf(limitToProductsWithDeals)))
        {
            parameters.put("hasDeals", String.valueOf(limitToProductsWithDeals));
        }
        if (!ParameterCheck.isNullOrEmpty(Long.valueOf(maxDistanceFromWaypoint)))
        {
            parameters.put("radius", String.valueOf(maxDistanceFromWaypoint));
        }
        if (!ParameterCheck.isNullOrEmpty(lat))
        {
            parameters.put("lat", String.valueOf(lat));
        }
        if (!ParameterCheck.isNullOrEmpty(lng))
        {
            parameters.put("lng", String.valueOf(lng));
        }
        if (!ParameterCheck.isNullOrEmpty(proximity))
        {
            parameters.put("proximity", String.valueOf(proximity));
        }
    }
}
