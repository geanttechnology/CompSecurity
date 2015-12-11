.class public final Lcom/amazon/identity/auth/device/metrics/SSOMetrics;
.super Ljava/lang/Object;
.source "SSOMetrics.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/metrics/SSOMetrics$SetAccountPropertiesFailureReason;,
        Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;,
        Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;,
        Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountProperties;
    }
.end annotation


# static fields
.field public static final NUMBER_AMAZON_ACCOUNTS:Ljava/lang/String; = "com.amazon.dcp.sso.numAmazonAccounts"

.field public static final TAG:Ljava/lang/String;

.field private static sCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

.field private static sContext:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const-class v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 177
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 178
    return-void
.end method

.method public static couldnotFindSubAuth()V
    .locals 2

    .prologue
    .line 373
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 375
    const-string/jumbo v0, "NoSubAuthFound"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 376
    return-void
.end method

.method public static deregistrationRequestFailure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)V
    .locals 4
    .param p0, "error"    # Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    .prologue
    .line 212
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 214
    const-string/jumbo v1, "DeregistrationFailure"

    const/4 v0, 0x1

    new-array v2, v0, [Ljava/lang/String;

    const/4 v3, 0x0

    if-eqz p0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->getName()Ljava/lang/String;

    move-result-object v0

    :goto_0
    aput-object v0, v2, v3

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 216
    return-void

    .line 214
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->getName()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static deregistrationRequestFailure(Ljava/lang/String;)V
    .locals 3
    .param p0, "error"    # Ljava/lang/String;

    .prologue
    .line 220
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 222
    const-string/jumbo v0, "DeregistrationFailure"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    aput-object p0, v1, v2

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 223
    return-void
.end method

.method public static deregistrationSubAuthFailure(Ljava/lang/String;)V
    .locals 3
    .param p0, "packageName"    # Ljava/lang/String;

    .prologue
    .line 227
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 229
    const-string/jumbo v0, "DeregistrationFailure"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    aput-object p0, v1, v2

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 230
    return-void
.end method

.method public static deregistrationSuccess()V
    .locals 2

    .prologue
    .line 205
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 207
    const-string/jumbo v0, "DeregistrationSuccess"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 208
    return-void
.end method

.method private static declared-synchronized doInit()V
    .locals 2

    .prologue
    .line 187
    const-class v1, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->sContext:Landroid/content/Context;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->sCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_1

    .line 193
    :cond_0
    :goto_0
    monitor-exit v1

    return-void

    .line 192
    :cond_1
    :try_start_1
    sget-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->sContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/platform/metric/MetricsHelper;->getMetricsCollectorInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->sCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 187
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private static formatExtraDataForMetrics(ILjava/lang/String;)Ljava/util/Map;
    .locals 3
    .param p0, "size"    # I
    .param p1, "packageName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 437
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 438
    .local v0, "extras":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v1, "size"

    invoke-static {p0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 439
    const-string/jumbo v1, "app"

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 440
    invoke-static {p0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 442
    return-object v0
.end method

.method public static getAuthTokenFailure(Ljava/lang/String;Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;)V
    .locals 4
    .param p0, "packageName"    # Ljava/lang/String;
    .param p1, "reason"    # Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    .prologue
    .line 262
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 264
    const-string/jumbo v0, "GetAuthTokenFailure"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    aput-object p0, v1, v2

    const/4 v2, 0x1

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->getName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 265
    return-void
.end method

.method public static getAuthTokenFailure(Ljava/lang/String;Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;)V
    .locals 4
    .param p0, "packageName"    # Ljava/lang/String;
    .param p1, "reason"    # Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;

    .prologue
    .line 255
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 257
    const-string/jumbo v0, "GetAuthTokenFailure"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    aput-object p0, v1, v2

    const/4 v2, 0x1

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;->getName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 258
    return-void
.end method

.method public static getAuthTokenSuccess(Ljava/lang/String;)V
    .locals 3
    .param p0, "packageName"    # Ljava/lang/String;

    .prologue
    .line 248
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 250
    const-string/jumbo v0, "GetAuthTokenSuccess"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    aput-object p0, v1, v2

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 251
    return-void
.end method

.method public static getAuthTokenSuccessTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .locals 2
    .param p0, "packageName"    # Ljava/lang/String;

    .prologue
    .line 276
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 278
    sget-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->sCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    const-string/jumbo v1, "GetAuthTokenSuccessTime"

    invoke-static {v0, v1, p0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->getInstance(Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    return-object v0
.end method

.method public static getAuthTokenTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .locals 2
    .param p0, "packageName"    # Ljava/lang/String;

    .prologue
    .line 269
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 271
    sget-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->sCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    const-string/jumbo v1, "GetAuthTokenTime"

    invoke-static {v0, v1, p0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->getInstance(Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    return-object v0
.end method

.method public static getDeregistrationSubAuthTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .locals 2
    .param p0, "packageName"    # Ljava/lang/String;

    .prologue
    .line 241
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 243
    sget-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->sCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    const-string/jumbo v1, "DeregistrationSubAuthTime"

    invoke-static {v0, v1, p0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->getInstance(Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    return-object v0
.end method

.method public static getDeregistrationTimer()Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .locals 3

    .prologue
    .line 234
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 236
    sget-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->sCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    const-string/jumbo v1, "DeregistrationTime"

    const-string/jumbo v2, "TotalDeregistrationTime"

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->getInstance(Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    return-object v0
.end method

.method public static getKeyPairSelfGenerationTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .locals 2
    .param p0, "algo"    # Ljava/lang/String;

    .prologue
    .line 430
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 432
    sget-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->sCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    const-string/jumbo v1, "KeyPairSelfGeneration"

    invoke-static {v0, v1, p0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->getInstance(Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    return-object v0
.end method

.method private static varargs incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V
    .locals 2
    .param p0, "metricName"    # Ljava/lang/String;
    .param p1, "extras"    # [Ljava/lang/String;

    .prologue
    .line 447
    sget-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->sCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    if-nez v0, :cond_0

    .line 453
    :goto_0
    return-void

    .line 452
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->sCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    const-string/jumbo v1, "GenericMetrics_SSO"

    invoke-interface {v0, v1, p0, p1}, Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;->incrementMetricCounter(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    goto :goto_0
.end method

.method private static incrementStateMetricCounter(Ljava/lang/String;Ljava/util/Map;)V
    .locals 2
    .param p0, "metricName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 457
    .local p1, "extras":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    sget-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->sCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    if-nez v0, :cond_0

    .line 463
    :goto_0
    return-void

    .line 462
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->sCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    const-string/jumbo v1, "GenericMetrics_SSO"

    invoke-interface {v0, v1, p0, p1}, Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;->incrementStateMetricCounter(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_0
.end method

.method public static init(Landroid/content/Context;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 182
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->sContext:Landroid/content/Context;

    .line 183
    return-void
.end method

.method public static recordCorPfmRequestFailure(Ljava/lang/String;)V
    .locals 3
    .param p0, "reason"    # Ljava/lang/String;

    .prologue
    .line 423
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 425
    const-string/jumbo v0, "GetCorPfmRequest"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    aput-object p0, v1, v2

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 426
    return-void
.end method

.method public static recordExchangeTokenRequestSize(ILjava/lang/String;)V
    .locals 2
    .param p0, "size"    # I
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 380
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 382
    invoke-static {p0, p1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->formatExtraDataForMetrics(ILjava/lang/String;)Ljava/util/Map;

    move-result-object v0

    .line 383
    .local v0, "extras":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v1, "SSOExchangeRequest"

    invoke-static {v1, v0}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->incrementStateMetricCounter(Ljava/lang/String;Ljava/util/Map;)V

    .line 384
    return-void
.end method

.method public static recordExchangeTokenResponseSize(ILjava/lang/String;)V
    .locals 2
    .param p0, "size"    # I
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 388
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 390
    invoke-static {p0, p1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->formatExtraDataForMetrics(ILjava/lang/String;)Ljava/util/Map;

    move-result-object v0

    .line 391
    .local v0, "extras":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v1, "SSOExchangeResponse"

    invoke-static {v1, v0}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->incrementStateMetricCounter(Ljava/lang/String;Ljava/util/Map;)V

    .line 392
    return-void
.end method

.method public static recordUpdateCredentialsRequestSize(ILjava/lang/String;)V
    .locals 2
    .param p0, "size"    # I
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 396
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 398
    invoke-static {p0, p1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->formatExtraDataForMetrics(ILjava/lang/String;)Ljava/util/Map;

    move-result-object v0

    .line 399
    .local v0, "extras":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v1, "SSOUpdateCredentialsRequest"

    invoke-static {v1, v0}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->incrementStateMetricCounter(Ljava/lang/String;Ljava/util/Map;)V

    .line 400
    return-void
.end method

.method public static recordUpdateCredentialsResponseSize(ILjava/lang/String;)V
    .locals 2
    .param p0, "size"    # I
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 404
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 406
    invoke-static {p0, p1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->formatExtraDataForMetrics(ILjava/lang/String;)Ljava/util/Map;

    move-result-object v0

    .line 407
    .local v0, "extras":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v1, "SSOUpdateCredentialsResponse"

    invoke-static {v1, v0}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->incrementStateMetricCounter(Ljava/lang/String;Ljava/util/Map;)V

    .line 408
    return-void
.end method

.method public static recordWebViewLoadFailure(Ljava/lang/String;I)V
    .locals 5
    .param p0, "url"    # Ljava/lang/String;
    .param p1, "errorCode"    # I

    .prologue
    .line 342
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 344
    const-string/jumbo v0, "WebViewLoadFailure"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "Path:"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {p0}, Lcom/amazon/identity/platform/metric/MetricUtils;->getAuthPortalUrlType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 347
    return-void
.end method

.method public static recordWebViewLoadFailureSSL(Ljava/lang/String;I)V
    .locals 5
    .param p0, "url"    # Ljava/lang/String;
    .param p1, "errorCode"    # I

    .prologue
    .line 351
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 353
    const-string/jumbo v0, "WebViewLoadFailure"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "SSLError:"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {p0}, Lcom/amazon/identity/platform/metric/MetricUtils;->getAuthPortalUrlType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "SSLError:"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 355
    return-void
.end method

.method public static registrationBadSecret(Lcom/amazon/identity/auth/device/api/RegistrationType;)V
    .locals 5
    .param p0, "registrationType"    # Lcom/amazon/identity/auth/device/api/RegistrationType;

    .prologue
    .line 197
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 199
    const-string/jumbo v0, "RegistrationFailure"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/RegistrationType;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v4, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_SECRET:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 201
    return-void
.end method

.method private static renameDeviceErrorCodeToErrorMessage(I)Ljava/lang/String;
    .locals 1
    .param p0, "renameDeviceErrorCode"    # I

    .prologue
    .line 482
    packed-switch p0, :pswitch_data_0

    .line 499
    const-string/jumbo v0, "Unrecognized"

    :goto_0
    return-object v0

    .line 485
    :pswitch_0
    const-string/jumbo v0, "NetworkFailure"

    goto :goto_0

    .line 487
    :pswitch_1
    const-string/jumbo v0, "AuthenticationFailed"

    goto :goto_0

    .line 489
    :pswitch_2
    const-string/jumbo v0, "InvalidInput"

    goto :goto_0

    .line 491
    :pswitch_3
    const-string/jumbo v0, "ParseError"

    goto :goto_0

    .line 493
    :pswitch_4
    const-string/jumbo v0, "NameAlreadyUsed"

    goto :goto_0

    .line 495
    :pswitch_5
    const-string/jumbo v0, "NoAmazonAccount"

    goto :goto_0

    .line 482
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch
.end method

.method public static renameDeviceFailure(I)V
    .locals 4
    .param p0, "renameDeviceErrorCode"    # I

    .prologue
    .line 333
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 335
    const-string/jumbo v0, "SetAccountPropertiesFailure"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    sget-object v3, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountProperties;->DeviceName:Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountProperties;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountProperties;->getName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    invoke-static {p0}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->renameDeviceErrorCodeToErrorMessage(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 338
    return-void
.end method

.method public static renameDeviceRequestFailure(I)V
    .locals 4
    .param p0, "renameDeviceErrorCode"    # I

    .prologue
    .line 474
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 476
    const-string/jumbo v0, "RenameDeviceRequestFailure"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    invoke-static {p0}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->renameDeviceErrorCodeToErrorMessage(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 478
    return-void
.end method

.method public static renameDeviceRequestSuccess()V
    .locals 2

    .prologue
    .line 467
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 469
    const-string/jumbo v0, "RenameDeviceRequestSuccess"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 470
    return-void
.end method

.method public static setAccountPropertiesFailure(Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountProperties;Lcom/amazon/identity/auth/device/metrics/SSOMetrics$SetAccountPropertiesFailureReason;)V
    .locals 4
    .param p0, "accountProperty"    # Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountProperties;
    .param p1, "reason"    # Lcom/amazon/identity/auth/device/metrics/SSOMetrics$SetAccountPropertiesFailureReason;

    .prologue
    .line 326
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 328
    const-string/jumbo v0, "SetAccountPropertiesFailure"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountProperties;->getName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$SetAccountPropertiesFailureReason;->getName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 329
    return-void
.end method

.method public static setAccountPropertiesSuccess(Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountProperties;)V
    .locals 4
    .param p0, "accountProperty"    # Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountProperties;

    .prologue
    .line 318
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 320
    const-string/jumbo v0, "SetAccountPropertiesSuccess"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountProperties;->getName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 321
    return-void
.end method

.method public static setAccountPropertiesTimer(Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountProperties;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .locals 3
    .param p0, "accountProperty"    # Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountProperties;

    .prologue
    .line 359
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 361
    sget-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->sCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    const-string/jumbo v1, "SetAccountPropertiesTime"

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountProperties;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->getInstance(Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    return-object v0
.end method

.method public static signatureCheckFailure()V
    .locals 2

    .prologue
    .line 366
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 368
    const-string/jumbo v0, "SignatureCheckFailure"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 369
    return-void
.end method

.method public static stateChanged(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p0, "key"    # Ljava/lang/String;
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 412
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 414
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 415
    .local v0, "extras":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v1, "key"

    invoke-interface {v0, v1, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 416
    const-string/jumbo v1, "value"

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 418
    const-string/jumbo v1, "StateChange"

    invoke-static {v1, v0}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->incrementStateMetricCounter(Ljava/lang/String;Ljava/util/Map;)V

    .line 419
    return-void
.end method

.method public static updateCredentialsFailure(Ljava/lang/String;Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;)V
    .locals 4
    .param p0, "packageName"    # Ljava/lang/String;
    .param p1, "reason"    # Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;

    .prologue
    .line 297
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 299
    const-string/jumbo v0, "UpdateCredentialsFailure"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    aput-object p0, v1, v2

    const/4 v2, 0x1

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure;->getName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 300
    return-void
.end method

.method public static updateCredentialsFailure(Ljava/lang/String;Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;)V
    .locals 4
    .param p0, "packageName"    # Ljava/lang/String;
    .param p1, "reason"    # Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;

    .prologue
    .line 290
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 292
    const-string/jumbo v0, "UpdateCredentialsFailure"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    aput-object p0, v1, v2

    const/4 v2, 0x1

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason;->getName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 293
    return-void
.end method

.method public static updateCredentialsSuccess(Ljava/lang/String;)V
    .locals 3
    .param p0, "packageName"    # Ljava/lang/String;

    .prologue
    .line 283
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 285
    const-string/jumbo v0, "UpdateCredentialsSuccess"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    aput-object p0, v1, v2

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->incrementMetricCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 286
    return-void
.end method

.method public static updateCredentialsSuccessTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .locals 2
    .param p0, "packageName"    # Ljava/lang/String;

    .prologue
    .line 311
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 313
    sget-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->sCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    const-string/jumbo v1, "UpdateCredentialsSuccessTime"

    invoke-static {v0, v1, p0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->getInstance(Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    return-object v0
.end method

.method public static updateCredentialsTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .locals 2
    .param p0, "packageName"    # Ljava/lang/String;

    .prologue
    .line 304
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->doInit()V

    .line 306
    sget-object v0, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->sCollector:Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;

    const-string/jumbo v1, "UpdateCredentialsTime"

    invoke-static {v0, v1, p0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->getInstance(Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    return-object v0
.end method
