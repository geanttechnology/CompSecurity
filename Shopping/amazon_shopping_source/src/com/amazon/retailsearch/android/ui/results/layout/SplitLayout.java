// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.ui.HorizontalListView;
import com.amazon.retailsearch.android.ui.listadapter.ViewBuilderEntry;
import com.amazon.retailsearch.android.ui.listadapter.ViewEntry;
import com.amazon.retailsearch.android.ui.results.SplitProduct;
import com.amazon.retailsearch.metrics.impressions.AsinImpressionTracker;
import com.amazon.searchapp.retailsearch.model.CategoryCorrected;
import com.amazon.searchapp.retailsearch.model.DidYouMean;
import com.amazon.searchapp.retailsearch.model.FKMR;
import com.amazon.searchapp.retailsearch.model.Product;
import com.amazon.searchapp.retailsearch.model.RelatedSearches;
import com.amazon.searchapp.retailsearch.model.SpellCorrected;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            StackLayout, VerticalStackView, StackView, HorizontalStackView, 
//            UserState, ResultsController, LayoutElementModel

public class SplitLayout extends StackLayout
{
    private class HorizontalScrollListener
        implements com.amazon.retailsearch.android.ui.HorizontalListView.OnScrollListener
    {

        final SplitLayout this$0;

        public void onScroll(HorizontalListView horizontallistview, int i, int j, int k)
        {
            if (loaderScrollListener != null && horizontallistview != null)
            {
                loaderScrollListener.onScroll(horizontallistview, i, j, k);
            }
        }

        public void onScrollStateChanged(HorizontalListView horizontallistview, int i)
        {
            if (horizontallistview != null)
            {
                loadAtBottom(horizontallistview.getFirstVisiblePosition(), horizontallistview.getLastVisiblePosition());
                if (loaderScrollListener != null)
                {
                    loaderScrollListener.onScrollStateChanged(horizontallistview, i);
                }
            }
        }

        private HorizontalScrollListener()
        {
            this$0 = SplitLayout.this;
            super();
        }

    }


    private int asinEntryGroupIndex;
    private int dividerWidth;
    private Drawable horizontalDivider;
    private LinearLayout horizontalProgressBar;
    private HorizontalScrollListener horizontalScrollListener;
    private HorizontalStackView horizontalStackView;
    private boolean isProgressBarVisible;
    private Drawable verticalDivider;
    private LinearLayout verticalProgressBar;
    private VerticalStackView verticalStackView;

