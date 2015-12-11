.class Lcom/adobe/mediacore/DefaultMediaPlayer$6;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/ItemUpdatedListener;


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

    iput-object p1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$6;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onUpdated()V
    .locals 3

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$6;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_currentStatus:Lcom/adobe/mediacore/MediaPlayer$PlayerState;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1700(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->ERROR:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$6;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

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

    const-string v2, "#onPlayerItemRefreshed"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Ignore event as media player is in ERROR state."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$6;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_currentStatus:Lcom/adobe/mediacore/MediaPlayer$PlayerState;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1700(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->INITIALIZED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    if-eq v0, v1, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$6;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_currentStatus:Lcom/adobe/mediacore/MediaPlayer$PlayerState;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1700(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->INITIALIZING:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    if-eq v0, v1, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$6;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_currentStatus:Lcom/adobe/mediacore/MediaPlayer$PlayerState;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1700(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PREPARING:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    if-ne v0, v1, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$6;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_cuesResolved:Z
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$2000(Lcom/adobe/mediacore/DefaultMediaPlayer;)Z

    move-result v0

    if-nez v0, :cond_2

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$6;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

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

    const-string v2, "#onPlayerItemRefreshed"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Ignore event as media player is in PREPARING state."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$6;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

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

    const-string v2, "#onPlayerItemRefreshed"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Media player item refreshed."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$6;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # invokes: Lcom/adobe/mediacore/DefaultMediaPlayer;->resolveCues()V
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$2100(Lcom/adobe/mediacore/DefaultMediaPlayer;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$6;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$100(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->UPDATED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_0
.end method
