.class Lcom/comcast/cim/container/PlayerContainer$4;
.super Ljava/lang/Object;
.source "PlayerContainer.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/container/PlayerContainer;->getLiveStreamMetaDataResourceFactory()Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory",
        "<",
        "Ljava/lang/String;",
        "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;",
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
    .line 639
    iput-object p1, p0, Lcom/comcast/cim/container/PlayerContainer$4;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic get(Ljava/lang/Object;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 1

    .prologue
    .line 639
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/comcast/cim/container/PlayerContainer$4;->get(Ljava/lang/String;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    return-object v0
.end method

.method public get(Ljava/lang/String;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 4
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;",
            ">;"
        }
    .end annotation

    .prologue
    .line 642
    new-instance v0, Lcom/xfinity/playerlib/model/HalLiveStreamMetaDataResource;

    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer$4;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-virtual {v1}, Lcom/comcast/cim/container/PlayerContainer;->getTveHypermediaServicesCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v1

    new-instance v2, Lcom/comcast/cim/model/hal/HalLiveStreamFactory;

    invoke-direct {v2}, Lcom/comcast/cim/model/hal/HalLiveStreamFactory;-><init>()V

    iget-object v3, p0, Lcom/comcast/cim/container/PlayerContainer$4;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-virtual {v3}, Lcom/comcast/cim/container/PlayerContainer;->getHalHttpClient()Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3, p1}, Lcom/xfinity/playerlib/model/HalLiveStreamMetaDataResource;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;Ljava/lang/String;)V

    return-object v0
.end method
