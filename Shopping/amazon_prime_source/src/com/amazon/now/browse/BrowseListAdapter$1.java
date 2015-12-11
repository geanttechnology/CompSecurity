// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.browse;

import android.content.Context;
import android.view.View;
import com.amazon.now.search.SearchIntentBuilder;
import com.amazon.retailsearch.android.api.log.CategoryBrowseLogger;
import com.amazon.searchapp.retailsearch.model.RefinementLink;

// Referenced classes of package com.amazon.now.browse:
//            BrowseListAdapter

class finementLink
    implements android.view.
{

    final BrowseListAdapter this$0;
    final RefinementLink val$link;

    public void onClick(View view)
    {
        view = new SearchIntentBuilder(BrowseListAdapter.access$000(BrowseListAdapter.this));
        view.dataUrl(val$link.getUrl());
        view.categoryName(val$link.getText());
        BrowseListAdapter.access$000(BrowseListAdapter.this).startActivity(view.build());
        BrowseListAdapter.access$100(BrowseListAdapter.this).recordDepartmentMenuClickInBrowse();
    }

    finementLink()
    {
        this$0 = final_browselistadapter;
        val$link = RefinementLink.this;
        super();
    }
}
