.class Lcom/amazon/device/ads/AdLoader;
.super Ljava/lang/Object;
.source "AdLoader.java"


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "UseSparseArrays"
    }
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/AdLoader$AdLoaderFactory;,
        Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;,
        Lcom/amazon/device/ads/AdLoader$AdFetchException;
    }
.end annotation


# static fields
.field public static final AD_FAILED:I = -0x1

.field public static final AD_NOT_READY:I = 0x1

.field public static final AD_QUEUED:I

.field protected static final LOG_TAG:Ljava/lang/String;

.field private static adLoaderFactory:Lcom/amazon/device/ads/AdLoader$AdLoaderFactory;


# instance fields
.field protected final adRequest:Lcom/amazon/device/ads/AdRequest;

.field protected compositeMetricsCollector:Lcom/amazon/device/ads/MetricsCollector$CompositeMetricsCollector;

.field protected error:Lcom/amazon/device/ads/AdError;

.field protected final slots:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/amazon/device/ads/AdSlot;",
            ">;"
        }
    .end annotation
.end field

.field protected timeout:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 42
    const-class v0, Lcom/amazon/device/ads/AdLoader;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/ads/AdLoader;->LOG_TAG:Ljava/lang/String;

    .line 48
    new-instance v0, Lcom/amazon/device/ads/AdLoader$AdLoaderFactory;

    invoke-direct {v0}, Lcom/amazon/device/ads/AdLoader$AdLoaderFactory;-><init>()V

    sput-object v0, Lcom/amazon/device/ads/AdLoader;->adLoaderFactory:Lcom/amazon/device/ads/AdLoader$AdLoaderFactory;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/device/ads/AdRequest;Ljava/util/Map;)V
    .locals 2
    .param p1, "adRequest"    # Lcom/amazon/device/ads/AdRequest;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/device/ads/AdRequest;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/amazon/device/ads/AdSlot;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p2, "slots":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Integer;Lcom/amazon/device/ads/AdSlot;>;"
    const/4 v1, 0x0

    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 52
    const/16 v0, 0x4e20

    iput v0, p0, Lcom/amazon/device/ads/AdLoader;->timeout:I

    .line 53
    iput-object v1, p0, Lcom/amazon/device/ads/AdLoader;->error:Lcom/amazon/device/ads/AdError;

    .line 54
    iput-object v1, p0, Lcom/amazon/device/ads/AdLoader;->compositeMetricsCollector:Lcom/amazon/device/ads/MetricsCollector$CompositeMetricsCollector;

    .line 58
    iput-object p1, p0, Lcom/amazon/device/ads/AdLoader;->adRequest:Lcom/amazon/device/ads/AdRequest;

    .line 59
    iput-object p2, p0, Lcom/amazon/device/ads/AdLoader;->slots:Ljava/util/Map;

    .line 60
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/device/ads/AdLoader;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/device/ads/AdLoader;

    .prologue
    .line 40
    invoke-direct {p0}, Lcom/amazon/device/ads/AdLoader;->beginFinalizeFetchAd()V

    return-void
.end method

