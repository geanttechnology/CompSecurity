// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.dnm;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.bestbuy.android.api.lib.models.dnm:
//            DNMFacetFilter

public class DNMFacet
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private int facetId;
    private ArrayList filters;
    private boolean hasMoreFilters;
    private int index;
    private String name;
    private int position;
    private int totalFilterCount;

    public DNMFacet()
    {
    }

    public static ArrayList loadDNMFacetsData(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++)
        {
            JSONObject jsonobject = jsonarray.optJSONObject(i);
            if (jsonobject == null)
            {
                continue;
            }
            DNMFacet dnmfacet = new DNMFacet();
            dnmfacet.name = jsonobject.optString("name");
            dnmfacet.position = jsonobject.optInt("position");
            dnmfacet.totalFilterCount = jsonobject.optInt("totalFilterCount");
            dnmfacet.hasMoreFilters = jsonobject.optBoolean("hasMoreFilters");
            dnmfacet.facetId = jsonobject.optInt("facetId");
            dnmfacet.index = i;
            if (jsonobject.optJSONArray("filters") != null)
            {
                dnmfacet.filters = DNMFacetFilter.loadDNMFilterData(jsonobject.optJSONArray("filters"), dnmfacet.name);
            }
            arraylist.add(dnmfacet);
        }

        return arraylist;
    }

    public int getFacetId()
    {
        return facetId;
    }

    public ArrayList getFilters()
    {
        return filters;
    }

    public int getIndex()
    {
        return index;
    }

    public String getName()
    {
        return name;
    }

    public int getPosition()
    {
        return position;
    }

    public int getTotalFilterCount()
    {
        return totalFilterCount;
    }

    public boolean isHasMoreFilters()
    {
        return hasMoreFilters;
    }

    public void setFilters(ArrayList arraylist)
    {
        filters = arraylist;
    }
}
