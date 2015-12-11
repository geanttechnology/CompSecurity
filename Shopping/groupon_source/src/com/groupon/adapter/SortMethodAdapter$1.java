// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.widget.CompoundButton;
import com.groupon.models.search.domain.SortMethodWrapper;

// Referenced classes of package com.groupon.adapter:
//            SortMethodAdapter, OnFilterSheetItemClickListener

class hodWrapper
    implements android.widget.ckedChangeListener
{

    final SortMethodAdapter this$0;
    final SortMethodWrapper val$sortMethodWrapper;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (SortMethodAdapter.access$100(SortMethodAdapter.this) != null)
        {
            SortMethodAdapter.access$100(SortMethodAdapter.this).onSortMethodSelected(val$sortMethodWrapper);
        }
    }

    hodWrapper()
    {
        this$0 = final_sortmethodadapter;
        val$sortMethodWrapper = SortMethodWrapper.this;
        super();
    }
}
