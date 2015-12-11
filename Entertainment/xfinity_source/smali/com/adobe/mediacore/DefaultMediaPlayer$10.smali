.class Lcom/adobe/mediacore/DefaultMediaPlayer$10;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/AudioTrackFailedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mediacore/DefaultMediaPlayer;-><init>(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;


# direct methods
.method constructor <init>(Lcom/adobe/mediacore/DefaultMediaPlayer;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$10;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFailed(Lcom/adobe/mediacore/info/AudioTrack;Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$10;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1600(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1400()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "::AudioTrackFailedListener#onFailed"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Audio track failed: ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->PLAYBACK_OPERATION_FAIL:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    const-string v1, "Failed to load audio track. Please select another track."

    invoke-static {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification;->createWarningNotification(Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Warning;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/adobe/mediacore/MediaPlayerNotification$Warning;->setInnerNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$10;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v1}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$100(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v1

    invoke-static {v0}, Lcom/adobe/mediacore/OperationFailedEvent;->createEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Warning;)Lcom/adobe/mediacore/OperationFailedEvent;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    return-void
.end method