.method static synthetic access$100(ILcom/amazon/device/ads/AdTargetingOptions;[Lcom/amazon/device/ads/AdSlot;)V
    .locals 0
    .param p0, "x0"    # I
    .param p1, "x1"    # Lcom/amazon/device/ads/AdTargetingOptions;
    .param p2, "x2"    # [Lcom/amazon/device/ads/AdSlot;

    .prologue
    .line 40
    invoke-static {p0, p1, p2}, Lcom/amazon/device/ads/AdLoader;->beginFetchAds(ILcom/amazon/device/ads/AdTargetingOptions;[Lcom/amazon/device/ads/AdSlot;)V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/device/ads/AdError;[Lcom/amazon/device/ads/AdSlot;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/device/ads/AdError;
    .param p1, "x1"    # [Lcom/amazon/device/ads/AdSlot;

    .prologue
    .line 40
    invoke-static {p0, p1}, Lcom/amazon/device/ads/AdLoader;->failAds(Lcom/amazon/device/ads/AdError;[Lcom/amazon/device/ads/AdSlot;)V

    return-void
.end method

.method protected static adFailedToBeReady(ILjava/util/concurrent/atomic/AtomicInteger;Lcom/amazon/device/ads/AdTargetingOptions;[Lcom/amazon/device/ads/AdSlot;I)V
    .locals 2
    .param p0, "timeout"    # I
    .param p1, "waitCount"    # Ljava/util/concurrent/atomic/AtomicInteger;
    .param p2, "requestOptions"    # Lcom/amazon/device/ads/AdTargetingOptions;
    .param p3, "adSlots"    # [Lcom/amazon/device/ads/AdSlot;
    .param p4, "slotId"    # I

    .prologue
    .line 558
    aget-object v0, p3, p4

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/AdSlot;->setSlotNumber(I)V

    .line 559
    invoke-static {p0, p1, p2, p3}, Lcom/amazon/device/ads/AdLoader;->decrementCount(ILjava/util/concurrent/atomic/AtomicInteger;Lcom/amazon/device/ads/AdTargetingOptions;[Lcom/amazon/device/ads/AdSlot;)V

    .line 560
    return-void
.end method

.method private static beginFetchAds(ILcom/amazon/device/ads/AdTargetingOptions;[Lcom/amazon/device/ads/AdSlot;)V
    .locals 12
    .param p0, "timeout"    # I
    .param p1, "requestOptions"    # Lcom/amazon/device/ads/AdTargetingOptions;
    .param p2, "adSlots"    # [Lcom/amazon/device/ads/AdSlot;

    .prologue
    .line 611
    new-instance v1, Lcom/amazon/device/ads/AdvertisingIdentifier;

    invoke-direct {v1}, Lcom/amazon/device/ads/AdvertisingIdentifier;-><init>()V

    .line 612
    .local v1, "advertisingIdentifier":Lcom/amazon/device/ads/AdvertisingIdentifier;
    invoke-virtual {v1}, Lcom/amazon/device/ads/AdvertisingIdentifier;->getAdvertisingIdentifierInfo()Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    move-result-object v2

    .line 614
    .local v2, "advertisingIdentifierInfo":Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    invoke-virtual {v2}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->canDo()Z

    move-result v9

    if-nez v9, :cond_1

    .line 616
    new-instance v9, Lcom/amazon/device/ads/AdError;

    sget-object v10, Lcom/amazon/device/ads/AdError$ErrorCode;->INTERNAL_ERROR:Lcom/amazon/device/ads/AdError$ErrorCode;

    const-string/jumbo v11, "An internal request was not made on a background thread."

    invoke-direct {v9, v10, v11}, Lcom/amazon/device/ads/AdError;-><init>(Lcom/amazon/device/ads/AdError$ErrorCode;Ljava/lang/String;)V

    invoke-static {v9, p2}, Lcom/amazon/device/ads/AdLoader;->failAds(Lcom/amazon/device/ads/AdError;[Lcom/amazon/device/ads/AdSlot;)V

    .line 640
    :cond_0
    :goto_0
    return-void

    .line 620
    :cond_1
    new-instance v9, Lcom/amazon/device/ads/AdRequest;

    invoke-direct {v9, p1}, Lcom/amazon/device/ads/AdRequest;-><init>(Lcom/amazon/device/ads/AdTargetingOptions;)V

    invoke-virtual {v9, v2}, Lcom/amazon/device/ads/AdRequest;->setAdvertisingIdentifierInfo(Lcom/amazon/device/ads/AdvertisingIdentifier$Info;)Lcom/amazon/device/ads/AdRequest;

    move-result-object v7

    .line 622
    .local v7, "request":Lcom/amazon/device/ads/AdRequest;
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    .line 623
    .local v4, "goodAdSlots":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/Integer;Lcom/amazon/device/ads/AdSlot;>;"
    move-object v3, p2

    .local v3, "arr$":[Lcom/amazon/device/ads/AdSlot;
    array-length v6, v3

    .local v6, "len$":I
    const/4 v5, 0x0

    .local v5, "i$":I
    :goto_1
    if-ge v5, v6, :cond_3

    aget-object v8, v3, v5

    .line 625
    .local v8, "slot":Lcom/amazon/device/ads/AdSlot;
    invoke-virtual {v8}, Lcom/amazon/device/ads/AdSlot;->getSlotNumber()I

    move-result v9

    const/4 v10, -0x1

    if-eq v9, v10, :cond_2

    .line 627
    invoke-virtual {v8}, Lcom/amazon/device/ads/AdSlot;->getSlotNumber()I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v4, v9, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 628
    invoke-virtual {v8}, Lcom/amazon/device/ads/AdSlot;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v9

    invoke-virtual {v8}, Lcom/amazon/device/ads/AdSlot;->getSlotNumber()I

    move-result v10

    invoke-virtual {v9, v10}, Lcom/amazon/device/ads/AdData;->setSlotId(I)V

    .line 629
    invoke-virtual {v8}, Lcom/amazon/device/ads/AdSlot;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v9

    invoke-virtual {v8}, Lcom/amazon/device/ads/AdSlot;->getAdTargetingOptions()Lcom/amazon/device/ads/AdTargetingOptions;

    move-result-object v10

    invoke-virtual {v7, v9, v10}, Lcom/amazon/device/ads/AdRequest;->putSlot(Lcom/amazon/device/ads/AdData;Lcom/amazon/device/ads/AdTargetingOptions;)V

    .line 623
    :cond_2
    add-int/lit8 v5, v5, 0x1

    goto :goto_1

    .line 633
    .end local v8    # "slot":Lcom/amazon/device/ads/AdSlot;
    :cond_3
    invoke-virtual {v4}, Ljava/util/HashMap;->size()I

    move-result v9

    if-lez v9, :cond_0

    .line 635
    sget-object v9, Lcom/amazon/device/ads/AdLoader;->adLoaderFactory:Lcom/amazon/device/ads/AdLoader$AdLoaderFactory;

    invoke-virtual {v9, v7, v4}, Lcom/amazon/device/ads/AdLoader$AdLoaderFactory;->createAdLoader(Lcom/amazon/device/ads/AdRequest;Ljava/util/Map;)Lcom/amazon/device/ads/AdLoader;

    move-result-object v0

    .line 636
    .local v0, "adLoader":Lcom/amazon/device/ads/AdLoader;
    invoke-virtual {v0, p0}, Lcom/amazon/device/ads/AdLoader;->setTimeout(I)V

    .line 637
    invoke-virtual {v0}, Lcom/amazon/device/ads/AdLoader;->beginFetchAd()V

    goto :goto_0
.end method

.method private beginFinalizeFetchAd()V
    .locals 2

    .prologue
    .line 97
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 98
    .local v0, "handler":Landroid/os/Handler;
    new-instance v1, Lcom/amazon/device/ads/AdLoader$2;

    invoke-direct {v1, p0}, Lcom/amazon/device/ads/AdLoader$2;-><init>(Lcom/amazon/device/ads/AdLoader;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 106
    return-void
.end method

.method protected static decrementCount(ILjava/util/concurrent/atomic/AtomicInteger;Lcom/amazon/device/ads/AdTargetingOptions;[Lcom/amazon/device/ads/AdSlot;)V
    .locals 2
    .param p0, "timeout"    # I
    .param p1, "waitCount"    # Ljava/util/concurrent/atomic/AtomicInteger;
    .param p2, "requestOptions"    # Lcom/amazon/device/ads/AdTargetingOptions;
    .param p3, "adSlots"    # [Lcom/amazon/device/ads/AdSlot;

    .prologue
    .line 572
    invoke-virtual {p1}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    move-result v1

    if-nez v1, :cond_0

    .line 574
    new-instance v0, Lcom/amazon/device/ads/AdLoader$3;

    invoke-direct {v0, p0, p2, p3}, Lcom/amazon/device/ads/AdLoader$3;-><init>(ILcom/amazon/device/ads/AdTargetingOptions;[Lcom/amazon/device/ads/AdSlot;)V

    .line 599
    .local v0, "waiter":Lcom/amazon/device/ads/StartUpWaiter;
    invoke-virtual {v0}, Lcom/amazon/device/ads/StartUpWaiter;->start()V

    .line 601
    .end local v0    # "waiter":Lcom/amazon/device/ads/StartUpWaiter;
    :cond_0
    return-void
.end method

.method private static failAds(Lcom/amazon/device/ads/AdError;[Lcom/amazon/device/ads/AdSlot;)V
    .locals 10
    .param p0, "adError"    # Lcom/amazon/device/ads/AdError;
    .param p1, "adSlots"    # [Lcom/amazon/device/ads/AdSlot;

    .prologue
    .line 649
    const/4 v0, 0x0

    .line 650
    .local v0, "adFailCount":I
    move-object v1, p1

    .local v1, "arr$":[Lcom/amazon/device/ads/AdSlot;
    array-length v3, v1

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_1

    aget-object v4, v1, v2

    .line 652
    .local v4, "slot":Lcom/amazon/device/ads/AdSlot;
    invoke-virtual {v4}, Lcom/amazon/device/ads/AdSlot;->getSlotNumber()I

    move-result v5

    const/4 v6, -0x1

    if-eq v5, v6, :cond_0

    .line 654
    invoke-virtual {v4}, Lcom/amazon/device/ads/AdSlot;->getAdLoaderCallback()Lcom/amazon/device/ads/IAdLoaderCallback;

    move-result-object v5

    invoke-interface {v5, p0}, Lcom/amazon/device/ads/IAdLoaderCallback;->adFailed(Lcom/amazon/device/ads/AdError;)V

    .line 655
    add-int/lit8 v0, v0, 0x1

    .line 650
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 658
    .end local v4    # "slot":Lcom/amazon/device/ads/AdSlot;
    :cond_1
    if-lez v0, :cond_2

    .line 660
    sget-object v5, Lcom/amazon/device/ads/AdLoader;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v6, "%s; code: %s"

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    invoke-virtual {p0}, Lcom/amazon/device/ads/AdError;->getMessage()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    const/4 v8, 0x1

    invoke-virtual {p0}, Lcom/amazon/device/ads/AdError;->getCode()Lcom/amazon/device/ads/AdError$ErrorCode;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-static {v5, v6, v7}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 662
    :cond_2
    return-void
.end method

.method private getAdRequest()Lcom/amazon/device/ads/WebRequest;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/device/ads/AdLoader$AdFetchException;
        }
    .end annotation

    .prologue
    .line 167
    invoke-direct {p0}, Lcom/amazon/device/ads/AdLoader;->getCompositeMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v1

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_CREATE_AAX_GET_AD_URL:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v1, v2}, Lcom/amazon/device/ads/MetricsCollector;->startMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 168
    iget-object v1, p0, Lcom/amazon/device/ads/AdLoader;->adRequest:Lcom/amazon/device/ads/AdRequest;

    invoke-virtual {v1}, Lcom/amazon/device/ads/AdRequest;->getWebRequest()Lcom/amazon/device/ads/WebRequest;

    move-result-object v0

    .line 169
    .local v0, "request":Lcom/amazon/device/ads/WebRequest;
    invoke-direct {p0}, Lcom/amazon/device/ads/AdLoader;->getCompositeMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v1

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_CREATE_AAX_GET_AD_URL:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v1, v2}, Lcom/amazon/device/ads/MetricsCollector;->stopMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 170
    return-object v0
.end method

.method private getCompositeMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;
    .locals 4

    .prologue
    .line 443
    iget-object v3, p0, Lcom/amazon/device/ads/AdLoader;->compositeMetricsCollector:Lcom/amazon/device/ads/MetricsCollector$CompositeMetricsCollector;

    if-nez v3, :cond_1

    .line 445
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 446
    .local v0, "collectors":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/amazon/device/ads/MetricsCollector;>;"
    iget-object v3, p0, Lcom/amazon/device/ads/AdLoader;->slots:Ljava/util/Map;

    invoke-interface {v3}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 448
    .local v1, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Integer;Lcom/amazon/device/ads/AdSlot;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/device/ads/AdSlot;

    invoke-virtual {v3}, Lcom/amazon/device/ads/AdSlot;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 450
    .end local v1    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Integer;Lcom/amazon/device/ads/AdSlot;>;"
    :cond_0
    new-instance v3, Lcom/amazon/device/ads/MetricsCollector$CompositeMetricsCollector;

    invoke-direct {v3, v0}, Lcom/amazon/device/ads/MetricsCollector$CompositeMetricsCollector;-><init>(Ljava/util/ArrayList;)V

    iput-object v3, p0, Lcom/amazon/device/ads/AdLoader;->compositeMetricsCollector:Lcom/amazon/device/ads/MetricsCollector$CompositeMetricsCollector;

    .line 452
    .end local v0    # "collectors":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/amazon/device/ads/MetricsCollector;>;"
    .end local v2    # "i$":Ljava/util/Iterator;
    :cond_1
    iget-object v3, p0, Lcom/amazon/device/ads/AdLoader;->compositeMetricsCollector:Lcom/amazon/device/ads/MetricsCollector$CompositeMetricsCollector;

    return-object v3
.end method

.method private static isNoRetry([Lcom/amazon/device/ads/AdSlot;)Z
    .locals 11
    .param p0, "adSlots"    # [Lcom/amazon/device/ads/AdSlot;

    .prologue
    .line 666
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v9

    invoke-interface {v9}, Lcom/amazon/device/ads/IInternalAdRegistration;->getNoRetryTtlRemainingMillis()I

    move-result v7

    .line 667
    .local v7, "noRetryTtlRemainingMillis":I
    if-lez v7, :cond_4

    .line 669
    div-int/lit16 v8, v7, 0x3e8

    .line 670
    .local v8, "noRetryTtlRemainingSecs":I
    const-string/jumbo v4, "SDK Message: "

    .line 672
    .local v4, "errorMessage":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v9

    invoke-interface {v9}, Lcom/amazon/device/ads/IInternalAdRegistration;->getIsAppDisabled()Z

    move-result v9

    if-eqz v9, :cond_2

    .line 674
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v9, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-static {}, Lcom/amazon/device/ads/Utils;->getDisabledAppServerMessage()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 675
    sget-object v3, Lcom/amazon/device/ads/AdError$ErrorCode;->INTERNAL_ERROR:Lcom/amazon/device/ads/AdError$ErrorCode;

    .line 682
    .local v3, "errorCode":Lcom/amazon/device/ads/AdError$ErrorCode;
    :goto_0
    sget-object v9, Lcom/amazon/device/ads/AdLoader;->LOG_TAG:Ljava/lang/String;

    invoke-static {v9, v4}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 683
    new-instance v0, Lcom/amazon/device/ads/AdError;

    invoke-direct {v0, v3, v4}, Lcom/amazon/device/ads/AdError;-><init>(Lcom/amazon/device/ads/AdError$ErrorCode;Ljava/lang/String;)V

    .line 684
    .local v0, "adError":Lcom/amazon/device/ads/AdError;
    move-object v2, p0

    .local v2, "arr$":[Lcom/amazon/device/ads/AdSlot;
    array-length v6, v2

    .local v6, "len$":I
    const/4 v5, 0x0

    .local v5, "i$":I
    :goto_1
    if-ge v5, v6, :cond_3

    aget-object v1, v2, v5

    .line 686
    .local v1, "adSlot":Lcom/amazon/device/ads/AdSlot;
    invoke-virtual {v1}, Lcom/amazon/device/ads/AdSlot;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v9

    if-eqz v9, :cond_0

    invoke-virtual {v1}, Lcom/amazon/device/ads/AdSlot;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v9

    invoke-virtual {v9}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v9

    if-eqz v9, :cond_0

    .line 688
    invoke-virtual {v1}, Lcom/amazon/device/ads/AdSlot;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v9

    invoke-virtual {v9}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v9

    sget-object v10, Lcom/amazon/device/ads/Metrics$MetricType;->AD_COUNTER_FAILED_DUE_TO_NO_RETRY:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v9, v10}, Lcom/amazon/device/ads/MetricsCollector;->incrementMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 690
    :cond_0
    invoke-virtual {v1}, Lcom/amazon/device/ads/AdSlot;->getAdLoaderCallback()Lcom/amazon/device/ads/IAdLoaderCallback;

    move-result-object v9

    if-eqz v9, :cond_1

    .line 692
    invoke-virtual {v1}, Lcom/amazon/device/ads/AdSlot;->getAdLoaderCallback()Lcom/amazon/device/ads/IAdLoaderCallback;

    move-result-object v9

    invoke-interface {v9, v0}, Lcom/amazon/device/ads/IAdLoaderCallback;->adFailed(Lcom/amazon/device/ads/AdError;)V

    .line 684
    :cond_1
    add-int/lit8 v5, v5, 0x1

    goto :goto_1

    .line 679
    .end local v0    # "adError":Lcom/amazon/device/ads/AdError;
    .end local v1    # "adSlot":Lcom/amazon/device/ads/AdSlot;
    .end local v2    # "arr$":[Lcom/amazon/device/ads/AdSlot;
    .end local v3    # "errorCode":Lcom/amazon/device/ads/AdError$ErrorCode;
    .end local v5    # "i$":I
    .end local v6    # "len$":I
    :cond_2
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v9, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string/jumbo v10, "no results. Try again in "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string/jumbo v10, " seconds."

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 680
    sget-object v3, Lcom/amazon/device/ads/AdError$ErrorCode;->NO_FILL:Lcom/amazon/device/ads/AdError$ErrorCode;

    .restart local v3    # "errorCode":Lcom/amazon/device/ads/AdError$ErrorCode;
    goto :goto_0

    .line 696
    .restart local v0    # "adError":Lcom/amazon/device/ads/AdError;
    .restart local v2    # "arr$":[Lcom/amazon/device/ads/AdSlot;
    .restart local v5    # "i$":I
    .restart local v6    # "len$":I
    :cond_3
    const/4 v9, 0x1

    .line 698
    .end local v0    # "adError":Lcom/amazon/device/ads/AdError;
    .end local v2    # "arr$":[Lcom/amazon/device/ads/AdSlot;
    .end local v3    # "errorCode":Lcom/amazon/device/ads/AdError$ErrorCode;
    .end local v4    # "errorMessage":Ljava/lang/String;
    .end local v5    # "i$":I
    .end local v6    # "len$":I
    .end local v8    # "noRetryTtlRemainingSecs":I
    :goto_2
    return v9

    :cond_4
    const/4 v9, 0x0

    goto :goto_2
.end method

.method protected static varargs loadAds(ILcom/amazon/device/ads/AdTargetingOptions;[Lcom/amazon/device/ads/Ad;)[Z
    .locals 5
    .param p0, "timeout"    # I
    .param p1, "requestOptions"    # Lcom/amazon/device/ads/AdTargetingOptions;
    .param p2, "ads"    # [Lcom/amazon/device/ads/Ad;

    .prologue
    .line 539
    array-length v2, p2

    new-array v1, v2, [Lcom/amazon/device/ads/AdSlot;

    .line 540
    .local v1, "slots":[Lcom/amazon/device/ads/AdSlot;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v2, p2

    if-ge v0, v2, :cond_0

    .line 542
    new-instance v2, Lcom/amazon/device/ads/AdSlot;

    aget-object v3, p2, v0

    new-instance v4, Lcom/amazon/device/ads/AdTargetingOptions;

    invoke-direct {v4}, Lcom/amazon/device/ads/AdTargetingOptions;-><init>()V

    invoke-direct {v2, v3, v4}, Lcom/amazon/device/ads/AdSlot;-><init>(Lcom/amazon/device/ads/Ad;Lcom/amazon/device/ads/AdTargetingOptions;)V

    aput-object v2, v1, v0

    .line 540
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 544
    :cond_0
    invoke-static {p0, p1, v1}, Lcom/amazon/device/ads/AdLoader;->loadAds(ILcom/amazon/device/ads/AdTargetingOptions;[Lcom/amazon/device/ads/AdSlot;)[Z

    move-result-object v2

    return-object v2
.end method

.method protected static varargs loadAds(ILcom/amazon/device/ads/AdTargetingOptions;[Lcom/amazon/device/ads/AdSlot;)[Z
    .locals 11
    .param p0, "timeout"    # I
    .param p1, "requestOptions"    # Lcom/amazon/device/ads/AdTargetingOptions;
    .param p2, "adSlots"    # [Lcom/amazon/device/ads/AdSlot;

    .prologue
    const/4 v10, 0x1

    .line 488
    if-nez p1, :cond_0

    .line 490
    new-instance p1, Lcom/amazon/device/ads/AdTargetingOptions;

    .end local p1    # "requestOptions":Lcom/amazon/device/ads/AdTargetingOptions;
    invoke-direct {p1}, Lcom/amazon/device/ads/AdTargetingOptions;-><init>()V

    .line 493
    .restart local p1    # "requestOptions":Lcom/amazon/device/ads/AdTargetingOptions;
    :cond_0
    array-length v9, p2

    new-array v8, v9, [Z

    .line 494
    .local v8, "responses":[Z
    invoke-static {p2}, Lcom/amazon/device/ads/AdLoader;->isNoRetry([Lcom/amazon/device/ads/AdSlot;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 496
    invoke-static {v8, v10}, Ljava/util/Arrays;->fill([ZZ)V

    .line 527
    :cond_1
    return-object v8

    .line 499
    :cond_2
    new-instance v5, Ljava/util/concurrent/atomic/AtomicInteger;

    array-length v9, p2

    invoke-direct {v5, v9}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    .line 500
    .local v5, "numberOfAdsNotReadyYet":Ljava/util/concurrent/atomic/AtomicInteger;
    new-instance v4, Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;

    invoke-direct {v4, p0, v5, p1, p2}, Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;-><init>(ILjava/util/concurrent/atomic/AtomicInteger;Lcom/amazon/device/ads/AdTargetingOptions;[Lcom/amazon/device/ads/AdSlot;)V

    .line 501
    .local v4, "listener":Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;
    const/4 v6, 0x0

    .line 502
    .local v6, "numberOfAdsStartedPreparing":I
    move-object v1, p2

    .local v1, "arr$":[Lcom/amazon/device/ads/AdSlot;
    array-length v3, v1

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_1

    aget-object v0, v1, v2

    .line 505
    .local v0, "adSlot":Lcom/amazon/device/ads/AdSlot;
    add-int/lit8 v9, v6, 0x1

    invoke-virtual {v0, v9}, Lcom/amazon/device/ads/AdSlot;->setSlotNumber(I)V

    .line 506
    invoke-virtual {v0}, Lcom/amazon/device/ads/AdSlot;->getAdWrapper()Lcom/amazon/device/ads/AdWrapper;

    move-result-object v9

    invoke-interface {v9, v4}, Lcom/amazon/device/ads/AdWrapper;->prepareAd(Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;)I

    move-result v7

    .line 507
    .local v7, "response":I
    if-eqz v7, :cond_4

    .line 510
    invoke-static {p0, v5, p1, p2, v6}, Lcom/amazon/device/ads/AdLoader;->adFailedToBeReady(ILjava/util/concurrent/atomic/AtomicInteger;Lcom/amazon/device/ads/AdTargetingOptions;[Lcom/amazon/device/ads/AdSlot;I)V

    .line 511
    const/4 v9, -0x1

    if-ne v7, v9, :cond_3

    .line 513
    const/4 v9, 0x0

    aput-boolean v9, v8, v6

    .line 525
    :goto_1
    add-int/lit8 v6, v6, 0x1

    .line 502
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 517
    :cond_3
    aput-boolean v10, v8, v6

    goto :goto_1

    .line 523
    :cond_4
    aput-boolean v10, v8, v6

    goto :goto_1
.end method

.method private parseResponse(Lorg/json/JSONObject;)V
    .locals 41
    .param p1, "jsonResponse"    # Lorg/json/JSONObject;

    .prologue
    .line 193
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v15

    .line 194
    .local v15, "currentTime":J
    const-string/jumbo v36, "status"

    const/16 v37, 0x0

    move-object/from16 v0, p1

    move-object/from16 v1, v36

    move-object/from16 v2, v37

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/JSONUtils;->getStringFromJSON(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v35

    .line 196
    .local v35, "status":Ljava/lang/String;
    new-instance v34, Ljava/util/HashSet;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/device/ads/AdLoader;->slots:Ljava/util/Map;

    move-object/from16 v36, v0

    invoke-interface/range {v36 .. v36}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v36

    move-object/from16 v0, v34

    move-object/from16 v1, v36

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    .line 197
    .local v34, "slotsNotReceived":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/Integer;>;"
    invoke-virtual/range {p0 .. p1}, Lcom/amazon/device/ads/AdLoader;->getAdError(Lorg/json/JSONObject;)Lcom/amazon/device/ads/AdError;

    move-result-object v5

    .line 198
    .local v5, "adError":Lcom/amazon/device/ads/AdError;
    const-string/jumbo v36, "errorCode"

    const-string/jumbo v37, "No Ad Received"

    move-object/from16 v0, p1

    move-object/from16 v1, v36

    move-object/from16 v2, v37

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/JSONUtils;->getStringFromJSON(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    .line 199
    .local v18, "errorCode":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/device/ads/AdLoader;->adRequest:Lcom/amazon/device/ads/AdRequest;

    move-object/from16 v36, v0

    const-string/jumbo v37, "instrPixelURL"

    const/16 v38, 0x0

    move-object/from16 v0, p1

    move-object/from16 v1, v37

    move-object/from16 v2, v38

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/JSONUtils;->getStringFromJSON(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    invoke-virtual/range {v36 .. v37}, Lcom/amazon/device/ads/AdRequest;->setInstrumentationPixelURL(Ljava/lang/String;)V

    .line 201
    if-eqz v35, :cond_b

    const-string/jumbo v36, "ok"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v36

    if-eqz v36, :cond_b

    .line 203
    const-string/jumbo v36, "ads"

    move-object/from16 v0, p1

    move-object/from16 v1, v36

    invoke-static {v0, v1}, Lcom/amazon/device/ads/JSONUtils;->getJSONArrayFromJSON(Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v10

    .line 204
    .local v10, "adsArray":Lorg/json/JSONArray;
    const/16 v23, 0x0

    .local v23, "i":I
    :goto_0
    invoke-virtual {v10}, Lorg/json/JSONArray;->length()I

    move-result v36

    move/from16 v0, v23

    move/from16 v1, v36

    if-ge v0, v1, :cond_b

    .line 206
    move/from16 v0, v23

    invoke-static {v10, v0}, Lcom/amazon/device/ads/JSONUtils;->getJSONObjectFromJSONArray(Lorg/json/JSONArray;I)Lorg/json/JSONObject;

    move-result-object v32

    .line 207
    .local v32, "slot":Lorg/json/JSONObject;
    if-nez v32, :cond_1

    .line 204
    :cond_0
    :goto_1
    add-int/lit8 v23, v23, 0x1

    goto :goto_0

    .line 211
    :cond_1
    const-string/jumbo v36, "slotId"

    const/16 v37, -0x1

    move-object/from16 v0, v32

    move-object/from16 v1, v36

    move/from16 v2, v37

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/JSONUtils;->getIntegerFromJSON(Lorg/json/JSONObject;Ljava/lang/String;I)I

    move-result v33

    .line 212
    .local v33, "slotId":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/device/ads/AdLoader;->slots:Ljava/util/Map;

    move-object/from16 v36, v0

    invoke-static/range {v33 .. v33}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v37

    invoke-interface/range {v36 .. v37}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/amazon/device/ads/AdSlot;

    .line 213
    .local v8, "adSlot":Lcom/amazon/device/ads/AdSlot;
    if-eqz v8, :cond_0

    .line 215
    invoke-static/range {v33 .. v33}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v36

    move-object/from16 v0, v34

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->remove(Ljava/lang/Object;)Z

    .line 216
    const-string/jumbo v36, "instrPixelURL"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/device/ads/AdLoader;->adRequest:Lcom/amazon/device/ads/AdRequest;

    move-object/from16 v37, v0

    invoke-virtual/range {v37 .. v37}, Lcom/amazon/device/ads/AdRequest;->getInstrumentationPixelURL()Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v32

    move-object/from16 v1, v36

    move-object/from16 v2, v37

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/JSONUtils;->getStringFromJSON(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 217
    .local v7, "adPixelUrl":Ljava/lang/String;
    invoke-virtual {v8}, Lcom/amazon/device/ads/AdSlot;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v36

    move-object/from16 v0, v36

    invoke-virtual {v0, v7}, Lcom/amazon/device/ads/AdData;->setInstrumentationPixelUrl(Ljava/lang/String;)V

    .line 218
    const-string/jumbo v36, "impPixelURL"

    const/16 v37, 0x0

    move-object/from16 v0, v32

    move-object/from16 v1, v36

    move-object/from16 v2, v37

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/JSONUtils;->getStringFromJSON(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v25

    .line 219
    .local v25, "impPixelUrl":Ljava/lang/String;
    invoke-virtual {v8}, Lcom/amazon/device/ads/AdSlot;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v36

    move-object/from16 v0, v36

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/AdData;->setImpressionPixelUrl(Ljava/lang/String;)V

    .line 220
    invoke-virtual {v8}, Lcom/amazon/device/ads/AdSlot;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v36

    invoke-virtual/range {v36 .. v36}, Lcom/amazon/device/ads/AdData;->getRequestedAdSize()Lcom/amazon/device/ads/AdSize;

    move-result-object v36

    invoke-virtual/range {v36 .. v36}, Lcom/amazon/device/ads/AdSize;->isAuto()Z

    move-result v36

    if-eqz v36, :cond_2

    .line 222
    invoke-virtual {v8}, Lcom/amazon/device/ads/AdSlot;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v36

    invoke-virtual/range {v36 .. v36}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v36

    sget-object v37, Lcom/amazon/device/ads/Metrics$MetricType;->AD_COUNTER_AUTO_AD_SIZE:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual/range {v36 .. v37}, Lcom/amazon/device/ads/MetricsCollector;->incrementMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 224
    :cond_2
    const-string/jumbo v36, "html"

    const-string/jumbo v37, ""

    move-object/from16 v0, v32

    move-object/from16 v1, v36

    move-object/from16 v2, v37

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/JSONUtils;->getStringFromJSON(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 226
    .local v11, "creative":Ljava/lang/String;
    const-string/jumbo v36, "creativeTypes"

    move-object/from16 v0, v32

    move-object/from16 v1, v36

    invoke-static {v0, v1}, Lcom/amazon/device/ads/JSONUtils;->getJSONArrayFromJSON(Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v14

    .line 228
    .local v14, "creativeTypes":Lorg/json/JSONArray;
    new-instance v12, Ljava/util/HashSet;

    invoke-direct {v12}, Ljava/util/HashSet;-><init>()V

    .line 229
    .local v12, "creativeSet":Ljava/util/HashSet;, "Ljava/util/HashSet<Lcom/amazon/device/ads/AdData$AAXCreative;>;"
    if-eqz v14, :cond_4

    .line 231
    const/16 v26, 0x0

    .local v26, "j":I
    :goto_2
    invoke-virtual {v14}, Lorg/json/JSONArray;->length()I

    move-result v36

    move/from16 v0, v26

    move/from16 v1, v36

    if-ge v0, v1, :cond_4

    .line 233
    const/16 v36, 0x0

    move/from16 v0, v26

    move/from16 v1, v36

    invoke-static {v14, v0, v1}, Lcom/amazon/device/ads/JSONUtils;->getIntegerFromJSONArray(Lorg/json/JSONArray;II)I

    move-result v13

    .line 234
    .local v13, "creativeType":I
    invoke-static {v13}, Lcom/amazon/device/ads/AdData$AAXCreative;->getCreative(I)Lcom/amazon/device/ads/AdData$AAXCreative;

    move-result-object v4

    .line 238
    .local v4, "aaxCreative":Lcom/amazon/device/ads/AdData$AAXCreative;
    if-eqz v4, :cond_3

    .line 240
    invoke-virtual {v12, v4}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 231
    :cond_3
    add-int/lit8 v26, v26, 0x1

    goto :goto_2

    .line 245
    .end local v4    # "aaxCreative":Lcom/amazon/device/ads/AdData$AAXCreative;
    .end local v13    # "creativeType":I
    .end local v26    # "j":I
    :cond_4
    invoke-virtual {v12}, Ljava/util/HashSet;->isEmpty()Z

    move-result v36

    if-eqz v36, :cond_5

    .line 248
    const-string/jumbo v27, "No valid creative types found"

    .line 249
    .local v27, "msg":Ljava/lang/String;
    new-instance v36, Lcom/amazon/device/ads/AdError;

    sget-object v37, Lcom/amazon/device/ads/AdError$ErrorCode;->INTERNAL_ERROR:Lcom/amazon/device/ads/AdError$ErrorCode;

    const-string/jumbo v38, "No valid creative types found"

    invoke-direct/range {v36 .. v38}, Lcom/amazon/device/ads/AdError;-><init>(Lcom/amazon/device/ads/AdError$ErrorCode;Ljava/lang/String;)V

    move-object/from16 v0, v36

    invoke-virtual {v8, v0}, Lcom/amazon/device/ads/AdSlot;->setAdError(Lcom/amazon/device/ads/AdError;)V

    .line 250
    sget-object v36, Lcom/amazon/device/ads/AdLoader;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v37, "No valid creative types found"

    invoke-static/range {v36 .. v37}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 254
    .end local v27    # "msg":Ljava/lang/String;
    :cond_5
    const-string/jumbo v36, "size"

    const-string/jumbo v37, ""

    move-object/from16 v0, v32

    move-object/from16 v1, v36

    move-object/from16 v2, v37

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/JSONUtils;->getStringFromJSON(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v29

    .line 255
    .local v29, "size":Ljava/lang/String;
    const/4 v9, 0x0

    .line 256
    .local v9, "adWidth":I
    const/4 v6, 0x0

    .line 257
    .local v6, "adHeight":I
    sget-object v36, Lcom/amazon/device/ads/AdData$AAXCreative;->INTERSTITIAL:Lcom/amazon/device/ads/AdData$AAXCreative;

    move-object/from16 v0, v36

    invoke-virtual {v12, v0}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v36

    if-nez v36, :cond_9

    .line 259
    const/16 v30, 0x0

    .line 260
    .local v30, "sizeIsInvalid":Z
    if-eqz v29, :cond_7

    const-string/jumbo v36, "x"

    move-object/from16 v0, v29

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v31

    .line 261
    .local v31, "sizes":[Ljava/lang/String;
    :goto_3
    if-eqz v31, :cond_6

    move-object/from16 v0, v31

    array-length v0, v0

    move/from16 v36, v0

    const/16 v37, 0x2

    move/from16 v0, v36

    move/from16 v1, v37

    if-eq v0, v1, :cond_8

    .line 263
    :cond_6
    const/16 v30, 0x1

    .line 277
    :goto_4
    if-eqz v30, :cond_9

    .line 280
    const-string/jumbo v27, "Server returned an invalid ad size"

    .line 281
    .restart local v27    # "msg":Ljava/lang/String;
    new-instance v36, Lcom/amazon/device/ads/AdError;

    sget-object v37, Lcom/amazon/device/ads/AdError$ErrorCode;->INTERNAL_ERROR:Lcom/amazon/device/ads/AdError$ErrorCode;

    const-string/jumbo v38, "Server returned an invalid ad size"

    invoke-direct/range {v36 .. v38}, Lcom/amazon/device/ads/AdError;-><init>(Lcom/amazon/device/ads/AdError$ErrorCode;Ljava/lang/String;)V

    move-object/from16 v0, v36

    invoke-virtual {v8, v0}, Lcom/amazon/device/ads/AdSlot;->setAdError(Lcom/amazon/device/ads/AdError;)V

    .line 282
    sget-object v36, Lcom/amazon/device/ads/AdLoader;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v37, "Server returned an invalid ad size"

    invoke-static/range {v36 .. v37}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 260
    .end local v27    # "msg":Ljava/lang/String;
    .end local v31    # "sizes":[Ljava/lang/String;
    :cond_7
    const/16 v31, 0x0

    goto :goto_3

    .line 269
    .restart local v31    # "sizes":[Ljava/lang/String;
    :cond_8
    const/16 v36, 0x0

    :try_start_0
    aget-object v36, v31, v36

    invoke-static/range {v36 .. v36}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v9

    .line 270
    const/16 v36, 0x1

    aget-object v36, v31, v36

    invoke-static/range {v36 .. v36}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v6

    goto :goto_4

    .line 272
    :catch_0
    move-exception v17

    .line 274
    .local v17, "e":Ljava/lang/NumberFormatException;
    const/16 v30, 0x1

    goto :goto_4

    .line 286
    .end local v17    # "e":Ljava/lang/NumberFormatException;
    .end local v30    # "sizeIsInvalid":Z
    .end local v31    # "sizes":[Ljava/lang/String;
    :cond_9
    const-string/jumbo v36, "cacheTTL"

    const-wide/16 v37, -0x1

    move-object/from16 v0, v32

    move-object/from16 v1, v36

    move-wide/from16 v2, v37

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/device/ads/JSONUtils;->getLongFromJSON(Lorg/json/JSONObject;Ljava/lang/String;J)J

    move-result-wide v19

    .line 287
    .local v19, "expiration":J
    const-wide/16 v36, -0x1

    cmp-long v36, v19, v36

    if-lez v36, :cond_a

    .line 289
    const-wide/16 v36, 0x3e8

    mul-long v36, v36, v19

    add-long v21, v15, v36

    .line 290
    .local v21, "expirationTimeMs":J
    invoke-virtual {v8}, Lcom/amazon/device/ads/AdSlot;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v36

    move-object/from16 v0, v36

    move-wide/from16 v1, v21

    invoke-virtual {v0, v1, v2}, Lcom/amazon/device/ads/AdData;->setExpirationTimeMillis(J)V

    .line 293
    .end local v21    # "expirationTimeMs":J
    :cond_a
    new-instance v28, Lcom/amazon/device/ads/AdProperties;

    move-object/from16 v0, v28

    invoke-direct {v0, v14}, Lcom/amazon/device/ads/AdProperties;-><init>(Lorg/json/JSONArray;)V

    .line 295
    .local v28, "props":Lcom/amazon/device/ads/AdProperties;
    invoke-virtual {v8}, Lcom/amazon/device/ads/AdSlot;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v36

    move-object/from16 v0, v36

    invoke-virtual {v0, v6}, Lcom/amazon/device/ads/AdData;->setHeight(I)V

    .line 296
    invoke-virtual {v8}, Lcom/amazon/device/ads/AdSlot;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v36

    move-object/from16 v0, v36

    invoke-virtual {v0, v9}, Lcom/amazon/device/ads/AdData;->setWidth(I)V

    .line 297
    invoke-virtual {v8}, Lcom/amazon/device/ads/AdSlot;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v36

    move-object/from16 v0, v36

    invoke-virtual {v0, v11}, Lcom/amazon/device/ads/AdData;->setCreative(Ljava/lang/String;)V

    .line 298
    invoke-virtual {v8}, Lcom/amazon/device/ads/AdSlot;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v36

    move-object/from16 v0, v36

    invoke-virtual {v0, v12}, Lcom/amazon/device/ads/AdData;->setCreativeTypes(Ljava/util/Set;)V

    .line 299
    invoke-virtual {v8}, Lcom/amazon/device/ads/AdSlot;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v36

    move-object/from16 v0, v36

    move-object/from16 v1, v28

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/AdData;->setProperties(Lcom/amazon/device/ads/AdProperties;)V

    .line 300
    invoke-virtual {v8}, Lcom/amazon/device/ads/AdSlot;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v36

    const/16 v37, 0x1

    invoke-virtual/range {v36 .. v37}, Lcom/amazon/device/ads/AdData;->setFetched(Z)V

    goto/16 :goto_1

    .line 304
    .end local v6    # "adHeight":I
    .end local v7    # "adPixelUrl":Ljava/lang/String;
    .end local v8    # "adSlot":Lcom/amazon/device/ads/AdSlot;
    .end local v9    # "adWidth":I
    .end local v10    # "adsArray":Lorg/json/JSONArray;
    .end local v11    # "creative":Ljava/lang/String;
    .end local v12    # "creativeSet":Ljava/util/HashSet;, "Ljava/util/HashSet<Lcom/amazon/device/ads/AdData$AAXCreative;>;"
    .end local v14    # "creativeTypes":Lorg/json/JSONArray;
    .end local v19    # "expiration":J
    .end local v23    # "i":I
    .end local v25    # "impPixelUrl":Ljava/lang/String;
    .end local v28    # "props":Lcom/amazon/device/ads/AdProperties;
    .end local v29    # "size":Ljava/lang/String;
    .end local v32    # "slot":Lorg/json/JSONObject;
    .end local v33    # "slotId":I
    :cond_b
    invoke-virtual/range {v34 .. v34}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v24

    .local v24, "i$":Ljava/util/Iterator;
    :goto_5
    invoke-interface/range {v24 .. v24}, Ljava/util/Iterator;->hasNext()Z

    move-result v36

    if-eqz v36, :cond_c

    invoke-interface/range {v24 .. v24}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v33

    check-cast v33, Ljava/lang/Integer;

    .line 306
    .local v33, "slotId":Ljava/lang/Integer;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/device/ads/AdLoader;->slots:Ljava/util/Map;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    move-object/from16 v1, v33

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v36

    check-cast v36, Lcom/amazon/device/ads/AdSlot;

    move-object/from16 v0, v36

    invoke-virtual {v0, v5}, Lcom/amazon/device/ads/AdSlot;->setAdError(Lcom/amazon/device/ads/AdError;)V

    .line 307
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/device/ads/AdLoader;->slots:Ljava/util/Map;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    move-object/from16 v1, v33

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v36

    check-cast v36, Lcom/amazon/device/ads/AdSlot;

    invoke-virtual/range {v36 .. v36}, Lcom/amazon/device/ads/AdSlot;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v36

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/device/ads/AdLoader;->adRequest:Lcom/amazon/device/ads/AdRequest;

    move-object/from16 v37, v0

    invoke-virtual/range {v37 .. v37}, Lcom/amazon/device/ads/AdRequest;->getInstrumentationPixelURL()Ljava/lang/String;

    move-result-object v37

    invoke-virtual/range {v36 .. v37}, Lcom/amazon/device/ads/AdData;->setInstrumentationPixelUrl(Ljava/lang/String;)V

    .line 308
    sget-object v36, Lcom/amazon/device/ads/AdLoader;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v37, "%s; code: %s"

    const/16 v38, 0x2

    move/from16 v0, v38

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v38, v0

    const/16 v39, 0x0

    invoke-virtual {v5}, Lcom/amazon/device/ads/AdError;->getMessage()Ljava/lang/String;

    move-result-object v40

    aput-object v40, v38, v39

    const/16 v39, 0x1

    aput-object v18, v38, v39

    invoke-static/range {v36 .. v38}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_5

    .line 310
    .end local v33    # "slotId":Ljava/lang/Integer;
    :cond_c
    return-void
.end method

.method protected static setAdLoaderFactory(Lcom/amazon/device/ads/AdLoader$AdLoaderFactory;)V
    .locals 0
    .param p0, "adLoaderFactory"    # Lcom/amazon/device/ads/AdLoader$AdLoaderFactory;

    .prologue
    .line 69
    sput-object p0, Lcom/amazon/device/ads/AdLoader;->adLoaderFactory:Lcom/amazon/device/ads/AdLoader$AdLoaderFactory;

    .line 70
    return-void
.end method

.method private setErrorForAllSlots(Lcom/amazon/device/ads/AdError;)V
    .locals 3
    .param p1, "error"    # Lcom/amazon/device/ads/AdError;

    .prologue
    .line 348
    iget-object v2, p0, Lcom/amazon/device/ads/AdLoader;->slots:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/device/ads/AdSlot;

    .line 350
    .local v1, "slot":Lcom/amazon/device/ads/AdSlot;
    invoke-virtual {v1, p1}, Lcom/amazon/device/ads/AdSlot;->setAdError(Lcom/amazon/device/ads/AdError;)V

    goto :goto_0

    .line 352
    .end local v1    # "slot":Lcom/amazon/device/ads/AdSlot;
    :cond_0
    return-void
.end method


# virtual methods
.method public beginFetchAd()V
    .locals 2

    .prologue
    .line 77
    invoke-direct {p0}, Lcom/amazon/device/ads/AdLoader;->getCompositeMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v0

    sget-object v1, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/MetricsCollector;->stopMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 78
    invoke-direct {p0}, Lcom/amazon/device/ads/AdLoader;->getCompositeMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v0

    sget-object v1, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_FETCH_THREAD_SPIN_UP:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/MetricsCollector;->startMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 79
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdLoader;->startFetchAdThread()V

    .line 80
    return-void
.end method

.method protected fetchAd()V
    .locals 7

    .prologue
    .line 113
    invoke-direct {p0}, Lcom/amazon/device/ads/AdLoader;->getCompositeMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v4

    sget-object v5, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_FETCH_THREAD_SPIN_UP:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v4, v5}, Lcom/amazon/device/ads/MetricsCollector;->stopMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 114
    invoke-direct {p0}, Lcom/amazon/device/ads/AdLoader;->getCompositeMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v4

    sget-object v5, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_FETCH_THREAD_START_TO_AAX_GET_AD_START:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v4, v5}, Lcom/amazon/device/ads/MetricsCollector;->startMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 118
    invoke-static {}, Lcom/amazon/device/ads/Assets;->getInstance()Lcom/amazon/device/ads/Assets;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/device/ads/Assets;->ensureAssetsCreated()Z

    move-result v4

    if-nez v4, :cond_0

    .line 121
    const-string/jumbo v2, "Unable to create the assets needed to display ads"

    .line 122
    .local v2, "msg":Ljava/lang/String;
    new-instance v4, Lcom/amazon/device/ads/AdError;

    sget-object v5, Lcom/amazon/device/ads/AdError$ErrorCode;->REQUEST_ERROR:Lcom/amazon/device/ads/AdError$ErrorCode;

    const-string/jumbo v6, "Unable to create the assets needed to display ads"

    invoke-direct {v4, v5, v6}, Lcom/amazon/device/ads/AdError;-><init>(Lcom/amazon/device/ads/AdError$ErrorCode;Ljava/lang/String;)V

    iput-object v4, p0, Lcom/amazon/device/ads/AdLoader;->error:Lcom/amazon/device/ads/AdError;

    .line 123
    sget-object v4, Lcom/amazon/device/ads/AdLoader;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v5, "Unable to create the assets needed to display ads"

    invoke-static {v4, v5}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 124
    iget-object v4, p0, Lcom/amazon/device/ads/AdLoader;->error:Lcom/amazon/device/ads/AdError;

    invoke-direct {p0, v4}, Lcom/amazon/device/ads/AdLoader;->setErrorForAllSlots(Lcom/amazon/device/ads/AdError;)V

    .line 163
    .end local v2    # "msg":Ljava/lang/String;
    :goto_0
    return-void

    .line 128
    :cond_0
    const/4 v3, 0x0

    .line 131
    .local v3, "response":Lcom/amazon/device/ads/WebRequest$WebResponse;
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdLoader;->fetchResponseFromNetwork()Lcom/amazon/device/ads/WebRequest$WebResponse;
    :try_end_0
    .catch Lcom/amazon/device/ads/AdLoader$AdFetchException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 141
    invoke-virtual {v3}, Lcom/amazon/device/ads/WebRequest$WebResponse;->isHttpStatusCodeOK()Z

    move-result v4

    if-nez v4, :cond_1

    .line 143
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3}, Lcom/amazon/device/ads/WebRequest$WebResponse;->getHttpStatusCode()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, " - "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v3}, Lcom/amazon/device/ads/WebRequest$WebResponse;->getHttpStatus()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 144
    .restart local v2    # "msg":Ljava/lang/String;
    new-instance v4, Lcom/amazon/device/ads/AdError;

    sget-object v5, Lcom/amazon/device/ads/AdError$ErrorCode;->NETWORK_ERROR:Lcom/amazon/device/ads/AdError$ErrorCode;

    invoke-direct {v4, v5, v2}, Lcom/amazon/device/ads/AdError;-><init>(Lcom/amazon/device/ads/AdError$ErrorCode;Ljava/lang/String;)V

    iput-object v4, p0, Lcom/amazon/device/ads/AdLoader;->error:Lcom/amazon/device/ads/AdError;

    .line 145
    sget-object v4, Lcom/amazon/device/ads/AdLoader;->LOG_TAG:Ljava/lang/String;

    invoke-static {v4, v2}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 146
    iget-object v4, p0, Lcom/amazon/device/ads/AdLoader;->error:Lcom/amazon/device/ads/AdError;

    invoke-direct {p0, v4}, Lcom/amazon/device/ads/AdLoader;->setErrorForAllSlots(Lcom/amazon/device/ads/AdError;)V

    goto :goto_0

    .line 133
    .end local v2    # "msg":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 135
    .local v0, "e":Lcom/amazon/device/ads/AdLoader$AdFetchException;
    invoke-virtual {v0}, Lcom/amazon/device/ads/AdLoader$AdFetchException;->getAdError()Lcom/amazon/device/ads/AdError;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/device/ads/AdLoader;->error:Lcom/amazon/device/ads/AdError;

    .line 136
    sget-object v4, Lcom/amazon/device/ads/AdLoader;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdLoader$AdFetchException;->getAdError()Lcom/amazon/device/ads/AdError;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/device/ads/AdError;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 137
    iget-object v4, p0, Lcom/amazon/device/ads/AdLoader;->error:Lcom/amazon/device/ads/AdError;

    invoke-direct {p0, v4}, Lcom/amazon/device/ads/AdLoader;->setErrorForAllSlots(Lcom/amazon/device/ads/AdError;)V

    goto :goto_0

    .line 150
    .end local v0    # "e":Lcom/amazon/device/ads/AdLoader$AdFetchException;
    :cond_1
    invoke-virtual {v3}, Lcom/amazon/device/ads/WebRequest$WebResponse;->getJSONObjectBody()Lorg/json/JSONObject;

    move-result-object v1

    .line 151
    .local v1, "jsonResponse":Lorg/json/JSONObject;
    if-nez v1, :cond_2

    .line 153
    const-string/jumbo v2, "Unable to parse response"

    .line 154
    .restart local v2    # "msg":Ljava/lang/String;
    new-instance v4, Lcom/amazon/device/ads/AdError;

    sget-object v5, Lcom/amazon/device/ads/AdError$ErrorCode;->INTERNAL_ERROR:Lcom/amazon/device/ads/AdError$ErrorCode;

    const-string/jumbo v6, "Unable to parse response"

    invoke-direct {v4, v5, v6}, Lcom/amazon/device/ads/AdError;-><init>(Lcom/amazon/device/ads/AdError$ErrorCode;Ljava/lang/String;)V

    iput-object v4, p0, Lcom/amazon/device/ads/AdLoader;->error:Lcom/amazon/device/ads/AdError;

    .line 155
    sget-object v4, Lcom/amazon/device/ads/AdLoader;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v5, "Unable to parse response"

    invoke-static {v4, v5}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 156
    iget-object v4, p0, Lcom/amazon/device/ads/AdLoader;->error:Lcom/amazon/device/ads/AdError;

    invoke-direct {p0, v4}, Lcom/amazon/device/ads/AdLoader;->setErrorForAllSlots(Lcom/amazon/device/ads/AdError;)V

    goto :goto_0

    .line 159
    .end local v2    # "msg":Ljava/lang/String;
    :cond_2
    invoke-direct {p0, v1}, Lcom/amazon/device/ads/AdLoader;->parseResponse(Lorg/json/JSONObject;)V

    .line 161
    invoke-direct {p0}, Lcom/amazon/device/ads/AdLoader;->getCompositeMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v4

    sget-object v5, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_AAX_GET_AD_END_TO_FETCH_THREAD_END:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v4, v5}, Lcom/amazon/device/ads/MetricsCollector;->stopMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 162
    invoke-direct {p0}, Lcom/amazon/device/ads/AdLoader;->getCompositeMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v4

    sget-object v5, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_FINALIZE_FETCH_SPIN_UP:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v4, v5}, Lcom/amazon/device/ads/MetricsCollector;->startMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    goto/16 :goto_0
.end method

.method protected fetchResponseFromNetwork()Lcom/amazon/device/ads/WebRequest$WebResponse;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/device/ads/AdLoader$AdFetchException;
        }
    .end annotation

    .prologue
    .line 406
    invoke-direct {p0}, Lcom/amazon/device/ads/AdLoader;->getAdRequest()Lcom/amazon/device/ads/WebRequest;

    move-result-object v2

    .line 407
    .local v2, "request":Lcom/amazon/device/ads/WebRequest;
    invoke-direct {p0}, Lcom/amazon/device/ads/AdLoader;->getCompositeMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/amazon/device/ads/WebRequest;->setMetricsCollector(Lcom/amazon/device/ads/MetricsCollector;)V

    .line 408
    sget-object v4, Lcom/amazon/device/ads/Metrics$MetricType;->AAX_LATENCY_GET_AD:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v2, v4}, Lcom/amazon/device/ads/WebRequest;->setServiceCallLatencyMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 409
    iget v4, p0, Lcom/amazon/device/ads/AdLoader;->timeout:I

    invoke-virtual {v2, v4}, Lcom/amazon/device/ads/WebRequest;->setTimeout(I)V

    .line 411
    invoke-direct {p0}, Lcom/amazon/device/ads/AdLoader;->getCompositeMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v4

    sget-object v5, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_FETCH_THREAD_START_TO_AAX_GET_AD_START:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v4, v5}, Lcom/amazon/device/ads/MetricsCollector;->stopMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 412
    const/4 v3, 0x0

    .line 415
    .local v3, "response":Lcom/amazon/device/ads/WebRequest$WebResponse;
    invoke-direct {p0}, Lcom/amazon/device/ads/AdLoader;->getCompositeMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v4

    sget-object v5, Lcom/amazon/device/ads/Metrics$MetricType;->TLS_ENABLED:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v4, v5}, Lcom/amazon/device/ads/MetricsCollector;->incrementMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 418
    :try_start_0
    invoke-virtual {v2}, Lcom/amazon/device/ads/WebRequest;->makeCall()Lcom/amazon/device/ads/WebRequest$WebResponse;
    :try_end_0
    .catch Lcom/amazon/device/ads/WebRequest$WebRequestException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 437
    invoke-direct {p0}, Lcom/amazon/device/ads/AdLoader;->getCompositeMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v4

    sget-object v5, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_AAX_GET_AD_END_TO_FETCH_THREAD_END:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v4, v5}, Lcom/amazon/device/ads/MetricsCollector;->startMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 438
    return-object v3

    .line 420
    :catch_0
    move-exception v0

    .line 422
    .local v0, "e":Lcom/amazon/device/ads/WebRequest$WebRequestException;
    const/4 v1, 0x0

    .line 423
    .local v1, "error":Lcom/amazon/device/ads/AdError;
    invoke-virtual {v0}, Lcom/amazon/device/ads/WebRequest$WebRequestException;->getStatus()Lcom/amazon/device/ads/WebRequest$WebRequestStatus;

    move-result-object v4

    sget-object v5, Lcom/amazon/device/ads/WebRequest$WebRequestStatus;->NETWORK_FAILURE:Lcom/amazon/device/ads/WebRequest$WebRequestStatus;

    if-ne v4, v5, :cond_0

    .line 425
    new-instance v1, Lcom/amazon/device/ads/AdError;

    .end local v1    # "error":Lcom/amazon/device/ads/AdError;
    sget-object v4, Lcom/amazon/device/ads/AdError$ErrorCode;->NETWORK_ERROR:Lcom/amazon/device/ads/AdError$ErrorCode;

    const-string/jumbo v5, "Could not contact Ad Server"

    invoke-direct {v1, v4, v5}, Lcom/amazon/device/ads/AdError;-><init>(Lcom/amazon/device/ads/AdError$ErrorCode;Ljava/lang/String;)V

    .line 435
    .restart local v1    # "error":Lcom/amazon/device/ads/AdError;
    :goto_0
    new-instance v4, Lcom/amazon/device/ads/AdLoader$AdFetchException;

    invoke-direct {v4, p0, v1}, Lcom/amazon/device/ads/AdLoader$AdFetchException;-><init>(Lcom/amazon/device/ads/AdLoader;Lcom/amazon/device/ads/AdError;)V

    throw v4

    .line 427
    :cond_0
    invoke-virtual {v0}, Lcom/amazon/device/ads/WebRequest$WebRequestException;->getStatus()Lcom/amazon/device/ads/WebRequest$WebRequestStatus;

    move-result-object v4

    sget-object v5, Lcom/amazon/device/ads/WebRequest$WebRequestStatus;->NETWORK_TIMEOUT:Lcom/amazon/device/ads/WebRequest$WebRequestStatus;

    if-ne v4, v5, :cond_1

    .line 429
    new-instance v1, Lcom/amazon/device/ads/AdError;

    .end local v1    # "error":Lcom/amazon/device/ads/AdError;
    sget-object v4, Lcom/amazon/device/ads/AdError$ErrorCode;->NETWORK_TIMEOUT:Lcom/amazon/device/ads/AdError$ErrorCode;

    const-string/jumbo v5, "Connection to Ad Server timed out"

    invoke-direct {v1, v4, v5}, Lcom/amazon/device/ads/AdError;-><init>(Lcom/amazon/device/ads/AdError$ErrorCode;Ljava/lang/String;)V

    .restart local v1    # "error":Lcom/amazon/device/ads/AdError;
    goto :goto_0

    .line 433
    :cond_1
    new-instance v1, Lcom/amazon/device/ads/AdError;

    .end local v1    # "error":Lcom/amazon/device/ads/AdError;
    sget-object v4, Lcom/amazon/device/ads/AdError$ErrorCode;->INTERNAL_ERROR:Lcom/amazon/device/ads/AdError$ErrorCode;

    invoke-virtual {v0}, Lcom/amazon/device/ads/WebRequest$WebRequestException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v1, v4, v5}, Lcom/amazon/device/ads/AdError;-><init>(Lcom/amazon/device/ads/AdError$ErrorCode;Ljava/lang/String;)V

    .restart local v1    # "error":Lcom/amazon/device/ads/AdError;
    goto :goto_0
.end method

.method protected finalizeFetchAd()V
    .locals 8

    .prologue
    .line 372
    iget-object v5, p0, Lcom/amazon/device/ads/AdLoader;->slots:Ljava/util/Map;

    invoke-interface {v5}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 374
    .local v2, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Integer;Lcom/amazon/device/ads/AdSlot;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/device/ads/AdSlot;

    .line 375
    .local v4, "slot":Lcom/amazon/device/ads/AdSlot;
    invoke-virtual {v4}, Lcom/amazon/device/ads/AdSlot;->getAdLoaderCallback()Lcom/amazon/device/ads/IAdLoaderCallback;

    move-result-object v1

    .line 376
    .local v1, "adLoaderCallback":Lcom/amazon/device/ads/IAdLoaderCallback;
    invoke-virtual {v4}, Lcom/amazon/device/ads/AdSlot;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v0

    .line 377
    .local v0, "adData":Lcom/amazon/device/ads/AdData;
    invoke-virtual {v0}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v5

    sget-object v6, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_FINALIZE_FETCH_SPIN_UP:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v5, v6}, Lcom/amazon/device/ads/MetricsCollector;->stopMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 378
    invoke-virtual {v0}, Lcom/amazon/device/ads/AdData;->getIsFetched()Z

    move-result v5

    if-nez v5, :cond_1

    .line 380
    invoke-virtual {v0}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v5

    sget-object v6, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v5, v6}, Lcom/amazon/device/ads/MetricsCollector;->startMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 381
    invoke-virtual {v4}, Lcom/amazon/device/ads/AdSlot;->getAdError()Lcom/amazon/device/ads/AdError;

    move-result-object v5

    if-eqz v5, :cond_0

    .line 383
    invoke-virtual {v4}, Lcom/amazon/device/ads/AdSlot;->getAdError()Lcom/amazon/device/ads/AdError;

    move-result-object v5

    invoke-interface {v1, v5}, Lcom/amazon/device/ads/IAdLoaderCallback;->adFailed(Lcom/amazon/device/ads/AdError;)V

    goto :goto_0

    .line 388
    :cond_0
    new-instance v5, Lcom/amazon/device/ads/AdError;

    sget-object v6, Lcom/amazon/device/ads/AdError$ErrorCode;->INTERNAL_ERROR:Lcom/amazon/device/ads/AdError$ErrorCode;

    const-string/jumbo v7, "Unknown error occurred."

    invoke-direct {v5, v6, v7}, Lcom/amazon/device/ads/AdError;-><init>(Lcom/amazon/device/ads/AdError$ErrorCode;Ljava/lang/String;)V

    invoke-interface {v1, v5}, Lcom/amazon/device/ads/IAdLoaderCallback;->adFailed(Lcom/amazon/device/ads/AdError;)V

    goto :goto_0

    .line 393
    :cond_1
    invoke-virtual {v0}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v5

    sget-object v6, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v5, v6}, Lcom/amazon/device/ads/MetricsCollector;->startMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 394
    invoke-interface {v1}, Lcom/amazon/device/ads/IAdLoaderCallback;->handleResponse()V

    goto :goto_0

    .line 397
    .end local v0    # "adData":Lcom/amazon/device/ads/AdData;
    .end local v1    # "adLoaderCallback":Lcom/amazon/device/ads/IAdLoaderCallback;
    .end local v2    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Integer;Lcom/amazon/device/ads/AdSlot;>;"
    .end local v4    # "slot":Lcom/amazon/device/ads/AdSlot;
    :cond_2
    return-void
.end method

.method protected getAdError(Lorg/json/JSONObject;)Lcom/amazon/device/ads/AdError;
    .locals 8
    .param p1, "jsonResponse"    # Lorg/json/JSONObject;

    .prologue
    .line 314
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/AdLoader;->retrieveNoRetryTtlSeconds(Lorg/json/JSONObject;)I

    move-result v3

    .line 316
    .local v3, "noRetryTtlSeconds":I
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v4

    invoke-interface {v4, v3}, Lcom/amazon/device/ads/IInternalAdRegistration;->setNoRetryTtl(I)V

    .line 318
    const-string/jumbo v4, "errorMessage"

    const-string/jumbo v5, "No Ad Received"

    invoke-static {p1, v4, v5}, Lcom/amazon/device/ads/JSONUtils;->getStringFromJSON(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 319
    .local v1, "errorMsg":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v4

    invoke-static {}, Lcom/amazon/device/ads/Utils;->getDisabledAppServerMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    invoke-interface {v4, v5}, Lcom/amazon/device/ads/IInternalAdRegistration;->setIsAppDisabled(Z)V

    .line 320
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "Server Message: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 321
    .local v2, "msg":Ljava/lang/String;
    const/4 v0, 0x0

    .line 323
    .local v0, "adError":Lcom/amazon/device/ads/AdError;
    if-lez v3, :cond_0

    .line 325
    invoke-direct {p0}, Lcom/amazon/device/ads/AdLoader;->getCompositeMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v4

    sget-object v5, Lcom/amazon/device/ads/Metrics$MetricType;->AD_NO_RETRY_TTL_RECEIVED:Lcom/amazon/device/ads/Metrics$MetricType;

    mul-int/lit16 v6, v3, 0x3e8

    int-to-long v6, v6

    invoke-virtual {v4, v5, v6, v7}, Lcom/amazon/device/ads/MetricsCollector;->publishMetricInMilliseconds(Lcom/amazon/device/ads/Metrics$MetricType;J)V

    .line 328
    :cond_0
    if-lez v3, :cond_1

    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/device/ads/IInternalAdRegistration;->getIsAppDisabled()Z

    move-result v4

    if-nez v4, :cond_1

    .line 330
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, ". Try again in "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, " seconds"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 331
    new-instance v0, Lcom/amazon/device/ads/AdError;

    .end local v0    # "adError":Lcom/amazon/device/ads/AdError;
    sget-object v4, Lcom/amazon/device/ads/AdError$ErrorCode;->NO_FILL:Lcom/amazon/device/ads/AdError$ErrorCode;

    invoke-direct {v0, v4, v2}, Lcom/amazon/device/ads/AdError;-><init>(Lcom/amazon/device/ads/AdError$ErrorCode;Ljava/lang/String;)V

    .line 343
    .restart local v0    # "adError":Lcom/amazon/device/ads/AdError;
    :goto_0
    return-object v0

    .line 333
    :cond_1
    const-string/jumbo v4, "no results"

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 337
    new-instance v0, Lcom/amazon/device/ads/AdError;

    .end local v0    # "adError":Lcom/amazon/device/ads/AdError;
    sget-object v4, Lcom/amazon/device/ads/AdError$ErrorCode;->NO_FILL:Lcom/amazon/device/ads/AdError$ErrorCode;

    invoke-direct {v0, v4, v2}, Lcom/amazon/device/ads/AdError;-><init>(Lcom/amazon/device/ads/AdError$ErrorCode;Ljava/lang/String;)V

    .restart local v0    # "adError":Lcom/amazon/device/ads/AdError;
    goto :goto_0

    .line 341
    :cond_2
    new-instance v0, Lcom/amazon/device/ads/AdError;

    .end local v0    # "adError":Lcom/amazon/device/ads/AdError;
    sget-object v4, Lcom/amazon/device/ads/AdError$ErrorCode;->INTERNAL_ERROR:Lcom/amazon/device/ads/AdError$ErrorCode;

    invoke-direct {v0, v4, v2}, Lcom/amazon/device/ads/AdError;-><init>(Lcom/amazon/device/ads/AdError$ErrorCode;Ljava/lang/String;)V

    .restart local v0    # "adError":Lcom/amazon/device/ads/AdError;
    goto :goto_0
.end method

.method protected retrieveNoRetryTtlSeconds(Lorg/json/JSONObject;)I
    .locals 3
    .param p1, "jsonResponse"    # Lorg/json/JSONObject;

    .prologue
    .line 362
    const-string/jumbo v1, "noretryTTL"

    const/4 v2, 0x0

    invoke-static {p1, v1, v2}, Lcom/amazon/device/ads/JSONUtils;->getIntegerFromJSON(Lorg/json/JSONObject;Ljava/lang/String;I)I

    move-result v0

    .line 363
    .local v0, "noRetryTtlSeconds":I
    const-string/jumbo v1, "debug.noRetryTTL"

    invoke-static {v1, v0}, Lcom/amazon/device/ads/DebugProperties;->getDebugPropertyAsInteger(Ljava/lang/String;I)I

    move-result v0

    .line 364
    return v0
.end method

.method public setTimeout(I)V
    .locals 0
    .param p1, "timeout"    # I

    .prologue
    .line 64
    iput p1, p0, Lcom/amazon/device/ads/AdLoader;->timeout:I

    .line 65
    return-void
.end method

.method protected startFetchAdThread()V
    .locals 1

    .prologue
    .line 84
    new-instance v0, Lcom/amazon/device/ads/AdLoader$1;

    invoke-direct {v0, p0}, Lcom/amazon/device/ads/AdLoader$1;-><init>(Lcom/amazon/device/ads/AdLoader;)V

    invoke-static {v0}, Lcom/amazon/device/ads/ThreadUtils;->executeRunnable(Ljava/lang/Runnable;)V

    .line 93
    return-void
.end method
