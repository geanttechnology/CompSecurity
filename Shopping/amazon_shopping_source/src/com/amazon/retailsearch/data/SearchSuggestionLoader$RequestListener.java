// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data;

import com.amazon.retailsearch.log.MessageLogger;
import com.amazon.searchapp.retailsearch.client.suggestions.AbstractSearchSuggestionsListener;

// Referenced classes of package com.amazon.retailsearch.data:
//            SearchSuggestionLoader

private class <init> extends AbstractSearchSuggestionsListener
{

    final SearchSuggestionLoader this$0;

    public void error(Exception exception)
    {
        SearchSuggestionLoader.access$100().error("Search suggestion request error", exception);
    }

    private uggestionsListener()
    {
        this$0 = SearchSuggestionLoader.this;
        super();
    }

    uggestionsListener(uggestionsListener uggestionslistener)
    {
        this();
    }
}
