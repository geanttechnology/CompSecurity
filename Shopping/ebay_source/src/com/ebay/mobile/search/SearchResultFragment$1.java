// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;


// Referenced classes of package com.ebay.mobile.search:
//            SearchResultFragment, SearchViewManager

class this._cls0
    implements Runnable
{

    final SearchResultFragment this$0;

    public void run()
    {
        SearchResultFragment.access$200(SearchResultFragment.this).setScrollPosition(SearchResultFragment.access$100(SearchResultFragment.this));
        SearchResultFragment.access$102(SearchResultFragment.this, 0);
    }

    ()
    {
        this$0 = SearchResultFragment.this;
        super();
    }
}
