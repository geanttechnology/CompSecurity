.class public abstract Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;
.super Ljava/lang/Object;
.source "BaseAbstractDCMLogger.java"


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "DefaultLocale"
    }
.end annotation


# static fields
.field private static final INVALID_ANDROID_ID:Ljava/lang/String; = "9774d56d682e549c"

.field private static final MAX_STACK_TRACE_SIZE:I = 0x4000

.field private static final NETWORK_EXCEPTIONS:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Class",
            "<*>;>;"
        }
    .end annotation
.end field

.field protected static final TAG:Ljava/lang/String;

.field private static final UTF8_ENCODING:Ljava/lang/String; = "UTF-8"

.field protected static final log:Lcom/amazon/retailsearch/log/MessageLogger;


# instance fields
.field protected final appVersion:Ljava/lang/String;

.field protected config:Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;

.field protected context:Landroid/content/Context;

.field protected metricsFactory:Lcom/amazon/client/metrics/MetricsFactory;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 69
    const-class v0, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;

    invoke-static {v0}, Lcom/amazon/retailsearch/log/AppLog;->getLog(Ljava/lang/Class;)Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    .line 71
    const-class v0, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->TAG:Ljava/lang/String;

    .line 78
    const/16 v0, 0x8

    new-array v0, v0, [Ljava/lang/Class;

    const/4 v1, 0x0

    const-class v2, Ljava/io/EOFException;

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-class v2, Ljava/net/SocketException;

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-class v2, Ljava/io/InterruptedIOException;

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-class v2, Ljava/net/UnknownHostException;

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-class v2, Ljavax/net/ssl/SSLException;

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-class v2, Lorg/apache/http/client/ClientProtocolException;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-class v2, Lorg/apache/http/MalformedChunkCodingException;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-class v2, Lorg/apache/http/NoHttpResponseException;

    aput-object v2, v0, v1

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->NETWORK_EXCEPTIONS:Ljava/util/List;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "config"    # Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;

    .prologue
    .line 95
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 96
    iput-object p1, p0, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->context:Landroid/content/Context;

    .line 97
    iput-object p2, p0, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->config:Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;

    .line 98
    invoke-static {}, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;->getInstance()Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;->getSettings()Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;

    move-result-object v0

    .line 99
    .local v0, "settings":Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;->getAppVersion()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 101
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/16 v2, 0x2d

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;->getAppVersion()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->appVersion:Ljava/lang/String;

    .line 107
    :goto_0
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->init(Landroid/content/Context;)V

    .line 108
    return-void

    .line 105
    :cond_0
    const-string/jumbo v1, "Unknown"

    iput-object v1, p0, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->appVersion:Ljava/lang/String;

    goto :goto_0
.end method

.method private addDeviceInfo(Lcom/amazon/client/metrics/MetricEvent;)V
    .locals 8
    .param p1, "event"    # Lcom/amazon/client/metrics/MetricEvent;

    .prologue
    .line 326
    :try_start_0
    sget-object v6, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 328
    sget-object v6, Lcom/amazon/retailsearch/metrics/StringName;->DeviceModel:Lcom/amazon/retailsearch/metrics/StringName;

    invoke-virtual {v6}, Lcom/amazon/retailsearch/metrics/StringName;->name()Ljava/lang/String;

    move-result-object v6

    sget-object v7, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-interface {p1, v6, v7}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V

    .line 331
    :cond_0
    sget-object v6, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 333
    sget-object v6, Lcom/amazon/retailsearch/metrics/StringName;->OsVersion:Lcom/amazon/retailsearch/metrics/StringName;

    invoke-virtual {v6}, Lcom/amazon/retailsearch/metrics/StringName;->name()Ljava/lang/String;

    move-result-object v6

    sget-object v7, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-interface {p1, v6, v7}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V

    .line 336
    :cond_1
    sget-object v6, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_2

    .line 338
    sget-object v6, Lcom/amazon/retailsearch/metrics/StringName;->Manufacturer:Lcom/amazon/retailsearch/metrics/StringName;

    invoke-virtual {v6}, Lcom/amazon/retailsearch/metrics/StringName;->name()Ljava/lang/String;

    move-result-object v6

    sget-object v7, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    invoke-interface {p1, v6, v7}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V

    .line 341
    :cond_2
    sget-object v6, Landroid/os/Build;->PRODUCT:Ljava/lang/String;

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_3

    .line 343
    sget-object v6, Lcom/amazon/retailsearch/metrics/StringName;->BuildProduct:Lcom/amazon/retailsearch/metrics/StringName;

    invoke-virtual {v6}, Lcom/amazon/retailsearch/metrics/StringName;->name()Ljava/lang/String;

    move-result-object v6

    sget-object v7, Landroid/os/Build;->PRODUCT:Ljava/lang/String;

    invoke-interface {p1, v6, v7}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V

    .line 346
    :cond_3
    sget-object v6, Landroid/os/Build;->FINGERPRINT:Ljava/lang/String;

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_4

    .line 348
    sget-object v6, Lcom/amazon/retailsearch/metrics/StringName;->BuildFingerprint:Lcom/amazon/retailsearch/metrics/StringName;

    invoke-virtual {v6}, Lcom/amazon/retailsearch/metrics/StringName;->name()Ljava/lang/String;

    move-result-object v6

    sget-object v7, Landroid/os/Build;->FINGERPRINT:Ljava/lang/String;

    invoke-interface {p1, v6, v7}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V

    .line 351
    :cond_4
    invoke-static {}, Lcom/amazon/retailsearch/deviceinfo/DeviceProfile;->getSerial()Ljava/lang/String;

    move-result-object v3

    .line 353
    .local v3, "serial":Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_5

    .line 355
    sget-object v6, Lcom/amazon/retailsearch/metrics/StringName;->SerialNumber:Lcom/amazon/retailsearch/metrics/StringName;

    invoke-virtual {v6}, Lcom/amazon/retailsearch/metrics/StringName;->name()Ljava/lang/String;

    move-result-object v6

    invoke-interface {p1, v6, v3}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V

    .line 358
    :cond_5
    iget-object v6, p0, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->context:Landroid/content/Context;

    invoke-virtual {v6}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/retailsearch/deviceinfo/DeviceProfile;->getAndroidId(Landroid/content/ContentResolver;)Ljava/lang/String;

    move-result-object v0

    .line 360
    .local v0, "androidId":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_6

    const-string/jumbo v6, "9774d56d682e549c"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_6

    .line 362
    sget-object v6, Lcom/amazon/retailsearch/metrics/StringName;->AndroidId:Lcom/amazon/retailsearch/metrics/StringName;

    invoke-virtual {v6}, Lcom/amazon/retailsearch/metrics/StringName;->name()Ljava/lang/String;

    move-result-object v6

    invoke-interface {p1, v6, v0}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_1

    .line 367
    :cond_6
    :try_start_1
    iget-object v6, p0, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->context:Landroid/content/Context;

    invoke-static {v6}, Lcom/amazon/retailsearch/deviceinfo/DeviceProfile;->getTelephonyDeviceId(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v5

    .line 369
    .local v5, "telId":Ljava/lang/String;
    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_7

    .line 371
    sget-object v6, Lcom/amazon/retailsearch/metrics/StringName;->TelephonyDeviceId:Lcom/amazon/retailsearch/metrics/StringName;

    invoke-virtual {v6}, Lcom/amazon/retailsearch/metrics/StringName;->name()Ljava/lang/String;

    move-result-object v6

    invoke-interface {p1, v6, v5}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V

    .line 374
    :cond_7
    iget-object v6, p0, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->context:Landroid/content/Context;

    invoke-static {v6}, Lcom/amazon/retailsearch/deviceinfo/DeviceProfile;->getNetworkOperatorName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    .line 376
    .local v2, "networkName":Ljava/lang/String;
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_8

    .line 378
    sget-object v6, Lcom/amazon/retailsearch/metrics/StringName;->NetworkName:Lcom/amazon/retailsearch/metrics/StringName;

    invoke-virtual {v6}, Lcom/amazon/retailsearch/metrics/StringName;->name()Ljava/lang/String;

    move-result-object v6

    invoke-interface {p1, v6, v2}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_1

    .line 396
    .end local v0    # "androidId":Ljava/lang/String;
    .end local v2    # "networkName":Ljava/lang/String;
    .end local v3    # "serial":Ljava/lang/String;
    .end local v5    # "telId":Ljava/lang/String;
    :cond_8
    :goto_0
    return-void

    .line 381
    .restart local v0    # "androidId":Ljava/lang/String;
    .restart local v3    # "serial":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 383
    .local v1, "e":Ljava/lang/Exception;
    :try_start_2
    invoke-static {}, Lcom/amazon/retailsearch/android/api/init/DebugMode;->enabled()Z

    move-result v6

    if-eqz v6, :cond_8

    .line 385
    sget-object v6, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "Telephony info error"

    invoke-static {v6, v7, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_0

    .line 389
    .end local v0    # "androidId":Ljava/lang/String;
    .end local v1    # "e":Ljava/lang/Exception;
    .end local v3    # "serial":Ljava/lang/String;
    :catch_1
    move-exception v4

    .line 391
    .local v4, "t":Ljava/lang/Throwable;
    invoke-static {}, Lcom/amazon/retailsearch/android/api/init/DebugMode;->enabled()Z

    move-result v6

    if-eqz v6, :cond_8

    .line 393
    sget-object v6, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "Error"

    invoke-static {v6, v7, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method private addExceptionInfo(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/Throwable;)V
    .locals 6
    .param p1, "event"    # Lcom/amazon/client/metrics/MetricEvent;
    .param p2, "throwable"    # Ljava/lang/Throwable;

    .prologue
    const/16 v5, 0x4000

    .line 261
    if-nez p2, :cond_1

    .line 299
    :cond_0
    :goto_0
    return-void

    .line 266
    :cond_1
    :try_start_0
    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v1

    .line 268
    .local v1, "name":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 270
    sget-object v4, Lcom/amazon/retailsearch/metrics/StringName;->ExceptionName:Lcom/amazon/retailsearch/metrics/StringName;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/metrics/StringName;->name()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v4, v1}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V

    .line 273
    :cond_2
    invoke-virtual {p2}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v0

    .line 275
    .local v0, "exceptionMsg":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_3

    .line 277
    sget-object v4, Lcom/amazon/retailsearch/metrics/StringName;->ExceptionMessage:Lcom/amazon/retailsearch/metrics/StringName;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/metrics/StringName;->name()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v4, v0}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V

    .line 280
    :cond_3
    invoke-direct {p0, p2}, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->getStackTraceAsString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v3

    .line 282
    .local v3, "trace":Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 284
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v4

    if-le v4, v5, :cond_4

    .line 286
    const/4 v4, 0x0

    const/16 v5, 0x4000

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    .line 289
    :cond_4
    sget-object v4, Lcom/amazon/retailsearch/metrics/StringName;->StackTrace:Lcom/amazon/retailsearch/metrics/StringName;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/metrics/StringName;->name()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v4, v3}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 292
    .end local v0    # "exceptionMsg":Ljava/lang/String;
    .end local v1    # "name":Ljava/lang/String;
    .end local v3    # "trace":Ljava/lang/String;
    :catch_0
    move-exception v2

    .line 294
    .local v2, "t":Ljava/lang/Throwable;
    invoke-static {}, Lcom/amazon/retailsearch/android/api/init/DebugMode;->enabled()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 296
    sget-object v4, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Error"

    invoke-static {v4, v5, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method private getStackTraceAsString(Ljava/lang/Throwable;)Ljava/lang/String;
    .locals 2
    .param p1, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 309
    if-nez p1, :cond_0

    .line 311
    const-string/jumbo v1, ""

    .line 316
    :goto_0
    return-object v1

    .line 314
    :cond_0
    new-instance v0, Ljava/io/StringWriter;

    invoke-direct {v0}, Ljava/io/StringWriter;-><init>()V

    .line 315
    .local v0, "stringWriter":Ljava/io/StringWriter;
    new-instance v1, Ljava/io/PrintWriter;

    invoke-direct {v1, v0}, Ljava/io/PrintWriter;-><init>(Ljava/io/Writer;)V

    invoke-virtual {p1, v1}, Ljava/lang/Throwable;->printStackTrace(Ljava/io/PrintWriter;)V

    .line 316
    invoke-virtual {v0}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method private init(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 120
    :try_start_0
    const-string/jumbo v1, "com.amazon.dp.metrics.MetricsFactory"

    invoke-virtual {p1, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/client/metrics/MetricsFactory;

    iput-object v1, p0, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->metricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    .line 121
    iget-object v1, p0, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->metricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    if-nez v1, :cond_0

    .line 124
    invoke-static {p1}, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;->getInstance(Landroid/content/Context;)Lcom/amazon/client/metrics/MetricsFactory;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->metricsFactory:Lcom/amazon/client/metrics/MetricsFactory;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 136
    :cond_0
    :goto_0
    return-void

    .line 126
    :catch_0
    move-exception v0

    .line 130
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Lcom/amazon/client/metrics/NullMetricsFactory;

    invoke-direct {v1}, Lcom/amazon/client/metrics/NullMetricsFactory;-><init>()V

    iput-object v1, p0, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->metricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    .line 131
    invoke-static {}, Lcom/amazon/retailsearch/android/api/init/DebugMode;->enabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 133
    sget-object v1, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not instantiate DCM metrics logger"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method private toLines(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)Ljava/lang/String;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 515
    .local p1, "collection":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    if-nez p1, :cond_0

    .line 517
    const/4 v5, 0x0

    .line 535
    :goto_0
    return-object v5

    .line 520
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 522
    .local v0, "buf":Ljava/lang/StringBuilder;
    invoke-virtual {p1}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->entrySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 524
    .local v1, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    if-eqz v5, :cond_1

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    if-eqz v5, :cond_1

    .line 529
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 531
    .local v4, "val":Ljava/lang/String;
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, ": "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const/16 v6, 0xa

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 535
    .end local v1    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v4    # "val":Ljava/lang/String;
    :cond_2
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    goto :goto_0
.end method

.method private toQueryString(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)Ljava/lang/String;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/UnsupportedEncodingException;
        }
    .end annotation

    .prologue
    .line 477
    .local p1, "collection":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    if-nez p1, :cond_0

    .line 479
    const/4 v5, 0x0

    .line 507
    :goto_0
    return-object v5

    .line 482
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 484
    .local v0, "buf":Ljava/lang/StringBuilder;
    invoke-virtual {p1}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->entrySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_4

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 486
    .local v1, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    if-eqz v5, :cond_1

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    if-eqz v5, :cond_1

    .line 491
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 493
    .local v4, "val":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->length()I

    move-result v5

    if-lez v5, :cond_3

    .line 495
    const/16 v5, 0x26

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 498
    :cond_3
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    const-string/jumbo v6, "UTF-8"

    invoke-static {v5, v6}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 500
    if-eqz v4, :cond_2

    .line 502
    const/16 v5, 0x3d

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, "UTF-8"

    invoke-static {v4, v6}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 507
    .end local v1    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v4    # "val":Ljava/lang/String;
    :cond_4
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    goto :goto_0
.end method


# virtual methods
.method protected addAppVersionInfo(Lcom/amazon/client/metrics/MetricEvent;)V
    .locals 2
    .param p1, "event"    # Lcom/amazon/client/metrics/MetricEvent;

    .prologue
    .line 220
    if-eqz p1, :cond_0

    .line 221
    sget-object v0, Lcom/amazon/retailsearch/metrics/MetricName;->MarketAppVersion:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->appVersion:Ljava/lang/String;

    invoke-interface {p1, v0, v1}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V

    .line 223
    :cond_0
    return-void
.end method

.method protected addEventInfo(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 3
    .param p1, "event"    # Lcom/amazon/client/metrics/MetricEvent;
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 236
    :try_start_0
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 238
    sget-object v1, Lcom/amazon/retailsearch/metrics/StringName;->Message:Lcom/amazon/retailsearch/metrics/StringName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/StringName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v1, p2}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V

    .line 241
    :cond_0
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->addDeviceInfo(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 243
    invoke-direct {p0, p1, p3}, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->addExceptionInfo(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/Throwable;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 252
    :cond_1
    :goto_0
    return-void

    .line 245
    :catch_0
    move-exception v0

    .line 247
    .local v0, "t":Ljava/lang/Throwable;
    invoke-static {}, Lcom/amazon/retailsearch/android/api/init/DebugMode;->enabled()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 249
    sget-object v1, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Error"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method protected addServiceCallInfo(Lcom/amazon/client/metrics/MetricEvent;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;)V
    .locals 11
    .param p1, "event"    # Lcom/amazon/client/metrics/MetricEvent;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/client/metrics/MetricEvent;",
            "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 408
    .local p2, "serviceCall":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<*>;"
    if-nez p2, :cond_1

    .line 470
    :cond_0
    :goto_0
    return-void

    .line 413
    :cond_1
    :try_start_0
    invoke-virtual {p2}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->getMethod()Ljava/lang/String;

    move-result-object v3

    .line 415
    .local v3, "method":Ljava/lang/String;
    if-eqz v3, :cond_2

    .line 417
    sget-object v9, Lcom/amazon/retailsearch/metrics/StringName;->RequestMethod:Lcom/amazon/retailsearch/metrics/StringName;

    invoke-virtual {v9}, Lcom/amazon/retailsearch/metrics/StringName;->name()Ljava/lang/String;

    move-result-object v9

    invoke-interface {p1, v9, v3}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V

    .line 420
    :cond_2
    invoke-virtual {p2}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->getRequestUrl()Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;

    move-result-object v7

    .line 422
    .local v7, "url":Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;
    if-eqz v7, :cond_3

    .line 424
    invoke-virtual {v7}, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->build()Ljava/lang/String;

    move-result-object v8

    .line 426
    .local v8, "urlStr":Ljava/lang/String;
    if-eqz v8, :cond_3

    .line 428
    sget-object v9, Lcom/amazon/retailsearch/metrics/StringName;->RequestUrl:Lcom/amazon/retailsearch/metrics/StringName;

    invoke-virtual {v9}, Lcom/amazon/retailsearch/metrics/StringName;->name()Ljava/lang/String;

    move-result-object v9

    invoke-interface {p1, v9, v8}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V

    .line 432
    .end local v8    # "urlStr":Ljava/lang/String;
    :cond_3
    invoke-virtual {p2}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->getParameters()Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    move-result-object v5

    .line 434
    .local v5, "params":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz v5, :cond_5

    .line 436
    invoke-direct {p0, v5}, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->toQueryString(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)Ljava/lang/String;

    move-result-object v4

    .line 438
    .local v4, "paramStr":Ljava/lang/String;
    if-eqz v4, :cond_4

    .line 440
    sget-object v9, Lcom/amazon/retailsearch/metrics/StringName;->RequestParameters:Lcom/amazon/retailsearch/metrics/StringName;

    invoke-virtual {v9}, Lcom/amazon/retailsearch/metrics/StringName;->name()Ljava/lang/String;

    move-result-object v9

    invoke-interface {p1, v9, v4}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V

    .line 443
    :cond_4
    sget-object v9, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->CLIENT_REQUEST_ID:Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;

    invoke-virtual {v9}, Lcom/amazon/searchapp/retailsearch/client/SearchParameterName;->getName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v5, v9}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 445
    .local v0, "clientRequestId":Ljava/lang/String;
    if-eqz v0, :cond_5

    .line 447
    sget-object v9, Lcom/amazon/retailsearch/metrics/StringName;->ClientRequestId:Lcom/amazon/retailsearch/metrics/StringName;

    invoke-virtual {v9}, Lcom/amazon/retailsearch/metrics/StringName;->name()Ljava/lang/String;

    move-result-object v9

    invoke-interface {p1, v9, v0}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V

    .line 451
    .end local v0    # "clientRequestId":Ljava/lang/String;
    .end local v4    # "paramStr":Ljava/lang/String;
    :cond_5
    invoke-virtual {p2}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->getHeaders()Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    move-result-object v2

    .line 453
    .local v2, "headers":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz v2, :cond_0

    .line 455
    invoke-direct {p0, v2}, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->toLines(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)Ljava/lang/String;

    move-result-object v1

    .line 457
    .local v1, "headerStr":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 459
    sget-object v9, Lcom/amazon/retailsearch/metrics/StringName;->RequestHeaders:Lcom/amazon/retailsearch/metrics/StringName;

    invoke-virtual {v9}, Lcom/amazon/retailsearch/metrics/StringName;->name()Ljava/lang/String;

    move-result-object v9

    invoke-interface {p1, v9, v1}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 463
    .end local v1    # "headerStr":Ljava/lang/String;
    .end local v2    # "headers":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v3    # "method":Ljava/lang/String;
    .end local v5    # "params":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v7    # "url":Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;
    :catch_0
    move-exception v6

    .line 465
    .local v6, "t":Ljava/lang/Throwable;
    invoke-static {}, Lcom/amazon/retailsearch/android/api/init/DebugMode;->enabled()Z

    move-result v9

    if-eqz v9, :cond_0

    .line 467
    sget-object v9, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->TAG:Ljava/lang/String;

    const-string/jumbo v10, "Error"

    invoke-static {v9, v10, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method protected getConcurrentMetricEvent(Ljava/lang/String;Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;
    .locals 3
    .param p1, "validatedProgramName"    # Ljava/lang/String;
    .param p2, "source"    # Lcom/amazon/retailsearch/metrics/SourceName;

    .prologue
    .line 166
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    if-nez p2, :cond_1

    .line 168
    :cond_0
    const/4 v0, 0x0

    .line 173
    :goto_0
    return-object v0

    .line 170
    :cond_1
    iget-object v1, p0, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->metricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    invoke-virtual {p2}, Lcom/amazon/retailsearch/metrics/SourceName;->name()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, p1, v2}, Lcom/amazon/client/metrics/MetricsFactory;->createConcurrentMetricEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    .line 172
    .local v0, "event":Lcom/amazon/client/metrics/MetricEvent;
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->addAppVersionInfo(Lcom/amazon/client/metrics/MetricEvent;)V

    goto :goto_0
.end method

.method protected getErrorMetric(Ljava/lang/Throwable;)Ljava/lang/String;
    .locals 3
    .param p1, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 192
    if-nez p1, :cond_0

    .line 194
    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->Error:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v2

    .line 210
    :goto_0
    return-object v2

    .line 197
    :cond_0
    instance-of v2, p1, Lcom/fasterxml/jackson/core/JsonProcessingException;

    if-eqz v2, :cond_1

    .line 199
    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->JsonError:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 202
    :cond_1
    sget-object v2, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->NETWORK_EXCEPTIONS:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Class;

    .line 204
    .local v0, "cls":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v0, p1}, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 206
    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->NetworkError:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 210
    .end local v0    # "cls":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_3
    sget-object v2, Lcom/amazon/retailsearch/metrics/MetricName;->Error:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method

.method protected getMetricEvent(Ljava/lang/String;Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;
    .locals 3
    .param p1, "validatedProgramName"    # Ljava/lang/String;
    .param p2, "source"    # Lcom/amazon/retailsearch/metrics/SourceName;

    .prologue
    .line 147
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    if-nez p2, :cond_1

    .line 149
    :cond_0
    const/4 v0, 0x0

    .line 154
    :goto_0
    return-object v0

    .line 151
    :cond_1
    iget-object v1, p0, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->metricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    invoke-virtual {p2}, Lcom/amazon/retailsearch/metrics/SourceName;->name()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, p1, v2}, Lcom/amazon/client/metrics/MetricsFactory;->createMetricEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    .line 153
    .local v0, "event":Lcom/amazon/client/metrics/MetricEvent;
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->addAppVersionInfo(Lcom/amazon/client/metrics/MetricEvent;)V

    goto :goto_0
.end method

.method protected recordCounter(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;I)V
    .locals 2
    .param p1, "metricEvent"    # Lcom/amazon/client/metrics/MetricEvent;
    .param p2, "metricName"    # Ljava/lang/String;
    .param p3, "count"    # I

    .prologue
    .line 178
    if-eqz p1, :cond_0

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 185
    :cond_0
    :goto_0
    return-void

    .line 182
    :cond_1
    int-to-double v0, p3

    invoke-interface {p1, p2, v0, v1}, Lcom/amazon/client/metrics/MetricEvent;->addCounter(Ljava/lang/String;D)V

    .line 183
    invoke-static {p1}, Lcom/amazon/retailsearch/debug/RetailSearchDebug;->logMetricEvent(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 184
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->metricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    invoke-interface {v0, p1}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    goto :goto_0
.end method
