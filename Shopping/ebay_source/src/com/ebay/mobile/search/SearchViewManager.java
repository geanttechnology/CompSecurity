// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.style.AbsoluteSizeSpan;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.net.api.search.idealmodel.AdsListItem;
import com.ebay.common.net.api.search.idealmodel.SrpListItem;
import com.ebay.common.view.SearchCompositeRecyclerAdapter;
import com.ebay.mobile.util.AdUtil;
import com.ebay.mobile.widget.EbayScrollView;
import com.ebay.shared.ui.SearchRefinementSummary;
import java.util.ArrayList;
import java.util.List;

public final class SearchViewManager extends android.support.v7.widget.RecyclerView.OnScrollListener
    implements android.view.View.OnTouchListener, com.ebay.mobile.widget.EbayScrollView.OnScrollChangedListener
{

    private static final int HIDE_THRESHOLD = 20;
    public static final int SEARCH_ACTION_CLEAN_SEARCH = 0;
    public static final int SEARCH_ACTION_GENERAL_REFINE_CHANGE = 2;
    public static final int SEARCH_ACTION_SORT_CHANGE = 1;
    private View googleTextAdView;
    private int headerHeight;
    private boolean isUserScrolling;
    private final View listContainer;
    private final TextView noBarcodeMatchTextView;
    private final EbayScrollView noResultsContainer;
    private int numAdColumns;
    private int numGridColumns;
    private final View progressContainer;
    private final RecyclerView recyclerView;
    private final TextView refineSummaryTextView;
    private boolean refinementToolsVisible;
    private int scrollDirection;
    private SearchResultFragment.OnScrollEventListener scrollListener;
    private int scrolledDistance;
    private float touchPositionY;
    private final View view;

    public SearchViewManager(View view1, SearchResultFragment.OnScrollEventListener onscrolleventlistener)
    {
        scrollListener = null;
        isUserScrolling = false;
        scrollDirection = 0;
        refinementToolsVisible = true;
        scrolledDistance = 0;
        view = view1;
        progressContainer = view1.findViewById(0x7f1000ca);
        listContainer = view1.findViewById(0x7f1000d4);
        noResultsContainer = (EbayScrollView)view1.findViewById(0x7f100573);
        noBarcodeMatchTextView = (TextView)view1.findViewById(0x7f1005fa);
        refineSummaryTextView = (TextView)view1.findViewById(0x7f10053e);
        recyclerView = (RecyclerView)view1.findViewById(0x7f1005fb);
        view1 = view1.getContext();
        Resources resources = view1.getResources();
        numAdColumns = resources.getInteger(0x7f0c0002);
        numGridColumns = resources.getInteger(0x7f0c0003);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(numGridColumns, 1));
        view1.getTheme();
        scrollListener = onscrolleventlistener;
    }

    private void setNoResultsContainerHeight(int i)
    {
        headerHeight = i;
        View view1 = noResultsContainer.findViewById(0x7f100574);
        android.view.ViewGroup.LayoutParams layoutparams = view1.getLayoutParams();
        if (layoutparams.height != i)
        {
            layoutparams.height = i;
            view1.setLayoutParams(layoutparams);
        }
    }

    public void adsLoaded(com.ebay.common.net.api.search.SearchResultState.SearchAds searchads, android.view.View.OnClickListener onclicklistener)
    {
        Object obj = getListAdapter();
        if (obj == null)
        {
            return;
        }
        if (((SearchCompositeRecyclerAdapter) (obj)).getList(0).list.size() == 0)
        {
            int i = searchads.adsList.size();
            obj = noResultsContainer.findViewById(0x7f100561);
            ((View) (obj)).setVisibility(0);
            ((View) (obj)).findViewById(0x7f100562).setVisibility(0);
            AdUtil.renderAds(((View) (obj)), searchads.adsList, searchads.isProductListingAds, onclicklistener, numAdColumns, i, numGridColumns);
            return;
        }
        searchads = new AdsListItem(searchads);
        onclicklistener = new ArrayList();
        onclicklistener.add(searchads);
        searchads = ((SearchCompositeRecyclerAdapter) (obj)).newSection(0, null, onclicklistener, 1, 1, 1, 1);
        int j = ((SearchCompositeRecyclerAdapter) (obj)).getListCount();
        if (j > 1)
        {
            ((SearchCompositeRecyclerAdapter) (obj)).insert(searchads, j - 1);
            return;
        } else
        {
            ((SearchCompositeRecyclerAdapter) (obj)).add(searchads);
            return;
        }
    }

    public void barcodeSearchError(String s, int i)
    {
        listContainer.setVisibility(8);
        refineSummaryTextView.setVisibility(8);
        progressContainer.setVisibility(8);
        s = new StringBuilder(String.format(view.getContext().getString(0x7f070152), new Object[] {
            s
        }));
        s.append(System.getProperty("line.separator"));
        s.append(System.getProperty("line.separator"));
        s.append(view.getContext().getString(0x7f070153));
        noBarcodeMatchTextView.setText(s);
        noBarcodeMatchTextView.setVisibility(0);
        s = (android.widget.FrameLayout.LayoutParams)noBarcodeMatchTextView.getLayoutParams();
        if (((android.widget.FrameLayout.LayoutParams) (s)).topMargin != i)
        {
            s.topMargin = i;
            noBarcodeMatchTextView.setLayoutParams(s);
            noBarcodeMatchTextView.requestLayout();
        }
    }

    public Parcelable getGridState()
    {
        return recyclerView.getLayoutManager().onSaveInstanceState();
    }

    public SearchCompositeRecyclerAdapter getListAdapter()
    {
        return (SearchCompositeRecyclerAdapter)recyclerView.getAdapter();
    }

    public int getScrollPosition()
    {
        StaggeredGridLayoutManager staggeredgridlayoutmanager = (StaggeredGridLayoutManager)recyclerView.getLayoutManager();
        int ai[] = new int[2];
        staggeredgridlayoutmanager.findFirstVisibleItemPositions(ai);
        return ai[0];
    }

    public void googleTextAdLoaded(View view1)
    {
        Object obj = getListAdapter();
        if (obj == null)
        {
            return;
        }
        if (((SearchCompositeRecyclerAdapter) (obj)).getList(0).list.size() == 0)
        {
            obj = (LinearLayout)noResultsContainer.findViewById(0x7f100560);
            if (googleTextAdView != null)
            {
                ((LinearLayout) (obj)).removeView(googleTextAdView);
            }
            ((LinearLayout) (obj)).addView(view1);
            ((LinearLayout) (obj)).setVisibility(0);
            googleTextAdView = view1;
            return;
        }
        view1 = new AdsListItem(view1);
        int i = ((SearchCompositeRecyclerAdapter) (obj)).getListCount();
        if (i > 1)
        {
            com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section section = ((SearchCompositeRecyclerAdapter) (obj)).getList(i - 1);
            if (section.listType == 0)
            {
                SrpListItem srplistitem = (SrpListItem)section.list.get(0);
                if ((srplistitem instanceof AdsListItem) && ((AdsListItem)srplistitem).googleTextAdView != null)
                {
                    section.list.set(0, view1);
                    return;
                }
            }
        }
        ArrayList arraylist = new ArrayList();
        arraylist.add(view1);
        ((SearchCompositeRecyclerAdapter) (obj)).add(((SearchCompositeRecyclerAdapter) (obj)).newSection(0, null, arraylist, 1, 1, 1, 1));
    }

    public void onFragmentTimerTick()
    {
        SearchCompositeRecyclerAdapter searchcompositerecycleradapter = getListAdapter();
        StaggeredGridLayoutManager staggeredgridlayoutmanager = (StaggeredGridLayoutManager)recyclerView.getLayoutManager();
        int j = staggeredgridlayoutmanager.getChildCount();
        if (staggeredgridlayoutmanager.getChildAt(0) != null)
        {
            for (int i = 0; i < j; i++)
            {
                searchcompositerecycleradapter.onFragmentTimerTick(staggeredgridlayoutmanager.getChildAt(i));
            }

        }
    }

    public void onHeaderHeightUpdated(int i)
    {
        if (noResultsContainer.getVisibility() == 0)
        {
            setNoResultsContainerHeight(i);
        }
    }

    public void onScrollChanged(EbayScrollView ebayscrollview, int i, int j, int k, int l)
    {
        i = l - j;
        if (i < 0)
        {
            if (j >= headerHeight)
            {
                scrollListener.onScrollDown();
            }
        } else
        if (i >= 4)
        {
            scrollListener.onScrollUp();
            return;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerview, int i)
    {
        boolean flag;
        if (i != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isUserScrolling = flag;
    }

    public void onScrolled(RecyclerView recyclerview, int i, int j)
    {
        if (!isUserScrolling || scrollListener == null) goto _L2; else goto _L1
_L1:
        if (scrolledDistance <= 20 || !refinementToolsVisible) goto _L4; else goto _L3
_L3:
        if (((StaggeredGridLayoutManager)recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPositions(null)[0] > 1)
        {
            scrollListener.onScrollDown();
            refinementToolsVisible = false;
            scrolledDistance = 0;
        }
_L6:
        if (refinementToolsVisible && j > 0 || !refinementToolsVisible && j < 0)
        {
            scrolledDistance = scrolledDistance + j;
        }
_L2:
        return;
_L4:
        if (scrolledDistance < -20 && !refinementToolsVisible)
        {
            scrollListener.onScrollUp();
            refinementToolsVisible = true;
            scrolledDistance = 0;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean onTouch(View view1, MotionEvent motionevent)
    {
        if (isUserScrolling && motionevent.getAction() == 2)
        {
            scrollDirection = (int)(motionevent.getY() - touchPositionY);
        }
        touchPositionY = motionevent.getY();
        return false;
    }

    public void postGridViewRunnable(Runnable runnable)
    {
        recyclerView.post(runnable);
    }

    public void refinementsChanged()
    {
        listContainer.setVisibility(4);
        noResultsContainer.setVisibility(4);
        progressContainer.setVisibility(0);
        refineSummaryTextView.setVisibility(8);
    }

    public void refreshList(SearchCompositeRecyclerAdapter searchcompositerecycleradapter)
    {
        StaggeredGridLayoutManager staggeredgridlayoutmanager = (StaggeredGridLayoutManager)recyclerView.getLayoutManager();
        int i = staggeredgridlayoutmanager.findFirstVisibleItemPositions(null)[0];
        searchcompositerecycleradapter.notifyItemRangeChanged(i, (staggeredgridlayoutmanager.findLastVisibleItemPositions(null)[numGridColumns - 1] - i) + 1);
    }

    public void removeCallbacks(Runnable runnable)
    {
        recyclerView.removeCallbacks(runnable);
    }

    public void restoreGridState(Parcelable parcelable)
    {
        if (parcelable == null)
        {
            return;
        } else
        {
            recyclerView.getLayoutManager().onRestoreInstanceState(parcelable);
            return;
        }
    }

    public void searchComplete(int i, boolean flag, int j)
    {
        progressContainer.setVisibility(8);
        refineSummaryTextView.setVisibility(8);
        if (i > 0 || flag)
        {
            listContainer.setVisibility(0);
            recyclerView.setOnScrollListener(this);
            recyclerView.setOnTouchListener(this);
            return;
        } else
        {
            setNoResultsContainerHeight(j);
            noResultsContainer.setOnScrollViewListener(this);
            listContainer.setVisibility(4);
            noResultsContainer.setVisibility(0);
            return;
        }
    }

    public void searchError()
    {
        noBarcodeMatchTextView.setVisibility(8);
        refineSummaryTextView.setVisibility(8);
        progressContainer.setVisibility(8);
    }

    public void searchStarted(SearchParameters searchparameters)
    {
        recyclerView.setOnScrollListener(null);
        recyclerView.setOnTouchListener(null);
        noBarcodeMatchTextView.setVisibility(8);
        listContainer.setVisibility(4);
        noResultsContainer.setVisibility(4);
        noResultsContainer.setOnScrollViewListener(null);
        progressContainer.setVisibility(0);
        AbsoluteSizeSpan absolutesizespan = new AbsoluteSizeSpan((int)TypedValue.applyDimension(2, 12F, view.getResources().getDisplayMetrics()));
        searchparameters = SearchRefinementSummary.getRefinementsSummary(searchparameters, view.getResources(), absolutesizespan, view.getContext().getString(0x7f0705a9));
        refineSummaryTextView.setText(searchparameters);
        refineSummaryTextView.setVisibility(0);
    }

    public void setGridAdapter(SearchCompositeRecyclerAdapter searchcompositerecycleradapter)
    {
        recyclerView.setAdapter(searchcompositerecycleradapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(numGridColumns, 1));
        recyclerView.setVisibility(0);
    }

    public void setScrollPosition(int i)
    {
        SearchCompositeRecyclerAdapter searchcompositerecycleradapter = getListAdapter();
        if (searchcompositerecycleradapter != null)
        {
            i = Math.min(i, searchcompositerecycleradapter.getItemCount() - 1);
            ((StaggeredGridLayoutManager)recyclerView.getLayoutManager()).scrollToPosition(i);
        }
    }

    public void sortChanged(SearchParameters searchparameters)
    {
        searchStarted(searchparameters);
    }

    public void startGridViewAnimation(Animation animation)
    {
        recyclerView.startAnimation(animation);
    }
}
