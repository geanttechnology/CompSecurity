// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.util.Pair;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.InvalidateDataEvent;
import com.amazon.gallery.foundation.utils.messaging.ItemChangeEvent;
import com.amazon.gallery.foundation.utils.messaging.WhisperplayConnectionEvent;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.gallery.timeline.TimelineNavigator;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.gallery.widget.AndroidGalleryBadgeableCoverView;
import com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView;
import com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverViewProvider;
import com.amazon.gallery.framework.gallery.widget.GridItemViewFactory;
import com.amazon.gallery.framework.gallery.widget.ItemViewFactory;
import com.amazon.gallery.framework.gallery.widget.MediaItemProxyAdapter;
import com.amazon.gallery.framework.gallery.widget.ThisDayBannerViewFactory;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.BasicListActivity;
import com.amazon.gallery.framework.kindle.activity.CommonActivity;
import com.amazon.gallery.framework.kindle.amazon.ScreenModeManager;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;
import com.amazon.gallery.framework.kindle.recyclerview.BannerAwareRecyclerAdapter;
import com.amazon.gallery.framework.kindle.recyclerview.DividerItemDecorator;
import com.amazon.gallery.framework.kindle.recyclerview.GridSpacingItemDecorator;
import com.amazon.gallery.framework.kindle.recyclerview.RecyclerAdapter;
import com.amazon.gallery.framework.kindle.util.IntentUtil;
import com.amazon.gallery.framework.kindle.widget.BadgeableItemViewFactory;
import com.amazon.gallery.framework.kindle.widget.DividerViewFactory;
import com.amazon.gallery.thor.app.activity.ThorActionBar;
import com.amazon.gallery.thor.app.ui.UiReadyExecutor;
import com.amazon.gallery.thor.di.AppKeys;
import com.amazon.gallery.thor.thisday.ThisDayBannerLoaderFactory;
import com.amazon.gallery.thor.thisday.ThisDayMetricsHelper;
import com.amazon.gallery.thor.thisday.ThisDaySharedPrefsManager;
import com.amazon.gallery.whisperplay.WhisperPlayConnectionManager;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            ViewFragment

public class GridFragment extends ViewFragment
{

    private int boundingGridSize;
    private MediaItemProxyAdapter delegateBaseAdapter;
    private DividerItemDecorator dividerDecorator;
    private GridLayoutManager gridLayoutManager;
    private ThisDayMetricsHelper thisDayMetricsHelper;
    private ThisDaySharedPrefsManager thisDaySharedPrefsManager;

    public GridFragment()
    {
        boundingGridSize = 512;
    }

    private RecyclerAdapter initRecyclerAdapter(ItemViewFactory itemviewfactory, BadgeableItemViewFactory badgeableitemviewfactory)
    {
        delegateBaseAdapter.setGridItemCursorAdapter(mMediaItemCursorAdapter);
        DividerViewFactory dividerviewfactory = new DividerViewFactory(getActivity());
        dividerviewfactory.setBoundingSize(boundingGridSize);
        delegateBaseAdapter.setGridItemViewFactory(dividerviewfactory);
        ThisDayBannerViewFactory thisdaybannerviewfactory = new ThisDayBannerViewFactory();
        thisdaybannerviewfactory.setContext(getActivity());
        delegateBaseAdapter.setBannerViewFactory(thisdaybannerviewfactory);
        itemviewfactory = setupAdapter(delegateBaseAdapter, itemviewfactory, badgeableitemviewfactory);
        itemviewfactory.setViewFactory(com.amazon.gallery.framework.gallery.widget.GalleryBaseAdapter.ItemViewType.DIVIDER.ordinal(), dividerviewfactory);
        itemviewfactory.setViewFactory(com.amazon.gallery.framework.gallery.widget.GalleryBaseAdapter.ItemViewType.BANNER.ordinal(), thisdaybannerviewfactory);
        return itemviewfactory;
    }

    private boolean isInAddToAlbumChooserMode()
    {
        Bundle bundle = getArguments();
        return bundle != null && bundle.getBoolean("add_to_album_chooser_mode");
    }

    private void switchViewConfiguration(final boolean hasBanner)
    {
        delegateBaseAdapter.setHasBannerSupport(hasBanner);
        gridLayoutManager.setSpanSizeLookup(new android.support.v7.widget.GridLayoutManager.SpanSizeLookup() {

            final GridFragment this$0;
            final boolean val$hasBanner;

            public int getSpanSize(int i)
            {
                if (hasBanner && i == 0)
                {
                    return getResources().getInteger(0x7f0d0001);
                } else
                {
                    return 1;
                }
            }

            
            {
                this$0 = GridFragment.this;
                hasBanner = flag;
                super();
            }
        });
    }

    protected PointF computeScrollVectorForPosition(int i)
    {
        return gridLayoutManager.computeScrollVectorForPosition(i);
    }

