// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.di;

import android.content.Context;
import android.content.res.Resources;
import android.media.MediaScannerConnection;
import android.os.Build;
import android.os.Environment;
import android.preference.PreferenceManager;
import com.amazon.client.metrics.MetricsFactory;
import com.amazon.gallery.foundation.metrics.AbstractProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.metrics.amazoninsights.AmazonInsightsHelper;
import com.amazon.gallery.foundation.metrics.customer.CustomerMetricsProfiler;
import com.amazon.gallery.foundation.metrics.customer.ForesterPublisher;
import com.amazon.gallery.foundation.utils.DebugAssert;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.di.BeanAwareApplication;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.foundation.utils.featuremanager.FeatureManager;
import com.amazon.gallery.foundation.utils.featuremanager.Features;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.log.GTrace;
import com.amazon.gallery.framework.data.dao.DynamicAlbumDao;
import com.amazon.gallery.framework.data.dao.TagPropertyDao;
import com.amazon.gallery.framework.data.dao.deduplicate.CloudFieldDeduplicater;
import com.amazon.gallery.framework.data.dao.deduplicate.CutDeduplicater;
import com.amazon.gallery.framework.data.dao.deduplicate.PathDeduplicater;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDaoImpl;
import com.amazon.gallery.framework.data.dao.remotestorage.RemoteStorageDao;
import com.amazon.gallery.framework.data.dao.remotestorage.RemoteStorageDaoSqliteImpl;
import com.amazon.gallery.framework.data.dao.sqlite.GalleryDBConnectionManager;
import com.amazon.gallery.framework.data.dao.sqlite.SQLiteDaoUtil;
import com.amazon.gallery.framework.data.dao.sqlite.SortTypeSqliteImpl;
import com.amazon.gallery.framework.data.dao.sqlite.mediaitem.LocalMediaItemDaoSqliteImpl;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.AbstractMediaStoreHelper;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.LocalStateDao;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreHelper;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreHelperImpl;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreImageHelper;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreSyncProvider;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreVideoHelper;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.TagAwareMediaStoreSyncProviderImpl;
import com.amazon.gallery.framework.data.dao.sqlite.tag.TagDaoSqliteImpl;
import com.amazon.gallery.framework.data.dao.sqlite.tag.TagFactory;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.data.dao.tag.TagDaoImpl;
import com.amazon.gallery.framework.data.model.TimelineModel;
import com.amazon.gallery.framework.data.store.CloudDriveAssetDiskCache;
import com.amazon.gallery.framework.data.store.DiskEvictor;
import com.amazon.gallery.framework.data.store.DiskEvictorFactory;
import com.amazon.gallery.framework.data.store.DiskStorageUtils;
import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.data.store.LenticularHelper;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.gallery.lenticular.GalleryLenticularHelper;
import com.amazon.gallery.framework.gallery.metrics.EngagementMetrics;
import com.amazon.gallery.framework.gallery.metrics.LaunchTimeMetrics;
import com.amazon.gallery.framework.gallery.metrics.ProfilerSession;
import com.amazon.gallery.framework.gallery.metrics.SessionMetrics;
import com.amazon.gallery.framework.gallery.share.CloudDriveShareStore;
import com.amazon.gallery.framework.gallery.view.ViewDescriptorQuery;
import com.amazon.gallery.framework.kindle.AutoSaveManagerImpl;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.KindleGalleryDBConnectionManager;
import com.amazon.gallery.framework.kindle.KindleNetworkConnectivity;
import com.amazon.gallery.framework.kindle.activity.LaunchSourceMetrics;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManagerWrapper;
import com.amazon.gallery.framework.kindle.auth.UserManagerImpl;
import com.amazon.gallery.framework.kindle.auth.mapr5.MapHttpFactory;
import com.amazon.gallery.framework.kindle.auth.mapr5.MapRestClient;
import com.amazon.gallery.framework.kindle.auth.mapr5.ThorCustomerMetricInfo;
import com.amazon.gallery.framework.kindle.cms.KindleCMSClient;
import com.amazon.gallery.framework.kindle.edit.PreScanEditsListenerWrapper;
import com.amazon.gallery.framework.kindle.edit.ProcessImageEditsUtil;
import com.amazon.gallery.framework.kindle.metrics.UIClickMetrics;
import com.amazon.gallery.framework.kindle.network.http.rest.account.KindleProdHttpConfig;
import com.amazon.gallery.framework.kindle.notifications.UploadNotificationHandler;
import com.amazon.gallery.framework.kindle.widget.DebugPopup;
import com.amazon.gallery.framework.metrics.clickstream.ClickstreamEventHelper;
import com.amazon.gallery.framework.metrics.clickstream.ComponentClickstreamRecorder;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.framework.network.DownloadManagerRetryWatchdog;
import com.amazon.gallery.framework.network.cloudfront.CloudFrontConfig;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.disk.CloudDriveNetworkStore;
import com.amazon.gallery.framework.network.disk.NetworkStore;
import com.amazon.gallery.framework.network.download.DownloadIconHelper;
import com.amazon.gallery.framework.network.download.DownloadManagerWrapper;
import com.amazon.gallery.framework.network.download.DownloadStatusNotifierWrapper;
import com.amazon.gallery.framework.network.download.GalleryDownloadManager;
import com.amazon.gallery.framework.network.exceptions.MediaItemIdErrorHandlerFactory;
import com.amazon.gallery.framework.network.http.rest.DummyRestClient;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.http.rest.account.OneBoxHttpConfig;
import com.amazon.gallery.framework.network.http.rest.account.SubscriptionInfoCache;
import com.amazon.gallery.framework.network.http.rest.account.UserManager;
import com.amazon.gallery.framework.network.http.rest.http.UserAgent;
import com.amazon.gallery.framework.network.http.senna.SennaSyncListener;
import com.amazon.gallery.framework.network.http.senna.sync.manager.SyncManager;
import com.amazon.gallery.framework.network.multiqueueuploader.GalleryUploader;
import com.amazon.gallery.framework.network.multiqueueuploader.MultiQueueUploaderImpl;
import com.amazon.gallery.framework.network.multiqueueuploader.MultiQueueUploaderMessageHandler;
import com.amazon.gallery.framework.network.throttle.NetworkThrottle;
import com.amazon.gallery.framework.network.upload.DeviceAttributeStore;
import com.amazon.gallery.framework.network.watchdog.AutoSaveManager;
import com.amazon.gallery.thor.app.FeatureChecker;
import com.amazon.gallery.thor.app.FreeTime;
import com.amazon.gallery.thor.app.FreeTimeCommon;
import com.amazon.gallery.thor.app.FreeTimeTagFactory;
import com.amazon.gallery.thor.app.FreeTimeWrapper;
import com.amazon.gallery.thor.app.GalleryPermissionChecker;
import com.amazon.gallery.thor.app.ThorFeatureChecker;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.ThorLogOverride;
import com.amazon.gallery.thor.app.ThorTracer;
import com.amazon.gallery.thor.app.activity.ParentalControlWrapper;
import com.amazon.gallery.thor.app.authentication.AccountStateManager;
import com.amazon.gallery.thor.app.service.WhisperUploadManager;
import com.amazon.gallery.thor.app.ui.UiReadyExecutor;
import com.amazon.gallery.thor.aviary.LaunchAviaryFactory;
import com.amazon.gallery.thor.camera.SystemPathProvider;
import com.amazon.gallery.thor.cds.CDSSyncManager;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import com.amazon.gallery.thor.cds.ThorCloudDriveServiceClientFactory;
import com.amazon.gallery.thor.dagger.ThorScreenModeManager;
import com.amazon.gallery.thor.demo.PhotosDemoManagerWrapper;
import com.amazon.gallery.thor.device.DeviceAttributeStoreWrapper;
import com.amazon.gallery.thor.device.DeviceModel;
import com.amazon.gallery.thor.facebook.FacebookHelperImpl;
import com.amazon.gallery.thor.metrics.GalleryMetricsFactory;
import com.amazon.gallery.thor.metrics.ThorNavigationMetrics;
import com.amazon.gallery.thor.metrics.ThorProfiler;
import com.amazon.gallery.thor.removablestorage.RemovableStorageManager;
import com.amazon.gallery.thor.removablestorage.RemovableStorageManagerWrapper;
import com.amazon.gallery.thor.thisday.ThisDayAlarmManager;
import com.amazon.gallery.thor.whisperplay.WhisperPlayConnectionManagerWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

