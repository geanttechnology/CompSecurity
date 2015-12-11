.class public Lcom/xfinity/playerlib/model/dibic/NullDibicResource;
.super Ljava/lang/Object;
.source "NullDibicResource.java"

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
.method public getGenreMapForNetwork(Lcom/xfinity/playerlib/model/tags/Network;)Ljava/util/Map;
    .locals 1
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
    .line 30
    invoke-static {}, Ljava/util/Collections;->emptyMap()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getProgramByMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .locals 1
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 20
    const/4 v0, 0x0

    return-object v0
.end method

.method public getPrograms()Ljava/util/List;
    .locals 1
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
    .line 15
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getProgramsMatchingGenreAndNetwork(Lcom/xfinity/playerlib/model/tags/OrderedTag;Lcom/xfinity/playerlib/model/tags/Network;)Ljava/util/List;
    .locals 1
    .param p1, "genres"    # Lcom/xfinity/playerlib/model/tags/OrderedTag;
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
    .line 40
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getProgramsMatchingGenresAndNetwork(Ljava/util/List;Lcom/xfinity/playerlib/model/tags/Network;)Ljava/util/Map;
    .locals 1
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
    .line 35
    .local p1, "genres":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/tags/OrderedTag;>;"
    invoke-static {}, Ljava/util/Collections;->emptyMap()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getProgramsMatchingTitleFilter(Ljava/lang/String;)Ljava/util/List;
    .locals 1
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
    .line 25
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method
