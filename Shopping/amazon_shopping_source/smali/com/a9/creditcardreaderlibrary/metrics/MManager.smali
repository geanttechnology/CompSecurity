.class public Lcom/a9/creditcardreaderlibrary/metrics/MManager;
.super Ljava/lang/Object;
.source "MManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/a9/creditcardreaderlibrary/metrics/MManager$1;,
        Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadListener;,
        Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadTask;
    }
.end annotation


# static fields
.field private static s_appVersion:Ljava/lang/String;

.field private static s_context:Landroid/content/Context;

.field private static s_countersMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private static s_deviceId:Ljava/lang/String;

.field private static s_isDryRun:Z

.field private static s_marketPlace:Ljava/lang/String;

.field private static s_serviceName:Ljava/lang/String;

.field private static s_sessionEnd:J

.field private static s_sessionStart:J

.field private static s_timingsMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Double;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 37
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_countersMap:Ljava/util/HashMap;

    .line 38
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_timingsMap:Ljava/util/HashMap;

    .line 42
    const-string/jumbo v0, "1"

    sput-object v0, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_marketPlace:Ljava/lang/String;

    .line 45
    const/4 v0, 0x0

    sput-boolean v0, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_isDryRun:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 326
    return-void
.end method

.method static synthetic access$100(Lorg/apache/http/HttpResponse;Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadListener;)V
    .locals 0
    .param p0, "x0"    # Lorg/apache/http/HttpResponse;
    .param p1, "x1"    # Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadListener;

    .prologue
    .line 35
    invoke-static {p0, p1}, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->onHttpResponseReceived(Lorg/apache/http/HttpResponse;Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadListener;)V

    return-void
.end method

.method private static clearMaps()V
    .locals 1

    .prologue
    .line 318
    sget-object v0, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_timingsMap:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 319
    sget-object v0, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_countersMap:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 320
    return-void
.end method

