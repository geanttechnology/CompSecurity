// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.debug;

import android.view.View;
import android.widget.AdapterView;
import com.amazon.retailsearch.adaptive.latency.LatencyAdaptiveManager;

// Referenced classes of package com.amazon.retailsearch.android.api.debug:
//            SearchDebugView

class val.latencies
    implements android.widget.SelectedListener
{

    final SearchDebugView this$0;
    final String val$latencies[];

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        LatencyAdaptiveManager.setEmulationLevel(val$latencies[i]);
        SearchDebugView.access$000(SearchDebugView.this);
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    ger()
    {
        this$0 = final_searchdebugview;
        val$latencies = _5B_Ljava.lang.String_3B_.this;
        super();
    }
}
