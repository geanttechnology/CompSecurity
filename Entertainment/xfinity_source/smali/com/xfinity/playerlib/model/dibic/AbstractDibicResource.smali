.class public abstract Lcom/xfinity/playerlib/model/dibic/AbstractDibicResource;
.super Ljava/lang/Object;
.source "AbstractDibicResource.java"

# interfaces
.implements Lcom/xfinity/playerlib/model/dibic/DibicResource;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getProgramsMatchingGenreAndNetwork(Lcom/xfinity/playerlib/model/tags/OrderedTag;Lcom/xfinity/playerlib/model/tags/Network;)Ljava/util/List;
    .locals 4
    .param p1, "genre"    # Lcom/xfinity/playerlib/model/tags/OrderedTag;
    .param p2, "network"    # Lcom/xfinity/playerlib/model/tags/Network;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;"
        }
    .end annotation

    .prologue
    .line 15
    const/4 v2, 0x1

    new-array v2, v2, [Lcom/xfinity/playerlib/model/tags/OrderedTag;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-static {v2}, Lcom/google/common/collect/Lists;->newArrayList([Ljava/lang/Object;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {p0, v2, p2}, Lcom/xfinity/playerlib/model/dibic/AbstractDibicResource;->getProgramsMatchingGenresAndNetwork(Ljava/util/List;Lcom/xfinity/playerlib/model/tags/Network;)Ljava/util/Map;

    move-result-object v1

    .line 16
    .local v1, "map":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/tags/OrderedTag;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 18
    .local v0, "list":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    if-nez v0, :cond_0

    .line 20
    new-instance v0, Ljava/util/ArrayList;

    .end local v0    # "list":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 22
    .restart local v0    # "list":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    :cond_0
    return-object v0
.end method
