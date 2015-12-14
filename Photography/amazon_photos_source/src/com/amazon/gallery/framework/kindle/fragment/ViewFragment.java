// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.PointF;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.Loader;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.ui.controller.androidviewcontroller.AndroidViewCompositeController;
import com.amazon.gallery.foundation.ui.controller.androidviewcontroller.AndroidViewController;
import com.amazon.gallery.foundation.utils.apilevel.Api;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.messaging.InvalidateDataEvent;
import com.amazon.gallery.foundation.utils.messaging.ItemChangeEvent;
import com.amazon.gallery.foundation.utils.messaging.MultiSelectModeCommand;
import com.amazon.gallery.framework.data.dao.SortTypeDao;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.data.model.TimelineModel;
import com.amazon.gallery.framework.gallery.metrics.LaunchTimeMetrics;
import com.amazon.gallery.framework.gallery.timeline.TimelineNavigator;
import com.amazon.gallery.framework.gallery.utils.SortHelper;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.gallery.widget.ItemViewFactory;
import com.amazon.gallery.framework.gallery.widget.MediaItemCoverViewFactory;
import com.amazon.gallery.framework.gallery.widget.MediaItemCursorAdapter;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.action.EditMediaItemAction;
import com.amazon.gallery.framework.kindle.activity.NativeGalleryActivity;
import com.amazon.gallery.framework.kindle.activity.OnSortingChangedListener;
import com.amazon.gallery.framework.kindle.amazon.ScreenModeManager;
import com.amazon.gallery.framework.kindle.androidviewcontrollers.ChooserController;
import com.amazon.gallery.framework.kindle.androidviewcontrollers.FreetimeController;
import com.amazon.gallery.framework.kindle.androidviewcontrollers.NavigationController;
import com.amazon.gallery.framework.kindle.androidviewcontrollers.ThisDayBannerController;
import com.amazon.gallery.framework.kindle.androidviewcontrollers.TimelineController;
import com.amazon.gallery.framework.kindle.metrics.customer.TimelineMetrics;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;
import com.amazon.gallery.framework.kindle.recyclerview.MosaicLayoutManager;
import com.amazon.gallery.framework.kindle.recyclerview.RecyclerAdapter;
import com.amazon.gallery.framework.kindle.timeline.TimelineNavigatorListImpl;
import com.amazon.gallery.framework.kindle.widget.BadgeableItemViewFactory;
import com.amazon.gallery.framework.kindle.widget.badgechecker.MediaItemBadgeChecker;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.thor.albums.AddToAlbumContextBar;
import com.amazon.gallery.thor.albums.AlbumPageTracker;
import com.amazon.gallery.thor.albums.AlbumsHelper;
import com.amazon.gallery.thor.albums.ListChildrenTask;
import com.amazon.gallery.thor.app.FeatureChecker;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.actions.ThorActionFactory;
import com.amazon.gallery.thor.app.activity.ThorActionBar;
import com.amazon.gallery.thor.app.androidviewcontrollers.SelectionController;
import com.amazon.gallery.thor.app.androidviewcontrollers.WhisperplayController;
import com.amazon.gallery.thor.app.ui.UiReadyExecutor;
import com.amazon.gallery.thor.app.ui.cab.GalleryContextBar;
import com.amazon.gallery.thor.app.ui.cab.MultiSelectTitleUpdater;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            AdapterFragment, StateFragment

