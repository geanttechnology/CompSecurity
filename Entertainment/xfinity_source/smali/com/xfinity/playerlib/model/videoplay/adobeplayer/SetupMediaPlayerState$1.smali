.class Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState$1;
.super Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;
.source "SetupMediaPlayerState.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;

    .prologue
    .line 15
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;

    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;-><init>()V

    return-void
.end method


# virtual methods
.method public configurationFailed(Ljava/lang/String;)V
    .locals 1
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    .line 24
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;->configurationFailed(Ljava/lang/String;)V

    .line 25
    new-instance v0, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    invoke-direct {v0, p1}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public configurationLoaded()V
    .locals 1

    .prologue
    .line 18
    invoke-super {p0}, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;->configurationLoaded()V

    .line 19
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;

    iget-object v0, v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onConfigurationLoaded()V

    .line 20
    return-void
.end method
