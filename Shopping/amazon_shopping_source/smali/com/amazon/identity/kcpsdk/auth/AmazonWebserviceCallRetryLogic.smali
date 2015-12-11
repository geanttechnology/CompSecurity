.class public Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallRetryLogic;
.super Lcom/amazon/identity/auth/device/framework/RetryLogic;
.source "AmazonWebserviceCallRetryLogic.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mContext:Landroid/content/Context;

.field private mNumberOfAttempts:I

.field private mParser:Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallResponseParser;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallRetryLogic;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallRetryLogic;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallResponseParser;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "parser"    # Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallResponseParser;

    .prologue
    .line 31
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/RetryLogic;-><init>()V

    .line 26
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallRetryLogic;->mNumberOfAttempts:I

    .line 32
    iput-object p2, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallRetryLogic;->mParser:Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallResponseParser;

    .line 33
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallRetryLogic;->mContext:Landroid/content/Context;

    .line 34
    return-void
.end method


# virtual methods
.method public shouldRetry(Ljava/net/HttpURLConnection;ILcom/amazon/identity/auth/device/framework/Tracer;)Z
    .locals 12
    .param p1, "httpURLConnection"    # Ljava/net/HttpURLConnection;
    .param p2, "currentRetryNum"    # I
    .param p3, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 41
    iget v7, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallRetryLogic;->mNumberOfAttempts:I

    add-int/lit8 v7, v7, 0x1

    iput v7, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallRetryLogic;->mNumberOfAttempts:I

    .line 43
    invoke-virtual {p1}, Ljava/net/HttpURLConnection;->getURL()Ljava/net/URL;

    move-result-object v6

    .line 47
    .local v6, "url":Ljava/net/URL;
    :try_start_0
    invoke-static {v6}, Lcom/amazon/identity/platform/metric/MetricUtils;->getUrlPathAndDomain(Ljava/net/URL;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p3, v7}, Lcom/amazon/identity/auth/device/framework/Tracer;->startTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v5

    .line 48
    .local v5, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-virtual {p1}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v4

    .line 49
    .local v4, "responseCode":I
    invoke-virtual {v5}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stopClock()V

    .line 51
    iget-object v7, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallRetryLogic;->mParser:Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallResponseParser;

    invoke-interface {v7, p1}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallResponseParser;->getErrorCode(Ljava/net/HttpURLConnection;)Ljava/lang/String;

    move-result-object v3

    .line 52
    .local v3, "errorCode":Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 54
    invoke-static {v6, v4}, Lcom/amazon/identity/platform/metric/MetricUtils;->getUrlPathAndDomain(Ljava/net/URL;I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->setTimerName(Ljava/lang/String;)V

    .line 60
    :goto_0
    invoke-virtual {v5}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 62
    const/16 v7, 0x1f4

    if-lt v4, v7, :cond_2

    const/16 v7, 0x257

    if-gt v4, v7, :cond_2

    .line 64
    sget-object v7, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallRetryLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v8, "Got response code %d. Retrying"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v7, v8, v9}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 65
    const/4 v7, 0x1

    .line 97
    .end local v3    # "errorCode":Ljava/lang/String;
    .end local v4    # "responseCode":I
    .end local v5    # "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :goto_1
    return v7

    .line 58
    .restart local v3    # "errorCode":Ljava/lang/String;
    .restart local v4    # "responseCode":I
    .restart local v5    # "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :cond_0
    invoke-static {v6, v4, v3}, Lcom/amazon/identity/platform/metric/MetricUtils;->getUrlPathAndDomain(Ljava/net/URL;ILjava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->setTimerName(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 68
    .end local v3    # "errorCode":Ljava/lang/String;
    .end local v4    # "responseCode":I
    .end local v5    # "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :catch_0
    move-exception v2

    .line 70
    .local v2, "e":Ljava/io/IOException;
    iget-object v7, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallRetryLogic;->mContext:Landroid/content/Context;

    invoke-static {v7}, Lcom/amazon/identity/platform/metric/MetricUtils;->isDeviceConnected(Landroid/content/Context;)Z

    move-result v7

    if-nez v7, :cond_1

    .line 76
    iget v7, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallRetryLogic;->mNumberOfAttempts:I

    add-int/lit8 v7, v7, -0x1

    iput v7, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallRetryLogic;->mNumberOfAttempts:I

    .line 78
    :cond_1
    sget-object v7, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallRetryLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v8, "IOException : "

    invoke-static {v7, v8, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 79
    invoke-static {v6}, Lcom/amazon/identity/platform/metric/MetricUtils;->getIOExceptionMetricName(Ljava/net/URL;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p3, v7}, Lcom/amazon/identity/auth/device/framework/Tracer;->incrementCounter(Ljava/lang/String;)V

    .line 80
    iget-object v7, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallRetryLogic;->mContext:Landroid/content/Context;

    invoke-static {v6, v2, v7}, Lcom/amazon/identity/platform/metric/MetricUtils;->getIOExceptionWithSubClassMetricName(Ljava/net/URL;Ljava/io/IOException;Landroid/content/Context;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p3, v7}, Lcom/amazon/identity/auth/device/framework/Tracer;->incrementCounter(Ljava/lang/String;)V

    .line 81
    const/4 v7, 0x1

    goto :goto_1

    .line 85
    .end local v2    # "e":Ljava/io/IOException;
    .restart local v3    # "errorCode":Ljava/lang/String;
    .restart local v4    # "responseCode":I
    .restart local v5    # "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :cond_2
    iget v7, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallRetryLogic;->mNumberOfAttempts:I

    if-lez v7, :cond_3

    .line 87
    const-wide/high16 v7, 0x3ff0000000000000L    # 1.0

    iget v9, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallRetryLogic;->mNumberOfAttempts:I

    int-to-double v9, v9

    div-double v0, v7, v9

    .line 88
    .local v0, "availability":D
    invoke-static {v6}, Lcom/amazon/identity/platform/metric/MetricUtils;->getAvailabilityMetricName(Ljava/net/URL;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p3, v7, v0, v1}, Lcom/amazon/identity/auth/device/framework/Tracer;->incrementCounter(Ljava/lang/String;D)V

    .line 92
    .end local v0    # "availability":D
    :cond_3
    if-lez p2, :cond_4

    .line 94
    invoke-static {v6}, Lcom/amazon/identity/platform/metric/MetricUtils;->getSuccessAfterRetryMetricName(Ljava/net/URL;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p3, v7}, Lcom/amazon/identity/auth/device/framework/Tracer;->incrementCounter(Ljava/lang/String;)V

    .line 97
    :cond_4
    const/4 v7, 0x0

    goto :goto_1
.end method
