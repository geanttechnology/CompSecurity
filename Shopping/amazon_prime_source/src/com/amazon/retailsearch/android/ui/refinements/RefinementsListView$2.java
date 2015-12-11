// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;

import android.text.TextUtils;
import android.view.View;
import android.widget.ExpandableListView;
import com.amazon.searchapp.retailsearch.model.Domain;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            RefinementsListView, RefinementsAdapter, GroupAdapter, RefinementGroupType, 
//            DDSAdapter, RefinementType, DDSLocationAdapter, IRefinementsViewListener

class this._cls0
    implements android.widget.hildClickListener
{

    final RefinementsListView this$0;

    public boolean onChildClick(ExpandableListView expandablelistview, View view, int i, int j, long l)
    {
        expandablelistview = RefinementsListView.access$200(RefinementsListView.this).getGroupAdapter(i);
        if (expandablelistview == null || !expandablelistview.isChildEnabled(j))
        {
            return true;
        }
        if (getVisibility() == 8)
        {
            return true;
        }
        view = RefinementsListView.access$200(RefinementsListView.this).getRefinementGroupType(i);
        if (view == RefinementGroupType.DDS)
        {
            expandablelistview = (DDSAdapter)expandablelistview;
            clearAll();
            if (expandablelistview.isProvinceSelector(j))
            {
                return RefinementsListView.access$700(RefinementsListView.this, RefinementType.DDS_PROVINCE, RefinementsListView.access$100(RefinementsListView.this), expandablelistview.getCurrentValue(0));
            }
            if (expandablelistview.isCitySelector(j))
            {
                return RefinementsListView.access$700(RefinementsListView.this, RefinementType.DDS_CITY, RefinementsListView.access$800(RefinementsListView.this), expandablelistview.getCurrentValue(1));
            }
            if (expandablelistview.isDistrictSelector(j))
            {
                return RefinementsListView.access$700(RefinementsListView.this, RefinementType.DDS_DISTRICT, RefinementsListView.access$900(RefinementsListView.this), expandablelistview.getCurrentValue(2));
            }
            expandablelistview = expandablelistview.getChildUrl(j);
            if (RefinementsListView.access$1000(RefinementsListView.this, expandablelistview))
            {
                RefinementsListView.access$1102(RefinementsListView.this, DDSAdapter.ID);
                RefinementsListView.access$1202(RefinementsListView.this, j);
                RefinementsListView.access$1302(RefinementsListView.this, RefinementsListView.access$1100(RefinementsListView.this));
            }
            return true;
        }
        if (view == RefinementGroupType.DDS_PROVINCE)
        {
            expandablelistview = (DDSLocationAdapter)expandablelistview;
            RefinementsListView.access$802(RefinementsListView.this, expandablelistview.getDomains(j));
            RefinementsListView.access$1402(RefinementsListView.this, expandablelistview.getChild(j).getId());
            if (RefinementsListView.access$800(RefinementsListView.this).size() == 1)
            {
                RefinementsListView.access$902(RefinementsListView.this, ((Domain)RefinementsListView.access$800(RefinementsListView.this).get(0)).getDomains());
                RefinementsListView.access$1502(RefinementsListView.this, ((Domain)RefinementsListView.access$800(RefinementsListView.this).get(0)).getId());
                return RefinementsListView.access$1600(RefinementsListView.this, RefinementType.DDS_DISTRICT, RefinementsListView.access$900(RefinementsListView.this));
            } else
            {
                return RefinementsListView.access$1600(RefinementsListView.this, RefinementType.DDS_CITY, RefinementsListView.access$800(RefinementsListView.this));
            }
        }
        if (view == RefinementGroupType.DDS_CITY)
        {
            expandablelistview = (DDSLocationAdapter)expandablelistview;
            RefinementsListView.access$902(RefinementsListView.this, expandablelistview.getDomains(j));
            RefinementsListView.access$1502(RefinementsListView.this, expandablelistview.getChild(j).getId());
            return RefinementsListView.access$1600(RefinementsListView.this, RefinementType.DDS_DISTRICT, RefinementsListView.access$900(RefinementsListView.this));
        }
        if (view == RefinementGroupType.DDS_DISTRICT)
        {
            expandablelistview = (DDSLocationAdapter)expandablelistview;
            RefinementsListView.access$1702(RefinementsListView.this, expandablelistview.getChild(j).getId());
            expandablelistview = RefinementsListView.access$1800(RefinementsListView.this);
            if (RefinementsListView.access$1000(RefinementsListView.this, expandablelistview))
            {
                RefinementsListView.access$1102(RefinementsListView.this, DDSAdapter.ID);
                RefinementsListView.access$1202(RefinementsListView.this, 0);
                RefinementsListView.access$1302(RefinementsListView.this, RefinementsListView.access$1100(RefinementsListView.this));
            }
            return true;
        }
        RefinementsListView.access$1102(RefinementsListView.this, expandablelistview.getId());
        RefinementsListView.access$1202(RefinementsListView.this, j);
        expandablelistview = RefinementsListView.access$200(RefinementsListView.this).getChildUrl(i, j);
        if (!TextUtils.isEmpty(expandablelistview) && RefinementsListView.access$1900(RefinementsListView.this) != null)
        {
            RefinementsListView.access$1900(RefinementsListView.this).onRefinementClick(expandablelistview);
            if (RefinementsListView.access$1900(RefinementsListView.this) != null)
            {
                RefinementsListView.access$1900(RefinementsListView.this).onHide();
            }
            return true;
        } else
        {
            return false;
        }
    }

    er()
    {
        this$0 = RefinementsListView.this;
        super();
    }
}
