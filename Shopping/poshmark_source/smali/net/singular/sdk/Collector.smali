.class Lnet/singular/sdk/Collector;
.super Ljava/lang/Object;
.source "Collector.java"


# static fields
.field public static final COLLECTOR_NAMESPACE:Ljava/lang/String; = "collector"

.field public static final EXTERNAL_JOB_MAX_TIMEOUT_MILLIS:I = 0x2710


# instance fields
.field private I:Lnet/singular/sdk/NewInjector;

.field private adIdHelper:Lnet/singular/sdk/AdvertisingIdHelper;

.field private advertisingId:Ljava/lang/String;

.field private androidId:Ljava/lang/String;

.field private androidVersion:Ljava/lang/String;

.field private apiKey:Ljava/lang/String;

.field private appId:Ljava/lang/String;

.field private appVersionCode:I

.field private appVersionName:Ljava/lang/String;

.field private brand:Ljava/lang/String;

.field private carrierName:Ljava/lang/String;

.field private context:Landroid/content/Context;

.field private countersLogger:Lnet/singular/sdk/CountersLogger;

.field private currency:Ljava/lang/String;

.field private final debug_vars:Lorg/json/JSONObject;

.field private externalJobsWorker:Lnet/singular/sdk/PostableWorker;

.field private final facebookAttributionGetter:Lnet/singular/sdk/FacebookAttributionIdGetter;

.field private facebookAttributionId:Ljava/lang/String;

.field private firstInstallTime:Ljava/lang/Long;

.field private firstUploadDelay:Ljava/lang/Long;

.field private isFirstOpen:Z

.field private language:Ljava/lang/String;

.field private lastUpdateTime:Ljava/lang/Long;

.field private localeCountry:Ljava/lang/String;

.field private locationCountry:Ljava/lang/String;

.field private final log:Lnet/singular/sdk/SingularLog;

.field private macAddress:Ljava/lang/String;

.field private final manifestHelper:Lnet/singular/sdk/ManifestHelper;

.field private manufacturer:Ljava/lang/String;

.field private model:Ljava/lang/String;

.field private networkCountry:Ljava/lang/String;

.field private normalUploadDelay:Ljava/lang/Long;

.field private packageName:Ljava/lang/String;

.field private preferences:Lnet/singular/sdk/KeyValueStore;

.field private referralId:Ljava/lang/String;

.field private final referralIdLock:Ljava/lang/Object;

.field private sandbox:Z

.field private sdkVersion:I

.field private final sessionManager:Lnet/singular/sdk/SessionManager;

.field private simCountry:Ljava/lang/String;

.field private singularId:Ljava/lang/String;

.field private temporalIds:Lorg/json/JSONObject;


# direct methods
.method public constructor <init>(Lnet/singular/sdk/SingularLog;Landroid/content/Context;Lnet/singular/sdk/AdvertisingIdHelper;Lnet/singular/sdk/SessionManager;Lnet/singular/sdk/CountersLogger;Lnet/singular/sdk/ManifestHelper;Lnet/singular/sdk/FacebookAttributionIdGetter;Lnet/singular/sdk/NewInjector;Z)V
    .locals 1
    .param p1, "log"    # Lnet/singular/sdk/SingularLog;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "adIdHelper"    # Lnet/singular/sdk/AdvertisingIdHelper;
    .param p4, "sessionManager"    # Lnet/singular/sdk/SessionManager;
    .param p5, "countersLogger"    # Lnet/singular/sdk/CountersLogger;
    .param p6, "manifestHelper"    # Lnet/singular/sdk/ManifestHelper;
    .param p7, "facebookAttributionGetter"    # Lnet/singular/sdk/FacebookAttributionIdGetter;
    .param p8, "I"    # Lnet/singular/sdk/NewInjector;
    .param p9, "sandbox"    # Z

    .prologue
    .line 80
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 81
    iput-object p1, p0, Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;

    .line 82
    iput-object p2, p0, Lnet/singular/sdk/Collector;->context:Landroid/content/Context;

    .line 84
    iput-object p3, p0, Lnet/singular/sdk/Collector;->adIdHelper:Lnet/singular/sdk/AdvertisingIdHelper;

    .line 85
    iput-object p4, p0, Lnet/singular/sdk/Collector;->sessionManager:Lnet/singular/sdk/SessionManager;

    .line 86
    const-string v0, "external_worker"

    invoke-virtual {p8, v0}, Lnet/singular/sdk/NewInjector;->generatePostableWorker(Ljava/lang/String;)Lnet/singular/sdk/PostableWorker;

    move-result-object v0

    iput-object v0, p0, Lnet/singular/sdk/Collector;->externalJobsWorker:Lnet/singular/sdk/PostableWorker;

    .line 87
    const/4 v0, 0x0

    iput-boolean v0, p0, Lnet/singular/sdk/Collector;->isFirstOpen:Z

    .line 88
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lnet/singular/sdk/Collector;->referralIdLock:Ljava/lang/Object;

    .line 89
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    iput-object v0, p0, Lnet/singular/sdk/Collector;->debug_vars:Lorg/json/JSONObject;

    .line 90
    iget-object v0, p0, Lnet/singular/sdk/Collector;->externalJobsWorker:Lnet/singular/sdk/PostableWorker;

    invoke-virtual {v0}, Lnet/singular/sdk/PostableWorker;->start()V

    .line 91
    iput-object p5, p0, Lnet/singular/sdk/Collector;->countersLogger:Lnet/singular/sdk/CountersLogger;

    .line 92
    iput-object p6, p0, Lnet/singular/sdk/Collector;->manifestHelper:Lnet/singular/sdk/ManifestHelper;

    .line 93
    iput-object p7, p0, Lnet/singular/sdk/Collector;->facebookAttributionGetter:Lnet/singular/sdk/FacebookAttributionIdGetter;

    .line 94
    iput-boolean p9, p0, Lnet/singular/sdk/Collector;->sandbox:Z

    .line 95
    iput-object p8, p0, Lnet/singular/sdk/Collector;->I:Lnet/singular/sdk/NewInjector;

    .line 96
    return-void
.end method

