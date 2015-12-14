// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.DebugAssert;
import com.amazon.gallery.foundation.utils.TimeTracker;
import com.amazon.gallery.foundation.utils.apilevel.Api;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.account.AccountChangeListener;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.gallery.widget.AndroidGalleryBadgeableCoverView;
import com.amazon.gallery.framework.gallery.widget.CollectionViewItemWidthCalculator;
import com.amazon.gallery.framework.gallery.widget.CoverViewInterface;
import com.amazon.gallery.framework.gallery.widget.DefaultGalleryTagCoverHelper;
import com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView;
import com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverViewProvider;
import com.amazon.gallery.framework.gallery.widget.GridStatus;
import com.amazon.gallery.framework.gallery.widget.ItemViewFactory;
import com.amazon.gallery.framework.gallery.widget.ShadowedItemFactory;
import com.amazon.gallery.framework.gallery.widget.TagGridItemViewFactory;
import com.amazon.gallery.framework.gallery.widget.TagListAdapter;
import com.amazon.gallery.framework.gallery.widget.ViewFactory;
import com.amazon.gallery.framework.kindle.AutoUploadNotification;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.amazon.ScreenModeManager;
import com.amazon.gallery.framework.kindle.ui.NoContentOverlay;
import com.amazon.gallery.framework.kindle.util.IntentUtil;
import com.amazon.gallery.framework.kindle.util.SavedTagsFragment;
import com.amazon.gallery.framework.kindle.widget.BadgeableItemViewFactory;
import com.amazon.gallery.framework.kindle.widget.badgechecker.TagBadgeChecker;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.thor.widget.AppCompatProgressDialog;
import com.aviary.android.feather.common.utils.IOUtils;
import in.srain.cube.views.GridViewWithHeaderAndFooter;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            BasicListActivity, GridActivityParams

