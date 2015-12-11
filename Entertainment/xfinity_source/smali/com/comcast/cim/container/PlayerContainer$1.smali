.class Lcom/comcast/cim/container/PlayerContainer$1;
.super Ljava/lang/Object;
.source "PlayerContainer.java"

# interfaces
.implements Lcom/xfinity/playerlib/model/editorial/EditorialResourceFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/container/PlayerContainer;->getEditorialMovieAndSeriesResourceCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/xfinity/playerlib/model/editorial/EditorialResourceFactory",
        "<",
        "Lcom/xfinity/playerlib/model/editorial/VideoParser;",
        "Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/container/PlayerContainer;


# direct methods
.method constructor <init>(Lcom/comcast/cim/container/PlayerContainer;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/container/PlayerContainer;

    .prologue
    .line 464
    iput-object p1, p0, Lcom/comcast/cim/container/PlayerContainer$1;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createResource(Lcom/xfinity/playerlib/model/editorial/VideoParser;Ljava/lang/String;)Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;
    .locals 5
    .param p1, "parser"    # Lcom/xfinity/playerlib/model/editorial/VideoParser;
    .param p2, "json"    # Ljava/lang/String;

    .prologue
    .line 467
    new-instance v0, Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;

    invoke-virtual {p1, p2}, Lcom/xfinity/playerlib/model/editorial/VideoParser;->getMovies(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    invoke-virtual {p1, p2}, Lcom/xfinity/playerlib/model/editorial/VideoParser;->getMovieCollectionTitle(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, p2}, Lcom/xfinity/playerlib/model/editorial/VideoParser;->getSeries(Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    invoke-virtual {p1, p2}, Lcom/xfinity/playerlib/model/editorial/VideoParser;->getSeriesCollectionTitle(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;-><init>(Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V

    return-object v0
.end method

.method public bridge synthetic createResource(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 464
    check-cast p1, Lcom/xfinity/playerlib/model/editorial/VideoParser;

    invoke-virtual {p0, p1, p2}, Lcom/comcast/cim/container/PlayerContainer$1;->createResource(Lcom/xfinity/playerlib/model/editorial/VideoParser;Ljava/lang/String;)Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;

    move-result-object v0

    return-object v0
.end method
