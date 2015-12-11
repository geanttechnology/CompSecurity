.class public Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;
.super Ljava/lang/Object;
.source "RetailSearchInitializer.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/api/init/SearchInitializer;


# static fields
.field private static initializer:Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;


# instance fields
.field featureConfig:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private initComplete:Z

.field retailSearchDataProvider:Ldagger/Lazy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/Lazy",
            "<",
            "Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;",
            ">;"
        }
    .end annotation

    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

.field private settings:Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 39
    new-instance v0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;-><init>()V

    sput-object v0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;->initializer:Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;->initComplete:Z

    return-void
.end method

.method private doInit(Landroid/content/Context;Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "settings"    # Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;

    .prologue
    const/4 v1, 0x0

    .line 145
    iput-object p2, p0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;->settings:Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;

    .line 148
    const/4 v2, 0x1

    new-array v3, v2, [Ljava/lang/Object;

    const/4 v4, 0x0

    new-instance v5, Lcom/amazon/retailsearch/di/RetailSearchInternalModule;

    if-eqz p2, :cond_1

    invoke-virtual {p2}, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;->getFeatureConfiguration()Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

    move-result-object v2

    :goto_0
    if-eqz p2, :cond_0

    invoke-virtual {p2}, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;->getWeblabClient()Lcom/amazon/retailsearch/android/api/experimentation/WeblabClient;

    move-result-object v1

    :cond_0
    invoke-direct {v5, p1, v2, v1}, Lcom/amazon/retailsearch/di/RetailSearchInternalModule;-><init>(Landroid/content/Context;Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;Lcom/amazon/retailsearch/android/api/experimentation/WeblabClient;)V

    aput-object v5, v3, v4

    invoke-static {v3}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->createGraph([Ljava/lang/Object;)Ldagger/ObjectGraph;

    .line 154
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 156
    invoke-direct {p0, p1, p2}, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;->initializeLog(Landroid/content/Context;Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;)V

    .line 159
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/retailsearch/client/ClientIdProvider;->getClientId(Landroid/content/res/Resources;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->setClientId(Ljava/lang/String;)V

    .line 162
    invoke-virtual {p2}, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;->getUserAgent()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->setUserAgent(Ljava/lang/String;)V

    .line 163
    invoke-virtual {p2}, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;->getAppVersion()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->setAppVersion(Ljava/lang/String;)V

    .line 166
    invoke-static {}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->getInstance()Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;

    move-result-object v1

    const/16 v2, 0x2ee

    invoke-virtual {v1, p1, v2}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->refresh(Landroid/content/Context;I)V

    .line 169
    new-instance v0, Lcom/amazon/retailsearch/deviceinfo/MasEventReceiver;

    invoke-direct {v0}, Lcom/amazon/retailsearch/deviceinfo/MasEventReceiver;-><init>()V

    .line 170
    .local v0, "receiver":Lcom/amazon/retailsearch/deviceinfo/MasEventReceiver;
    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/deviceinfo/MasEventReceiver;->register(Landroid/content/Context;)V

    .line 171
    return-void

    .end local v0    # "receiver":Lcom/amazon/retailsearch/deviceinfo/MasEventReceiver;
    :cond_1
    move-object v2, v1

    .line 148
    goto :goto_0
.end method

.method public static getInstance()Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;
    .locals 1

    .prologue
    .line 107
    sget-object v0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;->initializer:Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;

    return-object v0
.end method

.method private initializeLog(Landroid/content/Context;Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "settings"    # Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;

    .prologue
    const/4 v3, 0x1

    .line 178
    invoke-static {}, Lcom/amazon/retailsearch/log/AppLog;->getAppLog()Lcom/amazon/retailsearch/log/AppLog;

    move-result-object v0

    .line 180
    .local v0, "appLog":Lcom/amazon/retailsearch/log/AppLog;
    if-eqz p2, :cond_0

    invoke-virtual {p2}, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;->isDebugMode()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 182
    invoke-static {v3}, Lcom/amazon/retailsearch/android/api/init/DebugMode;->setEnabled(Z)V

    .line 185
    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/log/AppLog;->setLevel(I)V

    .line 196
    :goto_0
    invoke-static {p1}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->init(Landroid/content/Context;)V

    .line 201
    invoke-virtual {v0}, Lcom/amazon/retailsearch/log/AppLog;->getRecorders()Ljava/util/List;

    move-result-object v1

    new-instance v2, Lcom/amazon/retailsearch/log/SearchLog;

    invoke-direct {v2, v0}, Lcom/amazon/retailsearch/log/SearchLog;-><init>(Lcom/amazon/retailsearch/log/AppLog;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 205
    invoke-virtual {v0, v3}, Lcom/amazon/retailsearch/log/AppLog;->setEnabled(Z)V

    .line 206
    return-void

    .line 189
    :cond_0
    const/4 v1, 0x0

    invoke-static {v1}, Lcom/amazon/retailsearch/android/api/init/DebugMode;->setEnabled(Z)V

    .line 192
    const/4 v1, 0x6

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/log/AppLog;->setLevel(I)V

    goto :goto_0
.end method


# virtual methods
.method public getSettings()Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;->settings:Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;

    return-object v0
.end method

.method public initialize(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 67
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;->initialize(Landroid/content/Context;Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;)V

    .line 68
    return-void
.end method

.method public initialize(Landroid/content/Context;Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "settings"    # Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;

    .prologue
    .line 48
    iget-boolean v6, p0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;->initComplete:Z

    if-eqz v6, :cond_0

    .line 59
    :goto_0
    return-void

    .line 52
    :cond_0
    invoke-static {}, Lcom/dp/utils/SystemTime;->now()J

    move-result-wide v2

    .line 53
    .local v2, "searchInitStart":J
    invoke-direct {p0, p1, p2}, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;->doInit(Landroid/content/Context;Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;)V

    .line 54
    const/4 v6, 0x1

    iput-boolean v6, p0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;->initComplete:Z

    .line 55
    invoke-static {}, Lcom/dp/utils/SystemTime;->now()J

    move-result-wide v0

    .line 56
    .local v0, "searchInitComplete":J
    sub-long v4, v0, v2

    .line 57
    .local v4, "searchInitializationTime":J
    invoke-static {}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getInstance()Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getRetailSearchLogger()Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v6

    iput-object v6, p0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    .line 58
    iget-object v6, p0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    invoke-interface {v6, v4, v5}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->saveSearchInitTime(J)V

    goto :goto_0
.end method

.method public onStartup()V
    .locals 3

    .prologue
    .line 129
    :try_start_0
    iget-object v1, p0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;->retailSearchDataProvider:Ldagger/Lazy;

    invoke-interface {v1}, Ldagger/Lazy;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;

    sget-object v2, Lcom/amazon/retailsearch/data/assets/AssetFetchType;->STARTUP_SEQUENCE:Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    invoke-interface {v1, v2}, Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;->fetchAssets(Lcom/amazon/retailsearch/data/assets/AssetFetchType;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 135
    :goto_0
    return-void

    .line 131
    :catch_0
    move-exception v0

    .line 133
    .local v0, "e":Ljava/lang/Exception;
    iget-object v1, p0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    const-string/jumbo v2, "startUp call resulted in an exception"

    invoke-interface {v1, v2, v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public reset()V
    .locals 1

    .prologue
    .line 73
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;->reset(Ljava/util/Locale;)V

    .line 74
    return-void
.end method

.method public reset(Ljava/util/Locale;)V
    .locals 4
    .param p1, "locale"    # Ljava/util/Locale;

    .prologue
    .line 79
    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getConfiguration()Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;

    move-result-object v1

    .line 80
    .local v1, "searchConfig":Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;
    if-nez p1, :cond_0

    .line 82
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object p1

    .line 84
    :cond_0
    invoke-virtual {v1, p1}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getRealmForLocale(Ljava/util/Locale;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v0

    .line 86
    .local v0, "newRealm":Lcom/amazon/searchapp/retailsearch/client/SearchRealm;
    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getRealm()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 98
    :goto_0
    return-void

    .line 90
    :cond_1
    invoke-virtual {v1, v0}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->setRealm(Lcom/amazon/searchapp/retailsearch/client/SearchRealm;)V

    .line 91
    invoke-static {}, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->resetClient()V

    .line 94
    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;->retailSearchDataProvider:Ldagger/Lazy;

    invoke-interface {v2}, Ldagger/Lazy;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;

    invoke-interface {v2}, Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;->clearAssets()V

    .line 95
    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;->retailSearchDataProvider:Ldagger/Lazy;

    invoke-interface {v2}, Ldagger/Lazy;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;

    sget-object v3, Lcom/amazon/retailsearch/data/assets/AssetFetchType;->APP_RESET:Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    invoke-interface {v2, v3}, Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;->fetchAssets(Lcom/amazon/retailsearch/data/assets/AssetFetchType;)V

    .line 97
    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;->retailSearchDataProvider:Ldagger/Lazy;

    invoke-interface {v2}, Ldagger/Lazy;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;

    invoke-interface {v2}, Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;->clearSuggestions()V

    goto :goto_0
.end method
