// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.widget.ListAdapter;
import com.amazon.gallery.foundation.ui.layout.LayoutType;
import com.amazon.gallery.foundation.utils.async.BlockingSpinnerDialog;
import com.amazon.gallery.foundation.utils.di.BeanAwareApplication;
import com.amazon.gallery.foundation.utils.featuremanager.FeatureManager;
import com.amazon.gallery.foundation.utils.featuremanager.Features;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ActivityResultEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.messaging.InvalidateDataEvent;
import com.amazon.gallery.framework.data.dao.SortTypeDao;
import com.amazon.gallery.framework.data.dao.filter.LocalVideoFilter;
import com.amazon.gallery.framework.data.dao.filter.MediaTypeFilter;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.SQLiteDaoUtil;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.TagAwareMediaStoreSyncProviderImpl;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.gallery.metrics.LaunchTimeMetrics;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.gallery.view.ViewNameFactory;
import com.amazon.gallery.framework.gallery.view.ViewNotificationManager;
import com.amazon.gallery.framework.gallery.view.ViewStateListener;
import com.amazon.gallery.framework.kindle.AutoUploadNotification;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.edit.PostEditSaveRunnable;
import com.amazon.gallery.framework.kindle.edit.ProcessImageEditsUtil;
import com.amazon.gallery.framework.kindle.fragment.AdapterFragment;
import com.amazon.gallery.framework.kindle.fragment.FragmentController;
import com.amazon.gallery.framework.kindle.fragment.StateFragment;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;
import com.amazon.gallery.framework.kindle.ui.NavigationBar;
import com.amazon.gallery.framework.kindle.ui.NoContentOverlay;
import com.amazon.gallery.framework.kindle.util.IntentUtil;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.EditType;
import com.amazon.gallery.framework.model.media.MediaProperty;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.thor.app.FeatureChecker;
import com.amazon.gallery.thor.app.FreeTime;
import com.amazon.gallery.thor.app.GalleryPermissionChecker;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.activity.MediaContentConfigurationHolder;
import com.amazon.gallery.thor.app.ui.navigation.GalleryPanelViewListener;
import com.amazon.gallery.thor.camera.CameraMediaLoaderTask;
import com.amazon.gallery.thor.controller.NavigationPaneController;
import com.amazon.gallery.thor.di.AppKeys;
import com.amazon.gallery.thor.settings.HidePreferenceManager;
import com.amazon.gallery.thor.thisday.ThisDayViewDescriptor;
import com.amazon.gallery.thor.view.PhotosNavigationPane;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            CommonActivity, GridActivityParams, LaunchSourceMetrics, SingleViewActivity

