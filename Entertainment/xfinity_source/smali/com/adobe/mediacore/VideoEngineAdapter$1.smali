.class Lcom/adobe/mediacore/VideoEngineAdapter$1;
.super Lcom/adobe/ave/VideoEngineListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mediacore/VideoEngineAdapter;->createEngineListener()Lcom/adobe/ave/VideoEngineListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mediacore/VideoEngineAdapter;


# direct methods
.method constructor <init>(Lcom/adobe/mediacore/VideoEngineAdapter;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-direct {p0}, Lcom/adobe/ave/VideoEngineListener;-><init>()V

    return-void
.end method

.method private getTimestamp(J)J
    .locals 9

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$900(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->update()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$900(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->getTime()J

    move-result-wide v0

    const-wide/32 v2, 0xf4240

    div-long v2, p1, v2

    sub-long v4, v2, v0

    invoke-static {v4, v5}, Ljava/lang/Math;->abs(J)J

    move-result-wide v4

    const-wide/16 v6, 0x3e8

    cmp-long v4, v4, v6

    if-ltz v4, :cond_0

    :goto_0
    return-wide v0

    :cond_0
    move-wide v0, v2

    goto :goto_0
.end method


# virtual methods
.method public onBackgroundManifestError(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/MediaErrorCode;Ljava/lang/String;)V
    .locals 5

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v0

    if-eq p1, v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$100()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onBackgroundManifestError"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "[Error] >> "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " - "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->BACKGROUND_MANIFEST_WARNING:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    const-string v1, "Native error received in background manifest."

    invoke-static {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification;->createWarningNotification(Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Warning;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v1}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v2, "BACKGROUND_MANIFEST_WARNING_CODE"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p2}, Lcom/adobe/ave/MediaErrorCode;->getValue()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v2, "BACKGROUND_MANIFEST_WARNING_NAME"

    invoke-virtual {p2}, Lcom/adobe/ave/MediaErrorCode;->name()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v2, "DESCRIPTION"

    invoke-interface {v1, v2, p3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification$Warning;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v1

    invoke-static {v0}, Lcom/adobe/mediacore/OperationFailedEvent;->createEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Warning;)Lcom/adobe/mediacore/OperationFailedEvent;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_0
.end method

.method public onBackgroundManifestWarning(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/MediaErrorCode;Ljava/lang/String;)V
    .locals 5

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v0

    if-eq p1, v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    sget-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->BACKGROUND_MANIFEST_WARNING:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    const-string v1, "Native warning received in background manifest."

    invoke-static {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification;->createWarningNotification(Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Warning;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v1}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v2, "BACKGROUND_MANIFEST_WARNING_CODE"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p2}, Lcom/adobe/ave/MediaErrorCode;->getValue()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v2, "BACKGROUND_MANIFEST_WARNING_NAME"

    invoke-virtual {p2}, Lcom/adobe/ave/MediaErrorCode;->name()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v2, "DESCRIPTION"

    invoke-interface {v1, v2, p3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification$Warning;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v1

    invoke-static {v0}, Lcom/adobe/mediacore/OperationFailedEvent;->createEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Warning;)Lcom/adobe/mediacore/OperationFailedEvent;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    sget-object v0, Lcom/adobe/ave/MediaErrorCode;->CANNOT_LOAD_PLAYLIST:Lcom/adobe/ave/MediaErrorCode;

    if-ne p2, v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    invoke-static {}, Lcom/adobe/mediacore/BlackoutEvent;->createBlackoutEvent()Lcom/adobe/mediacore/BlackoutEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_0
.end method

.method public onDRMError(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/drm/DRMError;)V
    .locals 6

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v0

    if-eq p1, v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    sget-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->NATIVE_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "Native error received."

    invoke-static {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v1}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v2, "NATIVE_ERROR_CODE"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p2}, Lcom/adobe/ave/drm/DRMError;->getMajorError()J

    move-result-wide v4

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v2, "DESCRIPTION"

    const-string v3, ""

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v2, "NATIVE_SUBERROR_CODE"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p2}, Lcom/adobe/ave/drm/DRMError;->getMinorError()J

    move-result-wide v4

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v2, "DRM_ERROR_STRING"

    invoke-virtual {p2}, Lcom/adobe/ave/drm/DRMError;->getServerErrorString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v1

    invoke-static {v0}, Lcom/adobe/mediacore/ErrorEvent;->createVideoErrorEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Lcom/adobe/mediacore/ErrorEvent;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_0
.end method

.method public onDRMMetadata(Lcom/adobe/ave/VideoEngine;[BIJ)V
    .locals 8

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v0

    if-eq p1, v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    const/4 v1, 0x1

    # setter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_isProtected:Z
    invoke-static {v0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1902(Lcom/adobe/mediacore/VideoEngineAdapter;Z)Z

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$100()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onDRMMetadata"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "DRM metadata event received for time ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p4, p5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v6, 0x0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$900(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$900(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->getPlaybackRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$900(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->getPlaybackRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    invoke-virtual {v0, p4, p5}, Lcom/adobe/mediacore/utils/TimeRange;->contains(J)Z

    move-result v6

    :cond_2
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getDRMManager()Lcom/adobe/ave/drm/DRMManager;

    move-result-object v1

    move-object v2, p2

    move v3, p3

    move-wide v4, p4

    invoke-static/range {v1 .. v6}, Lcom/adobe/mediacore/DRMMetadataInfo;->createDRMMetadataInfo(Lcom/adobe/ave/drm/DRMManager;[BIJZ)Lcom/adobe/mediacore/DRMMetadataInfo;

    move-result-object v0

    if-nez v0, :cond_3

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$100()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onDRMMetadata"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Unable to convert bytes to DRMMetadataInfo."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    :cond_3
    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_drmMetadataCache:Lcom/adobe/mediacore/DRMMetadataCache;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$2000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/DRMMetadataCache;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/DRMMetadataCache;->addDRMMetadata(Lcom/adobe/mediacore/DRMMetadataInfo;)Z

    move-result v1

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v2}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v2

    if-eqz v2, :cond_0

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v1

    invoke-static {v0}, Lcom/adobe/mediacore/DRMMetadataEvent;->createDRMMetadataEvent(Lcom/adobe/mediacore/DRMMetadataInfo;)Lcom/adobe/mediacore/DRMMetadataEvent;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_0
.end method

.method public onData(Lcom/adobe/ave/VideoEngine;JLcom/adobe/ave/DataType;[BI)V
    .locals 8

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v0

    if-eq p1, v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    invoke-direct {p0, p2, p3}, Lcom/adobe/mediacore/VideoEngineAdapter$1;->getTimestamp(J)J

    move-result-wide v0

    invoke-static {p5}, Lcom/adobe/mediacore/metadata/MetadataNode;->fromByteArray([B)Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v2

    if-nez v2, :cond_2

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$100()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onData"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Unable to deserialize data."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$100()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "#onData"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Data event received at time ["

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "] "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v3, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->MARKER_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v3}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/adobe/mediacore/metadata/Metadata;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    :try_start_0
    sget-object v3, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->MARKER_CONTENT_ID_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v3}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    iget-object v3, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v3}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v3

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v3}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v3

    invoke-static {v2, v0, v1}, Lcom/adobe/mediacore/ContentMarkerEvent;->createContentMarkerEvent(IJ)Lcom/adobe/mediacore/ContentMarkerEvent;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    :catch_0
    move-exception v0

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$100()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onData"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Unable to parse content id."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method public onDictionaryData(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/Dictionary;J)V
    .locals 7

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v0

    if-eq p1, v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$100()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onDictionaryData"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Dictionary data event received"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    if-nez p2, :cond_2

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$100()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onDictionaryData"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Dictionary received is null"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # invokes: Lcom/adobe/mediacore/VideoEngineAdapter;->isID3Dictionary(Lcom/adobe/ave/Dictionary;)Z
    invoke-static {v0, p2}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$3400(Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/ave/Dictionary;)Z

    move-result v0

    if-eqz v0, :cond_0

    :try_start_0
    invoke-virtual {p2}, Lcom/adobe/ave/Dictionary;->getCount()I

    move-result v1

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const/4 v0, 0x0

    :goto_1
    if-ge v0, v1, :cond_6

    invoke-virtual {p2, v0}, Lcom/adobe/ave/Dictionary;->getKeyByIndex(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/adobe/mediacore/utils/StringUtils;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_3

    const-string v4, "_dictionaryType"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4

    :cond_3
    :goto_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_4
    invoke-virtual {p2, v3}, Lcom/adobe/ave/Dictionary;->getValueByKey(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/adobe/mediacore/utils/StringUtils;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_5

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    :cond_5
    invoke-virtual {p2, v3}, Lcom/adobe/ave/Dictionary;->getByteArrayByKey(Ljava/lang/String;)[B

    move-result-object v4

    array-length v5, v4

    if-lez v5, :cond_3

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setByteArray(Ljava/lang/String;[B)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_2

    :catch_0
    move-exception v0

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$100()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#onDictionaryData"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Video engine exception raised while accesing the dictionary"

    invoke-interface {v1, v2, v3, v0}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    goto/16 :goto_0

    :cond_6
    :try_start_1
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    invoke-static {v2, p3, p4}, Lcom/adobe/mediacore/TimedMetadataAddedEvent;->createAddedID3Event(Lcom/adobe/mediacore/metadata/Metadata;J)Lcom/adobe/mediacore/TimedMetadataAddedEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V
    :try_end_1
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0
.end method

.method public onError(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/MediaErrorCode;Ljava/lang/String;)V
    .locals 5

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v0

    if-eq p1, v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    invoke-virtual {p2}, Lcom/adobe/ave/MediaErrorCode;->getValue()I

    move-result v0

    sget-object v1, Lcom/adobe/ave/MediaErrorCode;->AAXS_InvalidVoucher:Lcom/adobe/ave/MediaErrorCode;

    invoke-virtual {v1}, Lcom/adobe/ave/MediaErrorCode;->getValue()I

    move-result v1

    if-gt v0, v1, :cond_0

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$100()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onError"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "[Error] >> "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " - "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->NATIVE_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "Native error received."

    invoke-static {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v1}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v2, "NATIVE_ERROR_CODE"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p2}, Lcom/adobe/ave/MediaErrorCode;->getValue()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v2, "NATIVE_ERROR_NAME"

    invoke-virtual {p2}, Lcom/adobe/ave/MediaErrorCode;->name()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v2, "DESCRIPTION"

    invoke-interface {v1, v2, p3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    # invokes: Lcom/adobe/mediacore/VideoEngineAdapter;->createLoadInformationFrom(Ljava/lang/String;)Lcom/adobe/mediacore/qos/LoadInfo;
    invoke-static {p3}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$300(Ljava/lang/String;)Lcom/adobe/mediacore/qos/LoadInfo;

    move-result-object v1

    if-eqz v1, :cond_3

    invoke-virtual {v1}, Lcom/adobe/mediacore/qos/LoadInfo;->getType()Lcom/adobe/mediacore/qos/LoadInfo$Type;

    move-result-object v2

    sget-object v3, Lcom/adobe/mediacore/qos/LoadInfo$Type;->MANIFEST:Lcom/adobe/mediacore/qos/LoadInfo$Type;

    if-ne v2, v3, :cond_3

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # invokes: Lcom/adobe/mediacore/VideoEngineAdapter;->getFileLoadErrorNotification(Lcom/adobe/mediacore/qos/LoadInfo;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;
    invoke-static {v2, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$400(Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/mediacore/qos/LoadInfo;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setInnerNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V

    :cond_2
    :goto_1
    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v1

    invoke-static {v0}, Lcom/adobe/mediacore/ErrorEvent;->createVideoErrorEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Lcom/adobe/mediacore/ErrorEvent;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_0

    :cond_3
    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # invokes: Lcom/adobe/mediacore/VideoEngineAdapter;->handleAudioTrackError(Lcom/adobe/mediacore/qos/LoadInfo;)Z
    invoke-static {v2, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$500(Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/mediacore/qos/LoadInfo;)Z

    move-result v2

    if-nez v2, :cond_0

    if-eqz v1, :cond_2

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$100()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#onError"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Unexpected event. Fragment error received as error instead of warning."

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public onLoadInfo(Lcom/adobe/ave/VideoEngine;Ljava/lang/String;)V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v0

    if-eq p1, v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$100()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onLoadInfo"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Description: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    # invokes: Lcom/adobe/mediacore/VideoEngineAdapter;->createLoadInformationFrom(Ljava/lang/String;)Lcom/adobe/mediacore/qos/LoadInfo;
    invoke-static {p2}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$300(Ljava/lang/String;)Lcom/adobe/mediacore/qos/LoadInfo;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v1

    if-eqz v1, :cond_0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/LoadInfo;->getType()Lcom/adobe/mediacore/qos/LoadInfo$Type;

    move-result-object v1

    sget-object v2, Lcom/adobe/mediacore/qos/LoadInfo$Type;->FRAGMENT:Lcom/adobe/mediacore/qos/LoadInfo$Type;

    if-ne v1, v2, :cond_0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v1

    invoke-static {v0}, Lcom/adobe/mediacore/LoadInfoEvent;->createLoadInfoEvent(Lcom/adobe/mediacore/qos/LoadInfo;)Lcom/adobe/mediacore/LoadInfoEvent;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_0
.end method

.method public onManifestLoad(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/MediaErrorCode;IIJ)V
    .locals 5

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v0

    if-eq p1, v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$100()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onManifestLoad"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Manifest load event received with code "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p2}, Lcom/adobe/ave/MediaErrorCode;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " for content "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/adobe/ave/MediaErrorCode;->SUCCESS:Lcom/adobe/ave/MediaErrorCode;

    if-ne p2, v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    invoke-static {p3, p4, p5, p6}, Lcom/adobe/mediacore/AdManifestLoadEvent;->createAdManifestLoadCompletedEvent(IIJ)Lcom/adobe/mediacore/AdManifestLoadEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    invoke-static {p3}, Lcom/adobe/mediacore/AdManifestLoadEvent;->createAdManifestLoadFailedEvent(I)Lcom/adobe/mediacore/AdManifestLoadEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_0
.end method

.method public onPlayState(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/PlayState;)V
    .locals 7

    const/4 v6, 0x1

    const/4 v5, -0x1

    const/4 v4, 0x0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v0

    if-eq p1, v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$100()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onPlayState"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "PlayState event: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # setter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_playerState:Lcom/adobe/ave/PlayState;
    invoke-static {v0, p2}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$802(Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/ave/PlayState;)Lcom/adobe/ave/PlayState;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/adobe/mediacore/VideoEngineAdapter$2;->$SwitchMap$com$adobe$ave$PlayState:[I

    invoke-virtual {p2}, Lcom/adobe/ave/PlayState;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    goto :goto_0

    :pswitch_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$900(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->update()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ITEM_READY:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_0

    :pswitch_1
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$900(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->update()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerState;->COMPLETE:Lcom/adobe/mediacore/MediaPlayerState;

    invoke-static {v1, v4}, Lcom/adobe/mediacore/VideoStateChangedEvent;->createChangedEvent(Lcom/adobe/mediacore/MediaPlayerState;Lcom/adobe/mediacore/MediaPlayerNotification;)Lcom/adobe/mediacore/VideoStateChangedEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_0

    :pswitch_2
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$900(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->update()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # setter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_isBuffering:Z
    invoke-static {v0, v6}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1002(Lcom/adobe/mediacore/VideoEngineAdapter;Z)Z

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredBufferControlParameters:Lcom/adobe/mediacore/BufferControlParameters;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1100(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/BufferControlParameters;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/BufferControlParameters;->getInitialBufferTime()J

    move-result-wide v2

    # invokes: Lcom/adobe/mediacore/VideoEngineAdapter;->setBufferTime(J)V
    invoke-static {v0, v2, v3}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1200(Lcom/adobe/mediacore/VideoEngineAdapter;J)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # setter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_isTempBuffer:Z
    invoke-static {v0, v6}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1302(Lcom/adobe/mediacore/VideoEngineAdapter;Z)Z

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->BUFFERING_STARTED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_0

    :pswitch_3
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->BUFFERING_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_0

    :pswitch_4
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # invokes: Lcom/adobe/mediacore/VideoEngineAdapter;->checkAndDispatchBufferingComplete()V
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1400(Lcom/adobe/mediacore/VideoEngineAdapter;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$900(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->update()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerState;->PLAY:Lcom/adobe/mediacore/MediaPlayerState;

    invoke-static {v1, v4}, Lcom/adobe/mediacore/VideoStateChangedEvent;->createChangedEvent(Lcom/adobe/mediacore/MediaPlayerState;Lcom/adobe/mediacore/MediaPlayerNotification;)Lcom/adobe/mediacore/VideoStateChangedEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_lastKnownContentId:I
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1500(Lcom/adobe/mediacore/VideoEngineAdapter;)I

    move-result v0

    if-ne v0, v5, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$900(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->getTime()J

    move-result-wide v0

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # invokes: Lcom/adobe/mediacore/VideoEngineAdapter;->getContentIdByTime(J)I
    invoke-static {v2, v0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1600(Lcom/adobe/mediacore/VideoEngineAdapter;J)I

    move-result v2

    if-eq v2, v5, :cond_0

    iget-object v3, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;
    invoke-static {v3}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1700(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineTimeline;

    move-result-object v3

    invoke-virtual {v3, v0, v1}, Lcom/adobe/mediacore/VideoEngineTimeline;->containsMarkerForTime(J)Z

    move-result v3

    if-eqz v3, :cond_2

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;
    invoke-static {v2}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1700(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineTimeline;

    move-result-object v2

    invoke-virtual {v2, v0, v1}, Lcom/adobe/mediacore/VideoEngineTimeline;->updateTimelineMarkers(J)V

    goto/16 :goto_0

    :cond_2
    iget-object v3, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # setter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_lastKnownContentId:I
    invoke-static {v3, v2}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1502(Lcom/adobe/mediacore/VideoEngineAdapter;I)I

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$100()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#onPlayState"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Detected period-change at time ["

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-static {v0, v1}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "]."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v2}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v2

    iget-object v3, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_lastKnownContentId:I
    invoke-static {v3}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1500(Lcom/adobe/mediacore/VideoEngineAdapter;)I

    move-result v3

    invoke-static {v3, v0, v1}, Lcom/adobe/mediacore/ContentChangedEvent;->createChangeEvent(IJ)Lcom/adobe/mediacore/ContentChangedEvent;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_0

    :pswitch_5
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # invokes: Lcom/adobe/mediacore/VideoEngineAdapter;->checkAndDispatchBufferingComplete()V
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1400(Lcom/adobe/mediacore/VideoEngineAdapter;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerState;->PAUSE:Lcom/adobe/mediacore/MediaPlayerState;

    invoke-static {v1, v4}, Lcom/adobe/mediacore/VideoStateChangedEvent;->createChangedEvent(Lcom/adobe/mediacore/MediaPlayerState;Lcom/adobe/mediacore/MediaPlayerNotification;)Lcom/adobe/mediacore/VideoStateChangedEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_0

    :pswitch_6
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerState;->SUSPENDED:Lcom/adobe/mediacore/MediaPlayerState;

    invoke-static {v1, v4}, Lcom/adobe/mediacore/VideoStateChangedEvent;->createChangedEvent(Lcom/adobe/mediacore/MediaPlayerState;Lcom/adobe/mediacore/MediaPlayerNotification;)Lcom/adobe/mediacore/VideoStateChangedEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
    .end packed-switch
.end method

.method public onSeekComplete(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/MediaErrorCode;)V
    .locals 6

    const/4 v4, 0x0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v0

    if-eq p1, v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$100()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onSeekComplete"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Seek complete event received."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    const/4 v1, 0x1

    # setter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_isInitialised:Z
    invoke-static {v0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$3002(Lcom/adobe/mediacore/VideoEngineAdapter;Z)Z

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$900(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->update()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_isBuffering:Z
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1000(Lcom/adobe/mediacore/VideoEngineAdapter;)Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # setter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_isBuffering:Z
    invoke-static {v0, v4}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1002(Lcom/adobe/mediacore/VideoEngineAdapter;Z)Z

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->BUFFERING_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :cond_2
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # setter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_isSeeking:Z
    invoke-static {v0, v4}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$3102(Lcom/adobe/mediacore/VideoEngineAdapter;Z)Z

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # invokes: Lcom/adobe/mediacore/VideoEngineAdapter;->checkAndDispatchBufferingComplete()V
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1400(Lcom/adobe/mediacore/VideoEngineAdapter;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_isTempBuffer:Z
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1300(Lcom/adobe/mediacore/VideoEngineAdapter;)Z

    move-result v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredBufferControlParameters:Lcom/adobe/mediacore/BufferControlParameters;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1100(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/BufferControlParameters;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/BufferControlParameters;->getPlayBufferTime()J

    move-result-wide v2

    # invokes: Lcom/adobe/mediacore/VideoEngineAdapter;->setBufferTime(J)V
    invoke-static {v0, v2, v3}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1200(Lcom/adobe/mediacore/VideoEngineAdapter;J)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # setter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_isTempBuffer:Z
    invoke-static {v0, v4}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1302(Lcom/adobe/mediacore/VideoEngineAdapter;Z)Z

    :cond_3
    sget-object v0, Lcom/adobe/ave/MediaErrorCode;->SUCCESS:Lcom/adobe/ave/MediaErrorCode;

    if-ne p2, v0, :cond_5

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredSeekPositon:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$3200(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v0

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredSeekPositon:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    invoke-static {v2}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$3200(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getPeriod()I

    move-result v2

    const/4 v3, -0x1

    if-eq v2, v3, :cond_4

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredSeekPositon:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$3200(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v1

    # invokes: Lcom/adobe/mediacore/VideoEngineAdapter;->calculateVirtualTime(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;)J
    invoke-static {v0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$3300(Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;)J

    move-result-wide v0

    :cond_4
    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v2}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v2}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v2

    invoke-static {v0, v1}, Lcom/adobe/mediacore/SeekEvent;->createSeekCompleted(J)Lcom/adobe/mediacore/SeekEvent;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_0

    :cond_5
    sget-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->SEEK_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "Seeking operation has failed."

    invoke-static {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v1}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v2, "NATIVE_ERROR_CODE"

    invoke-virtual {p2}, Lcom/adobe/ave/MediaErrorCode;->name()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v2, "DESIRED_SEEK_PERIOD"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredSeekPositon:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    invoke-static {v4}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$3200(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v4

    invoke-virtual {v4}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getPeriod()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v2, "DESIRED_SEEK_POSITION"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_desiredSeekPositon:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    invoke-static {v4}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$3200(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v4

    invoke-virtual {v4}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v4

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v1

    invoke-static {v0}, Lcom/adobe/mediacore/ErrorEvent;->createVideoErrorEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Lcom/adobe/mediacore/ErrorEvent;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_0
.end method

.method public onStreamMetadata(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/StreamMetadata;)V
    .locals 5

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v0

    if-eq p1, v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    const/4 v0, 0x0

    if-eqz p2, :cond_2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Width: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p2, Lcom/adobe/ave/StreamMetadata;->outputWidth:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " | "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "Height: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p2, Lcom/adobe/ave/StreamMetadata;->outputHeight:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " | "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "Frame rate: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p2, Lcom/adobe/ave/StreamMetadata;->frameRate:F

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " | "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "Profile: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p2, Lcom/adobe/ave/StreamMetadata;->profile:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " | "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "Level: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p2, Lcom/adobe/ave/StreamMetadata;->level:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :cond_2
    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$100()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#onStreamMetadata"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "StreamMetadata event received - "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v2, v0}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    if-eqz v0, :cond_0

    if-eqz p2, :cond_0

    iget v0, p2, Lcom/adobe/ave/StreamMetadata;->outputWidth:I

    if-eqz v0, :cond_0

    iget v0, p2, Lcom/adobe/ave/StreamMetadata;->outputHeight:I

    if-eqz v0, :cond_0

    iget v0, p2, Lcom/adobe/ave/StreamMetadata;->outputWidth:I

    iget v1, p2, Lcom/adobe/ave/StreamMetadata;->outputHeight:I

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v2}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v2

    invoke-static {v1, v0}, Lcom/adobe/mediacore/VideoSizeChangedEvent;->createChangedEvent(II)Lcom/adobe/mediacore/VideoSizeChangedEvent;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_0
.end method

.method public onStreamSwitch(Lcom/adobe/ave/VideoEngine;JLcom/adobe/ave/SwitchInfo;II)V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v0

    if-eq p1, v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$100()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onStreamSwitch"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Switch detected at time ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p2, p3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_lastKnownContentId:I
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1500(Lcom/adobe/mediacore/VideoEngineAdapter;)I

    move-result v0

    if-eq v0, p6, :cond_3

    const/4 v0, 0x1

    :goto_1
    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v1

    if-eqz v1, :cond_2

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1700(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineTimeline;

    move-result-object v0

    invoke-virtual {v0, p2, p3}, Lcom/adobe/mediacore/VideoEngineTimeline;->containsMarkerForTime(J)Z

    move-result v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1700(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineTimeline;

    move-result-object v0

    invoke-virtual {v0, p2, p3}, Lcom/adobe/mediacore/VideoEngineTimeline;->updateTimelineMarkers(J)V

    :cond_2
    :goto_2
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_lastKnownProfile:J
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1800(Lcom/adobe/mediacore/VideoEngineAdapter;)J

    move-result-wide v0

    int-to-long v2, p5

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$100()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onStreamSwitch"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Detected bit rate change ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " at time ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p2, p3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    int-to-long v2, p5

    # setter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_lastKnownProfile:J
    invoke-static {v0, v2, v3}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1802(Lcom/adobe/mediacore/VideoEngineAdapter;J)J

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_lastKnownProfile:J
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1800(Lcom/adobe/mediacore/VideoEngineAdapter;)J

    move-result-wide v2

    invoke-static {v2, v3, p2, p3}, Lcom/adobe/mediacore/ProfileChangedEvent;->createProfileChangeEvent(JJ)Lcom/adobe/mediacore/ProfileChangedEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_0

    :cond_3
    const/4 v0, 0x0

    goto/16 :goto_1

    :cond_4
    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$100()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onStreamSwitch"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Detected period change contentId ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "] at time ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p2, p3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # setter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_lastKnownContentId:I
    invoke-static {v0, p6}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1502(Lcom/adobe/mediacore/VideoEngineAdapter;I)I

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_lastKnownContentId:I
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1500(Lcom/adobe/mediacore/VideoEngineAdapter;)I

    move-result v1

    invoke-static {v1, p2, p3}, Lcom/adobe/mediacore/ContentChangedEvent;->createChangeEvent(IJ)Lcom/adobe/mediacore/ContentChangedEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_2
.end method

.method public onTimeline(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/UpdateType;)V
    .locals 8

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v0

    if-eq p1, v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$100()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onTimeline"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Timeline event received. Update type: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # invokes: Lcom/adobe/mediacore/VideoEngineAdapter;->isAveTimelineValid()Z
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$2100(Lcom/adobe/mediacore/VideoEngineAdapter;)Z

    move-result v0

    if-nez v0, :cond_2

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$100()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onTimeline"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "AVE timeline is invalid. Ignoring event."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    sget-object v0, Lcom/adobe/mediacore/VideoEngineAdapter$2;->$SwitchMap$com$adobe$ave$UpdateType:[I

    invoke-virtual {p2}, Lcom/adobe/ave/UpdateType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    goto :goto_0

    :pswitch_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    const/4 v1, 0x0

    # setter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_alreadyReleased:Z
    invoke-static {v0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$2202(Lcom/adobe/mediacore/VideoEngineAdapter;Z)Z

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$900(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->update()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->RESOURCE_LOADED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :cond_3
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineDispatcher;->createNotificationHistory()V

    iget-object v6, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    new-instance v0, Lcom/adobe/mediacore/VideoEngineItem;

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_mediaResource:Lcom/adobe/mediacore/MediaResource;
    invoke-static {v2}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$2400(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/MediaResource;

    move-result-object v2

    iget-object v3, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_contentId:I
    invoke-static {v3}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$2500(Lcom/adobe/mediacore/VideoEngineAdapter;)I

    move-result v3

    iget-object v4, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_drmMetadataCache:Lcom/adobe/mediacore/DRMMetadataCache;
    invoke-static {v4}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$2000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/DRMMetadataCache;

    move-result-object v4

    iget-object v5, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_adTags:Ljava/util/List;
    invoke-static {v5}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$2600(Lcom/adobe/mediacore/VideoEngineAdapter;)Ljava/util/List;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Lcom/adobe/mediacore/VideoEngineItem;-><init>(Lcom/adobe/mediacore/VideoEngineDispatcher;Lcom/adobe/mediacore/MediaResource;ILcom/adobe/mediacore/DRMMetadataCache;Ljava/util/List;)V

    # setter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineItem:Lcom/adobe/mediacore/VideoEngineItem;
    invoke-static {v6, v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$2302(Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/mediacore/VideoEngineItem;)Lcom/adobe/mediacore/VideoEngineItem;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineItem:Lcom/adobe/mediacore/VideoEngineItem;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$2300(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineItem;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineItem;->update(Lcom/adobe/ave/VideoEngine;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineItem:Lcom/adobe/mediacore/VideoEngineItem;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$2300(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineItem;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_isProtected:Z
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1900(Lcom/adobe/mediacore/VideoEngineAdapter;)Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineItem;->setIsProtected(Z)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_backgroundMediaResource:Lcom/adobe/mediacore/MediaResource;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$2700(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/MediaResource;

    move-result-object v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    new-instance v1, Lcom/adobe/mediacore/BackgroundVideoEngineItem;

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v2}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v2

    iget-object v3, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_backgroundMediaResource:Lcom/adobe/mediacore/MediaResource;
    invoke-static {v3}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$2700(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/MediaResource;

    move-result-object v3

    iget-object v4, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_drmMetadataCache:Lcom/adobe/mediacore/DRMMetadataCache;
    invoke-static {v4}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$2000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/DRMMetadataCache;

    move-result-object v4

    iget-object v5, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_adTags:Ljava/util/List;
    invoke-static {v5}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$2600(Lcom/adobe/mediacore/VideoEngineAdapter;)Ljava/util/List;

    move-result-object v5

    invoke-direct {v1, v2, v3, v4, v5}, Lcom/adobe/mediacore/BackgroundVideoEngineItem;-><init>(Lcom/adobe/mediacore/VideoEngineDispatcher;Lcom/adobe/mediacore/MediaResource;Lcom/adobe/mediacore/DRMMetadataCache;Ljava/util/List;)V

    # setter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_backgroundVideoEngineItem:Lcom/adobe/mediacore/BackgroundVideoEngineItem;
    invoke-static {v0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$2802(Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/mediacore/BackgroundVideoEngineItem;)Lcom/adobe/mediacore/BackgroundVideoEngineItem;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_backgroundVideoEngineItem:Lcom/adobe/mediacore/BackgroundVideoEngineItem;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$2800(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/BackgroundVideoEngineItem;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->update(Lcom/adobe/ave/VideoEngine;)V

    :cond_4
    iget-object v6, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    new-instance v0, Lcom/adobe/mediacore/VideoEngineTimeline;

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    iget-object v3, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_mediaResource:Lcom/adobe/mediacore/MediaResource;
    invoke-static {v3}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$2400(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/MediaResource;

    move-result-object v3

    iget-object v4, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_contentId:I
    invoke-static {v4}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$2500(Lcom/adobe/mediacore/VideoEngineAdapter;)I

    move-result v4

    iget-object v5, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    iget-object v7, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_mediaResource:Lcom/adobe/mediacore/MediaResource;
    invoke-static {v7}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$2400(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/MediaResource;

    move-result-object v7

    invoke-virtual {v7}, Lcom/adobe/mediacore/MediaResource;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v7

    # invokes: Lcom/adobe/mediacore/VideoEngineAdapter;->shouldUseContentCache(Lcom/adobe/mediacore/metadata/Metadata;)Z
    invoke-static {v5, v7}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$2900(Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/mediacore/metadata/Metadata;)Z

    move-result v5

    invoke-direct/range {v0 .. v5}, Lcom/adobe/mediacore/VideoEngineTimeline;-><init>(Lcom/adobe/mediacore/VideoEngineDispatcher;Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/mediacore/MediaResource;IZ)V

    # setter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;
    invoke-static {v6, v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1702(Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/mediacore/VideoEngineTimeline;)Lcom/adobe/mediacore/VideoEngineTimeline;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ITEM_CREATED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_0

    :pswitch_1
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$900(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->update()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineItem:Lcom/adobe/mediacore/VideoEngineItem;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$2300(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineItem;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineItem;->update(Lcom/adobe/ave/VideoEngine;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$1700(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineTimeline;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$900(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->getTime()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/adobe/mediacore/VideoEngineTimeline;->update(J)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ITEM_UPDATED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_0

    :pswitch_2
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineItem:Lcom/adobe/mediacore/VideoEngineItem;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$2300(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineItem;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineItem;->refreshClosedCaptionsTracks(Lcom/adobe/ave/VideoEngine;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ITEM_UPDATED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_0

    :pswitch_3
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_backgroundVideoEngineItem:Lcom/adobe/mediacore/BackgroundVideoEngineItem;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$2800(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/BackgroundVideoEngineItem;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_backgroundVideoEngineItem:Lcom/adobe/mediacore/BackgroundVideoEngineItem;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$2800(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/BackgroundVideoEngineItem;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/BackgroundVideoEngineItem;->update(Lcom/adobe/ave/VideoEngine;)V

    goto/16 :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public onWarning(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/MediaErrorCode;Ljava/lang/String;)V
    .locals 6

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$000(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/ave/VideoEngine;

    move-result-object v0

    if-eq p1, v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$100()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onWarning"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "[Warning] >> "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " - "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcom/adobe/ave/MediaErrorCode;->PERIOD_HOLD:Lcom/adobe/ave/MediaErrorCode;

    if-ne p2, v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_timelineProxy:Lcom/adobe/mediacore/VideoEngineTimelineProxy;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$700(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineTimelineProxy;

    move-result-object v0

    if-eqz v0, :cond_2

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$200()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$100()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Current hold position is: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_timelineProxy:Lcom/adobe/mediacore/VideoEngineTimelineProxy;
    invoke-static {v3}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$700(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineTimelineProxy;

    move-result-object v3

    invoke-virtual {v3}, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->getCurrentHoldTime()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ". Current time is: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v3}, Lcom/adobe/mediacore/VideoEngineAdapter;->getCurrentTime()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;)V

    :cond_2
    sget-object v0, Lcom/adobe/ave/MediaErrorCode;->LIVE_HOLD:Lcom/adobe/ave/MediaErrorCode;

    if-eq p2, v0, :cond_0

    sget-object v0, Lcom/adobe/ave/MediaErrorCode;->RENDITION_M3U8_ERROR:Lcom/adobe/ave/MediaErrorCode;

    if-eq p2, v0, :cond_3

    sget-object v0, Lcom/adobe/ave/MediaErrorCode;->FILE_NOT_FOUND:Lcom/adobe/ave/MediaErrorCode;

    if-eq p2, v0, :cond_3

    sget-object v0, Lcom/adobe/ave/MediaErrorCode;->SEGMENT_SKIPPED_ON_FAILURE:Lcom/adobe/ave/MediaErrorCode;

    if-ne p2, v0, :cond_4

    :cond_3
    # invokes: Lcom/adobe/mediacore/VideoEngineAdapter;->createLoadInformationFrom(Ljava/lang/String;)Lcom/adobe/mediacore/qos/LoadInfo;
    invoke-static {p3}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$300(Ljava/lang/String;)Lcom/adobe/mediacore/qos/LoadInfo;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # invokes: Lcom/adobe/mediacore/VideoEngineAdapter;->handleAudioTrackError(Lcom/adobe/mediacore/qos/LoadInfo;)Z
    invoke-static {v1, v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$500(Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/mediacore/qos/LoadInfo;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # invokes: Lcom/adobe/mediacore/VideoEngineAdapter;->getFileLoadErrorNotification(Lcom/adobe/mediacore/qos/LoadInfo;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;
    invoke-static {v1, v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$400(Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/mediacore/qos/LoadInfo;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v1

    if-eqz v1, :cond_4

    if-eqz v0, :cond_4

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v1

    invoke-static {v0}, Lcom/adobe/mediacore/ErrorEvent;->createVideoErrorEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Lcom/adobe/mediacore/ErrorEvent;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_0

    :cond_4
    sget-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->NATIVE_WARNING:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    const-string v1, "Native warning received."

    invoke-static {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification;->createWarningNotification(Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Warning;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v1}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v2, "NATIVE_ERROR_CODE"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p2}, Lcom/adobe/ave/MediaErrorCode;->getValue()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v2, "NATIVE_ERROR_NAME"

    invoke-virtual {p2}, Lcom/adobe/ave/MediaErrorCode;->name()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v2, "DESCRIPTION"

    invoke-interface {v1, v2, p3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification$Warning;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineAdapter$1;->this$0:Lcom/adobe/mediacore/VideoEngineAdapter;

    # getter for: Lcom/adobe/mediacore/VideoEngineAdapter;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->access$600(Lcom/adobe/mediacore/VideoEngineAdapter;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v1

    invoke-static {v0}, Lcom/adobe/mediacore/OperationFailedEvent;->createEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Warning;)Lcom/adobe/mediacore/OperationFailedEvent;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_0
.end method
