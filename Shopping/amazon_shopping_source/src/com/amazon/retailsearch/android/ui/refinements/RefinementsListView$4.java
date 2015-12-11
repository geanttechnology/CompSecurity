// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;

import android.view.View;
import android.widget.ExpandableListView;

// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            RefinementsListView, RefinementsAdapter

class this._cls0
    implements android.widget.roupClickListener
{

    final RefinementsListView this$0;

    public boolean onGroupClick(ExpandableListView expandablelistview, View view, int i, long l)
    {
        int j = i;
        if (RefinementsListView.access$100(RefinementsListView.this).isGroupSeeMoreLink(i))
        {
            j = RefinementsListView.access$100(RefinementsListView.this).getGroupPosition("dept");
        } else
        if (RefinementsListView.access$100(RefinementsListView.this).isAddressInfo(i))
        {
            return true;
        }
        if (isGroupExpanded(j))
        {
            if (j != i)
            {
                setSelectedGroup(j);
                return true;
            } else
            {
                collapseGroupWithAnimation(j);
                RefinementsListView.access$602(RefinementsListView.this, null);
                return true;
            }
        }
        expandablelistview = RefinementsListView.access$200(RefinementsListView.this, RefinementsListView.access$100(RefinementsListView.this).getGroupItem(j));
        if (RefinementsListView.access$600(RefinementsListView.this) != null && expandablelistview != null && !expandablelistview.equals(RefinementsListView.access$600(RefinementsListView.this)))
        {
            collapseGroupWithAnimation(RefinementsListView.access$100(RefinementsListView.this).getGroupPosition(RefinementsListView.access$600(RefinementsListView.this)));
        }
        RefinementsListView.access$602(RefinementsListView.this, expandablelistview);
        smoothScrollToPosition(j);
        expandGroupWithAnimation(j);
        return true;
    }

    ()
    {
        this$0 = RefinementsListView.this;
        super();
    }
}
