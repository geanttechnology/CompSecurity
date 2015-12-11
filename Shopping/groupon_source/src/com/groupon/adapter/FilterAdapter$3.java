// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.widget.CompoundButton;
import com.groupon.models.search.data.FacetValue;

// Referenced classes of package com.groupon.adapter:
//            FilterAdapter

class Value
    implements android.widget.nCheckedChangeListener
{

    final FilterAdapter this$0;
    final FacetValue val$facetValue;
    final int val$position;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        onFilterSheetItemSelected(val$position, val$facetValue, flag);
    }

    Value()
    {
        this$0 = final_filteradapter;
        val$position = i;
        val$facetValue = FacetValue.this;
        super();
    }
}
