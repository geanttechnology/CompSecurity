.class Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheEntity;
.super Ljava/lang/Object;
.source "CacheEntity.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
.implements Ljava/io/Serializable;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# instance fields
.field private final cacheEntry:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V
    .locals 0
    .param p1, "cacheEntry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheEntity;->cacheEntry:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    .line 50
    return-void
.end method


# virtual methods
.method public clone()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 97
    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getContent()Ljava/io/InputStream;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 73
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheEntity;->cacheEntry:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getResource()Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;->getInputStream()Ljava/io/InputStream;

    move-result-object v0

    return-object v0
.end method

.method public getContentEncoding()Lcom/comcast/cim/httpcomponentsandroid/Header;
    .locals 2

    .prologue
    .line 57
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheEntity;->cacheEntry:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    const-string v1, "Content-Encoding"

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    return-object v0
.end method

.method public getContentLength()J
    .locals 2

    .prologue
    .line 69
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheEntity;->cacheEntry:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getResource()Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;->length()J

    move-result-wide v0

    return-wide v0
.end method

.method public getContentType()Lcom/comcast/cim/httpcomponentsandroid/Header;
    .locals 2

    .prologue
    .line 53
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheEntity;->cacheEntry:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    const-string v1, "Content-Type"

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    return-object v0
.end method

.method public isChunked()Z
    .locals 1

    .prologue
    .line 61
    const/4 v0, 0x0

    return v0
.end method

.method public isRepeatable()Z
    .locals 1

    .prologue
    .line 65
    const/4 v0, 0x1

    return v0
.end method

.method public isStreaming()Z
    .locals 1

    .prologue
    .line 89
    const/4 v0, 0x0

    return v0
.end method

.method public writeTo(Ljava/io/OutputStream;)V
    .locals 3
    .param p1, "outstream"    # Ljava/io/OutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 77
    if-nez p1, :cond_0

    .line 78
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Output stream may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 80
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheEntity;->cacheEntry:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getResource()Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;->getInputStream()Ljava/io/InputStream;

    move-result-object v0

    .line 82
    .local v0, "instream":Ljava/io/InputStream;
    :try_start_0
    invoke-static {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/IOUtils;->copy(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 84
    invoke-virtual {v0}, Ljava/io/InputStream;->close()V

    .line 86
    return-void

    .line 84
    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Ljava/io/InputStream;->close()V

    throw v1
.end method
