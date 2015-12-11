// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.view;

import android.content.res.Resources;
import android.view.View;
import com.amazon.retailsearch.android.ui.results.SearchLinkSpan;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.searchapp.retailsearch.model.Link;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout.view:
//            MixedCorrectionsView

class val.correctedQuery extends SearchLinkSpan
{

    final MixedCorrectionsView this$0;
    final Link val$correctedQuery;

    public void onClick(View view)
    {
        if (userInteractionListener != null && val$correctedQuery.getUrl() != null)
        {
            userInteractionListener.search(val$correctedQuery.getUrl());
        }
    }

    (Link link)
    {
        this$0 = final_mixedcorrectionsview;
        val$correctedQuery = link;
        super(Resources.this);
    }
}
