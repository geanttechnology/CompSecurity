.class public interface abstract Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
.super Ljava/lang/Object;
.source "TagsRoot.java"


# virtual methods
.method public abstract getAllPublicGenres()Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getClient()Ljava/lang/String;
.end method

.method public abstract getGenreById(Ljava/lang/String;)Lcom/xfinity/playerlib/model/tags/OrderedTag;
.end method

.method public abstract getNetworkByCompanyId(J)Lcom/xfinity/playerlib/model/tags/Network;
.end method

.method public abstract getNetworks()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getNetworksByCompanyIds(Ljava/util/List;)Ljava/util/Set;
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
.end method

.method public abstract getPublicMovieGenres()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getPublicTvGenres()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;"
        }
    .end annotation
.end method