public abstract class CollectionListActivity extends BasicListActivity
    implements AccountChangeListener
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent AlbumsViewAll;
        public static final MetricsEvent InCollectionLandscape;
        public static final MetricsEvent InCollectionPortrait;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/kindle/activity/CollectionListActivity$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            InCollectionPortrait = new MetricsEvent("InCollectionPortrait", 0);
            InCollectionLandscape = new MetricsEvent("InCollectionLandscape", 1);
            AlbumsViewAll = new MetricsEvent("AlbumsViewAll", 2);
            $VALUES = (new MetricsEvent[] {
                InCollectionPortrait, InCollectionLandscape, AlbumsViewAll
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }

    private abstract class RefreshAlbumAsyncTask extends AsyncTask
    {

        private AppCompatProgressDialog blockingPopup;
        final CollectionListActivity this$0;

        public void hideProgress()
        {
            if (blockingPopup != null)
            {
                blockingPopup.dismiss();
            }
        }

        protected final void onCancelled()
        {
            statusTracker.setForceShow(false);
            hideProgress();
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((List)obj);
        }

        protected final void onPostExecute(List list)
        {
            TimeTracker.log("loadTags.onPostExecute");
            listAdapter.setTags(list);
            statusTracker.setForceShow(false);
            hideProgress();
        }

        protected final void onPreExecute()
        {
            TimeTracker.log("loadTags.onPreExecute");
            statusTracker.setForceShow(true);
        }

        protected transient void onProgressUpdate(Integer ainteger[])
        {
            int i = ainteger[0].intValue();
            int j = ainteger[1].intValue();
            if (blockingPopup == null)
            {
                blockingPopup = (new com.amazon.gallery.thor.widget.AppCompatProgressDialog.Builder(CollectionListActivity.this)).setStyle(com.amazon.gallery.thor.widget.AppCompatProgressDialog.ProgressStyle.HORIZONTAL).setCancellable(false).setMax(j).show();
            }
            blockingPopup.updateProgress(i);
        }

        protected volatile void onProgressUpdate(Object aobj[])
        {
            onProgressUpdate((Integer[])aobj);
        }

        private RefreshAlbumAsyncTask()
        {
            this$0 = CollectionListActivity.this;
            super();
        }

    }

    private class ShowFolderBannerTask extends AsyncTask
    {

        final CollectionListActivity this$0;

        protected transient Long doInBackground(Void avoid[])
        {
            Cursor cursor;
            cursor = null;
            avoid = cursor;
            ContentResolver contentresolver = getContentResolver();
            avoid = cursor;
            android.net.Uri uri = com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.Tag.CONTENT_URI;
            avoid = cursor;
            String s = Integer.toString(TagType.FOLDER.ordinal());
            avoid = cursor;
            cursor = contentresolver.query(uri, new String[] {
                "COUNT(*) AS count"
            }, "type = ?", new String[] {
                s
            }, null);
            if (cursor == null)
            {
                break MISSING_BLOCK_LABEL_98;
            }
            avoid = cursor;
            if (!cursor.moveToFirst())
            {
                break MISSING_BLOCK_LABEL_98;
            }
            avoid = cursor;
            long l = cursor.getLong(0);
            IOUtils.closeSilently(cursor);
            return Long.valueOf(l);
            IOUtils.closeSilently(cursor);
            return Long.valueOf(0L);
            Exception exception;
            exception;
            IOUtils.closeSilently(avoid);
            throw exception;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onPostExecute(Long long1)
        {
            if (!isCancelled() && long1.longValue() > 0L)
            {
                GLogger.v(CollectionListActivity.TAG, "Showing folders banner", new Object[0]);
                foldersBanner.setVisibility(0);
            } else
            {
                GLogger.v(CollectionListActivity.TAG, "Could not find any folders or task was cancelled, hiding folders banner", new Object[0]);
                foldersBanner.setVisibility(8);
            }
            showFolderBannerTask = null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Long)obj);
        }

        private ShowFolderBannerTask()
        {
            this$0 = CollectionListActivity.this;
            super();
        }

    }


    private static final String TAG = com/amazon/gallery/framework/kindle/activity/CollectionListActivity.getName();
    protected BadgeableItemViewFactory badgeFactory;
    private RefreshAlbumAsyncTask currentRefreshTask;
    private RelativeLayout foldersBanner;
    protected TagListAdapter listAdapter;
    private ScreenModeManager screenModeManager;
    private AsyncTask showFolderBannerTask;
    private DefaultGalleryTagCoverHelper tagCoverHelper;
    private com.amazon.gallery.framework.model.tags.CommonTagProperty.Storage tagProperty;
    protected TagType tagType;

    public CollectionListActivity(GridActivityParams gridactivityparams)
    {
        super(gridactivityparams);
        currentRefreshTask = null;
        tagType = null;
    }

    private void addFoldersBanner()
    {
        Object obj = getIntent();
        boolean flag;
        if (((Intent) (obj)).hasExtra("tagType"))
        {
            obj = TagType.valueOf(((Intent) (obj)).getStringExtra("tagType"));
        } else
        {
            obj = getPersistedTagType();
        }
        foldersBanner = (RelativeLayout)LayoutInflater.from(this).inflate(0x7f030091, null, false);
        foldersBanner.setVisibility(8);
        ((TextView)foldersBanner.findViewById(0x7f0c0153)).setVisibility(0);
        foldersBanner.setOnClickListener(new android.view.View.OnClickListener() {

            final CollectionListActivity this$0;

            public void onClick(View view)
            {
                startActivity(IntentUtil.getCollectionListIntent(TagType.FOLDER));
            }

            
            {
                this$0 = CollectionListActivity.this;
                super();
            }
        });
        ((GridViewWithHeaderAndFooter)listView).addFooterView(foldersBanner);
        if (obj == TagType.ALBUM)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        showFoldersBanner(flag);
    }

    private TagType getPersistedTagType()
    {
        if (photosDemoManager.isInDemoMode())
        {
            return TagType.LOCAL_FOLDER;
        } else
        {
            return TagType.ALBUM;
        }
    }

    private com.amazon.gallery.framework.gallery.widget.TagListAdapter.SortType loadSortType()
    {
        return com.amazon.gallery.framework.gallery.widget.TagListAdapter.SortType.valueOf(getSharedPreferences("galleryKindleSharedPrefs", 0).getString(com/amazon/gallery/framework/gallery/widget/TagListAdapter$SortType.getSimpleName(), com.amazon.gallery.framework.gallery.widget.TagListAdapter.SortType.DATE_DESC.toString()));
    }

    private void openCameraPhoto()
    {
        Intent intent = new Intent(this, getLauncherActivityClass());
        intent.putExtra("mediaTag", getIntent().getSerializableExtra("mediaTag"));
        intent.putExtra("mediaItem", getIntent().getSerializableExtra("openCameraPhoto"));
        getIntent().putExtra("openCameraPhoto", (String)null);
        startPhotosIntent(intent);
    }

    private void persistTagType()
    {
    }

    private void reloadAlbumsAsync(TagProperty tagproperty)
    {
        if (currentRefreshTask != null && !currentRefreshTask.getStatus().equals(android.os.AsyncTask.Status.FINISHED))
        {
            currentRefreshTask.cancel(true);
        }
        currentRefreshTask = (RefreshAlbumAsyncTask)(new RefreshAlbumAsyncTask() {

            final CollectionListActivity this$0;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((TagProperty[])aobj);
            }

            protected transient List doInBackground(TagProperty atagproperty[])
            {
                TimeTracker.log("loadTags.started");
                atagproperty = listAdapter.loadTags(atagproperty[0]);
                TimeTracker.log("loadTags.finished");
                return atagproperty;
            }

            
            {
                this$0 = CollectionListActivity.this;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new TagProperty[] {
            tagproperty
        });
    }

    private void saveSortType(com.amazon.gallery.framework.gallery.widget.TagListAdapter.SortType sorttype)
    {
        getSharedPreferences("galleryKindleSharedPrefs", 0).edit().putString(com/amazon/gallery/framework/gallery/widget/TagListAdapter$SortType.getSimpleName(), sorttype.toString()).apply();
    }

    private boolean setTagType(TagType tagtype, List list)
    {
        boolean flag = false;
        if (tagType == tagtype)
        {
            return true;
        }
        if (photosDemoManager.isInDemoMode() && tagtype != TagType.LOCAL_FOLDER)
        {
            photosDemoManager.showWarningForUnavailableAction(this);
            return false;
        }
        updateView(tagtype);
        com.amazon.gallery.framework.model.tags.CommonTagProperty.Storage storage;
        if (tagtype == TagType.LOCAL_FOLDER)
        {
            storage = com.amazon.gallery.framework.model.tags.CommonTagProperty.Storage.LOCAL;
        } else
        {
            storage = com.amazon.gallery.framework.model.tags.CommonTagProperty.Storage.CLOUD;
        }
        getIntent().putExtra("tagType", tagtype.toString());
        tagType = tagtype;
        updateTagProperty(storage, list);
        if (tagtype == TagType.ALBUM)
        {
            flag = true;
        }
        showFoldersBanner(flag);
        return true;
    }

    private void showFoldersBanner(boolean flag)
    {
        if (flag)
        {
            if (showFolderBannerTask == null)
            {
                showFolderBannerTask = (new ShowFolderBannerTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
            return;
        }
        if (showFolderBannerTask != null)
        {
            showFolderBannerTask.cancel(true);
        }
        GLogger.v(TAG, "Hiding folders banner", new Object[0]);
        foldersBanner.setVisibility(8);
    }

    private void updateTagProperty(com.amazon.gallery.framework.model.tags.CommonTagProperty.Storage storage, List list)
    {
        tagProperty = storage;
        listAdapter.onDestroy();
        listAdapter.init(storage, tagType, list);
        if (list == null)
        {
            reloadAlbumsAsync(storage);
        }
        if (storage == TagProperty.CLOUD)
        {
            storage = com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode.CLOUD;
        } else
        {
            storage = com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode.DEVICE;
        }
        noContentOverlay.setNoContentMode(storage);
    }

    public int calculateImageWidth(Context context)
    {
        return tagCoverHelper.getTagItemWidthCalculator().calculateItemWidth(this, getResources().getInteger(0x7f0d0000), getResources().getDimensionPixelSize(0x7f0a0037), getResources().getDimensionPixelSize(0x7f0a0033));
    }

    protected BaseAdapter getListAdapter()
    {
        return listAdapter;
    }

    public boolean getLocalView()
    {
        while (tagType == null || tagType != TagType.LOCAL_FOLDER) 
        {
            return false;
        }
        return true;
    }

    protected Enum getOpenEvent()
    {
        if (getResources().getConfiguration().orientation == 1)
        {
            return MetricsEvent.InCollectionPortrait;
        } else
        {
            return MetricsEvent.InCollectionLandscape;
        }
    }

    public SavedTagsFragment getSavedTagsFragment()
    {
        FragmentManager fragmentmanager = getSupportFragmentManager();
        SavedTagsFragment savedtagsfragment1 = (SavedTagsFragment)fragmentmanager.findFragmentByTag(SavedTagsFragment.TAG);
        SavedTagsFragment savedtagsfragment = savedtagsfragment1;
        if (savedtagsfragment1 == null)
        {
            savedtagsfragment = new SavedTagsFragment();
            fragmentmanager.beginTransaction().add(savedtagsfragment, SavedTagsFragment.TAG).commit();
        }
        return savedtagsfragment;
    }

    protected Class getSettingsIntent()
    {
        return activityParams.settingsActivityClass;
    }

    protected void initGridItemViewFactory()
    {
        BadgeableItemViewFactory badgeableitemviewfactory = new BadgeableItemViewFactory(new TagGridItemViewFactory(getApplicationContext(), tagCoverHelper.getTagCoverViewFactory(), (MediaItemDao)getApplicationBean(Keys.MEDIA_ITEM_DAO)), new TagBadgeChecker((NetworkConnectivity)getApplicationBean(Keys.NETWORK_CONNECTIVITY)));
        badgeableitemviewfactory.setEqualityCheck(new com.amazon.gallery.framework.gallery.widget.ViewFactory.VisibleEqualityCheck() {

            final CollectionListActivity this$0;

            public boolean visiblyEqual(Tag tag, Tag tag1)
            {
                return tag != null && tag.visiblyEqual(tag1);
            }

            public volatile boolean visiblyEqual(Object obj, Object obj1)
            {
                return visiblyEqual((Tag)obj, (Tag)obj1);
            }

            
            {
                this$0 = CollectionListActivity.this;
                super();
            }
        });
        ItemViewFactory itemviewfactory = badgeableitemviewfactory.getBaseFactory();
        badgeableitemviewfactory.setContext(this);
        itemviewfactory.setLoadingStatusTracker(statusTracker);
        itemViewFactory = badgeableitemviewfactory;
        badgeFactory = badgeableitemviewfactory;
    }

    protected void initListAdapter()
    {
        listAdapter = new TagListAdapter();
        listAdapter.setSortType(loadSortType());
        listAdapter.setTagDao(tagDao);
        int i = calculateImageWidth(this);
        badgeFactory.setBadgeViewProvider(new GalleryBadgeableCoverViewProvider() {

            final CollectionListActivity this$0;

            public GalleryBadgeableCoverView buildBadgeableCoverView(View view)
            {
                return new AndroidGalleryBadgeableCoverView(view);
            }

            
            {
                this$0 = CollectionListActivity.this;
                super();
            }
        });
        if (tagCoverHelper.isItemShadowRequired())
        {
            badgeFactory.getBaseFactory().setBoundingSize(i);
            ShadowedItemFactory shadoweditemfactory = new ShadowedItemFactory();
            shadoweditemfactory.setChildFactory(itemViewFactory);
            shadoweditemfactory.setContext(this);
            listAdapter.setViewFactory(shadoweditemfactory);
            return;
        } else
        {
            badgeFactory.getBaseFactory().setBoundingSize(i, tagCoverHelper.getBottomOffsetForBadges(this) + i);
            listAdapter.setViewFactory(itemViewFactory);
            addFoldersBanner();
            return;
        }
    }

    protected void initPipelineFactory()
    {
        tagCoverHelper = new DefaultGalleryTagCoverHelper(this);
    }

    public void onAccountDeregistered()
    {
        runOnUiThread(new Runnable() {

            final CollectionListActivity this$0;

            public void run()
            {
                if (listAdapter != null && tagProperty != null)
                {
                    listAdapter.onDestroy();
                    listAdapter.init(tagProperty, tagType, null);
                }
            }

            
            {
                this$0 = CollectionListActivity.this;
                super();
            }
        });
    }

    public void onAccountRegistered()
    {
    }

    protected void onClick(View view, int i)
    {
label0:
        {
            view = (Tag)listAdapter.getItem(i);
            if (view != null)
            {
                if (BuildFlavors.isAosp() || !view.hasProperty(TagProperty.CAMERA))
                {
                    break label0;
                }
                launchCollectionViewActivity(CommonMediaProperty.CAMERA);
            }
            return;
        }
        launchCollectionViewActivity(view);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        screenModeManager = (ScreenModeManager)getApplicationBean(Keys.SCREEN_MODE_MANAGER);
        screenModeManager.setScreenMode(com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.NORMAL_OPAQUE_UI, this);
        bundle = getIntent();
        if (bundle.hasExtra("tagType"))
        {
            bundle = TagType.valueOf(bundle.getStringExtra("tagType"));
        } else
        {
            bundle = getPersistedTagType();
        }
        setTagType(bundle, getSavedTagsFragment().getSavedTags());
        listAdapter.registerDataSetObserver(new DataSetObserver() {

            final CollectionListActivity this$0;

            public void onChanged()
            {
                updateNoContentOverlay();
            }

            
            {
                this$0 = CollectionListActivity.this;
                super();
            }
        });
        if (Api.isAtLeastLollipop())
        {
            listView.setNestedScrollingEnabled(true);
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        listAdapter.onDestroy();
        itemViewFactory.reset();
        if (currentRefreshTask != null)
        {
            currentRefreshTask.hideProgress();
        }
    }

    public void onPause()
    {
        super.onPause();
        persistTagType();
        getApplicationBeanFactory().putBean(Keys.CURRENT_COLLECTION_ACTIVITY, null);
        tagCoverHelper.getTagCoverViewFactory().onActivityPaused();
        if (showFolderBannerTask != null)
        {
            showFolderBannerTask.cancel(true);
            showFolderBannerTask = null;
        }
    }

    public void onResume()
    {
        super.onResume();
        Object obj = getIntent();
        if (ftueLaunched)
        {
            return;
        }
        if (getIntent().getSerializableExtra("openCameraPhoto") != null)
        {
            openCameraPhoto();
            return;
        }
        listAdapter.setSortType(loadSortType());
        tagCoverHelper.getTagCoverViewFactory().onActivityResumed();
        if (((Intent) (obj)).hasExtra("tagType"))
        {
            obj = TagType.valueOf(((Intent) (obj)).getStringExtra("tagType"));
        } else
        {
            obj = getPersistedTagType();
        }
        setTagType(((TagType) (obj)));
        if (getSharedPreferences("galleryKindleSharedPrefs", 0).getBoolean("com.amazon.photos.account_state_changed", false))
        {
            updateTagProperty(tagProperty, null);
            getSharedPreferences("galleryKindleSharedPrefs", 0).edit().putBoolean("com.amazon.photos.account_state_changed", false).apply();
        }
        getApplicationBeanFactory().putBean(Keys.CURRENT_COLLECTION_ACTIVITY, this);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        getSavedTagsFragment().setSavedTags(listAdapter.getTags());
    }

    protected void recordOnResumeMetrics()
    {
        GLogger.v(TAG, "Recording metric for view of [tagType: %s]", new Object[] {
            tagType.name()
        });
        static class _cls10
        {

            static final int $SwitchMap$com$amazon$gallery$framework$gallery$widget$TagListAdapter$SortType[];
            static final int $SwitchMap$com$amazon$gallery$framework$model$tags$TagType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$gallery$widget$TagListAdapter$SortType = new int[com.amazon.gallery.framework.gallery.widget.TagListAdapter.SortType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$widget$TagListAdapter$SortType[com.amazon.gallery.framework.gallery.widget.TagListAdapter.SortType.DATE_DESC.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$widget$TagListAdapter$SortType[com.amazon.gallery.framework.gallery.widget.TagListAdapter.SortType.NAME_ASC.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                $SwitchMap$com$amazon$gallery$framework$model$tags$TagType = new int[TagType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$tags$TagType[TagType.SOURCE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$tags$TagType[TagType.FOLDER.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$tags$TagType[TagType.LOCAL_FOLDER.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$tags$TagType[TagType.ALBUM.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls10..SwitchMap.com.amazon.gallery.framework.model.tags.TagType[tagType.ordinal()])
        {
        default:
            return;

        case 4: // '\004'
            albumsProfiler.trackEvent(com.amazon.gallery.thor.albums.AlbumsMetricsHelper.MetricsEvent.PhotoAlbumsViewAll);
            break;
        }
    }

    public void setActivityContentView()
    {
        setContentView(0x7f030078);
    }

    protected boolean setTagType(TagType tagtype)
    {
        return setTagType(tagtype, null);
    }

    protected void setupNoContentOverlay()
    {
        super.setupNoContentOverlay();
        com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode contentmode;
        if (tagProperty == TagProperty.CLOUD)
        {
            contentmode = com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode.CLOUD;
        } else
        {
            contentmode = com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode.DEVICE;
        }
        noContentOverlay.setNoContentMode(contentmode);
    }

    protected void sortAlbums(com.amazon.gallery.framework.gallery.widget.TagListAdapter.SortType sorttype)
    {
        saveSortType(sorttype);
        (new RefreshAlbumAsyncTask() {

            final CollectionListActivity this$0;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((com.amazon.gallery.framework.gallery.widget.TagListAdapter.SortType[])aobj);
            }

            protected transient List doInBackground(com.amazon.gallery.framework.gallery.widget.TagListAdapter.SortType asorttype[])
            {
                return listAdapter.sort(asorttype[0]);
            }

            
            {
                this$0 = CollectionListActivity.this;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new com.amazon.gallery.framework.gallery.widget.TagListAdapter.SortType[] {
            sorttype
        });
    }

    protected void updateNoContentOverlay()
    {
        boolean flag1;
        flag1 = true;
        if (!isActivityResumed())
        {
            return;
        }
        boolean flag;
        if (listAdapter.getTags() != Collections.EMPTY_LIST)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!listAdapter.isEmpty() || !flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (noContentOverlay != null)
        {
            showFoldersBanner(false);
            noContentOverlay.showNoContentMode(400L);
        }
        this;
        JVM INSTR monitorexit ;
_L4:
        itemViewFactory.reset();
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        if (noContentOverlay != null)
        {
            noContentOverlay.hide();
            if (tagType != TagType.ALBUM)
            {
                flag1 = false;
            }
            showFoldersBanner(flag1);
            AutoUploadNotification.launchAutoUploadNotificationIfNeverSeen(this, getSettingsIntent());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void updateView(TagType tagtype)
    {
        switch (_cls10..SwitchMap.com.amazon.gallery.framework.model.tags.TagType[tagtype.ordinal()])
        {
        default:
            DebugAssert.assertMsg((new StringBuilder()).append("Unknown tag type: ").append(tagtype).toString());
            return;

        case 1: // '\001'
            setTitle(getString(0x7f0e0072));
            return;

        case 2: // '\002'
            setTitle(getString(0x7f0e01b5));
            return;

        case 3: // '\003'
            setTitle(getString(0x7f0e006c));
            return;

        case 4: // '\004'
            setTitle(getString(0x7f0e0065));
            break;
        }
    }






/*
    static AsyncTask access$502(CollectionListActivity collectionlistactivity, AsyncTask asynctask)
    {
        collectionlistactivity.showFolderBannerTask = asynctask;
        return asynctask;
    }

*/
}
