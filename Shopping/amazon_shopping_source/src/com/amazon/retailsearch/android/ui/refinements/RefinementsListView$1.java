// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;

import android.view.View;
import android.widget.ExpandableListView;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.RefinementLink;
import com.amazon.searchapp.retailsearch.model.SelectedOption;

// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            RefinementsListView, RefinementsAdapter, IRefinementsViewListener

class this._cls0
    implements android.widget.hildClickListener
{

    final RefinementsListView this$0;

    public boolean onChildClick(ExpandableListView expandablelistview, View view, int i, int j, long l)
    {
        if (getVisibility() != 8) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        RefinementsListView.access$002(RefinementsListView.this, RefinementsListView.access$200(RefinementsListView.this, RefinementsListView.access$100(RefinementsListView.this).getGroupItem(i)));
        RefinementsListView.access$302(RefinementsListView.this, j);
        l = RefinementsListView.access$100(RefinementsListView.this).getChildId(i, j);
        if (l != 3L)
        {
            break; /* Loop/switch isn't completed */
        }
        expandablelistview = (RefinementLink)RefinementsListView.access$100(RefinementsListView.this).getChild(i, j);
        if (RefinementsListView.access$400(RefinementsListView.this) != null)
        {
            RefinementsListView.access$400(RefinementsListView.this).onRefinementClick(expandablelistview.getUrl());
        }
_L4:
        if (RefinementsListView.access$400(RefinementsListView.this) != null)
        {
            RefinementsListView.access$400(RefinementsListView.this).onHide();
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (l == 4L)
        {
            expandablelistview = (SelectedOption)RefinementsListView.access$100(RefinementsListView.this).getChild(i, j);
            if (RefinementsListView.access$400(RefinementsListView.this) != null)
            {
                RefinementsListView.access$400(RefinementsListView.this).onRefinementClick(expandablelistview.getLink().getUrl());
            }
        } else
        {
            return false;
        }
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    er()
    {
        this$0 = RefinementsListView.this;
        super();
    }
}
