.class public abstract Lcom/comcast/cim/container/PlayerContainer;
.super Lcom/comcast/cim/container/CALContainer;
.source "PlayerContainer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/container/PlayerContainer$LegacyNormalizer;
    }
.end annotation


# static fields
.field protected static instance:Lcom/comcast/cim/container/PlayerContainer;


# instance fields
.field private androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

.field private appMeasurementProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<",
            "Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;",
            ">;"
        }
    .end annotation
.end field

.field protected appUpgradeHelper:Lcom/comcast/cim/android/application/AppUpgradeHelper;

.field private appirater:Lcom/ijsbrandslob/appirater/Appirater;

.field private appiraterConfig:Lcom/ijsbrandslob/appirater/Appirater$Configuration;

.field protected authStrategy:Lcom/xfinity/playerlib/view/authentication/PlayerAuthenticationStrategy;

.field private bookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

.field private bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

.field private cimAssetFactory:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

.field private consumableVideoListHelper:Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper;

.field private consumablesHypermediaServiceTask:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/ConsumablesHypermediaService;",
            ">;"
        }
    .end annotation
.end field

.field private coverArtCache:Lcom/github/ignition/support/cache/AbstractImageCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/github/ignition/support/cache/AbstractImageCache",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end field

.field private deepLinkingScheme:Ljava/lang/String;

.field private defaultOrientationStrategy:Lcom/comcast/cim/android/view/common/OrientationStrategy;

.field private dibicCombinedCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;"
        }
    .end annotation
.end field

.field private dibicCombinedTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;"
        }
    .end annotation
.end field

.field private dibicMovieCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;"
        }
    .end annotation
.end field

.field protected dibicParser:Lcom/xfinity/playerlib/model/dibic/DibicParser;

.field private dibicSeriesCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;"
        }
    .end annotation
.end field

.field private downloadErrorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

.field private downloadMetaDataJsonDeserializer:Lcom/comcast/cim/utils/JsonDeserializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/utils/JsonDeserializer",
            "<",
            "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;",
            ">;"
        }
    .end annotation
.end field

.field private downloadableFileFactory:Lcom/xfinity/playerlib/model/downloads/DownloadableFileFactory;

.field private downloadsItemListenerDelegate:Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;

.field protected downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

.field private downloadsSortPolicy:Lcom/xfinity/playerlib/view/downloads/DownloadsSortPolicy;

.field private editorVideoCoverResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;",
            ">;"
        }
    .end annotation
.end field

.field private editorialMovieAndSeriesResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;",
            ">;"
        }
    .end annotation
.end field

.field private favoriteDAO:Lcom/xfinity/playerlib/model/database/FavoriteDAO;

.field private featuredResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/editorial/FeaturedResource;",
            ">;"
        }
    .end annotation
.end field

.field private halHttpClient:Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/hal/http/HalHttpClient",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;",
            ">;>;"
        }
    .end annotation
.end field

.field private hypermediaClient:Lcom/comcast/cim/microdata/client/HypermediaClientImpl;

.field private hypermediaRevalidationPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;

.field protected launchStrategy:Lcom/xfinity/playerlib/view/launch/PlayerLaunchStrategy;

.field private layoutInflaterFactory:Landroid/view/LayoutInflater$Factory;

.field private legacyNormalizerFactory:Lcom/comcast/cim/cmasl/cachelib/NormalizerFactory;

.field private liveFeaturedContentResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContentResource;",
            ">;"
        }
    .end annotation
.end field

.field private liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

.field protected liveStreamMetaDataResourceFactory:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory",
            "<",
            "Ljava/lang/String;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;",
            ">;"
        }
    .end annotation
.end field

.field private liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            ">;"
        }
    .end annotation
.end field

.field private mediaLicenseClient:Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

.field private mediaLicenseRenewalScheduler:Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;

.field protected movieCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory",
            "<",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;",
            ">;"
        }
    .end annotation
.end field

.field private movieCollectionSortPolicy:Lcom/xfinity/playerlib/view/browseprograms/MovieCollectionSortPolicy;

.field private moviesAndEntitlementTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;>;"
        }
    .end annotation
.end field

.field private moviesAndTagsAndEntitlementTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;>;"
        }
    .end annotation
.end field

.field private moviesSortPolicy:Lcom/xfinity/playerlib/view/browseprograms/MoviesSortPolicy;

.field private networkLogoCache:Lcom/github/ignition/support/cache/AbstractImageCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/github/ignition/support/cache/AbstractImageCache",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end field

.field private nonDegradingVideoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;"
        }
    .end annotation
.end field

.field private nonDegradingVideoEntitlementProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;"
        }
    .end annotation
.end field

.field private notificationQueueManager:Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;

.field private nullSortPolicy:Lcom/xfinity/playerlib/view/browseprograms/NullSortPolicy;

.field private parentalControlsCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;",
            ">;"
        }
    .end annotation
.end field

.field private parentalControlsFileCache:Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;

.field private parentalControlsSettingsTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;",
            ">;"
        }
    .end annotation
.end field

.field private persistentCaptionsCache:Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;

.field private persistentEntityCache:Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;

.field private playNowDatabase:Lcom/xfinity/playerlib/model/database/PlayNowDatabase;

.field private playNowLaunchIntentInterceptor:Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;

.field protected playerApplication:Lcom/xfinity/playerlib/PlayerApplication;

.field private playerConfigUtil:Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

.field private playerErrorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

.field private playerObjectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

.field private preferencesUserStore:Lcom/comcast/cim/model/user/service/PreferencesUserStore;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/model/user/service/PreferencesUserStore",
            "<",
            "Lcom/xfinity/playerlib/model/user/PlayNowUser;",
            ">;"
        }
    .end annotation
.end field

.field private programDetailArtCache:Lcom/github/ignition/support/cache/AbstractImageCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/github/ignition/support/cache/AbstractImageCache",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end field

.field private programsAndTagsAndEntitlementTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;>;"
        }
    .end annotation
.end field

.field private propertyService:Lcom/comcast/cim/android/PropertyService;

.field private registerDeviceClient:Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;

.field private registrationListClient:Lcom/xfinity/playerlib/downloads/RegistrationListClient;

.field private requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;",
            ">;>;"
        }
    .end annotation
.end field

.field private searchQueryProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<",
            "Lcom/xfinity/playerlib/view/search/SearchQuery;",
            ">;"
        }
    .end annotation
.end field

.field private sensorIfHasKeyboardOrientationStrategy:Lcom/comcast/cim/android/view/common/OrientationStrategy;

.field private seriesAndEntitlementTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;>;"
        }
    .end annotation
.end field

.field private seriesAndTagsAndEntitlementTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;>;"
        }
    .end annotation
.end field

.field protected seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory",
            "<",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
            ">;"
        }
    .end annotation
.end field

.field private seriesCollectionSortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SeriesCollectionSortPolicy;

.field private seriesCombinedTaskExecutorFactory:Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;

.field private seriesSortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SeriesSortPolicy;

.field private sideMenuBuilder:Lcom/comcast/cim/android/sideribbon/SideMenuBuilder;

.field private sideRibbonDelegateBuilder:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;

.field private tagsAndProgramsTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;>;"
        }
    .end annotation
.end field

.field private tagsExecutor:Ljava/util/concurrent/Executor;

.field private tagsParser:Lcom/xfinity/playerlib/model/tags/parser/TagsParser;

.field private tagsRootCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            ">;"
        }
    .end annotation
.end field

.field private tagsRootTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            ">;"
        }
    .end annotation
.end field

.field private thePlatformClient:Lcom/xfinity/playerlib/authorization/ThePlatformClient;

.field private titaniumTicketClient:Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;

.field private trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

.field private tveHypermediaServiceTask:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/TveHypermediaService;",
            ">;"
        }
    .end annotation
.end field

.field private typefaceManager:Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;

.field private unregisterDeviceClient:Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;

.field private userAndIntervalRevalidationPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/comcast/cim/model/user/XipUser;",
            "Ljava/lang/Integer;",
            ">;>;"
        }
    .end annotation
.end field

.field private userDao:Lcom/xfinity/playerlib/model/user/service/PlayNowUserDao;

.field private userJsonDeserializer:Lcom/comcast/cim/utils/JsonDeserializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/utils/JsonDeserializer",
            "<",
            "Lcom/xfinity/playerlib/model/user/PlayNowUser;",
            ">;"
        }
    .end annotation
.end field

.field protected userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

.field private userRevalidationPolicy:Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy",
            "<",
            "Lcom/comcast/cim/model/user/XipUser;",
            ">;"
        }
    .end annotation
.end field

.field private userSaveExecutor:Lcom/comcast/cim/cmasl/utils/executor/ExceptionHandlingSingleThreadExecutor;

.field private userSettingsDao:Lcom/comcast/cim/model/user/service/UserSettingsDao;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/model/user/service/UserSettingsDao",
            "<",
            "Lcom/xfinity/playerlib/model/user/PlayerUserSettings;",
            ">;"
        }
    .end annotation
.end field

.field private userSettingsJsonDeserializer:Lcom/comcast/cim/utils/JsonDeserializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/utils/JsonDeserializer",
            "<",
            "Lcom/xfinity/playerlib/model/user/PlayerUserSettings;",
            ">;"
        }
    .end annotation
.end field

.field private userSettingsStore:Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore",
            "<",
            "Lcom/xfinity/playerlib/model/user/PlayerUserSettings;",
            ">;"
        }
    .end annotation
.end field

.field private videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;"
        }
    .end annotation
.end field

.field private videoEntitlementFileCache:Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;

.field private videoEntitlementTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;"
        }
    .end annotation
.end field

.field private videoPlayUtil:Lcom/xfinity/playerlib/VideoPlayUtil;

.field private videoTracker:Lcom/xfinity/playerlib/view/videoplay/VideoTracker;

.field private videoTrackerSharedPreferenceProvider:Lcom/xfinity/playerlib/view/videoplay/VideoTrackerSharedPreferenceProvider;

.field private volatileDownloadableFileCache:Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;",
            ">;"
        }
    .end annotation
.end field

.field private watchableClient:Lcom/xfinity/playerlib/model/consumable/WatchableClient;

.field private watchableCodec:Lcom/xfinity/playerlib/model/consumable/WatchableCodec;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 353
    invoke-direct {p0}, Lcom/comcast/cim/container/CALContainer;-><init>()V

    .line 354
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/PlayerApplication;)V
    .locals 0
    .param p1, "playerApplication"    # Lcom/xfinity/playerlib/PlayerApplication;

    .prologue
    .line 374
    invoke-direct {p0}, Lcom/comcast/cim/container/CALContainer;-><init>()V

    .line 375
    iput-object p1, p0, Lcom/comcast/cim/container/PlayerContainer;->playerApplication:Lcom/xfinity/playerlib/PlayerApplication;

    .line 376
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;

    .line 377
    return-void
.end method