.method static synthetic access$002(Lnet/singular/sdk/Collector;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lnet/singular/sdk/Collector;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 27
    iput-object p1, p0, Lnet/singular/sdk/Collector;->facebookAttributionId:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$100(Lnet/singular/sdk/Collector;)Lnet/singular/sdk/FacebookAttributionIdGetter;
    .locals 1
    .param p0, "x0"    # Lnet/singular/sdk/Collector;

    .prologue
    .line 27
    iget-object v0, p0, Lnet/singular/sdk/Collector;->facebookAttributionGetter:Lnet/singular/sdk/FacebookAttributionIdGetter;

    return-object v0
.end method

.method static synthetic access$200(Lnet/singular/sdk/Collector;)Lnet/singular/sdk/SingularLog;
    .locals 1
    .param p0, "x0"    # Lnet/singular/sdk/Collector;

    .prologue
    .line 27
    iget-object v0, p0, Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;

    return-object v0
.end method

.method static synthetic access$300(Lnet/singular/sdk/Collector;)V
    .locals 0
    .param p0, "x0"    # Lnet/singular/sdk/Collector;

    .prologue
    .line 27
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->initKeyValueStore()V

    return-void
.end method

.method static synthetic access$400(Lnet/singular/sdk/Collector;)Lnet/singular/sdk/KeyValueStore;
    .locals 1
    .param p0, "x0"    # Lnet/singular/sdk/Collector;

    .prologue
    .line 27
    iget-object v0, p0, Lnet/singular/sdk/Collector;->preferences:Lnet/singular/sdk/KeyValueStore;

    return-object v0
.end method

.method static synthetic access$500(Lnet/singular/sdk/Collector;)Lorg/json/JSONObject;
    .locals 1
    .param p0, "x0"    # Lnet/singular/sdk/Collector;

    .prologue
    .line 27
    iget-object v0, p0, Lnet/singular/sdk/Collector;->temporalIds:Lorg/json/JSONObject;

    return-object v0
.end method

.method static synthetic access$600(Lnet/singular/sdk/Collector;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lnet/singular/sdk/Collector;

    .prologue
    .line 27
    iget-object v0, p0, Lnet/singular/sdk/Collector;->advertisingId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$602(Lnet/singular/sdk/Collector;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lnet/singular/sdk/Collector;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 27
    iput-object p1, p0, Lnet/singular/sdk/Collector;->advertisingId:Ljava/lang/String;

    return-object p1
.end method

.method private addCountersField(Lorg/json/JSONObject;)V
    .locals 2
    .param p1, "res"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 268
    const-string v0, "counters"

    iget-object v1, p0, Lnet/singular/sdk/Collector;->countersLogger:Lnet/singular/sdk/CountersLogger;

    invoke-virtual {v1}, Lnet/singular/sdk/CountersLogger;->getAllCounters()Lorg/json/JSONObject;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 269
    return-void
.end method

.method private addDebugVars(Lorg/json/JSONObject;)V
    .locals 2
    .param p1, "res"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 272
    const-string v0, "debug_vars"

    iget-object v1, p0, Lnet/singular/sdk/Collector;->debug_vars:Lorg/json/JSONObject;

    invoke-virtual {p1, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 273
    return-void
.end method

.method private getAdvertisingIdBackupMethodAndAndroidIdAndMacOnFailure()V
    .locals 2

    .prologue
    .line 530
    new-instance v0, Lnet/singular/sdk/Collector$5;

    invoke-direct {v0, p0}, Lnet/singular/sdk/Collector$5;-><init>(Lnet/singular/sdk/Collector;)V

    .line 541
    .local v0, "setRunnable":Ljava/lang/Runnable;
    const-string v1, "getAdvertisingIdBackupMethodAndAndroidIdAndMacOnFailure"

    invoke-direct {p0, v1, v0}, Lnet/singular/sdk/Collector;->runExternalJob(Ljava/lang/String;Ljava/lang/Runnable;)V

    .line 542
    iget-object v1, p0, Lnet/singular/sdk/Collector;->advertisingId:Ljava/lang/String;

    if-nez v1, :cond_0

    .line 543
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->getAndroidId()V

    .line 544
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->getMacAddress()V

    .line 546
    :cond_0
    return-void
.end method

.method private getAndroidId()V
    .locals 2

    .prologue
    .line 482
    iget-object v0, p0, Lnet/singular/sdk/Collector;->context:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string v1, "android_id"

    invoke-static {v0, v1}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lnet/singular/sdk/Collector;->androidId:Ljava/lang/String;

    .line 483
    return-void
.end method

.method private getAndroidVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 673
    sget-object v0, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    return-object v0
.end method

.method private getApiKey()Ljava/lang/String;
    .locals 5

    .prologue
    .line 459
    iget-object v0, p0, Lnet/singular/sdk/Collector;->manifestHelper:Lnet/singular/sdk/ManifestHelper;

    const-string v1, "net.singular.api_key"

    const-string v2, "apiKey"

    const-string v3, "getApiKey"

    const/4 v4, 0x1

    invoke-virtual {v0, v1, v2, v3, v4}, Lnet/singular/sdk/ManifestHelper;->getManifestAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getAppId()Ljava/lang/String;
    .locals 5

    .prologue
    .line 455
    iget-object v0, p0, Lnet/singular/sdk/Collector;->manifestHelper:Lnet/singular/sdk/ManifestHelper;

    const-string v1, "net.singular.app_id"

    const-string v2, "appId"

    const-string v3, "getAppId"

    const/4 v4, 0x1

    invoke-virtual {v0, v1, v2, v3, v4}, Lnet/singular/sdk/ManifestHelper;->getManifestAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getAppVersionCode()I
    .locals 6

    .prologue
    const/4 v2, -0x1

    .line 643
    :try_start_0
    iget-object v3, p0, Lnet/singular/sdk/Collector;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    iget-object v4, p0, Lnet/singular/sdk/Collector;->context:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    .line 644
    .local v1, "packageInfo":Landroid/content/pm/PackageInfo;
    iget v2, v1, Landroid/content/pm/PackageInfo;->versionCode:I
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_1

    .line 650
    .end local v1    # "packageInfo":Landroid/content/pm/PackageInfo;
    :goto_0
    return v2

    .line 645
    :catch_0
    move-exception v0

    .line 647
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    goto :goto_0

    .line 648
    .end local v0    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :catch_1
    move-exception v0

    .line 649
    .local v0, "e":Ljava/lang/RuntimeException;
    iget-object v3, p0, Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;

    const-string v4, "singular_sdk"

    const-string v5, "getAppVersionCode failed"

    invoke-virtual {v3, v4, v5, v0}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private getAppVersionName()Ljava/lang/String;
    .locals 6

    .prologue
    const/4 v2, 0x0

    .line 628
    :try_start_0
    iget-object v3, p0, Lnet/singular/sdk/Collector;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    iget-object v4, p0, Lnet/singular/sdk/Collector;->context:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    .line 629
    .local v1, "packageInfo":Landroid/content/pm/PackageInfo;
    iget-object v2, v1, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_1

    .line 636
    .end local v1    # "packageInfo":Landroid/content/pm/PackageInfo;
    :goto_0
    return-object v2

    .line 630
    :catch_0
    move-exception v0

    .line 632
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    goto :goto_0

    .line 633
    .end local v0    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :catch_1
    move-exception v0

    .line 634
    .local v0, "e":Ljava/lang/RuntimeException;
    iget-object v3, p0, Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;

    const-string v4, "singular_sdk"

    const-string v5, "getAppVersionName failed"

    invoke-virtual {v3, v4, v5, v0}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private getBrand()Ljava/lang/String;
    .locals 1

    .prologue
    .line 677
    sget-object v0, Landroid/os/Build;->BRAND:Ljava/lang/String;

    return-object v0
.end method

.method private getDefaultCurrency()Ljava/lang/String;
    .locals 6

    .prologue
    .line 471
    iget-object v1, p0, Lnet/singular/sdk/Collector;->manifestHelper:Lnet/singular/sdk/ManifestHelper;

    const-string v2, "net.singular.default_currency"

    const-string v3, "currency"

    const-string v4, "getDefaultCurrency"

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Lnet/singular/sdk/ManifestHelper;->getManifestAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 474
    .local v0, "currency":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 475
    const-string v0, "USD"

    .line 478
    :cond_0
    return-object v0
.end method

.method private getFacebookAttributionId()V
    .locals 2

    .prologue
    .line 123
    new-instance v0, Lnet/singular/sdk/Collector$1;

    invoke-direct {v0, p0}, Lnet/singular/sdk/Collector$1;-><init>(Lnet/singular/sdk/Collector;)V

    .line 130
    .local v0, "setRunnable":Ljava/lang/Runnable;
    const-string v1, "getFacebookAttributionId"

    invoke-direct {p0, v1, v0}, Lnet/singular/sdk/Collector;->runExternalJob(Ljava/lang/String;Ljava/lang/Runnable;)V

    .line 131
    return-void
.end method

.method private getInstallDates()V
    .locals 4
    .annotation build Landroid/annotation/TargetApi;
        value = 0x9
    .end annotation

    .prologue
    .line 580
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x9

    if-lt v1, v2, :cond_0

    .line 582
    :try_start_0
    iget-object v1, p0, Lnet/singular/sdk/Collector;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    iget-object v2, p0, Lnet/singular/sdk/Collector;->context:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    .line 583
    .local v0, "packageInfo":Landroid/content/pm/PackageInfo;
    iget-wide v2, v0, Landroid/content/pm/PackageInfo;->firstInstallTime:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    iput-object v1, p0, Lnet/singular/sdk/Collector;->firstInstallTime:Ljava/lang/Long;

    .line 584
    iget-wide v2, v0, Landroid/content/pm/PackageInfo;->lastUpdateTime:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    iput-object v1, p0, Lnet/singular/sdk/Collector;->lastUpdateTime:Ljava/lang/Long;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 588
    .end local v0    # "packageInfo":Landroid/content/pm/PackageInfo;
    :cond_0
    :goto_0
    return-void

    .line 585
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private getLanguage()Ljava/lang/String;
    .locals 4

    .prologue
    .line 656
    :try_start_0
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v1

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v1, v2}, Ljava/util/Locale;->getDisplayLanguage(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 660
    :goto_0
    return-object v1

    .line 657
    :catch_0
    move-exception v0

    .line 658
    .local v0, "e":Ljava/lang/RuntimeException;
    iget-object v1, p0, Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;

    const-string v2, "singular_sdk"

    const-string v3, "getLanguage failed"

    invoke-virtual {v1, v2, v3, v0}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 660
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private getLastLocation()Landroid/location/Location;
    .locals 12

    .prologue
    .line 722
    iget-object v10, p0, Lnet/singular/sdk/Collector;->context:Landroid/content/Context;

    const-string v11, "location"

    invoke-virtual {v10, v11}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/location/LocationManager;

    .line 724
    .local v5, "locationManager":Landroid/location/LocationManager;
    const/4 v10, 0x1

    invoke-virtual {v5, v10}, Landroid/location/LocationManager;->getProviders(Z)Ljava/util/List;

    move-result-object v6

    .line 726
    .local v6, "matchingProviders":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const-wide/16 v2, -0x1

    .line 727
    .local v2, "bestTime":J
    const/4 v0, 0x0

    .line 728
    .local v0, "bestResult":Landroid/location/Location;
    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    .line 730
    .local v7, "provider":Ljava/lang/String;
    invoke-virtual {v5, v7}, Landroid/location/LocationManager;->getLastKnownLocation(Ljava/lang/String;)Landroid/location/Location;

    move-result-object v4

    .line 731
    .local v4, "location":Landroid/location/Location;
    if-eqz v4, :cond_0

    .line 732
    invoke-virtual {v4}, Landroid/location/Location;->getTime()J

    move-result-wide v8

    .line 734
    .local v8, "time":J
    cmp-long v10, v8, v2

    if-lez v10, :cond_0

    .line 736
    move-object v0, v4

    .line 737
    move-wide v2, v8

    goto :goto_0

    .line 742
    .end local v4    # "location":Landroid/location/Location;
    .end local v7    # "provider":Ljava/lang/String;
    .end local v8    # "time":J
    :cond_1
    return-object v0
.end method

.method private getLocaleCountry()Ljava/lang/String;
    .locals 6

    .prologue
    const/4 v2, 0x0

    .line 378
    :try_start_0
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v0

    .line 379
    .local v0, "country":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 386
    .end local v0    # "country":Ljava/lang/String;
    :goto_0
    return-object v2

    .line 382
    .restart local v0    # "country":Ljava/lang/String;
    :cond_0
    sget-object v3, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v0, v3}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    goto :goto_0

    .line 383
    .end local v0    # "country":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 384
    .local v1, "e":Ljava/lang/RuntimeException;
    iget-object v3, p0, Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;

    const-string v4, "singular_sdk"

    const-string v5, "getLocaleCountry failed"

    invoke-virtual {v3, v4, v5, v1}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private getLocationCountry()Ljava/lang/String;
    .locals 10

    .prologue
    const/4 v9, 0x0

    .line 395
    :try_start_0
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->getLastLocation()Landroid/location/Location;

    move-result-object v8

    .line 396
    .local v8, "location":Landroid/location/Location;
    if-nez v8, :cond_0

    move-object v2, v9

    .line 420
    .end local v8    # "location":Landroid/location/Location;
    :goto_0
    return-object v2

    .line 400
    .restart local v8    # "location":Landroid/location/Location;
    :cond_0
    new-instance v1, Landroid/location/Geocoder;

    iget-object v2, p0, Lnet/singular/sdk/Collector;->context:Landroid/content/Context;

    invoke-direct {v1, v2}, Landroid/location/Geocoder;-><init>(Landroid/content/Context;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_1

    .line 403
    .local v1, "geocoder":Landroid/location/Geocoder;
    :try_start_1
    invoke-virtual {v8}, Landroid/location/Location;->getLatitude()D

    move-result-wide v2

    invoke-virtual {v8}, Landroid/location/Location;->getLongitude()D

    move-result-wide v4

    const/4 v6, 0x1

    invoke-virtual/range {v1 .. v6}, Landroid/location/Geocoder;->getFromLocation(DDI)Ljava/util/List;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v0

    .line 411
    .local v0, "addresses":Ljava/util/List;, "Ljava/util/List<Landroid/location/Address;>;"
    if-eqz v0, :cond_1

    :try_start_2
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    if-nez v2, :cond_2

    .line 412
    :cond_1
    iget-object v2, p0, Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;

    const-string v3, "singular_sdk"

    const-string v4, "Got no addresses for given coordinates"

    invoke-virtual {v2, v3, v4}, Lnet/singular/sdk/SingularLog;->v(Ljava/lang/String;Ljava/lang/String;)V

    move-object v2, v9

    .line 413
    goto :goto_0

    .line 406
    .end local v0    # "addresses":Ljava/util/List;, "Ljava/util/List<Landroid/location/Address;>;"
    :catch_0
    move-exception v7

    .line 407
    .local v7, "e":Ljava/io/IOException;
    iget-object v2, p0, Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;

    const-string v3, "singular_sdk"

    const-string v4, "Could not geocode location"

    invoke-virtual {v2, v3, v4}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;)V

    move-object v2, v9

    .line 408
    goto :goto_0

    .line 416
    .end local v7    # "e":Ljava/io/IOException;
    .restart local v0    # "addresses":Ljava/util/List;, "Ljava/util/List<Landroid/location/Address;>;"
    :cond_2
    const/4 v2, 0x0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/location/Address;

    invoke-virtual {v2}, Landroid/location/Address;->getCountryCode()Ljava/lang/String;

    move-result-object v2

    sget-object v3, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v2, v3}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    :try_end_2
    .catch Ljava/lang/RuntimeException; {:try_start_2 .. :try_end_2} :catch_1

    move-result-object v2

    goto :goto_0

    .line 417
    .end local v0    # "addresses":Ljava/util/List;, "Ljava/util/List<Landroid/location/Address;>;"
    .end local v1    # "geocoder":Landroid/location/Geocoder;
    .end local v8    # "location":Landroid/location/Location;
    :catch_1
    move-exception v7

    .line 418
    .local v7, "e":Ljava/lang/RuntimeException;
    iget-object v2, p0, Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;

    const-string v3, "singular_sdk"

    const-string v4, "getLocationCountry failed"

    invoke-virtual {v2, v3, v4, v7}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v2, v9

    .line 420
    goto :goto_0
.end method

.method private getMacAddress()V
    .locals 6

    .prologue
    .line 487
    :try_start_0
    iget-object v3, p0, Lnet/singular/sdk/Collector;->context:Landroid/content/Context;

    const-string v4, "wifi"

    invoke-virtual {v3, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/net/wifi/WifiManager;

    .line 488
    .local v2, "manager":Landroid/net/wifi/WifiManager;
    invoke-virtual {v2}, Landroid/net/wifi/WifiManager;->getConnectionInfo()Landroid/net/wifi/WifiInfo;

    move-result-object v1

    .line 489
    .local v1, "info":Landroid/net/wifi/WifiInfo;
    invoke-virtual {v1}, Landroid/net/wifi/WifiInfo;->getMacAddress()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lnet/singular/sdk/Collector;->macAddress:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 493
    .end local v1    # "info":Landroid/net/wifi/WifiInfo;
    .end local v2    # "manager":Landroid/net/wifi/WifiManager;
    :goto_0
    return-void

    .line 490
    :catch_0
    move-exception v0

    .line 491
    .local v0, "ignored":Ljava/lang/RuntimeException;
    iget-object v3, p0, Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;

    const-string v4, "singular_sdk"

    const-string v5, "getMacAddress runtime"

    invoke-virtual {v3, v4, v5, v0}, Lnet/singular/sdk/SingularLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private getManufacturer()Ljava/lang/String;
    .locals 1

    .prologue
    .line 669
    sget-object v0, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    return-object v0
.end method

.method private getModel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 665
    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    return-object v0
.end method

.method private getNetworkCountry()Ljava/lang/String;
    .locals 7

    .prologue
    const/4 v3, 0x0

    .line 426
    :try_start_0
    iget-object v4, p0, Lnet/singular/sdk/Collector;->context:Landroid/content/Context;

    const-string v5, "phone"

    invoke-virtual {v4, v5}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/telephony/TelephonyManager;

    .line 427
    .local v2, "tm":Landroid/telephony/TelephonyManager;
    invoke-virtual {v2}, Landroid/telephony/TelephonyManager;->getNetworkCountryIso()Ljava/lang/String;

    move-result-object v0

    .line 428
    .local v0, "countryCode":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 435
    .end local v0    # "countryCode":Ljava/lang/String;
    .end local v2    # "tm":Landroid/telephony/TelephonyManager;
    :goto_0
    return-object v3

    .line 431
    .restart local v0    # "countryCode":Ljava/lang/String;
    .restart local v2    # "tm":Landroid/telephony/TelephonyManager;
    :cond_0
    sget-object v4, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v0, v4}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    goto :goto_0

    .line 432
    .end local v0    # "countryCode":Ljava/lang/String;
    .end local v2    # "tm":Landroid/telephony/TelephonyManager;
    :catch_0
    move-exception v1

    .line 433
    .local v1, "e":Ljava/lang/RuntimeException;
    iget-object v4, p0, Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;

    const-string v5, "singular_sdk"

    const-string v6, "getNetworkCountry failed"

    invoke-virtual {v4, v5, v6, v1}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private getPackageName()Ljava/lang/String;
    .locals 4

    .prologue
    .line 686
    :try_start_0
    iget-object v1, p0, Lnet/singular/sdk/Collector;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 690
    :goto_0
    return-object v1

    .line 687
    :catch_0
    move-exception v0

    .line 688
    .local v0, "e":Ljava/lang/RuntimeException;
    iget-object v1, p0, Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;

    const-string v2, "singular_sdk"

    const-string v3, "getPackageName failed"

    invoke-virtual {v1, v2, v3, v0}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 690
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private getReferralId()V
    .locals 6

    .prologue
    .line 591
    iget-object v3, p0, Lnet/singular/sdk/Collector;->referralIdLock:Ljava/lang/Object;

    monitor-enter v3

    .line 593
    :try_start_0
    iget-object v2, p0, Lnet/singular/sdk/Collector;->referralId:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v2, :cond_0

    .line 594
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 610
    :goto_0
    return-void

    .line 596
    :cond_0
    :try_start_2
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->initKeyValueStore()V
    :try_end_2
    .catch Ljava/lang/RuntimeException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 599
    :try_start_3
    iget-object v2, p0, Lnet/singular/sdk/Collector;->preferences:Lnet/singular/sdk/KeyValueStore;

    const-string v4, "referral_id"

    invoke-virtual {v2, v4}, Lnet/singular/sdk/KeyValueStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 600
    .local v1, "referralId":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 601
    iput-object v1, p0, Lnet/singular/sdk/Collector;->referralId:Ljava/lang/String;
    :try_end_3
    .catch Lnet/singular/sdk/KeyNotFoundException; {:try_start_3 .. :try_end_3} :catch_1
    .catch Ljava/lang/RuntimeException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 609
    .end local v1    # "referralId":Ljava/lang/String;
    :cond_1
    :goto_1
    :try_start_4
    monitor-exit v3

    goto :goto_0

    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    throw v2

    .line 605
    :catch_0
    move-exception v0

    .line 606
    .local v0, "e":Ljava/lang/RuntimeException;
    :try_start_5
    iget-object v2, p0, Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;

    const-string v4, "singular_sdk"

    const-string v5, "getReferralId failed"

    invoke-virtual {v2, v4, v5, v0}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_1

    .line 603
    .end local v0    # "e":Ljava/lang/RuntimeException;
    :catch_1
    move-exception v2

    goto :goto_1
.end method

.method private getSandboxValue()V
    .locals 6

    .prologue
    .line 463
    iget-object v1, p0, Lnet/singular/sdk/Collector;->manifestHelper:Lnet/singular/sdk/ManifestHelper;

    const-string v2, "net.singular.sandbox"

    const-string v3, "sandbox"

    const-string v4, "getSandboxValue"

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Lnet/singular/sdk/ManifestHelper;->getManifestAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 465
    .local v0, "sandbox":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 466
    const-string v1, "true"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lnet/singular/sdk/Collector;->sandbox:Z

    .line 468
    :cond_0
    return-void
.end method

.method private getSdkVersion()I
    .locals 1

    .prologue
    .line 681
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    return v0
.end method

.method private getSimCountry()Ljava/lang/String;
    .locals 7

    .prologue
    const/4 v3, 0x0

    .line 441
    :try_start_0
    iget-object v4, p0, Lnet/singular/sdk/Collector;->context:Landroid/content/Context;

    const-string v5, "phone"

    invoke-virtual {v4, v5}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/telephony/TelephonyManager;

    .line 442
    .local v2, "tm":Landroid/telephony/TelephonyManager;
    invoke-virtual {v2}, Landroid/telephony/TelephonyManager;->getSimCountryIso()Ljava/lang/String;

    move-result-object v0

    .line 443
    .local v0, "countryCode":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 450
    .end local v0    # "countryCode":Ljava/lang/String;
    .end local v2    # "tm":Landroid/telephony/TelephonyManager;
    :goto_0
    return-object v3

    .line 446
    .restart local v0    # "countryCode":Ljava/lang/String;
    .restart local v2    # "tm":Landroid/telephony/TelephonyManager;
    :cond_0
    sget-object v4, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v0, v4}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    goto :goto_0

    .line 447
    .end local v0    # "countryCode":Ljava/lang/String;
    .end local v2    # "tm":Landroid/telephony/TelephonyManager;
    :catch_0
    move-exception v1

    .line 448
    .local v1, "e":Ljava/lang/RuntimeException;
    iget-object v4, p0, Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;

    const-string v5, "singular_sdk"

    const-string v6, "getSimCountry failed"

    invoke-virtual {v4, v5, v6, v1}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private initKeyValueStore()V
    .locals 2

    .prologue
    .line 216
    iget-object v0, p0, Lnet/singular/sdk/Collector;->preferences:Lnet/singular/sdk/KeyValueStore;

    if-nez v0, :cond_0

    .line 217
    iget-object v0, p0, Lnet/singular/sdk/Collector;->I:Lnet/singular/sdk/NewInjector;

    const-string v1, "collector"

    invoke-virtual {v0, v1}, Lnet/singular/sdk/NewInjector;->generateKeyValueStore(Ljava/lang/String;)Lnet/singular/sdk/KeyValueStore;

    move-result-object v0

    iput-object v0, p0, Lnet/singular/sdk/Collector;->preferences:Lnet/singular/sdk/KeyValueStore;

    .line 219
    :cond_0
    return-void
.end method

.method private initSendDelayOptions()V
    .locals 2

    .prologue
    .line 195
    iget-object v0, p0, Lnet/singular/sdk/Collector;->manifestHelper:Lnet/singular/sdk/ManifestHelper;

    const-string v1, "net.singular.first_upload_delay_millis"

    invoke-virtual {v0, v1}, Lnet/singular/sdk/ManifestHelper;->tryToGetManifestAttributeLong(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lnet/singular/sdk/Collector;->firstUploadDelay:Ljava/lang/Long;

    .line 196
    iget-object v0, p0, Lnet/singular/sdk/Collector;->manifestHelper:Lnet/singular/sdk/ManifestHelper;

    const-string v1, "net.singular.normal_upload_delay_millis"

    invoke-virtual {v0, v1}, Lnet/singular/sdk/ManifestHelper;->tryToGetManifestAttributeLong(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lnet/singular/sdk/Collector;->normalUploadDelay:Ljava/lang/Long;

    .line 197
    return-void
.end method

.method private initializeBuildIds()V
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 167
    const/4 v1, -0x1

    iput v1, p0, Lnet/singular/sdk/Collector;->sdkVersion:I

    .line 168
    iput-object v2, p0, Lnet/singular/sdk/Collector;->brand:Ljava/lang/String;

    .line 169
    iput-object v2, p0, Lnet/singular/sdk/Collector;->androidVersion:Ljava/lang/String;

    .line 170
    iput-object v2, p0, Lnet/singular/sdk/Collector;->manufacturer:Ljava/lang/String;

    .line 171
    iput-object v2, p0, Lnet/singular/sdk/Collector;->model:Ljava/lang/String;

    .line 173
    :try_start_0
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->getSdkVersion()I

    move-result v1

    iput v1, p0, Lnet/singular/sdk/Collector;->sdkVersion:I

    .line 174
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->getBrand()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lnet/singular/sdk/Collector;->brand:Ljava/lang/String;

    .line 175
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->getAndroidVersion()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lnet/singular/sdk/Collector;->androidVersion:Ljava/lang/String;

    .line 176
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->getManufacturer()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lnet/singular/sdk/Collector;->manufacturer:Ljava/lang/String;

    .line 177
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->getModel()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lnet/singular/sdk/Collector;->model:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 182
    :goto_0
    return-void

    .line 178
    :catch_0
    move-exception v0

    .line 179
    .local v0, "e":Ljava/lang/RuntimeException;
    iget-object v1, p0, Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;

    const-string v2, "singular_sdk"

    const-string v3, "initializeBuildIds runtime"

    invoke-virtual {v1, v2, v3, v0}, Lnet/singular/sdk/SingularLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private loadTemporalIds()Lorg/json/JSONObject;
    .locals 8

    .prologue
    .line 696
    :try_start_0
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->initKeyValueStore()V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_1

    .line 698
    :try_start_1
    iget-object v5, p0, Lnet/singular/sdk/Collector;->preferences:Lnet/singular/sdk/KeyValueStore;

    const-string v6, "temporal_ids"

    invoke-virtual {v5, v6}, Lnet/singular/sdk/KeyValueStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 699
    .local v4, "temporalIdsJson":Ljava/lang/String;
    new-instance v5, Lorg/json/JSONObject;

    invoke-static {v4}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->init(Ljava/lang/String;)Lorg/json/JSONObject;
    :try_end_1
    .catch Lnet/singular/sdk/KeyNotFoundException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v2

    .line 716
    .end local v4    # "temporalIdsJson":Ljava/lang/String;
    :goto_0
    return-object v2

    .line 701
    :catch_0
    move-exception v3

    .line 702
    .local v3, "ignored":Lorg/json/JSONException;
    :try_start_2
    iget-object v5, p0, Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;

    const-string v6, "singular_sdk"

    const-string v7, "loadTemporalIds: got invalid json!"

    invoke-virtual {v5, v6, v7}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;)V

    .line 706
    .end local v3    # "ignored":Lorg/json/JSONException;
    :goto_1
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V

    .line 709
    .local v2, "emptyTemporalIds":Lorg/json/JSONObject;
    iget-object v6, p0, Lnet/singular/sdk/Collector;->preferences:Lnet/singular/sdk/KeyValueStore;

    const-string v7, "temporal_ids"

    instance-of v5, v2, Lorg/json/JSONObject;

    if-nez v5, :cond_0

    invoke-virtual {v2}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v5

    :goto_2
    invoke-virtual {v6, v7, v5}, Lnet/singular/sdk/KeyValueStore;->put(Ljava/lang/String;Ljava/lang/String;)Z
    :try_end_2
    .catch Ljava/lang/RuntimeException; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_0

    .line 713
    .end local v2    # "emptyTemporalIds":Lorg/json/JSONObject;
    :catch_1
    move-exception v1

    .line 714
    .local v1, "e":Ljava/lang/RuntimeException;
    iget-object v5, p0, Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;

    const-string v6, "singular_sdk"

    const-string v7, "loadTemporalIds failed"

    invoke-virtual {v5, v6, v7, v1}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 716
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V

    goto :goto_0

    .line 709
    .end local v1    # "e":Ljava/lang/RuntimeException;
    .restart local v2    # "emptyTemporalIds":Lorg/json/JSONObject;
    :cond_0
    :try_start_3
    move-object v0, v2

    check-cast v0, Lorg/json/JSONObject;

    move-object v5, v0

    invoke-static {v5}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;)Ljava/lang/String;
    :try_end_3
    .catch Ljava/lang/RuntimeException; {:try_start_3 .. :try_end_3} :catch_1

    move-result-object v5

    goto :goto_2

    .line 700
    .end local v2    # "emptyTemporalIds":Lorg/json/JSONObject;
    :catch_2
    move-exception v5

    goto :goto_1
.end method

.method private runExternalJob(Ljava/lang/String;Ljava/lang/Runnable;)V
    .locals 6
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "setRunnable"    # Ljava/lang/Runnable;

    .prologue
    const/4 v1, 0x0

    .line 134
    new-instance v0, Ljava/util/concurrent/Semaphore;

    invoke-direct {v0, v1}, Ljava/util/concurrent/Semaphore;-><init>(I)V

    .line 136
    .local v0, "waitSem":Ljava/util/concurrent/Semaphore;
    iget-object v1, p0, Lnet/singular/sdk/Collector;->externalJobsWorker:Lnet/singular/sdk/PostableWorker;

    new-instance v2, Lnet/singular/sdk/Collector$2;

    invoke-direct {v2, p0, p2, p1, v0}, Lnet/singular/sdk/Collector$2;-><init>(Lnet/singular/sdk/Collector;Ljava/lang/Runnable;Ljava/lang/String;Ljava/util/concurrent/Semaphore;)V

    invoke-virtual {v1, v2}, Lnet/singular/sdk/PostableWorker;->postNow(Ljava/lang/Runnable;)Z

    .line 153
    const-wide/16 v2, 0x2710

    :try_start_0
    sget-object v1, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v2, v3, v1}, Ljava/util/concurrent/Semaphore;->tryAcquire(JLjava/util/concurrent/TimeUnit;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 154
    iget-object v1, p0, Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;

    const-string v2, "singular_sdk"

    const-string v3, "runExternalJob(%s) timeout"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;)V

    .line 156
    iget-object v1, p0, Lnet/singular/sdk/Collector;->externalJobsWorker:Lnet/singular/sdk/PostableWorker;

    invoke-virtual {v1}, Lnet/singular/sdk/PostableWorker;->interruptThread()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 160
    :cond_0
    :goto_0
    return-void

    .line 159
    :catch_0
    move-exception v1

    goto :goto_0

    .line 158
    :catch_1
    move-exception v1

    goto :goto_0
