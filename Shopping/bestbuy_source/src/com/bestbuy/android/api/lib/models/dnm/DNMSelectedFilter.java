// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.dnm;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class DNMSelectedFilter
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String facetTitle;
    private String filterQuery;
    private boolean removeLinkFlag;
    private String selectedFilterValue;
    private String unselectPath;

    public DNMSelectedFilter()
    {
    }

    public static ArrayList loadSelectedFilterData(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++)
        {
            JSONObject jsonobject = jsonarray.optJSONObject(i);
            if (jsonobject != null)
            {
                DNMSelectedFilter dnmselectedfilter = new DNMSelectedFilter();
                dnmselectedfilter.selectedFilterValue = jsonobject.optString("selectedFilterValue");
                dnmselectedfilter.unselectPath = jsonobject.optString("unselectPath");
                dnmselectedfilter.filterQuery = jsonobject.optString("filterQuery");
                dnmselectedfilter.facetTitle = jsonobject.optString("facetTitle");
                dnmselectedfilter.removeLinkFlag = jsonobject.optBoolean("removeLinkFlag");
                arraylist.add(dnmselectedfilter);
            }
        }

        return arraylist;
    }

    public String getFacetTitle()
    {
        return facetTitle;
    }

    public String getFilterQuery()
    {
        return filterQuery;
    }

    public String getSelectedFilterValue()
    {
        return selectedFilterValue;
    }

    public String getUnselectPath()
    {
        return unselectPath;
    }

    public boolean isRemoveLinkFlag()
    {
        return removeLinkFlag;
    }
}
