.class public Lcom/amazon/device/ads/InterstitialAd;
.super Ljava/lang/Object;
.source "InterstitialAd.java"

# interfaces
.implements Lcom/amazon/device/ads/Ad;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/InterstitialAd$State;,
        Lcom/amazon/device/ads/InterstitialAd$InterstitialAdLoaderCallback;
    }
.end annotation


# static fields
.field protected static final ACTION_INTERSTITIAL_DISMISSED:Ljava/lang/String; = "dismissed"

.field protected static final ACTION_INTERSTITIAL_FINISHED_LOADING:Ljava/lang/String; = "finished"

.field protected static final BROADCAST_ACTION:Ljava/lang/String; = "action"

.field protected static final BROADCAST_CREATIVE:Ljava/lang/String; = "creative"

.field protected static final BROADCAST_INTENT:Ljava/lang/String; = "amazon.mobile.ads.interstitial"

.field protected static final BROADCAST_UNIQUE_IDENTIFIER_KEY:Ljava/lang/String; = "uniqueIdentifier"

.field private static final LOG_TAG:Ljava/lang/String; = "InterstitialAd"

.field protected static final MSG_PREPARE_AD_DESTROYED:Ljava/lang/String; = "This interstitial ad has been destroyed and can no longer be used. Create a new InterstitialAd object to load a new ad."

.field protected static final MSG_PREPARE_AD_LOADING:Ljava/lang/String; = "An interstitial ad is currently loading. Please wait for the ad to finish loading and showing before loading another ad."

.field protected static final MSG_PREPARE_AD_READY_TO_SHOW:Ljava/lang/String; = "An interstitial ad is ready to show. Please call showAd() to show the ad before loading another ad."

.field protected static final MSG_PREPARE_AD_SHOWING:Ljava/lang/String; = "An interstitial ad is currently showing. Please wait for the user to dismiss the ad before loading an ad."

.field protected static final MSG_SHOW_AD_ANOTHER_SHOWING:Ljava/lang/String; = "Another interstitial ad is currently showing. Please wait for the InterstitialAdListener.onAdDismissed callback of the other ad."

.field protected static final MSG_SHOW_AD_DESTROYED:Ljava/lang/String; = "The interstitial ad cannot be shown because it has been destroyed. Create a new InterstitialAd object to load a new ad."

.field protected static final MSG_SHOW_AD_DISMISSED:Ljava/lang/String; = "The interstitial ad cannot be shown because it has already been displayed to the user. Please call loadAd(AdTargetingOptions) to load a new ad."

.field protected static final MSG_SHOW_AD_EXPIRED:Ljava/lang/String; = "This interstitial ad has expired. Please load another ad."

.field protected static final MSG_SHOW_AD_LOADING:Ljava/lang/String; = "The interstitial ad cannot be shown because it is still loading. Please wait for the AdListener.onAdLoaded() callback before showing the ad."

.field protected static final MSG_SHOW_AD_READY_TO_LOAD:Ljava/lang/String; = "The interstitial ad cannot be shown because it has not loaded successfully. Please call loadAd(AdTargetingOptions) to load an ad first."

.field protected static final MSG_SHOW_AD_SHOWING:Ljava/lang/String; = "The interstitial ad cannot be shown because it is already displayed on the screen. Please wait for the InterstitialAdListener.onAdDismissed() callback and then load a new ad."

.field private static final isAdShowing:Ljava/util/concurrent/atomic/AtomicBoolean;


# instance fields
.field private final activity:Landroid/app/Activity;

.field private adData:Lcom/amazon/device/ads/AdData;

.field private adListener:Lcom/amazon/device/ads/AdListener;

.field private adLoaderCallback:Lcom/amazon/device/ads/IAdLoaderCallback;

.field private broadcastReceiver:Landroid/content/BroadcastReceiver;

.field private final hasFinishedLoading:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private hasPassedActivityValidationCheck:Z

.field private final isPrerendering:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private mraidView:Lcom/amazon/device/ads/MraidView;

.field private state:Lcom/amazon/device/ads/InterstitialAd$State;

.field private timeout:I

.field private timer:Ljava/util/Timer;

.field private final uniqueIdentifier:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 71
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    sput-object v0, Lcom/amazon/device/ads/InterstitialAd;->isAdShowing:Ljava/util/concurrent/atomic/AtomicBoolean;

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 104
    invoke-static {}, Lcom/amazon/device/ads/InterstitialAd;->generateUniqueIdentifier()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/amazon/device/ads/InterstitialAd;-><init>(Landroid/app/Activity;Ljava/lang/String;)V

    .line 105
    return-void
.end method

.method constructor <init>(Landroid/app/Activity;Ljava/lang/String;)V
    .locals 3
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "uniqueIdentifier"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 91
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 77
    iput-object v1, p0, Lcom/amazon/device/ads/InterstitialAd;->adListener:Lcom/amazon/device/ads/AdListener;

    .line 79
    iput-object v1, p0, Lcom/amazon/device/ads/InterstitialAd;->adData:Lcom/amazon/device/ads/AdData;

    .line 80
    const/16 v0, 0x4e20

    iput v0, p0, Lcom/amazon/device/ads/InterstitialAd;->timeout:I

    .line 81
    iput-object v1, p0, Lcom/amazon/device/ads/InterstitialAd;->broadcastReceiver:Landroid/content/BroadcastReceiver;

    .line 84
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/device/ads/InterstitialAd;->isPrerendering:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 85
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/device/ads/InterstitialAd;->hasFinishedLoading:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 92
    if-nez p1, :cond_0

    .line 94
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "InterstitialAd requires a non-null Activity"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 96
    :cond_0
    iput-object p1, p0, Lcom/amazon/device/ads/InterstitialAd;->activity:Landroid/app/Activity;

    .line 97
    iput-object p2, p0, Lcom/amazon/device/ads/InterstitialAd;->uniqueIdentifier:Ljava/lang/String;

    .line 98
    new-instance v0, Lcom/amazon/device/ads/InterstitialAd$InterstitialAdLoaderCallback;

    invoke-direct {v0, p0, p0}, Lcom/amazon/device/ads/InterstitialAd$InterstitialAdLoaderCallback;-><init>(Lcom/amazon/device/ads/InterstitialAd;Lcom/amazon/device/ads/InterstitialAd;)V

    iput-object v0, p0, Lcom/amazon/device/ads/InterstitialAd;->adLoaderCallback:Lcom/amazon/device/ads/IAdLoaderCallback;

    .line 99
    invoke-direct {p0}, Lcom/amazon/device/ads/InterstitialAd;->initialize()V

    .line 100
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/device/ads/InterstitialAd;Lcom/amazon/device/ads/AdError;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/device/ads/InterstitialAd;
    .param p1, "x1"    # Lcom/amazon/device/ads/AdError;

    .prologue
    .line 42
    invoke-direct {p0, p1}, Lcom/amazon/device/ads/InterstitialAd;->failAd(Lcom/amazon/device/ads/AdError;)V

    return-void
