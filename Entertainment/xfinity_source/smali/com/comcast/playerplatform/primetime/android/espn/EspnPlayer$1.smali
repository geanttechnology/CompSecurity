.class Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$1;
.super Ljava/lang/Object;
.source "EspnPlayer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->setAsset(Lcom/comcast/playerplatform/primetime/android/asset/Asset;JLcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)V
    .locals 0

    .prologue
    .line 116
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 120
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # invokes: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->isEspnReady()Z
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$000(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 121
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->playbackManager:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$200(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$100(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getDrmKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->initWithToken(Ljava/lang/String;)V

    .line 122
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$100(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getEventId()Ljava/lang/String;

    move-result-object v0

    .line 123
    .local v0, "eventId":Ljava/lang/String;
    invoke-static {v0}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 124
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->playbackManager:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$200(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->initiateStartSessionRequest(Ljava/lang/String;)V

    .line 135
    .end local v0    # "eventId":Ljava/lang/String;
    :goto_0
    return-void

    .line 125
    .restart local v0    # "eventId":Ljava/lang/String;
    :cond_0
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$100(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getChannelName()Ljava/lang/String;

    move-result-object v1

    const-string v2, "espn3"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$100(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getChannelName()Ljava/lang/String;

    move-result-object v1

    const-string v2, "secplus"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$100(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getChannelName()Ljava/lang/String;

    move-result-object v1

    const-string v2, "goalline"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 128
    :cond_1
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # invokes: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->checkForActiveChannelEvents()V
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$300(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)V

    goto :goto_0

    .line 130
    :cond_2
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->playbackManager:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$200(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->access$100(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getChannelName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->initiateLiveEventSessionForLinearNetwork(Ljava/lang/String;)V

    goto :goto_0

    .line 133
    .end local v0    # "eventId":Ljava/lang/String;
    :cond_3
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    const-string v3, "Failed to initialize playback for ESPN."

    invoke-virtual {v1, v2, v3}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->sendMediaFailed(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
