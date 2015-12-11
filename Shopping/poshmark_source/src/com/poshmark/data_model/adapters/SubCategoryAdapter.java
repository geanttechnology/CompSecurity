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
import com.poshmark.ui.fragments.SubCategoryListFragment;
import com.poshmark.utils.ViewUtils;
import com.poshmark.utils.meta_data.CategorySubCategorySelectionModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SubCategoryAdapter extends ArrayAdapter
{

    Context context;
    int defaultColor;
    boolean defaultColorSet;
    SubCategoryListFragment fragment;
    CategorySubCategorySelectionModel info;
    boolean isAllSelected;
    int layoutResourceId;
    ListView parentListView;

    public SubCategoryAdapter(Context context1, int i, CategorySubCategorySelectionModel categorysubcategoryselectionmodel, SubCategoryListFragment subcategorylistfragment)
    {
        super(context1, i, categorysubcategoryselectionmodel.scrubbedSubCategoryList);
        isAllSelected = false;
        defaultColorSet = false;
        context = context1;
        layoutResourceId = i;
        fragment = subcategorylistfragment;
        info = categorysubcategoryselectionmodel;
        if (categorysubcategoryselectionmodel.currentGlobalStyleTagsSelection == null)
        {
            categorysubcategoryselectionmodel.currentGlobalStyleTagsSelection = new ArrayList();
        }
        if (categorysubcategoryselectionmodel.currentSubCategorySelection == null)
        {
            categorysubcategoryselectionmodel.currentSubCategorySelection = new ArrayList();
        }
        if (!categorysubcategoryselectionmodel.selectionsPresent())
        {
            isAllSelected = true;
        }
    }

    private SubCategoryAdapter(Context context1, int i, ArrayList arraylist)
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

    private void selectRowItem(View view)
    {
        ImageView imageview = (ImageView)view.findViewById(0x7f0c0097);
        view = (TextView)view.findViewById(0x7f0c0208);
        imageview.setVisibility(0);
        view.setTextColor(context.getResources().getColor(0x7f09003c));
        view.setTypeface(null, 1);
    }

    private void setAllItemsRowState(View view, boolean flag)
    {
        PMTextView pmtextview = (PMTextView)view.findViewById(0x7f0c0072);
        view = (LinearLayout)view.findViewById(0x7f0c0071);
        view.setVisibility(0);
        pmtextview.setText("All");
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-1, -2);
        layoutparams.setMargins(0, 0, 0, (int)ViewUtils.dipToPixels(context, 30F));
        view.setLayoutParams(layoutparams);
        if (flag)
        {
            pmtextview.setTextColor(context.getResources().getColor(0x7f09003c));
            pmtextview.setTypeface(null, 1);
            pmtextview.setCompoundDrawablesWithIntrinsicBounds(null, null, context.getResources().getDrawable(0x7f02007e), null);
            return;
        } else
        {
            pmtextview.setTextColor(defaultColor);
            pmtextview.setTypeface(null, 0);
            pmtextview.setCompoundDrawables(null, null, null, null);
            return;
        }
    }

    private void setItemState(View view, MetaItem metaitem, List list)
    {
        if (!list.isEmpty())
        {
            if (((MetaItem)list.get(0)).getId().equalsIgnoreCase(metaitem.getId()))
            {
                selectRowItem(view);
                return;
            } else
            {
                unselectRowItem(view);
                return;
            }
        } else
        {
            unselectRowItem(view);
            return;
        }
    }

    private void setupListItemClickListener()
    {
        parentListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final SubCategoryAdapter this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                if (parentListView.getHeaderViewsCount() > 0 && i == 0)
                {
                    fragment.allItemSelected();
                    return;
                } else
                {
                    int j = parentListView.getHeaderViewsCount();
                    adapterview = (MetaItem)info.scrubbedSubCategoryList.get(i - j);
                    fragment.itemSelected(adapterview);
                    return;
                }
            }

            
            {
                this$0 = SubCategoryAdapter.this;
                super();
            }
        });
    }

    private void toggleItem(View view, MetaItem metaitem, List list)
    {
        Iterator iterator = list.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        if (!((MetaItem)iterator.next()).getId().equalsIgnoreCase(metaitem.getId())) goto _L4; else goto _L3
_L3:
        unselectRowItem(view);
        iterator.remove();
_L6:
        return;
_L2:
        selectRowItem(view);
        list.add(metaitem);
        if (isAllSelected)
        {
            isAllSelected = false;
            setAllItemsRowState(fragment.getListHeaderView(), isAllSelected);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void unselectRowItem(View view)
    {
        ImageView imageview = (ImageView)view.findViewById(0x7f0c0097);
        view = (TextView)view.findViewById(0x7f0c0208);
        view.setTextColor(defaultColor);
        view.setTypeface(null, 0);
        imageview.setVisibility(8);
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
        if (!defaultColorSet)
        {
            defaultColorSet = true;
            defaultColor = viewgroup.getTextColors().getDefaultColor();
        }
        viewgroup.setCompoundDrawables(null, null, null, null);
        viewgroup.setText(((MetaItem)getItem(i)).getDisplay());
        setItemState(view, (MetaItem)getItem(i), info.currentSubCategorySelection);
        view.setTag(Integer.valueOf(i));
        return view;
    }

    public void setListView(ListView listview)
    {
        parentListView = listview;
        setupListItemClickListener();
    }
}