public abstract class ViewFragment extends AdapterFragment
    implements android.content.SharedPreferences.OnSharedPreferenceChangeListener, com.amazon.gallery.framework.data.model.TimelineModel.ChangeListener, OnSortingChangedListener
{

    private static final Pair NO_RESTORE_SCROLL_STATE = new Pair(Integer.valueOf(-1), Integer.valueOf(-1));
    public static final String TAG = com/amazon/gallery/framework/kindle/fragment/ViewFragment.getName();
    private AlbumsHelper albumsHelper;
    protected MediaItemCoverViewFactory coverViewFactory;
    private boolean firstCursorLoadCompleted;
    protected SharedPreferences kindlePreferences;
    protected RecyclerAdapter mAdapter;
    protected GalleryContextBar mContextBar;
    private AndroidViewCompositeController mController;
    private LaunchTimeMetrics mLaunchTimeMetrics;
    protected android.support.v7.widget.RecyclerView.LayoutManager mLayoutManager;
    protected MediaItemBadgeChecker mMediaItemBadgeChecker;
    protected RecyclerView mRecyclerView;
    private SortHelper mSortHelper;
    TimelineModel timelineModel;
    TimelineNavigator timelineNavigator;
    protected ListView timelinebar;

    public ViewFragment()
    {
        firstCursorLoadCompleted = false;
    }

    private boolean checkLoadMoreItems(int i, int j, int k)
    {
label0:
        {
label1:
            {
                Object obj = ((NativeGalleryActivity)getActivity()).getMediaContentConfiguration();
                Tag tag = ((MediaContentConfiguration) (obj)).toViewDescriptor().getTag();
                if (!((MediaContentConfiguration) (obj)).toViewDescriptor().getCollectionType().equals(com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.DYNAMIC_ALBUM) || tag == null)
                {
                    break label0;
                }
                obj = AlbumPageTracker.getInstance();
                if (!((AlbumPageTracker) (obj)).isLoading() && j + i + 50 > k)
                {
                    if (((AlbumPageTracker) (obj)).getCurrentItems() >= ((AlbumPageTracker) (obj)).getTotalItems())
                    {
                        break label1;
                    }
                    ListChildrenTask.executeWithOffset(tag, ((AlbumPageTracker) (obj)).getCurrentItems());
                }
                return false;
            }
            return true;
        }
        return true;
    }

    private Pair getSavedScrollState()
    {
        if (getArguments() != null && getArguments().containsKey("START_POSITION"))
        {
            return new Pair(Integer.valueOf(getArguments().getInt("START_POSITION")), Integer.valueOf(getArguments().getInt("POSITION_OFFSET")));
        } else
        {
            return NO_RESTORE_SCROLL_STATE;
        }
    }

    private void onDrag(MotionEvent motionevent)
    {
        if (motionevent.getAction() == 2 && motionevent.getHistorySize() > 0)
        {
            float f = motionevent.getX() - motionevent.getHistoricalX(0);
            float f1 = motionevent.getY();
            float f2 = motionevent.getHistoricalY(0);
            if (Math.abs(f) > Math.abs(f1 - f2))
            {
                timelineNavigator.drag(f);
            }
        }
    }

    private void setupContextBar()
    {
        if (getArguments() != null && getArguments().getBoolean("add_to_album_chooser_mode"))
        {
            mContextBar = new AddToAlbumContextBar((NativeGalleryActivity)getActivity(), mFeatureChecker.getContextMenuResource());
        } else
        {
            mContextBar = new GalleryContextBar((NativeGalleryActivity)getActivity(), mFeatureChecker.getContextMenuResource(), new MultiSelectTitleUpdater(getActivity()));
        }
        ((BadgeableItemViewFactory)mViewFactory).setSelectionChecker(mContextBar);
        if (StateFragment.stateFragmentExists(getActivity()))
        {
            StateFragment statefragment = StateFragment.getAndRegisterInstance(getActivity());
            if (statefragment.hasSelectedItems())
            {
                mContextBar.restoreState(statefragment.getSelectedItems());
            }
        }
    }

    private AndroidViewCompositeController setupController()
    {
        NativeGalleryActivity nativegalleryactivity = (NativeGalleryActivity)getActivity();
        TimelineController timelinecontroller = new TimelineController(timelineNavigator);
        Object obj = new SelectionController(mContextBar, nativegalleryactivity.getFragmentController());
        WhisperplayController whisperplaycontroller = new WhisperplayController(nativegalleryactivity);
        NavigationController navigationcontroller = new NavigationController(nativegalleryactivity);
        boolean flag1 = false;
        boolean flag = false;
        if (getArguments() != null)
        {
            flag1 = getArguments().getBoolean("chooser_mode");
            flag = getArguments().getBoolean("add_to_album_chooser_mode");
        }
        if (flag1 || flag)
        {
            if (flag1)
            {
                obj = new ChooserController(nativegalleryactivity);
            }
            return new AndroidViewCompositeController(new AndroidViewController[] {
                whisperplaycontroller, obj, navigationcontroller
            });
        }
        if (mFeatureChecker.hasFreetimeActionBar())
        {
            return new AndroidViewCompositeController(new AndroidViewController[] {
                timelinecontroller, obj, new FreetimeController(nativegalleryactivity, (EditMediaItemAction)ThorActionFactory.createThorAction(nativegalleryactivity, com/amazon/gallery/framework/kindle/action/EditMediaItemAction), mFeatureChecker.hasSingleLayout()), whisperplaycontroller, navigationcontroller
            });
        } else
        {
            return new AndroidViewCompositeController(new AndroidViewController[] {
                timelinecontroller, obj, whisperplaycontroller, navigationcontroller, new ThisDayBannerController(nativegalleryactivity)
            });
        }
    }

    private void updateCoverPhoto()
    {
        ViewDescriptor viewdescriptor = contentConfiguration.toViewDescriptor();
        Tag tag = viewdescriptor.getTag();
        MediaItem mediaitem = (MediaItem)getAdapter().getItem(0);
        if (!mediaitem.getObjectId().equals(tag.getCustomCoverId()))
        {
            tag.setCustomCoverId(mediaitem.getObjectId());
            ((TagDao)getApplicationBean(Keys.TAG_DAO)).save(tag, true);
        }
        viewdescriptor.setSortingChanged(false);
    }

    protected boolean checkLoadMoreItems(LinearLayoutManager linearlayoutmanager)
    {
        int i = linearlayoutmanager.getChildCount();
        return checkLoadMoreItems(linearlayoutmanager.findFirstVisibleItemPosition(), i, linearlayoutmanager.getItemCount());
    }

    protected boolean checkLoadMoreItems(MosaicLayoutManager mosaiclayoutmanager)
    {
        int i = mosaiclayoutmanager.getChildCount();
        return checkLoadMoreItems(mosaiclayoutmanager.findFirstVisibleItemPosition(), i, mosaiclayoutmanager.getItemCount());
    }

    protected abstract PointF computeScrollVectorForPosition(int i);

    protected boolean configurationHasTimeline()
    {
        return contentConfiguration != null && contentConfiguration.toViewDescriptor().getTimeLineVisbility();
    }

    protected abstract RecyclerAdapter createAdapter();

    protected abstract android.support.v7.widget.RecyclerView.LayoutManager createLayoutManager();

    protected RecyclerAdapter createRecyclerAdapter(BaseAdapter baseadapter, BadgeableItemViewFactory badgeableitemviewfactory)
    {
        return new RecyclerAdapter(baseadapter, badgeableitemviewfactory);
    }

    protected abstract int getFirstCompletelyVisiblePosition();

    protected abstract int getLastVisiblePosition();

    protected abstract int getLayoutId();

    protected abstract int getOffsetForPosition(int i);

    public Pair getScrollState()
    {
        int i = getFirstCompletelyVisiblePosition();
        return new Pair(Integer.valueOf(i), Integer.valueOf(getOffsetForPosition(i)));
    }

    protected OnSortingChangedListener getSortingChangedListener()
    {
        return this;
    }

    protected abstract int getViewCacheSize();

    protected boolean hasTimeline()
    {
        return configurationHasTimeline();
    }

    public void initTimeline()
    {
        if (timelinebar != null)
        {
            (new AsyncTask() {

                final ViewFragment this$0;

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    timelineNavigator.init(timelinebar);
                    timelineNavigator.setTimelineClickListener(new com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineClickListener() {

                        final _cls4 this$1;

                        public void onTimeNavBarClick(int i, int j)
                        {
                            scrollToPosition(j);
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    });
                    return null;
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Void)obj);
                }

                protected void onPostExecute(Void void1)
                {
                    timelineNavigator.enableTimelineBar();
                }

            
            {
                this$0 = ViewFragment.this;
                super();
            }
            }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            mRecyclerView.setOnTouchListener(new android.view.View.OnTouchListener() {

                final ViewFragment this$0;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    onDrag(motionevent);
                    return false;
                }

            
            {
                this$0 = ViewFragment.this;
                super();
            }
            });
            timelineNavigator.setScreenHeight(getActivity().getResources().getDisplayMetrics().heightPixels);
        }
    }

    protected boolean isInNavBarDecorMode()
    {
        return true;
    }

    protected boolean isValidFragment()
    {
        ViewDescriptor viewdescriptor = contentConfiguration.toViewDescriptor();
        return viewdescriptor.getCollectionSize() >= 0 || viewdescriptor.getTag() == null;
    }

    public void onActivityCreated(Bundle bundle)
    {
        setupContextBar();
        mController = setupController();
        mAdapter.setOnClickListener(new android.view.View.OnClickListener() {

            final ViewFragment this$0;

            public void onClick(View view)
            {
                mController.onClick(view, ((android.support.v7.widget.RecyclerView.ViewHolder)view.getTag()).getPosition());
            }

            
            {
                this$0 = ViewFragment.this;
                super();
            }
        });
        mAdapter.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final ViewFragment this$0;

            public boolean onLongClick(View view)
            {
                if (mScreenModeManager.isFullScreen())
                {
                    exitFullScreen();
                }
                int i = ((android.support.v7.widget.RecyclerView.ViewHolder)view.getTag()).getPosition();
                boolean flag = mController.onLongClick(view, i);
                if (flag)
                {
                    mAdapter.notifyItemChanged(i);
                }
                return flag;
            }

            
            {
                this$0 = ViewFragment.this;
                super();
            }
        });
        mAdapter.setOnTouchListener(new android.view.View.OnTouchListener() {

            final ViewFragment this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                onDrag(motionevent);
                return false;
            }

            
            {
                this$0 = ViewFragment.this;
                super();
            }
        });
        super.onActivityCreated(bundle);
    }

    public boolean onBackPressed()
    {
        boolean flag = false;
        if (mContextBar.isContextBarActive())
        {
            GlobalMessagingBus.post(new MultiSelectModeCommand(false, com.amazon.gallery.foundation.utils.messaging.MultiSelectModeCommand.EntranceType.BACK));
            flag = true;
        }
        return flag;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        createMediaItemCursorAdapter();
        mSortHelper = new SortHelper((SortTypeDao)getApplicationBean(Keys.SORT_PREFERENCE_DAO), (ComponentProfiler)getApplicationBean(Keys.ENGAGEMENT_METRICS));
        mLaunchTimeMetrics = ((ThorGalleryApplication)getActivity().getApplication()).getLaunchTimeMetrics();
        coverViewFactory = new MediaItemCoverViewFactory(mLaunchTimeMetrics);
        kindlePreferences = getActivity().getSharedPreferences("galleryKindleSharedPrefs", 0);
        kindlePreferences.registerOnSharedPreferenceChangeListener(this);
        timelineModel = (TimelineModel)getApplicationBean(Keys.TIMELINE_DAO);
        timelineNavigator = new TimelineNavigatorListImpl(getActivity());
        ((TimelineNavigatorListImpl)timelineNavigator).setTimelineMetrics(new TimelineMetrics((Profiler)getApplicationBean(Keys.PROFILER)));
        if (contentConfiguration != null)
        {
            timelineNavigator.setViewDescriptor(contentConfiguration.toViewDescriptor());
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(getLayoutId(), viewgroup, false);
        mRecyclerView = (RecyclerView)layoutinflater.findViewById(0x7f0c0171);
        mRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final ViewFragment this$0;

            public void onGlobalLayout()
            {
                int i = getFirstVisiblePosition();
                if (getLastVisiblePosition() - i > 0)
                {
                    if (Api.isAtLeastJellyBean())
                    {
                        mRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    } else
                    {
                        mRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                    mLaunchTimeMetrics.setGridStatus(mGridStatus);
                }
            }

            
            {
                this$0 = ViewFragment.this;
                super();
            }
        });
        mLayoutManager = createLayoutManager();
        mMediaItemBadgeChecker = new MediaItemBadgeChecker();
        mMediaItemBadgeChecker.setSyncStateBadgingEnabled(kindlePreferences.getBoolean("coldBootStatus", false));
        mAdapter = createAdapter();
        timelinebar = (ListView)layoutinflater.findViewById(0x7f0c0172);
        if (hasTimeline())
        {
            initTimeline();
        }
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemViewCacheSize(getViewCacheSize());
        viewgroup = mRecyclerView.getItemAnimator();
        if (viewgroup != null)
        {
            viewgroup.setSupportsChangeAnimations(false);
        }
        return layoutinflater;
    }

    protected void onDataInvalidated(boolean flag)
    {
        super.onDataInvalidated(flag);
        getActivity().runOnUiThread(new Runnable() {

            final ViewFragment this$0;

            public void run()
            {
                mAdapter.notifyDataSetChanged();
            }

            
            {
                this$0 = ViewFragment.this;
                super();
            }
        });
    }

    public void onDestroy()
    {
        super.onDestroy();
        kindlePreferences.unregisterOnSharedPreferenceChangeListener(this);
        GlobalMessagingBus.unregister(this);
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mRecyclerView.swapAdapter(null, true);
    }

    public void onLoadFinished(Loader loader, Cursor cursor)
    {
        firstCursorLoadCompleted = true;
        if (hasTimeline() && timelineModel != null)
        {
            timelineModel.clearCached(contentConfiguration.getTimelineQuery());
            onTimelineChanged(timelineModel.get(contentConfiguration.getTimelineQuery()));
        }
        super.onLoadFinished(loader, cursor);
        cursor = contentConfiguration.toViewDescriptor();
        if (!isValidFragment())
        {
            getActivity().finish();
        } else
        {
            if (cursor.getTag() != null && cursor.hasSortingChanged() && cursor.getCollectionSize() > 0)
            {
                updateCoverPhoto();
            }
            if (cursor.hasCollectionTypeChanged())
            {
                scrollToPositionWithOffset(0, 0);
                cursor.setCollectionTypeChanged(false);
                return;
            }
            cursor = getSavedScrollState();
            int i = ((Integer)((Pair) (cursor)).first).intValue();
            if (i >= 0 && (!isPreload(loader) || i < 50))
            {
                setScrollState(i, ((Integer)((Pair) (cursor)).second).intValue());
                getArguments().putInt("START_POSITION", -1);
                getArguments().putInt("POSITION_OFFSET", 0);
                return;
            }
        }
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Cursor)obj);
    }

    protected void onNavigate(MenuItem menuitem)
    {
        super.onNavigate(menuitem);
        mContextBar.hide();
    }

    public void onPause()
    {
        super.onPause();
        mContextBar.onPause();
    }

    protected void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        GlobalMessagingBus.register(this);
    }

    public void onResume()
    {
        super.onResume();
        mContextBar.onResume();
        android.content.Intent intent = getActivity().getIntent();
        albumsHelper.onEnterAlbum(intent);
        FragmentActivity fragmentactivity = getActivity();
        ViewDescriptor viewdescriptor = contentConfiguration.toViewDescriptor();
        if (fragmentactivity != null && firstCursorLoadCompleted && (viewdescriptor == null || !viewdescriptor.hasCollectionTypeChanged()))
        {
            ((NativeGalleryActivity)getActivity()).updateNoContentOverlay(mAdapter.getItemCount());
        }
        if (albumsHelper.fromAddToAlbumIntent(intent))
        {
            albumsHelper.showSnackbar(intent, viewdescriptor.getTag());
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        StateFragment statefragment = StateFragment.getAndRegisterInstance(getActivity());
        if (mContextBar.isContextBarActive())
        {
            statefragment.setSelectedItems(mContextBar.getSelectables());
        } else
        {
            statefragment.clearSelectedItems();
        }
        super.onSaveInstanceState(bundle);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
    {
        if ("coldBootStatus".equals(s) && sharedpreferences.getBoolean(s, false))
        {
            mMediaItemBadgeChecker.setSyncStateBadgingEnabled(true);
            GlobalMessagingBus.post(new ItemChangeEvent());
        }
    }

    public void onSortingChanged(int i)
    {
        Object obj = mSortHelper.getSortType(i);
        contentConfiguration.setSortType(((com.amazon.gallery.framework.data.dao.MediaItemSortType) (obj)));
        ViewDescriptor viewdescriptor = contentConfiguration.toViewDescriptor();
        mSortHelper.trackSortMetric(contentConfiguration, ((com.amazon.gallery.framework.data.dao.MediaItemSortType) (obj)));
        mSortHelper.saveSortPreference(contentConfiguration, ((com.amazon.gallery.framework.data.dao.MediaItemSortType) (obj)));
        viewdescriptor.setFocusedIndex(0);
        viewdescriptor.setMediaItem(null);
        viewdescriptor.setSortingChanged(true);
        obj = contentConfiguration.toViewDescriptor().getTag();
        if (contentConfiguration.toViewDescriptor().getCollectionType().equals(com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.DYNAMIC_ALBUM) && obj != null)
        {
            AlbumPageTracker.getInstance().reset();
            ListChildrenTask.executeWithOffset(((Tag) (obj)), 0);
        }
        GlobalMessagingBus.post(new InvalidateDataEvent(true));
    }

    public void onTimelineChanged(List list)
    {
        timelineNavigator.onTimelineChanged(list);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        albumsHelper = new AlbumsHelper(getActivity().findViewById(0x7f0c0122));
    }

    protected void saveScrollState(Bundle bundle)
    {
        Pair pair = getScrollState();
        bundle.putInt("START_POSITION", ((Integer)pair.first).intValue());
        bundle.putInt("POSITION_OFFSET", ((Integer)pair.second).intValue());
        contentConfiguration.toViewDescriptor().setFocusedIndex(((Integer)pair.first).intValue());
        GLogger.d(TAG, "Saved scroll start: %d, offset: %d", new Object[] {
            pair.first, pair.second
        });
    }

    protected void scrollToPosition(int i)
    {
        if (Math.abs(getFirstVisiblePosition() - i) < 50)
        {
            LinearSmoothScroller linearsmoothscroller = new LinearSmoothScroller(mRecyclerView.getContext()) {

                final ViewFragment this$0;

                public PointF computeScrollVectorForPosition(int j)
                {
                    return ViewFragment.this.computeScrollVectorForPosition(j);
                }

                protected int getVerticalSnapPreference()
                {
                    return -1;
                }

            
            {
                this$0 = ViewFragment.this;
                super(context);
            }
            };
            linearsmoothscroller.setTargetPosition(i);
            mLayoutManager.startSmoothScroll(linearsmoothscroller);
            return;
        } else
        {
            scrollToPositionWithOffset(i, 0);
            return;
        }
    }

    protected abstract void scrollToPositionWithOffset(int i, int j);

    public void setContentConfiguration(MediaContentConfiguration mediacontentconfiguration)
    {
        super.setContentConfiguration(mediacontentconfiguration);
        if (mediacontentconfiguration != null && timelineNavigator != null)
        {
            timelineNavigator.setViewDescriptor(mediacontentconfiguration.toViewDescriptor());
        }
        if (!hasTimeline() && timelineNavigator != null)
        {
            onTimelineChanged(null);
        }
    }

    protected void setScrollState(int i, int j)
    {
        GLogger.d(TAG, "Scrolling to : %d, offset: %d", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j)
        });
        scrollToPositionWithOffset(i, j);
    }

    protected void setUpActionBar(final ThorActionBar thorActionBar, int i, int j, OnSortingChangedListener onsortingchangedlistener)
    {
        super.setUpActionBar(thorActionBar, i, j, onsortingchangedlistener);
        executor.execute(new Runnable() {

            final ViewFragment this$0;
            final ThorActionBar val$thorActionBar;

            public void run()
            {
                FragmentActivity fragmentactivity = getActivity();
                if (fragmentactivity == null)
                {
                    return;
                } else
                {
                    fragmentactivity.runOnUiThread(new Runnable() {

                        final _cls9 this$1;

                        public void run()
                        {
                            if (!thorActionBar.isDestroyed())
                            {
                                thorActionBar.updateHeaderOptions(contentConfiguration.toViewDescriptor(), null);
                                thorActionBar.viewStateChanged(contentConfiguration.toViewDescriptor());
                            }
                        }

            
            {
                this$1 = _cls9.this;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                this$0 = ViewFragment.this;
                thorActionBar = thoractionbar;
                super();
            }
        });
    }

    protected RecyclerAdapter setupAdapter(BaseAdapter baseadapter, ItemViewFactory itemviewfactory, BadgeableItemViewFactory badgeableitemviewfactory)
    {
        itemviewfactory.setLoadingStatusTracker(mGridStatus);
        badgeableitemviewfactory.setContext(getActivity());
        mMediaItemCursorAdapter.setViewFactory(badgeableitemviewfactory);
        mViewFactory = badgeableitemviewfactory;
        baseadapter = createRecyclerAdapter(baseadapter, badgeableitemviewfactory);
        baseadapter.setHasStableIds(true);
        baseadapter.registerAdapterDataObserver(new android.support.v7.widget.RecyclerView.AdapterDataObserver() {

            final ViewFragment this$0;

            public void onChanged()
            {
                FragmentActivity fragmentactivity = getActivity();
                ViewDescriptor viewdescriptor = contentConfiguration.toViewDescriptor();
                if (fragmentactivity != null && firstCursorLoadCompleted && (viewdescriptor == null || !viewdescriptor.hasCollectionTypeChanged()))
                {
                    ((NativeGalleryActivity)fragmentactivity).updateNoContentOverlay(mAdapter.getItemCount());
                }
            }

            
            {
                this$0 = ViewFragment.this;
                super();
            }
        });
        return baseadapter;
    }





}
