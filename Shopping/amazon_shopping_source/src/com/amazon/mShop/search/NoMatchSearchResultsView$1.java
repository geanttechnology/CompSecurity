// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search;

import android.view.View;

// Referenced classes of package com.amazon.mShop.search:
//            NoMatchSearchResultsView, SearchActivity

class this._cls0
    implements android.view.ultsView._cls1
{

    final NoMatchSearchResultsView this$0;

    public void onClick(View view)
    {
        ((SearchActivity)NoMatchSearchResultsView.access$000(NoMatchSearchResultsView.this)).setSearchEntryViewAsRoot(((SearchActivity)NoMatchSearchResultsView.access$000(NoMatchSearchResultsView.this)).getIntent(), false);
    }

    ()
    {
        this$0 = NoMatchSearchResultsView.this;
        super();
    }
}
