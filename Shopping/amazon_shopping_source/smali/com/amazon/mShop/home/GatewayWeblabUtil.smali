.class public Lcom/amazon/mShop/home/GatewayWeblabUtil;
.super Ljava/lang/Object;
.source "GatewayWeblabUtil.java"


# static fields
.field private static final DEBUG:Z

.field private static sGatewayWeblabUtil:Lcom/amazon/mShop/home/GatewayWeblabUtil;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    new-instance v0, Lcom/amazon/mShop/home/GatewayWeblabUtil;

    invoke-direct {v0}, Lcom/amazon/mShop/home/GatewayWeblabUtil;-><init>()V

    sput-object v0, Lcom/amazon/mShop/home/GatewayWeblabUtil;->sGatewayWeblabUtil:Lcom/amazon/mShop/home/GatewayWeblabUtil;

    .line 23
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/home/GatewayWeblabUtil;->DEBUG:Z

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    return-void
.end method

.method static synthetic access$000()Z
    .locals 1

    .prologue
    .line 20
    sget-boolean v0, Lcom/amazon/mShop/home/GatewayWeblabUtil;->DEBUG:Z

    return v0
.end method

.method public static getInstance()Lcom/amazon/mShop/home/GatewayWeblabUtil;
    .locals 1

    .prologue
    .line 33
    sget-object v0, Lcom/amazon/mShop/home/GatewayWeblabUtil;->sGatewayWeblabUtil:Lcom/amazon/mShop/home/GatewayWeblabUtil;

    return-object v0
.end method


