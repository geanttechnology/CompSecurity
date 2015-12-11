.class public Lcom/amazon/identity/auth/device/framework/AuthErrorRetryLogic;
.super Lcom/amazon/identity/auth/device/framework/RetryLogic;
.source "AuthErrorRetryLogic.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mAuthEndpointErrorParser:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const-class v0, Lcom/amazon/identity/auth/device/framework/AuthErrorRetryLogic;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/AuthErrorRetryLogic;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 17
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/RetryLogic;-><init>()V

    .line 21
    new-instance v0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;

    invoke-direct {v0}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/AuthErrorRetryLogic;->mAuthEndpointErrorParser:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;

    return-void
.end method


# virtual methods
.method public shouldRetry(Ljava/net/HttpURLConnection;ILcom/amazon/identity/auth/device/framework/Tracer;)Z
    .locals 9
    .param p1, "httpURLConnection"    # Ljava/net/HttpURLConnection;
    .param p2, "currentRetryNum"    # I
    .param p3, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 28
    invoke-virtual {p1}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v3

    .line 31
    .local v3, "responseCode":I
    :try_start_0
    invoke-static {p1}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->toJson(Ljava/net/HttpURLConnection;)Lorg/json/JSONObject;

    move-result-object v2

    .line 34
    .local v2, "json":Lorg/json/JSONObject;
    if-nez v2, :cond_1

    .line 36
    sget-object v7, Lcom/amazon/identity/auth/device/framework/AuthErrorRetryLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v8, "Malformatted json response detected. Should retry if still within retry limit."

    invoke-static {v7, v8}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 57
    .end local v2    # "json":Lorg/json/JSONObject;
    :cond_0
    :goto_0
    return v5

    .line 41
    .restart local v2    # "json":Lorg/json/JSONObject;
    :cond_1
    iget-object v7, p0, Lcom/amazon/identity/auth/device/framework/AuthErrorRetryLogic;->mAuthEndpointErrorParser:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;

    invoke-virtual {v7, v3}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;->isFailure(I)Z

    move-result v7

    if-nez v7, :cond_2

    move v5, v6

    .line 43
    goto :goto_0

    .line 46
    :cond_2
    iget-object v7, p0, Lcom/amazon/identity/auth/device/framework/AuthErrorRetryLogic;->mAuthEndpointErrorParser:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;

    invoke-virtual {v7, v2}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;->parse(Lorg/json/JSONObject;)Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    move-result-object v1

    .line 48
    .local v1, "error":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    if-eqz v1, :cond_3

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->shouldRetry()Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v7

    if-nez v7, :cond_0

    :cond_3
    move v5, v6

    goto :goto_0

    .line 50
    .end local v1    # "error":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    .end local v2    # "json":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 52
    .local v0, "e":Lorg/json/JSONException;
    invoke-virtual {p1}, Ljava/net/HttpURLConnection;->getURL()Ljava/net/URL;

    move-result-object v4

    .line 53
    .local v4, "url":Ljava/net/URL;
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Lcom/amazon/identity/platform/metric/MetricUtils;->getMAPUrlType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string/jumbo v8, ":"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v4}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string/jumbo v8, ":JSONException"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 55
    new-array v6, v6, [Ljava/lang/String;

    invoke-static {v7, v6}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 56
    sget-object v6, Lcom/amazon/identity/auth/device/framework/AuthErrorRetryLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "Got JSONException while parsing response. Should retry if still within retry limit."

    invoke-static {v6, v7, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
