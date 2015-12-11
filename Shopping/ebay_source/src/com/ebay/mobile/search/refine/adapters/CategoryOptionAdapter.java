// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ebay.mobile.search.SearchRefineFragment;

// Referenced classes of package com.ebay.mobile.search.refine.adapters:
//            RefineOptionAdapter

public class CategoryOptionAdapter extends RefineOptionAdapter
{

    private final com.ebay.common.model.search.EbayCategoryHistogram.Category container;
    private final int primaryTextColor;
    private final int primaryTextColorDisabled;
    public boolean speculative;

    public CategoryOptionAdapter(Context context, com.ebay.common.model.search.EbayCategoryHistogram.Category category, com.ebay.common.model.search.EbayCategoryHistogram.Category acategory[], boolean flag)
    {
label0:
        {
            boolean flag1 = false;
            super(context, acategory);
            TypedValue typedvalue = new TypedValue();
            ContextThemeWrapper contextthemewrapper = new ContextThemeWrapper(context, 0x7f0a002b);
            contextthemewrapper.getTheme().resolveAttribute(0x1010036, typedvalue, true);
            primaryTextColor = context.getResources().getColor(typedvalue.resourceId);
            typedvalue = new TypedValue();
            contextthemewrapper.getTheme().resolveAttribute(0x1010038, typedvalue, true);
            primaryTextColorDisabled = context.getResources().getColor(typedvalue.resourceId);
            container = category;
            if (!flag)
            {
                flag = flag1;
                if (acategory == null)
                {
                    break label0;
                }
                flag = flag1;
                if (acategory.length != 1)
                {
                    break label0;
                }
                flag = flag1;
                if (acategory[0].id >= 0L)
                {
                    break label0;
                }
            }
            flag = true;
        }
        speculative = flag;
    }

    protected String getItemTitle(com.ebay.common.model.search.EbayCategoryHistogram.Category category)
    {
        if (SearchRefineFragment.isRefineCategoryHistoDisplayEnabledByDCS)
        {
            return category.toString();
        } else
        {
            return category.name;
        }
    }

    protected volatile String getItemTitle(Object obj)
    {
        return getItemTitle((com.ebay.common.model.search.EbayCategoryHistogram.Category)obj);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = super.getView(i, view, viewgroup);
        Object obj = (RefineOptionAdapter.ViewCache)view.getTag();
        viewgroup = (com.ebay.common.model.search.EbayCategoryHistogram.Category)getItem(((RefineOptionAdapter.ViewCache) (obj)).itemIdx);
        ((RefineOptionAdapter.ViewCache) (obj)).leftArrow.setVisibility(4);
        if (((com.ebay.common.model.search.EbayCategoryHistogram.Category) (viewgroup)).id == container.id)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            view.setPadding(25, 0, 0, 0);
        } else
        {
            view.setPadding(50, 0, 0, 0);
        }
        if (i != 0)
        {
            ((RefineOptionAdapter.ViewCache) (obj)).titleView.setTextColor(SearchRefineFragment.textHighlightColor);
            return view;
        }
        obj = ((RefineOptionAdapter.ViewCache) (obj)).titleView;
        if (speculative || ((com.ebay.common.model.search.EbayCategoryHistogram.Category) (viewgroup)).id < 0L)
        {
            i = primaryTextColorDisabled;
        } else
        {
            i = primaryTextColor;
        }
        ((TextView) (obj)).setTextColor(i);
        return view;
    }
}