# virtual methods
.method public postGatewayFeatureTrigger(Z)V
    .locals 4
    .param p1, "shouldPostDelay"    # Z

    .prologue
    .line 85
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v2

    const-string/jumbo v3, "Android_ShopAppHTMLGateway"

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/feature/Features;->getFeatureState(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 86
    .local v1, "treatment":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v2

    const-string/jumbo v3, "Android_ShopAppHTMLGateway"

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/feature/Features;->getFeatureCacheStamp(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    .line 87
    .local v0, "cachedTimeStamp":Ljava/lang/Integer;
    if-eqz p1, :cond_0

    .line 88
    invoke-virtual {p0, v1, v0}, Lcom/amazon/mShop/home/GatewayWeblabUtil;->postGatewayFeatureTriggerWithTreatment(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 94
    :goto_0
    return-void

    .line 91
    :cond_0
    const-string/jumbo v2, "Android_ShopAppHTMLGateway"

    invoke-static {v2, v1, v0}, Lcom/amazon/mShop/feature/WeblabCsmUtils;->postFeatureTriggerWithTreatment(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V

    goto :goto_0
.end method

.method public postGatewayFeatureTriggerWithTreatment(Ljava/lang/String;Ljava/lang/Integer;)V
    .locals 6
    .param p1, "featureState"    # Ljava/lang/String;
    .param p2, "cacheStamp"    # Ljava/lang/Integer;

    .prologue
    .line 102
    const-string/jumbo v2, "debugHTMLGateway"

    invoke-static {v2}, Lcom/amazon/mShop/util/ActivityUtils;->isDebugSettingEnabled(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 104
    move-object v1, p1

    .line 105
    .local v1, "treatment":Ljava/lang/String;
    move-object v0, p2

    .line 107
    .local v0, "cachedTimeStamp":Ljava/lang/Integer;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    new-instance v3, Lcom/amazon/mShop/home/GatewayWeblabUtil$1;

    invoke-direct {v3, p0, v1, v0}, Lcom/amazon/mShop/home/GatewayWeblabUtil$1;-><init>(Lcom/amazon/mShop/home/GatewayWeblabUtil;Ljava/lang/String;Ljava/lang/Integer;)V

    const-wide/16 v4, 0x4e20

    invoke-interface {v2, v3, v4, v5}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;J)V

    .line 118
    .end local v0    # "cachedTimeStamp":Ljava/lang/Integer;
    .end local v1    # "treatment":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public updateGatewayWeblabState()Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;
    .locals 8

    .prologue
    .line 45
    const-string/jumbo v6, "debugHTMLGateway"

    invoke-static {v6}, Lcom/amazon/mShop/util/ActivityUtils;->isDebugSettingEnabled(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_4

    .line 47
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v6

    const-string/jumbo v7, "Android_ShopAppHTMLGateway"

    invoke-virtual {v6, v7}, Lcom/amazon/mShop/feature/Features;->getFeatureState(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 48
    .local v3, "featureState":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v6

    const-string/jumbo v7, "Android_ShopAppHTMLGateway"

    invoke-virtual {v6, v7}, Lcom/amazon/mShop/feature/Features;->getFeatureCacheStamp(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v4

    .line 49
    .local v4, "featureTimestamp":Ljava/lang/Integer;
    if-nez v4, :cond_0

    const/4 v5, 0x0

    .line 51
    .local v5, "featureTimestampIntVal":I
    :goto_0
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v6

    invoke-interface {v6}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    .line 53
    .local v2, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v6, "GatewayTreatment"

    invoke-interface {v2, v6}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 54
    .local v0, "cachedState":Ljava/lang/String;
    const-string/jumbo v6, "GatewayCacheStamp"

    invoke-interface {v2, v6}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getInt(Ljava/lang/String;)I

    move-result v1

    .line 55
    .local v1, "cachedTimeStamp":I
    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_3

    .line 56
    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 58
    const-string/jumbo v6, "GatewayTreatment"

    invoke-interface {v2, v6, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 59
    const-string/jumbo v6, "GatewayCacheStamp"

    invoke-interface {v2, v6, v5}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putInt(Ljava/lang/String;I)V

    .line 60
    sget-object v6, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;->TREATMENT_CHANGE:Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    .line 76
    .end local v0    # "cachedState":Ljava/lang/String;
    .end local v1    # "cachedTimeStamp":I
    .end local v2    # "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    .end local v3    # "featureState":Ljava/lang/String;
    .end local v4    # "featureTimestamp":Ljava/lang/Integer;
    .end local v5    # "featureTimestampIntVal":I
    :goto_1
    return-object v6

    .line 49
    .restart local v3    # "featureState":Ljava/lang/String;
    .restart local v4    # "featureTimestamp":Ljava/lang/Integer;
    :cond_0
    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v5

    goto :goto_0

    .line 61
    .restart local v0    # "cachedState":Ljava/lang/String;
    .restart local v1    # "cachedTimeStamp":I
    .restart local v2    # "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    .restart local v5    # "featureTimestampIntVal":I
    :cond_1
    if-eq v5, v1, :cond_2

    .line 63
    const-string/jumbo v6, "GatewayCacheStamp"

    invoke-interface {v2, v6, v5}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putInt(Ljava/lang/String;I)V

    .line 64
    sget-object v6, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;->CACHETIMESTAMP_CHANGE:Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    goto :goto_1

    .line 66
    :cond_2
    sget-object v6, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;->NO_CHANGE:Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    goto :goto_1

    .line 70
    :cond_3
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_4

    .line 71
    const-string/jumbo v6, "GatewayTreatment"

    const-string/jumbo v7, ""

    invoke-interface {v2, v6, v7}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 72
    sget-object v6, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;->TREATMENT_CHANGE:Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    goto :goto_1

    .line 76
    .end local v0    # "cachedState":Ljava/lang/String;
    .end local v1    # "cachedTimeStamp":I
    .end local v2    # "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    .end local v3    # "featureState":Ljava/lang/String;
    .end local v4    # "featureTimestamp":Ljava/lang/Integer;
    .end local v5    # "featureTimestampIntVal":I
    :cond_4
    sget-object v6, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;->NO_CHANGE:Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    goto :goto_1
.end method
