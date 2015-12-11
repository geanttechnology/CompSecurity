// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.fastBrowse;

import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ListView;
import com.amazon.retailsearch.android.ui.refinements.SpinnerHiderRelativeLayout;

// Referenced classes of package com.amazon.retailsearch.android.fastBrowse:
//            FastBrowseBaseView, FastBrowseListAdapter

class this._cls0
    implements Runnable
{

    final FastBrowseBaseView this$0;

    public void run()
    {
        FastBrowseBaseView.access$700(FastBrowseBaseView.this).notifyDataSetChanged();
        FastBrowseBaseView.access$1200(FastBrowseBaseView.this).setSelectionAfterHeaderView();
        FastBrowseBaseView.access$1100(FastBrowseBaseView.this).hide();
        if (FastBrowseBaseView.access$900(FastBrowseBaseView.this) == null)
        {
            FastBrowseBaseView.access$1000(FastBrowseBaseView.this).setVisibility(8);
            FastBrowseBaseView.access$200(FastBrowseBaseView.this).openDrawer(5);
            FastBrowseBaseView.access$200(FastBrowseBaseView.this).setDrawerLockMode(2, 5);
            return;
        } else
        {
            FastBrowseBaseView.access$200(FastBrowseBaseView.this).setDrawerLockMode(0, 5);
            return;
        }
    }

    iveLayout()
    {
        this$0 = FastBrowseBaseView.this;
        super();
    }
}
