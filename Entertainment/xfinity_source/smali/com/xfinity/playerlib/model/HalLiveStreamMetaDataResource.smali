.class public Lcom/xfinity/playerlib/model/HalLiveStreamMetaDataResource;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleTask;
.source "HalLiveStreamMetaDataResource.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleTask",
        "<",
        "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;",
        ">;"
    }
.end annotation


# instance fields
.field private final entityFactory:Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory",
            "<TT;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;",
            ">;"
        }
    .end annotation
.end field

.field private final halHttpClient:Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/hal/http/HalHttpClient",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;"
        }
    .end annotation
.end field

.field private final streamName:Ljava/lang/String;

.field private final tveHypermediaServicesCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/TveHypermediaService;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;Ljava/lang/String;)V
    .locals 0
    .param p4, "streamName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/TveHypermediaService;",
            ">;",
            "Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory",
            "<TT;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;",
            ">;",
            "Lcom/comcast/cim/cmasl/hal/http/HalHttpClient",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 17
    .local p0, "this":Lcom/xfinity/playerlib/model/HalLiveStreamMetaDataResource;, "Lcom/xfinity/playerlib/model/HalLiveStreamMetaDataResource<TT;>;"
    .local p1, "tveHypermediaServicesCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/TveHypermediaService;>;"
    .local p2, "entityFactory":Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;, "Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory<TT;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;>;"
    .local p3, "halHttpClient":Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;, "Lcom/comcast/cim/cmasl/hal/http/HalHttpClient<TT;Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/SimpleTask;-><init>()V

    .line 18
    iput-object p1, p0, Lcom/xfinity/playerlib/model/HalLiveStreamMetaDataResource;->tveHypermediaServicesCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 19
    iput-object p2, p0, Lcom/xfinity/playerlib/model/HalLiveStreamMetaDataResource;->entityFactory:Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;

    .line 20
    iput-object p3, p0, Lcom/xfinity/playerlib/model/HalLiveStreamMetaDataResource;->halHttpClient:Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;

    .line 21
    iput-object p4, p0, Lcom/xfinity/playerlib/model/HalLiveStreamMetaDataResource;->streamName:Ljava/lang/String;

    .line 22
    return-void
.end method


# virtual methods
.method public execute()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    .locals 3

    .prologue
    .line 26
    .local p0, "this":Lcom/xfinity/playerlib/model/HalLiveStreamMetaDataResource;, "Lcom/xfinity/playerlib/model/HalLiveStreamMetaDataResource<TT;>;"
    iget-object v1, p0, Lcom/xfinity/playerlib/model/HalLiveStreamMetaDataResource;->entityFactory:Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;

    iget-object v0, p0, Lcom/xfinity/playerlib/model/HalLiveStreamMetaDataResource;->tveHypermediaServicesCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/TveHypermediaService;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/HalLiveStreamMetaDataResource;->streamName:Ljava/lang/String;

    invoke-virtual {v0, v2}, Lcom/xfinity/playerlib/model/TveHypermediaService;->getStreamMetadataUri(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v0

    invoke-virtual {v0}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/xfinity/playerlib/model/HalLiveStreamMetaDataResource;->halHttpClient:Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;

    invoke-virtual {v1, v0, v2}, Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;->createWithUrl(Ljava/lang/String;Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;)Lcom/comcast/cim/cmasl/hal/model/HalParseable;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    return-object v0
.end method

.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 10
    .local p0, "this":Lcom/xfinity/playerlib/model/HalLiveStreamMetaDataResource;, "Lcom/xfinity/playerlib/model/HalLiveStreamMetaDataResource<TT;>;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/HalLiveStreamMetaDataResource;->execute()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v0

    return-object v0
.end method