public abstract class NativeGalleryActivity extends CommonActivity
    implements MediaContentConfigurationHolder
{

    private static final String TAG = com/amazon/gallery/framework/kindle/activity/NativeGalleryActivity.getName();
    protected ProcessImageEditsUtil aviaryProcessImageEditsUtil;
    protected CameraMediaLoaderTask cameraMediaLoaderTask;
    protected MediaContentConfiguration contentConfiguration;
    protected FeatureChecker featureChecker;
    protected FragmentController fragmentController;
    private HidePreferenceManager hidePreferenceManager;
    protected LaunchTimeMetrics launchTimeMetrics;
    private boolean localView;
    protected PhotosNavigationPane navPane;
    protected NavigationPaneController navPaneController;
    protected NavigationBar navigationBar;
    protected SortTypeDao sortTypeDao;
    private final AtomicBoolean syncAllowed = new AtomicBoolean(true);
    protected TagDao tagDao;

    public NativeGalleryActivity(GridActivityParams gridactivityparams)
    {
        super(gridactivityparams.beanFactory, gridactivityparams.launchCamera);
        navigationBar = null;
        localView = false;
    }

    private void setupAccessibilityDelegates()
    {
        AccessibilityDelegateCompat accessibilitydelegatecompat = new AccessibilityDelegateCompat() {

            final AccessibilityNodeProviderCompat emptyProvider = new AccessibilityNodeProviderCompat();
            final NativeGalleryActivity this$0;

            public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view1)
            {
                if (fragmentController != null && fragmentController.isFragmentOpen())
                {
                    return emptyProvider;
                } else
                {
                    return super.getAccessibilityNodeProvider(view1);
                }
            }

            
            {
                this$0 = NativeGalleryActivity.this;
                super();
            }
        };
        View view = findViewById(0x7f0c0086);
        if (view != null)
        {
            ViewCompat.setAccessibilityDelegate(view, accessibilitydelegatecompat);
        }
    }

    public boolean configurationHasCameraContentLoadingScreen()
    {
        ViewDescriptor viewdescriptor = contentConfiguration.toViewDescriptor();
        return viewdescriptor.getCollectionType() == com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.MEDIA_PROPERTY && viewdescriptor.getMediaProperty() == CommonMediaProperty.CAMERA && viewdescriptor.getSyncingAfterCameraClick();
    }

    protected MediaContentConfiguration createMediaContentConfiguration()
    {
        ViewDescriptor viewdescriptor = createViewDescriptor();
        com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration.Builder builder = IntentUtil.createMediaContentConfigBuilderFromIntent(this, getIntent());
        builder.withViewDescriptor(viewdescriptor).withSortType(viewdescriptor.getMediaItemSortType());
        if (FeatureManager.isFeatureEnabled(Features.HIDE))
        {
            if (getIntent().getBooleanExtra("view_hidden_content_button", false))
            {
                builder.appendWhere("hidden", Integer.valueOf(1));
                return builder.build();
            }
            if (!viewdescriptor.isInHiddenMode())
            {
                builder.appendWhere("hidden", Integer.valueOf(0));
            }
        }
        if (viewdescriptor.getTag() != null)
        {
            builder.withLabel(ViewNameFactory.getTitle(viewdescriptor.getTag(), this));
        }
        return builder.build();
    }

    protected ViewDescriptor createViewDescriptor()
    {
        ViewDescriptor viewdescriptor;
        Intent intent;
        viewdescriptor = new ViewDescriptor();
        intent = getIntent();
        viewdescriptor.setShowHiddenMode(hidePreferenceManager.getHiddenPreference());
        localView = false;
        Object obj = null;
        MediaTypeFilter mediatypefilter = ((MediaTypeFilter) (obj));
        if (intent.hasExtra("imageMediaType"))
        {
            mediatypefilter = ((MediaTypeFilter) (obj));
            if (intent.getStringExtra("imageMediaType").equals("vnd.android.cursor.dir/image"))
            {
                mediatypefilter = new MediaTypeFilter(MediaType.PHOTO);
            }
        }
        obj = mediatypefilter;
        if (mediatypefilter == null)
        {
            obj = mediatypefilter;
            boolean flag;
            long l;
            long l1;
            if (intent.getType() != null)
            {
                if (intent.getType().equals("image/*"))
                {
                    obj = new MediaTypeFilter(MediaType.PHOTO);
                } else
                if (intent.getType().equals("video/*"))
                {
                    obj = new MediaTypeFilter(MediaType.VIDEO);
                    setTitle(0x7f0e0073);
                } else
                {
                    obj = mediatypefilter;
                    if (IntentUtil.isChooser(intent))
                    {
                        obj = new LocalVideoFilter();
                    }
                }
            }
        }
        if (obj != null)
        {
            viewdescriptor.setMediaFilter(((com.amazon.gallery.framework.data.dao.filter.DaoFilter) (obj)));
        }
        if (!intent.hasExtra("mediaProperty")) goto _L2; else goto _L1
_L1:
        viewdescriptor.setMediaProperty(MediaProperty.fromString(intent.getStringExtra("mediaProperty")));
        localView = true;
_L6:
        if (IntentUtil.isLaunchedByCamera(intent))
        {
            obj = LaunchSourceMetrics.MetricsEvent.CameraToGallery;
            if (getIntent().hasExtra(((LaunchSourceMetrics.MetricsEvent) (obj)).toString()))
            {
                l = getIntent().getLongExtra(((LaunchSourceMetrics.MetricsEvent) (obj)).toString(), 0L);
                if (l > 0L)
                {
                    l1 = System.currentTimeMillis();
                    ((LaunchSourceMetrics)getApplicationBean(Keys.LAUNCH_SOURCE_PROFILER)).trackTimer(((Enum) (obj)), l1 - l);
                }
            }
        }
        if (viewdescriptor.getCollectionType() == com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.TAG)
        {
            flag = false;
            if (viewdescriptor.getTag().hasProperty(TagProperty.UPLOADED))
            {
                viewdescriptor.getTag().setProperty(TagProperty.NO_UPLOAD_STATE);
                flag = true;
            }
            if (viewdescriptor.getTag().hasProperty(TagProperty.NEW_CONTENT))
            {
                viewdescriptor.getTag().setProperty(TagProperty.NO_NEW_CONTENT);
                flag = true;
            }
            if (flag)
            {
                tagDao.save(viewdescriptor.getTag(), false);
            }
        }
        if (intent.hasExtra("mediaItem"))
        {
            viewdescriptor.setMediaItem((ObjectID)intent.getSerializableExtra("mediaItem"));
            viewdescriptor.setMediaItemType(IntentUtil.getMediaTypeFromIntent(intent));
        }
        if (IntentUtil.isThisDayIntent(intent))
        {
            viewdescriptor.setTimeLineVisbility(false);
            viewdescriptor.setMediaProperty(CommonMediaProperty.THISDAY);
            viewdescriptor.setThisDayViewDescriptor(new ThisDayViewDescriptor(intent.getIntExtra("thisDayYear", 0), intent.getBooleanExtra("weekData", false), intent.getBooleanExtra("shuffleData", false), intent.getLongExtra("thisDayItemDate", -1L)));
        }
        obj = viewdescriptor.getSortId();
        viewdescriptor.setMediaItemSortType(sortTypeDao.getSortTypeById(((String) (obj))));
        return viewdescriptor;
_L2:
        Object obj2;
        if (intent.getBooleanExtra("mediaDynamicAlbum", false))
        {
            localView = false;
            viewdescriptor.setDynamicAlbumTag((Tag)intent.getSerializableExtra("mediaTag"));
            continue; /* Loop/switch isn't completed */
        }
        if (intent.hasExtra("mediaTag"))
        {
            Tag tag = (Tag)intent.getSerializableExtra("mediaTag");
            boolean flag1;
            if (tag.getType() == TagType.LOCAL_FOLDER)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            localView = flag1;
            viewdescriptor.setTag(tag);
            continue; /* Loop/switch isn't completed */
        }
        if (intent.hasExtra("mediaType"))
        {
            if (IntentUtil.isLocalOnly(intent))
            {
                viewdescriptor.setLocalOnly(true);
            }
            if (IntentUtil.isSdCardOnly(intent))
            {
                viewdescriptor.setLocalOnly(true);
                viewdescriptor.setSdCardOnly(true);
                viewdescriptor.setMediaProperty(CommonMediaProperty.REMOVABLE);
            }
            MediaType mediatype = IntentUtil.getMediaTypeFromIntent(intent);
            viewdescriptor.setMediaType(mediatype);
            if (mediatype == MediaType.VIDEO)
            {
                setTitle(0x7f0e0073);
            }
            continue; /* Loop/switch isn't completed */
        }
        if (intent.hasExtra("mediaTagId"))
        {
            Object obj1 = ObjectID.parseString((String)intent.getSerializableExtra("mediaTagId"));
            obj1 = tagDao.getTagById(((ObjectID) (obj1)));
            if (obj1 != null)
            {
                viewdescriptor.setTag(((Tag) (obj1)));
            }
            continue; /* Loop/switch isn't completed */
        }
        if (!intent.hasExtra("tagPath"))
        {
            break MISSING_BLOCK_LABEL_859;
        }
        obj2 = intent.getStringExtra("tagPath");
        obj2 = getContentResolver().query(com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.Tag.CONTENT_URI, null, "local_path = ?", new String[] {
            obj2
        }, null);
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_821;
        }
        Tag tag1;
        if (((Cursor) (obj2)).getCount() <= 0 || !((Cursor) (obj2)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_821;
        }
        tag1 = SQLiteDaoUtil.itemFromCursor(((Cursor) (obj2)), tagDao);
        if (tag1 == null)
        {
            break MISSING_BLOCK_LABEL_799;
        }
        viewdescriptor.setTag(tag1);
_L4:
        if (obj2 != null && !((Cursor) (obj2)).isClosed())
        {
            ((Cursor) (obj2)).close();
        }
        continue; /* Loop/switch isn't completed */
        GLogger.w(TAG, "Photos launched with intent to open album but no album found!", new Object[0]);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        if (obj2 != null && !((Cursor) (obj2)).isClosed())
        {
            ((Cursor) (obj2)).close();
        }
        throw exception;
        if (IntentUtil.isLaunchedByCamera(intent) || intent.hasExtra("cameraRoll"))
        {
            viewdescriptor.setMediaProperty(CommonMediaProperty.CAMERA);
            Uri uri = intent.getData();
            if (uri != null && uri.getAuthority().equals(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI.getAuthority()))
            {
                if (CameraMediaLoaderTask.hasCameraLoaderExtras(intent))
                {
                    ObjectID objectid = (ObjectID)intent.getSerializableExtra("media_loader_task_object_id");
                    MediaType mediatype1 = (MediaType)intent.getSerializableExtra("media_loader_task_media_task");
                    viewdescriptor.setMediaItem(objectid);
                    viewdescriptor.setMediaItemType(mediatype1);
                } else
                {
                    viewdescriptor.setSyncingAfterCameraClick(true);
                    viewdescriptor.setMediaItem(null);
                    viewdescriptor.setMediaItemType(null);
                }
            }
        } else
        if (((FreeTime)getApplicationBean(AppKeys.THOR_FREE_TIME)).isFreeTime())
        {
            viewdescriptor.setMediaProperty(CommonMediaProperty.CAMERA);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void fetchBeans()
    {
        super.fetchBeans();
        featureChecker = (FeatureChecker)getApplicationBean(AppKeys.FEATURE_CHECKER);
        sortTypeDao = (SortTypeDao)getApplicationBean(Keys.SORT_PREFERENCE_DAO);
        tagDao = (TagDao)getApplicationBean(Keys.TAG_DAO);
        aviaryProcessImageEditsUtil = (ProcessImageEditsUtil)getApplicationBean(Keys.AVIARY_PROCESS_IMAGE_EDITS_UTIL);
        contentConfiguration = createMediaContentConfiguration();
    }

    protected String getAccessibilityDescription()
    {
        String s = null;
        if (contentConfiguration != null)
        {
            s = ViewNameFactory.getTitle(contentConfiguration.toViewDescriptor(), this);
        }
        return s;
    }

    public FragmentController getFragmentController()
    {
        return fragmentController;
    }

    protected LayoutType getLayoutType(int i)
    {
        if (contentConfiguration.toViewDescriptor().getMediaItem() != null)
        {
            return LayoutType.SINGLE;
        }
        if (isForceGridMode())
        {
            return LayoutType.GRID;
        }
        if (i == 2)
        {
            return LayoutType.MOSAIC;
        } else
        {
            return LayoutType.GRID;
        }
    }

    public ListAdapter getListAdapter()
    {
        android.support.v4.app.Fragment fragment;
        if (fragmentController != null)
        {
            if ((fragment = fragmentController.getFragment()) instanceof AdapterFragment)
            {
                return ((AdapterFragment)fragment).getAdapter();
            }
        }
        return null;
    }

    public boolean getLocalView()
    {
        return localView;
    }

    public MediaContentConfiguration getMediaContentConfiguration()
    {
        return contentConfiguration;
    }

    public int getMediaItemIndex(int i)
    {
        if (fragmentController.getFragment() instanceof AdapterFragment)
        {
            return ((AdapterFragment)fragmentController.getFragment()).getMediaItemIndex(i);
        } else
        {
            return -1;
        }
    }

    public PhotosNavigationPane getNavPane()
    {
        return navPane;
    }

    protected boolean isForceGridMode()
    {
        return false;
    }

    protected boolean isSyncAllowed()
    {
        return syncAllowed.getAndSet(true);
    }

    protected void launchFragment()
    {
        navigateForConfig(getResources().getConfiguration());
        notificationManager.notifyViewStateChange(contentConfiguration.toViewDescriptor(), true);
    }

    protected void logLaunchSource()
    {
        String s = getIntent().getAction();
        LaunchSourceMetrics launchsourcemetrics = (LaunchSourceMetrics)getApplicationBean(Keys.LAUNCH_SOURCE_PROFILER);
        if ("com.amazon.photos.LAUNCH_PHOTOS".equals(s))
        {
            launchsourcemetrics.trackEvent(LaunchSourceMetrics.MetricsEvent.PhotoTab);
        } else
        {
            if ("com.amazon.photos.CMS".equals(s))
            {
                launchsourcemetrics.trackEvent(LaunchSourceMetrics.MetricsEvent.Carousel);
                return;
            }
            if ("com.amazon.gallery.thor.LAUNCH_VIDEOS".equals(s))
            {
                launchsourcemetrics.trackEvent(LaunchSourceMetrics.MetricsEvent.VideoTab);
                return;
            }
            if ("com.amazon.gallery.LAUNCH_NEW_PROMOTION_NOTIFICATION".equals(s))
            {
                launchsourcemetrics.trackEvent(LaunchSourceMetrics.MetricsEvent.NewPromotionNotification);
                return;
            }
            if (!"com.amazon.photos.INTERNAL".equals(s) && !"com.android.camera.action.REVIEW".equals(s))
            {
                launchsourcemetrics.trackEvent(LaunchSourceMetrics.MetricsEvent.Misc);
                return;
            }
        }
    }

    protected void navigateForConfig(Configuration configuration)
    {
        configuration = getLayoutType(configuration.orientation);
        if (configuration == LayoutType.SINGLE && featureChecker.hasSingleLayout())
        {
            configuration = new Intent(getIntent());
            configuration.setFlags(0);
            configuration.setClass(this, com/amazon/gallery/framework/kindle/activity/SingleViewActivity);
            contentConfiguration.toViewDescriptor().setMediaItem(null);
            startActivity(configuration);
        } else
        if (configurationHasCameraContentLoadingScreen())
        {
            if (cameraMediaLoaderTask == null || cameraMediaLoaderTask.getStatus() == android.os.AsyncTask.Status.FINISHED)
            {
                setupNoContentOverlay();
                waitForUriToScan();
                return;
            }
        } else
        {
            navigateTo(configuration);
            return;
        }
    }

    public void navigateTo(LayoutType layouttype)
    {
        if (fragmentController != null)
        {
            fragmentController.onNavigateTo(layouttype, contentConfiguration);
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        GLogger.d(TAG, "on Activity Result called! %d|%d", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j)
        });
        i;
        JVM INSTR lookupswitch 6: default 92
    //                   85: 164
    //                   99: 93
    //                   155: 136
    //                   156: 122
    //                   157: 150
    //                   1010: 175;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L7:
        break MISSING_BLOCK_LABEL_175;
_L9:
        return;
_L3:
        switch (j)
        {
        default:
            return;

        case 1: // '\001'
            break;

        case 2: // '\002'
            finish();
            break; /* Loop/switch isn't completed */
        }
_L1:
        if (true) goto _L9; else goto _L8
_L8:
        return;
_L5:
        if (j == -1)
        {
            processImage(intent, EditType.LOCAL);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (j == -1)
        {
            processImage(intent, EditType.CLOUD);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (j == -1)
        {
            processImage(intent, EditType.UNIFIED);
            return;
        }
        if (true) goto _L9; else goto _L2
_L2:
        setResult(-1, intent);
        finish();
        return;
        if (intent != null)
        {
            intent = intent.getStringExtra("com.amazon.unifiedshare.chosen_activity_name");
        } else
        {
            intent = null;
        }
        GlobalMessagingBus.post(new ActivityResultEvent(this, intent));
        return;
    }

    public void onCreate(Bundle bundle)
    {
        ThorGalleryApplication thorgalleryapplication = (ThorGalleryApplication)getApplication();
        launchTimeMetrics = thorgalleryapplication.getLaunchTimeMetrics();
        launchTimeMetrics.trackOnCreate();
        thorgalleryapplication.registerNewActivity(this);
        hidePreferenceManager = new HidePreferenceManager(this);
        super.onCreate(bundle);
        if (FeatureManager.isFeatureEnabled(Features.CMS))
        {
            notificationManager.addListener((ViewStateListener)getApplicationBean(Keys.KINDLE_CMS_CLIENT));
        }
        notificationManager.addListener((ViewStateListener)getApplicationBean(Keys.SESSION_METRICS));
        overridePendingTransition(0x7f040020, 0x7f040021);
        setActivityContentView();
        setupFragmentController();
        setupAccessibilityDelegates();
        setupNavPane();
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (navPaneController != null)
        {
            navPaneController.onDestroy();
        }
        ((BeanAwareApplication)getApplication()).unregisterActivity(this);
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
        setMediaContentConfiguration(createMediaContentConfiguration());
        getMediaContentConfiguration().toViewDescriptor().setCollectionTypeChanged(true);
        notificationManager.notifyViewStateChange(contentConfiguration.toViewDescriptor(), true);
        GlobalMessagingBus.post(new InvalidateDataEvent(true));
    }

    public void onPause()
    {
        super.onPause();
        launchTimeMetrics.trackOnPause();
        notificationManager.removeListener(noContentOverlay);
    }

    public void onResume()
    {
        super.onResume();
        launchTimeMetrics.trackOnResume();
        ((GalleryPermissionChecker)getApplicationBean(Keys.GALLERY_PERMISSION_CHECKER)).showMissingPermissionsIfNeeded(this);
        if (!showFTUEIfNeeded())
        {
            showPromotionIfNeeded();
        }
        if (navPaneController != null)
        {
            navPaneController.onResume();
        }
        logLaunchSource();
        if (hidePreferenceManager.getHiddenPreference() != contentConfiguration.toViewDescriptor().isInHiddenMode())
        {
            setMediaContentConfiguration(createMediaContentConfiguration());
            GlobalMessagingBus.post(new InvalidateDataEvent(true));
        }
        notificationManager.addListener(noContentOverlay);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        StateFragment.getAndRegisterInstance(this).setContentConfiguration(contentConfiguration);
        super.onSaveInstanceState(bundle);
    }

    protected void onStart()
    {
        super.onStart();
        MediaContentConfiguration mediacontentconfiguration = StateFragment.getAndRegisterInstance(this).getContentConfiguration();
        if (mediacontentconfiguration != null)
        {
            contentConfiguration = mediacontentconfiguration;
        }
        launchFragment();
    }

    protected void processImage(Intent intent, EditType edittype)
    {
        Uri uri = Uri.fromFile(new File(intent.getData().getPath()));
        intent = intent.getExtras();
        if (intent.getBoolean("bitmap-changed"))
        {
            syncAllowed.set(false);
            intent = getMediaContentConfiguration().toViewDescriptor().getTag();
            (new BlockingSpinnerDialog(this, new PostEditSaveRunnable(this, edittype, aviaryProcessImageEditsUtil, uri, intent), getString(0x7f0e009b))).execute(new Void[0]);
            return;
        }
        if (intent.getBoolean("delete"))
        {
            aviaryProcessImageEditsUtil.delete(this, uri);
            return;
        } else
        {
            GLogger.v(TAG, "No processing needed for image", new Object[0]);
            return;
        }
    }

    public void setActivityContentView()
    {
        setContentView(0x7f0300ac);
    }

    public void setLocalView(boolean flag)
    {
        localView = flag;
    }

    public void setMediaContentConfiguration(MediaContentConfiguration mediacontentconfiguration)
    {
        contentConfiguration = mediacontentconfiguration;
        if (fragmentController != null && !fragmentController.setContentConfiguration(mediacontentconfiguration))
        {
            navigateForConfig(getResources().getConfiguration());
        }
    }

    protected void setupFragmentController()
    {
    }

    protected void setupNavPane()
    {
        navPane = (PhotosNavigationPane)findViewById(0x7f0c014e);
        if (!featureChecker.hasLeftPanel())
        {
            navPane.setSideBarEnabled(false);
            return;
        } else
        {
            navPaneController = new NavigationPaneController(this, navPane, tagDao, (MediaItemDao)getApplicationBean(Keys.MEDIA_ITEM_DAO), (Executor)getApplicationBean(Keys.UI_READY_EXECUTOR));
            notificationManager.addListener(new GalleryPanelViewListener(navPane));
            return;
        }
    }

    protected void showPromotionIfNeeded()
    {
    }

    public void updateNoContentOverlay(int i)
    {
        if (i != 0) goto _L2; else goto _L1
_L1:
        Tag tag = contentConfiguration.toViewDescriptor().getTag();
        if (tag == null) goto _L4; else goto _L3
_L3:
        if (tag.getType() != TagType.LOCAL_FOLDER) goto _L6; else goto _L5
_L5:
        noContentOverlay.setNoContentMode(com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode.DEVICE);
_L4:
        if (FeatureManager.isFeatureEnabled(Features.HIDE) && getIntent().getBooleanExtra("view_hidden_content_button", false))
        {
            noContentOverlay.setNoContentMode(com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode.HIDDEN);
        }
        noContentOverlay.showNoContentMode(400L);
_L8:
        return;
_L6:
        noContentOverlay.setNoContentMode(com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode.ALBUM);
        if (tagDao.getTagById(tag.getObjectId()) == null)
        {
            GLogger.i(TAG, "Current tag does not exist, finishing activity to return to albums list", new Object[0]);
            finish();
        }
        continue; /* Loop/switch isn't completed */
_L2:
        noContentOverlay.hide();
        if (!isActivityResumed()) goto _L8; else goto _L7
_L7:
        AutoUploadNotification.launchAutoUploadNotificationIfNeverSeen(this, getSettingsIntent());
        return;
        if (true) goto _L4; else goto _L9
_L9:
    }

    protected void waitForUriToScan()
    {
        Uri uri = getIntent().getData();
        Intent intent = new Intent(getIntent());
        cameraMediaLoaderTask = new CameraMediaLoaderTask(this, uri.toString(), intent);
        cameraMediaLoaderTask.executeOnExecutor(TagAwareMediaStoreSyncProviderImpl.SERIAL_EXECUTOR, new Void[0]);
    }

}
