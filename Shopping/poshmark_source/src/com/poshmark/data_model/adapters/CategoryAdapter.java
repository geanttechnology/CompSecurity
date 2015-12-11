// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.fragments.CategoryListFragment;
import com.poshmark.utils.meta_data.CategorySubCategorySelectionModel;
import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends ArrayAdapter
{

    Context context;
    int defaultColor;
    boolean defaultColorSet;
    CategoryListFragment fragment;
    CategorySubCategorySelectionModel info;
    boolean isAllSelected;
    int layoutResourceId;
    ListView parentListView;
    MetaItem selectedCategory;

    public CategoryAdapter(Context context1, int i, CategorySubCategorySelectionModel categorysubcategoryselectionmodel, CategoryListFragment categorylistfragment)
    {
        super(context1, i, categorysubcategoryselectionmodel.categoryFacetList);
        isAllSelected = false;
        defaultColorSet = false;
        context = context1;
        layoutResourceId = i;
        fragment = categorylistfragment;
        info = categorysubcategoryselectionmodel;
        if (categorysubcategoryselectionmodel.currentCategory == null)
        {
            isAllSelected = true;
            return;
        } else
        {
            selectedCategory = categorysubcategoryselectionmodel.currentCategory;
            return;
        }
    }

    private CategoryAdapter(Context context1, int i, ArrayList arraylist)
    {
        super(context1, i, arraylist);
        isAllSelected = false;
        defaultColorSet = false;
    }

    private static List getCompleteList(List list, List list1)
    {
        ArrayList arraylist = new ArrayList();
        if (list != null)
        {
            arraylist.addAll(list);
        }
        if (list1 != null)
        {
            arraylist.addAll(list1);
        }
        return arraylist;
    }

    private void removeAllSelections()
    {
        info.removeAllSelections();
    }

    private void removeCheckMark(View view)
    {
        ((ImageView)view.findViewById(0x7f0c0097)).setVisibility(8);
    }

    private void setAllItemsRowState(View view, boolean flag)
    {
        PMTextView pmtextview = (PMTextView)view.findViewById(0x7f0c0072);
        ((LinearLayout)view.findViewById(0x7f0c0071)).setVisibility(0);
        pmtextview.setText("All");
        if (flag)
        {
            pmtextview.setTextColor(context.getResources().getColor(0x7f09003c));
            pmtextview.setTypeface(null, 1);
            pmtextview.setCompoundDrawablesWithIntrinsicBounds(null, null, context.getResources().getDrawable(0x7f02007e), null);
            return;
        } else
        {
            pmtextview.setTextColor(context.getResources().getColor(0x7f090039));
            pmtextview.setTypeface(null, 1);
            pmtextview.setCompoundDrawables(null, null, null, null);
            return;
        }
    }

    private void setItemState(View view, MetaItem metaitem, MetaItem metaitem1)
    {
        View view1;
        TextView textview;
        TextView textview1;
        view1 = view.findViewById(0x7f0c0099);
        textview = (TextView)view.findViewById(0x7f0c009a);
        textview1 = (TextView)view.findViewById(0x7f0c0098);
        if (metaitem1 == null || !metaitem1.getId().equalsIgnoreCase(metaitem.getId()))
        {
            break MISSING_BLOCK_LABEL_179;
        }
        showCheckMark(view);
        textview1.setTextColor(context.getResources().getColor(0x7f09003c));
        textview1.setTypeface(null, 1);
        if (info.currentSubCategorySelection == null || info.currentSubCategorySelection.isEmpty()) goto _L2; else goto _L1
_L1:
        view1.setVisibility(0);
        textview.setVisibility(0);
        textview.setText(((MetaItem)info.currentSubCategorySelection.get(0)).getDisplay());
_L4:
        return;
_L2:
        if (fragment.isListingFlow()) goto _L4; else goto _L3
_L3:
        view1.setVisibility(0);
        textview.setVisibility(0);
        textview.setText(context.getResources().getString(0x7f06003c));
        return;
        removeCheckMark(view);
        textview1.setTextColor(defaultColor);
        textview1.setTypeface(null, 0);
        view1.setVisibility(8);
        textview.setVisibility(8);
        return;
    }

    private void setupListItemClickListener()
    {
        parentListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final CategoryAdapter this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                if (parentListView.getHeaderViewsCount() > 0 && i == 0)
                {
                    if (!isAllSelected)
                    {
                        isAllSelected = true;
                    }
                    setAllItemsRowState(view, isAllSelected);
                    removeAllSelections();
                    notifyDataSetChanged();
                    fragment.allItemSelected();
                    return;
                }
                int j = parentListView.getHeaderViewsCount();
                adapterview = (MetaItem)info.categoryFacetList.get(i - j);
                if (info.currentCategory == null)
                {
                    isAllSelected = true;
                    setAllItemsRowState(fragment.getListHeaderView(), isAllSelected);
                } else
                {
                    notifyDataSetChanged();
                }
                fragment.itemSelected(adapterview);
            }

            
            {
                this$0 = CategoryAdapter.this;
                super();
            }
        });
    }

    private void showCheckMark(View view)
    {
        ((ImageView)view.findViewById(0x7f0c0097)).setVisibility(0);
    }

    private void toggleItem(View view, MetaItem metaitem, MetaItem metaitem1)
    {
        if (metaitem1 != null && metaitem1.getId().equalsIgnoreCase(metaitem.getId()))
        {
            removeCheckMark(view);
        } else
        {
            info.currentCategory = metaitem;
            showCheckMark(view);
        }
        if (isAllSelected)
        {
            isAllSelected = false;
            setAllItemsRowState(fragment.getListHeaderView(), isAllSelected);
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
        viewgroup = (TextView)view.findViewById(0x7f0c0098);
        if (!defaultColorSet)
        {
            defaultColorSet = true;
            defaultColor = viewgroup.getTextColors().getDefaultColor();
        }
        viewgroup.setCompoundDrawables(null, null, null, null);
        viewgroup.setText(((MetaItem)getItem(i)).getDisplay());
        setItemState(view, (MetaItem)getItem(i), info.currentCategory);
        view.setTag(Integer.valueOf(i));
        return view;
    }

    public void setListView(ListView listview)
    {
        parentListView = listview;
        setupListItemClickListener();
    }


}