    protected boolean configurationHasThisDayBanner()
    {
        return contentConfiguration != null && contentConfiguration.toViewDescriptor().getCollectionType() == com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.EVERYTHING && !IntentUtil.isChooser(getActivity().getIntent()) && !isInAddToAlbumChooserMode() && thisDaySharedPrefsManager.isBannerEnabled() && !StringUtils.isEmpty(thisDaySharedPrefsManager.getPrefetchedBannerData());
    }

    protected RecyclerAdapter createAdapter()
    {
        GridItemViewFactory griditemviewfactory = new GridItemViewFactory(getActivity().getApplicationContext(), coverViewFactory, (MediaItemDao)getApplicationBean(Keys.MEDIA_ITEM_DAO));
        griditemviewfactory.setBoundingSize(boundingGridSize);
        BadgeableItemViewFactory badgeableitemviewfactory = new BadgeableItemViewFactory(griditemviewfactory, mMediaItemBadgeChecker);
        badgeableitemviewfactory.setBadgeViewProvider(new GalleryBadgeableCoverViewProvider() {

            final GridFragment this$0;

            public GalleryBadgeableCoverView buildBadgeableCoverView(View view)
            {
                return new AndroidGalleryBadgeableCoverView(view);
            }

            
            {
                this$0 = GridFragment.this;
                super();
            }
        });
        return initRecyclerAdapter(griditemviewfactory, badgeableitemviewfactory);
    }

    protected android.support.v7.widget.RecyclerView.LayoutManager createLayoutManager()
    {
        gridLayoutManager = new GridLayoutManager(getActivity(), getResources().getInteger(0x7f0d0001), 1, false);
        return gridLayoutManager;
    }

    protected RecyclerAdapter createRecyclerAdapter(BaseAdapter baseadapter, BadgeableItemViewFactory badgeableitemviewfactory)
    {
        switchViewConfiguration(configurationHasThisDayBanner());
        return new BannerAwareRecyclerAdapter(delegateBaseAdapter, badgeableitemviewfactory);
    }

    public ListAdapter getAdapter()
    {
        return delegateBaseAdapter;
    }

    protected int getFirstCompletelyVisiblePosition()
    {
        return gridLayoutManager.findFirstCompletelyVisibleItemPosition();
    }

    public int getFirstVisiblePosition()
    {
        return ((GridLayoutManager)mLayoutManager).findFirstVisibleItemPosition();
    }

    protected int getLastVisiblePosition()
    {
        return gridLayoutManager.findLastVisibleItemPosition();
    }

    protected int getLayoutId()
    {
        return 0x7f030098;
    }

    public int getMediaItemIndex(int i)
    {
        return delegateBaseAdapter.getMediaItemIndex(i);
    }

    protected int getOffsetForPosition(int i)
    {
        View view = mLayoutManager.findViewByPosition(i);
        if (view == null)
        {
            return 0;
        } else
        {
            return view.getTop() % boundingGridSize + view.getPaddingTop();
        }
    }

    public Pair getScrollState()
    {
        int l = getFirstVisiblePosition();
        int k = getOffsetForPosition(l);
        int j = delegateBaseAdapter.getMediaItemIndex(l);
        int i = j;
        if (j < 0)
        {
            i = delegateBaseAdapter.getMediaItemIndex(l + 1);
        }
        return new Pair(Integer.valueOf(i), Integer.valueOf(k));
    }

    protected int getViewCacheSize()
    {
        return 8;
    }

    protected boolean isInNavBarDecorMode()
    {
        return false;
    }

