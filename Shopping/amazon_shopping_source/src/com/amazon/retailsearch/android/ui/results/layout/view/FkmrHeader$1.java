// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.view;

import android.content.res.Resources;
import android.view.View;
import com.amazon.retailsearch.android.ui.results.SearchLinkSpan;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.searchapp.retailsearch.model.FKMR;
import com.amazon.searchapp.retailsearch.model.Link;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout.view:
//            FkmrHeader

class val.fkmr extends SearchLinkSpan
{

    final FkmrHeader this$0;
    final FKMR val$fkmr;

    public void onClick(View view)
    {
        userInteractionListener.search(val$fkmr.getSeeAllLink().getUrl());
    }

    I(FKMR fkmr1)
    {
        this$0 = final_fkmrheader;
        val$fkmr = fkmr1;
        super(Resources.this);
    }
}
