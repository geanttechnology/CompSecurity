// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import android.view.View;
import com.amazon.retailsearch.android.api.display.input.listeners.QuerySubmitListener;
import com.amazon.retailsearch.android.api.log.SearchBoxLogger;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            ActionViewBuilder

class this._cls0
    implements android.view.
{

    final ActionViewBuilder this$0;

    public void onClick(View view)
    {
        ActionViewBuilder.access$000(ActionViewBuilder.this).onQuerySubmit(new RetailSearchQuery("IMAGE_SEARCH_QUERY_KEYWORD"));
        ActionViewBuilder.access$100(ActionViewBuilder.this).recordFlowInvoked(showBarcodeIconForFlow);
    }

    uerySubmitListener()
    {
        this$0 = ActionViewBuilder.this;
        super();
    }
}
