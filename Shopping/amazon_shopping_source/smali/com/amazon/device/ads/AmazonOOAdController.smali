.class Lcom/amazon/device/ads/AmazonOOAdController;
.super Lcom/amazon/device/ads/AdController;
.source "AmazonOOAdController.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/AmazonOOAdController$2;,
        Lcom/amazon/device/ads/AmazonOOAdController$DefaultAmazonOOAdListener;
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String; = "AmazonOOAdController"


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/AdLayout;Lcom/amazon/device/ads/AdSize;Landroid/content/Context;)V
    .locals 0
    .param p1, "amazonAdLayout"    # Lcom/amazon/device/ads/AdLayout;
    .param p2, "size"    # Lcom/amazon/device/ads/AdSize;
    .param p3, "context"    # Landroid/content/Context;

    .prologue
    .line 21
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/device/ads/AdController;-><init>(Lcom/amazon/device/ads/AdLayout;Lcom/amazon/device/ads/AdSize;Landroid/content/Context;)V

    .line 22
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/device/ads/AmazonOOAdController;)Lcom/amazon/device/ads/AmazonOOAdListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/AmazonOOAdController;

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/amazon/device/ads/AmazonOOAdController;->getAmazonOOAdListener()Lcom/amazon/device/ads/AmazonOOAdListener;

    move-result-object v0

    return-object v0
.end method

.method private getAmazonOOAdListener()Lcom/amazon/device/ads/AmazonOOAdListener;
    .locals 2

    .prologue
    .line 33
    invoke-virtual {p0}, Lcom/amazon/device/ads/AmazonOOAdController;->getAdListener()Lcom/amazon/device/ads/AdListener;

    move-result-object v0

    .line 34
    .local v0, "adListener":Lcom/amazon/device/ads/AdListener;
    instance-of v1, v0, Lcom/amazon/device/ads/AmazonOOAdListener;

    if-eqz v1, :cond_0

    check-cast v0, Lcom/amazon/device/ads/AmazonOOAdListener;

    .end local v0    # "adListener":Lcom/amazon/device/ads/AdListener;
    :goto_0
    return-object v0

    .restart local v0    # "adListener":Lcom/amazon/device/ads/AdListener;
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method protected createAdListener()Lcom/amazon/device/ads/AdListener;
    .locals 1

    .prologue
    .line 27
    new-instance v0, Lcom/amazon/device/ads/AmazonOOAdController$DefaultAmazonOOAdListener;

    invoke-direct {v0, p0}, Lcom/amazon/device/ads/AmazonOOAdController$DefaultAmazonOOAdListener;-><init>(Lcom/amazon/device/ads/AmazonOOAdController;)V

    .line 28
    .local v0, "adListener":Lcom/amazon/device/ads/AmazonOOAdListener;
    return-object v0
.end method

.method public getSpecialUrlExecutor()Lcom/amazon/device/ads/AdWebViewClient$UrlExecutor;
    .locals 3

    .prologue
    .line 43
    new-instance v0, Lcom/amazon/device/ads/AmazonOOAdController$1;

    invoke-virtual {p0}, Lcom/amazon/device/ads/AmazonOOAdController;->getCurrentAdRenderer()Lcom/amazon/device/ads/AdRenderer;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/device/ads/AmazonOOAdController;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v0, p0, v1, v2}, Lcom/amazon/device/ads/AmazonOOAdController$1;-><init>(Lcom/amazon/device/ads/AmazonOOAdController;Lcom/amazon/device/ads/AdView;Landroid/content/Context;)V

    return-object v0
.end method

.method public handleResponse()V
    .locals 6

    .prologue
    .line 61
    sget-object v0, Lcom/amazon/device/ads/AmazonOOActionCode;->DISPLAY:Lcom/amazon/device/ads/AmazonOOActionCode;

    .line 62
    .local v0, "actionCode":Lcom/amazon/device/ads/AmazonOOActionCode;
    invoke-virtual {p0}, Lcom/amazon/device/ads/AmazonOOAdController;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v1

    .line 63
    .local v1, "ad":Lcom/amazon/device/ads/AdData;
    if-eqz v1, :cond_0

    .line 66
    invoke-direct {p0}, Lcom/amazon/device/ads/AmazonOOAdController;->getAmazonOOAdListener()Lcom/amazon/device/ads/AmazonOOAdListener;

    move-result-object v2

    .line 67
    .local v2, "adListener":Lcom/amazon/device/ads/AmazonOOAdListener;
    if-eqz v2, :cond_0

    .line 69
    invoke-virtual {p0}, Lcom/amazon/device/ads/AmazonOOAdController;->getAdLayout()Lcom/amazon/device/ads/AdLayout;

    move-result-object v3

    new-instance v4, Lcom/amazon/device/ads/AmazonOOAdResponse;

    invoke-direct {v4, v1}, Lcom/amazon/device/ads/AmazonOOAdResponse;-><init>(Lcom/amazon/device/ads/AdData;)V

    invoke-interface {v2, v3, v4}, Lcom/amazon/device/ads/AmazonOOAdListener;->onAdReceived(Lcom/amazon/device/ads/Ad;Lcom/amazon/device/ads/AmazonOOAdResponse;)Lcom/amazon/device/ads/AmazonOOActionCode;

    move-result-object v0

    .line 75
    .end local v2    # "adListener":Lcom/amazon/device/ads/AmazonOOAdListener;
    :cond_0
    if-nez v0, :cond_1

    .line 77
    sget-object v0, Lcom/amazon/device/ads/AmazonOOActionCode;->DISPLAY:Lcom/amazon/device/ads/AmazonOOActionCode;

    .line 80
    :cond_1
    sget-object v3, Lcom/amazon/device/ads/AmazonOOAdController$2;->$SwitchMap$com$amazon$device$ads$AmazonOOActionCode:[I

    invoke-virtual {v0}, Lcom/amazon/device/ads/AmazonOOActionCode;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_0

    .line 91
    invoke-super {p0}, Lcom/amazon/device/ads/AdController;->handleResponse()V

    .line 94
    :goto_0
    return-void

    .line 83
    :pswitch_0
    new-instance v3, Lcom/amazon/device/ads/AdError;

    sget-object v4, Lcom/amazon/device/ads/AdError$ErrorCode;->INTERNAL_ERROR:Lcom/amazon/device/ads/AdError$ErrorCode;

    const-string/jumbo v5, "Ad explicitly rejected by host application."

    invoke-direct {v3, v4, v5}, Lcom/amazon/device/ads/AdError;-><init>(Lcom/amazon/device/ads/AdError$ErrorCode;Ljava/lang/String;)V

    invoke-virtual {p0, v3}, Lcom/amazon/device/ads/AmazonOOAdController;->adFailed(Lcom/amazon/device/ads/AdError;)V

    goto :goto_0

    .line 86
    :pswitch_1
    invoke-static {}, Lcom/amazon/device/ads/Metrics;->getInstance()Lcom/amazon/device/ads/Metrics;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/device/ads/Metrics;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v3

    sget-object v4, Lcom/amazon/device/ads/Metrics$MetricType;->CUSTOM_RENDER_HANDLED:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v3, v4}, Lcom/amazon/device/ads/MetricsCollector;->incrementMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 87
    invoke-virtual {v1}, Lcom/amazon/device/ads/AdData;->getProperties()Lcom/amazon/device/ads/AdProperties;

    move-result-object v3

    invoke-virtual {p0, v3}, Lcom/amazon/device/ads/AmazonOOAdController;->adLoaded(Lcom/amazon/device/ads/AdProperties;)V

    goto :goto_0

    .line 80
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
