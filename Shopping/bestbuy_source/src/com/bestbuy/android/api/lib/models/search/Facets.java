// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.search;

import gu;
import java.io.Serializable;
import java.util.ArrayList;

public class Facets
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String depFacetField;
    private String depFacetFieldValue;
    private String displayContext;
    private String displayDepFacet;
    private boolean displayFacetRemoveLink;
    private boolean displayMobileFacet;
    private boolean displayMobileFacetRemoveLink;
    private String displayName;
    private boolean displayRecurrence;
    private boolean facetDisplay;
    private String facetField;
    private String joinCondition;
    private int maxValue;
    private String systemName;
    private String uniqueFacetId;
    private ArrayList values;

    public Facets()
    {
    }

    public String getDepFacetField()
    {
        return depFacetField;
    }

    public String getDepFacetFieldValue()
    {
        return depFacetFieldValue;
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

    public int getMaxValue()
    {
        return maxValue;
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

    public String isDisplayContext()
    {
        return displayContext;
    }

    public String isDisplayDepFacet()
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

    public void setDepFacetField(String s)
    {
        depFacetField = s;
    }

    public void setDepFacetFieldValue(String s)
    {
        depFacetFieldValue = s;
    }

    public void setDisplayContext(String s)
    {
        displayContext = s;
    }

    public void setDisplayDepFacet(String s)
    {
        displayDepFacet = s;
    }

    public void setDisplayFacetRemoveLink(boolean flag)
    {
        displayFacetRemoveLink = flag;
    }

    public void setDisplayMobileFacet(boolean flag)
    {
        displayMobileFacet = flag;
    }

    public void setDisplayMobileFacetRemoveLink(boolean flag)
    {
        displayMobileFacetRemoveLink = flag;
    }

    public void setDisplayName(String s)
    {
        displayName = s;
    }

    public void setDisplayRecurrence(boolean flag)
    {
        displayRecurrence = flag;
    }

    public void setFacetDisplay(boolean flag)
    {
        facetDisplay = flag;
    }

    public void setFacetField(String s)
    {
        facetField = s;
    }

    public void setJoinCondition(String s)
    {
        joinCondition = s;
    }

    public void setMaxValue(int i)
    {
        maxValue = i;
    }

    public void setSystemName(String s)
    {
        systemName = s;
    }

    public void setUniqueFacetId(String s)
    {
        uniqueFacetId = s;
    }

    public void setValues(ArrayList arraylist)
    {
        values = arraylist;
    }
}