.end method

.method private failAd(Lcom/amazon/device/ads/AdError;)V
    .locals 4
    .param p1, "error"    # Lcom/amazon/device/ads/AdError;

    .prologue
    .line 666
    sget-object v2, Lcom/amazon/device/ads/InterstitialAd$State;->READY_TO_LOAD:Lcom/amazon/device/ads/InterstitialAd$State;

    invoke-virtual {p0, v2}, Lcom/amazon/device/ads/InterstitialAd;->setState(Lcom/amazon/device/ads/InterstitialAd$State;)V

    .line 667
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v0

    .line 668
    .local v0, "renderStopTime":J
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v2

    if-eqz v2, :cond_1

    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 670
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_TOTAL:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v2, v3, v0, v1}, Lcom/amazon/device/ads/MetricsCollector;->stopMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 671
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v2, v3, v0, v1}, Lcom/amazon/device/ads/MetricsCollector;->stopMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 672
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_TOTAL_FAILURE:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v2, v3, v0, v1}, Lcom/amazon/device/ads/MetricsCollector;->stopMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 673
    if-eqz p1, :cond_1

    invoke-virtual {p1}, Lcom/amazon/device/ads/AdError;->getCode()Lcom/amazon/device/ads/AdError$ErrorCode;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/AdError$ErrorCode;->NO_FILL:Lcom/amazon/device/ads/AdError$ErrorCode;

    if-eq v2, v3, :cond_0

    invoke-virtual {p1}, Lcom/amazon/device/ads/AdError;->getCode()Lcom/amazon/device/ads/AdError$ErrorCode;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/AdError$ErrorCode;->NETWORK_ERROR:Lcom/amazon/device/ads/AdError$ErrorCode;

    if-eq v2, v3, :cond_0

    invoke-virtual {p1}, Lcom/amazon/device/ads/AdError;->getCode()Lcom/amazon/device/ads/AdError$ErrorCode;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/AdError$ErrorCode;->NETWORK_TIMEOUT:Lcom/amazon/device/ads/AdError$ErrorCode;

    if-ne v2, v3, :cond_1

    .line 675
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_FAILED:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v2, v3}, Lcom/amazon/device/ads/MetricsCollector;->incrementMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 676
    invoke-virtual {p1}, Lcom/amazon/device/ads/AdError;->getCode()Lcom/amazon/device/ads/AdError$ErrorCode;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/AdError$ErrorCode;->NETWORK_TIMEOUT:Lcom/amazon/device/ads/AdError$ErrorCode;

    if-ne v2, v3, :cond_1

    .line 678
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_FAILED_ON_AAX_CALL_TIMEOUT:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v2, v3}, Lcom/amazon/device/ads/MetricsCollector;->incrementMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 682
    :cond_1
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/InterstitialAd;->callOnAdFailedToLoadOnMainThread(Lcom/amazon/device/ads/AdError;)V

    .line 683
    return-void
.end method

