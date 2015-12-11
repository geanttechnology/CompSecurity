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
import android.widget.TextView;
import com.emilsjolander.components.stickylistheaders.StickyListHeadersAdapter;
import com.poshmark.data_model.models.IndexedMetaItem;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.utils.meta_data.BrandsMetaItemPickerInfo;
import com.poshmark.utils.view_holders.TableSectionHeaderViewHolder;
import java.util.ArrayList;
import java.util.Iterator;

public class BrandsMetaItemListAdapter extends ArrayAdapter
    implements StickyListHeadersAdapter
{
    public class BrandSearchFilter extends Filter
    {

        final BrandsMetaItemListAdapter this$0;

        protected android.widget.Filter.FilterResults performFiltering(CharSequence charsequence)
        {
            android.widget.Filter.FilterResults filterresults = new android.widget.Filter.FilterResults();
            ArrayList arraylist = new ArrayList();
            searchTerm = charsequence.toString();
            charsequence = data.iterator();
            try
            {
                do
                {
                    if (!charsequence.hasNext())
                    {
                        break;
                    }
                    IndexedMetaItem indexedmetaitem = (IndexedMetaItem)charsequence.next();
                    if (indexedmetaitem.getMetaItem().getDisplay().toLowerCase().startsWith(searchTerm.toLowerCase()))
                    {
                        arraylist.add(indexedmetaitem);
                    }
                } while (true);
            }
            // Misplaced declaration of an exception variable
            catch (CharSequence charsequence)
            {
                charsequence.printStackTrace();
            }
            filterresults.count = arraylist.size();
            filterresults.values = arraylist;
            return filterresults;
        }

        protected void publishResults(CharSequence charsequence, android.widget.Filter.FilterResults filterresults)
        {
            filteredData = (ArrayList)filterresults.values;
            recentBrandsList = new ArrayList();
            notifyDataSetChanged();
        }

        public BrandSearchFilter()
        {
            this$0 = BrandsMetaItemListAdapter.this;
            super();
        }
    }


    BrandsMetaItemPickerInfo brandsMetaInfo;
    Context context;
    MetaItem currentSelection;
    ArrayList data;
    BrandSearchFilter filter;
    boolean filterEnabled;
    public ArrayList filteredData;
    int layoutResourceId;
    public ArrayList recentBrandsList;
    String searchTerm;

    public BrandsMetaItemListAdapter(Context context1, int i, BrandsMetaItemPickerInfo brandsmetaitempickerinfo, ArrayList arraylist)
    {
        super(context1, i, IndexedMetaItem.convertToIndexMetaItemList((ArrayList)brandsmetaitempickerinfo.allItems));
        context = context1;
        layoutResourceId = i;
        if (data == null)
        {
            data = new ArrayList();
        } else
        {
            data = IndexedMetaItem.convertRecentBrandsToIndexMetaItemList((ArrayList)brandsmetaitempickerinfo.allItems, arraylist);
        }
        if (brandsmetaitempickerinfo.currentSelection != null)
        {
            currentSelection = brandsmetaitempickerinfo.currentSelection;
        }
        filteredData = IndexedMetaItem.convertRecentBrandsToIndexMetaItemList((ArrayList)brandsmetaitempickerinfo.allItems, arraylist);
        filter = new BrandSearchFilter();
        recentBrandsList = arraylist;
        data = IndexedMetaItem.convertToIndexMetaItemList((ArrayList)brandsmetaitempickerinfo.allItems);
    }

    public int getCount()
    {
        return filteredData.size();
    }

    public Filter getFilter()
    {
        filterEnabled = true;
        if (filter == null)
        {
            filter = new BrandSearchFilter();
        }
        return filter;
    }

    public long getHeaderId(int i)
    {
        if (recentBrandsList.size() > 0 && i >= recentBrandsList.size())
        {
            return (long)recentBrandsList.size();
        } else
        {
            return 0L;
        }
    }

    public View getHeaderView(int i, View view, ViewGroup viewgroup)
    {
        LayoutInflater layoutinflater = ((Activity)context).getLayoutInflater();
        if (view == null)
        {
            TableSectionHeaderViewHolder tablesectionheaderviewholder = new TableSectionHeaderViewHolder();
            view = layoutinflater.inflate(0x7f0300c4, viewgroup, false);
            tablesectionheaderviewholder.titleView = (TextView)view.findViewById(0x7f0c0130);
            view.setTag(tablesectionheaderviewholder);
            viewgroup = tablesectionheaderviewholder;
        } else
        {
            viewgroup = (TableSectionHeaderViewHolder)view.getTag();
        }
        if (i >= recentBrandsList.size())
        {
            String s = context.getString(0x7f06003c).toUpperCase();
            ((TableSectionHeaderViewHolder) (viewgroup)).titleView.setText(s);
            return view;
        }
        if (recentBrandsList.size() > 0)
        {
            ((TableSectionHeaderViewHolder) (viewgroup)).titleView.setVisibility(0);
            String s1 = context.getString(0x7f060221).toUpperCase();
            ((TableSectionHeaderViewHolder) (viewgroup)).titleView.setText(s1);
            return view;
        } else
        {
            ((TableSectionHeaderViewHolder) (viewgroup)).titleView.setVisibility(8);
            return view;
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1 = view;
        LayoutInflater layoutinflater = ((Activity)context).getLayoutInflater();
        view = view1;
        if (view1 == null)
        {
            view = layoutinflater.inflate(layoutResourceId, viewgroup, false);
        }
        viewgroup = (TextView)view.findViewById(0x7f0c0208);
        viewgroup.setCompoundDrawables(null, null, null, null);
        viewgroup.setText(((IndexedMetaItem)filteredData.get(i)).getMetaItem().getDisplay());
        if (currentSelection == null || !((IndexedMetaItem)filteredData.get(i)).getMetaItem().getDisplay().equals(currentSelection.getDisplay()))
        {
            break MISSING_BLOCK_LABEL_175;
        }
        viewgroup.setTextColor(context.getResources().getColor(0x7f09003c));
        viewgroup.setTypeface(null, 1);
        viewgroup.setCompoundDrawablesWithIntrinsicBounds(null, null, context.getResources().getDrawable(0x7f02007e), null);
_L1:
        view.setTag(Integer.valueOf(((IndexedMetaItem)filteredData.get(i)).getIndex()));
        return view;
        try
        {
            viewgroup.setTextColor(context.getResources().getColor(0x7f090035));
            viewgroup.setTypeface(null, 0);
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            return view;
        }
          goto _L1
    }
}
