// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.fastBrowse;

import com.amazon.retailsearch.log.MessageLogger;
import com.amazon.searchapp.retailsearch.client.web.AbstractServiceCallListener;
import com.amazon.searchapp.retailsearch.model.SearchResult;

// Referenced classes of package com.amazon.retailsearch.android.fastBrowse:
//            RefinementsLoader

private class <init> extends AbstractServiceCallListener
{

    final RefinementsLoader this$0;

    public void endRequest()
    {
    }

    public void error(Exception exception)
    {
        RefinementsLoader.access$100().error("Refinements request ended with an exception", exception);
        RefinementsLoader.access$200(RefinementsLoader.this).onError(exception);
    }

    public void result(SearchResult searchresult)
    {
        if (searchresult == null || searchresult.getRefinements() == null)
        {
            RefinementsLoader.access$100().error("RefinementsLoader result came back null");
        }
        RefinementsLoader.access$200(RefinementsLoader.this).onResult(searchresult);
    }

    public volatile void result(Object obj)
    {
        result((SearchResult)obj);
    }

    public void startRequest()
    {
    }

    private Listener()
    {
        this$0 = RefinementsLoader.this;
        super();
    }

    t>(t> t>)
    {
        this();
    }
}