.method private static generateUniqueIdentifier()Ljava/lang/String;
    .locals 1

    .prologue
    .line 117
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private initialize()V
    .locals 2

    .prologue
    .line 109
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/device/ads/InterstitialAd;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/device/ads/IInternalAdRegistration;->contextReceived(Landroid/content/Context;)V

    .line 110
    sget-object v0, Lcom/amazon/device/ads/InterstitialAd$State;->READY_TO_LOAD:Lcom/amazon/device/ads/InterstitialAd$State;

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/InterstitialAd;->setState(Lcom/amazon/device/ads/InterstitialAd$State;)V

    .line 111
    new-instance v0, Lcom/amazon/device/ads/DefaultAdListener;

    const-string/jumbo v1, "InterstitialAd"

    invoke-direct {v0, v1}, Lcom/amazon/device/ads/DefaultAdListener;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amazon/device/ads/InterstitialAd;->adListener:Lcom/amazon/device/ads/AdListener;

    .line 112
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAd;->activity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/device/ads/AdUtils;->checkDefinedActivities(Landroid/content/Context;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/amazon/device/ads/InterstitialAd;->hasPassedActivityValidationCheck:Z

    .line 113
    return-void
.end method

.method public static isAdShowing()Z
    .locals 1

    .prologue
    .line 258
    sget-object v0, Lcom/amazon/device/ads/InterstitialAd;->isAdShowing:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    return v0
.end method

.method private onRequestError(Ljava/lang/String;)V
    .locals 3
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 558
    const-string/jumbo v0, "InterstitialAd"

    invoke-static {v0, p1}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 559
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdLoaderCallback()Lcom/amazon/device/ads/IAdLoaderCallback;

    move-result-object v0

    new-instance v1, Lcom/amazon/device/ads/AdError;

    sget-object v2, Lcom/amazon/device/ads/AdError$ErrorCode;->REQUEST_ERROR:Lcom/amazon/device/ads/AdError$ErrorCode;

    invoke-direct {v1, v2, p1}, Lcom/amazon/device/ads/AdError;-><init>(Lcom/amazon/device/ads/AdError$ErrorCode;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Lcom/amazon/device/ads/IAdLoaderCallback;->adFailed(Lcom/amazon/device/ads/AdError;)V

    .line 560
    return-void
.end method

.method static resetIsAdShowing()V
    .locals 2

    .prologue
    .line 122
    sget-object v0, Lcom/amazon/device/ads/InterstitialAd;->isAdShowing:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 123
    return-void
.end method

.method private setAdditionalMetrics()V
    .locals 2

    .prologue
    .line 743
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v0

    sget-object v1, Lcom/amazon/device/ads/AdProperties$AdType;->INTERSTITIAL:Lcom/amazon/device/ads/AdProperties$AdType;

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/MetricsCollector;->setAdType(Lcom/amazon/device/ads/AdProperties$AdType;)V

    .line 744
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v0

    sget-object v1, Lcom/amazon/device/ads/Metrics$MetricType;->AD_IS_INTERSTITIAL:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/MetricsCollector;->incrementMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 745
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/device/ads/AdUtils;->setConnectionMetrics(Lcom/amazon/device/ads/AdData;)V

    .line 746
    return-void
.end method


# virtual methods
.method callOnAdDismissed()V
    .locals 1

    .prologue
    .line 687
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAd;->adListener:Lcom/amazon/device/ads/AdListener;

    invoke-interface {v0, p0}, Lcom/amazon/device/ads/AdListener;->onAdDismissed(Lcom/amazon/device/ads/Ad;)V

    .line 688
    return-void
.end method

.method callOnAdDismissedOnMainThread()V
    .locals 2

    .prologue
    .line 692
    new-instance v0, Landroid/os/Handler;

    iget-object v1, p0, Lcom/amazon/device/ads/InterstitialAd;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 693
    .local v0, "h":Landroid/os/Handler;
    new-instance v1, Lcom/amazon/device/ads/InterstitialAd$7;

    invoke-direct {v1, p0}, Lcom/amazon/device/ads/InterstitialAd$7;-><init>(Lcom/amazon/device/ads/InterstitialAd;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 702
    return-void
.end method

.method callOnAdFailedToLoad(Lcom/amazon/device/ads/AdError;)V
    .locals 1
    .param p1, "error"    # Lcom/amazon/device/ads/AdError;

    .prologue
    .line 642
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAd;->adListener:Lcom/amazon/device/ads/AdListener;

    invoke-interface {v0, p0, p1}, Lcom/amazon/device/ads/AdListener;->onAdFailedToLoad(Lcom/amazon/device/ads/Ad;Lcom/amazon/device/ads/AdError;)V

    .line 643
    return-void
.end method

.method callOnAdFailedToLoadOnMainThread(Lcom/amazon/device/ads/AdError;)V
    .locals 2
    .param p1, "error"    # Lcom/amazon/device/ads/AdError;

    .prologue
    .line 647
    new-instance v0, Landroid/os/Handler;

    iget-object v1, p0, Lcom/amazon/device/ads/InterstitialAd;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 648
    .local v0, "h":Landroid/os/Handler;
    new-instance v1, Lcom/amazon/device/ads/InterstitialAd$6;

    invoke-direct {v1, p0, p1}, Lcom/amazon/device/ads/InterstitialAd$6;-><init>(Lcom/amazon/device/ads/InterstitialAd;Lcom/amazon/device/ads/AdError;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 657
    return-void
.end method

.method callOnAdLoaded()V
    .locals 2

    .prologue
    .line 624
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAd;->adListener:Lcom/amazon/device/ads/AdListener;

    iget-object v1, p0, Lcom/amazon/device/ads/InterstitialAd;->adData:Lcom/amazon/device/ads/AdData;

    invoke-virtual {v1}, Lcom/amazon/device/ads/AdData;->getProperties()Lcom/amazon/device/ads/AdProperties;

    move-result-object v1

    invoke-interface {v0, p0, v1}, Lcom/amazon/device/ads/AdListener;->onAdLoaded(Lcom/amazon/device/ads/Ad;Lcom/amazon/device/ads/AdProperties;)V

    .line 625
    return-void
.end method

.method callOnAdLoadedOnMainThread()V
    .locals 2

    .prologue
    .line 629
    new-instance v0, Landroid/os/Handler;

    iget-object v1, p0, Lcom/amazon/device/ads/InterstitialAd;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 630
    .local v0, "h":Landroid/os/Handler;
    new-instance v1, Lcom/amazon/device/ads/InterstitialAd$5;

    invoke-direct {v1, p0}, Lcom/amazon/device/ads/InterstitialAd$5;-><init>(Lcom/amazon/device/ads/InterstitialAd;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 638
    return-void
.end method

.method cancelTimer()V
    .locals 1

    .prologue
    .line 582
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAd;->timer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 583
    return-void
.end method

.method constructMraidView(Landroid/webkit/WebView;)Lcom/amazon/device/ads/MraidView;
    .locals 3
    .param p1, "webView"    # Landroid/webkit/WebView;

    .prologue
    .line 430
    new-instance v0, Lcom/amazon/device/ads/MraidView;

    new-instance v1, Lcom/amazon/device/ads/InterstitialAd$2;

    invoke-direct {v1, p0}, Lcom/amazon/device/ads/InterstitialAd$2;-><init>(Lcom/amazon/device/ads/InterstitialAd;)V

    iget-object v2, p0, Lcom/amazon/device/ads/InterstitialAd;->activity:Landroid/app/Activity;

    invoke-direct {v0, v1, v2, p1}, Lcom/amazon/device/ads/MraidView;-><init>(Lcom/amazon/device/ads/AdView;Landroid/content/Context;Landroid/webkit/WebView;)V

    .line 472
    .local v0, "mraidView":Lcom/amazon/device/ads/MraidView;
    return-object v0
.end method

.method executePostActivityShown()V
    .locals 1

    .prologue
    .line 482
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdLoaderCallback()Lcom/amazon/device/ads/IAdLoaderCallback;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/device/ads/IAdLoaderCallback;->adShown()V

    .line 483
    return-void
.end method

.method getAdData()Lcom/amazon/device/ads/AdData;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAd;->adData:Lcom/amazon/device/ads/AdData;

    return-object v0
.end method

.method getAdLoaderCallback()Lcom/amazon/device/ads/IAdLoaderCallback;
    .locals 1

    .prologue
    .line 553
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAd;->adLoaderCallback:Lcom/amazon/device/ads/IAdLoaderCallback;

    return-object v0
.end method

.method getAndSetHasFinishedLoading(Z)Z
    .locals 1
    .param p1, "hasFinishedLoading"    # Z

    .prologue
    .line 592
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAd;->hasFinishedLoading:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/atomic/AtomicBoolean;->getAndSet(Z)Z

    move-result v0

    return v0
.end method

.method getState()Lcom/amazon/device/ads/InterstitialAd$State;
    .locals 1

    .prologue
    .line 301
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAd;->state:Lcom/amazon/device/ads/InterstitialAd$State;

    return-object v0
.end method

.method public getTimeout()I
    .locals 1

    .prologue
    .line 543
    iget v0, p0, Lcom/amazon/device/ads/InterstitialAd;->timeout:I

    return v0
.end method

.method handleDismissed()V
    .locals 2

    .prologue
    .line 526
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v0

    sget-object v1, Lcom/amazon/device/ads/Metrics$MetricType;->AD_SHOW_DURATION:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/MetricsCollector;->stopMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 527
    sget-object v0, Lcom/amazon/device/ads/InterstitialAd$State;->DISMISSED:Lcom/amazon/device/ads/InterstitialAd$State;

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/InterstitialAd;->setState(Lcom/amazon/device/ads/InterstitialAd$State;)V

    .line 528
    sget-object v0, Lcom/amazon/device/ads/InterstitialAd;->isAdShowing:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 529
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->callOnAdDismissedOnMainThread()V

    .line 530
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->unregisterBroadcastReceiver()V

    .line 531
    return-void
.end method

.method handlePageFinished()V
    .locals 3

    .prologue
    .line 535
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v0

    sget-object v1, Lcom/amazon/device/ads/Metrics$MetricType;->AD_SHOW_LATENCY:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/MetricsCollector;->stopMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 536
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->executePostActivityShown()V

    .line 537
    sget-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_SHOW_DURATION:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v1

    invoke-virtual {p0, v0, v1, v2}, Lcom/amazon/device/ads/InterstitialAd;->submitAndResetMetricsOnMainThreadAndStartMetric(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 538
    return-void
.end method

.method hasDismissed()Z
    .locals 2

    .prologue
    .line 291
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getState()Lcom/amazon/device/ads/InterstitialAd$State;

    move-result-object v0

    sget-object v1, Lcom/amazon/device/ads/InterstitialAd$State;->DISMISSED:Lcom/amazon/device/ads/InterstitialAd$State;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method isExpired()Z
    .locals 1

    .prologue
    .line 296
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdData;->isExpired()Z

    move-result v0

    return v0
.end method

.method public isLoading()Z
    .locals 2

    .prologue
    .line 267
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getState()Lcom/amazon/device/ads/InterstitialAd$State;

    move-result-object v0

    sget-object v1, Lcom/amazon/device/ads/InterstitialAd$State;->LOADING:Lcom/amazon/device/ads/InterstitialAd$State;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method isReadyToLoad()Z
    .locals 2

    .prologue
    .line 281
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getState()Lcom/amazon/device/ads/InterstitialAd$State;

    move-result-object v0

    sget-object v1, Lcom/amazon/device/ads/InterstitialAd$State;->READY_TO_LOAD:Lcom/amazon/device/ads/InterstitialAd$State;

    if-eq v0, v1, :cond_0

    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->hasDismissed()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method isReadyToShow()Z
    .locals 2

    .prologue
    .line 286
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getState()Lcom/amazon/device/ads/InterstitialAd$State;

    move-result-object v0

    sget-object v1, Lcom/amazon/device/ads/InterstitialAd$State;->READY_TO_SHOW:Lcom/amazon/device/ads/InterstitialAd$State;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isShowing()Z
    .locals 2

    .prologue
    .line 276
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getState()Lcom/amazon/device/ads/InterstitialAd$State;

    move-result-object v0

    sget-object v1, Lcom/amazon/device/ads/InterstitialAd$State;->SHOWING:Lcom/amazon/device/ads/InterstitialAd$State;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public loadAd()Z
    .locals 1

    .prologue
    .line 158
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/InterstitialAd;->loadAd(Lcom/amazon/device/ads/AdTargetingOptions;)Z

    move-result v0

    return v0
.end method

.method public loadAd(Lcom/amazon/device/ads/AdTargetingOptions;)Z
    .locals 4
    .param p1, "options"    # Lcom/amazon/device/ads/AdTargetingOptions;

    .prologue
    const/4 v3, 0x0

    .line 168
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getTimeout()I

    move-result v0

    const/4 v1, 0x1

    new-array v1, v1, [Lcom/amazon/device/ads/AdSlot;

    new-instance v2, Lcom/amazon/device/ads/AdSlot;

    invoke-direct {v2, p0, p1}, Lcom/amazon/device/ads/AdSlot;-><init>(Lcom/amazon/device/ads/Ad;Lcom/amazon/device/ads/AdTargetingOptions;)V

    aput-object v2, v1, v3

    invoke-static {v0, p1, v1}, Lcom/amazon/device/ads/AdLoader;->loadAds(ILcom/amazon/device/ads/AdTargetingOptions;[Lcom/amazon/device/ads/AdSlot;)[Z

    move-result-object v0

    aget-boolean v0, v0, v3

    return v0
.end method

.method loadHtml(Ljava/lang/String;)V
    .locals 2
    .param p1, "html"    # Ljava/lang/String;

    .prologue
    .line 477
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAd;->mraidView:Lcom/amazon/device/ads/MraidView;

    const-string/jumbo v1, "http://amazon-adsystem.amazon.com/"

    invoke-virtual {v0, v1, p1}, Lcom/amazon/device/ads/MraidView;->loadHtmlData(Ljava/lang/String;Ljava/lang/String;)Z

    .line 478
    return-void
.end method

.method onAdPrerendered()V
    .locals 4

    .prologue
    .line 564
    iget-object v2, p0, Lcom/amazon/device/ads/InterstitialAd;->mraidView:Lcom/amazon/device/ads/MraidView;

    if-eqz v2, :cond_0

    .line 566
    iget-object v2, p0, Lcom/amazon/device/ads/InterstitialAd;->mraidView:Lcom/amazon/device/ads/MraidView;

    invoke-virtual {v2}, Lcom/amazon/device/ads/MraidView;->unregisterReceivers()V

    .line 569
    :cond_0
    const/4 v2, 0x1

    invoke-virtual {p0, v2}, Lcom/amazon/device/ads/InterstitialAd;->getAndSetHasFinishedLoading(Z)Z

    move-result v2

    if-nez v2, :cond_1

    .line 571
    iget-object v2, p0, Lcom/amazon/device/ads/InterstitialAd;->isPrerendering:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 572
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->cancelTimer()V

    .line 573
    sget-object v2, Lcom/amazon/device/ads/InterstitialAd$State;->READY_TO_SHOW:Lcom/amazon/device/ads/InterstitialAd$State;

    invoke-virtual {p0, v2}, Lcom/amazon/device/ads/InterstitialAd;->setState(Lcom/amazon/device/ads/InterstitialAd$State;)V

    .line 574
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->callOnAdLoadedOnMainThread()V

    .line 575
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v0

    .line 576
    .local v0, "adLoadedStartTime":J
    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOADED_TO_AD_SHOW_TIME:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {p0, v2, v0, v1}, Lcom/amazon/device/ads/InterstitialAd;->submitAndResetMetricsOnMainThreadAndStartMetric(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 578
    .end local v0    # "adLoadedStartTime":J
    :cond_1
    return-void
.end method

.method onAdTimedOut()V
    .locals 6

    .prologue
    .line 600
    iget-object v3, p0, Lcom/amazon/device/ads/InterstitialAd;->isPrerendering:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v3}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v2

    .line 602
    .local v2, "timedOutInPrerender":Z
    iget-object v3, p0, Lcom/amazon/device/ads/InterstitialAd;->uniqueIdentifier:Ljava/lang/String;

    invoke-static {v3}, Lcom/amazon/device/ads/MraidView;->removeCachedMraidView(Ljava/lang/String;)Lcom/amazon/device/ads/MraidView;

    move-result-object v1

    .line 603
    .local v1, "mraidView":Lcom/amazon/device/ads/MraidView;
    if-eqz v1, :cond_0

    .line 605
    new-instance v0, Landroid/os/Handler;

    iget-object v3, p0, Lcom/amazon/device/ads/InterstitialAd;->activity:Landroid/app/Activity;

    invoke-virtual {v3}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v3

    invoke-direct {v0, v3}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 606
    .local v0, "handler":Landroid/os/Handler;
    new-instance v3, Lcom/amazon/device/ads/InterstitialAd$4;

    invoke-direct {v3, p0, v1}, Lcom/amazon/device/ads/InterstitialAd$4;-><init>(Lcom/amazon/device/ads/InterstitialAd;Lcom/amazon/device/ads/MraidView;)V

    invoke-virtual {v0, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 615
    .end local v0    # "handler":Landroid/os/Handler;
    :cond_0
    if-eqz v2, :cond_1

    .line 617
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v3

    sget-object v4, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_FAILED_ON_PRERENDERING_TIMEOUT:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v3, v4}, Lcom/amazon/device/ads/MetricsCollector;->incrementMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 619
    :cond_1
    new-instance v3, Lcom/amazon/device/ads/AdError;

    sget-object v4, Lcom/amazon/device/ads/AdError$ErrorCode;->NETWORK_ERROR:Lcom/amazon/device/ads/AdError$ErrorCode;

    const-string/jumbo v5, "Ad Load Timed Out"

    invoke-direct {v3, v4, v5}, Lcom/amazon/device/ads/AdError;-><init>(Lcom/amazon/device/ads/AdError$ErrorCode;Ljava/lang/String;)V

    invoke-direct {p0, v3}, Lcom/amazon/device/ads/InterstitialAd;->failAd(Lcom/amazon/device/ads/AdError;)V

    .line 620
    return-void
.end method

.method onBroadcastReceived(Landroid/content/Intent;)V
    .locals 3
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 507
    iget-object v1, p0, Lcom/amazon/device/ads/InterstitialAd;->uniqueIdentifier:Ljava/lang/String;

    const-string/jumbo v2, "uniqueIdentifier"

    invoke-virtual {p1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 509
    const-string/jumbo v1, "amazon.mobile.ads.interstitial"

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 511
    const-string/jumbo v1, "action"

    invoke-virtual {p1, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 512
    .local v0, "action":Ljava/lang/String;
    const-string/jumbo v1, "dismissed"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 514
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->handleDismissed()V

    .line 522
    .end local v0    # "action":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 516
    .restart local v0    # "action":Ljava/lang/String;
    :cond_1
    const-string/jumbo v1, "finished"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 518
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->handlePageFinished()V

    goto :goto_0
.end method

.method prepareAd(Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;)I
    .locals 9
    .param p1, "listener"    # Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;

    .prologue
    const/4 v4, 0x0

    .line 181
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v1

    .line 182
    .local v1, "loadAdStartTime":J
    iget-boolean v5, p0, Lcom/amazon/device/ads/InterstitialAd;->hasPassedActivityValidationCheck:Z

    if-nez v5, :cond_0

    .line 184
    const-string/jumbo v3, "Ads cannot load unless \"com.amazon.device.ads.AdActivity\" is correctly declared as an activity in AndroidManifest.xml. Consult the online documentation for more info."

    .line 187
    .local v3, "msg":Ljava/lang/String;
    const-string/jumbo v4, "Ads cannot load unless \"com.amazon.device.ads.AdActivity\" is correctly declared as an activity in AndroidManifest.xml. Consult the online documentation for more info."

    invoke-direct {p0, v4}, Lcom/amazon/device/ads/InterstitialAd;->onRequestError(Ljava/lang/String;)V

    .line 188
    const/4 v4, 0x1

    .line 248
    .end local v3    # "msg":Ljava/lang/String;
    :goto_0
    return v4

    .line 190
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->isReadyToLoad()Z

    move-result v5

    if-nez v5, :cond_5

    .line 192
    const/4 v0, 0x1

    .line 193
    .local v0, "failLoad":Z
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->isShowing()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 195
    const-string/jumbo v5, "InterstitialAd"

    const-string/jumbo v6, "An interstitial ad is currently showing. Please wait for the user to dismiss the ad before loading an ad."

    invoke-static {v5, v6}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 216
    :cond_1
    :goto_1
    if-eqz v0, :cond_5

    .line 218
    const/4 v4, -0x1

    goto :goto_0

    .line 197
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->isReadyToShow()Z

    move-result v5

    if-eqz v5, :cond_4

    .line 202
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v5

    if-eqz v5, :cond_3

    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/device/ads/AdData;->isExpired()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 204
    const/4 v0, 0x0

    goto :goto_1

    .line 208
    :cond_3
    const-string/jumbo v5, "InterstitialAd"

    const-string/jumbo v6, "An interstitial ad is ready to show. Please call showAd() to show the ad before loading another ad."

    invoke-static {v5, v6}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 211
    :cond_4
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->isLoading()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 213
    const-string/jumbo v5, "InterstitialAd"

    const-string/jumbo v6, "An interstitial ad is currently loading. Please wait for the ad to finish loading and showing before loading another ad."

    invoke-static {v5, v6}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 221
    .end local v0    # "failLoad":Z
    :cond_5
    iget-object v5, p0, Lcom/amazon/device/ads/InterstitialAd;->isPrerendering:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v5, v4}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 222
    invoke-virtual {p0, v4}, Lcom/amazon/device/ads/InterstitialAd;->setHasFinishedLoading(Z)V

    .line 224
    iget-object v5, p0, Lcom/amazon/device/ads/InterstitialAd;->timer:Ljava/util/Timer;

    if-eqz v5, :cond_6

    .line 226
    iget-object v5, p0, Lcom/amazon/device/ads/InterstitialAd;->timer:Ljava/util/Timer;

    invoke-virtual {v5}, Ljava/util/Timer;->purge()I

    .line 228
    :cond_6
    new-instance v5, Ljava/util/Timer;

    invoke-direct {v5}, Ljava/util/Timer;-><init>()V

    iput-object v5, p0, Lcom/amazon/device/ads/InterstitialAd;->timer:Ljava/util/Timer;

    .line 229
    iget-object v5, p0, Lcom/amazon/device/ads/InterstitialAd;->timer:Ljava/util/Timer;

    new-instance v6, Lcom/amazon/device/ads/InterstitialAd$1;

    invoke-direct {v6, p0}, Lcom/amazon/device/ads/InterstitialAd$1;-><init>(Lcom/amazon/device/ads/InterstitialAd;)V

    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getTimeout()I

    move-result v7

    int-to-long v7, v7

    invoke-virtual {v5, v6, v7, v8}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    .line 241
    sget-object v5, Lcom/amazon/device/ads/InterstitialAd$State;->LOADING:Lcom/amazon/device/ads/InterstitialAd$State;

    invoke-virtual {p0, v5}, Lcom/amazon/device/ads/InterstitialAd;->setState(Lcom/amazon/device/ads/InterstitialAd$State;)V

    .line 242
    new-instance v5, Lcom/amazon/device/ads/AdData;

    sget-object v6, Lcom/amazon/device/ads/AdSize;->SIZE_INTERSTITIAL:Lcom/amazon/device/ads/AdSize;

    invoke-direct {v5, v6}, Lcom/amazon/device/ads/AdData;-><init>(Lcom/amazon/device/ads/AdSize;)V

    invoke-virtual {p0, v5}, Lcom/amazon/device/ads/InterstitialAd;->setAdData(Lcom/amazon/device/ads/AdData;)V

    .line 243
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v5

    sget-object v6, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_TOTAL:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v5, v6, v1, v2}, Lcom/amazon/device/ads/MetricsCollector;->startMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 244
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v5

    sget-object v6, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_TOTAL_FAILURE:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v5, v6, v1, v2}, Lcom/amazon/device/ads/MetricsCollector;->startMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 245
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v5

    sget-object v6, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_TOTAL_SUCCESS:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v5, v6, v1, v2}, Lcom/amazon/device/ads/MetricsCollector;->startMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 246
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v5

    sget-object v6, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v5, v6, v1, v2}, Lcom/amazon/device/ads/MetricsCollector;->startMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 247
    invoke-virtual {p1, p0}, Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;->onAdReady(Lcom/amazon/device/ads/Ad;)V

    goto/16 :goto_0
.end method

.method prerenderHtml()V
    .locals 8

    .prologue
    const/4 v5, 0x1

    .line 407
    iget-object v4, p0, Lcom/amazon/device/ads/InterstitialAd;->isPrerendering:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v4, v5}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 408
    iget-object v4, p0, Lcom/amazon/device/ads/InterstitialAd;->adData:Lcom/amazon/device/ads/AdData;

    invoke-virtual {v4}, Lcom/amazon/device/ads/AdData;->getCreative()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v5}, Lcom/amazon/device/ads/AdUtils;->encloseHtml(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v4

    const-string/jumbo v5, "<head>"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "<head>\n  <script type=\'text/javascript\'>\n  var connectionType=\""

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Lcom/amazon/device/ads/InterstitialAd;->adData:Lcom/amazon/device/ads/AdData;

    invoke-virtual {v7}, Lcom/amazon/device/ads/AdData;->getConnectionType()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, "\";\n"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, "  var screenWidth="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Lcom/amazon/device/ads/InterstitialAd;->adData:Lcom/amazon/device/ads/AdData;

    invoke-virtual {v7}, Lcom/amazon/device/ads/AdData;->getScreenWidth()I

    move-result v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, ";\n"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, "  var screenHeight="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Lcom/amazon/device/ads/InterstitialAd;->adData:Lcom/amazon/device/ads/AdData;

    invoke-virtual {v7}, Lcom/amazon/device/ads/AdData;->getScreenHeight()I

    move-result v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, ";\n"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, "  </script>\n"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 416
    .local v0, "html":Ljava/lang/String;
    iget-object v4, p0, Lcom/amazon/device/ads/InterstitialAd;->adData:Lcom/amazon/device/ads/AdData;

    invoke-virtual {v4, v0}, Lcom/amazon/device/ads/AdData;->setCreative(Ljava/lang/String;)V

    .line 417
    invoke-static {}, Lcom/amazon/device/ads/WebViewFactory;->getInstance()Lcom/amazon/device/ads/WebViewFactory;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/device/ads/InterstitialAd;->activity:Landroid/app/Activity;

    invoke-virtual {v4, v5}, Lcom/amazon/device/ads/WebViewFactory;->createWebView(Landroid/content/Context;)Landroid/webkit/WebView;

    move-result-object v3

    .line 418
    .local v3, "webView":Landroid/webkit/WebView;
    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/webkit/WebView;->setBackgroundColor(I)V

    .line 419
    invoke-virtual {p0, v3}, Lcom/amazon/device/ads/InterstitialAd;->constructMraidView(Landroid/webkit/WebView;)Lcom/amazon/device/ads/MraidView;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/device/ads/InterstitialAd;->mraidView:Lcom/amazon/device/ads/MraidView;

    .line 421
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v1

    .line 422
    .local v1, "renderLatencyStartTime":J
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v4

    sget-object v5, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v4, v5, v1, v2}, Lcom/amazon/device/ads/MetricsCollector;->stopMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 423
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v4

    sget-object v5, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_RENDER:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v4, v5, v1, v2}, Lcom/amazon/device/ads/MetricsCollector;->startMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 425
    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/InterstitialAd;->loadHtml(Ljava/lang/String;)V

    .line 426
    return-void
.end method

.method registerBroadcastReceiver()V
    .locals 3

    .prologue
    .line 487
    new-instance v1, Lcom/amazon/device/ads/InterstitialAd$3;

    invoke-direct {v1, p0}, Lcom/amazon/device/ads/InterstitialAd$3;-><init>(Lcom/amazon/device/ads/InterstitialAd;)V

    iput-object v1, p0, Lcom/amazon/device/ads/InterstitialAd;->broadcastReceiver:Landroid/content/BroadcastReceiver;

    .line 495
    new-instance v0, Landroid/content/IntentFilter;

    const-string/jumbo v1, "amazon.mobile.ads.interstitial"

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 496
    .local v0, "filter":Landroid/content/IntentFilter;
    iget-object v1, p0, Lcom/amazon/device/ads/InterstitialAd;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/device/ads/InterstitialAd;->broadcastReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v1, v2, v0}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 497
    return-void
.end method

.method setAdData(Lcom/amazon/device/ads/AdData;)V
    .locals 0
    .param p1, "adData"    # Lcom/amazon/device/ads/AdData;

    .prologue
    .line 311
    iput-object p1, p0, Lcom/amazon/device/ads/InterstitialAd;->adData:Lcom/amazon/device/ads/AdData;

    .line 312
    return-void
.end method

.method setAdLoaderCallback(Lcom/amazon/device/ads/IAdLoaderCallback;)V
    .locals 0
    .param p1, "adLoaderCallback"    # Lcom/amazon/device/ads/IAdLoaderCallback;

    .prologue
    .line 148
    iput-object p1, p0, Lcom/amazon/device/ads/InterstitialAd;->adLoaderCallback:Lcom/amazon/device/ads/IAdLoaderCallback;

    .line 149
    return-void
.end method

.method setHasFinishedLoading(Z)V
    .locals 1
    .param p1, "hasFinishedLoading"    # Z

    .prologue
    .line 587
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAd;->hasFinishedLoading:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 588
    return-void
.end method

.method public setListener(Lcom/amazon/device/ads/AdListener;)V
    .locals 2
    .param p1, "adListener"    # Lcom/amazon/device/ads/AdListener;

    .prologue
    .line 133
    if-nez p1, :cond_0

    .line 135
    new-instance v0, Lcom/amazon/device/ads/DefaultAdListener;

    const-string/jumbo v1, "InterstitialAd"

    invoke-direct {v0, v1}, Lcom/amazon/device/ads/DefaultAdListener;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amazon/device/ads/InterstitialAd;->adListener:Lcom/amazon/device/ads/AdListener;

    .line 141
    :goto_0
    return-void

    .line 139
    :cond_0
    iput-object p1, p0, Lcom/amazon/device/ads/InterstitialAd;->adListener:Lcom/amazon/device/ads/AdListener;

    goto :goto_0
.end method

.method setState(Lcom/amazon/device/ads/InterstitialAd$State;)V
    .locals 0
    .param p1, "state"    # Lcom/amazon/device/ads/InterstitialAd$State;

    .prologue
    .line 306
    iput-object p1, p0, Lcom/amazon/device/ads/InterstitialAd;->state:Lcom/amazon/device/ads/InterstitialAd$State;

    .line 307
    return-void
.end method

.method public setTimeout(I)V
    .locals 0
    .param p1, "timeout"    # I

    .prologue
    .line 548
    iput p1, p0, Lcom/amazon/device/ads/InterstitialAd;->timeout:I

    .line 549
    return-void
.end method

.method public showAd()Z
    .locals 6

    .prologue
    const/4 v3, 0x0

    .line 320
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v1

    .line 321
    .local v1, "renderLatencyStartTime":J
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->isReadyToShow()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 323
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->isExpired()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 325
    const-string/jumbo v4, "InterstitialAd"

    const-string/jumbo v5, "This interstitial ad has expired. Please load another ad."

    invoke-static {v4, v5}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 326
    sget-object v4, Lcom/amazon/device/ads/InterstitialAd$State;->READY_TO_LOAD:Lcom/amazon/device/ads/InterstitialAd$State;

    invoke-virtual {p0, v4}, Lcom/amazon/device/ads/InterstitialAd;->setState(Lcom/amazon/device/ads/InterstitialAd$State;)V

    move v0, v3

    .line 383
    :goto_0
    return v0

    .line 329
    :cond_0
    sget-object v4, Lcom/amazon/device/ads/InterstitialAd;->isAdShowing:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v5, 0x1

    invoke-virtual {v4, v5}, Ljava/util/concurrent/atomic/AtomicBoolean;->getAndSet(Z)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 331
    const-string/jumbo v4, "InterstitialAd"

    const-string/jumbo v5, "Another interstitial ad is currently showing. Please wait for the InterstitialAdListener.onAdDismissed callback of the other ad."

    invoke-static {v4, v5}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    move v0, v3

    .line 332
    goto :goto_0

    .line 336
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v4

    sget-object v5, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOADED_TO_AD_SHOW_TIME:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v4, v5, v1, v2}, Lcom/amazon/device/ads/MetricsCollector;->stopMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 337
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v4

    sget-object v5, Lcom/amazon/device/ads/Metrics$MetricType;->AD_SHOW_LATENCY:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v4, v5, v1, v2}, Lcom/amazon/device/ads/MetricsCollector;->startMetricInMillisecondsFromNanoseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 339
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->registerBroadcastReceiver()V

    .line 343
    iget-object v4, p0, Lcom/amazon/device/ads/InterstitialAd;->uniqueIdentifier:Ljava/lang/String;

    iget-object v5, p0, Lcom/amazon/device/ads/InterstitialAd;->mraidView:Lcom/amazon/device/ads/MraidView;

    invoke-static {v4, v5}, Lcom/amazon/device/ads/MraidView;->cacheMraidView(Ljava/lang/String;Lcom/amazon/device/ads/MraidView;)V

    .line 345
    const/4 v4, 0x0

    iput-object v4, p0, Lcom/amazon/device/ads/InterstitialAd;->mraidView:Lcom/amazon/device/ads/MraidView;

    .line 346
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->showAdInActivity()Z

    move-result v0

    .line 347
    .local v0, "activityShown":Z
    if-eqz v0, :cond_2

    .line 349
    sget-object v3, Lcom/amazon/device/ads/InterstitialAd$State;->SHOWING:Lcom/amazon/device/ads/InterstitialAd$State;

    invoke-virtual {p0, v3}, Lcom/amazon/device/ads/InterstitialAd;->setState(Lcom/amazon/device/ads/InterstitialAd$State;)V

    goto :goto_0

    .line 354
    :cond_2
    iget-object v4, p0, Lcom/amazon/device/ads/InterstitialAd;->uniqueIdentifier:Ljava/lang/String;

    invoke-static {v4}, Lcom/amazon/device/ads/MraidView;->removeCachedMraidView(Ljava/lang/String;)Lcom/amazon/device/ads/MraidView;

    .line 355
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->unregisterBroadcastReceiver()V

    .line 356
    sget-object v4, Lcom/amazon/device/ads/InterstitialAd$State;->READY_TO_LOAD:Lcom/amazon/device/ads/InterstitialAd$State;

    invoke-virtual {p0, v4}, Lcom/amazon/device/ads/InterstitialAd;->setState(Lcom/amazon/device/ads/InterstitialAd$State;)V

    .line 358
    sget-object v4, Lcom/amazon/device/ads/InterstitialAd;->isAdShowing:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v4, v3}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 359
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v3

    sget-object v4, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_RENDER_FAILED:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v3, v4}, Lcom/amazon/device/ads/MetricsCollector;->stopMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    goto :goto_0

    .line 367
    .end local v0    # "activityShown":Z
    :cond_3
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->hasDismissed()Z

    move-result v4

    if-eqz v4, :cond_5

    .line 369
    const-string/jumbo v4, "InterstitialAd"

    const-string/jumbo v5, "The interstitial ad cannot be shown because it has already been displayed to the user. Please call loadAd(AdTargetingOptions) to load a new ad."

    invoke-static {v4, v5}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    :cond_4
    :goto_1
    move v0, v3

    .line 383
    goto :goto_0

    .line 371
    :cond_5
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->isReadyToLoad()Z

    move-result v4

    if-eqz v4, :cond_6

    .line 373
    const-string/jumbo v4, "InterstitialAd"

    const-string/jumbo v5, "The interstitial ad cannot be shown because it has not loaded successfully. Please call loadAd(AdTargetingOptions) to load an ad first."

    invoke-static {v4, v5}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 375
    :cond_6
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->isLoading()Z

    move-result v4

    if-eqz v4, :cond_7

    .line 377
    const-string/jumbo v4, "InterstitialAd"

    const-string/jumbo v5, "The interstitial ad cannot be shown because it is still loading. Please wait for the AdListener.onAdLoaded() callback before showing the ad."

    invoke-static {v4, v5}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 379
    :cond_7
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->isShowing()Z

    move-result v4

    if-eqz v4, :cond_4

    .line 381
    const-string/jumbo v4, "InterstitialAd"

    const-string/jumbo v5, "The interstitial ad cannot be shown because it is already displayed on the screen. Please wait for the InterstitialAdListener.onAdDismissed() callback and then load a new ad."

    invoke-static {v4, v5}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method showAdInActivity()Z
    .locals 4

    .prologue
    .line 391
    :try_start_0
    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/amazon/device/ads/InterstitialAd;->activity:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const-class v3, Lcom/amazon/device/ads/AdActivity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 392
    .local v1, "intent":Landroid/content/Intent;
    const-string/jumbo v2, "adapter"

    const-class v3, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 393
    const-string/jumbo v2, "uniqueIdentifier"

    iget-object v3, p0, Lcom/amazon/device/ads/InterstitialAd;->uniqueIdentifier:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 394
    const-string/jumbo v2, "creative"

    iget-object v3, p0, Lcom/amazon/device/ads/InterstitialAd;->adData:Lcom/amazon/device/ads/AdData;

    invoke-virtual {v3}, Lcom/amazon/device/ads/AdData;->getCreative()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 395
    iget-object v2, p0, Lcom/amazon/device/ads/InterstitialAd;->activity:Landroid/app/Activity;

    invoke-virtual {v2, v1}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 402
    const/4 v2, 0x1

    .end local v1    # "intent":Landroid/content/Intent;
    :goto_0
    return v2

    .line 397
    :catch_0
    move-exception v0

    .line 399
    .local v0, "e":Landroid/content/ActivityNotFoundException;
    const-string/jumbo v2, "InterstitialAd"

    const-string/jumbo v3, "Failed to show the interstitial ad because AdActivity could not be found."

    invoke-static {v2, v3}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 400
    const/4 v2, 0x0

    goto :goto_0
