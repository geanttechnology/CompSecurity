// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.fastBrowse;

import android.content.res.TypedArray;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import com.amazon.retailsearch.android.ui.refinements.SpinnerHiderRelativeLayout;
import com.amazon.searchapp.retailsearch.model.Department;
import com.amazon.searchapp.retailsearch.model.RefinementLink;
import com.amazon.searchapp.retailsearch.model.Refinements;
import com.amazon.searchapp.retailsearch.model.SearchResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.fastBrowse:
//            FastBrowseBaseView, FastBrowseItem, FastBrowseListAdapter

class this._cls0
    implements Runnable
{

    final FastBrowseBaseView this$0;

    public void run()
    {
        RefinementLink refinementlink;
        for (Iterator iterator = FastBrowseBaseView.access$300(FastBrowseBaseView.this).getRefinements().getDepartments().getCategories().iterator(); iterator.hasNext(); FastBrowseBaseView.access$400(FastBrowseBaseView.this).add(new FastBrowseItem(refinementlink.getText(), refinementlink.getUrl(), refinementlink.getBrowseUrl(), FastBrowseBaseView.access$600(FastBrowseBaseView.this).getResourceId(0, -1))))
        {
            refinementlink = (RefinementLink)iterator.next();
        }

        FastBrowseBaseView.access$600(FastBrowseBaseView.this).recycle();
        FastBrowseBaseView.access$700(FastBrowseBaseView.this).notifyDataSetChanged();
        FastBrowseBaseView.access$200(FastBrowseBaseView.this).setDrawerShadow(com.amazon.retailsearch.dow, 5);
        setIconListner();
        FastBrowseBaseView.access$1000(FastBrowseBaseView.this).setVisibility(8);
        FastBrowseBaseView.access$200(FastBrowseBaseView.this).setDrawerLockMode(0, 5);
        FastBrowseBaseView.access$1100(FastBrowseBaseView.this).hide();
        FastBrowseBaseView.access$200(FastBrowseBaseView.this).openDrawer(5);
        FastBrowseBaseView.access$200(FastBrowseBaseView.this).setDrawerLockMode(2, 5);
        if (FastBrowseBaseView.access$000(FastBrowseBaseView.this) != null)
        {
            FastBrowseBaseView.access$000(FastBrowseBaseView.this).onCloseGno();
        }
    }

    BackUrlListener()
    {
        this$0 = FastBrowseBaseView.this;
        super();
    }
}
