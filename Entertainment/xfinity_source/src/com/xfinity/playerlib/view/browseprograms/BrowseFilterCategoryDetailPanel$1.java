// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.widget.ArrayAdapter;
import com.comcast.cim.cmasl.android.util.view.common.FilterChangeListener;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            BrowseFilterCategoryDetailPanel, DibicProgramFilter

class this._cls0
    implements FilterChangeListener
{

    final BrowseFilterCategoryDetailPanel this$0;

    public void onFilterChange(DibicProgramFilter dibicprogramfilter)
    {
        if (adapter != null)
        {
            adapter.notifyDataSetChanged();
        }
    }

    public volatile void onFilterChange(Object obj)
    {
        onFilterChange((DibicProgramFilter)obj);
    }

    Q()
    {
        this$0 = BrowseFilterCategoryDetailPanel.this;
        super();
    }
}