.end method

.method protected submitAndResetMetrics()V
    .locals 2

    .prologue
    .line 733
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/MetricsCollector;->isMetricsCollectorEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 735
    invoke-direct {p0}, Lcom/amazon/device/ads/InterstitialAd;->setAdditionalMetrics()V

    .line 736
    invoke-static {}, Lcom/amazon/device/ads/Metrics;->getInstance()Lcom/amazon/device/ads/Metrics;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/Metrics;->submitAndResetMetrics(Lcom/amazon/device/ads/AdData;)V

    .line 738
    :cond_0
    return-void
.end method

.method submitAndResetMetricsOnMainThread()V
    .locals 3

    .prologue
    .line 706
    const/4 v0, 0x0

    const-wide/16 v1, 0x0

    invoke-virtual {p0, v0, v1, v2}, Lcom/amazon/device/ads/InterstitialAd;->submitAndResetMetricsOnMainThreadAndStartMetric(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 707
    return-void
.end method

.method submitAndResetMetricsOnMainThreadAndStartMetric(Lcom/amazon/device/ads/Metrics$MetricType;J)V
    .locals 2
    .param p1, "metricType"    # Lcom/amazon/device/ads/Metrics$MetricType;
    .param p2, "startTime"    # J

    .prologue
    .line 716
    new-instance v0, Landroid/os/Handler;

    iget-object v1, p0, Lcom/amazon/device/ads/InterstitialAd;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 717
    .local v0, "h":Landroid/os/Handler;
    new-instance v1, Lcom/amazon/device/ads/InterstitialAd$8;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/amazon/device/ads/InterstitialAd$8;-><init>(Lcom/amazon/device/ads/InterstitialAd;Lcom/amazon/device/ads/Metrics$MetricType;J)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 729
    return-void
.end method

.method unregisterBroadcastReceiver()V
    .locals 2

    .prologue
    .line 501
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAd;->activity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/device/ads/InterstitialAd;->broadcastReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 502
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/device/ads/InterstitialAd;->broadcastReceiver:Landroid/content/BroadcastReceiver;

    .line 503
    return-void
.end method
