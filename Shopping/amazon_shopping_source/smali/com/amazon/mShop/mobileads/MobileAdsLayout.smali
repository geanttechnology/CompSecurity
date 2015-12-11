.class public Lcom/amazon/mShop/mobileads/MobileAdsLayout;
.super Lcom/amazon/device/ads/AmazonOOAdLayout;
.source "MobileAdsLayout.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/mobileads/MobileAdsLayout$MobileAdsDefaultListener;
    }
.end annotation


# instance fields
.field private mConfigListener:Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;

.field private mLoadingStarted:Z

.field private final mMetricsId:Ljava/lang/String;

.field private mMetricsObserverForFailure:Lcom/amazon/mShop/net/PageMetricsObserver;

.field private mMetricsObserverForSuccess:Lcom/amazon/mShop/net/PageMetricsObserver;

.field private final mNewIntentListener:Lcom/amazon/mShop/AmazonActivity$NewIntentListener;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/amazon/device/ads/AdSize;)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "adSize"    # Lcom/amazon/device/ads/AdSize;

    .prologue
    const/4 v1, 0x0

    .line 38
    invoke-direct {p0, p1, p2}, Lcom/amazon/device/ads/AmazonOOAdLayout;-><init>(Landroid/app/Activity;Lcom/amazon/device/ads/AdSize;)V

    .line 52
    iput-object v1, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mMetricsObserverForSuccess:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 53
    iput-object v1, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mMetricsObserverForFailure:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 54
    invoke-virtual {p0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mMetricsId:Ljava/lang/String;

    .line 68
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mLoadingStarted:Z

    .line 78
    iput-object v1, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mConfigListener:Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;

    .line 88
    new-instance v0, Lcom/amazon/mShop/mobileads/MobileAdsLayout$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/mobileads/MobileAdsLayout$1;-><init>(Lcom/amazon/mShop/mobileads/MobileAdsLayout;)V

    iput-object v0, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mNewIntentListener:Lcom/amazon/mShop/AmazonActivity$NewIntentListener;

    .line 39
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->setShouldDisableWebViewHardwareAcceleration(Z)V

    .line 40
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/mShop/mobileads/MobileAdsLayout;)Lcom/amazon/mShop/net/PageMetricsObserver;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mMetricsObserverForFailure:Lcom/amazon/mShop/net/PageMetricsObserver;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/mobileads/MobileAdsLayout;Lcom/amazon/mShop/net/PageMetricsObserver;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/mobileads/MobileAdsLayout;
    .param p1, "x1"    # Lcom/amazon/mShop/net/PageMetricsObserver;

    .prologue
    .line 30
    invoke-direct {p0, p1}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->completeMetrics(Lcom/amazon/mShop/net/PageMetricsObserver;)V

    return-void
.end method

.method static synthetic access$300(Lcom/amazon/mShop/mobileads/MobileAdsLayout;)Lcom/amazon/mShop/net/PageMetricsObserver;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/mobileads/MobileAdsLayout;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mMetricsObserverForSuccess:Lcom/amazon/mShop/net/PageMetricsObserver;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/mobileads/MobileAdsLayout;Lcom/amazon/mShop/net/PageMetricsObserver;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/mobileads/MobileAdsLayout;
    .param p1, "x1"    # Lcom/amazon/mShop/net/PageMetricsObserver;

    .prologue
    .line 30
    invoke-direct {p0, p1}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->cancelMetrics(Lcom/amazon/mShop/net/PageMetricsObserver;)V

    return-void
.end method

.method private cancelMetrics(Lcom/amazon/mShop/net/PageMetricsObserver;)V
    .locals 1
    .param p1, "metricsObserver"    # Lcom/amazon/mShop/net/PageMetricsObserver;

    .prologue
    .line 57
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v0

    if-nez v0, :cond_0

    .line 58
    invoke-virtual {p1}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 60
    :cond_0
    return-void
.end method

