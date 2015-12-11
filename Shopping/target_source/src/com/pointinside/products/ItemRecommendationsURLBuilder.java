// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import android.location.Location;
import com.pointinside.internal.ParameterCheck;
import com.pointinside.net.EndpointType;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.pointinside.products:
//            SearchURLBuilder

public class ItemRecommendationsURLBuilder extends SearchURLBuilder
{

    private final String PARAM_ITEMS = "items";
    private final String PARAM_LIMIT = "limit";
    private final String PARAM_ZONE = "zone";
    private int limit;
    private final List productIDs;
    private String zoneUUID;

    public ItemRecommendationsURLBuilder(Location location, List list)
    {
        super(EndpointType.RECOMMEND_ITEMS, location);
        productIDs = list;
    }

    private String listToCommaSeparated(List list)
    {
        List list1 = list;
        if (list.size() > 25)
        {
            list1 = list.subList(0, 24);
        }
        list = new StringBuilder(list1.toString());
        list.deleteCharAt(list.indexOf("["));
        list.deleteCharAt(list.lastIndexOf("]"));
        return list.toString();
    }

    public void limit(int i)
    {
        if (i > 100)
        {
            limit = 5;
            return;
        } else
        {
            limit = i;
            return;
        }
    }

    public void onPrepareURL()
    {
        super.onPrepareURL();
        if (ParameterCheck.isNullOrEmpty(productIDs))
        {
            throw new IllegalArgumentException("Atleast one productID is mandatory for recommendation service");
        }
        parameters.put("items", listToCommaSeparated(productIDs));
        if (limit > 0)
        {
            parameters.put("limit", String.valueOf(limit));
        }
        if (!ParameterCheck.isNullOrEmpty(zoneUUID))
        {
            parameters.put("zone", zoneUUID);
        }
    }

    public void zoneUUID(String s)
    {
        zoneUUID = s;
    }
}
