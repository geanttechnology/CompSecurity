// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.solr;

import gs;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.bestbuy.android.api.lib.models.solr:
//            Value

public class Facet
    implements Serializable
{

    private static final String TAG = com/bestbuy/android/api/lib/models/solr/Facet.getSimpleName();
    private static final long serialVersionUID = 1L;
    private HashMap categoryMap;
    private String deptFacetField;
    private String deptFacetFieldValue;
    private boolean displayContext;
    private boolean displayDepFacet;
    private boolean displayFacetRemoveLink;
    private boolean displayMobileFacet;
    private boolean displayMobileFacetRemoveLink;
    private String displayName;
    private boolean displayRecurrence;
    private boolean facetDisplay;
    private String facetField;
    private String joinCondition;
    private int maxVaue;
    private int minVaue;
    private String systemName;
    private String uniqueFacetId;
    private ArrayList values;

    public Facet()
    {
        categoryMap = new HashMap();
    }

    public static Facet loadData(JSONObject jsonobject)
    {
        int i = 0;
        Facet facet = new Facet();
        facet.systemName = jsonobject.optString("systemName");
        facet.displayName = jsonobject.optString("displayName").replace("(Hidden) DO NOT EDIT", "");
        facet.facetField = jsonobject.optString("facetField");
        facet.facetDisplay = jsonobject.optBoolean("facetDisplay");
        facet.displayRecurrence = jsonobject.optBoolean("displayRecurrence");
        facet.displayFacetRemoveLink = jsonobject.optBoolean("displayFacetRemoveLink");
        facet.displayMobileFacet = jsonobject.optBoolean("displayMobileFacet");
        facet.displayMobileFacetRemoveLink = jsonobject.optBoolean("displayMobileFacetRemoveLink");
        facet.deptFacetField = jsonobject.optString("depFacetField");
        facet.deptFacetFieldValue = jsonobject.optString("depFacetFieldValue");
        Object obj = jsonobject.optString("displayContext");
        if (((String) (obj)).length() > 0)
        {
            boolean flag;
            if (((String) (obj)).equalsIgnoreCase("Yes"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            facet.displayContext = flag;
        } else
        {
            facet.displayContext = false;
        }
        facet.displayDepFacet = jsonobject.optBoolean("displayDepFacet");
        facet.minVaue = jsonobject.optInt("minValue");
        facet.maxVaue = jsonobject.optInt("maxValue");
        facet.joinCondition = jsonobject.optString("joinCondition");
        facet.uniqueFacetId = jsonobject.optString("uniqueFacetId");
        facet.values = new ArrayList();
        jsonobject = jsonobject.optJSONArray("values");
        while (i < jsonobject.length()) 
        {
            try
            {
                obj = Value.loadData(jsonobject.getJSONObject(i));
                facet.values.add(obj);
                if (((Value) (obj)).getCatPath() != null && !((Value) (obj)).getCatPath().isEmpty())
                {
                    facet.categoryMap.put(((Value) (obj)).getValue(), ((Value) (obj)).getCatPath());
                }
            }
            catch (JSONException jsonexception)
            {
                gs.d(TAG, (new StringBuilder()).append("Could not parse Facet Value, skipping:").append(jsonexception.getLocalizedMessage()).toString());
            }
            i++;
        }
        return facet;
    }

    public HashMap getCategoryMap()
    {
        return categoryMap;
    }

    public String getDeptFacetField()
    {
        return deptFacetField;
    }

    public String getDeptFacetFieldValue()
    {
        return deptFacetFieldValue;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getFacetField()
    {
        return facetField;
    }

    public String getJoinCondition()
    {
        return joinCondition;
    }

    public int getMaxVaue()
    {
        return maxVaue;
    }

    public int getMinVaue()
    {
        return minVaue;
    }

    public String getSystemName()
    {
        return systemName;
    }

    public String getUniqueFacetId()
    {
        return uniqueFacetId;
    }

    public ArrayList getValues()
    {
        return values;
    }

    public boolean isDisplayContext()
    {
        return displayContext;
    }

    public boolean isDisplayDepFacet()
    {
        return displayDepFacet;
    }

    public boolean isDisplayFacetRemoveLink()
    {
        return displayFacetRemoveLink;
    }

    public boolean isDisplayMobileFacet()
    {
        return displayMobileFacet;
    }

    public boolean isDisplayMobileFacetRemoveLink()
    {
        return displayMobileFacetRemoveLink;
    }

    public boolean isDisplayRecurrence()
    {
        return displayRecurrence;
    }

    public boolean isFacetDisplay()
    {
        return facetDisplay;
    }

}
