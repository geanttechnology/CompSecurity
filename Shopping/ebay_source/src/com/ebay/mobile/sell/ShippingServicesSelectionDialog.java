// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.LdsOption;
import com.ebay.nautilus.domain.data.ShippingEstimate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.mobile.sell:
//            EditShippingServiceDialogFragment

public class ShippingServicesSelectionDialog extends DialogFragment
{
    private class CategorySort
        implements Comparator
    {

        final ShippingServicesSelectionDialog this$0;

        public int compare(EditShippingServiceDialogFragment.ShippingServiceCategoryType shippingservicecategorytype, EditShippingServiceDialogFragment.ShippingServiceCategoryType shippingservicecategorytype1)
        {
            return shippingservicecategorytype.getCategoryIdentifier().compareTo(shippingservicecategorytype1.getCategoryIdentifier());
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((EditShippingServiceDialogFragment.ShippingServiceCategoryType)obj, (EditShippingServiceDialogFragment.ShippingServiceCategoryType)obj1);
        }

        private CategorySort()
        {
            this$0 = ShippingServicesSelectionDialog.this;
            super();
        }

    }

    private class ShippingServiceInfoAdapter extends BaseExpandableListAdapter
        implements android.widget.ExpandableListView.OnChildClickListener
    {

        private final String currencyCode;
        private final ArrayList groupList;
        private final LayoutInflater inflater;
        private final Map serviceCategoryMap;
        final ShippingServicesSelectionDialog this$0;

        public EditShippingServiceDialogFragment.ShippingServiceInfo getChild(int i, int j)
        {
            EditShippingServiceDialogFragment.ShippingServiceCategoryType shippingservicecategorytype = getGroup(i);
            return (EditShippingServiceDialogFragment.ShippingServiceInfo)((ArrayList)serviceCategoryMap.get(shippingservicecategorytype)).get(j);
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
            shippingestimate = ((EditShippingServiceDialogFragment.ShippingServiceInfo) (obj)).serviceEstimate;
            obj = ((EditShippingServiceDialogFragment.ShippingServiceInfo) (obj)).serviceOption;
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
            EditShippingServiceDialogFragment.ShippingServiceCategoryType shippingservicecategorytype = getGroup(i);
            if (serviceCategoryMap.get(shippingservicecategorytype) != null)
            {
                return ((ArrayList)serviceCategoryMap.get(shippingservicecategorytype)).size();
            } else
            {
                return 0;
            }
        }

        public EditShippingServiceDialogFragment.ShippingServiceCategoryType getGroup(int i)
        {
            return (EditShippingServiceDialogFragment.ShippingServiceCategoryType)groupList.get(i);
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
            ((TextView)viewgroup).setText(EditShippingServiceDialogFragment.ShippingServiceCategoryType.getCategoryCaption(getGroup(i), getActivity(), siteId));
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

        public ShippingServiceInfoAdapter(Context context, String s, ArrayList arraylist, Map map)
        {
            this$0 = ShippingServicesSelectionDialog.this;
            super();
            inflater = LayoutInflater.from(context);
            currencyCode = ShippingServicesSelectionDialog.this.currencyCode;
            groupList = arraylist;
            serviceCategoryMap = map;
        }
    }

    class ShippingServiceInfoAdapter.ViewHolder
    {

        public final TextView subtext;
        public final TextView text;
        final ShippingServiceInfoAdapter this$1;

        public ShippingServiceInfoAdapter.ViewHolder(View view)
        {
            this$1 = ShippingServiceInfoAdapter.this;
            super();
            text = (TextView)view.findViewById(0x7f1000ec);
            subtext = (TextView)view.findViewById(0x7f1000ed);
        }
    }


    private static final String DIALOG_EXTRA_CURRENCY_CODE = "currency_code";
    private static final String DIALOG_EXTRA_SHIPPING_SERVICE_INFO_LIST = "shipping_service_info_list";
    protected String currencyCode;
    protected int prevExpandedGroup;
    private Map serviceCategoryToInfoMap;
    protected ExpandableListView servicesListView;
    private ShippingServiceInfoAdapter shippingInfoAdapter;
    protected int siteId;

    public ShippingServicesSelectionDialog()
    {
        prevExpandedGroup = 0;
    }

    public static ShippingServicesSelectionDialog createInstance(Fragment fragment, int i, Map map, String s)
    {
        Bundle bundle = new Bundle();
        bundle.putSerializable("currency_code", s);
        bundle.putSerializable("shipping_service_info_list", (Serializable)map);
        map = new ShippingServicesSelectionDialog();
        map.setTargetFragment(fragment, i);
        map.setArguments(bundle);
        return map;
    }

    private void createUI(View view)
    {
        servicesListView = (ExpandableListView)view.findViewById(0x7f100701);
        boolean flag1 = false;
        boolean flag = false;
        view = new ArrayList();
        EditShippingServiceDialogFragment.ShippingServiceCategoryType shippingservicecategorytype = EditShippingServiceDialogFragment.ShippingServiceCategoryType.NONE;
        EditShippingServiceDialogFragment.ShippingServiceCategoryType shippingservicecategorytype1 = EditShippingServiceDialogFragment.ShippingServiceCategoryType.OTHER;
        for (Iterator iterator = serviceCategoryToInfoMap.keySet().iterator(); iterator.hasNext();)
        {
            EditShippingServiceDialogFragment.ShippingServiceCategoryType shippingservicecategorytype2 = (EditShippingServiceDialogFragment.ShippingServiceCategoryType)iterator.next();
            if (shippingservicecategorytype2 == shippingservicecategorytype)
            {
                flag1 = true;
            } else
            if (shippingservicecategorytype2 == shippingservicecategorytype1)
            {
                flag = true;
            } else
            {
                view.add(shippingservicecategorytype2);
            }
        }

        Collections.sort(view, new CategorySort());
        if (flag)
        {
            view.add(view.size(), shippingservicecategorytype1);
        }
        if (flag1)
        {
            view.add(view.size(), shippingservicecategorytype);
        }
        shippingInfoAdapter = new ShippingServiceInfoAdapter(getActivity(), currencyCode, view, serviceCategoryToInfoMap);
        servicesListView.setAdapter(shippingInfoAdapter);
        servicesListView.setOnChildClickListener(shippingInfoAdapter);
        if (view.size() == 1)
        {
            servicesListView.expandGroup(0);
            servicesListView.setOnGroupClickListener(new android.widget.ExpandableListView.OnGroupClickListener() {

                final ShippingServicesSelectionDialog this$0;

                public boolean onGroupClick(ExpandableListView expandablelistview, View view1, int i, long l)
                {
                    return true;
                }

            
            {
                this$0 = ShippingServicesSelectionDialog.this;
                super();
            }
            });
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setRetainInstance(true);
        setStyle(0, 0x7f0a0280);
        bundle = getArguments();
        if (bundle != null)
        {
            currencyCode = bundle.getString("currency_code");
            serviceCategoryToInfoMap = (Map)bundle.getSerializable("shipping_service_info_list");
        }
        siteId = MyApp.getPrefs().getCurrentSite().idInt;
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = LayoutInflater.from(getActivity()).inflate(0x7f03021a, null);
        createUI(bundle);
        return (new android.support.v7.app.AlertDialog.Builder(getActivity())).setTitle(0x7f0705bd).setView(bundle).setCancelable(true).setNegativeButton(0x7f0701cc, null).create();
    }

    public void onResume()
    {
        super.onResume();
        if (getTargetFragment().isRemoving())
        {
            dismiss();
        }
    }
}