// Referenced classes of package com.amazon.gallery.thor.di:
//            AppKeys

public class ApplicationBeans extends BeanFactory
{

    public ApplicationBeans()
    {
    }

    private void initAccountChangeListeners()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(Keys.HTTP_FACTORY);
        arraylist.add(Keys.DB_CONNECTION_MANAGER);
        if (FeatureManager.isFeatureEnabled(Features.CMS))
        {
            arraylist.add(Keys.KINDLE_CMS_CLIENT);
        }
        arraylist.add(Keys.MEDIA_STORE_SYNC_PROVIDER);
        arraylist.add(Keys.CURRENT_COLLECTION_ACTIVITY);
        arraylist.add(Keys.CURRENT_FTUE_ACTIVITY);
        arraylist.add(Keys.GALLERY_DOWNLOAD_MANAGER);
        arraylist.add(AppKeys.WHISPER_PLAY_CONNECTION_MANAGER);
        arraylist.add(Keys.CLOUD_DRIVE_SERVICE_CLIENT_MANAGER);
        arraylist.add(Keys.SUBSCRIPTION_INFO_CACHE);
        arraylist.add(Keys.NETWORK_THROTTLE);
        arraylist.add(Keys.SYNC_MANAGER);
        arraylist.add(Keys.WHISPER_UPLOAD_MANAGER);
        arraylist.add(Keys.MEDIA_ITEM_DAO);
        arraylist.add(Keys.DYNAMIC_ALBUM_DAO);
        arraylist.add(Keys.THIS_DAY_ALARM_MANAGER);
        putBean(Keys.ACCOUNT_CHANGE_LISTENER, arraylist);
    }

    private void initDiskAndNetwork(Context context)
    {
        AuthenticationManager authenticationmanager = (AuthenticationManager)getBean(Keys.AUTHENTICATING_MANAGER);
        Object obj = new DiskEvictorFactory(context);
        putBean(Keys.DISK_EVICTOR, ((DiskEvictorFactory) (obj)).createDiskEvictor());
        putBean(Keys.DISK_EVICTOR_CONFIG, ((DiskEvictorFactory) (obj)).getConfig());
        CloudDriveAssetDiskCache clouddriveassetdiskcache = new CloudDriveAssetDiskCache(context.getCacheDir(), DiskStorageUtils.getInstance(), (DiskEvictor)getBean(Keys.DISK_EVICTOR));
        clouddriveassetdiskcache.setProfiler((Profiler)getBean(Keys.PROFILER));
        putBean(Keys.DISK_STORE, clouddriveassetdiskcache);
        Object obj2 = new KindleNetworkConnectivity(context);
        ThorGalleryApplication.inject(obj2);
        obj = new UserManagerImpl(context);
        putBean(Keys.USER_MANAGER, obj);
        Object obj1 = new UserAgent(context, context.getResources().getString(0x7f0e0302));
        CloudDriveServiceClientManager clouddriveserviceclientmanager = new CloudDriveServiceClientManager(new ThorCloudDriveServiceClientFactory(context, ((UserAgent) (obj1)), (Profiler)getBean(Keys.PROFILER)), authenticationmanager);
        putBean(Keys.CLOUD_DRIVE_SERVICE_CLIENT_MANAGER, clouddriveserviceclientmanager);
        MapHttpFactory maphttpfactory = new MapHttpFactory(context);
        putBean(Keys.HTTP_FACTORY, maphttpfactory);
        if (((PhotosDemoManager)getBean(Keys.DEMO_MANAGER)).isInDemoMode())
        {
            obj = new DummyRestClient(context, null);
        } else
        {
            obj = new MapRestClient(context, new KindleProdHttpConfig(authenticationmanager), ((NetworkConnectivity) (obj2)), ((UserManager) (obj)), authenticationmanager, maphttpfactory, new MediaItemIdErrorHandlerFactory((MediaItemDao)getBean(Keys.MEDIA_ITEM_DAO)), (DeviceAttributeStore)getBean(Keys.DEVICE_ATTRIBUTE_STORE), clouddriveserviceclientmanager, (RemoteStorageDao)getBean(Keys.REMOTE_STORAGE_DAO));
        }
        ((RestClient) (obj)).setUserAgent(((UserAgent) (obj1)));
        ((RestClient) (obj)).setProfiler((Profiler)getBean(Keys.PROFILER));
        putBean(Keys.REST_CLIENT, obj);
        if (BuildFlavors.isDebug())
        {
            obj1 = CloudFrontConfig.DEVELOPMENT;
        } else
        {
            obj1 = CloudFrontConfig.PRODUCTION;
        }
        putBean(Keys.CLOUD_FRONT_CONFIG, obj1);
        putBean(Keys.NETWORK_THROTTLE, new NetworkThrottle(((RestClient) (obj)), PreferenceManager.getDefaultSharedPreferences(context), ((CloudFrontConfig) (obj1))));
        putBean(Keys.NETWORK_CONNECTIVITY, obj2);
        obj1 = new ForesterPublisher(((RestClient) (obj)).getEndpointManager(), ((NetworkConnectivity) (obj2)), context);
        obj2 = new ThorCustomerMetricInfo(context, (AuthenticationManager)getBean(Keys.AUTHENTICATING_MANAGER), ((RestClient) (obj)));
        putBean(Keys.CUSTOMER_METRICS_INFO, obj2);
        obj1 = new CustomerMetricsProfiler(((com.amazon.gallery.foundation.metrics.customer.MetricsPublisher) (obj1)), ((com.amazon.gallery.foundation.metrics.customer.CustomerMetricsInfo) (obj2)));
        obj2 = (Profiler)getBean(Keys.PROFILER);
        if (obj2 instanceof ThorProfiler)
        {
            ((ThorProfiler)obj2).setCustomerMetricsProfiler(((CustomerMetricsProfiler) (obj1)));
        }
        putBean(Keys.FACEBOOK_HELPER, new FacebookHelperImpl(authenticationmanager));
        obj1 = new CloudDriveNetworkStore(((RestClient) (obj)), clouddriveassetdiskcache, (MediaItemDao)getBean(Keys.MEDIA_ITEM_DAO));
        ((CloudDriveNetworkStore) (obj1)).setProfiler((Profiler)getBean(Keys.PROFILER));
        putBean(Keys.NETWORK_STORE, obj1);
        obj2 = new GalleryLenticularHelper(context.getDir("lenticular_frames", 0), (MediaItemDao)getBean(Keys.MEDIA_ITEM_DAO), clouddriveassetdiskcache, ((NetworkStore) (obj1)));
        putBean(Keys.LENTICULAR_HELPER, obj2);
        obj1 = new CloudDriveShareStore(context, (File)getBean(Keys.SHARED_FILES_DIRECTORY), clouddriveassetdiskcache, ((NetworkStore) (obj1)), ((GalleryLenticularHelper) (obj2)));
        putBean(Keys.SHARE_STORE, obj1);
        putBean(Keys.SUBSCRIPTION_INFO_CACHE, new SubscriptionInfoCache((BeanAwareApplication)context));
        obj1 = (MediaItemDao)getBean(Keys.MEDIA_ITEM_DAO);
        ((MediaItemDao) (obj1)).addDeduplicater(new CutDeduplicater(((MediaItemDao) (obj1))));
        ((MediaItemDao) (obj1)).addDeduplicater(new CloudFieldDeduplicater(((MediaItemDao) (obj1)), context, authenticationmanager));
        ((MediaItemDao) (obj1)).addDeduplicater(new PathDeduplicater(((MediaItemDao) (obj1))));
        if (DebugAssert.isDebugBuild)
        {
            makeDemoModeDebugOption((PhotosDemoManager)getBean(Keys.DEMO_MANAGER));
            makeRestClientDebugOption(((RestClient) (obj)), (AuthenticationManager)getBean(Keys.AUTHENTICATING_MANAGER));
        }
    }

    private void initLaunchTimeMetrics(Context context)
    {
        if (context instanceof ThorGalleryApplication)
        {
            context = ((ThorGalleryApplication)context).getLaunchTimeMetrics();
            context.setProfiler((Profiler)getBean(Keys.PROFILER));
            context.setSyncManager((SyncManager)getBean(Keys.SYNC_MANAGER));
        }
    }

    private void initMediaStoreSyncProvider()
    {
        Object obj = (RemovableStorageManager)getBean(Keys.REMOVABLE_STORAGE_MANAGER);
        Object obj1 = new SystemPathProvider((FreeTime)getBean(AppKeys.THOR_FREE_TIME), ((RemovableStorageManager) (obj)));
        FreeTimeTagFactory freetimetagfactory = new FreeTimeTagFactory((TagDao)getBean(Keys.TAG_DAO), (FreeTime)getBean(AppKeys.THOR_FREE_TIME), ((RemovableStorageManager) (obj)));
        freetimetagfactory.setCameraDirPath(((SystemPathProvider) (obj1)).getCameraDirPath());
        freetimetagfactory.setRemovableCameraDirPath(((SystemPathProvider) (obj1)).getRemovableCameraDirPath());
        obj1 = new LinkedHashMap();
        ((Map) (obj1)).put(MediaType.PHOTO, (new MediaStoreImageHelper()).enableLenticular((LenticularHelper)getBean(Keys.LENTICULAR_HELPER)).enableRewindPhotos().setContext(context).setTagDao((TagDao)getBean(Keys.TAG_DAO)).setMediaItemDao((MediaItemDao)getBean(Keys.MEDIA_ITEM_DAO)).setTagFactory(freetimetagfactory).setRemovableStorageManager(((RemovableStorageManager) (obj))));
        ((Map) (obj1)).put(MediaType.VIDEO, (new MediaStoreVideoHelper()).setContext(context).setTagDao((TagDao)getBean(Keys.TAG_DAO)).setMediaItemDao((MediaItemDao)getBean(Keys.MEDIA_ITEM_DAO)).setTagFactory(freetimetagfactory).setRemovableStorageManager(((RemovableStorageManager) (obj))));
        obj = (new MediaStoreHelperImpl(((Map) (obj1)))).setContext(context);
        ((MediaStoreHelper) (obj)).addExcludedDirectory((File)getBean(Keys.SHARED_FILES_DIRECTORY));
        putBean(Keys.MEDIA_STORE_HELPER, obj);
        obj = new TagAwareMediaStoreSyncProviderImpl(context);
        ((TagAwareMediaStoreSyncProviderImpl) (obj)).setSharedPreferences(context.getSharedPreferences("galleryKindleSharedPrefs", 0));
        ((TagAwareMediaStoreSyncProviderImpl) (obj)).setTagDao((TagDao)getBean(Keys.TAG_DAO));
        ((TagAwareMediaStoreSyncProviderImpl) (obj)).setLocalDao((MediaItemDao)getBean(Keys.MEDIA_ITEM_DAO));
        ((TagAwareMediaStoreSyncProviderImpl) (obj)).setLocalStateDB((LocalStateDao)getBean(Keys.LOCAL_STATE_DAO));
        ((TagAwareMediaStoreSyncProviderImpl) (obj)).setMediaStoreHelper((MediaStoreHelper)getBean(Keys.MEDIA_STORE_HELPER));
        ((TagAwareMediaStoreSyncProviderImpl) (obj)).setProfiler((Profiler)getBean(Keys.PROFILER));
        putBean(Keys.MEDIA_STORE_SYNC_PROVIDER, obj);
    }

    private void initProfiler(Context context, MetricsFactory metricsfactory)
    {
        metricsfactory = new ThorProfiler(metricsfactory);
        metricsfactory.setDomain("Photos");
        putBean(Keys.PROFILER, metricsfactory);
        putBean(Keys.UI_METRICS_PROFILER, new UIClickMetrics(metricsfactory));
        putBean(Keys.LAUNCH_SOURCE_PROFILER, new LaunchSourceMetrics(metricsfactory));
        context = new SessionMetrics(context, metricsfactory, (AmazonInsightsHelper)getBean(Keys.AMAZON_INSIGHTS_HELPER));
        putBean(Keys.SESSION_METRICS, context);
        ThorNavigationMetrics thornavigationmetrics = new ThorNavigationMetrics(metricsfactory);
        putBean(Keys.NAVIGATION_METRICS, thornavigationmetrics);
        ProfilerSession profilersession = new ProfilerSession();
        profilersession.setSessionMetrics(context);
        profilersession.setNavigationMetrics(thornavigationmetrics);
        putBean(Keys.PROFILER_SESSION, profilersession);
        context = new EngagementMetrics(metricsfactory);
        putBean(Keys.ENGAGEMENT_METRICS, context);
    }

    private void initSqliteDao(Context context)
    {
        KindleGalleryDBConnectionManager kindlegallerydbconnectionmanager = new KindleGalleryDBConnectionManager(context, (AuthenticationManager)getBean(Keys.AUTHENTICATING_MANAGER));
        TagDaoSqliteImpl tagdaosqliteimpl = new TagDaoSqliteImpl(context, kindlegallerydbconnectionmanager);
        tagdaosqliteimpl.setPropDao(new TagPropertyDao());
        Object obj = new LocalMediaItemDaoSqliteImpl(context, kindlegallerydbconnectionmanager);
        ((LocalMediaItemDaoSqliteImpl) (obj)).setTagDao(tagdaosqliteimpl);
        tagdaosqliteimpl.setMediaItemDao(((com.amazon.gallery.framework.data.dao.mediaitem.LocalMediaItemDao) (obj)));
        obj = new MediaItemDaoImpl(((LocalMediaItemDaoSqliteImpl) (obj)));
        RemoteStorageDaoSqliteImpl remotestoragedaosqliteimpl = new RemoteStorageDaoSqliteImpl(kindlegallerydbconnectionmanager);
        SortTypeSqliteImpl sorttypesqliteimpl = new SortTypeSqliteImpl(kindlegallerydbconnectionmanager);
        TagDaoImpl tagdaoimpl = new TagDaoImpl(tagdaosqliteimpl);
        tagdaoimpl.setSortTypeDao(sorttypesqliteimpl);
        putBean(Keys.DB_CONNECTION_MANAGER, kindlegallerydbconnectionmanager);
        kindlegallerydbconnectionmanager.setMediaItemDao(((MediaItemDao) (obj)));
        kindlegallerydbconnectionmanager.setTagDao(tagdaoimpl);
        kindlegallerydbconnectionmanager.setProfiler((Profiler)getBean(Keys.PROFILER));
        kindlegallerydbconnectionmanager.setSortTypeDao(sorttypesqliteimpl);
        kindlegallerydbconnectionmanager.setAuthenticationManager((AuthenticationManager)getBean(Keys.AUTHENTICATING_MANAGER));
        SQLiteDaoUtil.setProfiler((Profiler)getBean(Keys.PROFILER));
        putBean(Keys.MEDIA_ITEM_DAO, obj);
        putBean(Keys.REMOTE_STORAGE_DAO, remotestoragedaosqliteimpl);
        putBean(Keys.TAG_DAO, tagdaoimpl);
        putBean(Keys.LOCAL_TAG_DAO, tagdaosqliteimpl);
        putBean(Keys.LOCAL_STATE_DAO, new LocalStateDao(context));
        putBean(Keys.TIMELINE_DAO, new TimelineModel(kindlegallerydbconnectionmanager));
        putBean(Keys.SORT_PREFERENCE_DAO, sorttypesqliteimpl);
        putBean(Keys.DYNAMIC_ALBUM_DAO, new DynamicAlbumDao(kindlegallerydbconnectionmanager, context));
    }

    private void initTateCMSClientSystems(Context context)
    {
        context = new KindleCMSClient(context);
        putBean(Keys.KINDLE_CMS_CLIENT, context);
        TagDao tagdao = (TagDao)getBean(Keys.TAG_DAO);
        tagdao.registerObserver(context, TagType.ALBUM);
        tagdao.registerObserver(context, TagType.SOURCE);
        tagdao.registerObserver(context, TagType.FOLDER);
        tagdao.registerObserver(context, TagType.LOCAL_FOLDER);
        tagdao.registerObserver(context, TagType.ALL);
    }

    private static void makeDemoModeDebugOption(PhotosDemoManager photosdemomanager)
    {
        DebugPopup.registerBooleanOption("Demo mode", null, true, false, new com.amazon.gallery.framework.kindle.widget.DebugPopup.DebugCallback(photosdemomanager) {

            final PhotosDemoManager val$demoManager;

            public void run(String s, Boolean boolean1)
            {
                demoManager.setForceDemoMode(boolean1.booleanValue());
            }

            public volatile void run(String s, Object obj)
            {
                run(s, (Boolean)obj);
            }

            
            {
                demoManager = photosdemomanager;
                super();
            }
        }, new com.amazon.gallery.framework.kindle.widget.DebugPopup.DebugSelectedCheck(photosdemomanager) {

            final PhotosDemoManager val$demoManager;

            public boolean check(String s, Boolean boolean1)
            {
                return demoManager.isInDemoMode() == boolean1.booleanValue();
            }

            public volatile boolean check(String s, Object obj)
            {
                return check(s, (Boolean)obj);
            }

            
            {
                demoManager = photosdemomanager;
                super();
            }
        }, new java.util.Map.Entry[] {
            new java.util.AbstractMap.SimpleEntry("Demo mode on", Boolean.valueOf(true)), new java.util.AbstractMap.SimpleEntry("Demo mode off", Boolean.valueOf(false))
        });
    }

    private static void makeRestClientDebugOption(RestClient restclient, AuthenticationManager authenticationmanager)
    {
        DebugPopup.registerStringOption("1lens endpoint", null, true, new com.amazon.gallery.framework.kindle.widget.DebugPopup.DebugCallback(restclient, authenticationmanager) {

            final AuthenticationManager val$authManager;
            final RestClient val$restClient;

            public volatile void run(String s, Object obj)
            {
                run(s, (String)obj);
            }

            public void run(String s, String s1)
            {
                if (s1.contentEquals("1box"))
                {
                    restClient.setConfig(new OneBoxHttpConfig());
                } else
                if (s1.contentEquals("prod"))
                {
                    restClient.setConfig(new KindleProdHttpConfig(authManager));
                    return;
                }
            }

            
            {
                restClient = restclient;
                authManager = authenticationmanager;
                super();
            }
        }, null, new java.util.Map.Entry[] {
            new java.util.AbstractMap.SimpleEntry("use 1box", "1box"), new java.util.AbstractMap.SimpleEntry("use prod", "prod")
        });
    }

    public void init(Context context)
    {
        super.init(context);
        GLogger.initLogProperties(context, "logging.properties");
        GLogger.setLogOverride(new ThorLogOverride());
        GTrace.setGTracer(new ThorTracer());
        boolean flag2 = BuildFlavors.isFireOS4OrLater();
        Object obj = new PhotosDemoManagerWrapper(context);
        putBean(Keys.DEMO_MANAGER, obj);
        Object obj1;
        Object obj2;
        Profiler profiler;
        UploadNotificationHandler uploadnotificationhandler;
        boolean flag;
        boolean flag1;
        if (BuildFlavors.isGen5() || BuildFlavors.isFos4() || BuildFlavors.isDuke() || BuildFlavors.isFos5() && !((PhotosDemoManager) (obj)).isInDemoMode())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if ((BuildFlavors.isFos5() || BuildFlavors.isDuke()) && Arrays.binarySearch(DeviceModel.BEST_SHOT_DEVICES, Build.DEVICE) >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        FeatureManager.setFeatureEnabled(context, Features.CMS, flag1);
        FeatureManager.setFeatureEnabled(context, Features.WHISPER_PLAY, flag2);
        FeatureManager.setFeatureEnabled(context, Features.HEADER_ACTION_BAR, true);
        obj = Features.FTUE;
        if (flag2 || BuildFlavors.isAosp())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        FeatureManager.setFeatureEnabled(context, ((com.amazon.gallery.foundation.utils.featuremanager.FeatureName) (obj)), flag1);
        FeatureManager.setFeatureEnabled(context, Features.CONTEXT_BAR, true);
        FeatureManager.setFeatureEnabled(context, Features.DEVICE_CAPABILITIES, flag2);
        FeatureManager.setFeatureEnabled(context, Features.PLATFORM_DOWNLOAD_MANAGER, flag2);
        obj = Features.SOFT_KEY_BAR;
        if (!BuildFlavors.isAosp())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        FeatureManager.setFeatureEnabled(context, ((com.amazon.gallery.foundation.utils.featuremanager.FeatureName) (obj)), flag1);
        FeatureManager.setFeatureEnabled(context, Features.HIDE, true);
        FeatureManager.setFeatureEnabled(context, Features.SHARE_ALBUM, true);
        FeatureManager.setFeatureEnabled(context, Features.REWIND, flag);
        putBean(Keys.UI_READY_EXECUTOR, new UiReadyExecutor());
        obj = new DeviceAttributeStoreWrapper(context);
        putBean(Keys.DEVICE_ATTRIBUTE_STORE, obj);
        FeatureManager.loadSetting(context);
        FeatureManager.setFeatureEnabled(context, Features.VIDEO, true);
        obj = new AuthenticationManagerWrapper(context);
        putBean(Keys.AUTHENTICATING_MANAGER, obj);
        putBean(Keys.SHARED_FILES_DIRECTORY, context.getExternalFilesDir(Environment.DIRECTORY_PICTURES));
        obj1 = (MetricsFactory)context.getSystemService("com.amazon.client.metrics.api");
        obj = obj1;
        if (obj1 == null)
        {
            obj = GalleryMetricsFactory.getMetricsFactory(context);
        }
        initProfiler(context, ((MetricsFactory) (obj)));
        initSqliteDao(context);
        obj1 = new DialogManager();
        putBean(Keys.DIALOG_MANAGER, obj1);
        if (FeatureManager.isFeatureEnabled(Features.CMS))
        {
            initTateCMSClientSystems(context);
        }
        initDiskAndNetwork(context);
        putBean(Keys.GALLERY_PERMISSION_CHECKER, new GalleryPermissionChecker(context));
        putBean(Keys.PARENTAL_CONTROL, new ParentalControlWrapper());
        putBean(Keys.VIEW_DESCRIPTOR_QUERY, new ViewDescriptorQuery());
        obj1 = new CDSSyncManager(context, (UserManager)getBean(Keys.USER_MANAGER), (SennaSyncListener)getBean(AppKeys.SENNA_SYNC_LISTENER), (MediaItemDao)getBean(Keys.MEDIA_ITEM_DAO), (Executor)getBean(Keys.UI_READY_EXECUTOR));
        putBean(Keys.SYNC_MANAGER, obj1);
        putBean(Keys.WHISPER_UPLOAD_MANAGER, new WhisperUploadManager(context));
        obj2 = (MediaItemDao)getBean(Keys.MEDIA_ITEM_DAO);
        profiler = (Profiler)getBean(Keys.PROFILER);
        obj1 = new FreeTimeWrapper(context, ((SyncManager) (obj1)), (TagDao)getBean(Keys.TAG_DAO), ((MediaItemDao) (obj2)), profiler, (Executor)getBean(Keys.UI_READY_EXECUTOR));
        putBean(AppKeys.THOR_FREE_TIME, obj1);
        putBean(AppKeys.FEATURE_CHECKER, new ThorFeatureChecker(FreeTimeCommon.getUserTheme(context), (PhotosDemoManager)getBean(Keys.DEMO_MANAGER)));
        obj = new ComponentClickstreamRecorder(ClickstreamEventHelper.getAppVariant((FeatureChecker)getBean(AppKeys.FEATURE_CHECKER)), ((MetricsFactory) (obj)));
        ((ThorProfiler)getBean(Keys.PROFILER)).setClickstreamRecorder(((ComponentClickstreamRecorder) (obj)));
        obj = new RemovableStorageManagerWrapper(context, this);
        putBean(Keys.REMOVABLE_STORAGE_MANAGER, obj);
        uploadnotificationhandler = new UploadNotificationHandler(context, (DiskStore)getBean(Keys.DISK_STORE), profiler);
        putBean(Keys.UPLOAD_NOTIFICATION_HANDLER, uploadnotificationhandler);
        obj = new AutoSaveManagerImpl((TagDao)getBean(Keys.TAG_DAO), (MediaItemDao)getBean(Keys.MEDIA_ITEM_DAO), (DialogManager)getBean(Keys.DIALOG_MANAGER), PreferenceManager.getDefaultSharedPreferences(context), (NetworkConnectivity)getBean(Keys.NETWORK_CONNECTIVITY), ((RemovableStorageManager) (obj)), uploadnotificationhandler);
        putBean(Keys.AUTO_SAVE_MANAGER, obj);
        ((AutoSaveManager) (obj)).registerObserver();
        obj = new MultiQueueUploaderImpl(context, ((MediaItemDao) (obj2)), new GalleryUploader(context, (RestClient)getBean(Keys.REST_CLIENT), (CloudDriveServiceClientManager)getBean(Keys.CLOUD_DRIVE_SERVICE_CLIENT_MANAGER), ((MediaItemDao) (obj2))), profiler);
        obj2 = new MultiQueueUploaderMessageHandler(context, ((com.amazon.gallery.framework.network.multiqueueuploader.MultiQueueUploader) (obj)));
        putBean(Keys.MULTI_QUEUE_UPLOADER, obj);
        putBean(Keys.MULTI_QUEUE_MESSAGE_HANDLER, obj2);
        putBean(Keys.ACCOUNT_STATE_MANAGER, new AccountStateManager());
        putBean(Keys.THIS_DAY_ALARM_MANAGER, new ThisDayAlarmManager(context));
        initMediaStoreSyncProvider();
        ((FreeTime) (obj1)).setMediaStoreSyncProvider((MediaStoreSyncProvider)getBean(Keys.MEDIA_STORE_SYNC_PROVIDER));
        initAccountChangeListeners();
        initLaunchTimeMetrics(context);
    }

    protected void initAviary()
    {
        Object obj = LaunchAviaryFactory.createLaunchAviary(context);
        putBean(Keys.LAUNCH_AVIARY, obj);
        obj = new ProcessImageEditsUtil((MediaItemDao)getBean(Keys.MEDIA_ITEM_DAO), (DynamicAlbumDao)getBean(Keys.DYNAMIC_ALBUM_DAO), (DiskStore)getBean(Keys.DISK_STORE), (MediaScannerConnection)getBean(Keys.MEDIA_SCANNER_CONNECTION), (MediaStoreSyncProvider)getBean(Keys.MEDIA_STORE_SYNC_PROVIDER), context, (NetworkStore)getBean(Keys.NETWORK_STORE));
        ((ProcessImageEditsUtil) (obj)).addPreScanEditsListener(new PreScanEditsListenerWrapper());
        putBean(Keys.AVIARY_PROCESS_IMAGE_EDITS_UTIL, obj);
    }

    public void initCommonAppBeans()
    {
        MediaScannerConnection mediascannerconnection = new MediaScannerConnection(context, (android.media.MediaScannerConnection.MediaScannerConnectionClient)getBean(Keys.MEDIA_STORE_SYNC_PROVIDER));
        putBean(Keys.MEDIA_SCANNER_CONNECTION, mediascannerconnection);
        Object obj = new DownloadIconHelper((MediaItemDao)getBean(Keys.MEDIA_ITEM_DAO), (DiskStore)getBean(Keys.DISK_STORE));
        ((DownloadIconHelper) (obj)).setDefaultIcon(context, 0x7f0201c5);
        DownloadManagerRetryWatchdog downloadmanagerretrywatchdog = new DownloadManagerRetryWatchdog();
        putBean(Keys.DOWNLOAD_MANAGER_RETRY_WATCHDOG, downloadmanagerretrywatchdog);
        DownloadStatusNotifierWrapper downloadstatusnotifierwrapper = new DownloadStatusNotifierWrapper(context);
        DownloadManagerWrapper downloadmanagerwrapper = new DownloadManagerWrapper(context, (RestClient)getBean(Keys.REST_CLIENT), (NetworkConnectivity)getBean(Keys.NETWORK_CONNECTIVITY), (MediaStoreSyncProvider)getBean(Keys.MEDIA_STORE_SYNC_PROVIDER), (MediaItemDao)getBean(Keys.MEDIA_ITEM_DAO), downloadstatusnotifierwrapper);
        obj = new GalleryDownloadManager(context, downloadmanagerwrapper, ((DownloadIconHelper) (obj)), (DiskEvictor)getBean(Keys.DISK_EVICTOR), downloadmanagerretrywatchdog, downloadstatusnotifierwrapper);
        mediascannerconnection.connect();
        putBean(Keys.GALLERY_DOWNLOAD_MANAGER, obj);
        if (FeatureManager.isFeatureEnabled(Features.WHISPER_PLAY))
        {
            putBean(AppKeys.WHISPER_PLAY_CONNECTION_MANAGER, new WhisperPlayConnectionManagerWrapper(context, (RestClient)getBean(Keys.REST_CLIENT), (NetworkStore)getBean(Keys.NETWORK_STORE), (DiskStore)getBean(Keys.DISK_STORE), (MediaItemDao)getBean(Keys.MEDIA_ITEM_DAO), (TagDao)getBean(Keys.TAG_DAO), (ViewDescriptorQuery)getBean(Keys.VIEW_DESCRIPTOR_QUERY), (Profiler)getBean(Keys.PROFILER), (AuthenticationManager)getBean(Keys.AUTHENTICATING_MANAGER)));
        }
        putBean(Keys.SCREEN_MODE_MANAGER, new ThorScreenModeManager());
        initAviary();
    }
}
