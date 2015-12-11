// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.debug;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.amazon.retailsearch.android.api.debug:
//            SearchDebugView

class this._cls0
    implements android.widget.SelectedListener
{

    final SearchDebugView this$0;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        SearchDebugView.access$000(SearchDebugView.this);
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    A()
    {
        this$0 = SearchDebugView.this;
        super();
    }
}
