// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.dnm;

import android.text.Html;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class DNMFacetFilter
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private int count;
    private String displayText;
    private String facetTitle;
    private String filterQuery;
    private String pathToNavigateOnThisFilter;
    private boolean selected;
    private boolean tabSelectedFlag;

    public DNMFacetFilter()
    {
    }

    public static ArrayList loadDNMFilterData(JSONArray jsonarray, String s)
    {
        ArrayList arraylist = new ArrayList();
        int i = 0;
        while (i < jsonarray.length()) 
        {
            JSONObject jsonobject = jsonarray.optJSONObject(i);
            if (jsonobject != null)
            {
                DNMFacetFilter dnmfacetfilter = new DNMFacetFilter();
                dnmfacetfilter.count = jsonobject.optInt("count");
                dnmfacetfilter.displayText = jsonobject.optString("displayText");
                try
                {
                    dnmfacetfilter.displayText = Html.fromHtml(dnmfacetfilter.displayText).toString();
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
                dnmfacetfilter.tabSelectedFlag = jsonobject.optBoolean("tabSelectedFlag");
                dnmfacetfilter.filterQuery = jsonobject.optString("filterQuery");
                dnmfacetfilter.pathToNavigateOnThisFilter = jsonobject.optString("pathToNavigateOnThisFilter");
                dnmfacetfilter.selected = jsonobject.optBoolean("selected");
                dnmfacetfilter.facetTitle = s;
                arraylist.add(dnmfacetfilter);
            }
            i++;
        }
        return arraylist;
    }

    public static ArrayList loadSelectedFilterData(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        int i = 0;
        while (i < jsonarray.length()) 
        {
            JSONObject jsonobject = jsonarray.optJSONObject(i);
            if (jsonobject != null)
            {
                DNMFacetFilter dnmfacetfilter = new DNMFacetFilter();
                dnmfacetfilter.displayText = jsonobject.optString("selectedFilterValue");
                try
                {
                    dnmfacetfilter.displayText = dnmfacetfilter.displayText.replace("\\", "").replace("\\;", "");
                    dnmfacetfilter.displayText = Html.fromHtml(dnmfacetfilter.displayText).toString();
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
                dnmfacetfilter.filterQuery = jsonobject.optString("filterQuery");
                dnmfacetfilter.facetTitle = jsonobject.optString("facetTitle");
                arraylist.add(dnmfacetfilter);
            }
            i++;
        }
        return arraylist;
    }

    public int getCount()
    {
        return count;
    }

    public String getDisplayText()
    {
        return displayText;
    }

    public String getFacetTitle()
    {
        return facetTitle;
    }

    public String getFilterQuery()
    {
        return filterQuery;
    }

    public String getPathToNavigateOnThisFilter()
    {
        return pathToNavigateOnThisFilter;
    }

    public boolean isSelected()
    {
        return selected;
    }

    public boolean isTabSelectedFlag()
    {
        return tabSelectedFlag;
    }

    public void setDisplayText(String s)
    {
        displayText = s;
    }
}
