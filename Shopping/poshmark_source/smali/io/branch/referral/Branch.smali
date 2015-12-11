.class public Lio/branch/referral/Branch;
.super Ljava/lang/Object;
.source "Branch.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/branch/referral/Branch$ShareLinkBuilder;,
        Lio/branch/referral/Branch$BranchWindowCallback;,
        Lio/branch/referral/Branch$BranchPostTask;,
        Lio/branch/referral/Branch$getShortLinkTask;,
        Lio/branch/referral/Branch$CreditHistoryOrder;,
        Lio/branch/referral/Branch$LogoutStatusListener;,
        Lio/branch/referral/Branch$BranchListResponseListener;,
        Lio/branch/referral/Branch$BranchLinkShareListener;,
        Lio/branch/referral/Branch$BranchLinkCreateListener;,
        Lio/branch/referral/Branch$BranchReferralStateChangedListener;,
        Lio/branch/referral/Branch$BranchUniversalReferralInitListener;,
        Lio/branch/referral/Branch$BranchReferralInitListener;,
        Lio/branch/referral/Branch$BranchActivityLifeCycleObserver;,
        Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;,
        Lio/branch/referral/Branch$SESSION_STATE;
    }
.end annotation


# static fields
.field public static final ALWAYS_DEEPLINK:Ljava/lang/String; = "$always_deeplink"

.field private static final AUTO_DEEP_LINKED:Ljava/lang/String; = "io.branch.sdk.auto_linked"

.field private static final AUTO_DEEP_LINK_DISABLE:Ljava/lang/String; = "io.branch.sdk.auto_link_disable"

.field private static final AUTO_DEEP_LINK_KEY:Ljava/lang/String; = "io.branch.sdk.auto_link_keys"

.field private static final AUTO_DEEP_LINK_PATH:Ljava/lang/String; = "io.branch.sdk.auto_link_path"

.field private static final AUTO_DEEP_LINK_REQ_CODE:Ljava/lang/String; = "io.branch.sdk.auto_link_request_code"

.field public static final DEEPLINK_PATH:Ljava/lang/String; = "$deeplink_path"

.field private static final DEF_AUTO_DEEP_LINK_REQ_CODE:I = 0x5dd

.field public static final FEATURE_TAG_DEAL:Ljava/lang/String; = "deal"

.field public static final FEATURE_TAG_GIFT:Ljava/lang/String; = "gift"

.field public static final FEATURE_TAG_INVITE:Ljava/lang/String; = "invite"

.field public static final FEATURE_TAG_REFERRAL:Ljava/lang/String; = "referral"

.field public static final FEATURE_TAG_SHARE:Ljava/lang/String; = "share"

.field public static final LINK_TYPE_ONE_TIME_USE:I = 0x1

.field public static final LINK_TYPE_UNLIMITED_USE:I = 0x0

.field public static final OG_APP_ID:Ljava/lang/String; = "$og_app_id"

.field public static final OG_DESC:Ljava/lang/String; = "$og_description"

.field public static final OG_IMAGE_URL:Ljava/lang/String; = "$og_image_url"

.field public static final OG_TITLE:Ljava/lang/String; = "$og_title"

.field public static final OG_URL:Ljava/lang/String; = "$og_url"

.field public static final OG_VIDEO:Ljava/lang/String; = "$og_video"

.field private static final PREVENT_CLOSE_TIMEOUT:I = 0x1f4

.field public static final REDEEM_CODE:Ljava/lang/String; = "$redeem_code"

.field public static final REDIRECT_ANDROID_URL:Ljava/lang/String; = "$android_url"

.field public static final REDIRECT_BLACKBERRY_URL:Ljava/lang/String; = "$blackberry_url"

.field public static final REDIRECT_DESKTOP_URL:Ljava/lang/String; = "$desktop_url"

.field public static final REDIRECT_FIRE_URL:Ljava/lang/String; = "$fire_url"

.field public static final REDIRECT_IOS_URL:Ljava/lang/String; = "$ios_url"

.field public static final REDIRECT_IPAD_URL:Ljava/lang/String; = "$ipad_url"

.field public static final REDIRECT_WINDOWS_PHONE_URL:Ljava/lang/String; = "$windows_phone_url"

.field public static final REFERRAL_BUCKET_DEFAULT:Ljava/lang/String; = "default"

.field public static final REFERRAL_CODE:Ljava/lang/String; = "referral_code"

.field public static final REFERRAL_CODE_AWARD_UNIQUE:I = 0x0

.field public static final REFERRAL_CODE_AWARD_UNLIMITED:I = 0x1

.field public static final REFERRAL_CODE_LOCATION_BOTH:I = 0x3

.field public static final REFERRAL_CODE_LOCATION_REFERREE:I = 0x0

.field public static final REFERRAL_CODE_LOCATION_REFERRING_USER:I = 0x2

.field public static final REFERRAL_CODE_TYPE:Ljava/lang/String; = "credit"

.field public static final REFERRAL_CREATION_SOURCE_SDK:I = 0x2

.field private static final SESSION_KEEPALIVE:I = 0x7d0

.field private static final TAG:Ljava/lang/String; = "BranchSDK"

.field private static branchReferral_:Lio/branch/referral/Branch;

.field private static customReferrableSettings_:Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;

.field private static isActivityLifeCycleCallbackRegistered_:Z

.field private static isAutoSessionMode_:Z


# instance fields
.field private appListingSchedule_:Ljava/util/concurrent/ScheduledFuture;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ScheduledFuture",
            "<*>;"
        }
    .end annotation
.end field

.field private closeTimer:Ljava/util/Timer;

.field private context_:Landroid/content/Context;

.field private currentActivity_:Landroid/app/Activity;

.field private debugHandler_:Landroid/os/Handler;

.field private debugListenerInitHistory_:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private debugOnTouchListener_:Landroid/view/View$OnTouchListener;

.field private debugStarted_:Z

.field private hasNetwork_:Z

.field private initState_:Lio/branch/referral/Branch$SESSION_STATE;

.field private isInitReportedThroughCallBack:Z

.field private kRemoteInterface_:Lio/branch/referral/BranchRemoteInterface;

.field private keepAlive_:Z

.field private linkCache_:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lio/branch/referral/BranchLinkData;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field final lock:Ljava/lang/Object;

.field private networkCount_:I

.field private prefHelper_:Lio/branch/referral/PrefHelper;

.field private requestQueue_:Lio/branch/referral/ServerRequestQueue;

.field private rotateCloseTimer:Ljava/util/Timer;

.field private serverSema_:Ljava/util/concurrent/Semaphore;

.field private shareLinkManager_:Lio/branch/referral/ShareLinkManager;

.field private systemObserver_:Lio/branch/referral/SystemObserver;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 322
    sput-boolean v0, Lio/branch/referral/Branch;->isAutoSessionMode_:Z

    .line 325
    sput-boolean v0, Lio/branch/referral/Branch;->isActivityLifeCycleCallbackRegistered_:Z

    .line 347
    sget-object v0, Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;->USE_DEFAULT:Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;

    sput-object v0, Lio/branch/referral/Branch;->customReferrableSettings_:Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 378
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 333
    sget-object v0, Lio/branch/referral/Branch$SESSION_STATE;->UNINITIALISED:Lio/branch/referral/Branch$SESSION_STATE;

    iput-object v0, p0, Lio/branch/referral/Branch;->initState_:Lio/branch/referral/Branch$SESSION_STATE;

    .line 368
    iput-boolean v1, p0, Lio/branch/referral/Branch;->isInitReportedThroughCallBack:Z

    .line 379
    invoke-static {p1}, Lio/branch/referral/PrefHelper;->getInstance(Landroid/content/Context;)Lio/branch/referral/PrefHelper;

    move-result-object v0

    iput-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    .line 380
    new-instance v0, Lio/branch/referral/BranchRemoteInterface;

    invoke-direct {v0, p1}, Lio/branch/referral/BranchRemoteInterface;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lio/branch/referral/Branch;->kRemoteInterface_:Lio/branch/referral/BranchRemoteInterface;

    .line 381
    new-instance v0, Lio/branch/referral/SystemObserver;

    invoke-direct {v0, p1}, Lio/branch/referral/SystemObserver;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lio/branch/referral/Branch;->systemObserver_:Lio/branch/referral/SystemObserver;

    .line 382
    invoke-static {p1}, Lio/branch/referral/ServerRequestQueue;->getInstance(Landroid/content/Context;)Lio/branch/referral/ServerRequestQueue;

    move-result-object v0

    iput-object v0, p0, Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;

    .line 383
    new-instance v0, Ljava/util/concurrent/Semaphore;

    invoke-direct {v0, v2}, Ljava/util/concurrent/Semaphore;-><init>(I)V

    iput-object v0, p0, Lio/branch/referral/Branch;->serverSema_:Ljava/util/concurrent/Semaphore;

    .line 384
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Lio/branch/referral/Branch;->closeTimer:Ljava/util/Timer;

    .line 385
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Lio/branch/referral/Branch;->rotateCloseTimer:Ljava/util/Timer;

    .line 386
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lio/branch/referral/Branch;->lock:Ljava/lang/Object;

    .line 387
    iput-boolean v1, p0, Lio/branch/referral/Branch;->keepAlive_:Z

    .line 388
    iput v1, p0, Lio/branch/referral/Branch;->networkCount_:I

    .line 389
    iput-boolean v2, p0, Lio/branch/referral/Branch;->hasNetwork_:Z

    .line 390
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Lio/branch/referral/Branch;->debugListenerInitHistory_:Landroid/util/SparseArray;

    .line 391
    invoke-direct {p0}, Lio/branch/referral/Branch;->retrieveOnTouchListener()Landroid/view/View$OnTouchListener;

    move-result-object v0

    iput-object v0, p0, Lio/branch/referral/Branch;->debugOnTouchListener_:Landroid/view/View$OnTouchListener;

    .line 392
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lio/branch/referral/Branch;->debugHandler_:Landroid/os/Handler;

    .line 393
    iput-boolean v1, p0, Lio/branch/referral/Branch;->debugStarted_:Z

    .line 394
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lio/branch/referral/Branch;->linkCache_:Ljava/util/Map;

    .line 396
    return-void
.end method

.method static synthetic access$100(Lio/branch/referral/Branch;)Lio/branch/referral/PrefHelper;
    .locals 1
    .param p0, "x0"    # Lio/branch/referral/Branch;

    .prologue
    .line 77
    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    return-object v0
.end method

.method static synthetic access$1100(Lio/branch/referral/Branch;Landroid/app/Activity;)V
    .locals 0
    .param p0, "x0"    # Lio/branch/referral/Branch;
    .param p1, "x1"    # Landroid/app/Activity;

    .prologue
    .line 77
    invoke-direct {p0, p1}, Lio/branch/referral/Branch;->setTouchDebugInternal(Landroid/app/Activity;)V

    return-void
.end method

.method static synthetic access$1200(Lio/branch/referral/Branch;Landroid/app/Activity;)V
    .locals 0
    .param p0, "x0"    # Lio/branch/referral/Branch;
    .param p1, "x1"    # Landroid/app/Activity;

    .prologue
    .line 77
    invoke-direct {p0, p1}, Lio/branch/referral/Branch;->clearTouchDebugInternal(Landroid/app/Activity;)V

    return-void
.end method

.method static synthetic access$1300(Lio/branch/referral/Branch;)Lio/branch/referral/ShareLinkManager;
    .locals 1
    .param p0, "x0"    # Lio/branch/referral/Branch;

    .prologue
    .line 77
    iget-object v0, p0, Lio/branch/referral/Branch;->shareLinkManager_:Lio/branch/referral/ShareLinkManager;

    return-object v0
.end method

.method static synthetic access$1400(Lio/branch/referral/Branch;)V
    .locals 0
    .param p0, "x0"    # Lio/branch/referral/Branch;

    .prologue
    .line 77
    invoke-direct {p0}, Lio/branch/referral/Branch;->closeSessionInternal()V

    return-void
.end method

.method static synthetic access$1500(Lio/branch/referral/Branch;)Lio/branch/referral/BranchRemoteInterface;
    .locals 1
    .param p0, "x0"    # Lio/branch/referral/Branch;

    .prologue
    .line 77
    iget-object v0, p0, Lio/branch/referral/Branch;->kRemoteInterface_:Lio/branch/referral/BranchRemoteInterface;

    return-object v0
.end method

.method static synthetic access$1600(Lio/branch/referral/Branch;)Z
    .locals 1
    .param p0, "x0"    # Lio/branch/referral/Branch;

    .prologue
    .line 77
    iget-boolean v0, p0, Lio/branch/referral/Branch;->hasNetwork_:Z

    return v0
.end method

.method static synthetic access$1602(Lio/branch/referral/Branch;Z)Z
    .locals 0
    .param p0, "x0"    # Lio/branch/referral/Branch;
    .param p1, "x1"    # Z

    .prologue
    .line 77
    iput-boolean p1, p0, Lio/branch/referral/Branch;->hasNetwork_:Z

    return p1
.end method

.method static synthetic access$1700(Lio/branch/referral/Branch;)Lio/branch/referral/Branch$SESSION_STATE;
    .locals 1
    .param p0, "x0"    # Lio/branch/referral/Branch;

    .prologue
    .line 77
    iget-object v0, p0, Lio/branch/referral/Branch;->initState_:Lio/branch/referral/Branch$SESSION_STATE;

    return-object v0
.end method

.method static synthetic access$1702(Lio/branch/referral/Branch;Lio/branch/referral/Branch$SESSION_STATE;)Lio/branch/referral/Branch$SESSION_STATE;
    .locals 0
    .param p0, "x0"    # Lio/branch/referral/Branch;
    .param p1, "x1"    # Lio/branch/referral/Branch$SESSION_STATE;

    .prologue
    .line 77
    iput-object p1, p0, Lio/branch/referral/Branch;->initState_:Lio/branch/referral/Branch$SESSION_STATE;

    return-object p1
.end method

.method static synthetic access$1800(Lio/branch/referral/Branch;)Lio/branch/referral/ServerRequestQueue;
    .locals 1
    .param p0, "x0"    # Lio/branch/referral/Branch;

    .prologue
    .line 77
    iget-object v0, p0, Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;

    return-object v0
.end method

.method static synthetic access$1900(Lio/branch/referral/Branch;II)V
    .locals 0
    .param p0, "x0"    # Lio/branch/referral/Branch;
    .param p1, "x1"    # I
    .param p2, "x2"    # I

    .prologue
    .line 77
    invoke-direct {p0, p1, p2}, Lio/branch/referral/Branch;->handleFailure(II)V

    return-void
.end method

