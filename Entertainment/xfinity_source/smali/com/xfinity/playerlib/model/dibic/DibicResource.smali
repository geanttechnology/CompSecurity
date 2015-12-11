.class public interface abstract Lcom/xfinity/playerlib/model/dibic/DibicResource;
.super Ljava/lang/Object;
.source "DibicResource.java"


# virtual methods
.method public abstract getGenreMapForNetwork(Lcom/xfinity/playerlib/model/tags/Network;)Ljava/util/Map;
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
.end method

.method public abstract getProgramByMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/dibic/DibicProgram;
.end method

.method public abstract getPrograms()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getProgramsMatchingGenreAndNetwork(Lcom/xfinity/playerlib/model/tags/OrderedTag;Lcom/xfinity/playerlib/model/tags/Network;)Ljava/util/List;
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
.end method

.method public abstract getProgramsMatchingGenresAndNetwork(Ljava/util/List;Lcom/xfinity/playerlib/model/tags/Network;)Ljava/util/Map;
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
.end method

.method public abstract getProgramsMatchingTitleFilter(Ljava/lang/String;)Ljava/util/List;
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
.end method
