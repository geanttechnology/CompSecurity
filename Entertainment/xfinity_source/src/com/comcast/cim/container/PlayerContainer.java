// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.container;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.comcast.cim.analytics.PlayerAnalyticsService;
import com.comcast.cim.android.PropertyService;
import com.comcast.cim.android.application.AppUpgradeHelper;
import com.comcast.cim.android.authentication.AuthenticationStrategy;
import com.comcast.cim.android.sideribbon.SideMenuBuilder;
import com.comcast.cim.android.sideribbon.SideRibbonDelegateBuilder;
import com.comcast.cim.android.view.common.DownloadsAmsErrorFormatter;
import com.comcast.cim.android.view.common.OrientationStrategy;
import com.comcast.cim.android.view.common.PlayerAmsErrorFormatter;
import com.comcast.cim.android.view.common.PlayerPlatformErrorFormatter;
import com.comcast.cim.android.view.common.errorformatter.ChainedErrorFormatter;
import com.comcast.cim.android.view.common.errorformatter.ErrorFormatter;
import com.comcast.cim.android.view.launch.LaunchIntentInterceptor;
import com.comcast.cim.android.view.launch.LaunchStrategy;
import com.comcast.cim.cmasl.analytics.AnalyticsLogger;
import com.comcast.cim.cmasl.analytics.AnalyticsTaskQueueLogger;
import com.comcast.cim.cmasl.android.util.system.AndroidDevice;
import com.comcast.cim.cmasl.apachehttp.service.DefaultHttpService;
import com.comcast.cim.cmasl.cachelib.NamespacedFileCache;
import com.comcast.cim.cmasl.cachelib.Normalizer;
import com.comcast.cim.cmasl.cachelib.NormalizerFactory;
import com.comcast.cim.cmasl.customtypefacelib.CustomTypefaceButton;
import com.comcast.cim.cmasl.customtypefacelib.CustomTypefaceEditText;
import com.comcast.cim.cmasl.customtypefacelib.CustomTypefaceTextView;
import com.comcast.cim.cmasl.customtypefacelib.TypefaceFamily;
import com.comcast.cim.cmasl.customtypefacelib.TypefaceManager;
import com.comcast.cim.cmasl.hal.http.HalHttpClient;
import com.comcast.cim.cmasl.hal.http.HalRequestProviderFactory;
import com.comcast.cim.cmasl.http.request.signing.RequestSigner;
import com.comcast.cim.cmasl.http.request.signing.RequestSignerFactory;
import com.comcast.cim.cmasl.http.service.PermanentlyCachingHttpService;
import com.comcast.cim.cmasl.taskexecutor.executor.DefaultTaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.policy.MinimumIntervalRevalidationPolicy;
import com.comcast.cim.cmasl.taskexecutor.policy.RevalidationPolicy;
import com.comcast.cim.cmasl.taskexecutor.task.CachingTaskFactory;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.taskexecutor.task.TaskFactory;
import com.comcast.cim.cmasl.taskexecutor.task.Tuple3Task;
import com.comcast.cim.cmasl.taskexecutor.task.TupleTask;
import com.comcast.cim.cmasl.utils.StorageCache;
import com.comcast.cim.cmasl.utils.collections.LruLinkedHashMap;
import com.comcast.cim.cmasl.utils.executor.ExceptionHandlingSingleThreadExecutor;
import com.comcast.cim.cmasl.utils.initializer.Initializer;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.comcast.cim.config.CALConfiguration;
import com.comcast.cim.http.signing.OAuthRequestSigner;
import com.comcast.cim.microdata.client.HypermediaClient;
import com.comcast.cim.microdata.client.HypermediaClientImpl;
import com.comcast.cim.model.ParentalControlsCache;
import com.comcast.cim.model.hal.HalLiveFeaturedContentResourceFactory;
import com.comcast.cim.model.hal.HalLiveStreamFactory;
import com.comcast.cim.model.hal.HalLiveStreamResourceFactory;
import com.comcast.cim.model.hal.HalMovieFactory;
import com.comcast.cim.model.hal.HalTvSeriesFactory;
import com.comcast.cim.model.provider.CompositeRevalidationPolicy;
import com.comcast.cim.model.provider.UserChangeRevalidationPolicy;
import com.comcast.cim.model.system.PlayerAndroidDevice;
import com.comcast.cim.model.user.User;
import com.comcast.cim.model.user.UserManager;
import com.comcast.cim.model.user.service.PreferencesUserSettingsStore;
import com.comcast.cim.model.user.service.PreferencesUserStore;
import com.comcast.cim.model.user.service.UserSettings;
import com.comcast.cim.model.user.service.UserSettingsDao;
import com.comcast.cim.tracking.TrackingService;
import com.comcast.cim.utils.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ignition.support.cache.AbstractImageCache;
import com.github.ignition.support.cache.DecodedImageCache;
import com.github.ignition.support.images.remote.RemoteImageLoader;
import com.google.common.collect.Lists;
import com.ijsbrandslob.appirater.Appirater;
import com.xfinity.playerlib.PlayerApplication;
import com.xfinity.playerlib.VideoPlayUtil;
import com.xfinity.playerlib.authorization.ThePlatformClient;
import com.xfinity.playerlib.authorization.VideoAuthManager;
import com.xfinity.playerlib.captions.PersistentCaptionsCache;
import com.xfinity.playerlib.config.DebugPropertyService;
import com.xfinity.playerlib.config.PlayerConfiguration;
import com.xfinity.playerlib.config.ReleasePropertyService;
import com.xfinity.playerlib.downloads.DownloadsItemListenerDelegate;
import com.xfinity.playerlib.downloads.MediaLicenseClient;
import com.xfinity.playerlib.downloads.MediaLicenseRenewalScheduler;
import com.xfinity.playerlib.downloads.RegisterDeviceClient;
import com.xfinity.playerlib.downloads.RegistrationListClient;
import com.xfinity.playerlib.downloads.TitaniumTicketClient;
import com.xfinity.playerlib.downloads.UnregisterDeviceClient;
import com.xfinity.playerlib.image.CoverArtImageLoader;
import com.xfinity.playerlib.image.NetworkLogoImageLoader;
import com.xfinity.playerlib.image.ProgramDetailArtImageLoader;
import com.xfinity.playerlib.model.ConsumablesHypermediaServicesCache;
import com.xfinity.playerlib.model.HalLiveFeaturedContentResourceCache;
import com.xfinity.playerlib.model.HalLiveStreamMetaDataResource;
import com.xfinity.playerlib.model.HalLiveStreamResourceCache;
import com.xfinity.playerlib.model.HalMovieConsumableCache;
import com.xfinity.playerlib.model.HalTvSeriesConsumableCache;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.TveHypermediaServicesCache;
import com.xfinity.playerlib.model.consumable.WatchableClient;
import com.xfinity.playerlib.model.consumable.WatchableCodec;
import com.xfinity.playerlib.model.database.CachingLiveStreamBookmarkDAO;
import com.xfinity.playerlib.model.database.CachingVideoBookmarkDAO;
import com.xfinity.playerlib.model.database.DefaultLiveStreamBookmarkDAO;
import com.xfinity.playerlib.model.database.DefaultVideoBookmarkDAO;
import com.xfinity.playerlib.model.database.FavoriteDAO;
import com.xfinity.playerlib.model.database.LiveStreamBookmarkDAO;
import com.xfinity.playerlib.model.database.PlayNowDatabase;
import com.xfinity.playerlib.model.dibic.CompositeDibicResourceCache;
import com.xfinity.playerlib.model.dibic.DibicParser;
import com.xfinity.playerlib.model.dibic.DibicResourceCache;
import com.xfinity.playerlib.model.downloads.DownloadableFileFactory;
import com.xfinity.playerlib.model.downloads.NotificationQueueManager;
import com.xfinity.playerlib.model.downloads.PersistentEntityCache;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import com.xfinity.playerlib.model.editorial.CoverParser;
import com.xfinity.playerlib.model.editorial.EditorialMovieAndSeriesResource;
import com.xfinity.playerlib.model.editorial.EditorialResourceCache;
import com.xfinity.playerlib.model.editorial.EditorialResourceFactory;
import com.xfinity.playerlib.model.editorial.EditorialVideoCoverResource;
import com.xfinity.playerlib.model.editorial.FeaturedResourceCache;
import com.xfinity.playerlib.model.editorial.VideoParser;
import com.xfinity.playerlib.model.entitlement.GracefullyDegradingVideoEntitlementCache;
import com.xfinity.playerlib.model.entitlement.VideoEntitlementCache;
import com.xfinity.playerlib.model.etc.DibicMovieFactory;
import com.xfinity.playerlib.model.etc.DibicMovieUriProvider;
import com.xfinity.playerlib.model.etc.DibicSeriesFactory;
import com.xfinity.playerlib.model.etc.DibicTvSeriesUriProvider;
import com.xfinity.playerlib.model.tags.cache.TagsRootCache;
import com.xfinity.playerlib.model.tags.parser.TagsParser;
import com.xfinity.playerlib.model.user.PlayNowUser;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.model.user.service.PlayNowUserDao;
import com.xfinity.playerlib.model.videoplay.PlayerConfigUtil;
import com.xfinity.playerlib.model.videoplay.adobeplayer.CimAssetFactory;
import com.xfinity.playerlib.tracking.PlayNowAppMeasurementProvider;
import com.xfinity.playerlib.tracking.PlayNowTrackingService;
import com.xfinity.playerlib.view.authentication.PlayerAuthenticationStrategy;
import com.xfinity.playerlib.view.browseprograms.DefaultDibicProgramFilterFactory;
import com.xfinity.playerlib.view.browseprograms.DibicProgramFilterFactory;
import com.xfinity.playerlib.view.browseprograms.MovieCollectionSortPolicy;
import com.xfinity.playerlib.view.browseprograms.MoviesSortPolicy;
import com.xfinity.playerlib.view.browseprograms.NullSortPolicy;
import com.xfinity.playerlib.view.browseprograms.SeriesCollectionSortPolicy;
import com.xfinity.playerlib.view.browseprograms.SeriesSortPolicy;
import com.xfinity.playerlib.view.downloads.DownloadsItemListener;
import com.xfinity.playerlib.view.downloads.DownloadsSortPolicy;
import com.xfinity.playerlib.view.favorite.BookmarkUtils;
import com.xfinity.playerlib.view.flyinmenu.PlayerSideMenuBuilder;
import com.xfinity.playerlib.view.launch.PlayNowLaunchIntentInterceptor;
import com.xfinity.playerlib.view.launch.PlayerLaunchStrategy;
import com.xfinity.playerlib.view.programdetails.ConsumableVideoListHelper;
import com.xfinity.playerlib.view.programdetails.SeriesCombinedTaskExecutorFactory;
import com.xfinity.playerlib.view.search.SearchQueryProvider;
import com.xfinity.playerlib.view.videoplay.VideoTracker;
import com.xfinity.playerlib.view.videoplay.VideoTrackerSharedPreferenceProvider;
import java.net.URI;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Referenced classes of package com.comcast.cim.container:
//            CALContainer

public abstract class PlayerContainer extends CALContainer
{
    private static class LegacyNormalizer
        implements Normalizer
    {

        private final String namespace;

        public String normalize(String s)
        {
            return (new StringBuilder()).append(namespace).append(".").append(s).toString();
        }

        private LegacyNormalizer(String s)
        {
            namespace = s;
        }

    }


