.class public Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient;
.super Ljava/lang/Object;
.source "RetryingHttpClient.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient$ResponseProvider;
    }
.end annotation


# instance fields
.field private final LOG:Lorg/slf4j/Logger;

.field private final delegate:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

.field private final maxRetries:I

.field private final pauseBetweenRetriesInMillis:I


# direct methods
.method static synthetic access$000(Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient;)Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient;->delegate:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    return-object v0
.end method

.method private consumeQuietly(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V
    .locals 1
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .prologue
    .line 68
    if-eqz p1, :cond_0

    .line 70
    :try_start_0
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v0

    invoke-static {v0}, Lcom/comcast/cim/httpcomponentsandroid/util/EntityUtils;->consume(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 74
    :cond_0
    :goto_0
    return-void

    .line 71
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method private executeWithRetry(Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient$ResponseProvider;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 6
    .param p1, "responseProvider"    # Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient$ResponseProvider;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 46
    const/4 v1, 0x0

    .line 48
    .local v1, "response":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    const/4 v0, 0x0

    .line 49
    .local v0, "numAttempts":I
    :goto_0
    iget v3, p0, Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient;->maxRetries:I

    if-gt v0, v3, :cond_0

    .line 50
    invoke-interface {p1}, Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient$ResponseProvider;->executeRequest()Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v1

    .line 51
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v3

    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v2

    .line 52
    .local v2, "statusCode":I
    const/16 v3, 0xca

    if-eq v2, v3, :cond_1

    .line 64
    .end local v2    # "statusCode":I
    :cond_0
    return-object v1

    .line 55
    .restart local v2    # "statusCode":I
    :cond_1
    invoke-direct {p0, v1}, Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient;->consumeQuietly(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V

    .line 57
    :try_start_0
    iget-object v3, p0, Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient;->LOG:Lorg/slf4j/Logger;

    const-string v4, "Received 202 (ACCEPTED) response from delegate client, pausing for {} millis"

    iget v5, p0, Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient;->pauseBetweenRetriesInMillis:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    .line 58
    iget v3, p0, Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient;->pauseBetweenRetriesInMillis:I

    int-to-long v4, v3

    invoke-static {v4, v5}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 61
    :goto_1
    add-int/lit8 v0, v0, 0x1

    .line 62
    iget-object v3, p0, Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient;->LOG:Lorg/slf4j/Logger;

    const-string v4, "Retrying request (numAttempts so far: {})"

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0

    .line 59
    :catch_0
    move-exception v3

    goto :goto_1
.end method


# virtual methods
.method public execute(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 1
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 115
    new-instance v0, Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient$4;

    invoke-direct {v0, p0, p1, p2, p3}, Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient$4;-><init>(Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient;Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V

    invoke-direct {p0, v0}, Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient;->executeWithRetry(Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient$ResponseProvider;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v0

    return-object v0
.end method

.method public execute(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 1
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 88
    new-instance v0, Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient$1;

    invoke-direct {v0, p0, p1}, Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient$1;-><init>(Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient;Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;)V

    invoke-direct {p0, v0}, Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient;->executeWithRetry(Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient$ResponseProvider;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v0

    return-object v0
.end method

.method public execute(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 1
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 97
    new-instance v0, Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient$2;

    invoke-direct {v0, p0, p1, p2}, Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient$2;-><init>(Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient;Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V

    invoke-direct {p0, v0}, Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient;->executeWithRetry(Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient$ResponseProvider;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v0

    return-object v0
.end method

.method public getConnectionManager()Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient;->delegate:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;->getConnectionManager()Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;

    move-result-object v0

    return-object v0
.end method

.method public getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/client/RetryingHttpClient;->delegate:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;->getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-result-object v0

    return-object v0
.end method
