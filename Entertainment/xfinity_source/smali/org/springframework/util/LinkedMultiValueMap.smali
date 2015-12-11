.class public Lorg/springframework/util/LinkedMultiValueMap;
.super Ljava/lang/Object;
.source "LinkedMultiValueMap.java"

# interfaces
.implements Ljava/io/Serializable;
.implements Lorg/springframework/util/MultiValueMap;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "V:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Ljava/io/Serializable;",
        "Lorg/springframework/util/MultiValueMap",
        "<TK;TV;>;"
    }
.end annotation


# instance fields
.field private final targetMap:Ljava/util/Map;
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
    .line 48
    .local p0, "this":Lorg/springframework/util/LinkedMultiValueMap;, "Lorg/springframework/util/LinkedMultiValueMap<TK;TV;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v0, p0, Lorg/springframework/util/LinkedMultiValueMap;->targetMap:Ljava/util/Map;

    .line 50
    return-void
.end method

.method public constructor <init>(I)V
    .locals 1
    .param p1, "initialCapacity"    # I

    .prologue
    .line 57
    .local p0, "this":Lorg/springframework/util/LinkedMultiValueMap;, "Lorg/springframework/util/LinkedMultiValueMap<TK;TV;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0, p1}, Ljava/util/LinkedHashMap;-><init>(I)V

    iput-object v0, p0, Lorg/springframework/util/LinkedMultiValueMap;->targetMap:Ljava/util/Map;

    .line 59
    return-void
.end method


# virtual methods
.method public add(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;TV;)V"
        }
    .end annotation

    .prologue
    .line 74
    .local p0, "this":Lorg/springframework/util/LinkedMultiValueMap;, "Lorg/springframework/util/LinkedMultiValueMap<TK;TV;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    .local p2, "value":Ljava/lang/Object;, "TV;"
    iget-object v1, p0, Lorg/springframework/util/LinkedMultiValueMap;->targetMap:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 75
    .local v0, "values":Ljava/util/List;, "Ljava/util/List<TV;>;"
    if-nez v0, :cond_0

    .line 76
    new-instance v0, Ljava/util/LinkedList;

    .end local v0    # "values":Ljava/util/List;, "Ljava/util/List<TV;>;"
    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    .line 77
    .restart local v0    # "values":Ljava/util/List;, "Ljava/util/List<TV;>;"
    iget-object v1, p0, Lorg/springframework/util/LinkedMultiValueMap;->targetMap:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 79
    :cond_0
    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 80
    return-void
.end method

.method public clear()V
    .locals 1

    .prologue
    .line 143
    .local p0, "this":Lorg/springframework/util/LinkedMultiValueMap;, "Lorg/springframework/util/LinkedMultiValueMap<TK;TV;>;"
    iget-object v0, p0, Lorg/springframework/util/LinkedMultiValueMap;->targetMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 144
    return-void
.end method