    protected static PlayerContainer instance;
    private PlayerAndroidDevice androidDevice;
    private Provider appMeasurementProvider;
    protected AppUpgradeHelper appUpgradeHelper;
    private Appirater appirater;
    private com.ijsbrandslob.appirater.Appirater.Configuration appiraterConfig;
    protected PlayerAuthenticationStrategy authStrategy;
    private CachingVideoBookmarkDAO bookmarkDAO;
    private BookmarkUtils bookmarkUtils;
    private CimAssetFactory cimAssetFactory;
    private ConsumableVideoListHelper consumableVideoListHelper;
    private Task consumablesHypermediaServiceTask;
    private AbstractImageCache coverArtCache;
    private String deepLinkingScheme;
    private OrientationStrategy defaultOrientationStrategy;
    private Task dibicCombinedCache;
    private TaskExecutor dibicCombinedTaskExecutor;
    private Task dibicMovieCache;
    protected DibicParser dibicParser;
    private Task dibicSeriesCache;
    private ErrorFormatter downloadErrorFormatter;
    private JsonDeserializer downloadMetaDataJsonDeserializer;
    private DownloadableFileFactory downloadableFileFactory;
    private DownloadsItemListener downloadsItemListenerDelegate;
    protected PlayerDownloadServiceManager downloadsManager;
    private DownloadsSortPolicy downloadsSortPolicy;
    private Task editorVideoCoverResourceCache;
    private Task editorialMovieAndSeriesResourceCache;
    private FavoriteDAO favoriteDAO;
    private Task featuredResourceCache;
    private HalHttpClient halHttpClient;
    private HypermediaClientImpl hypermediaClient;
    private MinimumIntervalRevalidationPolicy hypermediaRevalidationPolicy;
    protected PlayerLaunchStrategy launchStrategy;
    private android.view.LayoutInflater.Factory layoutInflaterFactory;
    private NormalizerFactory legacyNormalizerFactory;
    private Task liveFeaturedContentResourceCache;
    private LiveStreamBookmarkDAO liveStreamBookmarkDAO;
    protected TaskFactory liveStreamMetaDataResourceFactory;
    private Task liveStreamResourceCache;
    private MediaLicenseClient mediaLicenseClient;
    private MediaLicenseRenewalScheduler mediaLicenseRenewalScheduler;
    protected TaskFactory movieCacheMap;
    private MovieCollectionSortPolicy movieCollectionSortPolicy;
    private TaskExecutor moviesAndEntitlementTaskExecutor;
    private TaskExecutor moviesAndTagsAndEntitlementTaskExecutor;
    private MoviesSortPolicy moviesSortPolicy;
    private AbstractImageCache networkLogoCache;
    private Task nonDegradingVideoEntitlementCache;
    private TaskExecutor nonDegradingVideoEntitlementProvider;
    private NotificationQueueManager notificationQueueManager;
    private NullSortPolicy nullSortPolicy;
    private Task parentalControlsCache;
    private NamespacedFileCache parentalControlsFileCache;
    private TaskExecutor parentalControlsSettingsTaskExecutor;
    private PersistentCaptionsCache persistentCaptionsCache;
    private PersistentEntityCache persistentEntityCache;
    private PlayNowDatabase playNowDatabase;
    private PlayNowLaunchIntentInterceptor playNowLaunchIntentInterceptor;
    protected PlayerApplication playerApplication;
    private PlayerConfigUtil playerConfigUtil;
    private ErrorFormatter playerErrorFormatter;
    private ObjectMapper playerObjectMapper;
    private PreferencesUserStore preferencesUserStore;
    private AbstractImageCache programDetailArtCache;
    private TaskExecutor programsAndTagsAndEntitlementTaskExecutor;
    private PropertyService propertyService;
    private RegisterDeviceClient registerDeviceClient;
    private RegistrationListClient registrationListClient;
    private RequestSignerFactory requestSignerFactory;
    private Provider searchQueryProvider;
    private OrientationStrategy sensorIfHasKeyboardOrientationStrategy;
    private TaskExecutor seriesAndEntitlementTaskExecutor;
    private TaskExecutor seriesAndTagsAndEntitlementTaskExecutor;
    protected TaskFactory seriesCacheMap;
    private SeriesCollectionSortPolicy seriesCollectionSortPolicy;
    private SeriesCombinedTaskExecutorFactory seriesCombinedTaskExecutorFactory;
    private SeriesSortPolicy seriesSortPolicy;
    private SideMenuBuilder sideMenuBuilder;
    private SideRibbonDelegateBuilder sideRibbonDelegateBuilder;
    private TaskExecutor tagsAndProgramsTaskExecutor;
    private Executor tagsExecutor;
    private TagsParser tagsParser;
    private Task tagsRootCache;
    private TaskExecutor tagsRootTaskExecutor;
    private ThePlatformClient thePlatformClient;
    private TitaniumTicketClient titaniumTicketClient;
    private PlayNowTrackingService trackingService;
    private Task tveHypermediaServiceTask;
    private TypefaceManager typefaceManager;
    private UnregisterDeviceClient unregisterDeviceClient;
    private RevalidationPolicy userAndIntervalRevalidationPolicy;
    private PlayNowUserDao userDao;
    private JsonDeserializer userJsonDeserializer;
    protected PlayNowUserManager userManager;
    private UserChangeRevalidationPolicy userRevalidationPolicy;
    private ExceptionHandlingSingleThreadExecutor userSaveExecutor;
    private UserSettingsDao userSettingsDao;
    private JsonDeserializer userSettingsJsonDeserializer;
    private PreferencesUserSettingsStore userSettingsStore;
    private Task videoEntitlementCache;
    private NamespacedFileCache videoEntitlementFileCache;
    private TaskExecutor videoEntitlementTaskExecutor;
    private VideoPlayUtil videoPlayUtil;
    private VideoTracker videoTracker;
    private VideoTrackerSharedPreferenceProvider videoTrackerSharedPreferenceProvider;
    private LruLinkedHashMap volatileDownloadableFileCache;
    private WatchableClient watchableClient;
    private WatchableCodec watchableCodec;

    public PlayerContainer()
    {
    }

    public PlayerContainer(PlayerApplication playerapplication)
    {
        playerApplication = playerapplication;
        getConfiguration();
    }

    private Executor createSingleThreadedExecutor()
    {
        this;
        JVM INSTR monitorenter ;
        java.util.concurrent.ExecutorService executorservice = Executors.newSingleThreadExecutor();
        this;
        JVM INSTR monitorexit ;
        return executorservice;
        Exception exception;
        exception;
        throw exception;
    }

    public static PlayerContainer getInstance()
    {
        com/comcast/cim/container/PlayerContainer;
        JVM INSTR monitorenter ;
        PlayerContainer playercontainer = instance;
        com/comcast/cim/container/PlayerContainer;
        JVM INSTR monitorexit ;
        return playercontainer;
        Exception exception;
        exception;
        throw exception;
    }

    private NormalizerFactory getLegacyNormalizerFactory()
    {
        if (legacyNormalizerFactory == null)
        {
            legacyNormalizerFactory = new NormalizerFactory() {

                final PlayerContainer this$0;

                public Normalizer get(String s)
                {
                    return new LegacyNormalizer(s);
                }

            
            {
                this$0 = PlayerContainer.this;
                super();
            }
            };
        }
        return legacyNormalizerFactory;
    }

    private NamespacedFileCache getParentalControlsFileCache()
    {
        if (parentalControlsFileCache == null)
        {
            parentalControlsFileCache = new NamespacedFileCache(getApplication(), "ParentalControlsCache");
        }
        return parentalControlsFileCache;
    }

    protected static void setInstance(PlayerContainer playercontainer)
    {
        com/comcast/cim/container/PlayerContainer;
        JVM INSTR monitorenter ;
        instance = playercontainer;
        CALContainer.setInstance(playercontainer);
        com/comcast/cim/container/PlayerContainer;
        JVM INSTR monitorexit ;
        return;
        playercontainer;
        throw playercontainer;
    }

    protected abstract AppUpgradeHelper createAppUpgradeHelper();

    public CoverArtImageLoader createCoverArtImageLoader()
    {
        this;
        JVM INSTR monitorenter ;
        CoverArtImageLoader coverartimageloader = new CoverArtImageLoader(getConfiguration().getEntityThumbnailUri(), createRemoteImageLoader(), getCoverArtCache(), playerApplication);
        this;
        JVM INSTR monitorexit ;
        return coverartimageloader;
        Exception exception;
        exception;
        throw exception;
    }

    public NetworkLogoImageLoader createNetworkLogoImageLoader()
    {
        this;
        JVM INSTR monitorenter ;
        NetworkLogoImageLoader networklogoimageloader = new NetworkLogoImageLoader(getConfiguration().getEntityThumbnailUri(), createRemoteImageLoader(), getNetworkLogoCache(), playerApplication);
        this;
        JVM INSTR monitorexit ;
        return networklogoimageloader;
        Exception exception;
        exception;
        throw exception;
    }

    public ProgramDetailArtImageLoader createProgramDetailArtImageLoader()
    {
        this;
        JVM INSTR monitorenter ;
        ProgramDetailArtImageLoader programdetailartimageloader = new ProgramDetailArtImageLoader(getConfiguration().getEntityThumbnailUri(), createRemoteImageLoader(), getProgramDetailArtCache(), playerApplication, getAndroidDevice());
        this;
        JVM INSTR monitorexit ;
        return programdetailartimageloader;
        Exception exception;
        exception;
        throw exception;
    }

    public RemoteImageLoader createRemoteImageLoader()
    {
        this;
        JVM INSTR monitorenter ;
        RemoteImageLoader remoteimageloader;
        remoteimageloader = new RemoteImageLoader(playerApplication);
        remoteimageloader.setMaxDownloadAttempts(1);
        this;
        JVM INSTR monitorexit ;
        return remoteimageloader;
        Exception exception;
        exception;
        throw exception;
    }

    protected Class getAnalyticsServiceClass()
    {
        return com/comcast/cim/analytics/PlayerAnalyticsService;
    }

    public volatile AndroidDevice getAndroidDevice()
    {
        return getAndroidDevice();
    }

    public PlayerAndroidDevice getAndroidDevice()
    {
        this;
        JVM INSTR monitorenter ;
        PlayerAndroidDevice playerandroiddevice;
        if (androidDevice == null)
        {
            androidDevice = new PlayerAndroidDevice(getApplication(), getResources(), getTelephonyManager(), getApplication().getResources().getString(com.xfinity.playerlib.R.string.appId));
        }
        playerandroiddevice = androidDevice;
        this;
        JVM INSTR monitorexit ;
        return playerandroiddevice;
        Exception exception;
        exception;
        throw exception;
    }

    public Provider getAppMeasurementProvider()
    {
        this;
        JVM INSTR monitorenter ;
        Provider provider;
        if (appMeasurementProvider == null)
        {
            appMeasurementProvider = new PlayNowAppMeasurementProvider(getApplication(), getAndroidDevice(), getPropertyService(), getApplication().getResources().getString(com.xfinity.playerlib.R.string.omniture_app_name));
        }
        provider = appMeasurementProvider;
        this;
        JVM INSTR monitorexit ;
        return provider;
        Exception exception;
        exception;
        throw exception;
    }

