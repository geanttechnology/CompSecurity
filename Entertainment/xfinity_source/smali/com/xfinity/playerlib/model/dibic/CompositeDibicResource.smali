.class public Lcom/xfinity/playerlib/model/dibic/CompositeDibicResource;
.super Lcom/xfinity/playerlib/model/dibic/AbstractDibicResource;
.source "CompositeDibicResource.java"


# instance fields
.field private final resources:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/util/Set;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 19
    .local p1, "resources":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/dibic/DibicResource;>;"
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/dibic/AbstractDibicResource;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/xfinity/playerlib/model/dibic/CompositeDibicResource;->resources:Ljava/util/Set;

    .line 21
    return-void
.end method


# virtual methods
.method public getGenreMapForNetwork(Lcom/xfinity/playerlib/model/tags/Network;)Ljava/util/Map;
    .locals 9
    .param p1, "network"    # Lcom/xfinity/playerlib/model/tags/Network;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 54
    invoke-static {}, Lcom/google/common/collect/Maps;->newTreeMap()Ljava/util/TreeMap;

    move-result-object v0

    .line 55
    .local v0, "combinedMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    iget-object v6, p0, Lcom/xfinity/playerlib/model/dibic/CompositeDibicResource;->resources:Ljava/util/Set;

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_2

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 56
    .local v5, "resource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    invoke-interface {v5, p1}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getGenreMapForNetwork(Lcom/xfinity/playerlib/model/tags/Network;)Ljava/util/Map;

    move-result-object v4

    .line 57
    .local v4, "programMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    invoke-interface {v4}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :goto_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 58
    .local v2, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 59
    .local v3, "genre":Ljava/lang/String;
    invoke-interface {v0, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 60
    .local v1, "combinedPrograms":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    if-nez v1, :cond_1

    .line 61
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v1

    .line 62
    invoke-interface {v0, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 64
    :cond_1
    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/Collection;

    invoke-interface {v1, v6}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    goto :goto_0

    .line 67
    .end local v1    # "combinedPrograms":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    .end local v2    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    .end local v3    # "genre":Ljava/lang/String;
    .end local v4    # "programMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    .end local v5    # "resource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    :cond_2
    return-object v0
.end method

.method public getProgramByMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .locals 4
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 34
    iget-object v2, p0, Lcom/xfinity/playerlib/model/dibic/CompositeDibicResource;->resources:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 35
    .local v1, "resource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    invoke-interface {v1, p1}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getProgramByMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    move-result-object v0

    .line 36
    .local v0, "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    if-eqz v0, :cond_0

    .line 40
    .end local v0    # "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .end local v1    # "resource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getPrograms()Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;"
        }
    .end annotation

    .prologue
    .line 25
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    .line 26
    .local v0, "combinedPrograms":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/model/dibic/CompositeDibicResource;->resources:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 27
    .local v1, "resource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    invoke-interface {v1}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getPrograms()Ljava/util/List;

    move-result-object v3

    invoke-interface {v0, v3}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    goto :goto_0

    .line 29
    .end local v1    # "resource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    :cond_0
    return-object v0
.end method

.method public getProgramsMatchingGenresAndNetwork(Ljava/util/List;Lcom/xfinity/playerlib/model/tags/Network;)Ljava/util/Map;
    .locals 9
    .param p2, "network"    # Lcom/xfinity/playerlib/model/tags/Network;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ")",
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 72
    .local p1, "genres":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/tags/OrderedTag;>;"
    invoke-static {}, Lcom/google/common/collect/Maps;->newTreeMap()Ljava/util/TreeMap;

    move-result-object v0

    .line 73
    .local v0, "combinedMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/tags/OrderedTag;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    iget-object v6, p0, Lcom/xfinity/playerlib/model/dibic/CompositeDibicResource;->resources:Ljava/util/Set;

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_2

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 74
    .local v5, "resource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    invoke-interface {v5, p1, p2}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getProgramsMatchingGenresAndNetwork(Ljava/util/List;Lcom/xfinity/playerlib/model/tags/Network;)Ljava/util/Map;

    move-result-object v4

    .line 75
    .local v4, "programMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/tags/OrderedTag;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    invoke-interface {v4}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :goto_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 76
    .local v2, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Lcom/xfinity/playerlib/model/tags/OrderedTag;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .line 77
    .local v3, "genre":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    invoke-interface {v0, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 78
    .local v1, "combinedPrograms":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    if-nez v1, :cond_1

    .line 79
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v1

    .line 80
    invoke-interface {v0, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 82
    :cond_1
    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/Collection;

    invoke-interface {v1, v6}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    goto :goto_0

    .line 85
    .end local v1    # "combinedPrograms":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    .end local v2    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Lcom/xfinity/playerlib/model/tags/OrderedTag;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    .end local v3    # "genre":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    .end local v4    # "programMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/tags/OrderedTag;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    .end local v5    # "resource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    :cond_2
    return-object v0
.end method

.method public getProgramsMatchingTitleFilter(Ljava/lang/String;)Ljava/util/List;
    .locals 4
    .param p1, "query"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;"
        }
    .end annotation

    .prologue
    .line 45
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    .line 46
    .local v0, "combinedPrograms":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/model/dibic/CompositeDibicResource;->resources:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 47
    .local v1, "resource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    invoke-interface {v1, p1}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getProgramsMatchingTitleFilter(Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    invoke-interface {v0, v3}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    goto :goto_0

    .line 49
    .end local v1    # "resource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    :cond_0
    return-object v0
.end method
