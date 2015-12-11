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

class val.onGroupCollapseListener
    implements android.widget.roupClickListener
{

    final RefinementsListView this$0;
    final android.widget.roupCollapseListener val$onGroupCollapseListener;

    public boolean onGroupClick(final ExpandableListView currGroupId, View view, int i, long l)
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
            currGroupId = RefinementsListView.access$200(RefinementsListView.this).getGroupAdapter(p);
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
                currGroupId = view;
            } else
            {
                currGroupId = view;
                if (refinementgrouptype == RefinementGroupType.FILTER_ITEM)
                {
                    currGroupId = view.getUrl();
                    if (!TextUtils.isEmpty(currGroupId) && RefinementsListView.access$1900(RefinementsListView.this) != null)
                    {
                        RefinementsListView.access$1900(RefinementsListView.this).onRefinementClick(currGroupId);
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
            currGroupId = currGroupId.getId();
            boolean flag = false;
            i = ((flag) ? 1 : 0);
            if (RefinementsListView.access$1300(RefinementsListView.this) != null)
            {
                i = ((flag) ? 1 : 0);
                if (currGroupId != null)
                {
                    i = ((flag) ? 1 : 0);
                    if (!currGroupId.equals(RefinementsListView.access$1300(RefinementsListView.this)))
                    {
                        int j = RefinementsListView.access$200(RefinementsListView.this).getGroupPosition(RefinementsListView.access$1300(RefinementsListView.this));
                        i = ((flag) ? 1 : 0);
                        if (isGroupExpanded(j))
                        {
                            setOnGroupCollapseListener(new android.widget.ExpandableListView.OnGroupCollapseListener() {

                                final RefinementsListView._cls5 this$1;
                                final String val$currGroupId;
                                final int val$p;

                                public void onGroupCollapse(int k)
                                {
                                    RefinementsListView.access$2200(this$0, p, currGroupId);
                                    setOnGroupCollapseListener(onGroupCollapseListener);
                                }

            
            {
                this$1 = RefinementsListView._cls5.this;
                p = i;
                currGroupId = s;
                super();
            }
                            });
                            collapseGroupWithAnimation(j);
                            i = 1;
                        }
                    }
                }
            }
            if (i == 0)
            {
                RefinementsListView.access$2200(RefinementsListView.this, p, currGroupId);
            }
        }
        return true;
    }

    _cls1.val.currGroupId()
    {
        this$0 = final_refinementslistview;
        val$onGroupCollapseListener = android.widget.roupCollapseListener.this;
        super();
    }
}
