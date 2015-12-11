// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;

import android.text.TextUtils;
import android.view.View;
import android.widget.ExpandableListView;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            RefinementsListView, RefinementsAdapter, GroupAdapter, RefinementGroupType, 
//            DepartmentAdapter, RefinementType, IRefinementsViewListener

class val.currGroupId
    implements android.widget.upCollapseListener
{

    final l.onGroupCollapseListener this$1;
    final String val$currGroupId;
    final int val$p;

    public void onGroupCollapse(int i)
    {
        RefinementsListView.access$2200(_fld0, val$p, val$currGroupId);
        setOnGroupCollapseListener(onGroupCollapseListener);
    }

    l.onGroupCollapseListener()
    {
        this$1 = final_ongroupcollapselistener;
        val$p = i;
        val$currGroupId = String.this;
        super();
    }

    // Unreferenced inner class com/amazon/retailsearch/android/ui/refinements/RefinementsListView$5

/* anonymous class */
    class RefinementsListView._cls5
        implements android.widget.ExpandableListView.OnGroupClickListener
    {

        final RefinementsListView this$0;
        final android.widget.ExpandableListView.OnGroupCollapseListener val$onGroupCollapseListener;

        public boolean onGroupClick(ExpandableListView expandablelistview, View view, int i, long l)
        {
            view = RefinementsListView.access$200(RefinementsListView.this).getGroupAdapter(i);
            if (view == null || !view.isEnabled())
            {
                return true;
            }
            RefinementGroupType refinementgrouptype = RefinementsListView.access$200(RefinementsListView.this).getRefinementGroupType(i);
            final int p = i;
            if (refinementgrouptype == RefinementGroupType.SEEMORE)
            {
                p = RefinementsListView.access$200(RefinementsListView.this).getGroupPosition(DepartmentAdapter.ID);
                expandablelistview = RefinementsListView.access$200(RefinementsListView.this).getGroupAdapter(p);
            } else
            {
                if (refinementgrouptype == RefinementGroupType.DDS_PROVINCE)
                {
                    return RefinementsListView.access$1600(RefinementsListView.this, RefinementType.DEFAULT, null);
                }
                if (refinementgrouptype == RefinementGroupType.DDS_CITY)
                {
                    return RefinementsListView.access$1600(RefinementsListView.this, RefinementType.DDS_PROVINCE, RefinementsListView.access$100(RefinementsListView.this));
                }
                if (refinementgrouptype == RefinementGroupType.DDS_DISTRICT)
                {
                    if (RefinementsListView.access$800(RefinementsListView.this).size() == 1)
                    {
                        return RefinementsListView.access$1600(RefinementsListView.this, RefinementType.DDS_PROVINCE, RefinementsListView.access$100(RefinementsListView.this));
                    } else
                    {
                        return RefinementsListView.access$1600(RefinementsListView.this, RefinementType.DDS_CITY, RefinementsListView.access$800(RefinementsListView.this));
                    }
                }
                if (refinementgrouptype == RefinementGroupType.DDS)
                {
                    RefinementsListView.access$2100(RefinementsListView.this);
                    expandablelistview = view;
                } else
                {
                    expandablelistview = view;
                    if (refinementgrouptype == RefinementGroupType.FILTER_ITEM)
                    {
                        expandablelistview = view.getUrl();
                        if (!TextUtils.isEmpty(expandablelistview) && RefinementsListView.access$1900(RefinementsListView.this) != null)
                        {
                            RefinementsListView.access$1900(RefinementsListView.this).onRefinementClick(expandablelistview);
                        }
                        return true;
                    }
                }
            }
            if (isGroupExpanded(p))
            {
                if (p != i)
                {
                    setSelectedGroup(p);
                } else
                {
                    collapseGroupWithAnimation(p);
                    RefinementsListView.access$1302(RefinementsListView.this, null);
                }
            } else
            {
                expandablelistview = expandablelistview.getId();
                boolean flag = false;
                i = ((flag) ? 1 : 0);
                if (RefinementsListView.access$1300(RefinementsListView.this) != null)
                {
                    i = ((flag) ? 1 : 0);
                    if (expandablelistview != null)
                    {
                        i = ((flag) ? 1 : 0);
                        if (!expandablelistview.equals(RefinementsListView.access$1300(RefinementsListView.this)))
                        {
                            int j = RefinementsListView.access$200(RefinementsListView.this).getGroupPosition(RefinementsListView.access$1300(RefinementsListView.this));
                            i = ((flag) ? 1 : 0);
                            if (isGroupExpanded(j))
                            {
                                setOnGroupCollapseListener(expandablelistview. new RefinementsListView._cls5._cls1());
                                collapseGroupWithAnimation(j);
                                i = 1;
                            }
                        }
                    }
                }
                if (i == 0)
                {
                    RefinementsListView.access$2200(RefinementsListView.this, p, expandablelistview);
                }
            }
            return true;
        }

            
            {
                this$0 = final_refinementslistview;
                onGroupCollapseListener = android.widget.ExpandableListView.OnGroupCollapseListener.this;
                super();
            }
    }

}
