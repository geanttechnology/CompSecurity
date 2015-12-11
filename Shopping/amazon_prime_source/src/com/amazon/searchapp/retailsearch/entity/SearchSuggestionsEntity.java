// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.SearchSuggestions;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class SearchSuggestionsEntity extends RetailSearchEntity
    implements SearchSuggestions
{

    private String query;
    private List suggestions;

    public SearchSuggestionsEntity()
    {
    }

    public String getQuery()
    {
        return query;
    }

    public List getSuggestions()
    {
        return suggestions;
    }

    public void setQuery(String s)
    {
        query = s;
    }

    public void setSuggestions(List list)
    {
        suggestions = list;
    }
}