.method static synthetic access$200(Lio/branch/referral/Branch;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lio/branch/referral/Branch;

    .prologue
    .line 77
    iget-object v0, p0, Lio/branch/referral/Branch;->debugHandler_:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$2002(Lio/branch/referral/Branch;I)I
    .locals 0
    .param p0, "x0"    # Lio/branch/referral/Branch;
    .param p1, "x1"    # I

    .prologue
    .line 77
    iput p1, p0, Lio/branch/referral/Branch;->networkCount_:I

    return p1
.end method

.method static synthetic access$2100(Lio/branch/referral/Branch;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Lio/branch/referral/Branch;

    .prologue
    .line 77
    iget-object v0, p0, Lio/branch/referral/Branch;->linkCache_:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic access$2200(Lio/branch/referral/Branch;)V
    .locals 0
    .param p0, "x0"    # Lio/branch/referral/Branch;

    .prologue
    .line 77
    invoke-direct {p0}, Lio/branch/referral/Branch;->updateAllRequestsInQueue()V

    return-void
.end method

.method static synthetic access$2300()Lio/branch/referral/Branch;
    .locals 1

    .prologue
    .line 77
    sget-object v0, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    return-object v0
.end method

.method static synthetic access$2402(Lio/branch/referral/Branch;Z)Z
    .locals 0
    .param p0, "x0"    # Lio/branch/referral/Branch;
    .param p1, "x1"    # Z

    .prologue
    .line 77
    iput-boolean p1, p0, Lio/branch/referral/Branch;->isInitReportedThroughCallBack:Z

    return p1
.end method

.method static synthetic access$2500(Lio/branch/referral/Branch;)V
    .locals 0
    .param p0, "x0"    # Lio/branch/referral/Branch;

    .prologue
    .line 77
    invoke-direct {p0}, Lio/branch/referral/Branch;->checkForAutoDeepLinkConfiguration()V

    return-void
.end method

.method static synthetic access$2600(Lio/branch/referral/Branch;)V
    .locals 0
    .param p0, "x0"    # Lio/branch/referral/Branch;

    .prologue
    .line 77
    invoke-direct {p0}, Lio/branch/referral/Branch;->processNextQueueItem()V

    return-void
.end method

.method static synthetic access$2800(Lio/branch/referral/Branch;)Z
    .locals 1
    .param p0, "x0"    # Lio/branch/referral/Branch;

    .prologue
    .line 77
    iget-boolean v0, p0, Lio/branch/referral/Branch;->debugStarted_:Z

    return v0
.end method

.method static synthetic access$2802(Lio/branch/referral/Branch;Z)Z
    .locals 0
    .param p0, "x0"    # Lio/branch/referral/Branch;
    .param p1, "x1"    # Z

    .prologue
    .line 77
    iput-boolean p1, p0, Lio/branch/referral/Branch;->debugStarted_:Z

    return p1
.end method

.method static synthetic access$2900(Lio/branch/referral/Branch;Lio/branch/referral/Branch$ShareLinkBuilder;)V
    .locals 0
    .param p0, "x0"    # Lio/branch/referral/Branch;
    .param p1, "x1"    # Lio/branch/referral/Branch$ShareLinkBuilder;

    .prologue
    .line 77
    invoke-direct {p0, p1}, Lio/branch/referral/Branch;->shareLink(Lio/branch/referral/Branch$ShareLinkBuilder;)V

    return-void
.end method

.method static synthetic access$300(Lio/branch/referral/Branch;)Lio/branch/referral/SystemObserver;
    .locals 1
    .param p0, "x0"    # Lio/branch/referral/Branch;

    .prologue
    .line 77
    iget-object v0, p0, Lio/branch/referral/Branch;->systemObserver_:Lio/branch/referral/SystemObserver;

    return-object v0
.end method

.method static synthetic access$400(Lio/branch/referral/Branch;)Landroid/app/Activity;
    .locals 1
    .param p0, "x0"    # Lio/branch/referral/Branch;

    .prologue
    .line 77
    iget-object v0, p0, Lio/branch/referral/Branch;->currentActivity_:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic access$402(Lio/branch/referral/Branch;Landroid/app/Activity;)Landroid/app/Activity;
    .locals 0
    .param p0, "x0"    # Lio/branch/referral/Branch;
    .param p1, "x1"    # Landroid/app/Activity;

    .prologue
    .line 77
    iput-object p1, p0, Lio/branch/referral/Branch;->currentActivity_:Landroid/app/Activity;

    return-object p1
.end method

.method static synthetic access$500(Lio/branch/referral/Branch;)V
    .locals 0
    .param p0, "x0"    # Lio/branch/referral/Branch;

    .prologue
    .line 77
    invoke-direct {p0}, Lio/branch/referral/Branch;->executeClose()V

    return-void
.end method

.method static synthetic access$700(Lio/branch/referral/Branch;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lio/branch/referral/Branch;

    .prologue
    .line 77
    iget-object v0, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$800(Lio/branch/referral/Branch;Lio/branch/referral/ServerRequest;)V
    .locals 0
    .param p0, "x0"    # Lio/branch/referral/Branch;
    .param p1, "x1"    # Lio/branch/referral/ServerRequest;

    .prologue
    .line 77
    invoke-direct {p0, p1}, Lio/branch/referral/Branch;->handleNewRequest(Lio/branch/referral/ServerRequest;)V

    return-void
.end method

.method static synthetic access$902(Lio/branch/referral/Branch;Z)Z
    .locals 0
    .param p0, "x0"    # Lio/branch/referral/Branch;
    .param p1, "x1"    # Z

    .prologue
    .line 77
    iput-boolean p1, p0, Lio/branch/referral/Branch;->keepAlive_:Z

    return p1
.end method

.method private checkForAutoDeepLinkConfiguration()V
    .locals 18

    .prologue
    .line 3414
    invoke-virtual/range {p0 .. p0}, Lio/branch/referral/Branch;->getLatestReferringParams()Lorg/json/JSONObject;

    move-result-object v13

    .line 3415
    .local v13, "latestParams":Lorg/json/JSONObject;
    const/4 v5, 0x0

    .line 3419
    .local v5, "deepLinkActivity":Ljava/lang/String;
    :try_start_0
    sget-object v15, Lio/branch/referral/Defines$Jsonkey;->Clicked_Branch_Link:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v15}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v13, v15}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v15

    if-eqz v15, :cond_0

    sget-object v15, Lio/branch/referral/Defines$Jsonkey;->Clicked_Branch_Link:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v15}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v13, v15}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v15

    if-nez v15, :cond_1

    .line 3466
    :cond_0
    :goto_0
    return-void

    .line 3423
    :cond_1
    invoke-virtual {v13}, Lorg/json/JSONObject;->length()I

    move-result v15

    if-lez v15, :cond_0

    .line 3425
    move-object/from16 v0, p0

    iget-object v15, v0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    invoke-virtual {v15}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v16

    const/16 v17, 0x80

    invoke-virtual/range {v15 .. v17}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v3

    .line 3426
    .local v3, "appInfo":Landroid/content/pm/ApplicationInfo;
    iget-object v15, v3, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    if-eqz v15, :cond_2

    iget-object v15, v3, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    const-string v16, "io.branch.sdk.auto_link_disable"

    const/16 v17, 0x0

    invoke-virtual/range {v15 .. v17}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v15

    if-nez v15, :cond_0

    .line 3429
    :cond_2
    move-object/from16 v0, p0

    iget-object v15, v0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    invoke-virtual {v15}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v16

    const/16 v17, 0x81

    invoke-virtual/range {v15 .. v17}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v9

    .line 3430
    .local v9, "info":Landroid/content/pm/PackageInfo;
    iget-object v2, v9, Landroid/content/pm/PackageInfo;->activities:[Landroid/content/pm/ActivityInfo;

    .line 3431
    .local v2, "activityInfos":[Landroid/content/pm/ActivityInfo;
    const/16 v6, 0x5dd

    .line 3433
    .local v6, "deepLinkActivityReqCode":I
    if-eqz v2, :cond_5

    .line 3434
    move-object v4, v2

    .local v4, "arr$":[Landroid/content/pm/ActivityInfo;
    array-length v14, v4

    .local v14, "len$":I
    const/4 v8, 0x0

    .local v8, "i$":I
    :goto_1
    if-ge v8, v14, :cond_5

    aget-object v1, v4, v8

    .line 3435
    .local v1, "activityInfo":Landroid/content/pm/ActivityInfo;
    if-eqz v1, :cond_6

    iget-object v15, v1, Landroid/content/pm/ActivityInfo;->metaData:Landroid/os/Bundle;

    if-eqz v15, :cond_6

    iget-object v15, v1, Landroid/content/pm/ActivityInfo;->metaData:Landroid/os/Bundle;

    const-string v16, "io.branch.sdk.auto_link_keys"

    invoke-virtual/range {v15 .. v16}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    if-nez v15, :cond_3

    iget-object v15, v1, Landroid/content/pm/ActivityInfo;->metaData:Landroid/os/Bundle;

    const-string v16, "io.branch.sdk.auto_link_path"

    invoke-virtual/range {v15 .. v16}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    if-eqz v15, :cond_6

    .line 3436
    :cond_3
    move-object/from16 v0, p0

    invoke-direct {v0, v13, v1}, Lio/branch/referral/Branch;->checkForAutoDeepLinkKeys(Lorg/json/JSONObject;Landroid/content/pm/ActivityInfo;)Z

    move-result v15

    if-nez v15, :cond_4

    move-object/from16 v0, p0

    invoke-direct {v0, v13, v1}, Lio/branch/referral/Branch;->checkForAutoDeepLinkPath(Lorg/json/JSONObject;Landroid/content/pm/ActivityInfo;)Z

    move-result v15

    if-eqz v15, :cond_6

    .line 3437
    :cond_4
    iget-object v5, v1, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    .line 3438
    iget-object v15, v1, Landroid/content/pm/ActivityInfo;->metaData:Landroid/os/Bundle;

    const-string v16, "io.branch.sdk.auto_link_request_code"

    const/16 v17, 0x5dd

    invoke-virtual/range {v15 .. v17}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v6

    .line 3444
    .end local v1    # "activityInfo":Landroid/content/pm/ActivityInfo;
    .end local v4    # "arr$":[Landroid/content/pm/ActivityInfo;
    .end local v8    # "i$":I
    .end local v14    # "len$":I
    :cond_5
    if-eqz v5, :cond_0

    move-object/from16 v0, p0

    iget-object v15, v0, Lio/branch/referral/Branch;->currentActivity_:Landroid/app/Activity;

    if-eqz v15, :cond_0

    .line 3445
    new-instance v10, Landroid/content/Intent;

    move-object/from16 v0, p0

    iget-object v15, v0, Lio/branch/referral/Branch;->currentActivity_:Landroid/app/Activity;

    invoke-static {v5}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-direct {v10, v15, v0}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 3446
    .local v10, "intent":Landroid/content/Intent;
    const-string v15, "io.branch.sdk.auto_linked"

    const-string v16, "true"

    move-object/from16 v0, v16

    invoke-virtual {v10, v15, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 3449
    sget-object v15, Lio/branch/referral/Defines$Jsonkey;->ReferringData:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v15}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v16

    instance-of v15, v13, Lorg/json/JSONObject;

    if-nez v15, :cond_7

    invoke-virtual {v13}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v15

    :goto_2
    move-object/from16 v0, v16

    invoke-virtual {v10, v0, v15}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 3452
    invoke-virtual {v13}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v12

    .line 3453
    .local v12, "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    :goto_3
    invoke-interface {v12}, Ljava/util/Iterator;->hasNext()Z

    move-result v15

    if-eqz v15, :cond_8

    .line 3454
    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/String;

    .line 3455
    .local v11, "key":Ljava/lang/String;
    invoke-virtual {v13, v11}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v10, v11, v15}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_2

    goto :goto_3

    .line 3460
    .end local v2    # "activityInfos":[Landroid/content/pm/ActivityInfo;
    .end local v3    # "appInfo":Landroid/content/pm/ApplicationInfo;
    .end local v6    # "deepLinkActivityReqCode":I
    .end local v9    # "info":Landroid/content/pm/PackageInfo;
    .end local v10    # "intent":Landroid/content/Intent;
    .end local v11    # "key":Ljava/lang/String;
    .end local v12    # "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    :catch_0
    move-exception v7

    .line 3461
    .local v7, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    const-string v15, "BranchSDK"

    const-string v16, "Branch Warning: Please make sure Activity names set for auto deep link are correct!"

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 3434
    .end local v7    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    .restart local v1    # "activityInfo":Landroid/content/pm/ActivityInfo;
    .restart local v2    # "activityInfos":[Landroid/content/pm/ActivityInfo;
    .restart local v3    # "appInfo":Landroid/content/pm/ApplicationInfo;
    .restart local v4    # "arr$":[Landroid/content/pm/ActivityInfo;
    .restart local v6    # "deepLinkActivityReqCode":I
    .restart local v8    # "i$":I
    .restart local v9    # "info":Landroid/content/pm/PackageInfo;
    .restart local v14    # "len$":I
    :cond_6
    add-int/lit8 v8, v8, 0x1

    goto/16 :goto_1

    .line 3449
    .end local v1    # "activityInfo":Landroid/content/pm/ActivityInfo;
    .end local v4    # "arr$":[Landroid/content/pm/ActivityInfo;
    .end local v8    # "i$":I
    .end local v14    # "len$":I
    .restart local v10    # "intent":Landroid/content/Intent;
    :cond_7
    :try_start_1
    move-object v0, v13

    check-cast v0, Lorg/json/JSONObject;

    move-object v15, v0

    invoke-static {v15}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v15

    goto :goto_2

    .line 3457
    .restart local v12    # "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    :cond_8
    move-object/from16 v0, p0

    iget-object v15, v0, Lio/branch/referral/Branch;->currentActivity_:Landroid/app/Activity;

    invoke-virtual {v15, v10, v6}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_2

    goto/16 :goto_0

    .line 3462
    .end local v2    # "activityInfos":[Landroid/content/pm/ActivityInfo;
    .end local v3    # "appInfo":Landroid/content/pm/ApplicationInfo;
    .end local v6    # "deepLinkActivityReqCode":I
    .end local v9    # "info":Landroid/content/pm/PackageInfo;
    .end local v10    # "intent":Landroid/content/Intent;
    .end local v12    # "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    :catch_1
    move-exception v7

    .line 3463
    .local v7, "e":Ljava/lang/ClassNotFoundException;
    const-string v15, "BranchSDK"

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    const-string v17, "Branch Warning: Please make sure Activity names set for auto deep link are correct! Error while looking for activity "

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 3464
    .end local v7    # "e":Ljava/lang/ClassNotFoundException;
    :catch_2
    move-exception v15

    goto/16 :goto_0
.end method

.method private checkForAutoDeepLinkKeys(Lorg/json/JSONObject;Landroid/content/pm/ActivityInfo;)Z
    .locals 7
    .param p1, "params"    # Lorg/json/JSONObject;
    .param p2, "activityInfo"    # Landroid/content/pm/ActivityInfo;

    .prologue
    .line 3469
    iget-object v5, p2, Landroid/content/pm/ActivityInfo;->metaData:Landroid/os/Bundle;

    const-string v6, "io.branch.sdk.auto_link_keys"

    invoke-virtual {v5, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_1

    .line 3470
    iget-object v5, p2, Landroid/content/pm/ActivityInfo;->metaData:Landroid/os/Bundle;

    const-string v6, "io.branch.sdk.auto_link_keys"

    invoke-virtual {v5, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v6, ","

    invoke-virtual {v5, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 3471
    .local v1, "activityLinkKeys":[Ljava/lang/String;
    move-object v2, v1

    .local v2, "arr$":[Ljava/lang/String;
    array-length v4, v2

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_1

    aget-object v0, v2, v3

    .line 3472
    .local v0, "activityLinkKey":Ljava/lang/String;
    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 3473
    const/4 v5, 0x1

    .line 3477
    .end local v0    # "activityLinkKey":Ljava/lang/String;
    .end local v1    # "activityLinkKeys":[Ljava/lang/String;
    .end local v2    # "arr$":[Ljava/lang/String;
    .end local v3    # "i$":I
    .end local v4    # "len$":I
    :goto_1
    return v5

    .line 3471
    .restart local v0    # "activityLinkKey":Ljava/lang/String;
    .restart local v1    # "activityLinkKeys":[Ljava/lang/String;
    .restart local v2    # "arr$":[Ljava/lang/String;
    .restart local v3    # "i$":I
    .restart local v4    # "len$":I
    :cond_0
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 3477
    .end local v0    # "activityLinkKey":Ljava/lang/String;
    .end local v1    # "activityLinkKeys":[Ljava/lang/String;
    .end local v2    # "arr$":[Ljava/lang/String;
    .end local v3    # "i$":I
    .end local v4    # "len$":I
    :cond_1
    const/4 v5, 0x0

    goto :goto_1
.end method

.method private checkForAutoDeepLinkPath(Lorg/json/JSONObject;Landroid/content/pm/ActivityInfo;)Z
    .locals 8
    .param p1, "params"    # Lorg/json/JSONObject;
    .param p2, "activityInfo"    # Landroid/content/pm/ActivityInfo;

    .prologue
    .line 3481
    const/4 v3, 0x0

    .line 3483
    .local v3, "deepLinkPath":Ljava/lang/String;
    :try_start_0
    sget-object v6, Lio/branch/referral/Defines$Jsonkey;->AndroidDeepLinkPath:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v6}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 3484
    sget-object v6, Lio/branch/referral/Defines$Jsonkey;->AndroidDeepLinkPath:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v6}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 3490
    :cond_0
    :goto_0
    iget-object v6, p2, Landroid/content/pm/ActivityInfo;->metaData:Landroid/os/Bundle;

    const-string v7, "io.branch.sdk.auto_link_path"

    invoke-virtual {v6, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_3

    if-eqz v3, :cond_3

    .line 3491
    iget-object v6, p2, Landroid/content/pm/ActivityInfo;->metaData:Landroid/os/Bundle;

    const-string v7, "io.branch.sdk.auto_link_path"

    invoke-virtual {v6, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string v7, ","

    invoke-virtual {v6, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 3492
    .local v1, "activityLinkPaths":[Ljava/lang/String;
    move-object v2, v1

    .local v2, "arr$":[Ljava/lang/String;
    array-length v5, v2

    .local v5, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_1
    if-ge v4, v5, :cond_3

    aget-object v0, v2, v4

    .line 3493
    .local v0, "activityLinkPath":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v6

    invoke-direct {p0, v6, v3}, Lio/branch/referral/Branch;->pathMatch(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 3494
    const/4 v6, 0x1

    .line 3498
    .end local v0    # "activityLinkPath":Ljava/lang/String;
    .end local v1    # "activityLinkPaths":[Ljava/lang/String;
    .end local v2    # "arr$":[Ljava/lang/String;
    .end local v4    # "i$":I
    .end local v5    # "len$":I
    :goto_2
    return v6

    .line 3485
    :cond_1
    :try_start_1
    sget-object v6, Lio/branch/referral/Defines$Jsonkey;->DeepLinkPath:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v6}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 3486
    sget-object v6, Lio/branch/referral/Defines$Jsonkey;->DeepLinkPath:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v6}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v3

    goto :goto_0

    .line 3492
    .restart local v0    # "activityLinkPath":Ljava/lang/String;
    .restart local v1    # "activityLinkPaths":[Ljava/lang/String;
    .restart local v2    # "arr$":[Ljava/lang/String;
    .restart local v4    # "i$":I
    .restart local v5    # "len$":I
    :cond_2
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 3498
    .end local v0    # "activityLinkPath":Ljava/lang/String;
    .end local v1    # "activityLinkPaths":[Ljava/lang/String;
    .end local v2    # "arr$":[Ljava/lang/String;
    .end local v4    # "i$":I
    .end local v5    # "len$":I
    :cond_3
    const/4 v6, 0x0

    goto :goto_2

    .line 3488
    :catch_0
    move-exception v6

    goto :goto_0
.end method

.method private clearCloseTimer()V
    .locals 1

    .prologue
    .line 2889
    iget-object v0, p0, Lio/branch/referral/Branch;->rotateCloseTimer:Ljava/util/Timer;

    if-nez v0, :cond_0

    .line 2894
    :goto_0
    return-void

    .line 2891
    :cond_0
    iget-object v0, p0, Lio/branch/referral/Branch;->rotateCloseTimer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 2892
    iget-object v0, p0, Lio/branch/referral/Branch;->rotateCloseTimer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->purge()I

    .line 2893
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Lio/branch/referral/Branch;->rotateCloseTimer:Ljava/util/Timer;

    goto :goto_0
.end method

.method private clearTimer()V
    .locals 1

    .prologue
    .line 2897
    iget-object v0, p0, Lio/branch/referral/Branch;->closeTimer:Ljava/util/Timer;

    if-nez v0, :cond_0

    .line 2902
    :goto_0
    return-void

    .line 2899
    :cond_0
    iget-object v0, p0, Lio/branch/referral/Branch;->closeTimer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 2900
    iget-object v0, p0, Lio/branch/referral/Branch;->closeTimer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->purge()I

    .line 2901
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Lio/branch/referral/Branch;->closeTimer:Ljava/util/Timer;

    goto :goto_0
.end method

.method private clearTouchDebugInternal(Landroid/app/Activity;)V
    .locals 3
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 1125
    invoke-virtual {p1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/Window;->getCallback()Landroid/view/Window$Callback;

    move-result-object v1

    instance-of v1, v1, Lio/branch/referral/Branch$BranchWindowCallback;

    if-eqz v1, :cond_0

    .line 1126
    invoke-virtual {p1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/Window;->getCallback()Landroid/view/Window$Callback;

    move-result-object v1

    check-cast v1, Lio/branch/referral/Branch$BranchWindowCallback;

    # getter for: Lio/branch/referral/Branch$BranchWindowCallback;->callback_:Landroid/view/Window$Callback;
    invoke-static {v1}, Lio/branch/referral/Branch$BranchWindowCallback;->access$000(Lio/branch/referral/Branch$BranchWindowCallback;)Landroid/view/Window$Callback;

    move-result-object v0

    .line 1128
    .local v0, "originalCallback":Landroid/view/Window$Callback;
    invoke-virtual {p1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/view/Window;->setCallback(Landroid/view/Window$Callback;)V

    .line 1129
    iget-object v1, p0, Lio/branch/referral/Branch;->debugListenerInitHistory_:Landroid/util/SparseArray;

    invoke-static {p1}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/util/SparseArray;->remove(I)V

    .line 1132
    iget-object v1, p0, Lio/branch/referral/Branch;->debugHandler_:Landroid/os/Handler;

    if-eqz v1, :cond_0

    .line 1133
    iget-object v1, p0, Lio/branch/referral/Branch;->debugHandler_:Landroid/os/Handler;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 1136
    .end local v0    # "originalCallback":Landroid/view/Window$Callback;
    :cond_0
    return-void
.end method

.method private closeSessionInternal()V
    .locals 1

    .prologue
    .line 1261
    invoke-direct {p0}, Lio/branch/referral/Branch;->executeClose()V

    .line 1262
    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getExternAppListing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1263
    iget-object v0, p0, Lio/branch/referral/Branch;->appListingSchedule_:Ljava/util/concurrent/ScheduledFuture;

    if-nez v0, :cond_0

    .line 1264
    invoke-direct {p0}, Lio/branch/referral/Branch;->scheduleListOfApps()V

    .line 1267
    :cond_0
    return-void
.end method

.method private convertDate(Ljava/util/Date;)Ljava/lang/String;
    .locals 1
    .param p1, "date"    # Ljava/util/Date;

    .prologue
    .line 2721
    const-string v0, "yyyy-MM-dd"

    invoke-static {v0, p1}, Landroid/text/format/DateFormat;->format(Ljava/lang/CharSequence;Ljava/util/Date;)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private convertParamsStringToDictionary(Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 5
    .param p1, "paramString"    # Ljava/lang/String;

    .prologue
    .line 2755
    const-string v3, "bnc_no_value"

    invoke-virtual {p1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 2756
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 2766
    :goto_0
    return-object v3

    .line 2759
    :cond_0
    :try_start_0
    new-instance v3, Lorg/json/JSONObject;

    invoke-static {p1}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->init(Ljava/lang/String;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    goto :goto_0

    .line 2760
    :catch_0
    move-exception v0

    .line 2761
    .local v0, "e":Lorg/json/JSONException;
    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object v3

    const/4 v4, 0x2

    invoke-static {v3, v4}, Lio/branch/referral/Base64;->decode([BI)[B

    move-result-object v1

    .line 2763
    .local v1, "encodedArray":[B
    :try_start_1
    new-instance v3, Lorg/json/JSONObject;

    new-instance v3, Ljava/lang/String;

    invoke-direct {v3, v1}, Ljava/lang/String;-><init>([B)V

    invoke-static {v3}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->init(Ljava/lang/String;)Lorg/json/JSONObject;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v3

    goto :goto_0

    .line 2764
    :catch_1
    move-exception v2

    .line 2765
    .local v2, "ex":Lorg/json/JSONException;
    invoke-virtual {v2}, Lorg/json/JSONException;->printStackTrace()V

    .line 2766
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    goto :goto_0
.end method

.method private executeClose()V
    .locals 3

    .prologue
    .line 1274
    iget-object v1, p0, Lio/branch/referral/Branch;->initState_:Lio/branch/referral/Branch$SESSION_STATE;

    sget-object v2, Lio/branch/referral/Branch$SESSION_STATE;->UNINITIALISED:Lio/branch/referral/Branch$SESSION_STATE;

    if-eq v1, v2, :cond_3

    .line 1275
    iget-boolean v1, p0, Lio/branch/referral/Branch;->hasNetwork_:Z

    if-nez v1, :cond_4

    .line 1277
    iget-object v1, p0, Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;

    invoke-virtual {v1}, Lio/branch/referral/ServerRequestQueue;->peek()Lio/branch/referral/ServerRequest;

    move-result-object v0

    .line 1278
    .local v0, "req":Lio/branch/referral/ServerRequest;
    if-eqz v0, :cond_0

    instance-of v1, v0, Lio/branch/referral/ServerRequestRegisterInstall;

    if-nez v1, :cond_1

    :cond_0
    instance-of v1, v0, Lio/branch/referral/ServerRequestRegisterOpen;

    if-eqz v1, :cond_2

    .line 1279
    :cond_1
    iget-object v1, p0, Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;

    invoke-virtual {v1}, Lio/branch/referral/ServerRequestQueue;->dequeue()Lio/branch/referral/ServerRequest;

    .line 1287
    .end local v0    # "req":Lio/branch/referral/ServerRequest;
    :cond_2
    :goto_0
    sget-object v1, Lio/branch/referral/Branch$SESSION_STATE;->UNINITIALISED:Lio/branch/referral/Branch$SESSION_STATE;

    iput-object v1, p0, Lio/branch/referral/Branch;->initState_:Lio/branch/referral/Branch$SESSION_STATE;

    .line 1289
    :cond_3
    return-void

    .line 1282
    :cond_4
    iget-object v1, p0, Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;

    invoke-virtual {v1}, Lio/branch/referral/ServerRequestQueue;->containsClose()Z

    move-result v1

    if-nez v1, :cond_2

    .line 1283
    new-instance v0, Lio/branch/referral/ServerRequestRegisterClose;

    iget-object v1, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    invoke-direct {v0, v1}, Lio/branch/referral/ServerRequestRegisterClose;-><init>(Landroid/content/Context;)V

    .line 1284
    .restart local v0    # "req":Lio/branch/referral/ServerRequest;
    invoke-direct {p0, v0}, Lio/branch/referral/Branch;->handleNewRequest(Lio/branch/referral/ServerRequest;)V

    goto :goto_0
.end method

.method private generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;
    .locals 14
    .param p1, "alias"    # Ljava/lang/String;
    .param p2, "type"    # I
    .param p3, "duration"    # I
    .param p5, "channel"    # Ljava/lang/String;
    .param p6, "feature"    # Ljava/lang/String;
    .param p7, "stage"    # Ljava/lang/String;
    .param p8, "params"    # Ljava/lang/String;
    .param p9, "callback"    # Lio/branch/referral/Branch$BranchLinkCreateListener;
    .param p10, "async"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "II",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lio/branch/referral/Branch$BranchLinkCreateListener;",
            "Z)",
            "Ljava/lang/String;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 2288
    .local p4, "tags":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    new-instance v1, Lio/branch/referral/ServerRequestCreateUrl;

    iget-object v2, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    move-object v3, p1

    move/from16 v4, p2

    move/from16 v5, p3

    move-object/from16 v6, p4

    move-object/from16 v7, p5

    move-object/from16 v8, p6

    move-object/from16 v9, p7

    move-object/from16 v10, p8

    move-object/from16 v11, p9

    move/from16 v12, p10

    invoke-direct/range {v1 .. v12}, Lio/branch/referral/ServerRequestCreateUrl;-><init>(Landroid/content/Context;Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)V

    .line 2292
    .local v1, "req":Lio/branch/referral/ServerRequestCreateUrl;
    iget-boolean v2, v1, Lio/branch/referral/ServerRequestCreateUrl;->constructError_:Z

    if-nez v2, :cond_2

    iget-object v2, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    invoke-virtual {v1, v2}, Lio/branch/referral/ServerRequestCreateUrl;->handleErrors(Landroid/content/Context;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 2293
    iget-object v2, p0, Lio/branch/referral/Branch;->linkCache_:Ljava/util/Map;

    invoke-virtual {v1}, Lio/branch/referral/ServerRequestCreateUrl;->getLinkPost()Lio/branch/referral/BranchLinkData;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 2294
    iget-object v2, p0, Lio/branch/referral/Branch;->linkCache_:Ljava/util/Map;

    invoke-virtual {v1}, Lio/branch/referral/ServerRequestCreateUrl;->getLinkPost()Lio/branch/referral/BranchLinkData;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/lang/String;

    .line 2295
    .local v13, "url":Ljava/lang/String;
    if-eqz p9, :cond_0

    .line 2296
    const/4 v2, 0x0

    move-object/from16 v0, p9

    invoke-interface {v0, v13, v2}, Lio/branch/referral/Branch$BranchLinkCreateListener;->onLinkCreate(Ljava/lang/String;Lio/branch/referral/BranchError;)V

    .line 2307
    .end local v13    # "url":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object v13

    .line 2300
    :cond_1
    if-eqz p10, :cond_3

    .line 2301
    invoke-direct {p0, v1}, Lio/branch/referral/Branch;->generateShortLinkAsync(Lio/branch/referral/ServerRequest;)V

    .line 2307
    :cond_2
    const/4 v13, 0x0

    goto :goto_0

    .line 2303
    :cond_3
    invoke-direct {p0, v1}, Lio/branch/referral/Branch;->generateShortLinkSync(Lio/branch/referral/ServerRequestCreateUrl;)Ljava/lang/String;

    move-result-object v13

    goto :goto_0
.end method

.method private generateShortLinkAsync(Lio/branch/referral/ServerRequest;)V
    .locals 0
    .param p1, "req"    # Lio/branch/referral/ServerRequest;

    .prologue
    .line 2751
    invoke-direct {p0, p1}, Lio/branch/referral/Branch;->handleNewRequest(Lio/branch/referral/ServerRequest;)V

    .line 2752
    return-void
.end method

.method private generateShortLinkSync(Lio/branch/referral/ServerRequestCreateUrl;)Ljava/lang/String;
    .locals 10
    .param p1, "req"    # Lio/branch/referral/ServerRequestCreateUrl;

    .prologue
    const/4 v5, 0x0

    .line 2725
    iget-object v6, p0, Lio/branch/referral/Branch;->initState_:Lio/branch/referral/Branch$SESSION_STATE;

    sget-object v7, Lio/branch/referral/Branch$SESSION_STATE;->INITIALISED:Lio/branch/referral/Branch$SESSION_STATE;

    if-ne v6, v7, :cond_2

    .line 2726
    const/4 v3, 0x0

    .line 2728
    .local v3, "response":Lio/branch/referral/ServerResponse;
    :try_start_0
    iget-object v6, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v6}, Lio/branch/referral/PrefHelper;->getTimeout()I

    move-result v6

    add-int/lit16 v4, v6, 0x7d0

    .line 2729
    .local v4, "timeOut":I
    new-instance v6, Lio/branch/referral/Branch$getShortLinkTask;

    const/4 v7, 0x0

    invoke-direct {v6, p0, v7}, Lio/branch/referral/Branch$getShortLinkTask;-><init>(Lio/branch/referral/Branch;Lio/branch/referral/Branch$1;)V

    const/4 v7, 0x1

    new-array v7, v7, [Lio/branch/referral/ServerRequest;

    const/4 v8, 0x0

    aput-object p1, v7, v8

    instance-of v8, v6, Landroid/os/AsyncTask;

    if-nez v8, :cond_1

    invoke-virtual {v6, v7}, Lio/branch/referral/Branch$getShortLinkTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    move-result-object v6

    :goto_0
    int-to-long v8, v4

    sget-object v7, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v6, v8, v9, v7}, Landroid/os/AsyncTask;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object v6

    move-object v0, v6

    check-cast v0, Lio/branch/referral/ServerResponse;

    move-object v3, v0
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_0 .. :try_end_0} :catch_2

    .line 2732
    .end local v4    # "timeOut":I
    :goto_1
    invoke-virtual {p1}, Lio/branch/referral/ServerRequestCreateUrl;->getLongUrl()Ljava/lang/String;

    move-result-object v5

    .line 2733
    .local v5, "url":Ljava/lang/String;
    if-eqz v3, :cond_0

    invoke-virtual {v3}, Lio/branch/referral/ServerResponse;->getStatusCode()I

    move-result v6

    const/16 v7, 0xc8

    if-ne v6, v7, :cond_0

    .line 2735
    :try_start_1
    invoke-virtual {v3}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "url"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 2736
    invoke-virtual {v3}, Lio/branch/referral/ServerResponse;->getLinkData()Lio/branch/referral/BranchLinkData;

    move-result-object v6

    if-eqz v6, :cond_0

    .line 2737
    iget-object v6, p0, Lio/branch/referral/Branch;->linkCache_:Ljava/util/Map;

    invoke-virtual {v3}, Lio/branch/referral/ServerResponse;->getLinkData()Lio/branch/referral/BranchLinkData;

    move-result-object v7

    invoke-interface {v6, v7, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    .line 2747
    .end local v3    # "response":Lio/branch/referral/ServerResponse;
    .end local v5    # "url":Ljava/lang/String;
    :cond_0
    :goto_2
    return-object v5

    .line 2729
    .restart local v3    # "response":Lio/branch/referral/ServerResponse;
    .restart local v4    # "timeOut":I
    :cond_1
    :try_start_2
    check-cast v6, Landroid/os/AsyncTask;

    invoke-static {v6, v7}, Lcom/newrelic/agent/android/instrumentation/AsyncTaskInstrumentation;->execute(Landroid/os/AsyncTask;[Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_2
    .catch Ljava/lang/InterruptedException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_2 .. :try_end_2} :catch_3
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_2 .. :try_end_2} :catch_2

    move-result-object v6

    goto :goto_0

    .line 2739
    .end local v4    # "timeOut":I
    .restart local v5    # "url":Ljava/lang/String;
    :catch_0
    move-exception v2

    .line 2740
    .local v2, "e":Lorg/json/JSONException;
    invoke-virtual {v2}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_2

    .line 2745
    .end local v2    # "e":Lorg/json/JSONException;
    .end local v3    # "response":Lio/branch/referral/ServerResponse;
    .end local v5    # "url":Ljava/lang/String;
    :cond_2
    const-string v6, "BranchSDK"

    const-string v7, "Branch Warning: User session has not been initialized"

    invoke-static {v6, v7}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_2

    .line 2730
    .restart local v3    # "response":Lio/branch/referral/ServerResponse;
    :catch_1
    move-exception v6

    goto :goto_1

    :catch_2
    move-exception v6

    goto :goto_1

    :catch_3
    move-exception v6

    goto :goto_1
.end method

.method public static getAutoInstance(Landroid/content/Context;)Lio/branch/referral/Branch;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .annotation build Landroid/annotation/TargetApi;
        value = 0xe
    .end annotation

    .prologue
    const/4 v0, 0x1

    .line 520
    sput-boolean v0, Lio/branch/referral/Branch;->isAutoSessionMode_:Z

    .line 521
    sget-object v1, Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;->USE_DEFAULT:Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;

    sput-object v1, Lio/branch/referral/Branch;->customReferrableSettings_:Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;

    .line 522
    invoke-static {p0}, Lio/branch/referral/BranchUtil;->isTestModeEnabled(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 523
    .local v0, "isLive":Z
    :goto_0
    invoke-static {p0, v0}, Lio/branch/referral/Branch;->getBranchInstance(Landroid/content/Context;Z)Lio/branch/referral/Branch;

    .line 524
    sget-object v1, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    check-cast p0, Landroid/app/Application;

    .end local p0    # "context":Landroid/content/Context;
    invoke-direct {v1, p0}, Lio/branch/referral/Branch;->setActivityLifeCycleObserver(Landroid/app/Application;)V

    .line 525
    sget-object v1, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    return-object v1

    .line 522
    .end local v0    # "isLive":Z
    .restart local p0    # "context":Landroid/content/Context;
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static getAutoInstance(Landroid/content/Context;Z)Lio/branch/referral/Branch;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p1, "isReferrable"    # Z
    .annotation build Landroid/annotation/TargetApi;
        value = 0xe
    .end annotation

    .prologue
    const/4 v2, 0x1

    .line 544
    sput-boolean v2, Lio/branch/referral/Branch;->isAutoSessionMode_:Z

    .line 545
    if-eqz p1, :cond_0

    sget-object v1, Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;->REFERRABLE:Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;

    :goto_0
    sput-object v1, Lio/branch/referral/Branch;->customReferrableSettings_:Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;

    .line 546
    invoke-static {p0}, Lio/branch/referral/BranchUtil;->isTestModeEnabled(Landroid/content/Context;)Z

    move-result v0

    .line 547
    .local v0, "isDebug":Z
    if-nez v0, :cond_1

    move v1, v2

    :goto_1
    invoke-static {p0, v1}, Lio/branch/referral/Branch;->getBranchInstance(Landroid/content/Context;Z)Lio/branch/referral/Branch;

    .line 548
    sget-object v1, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    check-cast p0, Landroid/app/Application;

    .end local p0    # "context":Landroid/content/Context;
    invoke-direct {v1, p0}, Lio/branch/referral/Branch;->setActivityLifeCycleObserver(Landroid/app/Application;)V

    .line 549
    sget-object v1, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    return-object v1

    .line 545
    .end local v0    # "isDebug":Z
    .restart local p0    # "context":Landroid/content/Context;
    :cond_0
    sget-object v1, Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;->NON_REFERRABLE:Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;

    goto :goto_0

    .line 547
    .restart local v0    # "isDebug":Z
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method

.method public static getAutoTestInstance(Landroid/content/Context;)Lio/branch/referral/Branch;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .annotation build Landroid/annotation/TargetApi;
        value = 0xe
    .end annotation

    .prologue
    .line 562
    const/4 v0, 0x1

    sput-boolean v0, Lio/branch/referral/Branch;->isAutoSessionMode_:Z

    .line 563
    sget-object v0, Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;->USE_DEFAULT:Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;

    sput-object v0, Lio/branch/referral/Branch;->customReferrableSettings_:Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;

    .line 564
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lio/branch/referral/Branch;->getBranchInstance(Landroid/content/Context;Z)Lio/branch/referral/Branch;

    .line 565
    sget-object v0, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    check-cast p0, Landroid/app/Application;

    .end local p0    # "context":Landroid/content/Context;
    invoke-direct {v0, p0}, Lio/branch/referral/Branch;->setActivityLifeCycleObserver(Landroid/app/Application;)V

    .line 566
    sget-object v0, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    return-object v0
.end method

.method public static getAutoTestInstance(Landroid/content/Context;Z)Lio/branch/referral/Branch;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p1, "isReferrable"    # Z
    .annotation build Landroid/annotation/TargetApi;
        value = 0xe
    .end annotation

    .prologue
    .line 582
    const/4 v0, 0x1

    sput-boolean v0, Lio/branch/referral/Branch;->isAutoSessionMode_:Z

    .line 583
    if-eqz p1, :cond_0

    sget-object v0, Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;->REFERRABLE:Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;

    :goto_0
    sput-object v0, Lio/branch/referral/Branch;->customReferrableSettings_:Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;

    .line 584
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lio/branch/referral/Branch;->getBranchInstance(Landroid/content/Context;Z)Lio/branch/referral/Branch;

    .line 585
    sget-object v0, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    check-cast p0, Landroid/app/Application;

    .end local p0    # "context":Landroid/content/Context;
    invoke-direct {v0, p0}, Lio/branch/referral/Branch;->setActivityLifeCycleObserver(Landroid/app/Application;)V

    .line 586
    sget-object v0, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    return-object v0

    .line 583
    .restart local p0    # "context":Landroid/content/Context;
    :cond_0
    sget-object v0, Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;->NON_REFERRABLE:Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;

    goto :goto_0
.end method

.method private static getBranchInstance(Landroid/content/Context;Z)Lio/branch/referral/Branch;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p1, "isLive"    # Z

    .prologue
    .line 452
    sget-object v2, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    if-nez v2, :cond_1

    .line 453
    invoke-static {p0}, Lio/branch/referral/Branch;->initInstance(Landroid/content/Context;)Lio/branch/referral/Branch;

    move-result-object v2

    sput-object v2, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    .line 455
    sget-object v2, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    iget-object v2, v2, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2, p1}, Lio/branch/referral/PrefHelper;->readBranchKey(Z)Ljava/lang/String;

    move-result-object v0

    .line 457
    .local v0, "branchKey":Ljava/lang/String;
    if-eqz v0, :cond_0

    const-string v2, "bnc_no_value"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 458
    :cond_0
    const-string v2, "BranchSDK"

    const-string v3, "Branch Warning: Please enter your branch_key in your project\'s Manifest file!"

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 459
    sget-object v2, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    iget-object v2, v2, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    const-string v3, "bnc_no_value"

    invoke-virtual {v2, v3}, Lio/branch/referral/PrefHelper;->setBranchKey(Ljava/lang/String;)Z

    move-result v1

    .line 464
    .local v1, "isNewBranchKeySet":Z
    :goto_0
    if-eqz v1, :cond_1

    .line 465
    sget-object v2, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    iget-object v2, v2, Lio/branch/referral/Branch;->linkCache_:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->clear()V

    .line 466
    sget-object v2, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    iget-object v2, v2, Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;

    invoke-virtual {v2}, Lio/branch/referral/ServerRequestQueue;->clear()V

    .line 469
    .end local v0    # "branchKey":Ljava/lang/String;
    .end local v1    # "isNewBranchKeySet":Z
    :cond_1
    sget-object v2, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    iput-object v3, v2, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    .line 472
    instance-of v2, p0, Lio/branch/referral/BranchApp;

    if-eqz v2, :cond_2

    .line 473
    const/4 v2, 0x1

    sput-boolean v2, Lio/branch/referral/Branch;->isAutoSessionMode_:Z

    .line 474
    sget-object v2, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    check-cast p0, Landroid/app/Application;

    .end local p0    # "context":Landroid/content/Context;
    invoke-direct {v2, p0}, Lio/branch/referral/Branch;->setActivityLifeCycleObserver(Landroid/app/Application;)V

    .line 477
    :cond_2
    sget-object v2, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    return-object v2

    .line 461
    .restart local v0    # "branchKey":Ljava/lang/String;
    .restart local p0    # "context":Landroid/content/Context;
    :cond_3
    sget-object v2, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    iget-object v2, v2, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2, v0}, Lio/branch/referral/PrefHelper;->setBranchKey(Ljava/lang/String;)Z

    move-result v1

    .restart local v1    # "isNewBranchKeySet":Z
    goto :goto_0
.end method

.method public static getInstance()Lio/branch/referral/Branch;
    .locals 2
    .annotation build Landroid/annotation/TargetApi;
        value = 0xe
    .end annotation

    .prologue
    .line 409
    sget-object v0, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    if-nez v0, :cond_1

    .line 410
    const-string v0, "BranchSDK"

    const-string v1, "Branch instance is not created yet. Make sure you have initialised Branch. [Consider Calling getInstance(Context ctx) if you still have issue.]"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 418
    :cond_0
    :goto_0
    sget-object v0, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    return-object v0

    .line 411
    :cond_1
    sget-boolean v0, Lio/branch/referral/Branch;->isAutoSessionMode_:Z

    if-eqz v0, :cond_0

    .line 413
    sget-boolean v0, Lio/branch/referral/Branch;->isActivityLifeCycleCallbackRegistered_:Z

    if-nez v0, :cond_0

    .line 414
    const-string v0, "BranchSDK"

    const-string v1, "Branch instance is not properly initialised. Make sure your Application class is extending BranchApp class. If you are not extending BranchApp class make sure you are initialising Branch in your Applications onCreate()"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public static getInstance(Landroid/content/Context;)Lio/branch/referral/Branch;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .prologue
    .line 493
    const/4 v0, 0x1

    invoke-static {p0, v0}, Lio/branch/referral/Branch;->getBranchInstance(Landroid/content/Context;Z)Lio/branch/referral/Branch;

    move-result-object v0

    return-object v0
.end method

.method public static getInstance(Landroid/content/Context;Ljava/lang/String;)Lio/branch/referral/Branch;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p1, "branchKey"    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .prologue
    .line 434
    sget-object v1, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    if-nez v1, :cond_0

    .line 435
    invoke-static {p0}, Lio/branch/referral/Branch;->initInstance(Landroid/content/Context;)Lio/branch/referral/Branch;

    move-result-object v1

    sput-object v1, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    .line 437
    :cond_0
    sget-object v1, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    iput-object v2, v1, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    .line 438
    const-string v1, "key_"

    invoke-virtual {p1, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 439
    sget-object v1, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    iget-object v1, v1, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v1, p1}, Lio/branch/referral/PrefHelper;->setBranchKey(Ljava/lang/String;)Z

    move-result v0

    .line 441
    .local v0, "isNewBranchKeySet":Z
    if-eqz v0, :cond_1

    .line 442
    sget-object v1, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    iget-object v1, v1, Lio/branch/referral/Branch;->linkCache_:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->clear()V

    .line 443
    sget-object v1, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    iget-object v1, v1, Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;

    invoke-virtual {v1}, Lio/branch/referral/ServerRequestQueue;->clear()V

    .line 448
    .end local v0    # "isNewBranchKeySet":Z
    :cond_1
    :goto_0
    sget-object v1, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    return-object v1

    .line 446
    :cond_2
    sget-object v1, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    iget-object v1, v1, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v1, p1}, Lio/branch/referral/PrefHelper;->setAppKey(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static getTestInstance(Landroid/content/Context;)Lio/branch/referral/Branch;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .prologue
    .line 504
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lio/branch/referral/Branch;->getBranchInstance(Landroid/content/Context;Z)Lio/branch/referral/Branch;

    move-result-object v0

    return-object v0
.end method

.method private handleFailure(II)V
    .locals 3
    .param p1, "index"    # I
    .param p2, "statusCode"    # I

    .prologue
    .line 2851
    iget-object v1, p0, Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;

    invoke-virtual {v1}, Lio/branch/referral/ServerRequestQueue;->getSize()I

    move-result v1

    if-lt p1, v1, :cond_0

    .line 2852
    iget-object v1, p0, Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;

    iget-object v2, p0, Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;

    invoke-virtual {v2}, Lio/branch/referral/ServerRequestQueue;->getSize()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v1, v2}, Lio/branch/referral/ServerRequestQueue;->peekAt(I)Lio/branch/referral/ServerRequest;

    move-result-object v0

    .line 2856
    .local v0, "req":Lio/branch/referral/ServerRequest;
    :goto_0
    invoke-direct {p0, v0, p2}, Lio/branch/referral/Branch;->handleFailure(Lio/branch/referral/ServerRequest;I)V

    .line 2857
    return-void

    .line 2854
    .end local v0    # "req":Lio/branch/referral/ServerRequest;
    :cond_0
    iget-object v1, p0, Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;

    invoke-virtual {v1, p1}, Lio/branch/referral/ServerRequestQueue;->peekAt(I)Lio/branch/referral/ServerRequest;

    move-result-object v0

    .restart local v0    # "req":Lio/branch/referral/ServerRequest;
    goto :goto_0
.end method

.method private handleFailure(Lio/branch/referral/ServerRequest;I)V
    .locals 1
    .param p1, "req"    # Lio/branch/referral/ServerRequest;
    .param p2, "statusCode"    # I

    .prologue
    .line 2860
    if-nez p1, :cond_0

    .line 2863
    :goto_0
    return-void

    .line 2862
    :cond_0
    const-string v0, ""

    invoke-virtual {p1, p2, v0}, Lio/branch/referral/ServerRequest;->handleFailure(ILjava/lang/String;)V

    goto :goto_0
.end method

.method private handleNewRequest(Lio/branch/referral/ServerRequest;)V
    .locals 4
    .param p1, "req"    # Lio/branch/referral/ServerRequest;

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 2989
    iget-object v2, p0, Lio/branch/referral/Branch;->initState_:Lio/branch/referral/Branch$SESSION_STATE;

    sget-object v3, Lio/branch/referral/Branch$SESSION_STATE;->INITIALISED:Lio/branch/referral/Branch$SESSION_STATE;

    if-eq v2, v3, :cond_2

    instance-of v2, p1, Lio/branch/referral/ServerRequestInitSession;

    if-nez v2, :cond_2

    .line 2991
    instance-of v2, p1, Lio/branch/referral/ServerRequestLogout;

    if-eqz v2, :cond_0

    .line 2992
    const/16 v1, -0x65

    const-string v2, ""

    invoke-virtual {p1, v1, v2}, Lio/branch/referral/ServerRequest;->handleFailure(ILjava/lang/String;)V

    .line 2993
    const-string v1, "BranchSDK"

    const-string v2, "Branch is not initialized, cannot logout"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 3010
    :goto_0
    return-void

    .line 2996
    :cond_0
    instance-of v2, p1, Lio/branch/referral/ServerRequestRegisterClose;

    if-eqz v2, :cond_1

    .line 2997
    const-string v1, "BranchSDK"

    const-string v2, "Branch is not initialized, cannot close session"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 3000
    :cond_1
    sget-object v2, Lio/branch/referral/Branch;->customReferrableSettings_:Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;

    sget-object v3, Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;->USE_DEFAULT:Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;

    if-ne v2, v3, :cond_3

    .line 3001
    check-cast v1, Lio/branch/referral/Branch$BranchReferralInitListener;

    iget-object v2, p0, Lio/branch/referral/Branch;->currentActivity_:Landroid/app/Activity;

    invoke-direct {p0, v1, v2, v0}, Lio/branch/referral/Branch;->initUserSessionInternal(Lio/branch/referral/Branch$BranchReferralInitListener;Landroid/app/Activity;Z)V

    .line 3008
    :cond_2
    :goto_1
    iget-object v1, p0, Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;

    invoke-virtual {v1, p1}, Lio/branch/referral/ServerRequestQueue;->enqueue(Lio/branch/referral/ServerRequest;)V

    .line 3009
    invoke-direct {p0}, Lio/branch/referral/Branch;->processNextQueueItem()V

    goto :goto_0

    .line 3003
    :cond_3
    sget-object v2, Lio/branch/referral/Branch;->customReferrableSettings_:Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;

    sget-object v3, Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;->REFERRABLE:Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;

    if-ne v2, v3, :cond_4

    .line 3004
    .local v0, "isReferrable":Z
    :goto_2
    check-cast v1, Lio/branch/referral/Branch$BranchReferralInitListener;

    iget-object v2, p0, Lio/branch/referral/Branch;->currentActivity_:Landroid/app/Activity;

    invoke-direct {p0, v1, v2, v0}, Lio/branch/referral/Branch;->initUserSessionInternal(Lio/branch/referral/Branch$BranchReferralInitListener;Landroid/app/Activity;Z)V

    goto :goto_1

    .line 3003
    .end local v0    # "isReferrable":Z
    :cond_4
    const/4 v0, 0x0

    goto :goto_2
.end method

.method private hasDeviceFingerPrint()Z
    .locals 2

    .prologue
    .line 2927
    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getDeviceFingerPrintID()Ljava/lang/String;

    move-result-object v0

    const-string v1, "bnc_no_value"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private hasSession()Z
    .locals 2

    .prologue
    .line 2923
    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getSessionID()Ljava/lang/String;

    move-result-object v0

    const-string v1, "bnc_no_value"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private hasUser()Z
    .locals 2

    .prologue
    .line 2931
    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getIdentityID()Ljava/lang/String;

    move-result-object v0

    const-string v1, "bnc_no_value"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static initInstance(Landroid/content/Context;)Lio/branch/referral/Branch;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .prologue
    .line 596
    new-instance v0, Lio/branch/referral/Branch;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lio/branch/referral/Branch;-><init>(Landroid/content/Context;)V

    return-object v0
.end method

.method private initUserSessionInternal(Lio/branch/referral/Branch$BranchReferralInitListener;Landroid/app/Activity;Z)V
    .locals 4
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchReferralInitListener;
    .param p2, "activity"    # Landroid/app/Activity;
    .param p3, "isReferrable"    # Z

    .prologue
    const/4 v3, 0x0

    .line 1059
    iput-object p2, p0, Lio/branch/referral/Branch;->currentActivity_:Landroid/app/Activity;

    .line 1061
    invoke-direct {p0}, Lio/branch/referral/Branch;->hasUser()Z

    move-result v1

    if-eqz v1, :cond_4

    invoke-direct {p0}, Lio/branch/referral/Branch;->hasSession()Z

    move-result v1

    if-eqz v1, :cond_4

    iget-object v1, p0, Lio/branch/referral/Branch;->initState_:Lio/branch/referral/Branch$SESSION_STATE;

    sget-object v2, Lio/branch/referral/Branch$SESSION_STATE;->INITIALISED:Lio/branch/referral/Branch$SESSION_STATE;

    if-ne v1, v2, :cond_4

    .line 1062
    if-eqz p1, :cond_0

    .line 1063
    sget-boolean v1, Lio/branch/referral/Branch;->isAutoSessionMode_:Z

    if-eqz v1, :cond_3

    .line 1066
    iget-boolean v1, p0, Lio/branch/referral/Branch;->isInitReportedThroughCallBack:Z

    if-nez v1, :cond_2

    .line 1067
    invoke-virtual {p0}, Lio/branch/referral/Branch;->getLatestReferringParams()Lorg/json/JSONObject;

    move-result-object v1

    invoke-interface {p1, v1, v3}, Lio/branch/referral/Branch$BranchReferralInitListener;->onInitFinished(Lorg/json/JSONObject;Lio/branch/referral/BranchError;)V

    .line 1068
    const/4 v1, 0x1

    iput-boolean v1, p0, Lio/branch/referral/Branch;->isInitReportedThroughCallBack:Z

    .line 1077
    :cond_0
    :goto_0
    invoke-direct {p0}, Lio/branch/referral/Branch;->clearCloseTimer()V

    .line 1078
    invoke-direct {p0}, Lio/branch/referral/Branch;->keepAlive()V

    .line 1101
    :goto_1
    iget-object v1, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v1}, Lio/branch/referral/PrefHelper;->getTouchDebugging()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1102
    if-eqz p2, :cond_1

    iget-object v1, p0, Lio/branch/referral/Branch;->debugListenerInitHistory_:Landroid/util/SparseArray;

    invoke-static {p2}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    if-nez v1, :cond_1

    .line 1103
    iget-object v1, p0, Lio/branch/referral/Branch;->debugListenerInitHistory_:Landroid/util/SparseArray;

    invoke-static {p2}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v2

    const-string v3, "init"

    invoke-virtual {v1, v2, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 1104
    invoke-virtual {p2}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v1

    const v2, 0x1020002

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 1105
    .local v0, "view":Landroid/view/View;
    if-eqz v0, :cond_1

    .line 1106
    iget-object v1, p0, Lio/branch/referral/Branch;->debugOnTouchListener_:Landroid/view/View$OnTouchListener;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 1110
    .end local v0    # "view":Landroid/view/View;
    :cond_1
    return-void

    .line 1070
    :cond_2
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    invoke-interface {p1, v1, v3}, Lio/branch/referral/Branch$BranchReferralInitListener;->onInitFinished(Lorg/json/JSONObject;Lio/branch/referral/BranchError;)V

    goto :goto_0

    .line 1074
    :cond_3
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    invoke-interface {p1, v1, v3}, Lio/branch/referral/Branch$BranchReferralInitListener;->onInitFinished(Lorg/json/JSONObject;Lio/branch/referral/BranchError;)V

    goto :goto_0

    .line 1084
    :cond_4
    if-eqz p3, :cond_5

    .line 1085
    iget-object v1, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v1}, Lio/branch/referral/PrefHelper;->setIsReferrable()V

    .line 1091
    :goto_2
    iget-object v1, p0, Lio/branch/referral/Branch;->initState_:Lio/branch/referral/Branch$SESSION_STATE;

    sget-object v2, Lio/branch/referral/Branch$SESSION_STATE;->INITIALISING:Lio/branch/referral/Branch$SESSION_STATE;

    if-ne v1, v2, :cond_6

    .line 1092
    iget-object v1, p0, Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;

    invoke-virtual {v1, p1}, Lio/branch/referral/ServerRequestQueue;->setInstallOrOpenCallback(Lio/branch/referral/Branch$BranchReferralInitListener;)V

    goto :goto_1

    .line 1087
    :cond_5
    iget-object v1, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v1}, Lio/branch/referral/PrefHelper;->clearIsReferrable()V

    goto :goto_2

    .line 1096
    :cond_6
    sget-object v1, Lio/branch/referral/Branch$SESSION_STATE;->INITIALISING:Lio/branch/referral/Branch$SESSION_STATE;

    iput-object v1, p0, Lio/branch/referral/Branch;->initState_:Lio/branch/referral/Branch$SESSION_STATE;

    .line 1097
    invoke-direct {p0, p1}, Lio/branch/referral/Branch;->initializeSession(Lio/branch/referral/Branch$BranchReferralInitListener;)V

    goto :goto_1
.end method

.method private initUserSessionInternal(Lio/branch/referral/Branch$BranchUniversalReferralInitListener;Landroid/app/Activity;Z)V
    .locals 1
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchUniversalReferralInitListener;
    .param p2, "activity"    # Landroid/app/Activity;
    .param p3, "isReferrable"    # Z

    .prologue
    .line 1054
    new-instance v0, Lio/branch/referral/BranchUniversalReferralInitWrapper;

    invoke-direct {v0, p1}, Lio/branch/referral/BranchUniversalReferralInitWrapper;-><init>(Lio/branch/referral/Branch$BranchUniversalReferralInitListener;)V

    .line 1055
    .local v0, "branchUniversalReferralInitWrapper":Lio/branch/referral/BranchUniversalReferralInitWrapper;
    invoke-direct {p0, v0, p2, p3}, Lio/branch/referral/Branch;->initUserSessionInternal(Lio/branch/referral/Branch$BranchReferralInitListener;Landroid/app/Activity;Z)V

    .line 1056
    return-void
.end method

.method private initializeSession(Lio/branch/referral/Branch$BranchReferralInitListener;)V
    .locals 4
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchReferralInitListener;

    .prologue
    .line 2960
    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getBranchKey()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getBranchKey()Ljava/lang/String;

    move-result-object v0

    const-string v1, "bnc_no_value"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    :cond_0
    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getAppKey()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getAppKey()Ljava/lang/String;

    move-result-object v0

    const-string v1, "bnc_no_value"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 2962
    :cond_1
    sget-object v0, Lio/branch/referral/Branch$SESSION_STATE;->UNINITIALISED:Lio/branch/referral/Branch$SESSION_STATE;

    iput-object v0, p0, Lio/branch/referral/Branch;->initState_:Lio/branch/referral/Branch$SESSION_STATE;

    .line 2964
    if-eqz p1, :cond_2

    .line 2965
    const/4 v0, 0x0

    new-instance v1, Lio/branch/referral/BranchError;

    const-string v2, "Trouble initializing Branch."

    const/16 v3, -0x4d2

    invoke-direct {v1, v2, v3}, Lio/branch/referral/BranchError;-><init>(Ljava/lang/String;I)V

    invoke-interface {p1, v0, v1}, Lio/branch/referral/Branch$BranchReferralInitListener;->onInitFinished(Lorg/json/JSONObject;Lio/branch/referral/BranchError;)V

    .line 2967
    :cond_2
    const-string v0, "BranchSDK"

    const-string v1, "Branch Warning: Please enter your branch_key in your project\'s res/values/strings.xml!"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 2978
    :goto_0
    return-void

    .line 2969
    :cond_3
    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getBranchKey()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getBranchKey()Ljava/lang/String;

    move-result-object v0

    const-string v1, "key_test_"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 2970
    const-string v0, "BranchSDK"

    const-string v1, "Branch Warning: You are using your test app\'s Branch Key. Remember to change it to live Branch Key during deployment."

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 2973
    :cond_4
    invoke-direct {p0}, Lio/branch/referral/Branch;->hasUser()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 2974
    new-instance v0, Lio/branch/referral/ServerRequestRegisterOpen;

    iget-object v1, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    iget-object v2, p0, Lio/branch/referral/Branch;->kRemoteInterface_:Lio/branch/referral/BranchRemoteInterface;

    invoke-virtual {v2}, Lio/branch/referral/BranchRemoteInterface;->getSystemObserver()Lio/branch/referral/SystemObserver;

    move-result-object v2

    invoke-direct {v0, v1, p1, v2}, Lio/branch/referral/ServerRequestRegisterOpen;-><init>(Landroid/content/Context;Lio/branch/referral/Branch$BranchReferralInitListener;Lio/branch/referral/SystemObserver;)V

    invoke-direct {p0, v0, p1}, Lio/branch/referral/Branch;->registerInstallOrOpen(Lio/branch/referral/ServerRequest;Lio/branch/referral/Branch$BranchReferralInitListener;)V

    goto :goto_0

    .line 2976
    :cond_5
    new-instance v0, Lio/branch/referral/ServerRequestRegisterInstall;

    iget-object v1, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    iget-object v2, p0, Lio/branch/referral/Branch;->kRemoteInterface_:Lio/branch/referral/BranchRemoteInterface;

    invoke-virtual {v2}, Lio/branch/referral/BranchRemoteInterface;->getSystemObserver()Lio/branch/referral/SystemObserver;

    move-result-object v2

    invoke-static {}, Lio/branch/referral/InstallListener;->getInstallationID()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v1, p1, v2, v3}, Lio/branch/referral/ServerRequestRegisterInstall;-><init>(Landroid/content/Context;Lio/branch/referral/Branch$BranchReferralInitListener;Lio/branch/referral/SystemObserver;Ljava/lang/String;)V

    invoke-direct {p0, v0, p1}, Lio/branch/referral/Branch;->registerInstallOrOpen(Lio/branch/referral/ServerRequest;Lio/branch/referral/Branch$BranchReferralInitListener;)V

    goto :goto_0
.end method

.method private insertRequestAtFront(Lio/branch/referral/ServerRequest;)V
    .locals 2
    .param p1, "req"    # Lio/branch/referral/ServerRequest;

    .prologue
    .line 2935
    iget v0, p0, Lio/branch/referral/Branch;->networkCount_:I

    if-nez v0, :cond_0

    .line 2936
    iget-object v0, p0, Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Lio/branch/referral/ServerRequestQueue;->insert(Lio/branch/referral/ServerRequest;I)V

    .line 2940
    :goto_0
    return-void

    .line 2938
    :cond_0
    iget-object v0, p0, Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;

    const/4 v1, 0x1

    invoke-virtual {v0, p1, v1}, Lio/branch/referral/ServerRequestQueue;->insert(Lio/branch/referral/ServerRequest;I)V

    goto :goto_0
.end method

.method public static isAutoDeepLinkLaunch(Landroid/app/Activity;)Z
    .locals 2
    .param p0, "activity"    # Landroid/app/Activity;

    .prologue
    .line 3410
    invoke-virtual {p0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "io.branch.sdk.auto_linked"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private keepAlive()V
    .locals 6

    .prologue
    .line 2905
    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/branch/referral/Branch;->keepAlive_:Z

    .line 2906
    iget-object v1, p0, Lio/branch/referral/Branch;->lock:Ljava/lang/Object;

    monitor-enter v1

    .line 2907
    :try_start_0
    invoke-direct {p0}, Lio/branch/referral/Branch;->clearTimer()V

    .line 2908
    iget-object v0, p0, Lio/branch/referral/Branch;->closeTimer:Ljava/util/Timer;

    new-instance v2, Lio/branch/referral/Branch$4;

    invoke-direct {v2, p0}, Lio/branch/referral/Branch$4;-><init>(Lio/branch/referral/Branch;)V

    const-wide/16 v4, 0x7d0

    invoke-virtual {v0, v2, v4, v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    .line 2919
    monitor-exit v1

    .line 2920
    return-void

    .line 2919
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private pathMatch(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 9
    .param p1, "templatePath"    # Ljava/lang/String;
    .param p2, "path"    # Ljava/lang/String;

    .prologue
    const/4 v6, 0x0

    .line 3502
    const/4 v1, 0x1

    .line 3503
    .local v1, "matched":Z
    const-string v7, "\\?"

    invoke-virtual {p1, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v7

    aget-object v7, v7, v6

    const-string v8, "/"

    invoke-virtual {v7, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 3504
    .local v5, "pathSegmentsTemplate":[Ljava/lang/String;
    const-string v7, "\\?"

    invoke-virtual {p2, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v7

    aget-object v7, v7, v6

    const-string v8, "/"

    invoke-virtual {v7, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    .line 3505
    .local v4, "pathSegmentsTarget":[Ljava/lang/String;
    array-length v7, v5

    array-length v8, v4

    if-eq v7, v8, :cond_0

    .line 3516
    :goto_0
    return v6

    .line 3508
    :cond_0
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    array-length v6, v5

    if-ge v0, v6, :cond_1

    array-length v6, v4

    if-ge v0, v6, :cond_1

    .line 3509
    aget-object v3, v5, v0

    .line 3510
    .local v3, "pathSegmentTemplate":Ljava/lang/String;
    aget-object v2, v4, v0

    .line 3511
    .local v2, "pathSegmentTarget":Ljava/lang/String;
    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_2

    const-string v6, "*"

    invoke-virtual {v3, v6}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_2

    .line 3512
    const/4 v1, 0x0

    .end local v2    # "pathSegmentTarget":Ljava/lang/String;
    .end local v3    # "pathSegmentTemplate":Ljava/lang/String;
    :cond_1
    move v6, v1

    .line 3516
    goto :goto_0

    .line 3508
    .restart local v2    # "pathSegmentTarget":Ljava/lang/String;
    .restart local v3    # "pathSegmentTemplate":Ljava/lang/String;
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method private processNextQueueItem()V
    .locals 5

    .prologue
    .line 2817
    :try_start_0
    iget-object v3, p0, Lio/branch/referral/Branch;->serverSema_:Ljava/util/concurrent/Semaphore;

    invoke-virtual {v3}, Ljava/util/concurrent/Semaphore;->acquire()V

    .line 2818
    iget v3, p0, Lio/branch/referral/Branch;->networkCount_:I

    if-nez v3, :cond_5

    iget-object v3, p0, Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;

    invoke-virtual {v3}, Lio/branch/referral/ServerRequestQueue;->getSize()I

    move-result v3

    if-lez v3, :cond_5

    .line 2819
    const/4 v3, 0x1

    iput v3, p0, Lio/branch/referral/Branch;->networkCount_:I

    .line 2820
    iget-object v3, p0, Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;

    invoke-virtual {v3}, Lio/branch/referral/ServerRequestQueue;->peek()Lio/branch/referral/ServerRequest;

    move-result-object v2

    .line 2822
    .local v2, "req":Lio/branch/referral/ServerRequest;
    iget-object v3, p0, Lio/branch/referral/Branch;->serverSema_:Ljava/util/concurrent/Semaphore;

    invoke-virtual {v3}, Ljava/util/concurrent/Semaphore;->release()V

    .line 2823
    if-eqz v2, :cond_4

    .line 2825
    instance-of v3, v2, Lio/branch/referral/ServerRequestRegisterInstall;

    if-nez v3, :cond_0

    invoke-direct {p0}, Lio/branch/referral/Branch;->hasUser()Z

    move-result v3

    if-nez v3, :cond_0

    .line 2826
    const-string v3, "BranchSDK"

    const-string v4, "Branch Error: User session has not been initialized!"

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 2827
    const/4 v3, 0x0

    iput v3, p0, Lio/branch/referral/Branch;->networkCount_:I

    .line 2828
    iget-object v3, p0, Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;

    invoke-virtual {v3}, Lio/branch/referral/ServerRequestQueue;->getSize()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    const/16 v4, -0x65

    invoke-direct {p0, v3, v4}, Lio/branch/referral/Branch;->handleFailure(II)V

    .line 2847
    .end local v2    # "req":Lio/branch/referral/ServerRequest;
    :goto_0
    return-void

    .line 2831
    .restart local v2    # "req":Lio/branch/referral/ServerRequest;
    :cond_0
    instance-of v3, v2, Lio/branch/referral/ServerRequestInitSession;

    if-nez v3, :cond_2

    invoke-direct {p0}, Lio/branch/referral/Branch;->hasSession()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-direct {p0}, Lio/branch/referral/Branch;->hasDeviceFingerPrint()Z

    move-result v3

    if-nez v3, :cond_2

    .line 2832
    :cond_1
    const/4 v3, 0x0

    iput v3, p0, Lio/branch/referral/Branch;->networkCount_:I

    .line 2833
    iget-object v3, p0, Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;

    invoke-virtual {v3}, Lio/branch/referral/ServerRequestQueue;->getSize()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    const/16 v4, -0x65

    invoke-direct {p0, v3, v4}, Lio/branch/referral/Branch;->handleFailure(II)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 2844
    .end local v2    # "req":Lio/branch/referral/ServerRequest;
    :catch_0
    move-exception v0

    .line 2845
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 2835
    .end local v0    # "e":Ljava/lang/Exception;
    .restart local v2    # "req":Lio/branch/referral/ServerRequest;
    :cond_2
    :try_start_1
    new-instance v1, Lio/branch/referral/Branch$BranchPostTask;

    invoke-direct {v1, p0, v2}, Lio/branch/referral/Branch$BranchPostTask;-><init>(Lio/branch/referral/Branch;Lio/branch/referral/ServerRequest;)V

    .line 2836
    .local v1, "postTask":Lio/branch/referral/Branch$BranchPostTask;
    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Void;

    instance-of v4, v1, Landroid/os/AsyncTask;

    if-nez v4, :cond_3

    invoke-virtual {v1, v3}, Lio/branch/referral/Branch$BranchPostTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    :cond_3
    check-cast v1, Landroid/os/AsyncTask;

    .end local v1    # "postTask":Lio/branch/referral/Branch$BranchPostTask;
    invoke-static {v1, v3}, Lcom/newrelic/agent/android/instrumentation/AsyncTaskInstrumentation;->execute(Landroid/os/AsyncTask;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 2839
    :cond_4
    iget-object v3, p0, Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Lio/branch/referral/ServerRequestQueue;->remove(Lio/branch/referral/ServerRequest;)Z

    goto :goto_0

    .line 2842
    .end local v2    # "req":Lio/branch/referral/ServerRequest;
    :cond_5
    iget-object v3, p0, Lio/branch/referral/Branch;->serverSema_:Ljava/util/concurrent/Semaphore;

    invoke-virtual {v3}, Ljava/util/concurrent/Semaphore;->release()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method private readAndStripParam(Landroid/net/Uri;Landroid/app/Activity;)Z
    .locals 12
    .param p1, "data"    # Landroid/net/Uri;
    .param p2, "activity"    # Landroid/app/Activity;

    .prologue
    const/4 v9, 0x0

    .line 1292
    if-eqz p1, :cond_5

    invoke-virtual {p1}, Landroid/net/Uri;->isHierarchical()Z

    move-result v10

    if-eqz v10, :cond_5

    if-eqz p2, :cond_5

    .line 1293
    sget-object v10, Lio/branch/referral/Defines$Jsonkey;->LinkClickID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v10}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {p1, v10}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    if-eqz v10, :cond_3

    .line 1294
    iget-object v9, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    sget-object v10, Lio/branch/referral/Defines$Jsonkey;->LinkClickID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v10}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {p1, v10}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Lio/branch/referral/PrefHelper;->setLinkClickIdentifier(Ljava/lang/String;)V

    .line 1295
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "link_click_id="

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    sget-object v10, Lio/branch/referral/Defines$Jsonkey;->LinkClickID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v10}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {p1, v10}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 1296
    .local v6, "paramString":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v9

    invoke-virtual {v9}, Landroid/content/Intent;->getDataString()Ljava/lang/String;

    move-result-object v8

    .line 1297
    .local v8, "uriString":Ljava/lang/String;
    invoke-virtual {p1}, Landroid/net/Uri;->getQuery()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/String;->length()I

    move-result v9

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v10

    if-ne v9, v10, :cond_1

    .line 1298
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "\\?"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 1304
    :goto_0
    const-string v9, ""

    invoke-virtual {v8, v6, v9}, Ljava/lang/String;->replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    .line 1305
    .local v5, "newData":Landroid/net/Uri;
    invoke-virtual {p2}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v9

    invoke-virtual {v9, v5}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 1306
    const/4 v9, 0x1

    .line 1342
    .end local v5    # "newData":Landroid/net/Uri;
    .end local v6    # "paramString":Ljava/lang/String;
    .end local v8    # "uriString":Ljava/lang/String;
    :cond_0
    :goto_1
    return v9

    .line 1299
    .restart local v6    # "paramString":Ljava/lang/String;
    .restart local v8    # "uriString":Ljava/lang/String;
    :cond_1
    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v9

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v10

    sub-int/2addr v9, v10

    invoke-virtual {v8, v6}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v10

    if-ne v9, v10, :cond_2

    .line 1300
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "&"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    goto :goto_0

    .line 1302
    :cond_2
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v9, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "&"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    goto :goto_0

    .line 1309
    .end local v6    # "paramString":Ljava/lang/String;
    .end local v8    # "uriString":Ljava/lang/String;
    :cond_3
    invoke-virtual {p1}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v7

    .line 1310
    .local v7, "scheme":Ljava/lang/String;
    if-eqz v7, :cond_5

    .line 1311
    const-string v10, "http"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_4

    const-string v10, "https"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_5

    :cond_4
    invoke-virtual {p1}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v10

    if-eqz v10, :cond_5

    invoke-virtual {p1}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/String;->length()I

    move-result v10

    if-lez v10, :cond_5

    .line 1313
    iget-object v10, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Lio/branch/referral/PrefHelper;->setAppLink(Ljava/lang/String;)V

    goto :goto_1

    .line 1322
    .end local v7    # "scheme":Ljava/lang/String;
    :cond_5
    if-eqz p1, :cond_6

    .line 1323
    :try_start_0
    iget-object v10, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Lio/branch/referral/PrefHelper;->setExternalIntentUri(Ljava/lang/String;)V

    .line 1325
    :cond_6
    if-eqz p2, :cond_0

    invoke-virtual {p2}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v10

    if-eqz v10, :cond_0

    invoke-virtual {p2}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v10

    invoke-virtual {v10}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v10

    if-eqz v10, :cond_0

    .line 1326
    invoke-virtual {p2}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v10

    invoke-virtual {v10}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 1327
    .local v0, "bundle":Landroid/os/Bundle;
    invoke-virtual {v0}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v1

    .line 1329
    .local v1, "extraKeys":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Set;->size()I

    move-result v10

    if-lez v10, :cond_0

    .line 1330
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V

    .line 1331
    .local v2, "extrasJson":Lorg/json/JSONObject;
    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_7

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 1332
    .local v4, "key":Ljava/lang/String;
    invoke-virtual {v0, v4}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v10

    invoke-virtual {v2, v4, v10}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_2

    .line 1337
    .end local v0    # "bundle":Landroid/os/Bundle;
    .end local v1    # "extraKeys":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .end local v2    # "extrasJson":Lorg/json/JSONObject;
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v4    # "key":Ljava/lang/String;
    :catch_0
    move-exception v10

    goto/16 :goto_1

    .line 1334
    .restart local v0    # "bundle":Landroid/os/Bundle;
    .restart local v1    # "extraKeys":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .restart local v2    # "extrasJson":Lorg/json/JSONObject;
    .restart local v3    # "i$":Ljava/util/Iterator;
    :cond_7
    iget-object v11, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    instance-of v10, v2, Lorg/json/JSONObject;

    if-nez v10, :cond_8

    invoke-virtual {v2}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v10

    .end local v2    # "extrasJson":Lorg/json/JSONObject;
    :goto_3
    invoke-virtual {v11, v10}, Lio/branch/referral/PrefHelper;->setExternalIntentExtra(Ljava/lang/String;)V

    goto/16 :goto_1

    .restart local v2    # "extrasJson":Lorg/json/JSONObject;
    :cond_8
    check-cast v2, Lorg/json/JSONObject;

    .end local v2    # "extrasJson":Lorg/json/JSONObject;
    invoke-static {v2}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v10

    goto :goto_3
.end method

.method private registerInstallOrOpen(Lio/branch/referral/ServerRequest;Lio/branch/referral/Branch$BranchReferralInitListener;)V
    .locals 2
    .param p1, "req"    # Lio/branch/referral/ServerRequest;
    .param p2, "callback"    # Lio/branch/referral/Branch$BranchReferralInitListener;

    .prologue
    .line 2944
    iget-object v0, p0, Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;

    invoke-virtual {v0}, Lio/branch/referral/ServerRequestQueue;->containsInstallOrOpen()Z

    move-result v0

    if-nez v0, :cond_0

    .line 2945
    invoke-direct {p0, p1}, Lio/branch/referral/Branch;->insertRequestAtFront(Lio/branch/referral/ServerRequest;)V

    .line 2956
    :goto_0
    invoke-direct {p0}, Lio/branch/referral/Branch;->processNextQueueItem()V

    .line 2957
    return-void

    .line 2952
    :cond_0
    iget-object v0, p0, Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;

    invoke-virtual {v0, p2}, Lio/branch/referral/ServerRequestQueue;->setInstallOrOpenCallback(Lio/branch/referral/Branch$BranchReferralInitListener;)V

    .line 2953
    iget-object v0, p0, Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;

    iget v1, p0, Lio/branch/referral/Branch;->networkCount_:I

    invoke-virtual {v0, p1, v1, p2}, Lio/branch/referral/ServerRequestQueue;->moveInstallOrOpenToFront(Lio/branch/referral/ServerRequest;ILio/branch/referral/Branch$BranchReferralInitListener;)V

    goto :goto_0
.end method

.method private retrieveOnTouchListener()Landroid/view/View$OnTouchListener;
    .locals 1

    .prologue
    .line 1139
    iget-object v0, p0, Lio/branch/referral/Branch;->debugOnTouchListener_:Landroid/view/View$OnTouchListener;

    if-nez v0, :cond_0

    .line 1140
    new-instance v0, Lio/branch/referral/Branch$1;

    invoke-direct {v0, p0}, Lio/branch/referral/Branch$1;-><init>(Lio/branch/referral/Branch;)V

    iput-object v0, p0, Lio/branch/referral/Branch;->debugOnTouchListener_:Landroid/view/View$OnTouchListener;

    .line 1199
    :cond_0
    iget-object v0, p0, Lio/branch/referral/Branch;->debugOnTouchListener_:Landroid/view/View$OnTouchListener;

    return-object v0
.end method

.method private scheduleListOfApps()V
    .locals 12

    .prologue
    .line 2790
    const/4 v2, 0x1

    invoke-static {v2}, Ljava/util/concurrent/Executors;->newScheduledThreadPool(I)Ljava/util/concurrent/ScheduledExecutorService;

    move-result-object v0

    check-cast v0, Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    .line 2791
    .local v0, "scheduler":Ljava/util/concurrent/ScheduledThreadPoolExecutor;
    new-instance v1, Lio/branch/referral/Branch$3;

    invoke-direct {v1, p0}, Lio/branch/referral/Branch$3;-><init>(Lio/branch/referral/Branch;)V

    .line 2801
    .local v1, "periodicTask":Ljava/lang/Runnable;
    new-instance v8, Ljava/util/Date;

    invoke-direct {v8}, Ljava/util/Date;-><init>()V

    .line 2802
    .local v8, "date":Ljava/util/Date;
    invoke-static {}, Ljava/util/GregorianCalendar;->getInstance()Ljava/util/Calendar;

    move-result-object v7

    .line 2803
    .local v7, "calendar":Ljava/util/Calendar;
    invoke-virtual {v7, v8}, Ljava/util/Calendar;->setTime(Ljava/util/Date;)V

    .line 2805
    const/4 v2, 0x7

    invoke-virtual {v7, v2}, Ljava/util/Calendar;->get(I)I

    move-result v2

    rsub-int/lit8 v9, v2, 0x7

    .line 2806
    .local v9, "days":I
    const/16 v2, 0xb

    invoke-virtual {v7, v2}, Ljava/util/Calendar;->get(I)I

    move-result v2

    rsub-int/lit8 v10, v2, 0x2

    .line 2807
    .local v10, "hours":I
    if-nez v9, :cond_0

    if-gez v10, :cond_0

    .line 2808
    const/4 v9, 0x7

    .line 2810
    :cond_0
    const v11, 0x93a80

    .line 2812
    .local v11, "interval":I
    mul-int/lit8 v2, v9, 0x18

    add-int/2addr v2, v10

    mul-int/lit8 v2, v2, 0x3c

    mul-int/lit8 v2, v2, 0x3c

    int-to-long v2, v2

    int-to-long v4, v11

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual/range {v0 .. v6}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    move-result-object v2

    iput-object v2, p0, Lio/branch/referral/Branch;->appListingSchedule_:Ljava/util/concurrent/ScheduledFuture;

    .line 2813
    return-void
.end method

.method private setActivityLifeCycleObserver(Landroid/app/Application;)V
    .locals 6
    .param p1, "application"    # Landroid/app/Application;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xe
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 3016
    :try_start_0
    new-instance v1, Lio/branch/referral/Branch$BranchActivityLifeCycleObserver;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lio/branch/referral/Branch$BranchActivityLifeCycleObserver;-><init>(Lio/branch/referral/Branch;Lio/branch/referral/Branch$1;)V

    .line 3018
    .local v1, "activityLifeCycleObserver":Lio/branch/referral/Branch$BranchActivityLifeCycleObserver;
    invoke-virtual {p1, v1}, Landroid/app/Application;->unregisterActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V

    .line 3019
    invoke-virtual {p1, v1}, Landroid/app/Application;->registerActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V

    .line 3020
    const/4 v2, 0x1

    sput-boolean v2, Lio/branch/referral/Branch;->isActivityLifeCycleCallbackRegistered_:Z
    :try_end_0
    .catch Ljava/lang/NoSuchMethodError; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/NoClassDefFoundError; {:try_start_0 .. :try_end_0} :catch_0

    .line 3028
    .end local v1    # "activityLifeCycleObserver":Lio/branch/referral/Branch$BranchActivityLifeCycleObserver;
    :goto_0
    return-void

    .line 3022
    :catch_0
    move-exception v0

    .line 3023
    .local v0, "Ex":Ljava/lang/LinkageError;
    :goto_1
    sput-boolean v3, Lio/branch/referral/Branch;->isActivityLifeCycleCallbackRegistered_:Z

    .line 3024
    sput-boolean v3, Lio/branch/referral/Branch;->isAutoSessionMode_:Z

    .line 3026
    const-string v2, "BranchSDK"

    new-instance v3, Lio/branch/referral/BranchError;

    const-string v4, ""

    const/16 v5, -0x6c

    invoke-direct {v3, v4, v5}, Lio/branch/referral/BranchError;-><init>(Ljava/lang/String;I)V

    invoke-virtual {v3}, Lio/branch/referral/BranchError;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 3022
    .end local v0    # "Ex":Ljava/lang/LinkageError;
    :catch_1
    move-exception v0

    goto :goto_1
.end method

.method private setTouchDebugInternal(Landroid/app/Activity;)V
    .locals 3
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 1118
    if-eqz p1, :cond_0

    iget-object v0, p0, Lio/branch/referral/Branch;->debugListenerInitHistory_:Landroid/util/SparseArray;

    invoke-static {p1}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_0

    .line 1119
    iget-object v0, p0, Lio/branch/referral/Branch;->debugListenerInitHistory_:Landroid/util/SparseArray;

    invoke-static {p1}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v1

    const-string v2, "init"

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 1120
    invoke-virtual {p1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    new-instance v1, Lio/branch/referral/Branch$BranchWindowCallback;

    invoke-virtual {p1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/Window;->getCallback()Landroid/view/Window$Callback;

    move-result-object v2

    invoke-direct {v1, p0, v2}, Lio/branch/referral/Branch$BranchWindowCallback;-><init>(Lio/branch/referral/Branch;Landroid/view/Window$Callback;)V

    invoke-virtual {v0, v1}, Landroid/view/Window;->setCallback(Landroid/view/Window$Callback;)V

    .line 1122
    :cond_0
    return-void
.end method

.method private shareLink(Lio/branch/referral/Branch$ShareLinkBuilder;)V
    .locals 2
    .param p1, "builder"    # Lio/branch/referral/Branch$ShareLinkBuilder;

    .prologue
    .line 2697
    iget-object v0, p0, Lio/branch/referral/Branch;->shareLinkManager_:Lio/branch/referral/ShareLinkManager;

    if-eqz v0, :cond_0

    .line 2698
    iget-object v0, p0, Lio/branch/referral/Branch;->shareLinkManager_:Lio/branch/referral/ShareLinkManager;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lio/branch/referral/ShareLinkManager;->cancelShareLinkDialog(Z)V

    .line 2700
    :cond_0
    new-instance v0, Lio/branch/referral/ShareLinkManager;

    invoke-direct {v0}, Lio/branch/referral/ShareLinkManager;-><init>()V

    iput-object v0, p0, Lio/branch/referral/Branch;->shareLinkManager_:Lio/branch/referral/ShareLinkManager;

    .line 2701
    iget-object v0, p0, Lio/branch/referral/Branch;->shareLinkManager_:Lio/branch/referral/ShareLinkManager;

    invoke-virtual {v0, p1}, Lio/branch/referral/ShareLinkManager;->shareLink(Lio/branch/referral/Branch$ShareLinkBuilder;)Landroid/app/Dialog;

    .line 2702
    return-void
.end method

.method private updateAllRequestsInQueue()V
    .locals 7

    .prologue
    .line 2867
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    :try_start_0
    iget-object v5, p0, Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;

    invoke-virtual {v5}, Lio/branch/referral/ServerRequestQueue;->getSize()I

    move-result v5

    if-ge v1, v5, :cond_1

    .line 2868
    iget-object v5, p0, Lio/branch/referral/Branch;->requestQueue_:Lio/branch/referral/ServerRequestQueue;

    invoke-virtual {v5, v1}, Lio/branch/referral/ServerRequestQueue;->peekAt(I)Lio/branch/referral/ServerRequest;

    move-result-object v4

    .line 2869
    .local v4, "req":Lio/branch/referral/ServerRequest;
    invoke-virtual {v4}, Lio/branch/referral/ServerRequest;->getPost()Lorg/json/JSONObject;

    move-result-object v5

    if-eqz v5, :cond_4

    .line 2870
    invoke-virtual {v4}, Lio/branch/referral/ServerRequest;->getPost()Lorg/json/JSONObject;

    move-result-object v5

    invoke-virtual {v5}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v3

    .line 2871
    .local v3, "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    :cond_0
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_4

    .line 2872
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 2873
    .local v2, "key":Ljava/lang/String;
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->SessionID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 2874
    invoke-virtual {v4}, Lio/branch/referral/ServerRequest;->getPost()Lorg/json/JSONObject;

    move-result-object v5

    iget-object v6, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v6}, Lio/branch/referral/PrefHelper;->getSessionID()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v2, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 2883
    .end local v2    # "key":Ljava/lang/String;
    .end local v3    # "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    .end local v4    # "req":Lio/branch/referral/ServerRequest;
    :catch_0
    move-exception v0

    .line 2884
    .local v0, "e":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    .line 2886
    .end local v0    # "e":Lorg/json/JSONException;
    :cond_1
    return-void

    .line 2875
    .restart local v2    # "key":Ljava/lang/String;
    .restart local v3    # "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    .restart local v4    # "req":Lio/branch/referral/ServerRequest;
    :cond_2
    :try_start_1
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->IdentityID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 2876
    invoke-virtual {v4}, Lio/branch/referral/ServerRequest;->getPost()Lorg/json/JSONObject;

    move-result-object v5

    iget-object v6, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v6}, Lio/branch/referral/PrefHelper;->getIdentityID()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v2, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_1

    .line 2877
    :cond_3
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->DeviceFingerprintID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 2878
    invoke-virtual {v4}, Lio/branch/referral/ServerRequest;->getPost()Lorg/json/JSONObject;

    move-result-object v5

    iget-object v6, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v6}, Lio/branch/referral/PrefHelper;->getDeviceFingerPrintID()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v2, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    .line 2867
    .end local v2    # "key":Ljava/lang/String;
    .end local v3    # "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    :cond_4
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method


# virtual methods
.method public applyReferralCode(Ljava/lang/String;Lio/branch/referral/Branch$BranchReferralInitListener;)V
    .locals 2
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "callback"    # Lio/branch/referral/Branch$BranchReferralInitListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 2683
    new-instance v0, Lio/branch/referral/ServerRequestApplyReferralCode;

    iget-object v1, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    invoke-direct {v0, v1, p2, p1}, Lio/branch/referral/ServerRequestApplyReferralCode;-><init>(Landroid/content/Context;Lio/branch/referral/Branch$BranchReferralInitListener;Ljava/lang/String;)V

    .line 2684
    .local v0, "req":Lio/branch/referral/ServerRequest;
    iget-boolean v1, v0, Lio/branch/referral/ServerRequest;->constructError_:Z

    if-nez v1, :cond_0

    iget-object v1, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lio/branch/referral/ServerRequest;->handleErrors(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 2685
    invoke-direct {p0, v0}, Lio/branch/referral/Branch;->handleNewRequest(Lio/branch/referral/ServerRequest;)V

    .line 2687
    :cond_0
    return-void
.end method

.method public cancelShareLinkDialog(Z)V
    .locals 1
    .param p1, "animateClose"    # Z

    .prologue
    .line 2713
    iget-object v0, p0, Lio/branch/referral/Branch;->shareLinkManager_:Lio/branch/referral/ShareLinkManager;

    if-eqz v0, :cond_0

    .line 2714
    iget-object v0, p0, Lio/branch/referral/Branch;->shareLinkManager_:Lio/branch/referral/ShareLinkManager;

    invoke-virtual {v0, p1}, Lio/branch/referral/ShareLinkManager;->cancelShareLinkDialog(Z)V

    .line 2716
    :cond_0
    return-void
.end method

.method public closeSession()V
    .locals 6

    .prologue
    .line 1211
    sget-boolean v0, Lio/branch/referral/Branch;->isAutoSessionMode_:Z

    if-eqz v0, :cond_1

    .line 1254
    :cond_0
    :goto_0
    return-void

    .line 1221
    :cond_1
    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getSmartSession()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1222
    iget-boolean v0, p0, Lio/branch/referral/Branch;->keepAlive_:Z

    if-nez v0, :cond_0

    .line 1228
    iget-object v1, p0, Lio/branch/referral/Branch;->lock:Ljava/lang/Object;

    monitor-enter v1

    .line 1229
    :try_start_0
    invoke-direct {p0}, Lio/branch/referral/Branch;->clearCloseTimer()V

    .line 1230
    iget-object v0, p0, Lio/branch/referral/Branch;->rotateCloseTimer:Ljava/util/Timer;

    new-instance v2, Lio/branch/referral/Branch$2;

    invoke-direct {v2, p0}, Lio/branch/referral/Branch$2;-><init>(Lio/branch/referral/Branch;)V

    const-wide/16 v4, 0x1f4

    invoke-virtual {v0, v2, v4, v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    .line 1238
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1245
    :goto_1
    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getExternAppListing()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1246
    iget-object v0, p0, Lio/branch/referral/Branch;->appListingSchedule_:Ljava/util/concurrent/ScheduledFuture;

    if-nez v0, :cond_2

    .line 1247
    invoke-direct {p0}, Lio/branch/referral/Branch;->scheduleListOfApps()V

    .line 1251
    :cond_2
    iget-object v0, p0, Lio/branch/referral/Branch;->shareLinkManager_:Lio/branch/referral/ShareLinkManager;

    if-eqz v0, :cond_0

    .line 1252
    iget-object v0, p0, Lio/branch/referral/Branch;->shareLinkManager_:Lio/branch/referral/ShareLinkManager;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lio/branch/referral/ShareLinkManager;->cancelShareLinkDialog(Z)V

    goto :goto_0

    .line 1238
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    .line 1241
    :cond_3
    const/4 v0, 0x0

    iput-object v0, p0, Lio/branch/referral/Branch;->currentActivity_:Landroid/app/Activity;

    .line 1242
    invoke-direct {p0}, Lio/branch/referral/Branch;->executeClose()V

    goto :goto_1
.end method

.method public disableAppList()V
    .locals 1

    .prologue
    .line 665
    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->disableExternAppListing()V

    .line 666
    return-void
.end method

.method public disableSmartSession()V
    .locals 1

    .prologue
    .line 687
    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->disableSmartSession()V

    .line 688
    return-void
.end method

.method public disableTouchDebugging()V
    .locals 1

    .prologue
    .line 674
    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->disableTouchDebugging()V

    .line 675
    return-void
.end method

.method public generateShortLinkInternal(Lio/branch/referral/ServerRequestCreateUrl;)Ljava/lang/String;
    .locals 3
    .param p1, "req"    # Lio/branch/referral/ServerRequestCreateUrl;

    .prologue
    .line 2318
    iget-boolean v1, p1, Lio/branch/referral/ServerRequestCreateUrl;->constructError_:Z

    if-nez v1, :cond_1

    iget-object v1, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    invoke-virtual {p1, v1}, Lio/branch/referral/ServerRequestCreateUrl;->handleErrors(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 2319
    iget-object v1, p0, Lio/branch/referral/Branch;->linkCache_:Ljava/util/Map;

    invoke-virtual {p1}, Lio/branch/referral/ServerRequestCreateUrl;->getLinkPost()Lio/branch/referral/BranchLinkData;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 2320
    iget-object v1, p0, Lio/branch/referral/Branch;->linkCache_:Ljava/util/Map;

    invoke-virtual {p1}, Lio/branch/referral/ServerRequestCreateUrl;->getLinkPost()Lio/branch/referral/BranchLinkData;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 2321
    .local v0, "url":Ljava/lang/String;
    invoke-virtual {p1, v0}, Lio/branch/referral/ServerRequestCreateUrl;->onUrlAvailable(Ljava/lang/String;)V

    .line 2331
    .end local v0    # "url":Ljava/lang/String;
    :goto_0
    return-object v0

    .line 2324
    :cond_0
    invoke-virtual {p1}, Lio/branch/referral/ServerRequestCreateUrl;->isAsync()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 2325
    invoke-direct {p0, p1}, Lio/branch/referral/Branch;->generateShortLinkAsync(Lio/branch/referral/ServerRequest;)V

    .line 2331
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 2327
    :cond_2
    invoke-direct {p0, p1}, Lio/branch/referral/Branch;->generateShortLinkSync(Lio/branch/referral/ServerRequestCreateUrl;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getContentUrl(Ljava/lang/String;Lorg/json/JSONObject;Lio/branch/referral/Branch$BranchLinkCreateListener;)V
    .locals 11
    .param p1, "channel"    # Ljava/lang/String;
    .param p2, "params"    # Lorg/json/JSONObject;
    .param p3, "callback"    # Lio/branch/referral/Branch$BranchLinkCreateListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 2439
    const-string v6, "share"

    invoke-static {p2}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    const/4 v10, 0x1

    move-object v0, p0

    move v3, v2

    move-object v4, v1

    move-object v5, p1

    move-object v7, v1

    move-object v9, p3

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    .line 2440
    return-void
.end method

.method public getContentUrl(Ljava/util/Collection;Ljava/lang/String;Lorg/json/JSONObject;Lio/branch/referral/Branch$BranchLinkCreateListener;)V
    .locals 11
    .param p2, "channel"    # Ljava/lang/String;
    .param p3, "params"    # Lorg/json/JSONObject;
    .param p4, "callback"    # Lio/branch/referral/Branch$BranchLinkCreateListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Lorg/json/JSONObject;",
            "Lio/branch/referral/Branch$BranchLinkCreateListener;",
            ")V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .local p1, "tags":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 2463
    const-string v6, "share"

    invoke-static {p3}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    const/4 v10, 0x1

    move-object v0, p0

    move v3, v2

    move-object v4, p1

    move-object v5, p2

    move-object v7, v1

    move-object v9, p4

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    .line 2464
    return-void
.end method

.method public getContentUrlSync(Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;
    .locals 11
    .param p1, "channel"    # Ljava/lang/String;
    .param p2, "params"    # Lorg/json/JSONObject;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 2480
    const-string v6, "share"

    invoke-static {p2}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    move-object v0, p0

    move v3, v2

    move-object v4, v1

    move-object v5, p1

    move-object v7, v1

    move-object v9, v1

    move v10, v2

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getContentUrlSync(Ljava/util/Collection;Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;
    .locals 11
    .param p2, "channel"    # Ljava/lang/String;
    .param p3, "params"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Lorg/json/JSONObject;",
            ")",
            "Ljava/lang/String;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .local p1, "tags":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 2499
    const-string v6, "share"

    invoke-static {p3}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    move-object v0, p0

    move v3, v2

    move-object v4, p1

    move-object v5, p2

    move-object v7, v1

    move-object v9, v1

    move v10, v2

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getCreditHistory(Lio/branch/referral/Branch$BranchListResponseListener;)V
    .locals 6
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchListResponseListener;

    .prologue
    const/4 v1, 0x0

    .line 1583
    const/16 v3, 0x64

    sget-object v4, Lio/branch/referral/Branch$CreditHistoryOrder;->kMostRecentFirst:Lio/branch/referral/Branch$CreditHistoryOrder;

    move-object v0, p0

    move-object v2, v1

    move-object v5, p1

    invoke-virtual/range {v0 .. v5}, Lio/branch/referral/Branch;->getCreditHistory(Ljava/lang/String;Ljava/lang/String;ILio/branch/referral/Branch$CreditHistoryOrder;Lio/branch/referral/Branch$BranchListResponseListener;)V

    .line 1584
    return-void
.end method

.method public getCreditHistory(Ljava/lang/String;ILio/branch/referral/Branch$CreditHistoryOrder;Lio/branch/referral/Branch$BranchListResponseListener;)V
    .locals 6
    .param p1, "afterId"    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p2, "length"    # I
    .param p3, "order"    # Lio/branch/referral/Branch$CreditHistoryOrder;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p4, "callback"    # Lio/branch/referral/Branch$BranchListResponseListener;

    .prologue
    .line 1621
    const/4 v1, 0x0

    move-object v0, p0

    move-object v2, p1

    move v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-virtual/range {v0 .. v5}, Lio/branch/referral/Branch;->getCreditHistory(Ljava/lang/String;Ljava/lang/String;ILio/branch/referral/Branch$CreditHistoryOrder;Lio/branch/referral/Branch$BranchListResponseListener;)V

    .line 1622
    return-void
.end method

.method public getCreditHistory(Ljava/lang/String;Lio/branch/referral/Branch$BranchListResponseListener;)V
    .locals 6
    .param p1, "bucket"    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p2, "callback"    # Lio/branch/referral/Branch$BranchListResponseListener;

    .prologue
    .line 1596
    const/4 v2, 0x0

    const/16 v3, 0x64

    sget-object v4, Lio/branch/referral/Branch$CreditHistoryOrder;->kMostRecentFirst:Lio/branch/referral/Branch$CreditHistoryOrder;

    move-object v0, p0

    move-object v1, p1

    move-object v5, p2

    invoke-virtual/range {v0 .. v5}, Lio/branch/referral/Branch;->getCreditHistory(Ljava/lang/String;Ljava/lang/String;ILio/branch/referral/Branch$CreditHistoryOrder;Lio/branch/referral/Branch$BranchListResponseListener;)V

    .line 1597
    return-void
.end method

.method public getCreditHistory(Ljava/lang/String;Ljava/lang/String;ILio/branch/referral/Branch$CreditHistoryOrder;Lio/branch/referral/Branch$BranchListResponseListener;)V
    .locals 7
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "afterId"    # Ljava/lang/String;
    .param p3, "length"    # I
    .param p4, "order"    # Lio/branch/referral/Branch$CreditHistoryOrder;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p5, "callback"    # Lio/branch/referral/Branch$BranchListResponseListener;

    .prologue
    .line 1648
    new-instance v0, Lio/branch/referral/ServerRequestGetRewardHistory;

    iget-object v1, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    move-object v2, p1

    move-object v3, p2

    move v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lio/branch/referral/ServerRequestGetRewardHistory;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILio/branch/referral/Branch$CreditHistoryOrder;Lio/branch/referral/Branch$BranchListResponseListener;)V

    .line 1649
    .local v0, "req":Lio/branch/referral/ServerRequest;
    iget-boolean v1, v0, Lio/branch/referral/ServerRequest;->constructError_:Z

    if-nez v1, :cond_0

    iget-object v1, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lio/branch/referral/ServerRequest;->handleErrors(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1650
    invoke-direct {p0, v0}, Lio/branch/referral/Branch;->handleNewRequest(Lio/branch/referral/ServerRequest;)V

    .line 1652
    :cond_0
    return-void
.end method

.method public getCredits()I
    .locals 1

    .prologue
    .line 1470
    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getCreditCount()I

    move-result v0

    return v0
.end method

.method public getCreditsForBucket(Ljava/lang/String;)I
    .locals 1
    .param p1, "bucket"    # Ljava/lang/String;

    .prologue
    .line 1482
    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0, p1}, Lio/branch/referral/PrefHelper;->getCreditCount(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public getFirstReferringParams()Lorg/json/JSONObject;
    .locals 2

    .prologue
    .line 1695
    iget-object v1, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v1}, Lio/branch/referral/PrefHelper;->getInstallParams()Ljava/lang/String;

    move-result-object v0

    .line 1696
    .local v0, "storedParam":Ljava/lang/String;
    invoke-direct {p0, v0}, Lio/branch/referral/Branch;->convertParamsStringToDictionary(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    return-object v1
.end method

.method public getLatestReferringParams()Lorg/json/JSONObject;
    .locals 2

    .prologue
    .line 1710
    iget-object v1, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v1}, Lio/branch/referral/PrefHelper;->getSessionParams()Ljava/lang/String;

    move-result-object v0

    .line 1711
    .local v0, "storedParam":Ljava/lang/String;
    invoke-direct {p0, v0}, Lio/branch/referral/Branch;->convertParamsStringToDictionary(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    return-object v1
.end method

.method public getReferralCode(ILio/branch/referral/Branch$BranchReferralInitListener;)V
    .locals 8
    .param p1, "amount"    # I
    .param p2, "callback"    # Lio/branch/referral/Branch$BranchReferralInitListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 2531
    const-string v4, "default"

    const/4 v5, 0x1

    const/4 v6, 0x2

    move-object v0, p0

    move v2, p1

    move-object v3, v1

    move-object v7, p2

    invoke-virtual/range {v0 .. v7}, Lio/branch/referral/Branch;->getReferralCode(Ljava/lang/String;ILjava/util/Date;Ljava/lang/String;IILio/branch/referral/Branch$BranchReferralInitListener;)V

    .line 2532
    return-void
.end method

.method public getReferralCode(ILjava/util/Date;Lio/branch/referral/Branch$BranchReferralInitListener;)V
    .locals 8
    .param p1, "amount"    # I
    .param p2, "expiration"    # Ljava/util/Date;
    .param p3, "callback"    # Lio/branch/referral/Branch$BranchReferralInitListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 2564
    const/4 v1, 0x0

    const-string v4, "default"

    const/4 v5, 0x1

    const/4 v6, 0x2

    move-object v0, p0

    move v2, p1

    move-object v3, p2

    move-object v7, p3

    invoke-virtual/range {v0 .. v7}, Lio/branch/referral/Branch;->getReferralCode(Ljava/lang/String;ILjava/util/Date;Ljava/lang/String;IILio/branch/referral/Branch$BranchReferralInitListener;)V

    .line 2565
    return-void
.end method

.method public getReferralCode(Lio/branch/referral/Branch$BranchReferralInitListener;)V
    .locals 2
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchReferralInitListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 2514
    new-instance v0, Lio/branch/referral/ServerRequestGetReferralCode;

    iget-object v1, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    invoke-direct {v0, v1, p1}, Lio/branch/referral/ServerRequestGetReferralCode;-><init>(Landroid/content/Context;Lio/branch/referral/Branch$BranchReferralInitListener;)V

    .line 2515
    .local v0, "req":Lio/branch/referral/ServerRequest;
    iget-boolean v1, v0, Lio/branch/referral/ServerRequest;->constructError_:Z

    if-nez v1, :cond_0

    iget-object v1, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lio/branch/referral/ServerRequest;->handleErrors(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 2516
    invoke-direct {p0, v0}, Lio/branch/referral/Branch;->handleNewRequest(Lio/branch/referral/ServerRequest;)V

    .line 2518
    :cond_0
    return-void
.end method

.method public getReferralCode(Ljava/lang/String;IIILio/branch/referral/Branch$BranchReferralInitListener;)V
    .locals 8
    .param p1, "prefix"    # Ljava/lang/String;
    .param p2, "amount"    # I
    .param p3, "calculationType"    # I
    .param p4, "location"    # I
    .param p5, "callback"    # Lio/branch/referral/Branch$BranchReferralInitListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 2613
    const/4 v3, 0x0

    const-string v4, "default"

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move v5, p3

    move v6, p4

    move-object v7, p5

    invoke-virtual/range {v0 .. v7}, Lio/branch/referral/Branch;->getReferralCode(Ljava/lang/String;ILjava/util/Date;Ljava/lang/String;IILio/branch/referral/Branch$BranchReferralInitListener;)V

    .line 2614
    return-void
.end method

.method public getReferralCode(Ljava/lang/String;ILio/branch/referral/Branch$BranchReferralInitListener;)V
    .locals 8
    .param p1, "prefix"    # Ljava/lang/String;
    .param p2, "amount"    # I
    .param p3, "callback"    # Lio/branch/referral/Branch$BranchReferralInitListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 2548
    const/4 v3, 0x0

    const-string v4, "default"

    const/4 v5, 0x1

    const/4 v6, 0x2

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-object v7, p3

    invoke-virtual/range {v0 .. v7}, Lio/branch/referral/Branch;->getReferralCode(Ljava/lang/String;ILjava/util/Date;Ljava/lang/String;IILio/branch/referral/Branch$BranchReferralInitListener;)V

    .line 2549
    return-void
.end method

.method public getReferralCode(Ljava/lang/String;ILjava/util/Date;Lio/branch/referral/Branch$BranchReferralInitListener;)V
    .locals 8
    .param p1, "prefix"    # Ljava/lang/String;
    .param p2, "amount"    # I
    .param p3, "expiration"    # Ljava/util/Date;
    .param p4, "callback"    # Lio/branch/referral/Branch$BranchReferralInitListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 2583
    const-string v4, "default"

    const/4 v5, 0x1

    const/4 v6, 0x2

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    move-object v7, p4

    invoke-virtual/range {v0 .. v7}, Lio/branch/referral/Branch;->getReferralCode(Ljava/lang/String;ILjava/util/Date;Ljava/lang/String;IILio/branch/referral/Branch$BranchReferralInitListener;)V

    .line 2584
    return-void
.end method

.method public getReferralCode(Ljava/lang/String;ILjava/util/Date;Ljava/lang/String;IILio/branch/referral/Branch$BranchReferralInitListener;)V
    .locals 9
    .param p1, "prefix"    # Ljava/lang/String;
    .param p2, "amount"    # I
    .param p3, "expiration"    # Ljava/util/Date;
    .param p4, "bucket"    # Ljava/lang/String;
    .param p5, "calculationType"    # I
    .param p6, "location"    # I
    .param p7, "callback"    # Lio/branch/referral/Branch$BranchReferralInitListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 2645
    const/4 v4, 0x0

    .line 2646
    .local v4, "date":Ljava/lang/String;
    if-eqz p3, :cond_0

    .line 2647
    invoke-direct {p0, p3}, Lio/branch/referral/Branch;->convertDate(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v4

    .line 2648
    :cond_0
    new-instance v0, Lio/branch/referral/ServerRequestGetReferralCode;

    iget-object v1, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    move-object v2, p1

    move v3, p2

    move-object v5, p4

    move v6, p5

    move v7, p6

    move-object/from16 v8, p7

    invoke-direct/range {v0 .. v8}, Lio/branch/referral/ServerRequestGetReferralCode;-><init>(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IILio/branch/referral/Branch$BranchReferralInitListener;)V

    .line 2650
    .local v0, "req":Lio/branch/referral/ServerRequest;
    iget-boolean v1, v0, Lio/branch/referral/ServerRequest;->constructError_:Z

    if-nez v1, :cond_1

    iget-object v1, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lio/branch/referral/ServerRequest;->handleErrors(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 2651
    invoke-direct {p0, v0}, Lio/branch/referral/Branch;->handleNewRequest(Lio/branch/referral/ServerRequest;)V

    .line 2653
    :cond_1
    return-void
.end method

.method public getReferralUrl(Ljava/lang/String;Lorg/json/JSONObject;Lio/branch/referral/Branch$BranchLinkCreateListener;)V
    .locals 11
    .param p1, "channel"    # Ljava/lang/String;
    .param p2, "params"    # Lorg/json/JSONObject;
    .param p3, "callback"    # Lio/branch/referral/Branch$BranchLinkCreateListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 2355
    const-string v6, "referral"

    invoke-static {p2}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    const/4 v10, 0x1

    move-object v0, p0

    move v3, v2

    move-object v4, v1

    move-object v5, p1

    move-object v7, v1

    move-object v9, p3

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    .line 2356
    return-void
.end method

.method public getReferralUrl(Ljava/util/Collection;Ljava/lang/String;Lorg/json/JSONObject;Lio/branch/referral/Branch$BranchLinkCreateListener;)V
    .locals 11
    .param p2, "channel"    # Ljava/lang/String;
    .param p3, "params"    # Lorg/json/JSONObject;
    .param p4, "callback"    # Lio/branch/referral/Branch$BranchLinkCreateListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Lorg/json/JSONObject;",
            "Lio/branch/referral/Branch$BranchLinkCreateListener;",
            ")V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .local p1, "tags":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 2379
    const-string v6, "referral"

    invoke-static {p3}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    const/4 v10, 0x1

    move-object v0, p0

    move v3, v2

    move-object v4, p1

    move-object v5, p2

    move-object v7, v1

    move-object v9, p4

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    .line 2380
    return-void
.end method

.method public getReferralUrlSync(Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;
    .locals 11
    .param p1, "channel"    # Ljava/lang/String;
    .param p2, "params"    # Lorg/json/JSONObject;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 2396
    const-string v6, "referral"

    invoke-static {p2}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    move-object v0, p0

    move v3, v2

    move-object v4, v1

    move-object v5, p1

    move-object v7, v1

    move-object v9, v1

    move v10, v2

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getReferralUrlSync(Ljava/util/Collection;Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;
    .locals 11
    .param p2, "channel"    # Ljava/lang/String;
    .param p3, "params"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Lorg/json/JSONObject;",
            ")",
            "Ljava/lang/String;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .local p1, "tags":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 2415
    const-string v6, "referral"

    invoke-static {p3}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    move-object v0, p0

    move v3, v2

    move-object v4, p1

    move-object v5, p2

    move-object v7, v1

    move-object v9, v1

    move v10, v2

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getShortUrl(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lio/branch/referral/Branch$BranchLinkCreateListener;)V
    .locals 11
    .param p1, "type"    # I
    .param p2, "channel"    # Ljava/lang/String;
    .param p3, "feature"    # Ljava/lang/String;
    .param p4, "stage"    # Ljava/lang/String;
    .param p5, "params"    # Lorg/json/JSONObject;
    .param p6, "callback"    # Lio/branch/referral/Branch$BranchLinkCreateListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 2079
    const/4 v1, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-static/range {p5 .. p5}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    const/4 v10, 0x1

    move-object v0, p0

    move v2, p1

    move-object v5, p2

    move-object v6, p3

    move-object v7, p4

    move-object/from16 v9, p6

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    .line 2080
    return-void
.end method

.method public getShortUrl(ILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lio/branch/referral/Branch$BranchLinkCreateListener;)V
    .locals 11
    .param p1, "type"    # I
    .param p3, "channel"    # Ljava/lang/String;
    .param p4, "feature"    # Ljava/lang/String;
    .param p5, "stage"    # Ljava/lang/String;
    .param p6, "params"    # Lorg/json/JSONObject;
    .param p7, "callback"    # Lio/branch/referral/Branch$BranchLinkCreateListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lorg/json/JSONObject;",
            "Lio/branch/referral/Branch$BranchLinkCreateListener;",
            ")V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 2212
    .local p2, "tags":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    const/4 v1, 0x0

    const/4 v3, 0x0

    invoke-static/range {p6 .. p6}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    const/4 v10, 0x1

    move-object v0, p0

    move v2, p1

    move-object v4, p2

    move-object v5, p3

    move-object v6, p4

    move-object/from16 v7, p5

    move-object/from16 v9, p7

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    .line 2213
    return-void
.end method

.method public getShortUrl(Lio/branch/referral/Branch$BranchLinkCreateListener;)V
    .locals 11
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchLinkCreateListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 1964
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    invoke-static {v0}, Lio/branch/referral/BranchUtil;->stringifyAndAddSource(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    const/4 v10, 0x1

    move-object v0, p0

    move v3, v2

    move-object v4, v1

    move-object v5, v1

    move-object v6, v1

    move-object v7, v1

    move-object v9, p1

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    .line 1965
    return-void
.end method

.method public getShortUrl(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lio/branch/referral/Branch$BranchLinkCreateListener;)V
    .locals 11
    .param p1, "alias"    # Ljava/lang/String;
    .param p2, "channel"    # Ljava/lang/String;
    .param p3, "feature"    # Ljava/lang/String;
    .param p4, "stage"    # Ljava/lang/String;
    .param p5, "params"    # Lorg/json/JSONObject;
    .param p6, "callback"    # Lio/branch/referral/Branch$BranchLinkCreateListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 2048
    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-static/range {p5 .. p5}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    const/4 v10, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v5, p2

    move-object v6, p3

    move-object v7, p4

    move-object/from16 v9, p6

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    .line 2049
    return-void
.end method

.method public getShortUrl(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;ILio/branch/referral/Branch$BranchLinkCreateListener;)V
    .locals 11
    .param p1, "channel"    # Ljava/lang/String;
    .param p2, "feature"    # Ljava/lang/String;
    .param p3, "stage"    # Ljava/lang/String;
    .param p4, "params"    # Lorg/json/JSONObject;
    .param p5, "duration"    # I
    .param p6, "callback"    # Lio/branch/referral/Branch$BranchLinkCreateListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 2110
    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v4, 0x0

    invoke-static {p4}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    const/4 v10, 0x1

    move-object v0, p0

    move/from16 v3, p5

    move-object v5, p1

    move-object v6, p2

    move-object v7, p3

    move-object/from16 v9, p6

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    .line 2111
    return-void
.end method

.method public getShortUrl(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lio/branch/referral/Branch$BranchLinkCreateListener;)V
    .locals 11
    .param p1, "channel"    # Ljava/lang/String;
    .param p2, "feature"    # Ljava/lang/String;
    .param p3, "stage"    # Ljava/lang/String;
    .param p4, "params"    # Lorg/json/JSONObject;
    .param p5, "callback"    # Lio/branch/referral/Branch$BranchLinkCreateListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 2012
    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-static {p4}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    const/4 v10, 0x1

    move-object v0, p0

    move-object v5, p1

    move-object v6, p2

    move-object v7, p3

    move-object/from16 v9, p5

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    .line 2013
    return-void
.end method

.method public getShortUrl(Ljava/lang/String;Ljava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lio/branch/referral/Branch$BranchLinkCreateListener;)V
    .locals 11
    .param p1, "alias"    # Ljava/lang/String;
    .param p3, "channel"    # Ljava/lang/String;
    .param p4, "feature"    # Ljava/lang/String;
    .param p5, "stage"    # Ljava/lang/String;
    .param p6, "params"    # Lorg/json/JSONObject;
    .param p7, "callback"    # Lio/branch/referral/Branch$BranchLinkCreateListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lorg/json/JSONObject;",
            "Lio/branch/referral/Branch$BranchLinkCreateListener;",
            ")V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 2178
    .local p2, "tags":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-static/range {p6 .. p6}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    const/4 v10, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v4, p2

    move-object v5, p3

    move-object v6, p4

    move-object/from16 v7, p5

    move-object/from16 v9, p7

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    .line 2179
    return-void
.end method

.method public getShortUrl(Ljava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;ILio/branch/referral/Branch$BranchLinkCreateListener;)V
    .locals 11
    .param p2, "channel"    # Ljava/lang/String;
    .param p3, "feature"    # Ljava/lang/String;
    .param p4, "stage"    # Ljava/lang/String;
    .param p5, "params"    # Lorg/json/JSONObject;
    .param p6, "duration"    # I
    .param p7, "callback"    # Lio/branch/referral/Branch$BranchLinkCreateListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lorg/json/JSONObject;",
            "I",
            "Lio/branch/referral/Branch$BranchLinkCreateListener;",
            ")V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 2246
    .local p1, "tags":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-static/range {p5 .. p5}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    const/4 v10, 0x1

    move-object v0, p0

    move/from16 v3, p6

    move-object v4, p1

    move-object v5, p2

    move-object v6, p3

    move-object v7, p4

    move-object/from16 v9, p7

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    .line 2247
    return-void
.end method

.method public getShortUrl(Ljava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lio/branch/referral/Branch$BranchLinkCreateListener;)V
    .locals 11
    .param p2, "channel"    # Ljava/lang/String;
    .param p3, "feature"    # Ljava/lang/String;
    .param p4, "stage"    # Ljava/lang/String;
    .param p5, "params"    # Lorg/json/JSONObject;
    .param p6, "callback"    # Lio/branch/referral/Branch$BranchLinkCreateListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lorg/json/JSONObject;",
            "Lio/branch/referral/Branch$BranchLinkCreateListener;",
            ")V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 2141
    .local p1, "tags":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-static/range {p5 .. p5}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    const/4 v10, 0x1

    move-object v0, p0

    move-object v4, p1

    move-object v5, p2

    move-object v6, p3

    move-object v7, p4

    move-object/from16 v9, p6

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    .line 2142
    return-void
.end method

.method public getShortUrl(Lorg/json/JSONObject;Lio/branch/referral/Branch$BranchLinkCreateListener;)V
    .locals 11
    .param p1, "params"    # Lorg/json/JSONObject;
    .param p2, "callback"    # Lio/branch/referral/Branch$BranchLinkCreateListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 1983
    invoke-static {p1}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    const/4 v10, 0x1

    move-object v0, p0

    move v3, v2

    move-object v4, v1

    move-object v5, v1

    move-object v6, v1

    move-object v7, v1

    move-object v9, p2

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    .line 1984
    return-void
.end method

.method public getShortUrlSync()Ljava/lang/String;
    .locals 11
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 1728
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    invoke-static {v0}, Lio/branch/referral/BranchUtil;->stringifyAndAddSource(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    move-object v0, p0

    move v3, v2

    move-object v4, v1

    move-object v5, v1

    move-object v6, v1

    move-object v7, v1

    move-object v9, v1

    move v10, v2

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getShortUrlSync(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;
    .locals 11
    .param p1, "type"    # I
    .param p2, "channel"    # Ljava/lang/String;
    .param p3, "feature"    # Ljava/lang/String;
    .param p4, "stage"    # Ljava/lang/String;
    .param p5, "params"    # Lorg/json/JSONObject;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1819
    const/4 v1, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-static/range {p5 .. p5}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x0

    const/4 v10, 0x0

    move-object v0, p0

    move v2, p1

    move-object v5, p2

    move-object v6, p3

    move-object v7, p4

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getShortUrlSync(ILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;
    .locals 11
    .param p1, "type"    # I
    .param p3, "channel"    # Ljava/lang/String;
    .param p4, "feature"    # Ljava/lang/String;
    .param p5, "stage"    # Ljava/lang/String;
    .param p6, "params"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lorg/json/JSONObject;",
            ")",
            "Ljava/lang/String;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1924
    .local p2, "tags":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    const/4 v1, 0x0

    const/4 v3, 0x0

    invoke-static/range {p6 .. p6}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x0

    const/4 v10, 0x0

    move-object v0, p0

    move v2, p1

    move-object v4, p2

    move-object v5, p3

    move-object v6, p4

    move-object/from16 v7, p5

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getShortUrlSync(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;
    .locals 11
    .param p1, "alias"    # Ljava/lang/String;
    .param p2, "channel"    # Ljava/lang/String;
    .param p3, "feature"    # Ljava/lang/String;
    .param p4, "stage"    # Ljava/lang/String;
    .param p5, "params"    # Lorg/json/JSONObject;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1795
    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-static/range {p5 .. p5}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x0

    const/4 v10, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v5, p2

    move-object v6, p3

    move-object v7, p4

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getShortUrlSync(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;
    .locals 11
    .param p1, "channel"    # Ljava/lang/String;
    .param p2, "feature"    # Ljava/lang/String;
    .param p3, "stage"    # Ljava/lang/String;
    .param p4, "params"    # Lorg/json/JSONObject;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 1766
    invoke-static {p4}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    move-object v0, p0

    move v3, v2

    move-object v4, v1

    move-object v5, p1

    move-object v6, p2

    move-object v7, p3

    move-object v9, v1

    move v10, v2

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getShortUrlSync(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;I)Ljava/lang/String;
    .locals 11
    .param p1, "channel"    # Ljava/lang/String;
    .param p2, "feature"    # Ljava/lang/String;
    .param p3, "stage"    # Ljava/lang/String;
    .param p4, "params"    # Lorg/json/JSONObject;
    .param p5, "duration"    # I
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1843
    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v4, 0x0

    invoke-static {p4}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x0

    const/4 v10, 0x0

    move-object v0, p0

    move/from16 v3, p5

    move-object v5, p1

    move-object v6, p2

    move-object v7, p3

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getShortUrlSync(Ljava/lang/String;Ljava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;
    .locals 11
    .param p1, "alias"    # Ljava/lang/String;
    .param p3, "channel"    # Ljava/lang/String;
    .param p4, "feature"    # Ljava/lang/String;
    .param p5, "stage"    # Ljava/lang/String;
    .param p6, "params"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lorg/json/JSONObject;",
            ")",
            "Ljava/lang/String;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1898
    .local p2, "tags":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-static/range {p6 .. p6}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x0

    const/4 v10, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v4, p2

    move-object v5, p3

    move-object v6, p4

    move-object/from16 v7, p5

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getShortUrlSync(Ljava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;
    .locals 11
    .param p2, "channel"    # Ljava/lang/String;
    .param p3, "feature"    # Ljava/lang/String;
    .param p4, "stage"    # Ljava/lang/String;
    .param p5, "params"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lorg/json/JSONObject;",
            ")",
            "Ljava/lang/String;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1867
    .local p1, "tags":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-static/range {p5 .. p5}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x0

    const/4 v10, 0x0

    move-object v0, p0

    move-object v4, p1

    move-object v5, p2

    move-object v6, p3

    move-object v7, p4

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getShortUrlSync(Ljava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;I)Ljava/lang/String;
    .locals 11
    .param p2, "channel"    # Ljava/lang/String;
    .param p3, "feature"    # Ljava/lang/String;
    .param p4, "stage"    # Ljava/lang/String;
    .param p5, "params"    # Lorg/json/JSONObject;
    .param p6, "duration"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lorg/json/JSONObject;",
            "I)",
            "Ljava/lang/String;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1950
    .local p1, "tags":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-static/range {p5 .. p5}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x0

    const/4 v10, 0x0

    move-object v0, p0

    move/from16 v3, p6

    move-object v4, p1

    move-object v5, p2

    move-object v6, p3

    move-object v7, p4

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getShortUrlSync(Lorg/json/JSONObject;)Ljava/lang/String;
    .locals 11
    .param p1, "params"    # Lorg/json/JSONObject;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 1744
    invoke-static {p1}, Lio/branch/referral/BranchUtil;->formatAndStringifyLinkParam(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v8

    move-object v0, p0

    move v3, v2

    move-object v4, v1

    move-object v5, v1

    move-object v6, v1

    move-object v7, v1

    move-object v9, v1

    move v10, v2

    invoke-direct/range {v0 .. v10}, Lio/branch/referral/Branch;->generateShortLink(Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTotalCountsForAction(Ljava/lang/String;)I
    .locals 1
    .param p1, "action"    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1497
    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0, p1}, Lio/branch/referral/PrefHelper;->getActionTotalCount(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public getUniqueCountsForAction(Ljava/lang/String;)I
    .locals 1
    .param p1, "action"    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1512
    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0, p1}, Lio/branch/referral/PrefHelper;->getActionUniqueCount(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public initSession()Z
    .locals 1

    .prologue
    .line 836
    const/4 v0, 0x0

    check-cast v0, Landroid/app/Activity;

    invoke-virtual {p0, v0}, Lio/branch/referral/Branch;->initSession(Landroid/app/Activity;)Z

    move-result v0

    return v0
.end method

.method public initSession(Landroid/app/Activity;)Z
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 846
    const/4 v0, 0x0

    check-cast v0, Lio/branch/referral/Branch$BranchReferralInitListener;

    invoke-virtual {p0, v0, p1}, Lio/branch/referral/Branch;->initSession(Lio/branch/referral/Branch$BranchReferralInitListener;Landroid/app/Activity;)Z

    move-result v0

    return v0
.end method

.method public initSession(Lio/branch/referral/Branch$BranchReferralInitListener;)Z
    .locals 1
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchReferralInitListener;

    .prologue
    .line 714
    const/4 v0, 0x0

    check-cast v0, Landroid/app/Activity;

    invoke-virtual {p0, p1, v0}, Lio/branch/referral/Branch;->initSession(Lio/branch/referral/Branch$BranchReferralInitListener;Landroid/app/Activity;)Z

    .line 715
    const/4 v0, 0x0

    return v0
.end method

.method public initSession(Lio/branch/referral/Branch$BranchReferralInitListener;Landroid/app/Activity;)Z
    .locals 4
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchReferralInitListener;
    .param p2, "activity"    # Landroid/app/Activity;

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 751
    sget-object v2, Lio/branch/referral/Branch;->customReferrableSettings_:Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;

    sget-object v3, Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;->USE_DEFAULT:Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;

    if-ne v2, v3, :cond_0

    .line 752
    invoke-direct {p0, p1, p2, v0}, Lio/branch/referral/Branch;->initUserSessionInternal(Lio/branch/referral/Branch$BranchReferralInitListener;Landroid/app/Activity;Z)V

    .line 757
    :goto_0
    return v1

    .line 754
    :cond_0
    sget-object v2, Lio/branch/referral/Branch;->customReferrableSettings_:Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;

    sget-object v3, Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;->REFERRABLE:Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;

    if-ne v2, v3, :cond_1

    .line 755
    .local v0, "isReferrable":Z
    :goto_1
    invoke-direct {p0, p1, p2, v0}, Lio/branch/referral/Branch;->initUserSessionInternal(Lio/branch/referral/Branch$BranchReferralInitListener;Landroid/app/Activity;Z)V

    goto :goto_0

    .end local v0    # "isReferrable":Z
    :cond_1
    move v0, v1

    .line 754
    goto :goto_1
.end method

.method public initSession(Lio/branch/referral/Branch$BranchReferralInitListener;Landroid/net/Uri;)Z
    .locals 1
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchReferralInitListener;
    .param p2, "data"    # Landroid/net/Uri;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .prologue
    .line 789
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Lio/branch/referral/Branch;->initSession(Lio/branch/referral/Branch$BranchReferralInitListener;Landroid/net/Uri;Landroid/app/Activity;)Z

    move-result v0

    return v0
.end method

.method public initSession(Lio/branch/referral/Branch$BranchReferralInitListener;Landroid/net/Uri;Landroid/app/Activity;)Z
    .locals 1
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchReferralInitListener;
    .param p2, "data"    # Landroid/net/Uri;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p3, "activity"    # Landroid/app/Activity;

    .prologue
    .line 825
    invoke-direct {p0, p2, p3}, Lio/branch/referral/Branch;->readAndStripParam(Landroid/net/Uri;Landroid/app/Activity;)Z

    move-result v0

    .line 826
    .local v0, "uriHandled":Z
    invoke-virtual {p0, p1, p3}, Lio/branch/referral/Branch;->initSession(Lio/branch/referral/Branch$BranchReferralInitListener;Landroid/app/Activity;)Z

    .line 827
    return v0
.end method

.method public initSession(Lio/branch/referral/Branch$BranchReferralInitListener;Z)Z
    .locals 1
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchReferralInitListener;
    .param p2, "isReferrable"    # Z

    .prologue
    .line 1013
    const/4 v0, 0x0

    check-cast v0, Landroid/app/Activity;

    invoke-virtual {p0, p1, p2, v0}, Lio/branch/referral/Branch;->initSession(Lio/branch/referral/Branch$BranchReferralInitListener;ZLandroid/app/Activity;)Z

    move-result v0

    return v0
.end method

.method public initSession(Lio/branch/referral/Branch$BranchReferralInitListener;ZLandroid/app/Activity;)Z
    .locals 1
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchReferralInitListener;
    .param p2, "isReferrable"    # Z
    .param p3, "activity"    # Landroid/app/Activity;

    .prologue
    .line 1048
    invoke-direct {p0, p1, p3, p2}, Lio/branch/referral/Branch;->initUserSessionInternal(Lio/branch/referral/Branch$BranchReferralInitListener;Landroid/app/Activity;Z)V

    .line 1049
    const/4 v0, 0x0

    return v0
.end method

.method public initSession(Lio/branch/referral/Branch$BranchReferralInitListener;ZLandroid/net/Uri;)Z
    .locals 1
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchReferralInitListener;
    .param p2, "isReferrable"    # Z
    .param p3, "data"    # Landroid/net/Uri;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .prologue
    .line 939
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, p3, v0}, Lio/branch/referral/Branch;->initSession(Lio/branch/referral/Branch$BranchReferralInitListener;ZLandroid/net/Uri;Landroid/app/Activity;)Z

    move-result v0

    return v0
.end method

.method public initSession(Lio/branch/referral/Branch$BranchReferralInitListener;ZLandroid/net/Uri;Landroid/app/Activity;)Z
    .locals 1
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchReferralInitListener;
    .param p2, "isReferrable"    # Z
    .param p3, "data"    # Landroid/net/Uri;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p4, "activity"    # Landroid/app/Activity;

    .prologue
    .line 979
    invoke-direct {p0, p3, p4}, Lio/branch/referral/Branch;->readAndStripParam(Landroid/net/Uri;Landroid/app/Activity;)Z

    move-result v0

    .line 980
    .local v0, "uriHandled":Z
    invoke-virtual {p0, p1, p2, p4}, Lio/branch/referral/Branch;->initSession(Lio/branch/referral/Branch$BranchReferralInitListener;ZLandroid/app/Activity;)Z

    .line 981
    return v0
.end method

.method public initSession(Lio/branch/referral/Branch$BranchUniversalReferralInitListener;)Z
    .locals 1
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchUniversalReferralInitListener;

    .prologue
    .line 700
    const/4 v0, 0x0

    check-cast v0, Landroid/app/Activity;

    invoke-virtual {p0, p1, v0}, Lio/branch/referral/Branch;->initSession(Lio/branch/referral/Branch$BranchUniversalReferralInitListener;Landroid/app/Activity;)Z

    .line 701
    const/4 v0, 0x0

    return v0
.end method

.method public initSession(Lio/branch/referral/Branch$BranchUniversalReferralInitListener;Landroid/app/Activity;)Z
    .locals 4
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchUniversalReferralInitListener;
    .param p2, "activity"    # Landroid/app/Activity;

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 730
    sget-object v2, Lio/branch/referral/Branch;->customReferrableSettings_:Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;

    sget-object v3, Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;->USE_DEFAULT:Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;

    if-ne v2, v3, :cond_0

    .line 731
    invoke-direct {p0, p1, p2, v0}, Lio/branch/referral/Branch;->initUserSessionInternal(Lio/branch/referral/Branch$BranchUniversalReferralInitListener;Landroid/app/Activity;Z)V

    .line 736
    :goto_0
    return v1

    .line 733
    :cond_0
    sget-object v2, Lio/branch/referral/Branch;->customReferrableSettings_:Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;

    sget-object v3, Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;->REFERRABLE:Lio/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS;

    if-ne v2, v3, :cond_1

    .line 734
    .local v0, "isReferrable":Z
    :goto_1
    invoke-direct {p0, p1, p2, v0}, Lio/branch/referral/Branch;->initUserSessionInternal(Lio/branch/referral/Branch$BranchUniversalReferralInitListener;Landroid/app/Activity;Z)V

    goto :goto_0

    .end local v0    # "isReferrable":Z
    :cond_1
    move v0, v1

    .line 733
    goto :goto_1
.end method

.method public initSession(Lio/branch/referral/Branch$BranchUniversalReferralInitListener;Landroid/net/Uri;)Z
    .locals 1
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchUniversalReferralInitListener;
    .param p2, "data"    # Landroid/net/Uri;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .prologue
    .line 773
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Lio/branch/referral/Branch;->initSession(Lio/branch/referral/Branch$BranchUniversalReferralInitListener;Landroid/net/Uri;Landroid/app/Activity;)Z

    move-result v0

    return v0
.end method

.method public initSession(Lio/branch/referral/Branch$BranchUniversalReferralInitListener;Landroid/net/Uri;Landroid/app/Activity;)Z
    .locals 1
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchUniversalReferralInitListener;
    .param p2, "data"    # Landroid/net/Uri;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p3, "activity"    # Landroid/app/Activity;

    .prologue
    .line 806
    invoke-direct {p0, p2, p3}, Lio/branch/referral/Branch;->readAndStripParam(Landroid/net/Uri;Landroid/app/Activity;)Z

    move-result v0

    .line 807
    .local v0, "uriHandled":Z
    invoke-virtual {p0, p1, p3}, Lio/branch/referral/Branch;->initSession(Lio/branch/referral/Branch$BranchUniversalReferralInitListener;Landroid/app/Activity;)Z

    .line 808
    return v0
.end method

.method public initSession(Lio/branch/referral/Branch$BranchUniversalReferralInitListener;Z)Z
    .locals 1
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchUniversalReferralInitListener;
    .param p2, "isReferrable"    # Z

    .prologue
    .line 997
    const/4 v0, 0x0

    check-cast v0, Landroid/app/Activity;

    invoke-virtual {p0, p1, p2, v0}, Lio/branch/referral/Branch;->initSession(Lio/branch/referral/Branch$BranchUniversalReferralInitListener;ZLandroid/app/Activity;)Z

    move-result v0

    return v0
.end method

.method public initSession(Lio/branch/referral/Branch$BranchUniversalReferralInitListener;ZLandroid/app/Activity;)Z
    .locals 1
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchUniversalReferralInitListener;
    .param p2, "isReferrable"    # Z
    .param p3, "activity"    # Landroid/app/Activity;

    .prologue
    .line 1030
    invoke-direct {p0, p1, p3, p2}, Lio/branch/referral/Branch;->initUserSessionInternal(Lio/branch/referral/Branch$BranchUniversalReferralInitListener;Landroid/app/Activity;Z)V

    .line 1031
    const/4 v0, 0x0

    return v0
.end method

.method public initSession(Lio/branch/referral/Branch$BranchUniversalReferralInitListener;ZLandroid/net/Uri;)Z
    .locals 1
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchUniversalReferralInitListener;
    .param p2, "isReferrable"    # Z
    .param p3, "data"    # Landroid/net/Uri;

    .prologue
    .line 921
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, p3, v0}, Lio/branch/referral/Branch;->initSession(Lio/branch/referral/Branch$BranchUniversalReferralInitListener;ZLandroid/net/Uri;Landroid/app/Activity;)Z

    move-result v0

    return v0
.end method

.method public initSession(Lio/branch/referral/Branch$BranchUniversalReferralInitListener;ZLandroid/net/Uri;Landroid/app/Activity;)Z
    .locals 1
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchUniversalReferralInitListener;
    .param p2, "isReferrable"    # Z
    .param p3, "data"    # Landroid/net/Uri;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p4, "activity"    # Landroid/app/Activity;

    .prologue
    .line 958
    invoke-direct {p0, p3, p4}, Lio/branch/referral/Branch;->readAndStripParam(Landroid/net/Uri;Landroid/app/Activity;)Z

    move-result v0

    .line 959
    .local v0, "uriHandled":Z
    invoke-virtual {p0, p1, p2, p4}, Lio/branch/referral/Branch;->initSession(Lio/branch/referral/Branch$BranchUniversalReferralInitListener;ZLandroid/app/Activity;)Z

    .line 960
    return v0
.end method

.method public initSession(Z)Z
    .locals 2
    .param p1, "isReferrable"    # Z

    .prologue
    const/4 v1, 0x0

    .line 888
    move-object v0, v1

    check-cast v0, Lio/branch/referral/Branch$BranchReferralInitListener;

    check-cast v1, Landroid/app/Activity;

    invoke-virtual {p0, v0, p1, v1}, Lio/branch/referral/Branch;->initSession(Lio/branch/referral/Branch$BranchReferralInitListener;ZLandroid/app/Activity;)Z

    move-result v0

    return v0
.end method

.method public initSession(ZLandroid/app/Activity;)Z
    .locals 1
    .param p1, "isReferrable"    # Z
    .param p2, "activity"    # Landroid/app/Activity;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .prologue
    .line 903
    const/4 v0, 0x0

    check-cast v0, Lio/branch/referral/Branch$BranchReferralInitListener;

    invoke-virtual {p0, v0, p1, p2}, Lio/branch/referral/Branch;->initSession(Lio/branch/referral/Branch$BranchReferralInitListener;ZLandroid/app/Activity;)Z

    move-result v0

    return v0
.end method

.method public initSessionWithData(Landroid/net/Uri;)Z
    .locals 1
    .param p1, "data"    # Landroid/net/Uri;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .prologue
    .line 859
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lio/branch/referral/Branch;->initSessionWithData(Landroid/net/Uri;Landroid/app/Activity;)Z

    move-result v0

    return v0
.end method

.method public initSessionWithData(Landroid/net/Uri;Landroid/app/Activity;)Z
    .locals 2
    .param p1, "data"    # Landroid/net/Uri;
    .param p2, "activity"    # Landroid/app/Activity;

    .prologue
    .line 872
    invoke-direct {p0, p1, p2}, Lio/branch/referral/Branch;->readAndStripParam(Landroid/net/Uri;Landroid/app/Activity;)Z

    move-result v0

    .line 873
    .local v0, "uriHandled":Z
    const/4 v1, 0x0

    check-cast v1, Lio/branch/referral/Branch$BranchReferralInitListener;

    invoke-virtual {p0, v1, p2}, Lio/branch/referral/Branch;->initSession(Lio/branch/referral/Branch$BranchReferralInitListener;Landroid/app/Activity;)Z

    .line 874
    return v0
.end method

.method public isUserIdentified()Z
    .locals 2

    .prologue
    .line 1383
    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getIdentity()Ljava/lang/String;

    move-result-object v0

    const-string v1, "bnc_no_value"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public loadActionCounts()V
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1419
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lio/branch/referral/Branch;->loadActionCounts(Lio/branch/referral/Branch$BranchReferralStateChangedListener;)V

    .line 1420
    return-void
.end method

.method public loadActionCounts(Lio/branch/referral/Branch$BranchReferralStateChangedListener;)V
    .locals 2
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchReferralStateChangedListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1436
    new-instance v0, Lio/branch/referral/ServerRequestGetReferralCount;

    iget-object v1, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    invoke-direct {v0, v1, p1}, Lio/branch/referral/ServerRequestGetReferralCount;-><init>(Landroid/content/Context;Lio/branch/referral/Branch$BranchReferralStateChangedListener;)V

    .line 1437
    .local v0, "req":Lio/branch/referral/ServerRequest;
    iget-boolean v1, v0, Lio/branch/referral/ServerRequest;->constructError_:Z

    if-nez v1, :cond_0

    iget-object v1, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lio/branch/referral/ServerRequest;->handleErrors(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1438
    invoke-direct {p0, v0}, Lio/branch/referral/Branch;->handleNewRequest(Lio/branch/referral/ServerRequest;)V

    .line 1440
    :cond_0
    return-void
.end method

.method public loadRewards()V
    .locals 1

    .prologue
    .line 1446
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lio/branch/referral/Branch;->loadRewards(Lio/branch/referral/Branch$BranchReferralStateChangedListener;)V

    .line 1447
    return-void
.end method

.method public loadRewards(Lio/branch/referral/Branch$BranchReferralStateChangedListener;)V
    .locals 2
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchReferralStateChangedListener;

    .prologue
    .line 1458
    new-instance v0, Lio/branch/referral/ServerRequestGetRewards;

    iget-object v1, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    invoke-direct {v0, v1, p1}, Lio/branch/referral/ServerRequestGetRewards;-><init>(Landroid/content/Context;Lio/branch/referral/Branch$BranchReferralStateChangedListener;)V

    .line 1459
    .local v0, "req":Lio/branch/referral/ServerRequest;
    iget-boolean v1, v0, Lio/branch/referral/ServerRequest;->constructError_:Z

    if-nez v1, :cond_0

    iget-object v1, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lio/branch/referral/ServerRequest;->handleErrors(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1460
    invoke-direct {p0, v0}, Lio/branch/referral/Branch;->handleNewRequest(Lio/branch/referral/ServerRequest;)V

    .line 1462
    :cond_0
    return-void
.end method

.method public logout()V
    .locals 1

    .prologue
    .line 1392
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lio/branch/referral/Branch;->logout(Lio/branch/referral/Branch$LogoutStatusListener;)V

    .line 1393
    return-void
.end method

.method public logout(Lio/branch/referral/Branch$LogoutStatusListener;)V
    .locals 2
    .param p1, "callback"    # Lio/branch/referral/Branch$LogoutStatusListener;

    .prologue
    .line 1403
    new-instance v0, Lio/branch/referral/ServerRequestLogout;

    iget-object v1, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    invoke-direct {v0, v1, p1}, Lio/branch/referral/ServerRequestLogout;-><init>(Landroid/content/Context;Lio/branch/referral/Branch$LogoutStatusListener;)V

    .line 1404
    .local v0, "req":Lio/branch/referral/ServerRequest;
    iget-boolean v1, v0, Lio/branch/referral/ServerRequest;->constructError_:Z

    if-nez v1, :cond_0

    iget-object v1, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lio/branch/referral/ServerRequest;->handleErrors(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1405
    invoke-direct {p0, v0}, Lio/branch/referral/Branch;->handleNewRequest(Lio/branch/referral/ServerRequest;)V

    .line 1407
    :cond_0
    return-void
.end method

.method public redeemRewards(I)V
    .locals 2
    .param p1, "count"    # I

    .prologue
    .line 1524
    sget-object v0, Lio/branch/referral/Defines$Jsonkey;->DefaultBucket:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v0}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, p1, v1}, Lio/branch/referral/Branch;->redeemRewards(Ljava/lang/String;ILio/branch/referral/Branch$BranchReferralStateChangedListener;)V

    .line 1525
    return-void
.end method

.method public redeemRewards(ILio/branch/referral/Branch$BranchReferralStateChangedListener;)V
    .locals 1
    .param p1, "count"    # I
    .param p2, "callback"    # Lio/branch/referral/Branch$BranchReferralStateChangedListener;

    .prologue
    .line 1538
    sget-object v0, Lio/branch/referral/Defines$Jsonkey;->DefaultBucket:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v0}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1, p2}, Lio/branch/referral/Branch;->redeemRewards(Ljava/lang/String;ILio/branch/referral/Branch$BranchReferralStateChangedListener;)V

    .line 1539
    return-void
.end method

.method public redeemRewards(Ljava/lang/String;I)V
    .locals 1
    .param p1, "bucket"    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p2, "count"    # I

    .prologue
    .line 1552
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Lio/branch/referral/Branch;->redeemRewards(Ljava/lang/String;ILio/branch/referral/Branch$BranchReferralStateChangedListener;)V

    .line 1553
    return-void
.end method

.method public redeemRewards(Ljava/lang/String;ILio/branch/referral/Branch$BranchReferralStateChangedListener;)V
    .locals 2
    .param p1, "bucket"    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p2, "count"    # I
    .param p3, "callback"    # Lio/branch/referral/Branch$BranchReferralStateChangedListener;

    .prologue
    .line 1569
    new-instance v0, Lio/branch/referral/ServerRequestRedeemRewards;

    iget-object v1, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    invoke-direct {v0, v1, p1, p2, p3}, Lio/branch/referral/ServerRequestRedeemRewards;-><init>(Landroid/content/Context;Ljava/lang/String;ILio/branch/referral/Branch$BranchReferralStateChangedListener;)V

    .line 1570
    .local v0, "req":Lio/branch/referral/ServerRequestRedeemRewards;
    iget-boolean v1, v0, Lio/branch/referral/ServerRequestRedeemRewards;->constructError_:Z

    if-nez v1, :cond_0

    iget-object v1, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lio/branch/referral/ServerRequestRedeemRewards;->handleErrors(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1571
    invoke-direct {p0, v0}, Lio/branch/referral/Branch;->handleNewRequest(Lio/branch/referral/ServerRequest;)V

    .line 1573
    :cond_0
    return-void
.end method

.method public registerView(Lio/branch/indexing/BranchUniversalObject;Lio/branch/indexing/BranchUniversalObject$RegisterViewStatusListener;)V
    .locals 3
    .param p1, "branchUniversalObject"    # Lio/branch/indexing/BranchUniversalObject;
    .param p2, "callback"    # Lio/branch/indexing/BranchUniversalObject$RegisterViewStatusListener;

    .prologue
    .line 4064
    new-instance v0, Lio/branch/referral/ServerRequestRegisterView;

    iget-object v1, p0, Lio/branch/referral/Branch;->currentActivity_:Landroid/app/Activity;

    iget-object v2, p0, Lio/branch/referral/Branch;->systemObserver_:Lio/branch/referral/SystemObserver;

    invoke-direct {v0, v1, p1, v2, p2}, Lio/branch/referral/ServerRequestRegisterView;-><init>(Landroid/content/Context;Lio/branch/indexing/BranchUniversalObject;Lio/branch/referral/SystemObserver;Lio/branch/indexing/BranchUniversalObject$RegisterViewStatusListener;)V

    .line 4065
    .local v0, "req":Lio/branch/referral/ServerRequest;
    iget-boolean v1, v0, Lio/branch/referral/ServerRequest;->constructError_:Z

    if-nez v1, :cond_0

    iget-object v1, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lio/branch/referral/ServerRequest;->handleErrors(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 4066
    invoke-direct {p0, v0}, Lio/branch/referral/Branch;->handleNewRequest(Lio/branch/referral/ServerRequest;)V

    .line 4068
    :cond_0
    return-void
.end method

.method public resetUserSession()V
    .locals 1

    .prologue
    .line 604
    sget-object v0, Lio/branch/referral/Branch$SESSION_STATE;->UNINITIALISED:Lio/branch/referral/Branch$SESSION_STATE;

    iput-object v0, p0, Lio/branch/referral/Branch;->initState_:Lio/branch/referral/Branch$SESSION_STATE;

    .line 605
    return-void
.end method

.method public setDebug()V
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 657
    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->setExternDebug()V

    .line 658
    return-void
.end method

.method public setIdentity(Ljava/lang/String;)V
    .locals 1
    .param p1, "userId"    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .prologue
    .line 1352
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lio/branch/referral/Branch;->setIdentity(Ljava/lang/String;Lio/branch/referral/Branch$BranchReferralInitListener;)V

    .line 1353
    return-void
.end method

.method public setIdentity(Ljava/lang/String;Lio/branch/referral/Branch$BranchReferralInitListener;)V
    .locals 2
    .param p1, "userId"    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p2, "callback"    # Lio/branch/referral/Branch$BranchReferralInitListener;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 1365
    new-instance v0, Lio/branch/referral/ServerRequestIdentifyUserRequest;

    iget-object v1, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    invoke-direct {v0, v1, p2, p1}, Lio/branch/referral/ServerRequestIdentifyUserRequest;-><init>(Landroid/content/Context;Lio/branch/referral/Branch$BranchReferralInitListener;Ljava/lang/String;)V

    .line 1366
    .local v0, "req":Lio/branch/referral/ServerRequest;
    iget-boolean v1, v0, Lio/branch/referral/ServerRequest;->constructError_:Z

    if-nez v1, :cond_1

    iget-object v1, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lio/branch/referral/ServerRequest;->handleErrors(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 1367
    invoke-direct {p0, v0}, Lio/branch/referral/Branch;->handleNewRequest(Lio/branch/referral/ServerRequest;)V

    .line 1373
    .end local v0    # "req":Lio/branch/referral/ServerRequest;
    :cond_0
    :goto_0
    return-void

    .restart local v0    # "req":Lio/branch/referral/ServerRequest;
    :cond_1
    move-object v1, v0

    .line 1369
    check-cast v1, Lio/branch/referral/ServerRequestIdentifyUserRequest;

    invoke-virtual {v1}, Lio/branch/referral/ServerRequestIdentifyUserRequest;->isExistingID()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1370
    check-cast v0, Lio/branch/referral/ServerRequestIdentifyUserRequest;

    .end local v0    # "req":Lio/branch/referral/ServerRequest;
    sget-object v1, Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;

    invoke-virtual {v0, v1}, Lio/branch/referral/ServerRequestIdentifyUserRequest;->handleUserExist(Lio/branch/referral/Branch;)V

    goto :goto_0
.end method

.method public setNetworkTimeout(I)V
    .locals 1
    .param p1, "timeout"    # I

    .prologue
    .line 644
    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    if-eqz v0, :cond_0

    if-lez p1, :cond_0

    .line 645
    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0, p1}, Lio/branch/referral/PrefHelper;->setTimeout(I)V

    .line 647
    :cond_0
    return-void
.end method

.method public setRetryCount(I)V
    .locals 1
    .param p1, "retryCount"    # I

    .prologue
    .line 615
    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    if-eqz v0, :cond_0

    if-lez p1, :cond_0

    .line 616
    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0, p1}, Lio/branch/referral/PrefHelper;->setRetryCount(I)V

    .line 618
    :cond_0
    return-void
.end method

.method public setRetryInterval(I)V
    .locals 1
    .param p1, "retryInterval"    # I

    .prologue
    .line 628
    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    if-eqz v0, :cond_0

    if-lez p1, :cond_0

    .line 629
    iget-object v0, p0, Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0, p1}, Lio/branch/referral/PrefHelper;->setRetryInterval(I)V

    .line 631
    :cond_0
    return-void
.end method

.method public userCompletedAction(Ljava/lang/String;)V
    .locals 1
    .param p1, "action"    # Ljava/lang/String;

    .prologue
    .line 1681
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lio/branch/referral/Branch;->userCompletedAction(Ljava/lang/String;Lorg/json/JSONObject;)V

    .line 1682
    return-void
.end method

.method public userCompletedAction(Ljava/lang/String;Lorg/json/JSONObject;)V
    .locals 2
    .param p1, "action"    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p2, "metadata"    # Lorg/json/JSONObject;

    .prologue
    .line 1664
    if-eqz p2, :cond_0

    .line 1665
    invoke-static {p2}, Lio/branch/referral/BranchUtil;->filterOutBadCharacters(Lorg/json/JSONObject;)Lorg/json/JSONObject;

    move-result-object p2

    .line 1667
    :cond_0
    new-instance v0, Lio/branch/referral/ServerRequestActionCompleted;

    iget-object v1, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    invoke-direct {v0, v1, p1, p2}, Lio/branch/referral/ServerRequestActionCompleted;-><init>(Landroid/content/Context;Ljava/lang/String;Lorg/json/JSONObject;)V

    .line 1668
    .local v0, "req":Lio/branch/referral/ServerRequest;
    iget-boolean v1, v0, Lio/branch/referral/ServerRequest;->constructError_:Z

    if-nez v1, :cond_1

    iget-object v1, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lio/branch/referral/ServerRequest;->handleErrors(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 1669
    invoke-direct {p0, v0}, Lio/branch/referral/Branch;->handleNewRequest(Lio/branch/referral/ServerRequest;)V

    .line 1671
    :cond_1
    return-void
.end method

.method public validateReferralCode(Ljava/lang/String;Lio/branch/referral/Branch$BranchReferralInitListener;)V
    .locals 2
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "callback"    # Lio/branch/referral/Branch$BranchReferralInitListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 2666
    new-instance v0, Lio/branch/referral/ServerRequestValidateReferralCode;

    iget-object v1, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    invoke-direct {v0, v1, p2, p1}, Lio/branch/referral/ServerRequestValidateReferralCode;-><init>(Landroid/content/Context;Lio/branch/referral/Branch$BranchReferralInitListener;Ljava/lang/String;)V

    .line 2667
    .local v0, "req":Lio/branch/referral/ServerRequest;
    iget-boolean v1, v0, Lio/branch/referral/ServerRequest;->constructError_:Z

    if-nez v1, :cond_0

    iget-object v1, p0, Lio/branch/referral/Branch;->context_:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lio/branch/referral/ServerRequest;->handleErrors(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 2668
    invoke-direct {p0, v0}, Lio/branch/referral/Branch;->handleNewRequest(Lio/branch/referral/ServerRequest;)V

    .line 2670
    :cond_0
    return-void
.end method
