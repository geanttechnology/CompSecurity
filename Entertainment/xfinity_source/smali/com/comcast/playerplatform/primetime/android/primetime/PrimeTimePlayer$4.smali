.class Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;
.super Ljava/lang/Object;
.source "PrimeTimePlayer.java"

# interfaces
.implements Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)V
    .locals 0

    .prologue
    .line 994
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onBufferComplete()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 1004
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playerMetrics:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$500(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->isIslatencyComplete()Z

    move-result v0

    if-nez v0, :cond_0

    .line 1005
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playerMetrics:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$500(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;

    move-result-object v0

    invoke-static {}, Lcom/comcast/playerplatform/util/android/TimeUtil;->getClockMonoTonicMillis()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->setPlaybackLatencyEnd(J)V

    .line 1006
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playerMetrics:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$500(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->setIslatencyComplete(Z)V

    .line 1009
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->isAudioRetry:Z
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1800(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1010
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # setter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->isAudioRetry:Z
    invoke-static {v0, v4}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1802(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;Z)Z

    .line 1013
    :cond_1
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # invokes: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->setViewColor(I)V
    invoke-static {v0, v4}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1900(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;I)V

    .line 1015
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 1016
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->onBufferComplete()V

    .line 1018
    :cond_2
    return-void
.end method

.method public onBufferStart()V
    .locals 1

    .prologue
    .line 997
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 998
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->onBufferStart()V

    .line 1000
    :cond_0
    return-void
.end method

.method public onLoadInfo(Lcom/adobe/mediacore/qos/LoadInfo;)V
    .locals 2
    .param p1, "loadInfo"    # Lcom/adobe/mediacore/qos/LoadInfo;

    .prologue
    .line 1036
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4$1;

    invoke-direct {v1, p0, p1}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4$1;-><init>(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;Lcom/adobe/mediacore/qos/LoadInfo;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeRunnable(Ljava/lang/Runnable;)V

    .line 1054
    return-void
.end method

.method public onOperationFailed(Lcom/adobe/mediacore/MediaPlayerNotification$Warning;)V
    .locals 1
    .param p1, "warning"    # Lcom/adobe/mediacore/MediaPlayerNotification$Warning;

    .prologue
    .line 1058
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # invokes: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->handlePlayerNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V
    invoke-static {v0, p1}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1500(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;Lcom/adobe/mediacore/MediaPlayerNotification;)V

    .line 1059
    return-void
.end method

.method public onSeekComplete(J)V
    .locals 1
    .param p1, "l"    # J

    .prologue
    .line 1029
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1030
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->onSeekComplete(J)V

    .line 1032
    :cond_0
    return-void
.end method

.method public onSeekStart()V
    .locals 1

    .prologue
    .line 1022
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1023
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->onSeekStart()V

    .line 1025
    :cond_0
    return-void
.end method
