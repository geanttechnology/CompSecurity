// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.widget.ListView;
import java.util.List;

// Referenced classes of package com.ebay.mobile.activities:
//            SavedSearchResultListActivity

class val.items
    implements Runnable
{

    final SavedSearchResultListActivity this$0;
    final List val$items;

    public void run()
    {
        getListView().setSelection(Math.min(val$items.size(), SavedSearchResultListActivity.access$400(SavedSearchResultListActivity.this)));
    }

    ()
    {
        this$0 = final_savedsearchresultlistactivity;
        val$items = List.this;
        super();
    }
}
