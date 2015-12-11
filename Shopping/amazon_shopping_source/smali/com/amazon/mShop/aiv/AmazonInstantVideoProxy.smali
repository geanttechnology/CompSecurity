.class public Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;
.super Ljava/lang/Object;
.source "AmazonInstantVideoProxy.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$1;,
        Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$NoopMobileStreamingQualitySettingsFragmentFactory;,
        Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$MShopNoopAmazonInstantVideo;,
        Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable;,
        Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$SingletonHolder;
    }
.end annotation


# static fields
.field private static final SDK_REF_MARKER:Ljava/lang/String; = "sdk_3p"

.field private static final TAG:Ljava/lang/String; = "AmazonApplication"

.field private static final USE_AIV_TIMECODE:J = -0x1L


# instance fields
.field private final mAivInitializedLatch:Ljava/util/concurrent/CountDownLatch;

.field private mApplicationContext:Landroid/content/Context;

.field private final mInitializationStarted:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private volatile mIsSupported:Z

.field private volatile mIsSustainable:Z

.field private mMShopAmazonInstantVideo:Lcom/amazon/avod/MShopAmazonInstantVideo;

.field private mMobileStreamingQualitySettingsFragmentFactory:Lcom/amazon/avod/playbackclient/settings/page/MobileStreamingQualitySettingsFragmentFactory;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mInitializationStarted:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 40
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mAivInitializedLatch:Ljava/util/concurrent/CountDownLatch;

    .line 264
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mApplicationContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$102(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;Landroid/content/Context;)Landroid/content/Context;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;
    .param p1, "x1"    # Landroid/content/Context;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mApplicationContext:Landroid/content/Context;

    return-object p1
.end method

.method static synthetic access$200(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;)Lcom/amazon/avod/MShopAmazonInstantVideo;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mMShopAmazonInstantVideo:Lcom/amazon/avod/MShopAmazonInstantVideo;

    return-object v0
.end method

.method static synthetic access$202(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;Lcom/amazon/avod/MShopAmazonInstantVideo;)Lcom/amazon/avod/MShopAmazonInstantVideo;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;
    .param p1, "x1"    # Lcom/amazon/avod/MShopAmazonInstantVideo;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mMShopAmazonInstantVideo:Lcom/amazon/avod/MShopAmazonInstantVideo;

    return-object p1
.end method

.method static synthetic access$302(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;Lcom/amazon/avod/playbackclient/settings/page/MobileStreamingQualitySettingsFragmentFactory;)Lcom/amazon/avod/playbackclient/settings/page/MobileStreamingQualitySettingsFragmentFactory;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;
    .param p1, "x1"    # Lcom/amazon/avod/playbackclient/settings/page/MobileStreamingQualitySettingsFragmentFactory;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mMobileStreamingQualitySettingsFragmentFactory:Lcom/amazon/avod/playbackclient/settings/page/MobileStreamingQualitySettingsFragmentFactory;

    return-object p1
.end method

