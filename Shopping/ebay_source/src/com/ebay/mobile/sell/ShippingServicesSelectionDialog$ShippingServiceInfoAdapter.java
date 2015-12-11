// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.ebay.nautilus.domain.data.LdsOption;
import com.ebay.nautilus.domain.data.ShippingEstimate;
import java.util.ArrayList;
import java.util.Map;

// Referenced classes of package com.ebay.mobile.sell:
//            ShippingServicesSelectionDialog, EditShippingServiceDialogFragment

private class serviceCategoryMap extends BaseExpandableListAdapter
    implements android.widget.apter
{
    class ViewHolder
    {

        public final TextView subtext;
        public final TextView text;
        final ShippingServicesSelectionDialog.ShippingServiceInfoAdapter this$1;

        public ViewHolder(View view)
        {
            this$1 = ShippingServicesSelectionDialog.ShippingServiceInfoAdapter.this;
            super();
            text = (TextView)view.findViewById(0x7f1000ec);
            subtext = (TextView)view.findViewById(0x7f1000ed);
        }
    }


    private final String currencyCode;
    private final ArrayList groupList;
    private final LayoutInflater inflater;
    private final Map serviceCategoryMap;
    final ShippingServicesSelectionDialog this$0;

    public ViewHolder getChild(int i, int j)
    {
        pe pe = getGroup(i);
        return (getGroup)((ArrayList)serviceCategoryMap.get(pe)).get(j);
    }

    public volatile Object getChild(int i, int j)
    {
        return getChild(i, j);
    }

    public long getChildId(int i, int j)
    {
        return 0L;
    }

    public View getChildView(int i, int j, boolean flag, View view, ViewGroup viewgroup)
    {
        ShippingEstimate shippingestimate;
        Object obj;
        if (view == null)
        {
            viewgroup = inflater.inflate(0x7f03021b, null);
            int k = (int)getResources().getDimension(0x7f090143);
            int l = (int)getResources().getDimension(0x7f090141);
            viewgroup.setPadding(k, l, k, l);
            view = new ViewHolder(viewgroup);
            viewgroup.setTag(view);
        } else
        {
            viewgroup = view;
            view = (ViewHolder)viewgroup.getTag();
        }
        obj = getChild(i, j);
        shippingestimate = ((getChild) (obj)).ceEstimate;
        obj = ((ceEstimate) (obj)).ceOption;
        ((ViewHolder) (view)).text.setText(((LdsOption) (obj)).caption);
        if (shippingestimate != null)
        {
            ((ViewHolder) (view)).subtext.setText(shippingestimate.getValueDisplay(currencyCode));
            ((ViewHolder) (view)).subtext.setVisibility(0);
            return viewgroup;
        } else
        {
            ((ViewHolder) (view)).subtext.setVisibility(8);
            return viewgroup;
        }
    }

    public int getChildrenCount(int i)
    {
        pe pe = getGroup(i);
        if (serviceCategoryMap.get(pe) != null)
        {
            return ((ArrayList)serviceCategoryMap.get(pe)).size();
        } else
        {
            return 0;
        }
    }

    public pe getGroup(int i)
    {
        return (pe)groupList.get(i);
    }

    public volatile Object getGroup(int i)
    {
        return getGroup(i);
    }

    public int getGroupCount()
    {
        if (groupList != null)
        {
            return groupList.size();
        } else
        {
            return 0;
        }
    }

    public long getGroupId(int i)
    {
        return 0L;
    }

    public View getGroupView(int i, boolean flag, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        if (view == null)
        {
            viewgroup = inflater.inflate(0x7f030218, null);
        }
        if (getGroupCount() > 1)
        {
            if (flag)
            {
                ((TextView)viewgroup).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0x7f020196, 0);
            } else
            {
                ((TextView)viewgroup).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0x7f020197, 0);
            }
        }
        ((TextView)viewgroup).setText(pe.getCategoryCaption(getGroup(i), getActivity(), siteId));
        return viewgroup;
    }

    public boolean hasStableIds()
    {
        return false;
    }

    public boolean isChildSelectable(int i, int j)
    {
        return true;
    }

    public boolean onChildClick(ExpandableListView expandablelistview, View view, int i, int j, long l)
    {
        expandablelistview = getChild(i, j);
        ((EditShippingServiceDialogFragment)getTargetFragment()).setSelectedServiceInfo(expandablelistview);
        dismiss();
        return true;
    }

    public void onGroupExpanded(int i)
    {
        super.onGroupExpanded(i);
        if (prevExpandedGroup != i)
        {
            servicesListView.collapseGroup(prevExpandedGroup);
        }
        prevExpandedGroup = i;
    }

    public ViewHolder.subtext(Context context, String s, ArrayList arraylist, Map map)
    {
        this$0 = ShippingServicesSelectionDialog.this;
        super();
        inflater = LayoutInflater.from(context);
        currencyCode = ShippingServicesSelectionDialog.this.currencyCode;
        groupList = arraylist;
        serviceCategoryMap = map;
    }
}
