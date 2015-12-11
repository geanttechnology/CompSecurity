// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.LocationSuggestionGroup;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class LocationSuggestionGroupEntity extends RetailSearchEntity
    implements LocationSuggestionGroup
{

    private String label;
    private List suggestions;

    public LocationSuggestionGroupEntity()
    {
    }

    public String getLabel()
    {
        return label;
    }

    public List getSuggestions()
    {
        return suggestions;
    }

    public void setLabel(String s)
    {
        label = s;
    }

    public void setSuggestions(List list)
    {
        suggestions = list;
    }
}