.method static synthetic access$402(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;
    .param p1, "x1"    # Z

    .prologue
    .line 26
    iput-boolean p1, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mIsSupported:Z

    return p1
.end method

.method static synthetic access$502(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;
    .param p1, "x1"    # Z

    .prologue
    .line 26
    iput-boolean p1, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mIsSustainable:Z

    return p1
.end method

.method static synthetic access$800(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;)Ljava/util/concurrent/CountDownLatch;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mAivInitializedLatch:Ljava/util/concurrent/CountDownLatch;

    return-object v0
.end method

.method public static getInstance()Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;
    .locals 1

    .prologue
    .line 57
    # getter for: Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$SingletonHolder;->INSTANCE:Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;
    invoke-static {}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$SingletonHolder;->access$000()Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    move-result-object v0

    return-object v0
.end method

.method private playContent(Landroid/app/Activity;Ljava/lang/String;Lcom/amazon/avod/sdk/Constants$UrlType;J)V
    .locals 8
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "asin"    # Ljava/lang/String;
    .param p3, "urlType"    # Lcom/amazon/avod/sdk/Constants$UrlType;
    .param p4, "timecode"    # J

    .prologue
    .line 202
    iget-object v7, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mMShopAmazonInstantVideo:Lcom/amazon/avod/MShopAmazonInstantVideo;

    new-instance v0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$1PlaybackRunnable;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-wide v5, p4

    invoke-direct/range {v0 .. v6}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$1PlaybackRunnable;-><init>(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;Landroid/app/Activity;Ljava/lang/String;Lcom/amazon/avod/sdk/Constants$UrlType;J)V

    invoke-interface {v7, p1, v0}, Lcom/amazon/avod/MShopAmazonInstantVideo;->verifyAndroidRuntime(Landroid/app/Activity;Ljava/lang/Runnable;)V

    .line 203
    return-void
.end method


# virtual methods
.method public createMainSettingsFragment()Landroid/support/v4/app/Fragment;
    .locals 1

    .prologue
    .line 169
    iget-object v0, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mAivInitializedLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-static {v0}, Lcom/google/common/util/concurrent/Uninterruptibles;->awaitUninterruptibly(Ljava/util/concurrent/CountDownLatch;)V

    .line 170
    iget-object v0, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mMobileStreamingQualitySettingsFragmentFactory:Lcom/amazon/avod/playbackclient/settings/page/MobileStreamingQualitySettingsFragmentFactory;

    invoke-interface {v0}, Lcom/amazon/avod/playbackclient/settings/page/MobileStreamingQualitySettingsFragmentFactory;->createInstance()Landroid/support/v4/app/Fragment;

    move-result-object v0

    return-object v0
.end method

.method public forceRefreshAccount()V
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mAivInitializedLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-static {v0}, Lcom/google/common/util/concurrent/Uninterruptibles;->awaitUninterruptibly(Ljava/util/concurrent/CountDownLatch;)V

    .line 175
    iget-object v0, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mMShopAmazonInstantVideo:Lcom/amazon/avod/MShopAmazonInstantVideo;

    invoke-interface {v0}, Lcom/amazon/avod/MShopAmazonInstantVideo;->forceRefreshAccount()V

    .line 176
    return-void
.end method

.method public getGroverRecommendations()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 179
    iget-object v0, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mAivInitializedLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-static {v0}, Lcom/google/common/util/concurrent/Uninterruptibles;->awaitUninterruptibly(Ljava/util/concurrent/CountDownLatch;)V

    .line 180
    iget-object v0, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mMShopAmazonInstantVideo:Lcom/amazon/avod/MShopAmazonInstantVideo;

    invoke-interface {v0}, Lcom/amazon/avod/MShopAmazonInstantVideo;->getGroverRecommendations()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getGroverRecommendationsTTLMillis()J
    .locals 2

    .prologue
    .line 184
    iget-object v0, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mAivInitializedLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-static {v0}, Lcom/google/common/util/concurrent/Uninterruptibles;->awaitUninterruptibly(Ljava/util/concurrent/CountDownLatch;)V

    .line 185
    iget-object v0, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mMShopAmazonInstantVideo:Lcom/amazon/avod/MShopAmazonInstantVideo;

    invoke-interface {v0}, Lcom/amazon/avod/MShopAmazonInstantVideo;->getGroverRecommendationsTTLMillis()J

    move-result-wide v0

    return-wide v0
.end method

.method public initializeAIV(Landroid/content/Context;)V
    .locals 2
    .param p1, "applicationContext"    # Landroid/content/Context;

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mInitializationStarted:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->getAndSet(Z)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 63
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "AIV initialization can only be called once"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 69
    :cond_0
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable;-><init>(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;Landroid/content/Context;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 70
    return-void
.end method

.method public isAIVBeta()Z
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mAivInitializedLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-static {v0}, Lcom/google/common/util/concurrent/Uninterruptibles;->awaitUninterruptibly(Ljava/util/concurrent/CountDownLatch;)V

    .line 160
    iget-object v0, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mMShopAmazonInstantVideo:Lcom/amazon/avod/MShopAmazonInstantVideo;

    invoke-interface {v0}, Lcom/amazon/avod/MShopAmazonInstantVideo;->isAIVBeta()Z

    move-result v0

    return v0
.end method

.method public isPlaybackSustainable()Z
    .locals 1

    .prologue
    .line 164
    iget-object v0, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mAivInitializedLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-static {v0}, Lcom/google/common/util/concurrent/Uninterruptibles;->awaitUninterruptibly(Ljava/util/concurrent/CountDownLatch;)V

    .line 165
    iget-boolean v0, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mIsSustainable:Z

    return v0
.end method

.method public isSupported()Z
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mAivInitializedLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-static {v0}, Lcom/google/common/util/concurrent/Uninterruptibles;->awaitUninterruptibly(Ljava/util/concurrent/CountDownLatch;)V

    .line 130
    iget-boolean v0, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mIsSupported:Z

    return v0
.end method

.method public startPlayback(Landroid/app/Activity;Ljava/lang/String;J)V
    .locals 6
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "asin"    # Ljava/lang/String;
    .param p3, "timecode"    # J

    .prologue
    .line 144
    iget-object v0, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mAivInitializedLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-static {v0}, Lcom/google/common/util/concurrent/Uninterruptibles;->awaitUninterruptibly(Ljava/util/concurrent/CountDownLatch;)V

    .line 148
    const-wide/16 v0, 0x0

    cmp-long v0, p3, v0

    if-nez v0, :cond_0

    move-wide v4, p3

    .line 149
    .local v4, "resumeTimecode":J
    :goto_0
    sget-object v3, Lcom/amazon/avod/sdk/Constants$UrlType;->CONTENT:Lcom/amazon/avod/sdk/Constants$UrlType;

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->playContent(Landroid/app/Activity;Ljava/lang/String;Lcom/amazon/avod/sdk/Constants$UrlType;J)V

    .line 150
    return-void

    .line 148
    .end local v4    # "resumeTimecode":J
    :cond_0
    const-wide/16 v4, -0x1

    goto :goto_0
.end method

.method public startTrailer(Landroid/app/Activity;Ljava/lang/String;)V
    .locals 6
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "asin"    # Ljava/lang/String;

    .prologue
    .line 153
    iget-object v0, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mAivInitializedLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-static {v0}, Lcom/google/common/util/concurrent/Uninterruptibles;->awaitUninterruptibly(Ljava/util/concurrent/CountDownLatch;)V

    .line 155
    sget-object v3, Lcom/amazon/avod/sdk/Constants$UrlType;->TRAILER:Lcom/amazon/avod/sdk/Constants$UrlType;

    const-wide/16 v4, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->playContent(Landroid/app/Activity;Ljava/lang/String;Lcom/amazon/avod/sdk/Constants$UrlType;J)V

    .line 156
    return-void
.end method

.method public whisperCache(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 134
    .local p1, "asins":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v1, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mAivInitializedLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-static {v1}, Lcom/google/common/util/concurrent/Uninterruptibles;->awaitUninterruptibly(Ljava/util/concurrent/CountDownLatch;)V

    .line 136
    iget-object v1, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mMShopAmazonInstantVideo:Lcom/amazon/avod/MShopAmazonInstantVideo;

    invoke-interface {v1}, Lcom/amazon/avod/MShopAmazonInstantVideo;->refreshUserData()V

    .line 138
    new-instance v0, Lcom/amazon/avod/sdk/AmazonInstantVideo;

    iget-object v1, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mApplicationContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/avod/sdk/AmazonInstantVideo;-><init>(Landroid/content/Context;)V

    .line 139
    .local v0, "sdkLauncher":Lcom/amazon/avod/sdk/AmazonInstantVideo;
    sget-object v1, Lcom/amazon/avod/sdk/CacheLevel;->L1:Lcom/amazon/avod/sdk/CacheLevel;

    invoke-virtual {v0, p1, v1}, Lcom/amazon/avod/sdk/AmazonInstantVideo;->whisperCacheContent(Ljava/util/List;Lcom/amazon/avod/sdk/CacheLevel;)V

    .line 140
    invoke-virtual {v0}, Lcom/amazon/avod/sdk/AmazonInstantVideo;->cleanup()V

    .line 141
    return-void
.end method
