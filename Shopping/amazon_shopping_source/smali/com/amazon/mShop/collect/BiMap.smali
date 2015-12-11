.class public Lcom/amazon/mShop/collect/BiMap;
.super Ljava/util/HashMap;
.source "BiMap.java"

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
        "Ljava/util/HashMap",
        "<TK;TV;>;",
        "Ljava/util/Map",
        "<TK;TV;>;"
    }
.end annotation


# instance fields
.field private inverse:Lcom/amazon/mShop/collect/BiMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/mShop/collect/BiMap",
            "<TV;TK;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 22
    .local p0, "this":Lcom/amazon/mShop/collect/BiMap;, "Lcom/amazon/mShop/collect/BiMap<TK;TV;>;"
    invoke-direct {p0}, Ljava/util/HashMap;-><init>()V

    .line 23
    new-instance v0, Lcom/amazon/mShop/collect/BiMap;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/collect/BiMap;-><init>(Lcom/amazon/mShop/collect/BiMap;)V

    iput-object v0, p0, Lcom/amazon/mShop/collect/BiMap;->inverse:Lcom/amazon/mShop/collect/BiMap;

    .line 24
    return-void
.end method

.method private constructor <init>(Lcom/amazon/mShop/collect/BiMap;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mShop/collect/BiMap",
            "<TV;TK;>;)V"
        }
    .end annotation

    .prologue
    .line 26
    .local p0, "this":Lcom/amazon/mShop/collect/BiMap;, "Lcom/amazon/mShop/collect/BiMap<TK;TV;>;"
    .local p1, "inverse":Lcom/amazon/mShop/collect/BiMap;, "Lcom/amazon/mShop/collect/BiMap<TV;TK;>;"
    invoke-direct {p0}, Ljava/util/HashMap;-><init>()V

    .line 27
    iput-object p1, p0, Lcom/amazon/mShop/collect/BiMap;->inverse:Lcom/amazon/mShop/collect/BiMap;

    .line 28
    return-void
.end method

.method static synthetic access$001(Lcom/amazon/mShop/collect/BiMap;)Ljava/util/Set;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/collect/BiMap;

    .prologue
    .line 17
    invoke-super {p0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$101(Lcom/amazon/mShop/collect/BiMap;)Ljava/util/Set;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/collect/BiMap;

    .prologue
    .line 17
    invoke-super {p0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$201(Lcom/amazon/mShop/collect/BiMap;)Ljava/util/Set;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/collect/BiMap;

    .prologue
    .line 17
    invoke-super {p0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$301(Lcom/amazon/mShop/collect/BiMap;)Ljava/util/Set;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/collect/BiMap;

    .prologue
    .line 17
    invoke-super {p0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method private putEntry(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;TV;)TV;"
        }
    .end annotation

    .prologue
    .line 116
    .local p0, "this":Lcom/amazon/mShop/collect/BiMap;, "Lcom/amazon/mShop/collect/BiMap<TK;TV;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    .local p2, "value":Ljava/lang/Object;, "TV;"
    invoke-super {p0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method private removeEntries()V
    .locals 0

    .prologue
    .line 124
    .local p0, "this":Lcom/amazon/mShop/collect/BiMap;, "Lcom/amazon/mShop/collect/BiMap<TK;TV;>;"
    invoke-super {p0}, Ljava/util/HashMap;->clear()V

    .line 125
    return-void
.end method


# virtual methods
.method public clear()V
    .locals 1

    .prologue
    .line 58
    .local p0, "this":Lcom/amazon/mShop/collect/BiMap;, "Lcom/amazon/mShop/collect/BiMap<TK;TV;>;"
    invoke-direct {p0}, Lcom/amazon/mShop/collect/BiMap;->removeEntries()V

    .line 59
    iget-object v0, p0, Lcom/amazon/mShop/collect/BiMap;->inverse:Lcom/amazon/mShop/collect/BiMap;

    invoke-direct {v0}, Lcom/amazon/mShop/collect/BiMap;->removeEntries()V

    .line 60
    return-void
.end method

.method public entrySet()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/util/Map$Entry",
            "<TK;TV;>;>;"
        }
    .end annotation

    .prologue
    .line 67
    .local p0, "this":Lcom/amazon/mShop/collect/BiMap;, "Lcom/amazon/mShop/collect/BiMap<TK;TV;>;"
    new-instance v0, Lcom/amazon/mShop/collect/BiMap$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/collect/BiMap$1;-><init>(Lcom/amazon/mShop/collect/BiMap;)V

    return-object v0
.end method

.method public inverse()Lcom/amazon/mShop/collect/BiMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/mShop/collect/BiMap",
            "<TV;TK;>;"
        }
    .end annotation

    .prologue
    .line 131
    .local p0, "this":Lcom/amazon/mShop/collect/BiMap;, "Lcom/amazon/mShop/collect/BiMap<TK;TV;>;"
    iget-object v0, p0, Lcom/amazon/mShop/collect/BiMap;->inverse:Lcom/amazon/mShop/collect/BiMap;

    return-object v0
.end method

.method public put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;TV;)TV;"
        }
    .end annotation

    .prologue
    .line 33
    .local p0, "this":Lcom/amazon/mShop/collect/BiMap;, "Lcom/amazon/mShop/collect/BiMap<TK;TV;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    .local p2, "value":Ljava/lang/Object;, "TV;"
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/collect/BiMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/collect/BiMap;->inverse:Lcom/amazon/mShop/collect/BiMap;

    invoke-virtual {v0, p2}, Lcom/amazon/mShop/collect/BiMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/collect/BiMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/amazon/mShop/collect/BiMap;->inverse:Lcom/amazon/mShop/collect/BiMap;

    invoke-virtual {v0, p2}, Lcom/amazon/mShop/collect/BiMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 34
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/collect/BiMap;->inverse:Lcom/amazon/mShop/collect/BiMap;

    invoke-direct {v0, p2, p1}, Lcom/amazon/mShop/collect/BiMap;->putEntry(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 35
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/collect/BiMap;->putEntry(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0

    .line 38
    :cond_2
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Non-unique key or value used: %s=%s"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    const/4 v3, 0x1

    aput-object p2, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public putAll(Ljava/util/Map;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<+TK;+TV;>;)V"
        }
    .end annotation

    .prologue
    .line 43
    .local p0, "this":Lcom/amazon/mShop/collect/BiMap;, "Lcom/amazon/mShop/collect/BiMap<TK;TV;>;"
    .local p1, "map":Ljava/util/Map;, "Ljava/util/Map<+TK;+TV;>;"
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

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

    .line 44
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<+TK;+TV;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {p0, v2, v3}, Lcom/amazon/mShop/collect/BiMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 46
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<+TK;+TV;>;"
    :cond_0
    return-void
.end method

.method public remove(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .param p1, "key"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            ")TV;"
        }
    .end annotation

    .prologue
    .line 50
    .local p0, "this":Lcom/amazon/mShop/collect/BiMap;, "Lcom/amazon/mShop/collect/BiMap<TK;TV;>;"
    invoke-super {p0, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 51
    .local v0, "value":Ljava/lang/Object;, "TV;"
    iget-object v1, p0, Lcom/amazon/mShop/collect/BiMap;->inverse:Lcom/amazon/mShop/collect/BiMap;

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/collect/BiMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 53
    return-object v0
.end method
