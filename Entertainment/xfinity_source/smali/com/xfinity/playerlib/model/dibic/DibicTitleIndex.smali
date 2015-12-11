.class public Lcom/xfinity/playerlib/model/dibic/DibicTitleIndex;
.super Ljava/lang/Object;
.source "DibicTitleIndex.java"


# instance fields
.field private final LOG:Lorg/slf4j/Logger;

.field private final nonAsciiRemover:Lcom/comcast/cim/utils/NonAsciiRemover;

.field private final programs:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;"
        }
    .end annotation
.end field

.field private final titleIndex:Ljava/util/SortedMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/SortedMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/Set",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 25
    .local p1, "programs":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    const-class v0, Lcom/xfinity/playerlib/model/dibic/DibicTitleIndex;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicTitleIndex;->LOG:Lorg/slf4j/Logger;

    .line 19
    new-instance v0, Lcom/comcast/cim/utils/NonAsciiRemover;

    invoke-direct {v0}, Lcom/comcast/cim/utils/NonAsciiRemover;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicTitleIndex;->nonAsciiRemover:Lcom/comcast/cim/utils/NonAsciiRemover;

    .line 26
    invoke-static {p1}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicTitleIndex;->programs:Ljava/util/List;

    .line 27
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/dibic/DibicTitleIndex;->buildIndex(Ljava/util/List;)Ljava/util/SortedMap;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicTitleIndex;->titleIndex:Ljava/util/SortedMap;

    .line 28
    return-void
.end method

