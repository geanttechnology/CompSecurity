// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.suggestions;

import com.amazon.searchapp.retailsearch.model.SearchSuggestions;
import com.amazon.searchapp.retailsearch.model.Suggestion;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.client.suggestions:
//            SearchSuggestionsListener

public class AbstractSearchSuggestionsListener
    implements SearchSuggestionsListener
{

    public AbstractSearchSuggestionsListener()
    {
    }

    public void endRequest()
    {
    }

    public void error(Exception exception)
    {
    }

    public void result(SearchSuggestions searchsuggestions)
    {
    }

    public volatile void result(Object obj)
    {
        result((SearchSuggestions)obj);
    }

    public void startRequest()
    {
    }

    public void suggestion(Suggestion suggestion1)
    {
    }

    public void suggestionList(List list)
    {
    }
}