    public void onCreate(Bundle bundle)
    {
        thisDaySharedPrefsManager = new ThisDaySharedPrefsManager(getActivity());
        delegateBaseAdapter = new MediaItemProxyAdapter((BeanAwareActivity)getActivity());
        thisDayMetricsHelper = new ThisDayMetricsHelper((Profiler)((BeanAwareActivity)getActivity()).getApplicationBean(Keys.PROFILER));
        super.onCreate(bundle);
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        if (!configurationHasThisDayBanner() || i != 0x7f0c0014)
        {
            return super.onCreateLoader(i, bundle);
        } else
        {
            return (new ThisDayBannerLoaderFactory(getActivity())).createLoader();
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        int i = getResources().getInteger(0x7f0d0001);
        boundingGridSize = BasicListActivity.calculateImageWidth(getActivity(), i, 0, getResources().getDimensionPixelSize(0x7f0a003c));
        layoutinflater = super.onCreateView(layoutinflater, viewgroup, bundle);
        dividerDecorator = new DividerItemDecorator(getActivity());
        dividerDecorator.setPokerSize((int)((float)boundingGridSize * 0.125F), (int)((float)boundingGridSize * 0.23F), getResources().getDimensionPixelSize(0x7f0a003c) * 2);
        mRecyclerView.addItemDecoration(dividerDecorator);
        mRecyclerView.addItemDecoration(new GridSpacingItemDecorator(getActivity(), i));
        mRecyclerView.setOnScrollListener(new android.support.v7.widget.RecyclerView.OnScrollListener() {

            private float cumulativeY;
            private boolean finished;
            final GridFragment this$0;

            public void onScrolled(RecyclerView recyclerview, int j, int k)
            {
                cumulativeY = cumulativeY + (float)k;
                timelineNavigator.onScroll(cumulativeY, recyclerview);
                if (!finished)
                {
                    finished = checkLoadMoreItems(gridLayoutManager);
                }
            }

            
            {
                this$0 = GridFragment.this;
                super();
                cumulativeY = 0.0F;
                finished = false;
            }
        });
        return layoutinflater;
    }

    protected void onDataInvalidated(boolean flag)
    {
        super.onDataInvalidated(flag);
        if (!hasTimeline()) goto _L2; else goto _L1
_L1:
        if (!timelineNavigator.isTimelineInitialized())
        {
            initTimeline();
        } else
        {
            timelineNavigator.enableTimelineBar();
        }
_L4:
        if (configurationHasThisDayBanner() && flag)
        {
            getLoaderManager().restartLoader(0x7f0c0014, null, this);
        }
        return;
_L2:
        timelineNavigator.disableTimelineBar();
        if (delegateBaseAdapter != null)
        {
            delegateBaseAdapter.notifyDataSetChanged();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onInvalidateDataEvent(InvalidateDataEvent invalidatedataevent)
    {
        onDataInvalidated(invalidatedataevent.isHardReset());
    }

    public void onItemChangeEvent(final ItemChangeEvent event)
    {
        if (mAdapter != null && getActivity() != null)
        {
            getActivity().runOnUiThread(new Runnable() {

                final GridFragment this$0;
                final ItemChangeEvent val$event;

                public void run()
                {
                    if (event.isSingleItemChange())
                    {
                        mAdapter.notifyItemChanged(event.getPosition());
                        return;
                    } else
                    {
                        mAdapter.notifyItemRangeChanged(0, mAdapter.getItemCount());
                        return;
                    }
                }

            
            {
                this$0 = GridFragment.this;
                event = itemchangeevent;
                super();
            }
            });
        }
    }

    public void onLoadFinished(Loader loader, Cursor cursor)
    {
        boolean flag = configurationHasThisDayBanner();
        if (flag)
        {
            Loader loader1 = getLoaderManager().getLoader(0x7f0c0014);
            if (loader1 == null || !loader1.isStarted())
            {
                getLoaderManager().restartLoader(0x7f0c0014, null, this);
            }
        }
        switchViewConfiguration(flag);
        if (flag && loader.getId() == 0x7f0c0014)
        {
            executor.onLoadFinished();
            if (cursor != null && cursor.getCount() > 0)
            {
                thisDayMetricsHelper.onShowThisDayBanner();
            }
            ((BannerAwareRecyclerAdapter)mAdapter).notifyBannerMetadataChanged(cursor);
            return;
        } else
        {
            super.onLoadFinished(loader, cursor);
            return;
        }
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Cursor)obj);
    }

    public void onSortingChanged(int i)
    {
        super.onSortingChanged(i);
        timelineNavigator.setHasSortChanged(true);
        timelineNavigator.hideTimelineNavigator(com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineEvent.AUTO_CLOSE);
    }

    public void onTimelineChanged(List list)
    {
        super.onTimelineChanged(list);
        delegateBaseAdapter.onTimelineChanged(list);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        if (configurationHasThisDayBanner())
        {
            getLoaderManager().initLoader(0x7f0c0014, null, this);
        }
    }

    public void onWhisperPlayConnectionEvent(WhisperplayConnectionEvent whisperplayconnectionevent)
    {
        WhisperPlayConnectionManager whisperplayconnectionmanager = null;
        if (whisperplayconnectionevent.deviceConnected)
        {
            whisperplayconnectionmanager = (WhisperPlayConnectionManager)getApplicationBean(AppKeys.WHISPER_PLAY_CONNECTION_MANAGER);
        }
        ((BadgeableItemViewFactory)mViewFactory).setActivePhotoChecker(whisperplayconnectionmanager);
    }

    protected void resetScreenMode()
    {
        com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode screenmode1 = com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.NORMAL_STABLE_OPAQUE_UI;
        if (!BuildFlavors.isGen5()) goto _L2; else goto _L1
_L1:
        com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode screenmode = com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.GRID_GEN5;
_L4:
        mScreenModeManager.setScreenMode(screenmode, getActivity(), false);
        if (mNavigationBar != null)
        {
            mNavigationBar.forceShow();
        }
        return;
_L2:
        screenmode = screenmode1;
        if (BuildFlavors.isFireOS4OrLater())
        {
            screenmode = screenmode1;
            if (((CommonActivity)getActivity()).isWhisperPlayModeEnabled())
            {
                screenmode = com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.NORMAL_OPAQUE_UI;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void scrollToPositionWithOffset(int i, int j)
    {
        gridLayoutManager.scrollToPositionWithOffset(i, j);
    }

    protected void setScrollState(int i, int j)
    {
        int k = delegateBaseAdapter.getGridItemIndexForLayoutFocus(i);
        GLogger.d(TAG, "Scrolling to : %d, offset: %d", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j)
        });
        scrollToPositionWithOffset(k, j);
    }

}
