.class Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;
.super Ljava/lang/Object;
.source "AsynchronousValidationRequest.java"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private final cacheEntry:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

.field private final cachingClient:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;

.field private final context:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

.field private final identifier:Ljava/lang/String;

.field private final log:Lorg/apache/commons/logging/Log;

.field private final parent:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;

.field private final request:Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

.field private final target:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;


# direct methods
.method constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/lang/String;)V
    .locals 1
    .param p1, "parent"    # Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;
    .param p2, "cachingClient"    # Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;
    .param p3, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p4, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p5, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .param p6, "cacheEntry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .param p7, "identifier"    # Ljava/lang/String;

    .prologue
    .line 68
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lorg/apache/commons/logging/LogFactory;->getLog(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;->log:Lorg/apache/commons/logging/Log;

    .line 69
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;->parent:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;

    .line 70
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;->cachingClient:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;

    .line 71
    iput-object p3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;->target:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    .line 72
    iput-object p4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;->request:Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .line 73
    iput-object p5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;->context:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    .line 74
    iput-object p6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;->cacheEntry:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    .line 75
    iput-object p7, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;->identifier:Ljava/lang/String;

    .line 76
    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    .line 80
    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;->cachingClient:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;->target:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;->request:Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;->context:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    iget-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;->cacheEntry:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    invoke-virtual {v2, v3, v4, v5, v6}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CachingHttpClient;->revalidateCacheEntry(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/ProtocolException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 86
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;->parent:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;->identifier:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;->markComplete(Ljava/lang/String;)V

    .line 88
    :goto_0
    return-void

    .line 81
    :catch_0
    move-exception v0

    .line 82
    .local v0, "ioe":Ljava/io/IOException;
    :try_start_1
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;->log:Lorg/apache/commons/logging/Log;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Asynchronous revalidation failed due to exception: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 86
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;->parent:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;->identifier:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;->markComplete(Ljava/lang/String;)V

    goto :goto_0

    .line 83
    .end local v0    # "ioe":Ljava/io/IOException;
    :catch_1
    move-exception v1

    .line 84
    .local v1, "pe":Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;
    :try_start_2
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;->log:Lorg/apache/commons/logging/Log;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "ProtocolException thrown during asynchronous revalidation: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lorg/apache/commons/logging/Log;->error(Ljava/lang/Object;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 86
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;->parent:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;->identifier:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;->markComplete(Ljava/lang/String;)V

    goto :goto_0

    .end local v1    # "pe":Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;
    :catchall_0
    move-exception v2

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;->parent:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;

    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidationRequest;->identifier:Ljava/lang/String;

    invoke-virtual {v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/AsynchronousValidator;->markComplete(Ljava/lang/String;)V

    throw v2
.end method