.method private static getBaseJSONObject()Lorg/json/JSONObject;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 191
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 192
    .local v0, "jsonObject":Lorg/json/JSONObject;
    const-string/jumbo v2, "DEVICE_ID"

    sget-object v3, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_deviceId:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 193
    const-string/jumbo v2, "MODEL"

    sget-object v3, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 194
    const-string/jumbo v2, "PLATFORM_VERSION"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 195
    const-string/jumbo v2, "PLATFORM"

    const-string/jumbo v3, "Android"

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 196
    const-string/jumbo v2, "Marketplace"

    sget-object v3, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_marketPlace:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 197
    const-string/jumbo v2, "APP_VERSION"

    sget-object v3, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_appVersion:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 198
    const-string/jumbo v2, "Program"

    sget-object v3, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_serviceName:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 199
    const-string/jumbo v2, "TIMESTAMP"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    invoke-virtual {v0, v2, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 201
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 202
    .local v1, "operationBuilder":Ljava/lang/StringBuilder;
    sget-object v2, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_serviceName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_appVersion:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "MetricsProd"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "Android"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 203
    const-string/jumbo v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 204
    sget-object v2, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_context:Landroid/content/Context;

    invoke-static {v2}, Lcom/a9/creditcardreaderlibrary/helpers/ScreenSizeHelper;->isTabletDevice(Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 205
    const-string/jumbo v2, "Tablet"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 210
    :goto_0
    const-string/jumbo v2, "Operation"

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 211
    const-string/jumbo v2, "Locale"

    invoke-static {}, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->getLocale()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 212
    return-object v0

    .line 207
    :cond_0
    const-string/jumbo v2, "Phone"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0
.end method

.method private static getLocale()Ljava/lang/String;
    .locals 3

    .prologue
    .line 221
    :try_start_0
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v1

    .line 222
    .local v1, "locale":Ljava/util/Locale;
    invoke-virtual {v1}, Ljava/util/Locale;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 226
    :goto_0
    return-object v2

    .line 223
    :catch_0
    move-exception v0

    .line 224
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 226
    const-string/jumbo v2, ""

    goto :goto_0
.end method

.method private static declared-synchronized getSessionLength()D
    .locals 6

    .prologue
    .line 96
    const-class v1, Lcom/a9/creditcardreaderlibrary/metrics/MManager;

    monitor-enter v1

    :try_start_0
    sget-wide v2, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_sessionEnd:J

    sget-wide v4, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_sessionStart:J

    sub-long/2addr v2, v4

    const-wide/16 v4, 0x3e8

    div-long/2addr v2, v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    long-to-double v2, v2

    monitor-exit v1

    return-wide v2

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static init(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "deviceId"    # Ljava/lang/String;
    .param p2, "applicationName"    # Ljava/lang/String;
    .param p3, "marketPlace"    # Ljava/lang/String;

    .prologue
    .line 54
    sput-object p1, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_deviceId:Ljava/lang/String;

    .line 55
    sput-object p2, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_serviceName:Ljava/lang/String;

    .line 56
    const/4 v1, 0x0

    .line 57
    .local v1, "packageInfo":Landroid/content/pm/PackageInfo;
    sput-object p0, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_context:Landroid/content/Context;

    .line 60
    :try_start_0
    sget-object v2, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_context:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    sget-object v3, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    .line 61
    iget-object v2, v1, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    sput-object v2, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_appVersion:Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 67
    :goto_0
    if-eqz p3, :cond_0

    .line 68
    sput-object p3, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_marketPlace:Ljava/lang/String;

    .line 70
    :cond_0
    return-void

    .line 63
    :catch_0
    move-exception v0

    .line 64
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v0}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_0
.end method

.method private static onHttpResponseReceived(Lorg/apache/http/HttpResponse;Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadListener;)V
    .locals 3
    .param p0, "result"    # Lorg/apache/http/HttpResponse;
    .param p1, "metricUploadListener"    # Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadListener;

    .prologue
    .line 283
    if-eqz p0, :cond_2

    .line 285
    invoke-interface {p0}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v0

    .line 286
    .local v0, "statusLine":Lorg/apache/http/StatusLine;
    invoke-interface {v0}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v1

    const/16 v2, 0xc8

    if-ne v1, v2, :cond_1

    .line 288
    invoke-static {}, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->clearMaps()V

    .line 290
    if-eqz p1, :cond_0

    .line 291
    invoke-interface {p1}, Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadListener;->onSuccess()V

    .line 300
    .end local v0    # "statusLine":Lorg/apache/http/StatusLine;
    :cond_0
    :goto_0
    return-void

    .line 295
    .restart local v0    # "statusLine":Lorg/apache/http/StatusLine;
    :cond_1
    invoke-interface {v0}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v1

    invoke-interface {v0}, Lorg/apache/http/StatusLine;->getReasonPhrase()Ljava/lang/String;

    move-result-object v2

    invoke-static {p1, v1, v2}, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->reportError(Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadListener;ILjava/lang/String;)V

    goto :goto_0

    .line 298
    .end local v0    # "statusLine":Lorg/apache/http/StatusLine;
    :cond_2
    const/4 v1, -0x1

    const-string/jumbo v2, "No Network Connectivity"

    invoke-static {p1, v1, v2}, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->reportError(Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadListener;ILjava/lang/String;)V

    goto :goto_0
.end method

.method private static reportError(Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadListener;ILjava/lang/String;)V
    .locals 2
    .param p0, "metricUploadListener"    # Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadListener;
    .param p1, "errorCode"    # I
    .param p2, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 303
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 304
    .local v0, "errorMessageBuilder":Ljava/lang/StringBuilder;
    const-string/jumbo v1, "Error Code: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 305
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 306
    const-string/jumbo v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 307
    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 309
    if-eqz p0, :cond_0

    .line 310
    invoke-virtual {p2}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p0, v1}, Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadListener;->onError(Ljava/lang/String;)V

    .line 312
    :cond_0
    return-void
.end method

.method public static final declared-synchronized sendMetrics(Ljava/lang/String;Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadListener;)V
    .locals 8
    .param p0, "sessionId"    # Ljava/lang/String;
    .param p1, "metricUploadListener"    # Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadListener;

    .prologue
    .line 153
    const-class v5, Lcom/a9/creditcardreaderlibrary/metrics/MManager;

    monitor-enter v5

    :try_start_0
    sget-boolean v4, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_isDryRun:Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v4, :cond_0

    .line 172
    :goto_0
    monitor-exit v5

    return-void

    .line 156
    :cond_0
    :try_start_1
    invoke-static {}, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->getSessionLength()D

    move-result-wide v2

    .line 157
    .local v2, "sessionLengthInSecs":D
    const-wide/16 v6, 0x0

    cmpl-double v4, v2, v6

    if-lez v4, :cond_1

    .line 158
    const-string/jumbo v4, "CreditCard.camera.session.length"

    invoke-static {v4, v2, v3}, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->setTimingMetric(Ljava/lang/String;D)V

    .line 161
    :cond_1
    invoke-static {}, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->getBaseJSONObject()Lorg/json/JSONObject;

    move-result-object v1

    .line 162
    .local v1, "jsonObject":Lorg/json/JSONObject;
    const-string/jumbo v4, "SESSION_ID"

    invoke-virtual {v1, v4, p0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 163
    const-string/jumbo v4, "counters"

    new-instance v6, Lorg/json/JSONObject;

    sget-object v7, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_countersMap:Ljava/util/HashMap;

    invoke-direct {v6, v7}, Lorg/json/JSONObject;-><init>(Ljava/util/Map;)V

    invoke-virtual {v1, v4, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 164
    const-string/jumbo v4, "timing"

    new-instance v6, Lorg/json/JSONObject;

    sget-object v7, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_timingsMap:Ljava/util/HashMap;

    invoke-direct {v6, v7}, Lorg/json/JSONObject;-><init>(Ljava/util/Map;)V

    invoke-virtual {v1, v4, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 166
    new-instance v4, Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadTask;

    const/4 v6, 0x0

    invoke-direct {v4, v6}, Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadTask;-><init>(Lcom/a9/creditcardreaderlibrary/metrics/MManager$1;)V

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object v1, v6, v7

    const/4 v7, 0x1

    aput-object p1, v6, v7

    invoke-virtual {v4, v6}, Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 168
    .end local v1    # "jsonObject":Lorg/json/JSONObject;
    .end local v2    # "sessionLengthInSecs":D
    :catch_0
    move-exception v0

    .line 169
    .local v0, "e":Ljava/lang/Exception;
    :try_start_2
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 153
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v4

    monitor-exit v5

    throw v4
.end method

.method public static final declared-synchronized setCounterMetric(Ljava/lang/String;I)V
    .locals 3
    .param p0, "key"    # Ljava/lang/String;
    .param p1, "value"    # I

    .prologue
    .line 130
    const-class v1, Lcom/a9/creditcardreaderlibrary/metrics/MManager;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_countersMap:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, p0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 131
    monitor-exit v1

    return-void

    .line 130
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static final declared-synchronized setTimingMetric(Ljava/lang/String;D)V
    .locals 3
    .param p0, "key"    # Ljava/lang/String;
    .param p1, "timeInSeconds"    # D

    .prologue
    .line 140
    const-class v1, Lcom/a9/creditcardreaderlibrary/metrics/MManager;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_timingsMap:Ljava/util/HashMap;

    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    invoke-virtual {v0, p0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 141
    monitor-exit v1

    return-void

    .line 140
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static final declared-synchronized startSession()V
    .locals 4

    .prologue
    .line 78
    const-class v1, Lcom/a9/creditcardreaderlibrary/metrics/MManager;

    monitor-enter v1

    :try_start_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    sput-wide v2, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_sessionStart:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 79
    monitor-exit v1

    return-void

    .line 78
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static final declared-synchronized stopSession()V
    .locals 4

    .prologue
    .line 87
    const-class v1, Lcom/a9/creditcardreaderlibrary/metrics/MManager;

    monitor-enter v1

    :try_start_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    sput-wide v2, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->s_sessionEnd:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 88
    monitor-exit v1

    return-void

    .line 87
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method
