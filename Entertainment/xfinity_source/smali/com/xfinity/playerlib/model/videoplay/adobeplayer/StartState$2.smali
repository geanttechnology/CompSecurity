.class Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$2;
.super Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;
.source "StartState.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->fetchMovie(Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/Long;)V
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


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Ljava/lang/Long;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;
    .param p3, "companyId"    # Ljava/lang/Long;

    .prologue
    .line 208
    .local p2, "taskExecutor":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;>;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$2;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;

    invoke-direct {p0, p1, p2, p3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Ljava/lang/Long;)V

    return-void
.end method


# virtual methods
.method protected createWatchable(Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;)Lcom/xfinity/playerlib/model/consumable/Watchable;
    .locals 1
    .param p1, "entity"    # Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    .prologue
    .line 210
    new-instance v0, Lcom/xfinity/playerlib/model/consumable/MovieFacade;

    invoke-direct {v0, p1}, Lcom/xfinity/playerlib/model/consumable/MovieFacade;-><init>(Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;)V

    return-object v0
.end method

.method protected bridge synthetic createWatchable(Ljava/lang/Object;)Lcom/xfinity/playerlib/model/consumable/Watchable;
    .locals 1

    .prologue
    .line 208
    check-cast p1, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$2;->createWatchable(Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;)Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v0

    return-object v0
.end method
