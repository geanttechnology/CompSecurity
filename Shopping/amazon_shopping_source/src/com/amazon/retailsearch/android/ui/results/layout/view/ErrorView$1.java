// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.view;

import android.view.View;
import com.amazon.retailsearch.interaction.UserInteractionListener;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout.view:
//            ErrorView

class this._cls0
    implements android.view.Listener
{

    final ErrorView this$0;

    public void onClick(View view)
    {
        userInteractionListener.retrySearch();
    }

    ()
    {
        this$0 = ErrorView.this;
        super();
    }
}
