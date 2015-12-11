// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.view.View;
import com.groupon.models.nst.SearchFilterTypeExtraInfo;
import com.groupon.models.search.data.Facet;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.adapter:
//            FilterAdapter

class 
    implements android.view.ener
{

    final FilterAdapter this$0;
    final Facet val$facet;

    public void onClick(View view)
    {
        FilterAdapter.access$200(FilterAdapter.this).logClick("", "filter_more_option_select", "search", Logger.NULL_NST_FIELD, new SearchFilterTypeExtraInfo(val$facet.id));
        FilterAdapter.access$300(FilterAdapter.this).addMore(val$facet);
    }

    ()
    {
        this$0 = final_filteradapter;
        val$facet = Facet.this;
        super();
    }
}
