.class final Lcom/adobe/mediacore/ContentNoCache;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/ContentCache;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/ContentNoCache$Pair;
    }
.end annotation


# instance fields
.field private final cache:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/ContentNoCache$Pair;",
            ">;"
        }
    .end annotation
.end field

.field private final requestedCount:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/ContentNoCache;->cache:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/ContentNoCache;->requestedCount:Ljava/util/Map;

    return-void
.end method


# virtual methods
.method public addContent(Ljava/lang/String;Lcom/adobe/mediacore/AdHandle;)Z
    .locals 2

    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/ContentNoCache;->cache:Ljava/util/List;

    new-instance v1, Lcom/adobe/mediacore/ContentNoCache$Pair;

    invoke-direct {v1, p0, p1, p2}, Lcom/adobe/mediacore/ContentNoCache$Pair;-><init>(Lcom/adobe/mediacore/ContentNoCache;Ljava/lang/String;Lcom/adobe/mediacore/AdHandle;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    const/4 v0, 0x1

    goto :goto_0
.end method

.method public clearCache()V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/ContentNoCache;->cache:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    return-void
.end method

.method public getCachedUrls()Ljava/util/Set;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    new-instance v1, Ljava/util/TreeSet;

    invoke-direct {v1}, Ljava/util/TreeSet;-><init>()V

    iget-object v0, p0, Lcom/adobe/mediacore/ContentNoCache;->cache:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/ContentNoCache$Pair;

    invoke-virtual {v0}, Lcom/adobe/mediacore/ContentNoCache$Pair;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_0
    return-object v1
.end method

.method public getHandle(Ljava/lang/String;)Lcom/adobe/mediacore/AdHandle;
    .locals 6

    const/4 v2, 0x0

    const/4 v1, 0x0

    if-nez p1, :cond_0

    move-object v0, v2

    :goto_0
    return-object v0

    :cond_0
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iget-object v0, p0, Lcom/adobe/mediacore/ContentNoCache;->cache:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_1
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/ContentNoCache$Pair;

    invoke-virtual {v0}, Lcom/adobe/mediacore/ContentNoCache$Pair;->getUrl()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    :cond_2
    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    move-object v0, v2

    goto :goto_0

    :cond_3
    iget-object v0, p0, Lcom/adobe/mediacore/ContentNoCache;->requestedCount:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    iget-object v0, p0, Lcom/adobe/mediacore/ContentNoCache;->requestedCount:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    :goto_2
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v2

    if-ge v0, v2, :cond_4

    if-gez v0, :cond_5

    :cond_4
    move v0, v1

    :cond_5
    iget-object v1, p0, Lcom/adobe/mediacore/ContentNoCache;->requestedCount:Ljava/util/Map;

    add-int/lit8 v2, v0, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, p1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-interface {v3, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/ContentNoCache$Pair;

    invoke-virtual {v0}, Lcom/adobe/mediacore/ContentNoCache$Pair;->getAdHandle()Lcom/adobe/mediacore/AdHandle;

    move-result-object v0

    goto :goto_0

    :cond_6
    move v0, v1

    goto :goto_2
.end method

.method public isCached(Ljava/lang/String;)Z
    .locals 3

    const/4 v1, 0x0

    if-nez p1, :cond_0

    move v0, v1

    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/ContentNoCache;->cache:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/ContentNoCache$Pair;

    invoke-virtual {v0}, Lcom/adobe/mediacore/ContentNoCache$Pair;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    goto :goto_0

    :cond_2
    move v0, v1

    goto :goto_0
.end method
