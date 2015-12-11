// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.poshmark.data_model.models.IndexedMetaItem;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.ui.customviews.BrandFollowButtonLayout;
import com.poshmark.utils.ViewUtils;
import com.poshmark.utils.meta_data.MetaItemPickerInfo;
import java.util.ArrayList;
import java.util.Iterator;

public class MetaItemListAdapter extends ArrayAdapter
{
    public class BrandSearchFilter extends Filter
    {

        final MetaItemListAdapter this$0;

        protected android.widget.Filter.FilterResults performFiltering(CharSequence charsequence)
        {
            android.widget.Filter.FilterResults filterresults = new android.widget.Filter.FilterResults();
            ArrayList arraylist = new ArrayList();
            searchTerm = charsequence.toString();
            Iterator iterator = data.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                IndexedMetaItem indexedmetaitem = (IndexedMetaItem)iterator.next();
                if (indexedmetaitem.getMetaItem().getDisplay().toLowerCase().startsWith(charsequence.toString().toLowerCase()))
                {
                    arraylist.add(indexedmetaitem);
                }
            } while (true);
            filterresults.count = arraylist.size();
            filterresults.values = arraylist;
            return filterresults;
        }

        protected void publishResults(CharSequence charsequence, android.widget.Filter.FilterResults filterresults)
        {
            filteredData = (ArrayList)filterresults.values;
            notifyDataSetChanged();
        }

        public BrandSearchFilter()
        {
            this$0 = MetaItemListAdapter.this;
            super();
        }
    }


    boolean allowCustomStringEnabled;
    Context context;
    MetaItem currentSelection;
    boolean customOptionEnabled;
    ArrayList data;
    BrandSearchFilter filter;
    ArrayList filteredData;
    int layoutResourceId;
    boolean searchEnabled;
    String searchTerm;
    boolean showBrandFollowButton;

    public MetaItemListAdapter(Context context1, int i, MetaItemPickerInfo metaitempickerinfo, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        super(context1, i, IndexedMetaItem.convertToIndexMetaItemList((ArrayList)metaitempickerinfo.allItems));
        context = context1;
        if (metaitempickerinfo == null)
        {
            data = new ArrayList();
        } else
        {
            data = IndexedMetaItem.convertToIndexMetaItemList((ArrayList)metaitempickerinfo.allItems);
        }
        layoutResourceId = i;
        currentSelection = metaitempickerinfo.currentSelection;
        filter = new BrandSearchFilter();
        searchEnabled = flag;
        customOptionEnabled = flag1;
        allowCustomStringEnabled = flag2;
        filteredData = IndexedMetaItem.convertToIndexMetaItemList((ArrayList)metaitempickerinfo.allItems);
        showBrandFollowButton = flag3;
    }

    private MetaItemListAdapter(Context context1, int i, ArrayList arraylist)
    {
        super(context1, i, arraylist);
    }

    public int getCount()
    {
        if (allowCustomStringEnabled && searchEnabled && searchTerm != null && searchTerm.length() > 0)
        {
            return filteredData.size() + 1;
        }
        if (customOptionEnabled)
        {
            return filteredData.size() + 1;
        } else
        {
            return filteredData.size();
        }
    }

    public Filter getFilter()
    {
        if (filter == null)
        {
            filter = new BrandSearchFilter();
        }
        return filter;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj = view;
        Object obj1 = ((Activity)context).getLayoutInflater();
        view = ((View) (obj));
        if (obj == null)
        {
            view = ((LayoutInflater) (obj1)).inflate(layoutResourceId, viewgroup, false);
        }
        obj = (RelativeLayout)view.findViewById(0x7f0c0207);
        LinearLayout linearlayout = (LinearLayout)view.findViewById(0x7f0c0209);
        obj1 = (TextView)view.findViewById(0x7f0c0208);
        viewgroup = null;
        if (showBrandFollowButton)
        {
            linearlayout.setVisibility(0);
            viewgroup = (BrandFollowButtonLayout)view.findViewById(0x7f0c0066);
            viewgroup.setFollowingButtonColor(0x7f020009, 0x7f090039);
        }
        if (allowCustomStringEnabled && searchEnabled)
        {
            if (searchTerm != null && searchTerm.length() > 0)
            {
                if (i == 0)
                {
                    ((TextView) (obj1)).setCompoundDrawablesWithIntrinsicBounds(getContext().getResources().getDrawable(0x7f020065), null, null, null);
                    ((TextView) (obj1)).setText(searchTerm);
                } else
                {
                    ((TextView) (obj1)).setCompoundDrawables(null, null, null, null);
                    ((TextView) (obj1)).setText(((IndexedMetaItem)filteredData.get(i - 1)).getMetaItem().getDisplay());
                    view.setTag(Integer.valueOf(((IndexedMetaItem)filteredData.get(i - 1)).getIndex()));
                }
            } else
            {
                ((TextView) (obj1)).setCompoundDrawables(null, null, null, null);
                ((TextView) (obj1)).setText(((IndexedMetaItem)filteredData.get(i)).getMetaItem().getDisplay());
                view.setTag(Integer.valueOf(((IndexedMetaItem)filteredData.get(i)).getIndex()));
            }
        } else
        if (customOptionEnabled && i == filteredData.size())
        {
            ((TextView) (obj1)).setCompoundDrawables(null, null, null, null);
            ((TextView) (obj1)).setText(context.getString(0x7f060032));
        } else
        {
            ((TextView) (obj1)).setCompoundDrawables(null, null, null, null);
            ((TextView) (obj1)).setText(((IndexedMetaItem)filteredData.get(i)).getMetaItem().getDisplay());
            if (viewgroup != null)
            {
                viewgroup.setParentScreenNameForAnalytics("listing_select_brand_screen");
                viewgroup.setBrand(((IndexedMetaItem)filteredData.get(i)).getMetaItem().getId());
            }
            if (currentSelection != null && ((IndexedMetaItem)filteredData.get(i)).getMetaItem().getId().equals(currentSelection.getId()))
            {
                ((TextView) (obj1)).setTextColor(context.getResources().getColor(0x7f09003c));
                ((TextView) (obj1)).setTypeface(null, 1);
                ((TextView) (obj1)).setCompoundDrawablesWithIntrinsicBounds(null, null, context.getResources().getDrawable(0x7f02007e), null);
            } else
            {
                ((TextView) (obj1)).setTextColor(context.getResources().getColor(0x7f090035));
                ((TextView) (obj1)).setTypeface(null, 0);
            }
            view.setTag(Integer.valueOf(((IndexedMetaItem)filteredData.get(i)).getIndex()));
        }
        i = (int)ViewUtils.dipToPixels(context, 30F);
        ((RelativeLayout) (obj)).getPaddingTop();
        return view;
    }
}