.method private declared-synchronized createSingleThreadedExecutor()Ljava/util/concurrent/Executor;
    .locals 1

    .prologue
    .line 544
    monitor-enter p0

    :try_start_0
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public static declared-synchronized getInstance()Lcom/comcast/cim/container/PlayerContainer;
    .locals 2
    .annotation runtime Lcom/comcast/cim/container/ContainerTestIgnore;
    .end annotation

    .prologue
    .line 358
    const-class v0, Lcom/comcast/cim/container/PlayerContainer;

    monitor-enter v0

    :try_start_0
    sget-object v1, Lcom/comcast/cim/container/PlayerContainer;->instance:Lcom/comcast/cim/container/PlayerContainer;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object v1

    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method private getLegacyNormalizerFactory()Lcom/comcast/cim/cmasl/cachelib/NormalizerFactory;
    .locals 1

    .prologue
    .line 1457
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->legacyNormalizerFactory:Lcom/comcast/cim/cmasl/cachelib/NormalizerFactory;

    if-nez v0, :cond_0

    .line 1458
    new-instance v0, Lcom/comcast/cim/container/PlayerContainer$14;

    invoke-direct {v0, p0}, Lcom/comcast/cim/container/PlayerContainer$14;-><init>(Lcom/comcast/cim/container/PlayerContainer;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->legacyNormalizerFactory:Lcom/comcast/cim/cmasl/cachelib/NormalizerFactory;

    .line 1466
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->legacyNormalizerFactory:Lcom/comcast/cim/cmasl/cachelib/NormalizerFactory;

    return-object v0
.end method

.method private getParentalControlsFileCache()Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;
    .locals 3

    .prologue
    .line 793
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->parentalControlsFileCache:Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;

    if-nez v0, :cond_0

    .line 794
    new-instance v0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v1

    const-string v2, "ParentalControlsCache"

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->parentalControlsFileCache:Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;

    .line 797
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->parentalControlsFileCache:Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;

    return-object v0
.end method

.method protected static declared-synchronized setInstance(Lcom/comcast/cim/container/PlayerContainer;)V
    .locals 2
    .param p0, "instance"    # Lcom/comcast/cim/container/PlayerContainer;

    .prologue
    .line 362
    const-class v1, Lcom/comcast/cim/container/PlayerContainer;

    monitor-enter v1

    :try_start_0
    sput-object p0, Lcom/comcast/cim/container/PlayerContainer;->instance:Lcom/comcast/cim/container/PlayerContainer;

    .line 363
    invoke-static {p0}, Lcom/comcast/cim/container/CALContainer;->setInstance(Lcom/comcast/cim/container/CALContainer;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 364
    monitor-exit v1

    return-void

    .line 362
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method protected abstract createAppUpgradeHelper()Lcom/comcast/cim/android/application/AppUpgradeHelper;
.end method

.method public declared-synchronized createCoverArtImageLoader()Lcom/xfinity/playerlib/image/CoverArtImageLoader;
    .locals 5
    .annotation runtime Lcom/comcast/cim/container/NonSingleton;
    .end annotation

    .prologue
    .line 744
    monitor-enter p0

    :try_start_0
    new-instance v0, Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getEntityThumbnailUri()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->createRemoteImageLoader()Lcom/github/ignition/support/images/remote/RemoteImageLoader;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getCoverArtCache()Lcom/github/ignition/support/cache/AbstractImageCache;

    move-result-object v3

    iget-object v4, p0, Lcom/comcast/cim/container/PlayerContainer;->playerApplication:Lcom/xfinity/playerlib/PlayerApplication;

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;-><init>(Ljava/lang/String;Lcom/github/ignition/support/images/remote/RemoteImageLoader;Lcom/github/ignition/support/cache/AbstractImageCache;Landroid/content/Context;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized createNetworkLogoImageLoader()Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;
    .locals 5
    .annotation runtime Lcom/comcast/cim/container/NonSingleton;
    .end annotation

    .prologue
    .line 757
    monitor-enter p0

    :try_start_0
    new-instance v0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getEntityThumbnailUri()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->createRemoteImageLoader()Lcom/github/ignition/support/images/remote/RemoteImageLoader;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getNetworkLogoCache()Lcom/github/ignition/support/cache/AbstractImageCache;

    move-result-object v3

    iget-object v4, p0, Lcom/comcast/cim/container/PlayerContainer;->playerApplication:Lcom/xfinity/playerlib/PlayerApplication;

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;-><init>(Ljava/lang/String;Lcom/github/ignition/support/images/remote/RemoteImageLoader;Lcom/github/ignition/support/cache/AbstractImageCache;Landroid/content/Context;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized createProgramDetailArtImageLoader()Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;
    .locals 6
    .annotation runtime Lcom/comcast/cim/container/NonSingleton;
    .end annotation

    .prologue
    .line 725
    monitor-enter p0

    :try_start_0
    new-instance v0, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getEntityThumbnailUri()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->createRemoteImageLoader()Lcom/github/ignition/support/images/remote/RemoteImageLoader;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getProgramDetailArtCache()Lcom/github/ignition/support/cache/AbstractImageCache;

    move-result-object v3

    iget-object v4, p0, Lcom/comcast/cim/container/PlayerContainer;->playerApplication:Lcom/xfinity/playerlib/PlayerApplication;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;-><init>(Ljava/lang/String;Lcom/github/ignition/support/images/remote/RemoteImageLoader;Lcom/github/ignition/support/cache/AbstractImageCache;Landroid/content/Context;Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized createRemoteImageLoader()Lcom/github/ignition/support/images/remote/RemoteImageLoader;
    .locals 2
    .annotation runtime Lcom/comcast/cim/container/NonSingleton;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/github/ignition/support/images/remote/RemoteImageLoader",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation

    .prologue
    .line 705
    monitor-enter p0

    :try_start_0
    new-instance v0, Lcom/github/ignition/support/images/remote/RemoteImageLoader;

    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->playerApplication:Lcom/xfinity/playerlib/PlayerApplication;

    invoke-direct {v0, v1}, Lcom/github/ignition/support/images/remote/RemoteImageLoader;-><init>(Landroid/content/Context;)V

    .line 706
    .local v0, "remoteImageLoader":Lcom/github/ignition/support/images/remote/RemoteImageLoader;, "Lcom/github/ignition/support/images/remote/RemoteImageLoader<Landroid/graphics/Bitmap;>;"
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/github/ignition/support/images/remote/RemoteImageLoader;->setMaxDownloadAttempts(I)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 707
    monitor-exit p0

    return-object v0

    .line 705
    .end local v0    # "remoteImageLoader":Lcom/github/ignition/support/images/remote/RemoteImageLoader;, "Lcom/github/ignition/support/images/remote/RemoteImageLoader<Landroid/graphics/Bitmap;>;"
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method protected getAnalyticsServiceClass()Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<+",
            "Lcom/comcast/cim/cmasl/analytics/AnalyticsService;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1451
    const-class v0, Lcom/comcast/cim/analytics/PlayerAnalyticsService;

    return-object v0
.end method

.method public bridge synthetic getAndroidDevice()Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;
    .locals 1

    .prologue
    .line 203
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;
    .locals 6

    .prologue
    .line 368
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    if-nez v0, :cond_0

    .line 369
    new-instance v0, Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getTelephonyManager()Landroid/telephony/TelephonyManager;

    move-result-object v3

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v4

    invoke-virtual {v4}, Lcom/xfinity/playerlib/PlayerApplication;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$string;->appId:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/comcast/cim/model/system/PlayerAndroidDevice;-><init>(Landroid/app/Application;Landroid/content/res/Resources;Landroid/telephony/TelephonyManager;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    .line 371
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 368
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getAppMeasurementProvider()Lcom/comcast/cim/cmasl/utils/provider/Provider;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<",
            "Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1094
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->appMeasurementProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    if-nez v0, :cond_0

    .line 1095
    new-instance v0, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurementProvider;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getPropertyService()Lcom/comcast/cim/android/PropertyService;

    move-result-object v3

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v4

    invoke-virtual {v4}, Lcom/xfinity/playerlib/PlayerApplication;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$string;->omniture_app_name:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurementProvider;-><init>(Lcom/xfinity/playerlib/PlayerApplication;Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;Lcom/comcast/cim/android/PropertyService;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->appMeasurementProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    .line 1097
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->appMeasurementProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1094
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getAppUpgradeHelper()Lcom/comcast/cim/android/application/AppUpgradeHelper;
    .locals 1

    .prologue
    .line 974
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->appUpgradeHelper:Lcom/comcast/cim/android/application/AppUpgradeHelper;

    if-nez v0, :cond_0

    .line 976
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 978
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->appUpgradeHelper:Lcom/comcast/cim/android/application/AppUpgradeHelper;

    return-object v0
.end method

.method public declared-synchronized getAppirater()Lcom/ijsbrandslob/appirater/Appirater;
    .locals 6

    .prologue
    .line 1350
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->appirater:Lcom/ijsbrandslob/appirater/Appirater;

    if-nez v0, :cond_0

    .line 1351
    new-instance v0, Lcom/ijsbrandslob/appirater/Appirater;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getAppiraterConfig()Lcom/ijsbrandslob/appirater/Appirater$Configuration;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v3

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->isDebuggable()Z

    move-result v4

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Lcom/ijsbrandslob/appirater/Appirater;-><init>(Landroid/content/Context;Lcom/ijsbrandslob/appirater/Appirater$Configuration;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;ZLcom/comcast/cim/cmasl/android/util/system/AndroidDevice;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->appirater:Lcom/ijsbrandslob/appirater/Appirater;

    .line 1353
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->appirater:Lcom/ijsbrandslob/appirater/Appirater;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1350
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getAppiraterConfig()Lcom/ijsbrandslob/appirater/Appirater$Configuration;
    .locals 1

    .prologue
    .line 1361
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->appiraterConfig:Lcom/ijsbrandslob/appirater/Appirater$Configuration;

    if-nez v0, :cond_0

    .line 1362
    new-instance v0, Lcom/comcast/cim/container/PlayerContainer$13;

    invoke-direct {v0, p0}, Lcom/comcast/cim/container/PlayerContainer$13;-><init>(Lcom/comcast/cim/container/PlayerContainer;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->appiraterConfig:Lcom/ijsbrandslob/appirater/Appirater$Configuration;

    .line 1384
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->appiraterConfig:Lcom/ijsbrandslob/appirater/Appirater$Configuration;

    return-object v0
.end method

.method public bridge synthetic getApplication()Landroid/app/Application;
    .locals 1

    .prologue
    .line 203
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized getApplication()Lcom/xfinity/playerlib/PlayerApplication;
    .locals 1

    .prologue
    .line 983
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->playerApplication:Lcom/xfinity/playerlib/PlayerApplication;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getAuthenticationStrategy()Lcom/comcast/cim/android/authentication/AuthenticationStrategy;
    .locals 2

    .prologue
    .line 1285
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->authStrategy:Lcom/xfinity/playerlib/view/authentication/PlayerAuthenticationStrategy;

    if-nez v0, :cond_0

    .line 1286
    new-instance v0, Lcom/xfinity/playerlib/view/authentication/PlayerAuthenticationStrategy;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/view/authentication/PlayerAuthenticationStrategy;-><init>(Lcom/comcast/cim/model/user/UserManager;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->authStrategy:Lcom/xfinity/playerlib/view/authentication/PlayerAuthenticationStrategy;

    .line 1288
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->authStrategy:Lcom/xfinity/playerlib/view/authentication/PlayerAuthenticationStrategy;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1285
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public abstract getAvailableConfigurations()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/config/PlayerConfiguration;",
            ">;"
        }
    .end annotation
.end method

.method public declared-synchronized getBookmarkUtils()Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;
    .locals 3

    .prologue
    .line 1027
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    if-nez v0, :cond_0

    .line 1028
    new-instance v0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getFavoriteDAO()Lcom/xfinity/playerlib/model/database/FavoriteDAO;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getLiveStreamBookmarkDAO()Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;-><init>(Lcom/xfinity/playerlib/model/database/FavoriteDAO;Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    .line 1030
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1027
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getCimAssetFactory()Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;
    .locals 1

    .prologue
    .line 1343
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->cimAssetFactory:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

    if-nez v0, :cond_0

    .line 1344
    new-instance v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

    invoke-direct {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->cimAssetFactory:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

    .line 1346
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->cimAssetFactory:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1343
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public bridge synthetic getConfiguration()Lcom/comcast/cim/config/CALConfiguration;
    .locals 1

    .prologue
    .line 203
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v0

    return-object v0
.end method

.method public abstract getConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;
.end method

.method public abstract getConfigurationVersion()Ljava/lang/String;
.end method

.method public declared-synchronized getConsumableVideoListHelper()Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper;
    .locals 1

    .prologue
    .line 412
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->consumableVideoListHelper:Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper;

    if-nez v0, :cond_0

    .line 413
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->consumableVideoListHelper:Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper;

    .line 415
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->consumableVideoListHelper:Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 412
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getConsumablesHypermediaServicesCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/ConsumablesHypermediaService;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1317
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->consumablesHypermediaServiceTask:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    if-nez v0, :cond_0

    .line 1318
    new-instance v0, Lcom/xfinity/playerlib/model/ConsumablesHypermediaServicesCache;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHypermediaServicesRevalidationPolicy()Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;

    move-result-object v1

    .line 1319
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHalHttpClient()Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getConsumablesHypermediaUrl()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/xfinity/playerlib/model/ConsumablesHypermediaServicesCache;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->consumablesHypermediaServiceTask:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 1322
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->consumablesHypermediaServiceTask:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1317
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getCoverArtCache()Lcom/github/ignition/support/cache/AbstractImageCache;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/github/ignition/support/cache/AbstractImageCache",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation

    .prologue
    .line 730
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->coverArtCache:Lcom/github/ignition/support/cache/AbstractImageCache;

    if-nez v1, :cond_0

    .line 731
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->playerApplication:Lcom/xfinity/playerlib/PlayerApplication;

    const-string v2, "activity"

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/PlayerApplication;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    .line 732
    .local v0, "activityManager":Landroid/app/ActivityManager;
    invoke-virtual {v0}, Landroid/app/ActivityManager;->getMemoryClass()I

    move-result v1

    const/16 v2, 0x30

    if-lt v1, v2, :cond_1

    .line 733
    new-instance v1, Lcom/github/ignition/support/cache/DecodedImageCache;

    const/16 v2, 0x48

    const/16 v3, 0x48

    const-wide/16 v4, 0x1c20

    const/4 v6, 0x5

    invoke-direct/range {v1 .. v6}, Lcom/github/ignition/support/cache/DecodedImageCache;-><init>(IIJI)V

    iput-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->coverArtCache:Lcom/github/ignition/support/cache/AbstractImageCache;

    .line 737
    :goto_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->coverArtCache:Lcom/github/ignition/support/cache/AbstractImageCache;

    iget-object v2, p0, Lcom/comcast/cim/container/PlayerContainer;->playerApplication:Lcom/xfinity/playerlib/PlayerApplication;

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Lcom/github/ignition/support/cache/AbstractImageCache;->enableDiskCache(Landroid/content/Context;I)Z

    .line 739
    .end local v0    # "activityManager":Landroid/app/ActivityManager;
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->coverArtCache:Lcom/github/ignition/support/cache/AbstractImageCache;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 735
    .restart local v0    # "activityManager":Landroid/app/ActivityManager;
    :cond_1
    :try_start_1
    new-instance v1, Lcom/github/ignition/support/cache/DecodedImageCache;

    const/16 v2, 0x12

    const/16 v3, 0x12

    const-wide/16 v4, 0x1c20

    const/4 v6, 0x5

    invoke-direct/range {v1 .. v6}, Lcom/github/ignition/support/cache/DecodedImageCache;-><init>(IIJI)V

    iput-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->coverArtCache:Lcom/github/ignition/support/cache/AbstractImageCache;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 730
    .end local v0    # "activityManager":Landroid/app/ActivityManager;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getDeepLinkingScheme()Ljava/lang/String;
    .locals 2

    .prologue
    .line 770
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->deepLinkingScheme:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 771
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->deep_linking_scheme:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->deepLinkingScheme:Ljava/lang/String;

    .line 773
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->deepLinkingScheme:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 770
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getDefaultOrientationStrategy()Lcom/comcast/cim/android/view/common/OrientationStrategy;
    .locals 1

    .prologue
    .line 1035
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->defaultOrientationStrategy:Lcom/comcast/cim/android/view/common/OrientationStrategy;

    if-nez v0, :cond_0

    .line 1036
    new-instance v0, Lcom/comcast/cim/container/PlayerContainer$10;

    invoke-direct {v0, p0}, Lcom/comcast/cim/container/PlayerContainer$10;-><init>(Lcom/comcast/cim/container/PlayerContainer;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->defaultOrientationStrategy:Lcom/comcast/cim/android/view/common/OrientationStrategy;

    .line 1048
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->defaultOrientationStrategy:Lcom/comcast/cim/android/view/common/OrientationStrategy;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1035
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getDibicCombinedCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;"
        }
    .end annotation

    .prologue
    .line 575
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->dibicCombinedCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    if-nez v0, :cond_0

    .line 576
    new-instance v0, Lcom/xfinity/playerlib/model/dibic/CompositeDibicResourceCache;

    const/4 v1, 0x2

    new-array v1, v1, [Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    const/4 v2, 0x0

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getDibicMovieCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getDibicSeriesCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/model/dibic/CompositeDibicResourceCache;-><init>([Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->dibicCombinedCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 578
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->dibicCombinedCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 575
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getDibicCombinedTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;"
        }
    .end annotation

    .prologue
    .line 582
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->dibicCombinedTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-nez v0, :cond_0

    .line 583
    new-instance v0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getDibicCombinedCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v1

    invoke-direct {p0}, Lcom/comcast/cim/container/PlayerContainer;->createSingleThreadedExecutor()Ljava/util/concurrent/Executor;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUiThreadExecutor()Lcom/comcast/cim/android/concurrent/UIThreadExecutor;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->dibicCombinedTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 585
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->dibicCombinedTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 582
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getDibicMovieCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;"
        }
    .end annotation

    .prologue
    .line 548
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->dibicMovieCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    if-nez v0, :cond_0

    .line 549
    new-instance v2, Lcom/xfinity/playerlib/model/etc/DibicMovieUriProvider;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getConsumablesHypermediaServicesCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    invoke-direct {v2, v0}, Lcom/xfinity/playerlib/model/etc/DibicMovieUriProvider;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)V

    .line 550
    .local v2, "uriProvider":Lcom/xfinity/playerlib/model/etc/DibicMovieUriProvider;
    new-instance v10, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpClient()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v0

    invoke-direct {v10, v0}, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    .line 551
    .local v10, "defaultHttpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    new-instance v1, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getPermanentFileCache()Lcom/comcast/cim/cmasl/cachelib/PermanentFileCache;

    move-result-object v0

    invoke-direct {v1, v10, v0}, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/utils/StorageCache;)V

    .line 552
    .local v1, "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    new-instance v0, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;

    new-instance v3, Lcom/xfinity/playerlib/model/etc/DibicMovieFactory;

    invoke-direct {v3}, Lcom/xfinity/playerlib/model/etc/DibicMovieFactory;-><init>()V

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getTagsRootCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v4

    .line 553
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getDefaultRevalidationPolicy()Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;

    move-result-object v5

    const-string v6, "DibicMovieCache"

    .line 554
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpRequestProviderFactory()Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    move-result-object v7

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getDibicParser()Lcom/xfinity/playerlib/model/dibic/DibicParser;

    move-result-object v8

    .line 555
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v9

    invoke-direct/range {v0 .. v9}, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/utils/provider/Provider;Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;Ljava/lang/String;Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;Lcom/xfinity/playerlib/model/dibic/DibicParser;Lcom/xfinity/playerlib/model/user/PlayNowUserManager;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->dibicMovieCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 557
    .end local v1    # "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    .end local v2    # "uriProvider":Lcom/xfinity/playerlib/model/etc/DibicMovieUriProvider;
    .end local v10    # "defaultHttpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->dibicMovieCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 548
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getDibicParser()Lcom/xfinity/playerlib/model/dibic/DibicParser;
    .locals 1

    .prologue
    .line 389
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->dibicParser:Lcom/xfinity/playerlib/model/dibic/DibicParser;

    if-nez v0, :cond_0

    .line 390
    new-instance v0, Lcom/xfinity/playerlib/model/dibic/DibicParser;

    invoke-direct {v0}, Lcom/xfinity/playerlib/model/dibic/DibicParser;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->dibicParser:Lcom/xfinity/playerlib/model/dibic/DibicParser;

    .line 392
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->dibicParser:Lcom/xfinity/playerlib/model/dibic/DibicParser;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 389
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected getDibicProgramFilterFactory()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilterFactory;
    .locals 1

    .prologue
    .line 864
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/DefaultDibicProgramFilterFactory;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/browseprograms/DefaultDibicProgramFilterFactory;-><init>()V

    return-object v0
.end method

.method public declared-synchronized getDibicSeriesCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;"
        }
    .end annotation

    .prologue
    .line 561
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->dibicSeriesCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    if-nez v0, :cond_0

    .line 562
    new-instance v2, Lcom/xfinity/playerlib/model/etc/DibicTvSeriesUriProvider;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getConsumablesHypermediaServicesCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    invoke-direct {v2, v0}, Lcom/xfinity/playerlib/model/etc/DibicTvSeriesUriProvider;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)V

    .line 563
    .local v2, "uriProvider":Lcom/comcast/cim/cmasl/utils/provider/Provider;, "Lcom/comcast/cim/cmasl/utils/provider/Provider<Ljava/net/URI;>;"
    new-instance v10, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpClient()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v0

    invoke-direct {v10, v0}, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    .line 564
    .local v10, "defaultHttpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    new-instance v1, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getPermanentFileCache()Lcom/comcast/cim/cmasl/cachelib/PermanentFileCache;

    move-result-object v0

    invoke-direct {v1, v10, v0}, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/utils/StorageCache;)V

    .line 565
    .local v1, "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    new-instance v0, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;

    new-instance v3, Lcom/xfinity/playerlib/model/etc/DibicSeriesFactory;

    invoke-direct {v3}, Lcom/xfinity/playerlib/model/etc/DibicSeriesFactory;-><init>()V

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getTagsRootCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v4

    .line 566
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getDefaultRevalidationPolicy()Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;

    move-result-object v5

    const-string v6, "DibicSeriesCache"

    .line 567
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpRequestProviderFactory()Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    move-result-object v7

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getDibicParser()Lcom/xfinity/playerlib/model/dibic/DibicParser;

    move-result-object v8

    .line 568
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v9

    invoke-direct/range {v0 .. v9}, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/utils/provider/Provider;Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;Ljava/lang/String;Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;Lcom/xfinity/playerlib/model/dibic/DibicParser;Lcom/xfinity/playerlib/model/user/PlayNowUserManager;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->dibicSeriesCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 570
    .end local v1    # "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    .end local v2    # "uriProvider":Lcom/comcast/cim/cmasl/utils/provider/Provider;, "Lcom/comcast/cim/cmasl/utils/provider/Provider<Ljava/net/URI;>;"
    .end local v10    # "defaultHttpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->dibicSeriesCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 561
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getDownloadErrorFormatter()Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;
    .locals 3

    .prologue
    .line 1415
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/container/PlayerContainer;->downloadErrorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    if-nez v2, :cond_0

    .line 1416
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 1417
    .local v1, "resources":Landroid/content/res/Resources;
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    .line 1418
    .local v0, "errorFormatters":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;>;"
    new-instance v2, Lcom/comcast/cim/android/view/common/DownloadsAmsErrorFormatter;

    invoke-direct {v2, v1}, Lcom/comcast/cim/android/view/common/DownloadsAmsErrorFormatter;-><init>(Landroid/content/res/Resources;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1419
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getErrorFormatter()Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1420
    new-instance v2, Lcom/comcast/cim/android/view/common/errorformatter/ChainedErrorFormatter;

    invoke-direct {v2, v0}, Lcom/comcast/cim/android/view/common/errorformatter/ChainedErrorFormatter;-><init>(Ljava/util/List;)V

    iput-object v2, p0, Lcom/comcast/cim/container/PlayerContainer;->downloadErrorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    .line 1422
    .end local v0    # "errorFormatters":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;>;"
    .end local v1    # "resources":Landroid/content/res/Resources;
    :cond_0
    iget-object v2, p0, Lcom/comcast/cim/container/PlayerContainer;->downloadErrorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v2

    .line 1415
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized getDownloadMetaDataDeserializer()Lcom/comcast/cim/utils/JsonDeserializer;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/utils/JsonDeserializer",
            "<",
            "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1118
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->downloadMetaDataJsonDeserializer:Lcom/comcast/cim/utils/JsonDeserializer;

    if-nez v0, :cond_0

    .line 1119
    new-instance v0, Lcom/comcast/cim/utils/JsonDeserializer;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getObjectMapper()Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/utils/JsonDeserializer;-><init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->downloadMetaDataJsonDeserializer:Lcom/comcast/cim/utils/JsonDeserializer;

    .line 1121
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->downloadMetaDataJsonDeserializer:Lcom/comcast/cim/utils/JsonDeserializer;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1118
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getDownloadServiceManager()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    .locals 1

    .prologue
    .line 1125
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    if-nez v0, :cond_0

    .line 1127
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 1130
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1125
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getDownloadableFileFactory()Lcom/xfinity/playerlib/model/downloads/DownloadableFileFactory;
    .locals 4

    .prologue
    .line 1134
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->downloadableFileFactory:Lcom/xfinity/playerlib/model/downloads/DownloadableFileFactory;

    if-nez v0, :cond_0

    .line 1135
    new-instance v0, Lcom/xfinity/playerlib/model/downloads/DownloadableFileFactory;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getPersistentEntityCache()Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getDownloadMetaDataDeserializer()Lcom/comcast/cim/utils/JsonDeserializer;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getWatchableCodec()Lcom/xfinity/playerlib/model/consumable/WatchableCodec;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/xfinity/playerlib/model/downloads/DownloadableFileFactory;-><init>(Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;Lcom/comcast/cim/utils/JsonDeserializer;Lcom/xfinity/playerlib/model/consumable/WatchableCodec;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->downloadableFileFactory:Lcom/xfinity/playerlib/model/downloads/DownloadableFileFactory;

    .line 1137
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->downloadableFileFactory:Lcom/xfinity/playerlib/model/downloads/DownloadableFileFactory;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1134
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getDownloadsItemListDelegate()Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;
    .locals 3

    .prologue
    .line 1277
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->downloadsItemListenerDelegate:Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;

    if-nez v0, :cond_0

    .line 1278
    new-instance v0, Lcom/xfinity/playerlib/downloads/DownloadsItemListenerDelegate;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getDownloadServiceManager()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/downloads/DownloadsItemListenerDelegate;-><init>(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Landroid/content/Context;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->downloadsItemListenerDelegate:Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;

    .line 1280
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->downloadsItemListenerDelegate:Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;

    return-object v0
.end method

.method public declared-synchronized getDownloadsSortPolicy()Lcom/xfinity/playerlib/view/downloads/DownloadsSortPolicy;
    .locals 2

    .prologue
    .line 447
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->downloadsSortPolicy:Lcom/xfinity/playerlib/view/downloads/DownloadsSortPolicy;

    if-nez v0, :cond_0

    .line 448
    new-instance v0, Lcom/xfinity/playerlib/view/downloads/DownloadsSortPolicy;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/view/downloads/DownloadsSortPolicy;-><init>(Lcom/xfinity/playerlib/model/user/PlayNowUserManager;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->downloadsSortPolicy:Lcom/xfinity/playerlib/view/downloads/DownloadsSortPolicy;

    .line 450
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->downloadsSortPolicy:Lcom/xfinity/playerlib/view/downloads/DownloadsSortPolicy;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 447
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getEditorVideoCoverResourceCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;",
            ">;"
        }
    .end annotation

    .prologue
    .line 475
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->editorVideoCoverResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    if-nez v0, :cond_0

    .line 476
    new-instance v8, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpClient()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v0

    invoke-direct {v8, v0}, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    .line 477
    .local v8, "defaultHttpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    new-instance v1, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getPermanentFileCache()Lcom/comcast/cim/cmasl/cachelib/PermanentFileCache;

    move-result-object v0

    invoke-direct {v1, v8, v0}, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/utils/StorageCache;)V

    .line 478
    .local v1, "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    new-instance v0, Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getEditorialCoversUri()Ljava/net/URI;

    move-result-object v2

    invoke-virtual {v2}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getDefaultRevalidationPolicy()Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;

    move-result-object v3

    const-string v4, "EditorialVideoCoverCache"

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpRequestProviderFactory()Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    move-result-object v5

    new-instance v6, Lcom/xfinity/playerlib/model/editorial/CoverParser;

    invoke-direct {v6}, Lcom/xfinity/playerlib/model/editorial/CoverParser;-><init>()V

    new-instance v7, Lcom/comcast/cim/container/PlayerContainer$2;

    invoke-direct {v7, p0}, Lcom/comcast/cim/container/PlayerContainer$2;-><init>(Lcom/comcast/cim/container/PlayerContainer;)V

    invoke-direct/range {v0 .. v7}, Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Ljava/lang/String;Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;Ljava/lang/String;Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;Lcom/xfinity/playerlib/model/editorial/EditorialParser;Lcom/xfinity/playerlib/model/editorial/EditorialResourceFactory;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->editorVideoCoverResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 485
    .end local v1    # "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    .end local v8    # "defaultHttpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->editorVideoCoverResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 475
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getEditorialMovieAndSeriesResourceCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;",
            ">;"
        }
    .end annotation

    .prologue
    .line 461
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->editorialMovieAndSeriesResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    if-nez v0, :cond_0

    .line 462
    new-instance v8, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpClient()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v0

    invoke-direct {v8, v0}, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    .line 463
    .local v8, "defaultHttpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    new-instance v1, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getPermanentFileCache()Lcom/comcast/cim/cmasl/cachelib/PermanentFileCache;

    move-result-object v0

    invoke-direct {v1, v8, v0}, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/utils/StorageCache;)V

    .line 464
    .local v1, "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    new-instance v0, Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getEditorialVideoUri()Ljava/net/URI;

    move-result-object v2

    invoke-virtual {v2}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getDefaultRevalidationPolicy()Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;

    move-result-object v3

    const-string v4, "EditorialResourceCache"

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpRequestProviderFactory()Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    move-result-object v5

    new-instance v6, Lcom/xfinity/playerlib/model/editorial/VideoParser;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->createCoverArtImageLoader()Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    move-result-object v7

    invoke-direct {v6, v7}, Lcom/xfinity/playerlib/model/editorial/VideoParser;-><init>(Lcom/xfinity/playerlib/image/CoverArtImageLoader;)V

    new-instance v7, Lcom/comcast/cim/container/PlayerContainer$1;

    invoke-direct {v7, p0}, Lcom/comcast/cim/container/PlayerContainer$1;-><init>(Lcom/comcast/cim/container/PlayerContainer;)V

    invoke-direct/range {v0 .. v7}, Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Ljava/lang/String;Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;Ljava/lang/String;Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;Lcom/xfinity/playerlib/model/editorial/EditorialParser;Lcom/xfinity/playerlib/model/editorial/EditorialResourceFactory;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->editorialMovieAndSeriesResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 471
    .end local v1    # "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    .end local v8    # "defaultHttpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->editorialMovieAndSeriesResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 461
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getFavoriteDAO()Lcom/xfinity/playerlib/model/database/FavoriteDAO;
    .locals 3

    .prologue
    .line 1020
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->favoriteDAO:Lcom/xfinity/playerlib/model/database/FavoriteDAO;

    if-nez v0, :cond_0

    .line 1021
    new-instance v0, Lcom/xfinity/playerlib/model/database/FavoriteDAO;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getPlayNowDatabase()Lcom/xfinity/playerlib/model/database/PlayNowDatabase;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/model/database/FavoriteDAO;-><init>(Lcom/xfinity/playerlib/model/database/PlayNowDatabase;Lcom/xfinity/playerlib/model/user/PlayNowUserManager;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->favoriteDAO:Lcom/xfinity/playerlib/model/database/FavoriteDAO;

    .line 1023
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->favoriteDAO:Lcom/xfinity/playerlib/model/database/FavoriteDAO;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1020
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getFeaturedResourceCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/editorial/FeaturedResource;",
            ">;"
        }
    .end annotation

    .prologue
    .line 489
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->featuredResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    if-nez v0, :cond_0

    .line 490
    new-instance v0, Lcom/xfinity/playerlib/model/editorial/FeaturedResourceCache;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getEditorialMovieAndSeriesResourceCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getEditorVideoCoverResourceCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/model/editorial/FeaturedResourceCache;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->featuredResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 492
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->featuredResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 489
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getFoxAnalyticsLogger()Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;
    .locals 4
    .annotation runtime Lcom/comcast/cim/container/ContainerTestIgnore;
    .end annotation

    .prologue
    .line 1442
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->foxAnalyticsLogger:Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    if-nez v0, :cond_0

    .line 1443
    new-instance v0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueueLogger;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getAnalyticsTaskQueue()Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getSplunkAppName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "http://foxnet.demdex.net/event?"

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueueLogger;-><init>(Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;Ljava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->foxAnalyticsLogger:Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    .line 1446
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->foxAnalyticsLogger:Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    return-object v0
.end method

.method public declared-synchronized getHalHttpClient()Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/hal/http/HalHttpClient",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 1308
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/container/PlayerContainer;->halHttpClient:Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;

    if-nez v2, :cond_0

    .line 1309
    new-instance v0, Lcom/comcast/cim/cmasl/hal/http/HalRequestProviderFactory;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpRequestProviderFactory()Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/comcast/cim/cmasl/hal/http/HalRequestProviderFactory;-><init>(Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;)V

    .line 1310
    .local v0, "halRequestProvider":Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;, "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory<Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    new-instance v1, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpClient()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    .line 1311
    .local v1, "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    new-instance v2, Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHypermediaClient()Lcom/comcast/cim/microdata/client/HypermediaClient;

    move-result-object v3

    invoke-direct {v2, v1, v0, v3}, Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;Lcom/comcast/cim/microdata/client/HypermediaClient;)V

    iput-object v2, p0, Lcom/comcast/cim/container/PlayerContainer;->halHttpClient:Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;

    .line 1313
    .end local v0    # "halRequestProvider":Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;, "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory<Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    .end local v1    # "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    :cond_0
    iget-object v2, p0, Lcom/comcast/cim/container/PlayerContainer;->halHttpClient:Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v2

    .line 1308
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method protected getHttpRequestSignerFactory()Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 801
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    if-nez v0, :cond_0

    .line 802
    new-instance v0, Lcom/comcast/cim/container/PlayerContainer$6;

    invoke-direct {v0, p0}, Lcom/comcast/cim/container/PlayerContainer$6;-><init>(Lcom/comcast/cim/container/PlayerContainer;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    .line 810
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    return-object v0
.end method

.method public declared-synchronized getHypermediaClient()Lcom/comcast/cim/microdata/client/HypermediaClient;
    .locals 1

    .prologue
    .line 1300
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->hypermediaClient:Lcom/comcast/cim/microdata/client/HypermediaClientImpl;

    if-nez v0, :cond_0

    .line 1301
    new-instance v0, Lcom/comcast/cim/microdata/client/HypermediaClientImpl;

    invoke-direct {v0}, Lcom/comcast/cim/microdata/client/HypermediaClientImpl;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->hypermediaClient:Lcom/comcast/cim/microdata/client/HypermediaClientImpl;

    .line 1304
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->hypermediaClient:Lcom/comcast/cim/microdata/client/HypermediaClientImpl;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1300
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getHypermediaServicesRevalidationPolicy()Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;
    .locals 4

    .prologue
    .line 1292
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->hypermediaRevalidationPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;

    if-nez v0, :cond_0

    .line 1293
    new-instance v0, Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getHypermediaRevalidationInterval()I

    move-result v1

    int-to-long v2, v1

    invoke-direct {v0, v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;-><init>(J)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->hypermediaRevalidationPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;

    .line 1296
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->hypermediaRevalidationPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1292
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getLaunchIntentInterceptor()Lcom/comcast/cim/android/view/launch/LaunchIntentInterceptor;
    .locals 5

    .prologue
    .line 988
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->playNowLaunchIntentInterceptor:Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;

    if-nez v0, :cond_0

    .line 990
    new-instance v0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getLaunchStrategy()Lcom/xfinity/playerlib/view/launch/PlayerLaunchStrategy;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v3

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getDeepLinkingScheme()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;-><init>(Landroid/content/Context;Lcom/comcast/cim/android/view/launch/LaunchStrategy;Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->playNowLaunchIntentInterceptor:Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;

    .line 992
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->playNowLaunchIntentInterceptor:Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 988
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public bridge synthetic getLaunchStrategy()Lcom/comcast/cim/android/view/launch/LaunchStrategy;
    .locals 1

    .prologue
    .line 203
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getLaunchStrategy()Lcom/xfinity/playerlib/view/launch/PlayerLaunchStrategy;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized getLaunchStrategy()Lcom/xfinity/playerlib/view/launch/PlayerLaunchStrategy;
    .locals 1

    .prologue
    .line 762
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->launchStrategy:Lcom/xfinity/playerlib/view/launch/PlayerLaunchStrategy;

    if-nez v0, :cond_0

    .line 763
    new-instance v0, Lcom/xfinity/playerlib/view/launch/PlayerLaunchStrategy;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/launch/PlayerLaunchStrategy;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->launchStrategy:Lcom/xfinity/playerlib/view/launch/PlayerLaunchStrategy;

    .line 765
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->launchStrategy:Lcom/xfinity/playerlib/view/launch/PlayerLaunchStrategy;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 762
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getLayoutInflatorFactory()Landroid/view/LayoutInflater$Factory;
    .locals 1

    .prologue
    .line 1173
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->layoutInflaterFactory:Landroid/view/LayoutInflater$Factory;

    if-nez v0, :cond_0

    .line 1174
    new-instance v0, Lcom/comcast/cim/container/PlayerContainer$12;

    invoke-direct {v0, p0}, Lcom/comcast/cim/container/PlayerContainer$12;-><init>(Lcom/comcast/cim/container/PlayerContainer;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->layoutInflaterFactory:Landroid/view/LayoutInflater$Factory;

    .line 1198
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->layoutInflaterFactory:Landroid/view/LayoutInflater$Factory;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1173
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getLiveFeaturedContentResourceCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContentResource;",
            ">;"
        }
    .end annotation

    .prologue
    .line 669
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->liveFeaturedContentResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    if-nez v0, :cond_0

    .line 670
    new-instance v0, Lcom/xfinity/playerlib/model/HalLiveFeaturedContentResourceCache;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getTveHypermediaServicesCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v1

    new-instance v2, Lcom/comcast/cim/model/hal/HalLiveFeaturedContentResourceFactory;

    invoke-direct {v2}, Lcom/comcast/cim/model/hal/HalLiveFeaturedContentResourceFactory;-><init>()V

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHalHttpClient()Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;

    move-result-object v3

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getDefaultRevalidationPolicy()Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/model/HalLiveFeaturedContentResourceCache;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->liveFeaturedContentResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 672
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->liveFeaturedContentResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 669
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getLiveStreamBookmarkDAO()Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;
    .locals 4

    .prologue
    .line 1012
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    if-nez v1, :cond_0

    .line 1013
    new-instance v0, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getPlayNowDatabase()Lcom/xfinity/playerlib/model/database/PlayNowDatabase;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;-><init>(Lcom/xfinity/playerlib/model/database/PlayNowDatabase;Lcom/xfinity/playerlib/model/user/PlayNowUserManager;)V

    .line 1014
    .local v0, "delegateDAO":Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;
    new-instance v1, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserAndIntervalRevalidationPolicy()Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;

    move-result-object v2

    const/16 v3, 0xc8

    invoke-direct {v1, v0, v2, v3}, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;-><init>(Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;I)V

    iput-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    .line 1016
    .end local v0    # "delegateDAO":Lcom/xfinity/playerlib/model/database/DefaultLiveStreamBookmarkDAO;
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 1012
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getLiveStreamMetaDataResourceFactory()Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory",
            "<",
            "Ljava/lang/String;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;",
            ">;"
        }
    .end annotation

    .prologue
    .line 638
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->liveStreamMetaDataResourceFactory:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    if-nez v0, :cond_0

    .line 639
    new-instance v0, Lcom/comcast/cim/cmasl/taskexecutor/task/CachingTaskFactory;

    new-instance v1, Lcom/comcast/cim/container/PlayerContainer$4;

    invoke-direct {v1, p0}, Lcom/comcast/cim/container/PlayerContainer$4;-><init>(Lcom/comcast/cim/container/PlayerContainer;)V

    const/16 v2, 0x64

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/cmasl/taskexecutor/task/CachingTaskFactory;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;I)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->liveStreamMetaDataResourceFactory:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    .line 646
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->liveStreamMetaDataResourceFactory:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 638
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getLiveStreamResourceCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            ">;"
        }
    .end annotation

    .prologue
    .line 662
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    if-nez v0, :cond_0

    .line 663
    new-instance v0, Lcom/xfinity/playerlib/model/HalLiveStreamResourceCache;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getTveHypermediaServicesCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v1

    new-instance v2, Lcom/comcast/cim/model/hal/HalLiveStreamResourceFactory;

    invoke-direct {v2}, Lcom/comcast/cim/model/hal/HalLiveStreamResourceFactory;-><init>()V

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHalHttpClient()Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;

    move-result-object v3

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getDefaultRevalidationPolicy()Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;

    move-result-object v4

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Lcom/xfinity/playerlib/model/HalLiveStreamResourceCache;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;Lcom/xfinity/playerlib/config/PlayerConfiguration;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 665
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 662
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getMediaLicenseClient()Lcom/xfinity/playerlib/downloads/MediaLicenseClient;
    .locals 5

    .prologue
    .line 1255
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->mediaLicenseClient:Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

    if-nez v0, :cond_0

    .line 1256
    new-instance v0, Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getSplunkLogger()Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getErrorFormatter()Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getHashedOmnitureGuid()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v4

    invoke-virtual {v4}, Lcom/xfinity/playerlib/PlayerApplication;->getVersionNumber()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/downloads/MediaLicenseClient;-><init>(Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;Ljava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->mediaLicenseClient:Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

    .line 1258
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->mediaLicenseClient:Lcom/xfinity/playerlib/downloads/MediaLicenseClient;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1255
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getMediaLicenseRenewalScheduler()Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;
    .locals 2

    .prologue
    .line 1262
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->mediaLicenseRenewalScheduler:Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;

    if-nez v0, :cond_0

    .line 1263
    new-instance v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->mediaLicenseRenewalScheduler:Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;

    .line 1265
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->mediaLicenseRenewalScheduler:Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1262
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getMovieCacheMap()Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory",
            "<",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;",
            ">;"
        }
    .end annotation

    .prologue
    .line 650
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->movieCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    if-nez v0, :cond_0

    .line 651
    new-instance v0, Lcom/comcast/cim/cmasl/taskexecutor/task/CachingTaskFactory;

    new-instance v1, Lcom/comcast/cim/container/PlayerContainer$5;

    invoke-direct {v1, p0}, Lcom/comcast/cim/container/PlayerContainer$5;-><init>(Lcom/comcast/cim/container/PlayerContainer;)V

    const/16 v2, 0x64

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/cmasl/taskexecutor/task/CachingTaskFactory;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;I)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->movieCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    .line 658
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->movieCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 650
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getMovieCollectionSortPolicy()Lcom/xfinity/playerlib/view/browseprograms/MovieCollectionSortPolicy;
    .locals 2

    .prologue
    .line 433
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->movieCollectionSortPolicy:Lcom/xfinity/playerlib/view/browseprograms/MovieCollectionSortPolicy;

    if-nez v0, :cond_0

    .line 434
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/MovieCollectionSortPolicy;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/view/browseprograms/MovieCollectionSortPolicy;-><init>(Lcom/xfinity/playerlib/model/user/PlayNowUserManager;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->movieCollectionSortPolicy:Lcom/xfinity/playerlib/view/browseprograms/MovieCollectionSortPolicy;

    .line 436
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->movieCollectionSortPolicy:Lcom/xfinity/playerlib/view/browseprograms/MovieCollectionSortPolicy;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 433
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getMoviesAndEntitlementTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 504
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->moviesAndEntitlementTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-nez v1, :cond_0

    .line 505
    new-instance v0, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getDibicMovieCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)V

    .line 506
    .local v0, "combinedCache":Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask<Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;>;"
    new-instance v1, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    invoke-direct {p0}, Lcom/comcast/cim/container/PlayerContainer;->createSingleThreadedExecutor()Ljava/util/concurrent/Executor;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUiThreadExecutor()Lcom/comcast/cim/android/concurrent/UIThreadExecutor;

    move-result-object v3

    invoke-direct {v1, v0, v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;)V

    iput-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->moviesAndEntitlementTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 508
    .end local v0    # "combinedCache":Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask<Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;>;"
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->moviesAndEntitlementTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 504
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getMoviesAndTagsAndEntitlementTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 528
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->moviesAndTagsAndEntitlementTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-nez v1, :cond_0

    .line 529
    new-instance v0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getDibicMovieCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getTagsRootCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)V

    .line 530
    .local v0, "combinedCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task<Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;>;"
    new-instance v1, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    invoke-direct {p0}, Lcom/comcast/cim/container/PlayerContainer;->createSingleThreadedExecutor()Ljava/util/concurrent/Executor;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUiThreadExecutor()Lcom/comcast/cim/android/concurrent/UIThreadExecutor;

    move-result-object v3

    invoke-direct {v1, v0, v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;)V

    iput-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->moviesAndTagsAndEntitlementTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 532
    .end local v0    # "combinedCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task<Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;>;"
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->moviesAndTagsAndEntitlementTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 528
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getMoviesSortPolicy()Lcom/xfinity/playerlib/view/browseprograms/MoviesSortPolicy;
    .locals 2

    .prologue
    .line 419
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->moviesSortPolicy:Lcom/xfinity/playerlib/view/browseprograms/MoviesSortPolicy;

    if-nez v0, :cond_0

    .line 420
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/MoviesSortPolicy;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/view/browseprograms/MoviesSortPolicy;-><init>(Lcom/xfinity/playerlib/model/user/PlayNowUserManager;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->moviesSortPolicy:Lcom/xfinity/playerlib/view/browseprograms/MoviesSortPolicy;

    .line 422
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->moviesSortPolicy:Lcom/xfinity/playerlib/view/browseprograms/MoviesSortPolicy;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 419
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getNetworkLogoCache()Lcom/github/ignition/support/cache/AbstractImageCache;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/github/ignition/support/cache/AbstractImageCache",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation

    .prologue
    .line 748
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->networkLogoCache:Lcom/github/ignition/support/cache/AbstractImageCache;

    if-nez v0, :cond_0

    .line 749
    new-instance v1, Lcom/github/ignition/support/cache/DecodedImageCache;

    const/16 v2, 0x96

    const/16 v3, 0x96

    const-wide/16 v4, 0x1c20

    const/4 v6, 0x5

    invoke-direct/range {v1 .. v6}, Lcom/github/ignition/support/cache/DecodedImageCache;-><init>(IIJI)V

    iput-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->networkLogoCache:Lcom/github/ignition/support/cache/AbstractImageCache;

    .line 750
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->networkLogoCache:Lcom/github/ignition/support/cache/AbstractImageCache;

    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->playerApplication:Lcom/xfinity/playerlib/PlayerApplication;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/github/ignition/support/cache/AbstractImageCache;->enableDiskCache(Landroid/content/Context;I)Z

    .line 752
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->networkLogoCache:Lcom/github/ignition/support/cache/AbstractImageCache;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 748
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getNonDegradingVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;"
        }
    .end annotation

    .prologue
    .line 617
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->nonDegradingVideoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    if-nez v0, :cond_0

    .line 618
    new-instance v7, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpClient()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v0

    invoke-direct {v7, v0}, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    .line 619
    .local v7, "defaultHttpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    new-instance v1, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoEntitlementFileCache()Lcom/comcast/cim/cmasl/utils/StorageCache;

    move-result-object v0

    invoke-direct {v1, v7, v0}, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/utils/StorageCache;)V

    .line 620
    .local v1, "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    new-instance v0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserAndIntervalRevalidationPolicy()Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v3

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getXipRequestProviderFactory()Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    move-result-object v4

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpRequestSignerFactory()Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    move-result-object v5

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getObjectMapper()Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v6

    invoke-direct/range {v0 .. v6}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;Lcom/comcast/cim/model/user/UserManager;Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;Lcom/fasterxml/jackson/databind/ObjectMapper;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->nonDegradingVideoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 622
    .end local v1    # "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    .end local v7    # "defaultHttpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->nonDegradingVideoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 617
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getNonDegradingVideoEntitlementProvider()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;"
        }
    .end annotation

    .prologue
    .line 603
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->nonDegradingVideoEntitlementProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-nez v0, :cond_0

    .line 604
    new-instance v0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getNonDegradingVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v1

    invoke-direct {p0}, Lcom/comcast/cim/container/PlayerContainer;->createSingleThreadedExecutor()Ljava/util/concurrent/Executor;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUiThreadExecutor()Lcom/comcast/cim/android/concurrent/UIThreadExecutor;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->nonDegradingVideoEntitlementProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 606
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->nonDegradingVideoEntitlementProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 603
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getNotificationQueueManager()Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;
    .locals 2

    .prologue
    .line 1426
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->notificationQueueManager:Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;

    if-nez v0, :cond_0

    .line 1427
    new-instance v0, Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->notificationQueueManager:Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;

    .line 1429
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->notificationQueueManager:Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1426
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getNullSortPolicy()Lcom/xfinity/playerlib/view/browseprograms/NullSortPolicy;
    .locals 1

    .prologue
    .line 454
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->nullSortPolicy:Lcom/xfinity/playerlib/view/browseprograms/NullSortPolicy;

    if-nez v0, :cond_0

    .line 455
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/NullSortPolicy;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/browseprograms/NullSortPolicy;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->nullSortPolicy:Lcom/xfinity/playerlib/view/browseprograms/NullSortPolicy;

    .line 457
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->nullSortPolicy:Lcom/xfinity/playerlib/view/browseprograms/NullSortPolicy;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 454
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getObjectMapper()Lcom/fasterxml/jackson/databind/ObjectMapper;
    .locals 1

    .prologue
    .line 381
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->playerObjectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    if-nez v0, :cond_0

    .line 382
    invoke-super {p0}, Lcom/comcast/cim/container/CALContainer;->getObjectMapper()Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->playerObjectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 385
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->playerObjectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 381
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getParentalControlsCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;",
            ">;"
        }
    .end annotation

    .prologue
    .line 784
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->parentalControlsCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    if-nez v0, :cond_0

    .line 785
    new-instance v8, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpClient()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v0

    invoke-direct {v8, v0}, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    .line 786
    .local v8, "defaultHttpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    new-instance v1, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;

    invoke-direct {p0}, Lcom/comcast/cim/container/PlayerContainer;->getParentalControlsFileCache()Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;

    move-result-object v0

    invoke-direct {v1, v8, v0}, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/utils/StorageCache;)V

    .line 787
    .local v1, "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    new-instance v0, Lcom/comcast/cim/model/ParentalControlsCache;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserAndIntervalRevalidationPolicy()Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getXipServer()Lcom/comcast/cim/cmasl/xip/XipServer;

    move-result-object v3

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v4

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getObjectMapper()Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v5

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpRequestProviderFactory()Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    move-result-object v6

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpRequestSignerFactory()Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    move-result-object v7

    invoke-direct/range {v0 .. v7}, Lcom/comcast/cim/model/ParentalControlsCache;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;Lcom/comcast/cim/cmasl/xip/XipServer;Lcom/comcast/cim/model/user/UserManager;Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->parentalControlsCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 789
    .end local v1    # "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    .end local v8    # "defaultHttpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->parentalControlsCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 784
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getParentalControlsSettingsTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;",
            ">;"
        }
    .end annotation

    .prologue
    .line 589
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->parentalControlsSettingsTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-nez v0, :cond_0

    .line 590
    new-instance v0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getParentalControlsCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v1

    invoke-direct {p0}, Lcom/comcast/cim/container/PlayerContainer;->createSingleThreadedExecutor()Ljava/util/concurrent/Executor;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUiThreadExecutor()Lcom/comcast/cim/android/concurrent/UIThreadExecutor;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->parentalControlsSettingsTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 592
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->parentalControlsSettingsTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 589
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getPersistentCaptionsCache()Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;
    .locals 5

    .prologue
    .line 1156
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->persistentCaptionsCache:Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;

    if-nez v0, :cond_0

    .line 1158
    new-instance v0, Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;

    new-instance v1, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v2

    sget-object v3, Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;->NAMESPACE:Ljava/lang/String;

    invoke-direct {p0}, Lcom/comcast/cim/container/PlayerContainer;->getLegacyNormalizerFactory()Lcom/comcast/cim/cmasl/cachelib/NormalizerFactory;

    move-result-object v4

    invoke-direct {v1, v2, v3, v4}, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;-><init>(Landroid/content/Context;Ljava/lang/String;Lcom/comcast/cim/cmasl/cachelib/NormalizerFactory;)V

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;-><init>(Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->persistentCaptionsCache:Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;

    .line 1161
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->persistentCaptionsCache:Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1156
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getPersistentEntityCache()Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;
    .locals 5

    .prologue
    .line 1148
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->persistentEntityCache:Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;

    if-nez v0, :cond_0

    .line 1150
    new-instance v0, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;

    new-instance v1, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v2

    sget-object v3, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->NAMESPACE:Ljava/lang/String;

    invoke-direct {p0}, Lcom/comcast/cim/container/PlayerContainer;->getLegacyNormalizerFactory()Lcom/comcast/cim/cmasl/cachelib/NormalizerFactory;

    move-result-object v4

    invoke-direct {v1, v2, v3, v4}, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;-><init>(Landroid/content/Context;Ljava/lang/String;Lcom/comcast/cim/cmasl/cachelib/NormalizerFactory;)V

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getJsonSerializer()Lcom/comcast/cim/utils/JsonSerializer;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getObjectMapper()Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;-><init>(Lcom/comcast/cim/cmasl/utils/StorageCache;Lcom/comcast/cim/utils/JsonSerializer;Lcom/fasterxml/jackson/databind/ObjectMapper;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->persistentEntityCache:Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;

    .line 1152
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->persistentEntityCache:Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1148
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getPlayNowDatabase()Lcom/xfinity/playerlib/model/database/PlayNowDatabase;
    .locals 2

    .prologue
    .line 996
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->playNowDatabase:Lcom/xfinity/playerlib/model/database/PlayNowDatabase;

    if-nez v0, :cond_0

    .line 997
    new-instance v0, Lcom/xfinity/playerlib/model/database/PlayNowDatabase;

    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->playerApplication:Lcom/xfinity/playerlib/PlayerApplication;

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/model/database/PlayNowDatabase;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->playNowDatabase:Lcom/xfinity/playerlib/model/database/PlayNowDatabase;

    .line 1000
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->playNowDatabase:Lcom/xfinity/playerlib/model/database/PlayNowDatabase;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 996
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getPlayerConfigUtil()Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;
    .locals 4

    .prologue
    .line 1388
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->playerConfigUtil:Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

    if-nez v0, :cond_0

    .line 1389
    new-instance v0, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->isDebuggable()Z

    move-result v3

    invoke-direct {v0, v1, v2, v3}, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;-><init>(Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;Lcom/xfinity/playerlib/model/user/PlayNowUserManager;Z)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->playerConfigUtil:Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

    .line 1392
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->playerConfigUtil:Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1388
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getPlayerErrorFormatter()Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;
    .locals 3

    .prologue
    .line 1403
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/container/PlayerContainer;->playerErrorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    if-nez v2, :cond_0

    .line 1404
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 1405
    .local v1, "resources":Landroid/content/res/Resources;
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    .line 1406
    .local v0, "errorFormatters":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;>;"
    new-instance v2, Lcom/comcast/cim/android/view/common/PlayerAmsErrorFormatter;

    invoke-direct {v2, v1}, Lcom/comcast/cim/android/view/common/PlayerAmsErrorFormatter;-><init>(Landroid/content/res/Resources;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1407
    new-instance v2, Lcom/comcast/cim/android/view/common/PlayerPlatformErrorFormatter;

    invoke-direct {v2, v1}, Lcom/comcast/cim/android/view/common/PlayerPlatformErrorFormatter;-><init>(Landroid/content/res/Resources;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1408
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getErrorFormatter()Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1409
    new-instance v2, Lcom/comcast/cim/android/view/common/errorformatter/ChainedErrorFormatter;

    invoke-direct {v2, v0}, Lcom/comcast/cim/android/view/common/errorformatter/ChainedErrorFormatter;-><init>(Ljava/util/List;)V

    iput-object v2, p0, Lcom/comcast/cim/container/PlayerContainer;->playerErrorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    .line 1411
    .end local v0    # "errorFormatters":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;>;"
    .end local v1    # "resources":Landroid/content/res/Resources;
    :cond_0
    iget-object v2, p0, Lcom/comcast/cim/container/PlayerContainer;->playerErrorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v2

    .line 1403
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized getPreferencesUserStore()Lcom/comcast/cim/model/user/service/PreferencesUserStore;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/model/user/service/PreferencesUserStore",
            "<",
            "Lcom/xfinity/playerlib/model/user/PlayNowUser;",
            ">;"
        }
    .end annotation

    .prologue
    .line 882
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->preferencesUserStore:Lcom/comcast/cim/model/user/service/PreferencesUserStore;

    if-nez v0, :cond_0

    .line 883
    new-instance v0, Lcom/comcast/cim/model/user/service/PreferencesUserStore;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getJsonSerializer()Lcom/comcast/cim/utils/JsonSerializer;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserJsonDeserializer()Lcom/comcast/cim/utils/JsonDeserializer;

    move-result-object v3

    const-class v4, Lcom/xfinity/playerlib/model/user/PlayNowUser;

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/comcast/cim/model/user/service/PreferencesUserStore;-><init>(Landroid/content/SharedPreferences;Lcom/comcast/cim/utils/JsonSerializer;Lcom/comcast/cim/utils/JsonDeserializer;Ljava/lang/Class;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->preferencesUserStore:Lcom/comcast/cim/model/user/service/PreferencesUserStore;

    .line 885
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->preferencesUserStore:Lcom/comcast/cim/model/user/service/PreferencesUserStore;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 882
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getProgramDetailArtCache()Lcom/github/ignition/support/cache/AbstractImageCache;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/github/ignition/support/cache/AbstractImageCache",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation

    .prologue
    .line 711
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->programDetailArtCache:Lcom/github/ignition/support/cache/AbstractImageCache;

    if-nez v1, :cond_0

    .line 712
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->playerApplication:Lcom/xfinity/playerlib/PlayerApplication;

    const-string v2, "activity"

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/PlayerApplication;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    .line 713
    .local v0, "activityManager":Landroid/app/ActivityManager;
    invoke-virtual {v0}, Landroid/app/ActivityManager;->getMemoryClass()I

    move-result v1

    const/16 v2, 0x30

    if-lt v1, v2, :cond_1

    .line 714
    new-instance v1, Lcom/github/ignition/support/cache/DecodedImageCache;

    const/16 v2, 0x8

    const/16 v3, 0x8

    const-wide/16 v4, 0x1c20

    const/4 v6, 0x5

    invoke-direct/range {v1 .. v6}, Lcom/github/ignition/support/cache/DecodedImageCache;-><init>(IIJI)V

    iput-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->programDetailArtCache:Lcom/github/ignition/support/cache/AbstractImageCache;

    .line 718
    :goto_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->programDetailArtCache:Lcom/github/ignition/support/cache/AbstractImageCache;

    iget-object v2, p0, Lcom/comcast/cim/container/PlayerContainer;->playerApplication:Lcom/xfinity/playerlib/PlayerApplication;

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Lcom/github/ignition/support/cache/AbstractImageCache;->enableDiskCache(Landroid/content/Context;I)Z

    .line 720
    .end local v0    # "activityManager":Landroid/app/ActivityManager;
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->programDetailArtCache:Lcom/github/ignition/support/cache/AbstractImageCache;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 716
    .restart local v0    # "activityManager":Landroid/app/ActivityManager;
    :cond_1
    :try_start_1
    new-instance v1, Lcom/github/ignition/support/cache/DecodedImageCache;

    const/4 v2, 0x4

    const/4 v3, 0x4

    const-wide/16 v4, 0x1c20

    const/4 v6, 0x5

    invoke-direct/range {v1 .. v6}, Lcom/github/ignition/support/cache/DecodedImageCache;-><init>(IIJI)V

    iput-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->programDetailArtCache:Lcom/github/ignition/support/cache/AbstractImageCache;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 711
    .end local v0    # "activityManager":Landroid/app/ActivityManager;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getProgramsAndTagsAndEntitlementTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 520
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->programsAndTagsAndEntitlementTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-nez v1, :cond_0

    .line 521
    new-instance v0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getDibicCombinedCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getTagsRootCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)V

    .line 522
    .local v0, "combinedCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task<Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;>;"
    new-instance v1, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    invoke-direct {p0}, Lcom/comcast/cim/container/PlayerContainer;->createSingleThreadedExecutor()Ljava/util/concurrent/Executor;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUiThreadExecutor()Lcom/comcast/cim/android/concurrent/UIThreadExecutor;

    move-result-object v3

    invoke-direct {v1, v0, v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;)V

    iput-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->programsAndTagsAndEntitlementTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 524
    .end local v0    # "combinedCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task<Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;>;"
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->programsAndTagsAndEntitlementTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 520
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getPropertyService()Lcom/comcast/cim/android/PropertyService;
    .locals 1

    .prologue
    .line 1083
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->propertyService:Lcom/comcast/cim/android/PropertyService;

    if-nez v0, :cond_0

    .line 1084
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->isDebuggable()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1085
    new-instance v0, Lcom/xfinity/playerlib/config/DebugPropertyService;

    invoke-direct {v0}, Lcom/xfinity/playerlib/config/DebugPropertyService;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->propertyService:Lcom/comcast/cim/android/PropertyService;

    .line 1090
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->propertyService:Lcom/comcast/cim/android/PropertyService;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1087
    :cond_1
    :try_start_1
    new-instance v0, Lcom/xfinity/playerlib/config/ReleasePropertyService;

    invoke-direct {v0}, Lcom/xfinity/playerlib/config/ReleasePropertyService;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->propertyService:Lcom/comcast/cim/android/PropertyService;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 1083
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getRegisterDeviceClient()Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;
    .locals 6

    .prologue
    .line 1230
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->registerDeviceClient:Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;

    if-nez v0, :cond_0

    .line 1231
    new-instance v1, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpClient()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v0

    invoke-direct {v1, v0}, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    .line 1232
    .local v1, "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    new-instance v0, Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getObjectMapper()Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v3

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getXipRequestProviderFactory()Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    move-result-object v4

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpRequestSignerFactory()Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->registerDeviceClient:Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;

    .line 1234
    .end local v1    # "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->registerDeviceClient:Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1230
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getRegistrationListClient()Lcom/xfinity/playerlib/downloads/RegistrationListClient;
    .locals 5

    .prologue
    .line 1269
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->registrationListClient:Lcom/xfinity/playerlib/downloads/RegistrationListClient;

    if-nez v1, :cond_0

    .line 1270
    new-instance v0, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpClient()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    .line 1271
    .local v0, "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    new-instance v1, Lcom/xfinity/playerlib/downloads/RegistrationListClient;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getObjectMapper()Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getXipRequestProviderFactory()Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    move-result-object v3

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpRequestSignerFactory()Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    move-result-object v4

    invoke-direct {v1, v0, v2, v3, v4}, Lcom/xfinity/playerlib/downloads/RegistrationListClient;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;)V

    iput-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->registrationListClient:Lcom/xfinity/playerlib/downloads/RegistrationListClient;

    .line 1273
    .end local v0    # "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->registrationListClient:Lcom/xfinity/playerlib/downloads/RegistrationListClient;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 1269
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getSearchQueryProvider()Lcom/comcast/cim/cmasl/utils/provider/Provider;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<",
            "Lcom/xfinity/playerlib/view/search/SearchQuery;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1076
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->searchQueryProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    if-nez v0, :cond_0

    .line 1077
    new-instance v0, Lcom/xfinity/playerlib/view/search/SearchQueryProvider;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/view/search/SearchQueryProvider;-><init>(Lcom/xfinity/playerlib/model/user/PlayNowUserManager;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->searchQueryProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    .line 1079
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->searchQueryProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1076
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getSensorIfHasKeyboardOrientationStrategy()Lcom/comcast/cim/android/view/common/OrientationStrategy;
    .locals 1

    .prologue
    .line 1056
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->sensorIfHasKeyboardOrientationStrategy:Lcom/comcast/cim/android/view/common/OrientationStrategy;

    if-nez v0, :cond_0

    .line 1057
    new-instance v0, Lcom/comcast/cim/container/PlayerContainer$11;

    invoke-direct {v0, p0}, Lcom/comcast/cim/container/PlayerContainer$11;-><init>(Lcom/comcast/cim/container/PlayerContainer;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->sensorIfHasKeyboardOrientationStrategy:Lcom/comcast/cim/android/view/common/OrientationStrategy;

    .line 1072
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->sensorIfHasKeyboardOrientationStrategy:Lcom/comcast/cim/android/view/common/OrientationStrategy;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1056
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getSeriesAndEntitlementTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 512
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->seriesAndEntitlementTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-nez v1, :cond_0

    .line 513
    new-instance v0, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getDibicSeriesCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)V

    .line 514
    .local v0, "combinedCache":Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask<Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;>;"
    new-instance v1, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    invoke-direct {p0}, Lcom/comcast/cim/container/PlayerContainer;->createSingleThreadedExecutor()Ljava/util/concurrent/Executor;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUiThreadExecutor()Lcom/comcast/cim/android/concurrent/UIThreadExecutor;

    move-result-object v3

    invoke-direct {v1, v0, v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;)V

    iput-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->seriesAndEntitlementTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 516
    .end local v0    # "combinedCache":Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask<Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;>;"
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->seriesAndEntitlementTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 512
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getSeriesAndTagsAndEntitlementTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 536
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->seriesAndTagsAndEntitlementTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-nez v1, :cond_0

    .line 537
    new-instance v0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getDibicSeriesCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getTagsRootCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)V

    .line 538
    .local v0, "combinedCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task<Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;>;"
    new-instance v1, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    invoke-direct {p0}, Lcom/comcast/cim/container/PlayerContainer;->createSingleThreadedExecutor()Ljava/util/concurrent/Executor;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUiThreadExecutor()Lcom/comcast/cim/android/concurrent/UIThreadExecutor;

    move-result-object v3

    invoke-direct {v1, v0, v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;)V

    iput-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->seriesAndTagsAndEntitlementTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 540
    .end local v0    # "combinedCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task<Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;>;"
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->seriesAndTagsAndEntitlementTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 536
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getSeriesCacheMap()Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory",
            "<",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
            ">;"
        }
    .end annotation

    .prologue
    .line 626
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    if-nez v0, :cond_0

    .line 627
    new-instance v0, Lcom/comcast/cim/cmasl/taskexecutor/task/CachingTaskFactory;

    new-instance v1, Lcom/comcast/cim/container/PlayerContainer$3;

    invoke-direct {v1, p0}, Lcom/comcast/cim/container/PlayerContainer$3;-><init>(Lcom/comcast/cim/container/PlayerContainer;)V

    const/16 v2, 0x64

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/cmasl/taskexecutor/task/CachingTaskFactory;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;I)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    .line 634
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 626
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getSeriesCollectionSortPolicy()Lcom/xfinity/playerlib/view/browseprograms/SeriesCollectionSortPolicy;
    .locals 2

    .prologue
    .line 440
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->seriesCollectionSortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SeriesCollectionSortPolicy;

    if-nez v0, :cond_0

    .line 441
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/SeriesCollectionSortPolicy;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/view/browseprograms/SeriesCollectionSortPolicy;-><init>(Lcom/xfinity/playerlib/model/user/PlayNowUserManager;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->seriesCollectionSortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SeriesCollectionSortPolicy;

    .line 443
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->seriesCollectionSortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SeriesCollectionSortPolicy;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 440
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getSeriesCombinedTaskExecutorFactory()Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;
    .locals 5

    .prologue
    .line 1396
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->seriesCombinedTaskExecutorFactory:Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;

    if-nez v0, :cond_0

    .line 1397
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getTaskExecutorFactory()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getDibicCombinedCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v3

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoBookmarkDAO()Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->seriesCombinedTaskExecutorFactory:Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;

    .line 1399
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->seriesCombinedTaskExecutorFactory:Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1396
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getSeriesSortPolicy()Lcom/xfinity/playerlib/view/browseprograms/SeriesSortPolicy;
    .locals 2

    .prologue
    .line 426
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->seriesSortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SeriesSortPolicy;

    if-nez v0, :cond_0

    .line 427
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/SeriesSortPolicy;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/view/browseprograms/SeriesSortPolicy;-><init>(Lcom/xfinity/playerlib/model/user/PlayNowUserManager;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->seriesSortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SeriesSortPolicy;

    .line 429
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->seriesSortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SeriesSortPolicy;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 426
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getSideMenuBuilder()Lcom/comcast/cim/android/sideribbon/SideMenuBuilder;
    .locals 2

    .prologue
    .line 1111
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->sideMenuBuilder:Lcom/comcast/cim/android/sideribbon/SideMenuBuilder;

    if-nez v0, :cond_0

    .line 1112
    new-instance v0, Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->sideMenuBuilder:Lcom/comcast/cim/android/sideribbon/SideMenuBuilder;

    .line 1114
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->sideMenuBuilder:Lcom/comcast/cim/android/sideribbon/SideMenuBuilder;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1111
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getSideRibbonDelegateBuilder()Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;
    .locals 4

    .prologue
    .line 1101
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->sideRibbonDelegateBuilder:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;

    if-nez v0, :cond_0

    .line 1102
    new-instance v0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getAccessibilityUtil()Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;-><init>(Lcom/comcast/cim/android/accessibility/AccessibilityUtil;)V

    sget v1, Lcom/xfinity/playerlib/R$color;->dark_gray_1:I

    .line 1103
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;->setBackgroundResource(Ljava/lang/Integer;)Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;

    move-result-object v0

    .line 1104
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/PlayerApplication;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$dimen;->flyin_menu_width:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;->setRibbonWidth(I)Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;

    move-result-object v0

    const-wide/16 v2, 0xfa

    .line 1105
    invoke-virtual {v0, v2, v3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;->setSlideDuration(J)Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->sideRibbonDelegateBuilder:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;

    .line 1107
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->sideRibbonDelegateBuilder:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1101
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getTagsAndProgramsTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 496
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->tagsAndProgramsTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-nez v1, :cond_0

    .line 497
    new-instance v0, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getTagsRootCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getDibicCombinedCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)V

    .line 498
    .local v0, "combinedCache":Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask<Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/xfinity/playerlib/model/dibic/DibicResource;>;"
    new-instance v1, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    invoke-direct {p0}, Lcom/comcast/cim/container/PlayerContainer;->createSingleThreadedExecutor()Ljava/util/concurrent/Executor;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUiThreadExecutor()Lcom/comcast/cim/android/concurrent/UIThreadExecutor;

    move-result-object v3

    invoke-direct {v1, v0, v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;)V

    iput-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->tagsAndProgramsTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 500
    .end local v0    # "combinedCache":Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask<Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/xfinity/playerlib/model/dibic/DibicResource;>;"
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->tagsAndProgramsTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 496
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getTagsExecutor()Ljava/util/concurrent/Executor;
    .locals 1

    .prologue
    .line 909
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->tagsExecutor:Ljava/util/concurrent/Executor;

    if-nez v0, :cond_0

    .line 910
    invoke-direct {p0}, Lcom/comcast/cim/container/PlayerContainer;->createSingleThreadedExecutor()Ljava/util/concurrent/Executor;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->tagsExecutor:Ljava/util/concurrent/Executor;

    .line 912
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->tagsExecutor:Ljava/util/concurrent/Executor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 909
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getTagsParser()Lcom/xfinity/playerlib/model/tags/parser/TagsParser;
    .locals 2

    .prologue
    .line 889
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->tagsParser:Lcom/xfinity/playerlib/model/tags/parser/TagsParser;

    if-nez v0, :cond_0

    .line 890
    new-instance v0, Lcom/xfinity/playerlib/model/tags/parser/TagsParser;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getObjectMapper()Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/model/tags/parser/TagsParser;-><init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->tagsParser:Lcom/xfinity/playerlib/model/tags/parser/TagsParser;

    .line 892
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->tagsParser:Lcom/xfinity/playerlib/model/tags/parser/TagsParser;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 889
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getTagsRootCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            ">;"
        }
    .end annotation

    .prologue
    .line 916
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->tagsRootCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    if-nez v0, :cond_0

    .line 917
    new-instance v7, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpClient()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v0

    invoke-direct {v7, v0}, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    .line 918
    .local v7, "defaultHttpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    new-instance v1, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getPermanentFileCache()Lcom/comcast/cim/cmasl/cachelib/PermanentFileCache;

    move-result-object v0

    invoke-direct {v1, v7, v0}, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/utils/StorageCache;)V

    .line 919
    .local v1, "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    new-instance v0, Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getConsumablesHypermediaServicesCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getDefaultRevalidationPolicy()Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;

    move-result-object v3

    const-string v4, "TagsRootCache"

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getTagsParser()Lcom/xfinity/playerlib/model/tags/parser/TagsParser;

    move-result-object v5

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpRequestProviderFactory()Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    move-result-object v6

    invoke-direct/range {v0 .. v6}, Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;Ljava/lang/String;Lcom/xfinity/playerlib/model/tags/parser/TagsParser;Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->tagsRootCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 921
    .end local v1    # "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    .end local v7    # "defaultHttpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->tagsRootCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 916
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getTagsRootTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            ">;"
        }
    .end annotation

    .prologue
    .line 925
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->tagsRootTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-nez v0, :cond_0

    .line 926
    new-instance v0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getTagsRootCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getTagsExecutor()Ljava/util/concurrent/Executor;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUiThreadExecutor()Lcom/comcast/cim/android/concurrent/UIThreadExecutor;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->tagsRootTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 928
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->tagsRootTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 925
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getThePlatformClient()Lcom/xfinity/playerlib/authorization/ThePlatformClient;
    .locals 3

    .prologue
    .line 1335
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->thePlatformClient:Lcom/xfinity/playerlib/authorization/ThePlatformClient;

    if-nez v1, :cond_0

    .line 1336
    new-instance v0, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpClient()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    .line 1337
    .local v0, "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    new-instance v1, Lcom/xfinity/playerlib/authorization/ThePlatformClient;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpRequestProviderFactory()Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    move-result-object v2

    invoke-direct {v1, v0, v2}, Lcom/xfinity/playerlib/authorization/ThePlatformClient;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;)V

    iput-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->thePlatformClient:Lcom/xfinity/playerlib/authorization/ThePlatformClient;

    .line 1339
    .end local v0    # "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->thePlatformClient:Lcom/xfinity/playerlib/authorization/ThePlatformClient;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 1335
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getTitaniumTicketClient()Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;
    .locals 5

    .prologue
    .line 1247
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->titaniumTicketClient:Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;

    if-nez v1, :cond_0

    .line 1248
    new-instance v0, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpClient()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    .line 1249
    .local v0, "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    new-instance v1, Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getObjectMapper()Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getXipRequestProviderFactory()Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    move-result-object v3

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpRequestSignerFactory()Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    move-result-object v4

    invoke-direct {v1, v0, v2, v3, v4}, Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;)V

    iput-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->titaniumTicketClient:Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;

    .line 1251
    .end local v0    # "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->titaniumTicketClient:Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 1247
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public bridge synthetic getTrackingService()Lcom/comcast/cim/tracking/TrackingService;
    .locals 1

    .prologue
    .line 203
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getTrackingService()Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized getTrackingService()Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;
    .locals 8

    .prologue
    .line 815
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    if-nez v0, :cond_0

    .line 816
    new-instance v0, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/container/PlayerContainer;->playerApplication:Lcom/xfinity/playerlib/PlayerApplication;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/PlayerApplication;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$string;->omniture_product_name:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/container/PlayerContainer;->playerApplication:Lcom/xfinity/playerlib/PlayerApplication;

    .line 817
    invoke-virtual {v3}, Lcom/xfinity/playerlib/PlayerApplication;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/xfinity/playerlib/R$string;->omniture_version:I

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    iget-object v7, p0, Lcom/comcast/cim/container/PlayerContainer;->playerApplication:Lcom/xfinity/playerlib/PlayerApplication;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/PlayerApplication;->getVersionNumber()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    iget-object v7, p0, Lcom/comcast/cim/container/PlayerContainer;->playerApplication:Lcom/xfinity/playerlib/PlayerApplication;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/PlayerApplication;->getVersionCode()I

    move-result v7

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-virtual {v3, v4, v5}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 818
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v4

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getAppMeasurementProvider()Lcom/comcast/cim/cmasl/utils/provider/Provider;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;-><init>(Lcom/xfinity/playerlib/model/user/PlayNowUserManager;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;Lcom/comcast/cim/cmasl/utils/provider/Provider;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    .line 820
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 815
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getTveHypermediaServicesCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/TveHypermediaService;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1326
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->tveHypermediaServiceTask:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    if-nez v0, :cond_0

    .line 1327
    new-instance v0, Lcom/xfinity/playerlib/model/TveHypermediaServicesCache;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHypermediaServicesRevalidationPolicy()Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;

    move-result-object v1

    .line 1328
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHalHttpClient()Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getTveHypermediaUrl()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/xfinity/playerlib/model/TveHypermediaServicesCache;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->tveHypermediaServiceTask:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 1331
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->tveHypermediaServiceTask:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1326
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getTypefaceManager()Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;
    .locals 4

    .prologue
    .line 1203
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/container/PlayerContainer;->typefaceManager:Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;

    if-nez v2, :cond_0

    .line 1204
    new-instance v2, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;

    invoke-direct {v2}, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;-><init>()V

    iput-object v2, p0, Lcom/comcast/cim/container/PlayerContainer;->typefaceManager:Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;

    .line 1206
    new-instance v0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;-><init>(Landroid/content/Context;)V

    .line 1207
    .local v0, "robotoFamily":Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;
    const-string v2, "Roboto-Regular.ttf"

    sget v3, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_REGULAR:I

    invoke-virtual {v0, v2, v3}, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->addTypeface(Ljava/lang/String;I)V

    .line 1208
    const-string v2, "Roboto-Bold.ttf"

    sget v3, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_BOLD:I

    invoke-virtual {v0, v2, v3}, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->addTypeface(Ljava/lang/String;I)V

    .line 1209
    const-string v2, "Roboto-BoldItalic.ttf"

    sget v3, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_BOLD_ITALIC:I

    invoke-virtual {v0, v2, v3}, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->addTypeface(Ljava/lang/String;I)V

    .line 1210
    const-string v2, "Roboto-Condensed.ttf"

    sget v3, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_CONDENSED:I

    invoke-virtual {v0, v2, v3}, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->addTypeface(Ljava/lang/String;I)V

    .line 1211
    const-string v2, "Roboto-Italic.ttf"

    sget v3, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_ITALIC:I

    invoke-virtual {v0, v2, v3}, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->addTypeface(Ljava/lang/String;I)V

    .line 1212
    iget-object v2, p0, Lcom/comcast/cim/container/PlayerContainer;->typefaceManager:Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getRobotoFamilyName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3, v0}, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;->addTypefaceFamily(Ljava/lang/String;Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;)V

    .line 1214
    new-instance v1, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;-><init>(Landroid/content/Context;)V

    .line 1215
    .local v1, "xfinitySansFamily":Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;
    const-string v2, "XFINITYSans-Lgt.otf"

    sget v3, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_LIGHT:I

    invoke-virtual {v1, v2, v3}, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->addTypeface(Ljava/lang/String;I)V

    .line 1216
    const-string v2, "XFINITYSans-Reg.otf"

    sget v3, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_REGULAR:I

    invoke-virtual {v1, v2, v3}, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->addTypeface(Ljava/lang/String;I)V

    .line 1217
    const-string v2, "XFINITYSans-Bold.otf"

    sget v3, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_BOLD:I

    invoke-virtual {v1, v2, v3}, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->addTypeface(Ljava/lang/String;I)V

    .line 1218
    const-string v2, "XFINITYSans-Med.otf"

    sget v3, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_MEDIUM:I

    invoke-virtual {v1, v2, v3}, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->addTypeface(Ljava/lang/String;I)V

    .line 1219
    const-string v2, "XFINITYSans-MedCond.otf"

    sget v3, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_MEDIUM_CONDENSED:I

    invoke-virtual {v1, v2, v3}, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->addTypeface(Ljava/lang/String;I)V

    .line 1220
    const-string v2, "XFINITYSans-Thin.otf"

    sget v3, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_THIN:I

    invoke-virtual {v1, v2, v3}, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->addTypeface(Ljava/lang/String;I)V

    .line 1221
    const-string v2, "XFINITYSans-BoldCond.otf"

    sget v3, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_BOLD_CONDENSED:I

    invoke-virtual {v1, v2, v3}, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->addTypeface(Ljava/lang/String;I)V

    .line 1222
    const-string v2, "XFINITYSansTabCond03.otf"

    sget v3, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_CONDENSED:I

    invoke-virtual {v1, v2, v3}, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->addTypeface(Ljava/lang/String;I)V

    .line 1223
    const-string v2, "XFINITYIndicators.otf"

    sget v3, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_CUSTOM_1:I

    invoke-virtual {v1, v2, v3}, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->addTypeface(Ljava/lang/String;I)V

    .line 1224
    iget-object v2, p0, Lcom/comcast/cim/container/PlayerContainer;->typefaceManager:Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getXfinitySansFamilyName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3, v1}, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;->addTypefaceFamily(Ljava/lang/String;Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;)V

    .line 1226
    .end local v0    # "robotoFamily":Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;
    .end local v1    # "xfinitySansFamily":Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;
    :cond_0
    iget-object v2, p0, Lcom/comcast/cim/container/PlayerContainer;->typefaceManager:Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v2

    .line 1203
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized getUnregisterDeviceClient()Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;
    .locals 5

    .prologue
    .line 1238
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->unregisterDeviceClient:Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;

    if-nez v1, :cond_0

    .line 1239
    new-instance v0, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpClient()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    .line 1240
    .local v0, "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    new-instance v1, Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getObjectMapper()Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getXipRequestProviderFactory()Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    move-result-object v3

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpRequestSignerFactory()Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    move-result-object v4

    invoke-direct {v1, v0, v2, v3, v4}, Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;-><init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;)V

    iput-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->unregisterDeviceClient:Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;

    .line 1243
    .end local v0    # "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->unregisterDeviceClient:Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 1238
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getUserAndIntervalRevalidationPolicy()Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/comcast/cim/model/user/XipUser;",
            "Ljava/lang/Integer;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 777
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->userAndIntervalRevalidationPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;

    if-nez v0, :cond_0

    .line 778
    new-instance v0, Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserChangeRevalidationPolicy()Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getDefaultRevalidationPolicy()Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/model/provider/CompositeRevalidationPolicy;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->userAndIntervalRevalidationPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;

    .line 780
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->userAndIntervalRevalidationPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 777
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getUserChangeRevalidationPolicy()Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy",
            "<",
            "Lcom/comcast/cim/model/user/XipUser;",
            ">;"
        }
    .end annotation

    .prologue
    .line 683
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->userRevalidationPolicy:Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy;

    if-nez v0, :cond_0

    .line 684
    new-instance v0, Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy;-><init>(Lcom/comcast/cim/model/user/UserManager;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->userRevalidationPolicy:Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy;

    .line 686
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->userRevalidationPolicy:Lcom/comcast/cim/model/provider/UserChangeRevalidationPolicy;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 683
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getUserDao()Lcom/xfinity/playerlib/model/user/service/PlayNowUserDao;
    .locals 2

    .prologue
    .line 868
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->userDao:Lcom/xfinity/playerlib/model/user/service/PlayNowUserDao;

    if-nez v0, :cond_0

    .line 869
    new-instance v0, Lcom/xfinity/playerlib/model/user/service/PlayNowUserDao;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getPreferencesUserStore()Lcom/comcast/cim/model/user/service/PreferencesUserStore;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/model/user/service/PlayNowUserDao;-><init>(Lcom/comcast/cim/model/user/service/PreferencesUserStore;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->userDao:Lcom/xfinity/playerlib/model/user/service/PlayNowUserDao;

    .line 871
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->userDao:Lcom/xfinity/playerlib/model/user/service/PlayNowUserDao;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 868
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getUserJsonDeserializer()Lcom/comcast/cim/utils/JsonDeserializer;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/utils/JsonDeserializer",
            "<",
            "Lcom/xfinity/playerlib/model/user/PlayNowUser;",
            ">;"
        }
    .end annotation

    .prologue
    .line 875
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->userJsonDeserializer:Lcom/comcast/cim/utils/JsonDeserializer;

    if-nez v0, :cond_0

    .line 876
    new-instance v0, Lcom/comcast/cim/utils/JsonDeserializer;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getObjectMapper()Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/utils/JsonDeserializer;-><init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->userJsonDeserializer:Lcom/comcast/cim/utils/JsonDeserializer;

    .line 878
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->userJsonDeserializer:Lcom/comcast/cim/utils/JsonDeserializer;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 875
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public bridge synthetic getUserManager()Lcom/comcast/cim/model/user/UserManager;
    .locals 1

    .prologue
    .line 203
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    .locals 11

    .prologue
    .line 933
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    if-nez v0, :cond_0

    .line 934
    new-instance v0, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserDao()Lcom/xfinity/playerlib/model/user/service/PlayNowUserDao;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserSettingsDao()Lcom/comcast/cim/model/user/service/UserSettingsDao;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getCurrentUser()Lcom/comcast/cim/model/user/CurrentUser;

    move-result-object v3

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserSaveExecutor()Lcom/comcast/cim/cmasl/utils/executor/ExceptionHandlingSingleThreadExecutor;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;-><init>(Lcom/xfinity/playerlib/model/user/service/PlayNowUserDao;Lcom/comcast/cim/model/user/service/UserSettingsDao;Lcom/comcast/cim/model/user/CurrentUser;Lcom/comcast/cim/cmasl/utils/executor/ExceptionHandlingSingleThreadExecutor;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 937
    new-instance v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getJsonSerializer()Lcom/comcast/cim/utils/JsonSerializer;

    move-result-object v2

    .line 938
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getDownloadableFileFactory()Lcom/xfinity/playerlib/model/downloads/DownloadableFileFactory;

    move-result-object v3

    iget-object v4, p0, Lcom/comcast/cim/container/PlayerContainer;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 939
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getWatchableCodec()Lcom/xfinity/playerlib/model/consumable/WatchableCodec;

    move-result-object v5

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getPersistentEntityCache()Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;

    move-result-object v6

    .line 940
    invoke-direct {p0}, Lcom/comcast/cim/container/PlayerContainer;->createSingleThreadedExecutor()Ljava/util/concurrent/Executor;

    move-result-object v7

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUiThreadExecutor()Lcom/comcast/cim/android/concurrent/UIThreadExecutor;

    move-result-object v8

    .line 941
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getTrackingService()Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    move-result-object v9

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v10

    invoke-direct/range {v0 .. v10}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;-><init>(Lcom/xfinity/playerlib/PlayerApplication;Lcom/comcast/cim/utils/JsonSerializer;Lcom/xfinity/playerlib/model/downloads/DownloadableFileFactory;Lcom/xfinity/playerlib/model/user/PlayNowUserManager;Lcom/xfinity/playerlib/model/consumable/WatchableCodec;Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;Landroid/content/SharedPreferences;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    .line 944
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->createAppUpgradeHelper()Lcom/comcast/cim/android/application/AppUpgradeHelper;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->appUpgradeHelper:Lcom/comcast/cim/android/application/AppUpgradeHelper;

    .line 946
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    new-instance v1, Lcom/comcast/cim/container/PlayerContainer$9;

    invoke-direct {v1, p0}, Lcom/comcast/cim/container/PlayerContainer$9;-><init>(Lcom/comcast/cim/container/PlayerContainer;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->addUserManagerListener(Lcom/comcast/cim/model/user/UserManager$UserManagerListener;)V

    .line 968
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 933
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getUserSaveExecutor()Lcom/comcast/cim/cmasl/utils/executor/ExceptionHandlingSingleThreadExecutor;
    .locals 2

    .prologue
    .line 824
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->userSaveExecutor:Lcom/comcast/cim/cmasl/utils/executor/ExceptionHandlingSingleThreadExecutor;

    if-nez v0, :cond_0

    .line 825
    new-instance v0, Lcom/comcast/cim/cmasl/utils/executor/ExceptionHandlingSingleThreadExecutor;

    const-string v1, "userSaveExecutor"

    invoke-direct {v0, v1}, Lcom/comcast/cim/cmasl/utils/executor/ExceptionHandlingSingleThreadExecutor;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->userSaveExecutor:Lcom/comcast/cim/cmasl/utils/executor/ExceptionHandlingSingleThreadExecutor;

    .line 827
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->userSaveExecutor:Lcom/comcast/cim/cmasl/utils/executor/ExceptionHandlingSingleThreadExecutor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 824
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getUserSettingsDao()Lcom/comcast/cim/model/user/service/UserSettingsDao;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/model/user/service/UserSettingsDao",
            "<",
            "Lcom/xfinity/playerlib/model/user/PlayerUserSettings;",
            ">;"
        }
    .end annotation

    .prologue
    .line 845
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/container/PlayerContainer;->userSettingsDao:Lcom/comcast/cim/model/user/service/UserSettingsDao;

    if-nez v2, :cond_0

    .line 846
    new-instance v0, Lcom/comcast/cim/container/PlayerContainer$7;

    invoke-direct {v0, p0}, Lcom/comcast/cim/container/PlayerContainer$7;-><init>(Lcom/comcast/cim/container/PlayerContainer;)V

    .line 852
    .local v0, "settingsFactory":Lcom/comcast/cim/cmasl/utils/provider/Provider;, "Lcom/comcast/cim/cmasl/utils/provider/Provider<Lcom/xfinity/playerlib/model/user/PlayerUserSettings;>;"
    new-instance v1, Lcom/comcast/cim/container/PlayerContainer$8;

    invoke-direct {v1, p0}, Lcom/comcast/cim/container/PlayerContainer$8;-><init>(Lcom/comcast/cim/container/PlayerContainer;)V

    .line 858
    .local v1, "settingsInjector":Lcom/comcast/cim/cmasl/utils/initializer/Initializer;, "Lcom/comcast/cim/cmasl/utils/initializer/Initializer<Lcom/xfinity/playerlib/model/user/PlayerUserSettings;>;"
    new-instance v2, Lcom/comcast/cim/model/user/service/UserSettingsDao;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserSettingsStore()Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;

    move-result-object v3

    invoke-direct {v2, v3, v0, v1}, Lcom/comcast/cim/model/user/service/UserSettingsDao;-><init>(Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;Lcom/comcast/cim/cmasl/utils/provider/Provider;Lcom/comcast/cim/cmasl/utils/initializer/Initializer;)V

    iput-object v2, p0, Lcom/comcast/cim/container/PlayerContainer;->userSettingsDao:Lcom/comcast/cim/model/user/service/UserSettingsDao;

    .line 860
    .end local v0    # "settingsFactory":Lcom/comcast/cim/cmasl/utils/provider/Provider;, "Lcom/comcast/cim/cmasl/utils/provider/Provider<Lcom/xfinity/playerlib/model/user/PlayerUserSettings;>;"
    .end local v1    # "settingsInjector":Lcom/comcast/cim/cmasl/utils/initializer/Initializer;, "Lcom/comcast/cim/cmasl/utils/initializer/Initializer<Lcom/xfinity/playerlib/model/user/PlayerUserSettings;>;"
    :cond_0
    iget-object v2, p0, Lcom/comcast/cim/container/PlayerContainer;->userSettingsDao:Lcom/comcast/cim/model/user/service/UserSettingsDao;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v2

    .line 845
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized getUserSettingsJsonDeserializer()Lcom/comcast/cim/utils/JsonDeserializer;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/utils/JsonDeserializer",
            "<",
            "Lcom/xfinity/playerlib/model/user/PlayerUserSettings;",
            ">;"
        }
    .end annotation

    .prologue
    .line 831
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->userSettingsJsonDeserializer:Lcom/comcast/cim/utils/JsonDeserializer;

    if-nez v0, :cond_0

    .line 832
    new-instance v0, Lcom/comcast/cim/utils/JsonDeserializer;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getObjectMapper()Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/utils/JsonDeserializer;-><init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->userSettingsJsonDeserializer:Lcom/comcast/cim/utils/JsonDeserializer;

    .line 834
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->userSettingsJsonDeserializer:Lcom/comcast/cim/utils/JsonDeserializer;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 831
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getUserSettingsStore()Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore",
            "<",
            "Lcom/xfinity/playerlib/model/user/PlayerUserSettings;",
            ">;"
        }
    .end annotation

    .prologue
    .line 838
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->userSettingsStore:Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;

    if-nez v0, :cond_0

    .line 839
    new-instance v0, Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getJsonSerializer()Lcom/comcast/cim/utils/JsonSerializer;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserSettingsJsonDeserializer()Lcom/comcast/cim/utils/JsonDeserializer;

    move-result-object v3

    const-class v4, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;-><init>(Landroid/content/SharedPreferences;Lcom/comcast/cim/utils/JsonSerializer;Lcom/comcast/cim/utils/JsonDeserializer;Ljava/lang/Class;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->userSettingsStore:Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;

    .line 841
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->userSettingsStore:Lcom/comcast/cim/model/user/service/PreferencesUserSettingsStore;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 838
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getVideoAuthManager()Lcom/xfinity/playerlib/authorization/VideoAuthManager;
    .locals 9
    .annotation runtime Lcom/comcast/cim/container/NonSingleton;
    .end annotation

    .prologue
    .line 406
    monitor-enter p0

    :try_start_0
    new-instance v3, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpClient()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v0

    invoke-direct {v3, v0}, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    .line 407
    .local v3, "defaultService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    new-instance v0, Lcom/xfinity/playerlib/authorization/VideoAuthManager;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getObjectMapper()Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v4

    .line 408
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getTrackingService()Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    move-result-object v5

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpRequestProviderFactory()Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    move-result-object v6

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getXipRequestProviderFactory()Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    move-result-object v7

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpRequestSignerFactory()Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    move-result-object v8

    invoke-direct/range {v0 .. v8}, Lcom/xfinity/playerlib/authorization/VideoAuthManager;-><init>(Lcom/xfinity/playerlib/model/user/PlayNowUserManager;Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 406
    .end local v3    # "defaultService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/cmasl/http/request/RequestProvider<Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;>;>;"
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getVideoBookmarkDAO()Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;
    .locals 4

    .prologue
    .line 1004
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->bookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    if-nez v1, :cond_0

    .line 1005
    new-instance v0, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getPlayNowDatabase()Lcom/xfinity/playerlib/model/database/PlayNowDatabase;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoTracker()Lcom/xfinity/playerlib/view/videoplay/VideoTracker;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;-><init>(Lcom/xfinity/playerlib/model/database/PlayNowDatabase;Lcom/xfinity/playerlib/model/user/PlayNowUserManager;Lcom/xfinity/playerlib/view/videoplay/VideoTracker;)V

    .line 1006
    .local v0, "delegateDAO":Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;
    new-instance v1, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserAndIntervalRevalidationPolicy()Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;

    move-result-object v2

    const/16 v3, 0xc8

    invoke-direct {v1, v0, v2, v3}, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;-><init>(Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;I)V

    iput-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->bookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    .line 1008
    .end local v0    # "delegateDAO":Lcom/xfinity/playerlib/model/database/DefaultVideoBookmarkDAO;
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->bookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 1004
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;"
        }
    .end annotation

    .prologue
    .line 610
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    if-nez v0, :cond_0

    .line 611
    new-instance v0, Lcom/xfinity/playerlib/model/entitlement/GracefullyDegradingVideoEntitlementCache;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getNonDegradingVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/model/entitlement/GracefullyDegradingVideoEntitlementCache;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 613
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 610
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getVideoEntitlementFileCache()Lcom/comcast/cim/cmasl/utils/StorageCache;
    .locals 3

    .prologue
    .line 1433
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->videoEntitlementFileCache:Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;

    if-nez v0, :cond_0

    .line 1434
    new-instance v0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v1

    const-string v2, "VideoEntitlementCache"

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->videoEntitlementFileCache:Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;

    .line 1437
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->videoEntitlementFileCache:Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;

    return-object v0
.end method

.method public declared-synchronized getVideoEntitlementTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;"
        }
    .end annotation

    .prologue
    .line 596
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->videoEntitlementTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-nez v0, :cond_0

    .line 597
    new-instance v0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v1

    invoke-direct {p0}, Lcom/comcast/cim/container/PlayerContainer;->createSingleThreadedExecutor()Ljava/util/concurrent/Executor;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUiThreadExecutor()Lcom/comcast/cim/android/concurrent/UIThreadExecutor;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->videoEntitlementTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 599
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->videoEntitlementTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 596
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getVideoPlayUtil()Lcom/xfinity/playerlib/VideoPlayUtil;
    .locals 1

    .prologue
    .line 396
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->videoPlayUtil:Lcom/xfinity/playerlib/VideoPlayUtil;

    if-nez v0, :cond_0

    .line 397
    new-instance v0, Lcom/xfinity/playerlib/VideoPlayUtil;

    invoke-direct {v0}, Lcom/xfinity/playerlib/VideoPlayUtil;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->videoPlayUtil:Lcom/xfinity/playerlib/VideoPlayUtil;

    .line 399
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->videoPlayUtil:Lcom/xfinity/playerlib/VideoPlayUtil;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 396
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getVideoTracker()Lcom/xfinity/playerlib/view/videoplay/VideoTracker;
    .locals 2

    .prologue
    .line 697
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->videoTracker:Lcom/xfinity/playerlib/view/videoplay/VideoTracker;

    if-nez v0, :cond_0

    .line 698
    new-instance v0, Lcom/xfinity/playerlib/view/videoplay/VideoTracker;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoTrackerSharedPreferenceProvider()Lcom/xfinity/playerlib/view/videoplay/VideoTrackerSharedPreferenceProvider;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoTracker;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoTrackerSharedPreferenceProvider;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->videoTracker:Lcom/xfinity/playerlib/view/videoplay/VideoTracker;

    .line 700
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->videoTracker:Lcom/xfinity/playerlib/view/videoplay/VideoTracker;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 697
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getVideoTrackerSharedPreferenceProvider()Lcom/xfinity/playerlib/view/videoplay/VideoTrackerSharedPreferenceProvider;
    .locals 3

    .prologue
    .line 690
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->videoTrackerSharedPreferenceProvider:Lcom/xfinity/playerlib/view/videoplay/VideoTrackerSharedPreferenceProvider;

    if-nez v0, :cond_0

    .line 691
    new-instance v0, Lcom/xfinity/playerlib/view/videoplay/VideoTrackerSharedPreferenceProvider;

    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer;->playerApplication:Lcom/xfinity/playerlib/PlayerApplication;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackerSharedPreferenceProvider;-><init>(Landroid/content/Context;Lcom/xfinity/playerlib/model/user/PlayNowUserManager;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->videoTrackerSharedPreferenceProvider:Lcom/xfinity/playerlib/view/videoplay/VideoTrackerSharedPreferenceProvider;

    .line 693
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->videoTrackerSharedPreferenceProvider:Lcom/xfinity/playerlib/view/videoplay/VideoTrackerSharedPreferenceProvider;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 690
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getVolatileDownloadableFileCache()Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1165
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->volatileDownloadableFileCache:Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;

    if-nez v0, :cond_0

    .line 1166
    new-instance v0, Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;

    const/16 v1, 0xa

    invoke-direct {v0, v1}, Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;-><init>(I)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->volatileDownloadableFileCache:Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;

    .line 1168
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->volatileDownloadableFileCache:Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1165
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getWatchableClient()Lcom/xfinity/playerlib/model/consumable/WatchableClient;
    .locals 4

    .prologue
    .line 676
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->watchableClient:Lcom/xfinity/playerlib/model/consumable/WatchableClient;

    if-nez v0, :cond_0

    .line 677
    new-instance v0, Lcom/xfinity/playerlib/model/consumable/WatchableClient;

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getMovieCacheMap()Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getSeriesCacheMap()Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    move-result-object v2

    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getWatchableCodec()Lcom/xfinity/playerlib/model/consumable/WatchableCodec;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/xfinity/playerlib/model/consumable/WatchableClient;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;Lcom/xfinity/playerlib/model/consumable/WatchableCodec;)V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->watchableClient:Lcom/xfinity/playerlib/model/consumable/WatchableClient;

    .line 679
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->watchableClient:Lcom/xfinity/playerlib/model/consumable/WatchableClient;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 676
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getWatchableCodec()Lcom/xfinity/playerlib/model/consumable/WatchableCodec;
    .locals 1

    .prologue
    .line 1141
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->watchableCodec:Lcom/xfinity/playerlib/model/consumable/WatchableCodec;

    if-nez v0, :cond_0

    .line 1142
    new-instance v0, Lcom/xfinity/playerlib/model/consumable/WatchableCodec;

    invoke-direct {v0}, Lcom/xfinity/playerlib/model/consumable/WatchableCodec;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->watchableCodec:Lcom/xfinity/playerlib/model/consumable/WatchableCodec;

    .line 1144
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer;->watchableCodec:Lcom/xfinity/playerlib/model/consumable/WatchableCodec;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 1141
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized isDebuggable()Z
    .locals 2

    .prologue
    .line 896
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/PlayerApplication;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    iget v1, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/lit8 v1, v1, 0x2

    iput v1, v0, Landroid/content/pm/ApplicationInfo;->flags:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit p0

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected shouldDisableSSLVerification()Z
    .locals 1

    .prologue
    .line 901
    invoke-virtual {p0}, Lcom/comcast/cim/container/PlayerContainer;->isDebuggable()Z

    move-result v0

    return v0
.end method
