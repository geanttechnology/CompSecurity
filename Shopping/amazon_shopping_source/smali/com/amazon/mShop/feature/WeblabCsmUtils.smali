.class public Lcom/amazon/mShop/feature/WeblabCsmUtils;
.super Ljava/lang/Object;
.source "WeblabCsmUtils.java"


# static fields
.field protected static final DEBUG:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/feature/WeblabCsmUtils;->DEBUG:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static postFeatureTrigger(Ljava/lang/String;)V
    .locals 3
    .param p0, "featureName"    # Ljava/lang/String;

    .prologue
    .line 93
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v2

    invoke-virtual {v2, p0}, Lcom/amazon/mShop/feature/Features;->getFeatureState(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 94
    .local v1, "treatment":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v2

    invoke-virtual {v2, p0}, Lcom/amazon/mShop/feature/Features;->getFeatureCacheStamp(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    .line 95
    .local v0, "cacheStamp":Ljava/lang/Integer;
    invoke-static {p0, v1, v0}, Lcom/amazon/mShop/feature/WeblabCsmUtils;->postFeatureTriggerWithTreatment(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V

    .line 96
    return-void
.end method

.method public static postFeatureTriggerWithTreatment(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V
    .locals 5
    .param p0, "featureName"    # Ljava/lang/String;
    .param p1, "treatment"    # Ljava/lang/String;
    .param p2, "cacheStamp"    # Ljava/lang/Integer;

    .prologue
    .line 105
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v4

    invoke-virtual {v4, p0}, Lcom/amazon/mShop/feature/Features;->isAllowClientTrigger(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 107
    new-instance v2, Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;

    invoke-direct {v2}, Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;-><init>()V

    .line 108
    .local v2, "featureExperience":Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;
    invoke-virtual {v2, p0}, Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;->setFeatureName(Ljava/lang/String;)V

    .line 109
    invoke-virtual {v2, p1}, Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;->setTreatment(Ljava/lang/String;)V

    .line 113
    invoke-virtual {v2, p2}, Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;->setCacheStamp(Ljava/lang/Integer;)V

    .line 116
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;-><init>()V

    .line 117
    .local v0, "clientLogInfo":Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;
    new-instance v3, Ljava/util/ArrayList;

    const/4 v4, 0x1

    invoke-direct {v3, v4}, Ljava/util/ArrayList;-><init>(I)V

    .line 118
    .local v3, "weblabMetrics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;>;"
    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 119
    new-instance v4, Ljava/util/Vector;

    invoke-direct {v4, v3}, Ljava/util/Vector;-><init>(Ljava/util/Collection;)V

    invoke-virtual {v0, v4}, Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;->setFeatures(Ljava/util/List;)V

    .line 120
    const-string/jumbo v4, "main"

    invoke-virtual {v0, v4}, Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;->setPageAssemblyType(Ljava/lang/String;)V

    .line 122
    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;-><init>()V

    .line 123
    .local v1, "clientMetrics":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;
    invoke-virtual {v1, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->setLogInfo(Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;)V

    .line 125
    invoke-static {v1}, Lcom/amazon/mShop/feature/WeblabCsmUtils;->postMetrics(Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;)V

    .line 128
    .end local v0    # "clientLogInfo":Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;
    .end local v1    # "clientMetrics":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;
    .end local v2    # "featureExperience":Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;
    .end local v3    # "weblabMetrics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;>;"
    :cond_0
    return-void
.end method

.method public static postMetrics(Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;)V
    .locals 2
    .param p0, "clientMetrics"    # Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    .prologue
    .line 60
    new-instance v0, Lcom/amazon/mShop/feature/WeblabCsmUtils$1;

    invoke-direct {v0}, Lcom/amazon/mShop/feature/WeblabCsmUtils$1;-><init>()V

    .line 83
    .local v0, "postMetricsResponseListener":Lcom/amazon/rio/j2me/client/services/mShop/PostMetricsResponseListener;
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v1

    invoke-interface {v1, p0, v0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->postMetrics(Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;Lcom/amazon/rio/j2me/client/services/mShop/PostMetricsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 84
    return-void
.end method
