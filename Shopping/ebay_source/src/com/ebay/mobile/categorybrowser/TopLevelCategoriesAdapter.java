// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.categorybrowser;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import com.ebay.mobile.common.view.RecyclerContentAdapter;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.cards.DepartmentTitleViewHolder;
import com.ebay.mobile.home.cards.DepartmentTitleViewModel;
import com.ebay.nautilus.domain.data.EbayCategory;
import com.ebay.nautilus.domain.data.EbayCategoryNode;
import java.lang.ref.WeakReference;
import java.util.List;

// Referenced classes of package com.ebay.mobile.categorybrowser:
//            CategoryTileViewHolder, CategoryViewModel

public final class TopLevelCategoriesAdapter extends RecyclerContentAdapter
{
    protected static final class CategoryGridLayoutManager extends GridLayoutManager
    {

        public void smoothScrollToPosition(RecyclerView recyclerview, android.support.v7.widget.RecyclerView.State state, int i)
        {
            recyclerview = new GridSmoothScroller(recyclerview.getContext());
            recyclerview.setTargetPosition(i);
            startSmoothScroll(recyclerview);
        }


        protected CategoryGridLayoutManager(Context context, int i)
        {
            super(context, i);
        }
    }

    private class CategoryGridLayoutManager.GridSmoothScroller extends LinearSmoothScroller
    {

        final CategoryGridLayoutManager this$0;

        public PointF computeScrollVectorForPosition(int i)
        {
            return LinearLayoutManager.this.computeScrollVectorForPosition(i);
        }

        protected int getVerticalSnapPreference()
        {
            return -1;
        }

        public CategoryGridLayoutManager.GridSmoothScroller(Context context)
        {
            this$0 = CategoryGridLayoutManager.this;
            super(context);
        }
    }

    protected static final class CategoryGridSpanSizeLookup extends android.support.v7.widget.GridLayoutManager.SpanSizeLookup
    {

        private final WeakReference layoutManagerReference;
        private final int spanCount;

        public int getSpanSize(int i)
        {
            GridLayoutManager gridlayoutmanager;
            for (gridlayoutmanager = (GridLayoutManager)layoutManagerReference.get(); gridlayoutmanager == null || i != 0;)
            {
                return 1;
            }

            return Math.min(spanCount, gridlayoutmanager.getSpanCount());
        }

        protected CategoryGridSpanSizeLookup(GridLayoutManager gridlayoutmanager, int i)
        {
            layoutManagerReference = new WeakReference(gridlayoutmanager);
            spanCount = i;
        }
    }


    public static final int COLUMNS_1 = 1;
    public static final int COLUMNS_2 = 2;
    public static final int COLUMNS_3 = 3;
    public static final int VIEW_TYPE_CATEGORY = 1;
    public static final int VIEW_TYPE_DEPARTMENT_TITLE = 0;
    private final String title;

    public TopLevelCategoriesAdapter(Context context, String s)
    {
        super(context);
        title = s;
        addViewType(0, com/ebay/mobile/home/cards/DepartmentTitleViewHolder, 0x7f0300e9);
        addViewType(1, com/ebay/mobile/categorybrowser/CategoryTileViewHolder, 0x7f03002b);
        showTitle(true);
        setCategories(new EbayCategoryNode[0]);
    }

    public android.support.v7.widget.RecyclerView.LayoutManager createLayoutManager()
    {
        CategoryGridLayoutManager categorygridlayoutmanager = new CategoryGridLayoutManager((Context)contextReference.get(), getNumSpans());
        categorygridlayoutmanager.setSpanSizeLookup(new CategoryGridSpanSizeLookup(categorygridlayoutmanager, getNumSpans()));
        return categorygridlayoutmanager;
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

    public int getNumSpans()
    {
        while (isTablet || isLandscape) 
        {
            return 3;
        }
        return 2;
    }

    public void setCategories(EbayCategoryNode aebaycategorynode[])
    {
        int i = getPositionForViewType(0);
        Object obj;
        int k;
        if (i >= 0)
        {
            obj = (ViewModel)dataSet.get(i);
        } else
        {
            obj = null;
        }
        dataSet.clear();
        if (obj != null)
        {
            dataSet.add(obj);
        }
        k = aebaycategorynode.length;
        for (int j = 0; j < k; j++)
        {
            obj = aebaycategorynode[j];
            dataSet.add(new CategoryViewModel(1, ((EbayCategoryNode) (obj)).category, getOnClickListener(1)));
        }

        notifyDataSetChanged();
    }

    public void showTitle(boolean flag)
    {
        int i = getPositionForViewType(0);
        if (flag && i < 0)
        {
            dataSet.add(0, new DepartmentTitleViewModel(0, title, getOnClickListener(0)));
            notifyItemInserted(0);
        } else
        if (!flag && i >= 0)
        {
            dataSet.remove(i);
            notifyItemRemoved(i);
            return;
        }
    }
}
