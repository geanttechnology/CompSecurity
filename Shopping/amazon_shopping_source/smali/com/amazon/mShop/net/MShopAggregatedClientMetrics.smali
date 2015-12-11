.class public Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;
.super Lcom/amazon/mShop/net/AggregatedMetrics;
.source "MShopAggregatedClientMetrics.java"


# static fields
.field private static final DEBUG:Z

.field private static final METRICS_SENDER:Lcom/amazon/mShop/net/MetricsSender;

.field private static final sPostMetricsResponseListener:Lcom/amazon/rio/j2me/client/services/mShop/PostMetricsResponseListener;


# instance fields
.field private mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 26
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;->DEBUG:Z

    .line 52
    new-instance v0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$1;

    invoke-direct {v0}, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$1;-><init>()V

    sput-object v0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;->METRICS_SENDER:Lcom/amazon/mShop/net/MetricsSender;

    .line 136
    new-instance v0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$2;

    invoke-direct {v0}, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics$2;-><init>()V

    sput-object v0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;->sPostMetricsResponseListener:Lcom/amazon/rio/j2me/client/services/mShop/PostMetricsResponseListener;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 24
    invoke-direct {p0}, Lcom/amazon/mShop/net/AggregatedMetrics;-><init>()V

    .line 28
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;->mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    return-void
.end method

.method static synthetic access$000()Z
    .locals 1

    .prologue
    .line 24
    sget-boolean v0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;->DEBUG:Z

    return v0
.end method

.method static synthetic access$100()Lcom/amazon/rio/j2me/client/services/mShop/PostMetricsResponseListener;
    .locals 1

    .prologue
    .line 24
    sget-object v0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;->sPostMetricsResponseListener:Lcom/amazon/rio/j2me/client/services/mShop/PostMetricsResponseListener;

    return-object v0
.end method


# virtual methods
.method public getClientMetrics()Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;->mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    return-object v0
.end method

.method public getMetricsSender()Lcom/amazon/mShop/net/MetricsSender;
    .locals 1

    .prologue
    .line 169
    sget-object v0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;->METRICS_SENDER:Lcom/amazon/mShop/net/MetricsSender;

    return-object v0
.end method

.method public getSenderType()Lcom/amazon/mShop/net/MetricsSender$SenderType;
    .locals 1

    .prologue
    .line 164
    sget-object v0, Lcom/amazon/mShop/net/MetricsSender$SenderType;->MShopSender:Lcom/amazon/mShop/net/MetricsSender$SenderType;

    return-object v0
.end method

.method public setClickedSlots(Ljava/util/List;)V
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
    .line 47
    .local p1, "slotTokens":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 48
    iget-object v0, p0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;->mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    new-instance v1, Ljava/util/Vector;

    invoke-direct {v1, p1}, Ljava/util/Vector;-><init>(Ljava/util/Collection;)V

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->setClickedSlots(Ljava/util/List;)V

    .line 50
    :cond_0
    return-void
.end method

.method public setExposedSlots(Ljava/util/List;)V
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
    .line 41
    .local p1, "slotTokens":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 42
    iget-object v0, p0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;->mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    new-instance v1, Ljava/util/Vector;

    invoke-direct {v1, p1}, Ljava/util/Vector;-><init>(Ljava/util/Collection;)V

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->setExposedSlots(Ljava/util/List;)V

    .line 44
    :cond_0
    return-void
.end method

.method public setMetrics(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 35
    .local p1, "metrics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;>;"
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 36
    iget-object v0, p0, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;->mClientMetrics:Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    new-instance v1, Ljava/util/Vector;

    invoke-direct {v1, p1}, Ljava/util/Vector;-><init>(Ljava/util/Collection;)V

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->setMetrics(Ljava/util/List;)V

    .line 38
    :cond_0
    return-void
.end method
