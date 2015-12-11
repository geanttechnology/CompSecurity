.class Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;
.super Ljava/lang/Object;
.source "AuthenticatingState.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->performAMSAuthentication(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;

.field final synthetic val$pin:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;Ljava/lang/String;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;

    .prologue
    .line 118
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;

    iput-object p2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;->val$pin:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private callOnAmsAuthenticationException(Ljava/lang/Exception;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 163
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;

    iget-object v0, v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiThreadExecutor()Ljava/util/concurrent/Executor;

    move-result-object v0

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1$3;

    invoke-direct {v1, p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1$3;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;Ljava/lang/Exception;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 169
    return-void
.end method

.method private callOnAmsAuthenticationSuccess()V
    .locals 2

    .prologue
    .line 145
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;

    iget-object v0, v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiThreadExecutor()Ljava/util/concurrent/Executor;

    move-result-object v0

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1$1;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1$1;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 151
    return-void
.end method

.method private callOnAmsPinRequired()V
    .locals 2

    .prologue
    .line 154
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;

    iget-object v0, v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiThreadExecutor()Ljava/util/concurrent/Executor;

    move-result-object v0

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1$2;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1$2;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 160
    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 122
    :try_start_0
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;

    iget-object v3, v3, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->shouldUseDownloadFile()Z

    move-result v3

    if-nez v3, :cond_1

    .line 123
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;

    iget-object v3, v3, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    iget-object v4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;->val$pin:Ljava/lang/String;

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->performAmsAuthorization(Ljava/lang/String;)V

    .line 134
    :cond_0
    :goto_0
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;->callOnAmsAuthenticationSuccess()V

    .line 142
    :goto_1
    return-void

    .line 124
    :cond_1
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;

    iget-object v3, v3, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLiveStream()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v3

    if-nez v3, :cond_0

    .line 126
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;

    iget-object v3, v3, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getParentalControlsCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v3

    invoke-interface {v3}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;

    .line 127
    .local v1, "pcSettings":Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;
    if-eqz v1, :cond_0

    .line 128
    invoke-virtual {v1}, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->getParentalPin()Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;

    move-result-object v2

    .line 129
    .local v2, "savedPin":Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;
    if-eqz v2, :cond_0

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;

    iget-object v4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;

    iget-object v4, v4, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoFacade()Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v4

    # invokes: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->pinRequiredForVideo(Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Z
    invoke-static {v3, v1, v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->access$000(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Z

    move-result v3

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;->val$pin:Ljava/lang/String;

    if-eqz v3, :cond_2

    invoke-virtual {v2}, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;->getPin()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;->val$pin:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 130
    :cond_2
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;->callOnAmsPinRequired()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 135
    .end local v1    # "pcSettings":Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;
    .end local v2    # "savedPin":Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;
    :catch_0
    move-exception v0

    .line 136
    .local v0, "e":Ljava/lang/Exception;
    instance-of v3, v0, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;

    if-eqz v3, :cond_3

    move-object v3, v0

    check-cast v3, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;

    invoke-virtual {v3}, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;->getDetailedStatusCode()I

    move-result v3

    const/16 v4, 0x1a1

    if-ne v3, v4, :cond_3

    .line 137
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;->callOnAmsPinRequired()V

    goto :goto_1

    .line 139
    :cond_3
    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;->callOnAmsAuthenticationException(Ljava/lang/Exception;)V

    goto :goto_1
.end method
