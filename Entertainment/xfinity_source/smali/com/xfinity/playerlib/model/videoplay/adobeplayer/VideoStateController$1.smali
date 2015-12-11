.class Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1;
.super Ljava/lang/Object;
.source "VideoStateController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->scheduleAmsContinueCalls()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .prologue
    .line 631
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private callOnAMSContinueException(Ljava/lang/Exception;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 686
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->uiThreadExecutor:Ljava/util/concurrent/Executor;
    invoke-static {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$300(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Ljava/util/concurrent/Executor;

    move-result-object v0

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1$1;

    invoke-direct {v1, p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1$1;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1;Ljava/lang/Exception;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 692
    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    .line 635
    :try_start_0
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoAuthManager:Lcom/xfinity/playerlib/authorization/VideoAuthManager;
    invoke-static {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$000(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/authorization/VideoAuthManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->sendVideoContinueHeartbeat()V
    :try_end_0
    .catch Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 683
    :goto_0
    return-void

    .line 636
    :catch_0
    move-exception v1

    .line 637
    .local v1, "e":Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;
    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$100()Lorg/slf4j/Logger;

    move-result-object v2

    const-string v3, "Caught exception during AMS continue call"

    invoke-interface {v2, v3, v1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 646
    sget-object v2, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$2;->$SwitchMap$com$comcast$cim$cmasl$xip$ams$AmsHttpErrorException$PlayerAction:[I

    invoke-static {v1}, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;->getPlayerActionForException(Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;)Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;

    move-result-object v3

    invoke-virtual {v3}, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 659
    invoke-direct {p0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1;->callOnAMSContinueException(Ljava/lang/Exception;)V

    goto :goto_0

    .line 648
    :pswitch_0
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->amsErrorCount:Ljava/util/concurrent/atomic/AtomicInteger;
    invoke-static {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$200(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Ljava/util/concurrent/atomic/AtomicInteger;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicInteger;->incrementAndGet()I

    move-result v0

    .line 649
    .local v0, "currentAmsErrorCount":I
    if-le v0, v5, :cond_0

    .line 650
    invoke-direct {p0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1;->callOnAMSContinueException(Ljava/lang/Exception;)V

    goto :goto_0

    .line 652
    :cond_0
    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$100()Lorg/slf4j/Logger;

    move-result-object v2

    const-string v3, "Error count {} is within threshold {}, continuing"

    iget-object v4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 654
    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->amsErrorCount:Ljava/util/concurrent/atomic/AtomicInteger;
    invoke-static {v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$200(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Ljava/util/concurrent/atomic/AtomicInteger;

    move-result-object v4

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    .line 652
    invoke-interface {v2, v3, v4, v5}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_0

    .line 662
    .end local v0    # "currentAmsErrorCount":I
    .end local v1    # "e":Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;
    :catch_1
    move-exception v1

    .line 663
    .local v1, "e":Ljava/lang/Exception;
    instance-of v2, v1, Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;

    if-eqz v2, :cond_1

    move-object v2, v1

    check-cast v2, Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;

    .line 664
    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;->getDetailedStatusCode()I

    move-result v2

    const/16 v3, 0xbb9

    if-ne v2, v3, :cond_1

    .line 665
    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$100()Lorg/slf4j/Logger;

    move-result-object v2

    const-string v3, "XipNotProvisioned captured in continue auth, signout and quit video"

    invoke-interface {v2, v3, v1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 672
    invoke-direct {p0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1;->callOnAMSContinueException(Ljava/lang/Exception;)V

    goto :goto_0

    .line 674
    :cond_1
    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->access$100()Lorg/slf4j/Logger;

    move-result-object v2

    const-string v3, "AMS continue call caught exception...ignore"

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;)V

    goto :goto_0

    .line 646
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method
