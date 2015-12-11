// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.debug;

import android.view.View;
import com.amazon.retailsearch.android.ui.UIUtils;

// Referenced classes of package com.amazon.retailsearch.android.api.debug:
//            SearchDebugView

class this._cls0
    implements android.view.r
{

    final SearchDebugView this$0;

    public void onClick(View view)
    {
        SearchDebugView.access$200(SearchDebugView.this);
        UIUtils.closeSoftKeyboard(SearchDebugView.access$700(SearchDebugView.this));
    }

    ()
    {
        this$0 = SearchDebugView.this;
        super();
    }
}
