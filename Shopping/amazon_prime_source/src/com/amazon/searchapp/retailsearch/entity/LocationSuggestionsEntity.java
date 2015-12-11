// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.LocationSuggestions;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class LocationSuggestionsEntity extends RetailSearchEntity
    implements LocationSuggestions
{

    private List groups;

    public LocationSuggestionsEntity()
    {
    }

    public List getGroups()
    {
        return groups;
    }

    public void setGroups(List list)
    {
        groups = list;
    }
}
