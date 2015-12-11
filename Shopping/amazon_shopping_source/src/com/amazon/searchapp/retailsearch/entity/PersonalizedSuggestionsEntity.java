// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.PersonalizedSuggestions;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class PersonalizedSuggestionsEntity extends RetailSearchEntity
    implements PersonalizedSuggestions
{

    private String requestId;
    private List searchedText;

    public PersonalizedSuggestionsEntity()
    {
    }

    public String getRequestId()
    {
        return requestId;
    }

    public List getSearchedText()
    {
        return searchedText;
    }

    public void setRequestId(String s)
    {
        requestId = s;
    }

    public void setSearchedText(List list)
    {
        searchedText = list;
    }
}
