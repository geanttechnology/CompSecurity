.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;
.super Ljava/lang/Object;
.source "HttpCacheStorage.java"


# virtual methods
.method public abstract getEntry(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract putEntry(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract removeEntry(Ljava/lang/String;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract updateEntry(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheUpdateCallback;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheUpdateException;
        }
    .end annotation
.end method
