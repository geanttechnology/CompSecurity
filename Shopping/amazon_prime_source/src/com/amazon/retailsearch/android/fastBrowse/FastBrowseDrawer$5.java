// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.fastBrowse;

import android.widget.ListView;
import com.amazon.retailsearch.android.ui.refinements.SpinnerHiderRelativeLayout;

// Referenced classes of package com.amazon.retailsearch.android.fastBrowse:
//            FastBrowseDrawer, FastBrowseItemAdapter

class this._cls0
    implements Runnable
{

    final FastBrowseDrawer this$0;

    public void run()
    {
        FastBrowseDrawer.access$300(FastBrowseDrawer.this).notifyDataSetChanged();
        FastBrowseDrawer.access$1300(FastBrowseDrawer.this).setSelectionAfterHeaderView();
        FastBrowseDrawer.access$700(FastBrowseDrawer.this).hide();
    }

    ativeLayout()
    {
        this$0 = FastBrowseDrawer.this;
        super();
    }
}
