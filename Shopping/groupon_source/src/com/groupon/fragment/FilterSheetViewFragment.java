// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.f2prateek.dart.Dart;
import com.groupon.Channel;
import com.groupon.adapter.FilterAdapter;
import com.groupon.adapter.OnFilterSheetItemClickListener;
import com.groupon.events.ExpandFilterSheetEvent;
import com.groupon.events.FilterDataChangedLocallyEvent;
import com.groupon.events.ResetFilterSheetEvent;
import com.groupon.events.ResizeFilterSheetEvent;
import com.groupon.events.ToggleFilterSheetEvent;
import com.groupon.models.nst.SearchFilterExpansionExtraInfo;
import com.groupon.models.search.data.Facet;
import com.groupon.models.search.data.FacetValue;
import com.groupon.models.search.domain.FilterSheetPresenter;
import com.groupon.models.search.domain.FilterSheetView;
import com.groupon.models.search.domain.SortMethodWrapper;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.v3.fragment.GrouponNormalFragmentV3;
import com.groupon.view.ExpandableStickyListAnimator;
import com.squareup.otto.Bus;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;
import se.emilsjolander.stickylistheaders.ExpandableStickyListHeadersListView;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class FilterSheetViewFragment extends GrouponNormalFragmentV3
    implements FilterSheetView
{
    private abstract class CheckIfAddedBeforeRunningRunnable
        implements Runnable
    {

        final FilterSheetViewFragment this$0;

        public final void run()
        {
            if (!isAdded())
            {
                return;
            } else
            {
                runIfAdded();
                return;
            }
        }

        protected abstract void runIfAdded();

        private CheckIfAddedBeforeRunningRunnable()
        {
            this$0 = FilterSheetViewFragment.this;
            super();
        }

    }

    public static final class FilterListHeaderListener
        implements se.emilsjolander.stickylistheaders.StickyListHeadersListView.OnHeaderClickListener
    {

        private ExpandableStickyListHeadersListView filterList;
        private Logger logger;
        private FilterAdapter stickyHeaderListAdapter;

        public void onHeaderClick(StickyListHeadersListView stickylistheaderslistview, View view, int i, long l, boolean flag)
        {
            flag = filterList.isHeaderCollapsed(l);
            Logger logger1;
            com.groupon.tracking.mobile.EncodedNSTField encodednstfield;
            if (flag)
            {
                filterList.expand(l);
                filterList.postDelayed(i. new Runnable() {

                    final FilterListHeaderListener this$0;
                    final int val$itemPosition;

                    public void run()
                    {
                        filterList.smoothScrollToPositionFromTop(itemPosition, 0, 150);
                    }

            
            {
                this$0 = final_filterlistheaderlistener;
                itemPosition = I.this;
                super();
            }
                }, 100L);
            } else
            {
                filterList.collapse(l);
            }
            logger1 = logger;
            encodednstfield = Logger.NULL_NST_FIELD;
            if (flag)
            {
                stickylistheaderslistview = "expand";
            } else
            {
                stickylistheaderslistview = "collapse";
            }
            logger1.logClick("", "filter_click", "search", encodednstfield, new SearchFilterExpansionExtraInfo(stickylistheaderslistview, stickyHeaderListAdapter.getHeaderNiceName(i)));
            stickylistheaderslistview = stickyHeaderListAdapter;
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            stickylistheaderslistview.onHeaderToggled(l, view, flag, true);
        }


        public FilterListHeaderListener(Logger logger1, ExpandableStickyListHeadersListView expandablestickylistheaderslistview, FilterAdapter filteradapter)
        {
            logger = logger1;
            filterList = expandablestickylistheaderslistview;
            stickyHeaderListAdapter = filteradapter;
        }
    }

    public static interface ScrollableActivatedListener
    {

        public abstract void onScrollableActivated();
    }


    private static final String NST_CLOSE_BUTTON_TAP = "filtersheet_close_click";
    private static final String NST_FILTER_EXPANSION_CHANGED = "filter_click";
    private static final String PRESENTER = "PRESENTER";
    private static final int SCROLL_TO_POSITION_TIME_MS = 150;
    private Bundle adapterViewState;
    private Bus bus;
    protected Channel channel;
    protected ImageButton closeButton;
    protected TextView dealCount;
    int default_reset_text_color;
    protected ExpandableStickyListHeadersListView filterList;
    private FilterSheetPresenter filterSheetPresenter;
    protected LinearLayout filterSheetView;
    private Logger logger;
    private MenuItem menuItem;
    int modified_reset_text_color;
    protected ProgressBar progressBar;
    protected TextView resetButton;
    private ScrollableActivatedListener scrollableActivatedListener;
    protected String searchTerm;
    protected View shade;
    private FilterAdapter stickyHeaderListAdapter;

    public FilterSheetViewFragment()
    {
        setupFilterSheetPresenter();
    }

    private void ensureMainThread(Runnable runnable)
    {
        if (getActivity() == null)
        {
            return;
        } else
        {
            (new Handler(getActivity().getMainLooper())).post(runnable);
            return;
        }
    }

    public void forceReload()
    {
    }

    public FilterSheetPresenter getPresenter()
    {
        return filterSheetPresenter;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        scrollableActivatedListener = (ScrollableActivatedListener)activity;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        if (bundle != null)
        {
            filterSheetPresenter = (FilterSheetPresenter)bundle.getParcelable("PRESENTER");
            adapterViewState = bundle;
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        menu.add(0, 0x7f10000f, 0, getString(0x7f080451)).setIcon(0x7f02016c).setActionView(0x7f0300e0).setShowAsAction(2);
        ((RelativeLayout)menu.findItem(0x7f10000f).getActionView()).setOnClickListener(new android.view.View.OnClickListener() {

            final FilterSheetViewFragment this$0;

            public void onClick(View view)
            {
                bus.post(new ToggleFilterSheetEvent());
                filterSheetPresenter.filterButtonTapped(searchTerm, channel, logger);
            }

            
            {
                this$0 = FilterSheetViewFragment.this;
                super();
            }
        });
        menuItem = menu.findItem(0x7f10000f);
        super.onCreateOptionsMenu(menu, menuinflater);
        filterSheetPresenter.requestMenuItemUpdate();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f0300e1, viewgroup, false);
        ButterKnife.bind(this, layoutinflater);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        filterSheetPresenter.onDestroy();
        if (stickyHeaderListAdapter != null)
        {
            stickyHeaderListAdapter.setOnFilterSheetItemClickListener(null);
        }
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public void onFilterDataChangedLocally(FilterDataChangedLocallyEvent filterdatachangedlocallyevent)
    {
        if (stickyHeaderListAdapter != null)
        {
            stickyHeaderListAdapter.notifyDataSetChanged();
        }
        filterSheetPresenter.onSearchFilterDomainModelSyncCompleted();
    }

    public void onPause()
    {
        super.onPause();
        bus.unregister(this);
        filterSheetPresenter.pause();
    }

    public void onResetFilterSheetEvent(ResetFilterSheetEvent resetfiltersheetevent)
    {
        filterSheetPresenter.reset(logger, channel.toString());
    }

    public void onResizeFilterSheet(ResizeFilterSheetEvent resizefiltersheetevent)
    {
        int i = (int)resizefiltersheetevent.heightValue;
        resizefiltersheetevent = filterSheetView.getLayoutParams();
        resizefiltersheetevent.height = i;
        filterSheetView.setLayoutParams(resizefiltersheetevent);
    }

    public void onResume()
    {
        super.onResume();
        bus.register(this);
        filterSheetPresenter.resume(this);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("PRESENTER", filterSheetPresenter);
        if (stickyHeaderListAdapter != null)
        {
            stickyHeaderListAdapter.onSaveInstanceState(bundle);
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        RoboGuice.getInjector(getActivity()).injectMembers(this);
        Dart.inject(this);
        filterList.setOnScrollListener(new android.widget.AbsListView.OnScrollListener() {

            final FilterSheetViewFragment this$0;

            public void onScroll(AbsListView abslistview, int i, int j, int k)
            {
            }

            public void onScrollStateChanged(AbsListView abslistview, int i)
            {
                filterList.setOnScrollListener(null);
                scrollableActivatedListener.onScrollableActivated();
            }

            
            {
                this$0 = FilterSheetViewFragment.this;
                super();
            }
        });
        resetButton.setOnClickListener(new android.view.View.OnClickListener() {

            final FilterSheetViewFragment this$0;

            public void onClick(View view1)
            {
                filterSheetPresenter.reset(logger, channel.toString());
            }

            
            {
                this$0 = FilterSheetViewFragment.this;
                super();
            }
        });
        closeButton.setOnClickListener(new android.view.View.OnClickListener() {

            final FilterSheetViewFragment this$0;

            public void onClick(View view1)
            {
                logger.logClick("", "filtersheet_close_click", channel.toString(), Logger.NULL_NST_FIELD, Logger.NULL_NST_FIELD);
                bus.post(new ExpandFilterSheetEvent(false));
            }

            
            {
                this$0 = FilterSheetViewFragment.this;
                super();
            }
        });
        stickyHeaderListAdapter = null;
    }

    public void setDealCount(final int count)
    {
        ensureMainThread(new CheckIfAddedBeforeRunningRunnable() {

            final FilterSheetViewFragment this$0;
            final int val$count;

            public void runIfAdded()
            {
                dealCount.setText(getResources().getQuantityString(0x7f0c0022, count, new Object[] {
                    Integer.valueOf(count)
                }));
            }

            
            {
                this$0 = FilterSheetViewFragment.this;
                count = i;
                super();
            }
        });
    }

    public void setFilterCount(final int count)
    {
        ensureMainThread(new CheckIfAddedBeforeRunningRunnable() {

            final FilterSheetViewFragment this$0;
            final int val$count;

            public void runIfAdded()
            {
                TextView textview = (TextView)((RelativeLayout)menuItem.getActionView()).findViewById(0x7f10028c);
                if (count > 0)
                {
                    textview.setVisibility(0);
                    textview.setText(Strings.toString(Integer.valueOf(count)));
                    return;
                } else
                {
                    textview.setVisibility(8);
                    return;
                }
            }

            
            {
                this$0 = FilterSheetViewFragment.this;
                count = i;
                super();
            }
        });
    }

    public void setIsRefreshing(final boolean isRefreshing)
    {
        ensureMainThread(new CheckIfAddedBeforeRunningRunnable() {

            final FilterSheetViewFragment this$0;
            final boolean val$isRefreshing;

            public void runIfAdded()
            {
                boolean flag = false;
                Object obj = shade;
                int i;
                if (isRefreshing)
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                ((View) (obj)).setVisibility(i);
                obj = progressBar;
                if (isRefreshing)
                {
                    i = ((flag) ? 1 : 0);
                } else
                {
                    i = 8;
                }
                ((ProgressBar) (obj)).setVisibility(i);
            }

            
            {
                this$0 = FilterSheetViewFragment.this;
                isRefreshing = flag;
                super();
            }
        });
    }

    public void setUpAdapter(List list, List list1)
    {
        if (stickyHeaderListAdapter == null)
        {
            OnFilterSheetItemClickListener onfiltersheetitemclicklistener = new OnFilterSheetItemClickListener() {

                final FilterSheetViewFragment this$0;

                public void onFacetValueSelected(Facet facet, FacetValue facetvalue, boolean flag)
                {
                    filterSheetPresenter.facetValueSelectionChanged(logger, channel, searchTerm, facet, facetvalue, flag);
                }

                public void onSortMethodSelected(SortMethodWrapper sortmethodwrapper)
                {
                    filterSheetPresenter.sortValueSelected(logger, channel, searchTerm, sortmethodwrapper);
                }

            
            {
                this$0 = FilterSheetViewFragment.this;
                super();
            }
            };
            stickyHeaderListAdapter = new FilterAdapter(getActivity(), list, list1, onfiltersheetitemclicklistener);
            filterList.setAdapter(stickyHeaderListAdapter);
            filterList.setOnHeaderClickListener(new FilterListHeaderListener(logger, filterList, stickyHeaderListAdapter));
            int i = getResources().getDimensionPixelSize(0x7f0b00a4);
            filterList.setAnimExecutor(new ExpandableStickyListAnimator(i));
        } else
        {
            stickyHeaderListAdapter.setDataSet(list);
        }
        stickyHeaderListAdapter.notifyDataSetChanged();
        stickyHeaderListAdapter.onRestoreInstanceState(adapterViewState, filterList);
        for (list = stickyHeaderListAdapter.generateCollapsedIdList().iterator(); list.hasNext(); filterList.collapse(list1.longValue()))
        {
            list1 = (Long)list.next();
        }

    }

    public void setupFilterSheetPresenter()
    {
        filterSheetPresenter = new FilterSheetPresenter(this);
    }

    public void updateFacets(final List facets, final List sortMethods)
    {
        ensureMainThread(new CheckIfAddedBeforeRunningRunnable() {

            final FilterSheetViewFragment this$0;
            final List val$facets;
            final List val$sortMethods;

            public void runIfAdded()
            {
                setUpAdapter(facets, sortMethods);
            }

            
            {
                this$0 = FilterSheetViewFragment.this;
                facets = list;
                sortMethods = list1;
                super();
            }
        });
    }

    public void updateResetButtonState(boolean flag)
    {
        TextView textview = resetButton;
        int i;
        if (flag)
        {
            i = default_reset_text_color;
        } else
        {
            i = modified_reset_text_color;
        }
        textview.setTextColor(i);
        textview = resetButton;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        textview.setClickable(flag);
    }





}
