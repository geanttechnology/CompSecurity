// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.search;

import android.view.View;

// Referenced classes of package com.xfinity.playerlib.view.search:
//            SearchResultsFragment

private abstract class <init>
    implements android.view.adcrumbClickListener
{

    final SearchResultsFragment this$0;

    protected abstract void onBreadcrumbClicked();

    public void onClick(View view)
    {
        onBreadcrumbClicked();
        view.setVisibility(8);
        SearchResultsFragment.access$100(SearchResultsFragment.this);
    }

    private ()
    {
        this$0 = SearchResultsFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
