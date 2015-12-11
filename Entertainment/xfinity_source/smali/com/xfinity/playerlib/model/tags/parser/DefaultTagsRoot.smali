.class public final Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;
.super Ljava/lang/Object;
.source "DefaultTagsRoot.java"

# interfaces
.implements Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final allPublicGenresMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;"
        }
    .end annotation
.end field

.field private final client:Ljava/lang/String;

.field private final companyIdMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Long;",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ">;"
        }
    .end annotation
.end field

.field private final networks:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ">;"
        }
    .end annotation
.end field

.field private final publicMovieGenres:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;"
        }
    .end annotation
.end field

.field private final publicTvGenres:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    const-class v0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V
    .locals 8
    .param p1, "client"    # Ljava/lang/String;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "client"
        .end annotation
    .end param
    .param p2    # Ljava/util/List;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "networkTags"
        .end annotation
    .end param
    .param p3    # Ljava/util/List;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "publicMovieTags"
        .end annotation
    .end param
    .param p4    # Ljava/util/List;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "publicTVTags"
        .end annotation
    .end param
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 36
    .local p2, "networks":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/tags/Network;>;"
    .local p3, "publicMovieGenres":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/tags/OrderedTag;>;"
    .local p4, "publicTvGenres":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/tags/OrderedTag;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    if-nez p2, :cond_0

    new-instance p2, Ljava/util/ArrayList;

    .end local p2    # "networks":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/tags/Network;>;"
    invoke-direct {p2}, Ljava/util/ArrayList;-><init>()V

    .line 39
    .restart local p2    # "networks":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/tags/Network;>;"
    :cond_0
    if-nez p3, :cond_1

    new-instance p3, Ljava/util/ArrayList;

    .end local p3    # "publicMovieGenres":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/tags/OrderedTag;>;"
    invoke-direct {p3}, Ljava/util/ArrayList;-><init>()V

    .line 40
    .restart local p3    # "publicMovieGenres":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/tags/OrderedTag;>;"
    :cond_1
    if-nez p4, :cond_2

    new-instance p4, Ljava/util/ArrayList;

    .end local p4    # "publicTvGenres":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/tags/OrderedTag;>;"
    invoke-direct {p4}, Ljava/util/ArrayList;-><init>()V

    .line 42
    .restart local p4    # "publicTvGenres":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/tags/OrderedTag;>;"
    :cond_2
    invoke-static {p2}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 43
    invoke-static {p3}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 44
    invoke-static {p4}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 46
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v1

    .line 47
    .local v1, "cidMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Long;Lcom/xfinity/playerlib/model/tags/Network;>;"
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v3

    .line 48
    .local v3, "nameMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/xfinity/playerlib/model/tags/Network;>;"
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/xfinity/playerlib/model/tags/Network;

    .line 49
    .local v4, "network":Lcom/xfinity/playerlib/model/tags/Network;
    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/tags/Network;->getCompanyId()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-interface {v1, v6, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 50
    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/tags/Network;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v3, v6, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 52
    .end local v4    # "network":Lcom/xfinity/playerlib/model/tags/Network;
    :cond_3
    invoke-static {v1}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v5

    iput-object v5, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->companyIdMap:Ljava/util/Map;

    .line 54
    iput-object p1, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->client:Ljava/lang/String;

    .line 55
    invoke-static {p2}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v5

    iput-object v5, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->networks:Ljava/util/List;

    .line 56
    invoke-static {p3}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v5

    iput-object v5, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->publicMovieGenres:Ljava/util/List;

    .line 57
    invoke-static {p4}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v5

    iput-object v5, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->publicTvGenres:Ljava/util/List;

    .line 59
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    .line 60
    .local v0, "allPublicGenresMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/xfinity/playerlib/model/tags/OrderedTag;>;"
    invoke-interface {p4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_4

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .line 61
    .local v2, "genre":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v0, v6, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 63
    .end local v2    # "genre":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    :cond_4
    invoke-interface {p3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_2
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_5

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .line 64
    .restart local v2    # "genre":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v0, v6, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    .line 66
    .end local v2    # "genre":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    :cond_5
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v5

    iput-object v5, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->allPublicGenresMap:Ljava/util/Map;

    .line 68
    return-void
.end method


# virtual methods
.method public final equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 137
    if-ne p0, p1, :cond_1

    .line 157
    :cond_0
    :goto_0
    return v1

    .line 140
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 141
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 143
    check-cast v0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;

    .line 144
    .local v0, "tagsRoot":Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;
    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->client:Ljava/lang/String;

    if-eqz v3, :cond_5

    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->client:Ljava/lang/String;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->client:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_6

    :cond_4
    move v1, v2

    .line 145
    goto :goto_0

    .line 144
    :cond_5
    iget-object v3, v0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->client:Ljava/lang/String;

    if-nez v3, :cond_4

    .line 147
    :cond_6
    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->networks:Ljava/util/List;

    if-eqz v3, :cond_8

    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->networks:Ljava/util/List;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->networks:Ljava/util/List;

    invoke-interface {v3, v4}, Ljava/util/List;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_9

    :cond_7
    move v1, v2

    .line 148
    goto :goto_0

    .line 147
    :cond_8
    iget-object v3, v0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->networks:Ljava/util/List;

    if-nez v3, :cond_7

    .line 150
    :cond_9
    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->publicMovieGenres:Ljava/util/List;

    if-eqz v3, :cond_b

    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->publicMovieGenres:Ljava/util/List;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->publicMovieGenres:Ljava/util/List;

    invoke-interface {v3, v4}, Ljava/util/List;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_c

    :cond_a
    move v1, v2

    .line 151
    goto :goto_0

    .line 150
    :cond_b
    iget-object v3, v0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->publicMovieGenres:Ljava/util/List;

    if-nez v3, :cond_a

    .line 154
    :cond_c
    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->publicTvGenres:Ljava/util/List;

    if-eqz v3, :cond_d

    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->publicTvGenres:Ljava/util/List;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->publicTvGenres:Ljava/util/List;

    invoke-interface {v3, v4}, Ljava/util/List;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :goto_1
    move v1, v2

    .line 155
    goto :goto_0

    .line 154
    :cond_d
    iget-object v3, v0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->publicTvGenres:Ljava/util/List;

    if-eqz v3, :cond_0

    goto :goto_1
.end method

.method public getAllPublicGenres()Ljava/util/Set;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;"
        }
    .end annotation

    .prologue
    .line 113
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v0

    .line 114
    .local v0, "allPublicGenres":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/tags/OrderedTag;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->allPublicGenresMap:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .line 115
    .local v1, "genre":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 117
    .end local v1    # "genre":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    :cond_0
    return-object v0
.end method

.method public getClient()Ljava/lang/String;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->client:Ljava/lang/String;

    return-object v0
.end method

.method public getGenreById(Ljava/lang/String;)Lcom/xfinity/playerlib/model/tags/OrderedTag;
    .locals 1
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 122
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->allPublicGenresMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/tags/OrderedTag;

    return-object v0
.end method

.method public getNetworkByCompanyId(J)Lcom/xfinity/playerlib/model/tags/Network;
    .locals 5
    .param p1, "companyId"    # J

    .prologue
    .line 82
    iget-object v1, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->companyIdMap:Ljava/util/Map;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/tags/Network;

    .line 83
    .local v0, "network":Lcom/xfinity/playerlib/model/tags/Network;
    if-nez v0, :cond_0

    .line 84
    sget-object v1, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->LOG:Lorg/slf4j/Logger;

    const-string v2, "No network found in map for id {}"

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;Ljava/lang/Object;)V

    .line 86
    :cond_0
    return-object v0
.end method

.method public getNetworks()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ">;"
        }
    .end annotation

    .prologue
    .line 77
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->networks:Ljava/util/List;

    return-object v0
