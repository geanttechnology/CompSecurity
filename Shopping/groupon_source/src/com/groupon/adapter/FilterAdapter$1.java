// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.widget.CompoundButton;
import com.groupon.models.search.domain.SortMethodWrapper;

// Referenced classes of package com.groupon.adapter:
//            FilterAdapter, OnFilterSheetItemClickListener

class tMethodWrapper
    implements android.widget.nCheckedChangeListener
{

    final FilterAdapter this$0;
    final SortMethodWrapper val$sortMethodWrapper;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (FilterAdapter.access$100(FilterAdapter.this) != null)
        {
            FilterAdapter.access$100(FilterAdapter.this).onSortMethodSelected(val$sortMethodWrapper);
        }
    }

    tMethodWrapper()
    {
        this$0 = final_filteradapter;
        val$sortMethodWrapper = SortMethodWrapper.this;
        super();
    }
}
