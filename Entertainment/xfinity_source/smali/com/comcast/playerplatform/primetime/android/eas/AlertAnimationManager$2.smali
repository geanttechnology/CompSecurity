.class Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$2;
.super Ljava/lang/Object;
.source "AlertAnimationManager.java"

# interfaces
.implements Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->startAlertContent()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)V
    .locals 0

    .prologue
    .line 99
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$2;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPlayComplete()V
    .locals 3

    .prologue
    .line 131
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$2;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->currentAlert:Lcom/comcast/playerplatform/primetime/android/eas/Alert;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$200(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/comcast/playerplatform/primetime/android/eas/Alert;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->getIdentifier()Ljava/lang/String;

    move-result-object v0

    .line 133
    .local v0, "completedAlertId":Ljava/lang/String;
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$2;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$100(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 134
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$2;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$100(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v0, v2}, Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;->emergencyAlertCompleted(Ljava/lang/String;Z)V

    .line 136
    :cond_0
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$2;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # invokes: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->checkForNextAlert()V
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$300(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)V

    .line 137
    return-void
.end method

.method public onPlayStart()V
    .locals 0

    .prologue
    .line 127
    return-void
.end method

.method public onPrepared()V
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$2;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertPlayer:Lcom/adobe/mediacore/MediaPlayer;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$400(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/adobe/mediacore/MediaPlayer;

    move-result-object v0

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->play()V

    .line 103
    return-void
.end method

.method public onProfileChanged(JJ)V
    .locals 0
    .param p1, "l"    # J
    .param p3, "l1"    # J

    .prologue
    .line 159
    return-void
.end method

.method public onRatePlaying(F)V
    .locals 0
    .param p1, "v"    # F

    .prologue
    .line 169
    return-void
.end method

.method public onRateSelected(F)V
    .locals 0
    .param p1, "v"    # F

    .prologue
    .line 164
    return-void
.end method

.method public onReplaceMediaPlayerItem()V
    .locals 0

    .prologue
    .line 113
    return-void
.end method

.method public onSizeAvailable(JJ)V
    .locals 0
    .param p1, "l"    # J
    .param p3, "l1"    # J

    .prologue
    .line 154
    return-void
.end method

.method public onStateChanged(Lcom/adobe/mediacore/MediaPlayer$PlayerState;Lcom/adobe/mediacore/MediaPlayerNotification;)V
    .locals 5
    .param p1, "playerState"    # Lcom/adobe/mediacore/MediaPlayer$PlayerState;
    .param p2, "mediaPlayerNotification"    # Lcom/adobe/mediacore/MediaPlayerNotification;

    .prologue
    .line 141
    sget-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->INITIALIZED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-virtual {p1, v0}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 142
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$2;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertPlayer:Lcom/adobe/mediacore/MediaPlayer;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$400(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/adobe/mediacore/MediaPlayer;

    move-result-object v0

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->prepareToPlay()V

    .line 145
    :cond_0
    sget-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->ERROR:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-virtual {p1, v0}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 146
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$2;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$100(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$2;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->currentAlert:Lcom/comcast/playerplatform/primetime/android/eas/Alert;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$200(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/comcast/playerplatform/primetime/android/eas/Alert;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->getIdentifier()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2}, Lcom/adobe/mediacore/MediaPlayerNotification;->getCode()Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;

    move-result-object v2

    invoke-interface {v2}, Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;->getCode()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p2}, Lcom/adobe/mediacore/MediaPlayerNotification;->getDescription()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;->emergencyAlertFailed(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 147
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$2;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    # invokes: Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->checkForNextAlert()V
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->access$300(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)V

    .line 149
    :cond_1
    return-void
.end method

.method public onTimedMetadata(Lcom/adobe/mediacore/metadata/TimedMetadata;)V
    .locals 0
    .param p1, "timedMetadata"    # Lcom/adobe/mediacore/metadata/TimedMetadata;

    .prologue
    .line 118
    return-void
.end method

.method public onTimelineUpdated()V
    .locals 0

    .prologue
    .line 123
    return-void
.end method

.method public onUpdated()V
    .locals 0

    .prologue
    .line 108
    return-void
.end method
