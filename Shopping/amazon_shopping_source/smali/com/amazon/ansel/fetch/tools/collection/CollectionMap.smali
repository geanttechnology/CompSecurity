.class public Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;
.super Ljava/lang/Object;
.source "CollectionMap.java"

# interfaces
.implements Ljava/util/Map;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "V:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Ljava/util/Map",
        "<TK;",
        "Ljava/util/List",
        "<TV;>;>;"
    }
.end annotation


# instance fields
.field private final initialListCapacity:I

.field private final map:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<TK;",
            "Ljava/util/List",
            "<TV;>;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 39
    .local p0, "this":Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;, "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap<TK;TV;>;"
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;-><init>(I)V

    .line 40
    return-void
.end method

.method public constructor <init>(I)V
    .locals 1
    .param p1, "initialMapCapacity"    # I

    .prologue
    .line 48
    .local p0, "this":Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;, "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap<TK;TV;>;"
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;-><init>(II)V

    .line 49
    return-void
.end method

.method public constructor <init>(II)V
    .locals 1
    .param p1, "initialMapCapacity"    # I
    .param p2, "initialListCapacity"    # I

    .prologue
    .line 30
    .local p0, "this":Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;, "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap<TK;TV;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0, p1}, Ljava/util/LinkedHashMap;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->map:Ljava/util/Map;

    .line 32
    iput p2, p0, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->initialListCapacity:I

    .line 33
    return-void
.end method

.method public constructor <init>(Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap",
            "<TK;TV;>;)V"
        }
    .end annotation

    .prologue
    .line 57
    .local p0, "this":Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;, "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap<TK;TV;>;"
    .local p1, "collection":Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;, "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap<TK;TV;>;"
    invoke-virtual {p1}, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->size()I

    move-result v0

    invoke-virtual {p1}, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->getInitialListCapacity()I

    move-result v1

    invoke-direct {p0, v0, v1}, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;-><init>(II)V

    .line 58
    invoke-virtual {p0, p1}, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->putAll(Ljava/util/Map;)V

    .line 59
    return-void
.end method


# virtual methods
.method public clear()V
    .locals 1

    .prologue
    .line 84
    .local p0, "this":Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;, "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap<TK;TV;>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->map:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 85
    return-void
.end method

.method public containsKey(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "key"    # Ljava/lang/Object;

    .prologue
    .line 89
    .local p0, "this":Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;, "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap<TK;TV;>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->map:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public containsValue(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    .line 94
    .local p0, "this":Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;, "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap<TK;TV;>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->map:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->containsValue(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public entrySet()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/util/Map$Entry",
            "<TK;",
            "Ljava/util/List",
            "<TV;>;>;>;"
        }
    .end annotation

    .prologue
    .line 99
    .local p0, "this":Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;, "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap<TK;TV;>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->map:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    .local p0, "this":Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;, "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap<TK;TV;>;"
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 327
    if-ne p0, p1, :cond_1

    .line 339
    :cond_0
    :goto_0
    return v1

    .line 329
    :cond_1
    if-nez p1, :cond_2

    move v1, v2

    .line 330
    goto :goto_0

    .line 331
    :cond_2
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    move v1, v2

    .line 332
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 333
    check-cast v0, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;

    .line 334
    .local v0, "other":Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;, "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap<**>;"
    iget-object v3, p0, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->map:Ljava/util/Map;

    if-nez v3, :cond_4

    .line 335
    iget-object v3, v0, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->map:Ljava/util/Map;

    if-eqz v3, :cond_0

    move v1, v2

    .line 336
    goto :goto_0

    .line 337
    :cond_4
    iget-object v3, p0, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->map:Ljava/util/Map;

    iget-object v4, v0, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->map:Ljava/util/Map;

    invoke-virtual {v3, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    move v1, v2

    .line 338
    goto :goto_0
.end method

.method public bridge synthetic get(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 17
    .local p0, "this":Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;, "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap<TK;TV;>;"
    invoke-virtual {p0, p1}, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->get(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public get(Ljava/lang/Object;)Ljava/util/List;
    .locals 1
    .param p1, "key"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            ")",
            "Ljava/util/List",
            "<TV;>;"
        }
    .end annotation

    .prologue
    .line 104
    .local p0, "this":Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;, "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap<TK;TV;>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->map:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    return-object v0
.end method

.method public getInitialListCapacity()I
    .locals 1

    .prologue
    .line 77
    .local p0, "this":Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;, "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap<TK;TV;>;"
    iget v0, p0, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->initialListCapacity:I

    return v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 319
    .local p0, "this":Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;, "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap<TK;TV;>;"
    const/16 v0, 0x1f

    .line 320
    .local v0, "prime":I
    const/4 v1, 0x1

    .line 321
    .local v1, "result":I
    iget-object v2, p0, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->map:Ljava/util/Map;

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    add-int/lit8 v1, v2, 0x1f

    .line 322
    return v1

    .line 321
    :cond_0
    iget-object v2, p0, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->map:Ljava/util/Map;

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    goto :goto_0
.end method

.method public isEmpty()Z
    .locals 1

    .prologue
    .line 109
    .local p0, "this":Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;, "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap<TK;TV;>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->map:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->isEmpty()Z

    move-result v0

    return v0
.end method

.method public keySet()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<TK;>;"
        }
    .end annotation

    .prologue
    .line 114
    .local p0, "this":Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;, "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap<TK;TV;>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->map:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 17
    .local p0, "this":Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;, "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap<TK;TV;>;"
    check-cast p2, Ljava/util/List;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->put(Ljava/lang/Object;Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public put(Ljava/lang/Object;Ljava/util/List;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;",
            "Ljava/util/List",
            "<TV;>;)",
            "Ljava/util/List",
            "<TV;>;"
        }
    .end annotation

    .prologue
    .line 119
    .local p0, "this":Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;, "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap<TK;TV;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    .local p2, "value":Ljava/util/List;, "Ljava/util/List<TV;>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->map:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    return-object v0
.end method

.method public putAll(Ljava/util/Map;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<+TK;+",
            "Ljava/util/List",
            "<TV;>;>;)V"
        }
    .end annotation

    .prologue
    .line 124
    .local p0, "this":Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;, "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap<TK;TV;>;"
    .local p1, "map":Ljava/util/Map;, "Ljava/util/Map<+TK;+Ljava/util/List<TV;>;>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->map:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 125
    return-void
.end method

.method public bridge synthetic remove(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 17
    .local p0, "this":Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;, "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap<TK;TV;>;"
    invoke-virtual {p0, p1}, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->remove(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public remove(Ljava/lang/Object;)Ljava/util/List;
    .locals 1
    .param p1, "key"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            ")",
            "Ljava/util/List",
            "<TV;>;"
        }
    .end annotation

    .prologue
    .line 129
    .local p0, "this":Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;, "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap<TK;TV;>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->map:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    return-object v0
.end method

.method public size()I
    .locals 1

    .prologue
    .line 134
    .local p0, "this":Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;, "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap<TK;TV;>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->map:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v0

    return v0
.end method

.method public values()Ljava/util/Collection;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection",
            "<",
            "Ljava/util/List",
            "<TV;>;>;"
        }
    .end annotation

    .prologue
    .line 139
    .local p0, "this":Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;, "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap<TK;TV;>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;->map:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    return-object v0
.end method