.method public containsKey(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "key"    # Ljava/lang/Object;

    .prologue
    .line 119
    .local p0, "this":Lorg/springframework/util/LinkedMultiValueMap;, "Lorg/springframework/util/LinkedMultiValueMap<TK;TV;>;"
    iget-object v0, p0, Lorg/springframework/util/LinkedMultiValueMap;->targetMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public containsValue(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    .line 123
    .local p0, "this":Lorg/springframework/util/LinkedMultiValueMap;, "Lorg/springframework/util/LinkedMultiValueMap<TK;TV;>;"
    iget-object v0, p0, Lorg/springframework/util/LinkedMultiValueMap;->targetMap:Ljava/util/Map;

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
    .line 155
    .local p0, "this":Lorg/springframework/util/LinkedMultiValueMap;, "Lorg/springframework/util/LinkedMultiValueMap<TK;TV;>;"
    iget-object v0, p0, Lorg/springframework/util/LinkedMultiValueMap;->targetMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    .line 161
    .local p0, "this":Lorg/springframework/util/LinkedMultiValueMap;, "Lorg/springframework/util/LinkedMultiValueMap<TK;TV;>;"
    iget-object v0, p0, Lorg/springframework/util/LinkedMultiValueMap;->targetMap:Ljava/util/Map;

    invoke-virtual {v0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public bridge synthetic get(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 38
    .local p0, "this":Lorg/springframework/util/LinkedMultiValueMap;, "Lorg/springframework/util/LinkedMultiValueMap<TK;TV;>;"
    invoke-virtual {p0, p1}, Lorg/springframework/util/LinkedMultiValueMap;->get(Ljava/lang/Object;)Ljava/util/List;

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
    .line 127
    .local p0, "this":Lorg/springframework/util/LinkedMultiValueMap;, "Lorg/springframework/util/LinkedMultiValueMap<TK;TV;>;"
    iget-object v0, p0, Lorg/springframework/util/LinkedMultiValueMap;->targetMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    return-object v0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 166
    .local p0, "this":Lorg/springframework/util/LinkedMultiValueMap;, "Lorg/springframework/util/LinkedMultiValueMap<TK;TV;>;"
    iget-object v0, p0, Lorg/springframework/util/LinkedMultiValueMap;->targetMap:Ljava/util/Map;

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    return v0
.end method

.method public isEmpty()Z
    .locals 1

    .prologue
    .line 115
    .local p0, "this":Lorg/springframework/util/LinkedMultiValueMap;, "Lorg/springframework/util/LinkedMultiValueMap<TK;TV;>;"
    iget-object v0, p0, Lorg/springframework/util/LinkedMultiValueMap;->targetMap:Ljava/util/Map;

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
    .line 147
    .local p0, "this":Lorg/springframework/util/LinkedMultiValueMap;, "Lorg/springframework/util/LinkedMultiValueMap<TK;TV;>;"
    iget-object v0, p0, Lorg/springframework/util/LinkedMultiValueMap;->targetMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 38
    .local p0, "this":Lorg/springframework/util/LinkedMultiValueMap;, "Lorg/springframework/util/LinkedMultiValueMap<TK;TV;>;"
    check-cast p2, Ljava/util/List;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lorg/springframework/util/LinkedMultiValueMap;->put(Ljava/lang/Object;Ljava/util/List;)Ljava/util/List;

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
    .line 131
    .local p0, "this":Lorg/springframework/util/LinkedMultiValueMap;, "Lorg/springframework/util/LinkedMultiValueMap<TK;TV;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    .local p2, "value":Ljava/util/List;, "Ljava/util/List<TV;>;"
    iget-object v0, p0, Lorg/springframework/util/LinkedMultiValueMap;->targetMap:Ljava/util/Map;

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
    .line 139
    .local p0, "this":Lorg/springframework/util/LinkedMultiValueMap;, "Lorg/springframework/util/LinkedMultiValueMap<TK;TV;>;"
    .local p1, "m":Ljava/util/Map;, "Ljava/util/Map<+TK;+Ljava/util/List<TV;>;>;"
    iget-object v0, p0, Lorg/springframework/util/LinkedMultiValueMap;->targetMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 140
    return-void
.end method

.method public bridge synthetic remove(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 38
    .local p0, "this":Lorg/springframework/util/LinkedMultiValueMap;, "Lorg/springframework/util/LinkedMultiValueMap<TK;TV;>;"
    invoke-virtual {p0, p1}, Lorg/springframework/util/LinkedMultiValueMap;->remove(Ljava/lang/Object;)Ljava/util/List;

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
    .line 135
    .local p0, "this":Lorg/springframework/util/LinkedMultiValueMap;, "Lorg/springframework/util/LinkedMultiValueMap<TK;TV;>;"
    iget-object v0, p0, Lorg/springframework/util/LinkedMultiValueMap;->targetMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    return-object v0
.end method

.method public set(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;TV;)V"
        }
    .end annotation

    .prologue
    .line 88
    .local p0, "this":Lorg/springframework/util/LinkedMultiValueMap;, "Lorg/springframework/util/LinkedMultiValueMap<TK;TV;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    .local p2, "value":Ljava/lang/Object;, "TV;"
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    .line 89
    .local v0, "values":Ljava/util/List;, "Ljava/util/List<TV;>;"
    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 90
    iget-object v1, p0, Lorg/springframework/util/LinkedMultiValueMap;->targetMap:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 91
    return-void
.end method

.method public setAll(Ljava/util/Map;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<TK;TV;>;)V"
        }
    .end annotation

    .prologue
    .line 94
    .local p0, "this":Lorg/springframework/util/LinkedMultiValueMap;, "Lorg/springframework/util/LinkedMultiValueMap<TK;TV;>;"
    .local p1, "values":Ljava/util/Map;, "Ljava/util/Map<TK;TV;>;"
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

    .line 95
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<TK;TV;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {p0, v2, v3}, Lorg/springframework/util/LinkedMultiValueMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_0

    .line 97
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<TK;TV;>;"
    :cond_0
    return-void
.end method

.method public size()I
    .locals 1

    .prologue
    .line 111
    .local p0, "this":Lorg/springframework/util/LinkedMultiValueMap;, "Lorg/springframework/util/LinkedMultiValueMap<TK;TV;>;"
    iget-object v0, p0, Lorg/springframework/util/LinkedMultiValueMap;->targetMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 171
    .local p0, "this":Lorg/springframework/util/LinkedMultiValueMap;, "Lorg/springframework/util/LinkedMultiValueMap<TK;TV;>;"
    iget-object v0, p0, Lorg/springframework/util/LinkedMultiValueMap;->targetMap:Ljava/util/Map;

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
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
    .line 151
    .local p0, "this":Lorg/springframework/util/LinkedMultiValueMap;, "Lorg/springframework/util/LinkedMultiValueMap<TK;TV;>;"
    iget-object v0, p0, Lorg/springframework/util/LinkedMultiValueMap;->targetMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    return-object v0
.end method
