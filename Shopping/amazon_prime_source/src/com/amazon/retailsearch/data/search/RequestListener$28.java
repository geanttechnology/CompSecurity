// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.search;

import com.amazon.searchapp.retailsearch.model.SearchResult;

// Referenced classes of package com.amazon.retailsearch.data.search:
//            ResultEvent, RequestListener, ResultStreamListener

class val.searchResult extends ResultEvent
{

    final RequestListener this$0;
    final SearchResult val$searchResult;

    public void send(ResultStreamListener resultstreamlistener)
    {
        resultstreamlistener.startParse(val$searchResult);
    }

    r()
    {
        this$0 = final_requestlistener;
        val$searchResult = SearchResult.this;
        super();
    }
}
