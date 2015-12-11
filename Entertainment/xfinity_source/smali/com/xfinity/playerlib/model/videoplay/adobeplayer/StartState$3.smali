.class Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$3;
.super Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;
.source "StartState.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->fetchMovie(Lcom/xfinity/playerlib/model/consumable/WatchableKey;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener",
        "<",
        "Lcom/comcast/cim/cmasl/utils/container/Tuple",
        "<",
        "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
        "Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;",
        ">;",
        "Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;

.field final synthetic val$watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Lcom/xfinity/playerlib/model/consumable/WatchableKey;Lcom/xfinity/playerlib/model/consumable/WatchableKey;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;
    .param p3, "watchableKey"    # Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    .prologue
    .line 222
    .local p2, "taskExecutor":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;>;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$3;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;

    iput-object p4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$3;->val$watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    invoke-direct {p0, p1, p2, p3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Lcom/xfinity/playerlib/model/consumable/WatchableKey;)V

    return-void
.end method


# virtual methods
.method protected createWatchable(Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;)Lcom/xfinity/playerlib/model/consumable/Watchable;
    .locals 3
    .param p1, "entity"    # Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    .prologue
    .line 224
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$3;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;

    iget-object v0, v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getWatchableCodec()Lcom/xfinity/playerlib/model/consumable/WatchableCodec;

    move-result-object v0

    new-instance v1, Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$3;->val$watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    invoke-direct {v1, v2, p1}, Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;-><init>(Lcom/xfinity/playerlib/model/consumable/WatchableKey;Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/consumable/WatchableCodec;->decode(Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;)Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v0

    return-object v0
.end method

.method protected bridge synthetic createWatchable(Ljava/lang/Object;)Lcom/xfinity/playerlib/model/consumable/Watchable;
    .locals 1

    .prologue
    .line 222
    check-cast p1, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$3;->createWatchable(Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;)Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v0

    return-object v0
.end method
