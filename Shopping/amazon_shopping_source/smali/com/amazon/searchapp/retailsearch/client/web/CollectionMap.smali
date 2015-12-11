.class public Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
.super Ljava/lang/Object;
.source "CollectionMap.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "V:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
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
    .line 27
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<TK;TV;>;"
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;-><init>(I)V

    .line 28
    return-void
.end method

.method public constructor <init>(I)V
    .locals 1
    .param p1, "initialMapCapacity"    # I

    .prologue
    .line 36
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<TK;TV;>;"
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;-><init>(II)V

    .line 37
    return-void
.end method

.method public constructor <init>(II)V
    .locals 1
    .param p1, "initialMapCapacity"    # I
    .param p2, "initialListCapacity"    # I

    .prologue
    .line 65
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<TK;TV;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 66
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0, p1}, Ljava/util/LinkedHashMap;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->map:Ljava/util/Map;

    .line 67
    iput p2, p0, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->initialListCapacity:I

    .line 68
    return-void
.end method

.method public constructor <init>(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<TK;TV;>;)V"
        }
    .end annotation

    .prologue
    .line 45
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<TK;TV;>;"
    .local p1, "collection":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<TK;TV;>;"
    invoke-virtual {p1}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->size()I

    move-result v0

    invoke-direct {p1}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->getInitialListCapacity()I

    move-result v1

    invoke-direct {p0, v0, v1}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;-><init>(II)V

    .line 46
    invoke-virtual {p0, p1}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V

    .line 47
    return-void
.end method

.method private getInitialListCapacity()I
    .locals 1

    .prologue
    .line 85
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<TK;TV;>;"
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->initialListCapacity:I

    return v0
.end method

.method private insert(Ljava/lang/Object;)Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;)",
            "Ljava/util/List",
            "<TV;>;"
        }
    .end annotation

    .prologue
    .line 366
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<TK;TV;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->map:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 368
    .local v0, "vals":Ljava/util/List;, "Ljava/util/List<TV;>;"
    if-nez v0, :cond_0

    .line 369
    new-instance v0, Ljava/util/ArrayList;

    .end local v0    # "vals":Ljava/util/List;, "Ljava/util/List<TV;>;"
    iget v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->initialListCapacity:I

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    .line 370
    .restart local v0    # "vals":Ljava/util/List;, "Ljava/util/List<TV;>;"
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->map:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 373
    :cond_0
    return-object v0
.end method

.method public static merge(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<K:",
            "Ljava/lang/Object;",
            "V:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<TK;TV;>;",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<TK;TV;>;",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<TK;TV;>;)",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<TK;TV;>;"
        }
    .end annotation

    .prologue
    .line 397
    .local p0, "a":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<TK;TV;>;"
    .local p1, "b":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<TK;TV;>;"
    .local p2, "c":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<TK;TV;>;"
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    invoke-direct {v0}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;-><init>()V

    .line 399
    .local v0, "res":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<TK;TV;>;"
    if-eqz p0, :cond_0

    .line 400
    invoke-virtual {v0, p0}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->merge(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V

    .line 403
    :cond_0
    if-eqz p1, :cond_1

    .line 404
    invoke-virtual {v0, p1}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->merge(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V

    .line 407
    :cond_1
    if-eqz p2, :cond_2

    .line 408
    invoke-virtual {v0, p2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->merge(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V

    .line 411
    :cond_2
    return-object v0
.end method


# virtual methods
.method public add(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;TV;)V"
        }
    .end annotation

    .prologue
    .line 224
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<TK;TV;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    .local p2, "value":Ljava/lang/Object;, "TV;"
    invoke-direct {p0, p1}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->insert(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 225
    return-void
.end method

.method public containsKey(Ljava/lang/Object;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;)Z"
        }
    .end annotation

    .prologue
    .line 131
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<TK;TV;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->map:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

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
    .line 356
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<TK;TV;>;"
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->map:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method public get(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;)TV;"
        }
    .end annotation

    .prologue
    .line 153
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<TK;TV;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    iget-object v1, p0, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->map:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 154
    .local v0, "vals":Ljava/util/List;, "Ljava/util/List<TV;>;"
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    const/4 v1, 0x0

    :goto_0
    return-object v1

    :cond_1
    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    goto :goto_0
.end method

.method public isEmpty()Z
    .locals 1

    .prologue
    .line 111
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<TK;TV;>;"
    invoke-virtual {p0}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->size()I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public merge(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<TK;TV;>;)V"
        }
    .end annotation

    .prologue
    .line 265
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<TK;TV;>;"
    .local p1, "collection":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<TK;TV;>;"
    invoke-virtual {p1}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 266
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<TK;Ljava/util/List<TV;>;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/List;

    invoke-virtual {p0, v3, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/util/List;)V

    goto :goto_0

    .line 268
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<TK;Ljava/util/List<TV;>;>;"
    :cond_0
    return-void
.end method

.method public set(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<TK;TV;>;)V"
        }
    .end annotation

    .prologue
    .line 197
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<TK;TV;>;"
    .local p1, "collection":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<TK;TV;>;"
    iget-object v2, p0, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->map:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->clear()V

    .line 199
    invoke-virtual {p1}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 200
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<TK;Ljava/util/List<TV;>;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/List;

    invoke-virtual {p0, v3, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/util/List;)V

    goto :goto_0

    .line 202
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<TK;Ljava/util/List<TV;>;>;"
    :cond_0
    return-void
.end method

.method public set(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;TV;)V"
        }
    .end annotation

    .prologue
    .line 174
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<TK;TV;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    .local p2, "value":Ljava/lang/Object;, "TV;"
    invoke-direct {p0, p1}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->insert(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    .line 175
    .local v0, "vals":Ljava/util/List;, "Ljava/util/List<TV;>;"
    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 176
    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 177
    return-void
.end method

.method public set(Ljava/lang/Object;Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;",
            "Ljava/util/List",
            "<TV;>;)V"
        }
    .end annotation

    .prologue
    .line 186
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<TK;TV;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    .local p2, "values":Ljava/util/List;, "Ljava/util/List<TV;>;"
    invoke-direct {p0, p1}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->insert(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    .line 187
    .local v0, "vals":Ljava/util/List;, "Ljava/util/List<TV;>;"
    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 188
    invoke-interface {v0, p2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 189
    return-void
.end method

.method public setDefault(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<TK;TV;>;)V"
        }
    .end annotation

    .prologue
    .line 287
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<TK;TV;>;"
    .local p1, "collection":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<TK;TV;>;"
    invoke-virtual {p1}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 288
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<TK;Ljava/util/List<TV;>;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 289
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/List;

    invoke-virtual {p0, v3, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/util/List;)V

    goto :goto_0

    .line 292
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<TK;Ljava/util/List<TV;>;>;"
    :cond_1
    return-void
.end method

.method public size()I
    .locals 1

    .prologue
    .line 94
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<TK;TV;>;"
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->map:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v0

    return v0
.end method
