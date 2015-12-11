.class public Lcom/auditude/ads/util/ObjectUtil;
.super Ljava/lang/Object;
.source "ObjectUtil.java"


# direct methods
.method public static convertToString(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "data"    # Ljava/lang/Object;
    .param p1, "defaultValue"    # Ljava/lang/String;

    .prologue
    .line 42
    if-eqz p0, :cond_0

    .line 44
    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p1

    .line 47
    .end local p1    # "defaultValue":Ljava/lang/String;
    :cond_0
    return-object p1
.end method

.method public static merge(Ljava/util/HashMap;Ljava/util/HashMap;)Ljava/util/HashMap;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 10
    .local p0, "a":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .local p1, "b":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    if-nez p0, :cond_1

    if-nez p1, :cond_1

    new-instance p0, Ljava/util/HashMap;

    .end local p0    # "a":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Ljava/util/HashMap;-><init>()V

    .line 32
    :cond_0
    :goto_0
    return-object p0

    .line 11
    .restart local p0    # "a":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_1
    if-eqz p0, :cond_2

    if-eqz p1, :cond_0

    .line 12
    :cond_2
    if-eqz p1, :cond_3

    if-nez p0, :cond_3

    move-object p0, p1

    goto :goto_0

    .line 14
    :cond_3
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 16
    .local v1, "result":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_4
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_6

    .line 24
    invoke-virtual {p1}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_5
    :goto_2
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_7

    move-object p0, v1

    .line 32
    goto :goto_0

    .line 16
    :cond_6
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 18
    .local v0, "kvp":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-static {v2}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 20
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 24
    .end local v0    # "kvp":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_7
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 26
    .restart local v0    # "kvp":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-static {v2}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 28
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2
.end method
