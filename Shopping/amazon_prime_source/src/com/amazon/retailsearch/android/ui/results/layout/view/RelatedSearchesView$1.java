// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.view;

import android.content.res.Resources;
import android.view.View;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.ui.results.SearchLinkSpan;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.searchapp.retailsearch.model.Link;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout.view:
//            RelatedSearchesView

class val.relatedSearch extends SearchLinkSpan
{

    final RelatedSearchesView this$0;
    final Link val$relatedSearch;

    public void onClick(View view)
    {
        userInteractionListener.search(val$relatedSearch.getUrl());
        RelatedSearchesView.access$000(RelatedSearchesView.this).recordRelatedSearchesInvoked();
    }

    (Link link)
    {
        this$0 = final_relatedsearchesview;
        val$relatedSearch = link;
        super(Resources.this);
    }
}
