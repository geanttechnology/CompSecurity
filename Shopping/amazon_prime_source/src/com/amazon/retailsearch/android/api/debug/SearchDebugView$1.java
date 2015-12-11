// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.debug;

import android.view.View;

// Referenced classes of package com.amazon.retailsearch.android.api.debug:
//            SearchDebugView

class bugCallback
    implements android.view.er
{

    final SearchDebugView this$0;
    final bugCallback val$callback;

    public void onClick(View view)
    {
        SearchDebugView.access$000(SearchDebugView.this);
        SearchDebugView.access$100(SearchDebugView.this);
        SearchDebugView.access$200(SearchDebugView.this);
        if (val$callback != null)
        {
            val$callback.envSelected();
        }
    }

    bugCallback()
    {
        this$0 = final_searchdebugview;
        val$callback = bugCallback.this;
        super();
    }
}