    public AppUpgradeHelper getAppUpgradeHelper()
    {
        if (appUpgradeHelper == null)
        {
            getUserManager();
        }
        return appUpgradeHelper;
    }

    public Appirater getAppirater()
    {
        this;
        JVM INSTR monitorenter ;
        Appirater appirater1;
        if (appirater == null)
        {
            appirater = new Appirater(getApplication(), getAppiraterConfig(), getInternetConnection(), isDebuggable(), getAndroidDevice());
        }
        appirater1 = appirater;
        this;
        JVM INSTR monitorexit ;
        return appirater1;
        Exception exception;
        exception;
        throw exception;
    }

    public com.ijsbrandslob.appirater.Appirater.Configuration getAppiraterConfig()
    {
        if (appiraterConfig == null)
        {
            appiraterConfig = new com.ijsbrandslob.appirater.Appirater.Configuration() {

                final PlayerContainer this$0;

                public int getDaysUntilPrompt()
                {
                    return 0;
                }

                public int getMillisBeforeReminding()
                {
                    return 60000;
                }

                public int getSignificantEventsUntilPrompt()
                {
                    return 1;
                }

                public int getUsesUntilPrompt()
                {
                    return 0;
                }

            
            {
                this$0 = PlayerContainer.this;
                super();
            }
            };
        }
        return appiraterConfig;
    }

    public volatile Application getApplication()
    {
        return getApplication();
    }

    public PlayerApplication getApplication()
    {
        this;
        JVM INSTR monitorenter ;
        PlayerApplication playerapplication = playerApplication;
        this;
        JVM INSTR monitorexit ;
        return playerapplication;
        Exception exception;
        exception;
        throw exception;
    }

    public AuthenticationStrategy getAuthenticationStrategy()
    {
        this;
        JVM INSTR monitorenter ;
        PlayerAuthenticationStrategy playerauthenticationstrategy;
        if (authStrategy == null)
        {
            authStrategy = new PlayerAuthenticationStrategy(getUserManager());
        }
        playerauthenticationstrategy = authStrategy;
        this;
        JVM INSTR monitorexit ;
        return playerauthenticationstrategy;
        Exception exception;
        exception;
        throw exception;
    }

    public abstract List getAvailableConfigurations();

    public BookmarkUtils getBookmarkUtils()
    {
        this;
        JVM INSTR monitorenter ;
        BookmarkUtils bookmarkutils;
        if (bookmarkUtils == null)
        {
            bookmarkUtils = new BookmarkUtils(getFavoriteDAO(), getLiveStreamBookmarkDAO());
        }
        bookmarkutils = bookmarkUtils;
        this;
        JVM INSTR monitorexit ;
        return bookmarkutils;
        Exception exception;
        exception;
        throw exception;
    }

    public CimAssetFactory getCimAssetFactory()
    {
        this;
        JVM INSTR monitorenter ;
        CimAssetFactory cimassetfactory;
        if (cimAssetFactory == null)
        {
            cimAssetFactory = new CimAssetFactory();
        }
        cimassetfactory = cimAssetFactory;
        this;
        JVM INSTR monitorexit ;
        return cimassetfactory;
        Exception exception;
        exception;
        throw exception;
    }

    public volatile CALConfiguration getConfiguration()
    {
        return getConfiguration();
    }

    public abstract PlayerConfiguration getConfiguration();

    public abstract String getConfigurationVersion();

    public ConsumableVideoListHelper getConsumableVideoListHelper()
    {
        this;
        JVM INSTR monitorenter ;
        ConsumableVideoListHelper consumablevideolisthelper;
        if (consumableVideoListHelper == null)
        {
            consumableVideoListHelper = new ConsumableVideoListHelper();
        }
        consumablevideolisthelper = consumableVideoListHelper;
        this;
        JVM INSTR monitorexit ;
        return consumablevideolisthelper;
        Exception exception;
        exception;
        throw exception;
    }

    public Task getConsumablesHypermediaServicesCache()
    {
        this;
        JVM INSTR monitorenter ;
        Task task;
        if (consumablesHypermediaServiceTask == null)
        {
            consumablesHypermediaServiceTask = new ConsumablesHypermediaServicesCache(getHypermediaServicesRevalidationPolicy(), getHalHttpClient(), getConfiguration().getConsumablesHypermediaUrl());
        }
        task = consumablesHypermediaServiceTask;
        this;
        JVM INSTR monitorexit ;
        return task;
        Exception exception;
        exception;
        throw exception;
    }

    public AbstractImageCache getCoverArtCache()
    {
        this;
        JVM INSTR monitorenter ;
        if (coverArtCache != null) goto _L2; else goto _L1
_L1:
        if (((ActivityManager)playerApplication.getSystemService("activity")).getMemoryClass() < 48)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        coverArtCache = new DecodedImageCache(72, 72, 7200L, 5);
_L3:
        coverArtCache.enableDiskCache(playerApplication, 0);
_L2:
        AbstractImageCache abstractimagecache = coverArtCache;
        this;
        JVM INSTR monitorexit ;
        return abstractimagecache;
        coverArtCache = new DecodedImageCache(18, 18, 7200L, 5);
          goto _L3
        Exception exception;
        exception;
        throw exception;
    }

