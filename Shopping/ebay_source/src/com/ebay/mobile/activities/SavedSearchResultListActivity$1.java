// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import com.ebay.mobile.search.SearchListAdapter;

// Referenced classes of package com.ebay.mobile.activities:
//            SavedSearchResultListActivity

class this._cls0
    implements com.ebay.common.Activity._cls1
{

    final SavedSearchResultListActivity this$0;

    public void OnTimer()
    {
        android.widget.ListAdapter listadapter = getListAdapter();
        if (listadapter != null)
        {
            ((SearchListAdapter)listadapter).refresh(getListView());
        }
    }

    ()
    {
        this$0 = SavedSearchResultListActivity.this;
        super();
    }
}
