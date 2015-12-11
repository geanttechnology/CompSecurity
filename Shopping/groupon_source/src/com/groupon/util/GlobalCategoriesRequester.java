// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            CategoriesRequester, DeviceInfoUtil

public class GlobalCategoriesRequester extends CategoriesRequester
{

    private DeviceInfoUtil deviceInfoUtil;
    private final String facetType;
    private final String facets;
    private Double lat;
    private Double lng;
    private final String relevanceContext;

    public GlobalCategoriesRequester(Context context, Class class1, String s, String s1, String s2, int i)
    {
        super(context, class1, s);
        facetType = s1;
        relevanceContext = s2;
        if (i <= 0)
        {
            i = 1;
        }
        facets = getFacets(i);
    }

    private String getFacets(int i)
    {
        StringBuilder stringbuilder = new StringBuilder();
        int j = 0;
        while (j < i) 
        {
            if (j > 0)
            {
                stringbuilder.append("|");
                stringbuilder.append("category");
                stringbuilder.append(j + 1);
            } else
            {
                stringbuilder.append("category");
            }
            j++;
        }
        return stringbuilder.toString();
    }

    protected Collection getSpecificParams()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(Arrays.asList(new String[] {
            "lang", deviceInfoUtil.getLanguageFromLocale()
        }));
        if (Strings.notEmpty(referrer))
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "referrer", referrer
            }));
        }
        arraylist.addAll(Arrays.asList(new String[] {
            "facets", facets
        }));
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "offset", Integer.valueOf(0), "limit", Integer.valueOf(0)
        }));
        arraylist.addAll(Arrays.asList(new String[] {
            "relevance_context", relevanceContext, "show_facets", facetType
        }));
        if (lat != null && lng != null)
        {
            arraylist.addAll(Arrays.asList(new Serializable[] {
                "lat", lat, "lng", lng
            }));
        }
        return arraylist;
    }

    public void setLatitude(Double double1)
    {
        lat = double1;
    }

    public void setLongitude(Double double1)
    {
        lng = double1;
    }
}
