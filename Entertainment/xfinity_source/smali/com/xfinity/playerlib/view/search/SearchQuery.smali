.class public Lcom/xfinity/playerlib/view/search/SearchQuery;
.super Ljava/lang/Object;
.source "SearchQuery.java"


# instance fields
.field private final genreFilters:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;"
        }
    .end annotation
.end field

.field private final networkFilters:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ">;"
        }
    .end annotation
.end field

.field private titleFilter:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    const-string v0, ""

    iput-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchQuery;->titleFilter:Ljava/lang/String;

    .line 13
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchQuery;->networkFilters:Ljava/util/Set;

    .line 14
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchQuery;->genreFilters:Ljava/util/Set;

    return-void
.end method


# virtual methods
.method public clear()V
    .locals 1

    .prologue
    .line 41
    const-string v0, ""

    iput-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchQuery;->titleFilter:Ljava/lang/String;

    .line 42
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchQuery;->networkFilters:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 43
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchQuery;->genreFilters:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 44
    return-void
.end method

.method public getGenreFilters()Ljava/util/Set;
    .locals 1
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
    .line 29
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchQuery;->genreFilters:Ljava/util/Set;

    return-object v0
.end method

.method public getNetworkFilters()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ">;"
        }
    .end annotation

    .prologue
    .line 25
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchQuery;->networkFilters:Ljava/util/Set;

    return-object v0
.end method

.method public getTagFilters()Ljava/util/Set;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<+",
            "Lcom/xfinity/playerlib/model/tags/Tag;",
            ">;"
        }
    .end annotation

    .prologue
    .line 33
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchQuery;->networkFilters:Ljava/util/Set;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchQuery;->genreFilters:Ljava/util/Set;

    invoke-static {v0, v1}, Lcom/google/common/collect/Sets;->union(Ljava/util/Set;Ljava/util/Set;)Lcom/google/common/collect/Sets$SetView;

    move-result-object v0

    return-object v0
.end method

.method public getTitleFilter()Ljava/lang/String;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchQuery;->titleFilter:Ljava/lang/String;

    return-object v0
.end method

.method public isEmpty()Z
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchQuery;->titleFilter:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchQuery;->getTagFilters()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setTitleFilter(Ljava/lang/String;)V
    .locals 0
    .param p1, "titleFilter"    # Ljava/lang/String;

    .prologue
    .line 21
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchQuery;->titleFilter:Ljava/lang/String;

    .line 22
    return-void
.end method
