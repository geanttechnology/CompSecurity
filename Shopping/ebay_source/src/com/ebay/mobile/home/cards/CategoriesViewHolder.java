// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.nautilus.domain.data.UnifiedStream.Category;
import com.ebay.nautilus.domain.data.cos.base.Text;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home.cards:
//            CategoriesViewModel

public class CategoriesViewHolder extends ViewHolder
{

    private ViewGroup list;
    private TextView title;

    public CategoriesViewHolder(View view)
    {
        super(view);
        title = (TextView)itemView.findViewById(0x7f10005f);
        list = (ViewGroup)itemView.findViewById(0x7f100236);
        setFullSpan(true);
    }

    private boolean bindCategoryView(View view, Category category, int i)
    {
        view = (TextView)view.findViewById(i);
        if (view != null)
        {
            view.setText(category.name.content);
            view.setTag(0x7f10000d, category);
            view.setOnClickListener(this);
            return true;
        } else
        {
            return false;
        }
    }

    public static boolean isValidModel(ViewModel viewmodel, boolean flag, boolean flag1)
    {
        flag = true;
        if (!(viewmodel instanceof CategoriesViewModel))
        {
            return false;
        }
        viewmodel = (CategoriesViewModel)viewmodel;
        if (!isNotEmpty(new CharSequence[] {
    ((CategoriesViewModel) (viewmodel)).name
}) || ((CategoriesViewModel) (viewmodel)).categories.isEmpty())
        {
            flag = false;
        }
        return flag;
    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        if (viewmodel instanceof CategoriesViewModel)
        {
            viewmodel = (CategoriesViewModel)viewmodel;
            title.setText(itemView.getContext().getString(0x7f07019a, new Object[] {
                ((CategoriesViewModel) (viewmodel)).name
            }));
            LayoutInflater layoutinflater = LayoutInflater.from(itemView.getContext());
            list.removeAllViews();
            int k = ((CategoriesViewModel) (viewmodel)).categories.size();
            View view;
            for (int i = 0; i < k; list.addView(view))
            {
                view = layoutinflater.inflate(0x7f03008a, list, false);
                bindCategoryView(view, (Category)((CategoriesViewModel) (viewmodel)).categories.get(i), 0x7f100135);
                if (i == 0)
                {
                    View view1 = view.findViewById(0x7f10016b);
                    if (view1 != null)
                    {
                        view1.setVisibility(8);
                    }
                }
                int j = i + 1;
                i = j;
                if (j >= k)
                {
                    continue;
                }
                i = j;
                if (!bindCategoryView(view, (Category)((CategoriesViewModel) (viewmodel)).categories.get(j), 0x7f100137))
                {
                    continue;
                }
                j++;
                i = j;
                if (j >= k)
                {
                    continue;
                }
                i = j;
                if (bindCategoryView(view, (Category)((CategoriesViewModel) (viewmodel)).categories.get(j), 0x7f100139))
                {
                    i = j + 1;
                }
            }

        }
    }
}
