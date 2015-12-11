.class public Lcom/poshmark/utils/FeatureManager;
.super Ljava/lang/Object;
.source "FeatureManager.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;


# static fields
.field static globalFeatureManager:Lcom/poshmark/utils/FeatureManager;


# instance fields
.field currentFeatures:Lcom/poshmark/data_model/models/Features;

.field lastFetchTime:Ljava/util/Date;

.field mutex:Ljava/lang/Object;

.field savedFeatureSettings:Landroid/content/SharedPreferences;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 33
    const/4 v0, 0x0

    sput-object v0, Lcom/poshmark/utils/FeatureManager;->globalFeatureManager:Lcom/poshmark/utils/FeatureManager;

    return-void
.end method

.method private constructor <init>()V
    .locals 3

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    .line 49
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.NEW_FEATURES_ON_SERVER"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 50
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGOUT_COMPLETE"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 52
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "savedFeatureSettings"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/utils/FeatureManager;->savedFeatureSettings:Landroid/content/SharedPreferences;

    .line 56
    invoke-direct {p0}, Lcom/poshmark/utils/FeatureManager;->cachedFeaturesAvailable()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 57
    invoke-direct {p0}, Lcom/poshmark/utils/FeatureManager;->getCachedFeatures()Lcom/poshmark/data_model/models/Features;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    .line 63
    :goto_0
    return-void

    .line 60
    :cond_0
    new-instance v0, Lcom/poshmark/data_model/models/Features;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/Features;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    goto :goto_0
.end method

