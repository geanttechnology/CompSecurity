.class Lcom/adobe/mediacore/TrickPlayManager$2;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/SeekAdjustCompletedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/TrickPlayManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mediacore/TrickPlayManager;


# direct methods
.method constructor <init>(Lcom/adobe/mediacore/TrickPlayManager;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/TrickPlayManager$2;->this$0:Lcom/adobe/mediacore/TrickPlayManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAdjustCompleted(J)V
    .locals 5

    iget-object v0, p0, Lcom/adobe/mediacore/TrickPlayManager$2;->this$0:Lcom/adobe/mediacore/TrickPlayManager;

    # getter for: Lcom/adobe/mediacore/TrickPlayManager;->_seekAdjustCompletedListener:Lcom/adobe/mediacore/SeekAdjustCompletedListener;
    invoke-static {v0}, Lcom/adobe/mediacore/TrickPlayManager;->access$200(Lcom/adobe/mediacore/TrickPlayManager;)Lcom/adobe/mediacore/SeekAdjustCompletedListener;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/TrickPlayManager$2;->this$0:Lcom/adobe/mediacore/TrickPlayManager;

    # getter for: Lcom/adobe/mediacore/TrickPlayManager;->_dispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/TrickPlayManager;->access$100(Lcom/adobe/mediacore/TrickPlayManager;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->SEEK_ADJUST_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v2, p0, Lcom/adobe/mediacore/TrickPlayManager$2;->this$0:Lcom/adobe/mediacore/TrickPlayManager;

    # getter for: Lcom/adobe/mediacore/TrickPlayManager;->_seekAdjustCompletedListener:Lcom/adobe/mediacore/SeekAdjustCompletedListener;
    invoke-static {v2}, Lcom/adobe/mediacore/TrickPlayManager;->access$200(Lcom/adobe/mediacore/TrickPlayManager;)Lcom/adobe/mediacore/SeekAdjustCompletedListener;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->removeEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/TrickPlayManager$2;->this$0:Lcom/adobe/mediacore/TrickPlayManager;

    # getter for: Lcom/adobe/mediacore/TrickPlayManager;->_engine:Lcom/adobe/mediacore/VideoEngineAdapter;
    invoke-static {v0}, Lcom/adobe/mediacore/TrickPlayManager;->access$300(Lcom/adobe/mediacore/TrickPlayManager;)Lcom/adobe/mediacore/VideoEngineAdapter;

    move-result-object v0

    const/4 v1, -0x1

    invoke-static {v1, p1, p2}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->create(IJ)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->seek(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;)V

    iget-object v0, p0, Lcom/adobe/mediacore/TrickPlayManager$2;->this$0:Lcom/adobe/mediacore/TrickPlayManager;

    # getter for: Lcom/adobe/mediacore/TrickPlayManager;->_currentPlaybackRate:F
    invoke-static {v0}, Lcom/adobe/mediacore/TrickPlayManager;->access$400(Lcom/adobe/mediacore/TrickPlayManager;)F

    move-result v0

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-nez v0, :cond_1

    # getter for: Lcom/adobe/mediacore/TrickPlayManager;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/TrickPlayManager;->access$600()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/TrickPlayManager;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/TrickPlayManager;->access$500()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#changePlaybackRate"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "returning to pause mode, position: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/TrickPlayManager$2;->this$0:Lcom/adobe/mediacore/TrickPlayManager;

    # getter for: Lcom/adobe/mediacore/TrickPlayManager;->_player:Lcom/adobe/mediacore/MediaPlayer;
    invoke-static {v0}, Lcom/adobe/mediacore/TrickPlayManager;->access$700(Lcom/adobe/mediacore/TrickPlayManager;)Lcom/adobe/mediacore/MediaPlayer;

    move-result-object v0

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->pause()V

    :goto_0
    iget-object v0, p0, Lcom/adobe/mediacore/TrickPlayManager$2;->this$0:Lcom/adobe/mediacore/TrickPlayManager;

    const/4 v1, 0x0

    # setter for: Lcom/adobe/mediacore/TrickPlayManager;->_returningFromTrickPlay:Z
    invoke-static {v0, v1}, Lcom/adobe/mediacore/TrickPlayManager;->access$002(Lcom/adobe/mediacore/TrickPlayManager;Z)Z

    iget-object v0, p0, Lcom/adobe/mediacore/TrickPlayManager$2;->this$0:Lcom/adobe/mediacore/TrickPlayManager;

    const-wide/16 v2, -0x1

    # setter for: Lcom/adobe/mediacore/TrickPlayManager;->_initialTrickPlayPosition:J
    invoke-static {v0, v2, v3}, Lcom/adobe/mediacore/TrickPlayManager;->access$902(Lcom/adobe/mediacore/TrickPlayManager;J)J

    return-void

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/TrickPlayManager$2;->this$0:Lcom/adobe/mediacore/TrickPlayManager;

    # getter for: Lcom/adobe/mediacore/TrickPlayManager;->_currentPlaybackRate:F
    invoke-static {v0}, Lcom/adobe/mediacore/TrickPlayManager;->access$400(Lcom/adobe/mediacore/TrickPlayManager;)F

    move-result v0

    const/high16 v1, 0x3f800000    # 1.0f

    cmpl-float v0, v0, v1

    if-nez v0, :cond_2

    # getter for: Lcom/adobe/mediacore/TrickPlayManager;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/TrickPlayManager;->access$600()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/TrickPlayManager;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/TrickPlayManager;->access$500()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#changePlaybackRate"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "returning to play mode, position: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/TrickPlayManager$2;->this$0:Lcom/adobe/mediacore/TrickPlayManager;

    # getter for: Lcom/adobe/mediacore/TrickPlayManager;->_player:Lcom/adobe/mediacore/MediaPlayer;
    invoke-static {v0}, Lcom/adobe/mediacore/TrickPlayManager;->access$700(Lcom/adobe/mediacore/TrickPlayManager;)Lcom/adobe/mediacore/MediaPlayer;

    move-result-object v0

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->play()V

    goto :goto_0

    :cond_2
    # getter for: Lcom/adobe/mediacore/TrickPlayManager;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/TrickPlayManager;->access$600()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/TrickPlayManager;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/TrickPlayManager;->access$500()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#changePlaybackRate"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "returning to slow motion mode, position: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/TrickPlayManager$2;->this$0:Lcom/adobe/mediacore/TrickPlayManager;

    iget-object v1, p0, Lcom/adobe/mediacore/TrickPlayManager$2;->this$0:Lcom/adobe/mediacore/TrickPlayManager;

    # getter for: Lcom/adobe/mediacore/TrickPlayManager;->_currentPlaybackRate:F
    invoke-static {v1}, Lcom/adobe/mediacore/TrickPlayManager;->access$400(Lcom/adobe/mediacore/TrickPlayManager;)F

    move-result v1

    # invokes: Lcom/adobe/mediacore/TrickPlayManager;->changeRateWithoutRemovingAds(F)V
    invoke-static {v0, v1}, Lcom/adobe/mediacore/TrickPlayManager;->access$800(Lcom/adobe/mediacore/TrickPlayManager;F)V

    goto/16 :goto_0
.end method
