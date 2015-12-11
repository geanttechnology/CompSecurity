// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.search;

import com.amazon.retailsearch.android.ui.resultheader.ResultsInfoBar;

// Referenced classes of package com.amazon.retailsearch.android.ui.search:
//            SearchResultView

class this._cls0
    implements com.amazon.retailsearch.android.ui.resultheader.BarVisibilityListener
{

    final SearchResultView this$0;

    public void onVisibilityChanged(boolean flag)
    {
        ResultsInfoBar resultsinfobar = SearchResultView.access$100(SearchResultView.this);
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        resultsinfobar.setVisibility(i);
    }

    r()
    {
        this$0 = SearchResultView.this;
        super();
    }
}
