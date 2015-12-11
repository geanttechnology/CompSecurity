.class Lcom/comcast/cim/container/PlayerContainer$5;
.super Ljava/lang/Object;
.source "PlayerContainer.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/container/PlayerContainer;->getMovieCacheMap()Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
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
        "Lcom/xfinity/playerlib/model/MerlinId;",
        "Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;",
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
    .line 651
    iput-object p1, p0, Lcom/comcast/cim/container/PlayerContainer$5;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 7
    .param p1, "key"    # Lcom/xfinity/playerlib/model/MerlinId;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            ")",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;",
            ">;"
        }
    .end annotation

    .prologue
    .line 654
    new-instance v0, Lcom/xfinity/playerlib/model/HalMovieConsumableCache;

    new-instance v1, Lcom/comcast/cim/model/hal/HalMovieFactory;

    invoke-direct {v1}, Lcom/comcast/cim/model/hal/HalMovieFactory;-><init>()V

    iget-object v2, p0, Lcom/comcast/cim/container/PlayerContainer$5;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-virtual {v2}, Lcom/comcast/cim/container/PlayerContainer;->getHalHttpClient()Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/container/PlayerContainer$5;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-virtual {v3}, Lcom/comcast/cim/container/PlayerContainer;->getDefaultRevalidationPolicy()Lcom/comcast/cim/cmasl/taskexecutor/policy/MinimumIntervalRevalidationPolicy;

    move-result-object v3

    iget-object v4, p0, Lcom/comcast/cim/container/PlayerContainer$5;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-virtual {v4}, Lcom/comcast/cim/container/PlayerContainer;->getConsumablesHypermediaServicesCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v4

    iget-object v5, p0, Lcom/comcast/cim/container/PlayerContainer$5;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-virtual {v5}, Lcom/comcast/cim/container/PlayerContainer;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v5

    move-object v6, p1

    invoke-direct/range {v0 .. v6}, Lcom/xfinity/playerlib/model/HalMovieConsumableCache;-><init>(Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;Lcom/xfinity/playerlib/model/MerlinId;)V

    return-object v0
.end method

.method public bridge synthetic get(Ljava/lang/Object;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 1

    .prologue
    .line 651
    check-cast p1, Lcom/xfinity/playerlib/model/MerlinId;

    invoke-virtual {p0, p1}, Lcom/comcast/cim/container/PlayerContainer$5;->get(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    return-object v0
.end method
