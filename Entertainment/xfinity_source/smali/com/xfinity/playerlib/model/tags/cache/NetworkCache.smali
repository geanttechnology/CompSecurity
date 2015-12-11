.class public Lcom/xfinity/playerlib/model/tags/cache/NetworkCache;
.super Lcom/xfinity/playerlib/model/tags/cache/TagsCache;
.source "NetworkCache.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/xfinity/playerlib/model/tags/cache/TagsCache",
        "<",
        "Lcom/xfinity/playerlib/model/tags/Network;",
        ">;"
    }
.end annotation


# virtual methods
.method protected getList(Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;)Ljava/util/List;
    .locals 1
    .param p1, "tagsRoot"    # Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ">;"
        }
    .end annotation

    .prologue
    .line 17
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;->getNetworks()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method