.end method

.method public getNetworksByCompanyIds(Ljava/util/List;)Ljava/util/Set;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Long;",
            ">;)",
            "Ljava/util/Set",
            "<",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ">;"
        }
    .end annotation

    .prologue
    .line 91
    .local p1, "companyIds":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Long;>;"
    new-instance v2, Ljava/util/HashSet;

    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    .line 92
    .local v2, "networks":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/tags/Network;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    .line 93
    .local v0, "companyId":Ljava/lang/Long;
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-virtual {p0, v4, v5}, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->getNetworkByCompanyId(J)Lcom/xfinity/playerlib/model/tags/Network;

    move-result-object v1

    .line 94
    .local v1, "network":Lcom/xfinity/playerlib/model/tags/Network;
    if-eqz v1, :cond_0

    .line 95
    invoke-interface {v2, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 98
    .end local v0    # "companyId":Ljava/lang/Long;
    .end local v1    # "network":Lcom/xfinity/playerlib/model/tags/Network;
    :cond_1
    return-object v2
.end method

.method public getPublicMovieGenres()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;"
        }
    .end annotation

    .prologue
    .line 103
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->publicMovieGenres:Ljava/util/List;

    return-object v0
.end method

.method public getPublicTvGenres()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;"
        }
    .end annotation

    .prologue
    .line 108
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->publicTvGenres:Ljava/util/List;

    return-object v0
.end method

.method public final hashCode()I
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 162
    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->client:Ljava/lang/String;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->client:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v0

    .line 163
    .local v0, "result":I
    :goto_0
    mul-int/lit8 v3, v0, 0x1f

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->networks:Ljava/util/List;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->networks:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->hashCode()I

    move-result v2

    :goto_1
    add-int v0, v3, v2

    .line 164
    mul-int/lit8 v3, v0, 0x1f

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->publicMovieGenres:Ljava/util/List;

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->publicMovieGenres:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->hashCode()I

    move-result v2

    :goto_2
    add-int v0, v3, v2

    .line 165
    mul-int/lit8 v2, v0, 0x1f

    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->publicTvGenres:Ljava/util/List;

    if-eqz v3, :cond_0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->publicTvGenres:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->hashCode()I

    move-result v1

    :cond_0
    add-int v0, v2, v1

    .line 166
    return v0

    .end local v0    # "result":I
    :cond_1
    move v0, v1

    .line 162
    goto :goto_0

    .restart local v0    # "result":I
    :cond_2
    move v2, v1

    .line 163
    goto :goto_1

    :cond_3
    move v2, v1

    .line 164
    goto :goto_2
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 127
    new-instance v0, Lorg/apache/commons/lang3/builder/ToStringBuilder;

    sget-object v1, Lorg/apache/commons/lang3/builder/ToStringStyle;->SHORT_PREFIX_STYLE:Lorg/apache/commons/lang3/builder/ToStringStyle;

    invoke-direct {v0, p0, v1}, Lorg/apache/commons/lang3/builder/ToStringBuilder;-><init>(Ljava/lang/Object;Lorg/apache/commons/lang3/builder/ToStringStyle;)V

    iget-object v1, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->client:Ljava/lang/String;

    .line 128
    invoke-virtual {v0, v1}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->networks:Ljava/util/List;

    .line 129
    invoke-virtual {v0, v1}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->publicMovieGenres:Ljava/util/List;

    .line 130
    invoke-virtual {v0, v1}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/tags/parser/DefaultTagsRoot;->publicTvGenres:Ljava/util/List;

    .line 131
    invoke-virtual {v0, v1}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    .line 132
    invoke-virtual {v0}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