.end method

.method private saveTemporalIds(Lnet/singular/sdk/PostableWorker;)V
    .locals 1
    .param p1, "saverPostable"    # Lnet/singular/sdk/PostableWorker;

    .prologue
    .line 357
    new-instance v0, Lnet/singular/sdk/Collector$4;

    invoke-direct {v0, p0}, Lnet/singular/sdk/Collector$4;-><init>(Lnet/singular/sdk/Collector;)V

    invoke-virtual {p1, v0}, Lnet/singular/sdk/PostableWorker;->postNow(Ljava/lang/Runnable;)Z

    .line 374
    return-void
.end method

.method private setDebugVar(Ljava/lang/String;Z)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Z

    .prologue
    .line 522
    :try_start_0
    iget-object v0, p0, Lnet/singular/sdk/Collector;->debug_vars:Lorg/json/JSONObject;

    invoke-virtual {v0, p1, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 524
    :goto_0
    return-void

    .line 523
    :catch_0
    move-exception v0

    goto :goto_0
.end method


# virtual methods
.method public clearTemporalIds(Lnet/singular/sdk/PostableWorker;)V
    .locals 1
    .param p1, "saverPostable"    # Lnet/singular/sdk/PostableWorker;

    .prologue
    .line 345
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    iput-object v0, p0, Lnet/singular/sdk/Collector;->temporalIds:Lorg/json/JSONObject;

    .line 347
    invoke-direct {p0, p1}, Lnet/singular/sdk/Collector;->saveTemporalIds(Lnet/singular/sdk/PostableWorker;)V

    .line 348
    return-void
.end method

.method public getAdvertisingId()Ljava/lang/String;
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 496
    const/4 v1, 0x0

    iput-object v1, p0, Lnet/singular/sdk/Collector;->advertisingId:Ljava/lang/String;

    .line 499
    :try_start_0
    iget-object v1, p0, Lnet/singular/sdk/Collector;->adIdHelper:Lnet/singular/sdk/AdvertisingIdHelper;

    invoke-virtual {v1}, Lnet/singular/sdk/AdvertisingIdHelper;->initializeClass()V

    .line 500
    iget-object v1, p0, Lnet/singular/sdk/Collector;->adIdHelper:Lnet/singular/sdk/AdvertisingIdHelper;

    invoke-virtual {v1}, Lnet/singular/sdk/AdvertisingIdHelper;->isLimitAdTrackingEnabled()Z

    move-result v1

    if-nez v1, :cond_0

    .line 501
    const-string v1, "LimitAdTrackingEnabled"

    const/4 v2, 0x0

    invoke-direct {p0, v1, v2}, Lnet/singular/sdk/Collector;->setDebugVar(Ljava/lang/String;Z)V

    .line 502
    iget-object v1, p0, Lnet/singular/sdk/Collector;->adIdHelper:Lnet/singular/sdk/AdvertisingIdHelper;

    invoke-virtual {v1}, Lnet/singular/sdk/AdvertisingIdHelper;->getId()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lnet/singular/sdk/Collector;->advertisingId:Ljava/lang/String;

    .line 506
    :goto_0
    iget-object v1, p0, Lnet/singular/sdk/Collector;->adIdHelper:Lnet/singular/sdk/AdvertisingIdHelper;

    invoke-virtual {v1}, Lnet/singular/sdk/AdvertisingIdHelper;->cleanupClass()V
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 517
    :goto_1
    iget-object v1, p0, Lnet/singular/sdk/Collector;->advertisingId:Ljava/lang/String;

    return-object v1

    .line 504
    :cond_0
    :try_start_1
    const-string v1, "LimitAdTrackingEnabled"

    const/4 v2, 0x1

    invoke-direct {p0, v1, v2}, Lnet/singular/sdk/Collector;->setDebugVar(Ljava/lang/String;Z)V
    :try_end_1
    .catch Ljava/lang/ClassNotFoundException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 507
    :catch_0
    move-exception v0

    .line 508
    .local v0, "e":Ljava/lang/ClassNotFoundException;
    const-string v1, "NoPlayServices"

    invoke-direct {p0, v1, v3}, Lnet/singular/sdk/Collector;->setDebugVar(Ljava/lang/String;Z)V

    .line 509
    iget-object v1, p0, Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;

    const-string v2, "singular_sdk"

    const-string v3, "Google Play Services SDK not found!"

    invoke-virtual {v1, v2, v3}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 510
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->getAdvertisingIdBackupMethodAndAndroidIdAndMacOnFailure()V

    goto :goto_1

    .line 511
    .end local v0    # "e":Ljava/lang/ClassNotFoundException;
    :catch_1
    move-exception v0

    .line 512
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "GAIDInvocationError"

    invoke-direct {p0, v1, v3}, Lnet/singular/sdk/Collector;->setDebugVar(Ljava/lang/String;Z)V

    .line 513
    iget-object v1, p0, Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;

    const-string v2, "singular_sdk"

    const-string v3, "Encountered an error connecting to Google Play Services"

    invoke-virtual {v1, v2, v3, v0}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 515
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->getAdvertisingIdBackupMethodAndAndroidIdAndMacOnFailure()V

    goto :goto_1
.end method

.method public getCarrierName()Ljava/lang/String;
    .locals 5

    .prologue
    .line 615
    :try_start_0
    iget-object v2, p0, Lnet/singular/sdk/Collector;->context:Landroid/content/Context;

    const-string v3, "phone"

    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/telephony/TelephonyManager;

    .line 617
    .local v1, "manager":Landroid/telephony/TelephonyManager;
    invoke-virtual {v1}, Landroid/telephony/TelephonyManager;->getNetworkOperatorName()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 621
    .end local v1    # "manager":Landroid/telephony/TelephonyManager;
    :goto_0
    return-object v2

    .line 618
    :catch_0
    move-exception v0

    .line 619
    .local v0, "e":Ljava/lang/RuntimeException;
    iget-object v2, p0, Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;

    const-string v3, "singular_sdk"

    const-string v4, "getCarrierName failed"

    invoke-virtual {v2, v3, v4, v0}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 621
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public getCurrency()Ljava/lang/String;
    .locals 1

    .prologue
    .line 276
    iget-object v0, p0, Lnet/singular/sdk/Collector;->currency:Ljava/lang/String;

    return-object v0
.end method

.method public getFirstUploadDelay()J
    .locals 2

    .prologue
    .line 208
    iget-object v0, p0, Lnet/singular/sdk/Collector;->firstUploadDelay:Ljava/lang/Long;

    if-nez v0, :cond_0

    .line 209
    const-wide/16 v0, 0xbb8

    .line 211
    :goto_0
    return-wide v0

    :cond_0
    iget-object v0, p0, Lnet/singular/sdk/Collector;->firstUploadDelay:Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    goto :goto_0
.end method

.method public getNormalUploadDelay()J
    .locals 2

    .prologue
    .line 200
    iget-object v0, p0, Lnet/singular/sdk/Collector;->normalUploadDelay:Ljava/lang/Long;

    if-nez v0, :cond_0

    .line 201
    const-wide/16 v0, 0x7530

    .line 203
    :goto_0
    return-wide v0

    :cond_0
    iget-object v0, p0, Lnet/singular/sdk/Collector;->normalUploadDelay:Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    goto :goto_0
.end method

.method public getPersistentIdCountersAndDebugVars()Lorg/json/JSONObject;
    .locals 5

    .prologue
    .line 222
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 225
    .local v1, "res":Lorg/json/JSONObject;
    :try_start_0
    const-string v2, "singular_sdk_version"

    const/4 v3, 0x7

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 227
    const-string v2, "app_id"

    iget-object v3, p0, Lnet/singular/sdk/Collector;->appId:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 228
    const-string v2, "sandbox"

    iget-boolean v3, p0, Lnet/singular/sdk/Collector;->sandbox:Z

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 229
    const-string v2, "api_key"

    iget-object v3, p0, Lnet/singular/sdk/Collector;->apiKey:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 230
    const-string v2, "package_name"

    iget-object v3, p0, Lnet/singular/sdk/Collector;->packageName:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 231
    const-string v2, "sdk_version"

    iget v3, p0, Lnet/singular/sdk/Collector;->sdkVersion:I

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 232
    const-string v2, "android_version"

    iget-object v3, p0, Lnet/singular/sdk/Collector;->androidVersion:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 233
    const-string v2, "brand"

    iget-object v3, p0, Lnet/singular/sdk/Collector;->brand:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 234
    const-string v2, "manufacturer"

    iget-object v3, p0, Lnet/singular/sdk/Collector;->manufacturer:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 235
    const-string v2, "model"

    iget-object v3, p0, Lnet/singular/sdk/Collector;->model:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 236
    const-string v2, "language"

    iget-object v3, p0, Lnet/singular/sdk/Collector;->language:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 237
    const-string v2, "carrier_name"

    iget-object v3, p0, Lnet/singular/sdk/Collector;->carrierName:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 238
    const-string v2, "app_version_code"

    iget v3, p0, Lnet/singular/sdk/Collector;->appVersionCode:I

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 239
    const-string v2, "app_version_name"

    iget-object v3, p0, Lnet/singular/sdk/Collector;->appVersionName:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 240
    const-string v2, "singular_id"

    iget-object v3, p0, Lnet/singular/sdk/Collector;->singularId:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 241
    const-string v2, "referral_id"

    iget-object v3, p0, Lnet/singular/sdk/Collector;->referralId:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 243
    const-string v2, "locale_country"

    iget-object v3, p0, Lnet/singular/sdk/Collector;->localeCountry:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 244
    const-string v2, "sim_country"

    iget-object v3, p0, Lnet/singular/sdk/Collector;->simCountry:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 245
    const-string v2, "network_country"

    iget-object v3, p0, Lnet/singular/sdk/Collector;->networkCountry:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 246
    const-string v2, "location_country"

    iget-object v3, p0, Lnet/singular/sdk/Collector;->locationCountry:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 249
    const-string v2, "android_id"

    iget-object v3, p0, Lnet/singular/sdk/Collector;->androidId:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 250
    const-string v2, "mac_address"

    iget-object v3, p0, Lnet/singular/sdk/Collector;->macAddress:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 251
    const-string v2, "google_advertising_id"

    iget-object v3, p0, Lnet/singular/sdk/Collector;->advertisingId:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 252
    const-string v2, "facebook_attribution_id"

    iget-object v3, p0, Lnet/singular/sdk/Collector;->facebookAttributionId:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 254
    const-string v2, "first_install_time"

    iget-object v3, p0, Lnet/singular/sdk/Collector;->firstInstallTime:Ljava/lang/Long;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 255
    const-string v2, "last_install_time"

    iget-object v3, p0, Lnet/singular/sdk/Collector;->lastUpdateTime:Ljava/lang/Long;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 257
    invoke-direct {p0, v1}, Lnet/singular/sdk/Collector;->addCountersField(Lorg/json/JSONObject;)V

    .line 258
    invoke-direct {p0, v1}, Lnet/singular/sdk/Collector;->addDebugVars(Lorg/json/JSONObject;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 264
    .end local v1    # "res":Lorg/json/JSONObject;
    :goto_0
    return-object v1

    .line 260
    .restart local v1    # "res":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 262
    .local v0, "e":Lorg/json/JSONException;
    iget-object v2, p0, Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;

    const-string v3, "singular_sdk"

    const-string v4, "JSONException in getPersistentIds. Should never happen"

    invoke-virtual {v2, v3, v4}, Lnet/singular/sdk/SingularLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 264
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getSingularId()Ljava/lang/String;
    .locals 7

    .prologue
    const/4 v3, 0x0

    .line 550
    :try_start_0
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->initKeyValueStore()V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_1

    .line 553
    :try_start_1
    iget-object v4, p0, Lnet/singular/sdk/Collector;->preferences:Lnet/singular/sdk/KeyValueStore;

    const-string v5, "singular_id"

    invoke-virtual {v4, v5}, Lnet/singular/sdk/KeyValueStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 554
    .local v0, "deviceId":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    :try_end_1
    .catch Lnet/singular/sdk/KeyNotFoundException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_1

    move-result v4

    if-nez v4, :cond_0

    .line 574
    .end local v0    # "deviceId":Ljava/lang/String;
    :goto_0
    return-object v0

    .line 557
    :catch_0
    move-exception v4

    .line 562
    :cond_0
    const/4 v4, 0x1

    :try_start_2
    iput-boolean v4, p0, Lnet/singular/sdk/Collector;->isFirstOpen:Z

    .line 564
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v2

    .line 565
    .local v2, "newSingularId":Ljava/lang/String;
    iget-object v4, p0, Lnet/singular/sdk/Collector;->preferences:Lnet/singular/sdk/KeyValueStore;

    const-string v5, "singular_id"

    invoke-virtual {v4, v5, v2}, Lnet/singular/sdk/KeyValueStore;->put(Ljava/lang/String;Ljava/lang/String;)Z
    :try_end_2
    .catch Ljava/lang/RuntimeException; {:try_start_2 .. :try_end_2} :catch_1

    move-result v4

    if-nez v4, :cond_1

    move-object v0, v3

    .line 567
    goto :goto_0

    :cond_1
    move-object v0, v2

    .line 570
    goto :goto_0

    .line 571
    .end local v2    # "newSingularId":Ljava/lang/String;
    :catch_1
    move-exception v1

    .line 572
    .local v1, "e":Ljava/lang/RuntimeException;
    iget-object v4, p0, Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;

    const-string v5, "singular_sdk"

    const-string v6, "getSingularId failed"

    invoke-virtual {v4, v5, v6, v1}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v0, v3

    .line 574
    goto :goto_0
.end method

.method public getTemporalIds()Lorg/json/JSONObject;
    .locals 3

    .prologue
    .line 289
    iget-object v1, p0, Lnet/singular/sdk/Collector;->temporalIds:Lorg/json/JSONObject;

    if-eqz v1, :cond_1

    .line 290
    iget-object v0, p0, Lnet/singular/sdk/Collector;->temporalIds:Lorg/json/JSONObject;

    .line 295
    .local v0, "ret":Lorg/json/JSONObject;
    :goto_0
    iget-object v1, p0, Lnet/singular/sdk/Collector;->sessionManager:Lnet/singular/sdk/SessionManager;

    if-eqz v1, :cond_0

    .line 297
    :try_start_0
    const-string v1, "session_id"

    iget-object v2, p0, Lnet/singular/sdk/Collector;->sessionManager:Lnet/singular/sdk/SessionManager;

    invoke-virtual {v2}, Lnet/singular/sdk/SessionManager;->getSessionId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 300
    :cond_0
    :goto_1
    return-object v0

    .line 292
    .end local v0    # "ret":Lorg/json/JSONObject;
    :cond_1
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .restart local v0    # "ret":Lorg/json/JSONObject;
    goto :goto_0

    .line 298
    :catch_0
    move-exception v1

    goto :goto_1
.end method

.method public initializeIds()V
    .locals 1

    .prologue
    .line 100
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->getPackageName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lnet/singular/sdk/Collector;->packageName:Ljava/lang/String;

    .line 102
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->initializeBuildIds()V

    .line 104
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->getLanguage()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lnet/singular/sdk/Collector;->language:Ljava/lang/String;

    .line 105
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->getAppVersionCode()I

    move-result v0

    iput v0, p0, Lnet/singular/sdk/Collector;->appVersionCode:I

    .line 106
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->getAppVersionName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lnet/singular/sdk/Collector;->appVersionName:Ljava/lang/String;

    .line 107
    invoke-virtual {p0}, Lnet/singular/sdk/Collector;->getCarrierName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lnet/singular/sdk/Collector;->carrierName:Ljava/lang/String;

    .line 108
    invoke-virtual {p0}, Lnet/singular/sdk/Collector;->getSingularId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lnet/singular/sdk/Collector;->singularId:Ljava/lang/String;

    .line 109
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->getInstallDates()V

    .line 110
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->getReferralId()V

    .line 111
    invoke-virtual {p0}, Lnet/singular/sdk/Collector;->getAdvertisingId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lnet/singular/sdk/Collector;->advertisingId:Ljava/lang/String;

    .line 113
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->getSimCountry()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lnet/singular/sdk/Collector;->simCountry:Ljava/lang/String;

    .line 114
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->getNetworkCountry()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lnet/singular/sdk/Collector;->networkCountry:Ljava/lang/String;

    .line 115
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->getLocationCountry()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lnet/singular/sdk/Collector;->locationCountry:Ljava/lang/String;

    .line 116
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->getLocaleCountry()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lnet/singular/sdk/Collector;->localeCountry:Ljava/lang/String;

    .line 117
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->getFacebookAttributionId()V

    .line 119
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->loadTemporalIds()Lorg/json/JSONObject;

    move-result-object v0

    iput-object v0, p0, Lnet/singular/sdk/Collector;->temporalIds:Lorg/json/JSONObject;

    .line 120
    return-void
.end method

.method public initializeMandatoryManifestIds()Z
    .locals 1

    .prologue
    .line 186
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->getAppId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lnet/singular/sdk/Collector;->appId:Ljava/lang/String;

    .line 187
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->getApiKey()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lnet/singular/sdk/Collector;->apiKey:Ljava/lang/String;

    .line 188
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->getDefaultCurrency()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lnet/singular/sdk/Collector;->currency:Ljava/lang/String;

    .line 189
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->getSandboxValue()V

    .line 190
    invoke-direct {p0}, Lnet/singular/sdk/Collector;->initSendDelayOptions()V

    .line 191
    iget-object v0, p0, Lnet/singular/sdk/Collector;->appId:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lnet/singular/sdk/Collector;->apiKey:Ljava/lang/String;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isFirstOpen()Z
    .locals 1

    .prologue
    .line 163
    iget-boolean v0, p0, Lnet/singular/sdk/Collector;->isFirstOpen:Z

    return v0
.end method

.method public setCurrency(Ljava/lang/String;)V
    .locals 0
    .param p1, "currency"    # Ljava/lang/String;

    .prologue
    .line 280
    iput-object p1, p0, Lnet/singular/sdk/Collector;->currency:Ljava/lang/String;

    .line 281
    return-void
.end method

.method public setReferralId(Ljava/lang/String;Lnet/singular/sdk/PostableWorker;)V
    .locals 2
    .param p1, "referralId"    # Ljava/lang/String;
    .param p2, "saverPostable"    # Lnet/singular/sdk/PostableWorker;

    .prologue
    .line 323
    iget-object v1, p0, Lnet/singular/sdk/Collector;->referralIdLock:Ljava/lang/Object;

    monitor-enter v1

    .line 324
    :try_start_0
    iput-object p1, p0, Lnet/singular/sdk/Collector;->referralId:Ljava/lang/String;

    .line 325
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 326
    new-instance v0, Lnet/singular/sdk/Collector$3;

    invoke-direct {v0, p0, p1}, Lnet/singular/sdk/Collector$3;-><init>(Lnet/singular/sdk/Collector;Ljava/lang/String;)V

    invoke-virtual {p2, v0}, Lnet/singular/sdk/PostableWorker;->postNow(Ljava/lang/Runnable;)Z

    .line 342
    return-void

    .line 325
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public setTemporalId(Ljava/lang/String;Ljava/lang/Object;Lnet/singular/sdk/PostableWorker;)Z
    .locals 4
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;
    .param p3, "saverPostable"    # Lnet/singular/sdk/PostableWorker;

    .prologue
    .line 313
    :try_start_0
    iget-object v1, p0, Lnet/singular/sdk/Collector;->temporalIds:Lorg/json/JSONObject;

    invoke-virtual {v1, p1, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 314
    invoke-direct {p0, p3}, Lnet/singular/sdk/Collector;->saveTemporalIds(Lnet/singular/sdk/PostableWorker;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 315
    const/4 v1, 0x1

    .line 318
    :goto_0
    return v1

    .line 316
    :catch_0
    move-exception v0

    .line 317
    .local v0, "e":Lorg/json/JSONException;
    iget-object v1, p0, Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;

    const-string v2, "singular_sdk"

    const-string v3, "Invalid JSON in setTemporalId"

    invoke-virtual {v1, v2, v3, v0}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 318
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public unsetTemporalId(Ljava/lang/String;Lnet/singular/sdk/PostableWorker;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "saverPostable"    # Lnet/singular/sdk/PostableWorker;

    .prologue
    .line 351
    iget-object v0, p0, Lnet/singular/sdk/Collector;->temporalIds:Lorg/json/JSONObject;

    invoke-virtual {v0, p1}, Lorg/json/JSONObject;->remove(Ljava/lang/String;)Ljava/lang/Object;

    .line 353
    invoke-direct {p0, p2}, Lnet/singular/sdk/Collector;->saveTemporalIds(Lnet/singular/sdk/PostableWorker;)V

    .line 354
    return-void
.end method
