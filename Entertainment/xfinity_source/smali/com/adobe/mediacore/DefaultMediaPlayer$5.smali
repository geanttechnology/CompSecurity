.class Lcom/adobe/mediacore/DefaultMediaPlayer$5;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/ItemCreatedListener;


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

    iput-object p1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$5;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreated()V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$5;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_currentStatus:Lcom/adobe/mediacore/MediaPlayer$PlayerState;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1700(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->ERROR:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    if-ne v0, v1, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$5;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

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

    const-string v2, "#onPlayerItemAvailable"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Ignore event as media player is in ERROR state."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$5;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

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

    const-string v2, "#onPlayerItemAvailable"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Media player item available."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$5;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$5;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;
    invoke-static {v1}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$200(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/VideoEngineAdapter;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->getCurrentItem()Lcom/adobe/mediacore/VideoEngineItem;

    move-result-object v1

    # setter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_item:Lcom/adobe/mediacore/MediaPlayerItem;
    invoke-static {v0, v1}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$302(Lcom/adobe/mediacore/DefaultMediaPlayer;Lcom/adobe/mediacore/MediaPlayerItem;)Lcom/adobe/mediacore/MediaPlayerItem;

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$5;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_item:Lcom/adobe/mediacore/MediaPlayerItem;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$300(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v0

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayerItem;->isLive()Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$5;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_item:Lcom/adobe/mediacore/MediaPlayerItem;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$300(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v0

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayerItem;->getResource()Lcom/adobe/mediacore/MediaResource;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaResource;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$5;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_item:Lcom/adobe/mediacore/MediaPlayerItem;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$300(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v0

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayerItem;->getResource()Lcom/adobe/mediacore/MediaResource;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaResource;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->CUSTOM_AD_MARKERS_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/adobe/mediacore/metadata/Metadata;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$5;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

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

    const-string v2, "#onPlayerItemAvailable"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Cannot place custom ad-markers on LIVE content."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->RESOURCE_LOAD_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "Resource loading failed due to invalid media-resource metadata."

    invoke-static {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v1}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v2, "DESCRIPTION"

    const-string v3, "Cannot place custom ad-markers on LIVE content."

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$5;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v1}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$100(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v1

    invoke-static {v0}, Lcom/adobe/mediacore/ErrorEvent;->createVideoErrorEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Lcom/adobe/mediacore/ErrorEvent;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_0

    :cond_2
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$5;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->INITIALIZED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/DefaultMediaPlayer;->setStatus(Lcom/adobe/mediacore/MediaPlayer$PlayerState;Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$5;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_preparePending:Z
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1800(Lcom/adobe/mediacore/DefaultMediaPlayer;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$5;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$5;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_startPosition:J
    invoke-static {v1}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1900(Lcom/adobe/mediacore/DefaultMediaPlayer;)J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/adobe/mediacore/DefaultMediaPlayer;->prepareToPlay(J)V

    goto/16 :goto_0
.end method
