.class public Lcom/amazon/zeroes/intentservice/command/HttpGetCommand;
.super Ljava/lang/Object;
.source "HttpGetCommand.java"

# interfaces
.implements Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/zeroes/intentservice/command/ZeroesCommand",
        "<",
        "Lcom/amazon/mas/client/http/WebResponse;",
        ">;"
    }
.end annotation


# instance fields
.field private final client:Lcom/amazon/mas/client/http/WebHttpClient;

.field private final request:Lcom/amazon/mas/client/http/AbstractWebRequest;


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/amazon/mas/client/http/WebHttpClient;)V
    .locals 3
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "client"    # Lcom/amazon/mas/client/http/WebHttpClient;

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 36
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v1, "url must not be empty"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 39
    :cond_0
    if-nez p2, :cond_1

    .line 40
    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "client must not be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 43
    :cond_1
    iput-object p2, p0, Lcom/amazon/zeroes/intentservice/command/HttpGetCommand;->client:Lcom/amazon/mas/client/http/WebHttpClient;

    .line 44
    new-instance v0, Lcom/amazon/mas/client/http/DefaultWebRequestFactory;

    invoke-direct {v0}, Lcom/amazon/mas/client/http/DefaultWebRequestFactory;-><init>()V

    const-string/jumbo v1, "GET"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p1, v2}, Lcom/amazon/mas/client/http/DefaultWebRequestFactory;->fromMethodUrlRetries(Ljava/lang/String;Ljava/lang/String;I)Lcom/amazon/mas/client/http/AbstractWebRequest;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/zeroes/intentservice/command/HttpGetCommand;->request:Lcom/amazon/mas/client/http/AbstractWebRequest;

    .line 45
    return-void
.end method


# virtual methods
.method public perform()Lcom/amazon/mas/client/http/WebResponse;
    .locals 4

    .prologue
    .line 53
    :try_start_0
    iget-object v2, p0, Lcom/amazon/zeroes/intentservice/command/HttpGetCommand;->client:Lcom/amazon/mas/client/http/WebHttpClient;

    iget-object v3, p0, Lcom/amazon/zeroes/intentservice/command/HttpGetCommand;->request:Lcom/amazon/mas/client/http/AbstractWebRequest;

    invoke-interface {v2, v3}, Lcom/amazon/mas/client/http/WebHttpClient;->invoke(Lcom/amazon/mas/client/http/AbstractWebRequest;)Lcom/amazon/mas/client/http/WebResponse;
    :try_end_0
    .catch Lcom/amazon/mas/client/http/WebHttpException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 57
    :goto_0
    return-object v2

    .line 54
    :catch_0
    move-exception v0

    .line 55
    .local v0, "e":Lcom/amazon/mas/client/http/WebHttpException;
    invoke-static {v0}, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->fromThrowable(Ljava/lang/Throwable;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v1

    .line 56
    .local v1, "error":Lcom/amazon/sdk/availability/Measurement;
    invoke-static {v1}, Lcom/amazon/zeroes/intentservice/Metrics;->putMeasurement(Lcom/amazon/sdk/availability/Measurement;)V

    .line 57
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public bridge synthetic perform()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 17
    invoke-virtual {p0}, Lcom/amazon/zeroes/intentservice/command/HttpGetCommand;->perform()Lcom/amazon/mas/client/http/WebResponse;

    move-result-object v0

    return-object v0
.end method