    public String getDeepLinkingScheme()
    {
        this;
        JVM INSTR monitorenter ;
        String s;
        if (deepLinkingScheme == null)
        {
            deepLinkingScheme = getResources().getString(com.xfinity.playerlib.R.string.deep_linking_scheme);
        }
        s = deepLinkingScheme;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public OrientationStrategy getDefaultOrientationStrategy()
    {
        this;
        JVM INSTR monitorenter ;
        OrientationStrategy orientationstrategy;
        if (defaultOrientationStrategy == null)
        {
            defaultOrientationStrategy = new OrientationStrategy() {

                final PlayerContainer this$0;

                public int getAppropriateOrientation()
                {
                    int i = 4;
                    if (!getAndroidDevice().isTabletDevice())
                    {
                        i = getAndroidDevice().getPortraitOrientation();
                    }
                    return i;
                }

            
            {
                this$0 = PlayerContainer.this;
                super();
            }
            };
        }
        orientationstrategy = defaultOrientationStrategy;
        this;
        JVM INSTR monitorexit ;
        return orientationstrategy;
        Exception exception;
        exception;
        throw exception;
    }

    public Task getDibicCombinedCache()
    {
        this;
        JVM INSTR monitorenter ;
        Task task;
        if (dibicCombinedCache == null)
        {
            dibicCombinedCache = new CompositeDibicResourceCache(new Task[] {
                getDibicMovieCache(), getDibicSeriesCache()
            });
        }
        task = dibicCombinedCache;
        this;
        JVM INSTR monitorexit ;
        return task;
        Exception exception;
        exception;
        throw exception;
    }

    public TaskExecutor getDibicCombinedTaskExecutor()
    {
        this;
        JVM INSTR monitorenter ;
        TaskExecutor taskexecutor;
        if (dibicCombinedTaskExecutor == null)
        {
            dibicCombinedTaskExecutor = new DefaultTaskExecutor(getDibicCombinedCache(), createSingleThreadedExecutor(), getUiThreadExecutor());
        }
        taskexecutor = dibicCombinedTaskExecutor;
        this;
        JVM INSTR monitorexit ;
        return taskexecutor;
        Exception exception;
        exception;
        throw exception;
    }

    public Task getDibicMovieCache()
    {
        this;
        JVM INSTR monitorenter ;
        Task task;
        if (dibicMovieCache == null)
        {
            DibicMovieUriProvider dibicmovieuriprovider = new DibicMovieUriProvider(getConsumablesHypermediaServicesCache());
            dibicMovieCache = new DibicResourceCache(new PermanentlyCachingHttpService(new DefaultHttpService(getHttpClient()), getPermanentFileCache()), dibicmovieuriprovider, new DibicMovieFactory(), getTagsRootCache(), getDefaultRevalidationPolicy(), "DibicMovieCache", getHttpRequestProviderFactory(), getDibicParser(), getUserManager());
        }
        task = dibicMovieCache;
        this;
        JVM INSTR monitorexit ;
        return task;
        Exception exception;
        exception;
        throw exception;
    }

    public DibicParser getDibicParser()
    {
        this;
        JVM INSTR monitorenter ;
        DibicParser dibicparser;
        if (dibicParser == null)
        {
            dibicParser = new DibicParser();
        }
        dibicparser = dibicParser;
        this;
        JVM INSTR monitorexit ;
        return dibicparser;
        Exception exception;
        exception;
        throw exception;
    }

    protected DibicProgramFilterFactory getDibicProgramFilterFactory()
    {
        return new DefaultDibicProgramFilterFactory();
    }

    public Task getDibicSeriesCache()
    {
        this;
        JVM INSTR monitorenter ;
        Task task;
        if (dibicSeriesCache == null)
        {
            DibicTvSeriesUriProvider dibictvseriesuriprovider = new DibicTvSeriesUriProvider(getConsumablesHypermediaServicesCache());
            dibicSeriesCache = new DibicResourceCache(new PermanentlyCachingHttpService(new DefaultHttpService(getHttpClient()), getPermanentFileCache()), dibictvseriesuriprovider, new DibicSeriesFactory(), getTagsRootCache(), getDefaultRevalidationPolicy(), "DibicSeriesCache", getHttpRequestProviderFactory(), getDibicParser(), getUserManager());
        }
        task = dibicSeriesCache;
        this;
        JVM INSTR monitorexit ;
        return task;
        Exception exception;
        exception;
        throw exception;
    }

    public ErrorFormatter getDownloadErrorFormatter()
    {
        this;
        JVM INSTR monitorenter ;
        ErrorFormatter errorformatter;
        if (downloadErrorFormatter == null)
        {
            Resources resources = getResources();
            java.util.ArrayList arraylist = Lists.newArrayList();
            arraylist.add(new DownloadsAmsErrorFormatter(resources));
            arraylist.add(getErrorFormatter());
            downloadErrorFormatter = new ChainedErrorFormatter(arraylist);
        }
        errorformatter = downloadErrorFormatter;
        this;
        JVM INSTR monitorexit ;
        return errorformatter;
        Exception exception;
        exception;
        throw exception;
    }

    public JsonDeserializer getDownloadMetaDataDeserializer()
    {
        this;
        JVM INSTR monitorenter ;
        JsonDeserializer jsondeserializer;
        if (downloadMetaDataJsonDeserializer == null)
        {
            downloadMetaDataJsonDeserializer = new JsonDeserializer(getObjectMapper());
        }
        jsondeserializer = downloadMetaDataJsonDeserializer;
        this;
        JVM INSTR monitorexit ;
        return jsondeserializer;
        Exception exception;
        exception;
        throw exception;
    }

    public PlayerDownloadServiceManager getDownloadServiceManager()
    {
        this;
        JVM INSTR monitorenter ;
        PlayerDownloadServiceManager playerdownloadservicemanager;
        if (downloadsManager == null)
        {
            getUserManager();
        }
        playerdownloadservicemanager = downloadsManager;
        this;
        JVM INSTR monitorexit ;
        return playerdownloadservicemanager;
        Exception exception;
        exception;
        throw exception;
    }

    public DownloadableFileFactory getDownloadableFileFactory()
    {
        this;
        JVM INSTR monitorenter ;
        DownloadableFileFactory downloadablefilefactory;
        if (downloadableFileFactory == null)
        {
            downloadableFileFactory = new DownloadableFileFactory(getPersistentEntityCache(), getDownloadMetaDataDeserializer(), getWatchableCodec());
        }
        downloadablefilefactory = downloadableFileFactory;
        this;
        JVM INSTR monitorexit ;
        return downloadablefilefactory;
        Exception exception;
        exception;
        throw exception;
    }

    public DownloadsItemListener getDownloadsItemListDelegate()
    {
        if (downloadsItemListenerDelegate == null)
        {
            downloadsItemListenerDelegate = new DownloadsItemListenerDelegate(getDownloadServiceManager(), getApplication());
        }
        return downloadsItemListenerDelegate;
    }

    public DownloadsSortPolicy getDownloadsSortPolicy()
    {
        this;
        JVM INSTR monitorenter ;
        DownloadsSortPolicy downloadssortpolicy;
        if (downloadsSortPolicy == null)
        {
            downloadsSortPolicy = new DownloadsSortPolicy(getUserManager());
        }
        downloadssortpolicy = downloadsSortPolicy;
        this;
        JVM INSTR monitorexit ;
        return downloadssortpolicy;
        Exception exception;
        exception;
        throw exception;
    }

    public Task getEditorVideoCoverResourceCache()
    {
        this;
        JVM INSTR monitorenter ;
        Task task;
        if (editorVideoCoverResourceCache == null)
        {
            editorVideoCoverResourceCache = new EditorialResourceCache(new PermanentlyCachingHttpService(new DefaultHttpService(getHttpClient()), getPermanentFileCache()), getConfiguration().getEditorialCoversUri().toString(), getDefaultRevalidationPolicy(), "EditorialVideoCoverCache", getHttpRequestProviderFactory(), new CoverParser(), new EditorialResourceFactory() {

                final PlayerContainer this$0;

                public EditorialVideoCoverResource createResource(CoverParser coverparser, String s)
                {
                    return new EditorialVideoCoverResource(coverparser.getPrograms(s), coverparser.getCollectionTitle(s));
                }

                public volatile Object createResource(Object obj, String s)
                {
                    return createResource((CoverParser)obj, s);
                }

            
            {
                this$0 = PlayerContainer.this;
                super();
            }
            });
        }
        task = editorVideoCoverResourceCache;
        this;
        JVM INSTR monitorexit ;
        return task;
        Exception exception;
        exception;
        throw exception;
    }

    public Task getEditorialMovieAndSeriesResourceCache()
    {
        this;
        JVM INSTR monitorenter ;
        Task task;
        if (editorialMovieAndSeriesResourceCache == null)
        {
            editorialMovieAndSeriesResourceCache = new EditorialResourceCache(new PermanentlyCachingHttpService(new DefaultHttpService(getHttpClient()), getPermanentFileCache()), getConfiguration().getEditorialVideoUri().toString(), getDefaultRevalidationPolicy(), "EditorialResourceCache", getHttpRequestProviderFactory(), new VideoParser(createCoverArtImageLoader()), new EditorialResourceFactory() {

                final PlayerContainer this$0;

                public EditorialMovieAndSeriesResource createResource(VideoParser videoparser, String s)
                {
                    return new EditorialMovieAndSeriesResource(videoparser.getMovies(s), videoparser.getMovieCollectionTitle(s), videoparser.getSeries(s), videoparser.getSeriesCollectionTitle(s));
                }

                public volatile Object createResource(Object obj, String s)
                {
                    return createResource((VideoParser)obj, s);
                }

            
            {
                this$0 = PlayerContainer.this;
                super();
            }
            });
        }
        task = editorialMovieAndSeriesResourceCache;
        this;
        JVM INSTR monitorexit ;
        return task;
        Exception exception;
        exception;
        throw exception;
    }

    public FavoriteDAO getFavoriteDAO()
    {
        this;
        JVM INSTR monitorenter ;
        FavoriteDAO favoritedao;
        if (favoriteDAO == null)
        {
            favoriteDAO = new FavoriteDAO(getPlayNowDatabase(), getUserManager());
        }
        favoritedao = favoriteDAO;
        this;
        JVM INSTR monitorexit ;
        return favoritedao;
        Exception exception;
        exception;
        throw exception;
    }

    public Task getFeaturedResourceCache()
    {
        this;
        JVM INSTR monitorenter ;
        Task task;
        if (featuredResourceCache == null)
        {
            featuredResourceCache = new FeaturedResourceCache(getEditorialMovieAndSeriesResourceCache(), getEditorVideoCoverResourceCache());
        }
        task = featuredResourceCache;
        this;
        JVM INSTR monitorexit ;
        return task;
        Exception exception;
        exception;
        throw exception;
    }

    public AnalyticsLogger getFoxAnalyticsLogger()
    {
        if (foxAnalyticsLogger == null)
        {
            foxAnalyticsLogger = new AnalyticsTaskQueueLogger(getAnalyticsTaskQueue(), getConfiguration().getSplunkAppName(), "http://foxnet.demdex.net/event?");
        }
        return foxAnalyticsLogger;
    }

    public HalHttpClient getHalHttpClient()
    {
        this;
        JVM INSTR monitorenter ;
        HalHttpClient halhttpclient;
        if (halHttpClient == null)
        {
            HalRequestProviderFactory halrequestproviderfactory = new HalRequestProviderFactory(getHttpRequestProviderFactory());
            halHttpClient = new HalHttpClient(new DefaultHttpService(getHttpClient()), halrequestproviderfactory, getHypermediaClient());
        }
        halhttpclient = halHttpClient;
        this;
        JVM INSTR monitorexit ;
        return halhttpclient;
        Exception exception;
        exception;
        throw exception;
    }

    protected RequestSignerFactory getHttpRequestSignerFactory()
    {
        if (requestSignerFactory == null)
        {
            requestSignerFactory = new RequestSignerFactory() {

                final PlayerContainer this$0;

                public RequestSigner create(String s, String s1)
                {
                    return new OAuthRequestSigner(s, s1);
                }

            
            {
                this$0 = PlayerContainer.this;
                super();
            }
            };
        }
        return requestSignerFactory;
    }

    public HypermediaClient getHypermediaClient()
    {
        this;
        JVM INSTR monitorenter ;
        HypermediaClientImpl hypermediaclientimpl;
        if (hypermediaClient == null)
        {
            hypermediaClient = new HypermediaClientImpl();
        }
        hypermediaclientimpl = hypermediaClient;
        this;
        JVM INSTR monitorexit ;
        return hypermediaclientimpl;
        Exception exception;
        exception;
        throw exception;
    }

    public MinimumIntervalRevalidationPolicy getHypermediaServicesRevalidationPolicy()
    {
        this;
        JVM INSTR monitorenter ;
        MinimumIntervalRevalidationPolicy minimumintervalrevalidationpolicy;
        if (hypermediaRevalidationPolicy == null)
        {
            hypermediaRevalidationPolicy = new MinimumIntervalRevalidationPolicy(getConfiguration().getHypermediaRevalidationInterval());
        }
        minimumintervalrevalidationpolicy = hypermediaRevalidationPolicy;
        this;
        JVM INSTR monitorexit ;
        return minimumintervalrevalidationpolicy;
        Exception exception;
        exception;
        throw exception;
    }

    public LaunchIntentInterceptor getLaunchIntentInterceptor()
    {
        this;
        JVM INSTR monitorenter ;
        PlayNowLaunchIntentInterceptor playnowlaunchintentinterceptor;
        if (playNowLaunchIntentInterceptor == null)
        {
            playNowLaunchIntentInterceptor = new PlayNowLaunchIntentInterceptor(getApplication(), getLaunchStrategy(), getAndroidDevice(), getDeepLinkingScheme());
        }
        playnowlaunchintentinterceptor = playNowLaunchIntentInterceptor;
        this;
        JVM INSTR monitorexit ;
        return playnowlaunchintentinterceptor;
        Exception exception;
        exception;
        throw exception;
    }

    public volatile LaunchStrategy getLaunchStrategy()
    {
        return getLaunchStrategy();
    }

    public PlayerLaunchStrategy getLaunchStrategy()
    {
        this;
        JVM INSTR monitorenter ;
        PlayerLaunchStrategy playerlaunchstrategy;
        if (launchStrategy == null)
        {
            launchStrategy = new PlayerLaunchStrategy();
        }
        playerlaunchstrategy = launchStrategy;
        this;
        JVM INSTR monitorexit ;
        return playerlaunchstrategy;
        Exception exception;
        exception;
        throw exception;
    }

    public android.view.LayoutInflater.Factory getLayoutInflatorFactory()
    {
        this;
        JVM INSTR monitorenter ;
        android.view.LayoutInflater.Factory factory;
        if (layoutInflaterFactory == null)
        {
            layoutInflaterFactory = new android.view.LayoutInflater.Factory() {

                final PlayerContainer this$0;

                public View onCreateView(String s, Context context, AttributeSet attributeset)
                {
                    String s1 = getConfiguration().getXfinitySansFamilyName();
                    if (TextUtils.equals(s, "TextView"))
                    {
                        s = new CustomTypefaceTextView(context, attributeset);
                        s.setupDelegate(context, attributeset, 0, getTypefaceManager());
                        s.setTypefaceFamilyName(s1);
                        return s;
                    }
                    if (TextUtils.equals(s, "EditText"))
                    {
                        s = new CustomTypefaceEditText(context, attributeset);
                        s.setupDelegate(context, attributeset, 0, getTypefaceManager());
                        s.setTypefaceFamilyName(s1);
                        return s;
                    }
                    if (TextUtils.equals(s, "Button"))
                    {
                        s = new CustomTypefaceButton(context, attributeset);
                        s.setupDelegate(context, attributeset, 0, getTypefaceManager());
                        s.setTypefaceFamilyName(s1);
                        return s;
                    } else
                    {
                        return null;
                    }
                }

            
            {
                this$0 = PlayerContainer.this;
                super();
            }
            };
        }
        factory = layoutInflaterFactory;
        this;
        JVM INSTR monitorexit ;
        return factory;
        Exception exception;
        exception;
        throw exception;
    }

    public Task getLiveFeaturedContentResourceCache()
    {
        this;
        JVM INSTR monitorenter ;
        Task task;
        if (liveFeaturedContentResourceCache == null)
        {
            liveFeaturedContentResourceCache = new HalLiveFeaturedContentResourceCache(getTveHypermediaServicesCache(), new HalLiveFeaturedContentResourceFactory(), getHalHttpClient(), getDefaultRevalidationPolicy());
        }
        task = liveFeaturedContentResourceCache;
        this;
        JVM INSTR monitorexit ;
        return task;
        Exception exception;
        exception;
        throw exception;
    }

    public LiveStreamBookmarkDAO getLiveStreamBookmarkDAO()
    {
        this;
        JVM INSTR monitorenter ;
        LiveStreamBookmarkDAO livestreambookmarkdao;
        if (liveStreamBookmarkDAO == null)
        {
            liveStreamBookmarkDAO = new CachingLiveStreamBookmarkDAO(new DefaultLiveStreamBookmarkDAO(getPlayNowDatabase(), getUserManager()), getUserAndIntervalRevalidationPolicy(), 200);
        }
        livestreambookmarkdao = liveStreamBookmarkDAO;
        this;
        JVM INSTR monitorexit ;
        return livestreambookmarkdao;
        Exception exception;
        exception;
        throw exception;
    }

    public TaskFactory getLiveStreamMetaDataResourceFactory()
    {
        this;
        JVM INSTR monitorenter ;
        TaskFactory taskfactory;
        if (liveStreamMetaDataResourceFactory == null)
        {
            liveStreamMetaDataResourceFactory = new CachingTaskFactory(new TaskFactory() {

                final PlayerContainer this$0;

                public volatile Task get(Object obj)
                {
                    return get((String)obj);
                }

                public Task get(String s)
                {
                    return new HalLiveStreamMetaDataResource(getTveHypermediaServicesCache(), new HalLiveStreamFactory(), getHalHttpClient(), s);
                }

            
            {
                this$0 = PlayerContainer.this;
                super();
            }
            }, 100);
        }
        taskfactory = liveStreamMetaDataResourceFactory;
        this;
        JVM INSTR monitorexit ;
        return taskfactory;
        Exception exception;
        exception;
        throw exception;
    }

    public Task getLiveStreamResourceCache()
    {
        this;
        JVM INSTR monitorenter ;
        Task task;
        if (liveStreamResourceCache == null)
        {
            liveStreamResourceCache = new HalLiveStreamResourceCache(getTveHypermediaServicesCache(), new HalLiveStreamResourceFactory(), getHalHttpClient(), getDefaultRevalidationPolicy(), getConfiguration());
        }
        task = liveStreamResourceCache;
        this;
        JVM INSTR monitorexit ;
        return task;
        Exception exception;
        exception;
        throw exception;
    }

    public MediaLicenseClient getMediaLicenseClient()
    {
        this;
        JVM INSTR monitorenter ;
        MediaLicenseClient medialicenseclient;
        if (mediaLicenseClient == null)
        {
            mediaLicenseClient = new MediaLicenseClient(getSplunkLogger(), getErrorFormatter(), getUserManager().getHashedOmnitureGuid(), getApplication().getVersionNumber());
        }
        medialicenseclient = mediaLicenseClient;
        this;
        JVM INSTR monitorexit ;
        return medialicenseclient;
        Exception exception;
        exception;
        throw exception;
    }

    public MediaLicenseRenewalScheduler getMediaLicenseRenewalScheduler()
    {
        this;
        JVM INSTR monitorenter ;
        MediaLicenseRenewalScheduler medialicenserenewalscheduler;
        if (mediaLicenseRenewalScheduler == null)
        {
            mediaLicenseRenewalScheduler = new MediaLicenseRenewalScheduler(getApplication());
        }
        medialicenserenewalscheduler = mediaLicenseRenewalScheduler;
        this;
        JVM INSTR monitorexit ;
        return medialicenserenewalscheduler;
        Exception exception;
        exception;
        throw exception;
    }

    public TaskFactory getMovieCacheMap()
    {
        this;
        JVM INSTR monitorenter ;
        TaskFactory taskfactory;
        if (movieCacheMap == null)
        {
            movieCacheMap = new CachingTaskFactory(new TaskFactory() {

                final PlayerContainer this$0;

                public Task get(MerlinId merlinid)
                {
                    return new HalMovieConsumableCache(new HalMovieFactory(), getHalHttpClient(), getDefaultRevalidationPolicy(), getConsumablesHypermediaServicesCache(), getAndroidDevice(), merlinid);
                }

                public volatile Task get(Object obj)
                {
                    return get((MerlinId)obj);
                }

            
            {
                this$0 = PlayerContainer.this;
                super();
            }
            }, 100);
        }
        taskfactory = movieCacheMap;
        this;
        JVM INSTR monitorexit ;
        return taskfactory;
        Exception exception;
        exception;
        throw exception;
    }

    public MovieCollectionSortPolicy getMovieCollectionSortPolicy()
    {
        this;
        JVM INSTR monitorenter ;
        MovieCollectionSortPolicy moviecollectionsortpolicy;
        if (movieCollectionSortPolicy == null)
        {
            movieCollectionSortPolicy = new MovieCollectionSortPolicy(getUserManager());
        }
        moviecollectionsortpolicy = movieCollectionSortPolicy;
        this;
        JVM INSTR monitorexit ;
        return moviecollectionsortpolicy;
        Exception exception;
        exception;
        throw exception;
    }

    public TaskExecutor getMoviesAndEntitlementTaskExecutor()
    {
        this;
        JVM INSTR monitorenter ;
        TaskExecutor taskexecutor;
        if (moviesAndEntitlementTaskExecutor == null)
        {
            moviesAndEntitlementTaskExecutor = new DefaultTaskExecutor(new TupleTask(getDibicMovieCache(), getVideoEntitlementCache()), createSingleThreadedExecutor(), getUiThreadExecutor());
        }
        taskexecutor = moviesAndEntitlementTaskExecutor;
        this;
        JVM INSTR monitorexit ;
        return taskexecutor;
        Exception exception;
        exception;
        throw exception;
    }

    public TaskExecutor getMoviesAndTagsAndEntitlementTaskExecutor()
    {
        this;
        JVM INSTR monitorenter ;
        TaskExecutor taskexecutor;
        if (moviesAndTagsAndEntitlementTaskExecutor == null)
        {
            moviesAndTagsAndEntitlementTaskExecutor = new DefaultTaskExecutor(new Tuple3Task(getDibicMovieCache(), getTagsRootCache(), getVideoEntitlementCache()), createSingleThreadedExecutor(), getUiThreadExecutor());
        }
        taskexecutor = moviesAndTagsAndEntitlementTaskExecutor;
        this;
        JVM INSTR monitorexit ;
        return taskexecutor;
        Exception exception;
        exception;
        throw exception;
    }

    public MoviesSortPolicy getMoviesSortPolicy()
    {
        this;
        JVM INSTR monitorenter ;
        MoviesSortPolicy moviessortpolicy;
        if (moviesSortPolicy == null)
        {
            moviesSortPolicy = new MoviesSortPolicy(getUserManager());
        }
        moviessortpolicy = moviesSortPolicy;
        this;
        JVM INSTR monitorexit ;
        return moviessortpolicy;
        Exception exception;
        exception;
        throw exception;
    }

    public AbstractImageCache getNetworkLogoCache()
    {
        this;
        JVM INSTR monitorenter ;
        AbstractImageCache abstractimagecache;
        if (networkLogoCache == null)
        {
            networkLogoCache = new DecodedImageCache(150, 150, 7200L, 5);
            networkLogoCache.enableDiskCache(playerApplication, 0);
        }
        abstractimagecache = networkLogoCache;
        this;
        JVM INSTR monitorexit ;
        return abstractimagecache;
        Exception exception;
        exception;
        throw exception;
    }

    public Task getNonDegradingVideoEntitlementCache()
    {
        this;
        JVM INSTR monitorenter ;
        Task task;
        if (nonDegradingVideoEntitlementCache == null)
        {
            nonDegradingVideoEntitlementCache = new VideoEntitlementCache(new PermanentlyCachingHttpService(new DefaultHttpService(getHttpClient()), getVideoEntitlementFileCache()), getUserAndIntervalRevalidationPolicy(), getUserManager(), getXipRequestProviderFactory(), getHttpRequestSignerFactory(), getObjectMapper());
        }
        task = nonDegradingVideoEntitlementCache;
        this;
        JVM INSTR monitorexit ;
        return task;
        Exception exception;
        exception;
        throw exception;
    }

    public TaskExecutor getNonDegradingVideoEntitlementProvider()
    {
        this;
        JVM INSTR monitorenter ;
        TaskExecutor taskexecutor;
        if (nonDegradingVideoEntitlementProvider == null)
        {
            nonDegradingVideoEntitlementProvider = new DefaultTaskExecutor(getNonDegradingVideoEntitlementCache(), createSingleThreadedExecutor(), getUiThreadExecutor());
        }
        taskexecutor = nonDegradingVideoEntitlementProvider;
        this;
        JVM INSTR monitorexit ;
        return taskexecutor;
        Exception exception;
        exception;
        throw exception;
    }

    public NotificationQueueManager getNotificationQueueManager()
    {
        this;
        JVM INSTR monitorenter ;
        NotificationQueueManager notificationqueuemanager;
        if (notificationQueueManager == null)
        {
            notificationQueueManager = new NotificationQueueManager(getApplication());
        }
        notificationqueuemanager = notificationQueueManager;
        this;
        JVM INSTR monitorexit ;
        return notificationqueuemanager;
        Exception exception;
        exception;
        throw exception;
    }

    public NullSortPolicy getNullSortPolicy()
    {
        this;
        JVM INSTR monitorenter ;
        NullSortPolicy nullsortpolicy;
        if (nullSortPolicy == null)
        {
            nullSortPolicy = new NullSortPolicy();
        }
        nullsortpolicy = nullSortPolicy;
        this;
        JVM INSTR monitorexit ;
        return nullsortpolicy;
        Exception exception;
        exception;
        throw exception;
    }

    public ObjectMapper getObjectMapper()
    {
        this;
        JVM INSTR monitorenter ;
        ObjectMapper objectmapper;
        if (playerObjectMapper == null)
        {
            playerObjectMapper = super.getObjectMapper();
        }
        objectmapper = playerObjectMapper;
        this;
        JVM INSTR monitorexit ;
        return objectmapper;
        Exception exception;
        exception;
        throw exception;
    }

    public Task getParentalControlsCache()
    {
        this;
        JVM INSTR monitorenter ;
        Task task;
        if (parentalControlsCache == null)
        {
            parentalControlsCache = new ParentalControlsCache(new PermanentlyCachingHttpService(new DefaultHttpService(getHttpClient()), getParentalControlsFileCache()), getUserAndIntervalRevalidationPolicy(), getXipServer(), getUserManager(), getObjectMapper(), getHttpRequestProviderFactory(), getHttpRequestSignerFactory());
        }
        task = parentalControlsCache;
        this;
        JVM INSTR monitorexit ;
        return task;
        Exception exception;
        exception;
        throw exception;
    }

    public TaskExecutor getParentalControlsSettingsTaskExecutor()
    {
        this;
        JVM INSTR monitorenter ;
        TaskExecutor taskexecutor;
        if (parentalControlsSettingsTaskExecutor == null)
        {
            parentalControlsSettingsTaskExecutor = new DefaultTaskExecutor(getParentalControlsCache(), createSingleThreadedExecutor(), getUiThreadExecutor());
        }
        taskexecutor = parentalControlsSettingsTaskExecutor;
        this;
        JVM INSTR monitorexit ;
        return taskexecutor;
        Exception exception;
        exception;
        throw exception;
    }

    public PersistentCaptionsCache getPersistentCaptionsCache()
    {
        this;
        JVM INSTR monitorenter ;
        PersistentCaptionsCache persistentcaptionscache;
        if (persistentCaptionsCache == null)
        {
            persistentCaptionsCache = new PersistentCaptionsCache(new NamespacedFileCache(getApplication(), PersistentCaptionsCache.NAMESPACE, getLegacyNormalizerFactory()));
        }
        persistentcaptionscache = persistentCaptionsCache;
        this;
        JVM INSTR monitorexit ;
        return persistentcaptionscache;
        Exception exception;
        exception;
        throw exception;
    }

    public PersistentEntityCache getPersistentEntityCache()
    {
        this;
        JVM INSTR monitorenter ;
        PersistentEntityCache persistententitycache;
        if (persistentEntityCache == null)
        {
            persistentEntityCache = new PersistentEntityCache(new NamespacedFileCache(getApplication(), PersistentEntityCache.NAMESPACE, getLegacyNormalizerFactory()), getJsonSerializer(), getObjectMapper());
        }
        persistententitycache = persistentEntityCache;
        this;
        JVM INSTR monitorexit ;
        return persistententitycache;
        Exception exception;
        exception;
        throw exception;
    }

    public PlayNowDatabase getPlayNowDatabase()
    {
        this;
        JVM INSTR monitorenter ;
        PlayNowDatabase playnowdatabase;
        if (playNowDatabase == null)
        {
            playNowDatabase = new PlayNowDatabase(playerApplication);
        }
        playnowdatabase = playNowDatabase;
        this;
        JVM INSTR monitorexit ;
        return playnowdatabase;
        Exception exception;
        exception;
        throw exception;
    }

    public PlayerConfigUtil getPlayerConfigUtil()
    {
        this;
        JVM INSTR monitorenter ;
        PlayerConfigUtil playerconfigutil;
        if (playerConfigUtil == null)
        {
            playerConfigUtil = new PlayerConfigUtil(getAndroidDevice(), getUserManager(), isDebuggable());
        }
        playerconfigutil = playerConfigUtil;
        this;
        JVM INSTR monitorexit ;
        return playerconfigutil;
        Exception exception;
        exception;
        throw exception;
    }

    public ErrorFormatter getPlayerErrorFormatter()
    {
        this;
        JVM INSTR monitorenter ;
        ErrorFormatter errorformatter;
        if (playerErrorFormatter == null)
        {
            Resources resources = getResources();
            java.util.ArrayList arraylist = Lists.newArrayList();
            arraylist.add(new PlayerAmsErrorFormatter(resources));
            arraylist.add(new PlayerPlatformErrorFormatter(resources));
            arraylist.add(getErrorFormatter());
            playerErrorFormatter = new ChainedErrorFormatter(arraylist);
        }
        errorformatter = playerErrorFormatter;
        this;
        JVM INSTR monitorexit ;
        return errorformatter;
        Exception exception;
        exception;
        throw exception;
    }

    public PreferencesUserStore getPreferencesUserStore()
    {
        this;
        JVM INSTR monitorenter ;
        PreferencesUserStore preferencesuserstore;
        if (preferencesUserStore == null)
        {
            preferencesUserStore = new PreferencesUserStore(getSharedPreferences(), getJsonSerializer(), getUserJsonDeserializer(), com/xfinity/playerlib/model/user/PlayNowUser);
        }
        preferencesuserstore = preferencesUserStore;
        this;
        JVM INSTR monitorexit ;
        return preferencesuserstore;
        Exception exception;
        exception;
        throw exception;
    }

    public AbstractImageCache getProgramDetailArtCache()
    {
        this;
        JVM INSTR monitorenter ;
        if (programDetailArtCache != null) goto _L2; else goto _L1
_L1:
        if (((ActivityManager)playerApplication.getSystemService("activity")).getMemoryClass() < 48)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        programDetailArtCache = new DecodedImageCache(8, 8, 7200L, 5);
_L3:
        programDetailArtCache.enableDiskCache(playerApplication, 0);
_L2:
        AbstractImageCache abstractimagecache = programDetailArtCache;
        this;
        JVM INSTR monitorexit ;
        return abstractimagecache;
        programDetailArtCache = new DecodedImageCache(4, 4, 7200L, 5);
          goto _L3
        Exception exception;
        exception;
        throw exception;
    }

    public TaskExecutor getProgramsAndTagsAndEntitlementTaskExecutor()
    {
        this;
        JVM INSTR monitorenter ;
        TaskExecutor taskexecutor;
        if (programsAndTagsAndEntitlementTaskExecutor == null)
        {
            programsAndTagsAndEntitlementTaskExecutor = new DefaultTaskExecutor(new Tuple3Task(getDibicCombinedCache(), getTagsRootCache(), getVideoEntitlementCache()), createSingleThreadedExecutor(), getUiThreadExecutor());
        }
        taskexecutor = programsAndTagsAndEntitlementTaskExecutor;
        this;
        JVM INSTR monitorexit ;
        return taskexecutor;
        Exception exception;
        exception;
        throw exception;
    }

    public PropertyService getPropertyService()
    {
        this;
        JVM INSTR monitorenter ;
        if (propertyService == null)
        {
            if (!isDebuggable())
            {
                break MISSING_BLOCK_LABEL_36;
            }
            propertyService = new DebugPropertyService();
        }
_L1:
        PropertyService propertyservice = propertyService;
        this;
        JVM INSTR monitorexit ;
        return propertyservice;
        propertyService = new ReleasePropertyService();
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    public RegisterDeviceClient getRegisterDeviceClient()
    {
        this;
        JVM INSTR monitorenter ;
        RegisterDeviceClient registerdeviceclient;
        if (registerDeviceClient == null)
        {
            registerDeviceClient = new RegisterDeviceClient(new DefaultHttpService(getHttpClient()), getAndroidDevice(), getObjectMapper(), getXipRequestProviderFactory(), getHttpRequestSignerFactory());
        }
        registerdeviceclient = registerDeviceClient;
        this;
        JVM INSTR monitorexit ;
        return registerdeviceclient;
        Exception exception;
        exception;
        throw exception;
    }

    public RegistrationListClient getRegistrationListClient()
    {
        this;
        JVM INSTR monitorenter ;
        RegistrationListClient registrationlistclient;
        if (registrationListClient == null)
        {
            registrationListClient = new RegistrationListClient(new DefaultHttpService(getHttpClient()), getObjectMapper(), getXipRequestProviderFactory(), getHttpRequestSignerFactory());
        }
        registrationlistclient = registrationListClient;
        this;
        JVM INSTR monitorexit ;
        return registrationlistclient;
        Exception exception;
        exception;
        throw exception;
    }

    public Provider getSearchQueryProvider()
    {
        this;
        JVM INSTR monitorenter ;
        Provider provider;
        if (searchQueryProvider == null)
        {
            searchQueryProvider = new SearchQueryProvider(getUserManager());
        }
        provider = searchQueryProvider;
        this;
        JVM INSTR monitorexit ;
        return provider;
        Exception exception;
        exception;
        throw exception;
    }

    public OrientationStrategy getSensorIfHasKeyboardOrientationStrategy()
    {
        this;
        JVM INSTR monitorenter ;
        OrientationStrategy orientationstrategy;
        if (sensorIfHasKeyboardOrientationStrategy == null)
        {
            sensorIfHasKeyboardOrientationStrategy = new OrientationStrategy() {

                final PlayerContainer this$0;

                public int getAppropriateOrientation()
                {
                    boolean flag = true;
                    byte byte0 = 4;
                    int i;
                    if (getResources().getConfiguration().keyboard == 1)
                    {
                        flag = false;
                    }
                    i = byte0;
                    if (getAndroidDevice().getDevicePhysicalSize() < 3)
                    {
                        i = byte0;
                        if (!flag)
                        {
                            i = getAndroidDevice().getPortraitOrientation();
                        }
                    }
                    return i;
                }

            
            {
                this$0 = PlayerContainer.this;
                super();
            }
            };
        }
        orientationstrategy = sensorIfHasKeyboardOrientationStrategy;
        this;
        JVM INSTR monitorexit ;
        return orientationstrategy;
        Exception exception;
        exception;
        throw exception;
    }

    public TaskExecutor getSeriesAndEntitlementTaskExecutor()
    {
        this;
        JVM INSTR monitorenter ;
        TaskExecutor taskexecutor;
        if (seriesAndEntitlementTaskExecutor == null)
        {
            seriesAndEntitlementTaskExecutor = new DefaultTaskExecutor(new TupleTask(getDibicSeriesCache(), getVideoEntitlementCache()), createSingleThreadedExecutor(), getUiThreadExecutor());
        }
        taskexecutor = seriesAndEntitlementTaskExecutor;
        this;
        JVM INSTR monitorexit ;
        return taskexecutor;
        Exception exception;
        exception;
        throw exception;
    }

    public TaskExecutor getSeriesAndTagsAndEntitlementTaskExecutor()
    {
        this;
        JVM INSTR monitorenter ;
        TaskExecutor taskexecutor;
        if (seriesAndTagsAndEntitlementTaskExecutor == null)
        {
            seriesAndTagsAndEntitlementTaskExecutor = new DefaultTaskExecutor(new Tuple3Task(getDibicSeriesCache(), getTagsRootCache(), getVideoEntitlementCache()), createSingleThreadedExecutor(), getUiThreadExecutor());
        }
        taskexecutor = seriesAndTagsAndEntitlementTaskExecutor;
        this;
        JVM INSTR monitorexit ;
        return taskexecutor;
        Exception exception;
        exception;
        throw exception;
    }

    public TaskFactory getSeriesCacheMap()
    {
        this;
        JVM INSTR monitorenter ;
        TaskFactory taskfactory;
        if (seriesCacheMap == null)
        {
            seriesCacheMap = new CachingTaskFactory(new TaskFactory() {

                final PlayerContainer this$0;

                public Task get(MerlinId merlinid)
                {
                    return new HalTvSeriesConsumableCache(new HalTvSeriesFactory(), getHalHttpClient(), getDefaultRevalidationPolicy(), getConsumablesHypermediaServicesCache(), getAndroidDevice(), merlinid);
                }

                public volatile Task get(Object obj)
                {
                    return get((MerlinId)obj);
                }

            
            {
                this$0 = PlayerContainer.this;
                super();
            }
            }, 100);
        }
        taskfactory = seriesCacheMap;
        this;
        JVM INSTR monitorexit ;
        return taskfactory;
        Exception exception;
        exception;
        throw exception;
    }

    public SeriesCollectionSortPolicy getSeriesCollectionSortPolicy()
    {
        this;
        JVM INSTR monitorenter ;
        SeriesCollectionSortPolicy seriescollectionsortpolicy;
        if (seriesCollectionSortPolicy == null)
        {
            seriesCollectionSortPolicy = new SeriesCollectionSortPolicy(getUserManager());
        }
        seriescollectionsortpolicy = seriesCollectionSortPolicy;
        this;
        JVM INSTR monitorexit ;
        return seriescollectionsortpolicy;
        Exception exception;
        exception;
        throw exception;
    }

    public SeriesCombinedTaskExecutorFactory getSeriesCombinedTaskExecutorFactory()
    {
        this;
        JVM INSTR monitorenter ;
        SeriesCombinedTaskExecutorFactory seriescombinedtaskexecutorfactory;
        if (seriesCombinedTaskExecutorFactory == null)
        {
            seriesCombinedTaskExecutorFactory = new SeriesCombinedTaskExecutorFactory(getTaskExecutorFactory(), getVideoEntitlementCache(), getDibicCombinedCache(), getVideoBookmarkDAO());
        }
        seriescombinedtaskexecutorfactory = seriesCombinedTaskExecutorFactory;
        this;
        JVM INSTR monitorexit ;
        return seriescombinedtaskexecutorfactory;
        Exception exception;
        exception;
        throw exception;
    }

    public SeriesSortPolicy getSeriesSortPolicy()
    {
        this;
        JVM INSTR monitorenter ;
        SeriesSortPolicy seriessortpolicy;
        if (seriesSortPolicy == null)
        {
            seriesSortPolicy = new SeriesSortPolicy(getUserManager());
        }
        seriessortpolicy = seriesSortPolicy;
        this;
        JVM INSTR monitorexit ;
        return seriessortpolicy;
        Exception exception;
        exception;
        throw exception;
    }

    public SideMenuBuilder getSideMenuBuilder()
    {
        this;
        JVM INSTR monitorenter ;
        SideMenuBuilder sidemenubuilder;
        if (sideMenuBuilder == null)
        {
            sideMenuBuilder = new PlayerSideMenuBuilder(getApplication());
        }
        sidemenubuilder = sideMenuBuilder;
        this;
        JVM INSTR monitorexit ;
        return sidemenubuilder;
        Exception exception;
        exception;
        throw exception;
    }

    public SideRibbonDelegateBuilder getSideRibbonDelegateBuilder()
    {
        this;
        JVM INSTR monitorenter ;
        SideRibbonDelegateBuilder sideribbondelegatebuilder;
        if (sideRibbonDelegateBuilder == null)
        {
            sideRibbonDelegateBuilder = (new SideRibbonDelegateBuilder(getAccessibilityUtil())).setBackgroundResource(Integer.valueOf(com.xfinity.playerlib.R.color.dark_gray_1)).setRibbonWidth(getApplication().getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.flyin_menu_width)).setSlideDuration(250L);
        }
        sideribbondelegatebuilder = sideRibbonDelegateBuilder;
        this;
        JVM INSTR monitorexit ;
        return sideribbondelegatebuilder;
        Exception exception;
        exception;
        throw exception;
    }

    public TaskExecutor getTagsAndProgramsTaskExecutor()
    {
        this;
        JVM INSTR monitorenter ;
        TaskExecutor taskexecutor;
        if (tagsAndProgramsTaskExecutor == null)
        {
            tagsAndProgramsTaskExecutor = new DefaultTaskExecutor(new TupleTask(getTagsRootCache(), getDibicCombinedCache()), createSingleThreadedExecutor(), getUiThreadExecutor());
        }
        taskexecutor = tagsAndProgramsTaskExecutor;
        this;
        JVM INSTR monitorexit ;
        return taskexecutor;
        Exception exception;
        exception;
        throw exception;
    }

    public Executor getTagsExecutor()
    {
        this;
        JVM INSTR monitorenter ;
        Executor executor;
        if (tagsExecutor == null)
        {
            tagsExecutor = createSingleThreadedExecutor();
        }
        executor = tagsExecutor;
        this;
        JVM INSTR monitorexit ;
        return executor;
        Exception exception;
        exception;
        throw exception;
    }

    public TagsParser getTagsParser()
    {
        this;
        JVM INSTR monitorenter ;
        TagsParser tagsparser;
        if (tagsParser == null)
        {
            tagsParser = new TagsParser(getObjectMapper());
        }
        tagsparser = tagsParser;
        this;
        JVM INSTR monitorexit ;
        return tagsparser;
        Exception exception;
        exception;
        throw exception;
    }

    public Task getTagsRootCache()
    {
        this;
        JVM INSTR monitorenter ;
        Task task;
        if (tagsRootCache == null)
        {
            tagsRootCache = new TagsRootCache(new PermanentlyCachingHttpService(new DefaultHttpService(getHttpClient()), getPermanentFileCache()), getConsumablesHypermediaServicesCache(), getDefaultRevalidationPolicy(), "TagsRootCache", getTagsParser(), getHttpRequestProviderFactory());
        }
        task = tagsRootCache;
        this;
        JVM INSTR monitorexit ;
        return task;
        Exception exception;
        exception;
        throw exception;
    }

    public TaskExecutor getTagsRootTaskExecutor()
    {
        this;
        JVM INSTR monitorenter ;
        TaskExecutor taskexecutor;
        if (tagsRootTaskExecutor == null)
        {
            tagsRootTaskExecutor = new DefaultTaskExecutor(getTagsRootCache(), getTagsExecutor(), getUiThreadExecutor());
        }
        taskexecutor = tagsRootTaskExecutor;
        this;
        JVM INSTR monitorexit ;
        return taskexecutor;
        Exception exception;
        exception;
        throw exception;
    }

    public ThePlatformClient getThePlatformClient()
    {
        this;
        JVM INSTR monitorenter ;
        ThePlatformClient theplatformclient;
        if (thePlatformClient == null)
        {
            thePlatformClient = new ThePlatformClient(new DefaultHttpService(getHttpClient()), getHttpRequestProviderFactory());
        }
        theplatformclient = thePlatformClient;
        this;
        JVM INSTR monitorexit ;
        return theplatformclient;
        Exception exception;
        exception;
        throw exception;
    }

    public TitaniumTicketClient getTitaniumTicketClient()
    {
        this;
        JVM INSTR monitorenter ;
        TitaniumTicketClient titaniumticketclient;
        if (titaniumTicketClient == null)
        {
            titaniumTicketClient = new TitaniumTicketClient(new DefaultHttpService(getHttpClient()), getObjectMapper(), getXipRequestProviderFactory(), getHttpRequestSignerFactory());
        }
        titaniumticketclient = titaniumTicketClient;
        this;
        JVM INSTR monitorexit ;
        return titaniumticketclient;
        Exception exception;
        exception;
        throw exception;
    }

    public volatile TrackingService getTrackingService()
    {
        return getTrackingService();
    }

    public PlayNowTrackingService getTrackingService()
    {
        this;
        JVM INSTR monitorenter ;
        PlayNowTrackingService playnowtrackingservice;
        if (trackingService == null)
        {
            trackingService = new PlayNowTrackingService(getUserManager(), playerApplication.getResources().getString(com.xfinity.playerlib.R.string.omniture_product_name), playerApplication.getResources().getString(com.xfinity.playerlib.R.string.omniture_version, new Object[] {
                playerApplication.getVersionNumber(), Integer.valueOf(playerApplication.getVersionCode())
            }), getAndroidDevice(), getAppMeasurementProvider());
        }
        playnowtrackingservice = trackingService;
        this;
        JVM INSTR monitorexit ;
        return playnowtrackingservice;
        Exception exception;
        exception;
        throw exception;
    }

    public Task getTveHypermediaServicesCache()
    {
        this;
        JVM INSTR monitorenter ;
        Task task;
        if (tveHypermediaServiceTask == null)
        {
            tveHypermediaServiceTask = new TveHypermediaServicesCache(getHypermediaServicesRevalidationPolicy(), getHalHttpClient(), getConfiguration().getTveHypermediaUrl());
        }
        task = tveHypermediaServiceTask;
        this;
        JVM INSTR monitorexit ;
        return task;
        Exception exception;
        exception;
        throw exception;
    }

    public TypefaceManager getTypefaceManager()
    {
        this;
        JVM INSTR monitorenter ;
        TypefaceManager typefacemanager;
        if (typefaceManager == null)
        {
            typefaceManager = new TypefaceManager();
            TypefaceFamily typefacefamily = new TypefaceFamily(getApplication());
            typefacefamily.addTypeface("Roboto-Regular.ttf", TypefaceFamily.STYLE_REGULAR);
            typefacefamily.addTypeface("Roboto-Bold.ttf", TypefaceFamily.STYLE_BOLD);
            typefacefamily.addTypeface("Roboto-BoldItalic.ttf", TypefaceFamily.STYLE_BOLD_ITALIC);
            typefacefamily.addTypeface("Roboto-Condensed.ttf", TypefaceFamily.STYLE_CONDENSED);
            typefacefamily.addTypeface("Roboto-Italic.ttf", TypefaceFamily.STYLE_ITALIC);
            typefaceManager.addTypefaceFamily(getConfiguration().getRobotoFamilyName(), typefacefamily);
            typefacefamily = new TypefaceFamily(getApplication());
            typefacefamily.addTypeface("XFINITYSans-Lgt.otf", TypefaceFamily.STYLE_LIGHT);
            typefacefamily.addTypeface("XFINITYSans-Reg.otf", TypefaceFamily.STYLE_REGULAR);
            typefacefamily.addTypeface("XFINITYSans-Bold.otf", TypefaceFamily.STYLE_BOLD);
            typefacefamily.addTypeface("XFINITYSans-Med.otf", TypefaceFamily.STYLE_MEDIUM);
            typefacefamily.addTypeface("XFINITYSans-MedCond.otf", TypefaceFamily.STYLE_MEDIUM_CONDENSED);
            typefacefamily.addTypeface("XFINITYSans-Thin.otf", TypefaceFamily.STYLE_THIN);
            typefacefamily.addTypeface("XFINITYSans-BoldCond.otf", TypefaceFamily.STYLE_BOLD_CONDENSED);
            typefacefamily.addTypeface("XFINITYSansTabCond03.otf", TypefaceFamily.STYLE_CONDENSED);
            typefacefamily.addTypeface("XFINITYIndicators.otf", TypefaceFamily.STYLE_CUSTOM_1);
            typefaceManager.addTypefaceFamily(getConfiguration().getXfinitySansFamilyName(), typefacefamily);
        }
        typefacemanager = typefaceManager;
        this;
        JVM INSTR monitorexit ;
        return typefacemanager;
        Exception exception;
        exception;
        throw exception;
    }

    public UnregisterDeviceClient getUnregisterDeviceClient()
    {
        this;
        JVM INSTR monitorenter ;
        UnregisterDeviceClient unregisterdeviceclient;
        if (unregisterDeviceClient == null)
        {
            unregisterDeviceClient = new UnregisterDeviceClient(new DefaultHttpService(getHttpClient()), getObjectMapper(), getXipRequestProviderFactory(), getHttpRequestSignerFactory());
        }
        unregisterdeviceclient = unregisterDeviceClient;
        this;
        JVM INSTR monitorexit ;
        return unregisterdeviceclient;
        Exception exception;
        exception;
        throw exception;
    }

    public RevalidationPolicy getUserAndIntervalRevalidationPolicy()
    {
        this;
        JVM INSTR monitorenter ;
        RevalidationPolicy revalidationpolicy;
        if (userAndIntervalRevalidationPolicy == null)
        {
            userAndIntervalRevalidationPolicy = new CompositeRevalidationPolicy(getUserChangeRevalidationPolicy(), getDefaultRevalidationPolicy());
        }
        revalidationpolicy = userAndIntervalRevalidationPolicy;
        this;
        JVM INSTR monitorexit ;
        return revalidationpolicy;
        Exception exception;
        exception;
        throw exception;
    }

    public UserChangeRevalidationPolicy getUserChangeRevalidationPolicy()
    {
        this;
        JVM INSTR monitorenter ;
        UserChangeRevalidationPolicy userchangerevalidationpolicy;
        if (userRevalidationPolicy == null)
        {
            userRevalidationPolicy = new UserChangeRevalidationPolicy(getUserManager());
        }
        userchangerevalidationpolicy = userRevalidationPolicy;
        this;
        JVM INSTR monitorexit ;
        return userchangerevalidationpolicy;
        Exception exception;
        exception;
        throw exception;
    }

    public PlayNowUserDao getUserDao()
    {
        this;
        JVM INSTR monitorenter ;
        PlayNowUserDao playnowuserdao;
        if (userDao == null)
        {
            userDao = new PlayNowUserDao(getPreferencesUserStore());
        }
        playnowuserdao = userDao;
        this;
        JVM INSTR monitorexit ;
        return playnowuserdao;
        Exception exception;
        exception;
        throw exception;
    }

    public JsonDeserializer getUserJsonDeserializer()
    {
        this;
        JVM INSTR monitorenter ;
        JsonDeserializer jsondeserializer;
        if (userJsonDeserializer == null)
        {
            userJsonDeserializer = new JsonDeserializer(getObjectMapper());
        }
        jsondeserializer = userJsonDeserializer;
        this;
        JVM INSTR monitorexit ;
        return jsondeserializer;
        Exception exception;
        exception;
        throw exception;
    }

    public volatile UserManager getUserManager()
    {
        return getUserManager();
    }

    public PlayNowUserManager getUserManager()
    {
        this;
        JVM INSTR monitorenter ;
        PlayNowUserManager playnowusermanager;
        if (userManager == null)
        {
            userManager = new PlayNowUserManager(getUserDao(), getUserSettingsDao(), getCurrentUser(), getUserSaveExecutor());
            downloadsManager = new PlayerDownloadServiceManager(getApplication(), getJsonSerializer(), getDownloadableFileFactory(), userManager, getWatchableCodec(), getPersistentEntityCache(), createSingleThreadedExecutor(), getUiThreadExecutor(), getTrackingService(), getSharedPreferences());
            appUpgradeHelper = createAppUpgradeHelper();
            userManager.addUserManagerListener(new com.comcast.cim.model.user.UserManager.UserManagerListener() {

                final PlayerContainer this$0;

                public volatile void onUserChanged(User user, UserSettings usersettings)
                {
                    onUserChanged((PlayNowUser)user, (PlayerUserSettings)usersettings);
                }

                public void onUserChanged(PlayNowUser playnowuser, PlayerUserSettings playerusersettings)
                {
                }

                public volatile void onUserLoaded(User user, UserSettings usersettings)
                {
                    onUserLoaded((PlayNowUser)user, (PlayerUserSettings)usersettings);
                }

                public void onUserLoaded(PlayNowUser playnowuser, PlayerUserSettings playerusersettings)
                {
                }

                public volatile void onUserLoggedIn(User user, UserSettings usersettings)
                {
                    onUserLoggedIn((PlayNowUser)user, (PlayerUserSettings)usersettings);
                }

                public void onUserLoggedIn(PlayNowUser playnowuser, PlayerUserSettings playerusersettings)
                {
                    getPlayerConfigUtil().configureESPNPlayer(getApplication());
                }

                public void onUserLoggedOut()
                {
                }

            
            {
                this$0 = PlayerContainer.this;
                super();
            }
            });
        }
        playnowusermanager = userManager;
        this;
        JVM INSTR monitorexit ;
        return playnowusermanager;
        Exception exception;
        exception;
        throw exception;
    }

    public ExceptionHandlingSingleThreadExecutor getUserSaveExecutor()
    {
        this;
        JVM INSTR monitorenter ;
        ExceptionHandlingSingleThreadExecutor exceptionhandlingsinglethreadexecutor;
        if (userSaveExecutor == null)
        {
            userSaveExecutor = new ExceptionHandlingSingleThreadExecutor("userSaveExecutor");
        }
        exceptionhandlingsinglethreadexecutor = userSaveExecutor;
        this;
        JVM INSTR monitorexit ;
        return exceptionhandlingsinglethreadexecutor;
        Exception exception;
        exception;
        throw exception;
    }

    public UserSettingsDao getUserSettingsDao()
    {
        this;
        JVM INSTR monitorenter ;
        UserSettingsDao usersettingsdao;
        if (userSettingsDao == null)
        {
            Provider provider = new Provider() {

                final PlayerContainer this$0;

                public PlayerUserSettings get()
                {
                    return new PlayerUserSettings();
                }

                public volatile Object get()
                {
                    return get();
                }

            
            {
                this$0 = PlayerContainer.this;
                super();
            }
            };
            Initializer initializer = new Initializer() {

                final PlayerContainer this$0;

                public void initialize(PlayerUserSettings playerusersettings)
                {
                    playerusersettings.setFilterFactory(getDibicProgramFilterFactory());
                }

                public volatile void initialize(Object obj)
                {
                    initialize((PlayerUserSettings)obj);
                }

            
            {
                this$0 = PlayerContainer.this;
                super();
            }
            };
            userSettingsDao = new UserSettingsDao(getUserSettingsStore(), provider, initializer);
        }
        usersettingsdao = userSettingsDao;
        this;
        JVM INSTR monitorexit ;
        return usersettingsdao;
        Exception exception;
        exception;
        throw exception;
    }

    public JsonDeserializer getUserSettingsJsonDeserializer()
    {
        this;
        JVM INSTR monitorenter ;
        JsonDeserializer jsondeserializer;
        if (userSettingsJsonDeserializer == null)
        {
            userSettingsJsonDeserializer = new JsonDeserializer(getObjectMapper());
        }
        jsondeserializer = userSettingsJsonDeserializer;
        this;
        JVM INSTR monitorexit ;
        return jsondeserializer;
        Exception exception;
        exception;
        throw exception;
    }

    public PreferencesUserSettingsStore getUserSettingsStore()
    {
        this;
        JVM INSTR monitorenter ;
        PreferencesUserSettingsStore preferencesusersettingsstore;
        if (userSettingsStore == null)
        {
            userSettingsStore = new PreferencesUserSettingsStore(getSharedPreferences(), getJsonSerializer(), getUserSettingsJsonDeserializer(), com/xfinity/playerlib/model/user/PlayerUserSettings);
        }
        preferencesusersettingsstore = userSettingsStore;
        this;
        JVM INSTR monitorexit ;
        return preferencesusersettingsstore;
        Exception exception;
        exception;
        throw exception;
    }

    public VideoAuthManager getVideoAuthManager()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        obj = new DefaultHttpService(getHttpClient());
        obj = new VideoAuthManager(getUserManager(), getObjectMapper(), ((com.comcast.cim.cmasl.http.service.HttpService) (obj)), getVideoEntitlementCache(), getTrackingService(), getHttpRequestProviderFactory(), getXipRequestProviderFactory(), getHttpRequestSignerFactory());
        this;
        JVM INSTR monitorexit ;
        return ((VideoAuthManager) (obj));
        Exception exception;
        exception;
        throw exception;
    }

