.class public Lcom/auditude/creativerepackaging/Cache;
.super Ljava/lang/Object;
.source "Cache.java"


# static fields
.field public static streamCache:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public static streamCacheSize:I

.field public static streamIdCache:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 11
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/auditude/creativerepackaging/Cache;->streamCache:Ljava/util/HashMap;

    .line 12
    const/4 v0, 0x2

    sput v0, Lcom/auditude/creativerepackaging/Cache;->streamCacheSize:I

    .line 13
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/auditude/creativerepackaging/Cache;->streamIdCache:Ljava/util/ArrayList;

    .line 15
    return-void
.end method

.method public static addPlaylistToCache(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p0, "stream"    # Ljava/lang/String;
    .param p1, "streamId"    # Ljava/lang/String;

    .prologue
    .line 19
    sget-object v0, Lcom/auditude/creativerepackaging/Cache;->streamIdCache:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    sget v1, Lcom/auditude/creativerepackaging/Cache;->streamCacheSize:I

    if-lt v0, v1, :cond_0

    .line 21
    invoke-static {}, Lcom/auditude/creativerepackaging/Cache;->removeFirstStreamFromCache()V

    .line 24
    :cond_0
    invoke-static {p1}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-static {p0}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 26
    const-string v0, "CreativeRepackagingService"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Cache: Adding stream for id "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "to cache. Cache size: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcom/auditude/creativerepackaging/Cache;->streamIdCache:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 27
    sget-object v0, Lcom/auditude/creativerepackaging/Cache;->streamIdCache:Ljava/util/ArrayList;

    sget-object v1, Lcom/auditude/creativerepackaging/Cache;->streamIdCache:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    invoke-virtual {v0, v1, p1}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 28
    sget-object v0, Lcom/auditude/creativerepackaging/Cache;->streamCache:Ljava/util/HashMap;

    invoke-virtual {v0, p1, p0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 30
    :cond_1
    return-void
.end method

.method public static playlistFromCacheForId(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "streamId"    # Ljava/lang/String;

    .prologue
    .line 34
    const-string v0, "CreativeRepackagingService"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Cache: Looking for stream with id "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 35
    invoke-static {p0}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/auditude/creativerepackaging/Cache;->streamCache:Ljava/util/HashMap;

    invoke-virtual {v0, p0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static removeFirstStreamFromCache()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 40
    sget-object v1, Lcom/auditude/creativerepackaging/Cache;->streamIdCache:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 42
    sget-object v1, Lcom/auditude/creativerepackaging/Cache;->streamIdCache:Ljava/util/ArrayList;

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 43
    .local v0, "streamId":Ljava/lang/String;
    invoke-static {v0}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v1, Lcom/auditude/creativerepackaging/Cache;->streamCache:Ljava/util/HashMap;

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 45
    sget-object v1, Lcom/auditude/creativerepackaging/Cache;->streamCache:Ljava/util/HashMap;

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 46
    sget-object v1, Lcom/auditude/creativerepackaging/Cache;->streamIdCache:Ljava/util/ArrayList;

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 49
    :cond_0
    return-void
.end method