.method static synthetic access$000(Lcom/poshmark/utils/FeatureManager;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/utils/FeatureManager;

    .prologue
    .line 30
    invoke-direct {p0}, Lcom/poshmark/utils/FeatureManager;->saveFeaturesToCache()V

    return-void
.end method

.method private cachedFeaturesAvailable()Z
    .locals 4

    .prologue
    .line 339
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->savedFeatureSettings:Landroid/content/SharedPreferences;

    const-string v2, "FEATURES_JSON"

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 340
    .local v0, "cachedFeaturesJSON":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 341
    const/4 v1, 0x1

    .line 343
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private clearAllSavedSettings()V
    .locals 2

    .prologue
    .line 329
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 330
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->savedFeatureSettings:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 332
    new-instance v0, Lcom/poshmark/data_model/models/Features;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/Features;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    .line 334
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/utils/FeatureManager;->lastFetchTime:Ljava/util/Date;

    .line 335
    monitor-exit v1

    .line 336
    return-void

    .line 335
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private getCachedFeatures()Lcom/poshmark/data_model/models/Features;
    .locals 6

    .prologue
    const/4 v3, 0x0

    .line 317
    iget-object v4, p0, Lcom/poshmark/utils/FeatureManager;->savedFeatureSettings:Landroid/content/SharedPreferences;

    const-string v5, "FEATURES_JSON"

    invoke-interface {v4, v5, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 318
    .local v1, "cachedFeaturesJSON":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 319
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 320
    .local v0, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v2

    .line 321
    .local v2, "gson":Lcom/google/gson/Gson;
    const-class v3, Lcom/poshmark/data_model/models/Features;

    instance-of v4, v2, Lcom/google/gson/Gson;

    if-nez v4, :cond_1

    invoke-virtual {v2, v1, v3}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v3

    .end local v2    # "gson":Lcom/google/gson/Gson;
    :goto_0
    check-cast v3, Lcom/poshmark/data_model/models/Features;

    .line 323
    .end local v0    # "b":Lcom/google/gson/GsonBuilder;
    :cond_0
    return-object v3

    .line 321
    .restart local v0    # "b":Lcom/google/gson/GsonBuilder;
    .restart local v2    # "gson":Lcom/google/gson/Gson;
    :cond_1
    check-cast v2, Lcom/google/gson/Gson;

    .end local v2    # "gson":Lcom/google/gson/Gson;
    invoke-static {v2, v1, v3}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v3

    goto :goto_0
.end method

.method private getFeatures()V
    .locals 1

    .prologue
    .line 348
    new-instance v0, Lcom/poshmark/utils/FeatureManager$1;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/FeatureManager$1;-><init>(Lcom/poshmark/utils/FeatureManager;)V

    invoke-static {v0}, Lcom/poshmark/http/api/PMApi;->getFeatures(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 360
    return-void
.end method

.method public static declared-synchronized getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;
    .locals 2

    .prologue
    .line 36
    const-class v1, Lcom/poshmark/utils/FeatureManager;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/poshmark/utils/FeatureManager;->globalFeatureManager:Lcom/poshmark/utils/FeatureManager;

    if-nez v0, :cond_0

    .line 37
    new-instance v0, Lcom/poshmark/utils/FeatureManager;

    invoke-direct {v0}, Lcom/poshmark/utils/FeatureManager;-><init>()V

    sput-object v0, Lcom/poshmark/utils/FeatureManager;->globalFeatureManager:Lcom/poshmark/utils/FeatureManager;

    .line 39
    :cond_0
    sget-object v0, Lcom/poshmark/utils/FeatureManager;->globalFeatureManager:Lcom/poshmark/utils/FeatureManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 36
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private saveFeaturesToCache()V
    .locals 6

    .prologue
    .line 363
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 364
    .local v0, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v2

    .line 365
    .local v2, "gson":Lcom/google/gson/Gson;
    iget-object v3, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    const-class v4, Lcom/poshmark/data_model/models/Features;

    instance-of v5, v2, Lcom/google/gson/Gson;

    if-nez v5, :cond_1

    invoke-virtual {v2, v3, v4}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v1

    .line 366
    .end local v2    # "gson":Lcom/google/gson/Gson;
    .local v1, "featuresJson":Ljava/lang/String;
    :goto_0
    if-eqz v1, :cond_0

    .line 367
    iget-object v3, p0, Lcom/poshmark/utils/FeatureManager;->savedFeatureSettings:Landroid/content/SharedPreferences;

    invoke-interface {v3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    const-string v4, "FEATURES_JSON"

    invoke-interface {v3, v4, v1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    invoke-interface {v3}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 371
    :cond_0
    return-void

    .line 365
    .end local v1    # "featuresJson":Ljava/lang/String;
    .restart local v2    # "gson":Lcom/google/gson/Gson;
    :cond_1
    check-cast v2, Lcom/google/gson/Gson;

    .end local v2    # "gson":Lcom/google/gson/Gson;
    invoke-static {v2, v3, v4}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method


# virtual methods
.method public getAddToBundleButtonFeature()Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature;
    .locals 2

    .prologue
    .line 265
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 266
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Features;->getAddToBundleButtonFeature()Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature;

    move-result-object v0

    monitor-exit v1

    return-object v0

    .line 267
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public getBrandShareTriggerFeature()Lcom/poshmark/triggers/TriggerThresholds;
    .locals 2

    .prologue
    .line 277
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 278
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Features;->getBrandShareTriggerFeature()Lcom/poshmark/triggers/TriggerThresholds;

    move-result-object v0

    monitor-exit v1

    return-object v0

    .line 279
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public getFbShareProTipInfo(Lcom/poshmark/utils/ShareManager$SHARE_MODE;)Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;
    .locals 2
    .param p1, "mode"    # Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    .prologue
    .line 223
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 224
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0, p1}, Lcom/poshmark/data_model/models/Features;->isShareProTipEnabled(Lcom/poshmark/utils/ShareManager$SHARE_MODE;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 225
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0, p1}, Lcom/poshmark/data_model/models/Features;->getFbShareProTipInfo(Lcom/poshmark/utils/ShareManager$SHARE_MODE;)Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    move-result-object v0

    monitor-exit v1

    .line 227
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    monitor-exit v1

    goto :goto_0

    .line 229
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public getFeedAutoRefreshFeature()Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature;
    .locals 2

    .prologue
    .line 301
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 302
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Features;->getFeedAutoRefreshFeature()Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature;

    move-result-object v0

    monitor-exit v1

    return-object v0

    .line 303
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public getFeedLazyLoadFeature()Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature;
    .locals 2

    .prologue
    .line 295
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 296
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Features;->getLazyFeedLoadFeature()Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature;

    move-result-object v0

    monitor-exit v1

    return-object v0

    .line 297
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public getListingFeature()Lcom/poshmark/data_model/models/inner_models/ListingFeature;
    .locals 2

    .prologue
    .line 127
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 128
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Features;->getListingFeature()Lcom/poshmark/data_model/models/inner_models/ListingFeature;

    move-result-object v0

    monitor-exit v1

    return-object v0

    .line 129
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public getLuxuryFeature()Lcom/poshmark/data_model/models/inner_models/ShopTabLuxuryFeature;
    .locals 2

    .prologue
    .line 289
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 290
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Features;->getLuxuryFeature()Lcom/poshmark/data_model/models/inner_models/ShopTabLuxuryFeature;

    move-result-object v0

    monitor-exit v1

    return-object v0

    .line 291
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public getRateAppTriggerFeature()Lcom/poshmark/triggers/TriggerThresholds;
    .locals 2

    .prologue
    .line 283
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 284
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Features;->getRateAppTriggerFeature()Lcom/poshmark/triggers/TriggerThresholds;

    move-result-object v0

    monitor-exit v1

    return-object v0

    .line 285
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public getSimilarListingsFeature()Lcom/poshmark/data_model/models/inner_models/SimilarListings;
    .locals 2

    .prologue
    .line 271
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 272
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Features;->getSimilarListingsFeature()Lcom/poshmark/data_model/models/inner_models/SimilarListings;

    move-result-object v0

    monitor-exit v1

    return-object v0

    .line 273
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 308
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.NEW_FEATURES_ON_SERVER"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 309
    invoke-direct {p0}, Lcom/poshmark/utils/FeatureManager;->getFeatures()V

    .line 314
    :cond_0
    :goto_0
    return-void

    .line 310
    :cond_1
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGOUT_COMPLETE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 312
    invoke-direct {p0}, Lcom/poshmark/utils/FeatureManager;->clearAllSavedSettings()V

    goto :goto_0
.end method

.method public isAddToBundleButtonFeatureEnabled()Z
    .locals 2

    .prologue
    .line 244
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 245
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Features;->isAddToBundleButtonFeatureEnabled()Z

    move-result v0

    if-nez v0, :cond_1

    .line 246
    :cond_0
    const/4 v0, 0x0

    monitor-exit v1

    .line 248
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    monitor-exit v1

    goto :goto_0

    .line 250
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public isAutoCompleteSearchEnabled()Z
    .locals 2

    .prologue
    .line 87
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 88
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Features;->isAutoCompleteEnabled()Z

    move-result v0

    if-nez v0, :cond_1

    .line 89
    :cond_0
    const/4 v0, 0x0

    monitor-exit v1

    .line 91
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    monitor-exit v1

    goto :goto_0

    .line 93
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public isBrandPriceDropEnabled()Z
    .locals 2

    .prologue
    .line 133
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 134
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Features;->isBrandPriceDropEnabled()Z

    move-result v0

    if-nez v0, :cond_1

    .line 135
    :cond_0
    const/4 v0, 0x0

    monitor-exit v1

    .line 137
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    monitor-exit v1

    goto :goto_0

    .line 139
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public isBrandsFollowOnSignupEnabled()Z
    .locals 2

    .prologue
    .line 97
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 98
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Features;->isBrandsFollowOnSignupEnabled()Z

    move-result v0

    if-nez v0, :cond_1

    .line 99
    :cond_0
    const/4 v0, 0x0

    monitor-exit v1

    .line 101
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    monitor-exit v1

    goto :goto_0

    .line 103
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public isEditListingWithNFSEnable()Z
    .locals 2

    .prologue
    .line 117
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 118
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Features;->isEditListingWithNFSEnabled()Z

    move-result v0

    if-nez v0, :cond_1

    .line 119
    :cond_0
    const/4 v0, 0x0

    monitor-exit v1

    .line 121
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    monitor-exit v1

    goto :goto_0

    .line 123
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public isFbExplicitShareEnabled()Z
    .locals 2

    .prologue
    .line 203
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 204
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Features;->isFbExplicitShareEnabled()Z

    move-result v0

    if-nez v0, :cond_1

    .line 205
    :cond_0
    const/4 v0, 0x0

    monitor-exit v1

    .line 207
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    monitor-exit v1

    goto :goto_0

    .line 209
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public isFbMessengerSharingEnabled()Z
    .locals 2

    .prologue
    .line 234
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 235
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Features;->isFBMessengerSharingEnabled()Z

    move-result v0

    if-nez v0, :cond_1

    .line 236
    :cond_0
    const/4 v0, 0x0

    monitor-exit v1

    .line 238
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    monitor-exit v1

    goto :goto_0

    .line 240
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public isFbShareProTipEnabled(Lcom/poshmark/utils/ShareManager$SHARE_MODE;)Z
    .locals 2
    .param p1, "mode"    # Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    .prologue
    .line 213
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 214
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0, p1}, Lcom/poshmark/data_model/models/Features;->isShareProTipEnabled(Lcom/poshmark/utils/ShareManager$SHARE_MODE;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 215
    :cond_0
    const/4 v0, 0x0

    monitor-exit v1

    .line 217
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    monitor-exit v1

    goto :goto_0

    .line 219
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public isFilterBarv2FeatureEnabled()Z
    .locals 2

    .prologue
    .line 255
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 256
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Features;->isFilterBarv2FeatureEnabled()Z

    move-result v0

    if-nez v0, :cond_1

    .line 257
    :cond_0
    const/4 v0, 0x0

    monitor-exit v1

    .line 259
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    monitor-exit v1

    goto :goto_0

    .line 261
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public isListingDetailsPriceDropEnabled()Z
    .locals 2

    .prologue
    .line 153
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 154
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Features;->isListingDetailsPriceDropEnabled()Z

    move-result v0

    if-nez v0, :cond_1

    .line 155
    :cond_0
    const/4 v0, 0x0

    monitor-exit v1

    .line 157
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    monitor-exit v1

    goto :goto_0

    .line 159
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public isMakeAnOfferEnabled()Z
    .locals 2

    .prologue
    .line 107
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 108
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Features;->isMakeAnOfferEnabled()Z

    move-result v0

    if-nez v0, :cond_1

    .line 109
    :cond_0
    const/4 v0, 0x0

    monitor-exit v1

    .line 111
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    monitor-exit v1

    goto :goto_0

    .line 113
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public isMyLikesFiltersEnabled()Z
    .locals 2

    .prologue
    .line 173
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 174
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Features;->isMyLikesFiltersEnabled()Z

    move-result v0

    if-nez v0, :cond_1

    .line 175
    :cond_0
    const/4 v0, 0x0

    monitor-exit v1

    .line 177
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    monitor-exit v1

    goto :goto_0

    .line 179
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public isMyLikesPriceDropEnabled()Z
    .locals 2

    .prologue
    .line 163
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 164
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Features;->isMyLikesPriceDropEnabled()Z

    move-result v0

    if-nez v0, :cond_1

    .line 165
    :cond_0
    const/4 v0, 0x0

    monitor-exit v1

    .line 167
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    monitor-exit v1

    goto :goto_0

    .line 169
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public isNewListingDetailsLayoutEnabled()Z
    .locals 2

    .prologue
    .line 193
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 194
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Features;->isNewListingDetailsFeatureEnabled()Z

    move-result v0

    if-nez v0, :cond_1

    .line 195
    :cond_0
    const/4 v0, 0x0

    monitor-exit v1

    .line 197
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    monitor-exit v1

    goto :goto_0

    .line 199
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public isPinterestButtonEnabled()Z
    .locals 1

    .prologue
    .line 374
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Features;->isPinterestButtonEnabled()Z

    move-result v0

    return v0
.end method

.method public isPinterestConnectionDialogShowable()Z
    .locals 1

    .prologue
    .line 378
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Features;->isPinterestConnectionDialogShowable()Z

    move-result v0

    return v0
.end method

.method public isShowroomPriceDropEnabled()Z
    .locals 2

    .prologue
    .line 143
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 144
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Features;->isShowroomPriceDropEnabled()Z

    move-result v0

    if-nez v0, :cond_1

    .line 145
    :cond_0
    const/4 v0, 0x0

    monitor-exit v1

    .line 147
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    monitor-exit v1

    goto :goto_0

    .line 149
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public isShowroomsEnabled()Z
    .locals 2

    .prologue
    .line 76
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 78
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Features;->isShowRoomsEnabled()Z

    move-result v0

    if-nez v0, :cond_1

    .line 79
    :cond_0
    const/4 v0, 0x0

    monitor-exit v1

    .line 81
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    monitor-exit v1

    goto :goto_0

    .line 83
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public isSimilarListingsFeatureEnabled()Z
    .locals 2

    .prologue
    .line 183
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 184
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Features;->isSimilarListingsFeatureEnabled()Z

    move-result v0

    if-nez v0, :cond_1

    .line 185
    :cond_0
    const/4 v0, 0x0

    monitor-exit v1

    .line 187
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    monitor-exit v1

    goto :goto_0

    .line 189
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public lastUpdatedBefore(Ljava/util/Date;)Z
    .locals 2
    .param p1, "lastUpdatedAt"    # Ljava/util/Date;

    .prologue
    .line 66
    iget-object v1, p0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 67
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->lastFetchTime:Ljava/util/Date;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager;->lastFetchTime:Ljava/util/Date;

    invoke-virtual {v0, p1}, Ljava/util/Date;->before(Ljava/util/Date;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 68
    :cond_0
    const/4 v0, 0x1

    monitor-exit v1

    .line 70
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    monitor-exit v1

    goto :goto_0

    .line 72
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
