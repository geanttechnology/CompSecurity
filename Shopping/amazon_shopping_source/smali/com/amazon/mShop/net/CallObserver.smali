.class public Lcom/amazon/mShop/net/CallObserver;
.super Lcom/amazon/mShop/net/BaseMetricsObserver;
.source "CallObserver.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;,
        Lcom/amazon/mShop/net/CallObserver$CacheHitCounter;
    }
.end annotation


# static fields
.field static final METRICS_AGGREGATOR:Lcom/amazon/mShop/net/MetricsAggregator;


# instance fields
.field private mCacheHit:Z

.field private final mServiceCallIdentifier:Lcom/amazon/mShop/net/ServiceCallIdentifier;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 123
    new-instance v0, Lcom/amazon/mShop/net/CallObserver$1;

    invoke-direct {v0}, Lcom/amazon/mShop/net/CallObserver$1;-><init>()V

    sput-object v0, Lcom/amazon/mShop/net/CallObserver;->METRICS_AGGREGATOR:Lcom/amazon/mShop/net/MetricsAggregator;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/mShop/net/ServiceCallIdentifier;)V
    .locals 1
    .param p1, "sci"    # Lcom/amazon/mShop/net/ServiceCallIdentifier;

    .prologue
    .line 72
    invoke-direct {p0}, Lcom/amazon/mShop/net/BaseMetricsObserver;-><init>()V

    .line 95
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/net/CallObserver;->mCacheHit:Z

    .line 73
    iput-object p1, p0, Lcom/amazon/mShop/net/CallObserver;->mServiceCallIdentifier:Lcom/amazon/mShop/net/ServiceCallIdentifier;

    .line 74
    return-void
.end method

.method public static start(Lcom/amazon/mShop/net/ServiceCallIdentifier;)Lcom/amazon/mShop/net/CallObserver;
    .locals 1
    .param p0, "sci"    # Lcom/amazon/mShop/net/ServiceCallIdentifier;

    .prologue
    .line 83
    new-instance v0, Lcom/amazon/mShop/net/CallObserver;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/net/CallObserver;-><init>(Lcom/amazon/mShop/net/ServiceCallIdentifier;)V

    .line 84
    .local v0, "co":Lcom/amazon/mShop/net/CallObserver;
    invoke-virtual {v0}, Lcom/amazon/mShop/net/CallObserver;->onStart()V

    .line 85
    return-object v0
.end method


# virtual methods
.method public getAggregator()Lcom/amazon/mShop/net/MetricsAggregator;
    .locals 1

    .prologue
    .line 284
    sget-object v0, Lcom/amazon/mShop/net/CallObserver;->METRICS_AGGREGATOR:Lcom/amazon/mShop/net/MetricsAggregator;

    return-object v0
.end method

.method public getCacheHit()Z
    .locals 1

    .prologue
    .line 109
    iget-boolean v0, p0, Lcom/amazon/mShop/net/CallObserver;->mCacheHit:Z

    return v0
.end method

.method public getEventAggregatorType()Lcom/amazon/mShop/net/MetricsAggregator$Type;
    .locals 1

    .prologue
    .line 279
    sget-object v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;->CallMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    return-object v0
.end method

.method public getServiceCallIdentifier()Lcom/amazon/mShop/net/ServiceCallIdentifier;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/amazon/mShop/net/CallObserver;->mServiceCallIdentifier:Lcom/amazon/mShop/net/ServiceCallIdentifier;

    return-object v0
.end method

.method public setCacheHit(Z)V
    .locals 0
    .param p1, "hit"    # Z

    .prologue
    .line 102
    iput-boolean p1, p0, Lcom/amazon/mShop/net/CallObserver;->mCacheHit:Z

    .line 103
    return-void
.end method