    public CachingVideoBookmarkDAO getVideoBookmarkDAO()
    {
        this;
        JVM INSTR monitorenter ;
        CachingVideoBookmarkDAO cachingvideobookmarkdao;
        if (bookmarkDAO == null)
        {
            bookmarkDAO = new CachingVideoBookmarkDAO(new DefaultVideoBookmarkDAO(getPlayNowDatabase(), getUserManager(), getVideoTracker()), getUserAndIntervalRevalidationPolicy(), 200);
        }
        cachingvideobookmarkdao = bookmarkDAO;
        this;
        JVM INSTR monitorexit ;
        return cachingvideobookmarkdao;
        Exception exception;
        exception;
        throw exception;
    }

    public Task getVideoEntitlementCache()
    {
        this;
        JVM INSTR monitorenter ;
        Task task;
        if (videoEntitlementCache == null)
        {
            videoEntitlementCache = new GracefullyDegradingVideoEntitlementCache(getNonDegradingVideoEntitlementCache());
        }
        task = videoEntitlementCache;
        this;
        JVM INSTR monitorexit ;
        return task;
        Exception exception;
        exception;
        throw exception;
    }

    public StorageCache getVideoEntitlementFileCache()
    {
        if (videoEntitlementFileCache == null)
        {
            videoEntitlementFileCache = new NamespacedFileCache(getApplication(), "VideoEntitlementCache");
        }
        return videoEntitlementFileCache;
    }

