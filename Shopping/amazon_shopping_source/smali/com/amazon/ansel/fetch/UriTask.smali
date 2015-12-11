.class public abstract Lcom/amazon/ansel/fetch/UriTask;
.super Lcom/amazon/ansel/fetch/LoaderTask;
.source "UriTask.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<Result:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/amazon/ansel/fetch/LoaderTask",
        "<TResult;>;"
    }
.end annotation


# instance fields
.field private volatile connection:Lcom/amazon/ansel/fetch/tools/web/WebConnection;

.field private final uriRequest:Lcom/amazon/ansel/fetch/UriRequest;


# direct methods
.method public constructor <init>(Lcom/amazon/ansel/fetch/LoaderContext;Ljava/lang/Object;JLcom/amazon/ansel/fetch/UriRequest;)V
    .locals 0
    .param p1, "context"    # Lcom/amazon/ansel/fetch/LoaderContext;
    .param p2, "resourceKey"    # Ljava/lang/Object;
    .param p3, "priority"    # J
    .param p5, "uriRequest"    # Lcom/amazon/ansel/fetch/UriRequest;

    .prologue
    .line 20
    .local p0, "this":Lcom/amazon/ansel/fetch/UriTask;, "Lcom/amazon/ansel/fetch/UriTask<TResult;>;"
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/amazon/ansel/fetch/LoaderTask;-><init>(Lcom/amazon/ansel/fetch/LoaderContext;Ljava/lang/Object;J)V

    .line 21
    iput-object p5, p0, Lcom/amazon/ansel/fetch/UriTask;->uriRequest:Lcom/amazon/ansel/fetch/UriRequest;

    .line 22
    return-void
.end method


