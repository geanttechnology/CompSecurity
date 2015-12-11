// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.PersonalizedSuggestions;
import com.amazon.searchapp.retailsearch.model.PersonalizedSuggestionsResult;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class PersonalizedSuggestionsResultEntity extends RetailSearchEntity
    implements PersonalizedSuggestionsResult
{

    private PersonalizedSuggestions searchSuggestion;

    public PersonalizedSuggestionsResultEntity()
    {
    }

    public PersonalizedSuggestions getSearchSuggestion()
    {
        return searchSuggestion;
    }

    public void setSearchSuggestion(PersonalizedSuggestions personalizedsuggestions)
    {
        searchSuggestion = personalizedsuggestions;
    }
}