    public TaskExecutor getVideoEntitlementTaskExecutor()
    {
        this;
        JVM INSTR monitorenter ;
        TaskExecutor taskexecutor;
        if (videoEntitlementTaskExecutor == null)
        {
            videoEntitlementTaskExecutor = new DefaultTaskExecutor(getVideoEntitlementCache(), createSingleThreadedExecutor(), getUiThreadExecutor());
        }
        taskexecutor = videoEntitlementTaskExecutor;
        this;
        JVM INSTR monitorexit ;
        return taskexecutor;
        Exception exception;
        exception;
        throw exception;
    }

    public VideoPlayUtil getVideoPlayUtil()
    {
        this;
        JVM INSTR monitorenter ;
        VideoPlayUtil videoplayutil;
        if (videoPlayUtil == null)
        {
            videoPlayUtil = new VideoPlayUtil();
        }
        videoplayutil = videoPlayUtil;
        this;
        JVM INSTR monitorexit ;
        return videoplayutil;
        Exception exception;
        exception;
        throw exception;
    }

    public VideoTracker getVideoTracker()
    {
        this;
        JVM INSTR monitorenter ;
        VideoTracker videotracker;
        if (videoTracker == null)
        {
            videoTracker = new VideoTracker(getVideoTrackerSharedPreferenceProvider());
        }
        videotracker = videoTracker;
        this;
        JVM INSTR monitorexit ;
        return videotracker;
        Exception exception;
        exception;
        throw exception;
    }

