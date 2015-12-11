.class public Lcom/amazon/mShop/feature/WeblabCsmMetricsImpl;
.super Ljava/lang/Object;
.source "WeblabCsmMetricsImpl.java"

# interfaces
.implements Lcom/amazon/mShop/net/PageMetricsEventListener;


# static fields
.field protected static final DEBUG:Z


# instance fields
.field private final mCsmLatencyType:Ljava/lang/String;

.field private final mFeatureName:Ljava/lang/String;

.field private final mMainRequestId:Ljava/lang/String;

.field private final mPageAssemblyType:Ljava/lang/String;

.field private final mPageType:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/feature/WeblabCsmMetricsImpl;->DEBUG:Z

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "requestId"    # Ljava/lang/String;
    .param p2, "pageType"    # Ljava/lang/String;
    .param p3, "pageAssemblyType"    # Ljava/lang/String;
    .param p4, "featureName"    # Ljava/lang/String;
    .param p5, "csmLatencyType"    # Ljava/lang/String;

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    iput-object p1, p0, Lcom/amazon/mShop/feature/WeblabCsmMetricsImpl;->mMainRequestId:Ljava/lang/String;

    .line 43
    iput-object p2, p0, Lcom/amazon/mShop/feature/WeblabCsmMetricsImpl;->mPageType:Ljava/lang/String;

    .line 44
    iput-object p3, p0, Lcom/amazon/mShop/feature/WeblabCsmMetricsImpl;->mPageAssemblyType:Ljava/lang/String;

    .line 45
    iput-object p4, p0, Lcom/amazon/mShop/feature/WeblabCsmMetricsImpl;->mFeatureName:Ljava/lang/String;

    .line 46
    iput-object p5, p0, Lcom/amazon/mShop/feature/WeblabCsmMetricsImpl;->mCsmLatencyType:Ljava/lang/String;

    .line 47
    return-void
.end method

