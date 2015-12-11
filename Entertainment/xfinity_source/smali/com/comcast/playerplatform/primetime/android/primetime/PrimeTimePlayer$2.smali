.class Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;
.super Ljava/lang/Object;
.source "PrimeTimePlayer.java"

# interfaces
.implements Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;


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
    .line 708
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPlayComplete()V
    .locals 1

    .prologue
    .line 770
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 771
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->mediaEnded()V

    .line 773
    :cond_0
    return-void
.end method

.method public onPlayStart()V
    .locals 2

    .prologue
    .line 762
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    const/4 v1, 0x0

    # setter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->retryCount:I
    invoke-static {v0, v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1102(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;I)I

    .line 763
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 764
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->onPlayStarted()V

    .line 766
    :cond_0
    return-void
.end method

.method public onPrepared()V
    .locals 10

    .prologue
    .line 711
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playerMetrics:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;
    invoke-static {v5}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$500(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;

    move-result-object v5

    iget-object v6, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->qosProvider:Lcom/adobe/mediacore/qos/QOSProvider;
    invoke-static {v6}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$400(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/adobe/mediacore/qos/QOSProvider;

    move-result-object v6

    invoke-virtual {v6}, Lcom/adobe/mediacore/qos/QOSProvider;->getPlaybackInformation()Lcom/adobe/mediacore/qos/PlaybackInformation;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->setPlaybackInformation(Lcom/adobe/mediacore/qos/PlaybackInformation;)V

    .line 713
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;
    invoke-static {v5}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/adobe/mediacore/MediaPlayer;

    move-result-object v5

    invoke-interface {v5}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v5

    invoke-interface {v5}, Lcom/adobe/mediacore/MediaPlayerItem;->isLive()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 714
    new-instance v1, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;

    invoke-direct {v1}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;-><init>()V

    .line 715
    .local v1, "helper":Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;
    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getLinearBuffer()Ljava/lang/String;

    move-result-object v4

    .line 716
    .local v4, "liveBufferString":Ljava/lang/String;
    invoke-static {v4}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    .end local v4    # "liveBufferString":Ljava/lang/String;
    :goto_0
    invoke-static {v4}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    .line 717
    .local v2, "liveBuffer":J
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;
    invoke-static {v5}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/adobe/mediacore/MediaPlayer;

    move-result-object v5

    iget-object v6, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->initialBuffer:J
    invoke-static {v6}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$600(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)J

    move-result-wide v6

    invoke-static {v6, v7, v2, v3}, Lcom/adobe/mediacore/BufferControlParameters;->createDual(JJ)Lcom/adobe/mediacore/BufferControlParameters;

    move-result-object v6

    invoke-interface {v5, v6}, Lcom/adobe/mediacore/MediaPlayer;->setBufferControlParameters(Lcom/adobe/mediacore/BufferControlParameters;)V

    .line 723
    .end local v1    # "helper":Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;
    .end local v2    # "liveBuffer":J
    :goto_1
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;
    invoke-static {v5}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/adobe/mediacore/MediaPlayer;

    move-result-object v5

    invoke-interface {v5}, Lcom/adobe/mediacore/MediaPlayer;->prepareBuffer()V

    .line 725
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    invoke-virtual {v5}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->getAdManager()Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    move-result-object v0

    .line 726
    .local v0, "adManager":Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
    if-eqz v0, :cond_1

    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;
    invoke-static {v5}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$800(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    move-result-object v5

    invoke-virtual {v5}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getAdType()Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    move-result-object v5

    sget-object v6, Lcom/comcast/playerplatform/primetime/android/enums/AdType;->C3:Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    if-eq v5, v6, :cond_0

    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;
    invoke-static {v5}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$800(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    move-result-object v5

    invoke-virtual {v5}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getAdType()Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    move-result-object v5

    sget-object v6, Lcom/comcast/playerplatform/primetime/android/enums/AdType;->MANIFEST_MANIPULATOR:Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    if-ne v5, v6, :cond_1

    .line 727
    :cond_0
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    invoke-virtual {v5}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->getCurrentPosition()J

    move-result-wide v6

    invoke-virtual {v0, v6, v7}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->setResumePosition(J)V

    .line 729
    :cond_1
    return-void

    .line 716
    .end local v0    # "adManager":Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
    .restart local v1    # "helper":Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;
    .restart local v4    # "liveBufferString":Ljava/lang/String;
    :cond_2
    const-string v4, "0"

    goto :goto_0

    .line 720
    .end local v1    # "helper":Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;
    .end local v4    # "liveBufferString":Ljava/lang/String;
    :cond_3
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;
    invoke-static {v5}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/adobe/mediacore/MediaPlayer;

    move-result-object v5

    iget-object v6, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->initialBuffer:J
    invoke-static {v6}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$600(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)J

    move-result-wide v6

    iget-object v8, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playbackBuffer:J
    invoke-static {v8}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$700(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)J

    move-result-wide v8

    invoke-static {v6, v7, v8, v9}, Lcom/adobe/mediacore/BufferControlParameters;->createDual(JJ)Lcom/adobe/mediacore/BufferControlParameters;

    move-result-object v6

    invoke-interface {v5, v6}, Lcom/adobe/mediacore/MediaPlayer;->setBufferControlParameters(Lcom/adobe/mediacore/BufferControlParameters;)V

    goto :goto_1
.end method

.method public onProfileChanged(JJ)V
    .locals 0
    .param p1, "l"    # J
    .param p3, "l2"    # J

    .prologue
    .line 734
    return-void
.end method

.method public onRatePlaying(F)V
    .locals 0
    .param p1, "v"    # F

    .prologue
    .line 839
    return-void
.end method

.method public onRateSelected(F)V
    .locals 1
    .param p1, "v"    # F

    .prologue
    .line 831
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 832
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->playbackSpeedChanged(F)V

    .line 834
    :cond_0
    return-void
.end method

.method public onReplaceMediaPlayerItem()V
    .locals 0

    .prologue
    .line 744
    return-void
.end method

.method public onSizeAvailable(JJ)V
    .locals 3
    .param p1, "height"    # J
    .param p3, "width"    # J

    .prologue
    .line 808
    move-wide v0, p1

    .line 827
    .local v0, "newHeight":J
    return-void
.end method

.method public onStateChanged(Lcom/adobe/mediacore/MediaPlayer$PlayerState;Lcom/adobe/mediacore/MediaPlayerNotification;)V
    .locals 4
    .param p1, "playerState"    # Lcom/adobe/mediacore/MediaPlayer$PlayerState;
    .param p2, "mediaPlayerNotification"    # Lcom/adobe/mediacore/MediaPlayerNotification;

    .prologue
    .line 777
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$200(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    move-result-object v0

    const-string v1, "com.comcast.playerplatform.primetime::primetimeplayer"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "onStateChanged Event:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 779
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 780
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->name()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->valueOf(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->playStateChanged(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V

    .line 783
    :cond_0
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$9;->$SwitchMap$com$adobe$mediacore$MediaPlayer$PlayerState:[I

    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 804
    :goto_0
    return-void

    .line 785
    :pswitch_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/adobe/mediacore/MediaPlayer;

    move-result-object v0

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->getSeekableRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->startPosition:J
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1200(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/adobe/mediacore/utils/TimeRange;->contains(J)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 786
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/adobe/mediacore/MediaPlayer;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->startPosition:J
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1200(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)J

    move-result-wide v2

    invoke-interface {v0, v2, v3}, Lcom/adobe/mediacore/MediaPlayer;->prepareToPlay(J)V

    goto :goto_0

    .line 789
    :cond_1
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/adobe/mediacore/MediaPlayer;

    move-result-object v0

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->prepareToPlay()V

    goto :goto_0

    .line 794
    :pswitch_1
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # invokes: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->updateAbrControlParameters()V
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1300(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)V

    goto :goto_0

    .line 798
    :pswitch_2
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # invokes: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->setClosedCaptionSettings()V
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1400(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)V

    goto :goto_0

    .line 801
    :pswitch_3
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # invokes: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->handlePlayerNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V
    invoke-static {v0, p2}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1500(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;Lcom/adobe/mediacore/MediaPlayerNotification;)V

    goto :goto_0

    .line 783
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public onTimedMetadata(Lcom/adobe/mediacore/metadata/TimedMetadata;)V
    .locals 1
    .param p1, "timedMetadata"    # Lcom/adobe/mediacore/metadata/TimedMetadata;

    .prologue
    .line 748
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$900(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 749
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$900(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->onTimedMetadata(Lcom/adobe/mediacore/metadata/TimedMetadata;)V

    .line 751
    :cond_0
    return-void
.end method

.method public onTimelineUpdated()V
    .locals 1

    .prologue
    .line 755
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 756
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->onTimelineUpdated()V

    .line 758
    :cond_0
    return-void
.end method

.method public onUpdated()V
    .locals 3

    .prologue
    .line 738
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$200(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    move-result-object v0

    const-string v1, "onUpdated"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 739
    return-void
.end method
