.class public Lcom/amazon/mShop/feature/FeatureTrigger;
.super Ljava/lang/Object;
.source "FeatureTrigger.java"


# static fields
.field private static final DEBUG:Z

.field private static final REMOVE_SERVICE_CALL_AFTER_SENDING_TRIGGER:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final SERVICECALL_TO_FEATURE:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 19
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/feature/FeatureTrigger;->DEBUG:Z

    .line 31
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amazon/mShop/feature/FeatureTrigger;->SERVICECALL_TO_FEATURE:Ljava/util/Map;

    .line 41
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/amazon/mShop/feature/FeatureTrigger;->REMOVE_SERVICE_CALL_AFTER_SENDING_TRIGGER:Ljava/util/List;

    .line 43
    sget-object v0, Lcom/amazon/mShop/feature/FeatureTrigger;->REMOVE_SERVICE_CALL_AFTER_SENDING_TRIGGER:Ljava/util/List;

    const-string/jumbo v1, "post_metrics_v36"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 44
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static final declared-synchronized getHttpHeaderFeatureTriggers(Ljava/lang/String;)Ljava/lang/String;
    .locals 11
    .param p0, "method"    # Ljava/lang/String;

    .prologue
    .line 72
    const-class v8, Lcom/amazon/mShop/feature/FeatureTrigger;

    monitor-enter v8

    :try_start_0
    sget-object v7, Lcom/amazon/mShop/feature/FeatureTrigger;->SERVICECALL_TO_FEATURE:Ljava/util/Map;

    invoke-interface {v7, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [Ljava/lang/String;

    .line 73
    .local v3, "featureNames":[Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty([Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v7

    if-eqz v7, :cond_0

    .line 74
    const/4 v7, 0x0

    .line 97
    :goto_0
    monitor-exit v8

    return-object v7

    .line 77
    :cond_0
    :try_start_1
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 79
    .local v1, "featureList":Ljava/lang/StringBuilder;
    move-object v0, v3

    .local v0, "arr$":[Ljava/lang/String;
    array-length v5, v0

    .local v5, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_1
    if-ge v4, v5, :cond_2

    aget-object v2, v0, v4

    .line 80
    .local v2, "featureName":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v7

    invoke-virtual {v7, v2}, Lcom/amazon/mShop/feature/Features;->getFeatureState(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 82
    .local v6, "treatment":Ljava/lang/String;
    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_1

    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v7

    invoke-virtual {v7, v2}, Lcom/amazon/mShop/feature/Features;->isAllowClientTrigger(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 83
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string/jumbo v9, "="

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 84
    const-string/jumbo v7, ";"

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 79
    :cond_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 88
    .end local v2    # "featureName":Ljava/lang/String;
    .end local v6    # "treatment":Ljava/lang/String;
    :cond_2
    sget-boolean v7, Lcom/amazon/mShop/feature/FeatureTrigger;->DEBUG:Z

    if-eqz v7, :cond_3

    .line 89
    const-string/jumbo v7, "Trigger"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v10, "Method:"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string/jumbo v10, " Header:"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v7, v9}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 93
    :cond_3
    sget-object v7, Lcom/amazon/mShop/feature/FeatureTrigger;->REMOVE_SERVICE_CALL_AFTER_SENDING_TRIGGER:Ljava/util/List;

    invoke-interface {v7, p0}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_4

    .line 94
    invoke-static {p0}, Lcom/amazon/mShop/feature/FeatureTrigger;->removeServiceCallAndFeature(Ljava/lang/String;)V

    .line 97
    :cond_4
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v7

    goto/16 :goto_0

    .line 72
    .end local v0    # "arr$":[Ljava/lang/String;
    .end local v1    # "featureList":Ljava/lang/StringBuilder;
    .end local v3    # "featureNames":[Ljava/lang/String;
    .end local v4    # "i$":I
    .end local v5    # "len$":I
    :catchall_0
    move-exception v7

    monitor-exit v8

    throw v7
.end method

.method public static removeServiceCallAndFeature(Ljava/lang/String;)V
    .locals 1
    .param p0, "serviceCall"    # Ljava/lang/String;

    .prologue
    .line 62
    sget-object v0, Lcom/amazon/mShop/feature/FeatureTrigger;->SERVICECALL_TO_FEATURE:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 63
    return-void
.end method