# virtual methods
.method protected abortTask()V
    .locals 2

    .prologue
    .line 62
    .local p0, "this":Lcom/amazon/ansel/fetch/UriTask;, "Lcom/amazon/ansel/fetch/UriTask<TResult;>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/UriTask;->connection:Lcom/amazon/ansel/fetch/tools/web/WebConnection;

    .line 64
    .local v0, "conn":Lcom/amazon/ansel/fetch/tools/web/WebConnection;
    if-eqz v0, :cond_0

    .line 66
    :try_start_0
    invoke-interface {v0}, Lcom/amazon/ansel/fetch/tools/web/WebConnection;->abort()V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 70
    :cond_0
    :goto_0
    return-void

    .line 67
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public executeTask()Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/ansel/fetch/cache/ResourceCacheValue",
            "<TResult;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/ansel/fetch/LoaderException;
        }
    .end annotation

    .prologue
    .line 30
    .local p0, "this":Lcom/amazon/ansel/fetch/UriTask;, "Lcom/amazon/ansel/fetch/UriTask<TResult;>;"
    const/4 v3, 0x0

    .line 31
    .local v3, "stream":Ljava/io/InputStream;
    const/4 v0, 0x0

    .line 34
    .local v0, "cacheValue":Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;, "Lcom/amazon/ansel/fetch/cache/ResourceCacheValue<TResult;>;"
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/UriTask;->getContext()Lcom/amazon/ansel/fetch/LoaderContext;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/ansel/fetch/LoaderContext;->getWebClientFactory()Lcom/amazon/ansel/fetch/tools/web/WebClientFactory;

    move-result-object v5

    invoke-interface {v5}, Lcom/amazon/ansel/fetch/tools/web/WebClientFactory;->getWebClient()Lcom/amazon/ansel/fetch/tools/web/WebClient;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v4

    .line 37
    .local v4, "webClient":Lcom/amazon/ansel/fetch/tools/web/WebClient;
    :try_start_1
    iget-object v5, p0, Lcom/amazon/ansel/fetch/UriTask;->uriRequest:Lcom/amazon/ansel/fetch/UriRequest;

    invoke-virtual {v5}, Lcom/amazon/ansel/fetch/UriRequest;->getMethod()Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/amazon/ansel/fetch/UriTask;->uriRequest:Lcom/amazon/ansel/fetch/UriRequest;

    invoke-virtual {v6}, Lcom/amazon/ansel/fetch/UriRequest;->getUri()Ljava/lang/String;

    move-result-object v6

    iget-object v7, p0, Lcom/amazon/ansel/fetch/UriTask;->uriRequest:Lcom/amazon/ansel/fetch/UriRequest;

    invoke-virtual {v7}, Lcom/amazon/ansel/fetch/UriRequest;->getHeaders()Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;

    move-result-object v7

    const/4 v8, 0x0

    invoke-interface {v4, v5, v6, v7, v8}, Lcom/amazon/ansel/fetch/tools/web/WebClient;->createConnection(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;Lcom/amazon/ansel/fetch/tools/web/RequestContent;)Lcom/amazon/ansel/fetch/tools/web/WebConnection;

    move-result-object v5

    iput-object v5, p0, Lcom/amazon/ansel/fetch/UriTask;->connection:Lcom/amazon/ansel/fetch/tools/web/WebConnection;

    .line 39
    iget-object v5, p0, Lcom/amazon/ansel/fetch/UriTask;->connection:Lcom/amazon/ansel/fetch/tools/web/WebConnection;

    invoke-interface {v5}, Lcom/amazon/ansel/fetch/tools/web/WebConnection;->getResponse()Lcom/amazon/ansel/fetch/tools/web/WebResponse;

    move-result-object v2

    .line 40
    .local v2, "response":Lcom/amazon/ansel/fetch/tools/web/WebResponse;
    invoke-interface {v2}, Lcom/amazon/ansel/fetch/tools/web/WebResponse;->getContent()Ljava/io/InputStream;

    move-result-object v3

    .line 41
    invoke-interface {v2}, Lcom/amazon/ansel/fetch/tools/web/WebResponse;->getStatusCode()I

    move-result v5

    invoke-virtual {p0, v5, v3}, Lcom/amazon/ansel/fetch/UriTask;->readResponse(ILjava/io/InputStream;)Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;

    move-result-object v0

    .line 42
    const/4 v5, 0x0

    iput-object v5, p0, Lcom/amazon/ansel/fetch/UriTask;->connection:Lcom/amazon/ansel/fetch/tools/web/WebConnection;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 47
    if-eqz v3, :cond_0

    .line 49
    :try_start_2
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    .line 55
    :cond_0
    :goto_0
    return-object v0

    .line 43
    .end local v2    # "response":Lcom/amazon/ansel/fetch/tools/web/WebResponse;
    :catch_0
    move-exception v1

    .line 44
    .local v1, "ioException":Ljava/io/IOException;
    :try_start_3
    new-instance v5, Lcom/amazon/ansel/fetch/LoaderException;

    invoke-direct {v5, v1}, Lcom/amazon/ansel/fetch/LoaderException;-><init>(Ljava/lang/Throwable;)V

    throw v5
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 47
    .end local v1    # "ioException":Ljava/io/IOException;
    .end local v4    # "webClient":Lcom/amazon/ansel/fetch/tools/web/WebClient;
    :catchall_0
    move-exception v5

    if-eqz v3, :cond_1

    .line 49
    :try_start_4
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2

    .line 51
    :cond_1
    :goto_1
    throw v5

    .line 50
    .restart local v2    # "response":Lcom/amazon/ansel/fetch/tools/web/WebResponse;
    .restart local v4    # "webClient":Lcom/amazon/ansel/fetch/tools/web/WebClient;
    :catch_1
    move-exception v5

    goto :goto_0

    .end local v2    # "response":Lcom/amazon/ansel/fetch/tools/web/WebResponse;
    .end local v4    # "webClient":Lcom/amazon/ansel/fetch/tools/web/WebClient;
    :catch_2
    move-exception v6

    goto :goto_1
.end method

.method public abstract readResponse(ILjava/io/InputStream;)Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/io/InputStream;",
            ")",
            "Lcom/amazon/ansel/fetch/cache/ResourceCacheValue",
            "<TResult;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/ansel/fetch/LoaderException;
        }
    .end annotation
.end method
