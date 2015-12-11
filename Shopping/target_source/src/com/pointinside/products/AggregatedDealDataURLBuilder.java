// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import android.text.TextUtils;
import com.pointinside.internal.ParameterCheck;
import com.pointinside.internal.utils.LogUtils;
import com.pointinside.net.EndpointType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.pointinside.products:
//            SearchURLBuilder

class AggregatedDealDataURLBuilder extends SearchURLBuilder
{

    private static final String LOG_TAG = LogUtils.makeLogTag(com/pointinside/products/AggregatedDealDataURLBuilder);
    private static final String PARAM_BACKGROUND = "background";
    private static final String PARAM_CLASSES = "classes";
    private static final String PARAM_FACETS = "facets";
    private static final String PARAM_LIMIT = "limit";
    private static final String PARAM_LOCAL_TIME = "localTime";
    private static final String PARAM_OFFSET = "offset";
    private static final String PARAM_QUERY = "q";
    private static final String PARAM_SOURCE = "source";
    private static final String VERSION = "v1.4";
    boolean background;
    Map facets;
    String keywordToSearch;
    long localTime;
    int maxDealsLimit;
    int offset;
    String rankUsing;
    String source;

    AggregatedDealDataURLBuilder()
    {
        super(EndpointType.CATEGORY);
    }

    String formatFacetsParam(Map map)
    {
        StringBuilder stringbuilder = new StringBuilder();
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); stringbuilder.append(entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
            if (!stringbuilder.toString().isEmpty())
            {
                stringbuilder.append(",");
            }
            stringbuilder.append(entry.getKey());
            stringbuilder.append(':');
        }

        return stringbuilder.toString();
    }

    protected String getVersion()
    {
        return "v1.4";
    }

    public void onPrepareURL()
    {
        super.onPrepareURL();
        boolean flag = false;
        if (!TextUtils.isEmpty(keywordToSearch))
        {
            parameters.put("q", keywordToSearch);
            flag = true;
        }
        if (!ParameterCheck.isNullOrEmpty(facets) && !flag)
        {
            parameters.put("facets", formatFacetsParam(facets));
        }
        parameters.put("classes", BaseProduct.PIProductsProductType.deal.toString());
        if (!ParameterCheck.isNullOrEmpty(source))
        {
            parameters.put("source", source);
        }
        if (maxDealsLimit > 0)
        {
            parameters.put("limit", String.valueOf(maxDealsLimit));
        }
        if (offset >= 0)
        {
            parameters.put("offset", String.valueOf(offset));
        }
        if (background)
        {
            parameters.put("background", String.valueOf(true));
        }
        if (localTime > 0L)
        {
            parameters.put("localTime", String.valueOf(localTime));
        }
    }

}
