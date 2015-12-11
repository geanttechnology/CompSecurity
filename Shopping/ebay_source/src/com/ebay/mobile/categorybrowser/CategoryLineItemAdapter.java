// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.categorybrowser;

import android.content.Context;
import com.ebay.mobile.common.view.RecyclerContentAdapter;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.nautilus.domain.data.EbayCategory;
import com.ebay.nautilus.domain.data.EbayCategoryNode;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.categorybrowser:
//            CategoryLineItemViewHolder, CategoryViewModel

public final class CategoryLineItemAdapter extends RecyclerContentAdapter
{

    public static final int VIEW_TYPE_LINE_ITEM = 3;
    public static final int VIEW_TYPE_LINE_ITEM_BRANCH = 4;
    public static final int VIEW_TYPE_NAVIGATION_BRANCH = 1;
    public static final int VIEW_TYPE_NAVIGATION_CURRENT = 2;
    public static final int VIEW_TYPE_NAVIGATION_ROOT = 0;
    public static final int VIEW_TYPE_PROGRESS_INDICATOR = 5;

    public CategoryLineItemAdapter(Context context)
    {
        super(context);
        addViewType(0, com/ebay/mobile/categorybrowser/CategoryLineItemViewHolder, 0x7f03002a);
        addViewType(1, com/ebay/mobile/categorybrowser/CategoryLineItemViewHolder, 0x7f030028);
        addViewType(2, com/ebay/mobile/categorybrowser/CategoryLineItemViewHolder, 0x7f030029);
        addViewType(4, com/ebay/mobile/categorybrowser/CategoryLineItemViewHolder, 0x7f030026);
        addViewType(3, com/ebay/mobile/categorybrowser/CategoryLineItemViewHolder, 0x7f030025);
        addViewType(5, com/ebay/mobile/categorybrowser/CategoryLineItemViewHolder, 0x7f030027);
    }

    public int findAdapterPositionByEbayCategoryId(long l)
    {
        int j = dataSet.size();
        for (int i = 0; i < j; i++)
        {
            ViewModel viewmodel = (ViewModel)dataSet.get(i);
            if ((viewmodel instanceof CategoryViewModel) && ((CategoryViewModel)viewmodel).category.id == l)
            {
                return i;
            }
        }

        return -1;
    }

    public int getItemCount()
    {
        return dataSet.size();
    }

    public void setBreadcrumbs(EbayCategory aebaycategory[])
    {
        int j = getPositionForViewType(2);
        int i = j;
        if (j == -1)
        {
            i = 0;
        }
        j = dataSet.size();
        if (i > 0 && i < j)
        {
            ArrayList arraylist = new ArrayList(dataSet.subList(i, dataSet.size() - 1));
            dataSet.clear();
            dataSet.addAll(arraylist);
            notifyItemRangeRemoved(0, i);
        }
        j = 0;
        while (j < aebaycategory.length) 
        {
            EbayCategory ebaycategory;
            byte byte0;
            if (j == aebaycategory.length - 1)
            {
                byte0 = 2;
            } else
            if (j == 0)
            {
                byte0 = 0;
            } else
            {
                byte0 = 1;
            }
            ebaycategory = aebaycategory[j];
            dataSet.add(j, new CategoryViewModel(byte0, ebaycategory, getOnClickListener(byte0)));
            j++;
        }
        notifyItemRangeInserted(0, aebaycategory.length);
    }

    public void setChildCategories(EbayCategoryNode aebaycategorynode[])
    {
        int j = getPositionForViewType(2);
        int i = dataSet.size();
        if (j >= 0 && j < i)
        {
            ArrayList arraylist = new ArrayList(dataSet.subList(0, j + 1));
            dataSet.clear();
            dataSet.addAll(arraylist);
            notifyItemRangeRemoved(j + 1, i - 1);
        }
        int k = aebaycategorynode.length;
        i = 0;
        while (i < k) 
        {
            EbayCategoryNode ebaycategorynode = aebaycategorynode[i];
            byte byte0;
            if (ebaycategorynode.category.isLeaf)
            {
                byte0 = 3;
            } else
            {
                byte0 = 4;
            }
            dataSet.add(new CategoryViewModel(byte0, ebaycategorynode.category, getOnClickListener(byte0)));
            i++;
        }
        notifyItemRangeInserted(j + 1, (aebaycategorynode.length - 1) + j);
    }

    public void setLoading(boolean flag)
    {
        if (flag)
        {
            int k = getPositionForViewType(2);
            int i = k;
            if (k == -1)
            {
                i = 0;
            }
            k = dataSet.size();
            if (i > 0 && i < k)
            {
                ArrayList arraylist = new ArrayList(dataSet.subList(0, i + 1));
                dataSet.clear();
                dataSet.addAll(arraylist);
                notifyItemRangeRemoved(i + 1, k - 1);
            }
            dataSet.add(new CategoryViewModel(5, null, null));
            notifyItemInserted(dataSet.size() - 1);
        } else
        {
            int j = getPositionForViewType(5);
            if (j > -1)
            {
                dataSet.remove(j);
                notifyItemRemoved(j);
                return;
            }
        }
    }
}
