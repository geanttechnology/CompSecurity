.class public interface abstract Lcom/squareup/okhttp/OkResponseCache;
.super Ljava/lang/Object;
.source "OkResponseCache.java"


# virtual methods
.method public abstract get(Lcom/squareup/okhttp/internal/http/Request;)Lcom/squareup/okhttp/internal/http/Response;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract maybeRemove(Lcom/squareup/okhttp/internal/http/Request;)Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract put(Lcom/squareup/okhttp/internal/http/Response;)Ljava/net/CacheRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract trackConditionalCacheHit()V
.end method

.method public abstract trackResponse(Lcom/squareup/okhttp/ResponseSource;)V
.end method

.method public abstract update(Lcom/squareup/okhttp/internal/http/Response;Lcom/squareup/okhttp/internal/http/Response;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method
