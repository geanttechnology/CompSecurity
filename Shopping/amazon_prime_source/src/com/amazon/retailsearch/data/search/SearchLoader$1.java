// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.search;


// Referenced classes of package com.amazon.retailsearch.data.search:
//            ResultEvent, SearchLoader, ResultStreamListener

class it> extends ResultEvent
{

    final SearchLoader this$0;

    public void send(ResultStreamListener resultstreamlistener)
    {
        resultstreamlistener.clearError();
    }

    tener()
    {
        this$0 = SearchLoader.this;
        super();
    }
}