    public VideoTrackerSharedPreferenceProvider getVideoTrackerSharedPreferenceProvider()
    {
        this;
        JVM INSTR monitorenter ;
        VideoTrackerSharedPreferenceProvider videotrackersharedpreferenceprovider;
        if (videoTrackerSharedPreferenceProvider == null)
        {
            videoTrackerSharedPreferenceProvider = new VideoTrackerSharedPreferenceProvider(playerApplication, getUserManager());
        }
        videotrackersharedpreferenceprovider = videoTrackerSharedPreferenceProvider;
        this;
        JVM INSTR monitorexit ;
        return videotrackersharedpreferenceprovider;
        Exception exception;
        exception;
        throw exception;
    }

    public LruLinkedHashMap getVolatileDownloadableFileCache()
    {
        this;
        JVM INSTR monitorenter ;
        LruLinkedHashMap lrulinkedhashmap;
        if (volatileDownloadableFileCache == null)
        {
            volatileDownloadableFileCache = new LruLinkedHashMap(10);
        }
        lrulinkedhashmap = volatileDownloadableFileCache;
        this;
        JVM INSTR monitorexit ;
        return lrulinkedhashmap;
        Exception exception;
        exception;
        throw exception;
    }

    public WatchableClient getWatchableClient()
    {
        this;
        JVM INSTR monitorenter ;
        WatchableClient watchableclient;
        if (watchableClient == null)
        {
            watchableClient = new WatchableClient(getMovieCacheMap(), getSeriesCacheMap(), getWatchableCodec());
        }
        watchableclient = watchableClient;
        this;
        JVM INSTR monitorexit ;
        return watchableclient;
        Exception exception;
        exception;
        throw exception;
    }

    public WatchableCodec getWatchableCodec()
    {
        this;
        JVM INSTR monitorenter ;
        WatchableCodec watchablecodec;
        if (watchableCodec == null)
        {
            watchableCodec = new WatchableCodec();
        }
        watchablecodec = watchableCodec;
        this;
        JVM INSTR monitorexit ;
        return watchablecodec;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isDebuggable()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        ApplicationInfo applicationinfo = getApplication().getApplicationInfo();
        i = applicationinfo.flags & 2;
        applicationinfo.flags = i;
        boolean flag;
        if (i != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    protected boolean shouldDisableSSLVerification()
    {
        return isDebuggable();
    }
}