.method private buildClientLogInfo()Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;
    .locals 8

    .prologue
    const/16 v7, 0x20

    .line 86
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;-><init>()V

    .line 89
    .local v0, "clientLogInfo":Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;
    iget-object v4, p0, Lcom/amazon/mShop/feature/WeblabCsmMetricsImpl;->mPageType:Ljava/lang/String;

    invoke-virtual {v0, v4}, Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;->setPageType(Ljava/lang/String;)V

    .line 91
    iget-object v4, p0, Lcom/amazon/mShop/feature/WeblabCsmMetricsImpl;->mPageAssemblyType:Ljava/lang/String;

    invoke-virtual {v0, v4}, Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;->setPageAssemblyType(Ljava/lang/String;)V

    .line 93
    iget-object v4, p0, Lcom/amazon/mShop/feature/WeblabCsmMetricsImpl;->mMainRequestId:Ljava/lang/String;

    invoke-virtual {v0, v4}, Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;->setRelatedRequestId(Ljava/lang/String;)V

    .line 96
    new-instance v3, Ljava/util/ArrayList;

    const/4 v4, 0x1

    invoke-direct {v3, v4}, Ljava/util/ArrayList;-><init>(I)V

    .line 97
    .local v3, "weblabMetrics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;>;"
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/mShop/feature/WeblabCsmMetricsImpl;->mFeatureName:Ljava/lang/String;

    invoke-virtual {v4, v5}, Lcom/amazon/mShop/feature/Features;->getFeatureState(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 98
    .local v2, "treatment":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/mShop/feature/WeblabCsmMetricsImpl;->mFeatureName:Ljava/lang/String;

    invoke-virtual {v4, v5}, Lcom/amazon/mShop/feature/Features;->isAllowClientTrigger(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 99
    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;-><init>()V

    .line 100
    .local v1, "featureExperience":Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;
    iget-object v4, p0, Lcom/amazon/mShop/feature/WeblabCsmMetricsImpl;->mFeatureName:Ljava/lang/String;

    invoke-virtual {v1, v4}, Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;->setFeatureName(Ljava/lang/String;)V

    .line 101
    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;->setTreatment(Ljava/lang/String;)V

    .line 103
    invoke-interface {v3, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 105
    sget-boolean v4, Lcom/amazon/mShop/feature/WeblabCsmMetricsImpl;->DEBUG:Z

    if-eqz v4, :cond_0

    .line 106
    const-string/jumbo v4, "WeblabCsmUtils"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "FeatureExperience:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;->getFeatureName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;->getTreatment()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 111
    .end local v1    # "featureExperience":Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;
    :cond_0
    new-instance v4, Ljava/util/Vector;

    invoke-direct {v4, v3}, Ljava/util/Vector;-><init>(Ljava/util/Collection;)V

    invoke-virtual {v0, v4}, Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;->setFeatures(Ljava/util/List;)V

    .line 113
    sget-boolean v4, Lcom/amazon/mShop/feature/WeblabCsmMetricsImpl;->DEBUG:Z

    if-eqz v4, :cond_1

    .line 114
    const-string/jumbo v4, "WeblabCsmUtils"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "buildClientLogInfo:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;->getPageAssemblyType()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;->getPageType()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;->getRelatedRequestId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;->getSessionId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 121
    :cond_1
    return-object v0
.end method

.method private buildLatencyMetrics(Lcom/amazon/mShop/net/PageMetricsObserver;)Ljava/util/List;
    .locals 6
    .param p1, "observer"    # Lcom/amazon/mShop/net/PageMetricsObserver;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mShop/net/PageMetricsObserver;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;",
            ">;"
        }
    .end annotation

    .prologue
    .line 130
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;-><init>()V

    .line 131
    .local v0, "csmLatency":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    invoke-virtual {p1}, Lcom/amazon/mShop/net/PageMetricsObserver;->getTotalTime()I

    move-result v2

    .line 134
    .local v2, "time":I
    iget-object v3, p0, Lcom/amazon/mShop/feature/WeblabCsmMetricsImpl;->mCsmLatencyType:Ljava/lang/String;

    invoke-virtual {v0, v3}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setName(Ljava/lang/String;)V

    .line 135
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setTime(Ljava/lang/Integer;)V

    .line 138
    new-instance v1, Ljava/util/ArrayList;

    const/4 v3, 0x1

    invoke-direct {v1, v3}, Ljava/util/ArrayList;-><init>(I)V

    .line 139
    .local v1, "latencyMetrics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;>;"
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 141
    sget-boolean v3, Lcom/amazon/mShop/feature/WeblabCsmMetricsImpl;->DEBUG:Z

    if-eqz v3, :cond_0

    .line 142
    const-string/jumbo v3, "WeblabCsmUtils"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "Csm Latency for "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p1}, Lcom/amazon/mShop/net/PageMetricsObserver;->getPageIdentifier()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, ": "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->getTime()Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 144
    :cond_0
    return-object v1
.end method


# virtual methods
.method public onPageCancelled(Lcom/amazon/mShop/net/PageMetricsObserver;Ljava/lang/String;)V
    .locals 3
    .param p1, "observer"    # Lcom/amazon/mShop/net/PageMetricsObserver;
    .param p2, "identifier"    # Ljava/lang/String;

    .prologue
    .line 58
    sget-boolean v0, Lcom/amazon/mShop/feature/WeblabCsmMetricsImpl;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 59
    const-string/jumbo v0, "WeblabCsmUtils"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "onPageCancelled "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 61
    :cond_0
    return-void
.end method

.method public onPageComplete(Lcom/amazon/mShop/net/PageMetricsObserver;Ljava/lang/String;)V
    .locals 4
    .param p1, "observer"    # Lcom/amazon/mShop/net/PageMetricsObserver;
    .param p2, "identifier"    # Ljava/lang/String;

    .prologue
    .line 65
    sget-boolean v1, Lcom/amazon/mShop/feature/WeblabCsmMetricsImpl;->DEBUG:Z

    if-eqz v1, :cond_0

    .line 66
    const-string/jumbo v1, "WeblabCsmUtils"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "onPageComplete "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 69
    :cond_0
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;-><init>()V

    .line 71
    .local v0, "clientMetrics":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;
    invoke-direct {p0}, Lcom/amazon/mShop/feature/WeblabCsmMetricsImpl;->buildClientLogInfo()Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->setLogInfo(Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;)V

    .line 73
    new-instance v1, Ljava/util/Vector;

    invoke-direct {p0, p1}, Lcom/amazon/mShop/feature/WeblabCsmMetricsImpl;->buildLatencyMetrics(Lcom/amazon/mShop/net/PageMetricsObserver;)Ljava/util/List;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/util/Vector;-><init>(Ljava/util/Collection;)V

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->setMetrics(Ljava/util/List;)V

    .line 76
    invoke-static {v0}, Lcom/amazon/mShop/feature/WeblabCsmUtils;->postMetrics(Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;)V

    .line 77
    return-void
.end method

.method public onPageStart(Lcom/amazon/mShop/net/PageMetricsObserver;Ljava/lang/String;)V
    .locals 3
    .param p1, "observer"    # Lcom/amazon/mShop/net/PageMetricsObserver;
    .param p2, "identifier"    # Ljava/lang/String;

    .prologue
    .line 51
    sget-boolean v0, Lcom/amazon/mShop/feature/WeblabCsmMetricsImpl;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 52
    const-string/jumbo v0, "WeblabCsmUtils"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "onPageStart "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 54
    :cond_0
    return-void
.end method