    public SplitLayout(ViewGroup viewgroup, ResourceProvider resourceprovider, AsinImpressionTracker asinimpressiontracker, int i)
    {
        super(viewgroup, 1, resourceprovider, asinimpressiontracker, com.amazon.retailsearch.R.dimen.rs_results_image_width_gallery, com.amazon.retailsearch.R.dimen.rs_results_image_height_gallery, com.amazon.retailsearch.R.integer.config_rs_atf_product_count_gallery);
        horizontalScrollListener = new HorizontalScrollListener();
        isProgressBarVisible = true;
        horizontalDivider = getContainer().getContext().getResources().getDrawable(com.amazon.retailsearch.R.drawable.rs_split_list_divider);
        verticalDivider = getContainer().getContext().getResources().getDrawable(com.amazon.retailsearch.R.drawable.rs_split_view_vertical_divider);
        dividerWidth = getContainer().getContext().getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_results_divider_line);
        asinEntryGroupIndex = i;
    }

    private VerticalStackView createVerticalStackView()
    {
        VerticalStackView verticalstackview = (VerticalStackView)LayoutInflater.from(getContainer().getContext()).inflate(com.amazon.retailsearch.R.layout.rs_vertical_stack_view, getContainer(), true).findViewById(com.amazon.retailsearch.R.id.rs_vertical_stack_view);
        verticalstackview.setBackgroundResource(com.amazon.retailsearch.R.drawable.rs_vertical_splitview_background);
        verticalstackview.setOnScrollListener(getScrollListener());
        verticalProgressBar = (LinearLayout)LayoutInflater.from(getContainer().getContext()).inflate(com.amazon.retailsearch.R.layout.rs_search_spinner, verticalstackview, false);
        if (!isProgressBarVisible)
        {
            verticalProgressBar.setVisibility(8);
        }
        verticalstackview.addFooterView(verticalProgressBar, null, false);
        return verticalstackview;
    }

    protected void add(ViewEntry viewentry, LayoutElementModel layoutelementmodel)
    {
    }

    protected void addCategoryCorrected(CategoryCorrected categorycorrected, int i)
    {
        if (i == asinEntryGroupIndex)
        {
            super.addCategoryCorrected(categorycorrected);
        }
    }

    protected void addDidYouMean(DidYouMean didyoumean)
    {
    }

    protected void addFkmr(FKMR fkmr, int i)
    {
        if (i == asinEntryGroupIndex)
        {
            super.addFkmr(fkmr);
        }
    }

    protected void addProductWrapper(Product product)
    {
        if (getEntryGroupIndex() == 0)
        {
            addProduct(product);
        }
    }

    protected void addRelatedSearches(RelatedSearches relatedsearches)
    {
    }

    protected void addSpellCorrected(SpellCorrected spellcorrected, int i)
    {
        if (i == asinEntryGroupIndex)
        {
            super.addSpellCorrected(spellcorrected);
        }
    }

    protected void addWordSplitter(SpellCorrected spellcorrected, int i)
    {
        if (i == asinEntryGroupIndex)
        {
            super.addWordSplitter(spellcorrected);
        }
    }

    public void changeOrientation(int i, UserState userstate)
    {
        super.changeOrientation(i, userstate);
        getStackView();
        if (stackView.getParent() == null)
        {
            getContainer().addView(stackView.getView());
        }
        if (getOrientation() == 2)
        {
            if (horizontalStackView != null)
            {
                horizontalStackView.getView().setVisibility(8);
            }
            verticalStackView.getView().setVisibility(0);
        } else
        {
            if (verticalStackView != null)
            {
                verticalStackView.getView().setVisibility(8);
            }
            horizontalStackView.getView().setVisibility(0);
        }
        stackView.setAdapter(getAdapter());
        update();
        if (userstate != null)
        {
            restoreUserState(userstate);
        }
    }

    protected HorizontalStackView createHorizontalStackView()
    {
        HorizontalStackView horizontalstackview = (HorizontalStackView)LayoutInflater.from(getContainer().getContext()).inflate(com.amazon.retailsearch.R.layout.rs_horizontal_stack_view, getContainer(), true).findViewById(com.amazon.retailsearch.R.id.rs_horizontal_stack_view);
        horizontalstackview.setBackgroundResource(com.amazon.retailsearch.R.drawable.rs_horizontal_stack_view_background);
        horizontalstackview.setOnScrollListener(horizontalScrollListener);
        horizontalProgressBar = (LinearLayout)LayoutInflater.from(getContainer().getContext()).inflate(com.amazon.retailsearch.R.layout.rs_search_spinner, horizontalstackview, false);
        if (!isProgressBarVisible)
        {
            horizontalProgressBar.setVisibility(8);
        }
        horizontalstackview.addFooterView(horizontalProgressBar, null, false);
        return horizontalstackview;
    }

    protected ViewBuilderEntry createProductCell(Product product)
    {
        return createContentView(16, com/amazon/retailsearch/android/ui/results/SplitProduct, createProductViewModel(product));
    }

    protected void detachViews()
    {
        if (verticalStackView != null)
        {
            if (verticalStackView.getParent() != null)
            {
                ((ViewGroup)verticalStackView.getParent()).removeView(verticalStackView.getView());
            }
            if (verticalStackView.getAdapter() != null)
            {
                verticalStackView.setAdapter(null);
            }
        }
        if (horizontalStackView != null)
        {
            if (horizontalStackView.getParent() != null)
            {
                ((ViewGroup)horizontalStackView.getParent()).removeView(horizontalStackView.getView());
            }
            if (horizontalStackView.getAdapter() != null)
            {
                horizontalStackView.setAdapter(null);
            }
        }
    }

    public void enable(UserState userstate)
    {
        setEntryGroupIndex(userstate.getEntryIndex());
        super.enable(userstate);
    }

    public int getEntryGroupIndex()
    {
        return asinEntryGroupIndex;
    }

    protected int getFirstVisibleItemPosition(View view)
    {
        boolean flag = false;
        int i;
        if (getOrientation() == 2)
        {
            i = super.getFirstVisibleItemPosition(view);
        } else
        {
            int j = stackView.getFirstVisiblePosition();
            i = view.getWidth() / 2;
            if (Math.abs(stackView.getChildAt(0).getLeft()) > i)
            {
                flag = true;
            }
            i = j;
            if (flag)
            {
                i = j;
                if (j < results.size() - 1)
                {
                    return j + 1;
                }
            }
        }
        return i;
    }

    protected LinearLayout getProgressBar()
    {
        if (verticalProgressBar == null)
        {
            return horizontalProgressBar;
        } else
        {
            return verticalProgressBar;
        }
    }

    protected StackView getStackView()
    {
        if (getOrientation() != 2) goto _L2; else goto _L1
_L1:
        if (verticalStackView == null)
        {
            verticalStackView = createVerticalStackView();
            verticalStackView.setDivider(horizontalDivider);
            verticalStackView.setDividerHeight(dividerWidth);
        }
        setStackView(verticalStackView);
_L4:
        return stackView;
_L2:
        if (getOrientation() == 1)
        {
            if (horizontalStackView == null)
            {
                horizontalStackView = createHorizontalStackView();
                horizontalStackView.setDivider(verticalDivider);
                horizontalStackView.setDividerWidth(dividerWidth);
            }
            setStackView(horizontalStackView);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void hideProgressBar()
    {
        isProgressBarVisible = false;
        if (verticalProgressBar != null)
        {
            verticalProgressBar.setVisibility(8);
        }
        if (horizontalProgressBar != null)
        {
            horizontalProgressBar.setVisibility(8);
        }
    }

    public void setEntryGroupIndex(int i)
    {
        asinEntryGroupIndex = i;
    }

    protected void showProgressBar()
    {
        isProgressBarVisible = true;
        if (verticalProgressBar != null)
        {
            verticalProgressBar.setVisibility(0);
        }
        if (horizontalProgressBar != null)
        {
            horizontalProgressBar.setVisibility(0);
        }
    }
}
