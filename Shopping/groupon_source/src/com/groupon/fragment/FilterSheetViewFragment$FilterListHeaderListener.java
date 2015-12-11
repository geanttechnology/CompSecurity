// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import com.groupon.adapter.FilterAdapter;
import com.groupon.models.nst.SearchFilterExpansionExtraInfo;
import com.groupon.tracking.mobile.sdk.Logger;
import se.emilsjolander.stickylistheaders.ExpandableStickyListHeadersListView;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

// Referenced classes of package com.groupon.fragment:
//            FilterSheetViewFragment

public static final class stickyHeaderListAdapter
    implements se.emilsjolander.stickylistheaders.stAdapter
{

    private ExpandableStickyListHeadersListView filterList;
    private Logger logger;
    private FilterAdapter stickyHeaderListAdapter;

    public void onHeaderClick(StickyListHeadersListView stickylistheaderslistview, View view, final int itemPosition, long l, boolean flag)
    {
        flag = filterList.isHeaderCollapsed(l);
        Logger logger1;
        com.groupon.tracking.mobile.EncodedNSTField encodednstfield;
        if (flag)
        {
            filterList.expand(l);
            filterList.postDelayed(new Runnable() {

                final FilterSheetViewFragment.FilterListHeaderListener this$0;
                final int val$itemPosition;

                public void run()
                {
                    filterList.smoothScrollToPositionFromTop(itemPosition, 0, 150);
                }

            
            {
                this$0 = FilterSheetViewFragment.FilterListHeaderListener.this;
                itemPosition = i;
                super();
            }
            }, 100L);
        } else
        {
            filterList.collapse(l);
        }
        logger1 = logger;
        encodednstfield = Logger.NULL_NST_FIELD;
        if (flag)
        {
            stickylistheaderslistview = "expand";
        } else
        {
            stickylistheaderslistview = "collapse";
        }
        logger1.logClick("", "filter_click", "search", encodednstfield, new SearchFilterExpansionExtraInfo(stickylistheaderslistview, stickyHeaderListAdapter.getHeaderNiceName(itemPosition)));
        stickylistheaderslistview = stickyHeaderListAdapter;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        stickylistheaderslistview.onHeaderToggled(l, view, flag, true);
    }


    public (Logger logger1, ExpandableStickyListHeadersListView expandablestickylistheaderslistview, FilterAdapter filteradapter)
    {
        logger = logger1;
        filterList = expandablestickylistheaderslistview;
        stickyHeaderListAdapter = filteradapter;
    }
}