.method private completeMetrics(Lcom/amazon/mShop/net/PageMetricsObserver;)V
    .locals 1
    .param p1, "metricsObserver"    # Lcom/amazon/mShop/net/PageMetricsObserver;

    .prologue
    .line 63
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v0

    if-nez v0, :cond_0

    .line 64
    iget-object v0, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mMetricsId:Ljava/lang/String;

    invoke-virtual {p1, v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->completeForObject(Ljava/lang/String;)V

    .line 66
    :cond_0
    return-void
.end method

.method private getConfigChangedListener()Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mConfigListener:Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;

    return-object v0
.end method

.method private getNewIntentListener()Lcom/amazon/mShop/AmazonActivity$NewIntentListener;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mNewIntentListener:Lcom/amazon/mShop/AmazonActivity$NewIntentListener;

    return-object v0
.end method

.method private setConfigChangedListener(Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;

    .prologue
    .line 81
    iput-object p1, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mConfigListener:Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;

    .line 82
    return-void
.end method

.method private setLoadingStarted(Z)V
    .locals 0
    .param p1, "started"    # Z

    .prologue
    .line 71
    iput-boolean p1, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mLoadingStarted:Z

    .line 72
    return-void
.end method


# virtual methods
.method public load(Lcom/amazon/device/ads/AmazonOOAdListener;Ljava/lang/String;)V
    .locals 4
    .param p1, "adListener"    # Lcom/amazon/device/ads/AmazonOOAdListener;
    .param p2, "adId"    # Ljava/lang/String;

    .prologue
    .line 140
    invoke-virtual {p0}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->getContext()Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {p0}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->getNewIntentListener()Lcom/amazon/mShop/AmazonActivity$NewIntentListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/AmazonActivity;->registerNewIntentListener(Lcom/amazon/mShop/AmazonActivity$NewIntentListener;)V

    .line 142
    new-instance v1, Lcom/amazon/mShop/mobileads/MobileAdsLayout$3;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/mobileads/MobileAdsLayout$3;-><init>(Lcom/amazon/mShop/mobileads/MobileAdsLayout;Lcom/amazon/device/ads/AmazonOOAdListener;)V

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->setListener(Lcom/amazon/device/ads/AdListener;)V

    .line 219
    new-instance v0, Lcom/amazon/device/ads/AdTargetingOptions;

    invoke-direct {v0}, Lcom/amazon/device/ads/AdTargetingOptions;-><init>()V

    .line 220
    .local v0, "opt":Lcom/amazon/device/ads/AdTargetingOptions;
    if-eqz p2, :cond_0

    .line 221
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v1

    if-eqz v1, :cond_6

    .line 222
    const-string/jumbo v1, "pt"

    invoke-virtual {p0}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2, p2}, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->getAdIdWithTypePostfix(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/amazon/device/ads/AdTargetingOptions;->setAdvancedOption(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/device/ads/AdTargetingOptions;

    .line 228
    :cond_0
    :goto_0
    const-string/jumbo v1, "pk"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "[\""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/util/AttributionUtils;->getAssociatesTag(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "\"]"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/amazon/device/ads/AdTargetingOptions;->setAdvancedOption(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/device/ads/AdTargetingOptions;

    .line 233
    iget-object v1, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mMetricsObserverForSuccess:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mMetricsObserverForSuccess:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 234
    :cond_1
    new-instance v1, Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v2, "MobileAdsSuccess"

    invoke-direct {v1, v2}, Lcom/amazon/mShop/net/PageMetricsObserver;-><init>(Ljava/lang/String;)V

    iput-object v1, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mMetricsObserverForSuccess:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 235
    iget-object v1, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mMetricsObserverForSuccess:Lcom/amazon/mShop/net/PageMetricsObserver;

    iget-object v2, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mMetricsId:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/net/PageMetricsObserver;->startForObject(Ljava/lang/String;)V

    .line 237
    :cond_2
    iget-object v1, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mMetricsObserverForFailure:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mMetricsObserverForFailure:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 238
    :cond_3
    new-instance v1, Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v2, "MobileAdsFailure"

    invoke-direct {v1, v2}, Lcom/amazon/mShop/net/PageMetricsObserver;-><init>(Ljava/lang/String;)V

    iput-object v1, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mMetricsObserverForFailure:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 239
    iget-object v1, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mMetricsObserverForFailure:Lcom/amazon/mShop/net/PageMetricsObserver;

    iget-object v2, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mMetricsId:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/net/PageMetricsObserver;->startForObject(Ljava/lang/String;)V

    .line 242
    :cond_4
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v1

    if-eqz v1, :cond_5

    .line 245
    const-string/jumbo v1, "c"

    invoke-virtual {p0}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->getChannel(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/amazon/device/ads/AdTargetingOptions;->setAdvancedOption(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/device/ads/AdTargetingOptions;

    .line 251
    :cond_5
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->loadAd(Lcom/amazon/device/ads/AdTargetingOptions;)Z

    .line 252
    return-void

    .line 225
    :cond_6
    const-string/jumbo v1, "pt"

    invoke-virtual {v0, v1, p2}, Lcom/amazon/device/ads/AdTargetingOptions;->setAdvancedOption(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/device/ads/AdTargetingOptions;

    goto/16 :goto_0
.end method

.method public onDetachedFromWindow()V
    .locals 2

    .prologue
    .line 44
    invoke-super {p0}, Lcom/amazon/device/ads/AmazonOOAdLayout;->onDetachedFromWindow()V

    .line 45
    iget-object v0, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mMetricsObserverForFailure:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-direct {p0, v0}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->cancelMetrics(Lcom/amazon/mShop/net/PageMetricsObserver;)V

    .line 46
    iget-object v0, p0, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->mMetricsObserverForSuccess:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-direct {p0, v0}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->cancelMetrics(Lcom/amazon/mShop/net/PageMetricsObserver;)V

    .line 47
    invoke-virtual {p0}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {p0}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->getConfigChangedListener()Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonActivity;->unregisterConfigChangedListener(Lcom/amazon/mShop/AmazonActivity$OnConfigurationChangedListener;)V

    .line 48
    invoke-virtual {p0}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {p0}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->getNewIntentListener()Lcom/amazon/mShop/AmazonActivity$NewIntentListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonActivity;->unregisterNewIntentListener(Lcom/amazon/mShop/AmazonActivity$NewIntentListener;)V

    .line 49
    invoke-virtual {p0}, Lcom/amazon/mShop/mobileads/MobileAdsLayout;->destroy()V

    .line 50
    return-void
.end method