.method private buildIndex(Ljava/util/List;)Ljava/util/SortedMap;
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;)",
            "Ljava/util/SortedMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/Set",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 31
    .local p1, "programs":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    new-instance v4, Lorg/apache/commons/lang3/time/StopWatch;

    invoke-direct {v4}, Lorg/apache/commons/lang3/time/StopWatch;-><init>()V

    .line 32
    .local v4, "timer":Lorg/apache/commons/lang3/time/StopWatch;
    invoke-virtual {v4}, Lorg/apache/commons/lang3/time/StopWatch;->start()V

    .line 33
    invoke-static {}, Lcom/google/common/collect/Maps;->newTreeMap()Ljava/util/TreeMap;

    move-result-object v6

    .line 34
    .local v6, "wordIndex":Ljava/util/SortedMap;, "Ljava/util/SortedMap<Ljava/lang/String;Ljava/util/Set<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 35
    .local v1, "normalizedWordMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_4

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .line 36
    .local v2, "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getTitleWords()Ljava/util/List;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :cond_1
    :goto_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_0

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 37
    .local v5, "word":Ljava/lang/String;
    const-string v9, " "

    invoke-virtual {v5, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_1

    .line 41
    invoke-interface {v1, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 42
    .local v0, "normalizedWord":Ljava/lang/String;
    if-nez v0, :cond_2

    .line 43
    iget-object v9, p0, Lcom/xfinity/playerlib/model/dibic/DibicTitleIndex;->nonAsciiRemover:Lcom/comcast/cim/utils/NonAsciiRemover;

    sget-object v10, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v5, v10}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/comcast/cim/utils/NonAsciiRemover;->convertNonAscii(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 44
    invoke-interface {v1, v5, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 47
    :cond_2
    invoke-interface {v6, v0}, Ljava/util/SortedMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Set;

    .line 48
    .local v3, "programSet":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    if-nez v3, :cond_3

    .line 49
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v3

    .line 50
    invoke-interface {v6, v0, v3}, Ljava/util/SortedMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 52
    :cond_3
    invoke-interface {v3, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 55
    .end local v0    # "normalizedWord":Ljava/lang/String;
    .end local v2    # "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .end local v3    # "programSet":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    .end local v5    # "word":Ljava/lang/String;
    :cond_4
    invoke-virtual {v4}, Lorg/apache/commons/lang3/time/StopWatch;->stop()V

    .line 56
    iget-object v7, p0, Lcom/xfinity/playerlib/model/dibic/DibicTitleIndex;->LOG:Lorg/slf4j/Logger;

    const-string v8, "Built index in {}"

    invoke-interface {v7, v8, v4}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    .line 57
    invoke-static {v6}, Ljava/util/Collections;->unmodifiableSortedMap(Ljava/util/SortedMap;)Ljava/util/SortedMap;

    move-result-object v7

    return-object v7
.end method


# virtual methods
.method public filterPrefix(Ljava/util/SortedMap;Ljava/lang/String;)Ljava/util/SortedMap;
    .locals 5
    .param p2, "prefix"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<V:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/SortedMap",
            "<",
            "Ljava/lang/String;",
            "TV;>;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/SortedMap",
            "<",
            "Ljava/lang/String;",
            "TV;>;"
        }
    .end annotation

    .prologue
    .line 86
    .local p1, "baseMap":Ljava/util/SortedMap;, "Ljava/util/SortedMap<Ljava/lang/String;TV;>;"
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_0

    .line 87
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {p2, v2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    add-int/lit8 v2, v2, 0x1

    int-to-char v1, v2

    .line 88
    .local v1, "nextLetter":C
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const/4 v3, 0x0

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    invoke-virtual {p2, v3, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 89
    .local v0, "end":Ljava/lang/String;
    invoke-interface {p1, p2, v0}, Ljava/util/SortedMap;->subMap(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/SortedMap;

    move-result-object p1

    .line 91
    .end local v0    # "end":Ljava/lang/String;
    .end local v1    # "nextLetter":C
    .end local p1    # "baseMap":Ljava/util/SortedMap;, "Ljava/util/SortedMap<Ljava/lang/String;TV;>;"
    :cond_0
    return-object p1
.end method

.method public getSublistMatchingTitleQuery(Ljava/lang/String;)Ljava/util/List;
    .locals 13
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
    .line 62
    new-instance v8, Lorg/apache/commons/lang3/time/StopWatch;

    invoke-direct {v8}, Lorg/apache/commons/lang3/time/StopWatch;-><init>()V

    .line 63
    .local v8, "timer":Lorg/apache/commons/lang3/time/StopWatch;
    invoke-virtual {v8}, Lorg/apache/commons/lang3/time/StopWatch;->start()V

    .line 65
    invoke-static {p1}, Lorg/apache/commons/lang3/StringUtils;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    .line 66
    .local v6, "searchTerms":[Ljava/lang/String;
    invoke-static {}, Lcom/google/common/collect/Sets;->newLinkedHashSet()Ljava/util/LinkedHashSet;

    move-result-object v7

    .line 67
    .local v7, "subList":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    new-instance v0, Ljava/util/HashSet;

    iget-object v9, p0, Lcom/xfinity/playerlib/model/dibic/DibicTitleIndex;->programs:Ljava/util/List;

    invoke-direct {v0, v9}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    .line 68
    .local v0, "intersectWith":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    array-length v10, v6

    const/4 v9, 0x0

    :goto_0
    if-ge v9, v10, :cond_1

    aget-object v5, v6, v9

    .line 69
    .local v5, "searchTerm":Ljava/lang/String;
    sget-object v11, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v5, v11}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    .line 70
    .local v1, "lcSearchTerm":Ljava/lang/String;
    invoke-static {}, Lcom/google/common/collect/Sets;->newLinkedHashSet()Ljava/util/LinkedHashSet;

    move-result-object v3

    .line 71
    .local v3, "matchingPrograms":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    iget-object v11, p0, Lcom/xfinity/playerlib/model/dibic/DibicTitleIndex;->titleIndex:Ljava/util/SortedMap;

    invoke-virtual {p0, v11, v1}, Lcom/xfinity/playerlib/model/dibic/DibicTitleIndex;->filterPrefix(Ljava/util/SortedMap;Ljava/lang/String;)Ljava/util/SortedMap;

    move-result-object v2

    .line 72
    .local v2, "matchingIndexEntries":Ljava/util/SortedMap;, "Ljava/util/SortedMap<Ljava/lang/String;Ljava/util/Set<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    invoke-interface {v2}, Ljava/util/SortedMap;->values()Ljava/util/Collection;

    move-result-object v11

    invoke-interface {v11}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v11

    :goto_1
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_0

    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/Set;

    .line 73
    .local v4, "programs":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    invoke-interface {v3, v4}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    goto :goto_1

    .line 75
    .end local v4    # "programs":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    :cond_0
    invoke-static {v3, v0}, Lcom/google/common/collect/Sets;->intersection(Ljava/util/Set;Ljava/util/Set;)Lcom/google/common/collect/Sets$SetView;

    move-result-object v7

    .line 76
    move-object v0, v7

    .line 68
    add-int/lit8 v9, v9, 0x1

    goto :goto_0

    .line 79
    .end local v1    # "lcSearchTerm":Ljava/lang/String;
    .end local v2    # "matchingIndexEntries":Ljava/util/SortedMap;, "Ljava/util/SortedMap<Ljava/lang/String;Ljava/util/Set<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    .end local v3    # "matchingPrograms":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    .end local v5    # "searchTerm":Ljava/lang/String;
    :cond_1
    invoke-virtual {v8}, Lorg/apache/commons/lang3/time/StopWatch;->stop()V

    .line 80
    iget-object v9, p0, Lcom/xfinity/playerlib/model/dibic/DibicTitleIndex;->LOG:Lorg/slf4j/Logger;

    const-string v10, "Search performed for {} in {}"

    invoke-interface {v9, v10, p1, v8}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 82
    invoke-static {v7}, Lcom/google/common/collect/Lists;->newArrayList(Ljava/lang/Iterable;)Ljava/util/ArrayList;

    move-result-object v9

    return-object v9
.end method
