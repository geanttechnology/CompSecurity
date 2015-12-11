.class public Lcom/xfinity/playerlib/model/etc/DibicMovieUriProvider;
.super Ljava/lang/Object;
.source "DibicMovieUriProvider.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/utils/provider/Provider",
        "<",
        "Ljava/net/URI;",
        ">;"
    }
.end annotation


# instance fields
.field private final hypermediaServiceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/ConsumablesHypermediaService;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/ConsumablesHypermediaService;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 12
    .local p1, "hypermediaServiceCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/ConsumablesHypermediaService;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput-object p1, p0, Lcom/xfinity/playerlib/model/etc/DibicMovieUriProvider;->hypermediaServiceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 14
    return-void
.end method


# virtual methods
.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 9
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/etc/DibicMovieUriProvider;->get()Ljava/net/URI;

    move-result-object v0

    return-object v0
.end method

.method public get()Ljava/net/URI;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/xfinity/playerlib/model/etc/DibicMovieUriProvider;->hypermediaServiceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/ConsumablesHypermediaService;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/ConsumablesHypermediaService;->getDibicMoviesUri()Ljava/net/URI;

    move-result-object v0

    return-object v0
.end method
